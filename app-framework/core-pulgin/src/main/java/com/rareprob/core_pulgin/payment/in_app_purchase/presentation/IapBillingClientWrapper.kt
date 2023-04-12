package com.rareprob.core_pulgin.payment.in_app_purchase.presentation

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.android.billingclient.api.*
import com.rareprob.core_pulgin.core.base.CoreDatabase
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData
import com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class IapBillingClientWrapper(
    private val context: Context,
   private val  coreDatabase: CoreDatabase
) : PurchasesUpdatedListener, ProductDetailsResponseListener {

    private val TAG = "BillingClient"

    // New Subscription ProductDetails
    private val _productWithProductDetails =
        MutableStateFlow<Map<String, ProductDetails>>(emptyMap())
    val productWithProductDetails =
        _productWithProductDetails.asStateFlow()

    private val _purchasesDetailNew =
        MutableStateFlow<List<ProductListingData>>(listOf())
    val purchasesDetailNew = _purchasesDetailNew.asStateFlow()


    // Current Purchases
    private val _purchases =
        MutableStateFlow<List<Purchase>>(listOf())
    val purchases = _purchases.asStateFlow()

    // Tracks new purchases acknowledgement state.
    // Set to true when a purchase is acknowledged and false when not.
    private val _isNewPurchaseAcknowledged = MutableStateFlow(value = false)
    val isNewPurchaseAcknowledged = _isNewPurchaseAcknowledged.asStateFlow()

//    private var _purchasedProductItemList =
//    MutableStateFlow<List<InAppProductData>>(listOf())
//    var purchasedProductItemList = _purchasedProductItemList.asStateFlow()

    // Initialize the BillingClient.
    private val billingClient = BillingClient.newBuilder(context)
        .setListener(this)
        .enablePendingPurchases()
        .build()

    private var rcProductItemList: List<ProductListingData> = emptyList()

    // Establish a connection to Google Play.
    fun startBillingConnection(
        billingConnectionState: MutableLiveData<Boolean>,
        rcProductItemList: List<ProductListingData>
    ) {
        this.rcProductItemList = rcProductItemList
        // to get the product type list
        var inAppTypeSkuItemList: ArrayList<String> = ArrayList()
        var subscriptionTypeSkuItemList: ArrayList<String> = ArrayList()
        prepareProductIdsList(rcProductItemList, inAppTypeSkuItemList, subscriptionTypeSkuItemList)

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.d(TAG, "Billing response OK")
                    // The BillingClient is ready. You can query purchases and product details here
                    queryProductDetails(BillingClient.ProductType.SUBS, subscriptionTypeSkuItemList)
                    queryProductDetails(BillingClient.ProductType.INAPP, inAppTypeSkuItemList)
                    billingConnectionState.postValue(true)
                    restorePurchase()
                } else {
                    Log.e(TAG, billingResult.debugMessage)
                }
            }

            override fun onBillingServiceDisconnected() {
                Log.i(TAG, "Billing connection disconnected")
                startBillingConnection(billingConnectionState, emptyList())

            }
        })
    }

    /**
     * Get the product type list.
     * For every product we have product id and pack id for actual price and offer price.
     * For this we main two product id and map it to a original product id
     */
    private fun prepareProductIdsList(
        rcProductItemList: List<ProductListingData>,
        inAppTypeSkuItemList: ArrayList<String>,
        subscriptionTypeSkuItemList: ArrayList<String>
    ) {
        rcProductItemList.onEach { item ->
            if (!TextUtils.isEmpty(item.productID)) {
                if (item.subType.equals("true", true)) {
                    subscriptionTypeSkuItemList.add(item.productID ?: "")
                    subscriptionTypeSkuItemList.add(item.packId ?: "")
                } else {
                    inAppTypeSkuItemList.add(item.productID ?: "")
                    inAppTypeSkuItemList.add(item.packId ?: "")
                }
            }
        }
    }

//    // Query Google Play Billing for existing purchases.
//    // New purchases will be provided to PurchasesUpdatedListener.onPurchasesUpdated().
//    fun queryPurchases() {
//        if (!billingClient.isReady) {
//            Log.e(TAG, "queryPurchases: BillingClient is not ready")
//        }
//        // Query for existing subscription products that have been purchased.
//        billingClient.queryPurchasesAsync(
//            QueryPurchasesParams.newBuilder().setProductType().build()
//        ) { billingResult, purchaseList ->
//            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
//                if (!purchaseList.isNullOrEmpty()) {
//                    _purchases.value = purchaseList
//                } else {
//                    _purchases.value = emptyList()
//                }
//
//            } else {
//                Log.e(TAG, billingResult.debugMessage)
//            }
//        }
//    }

    /**
     * Query Google Play Billing for products available to sell and present them in the UI
     * and Also Query Google Play Billing for existing purchases.
     * New purchases will be provided to PurchasesUpdatedListener.onPurchasesUpdated().
     */
    fun queryProductDetails(@NonNull productType: String, skuList: List<String>) {
        if (skuList.isEmpty())
            return

        val params = QueryProductDetailsParams.newBuilder()
        val productList = mutableListOf<QueryProductDetailsParams.Product>()
        for (productId in skuList) {
            productList.add(
                QueryProductDetailsParams.Product.newBuilder()
                    .setProductId(productId)
                    .setProductType(productType)
                    .build()
            )
        }
        params.setProductList(productList).let { productDetailsParams ->
            Log.i(TAG, "queryProductDetailsAsync")
            billingClient.queryProductDetailsAsync(productDetailsParams.build(), this)
        }
    }

    // [ProductDetailsResponseListener] implementation
    // Listen to response back from [queryProductDetails] and emits the results
    // to [_productWithProductDetails].
    override fun onProductDetailsResponse(
        billingResult: BillingResult,
        productDetailsList: MutableList<ProductDetails>
    ) {
        val responseCode = billingResult.responseCode
        val debugMessage = billingResult.debugMessage

        Log.d(
            "KpRestore", " responseCode " + productDetailsList.toString()
        )

        when (responseCode) {

            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> {
                Log.d(
                    "KpRestore", " ITEM_ALREADY_OWNED " + productDetailsList.toString()
                )
            }

            BillingClient.BillingResponseCode.OK -> {

                var newMap = emptyMap<String, ProductDetails>()
                if (productDetailsList.isNullOrEmpty()) {
                    Log.e(
                        TAG,
                        "onProductDetailsResponse: " +
                                "Found null or empty ProductDetails. " +
                                "Check to see if the Products you requested are correctly " +
                                "published in the Google Play Console."
                    )
                } else {
                    newMap = productDetailsList.associateBy {
                        it.productId
                    }
                }

                //Prepare final In app product list for showing it screen
                for (iapItem in productDetailsList) {
                    for (premiumDataClassItem in rcProductItemList) {
                        var formattedPrice: String =
                            iapItem.oneTimePurchaseOfferDetails?.formattedPrice ?: ""
                        if (iapItem.productId.equals(premiumDataClassItem.packId, true)) {
                            premiumDataClassItem.price =
                                formattedPrice
                            premiumDataClassItem.productDetails = iapItem
                        }
                        if (iapItem.productId.equals(premiumDataClassItem.productID, true)) {
                            premiumDataClassItem.showPrice =
                                formattedPrice
                            premiumDataClassItem.productDetails = iapItem
                        }
                    }
                }

                //    _productWithProductDetails.value = newMap
                _purchasesDetailNew.value = rcProductItemList
            }
            else -> {
                Log.i(TAG, "onProductDetailsResponse: $responseCode $debugMessage")
            }
        }
    }

    // Launch Purchase flow
    fun launchBillingFlow(activity: Activity, params: BillingFlowParams) {
        if (!billingClient.isReady) {
            Log.e(TAG, "launchBillingFlow: BillingClient is not ready")
        }
        billingClient.launchBillingFlow(activity, params)

    }

    // PurchasesUpdatedListener that helps handle new purchases returned from the API
    override fun onPurchasesUpdated(
        billingResult: BillingResult,
        purchases: List<Purchase>?
    ) {

        Log.d(
            "KpRestore", " responseCode " + billingResult.responseCode
        )

        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK
            && !purchases.isNullOrEmpty()
        ) {
            // Post new purchase List to _purchases
            _purchases.value = purchases

            // Then, handle the purchases
            for (purchase in purchases) {
                acknowledgePurchases(purchase)
            }
        } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.
            Log.e(TAG, "User has cancelled")
        } else {
            // Handle any other error codes.
        }
    }

//    private val _acknowledgePurchases =
//        MutableStateFlow<Map<String, Purchase>>(emptyMap())
//    val acknowledgePurchases =
//        _acknowledgePurchases.asStateFlow()

    // Perform new subscription purchases' acknowledgement client side.
    private fun acknowledgePurchases(purchase: Purchase?) {
        purchase?.let {
            if (!it.isAcknowledged) {
                val params = AcknowledgePurchaseParams.newBuilder()
                    .setPurchaseToken(it.purchaseToken)
                    .build()

                billingClient.acknowledgePurchase(
                    params
                ) { billingResult ->
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK &&
                        it.purchaseState == Purchase.PurchaseState.PURCHASED
                    ) {
//                        _acknowledgePurchases.map {
//                        }
                        _isNewPurchaseAcknowledged.value = true

                        saveProductToDb(it)
                    }
                }
            }
        }
    }

    /**
     * Saving product info to db for future restore purpose
     */
    private fun saveProductToDb(purchase: Purchase) {
//rcProductItemList.
//    purchase.
//
//        for(item in purchase.) {
////        }
//
//        var inAppProductData  = InAppProductData(
//            appId = context.packageName,
//            productId = purchase.products.get(0)
//
//        )
//        var productId: String,
//        var productType: String,
//        var productName: String,
//        var active: String
//        CoreDatabase.getCoreDatabase(context)?.inAppPurchaseDao.


    }

    // End Billing connection.
    fun terminateBillingConnection() {
        Log.i(TAG, "Terminating connection")
        billingClient.endConnection()
    }

//    companion object {
//        private const val TAG = "BillingClient"
//
//        // List of subscription product offerings
//        private const val BASIC_SUB = "up_basic_sub"
//        private const val PREMIUM_SUB = "up_premium_sub"
//
//        private val LIST_OF_PRODUCTS = listOf(BASIC_SUB, PREMIUM_SUB)
//
//    }

    /**
     * This function helps in restoring of already purchased items
     */
    private fun restorePurchase() {
//        val params = QueryPurchaseHistoryParams.newBuilder()
//            .setProductType(BillingClient.ProductType.SUBS)

//        productDetailsList
//        for(item in productDetailsList) {
//            val params = QueryPurchaseHistoryParams.newBuilder()
//                .setProductType(item.productType)
//        }
        val subscriptionTypeParams = QueryPurchaseHistoryParams.newBuilder()
            .setProductType(BillingClient.ProductType.SUBS)

        val inAppTypeParams = QueryPurchaseHistoryParams.newBuilder()
            .setProductType(BillingClient.ProductType.INAPP)

//        billingClient.queryPurchaseHistoryAsync(BillingClient.ProductType.SUBS,object:PurchaseHistoryResponseListener{
//            override fun onPurchaseHistoryResponse(
//                p0: BillingResult,
//                p1: MutableList<PurchaseHistoryRecord>?
//            ) {
//            }
//
//        })
//        billingClient.queryPurchaseHistoryAsync(BillingClient.ProductType.INAPP,
//            object : PurchaseHistoryResponseListener {
//                override fun onPurchaseHistoryResponse(
//                    p0: BillingResult,
//                    p1: MutableList<PurchaseHistoryRecord>?
//                ) {
//                    updateProductPurchaseStatus(p1)
//
//                    //inAppPurchaseDao?.insert(inAppPurchaseEntity)
//
//                    // Log.d("p0 INAPP ", "" + p1?.get(0)?.products.toString())
//                    Log.d("p0", "INAPP " + p1?.size)
//
//                    Log.d(
//                        "p0",
//                        "INAPPapplication " + context.packageName + " " + context.applicationContext.packageName
//                    )
//                }
//
//            })

        billingClient.queryPurchaseHistoryAsync(
            inAppTypeParams.build()
        ) { p0, p1 ->

            updateProductPurchaseStatus(p1)

            Log.d("p0", "SUBS " + p1?.size)

//            Log.d("p0", "SUBS " + p1?.get(0)?.products.toString())
//            Log.d("p0", "" + p0)
//            Log.d("p0", "" + p1.get(0).products.

            //val purchaseHistoryResult = billingClient.queryPurchaseHistoryAsync()


        }


        billingClient.queryPurchaseHistoryAsync(
            subscriptionTypeParams.build()
        ) { p0, p1 ->

            updateProductPurchaseStatus(p1)

            Log.d("p0", "SUBS " + p1?.size)

//            Log.d("p0", "SUBS " + p1?.get(0)?.products.toString())
//            Log.d("p0", "" + p0)
//            Log.d("p0", "" + p1.get(0).products.

            //val purchaseHistoryResult = billingClient.queryPurchaseHistoryAsync()


        }
    }

     val _purchasedProductMap =
        MutableStateFlow<Map<String, InAppProductData>>(emptyMap())
//    val purchasedProductMap =
//        _purchasedProductMap.asStateFlow()

    private fun updateProductPurchaseStatus(p1: MutableList<PurchaseHistoryRecord>?){
        val inAppPurchaseDao = coreDatabase?.inAppPurchaseDao
        p1?.let {
            if(it.isEmpty())
                return
            it.forEach { purchaseHistoryRecord ->
                purchaseHistoryRecord.products.forEach {
                    Log.d("kp", "kp" + it.toString())
                    CoroutineScope(Dispatchers.Unconfined).launch{
                        var inAppPurchaseEntity =  inAppPurchaseDao?.getInAppPurchaseById(context.packageName,
                            it.toString())
                        if(inAppPurchaseEntity != null){
                            inAppPurchaseEntity.isPurchased = true
                        }
                        //Update item
                        inAppPurchaseDao?.update(inAppPurchaseEntity ?: InAppPurchaseEntity(appId = context.packageName))
                        Log.d("kp", "kp" + inAppPurchaseEntity.toString())

                        var dbrRsultList =   inAppPurchaseDao?.getInAppPurchases() ?: emptyList()
                        Log.d("fdfd","dfd " + dbrRsultList?.size)

                        var purchasedItemsList = inAppPurchaseDao?.getInAppPurchases()?.map {
                            it.toInAppProductData()
                        } ?: emptyList()

                       // _purchasedProductItemList.value= dbList.map {  }

                        var productMap = emptyMap<String, InAppProductData>()
                        productMap =  purchasedItemsList.associateBy {
                            it.productId
                        }
                        _purchasedProductMap.value = productMap

                    }

//                                inAppPurchaseDao?
//
//                                var list =   inAppPurchaseDao?.getInAppPurchases()
//                                Log.d("fdfd","dfd " + list?.size)

                }
            }

//                        var inAppPurchaseEntity = InAppPurchaseEntity(
//                            appId =  context.applicationContext.packageName,
//                            productId = purchaseHistoryRecord.products. ?: "",
//                            productType = productDataItem.subType ?: "",
//                            productName = productDataItem.packName ?: "",
//                            active = productDataItem.active ?: "",
//                            isPurchased = false
//                        )
        }

    }

}

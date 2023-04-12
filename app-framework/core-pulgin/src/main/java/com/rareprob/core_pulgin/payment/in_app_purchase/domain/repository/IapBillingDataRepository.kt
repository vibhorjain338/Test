package com.rareprob.core_pulgin.payment.in_app_purchase.domain.repository

import android.app.Application
import android.util.Log
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.rareprob.core_pulgin.core.utils.FirebaseRemoteConfigUtils
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData
import com.rareprob.core_pulgin.core.utils.Resource
import com.rareprob.core_pulgin.core.base.CoreDatabase
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData
import com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity
import com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingClientWrapper
import kotlinx.coroutines.flow.*
import java.io.IOException

class IapBillingDataRepository(
    private val application: Application,
    private val billingClientWrapper: IapBillingClientWrapper,
    private val coreDatabase: CoreDatabase
) {
    private val TAG = "SubscriptionDataRepository"

    fun getPurchasedItemsList(): Flow<Resource<List<InAppProductData>>> = flow {
        emit(Resource.Loading())
        val inAppPurchaseDao = coreDatabase.inAppPurchaseDao
        var purchasedItemsList = inAppPurchaseDao.getInAppPurchases().map {
            it.toInAppProductData()
        }
        emit(Resource.Success(purchasedItemsList))
    }


    fun getInAppProducts(): Flow<Resource<List<ProductListingData>>> = flow {

        emit(Resource.Loading())
        try {
            var dataList = FirebaseRemoteConfigUtils.getInAppProducts(
                application
            )
            dataList = dataList?.filter {
                it.active == "true"
            }

            // save Products to Db for future use
            val inAppPurchaseDao = coreDatabase.inAppPurchaseDao
            dataList?.forEach { productDataItem ->
                val dbProduct = inAppPurchaseDao.getInAppPurchaseById(
                    application.packageName,
                    productDataItem.productID ?: ""
                )
                val isPurchased = dbProduct?.isPurchased ?: false
                val inAppPurchaseEntity = InAppPurchaseEntity(
                    appId = application.packageName,
                    productId = productDataItem.productID ?: "",
                    productType = productDataItem.subType ?: "",
                    productName = productDataItem.packName ?: "",
                    active = productDataItem.active ?: "",
                    isPurchased = isPurchased
                )
                inAppPurchaseDao.insert(inAppPurchaseEntity)
                val list = inAppPurchaseDao.getInAppPurchases()
                Log.d("fdfd", "dfd " + list.size)
            }

            emit(Resource.Success(dataList))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    /*message = "Couldn't reach server, check your internet connection."*/
                    message = e.message.toString(),
                    data = listOf()
                )
            )
        }
    }

    // Set to true when a returned purchase is an auto-renewing basic subscription.
    val hasRenewableBasic: Flow<Boolean> = billingClientWrapper.purchases.map { purchaseList ->
        purchaseList.any { purchase ->
            purchase.products.contains(BASIC_SUB) && purchase.isAutoRenewing
        }
    }

    // Set to true when a returned purchase is prepaid basic subscription.
    val hasPrepaidBasic: Flow<Boolean> = billingClientWrapper.purchases.map { purchaseList ->
        purchaseList.any { purchase ->
            !purchase.isAutoRenewing && purchase.products.contains(BASIC_SUB)
        }
    }

    // Set to true when a returned purchases is an auto-renewing premium subscription.
    val hasRenewablePremium: Flow<Boolean> = billingClientWrapper.purchases.map { purchaseList ->
        purchaseList.any { purchase ->
            purchase.products.contains(PREMIUM_SUB) && purchase.isAutoRenewing
        }
    }

    // Set to true when a returned purchase is prepaid premium subscription.
    val hasPrepaidPremium: Flow<Boolean> = billingClientWrapper.purchases.map { purchaseList ->
        purchaseList.any { purchase ->
            !purchase.isAutoRenewing && purchase.products.contains(PREMIUM_SUB)
        }
    }

    // ProductDetails for the basic subscription.
    val basicProductDetails: Flow<ProductDetails> =
        billingClientWrapper.productWithProductDetails.filter {
            it.containsKey(
                BASIC_SUB
            )
        }.map { it[BASIC_SUB]!! }

    // ProductDetails for the premium subscription.
    val premiumProductDetails: Flow<ProductDetails> =
        billingClientWrapper.productWithProductDetails.filter {
            it.containsKey(
                PREMIUM_SUB
            )
        }.map { it[PREMIUM_SUB]!! }

    // List of current purchases returned by the Google PLay Billing client library.
    val purchases: Flow<List<Purchase>> = billingClientWrapper.purchases

    // Set to true when a purchase is acknowledged.
    val isNewPurchaseAcknowledged: Flow<Boolean> = billingClientWrapper.isNewPurchaseAcknowledged

    companion object {
        // List of subscription product offerings
        private const val BASIC_SUB = "up_basic_sub"
        private const val PREMIUM_SUB = "up_premium_sub"
    }
}

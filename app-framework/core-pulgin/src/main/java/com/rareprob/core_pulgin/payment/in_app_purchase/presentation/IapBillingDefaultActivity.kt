package com.rareprob.core_pulgin.payment.in_app_purchase.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rareprob.core_pulgin.R
import com.rareprob.core_pulgin.core.utils.FirebaseRemoteConfigUtils
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class IapBillingDefaultActivity : AppCompatActivity(), IapBillingAdapter.OnItemClickListener {
    @Parcelize
    data class Params(
        val id: Long = 0,
    ) : Parcelable

    companion object {
        private const val PARAMS = "params"
        fun launch(context: Context, params: Params = Params()) {
            context.startActivity(getLaunchIntent(context, params))
        }

        private fun getLaunchIntent(context: Context, params: Params): Intent {
            return Intent(context, IapBillingDefaultActivity::class.java).apply {
                this.putExtra(PARAMS, params)
                this.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
        }
    }


    private var dataItemsList = ArrayList<ProductListingData>()
    private lateinit var iapBillingAdapter: IapBillingAdapter
    private val viewModel: IapBillingViewModel by viewModels()
    private var productDataList: List<ProductListingData> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        setupDataList()
    }

    private fun initUi() {
        setContentView(R.layout.activity_iap_default_product_listing)
        val recyclerView: RecyclerView = findViewById(R.id.pack_recyclerview)
        iapBillingAdapter = IapBillingAdapter(this@IapBillingDefaultActivity,this, dataItemsList)
        iapBillingAdapter.updateCheck(0)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = iapBillingAdapter

        var background = findViewById<LinearLayout>(R.id.background)
        val userSubscription = FirebaseRemoteConfigUtils.getPremiumBg(this)
        if(userSubscription == 2L) {
            background?.setBackgroundResource(R.drawable.premium_screen_bg)
        } else {
            background?.setBackgroundResource(R.drawable.premium_screen_bg_2)
        }

    }


    private fun setupDataList() {
//        lifecycleScope.launch{
        viewModel.getInAppPacksFromRc()

        lifecycleScope.launch() {

            withContext(Dispatchers.Main) {
                viewModel.productsForSaleFlows.collect {
                    productDataList = it
                }

                //Get Already owned products
                viewModel.getPurchasedItemsList()
            }
        }
        lifecycleScope.launch() {

            viewModel.isNewPurchaseAcknowledged.collect {
                Toast.makeText(
                    this@IapBillingDefaultActivity,
                    "Purchase is complete ${it}",
                    Toast.LENGTH_LONG
                ).show()

            }
        }

        lifecycleScope.launch() {
            viewModel.purchasedProductMap.collect { productStatusMap ->
                prepareItems(productDataList, productStatusMap)
            }
        }

    }


    private fun prepareItems(
        dataList: List<ProductListingData>,
        productStatusMap: Map<String, InAppProductData>
    ) {
        dataItemsList.addAll(dataList)
        iapBillingAdapter.productStatusMap = productStatusMap
        //  .setProductStatusMap(productStatusMap)
        iapBillingAdapter.notifyDataSetChanged()
    }

    override fun onitemClick(
        pack: String,
        position: Int,
        subType: String,
        item: ProductListingData?
    ) {
        item?.productDetails?.let {
            viewModel.buy(
                productDetails = it,
                currentPurchases = null,
                tag = "",
                activity = this
            )
        }

    }
}


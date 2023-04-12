package com.rareprob.core_pulgin.payment.in_app_purchase.presentation

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.rareprob.core_pulgin.R
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData
import kotlinx.android.synthetic.main.view_in_app_purchase_item.view.*

class IapBillingAdapter(
    private val context: Context,
    private var mListner: OnItemClickListener?,
    private var dataList: List<ProductListingData>

) :
    RecyclerView.Adapter<IapBillingAdapter.IapBillingViewHolder>() {

    var mPositon:Int = -1
    var productStatusMap: Map<String, InAppProductData> = emptyMap()

    interface OnItemClickListener {
        fun onitemClick(pack: String, position: Int, subType: String, item: ProductListingData?)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IapBillingViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_in_app_purchase_item, parent, false)
        return IapBillingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IapBillingViewHolder, position: Int) {
        val iapItem = dataList[position]

        bindDataToViews(holder, iapItem)
        calculatePriceAndSetData(holder, iapItem)
        setClickListener(holder, iapItem, position)

        if(position!=-1) {
            if(mPositon == position)
                holder.rlParentView.setBackgroundResource(R.drawable.premium_selected_bg_3)
            else
                holder.rlParentView.setBackgroundResource(R.drawable.premium_unselected_bg)
        }
    }

    private fun bindDataToViews(
        holder: IapBillingViewHolder,
        iapItem: ProductListingData,
    ) {
        var save = iapItem.save
        var offerName = iapItem.offerName
        var price = iapItem.price
        var trialText = iapItem.trialText

        if (save.isNullOrEmpty()) {
            holder.rlFullPrice.visibility = View.GONE
            holder.llSave.visibility = View.GONE
        } else {
            holder.tvSavePercent.text = save
        }

        if (price?.isNotEmpty() == true) {
            holder.tvOnetimePrice?.text = iapItem.price
        }

        if (offerName?.isNotEmpty() == true) {
            holder.tvOfferName.visibility = View.VISIBLE
            holder.tvOfferName.text = iapItem.offerName
            setTypeFaceOpenSensSmBold(holder.tvOfferName)
        } else {
            holder.tvOfferName.visibility = View.GONE
        }

        holder.tvPackName.text = iapItem.packName

        if (trialText?.isNotEmpty() == true) {
            holder.tvRecurring.text = trialText
            holder.tvRecurring.visibility = View.VISIBLE
        } else {
            holder.tvRecurring.visibility = View.GONE
        }

    }

    private fun calculatePriceAndSetData(
        holder: IapBillingViewHolder,
        iapItem: ProductListingData
    ) {
        if (dataList != null) {
            val productId = iapItem.productID
            val packId = iapItem.packId
            if (productId?.isNotEmpty() == true && packId?.isNotEmpty() == true) {
                try {
                    val amctualPrice = iapItem.price
                    val actualPrice =
                        iapItem.price?.substring(1, amctualPrice?.length!!)?.replace(",", "")
                            ?.toFloat()
                    val showPrice = iapItem.showPrice

                    val requiredShowPrice =
                        showPrice?.substring(1, showPrice.length)?.replace(",", "")?.toFloat()
                    val percent = requiredShowPrice?.let {
                        (actualPrice?.let { requiredShowPrice?.minus(it) })?.div(it)
                    }
                    val savePercent = percent?.times(100)

                    if (savePercent != null && savePercent > 0L) {
                        holder.rlFullPrice.visibility = View.VISIBLE
                        holder.llSave.visibility = View.VISIBLE
                        holder.tvShowPrice.text = showPrice
                        holder.tvSavePercent.text = savePercent?.toInt().toString() + "%"
                    } else {
                        holder.rlFullPrice.visibility = View.GONE
                        holder.llSave.visibility = View.GONE
                    }

                } catch (e: java.lang.Exception) {
                    holder.rlFullPrice.visibility = View.GONE
                    holder.llSave.visibility = View.GONE
                }

            } else {
                holder.rlFullPrice.visibility = View.GONE
                holder.llSave.visibility = View.GONE
            }
        }
    }

    private fun setClickListener(
        holder: IapBillingViewHolder,
        iapItem: ProductListingData,
        position: Int
    ) {

        holder.itemView.setOnClickListener {

            updateCheck(position)

            mListner?.onitemClick(
                iapItem.packId ?: "",
                position,
                iapItem.subType ?: "",
                dataList[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun updateCheck(position: Int) {
        mPositon=position
        notifyDataSetChanged()
    }
    private fun setTypeFaceOpenSensSmBold(textView: TextView) {
        val typeface = Typeface.createFromAsset(
            this?.context?.assets,
            this?.context?.resources?.getString(R.string.text_2_path)
        )
        textView.typeface = typeface
    }

    inner class IapBillingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rlParentView: RelativeLayout = view.findViewById(R.id.parent_view)
        var rlFullPrice: RelativeLayout = view.findViewById(R.id.full_price)
        var llSave: LinearLayout = view.findViewById(R.id.save)

        var tvOfferName: TextView = view.findViewById(R.id.offer_name)
        var tvPackName: TextView = view.findViewById(R.id.packName)
        var tvRecurring: TextView = view.findViewById(R.id.recurring_text)
        var tvShowPrice: TextView = view.findViewById(R.id.show_price)
        var tvOnetimePrice: TextView = view.findViewById(R.id.onetime_price)
        var tvSavePercent: TextView = view.findViewById(R.id.save_percent)
    }
}
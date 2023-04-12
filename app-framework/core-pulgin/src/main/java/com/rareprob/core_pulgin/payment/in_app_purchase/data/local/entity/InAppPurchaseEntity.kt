package com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity

import androidx.room.Entity
import com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData

//TODO KP remote this primary key later on and make composite key
@Entity (primaryKeys = ["appId", "productId"])
data class InAppPurchaseEntity(
     var appId: String = "", //it is package name of application
    var productId: String = "",
    var productType: String = "",
    var productName: String = "",
    var active: String = "",
    var isPurchased: Boolean = false
) {
    fun toInAppProductData(): InAppProductData {
        return InAppProductData(
            appId = appId,
            productId = productId,
            productType = productType,
            productName = productName,
            active = active,
            isPurchased = isPurchased
        )
    }
}

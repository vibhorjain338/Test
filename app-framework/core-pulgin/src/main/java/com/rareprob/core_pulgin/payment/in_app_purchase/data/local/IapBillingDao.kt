package com.rareprob.core_pulgin.payment.in_app_purchase.data.local

import androidx.room.*
import com.rareprob.core_pulgin.core.base.BaseDao
import com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity

@Dao
 interface IapBillingDao : BaseDao<InAppPurchaseEntity> {

// @Query("SELECT * FROM InAppPurchaseEntity WHERE word LIKE '%' || :word || '%'")
//@Query("SELECT * FROM InAppPurchaseEntity")
// suspend fun getInAppPurchases(word: String): List<InAppPurchaseEntity>

 @Query("SELECT * FROM InAppPurchaseEntity")
 suspend fun getInAppPurchases(): List<InAppPurchaseEntity>


 @Query("SELECT * FROM InAppPurchaseEntity where appId = :appId and isPurchased = :isPurchased")
 suspend fun getAlreadyOwnedProduct(appId: String,
                                    isPurchased:Boolean
                                    ): List<InAppPurchaseEntity>

 @Query("SELECT * FROM InAppPurchaseEntity where appId = :appId and productId = :productId")
 suspend fun getInAppPurchaseById( appId: String,
                                   productId: String): InAppPurchaseEntity


//    @Query("SELECT * FROM NewProfileData")
//    abstract override fun queryForAll(): LiveData<List<NewProfileData>>
//
//    @Query("SELECT * FROM NewProfileData")
//    abstract override fun queryForAllWithFlow(): Flow<List<NewProfileData>>


//    @Query("SELECT * FROM NewProfileData")
//    override fun queryForAll(): LiveData<List<NewProfileData>>
////    @Insert
//    suspend fun insertProfile(newProfileData : NewProfileData)
//
//    @Update
//    suspend fun updateProfile(newProfileData : NewProfileData)
//
//    @Delete
//    suspend fun deleteProfile(newProfileData : NewProfileData)

//    @Query("SELECT * FROM NewProfileData")
//    fun getProfile(): LiveData<List<NewProfileData>>
//
//    @Query("SELECT * FROM NewProfileData")
//     override fun queryForAll(): LiveData<List<NewProfileData>>
}
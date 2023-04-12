package com.rareprob.core_pulgin.payment.in_app_purchase.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/local/IapBillingDao;", "Lcom/rareprob/core_pulgin/core/base/BaseDao;", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/local/entity/InAppPurchaseEntity;", "getAlreadyOwnedProduct", "", "appId", "", "isPurchased", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInAppPurchaseById", "productId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInAppPurchases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core-pulgin_debug"})
public abstract interface IapBillingDao extends com.rareprob.core_pulgin.core.base.BaseDao<com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity> {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM InAppPurchaseEntity")
    public abstract java.lang.Object getInAppPurchases(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM InAppPurchaseEntity where appId = :appId and isPurchased = :isPurchased")
    public abstract java.lang.Object getAlreadyOwnedProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String appId, boolean isPurchased, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM InAppPurchaseEntity where appId = :appId and productId = :productId")
    public abstract java.lang.Object getInAppPurchaseById(@org.jetbrains.annotations.NotNull()
    java.lang.String appId, @org.jetbrains.annotations.NotNull()
    java.lang.String productId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity> continuation);
}
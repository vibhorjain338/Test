package com.rareprob.core_pulgin.payment.in_app_purchase.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u001d\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingDefaultActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter$OnItemClickListener;", "()V", "dataItemsList", "Ljava/util/ArrayList;", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/model/ProductListingData;", "iapBillingAdapter", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter;", "productDataList", "", "viewModel", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingViewModel;", "getViewModel", "()Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initUi", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onitemClick", "pack", "", "position", "", "subType", "item", "prepareItems", "dataList", "productStatusMap", "", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/model/InAppProductData;", "setupDataList", "Companion", "Params", "core-pulgin_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class IapBillingDefaultActivity extends androidx.appcompat.app.AppCompatActivity implements com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.OnItemClickListener {
    @org.jetbrains.annotations.NotNull()
    public static final com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Companion Companion = null;
    private static final java.lang.String PARAMS = "params";
    private java.util.ArrayList<com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData> dataItemsList;
    private com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter iapBillingAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.List<com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData> productDataList;
    private java.util.HashMap _$_findViewCache;
    
    public IapBillingDefaultActivity() {
        super();
    }
    
    private final com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initUi() {
    }
    
    private final void setupDataList() {
    }
    
    private final void prepareItems(java.util.List<com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData> dataList, java.util.Map<java.lang.String, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData> productStatusMap) {
    }
    
    @java.lang.Override()
    public void onitemClick(@org.jetbrains.annotations.NotNull()
    java.lang.String pack, int position, @org.jetbrains.annotations.NotNull()
    java.lang.String subType, @org.jetbrains.annotations.Nullable()
    com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData item) {
    }
    
    @kotlinx.android.parcel.Parcelize()
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingDefaultActivity$Params;", "Landroid/os/Parcelable;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core-pulgin_debug"})
    public static final class Params implements android.os.Parcelable {
        private final long id = 0L;
        public static final android.os.Parcelable.Creator<com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params copy(long id) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Params() {
            super();
        }
        
        public Params(long id) {
            super();
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long getId() {
            return 0L;
        }
        
        @java.lang.Override()
        public int describeContents() {
            return 0;
        }
        
        @java.lang.Override()
        public void writeToParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel, int flags) {
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
        public static final class Creator implements android.os.Parcelable.Creator<com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params[] newArray(int size) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingDefaultActivity$Companion;", "", "()V", "PARAMS", "", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "params", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingDefaultActivity$Params;", "launch", "", "core-pulgin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void launch(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params params) {
        }
        
        private final android.content.Intent getLaunchIntent(android.content.Context context, com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingDefaultActivity.Params params) {
            return null;
        }
    }
}
package com.rareprob.core_pulgin.payment.in_app_purchase.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002*+B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u001c\u0010\u001d\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0016J\u001c\u0010\u001f\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\fH\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0017J$\u0010%\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010 \u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006,"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter$IapBillingViewHolder;", "context", "Landroid/content/Context;", "mListner", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter$OnItemClickListener;", "dataList", "", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/model/ProductListingData;", "(Landroid/content/Context;Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter$OnItemClickListener;Ljava/util/List;)V", "mPositon", "", "getMPositon", "()I", "setMPositon", "(I)V", "productStatusMap", "", "", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/model/InAppProductData;", "getProductStatusMap", "()Ljava/util/Map;", "setProductStatusMap", "(Ljava/util/Map;)V", "bindDataToViews", "", "holder", "iapItem", "calculatePriceAndSetData", "getItemCount", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setTypeFaceOpenSensSmBold", "textView", "Landroid/widget/TextView;", "updateCheck", "IapBillingViewHolder", "OnItemClickListener", "core-pulgin_debug"})
public final class IapBillingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.IapBillingViewHolder> {
    private final android.content.Context context = null;
    private com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.OnItemClickListener mListner;
    private java.util.List<com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData> dataList;
    private int mPositon = -1;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData> productStatusMap;
    
    public IapBillingAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.OnItemClickListener mListner, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData> dataList) {
        super();
    }
    
    public final int getMPositon() {
        return 0;
    }
    
    public final void setMPositon(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData> getProductStatusMap() {
        return null;
    }
    
    public final void setProductStatusMap(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.InAppProductData> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    @java.lang.Override()
    public com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.IapBillingViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.IapBillingViewHolder holder, int position) {
    }
    
    private final void bindDataToViews(com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.IapBillingViewHolder holder, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData iapItem) {
    }
    
    private final void calculatePriceAndSetData(com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.IapBillingViewHolder holder, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData iapItem) {
    }
    
    private final void setClickListener(com.rareprob.core_pulgin.payment.in_app_purchase.presentation.IapBillingAdapter.IapBillingViewHolder holder, com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData iapItem, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateCheck(int position) {
    }
    
    private final void setTypeFaceOpenSensSmBold(android.widget.TextView textView) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter$OnItemClickListener;", "", "onitemClick", "", "pack", "", "position", "", "subType", "item", "Lcom/rareprob/core_pulgin/payment/in_app_purchase/data/model/ProductListingData;", "core-pulgin_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onitemClick(@org.jetbrains.annotations.NotNull()
        java.lang.String pack, int position, @org.jetbrains.annotations.NotNull()
        java.lang.String subType, @org.jetbrains.annotations.Nullable()
        com.rareprob.core_pulgin.payment.in_app_purchase.data.model.ProductListingData item);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0017\"\u0004\b(\u0010\u0019\u00a8\u0006)"}, d2 = {"Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter$IapBillingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/rareprob/core_pulgin/payment/in_app_purchase/presentation/IapBillingAdapter;Landroid/view/View;)V", "llSave", "Landroid/widget/LinearLayout;", "getLlSave", "()Landroid/widget/LinearLayout;", "setLlSave", "(Landroid/widget/LinearLayout;)V", "rlFullPrice", "Landroid/widget/RelativeLayout;", "getRlFullPrice", "()Landroid/widget/RelativeLayout;", "setRlFullPrice", "(Landroid/widget/RelativeLayout;)V", "rlParentView", "getRlParentView", "setRlParentView", "tvOfferName", "Landroid/widget/TextView;", "getTvOfferName", "()Landroid/widget/TextView;", "setTvOfferName", "(Landroid/widget/TextView;)V", "tvOnetimePrice", "getTvOnetimePrice", "setTvOnetimePrice", "tvPackName", "getTvPackName", "setTvPackName", "tvRecurring", "getTvRecurring", "setTvRecurring", "tvSavePercent", "getTvSavePercent", "setTvSavePercent", "tvShowPrice", "getTvShowPrice", "setTvShowPrice", "core-pulgin_debug"})
    public final class IapBillingViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.RelativeLayout rlParentView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.RelativeLayout rlFullPrice;
        @org.jetbrains.annotations.NotNull()
        private android.widget.LinearLayout llSave;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvOfferName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvPackName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvRecurring;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvShowPrice;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvOnetimePrice;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvSavePercent;
        
        public IapBillingViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RelativeLayout getRlParentView() {
            return null;
        }
        
        public final void setRlParentView(@org.jetbrains.annotations.NotNull()
        android.widget.RelativeLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RelativeLayout getRlFullPrice() {
            return null;
        }
        
        public final void setRlFullPrice(@org.jetbrains.annotations.NotNull()
        android.widget.RelativeLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getLlSave() {
            return null;
        }
        
        public final void setLlSave(@org.jetbrains.annotations.NotNull()
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvOfferName() {
            return null;
        }
        
        public final void setTvOfferName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPackName() {
            return null;
        }
        
        public final void setTvPackName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvRecurring() {
            return null;
        }
        
        public final void setTvRecurring(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvShowPrice() {
            return null;
        }
        
        public final void setTvShowPrice(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvOnetimePrice() {
            return null;
        }
        
        public final void setTvOnetimePrice(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSavePercent() {
            return null;
        }
        
        public final void setTvSavePercent(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
}
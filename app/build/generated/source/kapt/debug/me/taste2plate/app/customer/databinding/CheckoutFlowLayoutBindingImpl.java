package me.taste2plate.app.customer.databinding;
import me.taste2plate.app.customer.R;
import me.taste2plate.app.customer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CheckoutFlowLayoutBindingImpl extends CheckoutFlowLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.userName, 2);
        sViewsWithIds.put(R.id.address_type, 3);
        sViewsWithIds.put(R.id.addressSummary, 4);
        sViewsWithIds.put(R.id.phoneNumber, 5);
        sViewsWithIds.put(R.id.newAddress, 6);
        sViewsWithIds.put(R.id.products, 7);
        sViewsWithIds.put(R.id.apply_coupon, 8);
        sViewsWithIds.put(R.id.coupon_info, 9);
        sViewsWithIds.put(R.id.coupon_code, 10);
        sViewsWithIds.put(R.id.clear, 11);
        sViewsWithIds.put(R.id.price, 12);
        sViewsWithIds.put(R.id.dFee, 13);
        sViewsWithIds.put(R.id.packingPrice, 14);
        sViewsWithIds.put(R.id.cgstValue, 15);
        sViewsWithIds.put(R.id.sgstValue, 16);
        sViewsWithIds.put(R.id.igstValue, 17);
        sViewsWithIds.put(R.id.dContainer, 18);
        sViewsWithIds.put(R.id.discountPrice, 19);
        sViewsWithIds.put(R.id.sDiscount, 20);
        sViewsWithIds.put(R.id.sDiscountPrice, 21);
        sViewsWithIds.put(R.id.wDiscount, 22);
        sViewsWithIds.put(R.id.point_conversion, 23);
        sViewsWithIds.put(R.id.wDiscountPrice, 24);
        sViewsWithIds.put(R.id.check_wallet, 25);
        sViewsWithIds.put(R.id.choose_wallet, 26);
        sViewsWithIds.put(R.id.finalFee, 27);
        sViewsWithIds.put(R.id.radioGroup, 28);
        sViewsWithIds.put(R.id.express, 29);
        sViewsWithIds.put(R.id.standard, 30);
        sViewsWithIds.put(R.id.deliveryModeData, 31);
        sViewsWithIds.put(R.id.delivery_date_time, 32);
        sViewsWithIds.put(R.id.date, 33);
        sViewsWithIds.put(R.id.time, 34);
        sViewsWithIds.put(R.id.paymentType, 35);
        sViewsWithIds.put(R.id.online, 36);
        sViewsWithIds.put(R.id.cod, 37);
        sViewsWithIds.put(R.id.checkout, 38);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CheckoutFlowLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }
    private CheckoutFlowLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[15]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.TextView) bindings[38]
            , (android.widget.CheckBox) bindings[26]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.RadioButton) bindings[37]
            , (android.widget.TextView) bindings[10]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[33]
            , (android.widget.LinearLayout) bindings[32]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[19]
            , (android.widget.RadioButton) bindings[29]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[6]
            , (android.widget.RadioButton) bindings[36]
            , (android.widget.TextView) bindings[14]
            , (android.widget.RadioGroup) bindings[35]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[12]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (android.widget.RadioGroup) bindings[28]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[16]
            , (android.widget.RadioButton) bindings[30]
            , (android.widget.TextView) bindings[34]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.TextView) bindings[24]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}
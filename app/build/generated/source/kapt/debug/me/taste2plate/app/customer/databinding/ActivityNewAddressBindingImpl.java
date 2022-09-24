package me.taste2plate.app.customer.databinding;
import me.taste2plate.app.customer.R;
import me.taste2plate.app.customer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityNewAddressBindingImpl extends ActivityNewAddressBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tool, 1);
        sViewsWithIds.put(R.id.tilname, 2);
        sViewsWithIds.put(R.id.name, 3);
        sViewsWithIds.put(R.id.tilPhone, 4);
        sViewsWithIds.put(R.id.etPhone, 5);
        sViewsWithIds.put(R.id.address1, 6);
        sViewsWithIds.put(R.id.etAddress1, 7);
        sViewsWithIds.put(R.id.address2, 8);
        sViewsWithIds.put(R.id.etAddress2, 9);
        sViewsWithIds.put(R.id.country, 10);
        sViewsWithIds.put(R.id.etCountry, 11);
        sViewsWithIds.put(R.id.state, 12);
        sViewsWithIds.put(R.id.etState, 13);
        sViewsWithIds.put(R.id.city, 14);
        sViewsWithIds.put(R.id.etCity, 15);
        sViewsWithIds.put(R.id.pincode, 16);
        sViewsWithIds.put(R.id.etPin, 17);
        sViewsWithIds.put(R.id.postoffice, 18);
        sViewsWithIds.put(R.id.etpostOffice, 19);
        sViewsWithIds.put(R.id.address_type, 20);
        sViewsWithIds.put(R.id.home, 21);
        sViewsWithIds.put(R.id.work, 22);
        sViewsWithIds.put(R.id.other, 23);
        sViewsWithIds.put(R.id.tilOtherText, 24);
        sViewsWithIds.put(R.id.otherAddress, 25);
        sViewsWithIds.put(R.id.save, 26);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityNewAddressBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private ActivityNewAddressBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (android.widget.RadioGroup) bindings[20]
            , (com.google.android.material.textfield.TextInputLayout) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[10]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (com.google.android.material.textfield.TextInputEditText) bindings[15]
            , (com.google.android.material.textfield.TextInputEditText) bindings[11]
            , (android.widget.EditText) bindings[5]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[17]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[19]
            , (android.widget.RadioButton) bindings[21]
            , (android.widget.EditText) bindings[3]
            , (android.widget.RadioButton) bindings[23]
            , (android.widget.EditText) bindings[25]
            , (com.google.android.material.textfield.TextInputLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[18]
            , (android.widget.TextView) bindings[26]
            , (com.google.android.material.textfield.TextInputLayout) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[2]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.RadioButton) bindings[22]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
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
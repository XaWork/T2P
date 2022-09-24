package me.taste2plate.app.customer.databinding;
import me.taste2plate.app.customer.R;
import me.taste2plate.app.customer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PlanItemBindingImpl extends PlanItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline, 6);
        sViewsWithIds.put(R.id.guideline_end, 7);
        sViewsWithIds.put(R.id.description_title, 8);
        sViewsWithIds.put(R.id.benefits_title, 9);
        sViewsWithIds.put(R.id.buy_button, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView5;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PlanItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private PlanItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.benefitsContent.setTag(null);
        this.descriptionText.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.planName.setTag(null);
        this.validityText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.planModel == variableId) {
            setPlanModel((me.taste2plate.app.models.membership.Plan) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPlanModel(@Nullable me.taste2plate.app.models.membership.Plan PlanModel) {
        this.mPlanModel = PlanModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.planModel);
        super.requestRebind();
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
        java.lang.String planModelValidityText = null;
        java.lang.String planModelDescription = null;
        java.lang.String planModelName = null;
        java.lang.String planModelBenefits = null;
        java.lang.String planModelItemPrice = null;
        me.taste2plate.app.models.membership.Plan planModel = mPlanModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (planModel != null) {
                    // read planModel.validityText
                    planModelValidityText = planModel.getValidityText();
                    // read planModel.description
                    planModelDescription = planModel.getDescription();
                    // read planModel.name
                    planModelName = planModel.getName();
                    // read planModel.benefits
                    planModelBenefits = planModel.getBenefits();
                    // read planModel.itemPrice
                    planModelItemPrice = planModel.getItemPrice();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.benefitsContent, planModelBenefits);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.descriptionText, planModelDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, planModelItemPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.planName, planModelName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.validityText, planModelValidityText);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): planModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
package me.taste2plate.app.customer.databinding;
import me.taste2plate.app.customer.R;
import me.taste2plate.app.customer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RewardActivityBindingImpl extends RewardActivityBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(25);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar"},
            new int[] {1},
            new int[] {me.taste2plate.app.customer.R.layout.toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.data_view, 2);
        sViewsWithIds.put(R.id.guideline, 3);
        sViewsWithIds.put(R.id.guideline2, 4);
        sViewsWithIds.put(R.id.header1, 5);
        sViewsWithIds.put(R.id.header2, 6);
        sViewsWithIds.put(R.id.header3, 7);
        sViewsWithIds.put(R.id.min_s1, 8);
        sViewsWithIds.put(R.id.max_s1, 9);
        sViewsWithIds.put(R.id.point_s1, 10);
        sViewsWithIds.put(R.id.min_s2, 11);
        sViewsWithIds.put(R.id.max_s2, 12);
        sViewsWithIds.put(R.id.point_s2, 13);
        sViewsWithIds.put(R.id.min_s3, 14);
        sViewsWithIds.put(R.id.max_s3, 15);
        sViewsWithIds.put(R.id.point_s3, 16);
        sViewsWithIds.put(R.id.point_earn_container, 17);
        sViewsWithIds.put(R.id.referral_heading, 18);
        sViewsWithIds.put(R.id.referral_info, 19);
        sViewsWithIds.put(R.id.point_info, 20);
        sViewsWithIds.put(R.id.review_info, 21);
        sViewsWithIds.put(R.id.error_layout, 22);
        sViewsWithIds.put(R.id.tvEmptyState_title, 23);
        sViewsWithIds.put(R.id.tvEmptyState_description, 24);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RewardActivityBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private RewardActivityBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[22]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[17]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[21]
            , (me.taste2plate.app.customer.databinding.ToolbarBinding) bindings[1]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[23]
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
                mDirtyFlags = 0x2L;
        }
        toolbarContainer.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbarContainer.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbarContainer.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbarContainer((me.taste2plate.app.customer.databinding.ToolbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbarContainer(me.taste2plate.app.customer.databinding.ToolbarBinding ToolbarContainer, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        executeBindingsOn(toolbarContainer);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbarContainer
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
package me.taste2plate.app.customer.databinding;
import me.taste2plate.app.customer.R;
import me.taste2plate.app.customer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyPlanBindingImpl extends ActivityMyPlanBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(20);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar"},
            new int[] {1},
            new int[] {me.taste2plate.app.customer.R.layout.toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.error_layout, 2);
        sViewsWithIds.put(R.id.tvEmptyState_title, 3);
        sViewsWithIds.put(R.id.tvEmptyState_description, 4);
        sViewsWithIds.put(R.id.plan_container, 5);
        sViewsWithIds.put(R.id.guideline, 6);
        sViewsWithIds.put(R.id.plan_name, 7);
        sViewsWithIds.put(R.id.plan_price, 8);
        sViewsWithIds.put(R.id.guideline_half, 9);
        sViewsWithIds.put(R.id.or, 10);
        sViewsWithIds.put(R.id.upgrade, 11);
        sViewsWithIds.put(R.id.usage, 12);
        sViewsWithIds.put(R.id.usage_text, 13);
        sViewsWithIds.put(R.id.sep, 14);
        sViewsWithIds.put(R.id.expiry_title, 15);
        sViewsWithIds.put(R.id.expiry_date, 16);
        sViewsWithIds.put(R.id.sep1, 17);
        sViewsWithIds.put(R.id.benefits_title, 18);
        sViewsWithIds.put(R.id.benefits_content, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyPlanBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityMyPlanBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[15]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.view.View) bindings[14]
            , (android.view.View) bindings[17]
            , (me.taste2plate.app.customer.databinding.ToolbarBinding) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
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
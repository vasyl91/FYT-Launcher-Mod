package com.android.launcher66;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

public class HideFromAccessibilityHelper implements ViewGroup.OnHierarchyChangeListener {
    boolean mOnlyAllApps;
    private HashMap<View, Integer> mPreviousValues = new HashMap<>();
    boolean mHide = false;

    public void setImportantForAccessibilityToNo(View v, boolean onlyAllApps) {
        this.mOnlyAllApps = onlyAllApps;
        setImportantForAccessibilityToNoHelper(v);
        this.mHide = true;
    }

    private void setImportantForAccessibilityToNoHelper(View v) {
        this.mPreviousValues.put(v, Integer.valueOf(v.getImportantForAccessibility()));
        v.setImportantForAccessibility(2);
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            vg.setOnHierarchyChangeListener(this);
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                if (includeView(child)) {
                    setImportantForAccessibilityToNoHelper(child);
                }
            }
        }
    }

    public void restoreImportantForAccessibility(View v) {
        if (this.mHide) {
            restoreImportantForAccessibilityHelper(v);
        }
        this.mHide = false;
    }

    private void restoreImportantForAccessibilityHelper(View v) {
        Integer important = mPreviousValues.get(v);
        v.setImportantForAccessibility(important);
        mPreviousValues.remove(v);

        // Call method on children recursively
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;

            // We assume if a class implements OnHierarchyChangeListener, it listens
            // to changes to any of its children (happens to be the case in Launcher)
            if (vg instanceof ViewGroup.OnHierarchyChangeListener) {
                vg.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) vg);
            } else {
                vg.setOnHierarchyChangeListener(null);
            }
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                if (includeView(child)) {
                    restoreImportantForAccessibilityHelper(child);
                }
            }
        }
    }

    @Override
    public void onChildViewAdded(View parent, View child) {
        if (this.mHide && includeView(child)) {
            setImportantForAccessibilityToNoHelper(child);
        }
    }

    @Override
    public void onChildViewRemoved(View parent, View child) {
        if (this.mHide && includeView(child)) {
            restoreImportantForAccessibilityHelper(child);
        }
    }

    private boolean includeView(View v) {
        return !hasAncestorOfType(v, Cling.class) && (!this.mOnlyAllApps || hasAncestorOfType(v, AppsCustomizeTabHost.class));
    }

    private boolean hasAncestorOfType(View v, Class c) {
        return v != null && (v.getClass().equals(c) || ((v.getParent() instanceof ViewGroup) && hasAncestorOfType((ViewGroup) v.getParent(), c)));
    }
}

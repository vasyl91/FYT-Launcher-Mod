package com.android.launcher66;

import android.content.Context;
import android.view.View;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class AppsCustomizeCellLayout extends CellLayout implements Page {
    public AppsCustomizeCellLayout(Context context) {
        super(context);
    }

    @Override // com.android.launcher66.Page
    public void removeAllViewsOnPage() {
        removeAllViews();
        setLayerType(View.LAYER_TYPE_NONE, null);
    }

    @Override // com.android.launcher66.Page
    public void removeViewOnPageAt(int index) {
        removeViewAt(index);
    }

    @Override // com.android.launcher66.Page
    public int getPageChildCount() {
        return getChildCount();
    }

    @Override // com.android.launcher66.Page
    public View getChildOnPageAt(int i) {
        return getChildAt(i);
    }

    @Override // com.android.launcher66.Page
    public int indexOfChildOnPage(View v) {
        return indexOfChild(v);
    }

    public void resetChildrenOnKeyListeners() {
        ShortcutAndWidgetContainer children = getShortcutsAndWidgets();
        int childCount = children.getChildCount();
        for (int j = 0; j < childCount; j++) {
            children.getChildAt(j).setOnKeyListener(null);
        }
    }
}

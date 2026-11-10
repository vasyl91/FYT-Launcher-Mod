package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i2)), i2, 0));
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }
}

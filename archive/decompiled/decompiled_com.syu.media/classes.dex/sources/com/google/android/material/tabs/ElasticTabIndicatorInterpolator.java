package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
    }

    private static float decInterp(float f) {
        return (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
    }

    private static float accInterp(float f) {
        return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    void setIndicatorBoundsForOffset(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fDecInterp;
        float fAccInterp;
        RectF rectFCalculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        RectF rectFCalculateIndicatorWidthForTab2 = calculateIndicatorWidthForTab(tabLayout, view2);
        if (rectFCalculateIndicatorWidthForTab.left < rectFCalculateIndicatorWidthForTab2.left) {
            fDecInterp = accInterp(f);
            fAccInterp = decInterp(f);
        } else {
            fDecInterp = decInterp(f);
            fAccInterp = accInterp(f);
        }
        drawable.setBounds(AnimationUtils.lerp((int) rectFCalculateIndicatorWidthForTab.left, (int) rectFCalculateIndicatorWidthForTab2.left, fDecInterp), drawable.getBounds().top, AnimationUtils.lerp((int) rectFCalculateIndicatorWidthForTab.right, (int) rectFCalculateIndicatorWidthForTab2.right, fAccInterp), drawable.getBounds().bottom);
    }
}

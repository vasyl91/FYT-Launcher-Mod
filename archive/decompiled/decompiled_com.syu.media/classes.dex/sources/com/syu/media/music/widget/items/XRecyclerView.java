package com.syu.media.music.widget.items;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class XRecyclerView extends RecyclerView {
    private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final float INFLEXION = 0.35f;
    private float mFlingFriction;
    private float mPhysicalCoeff;

    public XRecyclerView(Context context) {
        super(context);
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mPhysicalCoeff = 0.0f;
        init();
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mPhysicalCoeff = 0.0f;
        init();
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mPhysicalCoeff = 0.0f;
        init();
    }

    private void init() {
        setChildrenDrawingOrderEnabled(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public XLayoutManager getLayoutManager() {
        return getLayoutManager();
    }

    private int getVelocity(double d) {
        return Math.abs((int) ((Math.exp((Math.log(d / ((double) (this.mFlingFriction * this.mPhysicalCoeff))) * (((double) DECELERATION_RATE) - 1.0d)) / ((double) DECELERATION_RATE)) * ((double) (this.mFlingFriction * this.mPhysicalCoeff))) / 0.3499999940395355d));
    }

    private double getSplineDeceleration(int i) {
        return Math.log((Math.abs(i) * INFLEXION) / (this.mFlingFriction * (((getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f)));
    }

    private float getPhysicalCoeff() {
        if (this.mPhysicalCoeff == 0.0f) {
            this.mPhysicalCoeff = getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }
        return this.mPhysicalCoeff;
    }
}

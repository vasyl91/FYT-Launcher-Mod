package com.android.launcher66;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class PageIndicatorMarker extends FrameLayout {
    private static final int MARKER_FADE_DURATION = 175;
    private static final String TAG = "PageIndicator";
    private ImageView mActiveMarker;
    private ImageView mInactiveMarker;
    private boolean mIsActive;

    public PageIndicatorMarker(Context context) {
        this(context, null);
    }

    public PageIndicatorMarker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageIndicatorMarker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsActive = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mActiveMarker = (ImageView) findViewById(R.id.active);
        this.mInactiveMarker = (ImageView) findViewById(R.id.inactive);
    }

    void setMarkerDrawables(int activeResId, int inactiveResId) {
        Resources r = getResources();
        this.mActiveMarker.setImageDrawable(r.getDrawable(activeResId));
        this.mInactiveMarker.setImageDrawable(r.getDrawable(inactiveResId));
    }

    void activate(boolean immediate) {
        if (immediate) {
            this.mActiveMarker.animate().cancel();
            this.mActiveMarker.setAlpha(1.0f);
            this.mActiveMarker.setScaleX(1.0f);
            this.mActiveMarker.setScaleY(1.0f);
            this.mInactiveMarker.animate().cancel();
            this.mInactiveMarker.setAlpha(0.0f);
        } else {
            this.mActiveMarker.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(175L).start();
            this.mInactiveMarker.animate().alpha(0.0f).setDuration(175L).start();
        }
        this.mIsActive = true;
    }

    void inactivate(boolean immediate) {
        if (immediate) {
            this.mInactiveMarker.animate().cancel();
            this.mInactiveMarker.setAlpha(1.0f);
            this.mActiveMarker.animate().cancel();
            this.mActiveMarker.setAlpha(0.0f);
            this.mActiveMarker.setScaleX(0.5f);
            this.mActiveMarker.setScaleY(0.5f);
        } else {
            this.mInactiveMarker.animate().alpha(1.0f).setDuration(175L).start();
            this.mActiveMarker.animate().alpha(0.0f).scaleX(0.5f).scaleY(0.5f).setDuration(175L).start();
        }
        this.mIsActive = false;
    }

    boolean isActive() {
        return this.mIsActive;
    }
}

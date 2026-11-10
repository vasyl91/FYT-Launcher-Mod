package com.lsec.core.frame.ctrl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.lsec.core.ipc.module.main.Main;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JScrollView extends ScrollView {
    boolean bAttached;
    private boolean bMove;
    boolean bWillUpdateBackground;
    private LinearLayout layout;
    public HashMap<String, Drawable> mDrawables;
    private GestureDetector mGestureDetector;
    private Runnable mRunnableMeasure;
    private Runnable mRunnableOverScroll;
    public int mStepHeight;
    String mStrDrawable;
    public JPage page;

    public void setStepHeight(int stepH) {
        this.mStepHeight = stepH;
    }

    public void setOverScrolled(Runnable overScrolled) {
        this.mRunnableOverScroll = overScrolled;
    }

    public void setMeasure(Runnable runnableSizeChange) {
        this.mRunnableMeasure = runnableSizeChange;
    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        YScrollDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceY) >= Math.abs(distanceX);
        }
    }

    public JScrollView(Context context, JPage page) {
        super(context);
        this.mStepHeight = 0;
        this.bMove = false;
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.page = page;
        this.mGestureDetector = new GestureDetector(context, new YScrollDetector());
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mGestureDetector.onTouchEvent(ev)) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                this.bMove = false;
                break;
            case 1:
                if (this.bMove && this.mRunnableOverScroll != null) {
                    Main.postRunnable_Ui(true, this.mRunnableOverScroll);
                }
                break;
            case 2:
                int scrollY = getScrollY();
                if (Math.abs(scrollY) > 15) {
                    this.bMove = true;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (widthMeasureSpec > 0 && heightMeasureSpec > 0 && this.mRunnableMeasure != null) {
            Main.postRunnable_Ui(true, this.mRunnableMeasure);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk) {
            if (drawable == null) {
                setBackground(null);
            } else {
                updateBackground();
            }
        }
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        if (this.page != null && this.mStrDrawable != null) {
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawable, this.page.mDrawables, this.mDrawables);
            setBackground(drawable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }

    public void setLayout(LinearLayout layout) {
        this.layout = layout;
        addView(layout);
    }

    public LinearLayout getLayout() {
        return this.layout;
    }
}

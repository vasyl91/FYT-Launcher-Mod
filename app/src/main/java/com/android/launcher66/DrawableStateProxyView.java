package com.android.launcher66;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class DrawableStateProxyView extends LinearLayout {
    private View mView;
    private int mViewId;

    public DrawableStateProxyView(Context context) {
        this(context, null);
    }

    public DrawableStateProxyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableStateProxyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DrawableStateProxyView, defStyle, 0);
        this.mViewId = a.getResourceId(0, -1);
        a.recycle();
        setFocusable(false);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mView == null) {
            View parent = (View) getParent();
            this.mView = parent.findViewById(this.mViewId);
        }
        if (this.mView != null) {
            this.mView.setPressed(isPressed());
            this.mView.setHovered(isHovered());
        }
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        return false;
    }
}

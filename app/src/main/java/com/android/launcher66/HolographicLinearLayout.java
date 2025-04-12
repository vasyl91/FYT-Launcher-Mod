package com.android.launcher66;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HolographicLinearLayout extends LinearLayout {
    private final HolographicViewHelper mHolographicHelper;
    private boolean mHotwordOn;
    private ImageView mImageView;
    private int mImageViewId;
    private boolean mIsFocused;
    private boolean mIsPressed;

    public HolographicLinearLayout(Context context) {
        this(context, null);
    }

    public HolographicLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HolographicLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HolographicLinearLayout, defStyle, 0);
        mImageViewId = a.getResourceId(R.styleable.HolographicLinearLayout_sourceImageViewId, -1);
        mHotwordOn = a.getBoolean(R.styleable.HolographicLinearLayout_stateHotwordOn, false);
        a.recycle();
        setWillNotDraw(false);
        this.mHolographicHelper = new HolographicViewHelper(context);
        setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (HolographicLinearLayout.this.isPressed() != HolographicLinearLayout.this.mIsPressed) {
                    HolographicLinearLayout.this.mIsPressed = HolographicLinearLayout.this.isPressed();
                    HolographicLinearLayout.this.refreshDrawableState();
                    return false;
                }
                return false;
            }
        });
        setOnFocusChangeListener(new View.OnFocusChangeListener() { 
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (HolographicLinearLayout.this.isFocused() != HolographicLinearLayout.this.mIsFocused) {
                    HolographicLinearLayout.this.mIsFocused = HolographicLinearLayout.this.isFocused();
                    HolographicLinearLayout.this.refreshDrawableState();
                }
            }
        });
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mImageView != null) {
            this.mHolographicHelper.generatePressedFocusedStates(this.mImageView);
            Drawable d = this.mImageView.getDrawable();
            if (d instanceof StateListDrawable) {
                StateListDrawable sld = (StateListDrawable) d;
                sld.setState(getDrawableState());
                sld.invalidateSelf();
            }
        }
    }

    void invalidatePressedFocusedStates() {
        this.mHolographicHelper.invalidatePressedFocusedStates(this.mImageView);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mImageView == null) {
            this.mImageView = (ImageView) findViewById(this.mImageViewId);
        }
        this.mHolographicHelper.generatePressedFocusedStates(this.mImageView);
    }

    private boolean isHotwordOn() {
        return this.mHotwordOn;
    }

    public void setHotwordState(boolean on) {
        if (on != this.mHotwordOn) {
            this.mHotwordOn = on;
            refreshDrawableState();
        }
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isHotwordOn()) {
            mergeDrawableStates(drawableState, new int[]{R.attr.stateHotwordOn});
        }
        return drawableState;
    }
}

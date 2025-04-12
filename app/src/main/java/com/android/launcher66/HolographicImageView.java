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

public class HolographicImageView extends ImageView {
    private final HolographicViewHelper mHolographicHelper;
    private boolean mHotwordOn;
    private boolean mIsFocused;
    private boolean mIsPressed;

    public HolographicImageView(Context context) {
        this(context, null);
    }

    public HolographicImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HolographicImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHolographicHelper = new HolographicViewHelper(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HolographicLinearLayout, defStyle, 0);
        this.mHotwordOn = a.getBoolean(R.styleable.HolographicLinearLayout_stateHotwordOn, false);
        a.recycle();
        setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (HolographicImageView.this.isPressed() != HolographicImageView.this.mIsPressed) {
                    HolographicImageView.this.mIsPressed = HolographicImageView.this.isPressed();
                    HolographicImageView.this.refreshDrawableState();
                    return false;
                }
                return false;
            }
        });
        setOnFocusChangeListener(new View.OnFocusChangeListener() { 
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (HolographicImageView.this.isFocused() != HolographicImageView.this.mIsFocused) {
                    HolographicImageView.this.mIsFocused = HolographicImageView.this.isFocused();
                    HolographicImageView.this.refreshDrawableState();
                }
            }
        });
    }

    void invalidatePressedFocusedStates() {
        this.mHolographicHelper.invalidatePressedFocusedStates(this);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.mHolographicHelper.generatePressedFocusedStates(this);
        Drawable d = getDrawable();
        if (d instanceof StateListDrawable) {
            StateListDrawable sld = (StateListDrawable) d;
            sld.setState(getDrawableState());
            sld.invalidateSelf();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mHolographicHelper.generatePressedFocusedStates(this);
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

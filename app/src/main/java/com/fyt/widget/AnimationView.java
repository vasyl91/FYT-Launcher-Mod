package com.fyt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import com.android.launcher66.R;

public class AnimationView extends View implements ViewTreeObserver.OnGlobalLayoutListener {
    protected int animId;
    private AnimationDrawable mAnimationDrawable;

    public AnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mAnimationDrawable = null;
        this.animId = -1;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimationView, 0, 0);
        this.animId = a.getResourceId(0, 0);
        a.recycle();
        init(context);
    }

    public AnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimationView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        if (this.animId > 0) {
            setBackgroundResource(this.animId);
            this.mAnimationDrawable = (AnimationDrawable) getBackground();
            this.mAnimationDrawable.setOneShot(false);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        if (this.mAnimationDrawable != null) {
            this.mAnimationDrawable.start();
        }
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        if (this.mAnimationDrawable != null) {
            this.mAnimationDrawable.stop();
        }
        super.onDetachedFromWindow();
    }

    @Override
    public void onGlobalLayout() {
    }
}

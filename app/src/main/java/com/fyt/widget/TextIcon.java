package com.fyt.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.StyleableRes;

import com.android.launcher66.R;

public class TextIcon extends TextView implements ViewTreeObserver.OnGlobalLayoutListener {
    private int iconId;
    private int mHeight;
    private int mWidth;
    private int pressedId;
    @SuppressWarnings("ResourceType")
    public TextIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.iconId = -1;
        this.pressedId = -1;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextIcon, defStyle, 0);
        this.iconId = a.getResourceId(0, 0);
        this.pressedId = a.getResourceId(1, 0);
        init();
        a.recycle();
    }

    public TextIcon(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextIcon(Context context) {
        this(context, null);
    }

    private void init() {
        Resources res = getResources();
        int dimension = (int) res.getDimension(R.dimen.app_icon_size);
        this.mWidth = dimension;
        this.mHeight = dimension;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            if (this.iconId > 0) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), this.iconId);
                int bwith = bitmap.getWidth();
                int bheight = bitmap.getHeight();
                float wscale = this.mWidth / bwith;
                float hscale = this.mHeight / bheight;
                if (wscale <= hscale) {
                    hscale = wscale;
                }
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getScaleBitmap(bitmap, hscale)), (Drawable) null, (Drawable) null);
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            setIcon(this.pressedId);
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            setIcon(this.iconId);
        }
        return super.onTouchEvent(event);
    }

    public void setIdToIcon(int res) {
        this.iconId = res;
    }

    public void setIdToPress(int res) {
        this.pressedId = res;
    }

    public void setIcon(int res) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), res);
        int bwith = bitmap.getWidth();
        int bheight = bitmap.getHeight();
        float wscale = this.mWidth / bwith;
        float hscale = this.mHeight / bheight;
        if (wscale <= hscale) {
            hscale = wscale;
        }
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getScaleBitmap(bitmap, hscale)), (Drawable) null, (Drawable) null);
    }

    public Bitmap getScaleBitmap(Bitmap bitmap, float scale) {
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * scale), (int) (bitmap.getHeight() * scale), true);
    }
}

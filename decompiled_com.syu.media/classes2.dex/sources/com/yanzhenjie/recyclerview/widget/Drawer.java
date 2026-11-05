package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class Drawer {
    private final Drawable mDivider;
    private final int mHeight;
    private final int mWidth;

    public Drawer(Drawable drawable, int i, int i2) {
        this.mDivider = drawable;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void drawLeft(View view, Canvas canvas) {
        int left = view.getLeft() - this.mWidth;
        this.mDivider.setBounds(left, view.getTop() - this.mHeight, this.mWidth + left, view.getBottom() + this.mHeight);
        this.mDivider.draw(canvas);
    }

    public void drawTop(View view, Canvas canvas) {
        int left = view.getLeft() - this.mWidth;
        int top = view.getTop() - this.mHeight;
        this.mDivider.setBounds(left, top, view.getRight() + this.mWidth, this.mHeight + top);
        this.mDivider.draw(canvas);
    }

    public void drawRight(View view, Canvas canvas) {
        int right = view.getRight();
        this.mDivider.setBounds(right, view.getTop() - this.mHeight, this.mWidth + right, view.getBottom() + this.mHeight);
        this.mDivider.draw(canvas);
    }

    public void drawBottom(View view, Canvas canvas) {
        int left = view.getLeft() - this.mWidth;
        int bottom = view.getBottom();
        this.mDivider.setBounds(left, bottom, view.getRight() + this.mWidth, this.mHeight + bottom);
        this.mDivider.draw(canvas);
    }
}

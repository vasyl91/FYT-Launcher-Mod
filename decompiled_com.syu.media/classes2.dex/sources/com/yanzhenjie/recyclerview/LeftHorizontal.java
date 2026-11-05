package com.yanzhenjie.recyclerview;

import android.view.View;
import android.widget.OverScroller;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class LeftHorizontal extends Horizontal {
    public LeftHorizontal(View view) {
        super(1, view);
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    public boolean isMenuOpen(int i) {
        int direction = (-getMenuView().getWidth()) * getDirection();
        return i <= direction && direction != 0;
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    public boolean isMenuOpenNotEqual(int i) {
        return i < (-getMenuView().getWidth()) * getDirection();
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    public void autoOpenMenu(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(Math.abs(i), 0, getMenuView().getWidth() - Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    public void autoCloseMenu(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(-Math.abs(i), 0, Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    public Horizontal.Checker checkXY(int i, int i2) {
        this.mChecker.x = i;
        this.mChecker.y = i2;
        this.mChecker.shouldResetSwipe = false;
        if (this.mChecker.x == 0) {
            this.mChecker.shouldResetSwipe = true;
        }
        if (this.mChecker.x >= 0) {
            this.mChecker.x = 0;
        }
        if (this.mChecker.x <= (-getMenuView().getWidth())) {
            this.mChecker.x = -getMenuView().getWidth();
        }
        return this.mChecker;
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    public boolean isClickOnContentView(int i, float f) {
        return f > ((float) getMenuView().getWidth());
    }
}

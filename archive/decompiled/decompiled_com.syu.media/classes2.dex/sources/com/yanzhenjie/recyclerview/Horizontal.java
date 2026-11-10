package com.yanzhenjie.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class Horizontal {
    private int direction;
    protected Checker mChecker = new Checker();
    private View menuView;

    public static final class Checker {
        public boolean shouldResetSwipe;
        public int x;
        public int y;
    }

    public abstract void autoCloseMenu(OverScroller overScroller, int i, int i2);

    public abstract void autoOpenMenu(OverScroller overScroller, int i, int i2);

    public abstract Checker checkXY(int i, int i2);

    public abstract boolean isClickOnContentView(int i, float f);

    public abstract boolean isMenuOpen(int i);

    public abstract boolean isMenuOpenNotEqual(int i);

    public Horizontal(int i, View view) {
        this.direction = i;
        this.menuView = view;
    }

    public boolean canSwipe() {
        View view = this.menuView;
        return (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0;
    }

    public boolean isCompleteClose(int i) {
        return i == 0 && (-getMenuView().getWidth()) * getDirection() != 0;
    }

    public int getDirection() {
        return this.direction;
    }

    public View getMenuView() {
        return this.menuView;
    }

    public int getMenuWidth() {
        return this.menuView.getWidth();
    }
}

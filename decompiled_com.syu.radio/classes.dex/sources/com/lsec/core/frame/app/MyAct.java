package com.lsec.core.frame.app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class MyAct {
    public HashMap<String, Drawable> mDrawables = new HashMap<>();
    public MyActivity myActivity;
    public MyUi ui;

    public abstract MyApp getMyApp();

    public abstract boolean includePage(int i);

    public abstract void onCreate(MyActivity myActivity);

    public abstract void onPause();

    public abstract void onResume();

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent, MyActivity act) {
    }

    public void onTouchEvent(MotionEvent event) {
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    public int getRightPage(int idPageTo) {
        return idPageTo;
    }

    public void doActionWhenGoPage(int idPageTo) {
    }

    public void doActionBeforeGoPage(int idPageTo) {
    }

    public void addChild2Parent(ViewGroup viewParent) {
    }

    public void removeChildFromParent(ViewGroup viewParent) {
    }

    public void setTransParentWindow(int idPageTo) {
        boolean bTrans = isTransparentPage(idPageTo);
        this.myActivity.setTransParentWindow(bTrans);
    }

    public boolean isTransparentPage(int idPageTo) {
        return false;
    }

    public Drawable getBackground() throws Throwable {
        Drawable drawable = this.ui.getDrawableFromPath("bitmap_bk", this.mDrawables, this.mDrawables);
        return drawable;
    }
}

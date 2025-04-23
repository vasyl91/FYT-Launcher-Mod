package com.fyt.skin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.android.launcher66.LauncherApplication;

public class SkinUtils {
    public static LauncherApplication getCtx() {
        getSkinManager();
        return SkinManager.getContext();
    }

    public static SkinManager getSkinManager() {
        return SkinManager.getInstance();
    }

    public static SkinResources getSkinResources() {
        return getSkinManager().getSkinResources();
    }

    public static Resources getResources() {
        return getSkinManager().getResources();
    }

    public static String getPackageName() {
        return getSkinManager().getPackageName();
    }

    public static int getId(int resid) {
        return getSkinManager().getIdentifier(resid);
    }

    public static Bitmap getBitmap(int resid) {
        return getSkinManager().getBitmap(resid);
    }

    public static Drawable getDrawable(int resid) {
        return getSkinManager().getDrawable(resid);
    }

    public static SkinAttribute getSkinAttr() {
        return getSkinManager().getSkinAttr();
    }

    public static void loadSkin(String resPath) {
        getSkinManager().loadSkin(resPath);
    }

    public static void clearSkin() {
        getSkinManager().clearSkin();
    }
}

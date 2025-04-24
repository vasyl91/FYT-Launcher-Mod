package com.syu.util;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.android.launcher66.LauncherApplication;

import java.io.IOException;

public class ToolkitRes {
    public static Drawable loadDrawable(String fileName) {
        try {
            return new BitmapDrawable(LauncherApplication.sApp.getResources(), BitmapFactory.decodeStream(LauncherApplication.getAssetManager().open(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return new ColorDrawable(0);
        }
    }
}

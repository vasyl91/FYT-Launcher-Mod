package com.syu.carinfo.rzc.mingjueruiteng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressWarnings({"deprecation", "unchecked"})
public class PackView {
    private View view;
    int mWidth = 266;
    int mHeight = 244;

    public PackView(Context context, int resId) {
        if (resId > 0) {
            this.view = LayoutInflater.from(context).inflate(resId, (ViewGroup) null);
        }
    }

    public View getView() {
        return this.view;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}

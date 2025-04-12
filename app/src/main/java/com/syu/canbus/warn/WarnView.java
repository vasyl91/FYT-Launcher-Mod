package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class WarnView {
    private View view;
    int mWidth = 300;
    int mHeight = 250;

    public WarnView(Context context, int resId) {
        if (resId > 0) {
            this.view = LayoutInflater.from(context).inflate(resId, null);
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

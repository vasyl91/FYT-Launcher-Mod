package com.syu.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class marqueeText extends TextView {
    public marqueeText(Context context) {
        super(context);
    }

    public marqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public marqueeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }
}

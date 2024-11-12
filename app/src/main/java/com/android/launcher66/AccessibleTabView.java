package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class AccessibleTabView extends TextView {
    public AccessibleTabView(Context context) {
        super(context);
    }

    public AccessibleTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AccessibleTabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return FocusHelper.handleTabKeyEvent(this, keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return FocusHelper.handleTabKeyEvent(this, keyCode, event) || super.onKeyUp(keyCode, event);
    }
}

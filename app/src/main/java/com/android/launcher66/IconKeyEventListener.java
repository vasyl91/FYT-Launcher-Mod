package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: FocusHelper.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class IconKeyEventListener implements View.OnKeyListener {
    IconKeyEventListener() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleIconKeyEvent(v, keyCode, event);
    }
}

package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: FocusHelper.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class AppsCustomizeTabKeyEventListener implements View.OnKeyListener {
    AppsCustomizeTabKeyEventListener() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleAppsCustomizeTabKeyEvent(v, keyCode, event);
    }
}

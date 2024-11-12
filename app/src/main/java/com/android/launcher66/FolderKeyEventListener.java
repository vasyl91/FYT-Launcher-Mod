package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: FocusHelper.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class FolderKeyEventListener implements View.OnKeyListener {
    FolderKeyEventListener() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleFolderKeyEvent(v, keyCode, event);
    }
}

package com.android.launcher66;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: FocusHelper.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class HotseatIconKeyEventListener implements View.OnKeyListener {
    HotseatIconKeyEventListener() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Configuration configuration = v.getResources().getConfiguration();
        return FocusHelper.handleHotseatButtonKeyEvent(v, keyCode, event, configuration.orientation);
    }
}

package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: FocusHelper.java */
class AppsCustomizeTabKeyEventListener implements View.OnKeyListener {
    AppsCustomizeTabKeyEventListener() {
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleAppsCustomizeTabKeyEvent(v, keyCode, event);
    }
}

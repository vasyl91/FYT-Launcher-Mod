package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;

class FolderKeyEventListener implements View.OnKeyListener {
    FolderKeyEventListener() {
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleFolderKeyEvent(v, keyCode, event);
    }
}

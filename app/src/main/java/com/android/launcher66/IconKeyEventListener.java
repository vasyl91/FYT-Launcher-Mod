package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;

class IconKeyEventListener implements View.OnKeyListener {
    IconKeyEventListener() {
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleIconKeyEvent(v, keyCode, event);
    }
}

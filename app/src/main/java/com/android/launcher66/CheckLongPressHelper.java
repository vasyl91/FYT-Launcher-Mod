package com.android.launcher66;

import android.util.Log;
import android.view.View;

public class CheckLongPressHelper {
    private boolean mHasPerformedLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private View mView;

    class CheckForLongPress implements Runnable {
        CheckForLongPress() {
        }

        @Override
        public void run() {
            if (CheckLongPressHelper.this.mView.getParent() != null) {
                CheckLongPressHelper.this.mView.requestFocus();
                Log.i("CheckLongPressHelper", 
                    "Has window focus: " + String.valueOf(CheckLongPressHelper.this.mView.hasWindowFocus()) + 
                    ", Performed long click: " +  String.valueOf(CheckLongPressHelper.this.mHasPerformedLongPress) + 
                    ", performLongClick(): " + String.valueOf(CheckLongPressHelper.this.mView.performLongClick()));
                if (CheckLongPressHelper.this.mView.hasWindowFocus() && !CheckLongPressHelper.this.mHasPerformedLongPress && CheckLongPressHelper.this.mView.performLongClick()) {
                    CheckLongPressHelper.this.mView.setPressed(false);
                    CheckLongPressHelper.this.mHasPerformedLongPress = true;
                }                
            }
        }
    }

    public CheckLongPressHelper(View v) {
        this.mView = v;
    }

    public void postCheckForLongPress() {
        this.mHasPerformedLongPress = false;
        if (this.mPendingCheckForLongPress == null) {
            this.mPendingCheckForLongPress = new CheckForLongPress();
        }
        this.mView.postDelayed(this.mPendingCheckForLongPress, LauncherAppState.getInstance().getLongPressTimeout());
    }

    public void cancelLongPress() {
        this.mHasPerformedLongPress = false;
        if (this.mPendingCheckForLongPress != null) {
            this.mView.removeCallbacks(this.mPendingCheckForLongPress);
            this.mPendingCheckForLongPress = null;
        }
    }

    public boolean hasPerformedLongPress() {
        return this.mHasPerformedLongPress;
    }
}

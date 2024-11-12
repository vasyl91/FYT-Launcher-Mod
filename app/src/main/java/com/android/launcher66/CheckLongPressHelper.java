package com.android.launcher66;

import android.view.View;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class CheckLongPressHelper {
    private boolean mHasPerformedLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private View mView;

    class CheckForLongPress implements Runnable {
        CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CheckLongPressHelper.this.mView.getParent() != null && CheckLongPressHelper.this.mView.hasWindowFocus() && !CheckLongPressHelper.this.mHasPerformedLongPress && CheckLongPressHelper.this.mView.performLongClick()) {
                CheckLongPressHelper.this.mView.setPressed(false);
                CheckLongPressHelper.this.mHasPerformedLongPress = true;
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

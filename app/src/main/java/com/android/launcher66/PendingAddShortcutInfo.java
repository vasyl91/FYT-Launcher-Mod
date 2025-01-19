package com.android.launcher66;

import android.content.pm.ActivityInfo;

import androidx.annotation.NonNull;

/* compiled from: PendingAddItemInfo.java */
class PendingAddShortcutInfo extends PendingAddItemInfo {
    ActivityInfo shortcutActivityInfo;

    public PendingAddShortcutInfo(ActivityInfo activityInfo) {
        this.shortcutActivityInfo = activityInfo;
    }

    @NonNull
    @Override
    public String toString() {
        return "Shortcut: " + this.shortcutActivityInfo.packageName;
    }
}

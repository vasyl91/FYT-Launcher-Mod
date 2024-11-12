package com.android.launcher66;

import android.content.pm.ActivityInfo;

import androidx.annotation.NonNull;

/* compiled from: PendingAddItemInfo.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class PendingAddShortcutInfo extends PendingAddItemInfo {
    ActivityInfo shortcutActivityInfo;

    public PendingAddShortcutInfo(ActivityInfo activityInfo) {
        this.shortcutActivityInfo = activityInfo;
    }

    @NonNull
    @Override // com.android.launcher66.ItemInfo
    public String toString() {
        return "Shortcut: " + this.shortcutActivityInfo.packageName;
    }
}

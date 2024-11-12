package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class PackageChangedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String packageName = intent.getData().getSchemeSpecificPart();
        if (packageName != null && packageName.length() != 0) {
            LauncherAppState.setApplicationContext(context.getApplicationContext());
            LauncherAppState app = LauncherAppState.getInstance();
            WidgetPreviewLoader.removePackageFromDb(app.getWidgetPreviewCacheDb(), packageName);
        }
    }
}

package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.syu.util.FytPackage;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class PreloadReceiver extends BroadcastReceiver {
    public static final String EXTRA_WORKSPACE_NAME = "com.android.launcher66.action.EXTRA_WORKSPACE_NAME";
    private static final boolean LOGD = false;
    private static final String TAG = "Launcher.PreloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        final LauncherProvider provider = LauncherAppState.getLauncherProvider();
        if (provider != null) {
            String name = intent.getStringExtra(EXTRA_WORKSPACE_NAME);
            final int workspaceResId = !TextUtils.isEmpty(name) ? context.getResources().getIdentifier(name, "xml", FytPackage.AppAction) : 0;
            new Thread(new Runnable() { // from class: com.android.launcher66.PreloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    provider.loadDefaultFavoritesIfNecessary(workspaceResId);
                }
            }).start();
        }
    }
}

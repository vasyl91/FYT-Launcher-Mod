package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ShareCompatICS {
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    ShareCompatICS() {
    }

    public static void configureMenuItem(MenuItem item, Activity callingActivity, Intent intent) {
        ShareActionProvider provider;
        ActionProvider itemProvider = item.getActionProvider();
        if (!(itemProvider instanceof ShareActionProvider)) {
            provider = new ShareActionProvider(callingActivity);
        } else {
            provider = (ShareActionProvider) itemProvider;
        }
        provider.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + callingActivity.getClass().getName());
        provider.setShareIntent(intent);
        item.setActionProvider(provider);
    }
}

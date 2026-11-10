package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class TaskStackBuilderJellybean {
    TaskStackBuilderJellybean() {
    }

    public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode, Intent[] intents, int flags, Bundle options) {
        return PendingIntent.getActivities(context, requestCode, intents, flags, options);
    }
}

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class NotificationCompatGingerbread {
    NotificationCompatGingerbread() {
    }

    public static Notification add(Notification notification, Context context, CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent, PendingIntent fullScreenIntent) {
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.fullScreenIntent = fullScreenIntent;
        return notification;
    }
}

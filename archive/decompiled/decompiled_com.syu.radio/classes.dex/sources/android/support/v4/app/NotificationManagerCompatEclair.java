package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class NotificationManagerCompatEclair {
    NotificationManagerCompatEclair() {
    }

    static void cancelNotification(NotificationManager notificationManager, String tag, int id) {
        notificationManager.cancel(tag, id);
    }

    public static void postNotification(NotificationManager notificationManager, String tag, int id, Notification notification) {
        notificationManager.notify(tag, id, notification);
    }
}

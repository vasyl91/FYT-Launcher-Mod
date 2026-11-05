package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class NotificationCompatBase {

    public static abstract class Action {

        public interface Factory {
            Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr);

            Action[] newArray(int i);
        }

        protected abstract PendingIntent getActionIntent();

        protected abstract Bundle getExtras();

        protected abstract int getIcon();

        protected abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();

        protected abstract CharSequence getTitle();
    }

    NotificationCompatBase() {
    }
}

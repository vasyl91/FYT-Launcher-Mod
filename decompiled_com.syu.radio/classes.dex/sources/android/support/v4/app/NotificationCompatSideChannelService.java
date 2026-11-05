package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {
    private static final int BUILD_VERSION_CODE_KITKAT_WATCH = 20;

    public abstract void cancel(String str, int i, String str2);

    public abstract void cancelAll(String str);

    public abstract void notify(String str, int i, String str2, Notification notification);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL) || Build.VERSION.SDK_INT >= 20) {
            return null;
        }
        return new NotificationSideChannelStub();
    }

    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        private NotificationSideChannelStub() {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String packageName, int id, String tag, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), packageName);
            long idToken = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.notify(packageName, id, tag, notification);
            } finally {
                restoreCallingIdentity(idToken);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String packageName, int id, String tag) throws RemoteException {
            NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), packageName);
            long idToken = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancel(packageName, id, tag);
            } finally {
                restoreCallingIdentity(idToken);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String packageName) {
            NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), packageName);
            long idToken = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancelAll(packageName);
            } finally {
                restoreCallingIdentity(idToken);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission(int callingUid, String packageName) {
        String[] arr$ = getPackageManager().getPackagesForUid(callingUid);
        for (String validPackage : arr$) {
            if (validPackage.equals(packageName)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + callingUid + " is not authorized for package " + packageName);
    }
}

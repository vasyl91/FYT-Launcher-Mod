package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
    private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks = new SparseArray<>();
    private static int mNextId = 1;

    public static ComponentName startWakefulService(Context context, Intent intent) {
        ComponentName comp;
        synchronized (mActiveWakeLocks) {
            int id = mNextId;
            mNextId++;
            if (mNextId <= 0) {
                mNextId = 1;
            }
            intent.putExtra(EXTRA_WAKE_LOCK_ID, id);
            comp = context.startService(intent);
            if (comp == null) {
                comp = null;
            } else {
                PowerManager pm = (PowerManager) context.getSystemService("power");
                PowerManager.WakeLock wl = pm.newWakeLock(1, "wake:" + comp.flattenToShortString());
                wl.setReferenceCounted(false);
                wl.acquire(60000L);
                mActiveWakeLocks.put(id, wl);
            }
        }
        return comp;
    }

    public static boolean completeWakefulIntent(Intent intent) {
        boolean z = true;
        z = false;
        int id = intent.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (id != 0) {
            synchronized (mActiveWakeLocks) {
                PowerManager.WakeLock wl = mActiveWakeLocks.get(id);
                if (wl != null) {
                    wl.release();
                    mActiveWakeLocks.remove(id);
                } else {
                    Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + id);
                }
            }
        }
        return z;
    }
}

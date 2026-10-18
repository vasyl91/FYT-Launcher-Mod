package com.syu.util;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.vdhost.VdHostProtocol;

/**
 * Removes the PiP panes when HiCar or the 360° camera comes to the front, for a launcher on an
 * FYT unit that is not the system one. Launcher.onPause() asks getRunningAppProcesses() for
 * them, which then lists only the launcher's own process; the VD host (root or Shizuku) watches
 * the task stack instead and reports the app in front (see VdHostProtocol.Proxy.watchForeground()).
 */
public final class PaneYieldWatcher {

    private static final String TAG = "PaneYieldWatcher";
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    private static HostCallback sCallback;

    private PaneYieldWatcher() {
    }

    /** Main thread; once per process is enough, later calls do nothing. */
    public static void start() {
        if (sCallback != null || LauncherApplication.hasSystemPrivileges()
                || !LauncherApplication.isFytDevice()) {
            return;
        }
        sCallback = new HostCallback();
        // A host that attaches later, or comes back after it died (its watchers die with it)
        WindowHostVdClient.addListener(available -> {
            if (available) watch();
        });
        watch();
    }

    private static void watch() {
        try {
            if (WindowHostVdClient.watchForeground(sCallback)) {
                Log.i(TAG, "the VD host reports HiCar and the 360° camera coming to the front");
            }
        } catch (Throwable t) {
            Log.w(TAG, "The VD host cannot report the foreground app: " + t);
        }
    }

    /** What the VD host calls with the app in front (VdHostProtocol.FOREGROUND_CHANGED). */
    private static final class HostCallback extends Binder {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != VdHostProtocol.FOREGROUND_CHANGED) {
                return super.onTransact(code, data, reply, flags);
            }
            String packageName = data.readString();
            if (FytPackage.hicarAction.equals(packageName)
                    || FytPackage.fourcamera2Action.equals(packageName)) {
                Log.i(TAG, packageName + " in front: the panes are removed");
                MAIN.post(WindowUtil::removePip);
            }
            return true;
        }
    }
}

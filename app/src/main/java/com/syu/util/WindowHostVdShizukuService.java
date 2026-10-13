package com.syu.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.syu.vdhost.VdHostCore;
import com.syu.vdhost.VdHostStub;

/**
 * The VD host as a Shizuku UserService (see WindowHostVdShizuku).
 *
 * Shizuku starts this class from the launcher's APK in a process of its own, with Shizuku's uid:
 * 2000 (shell) when Shizuku was started over ADB, 0 when it runs with root. It never runs in the
 * launcher process.
 */
public class WindowHostVdShizukuService extends VdHostStub {
    private static final String TAG = "FytVdHost";

    /** IUserService.destroy(): Shizuku sends it when the service is unbound with remove = true. */
    private static final int TX_SHIZUKU_DESTROY = 16777115;

    /** Shizuku 13+ passes the launcher's package Context. */
    public WindowHostVdShizukuService(Context context) {
        super(new VdHostCore(context, packageForUid(Process.myUid())), callerPolicy(context));
        Log.i(TAG, "Shizuku VD host started: uid=" + Process.myUid() + " pid=" + Process.myPid());
    }

    /**
     * DisplayManagerService only creates displays for a package of the calling uid. The service
     * runs the launcher's code but not as the launcher, so it has to name its own uid's package.
     * (Root has none; Android 14+ lets root through anyway, older versions refuse it.)
     */
    private static String packageForUid(int uid) {
        return uid == Process.SYSTEM_UID ? "android" : "com.android.shell";
    }

    /** Only the launcher that bound us (plus root and system) may use the host. */
    private static CallerPolicy callerPolicy(Context context) {
        final int launcherUid = context.getApplicationInfo() != null ? context.getApplicationInfo().uid : -1;
        return uid -> uid == launcherUid || uid == 0 || uid == Process.SYSTEM_UID;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (code == TX_SHIZUKU_DESTROY) {
            Log.i(TAG, "Shizuku VD host destroyed");
            System.exit(0);
            return true;
        }
        return super.onTransact(code, data, reply, flags);
    }
}

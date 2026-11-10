package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        int type = info.getType();
        switch (type) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return true;
            case 1:
                return false;
        }
    }
}

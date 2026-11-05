package android.support.v4.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File path) {
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return EnvironmentCompatKitKat.getStorageState(path);
        }
        try {
            String canonicalPath = path.getCanonicalPath();
            String canonicalExternal = Environment.getExternalStorageDirectory().getCanonicalPath();
            if (canonicalPath.startsWith(canonicalExternal)) {
                return Environment.getExternalStorageState();
            }
        } catch (IOException e) {
            Log.w(TAG, "Failed to resolve canonical path: " + e);
        }
        return MEDIA_UNKNOWN;
    }
}

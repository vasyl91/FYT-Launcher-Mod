package qin.widgets.layoutmanager;

import android.util.Log;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class PagerConfig {
    public static boolean a = false;
    public static int b = 1000;
    public static float c = 60.0f;

    public static void Loge(String str) {
        if (isShowLog()) {
            Log.e("PagerGrid", str);
        }
    }

    public static void Logi(String str) {
        if (isShowLog()) {
            Log.i("PagerGrid", str);
        }
    }

    public static int getFlingThreshold() {
        return b;
    }

    public static float getMillisecondsPreInch() {
        return c;
    }

    public static boolean isShowLog() {
        return a;
    }

    public static void setFlingThreshold(int i) {
        b = i;
    }

    public static void setMillisecondsPreInch(float f) {
        c = f;
    }

    public static void setShowLog(boolean z) {
        a = z;
    }
}

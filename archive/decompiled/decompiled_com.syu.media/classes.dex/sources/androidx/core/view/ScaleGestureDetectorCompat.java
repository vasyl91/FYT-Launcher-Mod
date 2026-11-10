package androidx.core.view;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z);
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
        scaleGestureDetector.setQuickScaleEnabled(z);
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }
}

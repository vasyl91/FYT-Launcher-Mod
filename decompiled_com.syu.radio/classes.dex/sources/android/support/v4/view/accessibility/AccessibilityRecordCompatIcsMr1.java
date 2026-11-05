package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class AccessibilityRecordCompatIcsMr1 {
    AccessibilityRecordCompatIcsMr1() {
    }

    public static int getMaxScrollX(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollX();
    }

    public static int getMaxScrollY(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollY();
    }

    public static void setMaxScrollX(Object record, int maxScrollX) {
        ((AccessibilityRecord) record).setMaxScrollX(maxScrollX);
    }

    public static void setMaxScrollY(Object record, int maxScrollY) {
        ((AccessibilityRecord) record).setMaxScrollY(maxScrollY);
    }
}

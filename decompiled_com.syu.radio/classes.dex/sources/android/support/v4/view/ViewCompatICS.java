package android.support.v4.view;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ViewCompatICS {
    ViewCompatICS() {
    }

    public static boolean canScrollHorizontally(View v, int direction) {
        return v.canScrollHorizontally(direction);
    }

    public static boolean canScrollVertically(View v, int direction) {
        return v.canScrollVertically(direction);
    }

    public static void setAccessibilityDelegate(View v, Object delegate) {
        v.setAccessibilityDelegate((View.AccessibilityDelegate) delegate);
    }

    public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        v.onPopulateAccessibilityEvent(event);
    }

    public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        v.onInitializeAccessibilityEvent(event);
    }

    public static void onInitializeAccessibilityNodeInfo(View v, Object info) {
        v.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) info);
    }
}

package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        viewGroup.setLayoutMode(i);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }
}

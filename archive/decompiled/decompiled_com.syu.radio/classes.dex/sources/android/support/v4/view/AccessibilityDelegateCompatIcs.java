package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class AccessibilityDelegateCompatIcs {

    public interface AccessibilityDelegateBridge {
        boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, Object obj);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void sendAccessibilityEvent(View view, int i);

        void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatIcs() {
    }

    public static Object newAccessibilityDelegateDefaultImpl() {
        return new View.AccessibilityDelegate();
    }

    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridge bridge) {
        return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompatIcs.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                return bridge.dispatchPopulateAccessibilityEvent(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                bridge.onInitializeAccessibilityEvent(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                bridge.onInitializeAccessibilityNodeInfo(host, info);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                bridge.onPopulateAccessibilityEvent(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
                return bridge.onRequestSendAccessibilityEvent(host, child, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View host, int eventType) {
                bridge.sendAccessibilityEvent(host, eventType);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                bridge.sendAccessibilityEventUnchecked(host, event);
            }
        };
    }

    public static boolean dispatchPopulateAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
        return ((View.AccessibilityDelegate) delegate).dispatchPopulateAccessibilityEvent(host, event);
    }

    public static void onInitializeAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
        ((View.AccessibilityDelegate) delegate).onInitializeAccessibilityEvent(host, event);
    }

    public static void onInitializeAccessibilityNodeInfo(Object delegate, View host, Object info) {
        ((View.AccessibilityDelegate) delegate).onInitializeAccessibilityNodeInfo(host, (AccessibilityNodeInfo) info);
    }

    public static void onPopulateAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
        ((View.AccessibilityDelegate) delegate).onPopulateAccessibilityEvent(host, event);
    }

    public static boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
        return ((View.AccessibilityDelegate) delegate).onRequestSendAccessibilityEvent(host, child, event);
    }

    public static void sendAccessibilityEvent(Object delegate, View host, int eventType) {
        ((View.AccessibilityDelegate) delegate).sendAccessibilityEvent(host, eventType);
    }

    public static void sendAccessibilityEventUnchecked(Object delegate, View host, AccessibilityEvent event) {
        ((View.AccessibilityDelegate) delegate).sendAccessibilityEventUnchecked(host, event);
    }
}

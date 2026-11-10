package android.support.v4.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class MotionEventCompatEclair {
    MotionEventCompatEclair() {
    }

    public static int findPointerIndex(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }

    public static int getPointerId(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }

    public static float getX(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }

    public static float getY(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }

    public static int getPointerCount(MotionEvent event) {
        return event.getPointerCount();
    }
}

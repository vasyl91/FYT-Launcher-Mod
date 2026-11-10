package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ViewCompatJellybeanMr1 {
    ViewCompatJellybeanMr1() {
    }

    public static int getLabelFor(View view) {
        return view.getLabelFor();
    }

    public static void setLabelFor(View view, int id) {
        view.setLabelFor(id);
    }

    public static void setLayerPaint(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    public static void setLayoutDirection(View view, int layoutDirection) {
        view.setLayoutDirection(layoutDirection);
    }

    public static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    public static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    public static void setPaddingRelative(View view, int start, int top, int end, int bottom) {
        view.setPaddingRelative(start, top, end, bottom);
    }
}

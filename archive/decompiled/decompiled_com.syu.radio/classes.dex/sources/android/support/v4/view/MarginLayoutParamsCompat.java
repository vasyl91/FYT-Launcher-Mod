package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MarginLayoutParamsCompat {
    static final MarginLayoutParamsCompatImpl IMPL;

    interface MarginLayoutParamsCompatImpl {
        int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams);

        int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams);

        int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams);

        boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams);

        void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i);
    }

    static class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplBase() {
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public int getMarginStart(ViewGroup.MarginLayoutParams lp) {
            return lp.leftMargin;
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
            return lp.rightMargin;
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
            lp.leftMargin = marginStart;
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
            lp.rightMargin = marginEnd;
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
            return false;
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
            return 0;
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        }
    }

    static class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplJbMr1() {
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public int getMarginStart(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(lp);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(lp);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginStart(lp, marginStart);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(lp, marginEnd);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(lp);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(lp);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
            MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(lp, layoutDirection);
        }

        @Override // android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
        public void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
            MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(lp, layoutDirection);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 17) {
            IMPL = new MarginLayoutParamsCompatImplJbMr1();
        } else {
            IMPL = new MarginLayoutParamsCompatImplBase();
        }
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams lp) {
        return IMPL.getMarginStart(lp);
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
        return IMPL.getMarginEnd(lp);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
        IMPL.setMarginStart(lp, marginStart);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
        IMPL.setMarginEnd(lp, marginEnd);
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
        return IMPL.isMarginRelative(lp);
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
        return IMPL.getLayoutDirection(lp);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        IMPL.setLayoutDirection(lp, layoutDirection);
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        IMPL.resolveLayoutDirection(lp, layoutDirection);
    }
}

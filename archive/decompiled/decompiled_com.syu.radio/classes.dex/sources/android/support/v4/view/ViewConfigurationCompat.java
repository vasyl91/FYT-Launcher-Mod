package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL;

    interface ViewConfigurationVersionImpl {
        int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration);
    }

    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return config.getScaledTouchSlop();
        }
    }

    static class FroyoViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return IMPL.getScaledPagingTouchSlop(config);
    }
}

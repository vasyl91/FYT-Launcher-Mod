package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    public static int getSlotIndex(int i) {
        if (i == -1) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getSlotIndex(i);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                Method declaredMethod = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                sGetSlotIndexMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }

    private SubscriptionManagerCompat() {
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static int getSlotIndex(int i) {
            return SubscriptionManager.getSlotIndex(i);
        }
    }
}

package androidx.core.location;

import android.location.Location;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
    }

    public static long getElapsedRealtimeNanos(Location location) {
        return Api17Impl.getElapsedRealtimeNanos(location);
    }

    public static long getElapsedRealtimeMillis(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(location));
    }

    public static boolean hasVerticalAccuracy(Location location) {
        return Api26Impl.hasVerticalAccuracy(location);
    }

    public static float getVerticalAccuracyMeters(Location location) {
        return Api26Impl.getVerticalAccuracyMeters(location);
    }

    public static void setVerticalAccuracyMeters(Location location, float f) {
        Api26Impl.setVerticalAccuracyMeters(location, f);
    }

    public static boolean hasSpeedAccuracy(Location location) {
        return Api26Impl.hasSpeedAccuracy(location);
    }

    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
    }

    public static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
        Api26Impl.setSpeedAccuracyMetersPerSecond(location, f);
    }

    public static boolean hasBearingAccuracy(Location location) {
        return Api26Impl.hasBearingAccuracy(location);
    }

    public static float getBearingAccuracyDegrees(Location location) {
        return Api26Impl.getBearingAccuracyDegrees(location);
    }

    public static void setBearingAccuracyDegrees(Location location, float f) {
        Api26Impl.setBearingAccuracyDegrees(location, f);
    }

    public static boolean isMock(Location location) {
        return Api18Impl.isMock(location);
    }

    public static void setMock(Location location, boolean z) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, Boolean.valueOf(z));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (NoSuchMethodException e2) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e2);
            throw noSuchMethodError;
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static void setVerticalAccuracyMeters(Location location, float f) {
            location.setVerticalAccuracyMeters(f);
        }

        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
            location.setSpeedAccuracyMetersPerSecond(f);
        }

        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        static void setBearingAccuracyDegrees(Location location, float f) {
            location.setBearingAccuracyDegrees(f);
        }
    }

    private static class Api18Impl {
        private Api18Impl() {
        }

        static boolean isMock(Location location) {
            return location.isFromMockProvider();
        }
    }

    private static class Api17Impl {
        private Api17Impl() {
        }

        static long getElapsedRealtimeNanos(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }
}

package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    static final WeakHashMap<LocationListener, List<WeakReference<LocationListenerTransport>>> sLocationListeners = new WeakHashMap<>();
    private static Method sRequestLocationUpdatesExecutorMethod;
    private static Method sRequestLocationUpdatesLooperMethod;

    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    public static boolean hasProvider(LocationManager locationManager, String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.hasProvider(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            return locationManager.getProvider(str) != null;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static void getCurrentLocation(LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, final Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < MAX_CURRENT_LOCATION_AGE_MS) {
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(lastKnownLocation);
                }
            });
            return;
        }
        final CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, cancellableLocationListener, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.core.location.LocationManagerCompat.1
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    cancellableLocationListener.cancel();
                }
            });
        }
        cancellableLocationListener.startTimeout(GET_CURRENT_LOCATION_TIMEOUT_MS);
    }

    public static void requestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (sRequestLocationUpdatesExecutorMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, Executor.class, LocationListener.class);
                    sRequestLocationUpdatesExecutorMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    sRequestLocationUpdatesExecutorMethod.invoke(locationManager, locationRequest, executor, locationListenerCompat);
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
        LocationListenerTransport locationListenerTransport = new LocationListenerTransport(locationListenerCompat, executor);
        try {
            if (sRequestLocationUpdatesLooperMethod == null) {
                Method declaredMethod2 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, LocationListener.class, Looper.class);
                sRequestLocationUpdatesLooperMethod = declaredMethod2;
                declaredMethod2.setAccessible(true);
            }
            LocationRequest locationRequest2 = locationRequestCompat.toLocationRequest(str);
            if (locationRequest2 != null) {
                synchronized (sLocationListeners) {
                    sRequestLocationUpdatesLooperMethod.invoke(locationManager, locationRequest2, locationListenerTransport, Looper.getMainLooper());
                    locationListenerTransport.register();
                }
                return;
            }
        } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused2) {
        }
        synchronized (sLocationListeners) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerTransport, Looper.getMainLooper());
            locationListenerTransport.register();
        }
    }

    public static void requestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
            return;
        }
        try {
            if (sRequestLocationUpdatesLooperMethod == null) {
                Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, LocationListener.class, Looper.class);
                sRequestLocationUpdatesLooperMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            try {
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    sRequestLocationUpdatesLooperMethod.invoke(locationManager, locationRequest, locationListenerCompat, looper);
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused2) {
        }
        locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
    }

    public static void removeUpdates(LocationManager locationManager, LocationListenerCompat locationListenerCompat) {
        WeakHashMap<LocationListener, List<WeakReference<LocationListenerTransport>>> weakHashMap = sLocationListeners;
        synchronized (weakHashMap) {
            List<WeakReference<LocationListenerTransport>> listRemove = weakHashMap.remove(locationListenerCompat);
            if (listRemove != null) {
                Iterator<WeakReference<LocationListenerTransport>> it = listRemove.iterator();
                while (it.hasNext()) {
                    LocationListenerTransport locationListenerTransport = it.next().get();
                    if (locationListenerTransport != null && locationListenerTransport.unregister()) {
                        locationManager.removeUpdates(locationListenerTransport);
                    }
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    public static String getGnssHardwareModelName(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    private static class GnssLazyLoader {
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

        private GnssLazyLoader() {
        }
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback, Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(looperMyLooper), executor, callback);
    }

    private static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            synchronized (GnssLazyLoader.sGnssStatusListeners) {
                GnssStatus.Callback gnssStatusTransport = (GnssStatusTransport) GnssLazyLoader.sGnssStatusListeners.get(callback);
                if (gnssStatusTransport == null) {
                    gnssStatusTransport = new GnssStatusTransport(callback);
                }
                if (!locationManager.registerGnssStatusCallback(executor, gnssStatusTransport)) {
                    return false;
                }
                GnssLazyLoader.sGnssStatusListeners.put(callback, gnssStatusTransport);
                return true;
            }
        }
        Preconditions.checkArgument(handler != null);
        synchronized (GnssLazyLoader.sGnssStatusListeners) {
            PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) GnssLazyLoader.sGnssStatusListeners.get(callback);
            if (preRGnssStatusTransport == null) {
                preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
            } else {
                preRGnssStatusTransport.unregister();
            }
            preRGnssStatusTransport.register(executor);
            if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                return false;
            }
            GnssLazyLoader.sGnssStatusListeners.put(callback, preRGnssStatusTransport);
            return true;
        }
    }

    public static void unregisterGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            synchronized (GnssLazyLoader.sGnssStatusListeners) {
                GnssStatus.Callback callback2 = (GnssStatusTransport) GnssLazyLoader.sGnssStatusListeners.remove(callback);
                if (callback2 != null) {
                    locationManager.unregisterGnssStatusCallback(callback2);
                }
            }
            return;
        }
        synchronized (GnssLazyLoader.sGnssStatusListeners) {
            PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) GnssLazyLoader.sGnssStatusListeners.remove(callback);
            if (preRGnssStatusTransport != null) {
                preRGnssStatusTransport.unregister();
                locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
            }
        }
    }

    private LocationManagerCompat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;
        volatile LocationListenerCompat mListener;

        LocationListenerTransport(LocationListenerCompat locationListenerCompat, Executor executor) {
            this.mListener = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
            this.mExecutor = executor;
        }

        public void register() {
            List<WeakReference<LocationListenerTransport>> arrayList = LocationManagerCompat.sLocationListeners.get(this.mListener);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                LocationManagerCompat.sLocationListeners.put(this.mListener, arrayList);
            } else {
                arrayList.removeIf(new Predicate() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda7
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return LocationManagerCompat.LocationListenerTransport.lambda$register$0((WeakReference) obj);
                    }
                });
            }
            arrayList.add(new WeakReference<>(this));
        }

        static /* synthetic */ boolean lambda$register$0(WeakReference weakReference) {
            return weakReference.get() == null;
        }

        public boolean unregister() {
            LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return false;
            }
            this.mListener = null;
            List<WeakReference<LocationListenerTransport>> list = LocationManagerCompat.sLocationListeners.get(locationListenerCompat);
            if (list == null) {
                return true;
            }
            list.removeIf(new Predicate() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return LocationManagerCompat.LocationListenerTransport.lambda$unregister$1((WeakReference) obj);
                }
            });
            if (!list.isEmpty()) {
                return true;
            }
            LocationManagerCompat.sLocationListeners.remove(locationListenerCompat);
            return true;
        }

        static /* synthetic */ boolean lambda$unregister$1(WeakReference weakReference) {
            return weakReference.get() == null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14lambda$onLocationChanged$2$androidxcorelocationLocationManagerCompat$LocationListenerTransport(locationListenerCompat, location);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onLocationChanged$2$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m14lambda$onLocationChanged$2$androidxcorelocationLocationManagerCompat$LocationListenerTransport(LocationListenerCompat locationListenerCompat, Location location) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onLocationChanged(location);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final List<Location> list) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m15lambda$onLocationChanged$3$androidxcorelocationLocationManagerCompat$LocationListenerTransport(locationListenerCompat, list);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onLocationChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m15lambda$onLocationChanged$3$androidxcorelocationLocationManagerCompat$LocationListenerTransport(LocationListenerCompat locationListenerCompat, List list) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onLocationChanged((List<Location>) list);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m13lambda$onFlushComplete$4$androidxcorelocationLocationManagerCompat$LocationListenerTransport(locationListenerCompat, i);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onFlushComplete$4$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m13lambda$onFlushComplete$4$androidxcorelocationLocationManagerCompat$LocationListenerTransport(LocationListenerCompat locationListenerCompat, int i) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onFlushComplete(i);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i, final Bundle bundle) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m18lambda$onStatusChanged$5$androidxcorelocationLocationManagerCompat$LocationListenerTransport(locationListenerCompat, str, i, bundle);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onStatusChanged$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m18lambda$onStatusChanged$5$androidxcorelocationLocationManagerCompat$LocationListenerTransport(LocationListenerCompat locationListenerCompat, String str, int i, Bundle bundle) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onStatusChanged(str, i, bundle);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String str) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m17lambda$onProviderEnabled$6$androidxcorelocationLocationManagerCompat$LocationListenerTransport(locationListenerCompat, str);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onProviderEnabled$6$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m17lambda$onProviderEnabled$6$androidxcorelocationLocationManagerCompat$LocationListenerTransport(LocationListenerCompat locationListenerCompat, String str) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onProviderEnabled(str);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String str) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m16lambda$onProviderDisabled$7$androidxcorelocationLocationManagerCompat$LocationListenerTransport(locationListenerCompat, str);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onProviderDisabled$7$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m16lambda$onProviderDisabled$7$androidxcorelocationLocationManagerCompat$LocationListenerTransport(LocationListenerCompat locationListenerCompat, String str) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onProviderDisabled(str);
        }
    }

    private static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            this.mCallback.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void register(Executor executor) {
            Preconditions.checkArgument(executor != null, "invalid null executor");
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m21lambda$onStarted$0$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(executor);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onStarted$0$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m21lambda$onStarted$0$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m22lambda$onStopped$1$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(executor);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onStopped$1$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m22lambda$onStopped$1$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i) {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m19lambda$onFirstFix$2$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(executor, i);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onFirstFix$2$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m19lambda$onFirstFix$2$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(Executor executor, int i) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m20lambda$onSatelliteStatusChanged$3$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(executor, gnssStatus);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onSatelliteStatusChanged$3$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m20lambda$onSatelliteStatusChanged$3$androidxcorelocationLocationManagerCompat$PreRGnssStatusTransport(Executor executor, GnssStatus gnssStatus) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            if (i == 1) {
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9lambda$onGpsStatusChanged$0$androidxcorelocationLocationManagerCompat$GpsStatusTransport(executor);
                    }
                });
                return;
            }
            if (i == 2) {
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m10lambda$onGpsStatusChanged$1$androidxcorelocationLocationManagerCompat$GpsStatusTransport(executor);
                    }
                });
                return;
            }
            if (i != 3) {
                if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                    final GnssStatusCompat gnssStatusCompatWrap = GnssStatusCompat.wrap(gpsStatus);
                    executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m12lambda$onGpsStatusChanged$3$androidxcorelocationLocationManagerCompat$GpsStatusTransport(executor, gnssStatusCompatWrap);
                        }
                    });
                    return;
                }
                return;
            }
            GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
            if (gpsStatus2 != null) {
                final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11lambda$onGpsStatusChanged$2$androidxcorelocationLocationManagerCompat$GpsStatusTransport(executor, timeToFirstFix);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$0$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m9lambda$onGpsStatusChanged$0$androidxcorelocationLocationManagerCompat$GpsStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStarted();
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$1$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m10lambda$onGpsStatusChanged$1$androidxcorelocationLocationManagerCompat$GpsStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStopped();
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$2$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m11lambda$onGpsStatusChanged$2$androidxcorelocationLocationManagerCompat$GpsStatusTransport(Executor executor, int i) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onFirstFix(i);
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$3$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m12lambda$onGpsStatusChanged$3$androidxcorelocationLocationManagerCompat$GpsStatusTransport(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onSatelliteStatusChanged(gnssStatusCompat);
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        static boolean hasProvider(LocationManager locationManager, String str) {
            return locationManager.hasProvider(str);
        }

        static void requestLocationUpdates(LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static void getCurrentLocation(LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, final Consumer<Location> consumer) {
            android.os.CancellationSignal cancellationSignal2 = cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null;
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal2, executor, new java.util.function.Consumer() { // from class: androidx.core.location.LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    consumer.accept((Location) obj);
                }
            });
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }

        static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        public void cancel() {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                cleanup();
            }
        }

        public void startTimeout(long j) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CancellableLocationListener.this.mTimeoutRunnable = null;
                        CancellableLocationListener.this.onLocationChanged((Location) null);
                    }
                };
                this.mTimeoutRunnable = runnable;
                this.mTimeoutHandler.postDelayed(runnable, j);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                final Consumer<Location> consumer = this.mConsumer;
                this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        consumer.accept(location);
                    }
                });
                cleanup();
            }
        }

        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }
}

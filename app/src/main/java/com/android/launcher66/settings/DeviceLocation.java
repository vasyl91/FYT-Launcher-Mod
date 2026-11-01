package com.android.launcher66.settings;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * The device's position, from the platform first. Callers see no Google type: GmsLocation, the
 * only class that refers to Play services, is not loaded unless the platform has nothing and Play
 * services are installed. Needs the location permissions, which the callers check.
 */
public final class DeviceLocation {
    private static final String TAG = "DeviceLocation";
    private static final String PLAY_SERVICES = "com.google.android.gms";
    private static final String[] LAST_KNOWN_PROVIDERS = {
            LocationManager.GPS_PROVIDER, LocationManager.NETWORK_PROVIDER, LocationManager.PASSIVE_PROVIDER};

    private DeviceLocation() {}

    /** A position, or null when there is none. */
    public interface Receiver {
        void onLocation(Location location);
    }

    /** Ends a request for updates. */
    public interface Handle {
        void remove();
    }

    private static volatile Boolean sPlayInstalled;

    /** Whether Google Play services are installed and on, found once per process. */
    static boolean playServicesInstalled(Context context) {
        Boolean known = sPlayInstalled;
        if (known == null) {
            boolean installed;
            try {
                ApplicationInfo info = context.getApplicationContext().getPackageManager()
                        .getApplicationInfo(PLAY_SERVICES, 0);
                installed = info.enabled;
            } catch (PackageManager.NameNotFoundException e) {
                installed = false;
            }
            sPlayInstalled = installed;
            Log.i(TAG, "Google Play services " + (installed ? "installed" : "not installed"));
            known = installed;
        }
        return known;
    }

    /**
     * The last known position, delivered on the main thread after the calling method has returned
     * (null when none can be had), as the Play services' task did.
     */
    public static void lastKnown(Context context, Receiver receiver) {
        final Context app = context.getApplicationContext();
        Location platform = platformLastKnown(app);
        switch (LocationChoice.forLastKnown(platform != null, playServicesInstalled(app))) {
            case PLATFORM:
                deliver(receiver, platform);
                break;
            case PLAY_SERVICES:
                Log.i(TAG, "No position from the platform, asking Google Play services");
                GmsLocation.lastKnown(app, receiver);
                break;
            default:
                Log.i(TAG, "No position from the platform and no Google Play services");
                deliver(receiver, null);
                break;
        }
    }

    /**
     * Fixes as they come (about every minTimeMs), on the looper's thread; null if none can be had.
     * The platform's GPS provider when there is one.
     */
    public static Handle requestUpdates(Context context, long minTimeMs, Receiver receiver, Looper looper) {
        final Context app = context.getApplicationContext();
        final LocationManager manager = (LocationManager) app.getSystemService(Context.LOCATION_SERVICE);
        boolean hasGps = manager != null && manager.getAllProviders().contains(LocationManager.GPS_PROVIDER);
        switch (LocationChoice.forUpdates(hasGps, playServicesInstalled(app))) {
            case PLATFORM:
                try {
                    final LocationListener listener = new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            receiver.onLocation(location);
                        }

                        // abstract before Android 11
                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                        }

                        @Override
                        public void onProviderDisabled(String provider) {
                        }
                    };
                    manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTimeMs, 0f, listener, looper);
                    return () -> {
                        try {
                            manager.removeUpdates(listener);
                        } catch (RuntimeException e) {
                            Log.w(TAG, "Removing the updates failed: " + e);
                        }
                    };
                } catch (SecurityException e) {
                    Log.w(TAG, "No permission for the GPS updates: " + e);
                    return null;
                } catch (RuntimeException e) {
                    Log.w(TAG, "GPS updates not available: " + e);
                    return null;
                }
            case PLAY_SERVICES:
                Log.i(TAG, "No GPS provider, asking Google Play services");
                return GmsLocation.requestUpdates(app, minTimeMs, receiver, looper);
            default:
                Log.i(TAG, "No GPS provider and no Google Play services");
                return null;
        }
    }

    private static Location platformLastKnown(Context app) {
        LocationManager manager = (LocationManager) app.getSystemService(Context.LOCATION_SERVICE);
        if (manager == null) {
            return null;
        }
        List<Location> fixes = new ArrayList<>();
        for (String provider : LAST_KNOWN_PROVIDERS) {
            try {
                Location fix = manager.getLastKnownLocation(provider);
                if (fix != null) {
                    fixes.add(fix);
                }
            } catch (SecurityException | IllegalArgumentException e) {
                // no permission, or no such provider on this device
            }
        }
        long[] times = new long[fixes.size()];
        for (int i = 0; i < times.length; i++) {
            times[i] = fixes.get(i).getTime();
        }
        int newest = LocationChoice.newest(times);
        return newest < 0 ? null : fixes.get(newest);
    }

    private static void deliver(Receiver receiver, Location location) {
        new Handler(Looper.getMainLooper()).post(() -> receiver.onLocation(location));
    }
}

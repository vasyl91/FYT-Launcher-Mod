package com.android.launcher66.settings;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

/**
 * The only class that refers to Google Play services. DeviceLocation reaches it when the platform
 * has no position and the services are installed, so on a unit without them (or with a fix at
 * hand) none of their classes is loaded or verified.
 */
final class GmsLocation {
    private static final String TAG = "GmsLocation";

    private GmsLocation() {}

    /** Delivers on the main thread; a failure is reported as no position. */
    static void lastKnown(Context app, DeviceLocation.Receiver receiver) {
        FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(app);
        client.getLastLocation()
                .addOnSuccessListener(ContextCompat.getMainExecutor(app), receiver::onLocation)
                .addOnFailureListener(ContextCompat.getMainExecutor(app), e -> {
                    Log.w(TAG, "getLastLocation failed: " + e);
                    receiver.onLocation(null);
                });
    }

    static DeviceLocation.Handle requestUpdates(Context app, long minTimeMs, DeviceLocation.Receiver receiver,
                                                Looper looper) {
        final FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(app);
        LocationRequest request = new LocationRequest.Builder(Math.max(minTimeMs, 500L) * 2)
                .setMinUpdateIntervalMillis(minTimeMs)
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                .build();
        final LocationCallback callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult result) {
                for (Location location : result.getLocations()) {
                    receiver.onLocation(location);
                }
            }
        };
        try {
            client.requestLocationUpdates(request, callback, looper);
        } catch (RuntimeException e) {
            Log.w(TAG, "requestLocationUpdates failed: " + e);
            return null;
        }
        return () -> client.removeLocationUpdates(callback);
    }
}

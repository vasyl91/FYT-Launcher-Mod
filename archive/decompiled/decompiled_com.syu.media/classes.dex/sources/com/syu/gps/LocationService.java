package com.syu.gps;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import chip.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class LocationService extends Service implements LocationListener, OnNmeaMessageListener {
    public LocationManager a = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LocationManager locationManager = (LocationManager) getSystemService("location");
        this.a = locationManager;
        locationManager.requestLocationUpdates("gps", 1000L, 0.0f, this);
        this.a.addNmeaListener(this);
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (str.startsWith("$GPGGA")) {
            try {
                String str2 = str.split(",")[9];
                if (str2.equals(FinalChip.BSP_PLATFORM_Null)) {
                    return;
                }
                Double.parseDouble(str2);
            } catch (Exception e) {
                Log.e("NMEA", "onNmeaReceived: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}

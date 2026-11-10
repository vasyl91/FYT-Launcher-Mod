package androidx.core.location;

import android.location.LocationManager;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final /* synthetic */ class LocationManagerCompat$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ LocationManager f$0;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f$1;

    public /* synthetic */ LocationManagerCompat$$ExternalSyntheticLambda0(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.f$0 = locationManager;
        this.f$1 = gpsStatusTransport;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return Boolean.valueOf(this.f$0.addGpsStatusListener(this.f$1));
    }
}

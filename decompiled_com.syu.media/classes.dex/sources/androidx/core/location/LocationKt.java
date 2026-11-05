package androidx.core.location;

import android.location.Location;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Location.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0086\n¨\u0006\u0004"}, d2 = {"component1", FinalChip.BSP_PLATFORM_Null, "Landroid/location/Location;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class LocationKt {
    public static final double component1(Location location) {
        Intrinsics.checkParameterIsNotNull(location, "$this$component1");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        Intrinsics.checkParameterIsNotNull(location, "$this$component2");
        return location.getLongitude();
    }
}

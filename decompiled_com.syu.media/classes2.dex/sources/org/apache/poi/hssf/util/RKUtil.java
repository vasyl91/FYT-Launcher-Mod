package org.apache.poi.hssf.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RKUtil {
    private RKUtil() {
    }

    public static double decodeNumber(int i) {
        long j = ((long) i) >> 2;
        double dLongBitsToDouble = (i & 2) == 2 ? j : Double.longBitsToDouble(j << 34);
        return (i & 1) == 1 ? dLongBitsToDouble / 100.0d : dLongBitsToDouble;
    }
}

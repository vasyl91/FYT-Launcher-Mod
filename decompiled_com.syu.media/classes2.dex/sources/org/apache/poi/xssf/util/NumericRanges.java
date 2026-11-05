package org.apache.poi.xssf.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NumericRanges {
    public static final int NO_OVERLAPS = -1;
    public static final int OVERLAPS_1_MINOR = 0;
    public static final int OVERLAPS_1_WRAPS = 2;
    public static final int OVERLAPS_2_MINOR = 1;
    public static final int OVERLAPS_2_WRAPS = 3;

    public static long[] getOverlappingRange(long[] jArr, long[] jArr2) {
        int overlappingType = getOverlappingType(jArr, jArr2);
        if (overlappingType == 0) {
            return new long[]{jArr2[0], jArr[1]};
        }
        if (overlappingType == 1) {
            return new long[]{jArr[0], jArr2[1]};
        }
        if (overlappingType != 2) {
            return overlappingType != 3 ? new long[]{-1, -1} : jArr;
        }
        return jArr2;
    }

    public static int getOverlappingType(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr2[0];
        long j4 = jArr2[1];
        if (j >= j3) {
            if (j2 <= j4) {
                return 3;
            }
            return j <= j4 ? 1 : -1;
        }
        if (j2 >= j4) {
            return 2;
        }
        return j2 >= j3 ? 0 : -1;
    }
}

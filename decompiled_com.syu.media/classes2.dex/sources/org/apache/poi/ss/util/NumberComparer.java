package org.apache.poi.ss.util;

import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NumberComparer {
    private static int compareAcrossSubnormalThreshold(long j, long j2, boolean z) {
        long j3 = j2 & IEEEDouble.FRAC_MASK;
        if (j3 == 0) {
            return z ? -1 : 1;
        }
        long j4 = j & IEEEDouble.FRAC_MASK;
        if (j4 > 7 || j3 < 4503599627370490L) {
            return z ? -1 : 1;
        }
        if (j4 == 7 && j3 == 4503599627370490L) {
            return 0;
        }
        return z ? 1 : -1;
    }

    private static int compareSubnormalNumbers(long j, long j2, boolean z) {
        int i;
        if (j > j2) {
            i = 1;
        } else {
            i = j < j2 ? -1 : 0;
        }
        return z ? -i : i;
    }

    public static int compare(double d, double d2) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(d2);
        int biasedExponent = IEEEDouble.getBiasedExponent(jDoubleToLongBits);
        int biasedExponent2 = IEEEDouble.getBiasedExponent(jDoubleToLongBits2);
        if (biasedExponent == 2047) {
            throw new IllegalArgumentException("Special double values are not allowed: " + toHex(d));
        }
        if (biasedExponent2 == 2047) {
            throw new IllegalArgumentException("Special double values are not allowed: " + toHex(d));
        }
        boolean z = jDoubleToLongBits < 0;
        if (z != (jDoubleToLongBits2 < 0)) {
            return z ? -1 : 1;
        }
        int i = biasedExponent - biasedExponent2;
        int iAbs = Math.abs(i);
        if (iAbs > 1) {
            return z ? -i : i;
        }
        if (iAbs != 1 && jDoubleToLongBits == jDoubleToLongBits2) {
            return 0;
        }
        if (biasedExponent == 0) {
            if (biasedExponent2 == 0) {
                return compareSubnormalNumbers(jDoubleToLongBits & IEEEDouble.FRAC_MASK, IEEEDouble.FRAC_MASK & jDoubleToLongBits2, z);
            }
            return -compareAcrossSubnormalThreshold(jDoubleToLongBits2, jDoubleToLongBits, z);
        }
        if (biasedExponent2 == 0) {
            return compareAcrossSubnormalThreshold(jDoubleToLongBits, jDoubleToLongBits2, z);
        }
        int iCompareNormalised = ExpandedDouble.fromRawBitsAndExponent(jDoubleToLongBits, biasedExponent - 1023).normaliseBaseTen().roundUnits().compareNormalised(ExpandedDouble.fromRawBitsAndExponent(jDoubleToLongBits2, biasedExponent2 - 1023).normaliseBaseTen().roundUnits());
        return z ? -iCompareNormalised : iCompareNormalised;
    }

    private static String toHex(double d) {
        return "0x" + Long.toHexString(Double.doubleToLongBits(d)).toUpperCase(Locale.ROOT);
    }
}

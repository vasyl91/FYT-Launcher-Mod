package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BaseNumberUtils {
    /* JADX WARN: Code duplicated, block: B:31:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0056  */
    /* JADX WARN: Code duplicated, block: B:48:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0058 A[SYNTHETIC] */
    public static double convertToDecimal(String str, int i, int i2) throws IllegalArgumentException {
        long j;
        int i3;
        int i4;
        if (str == null || str.length() == 0) {
            return 0.0d;
        }
        long length = str.length();
        long j2 = i2;
        if (length > j2) {
            throw new IllegalArgumentException();
        }
        boolean z = false;
        long j3 = 0;
        double d = 0.0d;
        boolean z2 = true;
        for (char c : str.toCharArray()) {
            if ('0' > c || c > '9') {
                if ('A' > c || c > 'Z') {
                    if ('a' > c || c > 'z') {
                        j = i;
                    } else {
                        i3 = c - 'a';
                    }
                    if (j < i) {
                        throw new IllegalArgumentException("character not allowed");
                    }
                    if (z2) {
                        z2 = false;
                        j3 = j;
                    }
                    d = (d * ((double) i)) + j;
                } else {
                    i3 = c - 'A';
                }
                i4 = i3 + 10;
            } else {
                i4 = c - '0';
            }
            j = i4;
            if (j < i) {
                throw new IllegalArgumentException("character not allowed");
            }
            if (z2) {
                z2 = false;
                j3 = j;
            }
            d = (d * ((double) i)) + j;
        }
        if (!z2 && length == j2 && j3 >= i / 2) {
            z = true;
        }
        return z ? getTwoComplement(i, i2, d) * (-1.0d) : d;
    }

    private static double getTwoComplement(double d, double d2, double d3) {
        return Math.pow(d, d2) - d3;
    }
}

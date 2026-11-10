package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PngUtils {
    private static final byte[] PNG_FILE_HEADER = {-119, 80, 78, 71, 13, 10, 26, 10};

    private PngUtils() {
    }

    public static boolean matchesPngHeader(byte[] bArr, int i) {
        if (bArr == null || bArr.length - i < PNG_FILE_HEADER.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = PNG_FILE_HEADER;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr2[i2] != bArr[i2 + i]) {
                return false;
            }
            i2++;
        }
    }
}

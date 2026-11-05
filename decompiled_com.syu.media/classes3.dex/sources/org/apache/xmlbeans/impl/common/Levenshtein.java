package org.apache.xmlbeans.impl.common;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Levenshtein {
    private static int minimum(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static int distance(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int i = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length + 1, length2 + 1);
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[i2][0] = i2;
        }
        for (int i3 = 0; i3 <= length2; i3++) {
            iArr[0][i3] = i3;
        }
        int i4 = 1;
        while (i4 <= length) {
            int i5 = i4 - 1;
            char cCharAt = str.charAt(i5);
            int i6 = 1;
            while (i6 <= length2) {
                int i7 = i6 - 1;
                int i8 = cCharAt == str2.charAt(i7) ? i : 1;
                int[] iArr2 = iArr[i4];
                int[] iArr3 = iArr[i5];
                iArr2[i6] = minimum(iArr3[i6] + 1, iArr2[i7] + 1, iArr3[i7] + i8);
                i6++;
                i = 0;
            }
            i4++;
            i = 0;
        }
        return iArr[length][length2];
    }
}

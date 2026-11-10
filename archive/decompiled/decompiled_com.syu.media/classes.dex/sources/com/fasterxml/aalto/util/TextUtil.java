package com.fasterxml.aalto.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class TextUtil {
    static final int CHAR_SPACE = 32;

    private TextUtil() {
    }

    public static boolean isAllWhitespace(String str, boolean z) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > ' ' && (!z || cCharAt != 133)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllWhitespace(char[] cArr, int i, int i2, boolean z) {
        int i3 = i2 + i;
        while (i < i3) {
            char c = cArr[i];
            if (c > ' ' && (!z || c != 133)) {
                return false;
            }
            i++;
        }
        return true;
    }
}

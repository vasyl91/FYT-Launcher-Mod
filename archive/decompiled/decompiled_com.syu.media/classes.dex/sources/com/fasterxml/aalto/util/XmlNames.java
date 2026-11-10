package com.fasterxml.aalto.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class XmlNames {
    private static boolean validSurrogateNameChar(char c, char c2) {
        return false;
    }

    public static int findIllegalNameChar(String str, boolean z) {
        int i = 0;
        char cCharAt = str.charAt(0);
        int length = str.length();
        if (cCharAt < 55296 || cCharAt >= 57344) {
            if (z) {
                if (!XmlChars.is11NameStartChar(cCharAt)) {
                    return 0;
                }
            } else if (!XmlChars.is10NameStartChar(cCharAt)) {
                return 0;
            }
        } else {
            if (length < 2) {
                return 0;
            }
            if (!validSurrogateNameChar(cCharAt, str.charAt(1))) {
                return 1;
            }
            i = 1;
        }
        int i2 = i + 1;
        if (z) {
            while (i2 < length) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 < 55296 || cCharAt2 >= 57344) {
                    if (!XmlChars.is11NameChar(cCharAt2)) {
                        return i2;
                    }
                } else {
                    int i3 = i2 + 1;
                    if (i3 >= length || !validSurrogateNameChar(cCharAt2, str.charAt(i3))) {
                        return i2;
                    }
                    i2 = i3;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < length) {
            char cCharAt3 = str.charAt(i2);
            if (cCharAt3 < 55296 || cCharAt3 >= 57344) {
                if (!XmlChars.is10NameChar(cCharAt3)) {
                    return i2;
                }
            } else {
                int i4 = i2 + 1;
                if (i4 >= length || !validSurrogateNameChar(cCharAt3, str.charAt(i4))) {
                    return i2;
                }
                i2 = i4;
            }
            i2++;
        }
        return -1;
    }
}

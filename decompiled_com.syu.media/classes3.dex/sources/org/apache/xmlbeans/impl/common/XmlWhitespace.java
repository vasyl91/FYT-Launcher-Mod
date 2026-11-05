package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlWhitespace {
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;
    public static final int WS_UNSPECIFIED = 0;

    public static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    public static boolean isAllSpace(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isSpace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllSpace(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!isSpace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String collapse(String str) {
        return collapse(str, 3);
    }

    public static String collapse(String str, int i) {
        int length;
        int i2;
        int i3;
        if (i == 1 || i == 0) {
            return str;
        }
        if (str.indexOf(10) >= 0) {
            str = str.replace('\n', ' ');
        }
        if (str.indexOf(9) >= 0) {
            str = str.replace('\t', ' ');
        }
        if (str.indexOf(13) >= 0) {
            str = str.replace('\r', ' ');
        }
        String str2 = str;
        if (i == 2 || (length = str2.length()) == 0) {
            return str2;
        }
        if (str2.charAt(0) != ' ') {
            i2 = 2;
            while (true) {
                if (i2 < length) {
                    if (str2.charAt(i2) == ' ') {
                        if (str2.charAt(i2 - 1) == ' ' || i2 == length - 1) {
                            break;
                        }
                        i2++;
                        if (str2.charAt(i2) == ' ') {
                            break;
                        }
                    }
                    i2 += 2;
                } else {
                    if (i2 == length && str2.charAt(i2 - 1) == ' ') {
                        break;
                    }
                    return str2;
                }
            }
            i3 = i2;
        } else {
            i2 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= str2.length() || str2.charAt(i4) != ' ') {
                    break;
                }
                i2 = i4;
            }
            i3 = 0;
        }
        char[] charArray = str2.toCharArray();
        loop1: while (true) {
            i2++;
            if (i2 >= length) {
                break;
            }
            if (str2.charAt(i2) != ' ') {
                while (true) {
                    int i5 = i3 + 1;
                    int i6 = i2 + 1;
                    charArray[i3] = charArray[i2];
                    if (i6 >= length) {
                        i3 = i5;
                        break loop1;
                    }
                    char c = charArray[i6];
                    if (c == ' ') {
                        int i7 = i5 + 1;
                        i6++;
                        charArray[i5] = c;
                        if (i6 >= length) {
                            i3 = i7;
                            break loop1;
                        }
                        if (charArray[i6] == ' ') {
                            i3 = i7;
                            i2 = i6;
                            break;
                        }
                        i3 = i7;
                    } else {
                        i3 = i5;
                    }
                    i2 = i6;
                }
            }
        }
        if (i3 != 0) {
            int i8 = i3 - 1;
            if (charArray[i8] == ' ') {
                i3 = i8;
            }
        }
        return new String(charArray, 0, i3);
    }
}

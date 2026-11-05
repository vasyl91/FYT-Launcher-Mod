package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class SoundexUtils {
    SoundexUtils() {
    }

    static String clean(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isLetter(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        return new String(cArr, 0, i).toUpperCase(Locale.ENGLISH);
    }

    static int difference(StringEncoder stringEncoder, String str, String str2) throws EncoderException {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    static int differenceEncoded(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int iMin = Math.min(str.length(), str2.length());
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            if (str.charAt(i2) == str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }
}

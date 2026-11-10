package org.apache.commons.codec.binary;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CharSequenceUtils {
    static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i5 = i + 1;
            char cCharAt = charSequence.charAt(i);
            int i6 = i2 + 1;
            char cCharAt2 = charSequence2.charAt(i2);
            if (cCharAt != cCharAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                    return false;
                }
            }
            i = i5;
            i3 = i4;
            i2 = i6;
        }
    }
}

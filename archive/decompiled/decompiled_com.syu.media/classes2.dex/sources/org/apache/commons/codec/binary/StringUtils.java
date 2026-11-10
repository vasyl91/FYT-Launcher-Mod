package org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.Charsets;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class StringUtils {
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        return CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
    }

    private static byte[] getBytes(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] getBytesIso8859_1(String str) {
        return getBytes(str, Charsets.ISO_8859_1);
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            throw newIllegalStateException(str2, e);
        }
    }

    public static byte[] getBytesUsAscii(String str) {
        return getBytes(str, Charsets.US_ASCII);
    }

    public static byte[] getBytesUtf16(String str) {
        return getBytes(str, Charsets.UTF_16);
    }

    public static byte[] getBytesUtf16Be(String str) {
        return getBytes(str, Charsets.UTF_16BE);
    }

    public static byte[] getBytesUtf16Le(String str) {
        return getBytes(str, Charsets.UTF_16LE);
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytes(str, Charsets.UTF_8);
    }

    private static IllegalStateException newIllegalStateException(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    private static String newString(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String newString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw newIllegalStateException(str, e);
        }
    }

    public static String newStringIso8859_1(byte[] bArr) {
        return new String(bArr, Charsets.ISO_8859_1);
    }

    public static String newStringUsAscii(byte[] bArr) {
        return new String(bArr, Charsets.US_ASCII);
    }

    public static String newStringUtf16(byte[] bArr) {
        return new String(bArr, Charsets.UTF_16);
    }

    public static String newStringUtf16Be(byte[] bArr) {
        return new String(bArr, Charsets.UTF_16BE);
    }

    public static String newStringUtf16Le(byte[] bArr) {
        return new String(bArr, Charsets.UTF_16LE);
    }

    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, Charsets.UTF_8);
    }
}

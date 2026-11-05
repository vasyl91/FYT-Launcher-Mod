package org.apache.commons.codec.digest;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HmacUtils {
    private static final int STREAM_BUFFER_LENGTH = 1024;

    public static Mac getHmacMd5(byte[] bArr) {
        return getInitializedMac(HmacAlgorithms.HMAC_MD5, bArr);
    }

    public static Mac getHmacSha1(byte[] bArr) {
        return getInitializedMac(HmacAlgorithms.HMAC_SHA_1, bArr);
    }

    public static Mac getHmacSha256(byte[] bArr) {
        return getInitializedMac(HmacAlgorithms.HMAC_SHA_256, bArr);
    }

    public static Mac getHmacSha384(byte[] bArr) {
        return getInitializedMac(HmacAlgorithms.HMAC_SHA_384, bArr);
    }

    public static Mac getHmacSha512(byte[] bArr) {
        return getInitializedMac(HmacAlgorithms.HMAC_SHA_512, bArr);
    }

    public static Mac getInitializedMac(HmacAlgorithms hmacAlgorithms, byte[] bArr) {
        return getInitializedMac(hmacAlgorithms.toString(), bArr);
    }

    public static Mac getInitializedMac(String str, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null key");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, str);
            Mac mac = Mac.getInstance(str);
            mac.init(secretKeySpec);
            return mac;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static byte[] hmacMd5(byte[] bArr, byte[] bArr2) {
        try {
            return getHmacMd5(bArr).doFinal(bArr2);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] hmacMd5(byte[] bArr, InputStream inputStream) throws IOException {
        return updateHmac(getHmacMd5(bArr), inputStream).doFinal();
    }

    public static byte[] hmacMd5(String str, String str2) {
        return hmacMd5(StringUtils.getBytesUtf8(str), StringUtils.getBytesUtf8(str2));
    }

    public static String hmacMd5Hex(byte[] bArr, byte[] bArr2) {
        return Hex.encodeHexString(hmacMd5(bArr, bArr2));
    }

    public static String hmacMd5Hex(byte[] bArr, InputStream inputStream) throws IOException {
        return Hex.encodeHexString(hmacMd5(bArr, inputStream));
    }

    public static String hmacMd5Hex(String str, String str2) {
        return Hex.encodeHexString(hmacMd5(str, str2));
    }

    public static byte[] hmacSha1(byte[] bArr, byte[] bArr2) {
        try {
            return getHmacSha1(bArr).doFinal(bArr2);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] hmacSha1(byte[] bArr, InputStream inputStream) throws IOException {
        return updateHmac(getHmacSha1(bArr), inputStream).doFinal();
    }

    public static byte[] hmacSha1(String str, String str2) {
        return hmacSha1(StringUtils.getBytesUtf8(str), StringUtils.getBytesUtf8(str2));
    }

    public static String hmacSha1Hex(byte[] bArr, byte[] bArr2) {
        return Hex.encodeHexString(hmacSha1(bArr, bArr2));
    }

    public static String hmacSha1Hex(byte[] bArr, InputStream inputStream) throws IOException {
        return Hex.encodeHexString(hmacSha1(bArr, inputStream));
    }

    public static String hmacSha1Hex(String str, String str2) {
        return Hex.encodeHexString(hmacSha1(str, str2));
    }

    public static byte[] hmacSha256(byte[] bArr, byte[] bArr2) {
        try {
            return getHmacSha256(bArr).doFinal(bArr2);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] hmacSha256(byte[] bArr, InputStream inputStream) throws IOException {
        return updateHmac(getHmacSha256(bArr), inputStream).doFinal();
    }

    public static byte[] hmacSha256(String str, String str2) {
        return hmacSha256(StringUtils.getBytesUtf8(str), StringUtils.getBytesUtf8(str2));
    }

    public static String hmacSha256Hex(byte[] bArr, byte[] bArr2) {
        return Hex.encodeHexString(hmacSha256(bArr, bArr2));
    }

    public static String hmacSha256Hex(byte[] bArr, InputStream inputStream) throws IOException {
        return Hex.encodeHexString(hmacSha256(bArr, inputStream));
    }

    public static String hmacSha256Hex(String str, String str2) {
        return Hex.encodeHexString(hmacSha256(str, str2));
    }

    public static byte[] hmacSha384(byte[] bArr, byte[] bArr2) {
        try {
            return getHmacSha384(bArr).doFinal(bArr2);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] hmacSha384(byte[] bArr, InputStream inputStream) throws IOException {
        return updateHmac(getHmacSha384(bArr), inputStream).doFinal();
    }

    public static byte[] hmacSha384(String str, String str2) {
        return hmacSha384(StringUtils.getBytesUtf8(str), StringUtils.getBytesUtf8(str2));
    }

    public static String hmacSha384Hex(byte[] bArr, byte[] bArr2) {
        return Hex.encodeHexString(hmacSha384(bArr, bArr2));
    }

    public static String hmacSha384Hex(byte[] bArr, InputStream inputStream) throws IOException {
        return Hex.encodeHexString(hmacSha384(bArr, inputStream));
    }

    public static String hmacSha384Hex(String str, String str2) {
        return Hex.encodeHexString(hmacSha384(str, str2));
    }

    public static byte[] hmacSha512(byte[] bArr, byte[] bArr2) {
        try {
            return getHmacSha512(bArr).doFinal(bArr2);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] hmacSha512(byte[] bArr, InputStream inputStream) throws IOException {
        return updateHmac(getHmacSha512(bArr), inputStream).doFinal();
    }

    public static byte[] hmacSha512(String str, String str2) {
        return hmacSha512(StringUtils.getBytesUtf8(str), StringUtils.getBytesUtf8(str2));
    }

    public static String hmacSha512Hex(byte[] bArr, byte[] bArr2) {
        return Hex.encodeHexString(hmacSha512(bArr, bArr2));
    }

    public static String hmacSha512Hex(byte[] bArr, InputStream inputStream) throws IOException {
        return Hex.encodeHexString(hmacSha512(bArr, inputStream));
    }

    public static String hmacSha512Hex(String str, String str2) {
        return Hex.encodeHexString(hmacSha512(str, str2));
    }

    public static Mac updateHmac(Mac mac, byte[] bArr) {
        mac.reset();
        mac.update(bArr);
        return mac;
    }

    public static Mac updateHmac(Mac mac, InputStream inputStream) throws IOException {
        mac.reset();
        byte[] bArr = new byte[1024];
        int i = inputStream.read(bArr, 0, 1024);
        while (i > -1) {
            mac.update(bArr, 0, i);
            i = inputStream.read(bArr, 0, 1024);
        }
        return mac;
    }

    public static Mac updateHmac(Mac mac, String str) {
        mac.reset();
        mac.update(StringUtils.getBytesUtf8(str));
        return mac;
    }
}

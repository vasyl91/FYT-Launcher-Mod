package org.apache.commons.codec.digest;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DigestUtils {
    private static final int STREAM_BUFFER_LENGTH = 1024;

    private static byte[] digest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        return updateDigest(messageDigest, inputStream).digest();
    }

    public static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessageDigest getMd2Digest() {
        return getDigest(MessageDigestAlgorithms.MD2);
    }

    public static MessageDigest getMd5Digest() {
        return getDigest(MessageDigestAlgorithms.MD5);
    }

    public static MessageDigest getSha1Digest() {
        return getDigest(MessageDigestAlgorithms.SHA_1);
    }

    public static MessageDigest getSha256Digest() {
        return getDigest(MessageDigestAlgorithms.SHA_256);
    }

    public static MessageDigest getSha384Digest() {
        return getDigest(MessageDigestAlgorithms.SHA_384);
    }

    public static MessageDigest getSha512Digest() {
        return getDigest(MessageDigestAlgorithms.SHA_512);
    }

    @Deprecated
    public static MessageDigest getShaDigest() {
        return getSha1Digest();
    }

    public static byte[] md2(byte[] bArr) {
        return getMd2Digest().digest(bArr);
    }

    public static byte[] md2(InputStream inputStream) throws IOException {
        return digest(getMd2Digest(), inputStream);
    }

    public static byte[] md2(String str) {
        return md2(StringUtils.getBytesUtf8(str));
    }

    public static String md2Hex(byte[] bArr) {
        return Hex.encodeHexString(md2(bArr));
    }

    public static String md2Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(md2(inputStream));
    }

    public static String md2Hex(String str) {
        return Hex.encodeHexString(md2(str));
    }

    public static byte[] md5(byte[] bArr) {
        return getMd5Digest().digest(bArr);
    }

    public static byte[] md5(InputStream inputStream) throws IOException {
        return digest(getMd5Digest(), inputStream);
    }

    public static byte[] md5(String str) {
        return md5(StringUtils.getBytesUtf8(str));
    }

    public static String md5Hex(byte[] bArr) {
        return Hex.encodeHexString(md5(bArr));
    }

    public static String md5Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(md5(inputStream));
    }

    public static String md5Hex(String str) {
        return Hex.encodeHexString(md5(str));
    }

    @Deprecated
    public static byte[] sha(byte[] bArr) {
        return sha1(bArr);
    }

    @Deprecated
    public static byte[] sha(InputStream inputStream) throws IOException {
        return sha1(inputStream);
    }

    @Deprecated
    public static byte[] sha(String str) {
        return sha1(str);
    }

    public static byte[] sha1(byte[] bArr) {
        return getSha1Digest().digest(bArr);
    }

    public static byte[] sha1(InputStream inputStream) throws IOException {
        return digest(getSha1Digest(), inputStream);
    }

    public static byte[] sha1(String str) {
        return sha1(StringUtils.getBytesUtf8(str));
    }

    public static String sha1Hex(byte[] bArr) {
        return Hex.encodeHexString(sha1(bArr));
    }

    public static String sha1Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha1(inputStream));
    }

    public static String sha1Hex(String str) {
        return Hex.encodeHexString(sha1(str));
    }

    public static byte[] sha256(byte[] bArr) {
        return getSha256Digest().digest(bArr);
    }

    public static byte[] sha256(InputStream inputStream) throws IOException {
        return digest(getSha256Digest(), inputStream);
    }

    public static byte[] sha256(String str) {
        return sha256(StringUtils.getBytesUtf8(str));
    }

    public static String sha256Hex(byte[] bArr) {
        return Hex.encodeHexString(sha256(bArr));
    }

    public static String sha256Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha256(inputStream));
    }

    public static String sha256Hex(String str) {
        return Hex.encodeHexString(sha256(str));
    }

    public static byte[] sha384(byte[] bArr) {
        return getSha384Digest().digest(bArr);
    }

    public static byte[] sha384(InputStream inputStream) throws IOException {
        return digest(getSha384Digest(), inputStream);
    }

    public static byte[] sha384(String str) {
        return sha384(StringUtils.getBytesUtf8(str));
    }

    public static String sha384Hex(byte[] bArr) {
        return Hex.encodeHexString(sha384(bArr));
    }

    public static String sha384Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha384(inputStream));
    }

    public static String sha384Hex(String str) {
        return Hex.encodeHexString(sha384(str));
    }

    public static byte[] sha512(byte[] bArr) {
        return getSha512Digest().digest(bArr);
    }

    public static byte[] sha512(InputStream inputStream) throws IOException {
        return digest(getSha512Digest(), inputStream);
    }

    public static byte[] sha512(String str) {
        return sha512(StringUtils.getBytesUtf8(str));
    }

    public static String sha512Hex(byte[] bArr) {
        return Hex.encodeHexString(sha512(bArr));
    }

    public static String sha512Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha512(inputStream));
    }

    public static String sha512Hex(String str) {
        return Hex.encodeHexString(sha512(str));
    }

    @Deprecated
    public static String shaHex(byte[] bArr) {
        return sha1Hex(bArr);
    }

    @Deprecated
    public static String shaHex(InputStream inputStream) throws IOException {
        return sha1Hex(inputStream);
    }

    @Deprecated
    public static String shaHex(String str) {
        return sha1Hex(str);
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int i = inputStream.read(bArr, 0, 1024);
        while (i > -1) {
            messageDigest.update(bArr, 0, i);
            i = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, String str) {
        messageDigest.update(StringUtils.getBytesUtf8(str));
        return messageDigest;
    }
}

package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class Base64 implements BinaryEncoder, BinaryDecoder {
    public Base64() {
        throw new RuntimeException("Stub!");
    }

    public static boolean isArrayByteBase64(byte[] arrayOctect) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] encodeBase64(byte[] binaryData) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] encodeBase64Chunked(byte[] binaryData) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object pObject) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] pArray) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] decodeBase64(byte[] base64Data) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object pObject) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] pArray) {
        throw new RuntimeException("Stub!");
    }
}

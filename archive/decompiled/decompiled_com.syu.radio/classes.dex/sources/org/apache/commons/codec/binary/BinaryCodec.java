package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
    public BinaryCodec() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] raw) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object raw) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object ascii) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] ascii) {
        throw new RuntimeException("Stub!");
    }

    public byte[] toByteArray(String ascii) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] fromAscii(char[] ascii) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] fromAscii(byte[] ascii) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] toAsciiBytes(byte[] raw) {
        throw new RuntimeException("Stub!");
    }

    public static char[] toAsciiChars(byte[] raw) {
        throw new RuntimeException("Stub!");
    }

    public static String toAsciiString(byte[] raw) {
        throw new RuntimeException("Stub!");
    }
}

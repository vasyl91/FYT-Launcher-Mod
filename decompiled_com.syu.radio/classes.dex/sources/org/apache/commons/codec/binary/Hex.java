package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class Hex implements BinaryEncoder, BinaryDecoder {
    public Hex() {
        throw new RuntimeException("Stub!");
    }

    public static byte[] decodeHex(char[] data) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    protected static int toDigit(char ch, int index) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    public static char[] encodeHex(byte[] data) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] array) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object object) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] array) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object object) throws EncoderException {
        throw new RuntimeException("Stub!");
    }
}

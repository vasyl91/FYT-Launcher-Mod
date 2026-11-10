package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class QuotedPrintableCodec implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder {
    public QuotedPrintableCodec() {
        throw new RuntimeException("Stub!");
    }

    public QuotedPrintableCodec(String charset) {
        throw new RuntimeException("Stub!");
    }

    public static final byte[] encodeQuotedPrintable(BitSet printable, byte[] bytes) {
        throw new RuntimeException("Stub!");
    }

    public static final byte[] decodeQuotedPrintable(byte[] bytes) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bytes) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bytes) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String pString) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    public String decode(String pString, String charset) throws DecoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String pString) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object pObject) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object pObject) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    public String getDefaultCharset() {
        throw new RuntimeException("Stub!");
    }

    public String encode(String pString, String charset) throws UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }
}

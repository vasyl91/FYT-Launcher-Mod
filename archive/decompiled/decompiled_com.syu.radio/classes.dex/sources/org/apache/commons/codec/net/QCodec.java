package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class QCodec extends RFC1522Codec implements StringEncoder, StringDecoder {
    public QCodec() {
        throw new RuntimeException("Stub!");
    }

    public QCodec(String charset) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected String getEncoding() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doEncoding(byte[] bytes) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doDecoding(byte[] bytes) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    public String encode(String pString, String charset) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String pString) throws EncoderException {
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

    public boolean isEncodeBlanks() {
        throw new RuntimeException("Stub!");
    }

    public void setEncodeBlanks(boolean b) {
        throw new RuntimeException("Stub!");
    }
}

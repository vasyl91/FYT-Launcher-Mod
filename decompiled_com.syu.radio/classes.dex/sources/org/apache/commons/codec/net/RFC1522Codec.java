package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
abstract class RFC1522Codec {
    protected abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    protected abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    protected abstract String getEncoding();

    RFC1522Codec() {
        throw new RuntimeException("Stub!");
    }

    protected String encodeText(String text, String charset) throws EncoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    protected String decodeText(String text) throws DecoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }
}

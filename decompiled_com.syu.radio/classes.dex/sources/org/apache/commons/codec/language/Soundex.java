package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class Soundex implements StringEncoder {
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    public static final char[] US_ENGLISH_MAPPING = null;
    public static final Soundex US_ENGLISH = null;

    public Soundex() {
        throw new RuntimeException("Stub!");
    }

    public Soundex(char[] mapping) {
        throw new RuntimeException("Stub!");
    }

    public int difference(String s1, String s2) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object pObject) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String pString) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public int getMaxLength() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public void setMaxLength(int maxLength) {
        throw new RuntimeException("Stub!");
    }

    public String soundex(String str) {
        throw new RuntimeException("Stub!");
    }
}

package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class DoubleMetaphone implements StringEncoder {
    protected int maxCodeLen;

    public class DoubleMetaphoneResult {
        public DoubleMetaphoneResult(int maxLength) {
            throw new RuntimeException("Stub!");
        }

        public void append(char value) {
            throw new RuntimeException("Stub!");
        }

        public void append(char primary, char alternate) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(char value) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(char value) {
            throw new RuntimeException("Stub!");
        }

        public void append(String value) {
            throw new RuntimeException("Stub!");
        }

        public void append(String primary, String alternate) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(String value) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(String value) {
            throw new RuntimeException("Stub!");
        }

        public String getPrimary() {
            throw new RuntimeException("Stub!");
        }

        public String getAlternate() {
            throw new RuntimeException("Stub!");
        }

        public boolean isComplete() {
            throw new RuntimeException("Stub!");
        }
    }

    public DoubleMetaphone() {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String value) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String value, boolean alternate) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String value) {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String value1, String value2) {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String value1, String value2, boolean alternate) {
        throw new RuntimeException("Stub!");
    }

    public int getMaxCodeLen() {
        throw new RuntimeException("Stub!");
    }

    public void setMaxCodeLen(int maxCodeLen) {
        throw new RuntimeException("Stub!");
    }

    protected char charAt(String value, int index) {
        throw new RuntimeException("Stub!");
    }

    protected static boolean contains(String value, int start, int length, String[] criteria) {
        throw new RuntimeException("Stub!");
    }
}

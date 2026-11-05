package org.codehaus.stax2.ri.typed;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class AsciiValueEncoder {
    protected static final int MIN_CHARS_WITHOUT_FLUSH = 64;

    public final boolean bufferNeedsFlush(int i) {
        return i < 64;
    }

    public abstract int encodeMore(byte[] bArr, int i, int i2);

    public abstract int encodeMore(char[] cArr, int i, int i2);

    public abstract boolean isCompleted();

    protected AsciiValueEncoder() {
    }
}

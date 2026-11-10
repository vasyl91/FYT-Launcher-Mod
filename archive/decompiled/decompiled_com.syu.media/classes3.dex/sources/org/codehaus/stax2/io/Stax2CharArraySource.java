package org.codehaus.stax2.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2CharArraySource extends Stax2BlockSource {
    final char[] mBuffer;
    final int mLength;
    final int mStart;

    @Override // org.codehaus.stax2.io.Stax2BlockSource, org.codehaus.stax2.io.Stax2Source
    public InputStream constructInputStream() throws IOException {
        return null;
    }

    public Stax2CharArraySource(char[] cArr, int i, int i2) {
        this.mBuffer = cArr;
        this.mStart = i;
        this.mLength = i2;
    }

    @Override // org.codehaus.stax2.io.Stax2BlockSource, org.codehaus.stax2.io.Stax2Source
    public Reader constructReader() throws IOException {
        return new CharArrayReader(this.mBuffer, this.mStart, this.mLength);
    }

    public char[] getBuffer() {
        return this.mBuffer;
    }

    public int getBufferStart() {
        return this.mStart;
    }

    public int getBufferLength() {
        return this.mLength;
    }
}

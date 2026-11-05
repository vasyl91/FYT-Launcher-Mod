package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ReaderInputStream extends PushedInputStream {
    public static int defaultBufferSize = 2048;
    private char[] buf;
    private Reader reader;
    private Writer writer;

    public ReaderInputStream(Reader reader, String str) throws UnsupportedEncodingException {
        this(reader, str, defaultBufferSize);
    }

    public ReaderInputStream(Reader reader, String str, int i) throws UnsupportedEncodingException {
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.reader = reader;
        this.writer = new OutputStreamWriter(getOutputStream(), str);
        this.buf = new char[i];
    }

    @Override // org.apache.xmlbeans.impl.common.PushedInputStream
    public void fill(int i) throws IOException {
        do {
            int i2 = this.reader.read(this.buf);
            if (i2 < 0) {
                return;
            }
            this.writer.write(this.buf, 0, i2);
            this.writer.flush();
        } while (available() <= 0);
    }
}

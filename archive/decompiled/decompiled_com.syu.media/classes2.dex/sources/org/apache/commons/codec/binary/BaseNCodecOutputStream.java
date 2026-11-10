package org.apache.commons.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec, boolean z) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.baseNCodec = baseNCodec;
        this.doEncode = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i, i2, this.context);
            } else {
                this.baseNCodec.decode(bArr, i, i2, this.context);
            }
            flush(false);
        }
    }

    private void flush(boolean z) throws IOException {
        byte[] bArr;
        int results;
        int iAvailable = this.baseNCodec.available(this.context);
        if (iAvailable > 0 && (results = this.baseNCodec.readResults((bArr = new byte[iAvailable]), 0, iAvailable, this.context)) > 0) {
            this.out.write(bArr, 0, results);
        }
        if (z) {
            this.out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flush(true);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
        flush();
        this.out.close();
    }
}

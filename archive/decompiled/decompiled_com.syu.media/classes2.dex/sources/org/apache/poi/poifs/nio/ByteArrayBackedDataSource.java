package org.apache.poi.poifs.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ByteArrayBackedDataSource extends DataSource {
    private byte[] buffer;
    private long size;

    public ByteArrayBackedDataSource(byte[] bArr, int i) {
        this.buffer = bArr;
        this.size = i;
    }

    public ByteArrayBackedDataSource(byte[] bArr) {
        this(bArr, bArr.length);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int i, long j) {
        long j2 = this.size;
        if (j >= j2) {
            throw new IndexOutOfBoundsException("Unable to read " + i + " bytes from " + j + " in stream of length " + this.size);
        }
        return ByteBuffer.wrap(this.buffer, (int) j, (int) Math.min(i, j2 - j));
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer byteBuffer, long j) {
        long jCapacity = ((long) byteBuffer.capacity()) + j;
        if (jCapacity > this.buffer.length) {
            extend(jCapacity);
        }
        byteBuffer.get(this.buffer, (int) j, byteBuffer.capacity());
        if (jCapacity > this.size) {
            this.size = jCapacity;
        }
    }

    private void extend(long j) {
        byte[] bArr = this.buffer;
        long length = j - ((long) bArr.length);
        if (length < ((double) bArr.length) * 0.25d) {
            length = (long) (((double) bArr.length) * 0.25d);
        }
        if (length < 4096) {
            length = 4096;
        }
        byte[] bArr2 = new byte[(int) (length + ((long) bArr.length))];
        System.arraycopy(bArr, 0, bArr2, 0, (int) this.size);
        this.buffer = bArr2;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void copyTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buffer, 0, (int) this.size);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() {
        return this.size;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() {
        this.buffer = null;
        this.size = -1L;
    }
}

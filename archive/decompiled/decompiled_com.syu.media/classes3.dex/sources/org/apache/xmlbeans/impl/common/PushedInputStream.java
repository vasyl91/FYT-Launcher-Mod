package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class PushedInputStream extends InputStream {
    private static int defaultBufferSize = 2048;
    protected byte[] buf;
    protected int marklimit;
    protected int markpos;
    protected OutputStream outputStream;
    protected int readpos;
    protected int writepos;

    protected abstract void fill(int i) throws IOException;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public final OutputStream getOutputStream() {
        return this.outputStream;
    }

    public PushedInputStream() {
        this(defaultBufferSize);
    }

    public PushedInputStream(int i) {
        this.markpos = -1;
        this.outputStream = new InternalOutputStream();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial buffer size");
        }
        this.buf = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    public void shift(int i) {
        int i2 = this.readpos;
        int i3 = this.markpos;
        if (i3 > 0) {
            if (i2 - i3 > this.marklimit) {
                this.markpos = -1;
            } else {
                i2 = i3;
            }
        }
        int i4 = this.writepos - i2;
        if (i2 > 0) {
            byte[] bArr = this.buf;
            if (bArr.length - i4 >= i && i4 <= i) {
                System.arraycopy(bArr, i2, bArr, 0, i4);
            } else {
                byte[] bArr2 = new byte[Math.max(this.buf.length << 1, i + i4)];
                System.arraycopy(this.buf, i2, bArr2, 0, i4);
                this.buf = bArr2;
            }
        } else {
            byte[] bArr3 = new byte[Math.max(this.buf.length << 1, i + i4)];
            System.arraycopy(this.buf, i2, bArr3, 0, i4);
            this.buf = bArr3;
        }
        if (i2 > 0) {
            this.readpos -= i2;
            int i5 = this.markpos;
            if (i5 > 0) {
                this.markpos = i5 - i2;
            }
            this.writepos -= i2;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.readpos >= this.writepos) {
            fill(1);
            if (this.readpos >= this.writepos) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i = this.readpos;
        this.readpos = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.writepos - this.readpos;
        if (i3 < i2) {
            fill(i2 - i3);
            i3 = this.writepos - this.readpos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.readpos, bArr, i, i2);
        this.readpos += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        long j2 = this.writepos - this.readpos;
        if (j2 < j) {
            long j3 = j - j2;
            if (j3 > 2147483647L) {
                j3 = 2147483647L;
            }
            fill((int) j3);
            j2 = this.writepos - this.readpos;
            if (j2 <= 0) {
                return 0L;
            }
        }
        if (j2 < j) {
            j = j2;
        }
        this.readpos = (int) (((long) this.readpos) + j);
        return j;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.writepos - this.readpos;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.marklimit = i;
        this.markpos = this.readpos;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        int i = this.markpos;
        if (i < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.readpos = i;
    }

    private class InternalOutputStream extends OutputStream {
        private InternalOutputStream() {
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) throws IOException {
            if (PushedInputStream.this.writepos + 1 > PushedInputStream.this.buf.length) {
                PushedInputStream.this.shift(1);
            }
            PushedInputStream.this.buf[PushedInputStream.this.writepos] = (byte) i;
            PushedInputStream.this.writepos++;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            int i3;
            if (i >= 0) {
                if (i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0) {
                    if (i2 == 0) {
                        return;
                    }
                    if (PushedInputStream.this.writepos + i2 > PushedInputStream.this.buf.length) {
                        PushedInputStream.this.shift(i2);
                    }
                    System.arraycopy(bArr, i, PushedInputStream.this.buf, PushedInputStream.this.writepos, i2);
                    PushedInputStream.this.writepos += i2;
                    return;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }
}

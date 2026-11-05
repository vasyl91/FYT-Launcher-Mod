package net.lingala.zip4j.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipInputStream extends InputStream {
    private byte[] buff;
    private long bytesWritten;
    private Inflater inflater;
    private long length;
    ZipFileHeader localFileHeader;
    private long uncompressedSize;
    private ZipIn zipIn;
    private byte[] oneByteBuff = new byte[1];
    protected long bytesRead = 0;

    public ZipInputStream(ZipIn zipIn, ZipFileHeader localFileHeader, long start, long len, long uncompressedSize, boolean bInflate) {
        this.zipIn = zipIn;
        this.length = len;
        this.localFileHeader = localFileHeader;
        if (bInflate) {
            this.inflater = new Inflater(true);
            this.buff = new byte[4096];
            this.uncompressedSize = uncompressedSize;
            this.bytesWritten = 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByteBuff, 0, 1) == -1) {
            return -1;
        }
        return this.oneByteBuff[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.inflater != null) {
            try {
                if (this.bytesWritten >= this.uncompressedSize) {
                    return -1;
                }
                while (true) {
                    int n = this.inflater.inflate(b, off, len);
                    if (n == 0) {
                        if (this.inflater.finished() || this.inflater.needsDictionary()) {
                            return -1;
                        }
                        if (this.inflater.needsInput()) {
                            int lenTmp = readNormal(this.buff, 0, this.buff.length);
                            if (lenTmp == -1) {
                                throw new EOFException("Unexpected end of ZLIB input stream");
                            }
                            this.inflater.setInput(this.buff, 0, lenTmp);
                        }
                    } else {
                        this.bytesWritten += (long) n;
                        return n;
                    }
                }
            } catch (DataFormatException e) {
                String s = "Invalid ZLIB data format";
                if (e.getMessage() != null) {
                    s = e.getMessage();
                }
                if (this.localFileHeader != null && this.localFileHeader.isEncrypted()) {
                    s = String.valueOf(s) + " - Wrong Password?";
                }
                throw new IOException(s);
            }
        } else {
            return readNormal(b, off, len);
        }
    }

    public int readNormal(byte[] b, int off, int len) throws IOException {
        int count;
        if (len > this.length - this.bytesRead && (len = (int) (this.length - this.bytesRead)) <= 0) {
            return -1;
        }
        synchronized (this.zipIn) {
            count = this.zipIn.read(b, off, len);
        }
        if (count > 0) {
            this.localFileHeader.decryptData(b, off, count);
            this.bytesRead += (long) count;
        }
        return count;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.inflater != null) {
            this.inflater.end();
            this.inflater = null;
        }
        this.zipIn.close();
    }

    public void seek(long pos) throws IOException {
        this.zipIn.seek(pos);
    }
}

package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipIn1 extends ZipIn {
    public ZipIn1(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public void skip(long pos) throws IOException {
        this.randomAccessFile.skipBytes((int) pos);
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public void seek(long pos) throws IOException {
        this.randomAccessFile.seek(pos);
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public long length() throws IOException {
        return this.randomAccessFile.length();
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public int read(byte[] b, int off, int len) throws IOException {
        return this.randomAccessFile.read(b, off, len);
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public long readLeInt(byte[] b) throws IOException {
        this.randomAccessFile.readFully(b, 0, 4);
        return readLongLittleEndian(b);
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public void close() throws IOException {
        this.randomAccessFile.close();
    }
}

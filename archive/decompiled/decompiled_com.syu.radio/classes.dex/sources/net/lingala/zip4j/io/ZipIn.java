package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipIn {
    public static final int BUFF_SIZE = 4096;
    public static final int COMP_DEFLATE = 8;
    public static final int COMP_STORE = 0;
    public static final int ENC_METHOD_STANDARD = 0;
    public static final int ENDHDR = 22;
    public static final String READ_MODE = "r";
    public static final int STD_DEC_HDR_SIZE = 12;
    RandomAccessFile randomAccessFile;
    String strAsset;
    public static long LOCSIG = 67324752;
    public static long CENSIG = 33639248;
    public static long ENDSIG = 101010256;
    public static long DIGSIG = 84233040;

    public void skip(long pos) throws IOException {
    }

    public void seek(long pos) throws IOException {
    }

    public long length() throws IOException {
        return 0L;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return 0;
    }

    public int read(byte[] buf) throws IOException {
        return read(buf, 0, buf.length);
    }

    public void close() throws IOException {
    }

    public long readLeInt(byte[] b) throws IOException {
        return 0L;
    }

    public int readShortLittleEndian(byte[] b) {
        return (b[0] & 255) | ((b[1] & 255) << 8);
    }

    public long readLongLittleEndian(byte[] b) {
        return (b[0] & 255) | ((b[1] & 255) << 8) | (((b[2] & 255) | ((b[3] & 255) << 8)) << 16);
    }
}

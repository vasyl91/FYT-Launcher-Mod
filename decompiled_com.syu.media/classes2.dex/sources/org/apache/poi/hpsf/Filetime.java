package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Filetime {
    private static final long EPOCH_DIFF = -11644473600000L;
    private static final long NANO_100 = 10000;
    private static final int SIZE = 8;
    private static final long UINT_MASK = 4294967295L;
    private int _dwHighDateTime;
    private int _dwLowDateTime;

    Filetime() {
    }

    Filetime(int i, int i2) {
        this._dwLowDateTime = i;
        this._dwHighDateTime = i2;
    }

    Filetime(java.util.Date date) {
        long jDateToFileTime = dateToFileTime(date);
        this._dwHighDateTime = (int) ((jDateToFileTime >>> 32) & UINT_MASK);
        this._dwLowDateTime = (int) (jDateToFileTime & UINT_MASK);
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._dwLowDateTime = littleEndianByteArrayInputStream.readInt();
        this._dwHighDateTime = littleEndianByteArrayInputStream.readInt();
    }

    long getHigh() {
        return this._dwHighDateTime;
    }

    long getLow() {
        return this._dwLowDateTime;
    }

    byte[] toByteArray() {
        byte[] bArr = new byte[8];
        LittleEndian.putInt(bArr, 0, this._dwLowDateTime);
        LittleEndian.putInt(bArr, 4, this._dwHighDateTime);
        return bArr;
    }

    int write(OutputStream outputStream) throws IOException {
        LittleEndian.putInt(this._dwLowDateTime, outputStream);
        LittleEndian.putInt(this._dwHighDateTime, outputStream);
        return 8;
    }

    java.util.Date getJavaValue() {
        return filetimeToDate((((long) this._dwHighDateTime) << 32) | (((long) this._dwLowDateTime) & UINT_MASK));
    }

    public static java.util.Date filetimeToDate(long j) {
        return new java.util.Date((j / NANO_100) + EPOCH_DIFF);
    }

    public static long dateToFileTime(java.util.Date date) {
        return (date.getTime() - EPOCH_DIFF) * NANO_100;
    }

    public static boolean isUndefined(java.util.Date date) {
        return date == null || dateToFileTime(date) == 0;
    }
}

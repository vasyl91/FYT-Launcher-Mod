package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LittleEndian implements LittleEndianConsts {
    public static int ubyteToInt(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public static final class BufferUnderrunException extends IOException {
        private static final long serialVersionUID = 8736973884877006145L;

        BufferUnderrunException() {
            super("buffer underrun");
        }
    }

    public static byte[] getByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static double getDouble(byte[] bArr) {
        return Double.longBitsToDouble(getLong(bArr, 0));
    }

    public static double getDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(getLong(bArr, i));
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 0);
    }

    public static float getFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(getInt(bArr, i));
    }

    public static int getInt(byte[] bArr) {
        return getInt(bArr, 0);
    }

    public static int getInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        int i4 = i2 + 1;
        int i5 = bArr[i2] & UByte.MAX_VALUE;
        return ((bArr[i4 + 1] & UByte.MAX_VALUE) << 24) + ((bArr[i4] & UByte.MAX_VALUE) << 16) + (i5 << 8) + (i3 << 0);
    }

    public static long getLong(byte[] bArr) {
        return getLong(bArr, 0);
    }

    public static long getLong(byte[] bArr, int i) {
        long j = bArr[i + 7] & UByte.MAX_VALUE;
        for (int i2 = (i + 8) - 1; i2 >= i; i2--) {
            j = (j << 8) | ((long) (bArr[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    public static short getShort(byte[] bArr) {
        return getShort(bArr, 0);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & UByte.MAX_VALUE) << 8) + ((bArr[i] & UByte.MAX_VALUE) << 0));
    }

    public static short[] getShortArray(byte[] bArr, int i, int i2) {
        int i3 = i2 / 2;
        short[] sArr = new short[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            sArr[i4] = getShort(bArr, (i4 * 2) + i);
        }
        return sArr;
    }

    public static short getUByte(byte[] bArr) {
        return (short) (bArr[0] & UByte.MAX_VALUE);
    }

    public static short getUByte(byte[] bArr, int i) {
        return (short) (bArr[i] & UByte.MAX_VALUE);
    }

    public static long getUInt(byte[] bArr) {
        return getUInt(bArr, 0);
    }

    public static long getUInt(byte[] bArr, int i) {
        return ((long) getInt(bArr, i)) & 4294967295L;
    }

    public static int getUShort(byte[] bArr) {
        return getUShort(bArr, 0);
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 8) + ((bArr[i] & UByte.MAX_VALUE) << 0);
    }

    public static void putByte(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
    }

    public static void putDouble(byte[] bArr, int i, double d) {
        putLong(bArr, i, Double.doubleToLongBits(d));
    }

    public static void putDouble(double d, OutputStream outputStream) throws IOException {
        putLong(Double.doubleToLongBits(d), outputStream);
    }

    public static void putFloat(byte[] bArr, int i, float f) {
        putInt(bArr, i, Float.floatToIntBits(f));
    }

    public static void putFloat(float f, OutputStream outputStream) throws IOException {
        putInt(Float.floatToIntBits(f), outputStream);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        bArr[i] = (byte) ((i2 >>> 0) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        bArr[i4 + 1] = (byte) ((i2 >>> 24) & 255);
    }

    public static void putInt(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((i >>> 0) & 255));
        outputStream.write((byte) ((i >>> 8) & 255));
        outputStream.write((byte) ((i >>> 16) & 255));
        outputStream.write((byte) ((i >>> 24) & 255));
    }

    public static void putLong(byte[] bArr, int i, long j) {
        bArr[i + 0] = (byte) ((j >>> 0) & 255);
        bArr[i + 1] = (byte) ((j >>> 8) & 255);
        bArr[i + 2] = (byte) ((j >>> 16) & 255);
        bArr[i + 3] = (byte) ((j >>> 24) & 255);
        bArr[i + 4] = (byte) ((j >>> 32) & 255);
        bArr[i + 5] = (byte) ((j >>> 40) & 255);
        bArr[i + 6] = (byte) ((j >>> 48) & 255);
        bArr[i + 7] = (byte) ((j >>> 56) & 255);
    }

    public static void putLong(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((j >>> 0) & 255));
        outputStream.write((byte) ((j >>> 8) & 255));
        outputStream.write((byte) ((j >>> 16) & 255));
        outputStream.write((byte) ((j >>> 24) & 255));
        outputStream.write((byte) ((j >>> 32) & 255));
        outputStream.write((byte) ((j >>> 40) & 255));
        outputStream.write((byte) ((j >>> 48) & 255));
        outputStream.write((byte) ((j >>> 56) & 255));
    }

    public static void putShort(byte[] bArr, int i, short s) {
        bArr[i] = (byte) ((s >>> 0) & 255);
        bArr[i + 1] = (byte) ((s >>> 8) & 255);
    }

    public static void putShort(OutputStream outputStream, short s) throws IOException {
        outputStream.write((byte) ((s >>> 0) & 255));
        outputStream.write((byte) ((s >>> 8) & 255));
    }

    public static void putShortArray(byte[] bArr, int i, short[] sArr) {
        for (short s : sArr) {
            putShort(bArr, i, s);
            i += 2;
        }
    }

    public static void putUByte(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s & 255);
    }

    public static void putUInt(byte[] bArr, int i, long j) {
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 0) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 8) & 255);
        bArr[i3] = (byte) ((j >>> 16) & 255);
        bArr[i3 + 1] = (byte) ((j >>> 24) & 255);
    }

    public static void putUInt(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((j >>> 0) & 255));
        outputStream.write((byte) ((j >>> 8) & 255));
        outputStream.write((byte) ((j >>> 16) & 255));
        outputStream.write((byte) ((j >>> 24) & 255));
    }

    public static void putUShort(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >>> 0) & 255);
        bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
    }

    public static void putUShort(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((i >>> 0) & 255));
        outputStream.write((byte) ((i >>> 8) & 255));
    }

    public static int readInt(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        int i4 = inputStream.read();
        if ((i | i2 | i3 | i4) >= 0) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + (i << 0);
        }
        throw new BufferUnderrunException();
    }

    public static long readUInt(InputStream inputStream) throws IOException {
        return ((long) readInt(inputStream)) & 4294967295L;
    }

    public static long readLong(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        int i4 = inputStream.read();
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        int i7 = inputStream.read();
        int i8 = inputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) >= 0) {
            return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + ((long) (i3 << 16)) + ((long) (i2 << 8)) + ((long) (i << 0));
        }
        throw new BufferUnderrunException();
    }

    public static short readShort(InputStream inputStream) throws IOException {
        return (short) readUShort(inputStream);
    }

    public static int readUShort(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if ((i | i2) >= 0) {
            return (i2 << 8) + (i << 0);
        }
        throw new BufferUnderrunException();
    }

    private LittleEndian() {
    }
}

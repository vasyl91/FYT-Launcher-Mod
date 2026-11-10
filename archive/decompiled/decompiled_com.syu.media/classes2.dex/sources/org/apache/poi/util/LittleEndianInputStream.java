package org.apache.poi.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LittleEndianInputStream extends FilterInputStream implements LittleEndianInput {
    private static final int EOF = -1;

    public LittleEndianInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        try {
            return super.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        byte[] bArr = new byte[1];
        try {
            checkEOF(read(bArr), 1);
            return LittleEndian.getUByte(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        byte[] bArr = new byte[4];
        try {
            checkEOF(read(bArr), 4);
            return LittleEndian.getInt(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long readUInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        byte[] bArr = new byte[8];
        try {
            checkEOF(read(bArr), 8);
            return LittleEndian.getLong(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        byte[] bArr = new byte[2];
        try {
            checkEOF(read(bArr), 2);
            return LittleEndian.getUShort(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void checkEOF(int i, int i2) {
        if (i2 != 0) {
            if (i == -1 || i != i2) {
                throw new RuntimeException("Unexpected end-of-file");
            }
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        try {
            checkEOF(_read(bArr, i, i2), i2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int _read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i2;
        while (i3 > 0) {
            int i4 = read(bArr, (i2 - i3) + i, i3);
            if (-1 == i4) {
                break;
            }
            i3 -= i4;
        }
        return i2 - i3;
    }

    public void readPlain(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2);
    }
}

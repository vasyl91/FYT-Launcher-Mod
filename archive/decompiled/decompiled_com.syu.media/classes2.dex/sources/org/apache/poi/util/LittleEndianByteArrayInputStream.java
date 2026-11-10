package org.apache.poi.util;

import java.io.ByteArrayInputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LittleEndianByteArrayInputStream extends ByteArrayInputStream implements LittleEndianInput {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public LittleEndianByteArrayInputStream(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr, int i) {
        this(bArr, i, bArr.length - i);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr) {
        this(bArr, 0);
    }

    protected void checkPosition(int i) {
        if (i > this.count - this.pos) {
            throw new RuntimeException("Buffer overrun");
        }
    }

    public int getReadIndex() {
        return this.pos;
    }

    public void setReadIndex(int i) {
        if (i < 0 || i >= this.count) {
            throw new IndexOutOfBoundsException();
        }
        this.pos = i;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkPosition(1);
        return (byte) read();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkPosition(4);
        int i = LittleEndian.getInt(this.buf, this.pos);
        super.skip(4L);
        return i;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkPosition(8);
        long j = LittleEndian.getLong(this.buf, this.pos);
        super.skip(8L);
        return j;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkPosition(2);
        short s = LittleEndian.getShort(this.buf, this.pos);
        super.skip(2L);
        return s;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & UByte.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & 65535;
    }

    public long readUInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        checkPosition(i2);
        read(bArr, i, i2);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        checkPosition(bArr.length);
        read(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2);
    }
}

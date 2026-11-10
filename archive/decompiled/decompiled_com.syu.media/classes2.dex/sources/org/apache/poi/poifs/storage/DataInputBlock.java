package org.apache.poi.poifs.storage;

import kotlin.UByte;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataInputBlock {
    private final byte[] _buf;
    private int _maxIndex;
    private int _readIndex;

    DataInputBlock(byte[] bArr, int i) {
        this._buf = bArr;
        this._readIndex = i;
        this._maxIndex = bArr.length;
    }

    public int available() {
        return this._maxIndex - this._readIndex;
    }

    public int readUByte() {
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public int readUShortLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        int i4 = bArr[i2] & UByte.MAX_VALUE;
        this._readIndex = i2 + 1;
        return (i4 << 8) + (i3 << 0);
    }

    public int readUShortLE(DataInputBlock dataInputBlock) {
        byte[] bArr = dataInputBlock._buf;
        int i = bArr[bArr.length - 1] & UByte.MAX_VALUE;
        byte[] bArr2 = this._buf;
        int i2 = this._readIndex;
        this._readIndex = i2 + 1;
        return ((bArr2[i2] & UByte.MAX_VALUE) << 8) + (i << 0);
    }

    public int readIntLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        int i4 = i2 + 1;
        int i5 = bArr[i2] & UByte.MAX_VALUE;
        int i6 = i4 + 1;
        int i7 = bArr[i4] & UByte.MAX_VALUE;
        int i8 = bArr[i6] & UByte.MAX_VALUE;
        this._readIndex = i6 + 1;
        return (i8 << 24) + (i7 << 16) + (i5 << 8) + (i3 << 0);
    }

    public int readIntLE(DataInputBlock dataInputBlock, int i) {
        byte[] bArr = new byte[4];
        readSpanning(dataInputBlock, i, bArr);
        int i2 = bArr[0] & UByte.MAX_VALUE;
        int i3 = bArr[1] & UByte.MAX_VALUE;
        return ((bArr[3] & UByte.MAX_VALUE) << 24) + ((bArr[2] & UByte.MAX_VALUE) << 16) + (i3 << 8) + (i2 << 0);
    }

    public long readLongLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        int i4 = i2 + 1;
        int i5 = bArr[i2] & UByte.MAX_VALUE;
        int i6 = i4 + 1;
        int i7 = bArr[i4] & UByte.MAX_VALUE;
        int i8 = i6 + 1;
        int i9 = bArr[i6] & UByte.MAX_VALUE;
        int i10 = i8 + 1;
        int i11 = bArr[i8] & UByte.MAX_VALUE;
        int i12 = i10 + 1;
        int i13 = bArr[i10] & UByte.MAX_VALUE;
        int i14 = i12 + 1;
        int i15 = bArr[i12] & UByte.MAX_VALUE;
        int i16 = bArr[i14] & UByte.MAX_VALUE;
        this._readIndex = i14 + 1;
        return (((long) i16) << 56) + (((long) i15) << 48) + (((long) i13) << 40) + (((long) i11) << 32) + (((long) i9) << 24) + ((long) (i7 << 16)) + ((long) (i5 << 8)) + ((long) (i3 << 0));
    }

    public long readLongLE(DataInputBlock dataInputBlock, int i) {
        byte[] bArr = new byte[8];
        readSpanning(dataInputBlock, i, bArr);
        int i2 = bArr[0] & UByte.MAX_VALUE;
        int i3 = bArr[1] & UByte.MAX_VALUE;
        int i4 = bArr[2] & UByte.MAX_VALUE;
        int i5 = bArr[3] & UByte.MAX_VALUE;
        int i6 = bArr[4] & UByte.MAX_VALUE;
        int i7 = bArr[5] & UByte.MAX_VALUE;
        return (((long) (bArr[7] & UByte.MAX_VALUE)) << 56) + (((long) (bArr[6] & UByte.MAX_VALUE)) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + ((long) (i4 << 16)) + ((long) (i3 << 8)) + ((long) (i2 << 0));
    }

    private void readSpanning(DataInputBlock dataInputBlock, int i, byte[] bArr) {
        System.arraycopy(dataInputBlock._buf, dataInputBlock._readIndex, bArr, 0, i);
        int length = bArr.length - i;
        System.arraycopy(this._buf, 0, bArr, i, length);
        this._readIndex = length;
    }

    public void readFully(byte[] bArr, int i, int i2) {
        System.arraycopy(this._buf, this._readIndex, bArr, i, i2);
        this._readIndex += i2;
    }
}

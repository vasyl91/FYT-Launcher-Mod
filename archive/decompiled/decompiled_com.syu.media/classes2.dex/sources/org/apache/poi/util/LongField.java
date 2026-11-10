package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LongField implements FixedField {
    private final int _offset;
    private long _value;

    public LongField(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Illegal offset: " + i);
        }
        this._offset = i;
    }

    public LongField(int i, long j) throws ArrayIndexOutOfBoundsException {
        this(i);
        set(j);
    }

    public LongField(int i, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        readFromBytes(bArr);
    }

    public LongField(int i, long j, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        set(j, bArr);
    }

    public long get() {
        return this._value;
    }

    public void set(long j) {
        this._value = j;
    }

    public void set(long j, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = j;
        writeToBytes(bArr);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = LittleEndian.getLong(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) throws IOException {
        this._value = LittleEndian.readLong(inputStream);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        LittleEndian.putLong(bArr, this._offset, this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf(this._value);
    }
}

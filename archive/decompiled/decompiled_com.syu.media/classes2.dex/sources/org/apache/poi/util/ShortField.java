package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ShortField implements FixedField {
    private final int _offset;
    private short _value;

    public ShortField(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Illegal offset: " + i);
        }
        this._offset = i;
    }

    public ShortField(int i, short s) throws ArrayIndexOutOfBoundsException {
        this(i);
        set(s);
    }

    public ShortField(int i, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        readFromBytes(bArr);
    }

    public ShortField(int i, short s, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        set(s, bArr);
    }

    public short get() {
        return this._value;
    }

    public void set(short s) {
        this._value = s;
    }

    public void set(short s, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = s;
        writeToBytes(bArr);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = LittleEndian.getShort(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) throws IOException {
        this._value = LittleEndian.readShort(inputStream);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        LittleEndian.putShort(bArr, this._offset, this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf((int) this._value);
    }
}

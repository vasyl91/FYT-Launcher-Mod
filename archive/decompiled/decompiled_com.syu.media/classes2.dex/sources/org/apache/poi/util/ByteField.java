package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ByteField implements FixedField {
    private static final byte _default_value = 0;
    private final int _offset;
    private byte _value;

    public ByteField(int i) throws ArrayIndexOutOfBoundsException {
        this(i, (byte) 0);
    }

    public ByteField(int i, byte b) throws ArrayIndexOutOfBoundsException {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("offset cannot be negative");
        }
        this._offset = i;
        set(b);
    }

    public ByteField(int i, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        readFromBytes(bArr);
    }

    public ByteField(int i, byte b, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i, b);
        writeToBytes(bArr);
    }

    public byte get() {
        return this._value;
    }

    public void set(byte b) {
        this._value = b;
    }

    public void set(byte b, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        set(b);
        writeToBytes(bArr);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = bArr[this._offset];
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i < 0) {
            throw new BufferUnderflowException();
        }
        this._value = (byte) i;
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        bArr[this._offset] = this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf((int) this._value);
    }
}

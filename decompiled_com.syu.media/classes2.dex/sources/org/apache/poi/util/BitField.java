package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal(since = "POI 3.15 beta 3")
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i) {
        this._mask = i;
        int i2 = 0;
        if (i != 0) {
            while ((i & 1) == 0) {
                i2++;
                i >>= 1;
            }
        }
        this._shift_count = i2;
    }

    public int getValue(int i) {
        return getRawValue(i) >>> this._shift_count;
    }

    public short getShortValue(short s) {
        return (short) getValue(s);
    }

    public int getRawValue(int i) {
        return i & this._mask;
    }

    public short getShortRawValue(short s) {
        return (short) getRawValue(s);
    }

    public boolean isSet(int i) {
        return (i & this._mask) != 0;
    }

    public boolean isAllSet(int i) {
        int i2 = this._mask;
        return (i & i2) == i2;
    }

    public int setValue(int i, int i2) {
        int i3 = this._mask;
        return (i & (~i3)) | ((i2 << this._shift_count) & i3);
    }

    public short setShortValue(short s, short s2) {
        return (short) setValue(s, s2);
    }

    public int clear(int i) {
        return i & (~this._mask);
    }

    public short clearShort(short s) {
        return (short) clear(s);
    }

    public byte clearByte(byte b) {
        return (byte) clear(b);
    }

    public int set(int i) {
        return i | this._mask;
    }

    public short setShort(short s) {
        return (short) set(s);
    }

    public byte setByte(byte b) {
        return (byte) set(b);
    }

    public int setBoolean(int i, boolean z) {
        return z ? set(i) : clear(i);
    }

    public short setShortBoolean(short s, boolean z) {
        return z ? setShort(s) : clearShort(s);
    }

    public byte setByteBoolean(byte b, boolean z) {
        return z ? setByte(b) : clearByte(b);
    }
}

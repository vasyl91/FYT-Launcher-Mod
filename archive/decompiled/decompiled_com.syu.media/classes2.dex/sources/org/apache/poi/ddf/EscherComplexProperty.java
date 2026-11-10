package org.apache.poi.ddf;

import java.util.Arrays;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherComplexProperty extends EscherProperty {
    private byte[] _complexData;

    public EscherComplexProperty(short s, byte[] bArr) {
        super(s);
        if (bArr == null) {
            throw new IllegalArgumentException("complexData can't be null");
        }
        this._complexData = (byte[]) bArr.clone();
    }

    public EscherComplexProperty(short s, boolean z, byte[] bArr) {
        super(s, true, z);
        if (bArr == null) {
            throw new IllegalArgumentException("complexData can't be null");
        }
        this._complexData = (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i) {
        LittleEndian.putShort(bArr, i, getId());
        LittleEndian.putInt(bArr, i + 2, this._complexData.length);
        return 6;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] bArr, int i) {
        byte[] bArr2 = this._complexData;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        return this._complexData.length;
    }

    public byte[] getComplexData() {
        return this._complexData;
    }

    protected void setComplexData(byte[] bArr) {
        this._complexData = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EscherComplexProperty)) {
            return false;
        }
        return Arrays.equals(this._complexData, ((EscherComplexProperty) obj)._complexData);
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int getPropertySize() {
        return this._complexData.length + 6;
    }

    public int hashCode() {
        return getId() * 11;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public String toString() {
        return "propNum: " + ((int) getPropertyNumber()) + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", data: " + System.getProperty("line.separator") + HexDump.toHex(this._complexData, 32);
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        return str + "<" + getClass().getSimpleName() + " id=\"0x" + HexDump.toHex(getId()) + "\" name=\"" + getName() + "\" blipId=\"" + isBlipId() + "\">\n" + str + "</" + getClass().getSimpleName() + ">";
    }
}

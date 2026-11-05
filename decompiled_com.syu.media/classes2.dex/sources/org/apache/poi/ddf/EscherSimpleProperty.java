package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherSimpleProperty extends EscherProperty {
    private int propertyValue;

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] bArr, int i) {
        return 0;
    }

    public EscherSimpleProperty(short s, int i) {
        super(s);
        this.propertyValue = i;
    }

    public EscherSimpleProperty(short s, boolean z, boolean z2, int i) {
        super(s, z, z2);
        this.propertyValue = i;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i) {
        LittleEndian.putShort(bArr, i, getId());
        LittleEndian.putInt(bArr, i + 2, this.propertyValue);
        return 6;
    }

    public int getPropertyValue() {
        return this.propertyValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EscherSimpleProperty)) {
            return false;
        }
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) obj;
        return this.propertyValue == escherSimpleProperty.propertyValue && getId() == escherSimpleProperty.getId();
    }

    public int hashCode() {
        return this.propertyValue;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public String toString() {
        return "propNum: " + ((int) getPropertyNumber()) + ", RAW: 0x" + HexDump.toHex(getId()) + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", value: " + this.propertyValue + " (0x" + HexDump.toHex(this.propertyValue) + ")";
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\" complex=\"").append(isComplex()).append("\" value=\"0x").append(HexDump.toHex(this.propertyValue)).append("\"/>");
        return sb.toString();
    }
}

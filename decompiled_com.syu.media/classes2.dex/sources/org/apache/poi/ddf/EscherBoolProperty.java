package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherBoolProperty extends EscherSimpleProperty {
    public EscherBoolProperty(short s, int i) {
        super(s, i);
    }

    public boolean isTrue() {
        return getPropertyValue() != 0;
    }

    @Deprecated
    public boolean isFalse() {
        return !isTrue();
    }

    @Override // org.apache.poi.ddf.EscherSimpleProperty, org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" simpleValue=\"").append(getPropertyValue()).append("\" blipId=\"").append(isBlipId()).append("\" value=\"").append(isTrue()).append("\"/>");
        return sb.toString();
    }
}

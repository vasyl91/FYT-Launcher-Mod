package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherRGBProperty extends EscherSimpleProperty {
    public EscherRGBProperty(short s, int i) {
        super(s, i);
    }

    public int getRgbColor() {
        return getPropertyValue();
    }

    public byte getRed() {
        return (byte) (getRgbColor() & 255);
    }

    public byte getGreen() {
        return (byte) ((getRgbColor() >> 8) & 255);
    }

    public byte getBlue() {
        return (byte) ((getRgbColor() >> 16) & 255);
    }

    @Override // org.apache.poi.ddf.EscherSimpleProperty, org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\" value=\"0x").append(HexDump.toHex(getRgbColor())).append("\"/>");
        return sb.toString();
    }
}

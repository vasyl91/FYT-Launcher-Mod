package org.apache.poi.ddf;

import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.hpsf.Variant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class EscherProperty {
    private short _id;

    public int getPropertySize() {
        return 6;
    }

    public abstract int serializeComplexPart(byte[] bArr, int i);

    public abstract int serializeSimplePart(byte[] bArr, int i);

    public abstract String toString();

    public EscherProperty(short s) {
        this._id = s;
    }

    public EscherProperty(short s, boolean z, boolean z2) {
        this._id = (short) (s + (z ? ShortCompanionObject.MIN_VALUE : (short) 0) + (z2 ? Variant.VT_BYREF : 0));
    }

    public short getId() {
        return this._id;
    }

    public short getPropertyNumber() {
        return (short) (this._id & 16383);
    }

    public boolean isComplex() {
        return (this._id & ShortCompanionObject.MIN_VALUE) != 0;
    }

    public boolean isBlipId() {
        return (this._id & 16384) != 0;
    }

    public String getName() {
        return EscherProperties.getPropertyName(getPropertyNumber());
    }

    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"").append((int) getId()).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\"/>\n");
        return sb.toString();
    }
}

package org.apache.poi.hssf.record.cf;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IconMultiStateThreshold extends Threshold implements Cloneable {
    public static final byte EQUALS_EXCLUDE = 0;
    public static final byte EQUALS_INCLUDE = 1;
    private byte equals;

    public IconMultiStateThreshold() {
        this.equals = (byte) 1;
    }

    public IconMultiStateThreshold(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
        this.equals = littleEndianInput.readByte();
        littleEndianInput.readInt();
    }

    public byte getEquals() {
        return this.equals;
    }

    public void setEquals(byte b) {
        this.equals = b;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public int getDataLength() {
        return super.getDataLength() + 5;
    }

    public IconMultiStateThreshold clone() {
        IconMultiStateThreshold iconMultiStateThreshold = new IconMultiStateThreshold();
        super.copyTo(iconMultiStateThreshold);
        iconMultiStateThreshold.equals = this.equals;
        return iconMultiStateThreshold;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public void serialize(LittleEndianOutput littleEndianOutput) {
        super.serialize(littleEndianOutput);
        littleEndianOutput.writeByte(this.equals);
        littleEndianOutput.writeInt(0);
    }
}

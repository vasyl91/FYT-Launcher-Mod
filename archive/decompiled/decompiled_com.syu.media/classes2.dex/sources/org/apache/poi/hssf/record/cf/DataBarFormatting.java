package org.apache.poi.hssf.record.cf;

import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataBarFormatting implements Cloneable {
    private ExtendedColor color;
    private byte options;
    private byte percentMax;
    private byte percentMin;
    private DataBarThreshold thresholdMax;
    private DataBarThreshold thresholdMin;
    private static POILogger log = POILogFactory.getLogger((Class<?>) DataBarFormatting.class);
    private static BitField iconOnly = BitFieldFactory.getInstance(1);
    private static BitField reversed = BitFieldFactory.getInstance(4);

    public DataBarFormatting() {
        this.percentMin = (byte) 0;
        this.percentMax = (byte) 0;
        this.options = (byte) 2;
    }

    public DataBarFormatting(LittleEndianInput littleEndianInput) {
        this.options = (byte) 0;
        this.percentMin = (byte) 0;
        this.percentMax = (byte) 0;
        littleEndianInput.readShort();
        littleEndianInput.readByte();
        this.options = littleEndianInput.readByte();
        this.percentMin = littleEndianInput.readByte();
        this.percentMax = littleEndianInput.readByte();
        byte b = this.percentMin;
        if (b < 0 || b > 100) {
            log.log(5, "Inconsistent Minimum Percentage found " + ((int) this.percentMin));
        }
        byte b2 = this.percentMax;
        if (b2 < 0 || b2 > 100) {
            log.log(5, "Inconsistent Minimum Percentage found " + ((int) this.percentMin));
        }
        this.color = new ExtendedColor(littleEndianInput);
        this.thresholdMin = new DataBarThreshold(littleEndianInput);
        this.thresholdMax = new DataBarThreshold(littleEndianInput);
    }

    public boolean isIconOnly() {
        return getOptionFlag(iconOnly);
    }

    public void setIconOnly(boolean z) {
        setOptionFlag(z, iconOnly);
    }

    public boolean isReversed() {
        return getOptionFlag(reversed);
    }

    public void setReversed(boolean z) {
        setOptionFlag(z, reversed);
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.getValue(this.options) != 0;
    }

    private void setOptionFlag(boolean z, BitField bitField) {
        this.options = bitField.setByteBoolean(this.options, z);
    }

    public byte getPercentMin() {
        return this.percentMin;
    }

    public void setPercentMin(byte b) {
        this.percentMin = b;
    }

    public byte getPercentMax() {
        return this.percentMax;
    }

    public void setPercentMax(byte b) {
        this.percentMax = b;
    }

    public ExtendedColor getColor() {
        return this.color;
    }

    public void setColor(ExtendedColor extendedColor) {
        this.color = extendedColor;
    }

    public DataBarThreshold getThresholdMin() {
        return this.thresholdMin;
    }

    public void setThresholdMin(DataBarThreshold dataBarThreshold) {
        this.thresholdMin = dataBarThreshold;
    }

    public DataBarThreshold getThresholdMax() {
        return this.thresholdMax;
    }

    public void setThresholdMax(DataBarThreshold dataBarThreshold) {
        this.thresholdMax = dataBarThreshold;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("    [Data Bar Formatting]\n          .icon_only= ");
        stringBuffer.append(isIconOnly()).append("\n          .reversed = ");
        stringBuffer.append(isReversed()).append("\n");
        stringBuffer.append(this.color);
        stringBuffer.append(this.thresholdMin);
        stringBuffer.append(this.thresholdMax);
        stringBuffer.append("    [/Data Bar Formatting]\n");
        return stringBuffer.toString();
    }

    public Object clone() {
        DataBarFormatting dataBarFormatting = new DataBarFormatting();
        dataBarFormatting.options = this.options;
        dataBarFormatting.percentMin = this.percentMin;
        dataBarFormatting.percentMax = this.percentMax;
        dataBarFormatting.color = this.color.clone();
        dataBarFormatting.thresholdMin = this.thresholdMin.clone();
        dataBarFormatting.thresholdMax = this.thresholdMax.clone();
        return dataBarFormatting;
    }

    public int getDataLength() {
        return this.color.getDataLength() + 6 + this.thresholdMin.getDataLength() + this.thresholdMax.getDataLength();
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.writeByte(this.options);
        littleEndianOutput.writeByte(this.percentMin);
        littleEndianOutput.writeByte(this.percentMax);
        this.color.serialize(littleEndianOutput);
        this.thresholdMin.serialize(littleEndianOutput);
        this.thresholdMax.serialize(littleEndianOutput);
    }
}

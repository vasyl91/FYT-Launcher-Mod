package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AxisOptionsRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4194;
    private short field_1_minimumCategory;
    private short field_2_maximumCategory;
    private short field_3_majorUnitValue;
    private short field_4_majorUnit;
    private short field_5_minorUnitValue;
    private short field_6_minorUnit;
    private short field_7_baseUnit;
    private short field_8_crossingPoint;
    private short field_9_options;
    private static final BitField defaultMinimum = BitFieldFactory.getInstance(1);
    private static final BitField defaultMaximum = BitFieldFactory.getInstance(2);
    private static final BitField defaultMajor = BitFieldFactory.getInstance(4);
    private static final BitField defaultMinorUnit = BitFieldFactory.getInstance(8);
    private static final BitField isDate = BitFieldFactory.getInstance(16);
    private static final BitField defaultBase = BitFieldFactory.getInstance(32);
    private static final BitField defaultCross = BitFieldFactory.getInstance(64);
    private static final BitField defaultDateSettings = BitFieldFactory.getInstance(128);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AxisOptionsRecord() {
    }

    public AxisOptionsRecord(RecordInputStream recordInputStream) {
        this.field_1_minimumCategory = recordInputStream.readShort();
        this.field_2_maximumCategory = recordInputStream.readShort();
        this.field_3_majorUnitValue = recordInputStream.readShort();
        this.field_4_majorUnit = recordInputStream.readShort();
        this.field_5_minorUnitValue = recordInputStream.readShort();
        this.field_6_minorUnit = recordInputStream.readShort();
        this.field_7_baseUnit = recordInputStream.readShort();
        this.field_8_crossingPoint = recordInputStream.readShort();
        this.field_9_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[AXCEXT]\n    .minimumCategory      = 0x");
        stringBuffer.append(HexDump.toHex(getMinimumCategory())).append(" (").append((int) getMinimumCategory()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .maximumCategory      = 0x").append(HexDump.toHex(getMaximumCategory())).append(" (").append((int) getMaximumCategory()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .majorUnitValue       = 0x").append(HexDump.toHex(getMajorUnitValue())).append(" (").append((int) getMajorUnitValue()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .majorUnit            = 0x").append(HexDump.toHex(getMajorUnit())).append(" (").append((int) getMajorUnit()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .minorUnitValue       = 0x").append(HexDump.toHex(getMinorUnitValue())).append(" (").append((int) getMinorUnitValue()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .minorUnit            = 0x").append(HexDump.toHex(getMinorUnit())).append(" (").append((int) getMinorUnit()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .baseUnit             = 0x").append(HexDump.toHex(getBaseUnit())).append(" (").append((int) getBaseUnit()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .crossingPoint        = 0x").append(HexDump.toHex(getCrossingPoint())).append(" (").append((int) getCrossingPoint()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .options              = 0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .defaultMinimum           = ").append(isDefaultMinimum()).append("\n         .defaultMaximum           = ");
        stringBuffer.append(isDefaultMaximum()).append("\n         .defaultMajor             = ");
        stringBuffer.append(isDefaultMajor()).append("\n         .defaultMinorUnit         = ");
        stringBuffer.append(isDefaultMinorUnit()).append("\n         .isDate                   = ");
        stringBuffer.append(isIsDate()).append("\n         .defaultBase              = ");
        stringBuffer.append(isDefaultBase()).append("\n         .defaultCross             = ");
        stringBuffer.append(isDefaultCross()).append("\n         .defaultDateSettings      = ");
        stringBuffer.append(isDefaultDateSettings()).append("\n[/AXCEXT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_minimumCategory);
        littleEndianOutput.writeShort(this.field_2_maximumCategory);
        littleEndianOutput.writeShort(this.field_3_majorUnitValue);
        littleEndianOutput.writeShort(this.field_4_majorUnit);
        littleEndianOutput.writeShort(this.field_5_minorUnitValue);
        littleEndianOutput.writeShort(this.field_6_minorUnit);
        littleEndianOutput.writeShort(this.field_7_baseUnit);
        littleEndianOutput.writeShort(this.field_8_crossingPoint);
        littleEndianOutput.writeShort(this.field_9_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public AxisOptionsRecord clone() {
        AxisOptionsRecord axisOptionsRecord = new AxisOptionsRecord();
        axisOptionsRecord.field_1_minimumCategory = this.field_1_minimumCategory;
        axisOptionsRecord.field_2_maximumCategory = this.field_2_maximumCategory;
        axisOptionsRecord.field_3_majorUnitValue = this.field_3_majorUnitValue;
        axisOptionsRecord.field_4_majorUnit = this.field_4_majorUnit;
        axisOptionsRecord.field_5_minorUnitValue = this.field_5_minorUnitValue;
        axisOptionsRecord.field_6_minorUnit = this.field_6_minorUnit;
        axisOptionsRecord.field_7_baseUnit = this.field_7_baseUnit;
        axisOptionsRecord.field_8_crossingPoint = this.field_8_crossingPoint;
        axisOptionsRecord.field_9_options = this.field_9_options;
        return axisOptionsRecord;
    }

    public short getMinimumCategory() {
        return this.field_1_minimumCategory;
    }

    public void setMinimumCategory(short s) {
        this.field_1_minimumCategory = s;
    }

    public short getMaximumCategory() {
        return this.field_2_maximumCategory;
    }

    public void setMaximumCategory(short s) {
        this.field_2_maximumCategory = s;
    }

    public short getMajorUnitValue() {
        return this.field_3_majorUnitValue;
    }

    public void setMajorUnitValue(short s) {
        this.field_3_majorUnitValue = s;
    }

    public short getMajorUnit() {
        return this.field_4_majorUnit;
    }

    public void setMajorUnit(short s) {
        this.field_4_majorUnit = s;
    }

    public short getMinorUnitValue() {
        return this.field_5_minorUnitValue;
    }

    public void setMinorUnitValue(short s) {
        this.field_5_minorUnitValue = s;
    }

    public short getMinorUnit() {
        return this.field_6_minorUnit;
    }

    public void setMinorUnit(short s) {
        this.field_6_minorUnit = s;
    }

    public short getBaseUnit() {
        return this.field_7_baseUnit;
    }

    public void setBaseUnit(short s) {
        this.field_7_baseUnit = s;
    }

    public short getCrossingPoint() {
        return this.field_8_crossingPoint;
    }

    public void setCrossingPoint(short s) {
        this.field_8_crossingPoint = s;
    }

    public short getOptions() {
        return this.field_9_options;
    }

    public void setOptions(short s) {
        this.field_9_options = s;
    }

    public void setDefaultMinimum(boolean z) {
        this.field_9_options = defaultMinimum.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultMinimum() {
        return defaultMinimum.isSet(this.field_9_options);
    }

    public void setDefaultMaximum(boolean z) {
        this.field_9_options = defaultMaximum.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultMaximum() {
        return defaultMaximum.isSet(this.field_9_options);
    }

    public void setDefaultMajor(boolean z) {
        this.field_9_options = defaultMajor.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultMajor() {
        return defaultMajor.isSet(this.field_9_options);
    }

    public void setDefaultMinorUnit(boolean z) {
        this.field_9_options = defaultMinorUnit.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultMinorUnit() {
        return defaultMinorUnit.isSet(this.field_9_options);
    }

    public void setIsDate(boolean z) {
        this.field_9_options = isDate.setShortBoolean(this.field_9_options, z);
    }

    public boolean isIsDate() {
        return isDate.isSet(this.field_9_options);
    }

    public void setDefaultBase(boolean z) {
        this.field_9_options = defaultBase.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultBase() {
        return defaultBase.isSet(this.field_9_options);
    }

    public void setDefaultCross(boolean z) {
        this.field_9_options = defaultCross.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultCross() {
        return defaultCross.isSet(this.field_9_options);
    }

    public void setDefaultDateSettings(boolean z) {
        this.field_9_options = defaultDateSettings.setShortBoolean(this.field_9_options, z);
    }

    public boolean isDefaultDateSettings() {
        return defaultDateSettings.isSet(this.field_9_options);
    }
}

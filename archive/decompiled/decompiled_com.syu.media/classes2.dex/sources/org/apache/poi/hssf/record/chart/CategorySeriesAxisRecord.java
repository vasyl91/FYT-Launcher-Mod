package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CategorySeriesAxisRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4128;
    private short field_1_crossingPoint;
    private short field_2_labelFrequency;
    private short field_3_tickMarkFrequency;
    private short field_4_options;
    private static final BitField valueAxisCrossing = BitFieldFactory.getInstance(1);
    private static final BitField crossesFarRight = BitFieldFactory.getInstance(2);
    private static final BitField reversed = BitFieldFactory.getInstance(4);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public CategorySeriesAxisRecord() {
    }

    public CategorySeriesAxisRecord(RecordInputStream recordInputStream) {
        this.field_1_crossingPoint = recordInputStream.readShort();
        this.field_2_labelFrequency = recordInputStream.readShort();
        this.field_3_tickMarkFrequency = recordInputStream.readShort();
        this.field_4_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CATSERRANGE]\n    .crossingPoint        = 0x");
        stringBuffer.append(HexDump.toHex(getCrossingPoint())).append(" (").append((int) getCrossingPoint()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .labelFrequency       = 0x").append(HexDump.toHex(getLabelFrequency())).append(" (").append((int) getLabelFrequency()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .tickMarkFrequency    = 0x").append(HexDump.toHex(getTickMarkFrequency())).append(" (").append((int) getTickMarkFrequency()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .options              = 0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .valueAxisCrossing        = ").append(isValueAxisCrossing()).append("\n         .crossesFarRight          = ");
        stringBuffer.append(isCrossesFarRight()).append("\n         .reversed                 = ");
        stringBuffer.append(isReversed()).append("\n[/CATSERRANGE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_crossingPoint);
        littleEndianOutput.writeShort(this.field_2_labelFrequency);
        littleEndianOutput.writeShort(this.field_3_tickMarkFrequency);
        littleEndianOutput.writeShort(this.field_4_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public CategorySeriesAxisRecord clone() {
        CategorySeriesAxisRecord categorySeriesAxisRecord = new CategorySeriesAxisRecord();
        categorySeriesAxisRecord.field_1_crossingPoint = this.field_1_crossingPoint;
        categorySeriesAxisRecord.field_2_labelFrequency = this.field_2_labelFrequency;
        categorySeriesAxisRecord.field_3_tickMarkFrequency = this.field_3_tickMarkFrequency;
        categorySeriesAxisRecord.field_4_options = this.field_4_options;
        return categorySeriesAxisRecord;
    }

    public short getCrossingPoint() {
        return this.field_1_crossingPoint;
    }

    public void setCrossingPoint(short s) {
        this.field_1_crossingPoint = s;
    }

    public short getLabelFrequency() {
        return this.field_2_labelFrequency;
    }

    public void setLabelFrequency(short s) {
        this.field_2_labelFrequency = s;
    }

    public short getTickMarkFrequency() {
        return this.field_3_tickMarkFrequency;
    }

    public void setTickMarkFrequency(short s) {
        this.field_3_tickMarkFrequency = s;
    }

    public short getOptions() {
        return this.field_4_options;
    }

    public void setOptions(short s) {
        this.field_4_options = s;
    }

    public void setValueAxisCrossing(boolean z) {
        this.field_4_options = valueAxisCrossing.setShortBoolean(this.field_4_options, z);
    }

    public boolean isValueAxisCrossing() {
        return valueAxisCrossing.isSet(this.field_4_options);
    }

    public void setCrossesFarRight(boolean z) {
        this.field_4_options = crossesFarRight.setShortBoolean(this.field_4_options, z);
    }

    public boolean isCrossesFarRight() {
        return crossesFarRight.isSet(this.field_4_options);
    }

    public void setReversed(boolean z) {
        this.field_4_options = reversed.setShortBoolean(this.field_4_options, z);
    }

    public boolean isReversed() {
        return reversed.isSet(this.field_4_options);
    }
}

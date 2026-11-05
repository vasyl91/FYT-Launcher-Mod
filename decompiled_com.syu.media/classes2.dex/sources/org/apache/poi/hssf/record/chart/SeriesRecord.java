package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SeriesRecord extends StandardRecord {
    public static final short BUBBLE_SERIES_TYPE_DATES = 0;
    public static final short BUBBLE_SERIES_TYPE_NUMERIC = 1;
    public static final short BUBBLE_SERIES_TYPE_SEQUENCE = 2;
    public static final short BUBBLE_SERIES_TYPE_TEXT = 3;
    public static final short CATEGORY_DATA_TYPE_DATES = 0;
    public static final short CATEGORY_DATA_TYPE_NUMERIC = 1;
    public static final short CATEGORY_DATA_TYPE_SEQUENCE = 2;
    public static final short CATEGORY_DATA_TYPE_TEXT = 3;
    public static final short VALUES_DATA_TYPE_DATES = 0;
    public static final short VALUES_DATA_TYPE_NUMERIC = 1;
    public static final short VALUES_DATA_TYPE_SEQUENCE = 2;
    public static final short VALUES_DATA_TYPE_TEXT = 3;
    public static final short sid = 4099;
    private short field_1_categoryDataType;
    private short field_2_valuesDataType;
    private short field_3_numCategories;
    private short field_4_numValues;
    private short field_5_bubbleSeriesType;
    private short field_6_numBubbleValues;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public SeriesRecord() {
    }

    public SeriesRecord(RecordInputStream recordInputStream) {
        this.field_1_categoryDataType = recordInputStream.readShort();
        this.field_2_valuesDataType = recordInputStream.readShort();
        this.field_3_numCategories = recordInputStream.readShort();
        this.field_4_numValues = recordInputStream.readShort();
        this.field_5_bubbleSeriesType = recordInputStream.readShort();
        this.field_6_numBubbleValues = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SERIES]\n    .categoryDataType     = 0x");
        stringBuffer.append(HexDump.toHex(getCategoryDataType())).append(" (").append((int) getCategoryDataType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .valuesDataType       = 0x").append(HexDump.toHex(getValuesDataType())).append(" (").append((int) getValuesDataType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .numCategories        = 0x").append(HexDump.toHex(getNumCategories())).append(" (").append((int) getNumCategories()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .numValues            = 0x").append(HexDump.toHex(getNumValues())).append(" (").append((int) getNumValues()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .bubbleSeriesType     = 0x").append(HexDump.toHex(getBubbleSeriesType())).append(" (").append((int) getBubbleSeriesType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .numBubbleValues      = 0x").append(HexDump.toHex(getNumBubbleValues())).append(" (").append((int) getNumBubbleValues()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/SERIES]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_categoryDataType);
        littleEndianOutput.writeShort(this.field_2_valuesDataType);
        littleEndianOutput.writeShort(this.field_3_numCategories);
        littleEndianOutput.writeShort(this.field_4_numValues);
        littleEndianOutput.writeShort(this.field_5_bubbleSeriesType);
        littleEndianOutput.writeShort(this.field_6_numBubbleValues);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SeriesRecord seriesRecord = new SeriesRecord();
        seriesRecord.field_1_categoryDataType = this.field_1_categoryDataType;
        seriesRecord.field_2_valuesDataType = this.field_2_valuesDataType;
        seriesRecord.field_3_numCategories = this.field_3_numCategories;
        seriesRecord.field_4_numValues = this.field_4_numValues;
        seriesRecord.field_5_bubbleSeriesType = this.field_5_bubbleSeriesType;
        seriesRecord.field_6_numBubbleValues = this.field_6_numBubbleValues;
        return seriesRecord;
    }

    public short getCategoryDataType() {
        return this.field_1_categoryDataType;
    }

    public void setCategoryDataType(short s) {
        this.field_1_categoryDataType = s;
    }

    public short getValuesDataType() {
        return this.field_2_valuesDataType;
    }

    public void setValuesDataType(short s) {
        this.field_2_valuesDataType = s;
    }

    public short getNumCategories() {
        return this.field_3_numCategories;
    }

    public void setNumCategories(short s) {
        this.field_3_numCategories = s;
    }

    public short getNumValues() {
        return this.field_4_numValues;
    }

    public void setNumValues(short s) {
        this.field_4_numValues = s;
    }

    public short getBubbleSeriesType() {
        return this.field_5_bubbleSeriesType;
    }

    public void setBubbleSeriesType(short s) {
        this.field_5_bubbleSeriesType = s;
    }

    public short getNumBubbleValues() {
        return this.field_6_numBubbleValues;
    }

    public void setNumBubbleValues(short s) {
        this.field_6_numBubbleValues = s;
    }
}

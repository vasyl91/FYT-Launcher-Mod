package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataFormatRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4102;
    private static final BitField useExcel4Colors = BitFieldFactory.getInstance(1);
    private short field_1_pointNumber;
    private short field_2_seriesIndex;
    private short field_3_seriesNumber;
    private short field_4_formatFlags;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DataFormatRecord() {
    }

    public DataFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_pointNumber = recordInputStream.readShort();
        this.field_2_seriesIndex = recordInputStream.readShort();
        this.field_3_seriesNumber = recordInputStream.readShort();
        this.field_4_formatFlags = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DATAFORMAT]\n    .pointNumber          = 0x");
        stringBuffer.append(HexDump.toHex(getPointNumber())).append(" (").append((int) getPointNumber()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .seriesIndex          = 0x").append(HexDump.toHex(getSeriesIndex())).append(" (").append((int) getSeriesIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .seriesNumber         = 0x").append(HexDump.toHex(getSeriesNumber())).append(" (").append((int) getSeriesNumber()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .formatFlags          = 0x").append(HexDump.toHex(getFormatFlags())).append(" (").append((int) getFormatFlags()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .useExcel4Colors          = ").append(isUseExcel4Colors()).append("\n[/DATAFORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_pointNumber);
        littleEndianOutput.writeShort(this.field_2_seriesIndex);
        littleEndianOutput.writeShort(this.field_3_seriesNumber);
        littleEndianOutput.writeShort(this.field_4_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public DataFormatRecord clone() {
        DataFormatRecord dataFormatRecord = new DataFormatRecord();
        dataFormatRecord.field_1_pointNumber = this.field_1_pointNumber;
        dataFormatRecord.field_2_seriesIndex = this.field_2_seriesIndex;
        dataFormatRecord.field_3_seriesNumber = this.field_3_seriesNumber;
        dataFormatRecord.field_4_formatFlags = this.field_4_formatFlags;
        return dataFormatRecord;
    }

    public short getPointNumber() {
        return this.field_1_pointNumber;
    }

    public void setPointNumber(short s) {
        this.field_1_pointNumber = s;
    }

    public short getSeriesIndex() {
        return this.field_2_seriesIndex;
    }

    public void setSeriesIndex(short s) {
        this.field_2_seriesIndex = s;
    }

    public short getSeriesNumber() {
        return this.field_3_seriesNumber;
    }

    public void setSeriesNumber(short s) {
        this.field_3_seriesNumber = s;
    }

    public short getFormatFlags() {
        return this.field_4_formatFlags;
    }

    public void setFormatFlags(short s) {
        this.field_4_formatFlags = s;
    }

    public void setUseExcel4Colors(boolean z) {
        this.field_4_formatFlags = useExcel4Colors.setShortBoolean(this.field_4_formatFlags, z);
    }

    public boolean isUseExcel4Colors() {
        return useExcel4Colors.isSet(this.field_4_formatFlags);
    }
}

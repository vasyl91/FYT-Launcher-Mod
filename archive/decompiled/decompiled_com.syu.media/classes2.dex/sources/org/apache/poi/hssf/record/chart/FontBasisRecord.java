package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FontBasisRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4192;
    private short field_1_xBasis;
    private short field_2_yBasis;
    private short field_3_heightBasis;
    private short field_4_scale;
    private short field_5_indexToFontTable;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 10;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public FontBasisRecord() {
    }

    public FontBasisRecord(RecordInputStream recordInputStream) {
        this.field_1_xBasis = recordInputStream.readShort();
        this.field_2_yBasis = recordInputStream.readShort();
        this.field_3_heightBasis = recordInputStream.readShort();
        this.field_4_scale = recordInputStream.readShort();
        this.field_5_indexToFontTable = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FBI]\n    .xBasis               = 0x");
        stringBuffer.append(HexDump.toHex(getXBasis())).append(" (").append((int) getXBasis()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .yBasis               = 0x").append(HexDump.toHex(getYBasis())).append(" (").append((int) getYBasis()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .heightBasis          = 0x").append(HexDump.toHex(getHeightBasis())).append(" (").append((int) getHeightBasis()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .scale                = 0x").append(HexDump.toHex(getScale())).append(" (").append((int) getScale()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .indexToFontTable     = 0x").append(HexDump.toHex(getIndexToFontTable())).append(" (").append((int) getIndexToFontTable()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/FBI]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_xBasis);
        littleEndianOutput.writeShort(this.field_2_yBasis);
        littleEndianOutput.writeShort(this.field_3_heightBasis);
        littleEndianOutput.writeShort(this.field_4_scale);
        littleEndianOutput.writeShort(this.field_5_indexToFontTable);
    }

    @Override // org.apache.poi.hssf.record.Record
    public FontBasisRecord clone() {
        FontBasisRecord fontBasisRecord = new FontBasisRecord();
        fontBasisRecord.field_1_xBasis = this.field_1_xBasis;
        fontBasisRecord.field_2_yBasis = this.field_2_yBasis;
        fontBasisRecord.field_3_heightBasis = this.field_3_heightBasis;
        fontBasisRecord.field_4_scale = this.field_4_scale;
        fontBasisRecord.field_5_indexToFontTable = this.field_5_indexToFontTable;
        return fontBasisRecord;
    }

    public short getXBasis() {
        return this.field_1_xBasis;
    }

    public void setXBasis(short s) {
        this.field_1_xBasis = s;
    }

    public short getYBasis() {
        return this.field_2_yBasis;
    }

    public void setYBasis(short s) {
        this.field_2_yBasis = s;
    }

    public short getHeightBasis() {
        return this.field_3_heightBasis;
    }

    public void setHeightBasis(short s) {
        this.field_3_heightBasis = s;
    }

    public short getScale() {
        return this.field_4_scale;
    }

    public void setScale(short s) {
        this.field_4_scale = s;
    }

    public short getIndexToFontTable() {
        return this.field_5_indexToFontTable;
    }

    public void setIndexToFontTable(short s) {
        this.field_5_indexToFontTable = s;
    }
}

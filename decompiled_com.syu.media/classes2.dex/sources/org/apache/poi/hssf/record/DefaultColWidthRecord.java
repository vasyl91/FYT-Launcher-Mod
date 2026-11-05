package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DefaultColWidthRecord extends StandardRecord implements Cloneable {
    public static final int DEFAULT_COLUMN_WIDTH = 8;
    public static final short sid = 85;
    private int field_1_col_width;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 85;
    }

    public DefaultColWidthRecord() {
        this.field_1_col_width = 8;
    }

    public DefaultColWidthRecord(RecordInputStream recordInputStream) {
        this.field_1_col_width = recordInputStream.readUShort();
    }

    public void setColWidth(int i) {
        this.field_1_col_width = i;
    }

    public int getColWidth() {
        return this.field_1_col_width;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DEFAULTCOLWIDTH]\n    .colwidth      = ");
        stringBuffer.append(Integer.toHexString(getColWidth())).append("\n[/DEFAULTCOLWIDTH]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getColWidth());
    }

    @Override // org.apache.poi.hssf.record.Record
    public DefaultColWidthRecord clone() {
        DefaultColWidthRecord defaultColWidthRecord = new DefaultColWidthRecord();
        defaultColWidthRecord.field_1_col_width = this.field_1_col_width;
        return defaultColWidthRecord;
    }
}

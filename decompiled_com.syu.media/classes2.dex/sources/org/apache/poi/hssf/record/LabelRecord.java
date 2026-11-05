package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LabelRecord extends Record implements CellValueRecordInterface, Cloneable {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) LabelRecord.class);
    public static final short sid = 516;
    private int field_1_row;
    private short field_2_column;
    private short field_3_xf_index;
    private short field_4_string_len;
    private byte field_5_unicode_flag;
    private String field_6_value;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 516;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setColumn(short s) {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setRow(int i) {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setXFIndex(short s) {
    }

    public LabelRecord() {
    }

    public LabelRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_column = recordInputStream.readShort();
        this.field_3_xf_index = recordInputStream.readShort();
        this.field_4_string_len = recordInputStream.readShort();
        this.field_5_unicode_flag = recordInputStream.readByte();
        if (this.field_4_string_len > 0) {
            if (isUnCompressedUnicode()) {
                this.field_6_value = recordInputStream.readUnicodeLEString(this.field_4_string_len);
            } else {
                this.field_6_value = recordInputStream.readCompressedUnicode(this.field_4_string_len);
            }
        } else {
            this.field_6_value = "";
        }
        if (recordInputStream.remaining() > 0) {
            logger.log(3, "LabelRecord data remains: " + recordInputStream.remaining() + " : " + HexDump.toHex(recordInputStream.readRemainder()));
        }
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_column;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf_index;
    }

    public short getStringLength() {
        return this.field_4_string_len;
    }

    public boolean isUnCompressedUnicode() {
        return (this.field_5_unicode_flag & 1) != 0;
    }

    public String getValue() {
        return this.field_6_value;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LABEL]\n    .row       = ");
        stringBuffer.append(HexDump.shortToHex(getRow())).append("\n    .column    = ");
        stringBuffer.append(HexDump.shortToHex(getColumn())).append("\n    .xfindex   = ");
        stringBuffer.append(HexDump.shortToHex(getXFIndex())).append("\n    .string_len= ");
        stringBuffer.append(HexDump.shortToHex(this.field_4_string_len)).append("\n    .unicode_flag= ");
        stringBuffer.append(HexDump.byteToHex(this.field_5_unicode_flag)).append("\n    .value       = ");
        stringBuffer.append(getValue()).append("\n[/LABEL]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public LabelRecord clone() {
        LabelRecord labelRecord = new LabelRecord();
        labelRecord.field_1_row = this.field_1_row;
        labelRecord.field_2_column = this.field_2_column;
        labelRecord.field_3_xf_index = this.field_3_xf_index;
        labelRecord.field_4_string_len = this.field_4_string_len;
        labelRecord.field_5_unicode_flag = this.field_5_unicode_flag;
        labelRecord.field_6_value = this.field_6_value;
        return labelRecord;
    }
}

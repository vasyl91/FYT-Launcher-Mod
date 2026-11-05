package org.apache.poi.hssf.record;

import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CRNRecord extends StandardRecord {
    public static final short sid = 90;
    private int field_1_last_column_index;
    private int field_2_first_column_index;
    private int field_3_row_index;
    private Object[] field_4_constant_values;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 90;
    }

    public CRNRecord() {
        throw new RuntimeException("incomplete code");
    }

    public int getNumberOfCRNs() {
        return this.field_1_last_column_index;
    }

    public CRNRecord(RecordInputStream recordInputStream) {
        this.field_1_last_column_index = recordInputStream.readUByte();
        this.field_2_first_column_index = recordInputStream.readUByte();
        this.field_3_row_index = recordInputStream.readShort();
        this.field_4_constant_values = ConstantValueParser.parse(recordInputStream, (this.field_1_last_column_index - this.field_2_first_column_index) + 1);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName()).append(" [CRN rowIx=");
        stringBuffer.append(this.field_3_row_index);
        stringBuffer.append(" firstColIx=").append(this.field_2_first_column_index);
        stringBuffer.append(" lastColIx=").append(this.field_1_last_column_index);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return ConstantValueParser.getEncodedSize(this.field_4_constant_values) + 4;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_1_last_column_index);
        littleEndianOutput.writeByte(this.field_2_first_column_index);
        littleEndianOutput.writeShort(this.field_3_row_index);
        ConstantValueParser.encode(littleEndianOutput, this.field_4_constant_values);
    }
}

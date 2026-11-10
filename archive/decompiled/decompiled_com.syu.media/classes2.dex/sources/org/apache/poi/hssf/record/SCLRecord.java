package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SCLRecord extends StandardRecord {
    public static final short sid = 160;
    private short field_1_numerator;
    private short field_2_denominator;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 160;
    }

    public SCLRecord() {
    }

    public SCLRecord(RecordInputStream recordInputStream) {
        this.field_1_numerator = recordInputStream.readShort();
        this.field_2_denominator = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SCL]\n    .numerator            = 0x");
        stringBuffer.append(HexDump.toHex(getNumerator())).append(" (").append((int) getNumerator()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .denominator          = 0x").append(HexDump.toHex(getDenominator())).append(" (").append((int) getDenominator()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/SCL]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numerator);
        littleEndianOutput.writeShort(this.field_2_denominator);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SCLRecord sCLRecord = new SCLRecord();
        sCLRecord.field_1_numerator = this.field_1_numerator;
        sCLRecord.field_2_denominator = this.field_2_denominator;
        return sCLRecord;
    }

    public short getNumerator() {
        return this.field_1_numerator;
    }

    public void setNumerator(short s) {
        this.field_1_numerator = s;
    }

    public short getDenominator() {
        return this.field_2_denominator;
    }

    public void setDenominator(short s) {
        this.field_2_denominator = s;
    }
}

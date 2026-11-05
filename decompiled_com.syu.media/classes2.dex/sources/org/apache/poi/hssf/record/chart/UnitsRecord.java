package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnitsRecord extends StandardRecord {
    public static final short sid = 4097;
    private short field_1_units;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public UnitsRecord() {
    }

    public UnitsRecord(RecordInputStream recordInputStream) {
        this.field_1_units = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[UNITS]\n    .units                = 0x");
        stringBuffer.append(HexDump.toHex(getUnits())).append(" (").append((int) getUnits()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/UNITS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_units);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        UnitsRecord unitsRecord = new UnitsRecord();
        unitsRecord.field_1_units = this.field_1_units;
        return unitsRecord;
    }

    public short getUnits() {
        return this.field_1_units;
    }

    public void setUnits(short s) {
        this.field_1_units = s;
    }
}

package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CalcCountRecord extends StandardRecord implements Cloneable {
    public static final short sid = 12;
    private short field_1_iterations;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 12;
    }

    public CalcCountRecord() {
    }

    public CalcCountRecord(RecordInputStream recordInputStream) {
        this.field_1_iterations = recordInputStream.readShort();
    }

    public void setIterations(short s) {
        this.field_1_iterations = s;
    }

    public short getIterations() {
        return this.field_1_iterations;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CALCCOUNT]\n    .iterations     = ");
        stringBuffer.append(Integer.toHexString(getIterations())).append("\n[/CALCCOUNT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getIterations());
    }

    @Override // org.apache.poi.hssf.record.Record
    public CalcCountRecord clone() {
        CalcCountRecord calcCountRecord = new CalcCountRecord();
        calcCountRecord.field_1_iterations = this.field_1_iterations;
        return calcCountRecord;
    }
}

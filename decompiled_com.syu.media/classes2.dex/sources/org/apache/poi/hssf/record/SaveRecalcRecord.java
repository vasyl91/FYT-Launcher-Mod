package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SaveRecalcRecord extends StandardRecord {
    public static final short sid = 95;
    private short field_1_recalc;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 95;
    }

    public SaveRecalcRecord() {
    }

    public SaveRecalcRecord(RecordInputStream recordInputStream) {
        this.field_1_recalc = recordInputStream.readShort();
    }

    public void setRecalc(boolean z) {
        this.field_1_recalc = (short) (!z ? 0 : 1);
    }

    public boolean getRecalc() {
        return this.field_1_recalc == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SAVERECALC]\n    .recalc         = ");
        stringBuffer.append(getRecalc()).append("\n[/SAVERECALC]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_recalc);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SaveRecalcRecord saveRecalcRecord = new SaveRecalcRecord();
        saveRecalcRecord.field_1_recalc = this.field_1_recalc;
        return saveRecalcRecord;
    }
}

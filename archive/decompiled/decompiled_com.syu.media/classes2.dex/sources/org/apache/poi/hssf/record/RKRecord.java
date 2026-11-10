package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.RKUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RKRecord extends CellRecord {
    public static final short RK_IEEE_NUMBER = 0;
    public static final short RK_IEEE_NUMBER_TIMES_100 = 1;
    public static final short RK_INTEGER = 2;
    public static final short RK_INTEGER_TIMES_100 = 3;
    public static final short sid = 638;
    private int field_4_rk_number;

    @Override // org.apache.poi.hssf.record.CellRecord
    protected String getRecordName() {
        return "RK";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected int getValueDataSize() {
        return 4;
    }

    private RKRecord() {
    }

    public RKRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_4_rk_number = recordInputStream.readInt();
    }

    public double getRKNumber() {
        return RKUtil.decodeNumber(this.field_4_rk_number);
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void appendValueText(StringBuilder sb) {
        sb.append("  .value= ").append(getRKNumber());
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_4_rk_number);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        RKRecord rKRecord = new RKRecord();
        copyBaseFields(rKRecord);
        rKRecord.field_4_rk_number = this.field_4_rk_number;
        return rKRecord;
    }
}

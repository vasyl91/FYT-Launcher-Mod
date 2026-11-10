package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PrecisionRecord extends StandardRecord {
    public static final short sid = 14;
    public short field_1_precision;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 14;
    }

    public PrecisionRecord() {
    }

    public PrecisionRecord(RecordInputStream recordInputStream) {
        this.field_1_precision = recordInputStream.readShort();
    }

    public void setFullPrecision(boolean z) {
        if (z) {
            this.field_1_precision = (short) 1;
        } else {
            this.field_1_precision = (short) 0;
        }
    }

    public boolean getFullPrecision() {
        return this.field_1_precision == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PRECISION]\n    .precision       = ");
        stringBuffer.append(getFullPrecision()).append("\n[/PRECISION]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_precision);
    }
}

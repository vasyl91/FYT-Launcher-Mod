package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FnGroupCountRecord extends StandardRecord {
    public static final short COUNT = 14;
    public static final short sid = 156;
    private short field_1_count;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 156;
    }

    public FnGroupCountRecord() {
    }

    public FnGroupCountRecord(RecordInputStream recordInputStream) {
        this.field_1_count = recordInputStream.readShort();
    }

    public void setCount(short s) {
        this.field_1_count = s;
    }

    public short getCount() {
        return this.field_1_count;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FNGROUPCOUNT]\n    .count            = ");
        stringBuffer.append((int) getCount()).append("\n[/FNGROUPCOUNT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getCount());
    }
}

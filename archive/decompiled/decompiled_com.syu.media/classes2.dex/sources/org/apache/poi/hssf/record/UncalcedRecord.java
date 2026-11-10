package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UncalcedRecord extends StandardRecord {
    public static final short sid = 94;
    private short _reserved;

    public static int getStaticRecordSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 94;
    }

    public UncalcedRecord() {
        this._reserved = (short) 0;
    }

    public UncalcedRecord(RecordInputStream recordInputStream) {
        this._reserved = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[UNCALCED]\n    _reserved: ");
        stringBuffer.append((int) this._reserved).append("\n[/UNCALCED]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._reserved);
    }
}

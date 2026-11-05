package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WriteProtectRecord extends StandardRecord {
    public static final short sid = 134;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 134;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[WRITEPROTECT]\n[/WRITEPROTECT]\n";
    }

    public WriteProtectRecord() {
    }

    public WriteProtectRecord(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() == 2) {
            recordInputStream.readShort();
        }
    }
}

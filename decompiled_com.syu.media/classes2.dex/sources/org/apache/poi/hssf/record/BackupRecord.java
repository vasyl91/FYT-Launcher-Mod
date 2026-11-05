package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BackupRecord extends StandardRecord {
    public static final short sid = 64;
    private short field_1_backup;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 64;
    }

    public BackupRecord() {
    }

    public BackupRecord(RecordInputStream recordInputStream) {
        this.field_1_backup = recordInputStream.readShort();
    }

    public void setBackup(short s) {
        this.field_1_backup = s;
    }

    public short getBackup() {
        return this.field_1_backup;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[BACKUP]\n    .backup          = ");
        stringBuffer.append(Integer.toHexString(getBackup())).append("\n[/BACKUP]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getBackup());
    }
}

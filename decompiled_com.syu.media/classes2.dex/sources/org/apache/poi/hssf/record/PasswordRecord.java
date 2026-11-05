package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PasswordRecord extends StandardRecord {
    public static final short sid = 19;
    private int field_1_password;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 19;
    }

    public PasswordRecord(int i) {
        this.field_1_password = i;
    }

    public PasswordRecord(RecordInputStream recordInputStream) {
        this.field_1_password = recordInputStream.readShort();
    }

    public void setPassword(int i) {
        this.field_1_password = i;
    }

    public int getPassword() {
        return this.field_1_password;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PASSWORD]\n    .password = ");
        stringBuffer.append(HexDump.shortToHex(this.field_1_password)).append("\n[/PASSWORD]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_password);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new PasswordRecord(this.field_1_password);
    }
}

package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PasswordRev4Record extends StandardRecord {
    public static final short sid = 444;
    private int field_1_password;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 444;
    }

    public PasswordRev4Record(int i) {
        this.field_1_password = i;
    }

    public PasswordRev4Record(RecordInputStream recordInputStream) {
        this.field_1_password = recordInputStream.readShort();
    }

    public void setPassword(short s) {
        this.field_1_password = s;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PROT4REVPASSWORD]\n    .password = ");
        stringBuffer.append(HexDump.shortToHex(this.field_1_password)).append("\n[/PROT4REVPASSWORD]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_password);
    }
}

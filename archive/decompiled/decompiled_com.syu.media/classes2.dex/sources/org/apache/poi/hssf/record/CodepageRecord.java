package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CodepageRecord extends StandardRecord {
    public static final short CODEPAGE = 1200;
    public static final short sid = 66;
    private short field_1_codepage;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 66;
    }

    public CodepageRecord() {
    }

    public CodepageRecord(RecordInputStream recordInputStream) {
        this.field_1_codepage = recordInputStream.readShort();
    }

    public void setCodepage(short s) {
        this.field_1_codepage = s;
    }

    public short getCodepage() {
        return this.field_1_codepage;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CODEPAGE]\n    .codepage        = ");
        stringBuffer.append(Integer.toHexString(getCodepage())).append("\n[/CODEPAGE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getCodepage());
    }
}

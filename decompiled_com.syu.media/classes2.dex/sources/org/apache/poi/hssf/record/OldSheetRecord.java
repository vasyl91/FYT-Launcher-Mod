package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OldSheetRecord {
    public static final short sid = 133;
    private CodepageRecord codepage;
    private int field_1_position_of_BOF;
    private int field_2_visibility;
    private int field_3_type;
    private byte[] field_5_sheetname;

    public short getSid() {
        return (short) 133;
    }

    public OldSheetRecord(RecordInputStream recordInputStream) {
        this.field_1_position_of_BOF = recordInputStream.readInt();
        this.field_2_visibility = recordInputStream.readUByte();
        this.field_3_type = recordInputStream.readUByte();
        int uByte = recordInputStream.readUByte();
        byte[] bArr = new byte[uByte];
        this.field_5_sheetname = bArr;
        recordInputStream.read(bArr, 0, uByte);
    }

    public void setCodePage(CodepageRecord codepageRecord) {
        this.codepage = codepageRecord;
    }

    public int getPositionOfBof() {
        return this.field_1_position_of_BOF;
    }

    public String getSheetname() {
        return OldStringRecord.getString(this.field_5_sheetname, this.codepage);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[BOUNDSHEET]\n    .bof        = ");
        stringBuffer.append(HexDump.intToHex(getPositionOfBof())).append("\n    .visibility = ");
        stringBuffer.append(HexDump.shortToHex(this.field_2_visibility)).append("\n    .type       = ");
        stringBuffer.append(HexDump.byteToHex(this.field_3_type)).append("\n    .sheetname  = ");
        stringBuffer.append(getSheetname()).append("\n[/BOUNDSHEET]\n");
        return stringBuffer.toString();
    }
}

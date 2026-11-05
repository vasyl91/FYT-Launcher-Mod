package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NameCommentRecord extends StandardRecord {
    public static final short sid = 2196;
    private final short field_1_record_type;
    private final short field_2_frt_cell_ref_flag;
    private final long field_3_reserved;
    private String field_6_name_text;
    private String field_7_comment_text;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public NameCommentRecord(String str, String str2) {
        this.field_1_record_type = (short) 0;
        this.field_2_frt_cell_ref_flag = (short) 0;
        this.field_3_reserved = 0L;
        this.field_6_name_text = str;
        this.field_7_comment_text = str2;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_6_name_text.length();
        int length2 = this.field_7_comment_text.length();
        littleEndianOutput.writeShort(this.field_1_record_type);
        littleEndianOutput.writeShort(this.field_2_frt_cell_ref_flag);
        littleEndianOutput.writeLong(this.field_3_reserved);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeShort(length2);
        boolean zHasMultibyte = StringUtil.hasMultibyte(this.field_6_name_text);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            StringUtil.putUnicodeLE(this.field_6_name_text, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(this.field_6_name_text, littleEndianOutput);
        }
        boolean zHasMultibyte2 = StringUtil.hasMultibyte(this.field_7_comment_text);
        littleEndianOutput.writeByte(zHasMultibyte2 ? 1 : 0);
        if (zHasMultibyte2) {
            StringUtil.putUnicodeLE(this.field_7_comment_text, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(this.field_7_comment_text, littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (StringUtil.hasMultibyte(this.field_6_name_text) ? this.field_6_name_text.length() * 2 : this.field_6_name_text.length()) + 18 + (StringUtil.hasMultibyte(this.field_7_comment_text) ? this.field_7_comment_text.length() * 2 : this.field_7_comment_text.length());
    }

    public NameCommentRecord(RecordInputStream recordInputStream) {
        this.field_1_record_type = recordInputStream.readShort();
        this.field_2_frt_cell_ref_flag = recordInputStream.readShort();
        this.field_3_reserved = recordInputStream.readLong();
        short s = recordInputStream.readShort();
        short s2 = recordInputStream.readShort();
        if (recordInputStream.readByte() == 0) {
            this.field_6_name_text = StringUtil.readCompressedUnicode(recordInputStream, s);
        } else {
            this.field_6_name_text = StringUtil.readUnicodeLE(recordInputStream, s);
        }
        if (recordInputStream.readByte() == 0) {
            this.field_7_comment_text = StringUtil.readCompressedUnicode(recordInputStream, s2);
        } else {
            this.field_7_comment_text = StringUtil.readUnicodeLE(recordInputStream, s2);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[NAMECMT]\n    .record type            = ");
        stringBuffer.append(HexDump.shortToHex(this.field_1_record_type)).append("\n    .frt cell ref flag      = ");
        stringBuffer.append(HexDump.byteToHex(this.field_2_frt_cell_ref_flag)).append("\n    .reserved               = ");
        stringBuffer.append(this.field_3_reserved).append("\n    .name length            = ");
        stringBuffer.append(this.field_6_name_text.length()).append("\n    .comment length         = ");
        stringBuffer.append(this.field_7_comment_text.length()).append("\n    .name                   = ");
        stringBuffer.append(this.field_6_name_text).append("\n    .comment                = ");
        stringBuffer.append(this.field_7_comment_text).append("\n[/NAMECMT]\n");
        return stringBuffer.toString();
    }

    public String getNameText() {
        return this.field_6_name_text;
    }

    public void setNameText(String str) {
        this.field_6_name_text = str;
    }

    public String getCommentText() {
        return this.field_7_comment_text;
    }

    public void setCommentText(String str) {
        this.field_7_comment_text = str;
    }

    public short getRecordType() {
        return this.field_1_record_type;
    }
}

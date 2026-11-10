package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FileSharingRecord extends StandardRecord implements Cloneable {
    public static final short sid = 91;
    private short field_1_readonly;
    private short field_2_password;
    private byte field_3_username_unicode_options;
    private String field_3_username_value;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 91;
    }

    public FileSharingRecord() {
    }

    public FileSharingRecord(RecordInputStream recordInputStream) {
        this.field_1_readonly = recordInputStream.readShort();
        this.field_2_password = recordInputStream.readShort();
        short s = recordInputStream.readShort();
        if (s > 0) {
            this.field_3_username_unicode_options = recordInputStream.readByte();
            this.field_3_username_value = recordInputStream.readCompressedUnicode(s);
        } else {
            this.field_3_username_value = "";
        }
    }

    public void setReadOnly(short s) {
        this.field_1_readonly = s;
    }

    public short getReadOnly() {
        return this.field_1_readonly;
    }

    public void setPassword(short s) {
        this.field_2_password = s;
    }

    public short getPassword() {
        return this.field_2_password;
    }

    public String getUsername() {
        return this.field_3_username_value;
    }

    public void setUsername(String str) {
        this.field_3_username_value = str;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FILESHARING]\n    .readonly       = ");
        stringBuffer.append(getReadOnly() == 1 ? "true" : "false").append("\n    .password       = ");
        stringBuffer.append(Integer.toHexString(getPassword())).append("\n    .username       = ");
        stringBuffer.append(getUsername()).append("\n[/FILESHARING]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getReadOnly());
        littleEndianOutput.writeShort(getPassword());
        littleEndianOutput.writeShort(this.field_3_username_value.length());
        if (this.field_3_username_value.length() > 0) {
            littleEndianOutput.writeByte(this.field_3_username_unicode_options);
            StringUtil.putCompressedUnicode(getUsername(), littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        int length = this.field_3_username_value.length();
        if (length < 1) {
            return 6;
        }
        return length + 7;
    }

    @Override // org.apache.poi.hssf.record.Record
    public FileSharingRecord clone() {
        FileSharingRecord fileSharingRecord = new FileSharingRecord();
        fileSharingRecord.setReadOnly(this.field_1_readonly);
        fileSharingRecord.setPassword(this.field_2_password);
        fileSharingRecord.setUsername(this.field_3_username_value);
        return fileSharingRecord;
    }
}

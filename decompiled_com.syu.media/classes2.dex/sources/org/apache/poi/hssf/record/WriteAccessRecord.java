package org.apache.poi.hssf.record;

import java.util.Arrays;
import module.canbus.FinalCanbus;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WriteAccessRecord extends StandardRecord {
    private static final int DATA_SIZE = 112;
    private static final byte[] PADDING;
    private static final byte PAD_CHAR = 32;
    public static final short sid = 92;
    private String field_1_username;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 112;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 92;
    }

    static {
        byte[] bArr = new byte[112];
        PADDING = bArr;
        Arrays.fill(bArr, (byte) 32);
    }

    public WriteAccessRecord() {
        setUsername("");
    }

    public WriteAccessRecord(RecordInputStream recordInputStream) {
        String unicodeLE;
        if (recordInputStream.remaining() > 112) {
            throw new RecordFormatException("Expected data size (112) but got (" + recordInputStream.remaining() + ")");
        }
        int uShort = recordInputStream.readUShort();
        int uByte = recordInputStream.readUByte();
        if (uShort > 112 || (uByte & FinalCanbus.CAR_WC2_15YingLang) != 0) {
            int iRemaining = recordInputStream.remaining() + 3;
            byte[] bArr = new byte[iRemaining];
            LittleEndian.putUShort(bArr, 0, uShort);
            LittleEndian.putByte(bArr, 2, uByte);
            recordInputStream.readFully(bArr, 3, iRemaining - 3);
            setUsername(new String(bArr, StringUtil.UTF8).trim());
            return;
        }
        if ((uByte & 1) == 0) {
            unicodeLE = StringUtil.readCompressedUnicode(recordInputStream, uShort);
        } else {
            unicodeLE = StringUtil.readUnicodeLE(recordInputStream, uShort);
        }
        this.field_1_username = unicodeLE.trim();
        for (int iRemaining2 = recordInputStream.remaining(); iRemaining2 > 0; iRemaining2--) {
            recordInputStream.readUByte();
        }
    }

    public void setUsername(String str) {
        if (112 - ((str.length() * (StringUtil.hasMultibyte(str) ? 2 : 1)) + 3) < 0) {
            throw new IllegalArgumentException("Name is too long: " + str);
        }
        this.field_1_username = str;
    }

    public String getUsername() {
        return this.field_1_username;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[WRITEACCESS]\n    .name = ");
        stringBuffer.append(this.field_1_username).append("\n[/WRITEACCESS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String username = getUsername();
        boolean zHasMultibyte = StringUtil.hasMultibyte(username);
        littleEndianOutput.writeShort(username.length());
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            StringUtil.putUnicodeLE(username, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(username, littleEndianOutput);
        }
        littleEndianOutput.write(PADDING, 0, 112 - ((username.length() * (zHasMultibyte ? 2 : 1)) + 3));
    }
}

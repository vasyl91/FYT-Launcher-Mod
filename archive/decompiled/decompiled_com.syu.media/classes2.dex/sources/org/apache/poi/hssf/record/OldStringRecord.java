package org.apache.poi.hssf.record;

import java.io.UnsupportedEncodingException;
import org.apache.poi.util.CodePageUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OldStringRecord {
    public static final short biff2_sid = 7;
    public static final short biff345_sid = 519;
    private CodepageRecord codepage;
    private short field_1_string_len;
    private byte[] field_2_bytes;
    private short sid;

    public OldStringRecord(RecordInputStream recordInputStream) {
        this.sid = recordInputStream.getSid();
        if (recordInputStream.getSid() == 7) {
            this.field_1_string_len = (short) recordInputStream.readUByte();
        } else {
            this.field_1_string_len = recordInputStream.readShort();
        }
        int i = this.field_1_string_len;
        byte[] bArr = new byte[i];
        this.field_2_bytes = bArr;
        recordInputStream.read(bArr, 0, i);
    }

    public boolean isBiff2() {
        return this.sid == 7;
    }

    public short getSid() {
        return this.sid;
    }

    public void setCodePage(CodepageRecord codepageRecord) {
        this.codepage = codepageRecord;
    }

    public String getString() {
        return getString(this.field_2_bytes, this.codepage);
    }

    protected static String getString(byte[] bArr, CodepageRecord codepageRecord) {
        try {
            return CodePageUtil.getStringFromCodePage(bArr, codepageRecord != null ? codepageRecord.getCodepage() & 65535 : 1252);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported codepage requested", e);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[OLD STRING]\n    .string            = ");
        stringBuffer.append(getString()).append("\n[/OLD STRING]\n");
        return stringBuffer.toString();
    }
}

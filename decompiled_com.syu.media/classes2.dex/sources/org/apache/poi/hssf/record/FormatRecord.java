package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FormatRecord extends StandardRecord implements Cloneable {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) FormatRecord.class);
    public static final short sid = 1054;
    private final int field_1_index_code;
    private final boolean field_3_hasMultibyte;
    private final String field_4_formatstring;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private FormatRecord(FormatRecord formatRecord) {
        this.field_1_index_code = formatRecord.field_1_index_code;
        this.field_3_hasMultibyte = formatRecord.field_3_hasMultibyte;
        this.field_4_formatstring = formatRecord.field_4_formatstring;
    }

    public FormatRecord(int i, String str) {
        this.field_1_index_code = i;
        this.field_4_formatstring = str;
        this.field_3_hasMultibyte = StringUtil.hasMultibyte(str);
    }

    public FormatRecord(RecordInputStream recordInputStream) {
        this.field_1_index_code = recordInputStream.readShort();
        int uShort = recordInputStream.readUShort();
        boolean z = (recordInputStream.readByte() & 1) != 0;
        this.field_3_hasMultibyte = z;
        if (z) {
            this.field_4_formatstring = readStringCommon(recordInputStream, uShort, false);
        } else {
            this.field_4_formatstring = readStringCommon(recordInputStream, uShort, true);
        }
    }

    public int getIndexCode() {
        return this.field_1_index_code;
    }

    public String getFormatString() {
        return this.field_4_formatstring;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FORMAT]\n    .indexcode       = ");
        stringBuffer.append(HexDump.shortToHex(getIndexCode())).append("\n    .isUnicode       = ");
        stringBuffer.append(this.field_3_hasMultibyte).append("\n    .formatstring    = ");
        stringBuffer.append(getFormatString()).append("\n[/FORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String formatString = getFormatString();
        littleEndianOutput.writeShort(getIndexCode());
        littleEndianOutput.writeShort(formatString.length());
        littleEndianOutput.writeByte(this.field_3_hasMultibyte ? 1 : 0);
        if (this.field_3_hasMultibyte) {
            StringUtil.putUnicodeLE(formatString, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(formatString, littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (getFormatString().length() * (this.field_3_hasMultibyte ? 2 : 1)) + 5;
    }

    @Override // org.apache.poi.hssf.record.Record
    public FormatRecord clone() {
        return new FormatRecord(this);
    }

    private static String readStringCommon(RecordInputStream recordInputStream, int i, boolean z) {
        char[] cArr;
        int uByte;
        if (i < 0 || i > 1048576) {
            throw new IllegalArgumentException("Bad requested string length (" + i + ")");
        }
        int iRemaining = recordInputStream.remaining();
        if (!z) {
            iRemaining /= 2;
        }
        recordInputStream.remaining();
        if (i == iRemaining) {
            cArr = new char[i];
        } else {
            cArr = new char[iRemaining];
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (z) {
                uByte = recordInputStream.readUByte();
            } else {
                uByte = recordInputStream.readShort();
            }
            cArr[i2] = (char) uByte;
        }
        if (recordInputStream.available() == 1) {
            char[] cArr2 = new char[cArr.length + 1];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            cArr2[cArr.length] = (char) recordInputStream.readUByte();
            cArr = cArr2;
        }
        if (recordInputStream.available() > 0) {
            logger.log(3, "FormatRecord has " + recordInputStream.available() + " unexplained bytes. Silently skipping");
            while (recordInputStream.available() > 0) {
                recordInputStream.readByte();
            }
        }
        return new String(cArr);
    }
}

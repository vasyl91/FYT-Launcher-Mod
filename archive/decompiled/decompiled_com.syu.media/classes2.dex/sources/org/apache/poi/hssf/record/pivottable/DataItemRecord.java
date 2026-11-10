package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataItemRecord extends StandardRecord {
    public static final short sid = 197;
    private int df;
    private int ifmt;
    private int iiftab;
    private int isxvd;
    private int isxvdData;
    private int isxvi;
    private String name;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 197;
    }

    public DataItemRecord(RecordInputStream recordInputStream) {
        this.isxvdData = recordInputStream.readUShort();
        this.iiftab = recordInputStream.readUShort();
        this.df = recordInputStream.readUShort();
        this.isxvd = recordInputStream.readUShort();
        this.isxvi = recordInputStream.readUShort();
        this.ifmt = recordInputStream.readUShort();
        this.name = recordInputStream.readString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.isxvdData);
        littleEndianOutput.writeShort(this.iiftab);
        littleEndianOutput.writeShort(this.df);
        littleEndianOutput.writeShort(this.isxvd);
        littleEndianOutput.writeShort(this.isxvi);
        littleEndianOutput.writeShort(this.ifmt);
        StringUtil.writeUnicodeString(littleEndianOutput, this.name);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return StringUtil.getEncodedSize(this.name) + 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SXDI]\n  .isxvdData = ");
        stringBuffer.append(HexDump.shortToHex(this.isxvdData)).append("\n  .iiftab = ");
        stringBuffer.append(HexDump.shortToHex(this.iiftab)).append("\n  .df = ");
        stringBuffer.append(HexDump.shortToHex(this.df)).append("\n  .isxvd = ");
        stringBuffer.append(HexDump.shortToHex(this.isxvd)).append("\n  .isxvi = ");
        stringBuffer.append(HexDump.shortToHex(this.isxvi)).append("\n  .ifmt = ");
        stringBuffer.append(HexDump.shortToHex(this.ifmt)).append("\n[/SXDI]\n");
        return stringBuffer.toString();
    }
}

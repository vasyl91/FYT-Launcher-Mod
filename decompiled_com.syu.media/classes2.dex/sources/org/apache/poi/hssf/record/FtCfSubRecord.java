package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FtCfSubRecord extends SubRecord implements Cloneable {
    public static final short BITMAP_BIT = 9;
    public static final short METAFILE_BIT = 2;
    public static final short UNSPECIFIED_BIT = -1;
    public static final short length = 2;
    public static final short sid = 7;
    private short flags;

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return 2;
    }

    public short getSid() {
        return (short) 7;
    }

    public FtCfSubRecord() {
        this.flags = (short) 0;
    }

    public FtCfSubRecord(LittleEndianInput littleEndianInput, int i) {
        this.flags = (short) 0;
        if (i != 2) {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
        this.flags = littleEndianInput.readShort();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FtCf ]\n  size     = 2\n  flags    = ");
        stringBuffer.append(HexDump.toHex(this.flags)).append("\n[/FtCf ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(7);
        littleEndianOutput.writeShort(2);
        littleEndianOutput.writeShort(this.flags);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    /* JADX INFO: renamed from: clone */
    public FtCfSubRecord mo1560clone() {
        FtCfSubRecord ftCfSubRecord = new FtCfSubRecord();
        ftCfSubRecord.flags = this.flags;
        return ftCfSubRecord;
    }

    public short getFlags() {
        return this.flags;
    }

    public void setFlags(short s) {
        this.flags = s;
    }
}

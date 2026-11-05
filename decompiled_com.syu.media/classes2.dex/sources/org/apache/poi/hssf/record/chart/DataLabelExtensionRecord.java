package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataLabelExtensionRecord extends StandardRecord {
    public static final short sid = 2154;
    private int grbitFrt;
    private int rt;
    private byte[] unused = new byte[8];

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DataLabelExtensionRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        recordInputStream.readFully(this.unused);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.write(this.unused);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DATALABEXT]\n    .rt      =");
        stringBuffer.append(HexDump.shortToHex(this.rt)).append("\n    .grbitFrt=");
        stringBuffer.append(HexDump.shortToHex(this.grbitFrt)).append("\n    .unused  =");
        stringBuffer.append(HexDump.toHex(this.unused)).append("\n[/DATALABEXT]\n");
        return stringBuffer.toString();
    }
}

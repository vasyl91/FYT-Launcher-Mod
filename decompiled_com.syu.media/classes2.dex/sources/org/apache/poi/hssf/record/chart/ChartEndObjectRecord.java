package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ChartEndObjectRecord extends StandardRecord {
    public static final short sid = 2133;
    private short grbitFrt;
    private short iObjectKind;
    private byte[] reserved = new byte[6];
    private short rt;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ChartEndObjectRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.iObjectKind = recordInputStream.readShort();
        if (recordInputStream.available() == 0) {
            return;
        }
        recordInputStream.readFully(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeShort(this.iObjectKind);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ENDOBJECT]\n    .rt         =");
        stringBuffer.append(HexDump.shortToHex(this.rt)).append("\n    .grbitFrt   =");
        stringBuffer.append(HexDump.shortToHex(this.grbitFrt)).append("\n    .iObjectKind=");
        stringBuffer.append(HexDump.shortToHex(this.iObjectKind)).append("\n    .reserved   =");
        stringBuffer.append(HexDump.toHex(this.reserved)).append("\n[/ENDOBJECT]\n");
        return stringBuffer.toString();
    }
}

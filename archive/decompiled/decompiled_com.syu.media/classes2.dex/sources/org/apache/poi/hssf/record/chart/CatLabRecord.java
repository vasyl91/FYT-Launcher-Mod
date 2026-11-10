package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CatLabRecord extends StandardRecord {
    public static final short sid = 2134;
    private short at;
    private short grbit;
    private short grbitFrt;
    private short rt;
    private Short unused;
    private short wOffset;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public CatLabRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.wOffset = recordInputStream.readShort();
        this.at = recordInputStream.readShort();
        this.grbit = recordInputStream.readShort();
        if (recordInputStream.available() == 0) {
            this.unused = null;
        } else {
            this.unused = Short.valueOf(recordInputStream.readShort());
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.unused == null ? 0 : 2) + 10;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeShort(this.wOffset);
        littleEndianOutput.writeShort(this.at);
        littleEndianOutput.writeShort(this.grbit);
        Short sh = this.unused;
        if (sh != null) {
            littleEndianOutput.writeShort(sh.shortValue());
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CATLAB]\n    .rt      =");
        stringBuffer.append(HexDump.shortToHex(this.rt)).append("\n    .grbitFrt=");
        stringBuffer.append(HexDump.shortToHex(this.grbitFrt)).append("\n    .wOffset =");
        stringBuffer.append(HexDump.shortToHex(this.wOffset)).append("\n    .at      =");
        stringBuffer.append(HexDump.shortToHex(this.at)).append("\n    .grbit   =");
        stringBuffer.append(HexDump.shortToHex(this.grbit)).append('\n');
        if (this.unused != null) {
            stringBuffer.append("    .unused  =").append(HexDump.shortToHex(this.unused.shortValue())).append('\n');
        }
        stringBuffer.append("[/CATLAB]\n");
        return stringBuffer.toString();
    }
}

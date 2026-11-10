package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ChartFRTInfoRecord extends StandardRecord {
    public static final short sid = 2128;
    private short grbitFrt;
    private CFRTID[] rgCFRTID;
    private short rt;
    private byte verOriginator;
    private byte verWriter;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private static final class CFRTID {
        public static final int ENCODED_SIZE = 4;
        private int rtFirst;
        private int rtLast;

        public CFRTID(LittleEndianInput littleEndianInput) {
            this.rtFirst = littleEndianInput.readShort();
            this.rtLast = littleEndianInput.readShort();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this.rtFirst);
            littleEndianOutput.writeShort(this.rtLast);
        }
    }

    public ChartFRTInfoRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.verOriginator = recordInputStream.readByte();
        this.verWriter = recordInputStream.readByte();
        int i = recordInputStream.readShort();
        this.rgCFRTID = new CFRTID[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.rgCFRTID[i2] = new CFRTID(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.rgCFRTID.length * 4) + 8;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeByte(this.verOriginator);
        littleEndianOutput.writeByte(this.verWriter);
        int length = this.rgCFRTID.length;
        littleEndianOutput.writeShort(length);
        for (int i = 0; i < length; i++) {
            this.rgCFRTID[i].serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CHARTFRTINFO]\n    .rt           =");
        stringBuffer.append(HexDump.shortToHex(this.rt)).append("\n    .grbitFrt     =");
        stringBuffer.append(HexDump.shortToHex(this.grbitFrt)).append("\n    .verOriginator=");
        stringBuffer.append(HexDump.byteToHex(this.verOriginator)).append("\n    .verWriter    =");
        stringBuffer.append(HexDump.byteToHex(this.verOriginator)).append("\n    .nCFRTIDs     =");
        stringBuffer.append(HexDump.shortToHex(this.rgCFRTID.length)).append("\n[/CHARTFRTINFO]\n");
        return stringBuffer.toString();
    }
}

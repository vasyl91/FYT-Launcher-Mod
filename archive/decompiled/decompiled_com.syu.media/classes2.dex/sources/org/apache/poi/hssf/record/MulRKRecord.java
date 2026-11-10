package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.RKUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MulRKRecord extends StandardRecord {
    public static final short sid = 189;
    private final int field_1_row;
    private final short field_2_first_col;
    private final RkRec[] field_3_rks;
    private final short field_4_last_col;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 189;
    }

    public int getRow() {
        return this.field_1_row;
    }

    public short getFirstColumn() {
        return this.field_2_first_col;
    }

    public short getLastColumn() {
        return this.field_4_last_col;
    }

    public int getNumColumns() {
        return (this.field_4_last_col - this.field_2_first_col) + 1;
    }

    public short getXFAt(int i) {
        return this.field_3_rks[i].xf;
    }

    public double getRKNumberAt(int i) {
        return RKUtil.decodeNumber(this.field_3_rks[i].rk);
    }

    public MulRKRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_first_col = recordInputStream.readShort();
        this.field_3_rks = RkRec.parseRKs(recordInputStream);
        this.field_4_last_col = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[MULRK]\n\t.row\t = ");
        stringBuffer.append(HexDump.shortToHex(getRow())).append("\n\t.firstcol= ");
        stringBuffer.append(HexDump.shortToHex(getFirstColumn())).append("\n\t.lastcol = ");
        stringBuffer.append(HexDump.shortToHex(getLastColumn())).append("\n");
        for (int i = 0; i < getNumColumns(); i++) {
            stringBuffer.append("\txf[").append(i).append("] = ").append(HexDump.shortToHex(getXFAt(i))).append("\n\trk[");
            stringBuffer.append(i).append("] = ").append(getRKNumberAt(i)).append("\n");
        }
        stringBuffer.append("[/MULRK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
    }

    private static final class RkRec {
        public static final int ENCODED_SIZE = 6;
        public final int rk;
        public final short xf;

        private RkRec(RecordInputStream recordInputStream) {
            this.xf = recordInputStream.readShort();
            this.rk = recordInputStream.readInt();
        }

        public static RkRec[] parseRKs(RecordInputStream recordInputStream) {
            int iRemaining = (recordInputStream.remaining() - 2) / 6;
            RkRec[] rkRecArr = new RkRec[iRemaining];
            for (int i = 0; i < iRemaining; i++) {
                rkRecArr[i] = new RkRec(recordInputStream);
            }
            return rkRecArr;
        }
    }
}

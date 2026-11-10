package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DBCellRecord extends StandardRecord implements Cloneable {
    public static final int BLOCK_SIZE = 32;
    public static final short sid = 215;
    private final int field_1_row_offset;
    private final short[] field_2_cell_offsets;

    @Override // org.apache.poi.hssf.record.Record
    public DBCellRecord clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public static final class Builder {
        private short[] _cellOffsets = new short[4];
        private int _nCellOffsets;

        public void addCellOffset(int i) {
            short[] sArr = this._cellOffsets;
            int length = sArr.length;
            int i2 = this._nCellOffsets;
            if (length <= i2) {
                short[] sArr2 = new short[i2 * 2];
                System.arraycopy(sArr, 0, sArr2, 0, i2);
                this._cellOffsets = sArr2;
            }
            short[] sArr3 = this._cellOffsets;
            int i3 = this._nCellOffsets;
            sArr3[i3] = (short) i;
            this._nCellOffsets = i3 + 1;
        }

        public DBCellRecord build(int i) {
            int i2 = this._nCellOffsets;
            short[] sArr = new short[i2];
            System.arraycopy(this._cellOffsets, 0, sArr, 0, i2);
            return new DBCellRecord(i, sArr);
        }
    }

    DBCellRecord(int i, short[] sArr) {
        this.field_1_row_offset = i;
        this.field_2_cell_offsets = sArr;
    }

    public DBCellRecord(RecordInputStream recordInputStream) {
        this.field_1_row_offset = recordInputStream.readUShort();
        this.field_2_cell_offsets = new short[recordInputStream.remaining() / 2];
        int i = 0;
        while (true) {
            short[] sArr = this.field_2_cell_offsets;
            if (i >= sArr.length) {
                return;
            }
            sArr[i] = recordInputStream.readShort();
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DBCELL]\n    .rowoffset = ");
        stringBuffer.append(HexDump.intToHex(this.field_1_row_offset)).append("\n");
        for (int i = 0; i < this.field_2_cell_offsets.length; i++) {
            stringBuffer.append("    .cell_").append(i).append(" = ").append(HexDump.shortToHex(this.field_2_cell_offsets[i])).append("\n");
        }
        stringBuffer.append("[/DBCELL]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_row_offset);
        int i = 0;
        while (true) {
            short[] sArr = this.field_2_cell_offsets;
            if (i >= sArr.length) {
                return;
            }
            littleEndianOutput.writeShort(sArr[i]);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.field_2_cell_offsets.length * 2) + 4;
    }
}

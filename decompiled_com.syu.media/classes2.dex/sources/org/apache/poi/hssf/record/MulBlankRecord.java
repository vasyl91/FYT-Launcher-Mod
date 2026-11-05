package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MulBlankRecord extends StandardRecord {
    public static final short sid = 190;
    private final int _firstCol;
    private final int _lastCol;
    private final int _row;
    private final short[] _xfs;

    @Override // org.apache.poi.hssf.record.Record
    public MulBlankRecord clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 190;
    }

    public MulBlankRecord(int i, int i2, short[] sArr) {
        this._row = i;
        this._firstCol = i2;
        this._xfs = sArr;
        this._lastCol = (i2 + sArr.length) - 1;
    }

    public int getRow() {
        return this._row;
    }

    public int getFirstColumn() {
        return this._firstCol;
    }

    public int getLastColumn() {
        return this._lastCol;
    }

    public int getNumColumns() {
        return (this._lastCol - this._firstCol) + 1;
    }

    public short getXFAt(int i) {
        return this._xfs[i];
    }

    public MulBlankRecord(RecordInputStream recordInputStream) {
        this._row = recordInputStream.readUShort();
        this._firstCol = recordInputStream.readShort();
        this._xfs = parseXFs(recordInputStream);
        this._lastCol = recordInputStream.readShort();
    }

    private static short[] parseXFs(RecordInputStream recordInputStream) {
        int iRemaining = (recordInputStream.remaining() - 2) / 2;
        short[] sArr = new short[iRemaining];
        for (int i = 0; i < iRemaining; i++) {
            sArr[i] = recordInputStream.readShort();
        }
        return sArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[MULBLANK]\nrow  = ");
        stringBuffer.append(Integer.toHexString(getRow())).append("\nfirstcol  = ");
        stringBuffer.append(Integer.toHexString(getFirstColumn())).append("\n lastcol  = ");
        stringBuffer.append(Integer.toHexString(this._lastCol)).append("\n");
        for (int i = 0; i < getNumColumns(); i++) {
            stringBuffer.append("xf").append(i).append("\t\t= ").append(Integer.toHexString(getXFAt(i))).append("\n");
        }
        stringBuffer.append("[/MULBLANK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._row);
        littleEndianOutput.writeShort(this._firstCol);
        int length = this._xfs.length;
        for (int i = 0; i < length; i++) {
            littleEndianOutput.writeShort(this._xfs[i]);
        }
        littleEndianOutput.writeShort(this._lastCol);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._xfs.length * 2) + 6;
    }
}

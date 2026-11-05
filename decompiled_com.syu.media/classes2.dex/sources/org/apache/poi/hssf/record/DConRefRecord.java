package org.apache.poi.hssf.record;

import java.util.Arrays;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DConRefRecord extends StandardRecord {
    public static final short sid = 81;
    private byte[] _unused;
    private int charCount;
    private int charType;
    private int firstCol;
    private int firstRow;
    private int lastCol;
    private int lastRow;
    private byte[] path;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 81;
    }

    public DConRefRecord(byte[] bArr) {
        if (LittleEndian.getShort(bArr, 0) != 81) {
            throw new RecordFormatException("incompatible sid.");
        }
        this.firstRow = LittleEndian.getUShort(bArr, 4);
        this.lastRow = LittleEndian.getUShort(bArr, 6);
        this.firstCol = LittleEndian.getUByte(bArr, 8);
        this.lastCol = LittleEndian.getUByte(bArr, 9);
        int uShort = LittleEndian.getUShort(bArr, 10);
        this.charCount = uShort;
        if (uShort < 2) {
            throw new RecordFormatException("Character count must be >= 2");
        }
        short uByte = LittleEndian.getUByte(bArr, 12);
        this.charType = uByte;
        int i = this.charCount * ((uByte & 1) + 1);
        byte[] byteArray = LittleEndian.getByteArray(bArr, 13, i);
        this.path = byteArray;
        int i2 = 13 + i;
        if (byteArray[0] == 2) {
            this._unused = LittleEndian.getByteArray(bArr, i2, this.charType + 1);
        }
    }

    public DConRefRecord(RecordInputStream recordInputStream) {
        if (recordInputStream.getSid() != 81) {
            throw new RecordFormatException("Wrong sid: " + ((int) recordInputStream.getSid()));
        }
        this.firstRow = recordInputStream.readUShort();
        this.lastRow = recordInputStream.readUShort();
        this.firstCol = recordInputStream.readUByte();
        this.lastCol = recordInputStream.readUByte();
        this.charCount = recordInputStream.readUShort();
        int uByte = recordInputStream.readUByte() & 1;
        this.charType = uByte;
        byte[] bArr = new byte[this.charCount * (uByte + 1)];
        this.path = bArr;
        recordInputStream.readFully(bArr);
        if (this.path[0] == 2) {
            this._unused = recordInputStream.readRemainder();
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        byte[] bArr = this.path;
        int length = bArr.length + 9;
        return bArr[0] == 2 ? length + this._unused.length : length;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.firstRow);
        littleEndianOutput.writeShort(this.lastRow);
        littleEndianOutput.writeByte(this.firstCol);
        littleEndianOutput.writeByte(this.lastCol);
        littleEndianOutput.writeShort(this.charCount);
        littleEndianOutput.writeByte(this.charType);
        littleEndianOutput.write(this.path);
        if (this.path[0] == 2) {
            littleEndianOutput.write(this._unused);
        }
    }

    public int getFirstColumn() {
        return this.firstCol;
    }

    public int getFirstRow() {
        return this.firstRow;
    }

    public int getLastColumn() {
        return this.lastCol;
    }

    public int getLastRow() {
        return this.lastRow;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuilder sb = new StringBuilder("[DCONREF]\n    .ref\n        .firstrow   = ");
        sb.append(this.firstRow).append("\n        .lastrow    = ");
        sb.append(this.lastRow).append("\n        .firstcol   = ");
        sb.append(this.firstCol).append("\n        .lastcol    = ");
        sb.append(this.lastCol).append("\n    .cch            = ");
        sb.append(this.charCount).append("\n    .stFile\n        .h          = ");
        sb.append(this.charType).append("\n        .rgb        = ");
        sb.append(getReadablePath()).append("\n[/DCONREF]\n");
        return sb.toString();
    }

    public byte[] getPath() {
        byte[] bArr = this.path;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String getReadablePath() {
        if (this.path == null) {
            return null;
        }
        int i = 1;
        while (true) {
            byte[] bArr = this.path;
            if (bArr[i] >= 32 || i >= bArr.length) {
                break;
            }
            i++;
        }
        byte[] bArr2 = this.path;
        return new String(Arrays.copyOfRange(bArr2, i, bArr2.length), StringUtil.UTF8).replaceAll("\u0003", "/");
    }

    public boolean isExternalRef() {
        return this.path[0] == 1;
    }
}

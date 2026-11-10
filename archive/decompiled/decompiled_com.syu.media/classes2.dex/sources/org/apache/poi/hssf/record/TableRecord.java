package org.apache.poi.hssf.record;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TableRecord extends SharedValueRecordBase {
    public static final short sid = 566;
    private int field_10_colInputCol;
    private int field_5_flags;
    private int field_6_res;
    private int field_7_rowInputRow;
    private int field_8_colInputRow;
    private int field_9_rowInputCol;
    private static final BitField alwaysCalc = BitFieldFactory.getInstance(1);
    private static final BitField calcOnOpen = BitFieldFactory.getInstance(2);
    private static final BitField rowOrColInpCell = BitFieldFactory.getInstance(4);
    private static final BitField oneOrTwoVar = BitFieldFactory.getInstance(8);
    private static final BitField rowDeleted = BitFieldFactory.getInstance(16);
    private static final BitField colDeleted = BitFieldFactory.getInstance(32);

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected int getExtraDataSize() {
        return 10;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public TableRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_5_flags = recordInputStream.readByte();
        this.field_6_res = recordInputStream.readByte();
        this.field_7_rowInputRow = recordInputStream.readShort();
        this.field_8_colInputRow = recordInputStream.readShort();
        this.field_9_rowInputCol = recordInputStream.readShort();
        this.field_10_colInputCol = recordInputStream.readShort();
    }

    public TableRecord(CellRangeAddress8Bit cellRangeAddress8Bit) {
        super(cellRangeAddress8Bit);
        this.field_6_res = 0;
    }

    public int getFlags() {
        return this.field_5_flags;
    }

    public void setFlags(int i) {
        this.field_5_flags = i;
    }

    public int getRowInputRow() {
        return this.field_7_rowInputRow;
    }

    public void setRowInputRow(int i) {
        this.field_7_rowInputRow = i;
    }

    public int getColInputRow() {
        return this.field_8_colInputRow;
    }

    public void setColInputRow(int i) {
        this.field_8_colInputRow = i;
    }

    public int getRowInputCol() {
        return this.field_9_rowInputCol;
    }

    public void setRowInputCol(int i) {
        this.field_9_rowInputCol = i;
    }

    public int getColInputCol() {
        return this.field_10_colInputCol;
    }

    public void setColInputCol(int i) {
        this.field_10_colInputCol = i;
    }

    public boolean isAlwaysCalc() {
        return alwaysCalc.isSet(this.field_5_flags);
    }

    public void setAlwaysCalc(boolean z) {
        this.field_5_flags = alwaysCalc.setBoolean(this.field_5_flags, z);
    }

    public boolean isRowOrColInpCell() {
        return rowOrColInpCell.isSet(this.field_5_flags);
    }

    public void setRowOrColInpCell(boolean z) {
        this.field_5_flags = rowOrColInpCell.setBoolean(this.field_5_flags, z);
    }

    public boolean isOneNotTwoVar() {
        return oneOrTwoVar.isSet(this.field_5_flags);
    }

    public void setOneNotTwoVar(boolean z) {
        this.field_5_flags = oneOrTwoVar.setBoolean(this.field_5_flags, z);
    }

    public boolean isColDeleted() {
        return colDeleted.isSet(this.field_5_flags);
    }

    public void setColDeleted(boolean z) {
        this.field_5_flags = colDeleted.setBoolean(this.field_5_flags, z);
    }

    public boolean isRowDeleted() {
        return rowDeleted.isSet(this.field_5_flags);
    }

    public void setRowDeleted(boolean z) {
        this.field_5_flags = rowDeleted.setBoolean(this.field_5_flags, z);
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected void serializeExtraData(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_5_flags);
        littleEndianOutput.writeByte(this.field_6_res);
        littleEndianOutput.writeShort(this.field_7_rowInputRow);
        littleEndianOutput.writeShort(this.field_8_colInputRow);
        littleEndianOutput.writeShort(this.field_9_rowInputCol);
        littleEndianOutput.writeShort(this.field_10_colInputCol);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[TABLE]\n    .range    = ");
        stringBuffer.append(getRange()).append("\n    .flags    = ");
        stringBuffer.append(HexDump.byteToHex(this.field_5_flags)).append("\n    .alwaysClc= ");
        stringBuffer.append(isAlwaysCalc()).append("\n    .reserved = ");
        stringBuffer.append(HexDump.intToHex(this.field_6_res)).append("\n    .rowInput = ");
        CellReference cellReferenceCr = cr(this.field_7_rowInputRow, this.field_8_colInputRow);
        CellReference cellReferenceCr2 = cr(this.field_9_rowInputCol, this.field_10_colInputCol);
        stringBuffer.append(cellReferenceCr.formatAsString()).append("\n    .colInput = ");
        stringBuffer.append(cellReferenceCr2.formatAsString()).append("\n[/TABLE]\n");
        return stringBuffer.toString();
    }

    private static CellReference cr(int i, int i2) {
        return new CellReference(i, i2 & 255, (32768 & i2) == 0, (i2 & Variant.VT_BYREF) == 0);
    }
}

package org.apache.poi.ss.formula.ptg;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class RefPtgBase extends OperandPtg {
    private int field_1_row;
    private int field_2_col;
    private static final BitField rowRelative = BitFieldFactory.getInstance(32768);
    private static final BitField colRelative = BitFieldFactory.getInstance(Variant.VT_BYREF);
    private static final BitField column = BitFieldFactory.getInstance(16383);

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final byte getDefaultOperandClass() {
        return (byte) 0;
    }

    protected RefPtgBase() {
    }

    protected RefPtgBase(CellReference cellReference) {
        setRow(cellReference.getRow());
        setColumn(cellReference.getCol());
        setColRelative(!cellReference.isColAbsolute());
        setRowRelative(!cellReference.isRowAbsolute());
    }

    protected final void readCoordinates(LittleEndianInput littleEndianInput) {
        this.field_1_row = littleEndianInput.readUShort();
        this.field_2_col = littleEndianInput.readUShort();
    }

    protected final void writeCoordinates(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_row);
        littleEndianOutput.writeShort(this.field_2_col);
    }

    public final void setRow(int i) {
        this.field_1_row = i;
    }

    public final int getRow() {
        return this.field_1_row;
    }

    public final boolean isRowRelative() {
        return rowRelative.isSet(this.field_2_col);
    }

    public final void setRowRelative(boolean z) {
        this.field_2_col = rowRelative.setBoolean(this.field_2_col, z);
    }

    public final boolean isColRelative() {
        return colRelative.isSet(this.field_2_col);
    }

    public final void setColRelative(boolean z) {
        this.field_2_col = colRelative.setBoolean(this.field_2_col, z);
    }

    public final void setColumn(int i) {
        this.field_2_col = column.setValue(this.field_2_col, i);
    }

    public final int getColumn() {
        return column.getValue(this.field_2_col);
    }

    protected final String formatReferenceAsString() {
        return new CellReference(getRow(), getColumn(), !isRowRelative(), !isColRelative()).formatAsString();
    }
}

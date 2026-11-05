package org.apache.poi.ss.formula.ptg;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AreaPtgBase extends OperandPtg implements AreaI {
    private int field_1_first_row;
    private int field_2_last_row;
    private int field_3_first_column;
    private int field_4_last_column;
    private static final BitField rowRelative = BitFieldFactory.getInstance(32768);
    private static final BitField colRelative = BitFieldFactory.getInstance(Variant.VT_BYREF);
    private static final BitField columnMask = BitFieldFactory.getInstance(16383);

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 0;
    }

    protected final RuntimeException notImplemented() {
        return new RuntimeException("Coding Error: This method should never be called. This ptg should be converted");
    }

    protected AreaPtgBase() {
    }

    protected AreaPtgBase(AreaReference areaReference) {
        CellReference firstCell = areaReference.getFirstCell();
        CellReference lastCell = areaReference.getLastCell();
        setFirstRow(firstCell.getRow());
        setFirstColumn(firstCell.getCol() == -1 ? (short) 0 : firstCell.getCol());
        setLastRow(lastCell.getRow());
        setLastColumn(lastCell.getCol() == -1 ? (short) 255 : lastCell.getCol());
        setFirstColRelative(!firstCell.isColAbsolute());
        setLastColRelative(!lastCell.isColAbsolute());
        setFirstRowRelative(!firstCell.isRowAbsolute());
        setLastRowRelative(!lastCell.isRowAbsolute());
    }

    protected AreaPtgBase(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        if (i2 >= i) {
            setFirstRow(i);
            setLastRow(i2);
            setFirstRowRelative(z);
            setLastRowRelative(z2);
        } else {
            setFirstRow(i2);
            setLastRow(i);
            setFirstRowRelative(z2);
            setLastRowRelative(z);
        }
        if (i4 >= i3) {
            setFirstColumn(i3);
            setLastColumn(i4);
            setFirstColRelative(z3);
            setLastColRelative(z4);
            return;
        }
        setFirstColumn(i4);
        setLastColumn(i3);
        setFirstColRelative(z4);
        setLastColRelative(z3);
    }

    public void sortTopLeftToBottomRight() {
        if (getFirstRow() > getLastRow()) {
            int firstRow = getFirstRow();
            boolean zIsFirstRowRelative = isFirstRowRelative();
            setFirstRow(getLastRow());
            setFirstRowRelative(isLastRowRelative());
            setLastRow(firstRow);
            setLastRowRelative(zIsFirstRowRelative);
        }
        if (getFirstColumn() > getLastColumn()) {
            int firstColumn = getFirstColumn();
            boolean zIsFirstColRelative = isFirstColRelative();
            setFirstColumn(getLastColumn());
            setFirstColRelative(isLastColRelative());
            setLastColumn(firstColumn);
            setLastColRelative(zIsFirstColRelative);
        }
    }

    protected final void readCoordinates(LittleEndianInput littleEndianInput) {
        this.field_1_first_row = littleEndianInput.readUShort();
        this.field_2_last_row = littleEndianInput.readUShort();
        this.field_3_first_column = littleEndianInput.readUShort();
        this.field_4_last_column = littleEndianInput.readUShort();
    }

    protected final void writeCoordinates(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_first_row);
        littleEndianOutput.writeShort(this.field_2_last_row);
        littleEndianOutput.writeShort(this.field_3_first_column);
        littleEndianOutput.writeShort(this.field_4_last_column);
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getFirstRow() {
        return this.field_1_first_row;
    }

    public final void setFirstRow(int i) {
        this.field_1_first_row = i;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getLastRow() {
        return this.field_2_last_row;
    }

    public final void setLastRow(int i) {
        this.field_2_last_row = i;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getFirstColumn() {
        return columnMask.getValue(this.field_3_first_column);
    }

    public final short getFirstColumnRaw() {
        return (short) this.field_3_first_column;
    }

    public final boolean isFirstRowRelative() {
        return rowRelative.isSet(this.field_3_first_column);
    }

    public final void setFirstRowRelative(boolean z) {
        this.field_3_first_column = rowRelative.setBoolean(this.field_3_first_column, z);
    }

    public final boolean isFirstColRelative() {
        return colRelative.isSet(this.field_3_first_column);
    }

    public final void setFirstColRelative(boolean z) {
        this.field_3_first_column = colRelative.setBoolean(this.field_3_first_column, z);
    }

    public final void setFirstColumn(int i) {
        this.field_3_first_column = columnMask.setValue(this.field_3_first_column, i);
    }

    public final void setFirstColumnRaw(int i) {
        this.field_3_first_column = i;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getLastColumn() {
        return columnMask.getValue(this.field_4_last_column);
    }

    public final short getLastColumnRaw() {
        return (short) this.field_4_last_column;
    }

    public final boolean isLastRowRelative() {
        return rowRelative.isSet(this.field_4_last_column);
    }

    public final void setLastRowRelative(boolean z) {
        this.field_4_last_column = rowRelative.setBoolean(this.field_4_last_column, z);
    }

    public final boolean isLastColRelative() {
        return colRelative.isSet(this.field_4_last_column);
    }

    public final void setLastColRelative(boolean z) {
        this.field_4_last_column = colRelative.setBoolean(this.field_4_last_column, z);
    }

    public final void setLastColumn(int i) {
        this.field_4_last_column = columnMask.setValue(this.field_4_last_column, i);
    }

    public final void setLastColumnRaw(short s) {
        this.field_4_last_column = s;
    }

    protected final String formatReferenceAsString() {
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn(), !isFirstRowRelative(), !isFirstColRelative());
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn(), !isLastRowRelative(), !isLastColRelative());
        if (AreaReference.isWholeColumnReference(SpreadsheetVersion.EXCEL97, cellReference, cellReference2)) {
            return new AreaReference(cellReference, cellReference2, SpreadsheetVersion.EXCEL97).formatAsString();
        }
        return cellReference.formatAsString() + ":" + cellReference2.formatAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return formatReferenceAsString();
    }
}

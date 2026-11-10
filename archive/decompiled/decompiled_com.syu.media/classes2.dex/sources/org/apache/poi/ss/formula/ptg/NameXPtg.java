package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NameXPtg extends OperandPtg implements WorkbookDependentFormula {
    private static final int SIZE = 7;
    public static final short sid = 57;
    private final int _nameNumber;
    private final int _reserved;
    private final int _sheetRefIndex;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 7;
    }

    private NameXPtg(int i, int i2, int i3) {
        this._sheetRefIndex = i;
        this._nameNumber = i2;
        this._reserved = i3;
    }

    public NameXPtg(int i, int i2) {
        this(i, i2 + 1, 0);
    }

    public NameXPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readUShort(), littleEndianInput.readUShort(), littleEndianInput.readUShort());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 57);
        littleEndianOutput.writeShort(this._sheetRefIndex);
        littleEndianOutput.writeShort(this._nameNumber);
        littleEndianOutput.writeShort(this._reserved);
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook) {
        return formulaRenderingWorkbook.resolveNameXText(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        return "NameXPtg:[sheetRefIndex:" + this._sheetRefIndex + " , nameNumber:" + this._nameNumber + "]";
    }

    public int getSheetRefIndex() {
        return this._sheetRefIndex;
    }

    public int getNameIndex() {
        return this._nameNumber - 1;
    }
}

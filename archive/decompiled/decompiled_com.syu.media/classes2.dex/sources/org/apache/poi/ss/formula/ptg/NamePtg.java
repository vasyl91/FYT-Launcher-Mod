package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NamePtg extends OperandPtg implements WorkbookDependentFormula {
    private static final int SIZE = 5;
    public static final short sid = 35;
    private int field_1_label_index;
    private short field_2_zero;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 5;
    }

    public NamePtg(int i) {
        this.field_1_label_index = i + 1;
    }

    public NamePtg(LittleEndianInput littleEndianInput) {
        this.field_1_label_index = littleEndianInput.readUShort();
        this.field_2_zero = littleEndianInput.readShort();
    }

    public int getIndex() {
        return this.field_1_label_index - 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 35);
        littleEndianOutput.writeShort(this.field_1_label_index);
        littleEndianOutput.writeShort(this.field_2_zero);
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook) {
        return formulaRenderingWorkbook.getNameText(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }
}

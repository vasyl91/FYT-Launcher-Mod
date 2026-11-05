package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DeletedArea3DPtg extends OperandPtg implements WorkbookDependentFormula {
    public static final byte sid = 61;
    private final int field_1_index_extern_sheet;
    private final int unused1;
    private final int unused2;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 11;
    }

    public DeletedArea3DPtg(int i) {
        this.field_1_index_extern_sheet = i;
        this.unused1 = 0;
        this.unused2 = 0;
    }

    public DeletedArea3DPtg(LittleEndianInput littleEndianInput) {
        this.field_1_index_extern_sheet = littleEndianInput.readUShort();
        this.unused1 = littleEndianInput.readInt();
        this.unused2 = littleEndianInput.readInt();
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook) {
        return ExternSheetNameResolver.prependSheetName(formulaRenderingWorkbook, this.field_1_index_extern_sheet, FormulaError.REF.getString());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeShort(this.field_1_index_extern_sheet);
        littleEndianOutput.writeInt(this.unused1);
        littleEndianOutput.writeInt(this.unused2);
    }
}

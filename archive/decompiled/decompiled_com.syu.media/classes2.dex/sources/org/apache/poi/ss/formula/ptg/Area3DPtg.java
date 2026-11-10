package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ExternSheetReferenceToken;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Area3DPtg extends AreaPtgBase implements WorkbookDependentFormula, ExternSheetReferenceToken {
    private static final int SIZE = 11;
    public static final byte sid = 59;
    private int field_1_index_extern_sheet;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 11;
    }

    public Area3DPtg(String str, int i) {
        super(new AreaReference(str, SpreadsheetVersion.EXCEL97));
        setExternSheetIndex(i);
    }

    public Area3DPtg(LittleEndianInput littleEndianInput) {
        this.field_1_index_extern_sheet = littleEndianInput.readShort();
        readCoordinates(littleEndianInput);
    }

    public Area3DPtg(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5) {
        super(i, i2, i3, i4, z, z2, z3, z4);
        setExternSheetIndex(i5);
    }

    public Area3DPtg(AreaReference areaReference, int i) {
        super(areaReference);
        setExternSheetIndex(i);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [sheetIx=");
        stringBuffer.append(getExternSheetIndex());
        stringBuffer.append(" ! ");
        stringBuffer.append(formatReferenceAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeShort(this.field_1_index_extern_sheet);
        writeCoordinates(littleEndianOutput);
    }

    @Override // org.apache.poi.ss.formula.ExternSheetReferenceToken
    public int getExternSheetIndex() {
        return this.field_1_index_extern_sheet;
    }

    public void setExternSheetIndex(int i) {
        this.field_1_index_extern_sheet = i;
    }

    @Override // org.apache.poi.ss.formula.ExternSheetReferenceToken
    public String format2DRefAsString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook) {
        return ExternSheetNameResolver.prependSheetName(formulaRenderingWorkbook, this.field_1_index_extern_sheet, formatReferenceAsString());
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }
}

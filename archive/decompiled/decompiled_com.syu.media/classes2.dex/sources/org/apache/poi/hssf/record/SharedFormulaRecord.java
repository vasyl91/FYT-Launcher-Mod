package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SharedFormulaRecord extends SharedValueRecordBase {
    public static final short sid = 1212;
    private int field_5_reserved;
    private Formula field_7_parsed_expr;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public SharedFormulaRecord() {
        this(new CellRangeAddress8Bit(0, 0, 0, 0));
    }

    private SharedFormulaRecord(CellRangeAddress8Bit cellRangeAddress8Bit) {
        super(cellRangeAddress8Bit);
        this.field_7_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
    }

    public SharedFormulaRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_5_reserved = recordInputStream.readShort();
        this.field_7_parsed_expr = Formula.read(recordInputStream.readShort(), recordInputStream, recordInputStream.available());
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected void serializeExtraData(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_5_reserved);
        this.field_7_parsed_expr.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected int getExtraDataSize() {
        return this.field_7_parsed_expr.getEncodedSize() + 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SHARED FORMULA (");
        stringBuffer.append(HexDump.intToHex(1212)).append("]\n    .range      = ");
        stringBuffer.append(getRange()).append("\n    .reserved    = ");
        stringBuffer.append(HexDump.shortToHex(this.field_5_reserved)).append("\n");
        Ptg[] tokens = this.field_7_parsed_expr.getTokens();
        for (int i = 0; i < tokens.length; i++) {
            stringBuffer.append("Formula[").append(i).append("]");
            Ptg ptg = tokens[i];
            stringBuffer.append(ptg).append(ptg.getRVAType()).append("\n");
        }
        stringBuffer.append("[/SHARED FORMULA]\n");
        return stringBuffer.toString();
    }

    public Ptg[] getFormulaTokens(FormulaRecord formulaRecord) {
        int row = formulaRecord.getRow();
        short column = formulaRecord.getColumn();
        if (!isInRange(row, column)) {
            throw new RuntimeException("Shared Formula Conversion: Coding Error");
        }
        return new SharedFormula(SpreadsheetVersion.EXCEL97).convertSharedFormulas(this.field_7_parsed_expr.getTokens(), row, column);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SharedFormulaRecord sharedFormulaRecord = new SharedFormulaRecord(getRange());
        sharedFormulaRecord.field_5_reserved = this.field_5_reserved;
        sharedFormulaRecord.field_7_parsed_expr = this.field_7_parsed_expr.copy();
        return sharedFormulaRecord;
    }

    public boolean isFormulaSame(SharedFormulaRecord sharedFormulaRecord) {
        return this.field_7_parsed_expr.isSame(sharedFormulaRecord.field_7_parsed_expr);
    }
}

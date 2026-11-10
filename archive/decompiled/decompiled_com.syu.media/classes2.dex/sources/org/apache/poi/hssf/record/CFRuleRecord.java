package org.apache.poi.hssf.record;

import java.util.Arrays;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CFRuleRecord extends CFRuleBase implements Cloneable {
    public static final short sid = 433;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private CFRuleRecord(byte b, byte b2) {
        super(b, b2);
        setDefaults();
    }

    private CFRuleRecord(byte b, byte b2, Ptg[] ptgArr, Ptg[] ptgArr2) {
        super(b, b2, ptgArr, ptgArr2);
        setDefaults();
    }

    private void setDefaults() {
        this.formatting_options = modificationBits.setValue(this.formatting_options, -1);
        this.formatting_options = fmtBlockBits.setValue(this.formatting_options, 0);
        this.formatting_options = undocumented.clear(this.formatting_options);
        this.formatting_not_used = (short) -32766;
        this._fontFormatting = null;
        this._borderFormatting = null;
        this._patternFormatting = null;
    }

    public static CFRuleRecord create(HSSFSheet hSSFSheet, String str) {
        return new CFRuleRecord((byte) 2, (byte) 0, parseFormula(str, hSSFSheet), null);
    }

    public static CFRuleRecord create(HSSFSheet hSSFSheet, byte b, String str, String str2) {
        return new CFRuleRecord((byte) 1, b, parseFormula(str, hSSFSheet), parseFormula(str2, hSSFSheet));
    }

    public CFRuleRecord(RecordInputStream recordInputStream) {
        setConditionType(recordInputStream.readByte());
        setComparisonOperation(recordInputStream.readByte());
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        readFormatOptions(recordInputStream);
        setFormula1(Formula.read(uShort, recordInputStream));
        setFormula2(Formula.read(uShort2, recordInputStream));
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int formulaSize = getFormulaSize(getFormula1());
        int formulaSize2 = getFormulaSize(getFormula2());
        littleEndianOutput.writeByte(getConditionType());
        littleEndianOutput.writeByte(getComparisonOperation());
        littleEndianOutput.writeShort(formulaSize);
        littleEndianOutput.writeShort(formulaSize2);
        serializeFormattingBlock(littleEndianOutput);
        getFormula1().serializeTokens(littleEndianOutput);
        getFormula2().serializeTokens(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return getFormattingBlockSize() + 6 + getFormulaSize(getFormula1()) + getFormulaSize(getFormula2());
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CFRULE]\n    .condition_type   =");
        stringBuffer.append((int) getConditionType()).append("\n    OPTION FLAGS=0x");
        stringBuffer.append(Integer.toHexString(getOptions())).append("\n");
        if (containsFontFormattingBlock()) {
            stringBuffer.append(this._fontFormatting).append("\n");
        }
        if (containsBorderFormattingBlock()) {
            stringBuffer.append(this._borderFormatting).append("\n");
        }
        if (containsPatternFormattingBlock()) {
            stringBuffer.append(this._patternFormatting).append("\n");
        }
        stringBuffer.append("    Formula 1 =").append(Arrays.toString(getFormula1().getTokens())).append("\n    Formula 2 =");
        stringBuffer.append(Arrays.toString(getFormula2().getTokens())).append("\n[/CFRULE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.CFRuleBase, org.apache.poi.hssf.record.Record
    public CFRuleRecord clone() {
        CFRuleRecord cFRuleRecord = new CFRuleRecord(getConditionType(), getComparisonOperation());
        super.copyTo(cFRuleRecord);
        return cFRuleRecord;
    }
}

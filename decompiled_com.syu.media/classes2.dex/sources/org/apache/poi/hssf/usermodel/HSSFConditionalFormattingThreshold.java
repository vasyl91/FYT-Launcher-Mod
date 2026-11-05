package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFConditionalFormattingThreshold implements ConditionalFormattingThreshold {
    private final HSSFSheet sheet;
    private final Threshold threshold;
    private final HSSFWorkbook workbook;

    protected HSSFConditionalFormattingThreshold(Threshold threshold, HSSFSheet hSSFSheet) {
        this.threshold = threshold;
        this.sheet = hSSFSheet;
        this.workbook = hSSFSheet.getWorkbook();
    }

    protected Threshold getThreshold() {
        return this.threshold;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public ConditionalFormattingThreshold.RangeType getRangeType() {
        return ConditionalFormattingThreshold.RangeType.byId(this.threshold.getType());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public void setRangeType(ConditionalFormattingThreshold.RangeType rangeType) {
        this.threshold.setType((byte) rangeType.id);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public String getFormula() {
        return HSSFConditionalFormattingRule.toFormulaString(this.threshold.getParsedExpression(), this.workbook);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public void setFormula(String str) {
        this.threshold.setParsedExpression(CFRuleBase.parseFormula(str, this.sheet));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public Double getValue() {
        return this.threshold.getValue();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public void setValue(Double d) {
        this.threshold.setValue(d);
    }
}

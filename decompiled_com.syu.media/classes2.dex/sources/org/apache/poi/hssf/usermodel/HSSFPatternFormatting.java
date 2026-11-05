package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.PatternFormatting;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFPatternFormatting implements PatternFormatting {
    private final CFRuleBase cfRuleRecord;
    private final org.apache.poi.hssf.record.cf.PatternFormatting patternFormatting;
    private final HSSFWorkbook workbook;

    protected HSSFPatternFormatting(CFRuleBase cFRuleBase, HSSFWorkbook hSSFWorkbook) {
        this.workbook = hSSFWorkbook;
        this.cfRuleRecord = cFRuleBase;
        this.patternFormatting = cFRuleBase.getPatternFormatting();
    }

    protected org.apache.poi.hssf.record.cf.PatternFormatting getPatternFormattingBlock() {
        return this.patternFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public HSSFColor getFillBackgroundColorColor() {
        return this.workbook.getCustomPalette().getColor(getFillBackgroundColor());
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public HSSFColor getFillForegroundColorColor() {
        return this.workbook.getCustomPalette().getColor(getFillForegroundColor());
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillBackgroundColor() {
        return (short) this.patternFormatting.getFillBackgroundColor();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillForegroundColor() {
        return (short) this.patternFormatting.getFillForegroundColor();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillPattern() {
        return (short) this.patternFormatting.getFillPattern();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setFillBackgroundColor((short) 0);
        } else {
            setFillBackgroundColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setFillForegroundColor((short) 0);
        } else {
            setFillForegroundColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(short s) {
        this.patternFormatting.setFillBackgroundColor(s);
        if (s != 0) {
            this.cfRuleRecord.setPatternBackgroundColorModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(short s) {
        this.patternFormatting.setFillForegroundColor(s);
        if (s != 0) {
            this.cfRuleRecord.setPatternColorModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillPattern(short s) {
        this.patternFormatting.setFillPattern(s);
        if (s != 0) {
            this.cfRuleRecord.setPatternStyleModified(true);
        }
    }
}

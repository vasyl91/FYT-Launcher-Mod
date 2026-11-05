package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FontFormatting;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFFontFormatting implements FontFormatting {
    public static final byte U_DOUBLE = 2;
    public static final byte U_DOUBLE_ACCOUNTING = 34;
    public static final byte U_NONE = 0;
    public static final byte U_SINGLE = 1;
    public static final byte U_SINGLE_ACCOUNTING = 33;
    private final org.apache.poi.hssf.record.cf.FontFormatting fontFormatting;
    private final HSSFWorkbook workbook;

    protected HSSFFontFormatting(CFRuleBase cFRuleBase, HSSFWorkbook hSSFWorkbook) {
        this.fontFormatting = cFRuleBase.getFontFormatting();
        this.workbook = hSSFWorkbook;
    }

    protected org.apache.poi.hssf.record.cf.FontFormatting getFontFormattingBlock() {
        return this.fontFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public short getEscapementType() {
        return this.fontFormatting.getEscapementType();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public short getFontColorIndex() {
        return this.fontFormatting.getFontColorIndex();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public HSSFColor getFontColor() {
        return this.workbook.getCustomPalette().getColor(getFontColorIndex());
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            this.fontFormatting.setFontColorIndex((short) 0);
        } else {
            this.fontFormatting.setFontColorIndex(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public int getFontHeight() {
        return this.fontFormatting.getFontHeight();
    }

    public short getFontWeight() {
        return this.fontFormatting.getFontWeight();
    }

    protected byte[] getRawRecord() {
        return this.fontFormatting.getRawRecord();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public short getUnderlineType() {
        return this.fontFormatting.getUnderlineType();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public boolean isBold() {
        return this.fontFormatting.isFontWeightModified() && this.fontFormatting.isBold();
    }

    public boolean isEscapementTypeModified() {
        return this.fontFormatting.isEscapementTypeModified();
    }

    public boolean isFontCancellationModified() {
        return this.fontFormatting.isFontCancellationModified();
    }

    public boolean isFontOutlineModified() {
        return this.fontFormatting.isFontOutlineModified();
    }

    public boolean isFontShadowModified() {
        return this.fontFormatting.isFontShadowModified();
    }

    public boolean isFontStyleModified() {
        return this.fontFormatting.isFontStyleModified();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public boolean isItalic() {
        return this.fontFormatting.isFontStyleModified() && this.fontFormatting.isItalic();
    }

    public boolean isOutlineOn() {
        return this.fontFormatting.isFontOutlineModified() && this.fontFormatting.isOutlineOn();
    }

    public boolean isShadowOn() {
        return this.fontFormatting.isFontOutlineModified() && this.fontFormatting.isShadowOn();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public boolean isStruckout() {
        return this.fontFormatting.isFontCancellationModified() && this.fontFormatting.isStruckout();
    }

    public boolean isUnderlineTypeModified() {
        return this.fontFormatting.isUnderlineTypeModified();
    }

    public boolean isFontWeightModified() {
        return this.fontFormatting.isFontWeightModified();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontStyle(boolean z, boolean z2) {
        boolean z3 = z || z2;
        this.fontFormatting.setItalic(z);
        this.fontFormatting.setBold(z2);
        this.fontFormatting.setFontStyleModified(z3);
        this.fontFormatting.setFontWieghtModified(z3);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void resetFontStyle() {
        setFontStyle(false, false);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setEscapementType(short s) {
        if (s == 0) {
            this.fontFormatting.setEscapementType(s);
            this.fontFormatting.setEscapementTypeModified(false);
        } else if (s == 1 || s == 2) {
            this.fontFormatting.setEscapementType(s);
            this.fontFormatting.setEscapementTypeModified(true);
        }
    }

    public void setEscapementTypeModified(boolean z) {
        this.fontFormatting.setEscapementTypeModified(z);
    }

    public void setFontCancellationModified(boolean z) {
        this.fontFormatting.setFontCancellationModified(z);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontColorIndex(short s) {
        this.fontFormatting.setFontColorIndex(s);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontHeight(int i) {
        this.fontFormatting.setFontHeight(i);
    }

    public void setFontOutlineModified(boolean z) {
        this.fontFormatting.setFontOutlineModified(z);
    }

    public void setFontShadowModified(boolean z) {
        this.fontFormatting.setFontShadowModified(z);
    }

    public void setFontStyleModified(boolean z) {
        this.fontFormatting.setFontStyleModified(z);
    }

    public void setOutline(boolean z) {
        this.fontFormatting.setOutline(z);
        this.fontFormatting.setFontOutlineModified(z);
    }

    public void setShadow(boolean z) {
        this.fontFormatting.setShadow(z);
        this.fontFormatting.setFontShadowModified(z);
    }

    public void setStrikeout(boolean z) {
        this.fontFormatting.setStrikeout(z);
        this.fontFormatting.setFontCancellationModified(z);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setUnderlineType(short s) {
        if (s == 0) {
            this.fontFormatting.setUnderlineType(s);
            setUnderlineTypeModified(false);
        } else if (s == 1 || s == 2 || s == 33 || s == 34) {
            this.fontFormatting.setUnderlineType(s);
            setUnderlineTypeModified(true);
        }
    }

    public void setUnderlineTypeModified(boolean z) {
        this.fontFormatting.setUnderlineTypeModified(z);
    }
}

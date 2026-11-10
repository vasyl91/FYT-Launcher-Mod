package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Color;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFBorderFormatting implements BorderFormatting {
    private final org.apache.poi.hssf.record.cf.BorderFormatting borderFormatting;
    private final CFRuleBase cfRuleRecord;
    private final HSSFWorkbook workbook;

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderHorizontal(BorderStyle borderStyle) {
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderVertical(BorderStyle borderStyle) {
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setHorizontalBorderColor(Color color) {
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setHorizontalBorderColor(short s) {
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setVerticalBorderColor(Color color) {
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setVerticalBorderColor(short s) {
    }

    protected HSSFBorderFormatting(CFRuleBase cFRuleBase, HSSFWorkbook hSSFWorkbook) {
        this.workbook = hSSFWorkbook;
        this.cfRuleRecord = cFRuleBase;
        this.borderFormatting = cFRuleBase.getBorderFormatting();
    }

    protected org.apache.poi.hssf.record.cf.BorderFormatting getBorderFormattingBlock() {
        return this.borderFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderBottom() {
        return (short) this.borderFormatting.getBorderBottom();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderBottomEnum() {
        return BorderStyle.valueOf((short) this.borderFormatting.getBorderBottom());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderDiagonal() {
        return (short) this.borderFormatting.getBorderDiagonal();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderDiagonalEnum() {
        return BorderStyle.valueOf((short) this.borderFormatting.getBorderDiagonal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderLeft() {
        return (short) this.borderFormatting.getBorderLeft();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderLeftEnum() {
        return BorderStyle.valueOf((short) this.borderFormatting.getBorderLeft());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderRight() {
        return (short) this.borderFormatting.getBorderRight();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderRightEnum() {
        return BorderStyle.valueOf((short) this.borderFormatting.getBorderRight());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderTop() {
        return (short) this.borderFormatting.getBorderTop();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderTopEnum() {
        return BorderStyle.valueOf((short) this.borderFormatting.getBorderTop());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBottomBorderColor() {
        return (short) this.borderFormatting.getBottomBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public HSSFColor getBottomBorderColorColor() {
        return this.workbook.getCustomPalette().getColor(this.borderFormatting.getBottomBorderColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getDiagonalBorderColor() {
        return (short) this.borderFormatting.getDiagonalBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public HSSFColor getDiagonalBorderColorColor() {
        return this.workbook.getCustomPalette().getColor(this.borderFormatting.getDiagonalBorderColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getLeftBorderColor() {
        return (short) this.borderFormatting.getLeftBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public HSSFColor getLeftBorderColorColor() {
        return this.workbook.getCustomPalette().getColor(this.borderFormatting.getLeftBorderColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getRightBorderColor() {
        return (short) this.borderFormatting.getRightBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public HSSFColor getRightBorderColorColor() {
        return this.workbook.getCustomPalette().getColor(this.borderFormatting.getRightBorderColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getTopBorderColor() {
        return (short) this.borderFormatting.getTopBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public HSSFColor getTopBorderColorColor() {
        return this.workbook.getCustomPalette().getColor(this.borderFormatting.getTopBorderColor());
    }

    public boolean isBackwardDiagonalOn() {
        return this.borderFormatting.isBackwardDiagonalOn();
    }

    public boolean isForwardDiagonalOn() {
        return this.borderFormatting.isForwardDiagonalOn();
    }

    public void setBackwardDiagonalOn(boolean z) {
        this.borderFormatting.setBackwardDiagonalOn(z);
        if (z) {
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(z);
        }
    }

    public void setForwardDiagonalOn(boolean z) {
        this.borderFormatting.setForwardDiagonalOn(z);
        if (z) {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(short s) {
        this.borderFormatting.setBorderBottom(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomBorderModified(true);
        } else {
            this.cfRuleRecord.setBottomBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(BorderStyle borderStyle) {
        setBorderBottom(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(short s) {
        this.borderFormatting.setBorderDiagonal(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(true);
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(true);
        } else {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(false);
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(BorderStyle borderStyle) {
        setBorderDiagonal(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(short s) {
        this.borderFormatting.setBorderLeft(s);
        if (s != 0) {
            this.cfRuleRecord.setLeftBorderModified(true);
        } else {
            this.cfRuleRecord.setLeftBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(BorderStyle borderStyle) {
        setBorderLeft(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(short s) {
        this.borderFormatting.setBorderRight(s);
        if (s != 0) {
            this.cfRuleRecord.setRightBorderModified(true);
        } else {
            this.cfRuleRecord.setRightBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(BorderStyle borderStyle) {
        setBorderRight(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(short s) {
        this.borderFormatting.setBorderTop(s);
        if (s != 0) {
            this.cfRuleRecord.setTopBorderModified(true);
        } else {
            this.cfRuleRecord.setTopBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(BorderStyle borderStyle) {
        setBorderTop(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(short s) {
        this.borderFormatting.setBottomBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomBorderModified(true);
        } else {
            this.cfRuleRecord.setBottomBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setBottomBorderColor((short) 0);
        } else {
            setBottomBorderColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(short s) {
        this.borderFormatting.setDiagonalBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(true);
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(true);
        } else {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(false);
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setDiagonalBorderColor((short) 0);
        } else {
            setDiagonalBorderColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(short s) {
        this.borderFormatting.setLeftBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setLeftBorderModified(true);
        } else {
            this.cfRuleRecord.setLeftBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setLeftBorderColor((short) 0);
        } else {
            setLeftBorderColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(short s) {
        this.borderFormatting.setRightBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setRightBorderModified(true);
        } else {
            this.cfRuleRecord.setRightBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setRightBorderColor((short) 0);
        } else {
            setRightBorderColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(short s) {
        this.borderFormatting.setTopBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setTopBorderModified(true);
        } else {
            this.cfRuleRecord.setTopBorderModified(false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setTopBorderColor((short) 0);
        } else {
            setTopBorderColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderVerticalEnum() {
        return BorderStyle.NONE;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderHorizontalEnum() {
        return BorderStyle.NONE;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getVerticalBorderColor() {
        return HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public Color getVerticalBorderColorColor() {
        return HSSFColor.HSSFColorPredefined.AUTOMATIC.getColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getHorizontalBorderColor() {
        return HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public Color getHorizontalBorderColorColor() {
        return HSSFColor.HSSFColorPredefined.AUTOMATIC.getColor();
    }
}

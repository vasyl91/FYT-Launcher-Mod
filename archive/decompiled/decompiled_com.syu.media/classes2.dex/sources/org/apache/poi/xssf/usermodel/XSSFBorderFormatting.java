package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Color;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFBorderFormatting implements BorderFormatting {
    CTBorder _border;
    IndexedColorMap _colorMap;

    XSSFBorderFormatting(CTBorder cTBorder, IndexedColorMap indexedColorMap) {
        this._border = cTBorder;
        this._colorMap = indexedColorMap;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderBottom() {
        return getBorderBottomEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderBottomEnum() {
        return getBorderStyle(this._border.getBottom());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderDiagonal() {
        return getBorderDiagonalEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderDiagonalEnum() {
        return getBorderStyle(this._border.getDiagonal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderLeft() {
        return getBorderLeftEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderLeftEnum() {
        return getBorderStyle(this._border.getLeft());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderRight() {
        return getBorderRightEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderRightEnum() {
        return getBorderStyle(this._border.getRight());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderTop() {
        return getBorderTopEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderTopEnum() {
        return getBorderStyle(this._border.getTop());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getBottomBorderColorColor() {
        return getColor(this._border.getBottom());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBottomBorderColor() {
        return getIndexedColor(getBottomBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getDiagonalBorderColorColor() {
        return getColor(this._border.getDiagonal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getDiagonalBorderColor() {
        return getIndexedColor(getDiagonalBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getLeftBorderColorColor() {
        return getColor(this._border.getLeft());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getLeftBorderColor() {
        return getIndexedColor(getLeftBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getRightBorderColorColor() {
        return getColor(this._border.getRight());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getRightBorderColor() {
        return getIndexedColor(getRightBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getTopBorderColorColor() {
        return getColor(this._border.getTop());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getTopBorderColor() {
        return getIndexedColor(getRightBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(short s) {
        setBorderBottom(BorderStyle.valueOf(s));
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(BorderStyle borderStyle) {
        CTBorderPr bottom = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetBottom();
        } else {
            bottom.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(short s) {
        setBorderDiagonal(BorderStyle.valueOf(s));
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(BorderStyle borderStyle) {
        CTBorderPr diagonal = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetDiagonal();
        } else {
            diagonal.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(short s) {
        setBorderLeft(BorderStyle.valueOf(s));
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(BorderStyle borderStyle) {
        CTBorderPr left = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetLeft();
        } else {
            left.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(short s) {
        setBorderRight(BorderStyle.valueOf(s));
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(BorderStyle borderStyle) {
        CTBorderPr right = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetRight();
        } else {
            right.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(short s) {
        setBorderTop(BorderStyle.valueOf(s));
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(BorderStyle borderStyle) {
        CTBorderPr top = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetTop();
        } else {
            top.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setBottomBorderColor((CTColor) null);
        } else {
            setBottomBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setBottomBorderColor(cTColorNewInstance);
    }

    public void setBottomBorderColor(CTColor cTColor) {
        CTBorderPr bottom = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
        if (cTColor == null) {
            bottom.unsetColor();
        } else {
            bottom.setColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setDiagonalBorderColor((CTColor) null);
        } else {
            setDiagonalBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setDiagonalBorderColor(cTColorNewInstance);
    }

    public void setDiagonalBorderColor(CTColor cTColor) {
        CTBorderPr diagonal = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
        if (cTColor == null) {
            diagonal.unsetColor();
        } else {
            diagonal.setColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setLeftBorderColor((CTColor) null);
        } else {
            setLeftBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setLeftBorderColor(cTColorNewInstance);
    }

    public void setLeftBorderColor(CTColor cTColor) {
        CTBorderPr left = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
        if (cTColor == null) {
            left.unsetColor();
        } else {
            left.setColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setRightBorderColor((CTColor) null);
        } else {
            setRightBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setRightBorderColor(cTColorNewInstance);
    }

    public void setRightBorderColor(CTColor cTColor) {
        CTBorderPr right = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
        if (cTColor == null) {
            right.unsetColor();
        } else {
            right.setColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setTopBorderColor((CTColor) null);
        } else {
            setTopBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setTopBorderColor(cTColorNewInstance);
    }

    public void setTopBorderColor(CTColor cTColor) {
        CTBorderPr top = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
        if (cTColor == null) {
            top.unsetColor();
        } else {
            top.setColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderVerticalEnum() {
        return getBorderStyle(this._border.getVertical());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderHorizontalEnum() {
        return getBorderStyle(this._border.getHorizontal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getVerticalBorderColor() {
        return getIndexedColor(getVerticalBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getVerticalBorderColorColor() {
        return getColor(this._border.getVertical());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getHorizontalBorderColor() {
        return getIndexedColor(getHorizontalBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getHorizontalBorderColorColor() {
        return getColor(this._border.getHorizontal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderHorizontal(BorderStyle borderStyle) {
        CTBorderPr horizontal = this._border.isSetHorizontal() ? this._border.getHorizontal() : this._border.addNewHorizontal();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetHorizontal();
        } else {
            horizontal.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderVertical(BorderStyle borderStyle) {
        CTBorderPr vertical = this._border.isSetVertical() ? this._border.getVertical() : this._border.addNewVertical();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetVertical();
        } else {
            vertical.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setHorizontalBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setHorizontalBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setHorizontalBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setBottomBorderColor((CTColor) null);
        } else {
            setHorizontalBorderColor(xSSFColor.getCTColor());
        }
    }

    public void setHorizontalBorderColor(CTColor cTColor) {
        CTBorderPr horizontal = this._border.isSetHorizontal() ? this._border.getHorizontal() : this._border.addNewHorizontal();
        if (cTColor == null) {
            horizontal.unsetColor();
        } else {
            horizontal.setColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setVerticalBorderColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setVerticalBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setVerticalBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setBottomBorderColor((CTColor) null);
        } else {
            setVerticalBorderColor(xSSFColor.getCTColor());
        }
    }

    public void setVerticalBorderColor(CTColor cTColor) {
        CTBorderPr vertical = this._border.isSetVertical() ? this._border.getVertical() : this._border.addNewVertical();
        if (cTColor == null) {
            vertical.unsetColor();
        } else {
            vertical.setColor(cTColor);
        }
    }

    private BorderStyle getBorderStyle(CTBorderPr cTBorderPr) {
        if (cTBorderPr == null) {
            return BorderStyle.NONE;
        }
        STBorderStyle.Enum style = cTBorderPr.getStyle();
        return style == null ? BorderStyle.NONE : BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    private short getIndexedColor(XSSFColor xSSFColor) {
        if (xSSFColor == null) {
            return (short) 0;
        }
        return xSSFColor.getIndexed();
    }

    private XSSFColor getColor(CTBorderPr cTBorderPr) {
        if (cTBorderPr == null) {
            return null;
        }
        return new XSSFColor(cTBorderPr.getColor(), this._colorMap);
    }
}

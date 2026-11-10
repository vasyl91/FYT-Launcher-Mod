package org.apache.poi.xssf.usermodel;

import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFCellStyle implements CellStyle {
    private XSSFCellAlignment _cellAlignment;
    private final CTXf _cellStyleXf;
    private CTXf _cellXf;
    private int _cellXfId;
    private XSSFFont _font;
    private final StylesTable _stylesSource;
    private ThemesTable _theme;

    public XSSFCellStyle(int i, int i2, StylesTable stylesTable, ThemesTable themesTable) {
        this._cellXfId = i;
        this._stylesSource = stylesTable;
        this._cellXf = stylesTable.getCellXfAt(i);
        this._cellStyleXf = i2 == -1 ? null : stylesTable.getCellStyleXfAt(i2);
        this._theme = themesTable;
    }

    @Internal
    public CTXf getCoreXf() {
        return this._cellXf;
    }

    @Internal
    public CTXf getStyleXf() {
        return this._cellStyleXf;
    }

    public XSSFCellStyle(StylesTable stylesTable) {
        this._stylesSource = stylesTable;
        this._cellXf = CTXf.Factory.newInstance();
        this._cellStyleXf = null;
    }

    public void verifyBelongsToStylesSource(StylesTable stylesTable) {
        if (this._stylesSource != stylesTable) {
            throw new IllegalArgumentException("This Style does not belong to the supplied Workbook Stlyes Source. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void cloneStyleFrom(CellStyle cellStyle) {
        if (cellStyle instanceof XSSFCellStyle) {
            XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
            if (xSSFCellStyle._stylesSource == this._stylesSource) {
                this._cellXf.set(xSSFCellStyle.getCoreXf());
                this._cellStyleXf.set(xSSFCellStyle.getStyleXf());
            } else {
                try {
                    if (this._cellXf.isSetAlignment()) {
                        this._cellXf.unsetAlignment();
                    }
                    if (this._cellXf.isSetExtLst()) {
                        this._cellXf.unsetExtLst();
                    }
                    this._cellXf = CTXf.Factory.parse(xSSFCellStyle.getCoreXf().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                    addFill(CTFill.Factory.parse(xSSFCellStyle.getCTFill().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                    addBorder(CTBorder.Factory.parse(xSSFCellStyle.getCTBorder().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                    this._stylesSource.replaceCellXfAt(this._cellXfId, this._cellXf);
                    setDataFormat(new XSSFDataFormat(this._stylesSource).getFormat(xSSFCellStyle.getDataFormatString()));
                    try {
                        XSSFFont xSSFFont = new XSSFFont(CTFont.Factory.parse(xSSFCellStyle.getFont().getCTFont().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                        xSSFFont.registerTo(this._stylesSource);
                        setFont(xSSFFont);
                    } catch (XmlException e) {
                        throw new POIXMLException(e);
                    }
                } catch (XmlException e2) {
                    throw new POIXMLException(e2);
                }
            }
            this._font = null;
            this._cellAlignment = null;
            return;
        }
        throw new IllegalArgumentException("Can only clone from one XSSFCellStyle to another, not between HSSFCellStyle and XSSFCellStyle");
    }

    private void addFill(CTFill cTFill) {
        this._cellXf.setFillId(this._stylesSource.putFill(new XSSFCellFill(cTFill, this._stylesSource.getIndexedColors())));
        this._cellXf.setApplyFill(true);
    }

    private void addBorder(CTBorder cTBorder) {
        this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getAlignment() {
        return getAlignmentEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HorizontalAlignment getAlignmentEnum() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        if (alignment != null && alignment.isSetHorizontal()) {
            return HorizontalAlignment.forInt(alignment.getHorizontal().intValue() - 1);
        }
        return HorizontalAlignment.GENERAL;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderBottomEnum() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetBottom() ? cTBorder.getBottom().getStyle() : null;
        if (style == null) {
            return BorderStyle.NONE;
        }
        return BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBorderBottom() {
        return getBorderBottomEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderLeftEnum() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetLeft() ? cTBorder.getLeft().getStyle() : null;
        if (style == null) {
            return BorderStyle.NONE;
        }
        return BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBorderLeft() {
        return getBorderLeftEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderRightEnum() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetRight() ? cTBorder.getRight().getStyle() : null;
        if (style == null) {
            return BorderStyle.NONE;
        }
        return BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBorderRight() {
        return getBorderRightEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderTopEnum() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetTop() ? cTBorder.getTop().getStyle() : null;
        if (style == null) {
            return BorderStyle.NONE;
        }
        return BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBorderTop() {
        return getBorderTopEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBottomBorderColor() {
        XSSFColor bottomBorderXSSFColor = getBottomBorderXSSFColor();
        return bottomBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : bottomBorderXSSFColor.getIndexed();
    }

    public XSSFColor getBottomBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getBorderColor(XSSFCellBorder.BorderSide.BOTTOM);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getDataFormat() {
        return (short) this._cellXf.getNumFmtId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public String getDataFormatString() {
        return new XSSFDataFormat(this._stylesSource).getFormat(getDataFormat());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillBackgroundColor() {
        XSSFColor fillBackgroundXSSFColor = getFillBackgroundXSSFColor();
        return fillBackgroundXSSFColor == null ? IndexedColors.AUTOMATIC.getIndex() : fillBackgroundXSSFColor.getIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public XSSFColor getFillBackgroundColorColor() {
        return getFillBackgroundXSSFColor();
    }

    public XSSFColor getFillBackgroundXSSFColor() {
        ThemesTable themesTable;
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return null;
        }
        XSSFColor fillBackgroundColor = this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getFillBackgroundColor();
        if (fillBackgroundColor != null && (themesTable = this._theme) != null) {
            themesTable.inheritFromThemeAsRequired(fillBackgroundColor);
        }
        return fillBackgroundColor;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillForegroundColor() {
        XSSFColor fillForegroundXSSFColor = getFillForegroundXSSFColor();
        return fillForegroundXSSFColor == null ? IndexedColors.AUTOMATIC.getIndex() : fillForegroundXSSFColor.getIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public XSSFColor getFillForegroundColorColor() {
        return getFillForegroundXSSFColor();
    }

    public XSSFColor getFillForegroundXSSFColor() {
        ThemesTable themesTable;
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return null;
        }
        XSSFColor fillForegroundColor = this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getFillForegroundColor();
        if (fillForegroundColor != null && (themesTable = this._theme) != null) {
            themesTable.inheritFromThemeAsRequired(fillForegroundColor);
        }
        return fillForegroundColor;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillPattern() {
        return getFillPatternEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public FillPatternType getFillPatternEnum() {
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return FillPatternType.NO_FILL;
        }
        STPatternType.Enum patternType = this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getPatternType();
        if (patternType == null) {
            return FillPatternType.NO_FILL;
        }
        return FillPatternType.forInt(patternType.intValue() - 1);
    }

    public XSSFFont getFont() {
        if (this._font == null) {
            this._font = this._stylesSource.getFontAt(getFontId());
        }
        return this._font;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFontIndex() {
        return (short) getFontId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getHidden() {
        if (this._cellXf.isSetProtection() && this._cellXf.getProtection().isSetHidden()) {
            return this._cellXf.getProtection().getHidden();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndention() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return (short) (alignment == null ? 0L : alignment.getIndent());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndex() {
        return (short) this._cellXfId;
    }

    protected int getUIndex() {
        return this._cellXfId;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getLeftBorderColor() {
        XSSFColor leftBorderXSSFColor = getLeftBorderXSSFColor();
        return leftBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : leftBorderXSSFColor.getIndexed();
    }

    public XSSFColor getLeftBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getBorderColor(XSSFCellBorder.BorderSide.LEFT);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getLocked() {
        if (this._cellXf.isSetProtection() && this._cellXf.getProtection().isSetLocked()) {
            return this._cellXf.getProtection().getLocked();
        }
        return true;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getQuotePrefixed() {
        return this._cellXf.getQuotePrefix();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRightBorderColor() {
        XSSFColor rightBorderXSSFColor = getRightBorderXSSFColor();
        return rightBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : rightBorderXSSFColor.getIndexed();
    }

    public XSSFColor getRightBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getBorderColor(XSSFCellBorder.BorderSide.RIGHT);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRotation() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return (short) (alignment == null ? 0L : alignment.getTextRotation());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getShrinkToFit() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return alignment != null && alignment.getShrinkToFit();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getTopBorderColor() {
        XSSFColor topBorderXSSFColor = getTopBorderXSSFColor();
        return topBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : topBorderXSSFColor.getIndexed();
    }

    public XSSFColor getTopBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getBorderColor(XSSFCellBorder.BorderSide.TOP);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getVerticalAlignment() {
        return getVerticalAlignmentEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public VerticalAlignment getVerticalAlignmentEnum() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        if (alignment != null && alignment.isSetVertical()) {
            return VerticalAlignment.forInt(alignment.getVertical().intValue() - 1);
        }
        return VerticalAlignment.BOTTOM;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getWrapText() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return alignment != null && alignment.getWrapText();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setAlignment(HorizontalAlignment horizontalAlignment) {
        getCellAlignment().setHorizontal(horizontalAlignment);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderBottom(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr bottom = cTBorder.isSetBottom() ? cTBorder.getBottom() : cTBorder.addNewBottom();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetBottom();
        } else {
            bottom.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderLeft(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr left = cTBorder.isSetLeft() ? cTBorder.getLeft() : cTBorder.addNewLeft();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetLeft();
        } else {
            left.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderRight(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr right = cTBorder.isSetRight() ? cTBorder.getRight() : cTBorder.addNewRight();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetRight();
        } else {
            right.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderTop(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr top = cTBorder.isSetTop() ? cTBorder.getTop() : cTBorder.addNewTop();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetTop();
        } else {
            top.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBottomBorderColor(short s) {
        XSSFColor xSSFColor = new XSSFColor();
        xSSFColor.setIndexed(s);
        setBottomBorderColor(xSSFColor);
    }

    public void setBottomBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetBottom()) {
            CTBorderPr bottom = cTBorder.isSetBottom() ? cTBorder.getBottom() : cTBorder.addNewBottom();
            if (xSSFColor != null) {
                bottom.setColor(xSSFColor.getCTColor());
            } else {
                bottom.unsetColor();
            }
            this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setDataFormat(short s) {
        setDataFormat(s & 65535);
    }

    public void setDataFormat(int i) {
        this._cellXf.setApplyNumberFormat(true);
        this._cellXf.setNumFmtId(i);
    }

    public void setFillBackgroundColor(XSSFColor xSSFColor) {
        CTFill cTFill = getCTFill();
        CTPatternFill patternFill = cTFill.getPatternFill();
        if (xSSFColor == null) {
            if (patternFill != null && patternFill.isSetBgColor()) {
                patternFill.unsetBgColor();
            }
        } else {
            if (patternFill == null) {
                patternFill = cTFill.addNewPatternFill();
            }
            patternFill.setBgColor(xSSFColor.getCTColor());
        }
        addFill(cTFill);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillBackgroundColor(short s) {
        XSSFColor xSSFColor = new XSSFColor();
        xSSFColor.setIndexed(s);
        setFillBackgroundColor(xSSFColor);
    }

    public void setFillForegroundColor(XSSFColor xSSFColor) {
        CTFill cTFill = getCTFill();
        CTPatternFill patternFill = cTFill.getPatternFill();
        if (xSSFColor == null) {
            if (patternFill != null && patternFill.isSetFgColor()) {
                patternFill.unsetFgColor();
            }
        } else {
            if (patternFill == null) {
                patternFill = cTFill.addNewPatternFill();
            }
            patternFill.setFgColor(xSSFColor.getCTColor());
        }
        addFill(cTFill);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillForegroundColor(short s) {
        XSSFColor xSSFColor = new XSSFColor();
        xSSFColor.setIndexed(s);
        setFillForegroundColor(xSSFColor);
    }

    private CTFill getCTFill() {
        if (!this._cellXf.isSetApplyFill() || this._cellXf.getApplyFill()) {
            return this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getCTFill().copy();
        }
        return CTFill.Factory.newInstance();
    }

    private CTBorder getCTBorder() {
        if (this._cellXf.getApplyBorder()) {
            return this._stylesSource.getBorderAt((int) this._cellXf.getBorderId()).getCTBorder().copy();
        }
        return CTBorder.Factory.newInstance();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillPattern(FillPatternType fillPatternType) {
        CTFill cTFill = getCTFill();
        CTPatternFill patternFill = cTFill.isSetPatternFill() ? cTFill.getPatternFill() : cTFill.addNewPatternFill();
        if (fillPatternType == FillPatternType.NO_FILL && patternFill.isSetPatternType()) {
            patternFill.unsetPatternType();
        } else {
            patternFill.setPatternType(STPatternType.Enum.forInt(fillPatternType.getCode() + 1));
        }
        addFill(cTFill);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFont(Font font) {
        if (font != null) {
            this._cellXf.setFontId(font.getIndex());
            this._cellXf.setApplyFont(true);
            return;
        }
        this._cellXf.setApplyFont(false);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setHidden(boolean z) {
        if (!this._cellXf.isSetProtection()) {
            this._cellXf.addNewProtection();
        }
        this._cellXf.getProtection().setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setIndention(short s) {
        getCellAlignment().setIndent(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLeftBorderColor(short s) {
        XSSFColor xSSFColor = new XSSFColor();
        xSSFColor.setIndexed(s);
        setLeftBorderColor(xSSFColor);
    }

    public void setLeftBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetLeft()) {
            CTBorderPr left = cTBorder.isSetLeft() ? cTBorder.getLeft() : cTBorder.addNewLeft();
            if (xSSFColor != null) {
                left.setColor(xSSFColor.getCTColor());
            } else {
                left.unsetColor();
            }
            this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLocked(boolean z) {
        if (!this._cellXf.isSetProtection()) {
            this._cellXf.addNewProtection();
        }
        this._cellXf.getProtection().setLocked(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setQuotePrefixed(boolean z) {
        this._cellXf.setQuotePrefix(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRightBorderColor(short s) {
        XSSFColor xSSFColor = new XSSFColor();
        xSSFColor.setIndexed(s);
        setRightBorderColor(xSSFColor);
    }

    public void setRightBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetRight()) {
            CTBorderPr right = cTBorder.isSetRight() ? cTBorder.getRight() : cTBorder.addNewRight();
            if (xSSFColor != null) {
                right.setColor(xSSFColor.getCTColor());
            } else {
                right.unsetColor();
            }
            this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRotation(short s) {
        getCellAlignment().setTextRotation(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setTopBorderColor(short s) {
        XSSFColor xSSFColor = new XSSFColor();
        xSSFColor.setIndexed(s);
        setTopBorderColor(xSSFColor);
    }

    public void setTopBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetTop()) {
            CTBorderPr top = cTBorder.isSetTop() ? cTBorder.getTop() : cTBorder.addNewTop();
            if (xSSFColor != null) {
                top.setColor(xSSFColor.getCTColor());
            } else {
                top.unsetColor();
            }
            this._cellXf.setBorderId(this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme, this._stylesSource.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        getCellAlignment().setVertical(verticalAlignment);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setWrapText(boolean z) {
        getCellAlignment().setWrapText(z);
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFCellStyle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide;

        static {
            int[] iArr = new int[XSSFCellBorder.BorderSide.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide = iArr;
            try {
                iArr[XSSFCellBorder.BorderSide.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[XSSFCellBorder.BorderSide.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[XSSFCellBorder.BorderSide.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[XSSFCellBorder.BorderSide.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public XSSFColor getBorderColor(XSSFCellBorder.BorderSide borderSide) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[borderSide.ordinal()];
        if (i == 1) {
            return getBottomBorderXSSFColor();
        }
        if (i == 2) {
            return getRightBorderXSSFColor();
        }
        if (i == 3) {
            return getTopBorderXSSFColor();
        }
        if (i == 4) {
            return getLeftBorderXSSFColor();
        }
        throw new IllegalArgumentException("Unknown border: " + borderSide);
    }

    public void setBorderColor(XSSFCellBorder.BorderSide borderSide, XSSFColor xSSFColor) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[borderSide.ordinal()];
        if (i == 1) {
            setBottomBorderColor(xSSFColor);
            return;
        }
        if (i == 2) {
            setRightBorderColor(xSSFColor);
        } else if (i == 3) {
            setTopBorderColor(xSSFColor);
        } else {
            if (i != 4) {
                return;
            }
            setLeftBorderColor(xSSFColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setShrinkToFit(boolean z) {
        getCellAlignment().setShrinkToFit(z);
    }

    private int getFontId() {
        long fontId;
        if (this._cellXf.isSetFontId()) {
            fontId = this._cellXf.getFontId();
        } else {
            fontId = this._cellStyleXf.getFontId();
        }
        return (int) fontId;
    }

    protected XSSFCellAlignment getCellAlignment() {
        if (this._cellAlignment == null) {
            this._cellAlignment = new XSSFCellAlignment(getCTCellAlignment());
        }
        return this._cellAlignment;
    }

    private CTCellAlignment getCTCellAlignment() {
        if (this._cellXf.getAlignment() == null) {
            this._cellXf.setAlignment(CTCellAlignment.Factory.newInstance());
        }
        return this._cellXf.getAlignment();
    }

    public int hashCode() {
        return this._cellXf.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof XSSFCellStyle)) {
            return false;
        }
        return this._cellXf.toString().equals(((XSSFCellStyle) obj).getCoreXf().toString());
    }

    public Object clone() {
        return new XSSFCellStyle(this._stylesSource.putCellXf(this._cellXf.copy()) - 1, this._stylesSource._getStyleXfsSize() - 1, this._stylesSource, this._theme);
    }
}

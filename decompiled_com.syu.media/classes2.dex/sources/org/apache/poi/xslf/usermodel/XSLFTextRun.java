package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import kotlin.UByte;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.xslf.model.CharacterPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTextRun implements TextRun {
    private final XSLFTextParagraph _p;
    private final XmlObject _r;

    protected XSLFTextRun(XmlObject xmlObject, XSLFTextParagraph xSLFTextParagraph) {
        this._r = xmlObject;
        this._p = xSLFTextParagraph;
        if (!(xmlObject instanceof CTRegularTextRun) && !(xmlObject instanceof CTTextLineBreak) && !(xmlObject instanceof CTTextField)) {
            throw new OpenXML4JRuntimeException("unsupported text run of type " + xmlObject.getClass());
        }
    }

    XSLFTextParagraph getParentParagraph() {
        return this._p;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public String getRawText() {
        CTTextField cTTextField = this._r;
        if (cTTextField instanceof CTTextField) {
            return cTTextField.getT();
        }
        return cTTextField instanceof CTTextLineBreak ? "\n" : ((CTRegularTextRun) cTTextField).getT();
    }

    String getRenderableText() {
        CTTextField cTTextField = this._r;
        if (cTTextField instanceof CTTextField) {
            CTTextField cTTextField2 = cTTextField;
            XSLFSheet sheet = this._p.getParentShape().getSheet();
            if ("slidenum".equals(cTTextField2.getType()) && (sheet instanceof XSLFSlide)) {
                return Integer.toString(((XSLFSlide) sheet).getSlideNumber());
            }
            return cTTextField2.getT();
        }
        if (cTTextField instanceof CTTextLineBreak) {
            return "\n";
        }
        String t = ((CTRegularTextRun) cTTextField).getT();
        TextRun.TextCap textCap = getTextCap();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < t.length(); i++) {
            char cCharAt = t.charAt(i);
            if (cCharAt == '\t') {
                stringBuffer.append("  ");
            } else {
                int i2 = AnonymousClass11.$SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[textCap.ordinal()];
                if (i2 == 1) {
                    stringBuffer.append(Character.toUpperCase(cCharAt));
                } else if (i2 == 2) {
                    stringBuffer.append(Character.toLowerCase(cCharAt));
                } else {
                    stringBuffer.append(cCharAt);
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setText(String str) {
        CTTextField cTTextField = this._r;
        if (cTTextField instanceof CTTextField) {
            cTTextField.setT(str);
        } else {
            if (cTTextField instanceof CTTextLineBreak) {
                return;
            }
            ((CTRegularTextRun) cTTextField).setT(str);
        }
    }

    public XmlObject getXmlObject() {
        return this._r;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontColor(Color color) {
        setFontColor(DrawPaint.createSolidPaint(color));
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontColor(PaintStyle paintStyle) {
        if (!(paintStyle instanceof PaintStyle.SolidPaint)) {
            throw new IllegalArgumentException("Currently only SolidPaint is supported!");
        }
        Color colorApplyColorTransform = DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) paintStyle).getSolidColor());
        CTTextCharacterProperties rPr = getRPr(true);
        CTSolidColorFillProperties solidFill = rPr.isSetSolidFill() ? rPr.getSolidFill() : rPr.addNewSolidFill();
        new XSLFColor(solidFill, getParentParagraph().getParentShape().getSheet().getTheme(), solidFill.getSchemeClr()).setColor(colorApplyColorTransform);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public PaintStyle getFontColor() {
        final boolean z = getParentParagraph().getParentShape().getPlaceholder() != null;
        CharacterPropertyFetcher<PaintStyle> characterPropertyFetcher = new CharacterPropertyFetcher<PaintStyle>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.1
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null) {
                    return false;
                }
                XSLFTextShape parentShape = XSLFTextRun.this._p.getParentShape();
                CTShapeStyle spStyle = parentShape.getSpStyle();
                CTSchemeColor schemeClr = (spStyle == null || spStyle.getFontRef() == null) ? null : spStyle.getFontRef().getSchemeClr();
                XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(cTTextCharacterProperties);
                XSLFSheet sheet = parentShape.getSheet();
                PaintStyle paintStyleSelectPaint = XSLFShape.selectPaint(fillDelegate, schemeClr, sheet.getPackagePart(), sheet.getTheme(), z);
                if (paintStyleSelectPaint == null) {
                    return false;
                }
                setValue(paintStyleSelectPaint);
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        return characterPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontSize(Double d) {
        CTTextCharacterProperties rPr = getRPr(true);
        if (d == null) {
            if (rPr.isSetSz()) {
                rPr.unsetSz();
            }
        } else {
            if (d.doubleValue() < 1.0d) {
                throw new IllegalArgumentException("Minimum font size is 1pt but was " + d);
            }
            rPr.setSz((int) (d.doubleValue() * 100.0d));
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public Double getFontSize() {
        CTTextNormalAutofit normAutofit = getParentParagraph().getParentShape().getTextBodyPr().getNormAutofit();
        double fontScale = normAutofit != null ? ((double) normAutofit.getFontScale()) / 100000.0d : 1.0d;
        CharacterPropertyFetcher<Double> characterPropertyFetcher = new CharacterPropertyFetcher<Double>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.2
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetSz()) {
                    return false;
                }
                setValue(Double.valueOf(((double) cTTextCharacterProperties.getSz()) * 0.01d));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return null;
        }
        return Double.valueOf(characterPropertyFetcher.getValue().doubleValue() * fontScale);
    }

    public double getCharacterSpacing() {
        CharacterPropertyFetcher<Double> characterPropertyFetcher = new CharacterPropertyFetcher<Double>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.3
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetSpc()) {
                    return false;
                }
                setValue(Double.valueOf(((double) cTTextCharacterProperties.getSpc()) * 0.01d));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return characterPropertyFetcher.getValue().doubleValue();
    }

    public void setCharacterSpacing(double d) {
        CTTextCharacterProperties rPr = getRPr(true);
        if (d == 0.0d) {
            if (rPr.isSetSpc()) {
                rPr.unsetSpc();
                return;
            }
            return;
        }
        rPr.setSpc((int) (d * 100.0d));
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontFamily(String str) {
        new XSLFFontInfo(FontGroup.getFontGroupFirst(getRawText())).setTypeface(str);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontFamily(String str, FontGroup fontGroup) {
        new XSLFFontInfo(fontGroup).setTypeface(str);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontInfo(FontInfo fontInfo, FontGroup fontGroup) {
        new XSLFFontInfo(fontGroup).copyFrom(fontInfo);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public String getFontFamily() {
        return new XSLFFontInfo(FontGroup.getFontGroupFirst(getRawText())).getTypeface();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public String getFontFamily(FontGroup fontGroup) {
        return new XSLFFontInfo(fontGroup).getTypeface();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public FontInfo getFontInfo(FontGroup fontGroup) {
        XSLFFontInfo xSLFFontInfo = new XSLFFontInfo(fontGroup);
        if (xSLFFontInfo.getTypeface() != null) {
            return xSLFFontInfo;
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public byte getPitchAndFamily() {
        XSLFFontInfo xSLFFontInfo = new XSLFFontInfo(FontGroup.getFontGroupFirst(getRawText()));
        FontPitch pitch = xSLFFontInfo.getPitch();
        if (pitch == null) {
            pitch = FontPitch.VARIABLE;
        }
        FontFamily family = xSLFFontInfo.getFamily();
        if (family == null) {
            family = FontFamily.FF_SWISS;
        }
        return FontPitch.getNativeId(pitch, family);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setStrikethrough(boolean z) {
        getRPr(true).setStrike(z ? STTextStrikeType.SNG_STRIKE : STTextStrikeType.NO_STRIKE);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isStrikethrough() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.4
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetStrike()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getStrike() != STTextStrikeType.NO_STRIKE));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isSuperscript() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.5
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetBaseline()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getBaseline() > 0));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    public void setBaselineOffset(double d) {
        getRPr(true).setBaseline(((int) d) * 1000);
    }

    public void setSuperscript(boolean z) {
        setBaselineOffset(z ? 30.0d : 0.0d);
    }

    public void setSubscript(boolean z) {
        setBaselineOffset(z ? -25.0d : 0.0d);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isSubscript() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.6
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetBaseline()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getBaseline() < 0));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public TextRun.TextCap getTextCap() {
        CharacterPropertyFetcher<TextRun.TextCap> characterPropertyFetcher = new CharacterPropertyFetcher<TextRun.TextCap>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.7
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetCap()) {
                    return false;
                }
                setValue(TextRun.TextCap.values()[cTTextCharacterProperties.getCap().intValue() - 1]);
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        return characterPropertyFetcher.getValue() == null ? TextRun.TextCap.NONE : characterPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setBold(boolean z) {
        getRPr(true).setB(z);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isBold() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.8
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetB()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getB()));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setItalic(boolean z) {
        getRPr(true).setI(z);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isItalic() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.9
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetI()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getI()));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setUnderlined(boolean z) {
        getRPr(true).setU(z ? STTextUnderlineType.SNG : STTextUnderlineType.NONE);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isUnderlined() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.10
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (cTTextCharacterProperties == null || !cTTextCharacterProperties.isSetU()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getU() != STTextUnderlineType.NONE));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    protected CTTextCharacterProperties getRPr(boolean z) {
        CTTextField cTTextField = this._r;
        if (cTTextField instanceof CTTextField) {
            CTTextField cTTextField2 = cTTextField;
            if (cTTextField2.isSetRPr()) {
                return cTTextField2.getRPr();
            }
            if (z) {
                return cTTextField2.addNewRPr();
            }
            return null;
        }
        if (cTTextField instanceof CTTextLineBreak) {
            CTTextLineBreak cTTextLineBreak = (CTTextLineBreak) cTTextField;
            if (cTTextLineBreak.isSetRPr()) {
                return cTTextLineBreak.getRPr();
            }
            if (z) {
                return cTTextLineBreak.addNewRPr();
            }
            return null;
        }
        CTRegularTextRun cTRegularTextRun = (CTRegularTextRun) cTTextField;
        if (cTRegularTextRun.isSetRPr()) {
            return cTRegularTextRun.getRPr();
        }
        if (z) {
            return cTRegularTextRun.addNewRPr();
        }
        return null;
    }

    public String toString() {
        return "[" + getClass() + "]" + getRawText();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public XSLFHyperlink createHyperlink() {
        XSLFHyperlink hyperlink = getHyperlink();
        return hyperlink != null ? hyperlink : new XSLFHyperlink(getRPr(true).addNewHlinkClick(), this._p.getParentShape().getSheet());
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public XSLFHyperlink getHyperlink() {
        CTHyperlink hlinkClick;
        CTTextCharacterProperties rPr = getRPr(false);
        if (rPr == null || (hlinkClick = rPr.getHlinkClick()) == null) {
            return null;
        }
        return new XSLFHyperlink(hlinkClick, this._p.getParentShape().getSheet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fetchCharacterProperty(CharacterPropertyFetcher<?> characterPropertyFetcher) {
        CTTextParagraphProperties defaultParagraphStyle;
        XSLFTextShape parentShape = this._p.getParentShape();
        XSLFSheet sheet = parentShape.getSheet();
        CTTextCharacterProperties rPr = getRPr(false);
        if ((rPr != null && characterPropertyFetcher.fetch(rPr)) || parentShape.fetchShapeProperty(characterPropertyFetcher)) {
            return true;
        }
        if (parentShape.getCTPlaceholder() == null && (defaultParagraphStyle = sheet.getSlideShow().getDefaultParagraphStyle(this._p.getIndentLevel())) != null && characterPropertyFetcher.fetch(defaultParagraphStyle)) {
            return true;
        }
        CTTextParagraphProperties defaultMasterStyle = this._p.getDefaultMasterStyle();
        return defaultMasterStyle != null && characterPropertyFetcher.fetch(defaultMasterStyle);
    }

    void copy(XSLFTextRun xSLFTextRun) {
        String fontFamily = xSLFTextRun.getFontFamily();
        if (fontFamily != null && !fontFamily.equals(getFontFamily())) {
            setFontFamily(fontFamily);
        }
        PaintStyle fontColor = xSLFTextRun.getFontColor();
        if (fontColor != null && !fontColor.equals(getFontColor())) {
            setFontColor(fontColor);
        }
        double dDoubleValue = xSLFTextRun.getFontSize().doubleValue();
        if (dDoubleValue != getFontSize().doubleValue()) {
            setFontSize(Double.valueOf(dDoubleValue));
        }
        boolean zIsBold = xSLFTextRun.isBold();
        if (zIsBold != isBold()) {
            setBold(zIsBold);
        }
        boolean zIsItalic = xSLFTextRun.isItalic();
        if (zIsItalic != isItalic()) {
            setItalic(zIsItalic);
        }
        boolean zIsUnderlined = xSLFTextRun.isUnderlined();
        if (zIsUnderlined != isUnderlined()) {
            setUnderlined(zIsUnderlined);
        }
        boolean zIsStrikethrough = xSLFTextRun.isStrikethrough();
        if (zIsStrikethrough != isStrikethrough()) {
            setStrikethrough(zIsStrikethrough);
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public TextRun.FieldType getFieldType() {
        CTTextField cTTextField = this._r;
        if ((cTTextField instanceof CTTextField) && "slidenum".equals(cTTextField.getType())) {
            return TextRun.FieldType.SLIDE_NUMBER;
        }
        return null;
    }

    private class XSLFFontInfo implements FontInfo {
        private final FontGroup fontGroup;

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public Integer getIndex() {
            return null;
        }

        private XSLFFontInfo(FontGroup fontGroup) {
            this.fontGroup = fontGroup == null ? FontGroup.getFontGroupFirst(XSLFTextRun.this.getRawText()) : fontGroup;
        }

        public void copyFrom(FontInfo fontInfo) {
            CTTextFont xmlObject = getXmlObject(true);
            setTypeface(fontInfo.getTypeface());
            setCharset(fontInfo.getCharset());
            FontPitch pitch = fontInfo.getPitch();
            FontFamily family = fontInfo.getFamily();
            if (pitch == null && family == null) {
                if (xmlObject.isSetPitchFamily()) {
                    xmlObject.unsetPitchFamily();
                }
            } else {
                setPitch(pitch);
                setFamily(family);
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setIndex(int i) {
            throw new UnsupportedOperationException("setIndex not supported by XSLFFontInfo.");
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public String getTypeface() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetTypeface()) {
                return null;
            }
            return xmlObject.getTypeface();
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setTypeface(String str) {
            if (str != null) {
                getXmlObject(true).setTypeface(str);
                return;
            }
            CTTextCharacterProperties rPr = XSLFTextRun.this.getRPr(false);
            if (rPr == null) {
                return;
            }
            int i = AnonymousClass11.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.getFontGroupFirst(XSLFTextRun.this.getRawText()).ordinal()];
            if (i == 2) {
                if (rPr.isSetEa()) {
                    rPr.unsetEa();
                }
            } else if (i == 3) {
                if (rPr.isSetCs()) {
                    rPr.unsetCs();
                }
            } else if (i != 4) {
                if (rPr.isSetLatin()) {
                    rPr.unsetLatin();
                }
            } else if (rPr.isSetSym()) {
                rPr.unsetSym();
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public FontCharset getCharset() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetCharset()) {
                return null;
            }
            return FontCharset.valueOf(xmlObject.getCharset() & UByte.MAX_VALUE);
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setCharset(FontCharset fontCharset) {
            CTTextFont xmlObject = getXmlObject(true);
            if (fontCharset != null) {
                xmlObject.setCharset((byte) fontCharset.getNativeId());
            } else if (xmlObject.isSetCharset()) {
                xmlObject.unsetCharset();
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public FontFamily getFamily() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetPitchFamily()) {
                return null;
            }
            return FontFamily.valueOfPitchFamily(xmlObject.getPitchFamily());
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setFamily(FontFamily fontFamily) {
            CTTextFont xmlObject = getXmlObject(true);
            if (fontFamily != null || xmlObject.isSetPitchFamily()) {
                FontPitch fontPitchValueOfPitchFamily = xmlObject.isSetPitchFamily() ? FontPitch.valueOfPitchFamily(xmlObject.getPitchFamily()) : FontPitch.VARIABLE;
                if (fontFamily == null) {
                    fontFamily = FontFamily.FF_SWISS;
                }
                xmlObject.setPitchFamily(FontPitch.getNativeId(fontPitchValueOfPitchFamily, fontFamily));
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public FontPitch getPitch() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetPitchFamily()) {
                return null;
            }
            return FontPitch.valueOfPitchFamily(xmlObject.getPitchFamily());
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setPitch(FontPitch fontPitch) {
            CTTextFont xmlObject = getXmlObject(true);
            if (fontPitch != null || xmlObject.isSetPitchFamily()) {
                FontFamily fontFamilyValueOfPitchFamily = xmlObject.isSetPitchFamily() ? FontFamily.valueOfPitchFamily(xmlObject.getPitchFamily()) : FontFamily.FF_SWISS;
                if (fontPitch == null) {
                    fontPitch = FontPitch.VARIABLE;
                }
                xmlObject.setPitchFamily(FontPitch.getNativeId(fontPitch, fontFamilyValueOfPitchFamily));
            }
        }

        private CTTextFont getXmlObject(boolean z) {
            if (z) {
                return getCTTextFont(XSLFTextRun.this.getRPr(true), true);
            }
            CharacterPropertyFetcher<CTTextFont> characterPropertyFetcher = new CharacterPropertyFetcher<CTTextFont>(XSLFTextRun.this._p.getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.XSLFFontInfo.1
                @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
                public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                    CTTextFont cTTextFont = XSLFFontInfo.this.getCTTextFont(cTTextCharacterProperties, false);
                    if (cTTextFont == null) {
                        return false;
                    }
                    setValue(cTTextFont);
                    return true;
                }
            };
            XSLFTextRun.this.fetchCharacterProperty(characterPropertyFetcher);
            return characterPropertyFetcher.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CTTextFont getCTTextFont(CTTextCharacterProperties cTTextCharacterProperties, boolean z) {
            CTTextFont ea;
            CTTextFont latin;
            if (cTTextCharacterProperties == null) {
                return null;
            }
            int i = AnonymousClass11.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[this.fontGroup.ordinal()];
            if (i == 2) {
                ea = cTTextCharacterProperties.getEa();
                if (ea == null && z) {
                    ea = cTTextCharacterProperties.addNewEa();
                }
            } else if (i == 3) {
                ea = cTTextCharacterProperties.getCs();
                if (ea == null && z) {
                    ea = cTTextCharacterProperties.addNewCs();
                }
            } else if (i != 4) {
                ea = cTTextCharacterProperties.getLatin();
                if (ea == null && z) {
                    ea = cTTextCharacterProperties.addNewLatin();
                }
            } else {
                ea = cTTextCharacterProperties.getSym();
                if (ea == null && z) {
                    ea = cTTextCharacterProperties.addNewSym();
                }
            }
            if (ea == null) {
                return null;
            }
            String typeface = ea.isSetTypeface() ? ea.getTypeface() : "";
            if (!typeface.startsWith("+mj-") && !typeface.startsWith("+mn-")) {
                return ea;
            }
            CTFontScheme fontScheme = XSLFTextRun.this._p.getParentShape().getSheet().getTheme().getXmlObject().getThemeElements().getFontScheme();
            CTFontCollection majorFont = typeface.startsWith("+mj-") ? fontScheme.getMajorFont() : fontScheme.getMinorFont();
            String strSubstring = typeface.substring(4);
            if ("ea".equals(strSubstring)) {
                latin = majorFont.getEa();
            } else if ("cs".equals(strSubstring)) {
                latin = majorFont.getCs();
            } else {
                latin = majorFont.getLatin();
            }
            CTTextFont cTTextFont = latin;
            return (cTTextFont == null || !cTTextFont.isSetTypeface() || "".equals(cTTextFont.getTypeface())) ? majorFont.getLatin() : cTTextFont;
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTextRun$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap;

        static {
            int[] iArr = new int[FontGroup.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup = iArr;
            try {
                iArr[FontGroup.LATIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.EAST_ASIAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.COMPLEX_SCRIPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.SYMBOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TextRun.TextCap.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap = iArr2;
            try {
                iArr2[TextRun.TextCap.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[TextRun.TextCap.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}

package org.apache.poi.xssf.usermodel;

import java.awt.Color;
import kotlin.UByte;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFTextRun {
    private final XSSFTextParagraph _p;
    private final CTRegularTextRun _r;

    XSSFTextRun(CTRegularTextRun cTRegularTextRun, XSSFTextParagraph xSSFTextParagraph) {
        this._r = cTRegularTextRun;
        this._p = xSSFTextParagraph;
    }

    XSSFTextParagraph getParentParagraph() {
        return this._p;
    }

    public String getText() {
        return this._r.getT();
    }

    public void setText(String str) {
        this._r.setT(str);
    }

    public CTRegularTextRun getXmlObject() {
        return this._r;
    }

    public void setFontColor(Color color) {
        CTTextCharacterProperties rPr = getRPr();
        CTSolidColorFillProperties solidFill = rPr.isSetSolidFill() ? rPr.getSolidFill() : rPr.addNewSolidFill();
        (solidFill.isSetSrgbClr() ? solidFill.getSrgbClr() : solidFill.addNewSrgbClr()).setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
        if (solidFill.isSetHslClr()) {
            solidFill.unsetHslClr();
        }
        if (solidFill.isSetPrstClr()) {
            solidFill.unsetPrstClr();
        }
        if (solidFill.isSetSchemeClr()) {
            solidFill.unsetSchemeClr();
        }
        if (solidFill.isSetScrgbClr()) {
            solidFill.unsetScrgbClr();
        }
        if (solidFill.isSetSysClr()) {
            solidFill.unsetSysClr();
        }
    }

    public Color getFontColor() {
        CTTextCharacterProperties rPr = getRPr();
        if (rPr.isSetSolidFill()) {
            CTSolidColorFillProperties solidFill = rPr.getSolidFill();
            if (solidFill.isSetSrgbClr()) {
                byte[] val = solidFill.getSrgbClr().getVal();
                return new Color(val[0] & UByte.MAX_VALUE, val[1] & UByte.MAX_VALUE, val[2] & UByte.MAX_VALUE);
            }
        }
        return new Color(0, 0, 0);
    }

    public void setFontSize(double d) {
        CTTextCharacterProperties rPr = getRPr();
        if (d == -1.0d) {
            if (rPr.isSetSz()) {
                rPr.unsetSz();
            }
        } else {
            if (d < 1.0d) {
                throw new IllegalArgumentException("Minimum font size is 1pt but was " + d);
            }
            rPr.setSz((int) (d * 100.0d));
        }
    }

    public double getFontSize() {
        CTTextNormalAutofit normAutofit = getParentParagraph().getParentShape().getTxBody().getBodyPr().getNormAutofit();
        double fontScale = normAutofit != null ? ((double) normAutofit.getFontScale()) / 100000.0d : 1.0d;
        CTTextCharacterProperties rPr = getRPr();
        return (rPr.isSetSz() ? ((double) rPr.getSz()) * 0.01d : 11.0d) * fontScale;
    }

    public double getCharacterSpacing() {
        CTTextCharacterProperties rPr = getRPr();
        if (rPr.isSetSpc()) {
            return ((double) rPr.getSpc()) * 0.01d;
        }
        return 0.0d;
    }

    public void setCharacterSpacing(double d) {
        CTTextCharacterProperties rPr = getRPr();
        if (d == 0.0d) {
            if (rPr.isSetSpc()) {
                rPr.unsetSpc();
                return;
            }
            return;
        }
        rPr.setSpc((int) (d * 100.0d));
    }

    public void setFont(String str) {
        setFontFamily(str, (byte) -1, (byte) -1, false);
    }

    public void setFontFamily(String str, byte b, byte b2, boolean z) {
        CTTextCharacterProperties rPr = getRPr();
        if (str == null) {
            if (rPr.isSetLatin()) {
                rPr.unsetLatin();
            }
            if (rPr.isSetCs()) {
                rPr.unsetCs();
            }
            if (rPr.isSetSym()) {
                rPr.unsetSym();
                return;
            }
            return;
        }
        if (z) {
            (rPr.isSetSym() ? rPr.getSym() : rPr.addNewSym()).setTypeface(str);
            return;
        }
        CTTextFont latin = rPr.isSetLatin() ? rPr.getLatin() : rPr.addNewLatin();
        latin.setTypeface(str);
        if (b != -1) {
            latin.setCharset(b);
        }
        if (b2 != -1) {
            latin.setPitchFamily(b2);
        }
    }

    public String getFontFamily() {
        CTTextFont latin = getRPr().getLatin();
        return latin != null ? latin.getTypeface() : XSSFFont.DEFAULT_FONT_NAME;
    }

    public byte getPitchAndFamily() {
        CTTextFont latin = getRPr().getLatin();
        if (latin != null) {
            return latin.getPitchFamily();
        }
        return (byte) 0;
    }

    public void setStrikethrough(boolean z) {
        getRPr().setStrike(z ? STTextStrikeType.SNG_STRIKE : STTextStrikeType.NO_STRIKE);
    }

    public boolean isStrikethrough() {
        CTTextCharacterProperties rPr = getRPr();
        return rPr.isSetStrike() && rPr.getStrike() != STTextStrikeType.NO_STRIKE;
    }

    public boolean isSuperscript() {
        CTTextCharacterProperties rPr = getRPr();
        return rPr.isSetBaseline() && rPr.getBaseline() > 0;
    }

    public void setBaselineOffset(double d) {
        getRPr().setBaseline(((int) d) * 1000);
    }

    public void setSuperscript(boolean z) {
        setBaselineOffset(z ? 30.0d : 0.0d);
    }

    public void setSubscript(boolean z) {
        setBaselineOffset(z ? -25.0d : 0.0d);
    }

    public boolean isSubscript() {
        CTTextCharacterProperties rPr = getRPr();
        return rPr.isSetBaseline() && rPr.getBaseline() < 0;
    }

    public TextCap getTextCap() {
        CTTextCharacterProperties rPr = getRPr();
        if (rPr.isSetCap()) {
            return TextCap.values()[rPr.getCap().intValue() - 1];
        }
        return TextCap.NONE;
    }

    public void setBold(boolean z) {
        getRPr().setB(z);
    }

    public boolean isBold() {
        CTTextCharacterProperties rPr = getRPr();
        if (rPr.isSetB()) {
            return rPr.getB();
        }
        return false;
    }

    public void setItalic(boolean z) {
        getRPr().setI(z);
    }

    public boolean isItalic() {
        CTTextCharacterProperties rPr = getRPr();
        if (rPr.isSetI()) {
            return rPr.getI();
        }
        return false;
    }

    public void setUnderline(boolean z) {
        getRPr().setU(z ? STTextUnderlineType.SNG : STTextUnderlineType.NONE);
    }

    public boolean isUnderline() {
        CTTextCharacterProperties rPr = getRPr();
        return rPr.isSetU() && rPr.getU() != STTextUnderlineType.NONE;
    }

    protected CTTextCharacterProperties getRPr() {
        return this._r.isSetRPr() ? this._r.getRPr() : this._r.addNewRPr();
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }
}

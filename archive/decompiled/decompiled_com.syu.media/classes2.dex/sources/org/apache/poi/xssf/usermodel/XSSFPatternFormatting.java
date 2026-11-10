package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFPatternFormatting implements PatternFormatting {
    IndexedColorMap _colorMap;
    CTFill _fill;

    XSSFPatternFormatting(CTFill cTFill, IndexedColorMap indexedColorMap) {
        this._fill = cTFill;
        this._colorMap = indexedColorMap;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public XSSFColor getFillBackgroundColorColor() {
        if (this._fill.isSetPatternFill()) {
            return new XSSFColor(this._fill.getPatternFill().getBgColor(), this._colorMap);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public XSSFColor getFillForegroundColorColor() {
        if (this._fill.isSetPatternFill() && this._fill.getPatternFill().isSetFgColor()) {
            return new XSSFColor(this._fill.getPatternFill().getFgColor(), this._colorMap);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillPattern() {
        if (this._fill.isSetPatternFill() && this._fill.getPatternFill().isSetPatternType()) {
            return (short) (this._fill.getPatternFill().getPatternType().intValue() - 1);
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillBackgroundColor() {
        XSSFColor fillBackgroundColorColor = getFillBackgroundColorColor();
        if (fillBackgroundColorColor == null) {
            return (short) 0;
        }
        return fillBackgroundColorColor.getIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillForegroundColor() {
        XSSFColor fillForegroundColorColor = getFillForegroundColorColor();
        if (fillForegroundColorColor == null) {
            return (short) 0;
        }
        return fillForegroundColorColor.getIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setFillBackgroundColor((CTColor) null);
        } else {
            setFillBackgroundColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setFillBackgroundColor(cTColorNewInstance);
    }

    private void setFillBackgroundColor(CTColor cTColor) {
        CTPatternFill patternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
        if (cTColor == null) {
            patternFill.unsetBgColor();
        } else {
            patternFill.setBgColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setFillForegroundColor((CTColor) null);
        } else {
            setFillForegroundColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(short s) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s);
        setFillForegroundColor(cTColorNewInstance);
    }

    private void setFillForegroundColor(CTColor cTColor) {
        CTPatternFill patternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
        if (cTColor == null) {
            patternFill.unsetFgColor();
        } else {
            patternFill.setFgColor(cTColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillPattern(short s) {
        CTPatternFill patternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
        if (s == 0) {
            patternFill.unsetPatternType();
        } else {
            patternFill.setPatternType(STPatternType.Enum.forInt(s + 1));
        }
    }
}

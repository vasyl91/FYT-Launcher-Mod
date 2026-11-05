package org.apache.poi.xssf.usermodel.extensions;

import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFCellFill {
    private CTFill _fill;
    private IndexedColorMap _indexedColorMap;

    public XSSFCellFill(CTFill cTFill, IndexedColorMap indexedColorMap) {
        this._fill = cTFill;
        this._indexedColorMap = indexedColorMap;
    }

    public XSSFCellFill() {
        this._fill = CTFill.Factory.newInstance();
    }

    public XSSFColor getFillBackgroundColor() {
        CTColor bgColor;
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null || (bgColor = patternFill.getBgColor()) == null) {
            return null;
        }
        return new XSSFColor(bgColor, this._indexedColorMap);
    }

    public void setFillBackgroundColor(int i) {
        CTPatternFill cTPatternFillEnsureCTPatternFill = ensureCTPatternFill();
        (cTPatternFillEnsureCTPatternFill.isSetBgColor() ? cTPatternFillEnsureCTPatternFill.getBgColor() : cTPatternFillEnsureCTPatternFill.addNewBgColor()).setIndexed(i);
    }

    public void setFillBackgroundColor(XSSFColor xSSFColor) {
        ensureCTPatternFill().setBgColor(xSSFColor.getCTColor());
    }

    public XSSFColor getFillForegroundColor() {
        CTColor fgColor;
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null || (fgColor = patternFill.getFgColor()) == null) {
            return null;
        }
        return new XSSFColor(fgColor, this._indexedColorMap);
    }

    public void setFillForegroundColor(int i) {
        CTPatternFill cTPatternFillEnsureCTPatternFill = ensureCTPatternFill();
        (cTPatternFillEnsureCTPatternFill.isSetFgColor() ? cTPatternFillEnsureCTPatternFill.getFgColor() : cTPatternFillEnsureCTPatternFill.addNewFgColor()).setIndexed(i);
    }

    public void setFillForegroundColor(XSSFColor xSSFColor) {
        ensureCTPatternFill().setFgColor(xSSFColor.getCTColor());
    }

    public STPatternType.Enum getPatternType() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return patternFill.getPatternType();
    }

    public void setPatternType(STPatternType.Enum r2) {
        ensureCTPatternFill().setPatternType(r2);
    }

    private CTPatternFill ensureCTPatternFill() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        return patternFill == null ? this._fill.addNewPatternFill() : patternFill;
    }

    @Internal
    public CTFill getCTFill() {
        return this._fill;
    }

    public int hashCode() {
        return this._fill.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof XSSFCellFill) {
            return this._fill.toString().equals(((XSSFCellFill) obj).getCTFill().toString());
        }
        return false;
    }
}

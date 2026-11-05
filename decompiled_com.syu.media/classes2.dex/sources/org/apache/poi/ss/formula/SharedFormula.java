package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SharedFormula {
    private final int _columnWrappingMask;
    private final int _rowWrappingMask;

    public SharedFormula(SpreadsheetVersion spreadsheetVersion) {
        this._columnWrappingMask = spreadsheetVersion.getLastColumnIndex();
        this._rowWrappingMask = spreadsheetVersion.getLastRowIndex();
    }

    public Ptg[] convertSharedFormulas(Ptg[] ptgArr, int i, int i2) {
        Ptg[] ptgArr2 = new Ptg[ptgArr.length];
        for (int i3 = 0; i3 < ptgArr.length; i3++) {
            Ptg ptgCopy = ptgArr[i3];
            byte ptgClass = !ptgCopy.isBaseToken() ? ptgCopy.getPtgClass() : (byte) -1;
            if (ptgCopy instanceof RefPtgBase) {
                RefPtgBase refPtgBase = (RefPtgBase) ptgCopy;
                RefPtg refPtg = new RefPtg(fixupRelativeRow(i, refPtgBase.getRow(), refPtgBase.isRowRelative()), fixupRelativeColumn(i2, refPtgBase.getColumn(), refPtgBase.isColRelative()), refPtgBase.isRowRelative(), refPtgBase.isColRelative());
                refPtg.setClass(ptgClass);
                ptgCopy = refPtg;
            } else if (ptgCopy instanceof AreaPtgBase) {
                AreaPtgBase areaPtgBase = (AreaPtgBase) ptgCopy;
                AreaPtg areaPtg = new AreaPtg(fixupRelativeRow(i, areaPtgBase.getFirstRow(), areaPtgBase.isFirstRowRelative()), fixupRelativeRow(i, areaPtgBase.getLastRow(), areaPtgBase.isLastRowRelative()), fixupRelativeColumn(i2, areaPtgBase.getFirstColumn(), areaPtgBase.isFirstColRelative()), fixupRelativeColumn(i2, areaPtgBase.getLastColumn(), areaPtgBase.isLastColRelative()), areaPtgBase.isFirstRowRelative(), areaPtgBase.isLastRowRelative(), areaPtgBase.isFirstColRelative(), areaPtgBase.isLastColRelative());
                areaPtg.setClass(ptgClass);
                ptgCopy = areaPtg;
            } else if (ptgCopy instanceof OperandPtg) {
                ptgCopy = ((OperandPtg) ptgCopy).copy();
            }
            ptgArr2[i3] = ptgCopy;
        }
        return ptgArr2;
    }

    private int fixupRelativeColumn(int i, int i2, boolean z) {
        if (!z) {
            return i2;
        }
        return this._columnWrappingMask & (i2 + i);
    }

    private int fixupRelativeRow(int i, int i2, boolean z) {
        if (!z) {
            return i2;
        }
        return this._rowWrappingMask & (i2 + i);
    }
}

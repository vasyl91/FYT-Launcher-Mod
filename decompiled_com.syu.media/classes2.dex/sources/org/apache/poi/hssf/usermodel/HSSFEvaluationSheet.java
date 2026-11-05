package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
final class HSSFEvaluationSheet implements EvaluationSheet {
    private final HSSFSheet _hs;

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public void clearAllCachedResultValues() {
    }

    public HSSFEvaluationSheet(HSSFSheet hSSFSheet) {
        this._hs = hSSFSheet;
    }

    public HSSFSheet getHSSFSheet() {
        return this._hs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int i, int i2) {
        HSSFCell cell;
        HSSFRow row = this._hs.getRow(i);
        if (row == null || (cell = row.getCell(i2)) == null) {
            return null;
        }
        return new HSSFEvaluationCell(cell, this);
    }
}

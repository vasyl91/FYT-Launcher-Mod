package org.apache.poi.xssf.streaming;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
final class SXSSFEvaluationSheet implements EvaluationSheet {
    private final SXSSFSheet _xs;

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public void clearAllCachedResultValues() {
    }

    public SXSSFEvaluationSheet(SXSSFSheet sXSSFSheet) {
        this._xs = sXSSFSheet;
    }

    public SXSSFSheet getSXSSFSheet() {
        return this._xs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int i, int i2) {
        SXSSFRow row = this._xs.getRow(i);
        if (row == null) {
            if (i > this._xs.getLastFlushedRowNum()) {
                return null;
            }
            throw new SXSSFFormulaEvaluator.RowFlushedException(i);
        }
        SXSSFCell cell = row.getCell(i2);
        if (cell == null) {
            return null;
        }
        return new SXSSFEvaluationCell(cell, this);
    }
}

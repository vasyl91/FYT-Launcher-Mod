package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class LazyAreaEval extends AreaEvalBase {
    private final SheetRangeEvaluator _evaluator;

    LazyAreaEval(AreaI areaI, SheetRangeEvaluator sheetRangeEvaluator) {
        super(areaI, sheetRangeEvaluator);
        this._evaluator = sheetRangeEvaluator;
    }

    public LazyAreaEval(int i, int i2, int i3, int i4, SheetRangeEvaluator sheetRangeEvaluator) {
        super(sheetRangeEvaluator, i, i2, i3, i4);
        this._evaluator = sheetRangeEvaluator;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.eval.AreaEval
    public ValueEval getRelativeValue(int i, int i2) {
        return getRelativeValue(getFirstSheetIndex(), i, i2);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase
    public ValueEval getRelativeValue(int i, int i2, int i3) {
        return this._evaluator.getEvalForCell(i, i2 + getFirstRow(), i3 + getFirstColumn());
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public AreaEval offset(int i, int i2, int i3, int i4) {
        return new LazyAreaEval(new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), i, i2, i3, i4), this._evaluator);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getRow(int i) {
        if (i >= getHeight()) {
            throw new IllegalArgumentException("Invalid rowIndex " + i + ".  Allowable range is (0.." + getHeight() + ").");
        }
        int firstRow = getFirstRow() + i;
        return new LazyAreaEval(firstRow, getFirstColumn(), firstRow, getLastColumn(), this._evaluator);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getColumn(int i) {
        if (i >= getWidth()) {
            throw new IllegalArgumentException("Invalid columnIndex " + i + ".  Allowable range is (0.." + getWidth() + ").");
        }
        int firstColumn = getFirstColumn() + i;
        return new LazyAreaEval(getFirstRow(), firstColumn, getLastRow(), firstColumn, this._evaluator);
    }

    public String toString() {
        return getClass().getName() + "[" + this._evaluator.getSheetNameRange() + '!' + new CellReference(getFirstRow(), getFirstColumn()).formatAsString() + ':' + new CellReference(getLastRow(), getLastColumn()).formatAsString() + "]";
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.TwoDEval
    public boolean isSubTotal(int i, int i2) {
        SheetRangeEvaluator sheetRangeEvaluator = this._evaluator;
        return sheetRangeEvaluator.getSheetEvaluator(sheetRangeEvaluator.getFirstSheetIndex()).isSubTotal(getFirstRow() + i, getFirstColumn() + i2);
    }
}

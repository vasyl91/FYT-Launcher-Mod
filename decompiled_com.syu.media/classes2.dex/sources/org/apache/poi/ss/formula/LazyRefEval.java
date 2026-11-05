package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.RefEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LazyRefEval extends RefEvalBase {
    private final SheetRangeEvaluator _evaluator;

    public LazyRefEval(int i, int i2, SheetRangeEvaluator sheetRangeEvaluator) {
        super(sheetRangeEvaluator, i, i2);
        this._evaluator = sheetRangeEvaluator;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public ValueEval getInnerValueEval(int i) {
        return this._evaluator.getEvalForCell(i, getRow(), getColumn());
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public AreaEval offset(int i, int i2, int i3, int i4) {
        return new LazyAreaEval(new AreaI.OffsetArea(getRow(), getColumn(), i, i2, i3, i4), this._evaluator);
    }

    public boolean isSubTotal() {
        return this._evaluator.getSheetEvaluator(getFirstSheetIndex()).isSubTotal(getRow(), getColumn());
    }

    public String toString() {
        return getClass().getName() + "[" + this._evaluator.getSheetNameRange() + '!' + new CellReference(getRow(), getColumn()).formatAsString() + "]";
    }
}

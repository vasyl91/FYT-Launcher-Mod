package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class EvaluationTracker {
    private final EvaluationCache _cache;
    private final List<CellEvaluationFrame> _evaluationFrames = new ArrayList();
    private final Set<FormulaCellCacheEntry> _currentlyEvaluatingCells = new HashSet();

    public EvaluationTracker(EvaluationCache evaluationCache) {
        this._cache = evaluationCache;
    }

    public boolean startEvaluate(FormulaCellCacheEntry formulaCellCacheEntry) {
        if (formulaCellCacheEntry == null) {
            throw new IllegalArgumentException("cellLoc must not be null");
        }
        if (this._currentlyEvaluatingCells.contains(formulaCellCacheEntry)) {
            return false;
        }
        this._currentlyEvaluatingCells.add(formulaCellCacheEntry);
        this._evaluationFrames.add(new CellEvaluationFrame(formulaCellCacheEntry));
        return true;
    }

    public void updateCacheResult(ValueEval valueEval) {
        int size = this._evaluationFrames.size();
        if (size < 1) {
            throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
        }
        CellEvaluationFrame cellEvaluationFrame = this._evaluationFrames.get(size - 1);
        if (valueEval != ErrorEval.CIRCULAR_REF_ERROR || size <= 1) {
            cellEvaluationFrame.updateFormulaResult(valueEval);
        }
    }

    public void endEvaluate(CellCacheEntry cellCacheEntry) {
        int size = this._evaluationFrames.size();
        if (size < 1) {
            throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
        }
        int i = size - 1;
        if (cellCacheEntry != this._evaluationFrames.get(i).getCCE()) {
            throw new IllegalStateException("Wrong cell specified. ");
        }
        this._evaluationFrames.remove(i);
        this._currentlyEvaluatingCells.remove(cellCacheEntry);
    }

    public void acceptFormulaDependency(CellCacheEntry cellCacheEntry) {
        int size = this._evaluationFrames.size() - 1;
        if (size < 0) {
            return;
        }
        this._evaluationFrames.get(size).addSensitiveInputCell(cellCacheEntry);
    }

    public void acceptPlainValueDependency(int i, int i2, int i3, int i4, ValueEval valueEval) {
        int size = this._evaluationFrames.size() - 1;
        if (size < 0) {
            return;
        }
        CellEvaluationFrame cellEvaluationFrame = this._evaluationFrames.get(size);
        if (valueEval == BlankEval.instance) {
            cellEvaluationFrame.addUsedBlankCell(i, i2, i3, i4);
        } else {
            cellEvaluationFrame.addSensitiveInputCell(this._cache.getPlainValueEntry(i, i2, i3, i4, valueEval));
        }
    }
}

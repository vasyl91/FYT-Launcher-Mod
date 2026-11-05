package org.apache.poi.ss.usermodel;

import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface FormulaEvaluator {
    void clearAllCachedResultValues();

    CellValue evaluate(Cell cell);

    void evaluateAll();

    int evaluateFormulaCell(Cell cell);

    CellType evaluateFormulaCellEnum(Cell cell);

    Cell evaluateInCell(Cell cell);

    void notifyDeleteCell(Cell cell);

    void notifySetFormula(Cell cell);

    void notifyUpdateCell(Cell cell);

    void setDebugEvaluationOutputForNextEval(boolean z);

    void setIgnoreMissingWorkbooks(boolean z);

    void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map);
}

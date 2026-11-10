package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Sumifs extends Baseifs {
    public static final FreeRefFunction instance = new Sumifs();

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    protected boolean hasInitialRange() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs, org.apache.poi.ss.formula.functions.FreeRefFunction
    public /* bridge */ /* synthetic */ ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return super.evaluate(valueEvalArr, operationEvaluationContext);
    }
}

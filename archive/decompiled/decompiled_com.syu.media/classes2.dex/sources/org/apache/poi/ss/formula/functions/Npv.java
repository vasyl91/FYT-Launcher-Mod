package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Npv implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEvalArr[0], i, i2);
            int length = valueEvalArr.length - 1;
            ValueEval[] valueEvalArr2 = new ValueEval[length];
            System.arraycopy(valueEvalArr, 1, valueEvalArr2, 0, length);
            double dNpv = FinanceLib.npv(dSingleOperandEvaluate, AggregateFunction.ValueCollector.collectValues(valueEvalArr2));
            NumericFunction.checkValue(dNpv);
            return new NumberEval(dNpv);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

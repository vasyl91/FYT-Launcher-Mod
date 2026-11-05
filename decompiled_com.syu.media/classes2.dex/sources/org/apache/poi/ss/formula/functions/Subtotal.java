package org.apache.poi.ss.formula.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.poi.ss.formula.LazyRefEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Subtotal implements Function {
    private static Function findFunction(int i) throws EvaluationException {
        switch (i) {
            case 1:
                return AggregateFunction.subtotalInstance(AggregateFunction.AVERAGE);
            case 2:
                return Count.subtotalInstance();
            case 3:
                return Counta.subtotalInstance();
            case 4:
                return AggregateFunction.subtotalInstance(AggregateFunction.MAX);
            case 5:
                return AggregateFunction.subtotalInstance(AggregateFunction.MIN);
            case 6:
                return AggregateFunction.subtotalInstance(AggregateFunction.PRODUCT);
            case 7:
                return AggregateFunction.subtotalInstance(AggregateFunction.STDEV);
            case 8:
                throw new NotImplementedFunctionException("STDEVP");
            case 9:
                return AggregateFunction.subtotalInstance(AggregateFunction.SUM);
            case 10:
                throw new NotImplementedFunctionException("VAR");
            case 11:
                throw new NotImplementedFunctionException("VARP");
            default:
                if (i > 100 && i < 112) {
                    throw new NotImplementedException("SUBTOTAL - with 'exclude hidden values' option");
                }
                throw EvaluationException.invalidValue();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length - 1 < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            Function functionFindFunction = findFunction(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[0], i, i2)));
            ArrayList arrayList = new ArrayList(Arrays.asList(valueEvalArr).subList(1, valueEvalArr.length));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ValueEval valueEval = (ValueEval) it.next();
                if ((valueEval instanceof LazyRefEval) && ((LazyRefEval) valueEval).isSubTotal()) {
                    it.remove();
                }
            }
            return functionFindFunction.evaluate((ValueEval[]) arrayList.toArray(new ValueEval[arrayList.size()]), i, i2);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Vlookup extends Var3or4ArgFunction {
    private static final ValueEval DEFAULT_ARG3 = BoolEval.TRUE;

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        return evaluate(i, i2, valueEval, valueEval2, valueEval3, DEFAULT_ARG3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            TwoDEval twoDEvalResolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            return createResultColumnVector(twoDEvalResolveTableArrayArg, LookupUtils.resolveRowOrColIndexArg(valueEval3, i, i2)).getItem(LookupUtils.lookupIndexOfValue(singleValue, LookupUtils.createColumnVector(twoDEvalResolveTableArrayArg, 0), LookupUtils.resolveRangeLookupArg(valueEval4, i, i2)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private LookupUtils.ValueVector createResultColumnVector(TwoDEval twoDEval, int i) throws EvaluationException {
        if (i >= twoDEval.getWidth()) {
            throw EvaluationException.invalidRef();
        }
        return LookupUtils.createColumnVector(twoDEval, i);
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IfFunc extends Var2or3ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            if (evaluateFirstArg(valueEval, i, i2)) {
                return valueEval2 == MissingArgEval.instance ? BlankEval.instance : valueEval2;
            }
            return BoolEval.FALSE;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            if (evaluateFirstArg(valueEval, i, i2)) {
                return valueEval2 == MissingArgEval.instance ? BlankEval.instance : valueEval2;
            }
            return valueEval3 == MissingArgEval.instance ? BlankEval.instance : valueEval3;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static boolean evaluateFirstArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEval, i, i2), false);
        if (boolCoerceValueToBoolean == null) {
            return false;
        }
        return boolCoerceValueToBoolean.booleanValue();
    }
}

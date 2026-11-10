package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class TwoOperandNumericOperation extends Fixed2ArgFunction {
    public static final Function AddEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.1
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        protected double evaluate(double d, double d2) {
            return d + d2;
        }
    };
    public static final Function DivideEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.2
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        protected double evaluate(double d, double d2) throws EvaluationException {
            if (d2 != 0.0d) {
                return d / d2;
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function MultiplyEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.3
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        protected double evaluate(double d, double d2) {
            return d * d2;
        }
    };
    public static final Function PowerEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.4
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        protected double evaluate(double d, double d2) {
            return Math.pow(d, d2);
        }
    };
    public static final Function SubtractEval = new SubtractEvalClass();

    private static final class SubtractEvalClass extends TwoOperandNumericOperation {
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        protected double evaluate(double d, double d2) {
            return d - d2;
        }
    }

    protected abstract double evaluate(double d, double d2) throws EvaluationException;

    protected final double singleOperandEvaluate(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double dEvaluate = evaluate(singleOperandEvaluate(valueEval, i, i2), singleOperandEvaluate(valueEval2, i, i2));
            if (dEvaluate == 0.0d && !(this instanceof SubtractEvalClass)) {
                return NumberEval.ZERO;
            }
            if (Double.isNaN(dEvaluate) || Double.isInfinite(dEvaluate)) {
                return ErrorEval.NUM_ERROR;
            }
            return new NumberEval(dEvaluate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

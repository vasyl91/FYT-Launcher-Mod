package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class FinanceFunction implements Function3Arg, Function4Arg {
    private static final ValueEval DEFAULT_ARG3 = NumberEval.ZERO;
    private static final ValueEval DEFAULT_ARG4 = BoolEval.FALSE;
    public static final Function FV = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.1
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        protected double evaluate(double d, double d2, double d3, double d4, boolean z) {
            return FinanceLib.fv(d, d2, d3, d4, z);
        }
    };
    public static final Function NPER = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.2
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        protected double evaluate(double d, double d2, double d3, double d4, boolean z) {
            return FinanceLib.nper(d, d2, d3, d4, z);
        }
    };
    public static final Function PMT = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.3
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        protected double evaluate(double d, double d2, double d3, double d4, boolean z) {
            return FinanceLib.pmt(d, d2, d3, d4, z);
        }
    };
    public static final Function PV = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.4
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        protected double evaluate(double d, double d2, double d3, double d4, boolean z) {
            return FinanceLib.pv(d, d2, d3, d4, z);
        }
    };

    protected abstract double evaluate(double d, double d2, double d3, double d4, boolean z) throws EvaluationException;

    protected FinanceFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        return evaluate(i, i2, valueEval, valueEval2, valueEval3, DEFAULT_ARG3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        return evaluate(i, i2, valueEval, valueEval2, valueEval3, valueEval4, DEFAULT_ARG4);
    }

    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4, ValueEval valueEval5) {
        try {
            double dEvaluate = evaluate(NumericFunction.singleOperandEvaluate(valueEval, i, i2), NumericFunction.singleOperandEvaluate(valueEval2, i, i2), NumericFunction.singleOperandEvaluate(valueEval3, i, i2), NumericFunction.singleOperandEvaluate(valueEval4, i, i2), NumericFunction.singleOperandEvaluate(valueEval5, i, i2) != 0.0d);
            NumericFunction.checkValue(dEvaluate);
            return new NumberEval(dEvaluate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 3) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], DEFAULT_ARG3, DEFAULT_ARG4);
        }
        if (length == 4) {
            ValueEval valueEval = valueEvalArr[3];
            if (valueEval == MissingArgEval.instance) {
                valueEval = DEFAULT_ARG3;
            }
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEval, DEFAULT_ARG4);
        }
        if (length == 5) {
            ValueEval valueEval2 = valueEvalArr[3];
            if (valueEval2 == MissingArgEval.instance) {
                valueEval2 = DEFAULT_ARG3;
            }
            ValueEval valueEval3 = valueEval2;
            ValueEval valueEval4 = valueEvalArr[4];
            if (valueEval4 == MissingArgEval.instance) {
                valueEval4 = DEFAULT_ARG4;
            }
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEval3, valueEval4);
        }
        return ErrorEval.VALUE_INVALID;
    }

    protected double evaluate(double[] dArr) throws EvaluationException {
        double d;
        double d2;
        int length = dArr.length;
        if (length != 3) {
            if (length == 4) {
                d = 0.0d;
            } else if (length == 5) {
                d = dArr[4];
            } else {
                throw new IllegalStateException("Wrong number of arguments");
            }
            d2 = dArr[3];
        } else {
            d = 0.0d;
            d2 = 0.0d;
        }
        return evaluate(dArr[0], dArr[1], dArr[2], d2, d != 0.0d);
    }
}

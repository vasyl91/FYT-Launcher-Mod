package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class NumericFunction implements Function {
    static final double ZERO = 0.0d;
    static final double TEN = 10.0d;
    static final double LOG_10_TO_BASE_e = Math.log(TEN);
    public static final Function ABS = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.1
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.abs(d);
        }
    };
    public static final Function ACOS = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.2
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.acos(d);
        }
    };
    public static final Function ACOSH = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.3
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.acosh(d);
        }
    };
    public static final Function ASIN = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.4
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.asin(d);
        }
    };
    public static final Function ASINH = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.5
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.asinh(d);
        }
    };
    public static final Function ATAN = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.6
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.atan(d);
        }
    };
    public static final Function ATANH = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.7
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.atanh(d);
        }
    };
    public static final Function COS = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.8
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.cos(d);
        }
    };
    public static final Function COSH = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.9
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.cosh(d);
        }
    };
    public static final Function DEGREES = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.10
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.toDegrees(d);
        }
    };
    static final NumberEval DOLLAR_ARG2_DEFAULT = new NumberEval(2.0d);
    public static final Function DOLLAR = new Var1or2ArgFunction() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.11
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            return evaluate(i, i2, valueEval, NumericFunction.DOLLAR_ARG2_DEFAULT);
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
                if (((int) NumericFunction.singleOperandEvaluate(valueEval2, i, i2)) > 127) {
                    return ErrorEval.VALUE_INVALID;
                }
                return new NumberEval(dSingleOperandEvaluate);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function EXP = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.12
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.pow(2.718281828459045d, d);
        }
    };
    public static final Function FACT = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.13
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.factorial((int) d);
        }
    };
    public static final Function INT = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.14
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.round(d - 0.5d);
        }
    };
    public static final Function LN = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.15
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.log(d);
        }
    };
    public static final Function LOG10 = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.16
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.log(d) / NumericFunction.LOG_10_TO_BASE_e;
        }
    };
    public static final Function RADIANS = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.17
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.toRadians(d);
        }
    };
    public static final Function SIGN = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.18
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.sign(d);
        }
    };
    public static final Function SIN = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.19
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.sin(d);
        }
    };
    public static final Function SINH = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.20
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.sinh(d);
        }
    };
    public static final Function SQRT = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.21
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.sqrt(d);
        }
    };
    public static final Function TAN = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.22
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return Math.tan(d);
        }
    };
    public static final Function TANH = new OneArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.23
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
        protected double evaluate(double d) {
            return MathX.tanh(d);
        }
    };
    public static final Function ATAN2 = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.24
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) throws EvaluationException {
            if (d == 0.0d && d2 == 0.0d) {
                throw new EvaluationException(ErrorEval.DIV_ZERO);
            }
            return Math.atan2(d2, d);
        }
    };
    public static final Function CEILING = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.25
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) {
            return MathX.ceiling(d, d2);
        }
    };
    public static final Function COMBIN = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.26
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) throws EvaluationException {
            if (d > 2.147483647E9d || d2 > 2.147483647E9d) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
            return MathX.nChooseK((int) d, (int) d2);
        }
    };
    public static final Function FLOOR = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.27
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) throws EvaluationException {
            if (d2 != 0.0d) {
                return MathX.floor(d, d2);
            }
            if (d == 0.0d) {
                return 0.0d;
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function MOD = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.28
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) throws EvaluationException {
            if (d2 == 0.0d) {
                throw new EvaluationException(ErrorEval.DIV_ZERO);
            }
            return MathX.mod(d, d2);
        }
    };
    public static final Function POWER = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.29
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) {
            return Math.pow(d, d2);
        }
    };
    public static final Function ROUND = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.30
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) {
            return MathX.round(d, (int) d2);
        }
    };
    public static final Function ROUNDDOWN = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.31
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) {
            return MathX.roundDown(d, (int) d2);
        }
    };
    public static final Function ROUNDUP = new TwoArg() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.32
        @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoArg
        protected double evaluate(double d, double d2) {
            return MathX.roundUp(d, (int) d2);
        }
    };
    static final NumberEval TRUNC_ARG2_DEFAULT = new NumberEval(0.0d);
    public static final Function TRUNC = new Var1or2ArgFunction() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.33
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            return evaluate(i, i2, valueEval, NumericFunction.TRUNC_ARG2_DEFAULT);
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            double dFloor;
            try {
                double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
                double dPow = Math.pow(NumericFunction.TEN, NumericFunction.singleOperandEvaluate(valueEval2, i, i2));
                if (dSingleOperandEvaluate < 0.0d) {
                    dFloor = -Math.floor((-dSingleOperandEvaluate) * dPow);
                } else {
                    dFloor = Math.floor(dSingleOperandEvaluate * dPow);
                }
                double d = dFloor / dPow;
                NumericFunction.checkValue(d);
                return new NumberEval(d);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function LOG = new Log();
    static final NumberEval PI_EVAL = new NumberEval(3.141592653589793d);
    public static final Function PI = new Fixed0ArgFunction() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.34
        @Override // org.apache.poi.ss.formula.functions.Function0Arg
        public ValueEval evaluate(int i, int i2) {
            return NumericFunction.PI_EVAL;
        }
    };
    public static final Function RAND = new Fixed0ArgFunction() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.35
        @Override // org.apache.poi.ss.formula.functions.Function0Arg
        public ValueEval evaluate(int i, int i2) {
            return new NumberEval(Math.random());
        }
    };
    public static final Function POISSON = new Fixed3ArgFunction() { // from class: org.apache.poi.ss.formula.functions.NumericFunction.36
        private static final double DEFAULT_RETURN_RESULT = 1.0d;
        private final long[] FACTORIALS = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

        private boolean isDefaultResult(double d, double d2) {
            return d == 0.0d && d2 == 0.0d;
        }

        private boolean checkArgument(double d) throws EvaluationException {
            NumericFunction.checkValue(d);
            if (d >= 0.0d) {
                return true;
            }
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }

        private double probability(int i, double d) {
            return (Math.pow(d, i) * Math.exp(-d)) / factorial(i);
        }

        private double cumulativeProbability(int i, double d) {
            double dProbability = 0.0d;
            for (int i2 = 0; i2 <= i; i2++) {
                dProbability += probability(i2, d);
            }
            return dProbability;
        }

        public long factorial(int i) {
            if (i < 0 || i > 20) {
                throw new IllegalArgumentException("Valid argument should be in the range [0..20]");
            }
            return this.FACTORIALS[i];
        }

        @Override // org.apache.poi.ss.formula.functions.Function3Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
            double dProbability;
            boolean booleanValue = ((BoolEval) valueEval3).getBooleanValue();
            try {
                double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
                double dSingleOperandEvaluate2 = NumericFunction.singleOperandEvaluate(valueEval2, i, i2);
                if (isDefaultResult(dSingleOperandEvaluate, dSingleOperandEvaluate2)) {
                    return new NumberEval(DEFAULT_RETURN_RESULT);
                }
                checkArgument(dSingleOperandEvaluate);
                checkArgument(dSingleOperandEvaluate2);
                if (booleanValue) {
                    dProbability = cumulativeProbability((int) dSingleOperandEvaluate, dSingleOperandEvaluate2);
                } else {
                    dProbability = probability((int) dSingleOperandEvaluate, dSingleOperandEvaluate2);
                }
                NumericFunction.checkValue(dProbability);
                return new NumberEval(dProbability);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };

    protected abstract double eval(ValueEval[] valueEvalArr, int i, int i2) throws EvaluationException;

    protected static final double singleOperandEvaluate(ValueEval valueEval, int i, int i2) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("arg must not be null");
        }
        double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
        checkValue(dCoerceValueToDouble);
        return dCoerceValueToDouble;
    }

    public static final void checkValue(double d) throws EvaluationException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        try {
            double dEval = eval(valueEvalArr, i, i2);
            checkValue(dEval);
            return new NumberEval(dEval);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static abstract class OneArg extends Fixed1ArgFunction {
        protected abstract double evaluate(double d) throws EvaluationException;

        protected OneArg() {
        }

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            try {
                double dEvaluate = evaluate(NumericFunction.singleOperandEvaluate(valueEval, i, i2));
                NumericFunction.checkValue(dEvaluate);
                return new NumberEval(dEvaluate);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }

        protected final double eval(ValueEval[] valueEvalArr, int i, int i2) throws EvaluationException {
            if (valueEvalArr.length != 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return evaluate(NumericFunction.singleOperandEvaluate(valueEvalArr[0], i, i2));
        }
    }

    public static abstract class TwoArg extends Fixed2ArgFunction {
        protected abstract double evaluate(double d, double d2) throws EvaluationException;

        protected TwoArg() {
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                double dEvaluate = evaluate(NumericFunction.singleOperandEvaluate(valueEval, i, i2), NumericFunction.singleOperandEvaluate(valueEval2, i, i2));
                NumericFunction.checkValue(dEvaluate);
                return new NumberEval(dEvaluate);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    }

    private static final class Log extends Var1or2ArgFunction {
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            try {
                double dLog = Math.log(NumericFunction.singleOperandEvaluate(valueEval, i, i2)) / NumericFunction.LOG_10_TO_BASE_e;
                NumericFunction.checkValue(dLog);
                return new NumberEval(dLog);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
                double dSingleOperandEvaluate2 = NumericFunction.singleOperandEvaluate(valueEval2, i, i2);
                double dLog = Math.log(dSingleOperandEvaluate);
                if (Double.compare(dSingleOperandEvaluate2, 2.718281828459045d) != 0) {
                    dLog /= Math.log(dSingleOperandEvaluate2);
                }
                NumericFunction.checkValue(dLog);
                return new NumberEval(dLog);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    }
}

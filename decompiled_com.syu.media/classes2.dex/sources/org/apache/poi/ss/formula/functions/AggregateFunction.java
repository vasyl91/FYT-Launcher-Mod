package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AggregateFunction extends MultiOperandNumericFunction {
    public static final Function AVEDEV = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.2
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            return StatsLib.avedev(dArr);
        }
    };
    public static final Function AVERAGE = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.3
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length < 1) {
                throw new EvaluationException(ErrorEval.DIV_ZERO);
            }
            return MathX.average(dArr);
        }
    };
    public static final Function DEVSQ = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.4
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            return StatsLib.devsq(dArr);
        }
    };
    public static final Function LARGE = new LargeSmall(true);
    public static final Function MAX = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.5
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            if (dArr.length > 0) {
                return MathX.max(dArr);
            }
            return 0.0d;
        }
    };
    public static final Function MEDIAN = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.6
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            return StatsLib.median(dArr);
        }
    };
    public static final Function MIN = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.7
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            if (dArr.length > 0) {
                return MathX.min(dArr);
            }
            return 0.0d;
        }
    };
    public static final Function PERCENTILE = new Percentile();
    public static final Function PRODUCT = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.8
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            return MathX.product(dArr);
        }
    };
    public static final Function SMALL = new LargeSmall(false);
    public static final Function STDEV = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.9
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length < 1) {
                throw new EvaluationException(ErrorEval.DIV_ZERO);
            }
            return StatsLib.stdev(dArr);
        }
    };
    public static final Function SUM = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.10
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            return MathX.sum(dArr);
        }
    };
    public static final Function SUMSQ = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.11
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            return MathX.sumsq(dArr);
        }
    };
    public static final Function VAR = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.12
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length < 1) {
                throw new EvaluationException(ErrorEval.DIV_ZERO);
            }
            return StatsLib.var(dArr);
        }
    };
    public static final Function VARP = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.13
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length < 1) {
                throw new EvaluationException(ErrorEval.DIV_ZERO);
            }
            return StatsLib.varp(dArr);
        }
    };

    private static final class LargeSmall extends Fixed2ArgFunction {
        private final boolean _isLarge;

        protected LargeSmall(boolean z) {
            this._isLarge = z;
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval2, i, i2));
                if (dCoerceValueToDouble < 1.0d) {
                    return ErrorEval.NUM_ERROR;
                }
                int iCeil = (int) Math.ceil(dCoerceValueToDouble);
                try {
                    double[] dArrCollectValues = ValueCollector.collectValues(valueEval);
                    if (iCeil > dArrCollectValues.length) {
                        return ErrorEval.NUM_ERROR;
                    }
                    double dKthLargest = this._isLarge ? StatsLib.kthLargest(dArrCollectValues, iCeil) : StatsLib.kthSmallest(dArrCollectValues, iCeil);
                    NumericFunction.checkValue(dKthLargest);
                    return new NumberEval(dKthLargest);
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
    }

    private static final class Percentile extends Fixed2ArgFunction {
        protected Percentile() {
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            double dKthSmallest;
            try {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval2, i, i2));
                if (dCoerceValueToDouble < 0.0d || dCoerceValueToDouble > 1.0d) {
                    return ErrorEval.NUM_ERROR;
                }
                try {
                    double[] dArrCollectValues = ValueCollector.collectValues(valueEval);
                    int length = dArrCollectValues.length;
                    if (length != 0 && length <= 8191) {
                        double d = (((double) (length - 1)) * dCoerceValueToDouble) + 1.0d;
                        if (d == 1.0d) {
                            dKthSmallest = StatsLib.kthSmallest(dArrCollectValues, 1);
                        } else if (Double.compare(d, length) == 0) {
                            dKthSmallest = StatsLib.kthLargest(dArrCollectValues, 1);
                        } else {
                            int i3 = (int) d;
                            dKthSmallest = StatsLib.kthSmallest(dArrCollectValues, i3) + ((d - ((double) i3)) * (StatsLib.kthSmallest(dArrCollectValues, i3 + 1) - StatsLib.kthSmallest(dArrCollectValues, i3)));
                        }
                        NumericFunction.checkValue(dKthSmallest);
                        return new NumberEval(dKthSmallest);
                    }
                    return ErrorEval.NUM_ERROR;
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
    }

    static final class ValueCollector extends MultiOperandNumericFunction {
        private static final ValueCollector instance = new ValueCollector();

        public ValueCollector() {
            super(false, false);
        }

        public static double[] collectValues(ValueEval... valueEvalArr) throws EvaluationException {
            return instance.getNumberArray(valueEvalArr);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        protected double evaluate(double[] dArr) {
            throw new IllegalStateException("should not be called");
        }
    }

    protected AggregateFunction() {
        super(false, false);
    }

    static Function subtotalInstance(Function function) {
        return new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.1
            @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
            public boolean isSubtotalCounted() {
                return false;
            }

            @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
            protected double evaluate(double[] dArr) throws EvaluationException {
                return AggregateFunction.this.evaluate(dArr);
            }
        };
    }
}

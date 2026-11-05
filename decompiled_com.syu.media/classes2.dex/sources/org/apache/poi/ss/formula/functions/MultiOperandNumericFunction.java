package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class MultiOperandNumericFunction implements Function {
    private final boolean _isBlankCounted;
    private final boolean _isReferenceBoolCounted;
    static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    private static final int DEFAULT_MAX_NUM_OPERANDS = SpreadsheetVersion.EXCEL2007.getMaxFunctionArgs();

    protected abstract double evaluate(double[] dArr) throws EvaluationException;

    public boolean isSubtotalCounted() {
        return true;
    }

    protected MultiOperandNumericFunction(boolean z, boolean z2) {
        this._isReferenceBoolCounted = z;
        this._isBlankCounted = z2;
    }

    private static class DoubleList {
        private double[] _array = new double[8];
        private int _count = 0;

        public double[] toArray() {
            int i = this._count;
            if (i < 1) {
                return MultiOperandNumericFunction.EMPTY_DOUBLE_ARRAY;
            }
            double[] dArr = new double[i];
            System.arraycopy(this._array, 0, dArr, 0, i);
            return dArr;
        }

        private void ensureCapacity(int i) {
            double[] dArr = this._array;
            if (i > dArr.length) {
                double[] dArr2 = new double[(i * 3) / 2];
                System.arraycopy(dArr, 0, dArr2, 0, this._count);
                this._array = dArr2;
            }
        }

        public void add(double d) {
            ensureCapacity(this._count + 1);
            double[] dArr = this._array;
            int i = this._count;
            dArr[i] = d;
            this._count = i + 1;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        try {
            double dEvaluate = evaluate(getNumberArray(valueEvalArr));
            if (Double.isNaN(dEvaluate) || Double.isInfinite(dEvaluate)) {
                return ErrorEval.NUM_ERROR;
            }
            return new NumberEval(dEvaluate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    protected int getMaxNumOperands() {
        return DEFAULT_MAX_NUM_OPERANDS;
    }

    protected final double[] getNumberArray(ValueEval[] valueEvalArr) throws EvaluationException {
        if (valueEvalArr.length > getMaxNumOperands()) {
            throw EvaluationException.invalidValue();
        }
        DoubleList doubleList = new DoubleList();
        for (ValueEval valueEval : valueEvalArr) {
            collectValues(valueEval, doubleList);
        }
        return doubleList.toArray();
    }

    private void collectValues(ValueEval valueEval, DoubleList doubleList) throws EvaluationException {
        if (valueEval instanceof ThreeDEval) {
            ThreeDEval threeDEval = (ThreeDEval) valueEval;
            for (int firstSheetIndex = threeDEval.getFirstSheetIndex(); firstSheetIndex <= threeDEval.getLastSheetIndex(); firstSheetIndex++) {
                int width = threeDEval.getWidth();
                int height = threeDEval.getHeight();
                for (int i = 0; i < height; i++) {
                    for (int i2 = 0; i2 < width; i2++) {
                        ValueEval value = threeDEval.getValue(firstSheetIndex, i, i2);
                        if (isSubtotalCounted() || !threeDEval.isSubTotal(i, i2)) {
                            collectValue(value, true, doubleList);
                        }
                    }
                }
            }
            return;
        }
        if (valueEval instanceof TwoDEval) {
            TwoDEval twoDEval = (TwoDEval) valueEval;
            int width2 = twoDEval.getWidth();
            int height2 = twoDEval.getHeight();
            for (int i3 = 0; i3 < height2; i3++) {
                for (int i4 = 0; i4 < width2; i4++) {
                    ValueEval value2 = twoDEval.getValue(i3, i4);
                    if (isSubtotalCounted() || !twoDEval.isSubTotal(i3, i4)) {
                        collectValue(value2, true, doubleList);
                    }
                }
            }
            return;
        }
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            for (int firstSheetIndex2 = refEval.getFirstSheetIndex(); firstSheetIndex2 <= refEval.getLastSheetIndex(); firstSheetIndex2++) {
                collectValue(refEval.getInnerValueEval(firstSheetIndex2), true, doubleList);
            }
            return;
        }
        collectValue(valueEval, false, doubleList);
    }

    private void collectValue(ValueEval valueEval, boolean z, DoubleList doubleList) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("ve must not be null");
        }
        if (valueEval instanceof BoolEval) {
            if (!z || this._isReferenceBoolCounted) {
                doubleList.add(((BoolEval) valueEval).getNumberValue());
                return;
            }
            return;
        }
        if (valueEval instanceof NumericValueEval) {
            doubleList.add(((NumericValueEval) valueEval).getNumberValue());
            return;
        }
        if (valueEval instanceof StringValueEval) {
            if (z) {
                return;
            }
            Double d = OperandResolver.parseDouble(((StringValueEval) valueEval).getStringValue());
            if (d == null) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            doubleList.add(d.doubleValue());
            return;
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval == BlankEval.instance) {
            if (this._isBlankCounted) {
                doubleList.add(0.0d);
                return;
            }
            return;
        }
        throw new RuntimeException("Invalid ValueEval type passed for conversion: (" + valueEval.getClass() + ")");
    }
}

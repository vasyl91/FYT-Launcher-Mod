package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XYNumericFunction extends Fixed2ArgFunction {

    protected interface Accumulator {
        double accumulate(double d, double d2);
    }

    protected abstract Accumulator createAccumulator();

    private static abstract class ValueArray implements LookupUtils.ValueVector {
        private final int _size;

        protected abstract ValueEval getItemInternal(int i);

        protected ValueArray(int i) {
            this._size = i;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i) {
            if (i < 0 || i > this._size) {
                throw new IllegalArgumentException("Specified index " + i + " is outside range (0.." + (this._size - 1) + ")");
            }
            return getItemInternal(i);
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public final int getSize() {
            return this._size;
        }
    }

    private static final class SingleCellValueArray extends ValueArray {
        private final ValueEval _value;

        public SingleCellValueArray(ValueEval valueEval) {
            super(1);
            this._value = valueEval;
        }

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
        protected ValueEval getItemInternal(int i) {
            return this._value;
        }
    }

    private static final class RefValueArray extends ValueArray {
        private final RefEval _ref;
        private final int _width;

        public RefValueArray(RefEval refEval) {
            super(refEval.getNumberOfSheets());
            this._ref = refEval;
            this._width = refEval.getNumberOfSheets();
        }

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
        protected ValueEval getItemInternal(int i) {
            return this._ref.getInnerValueEval((i % this._width) + this._ref.getFirstSheetIndex());
        }
    }

    private static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval twoDEval) {
            super(twoDEval.getWidth() * twoDEval.getHeight());
            this._ae = twoDEval;
            this._width = twoDEval.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
        protected ValueEval getItemInternal(int i) {
            int i2 = this._width;
            return this._ae.getValue(i / i2, i % i2);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            LookupUtils.ValueVector valueVectorCreateValueVector = createValueVector(valueEval);
            LookupUtils.ValueVector valueVectorCreateValueVector2 = createValueVector(valueEval2);
            int size = valueVectorCreateValueVector.getSize();
            if (size != 0 && valueVectorCreateValueVector2.getSize() == size) {
                double dEvaluateInternal = evaluateInternal(valueVectorCreateValueVector, valueVectorCreateValueVector2, size);
                if (Double.isNaN(dEvaluateInternal) || Double.isInfinite(dEvaluateInternal)) {
                    return ErrorEval.NUM_ERROR;
                }
                return new NumberEval(dEvaluateInternal);
            }
            return ErrorEval.NA;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private double evaluateInternal(LookupUtils.ValueVector valueVector, LookupUtils.ValueVector valueVector2, int i) throws EvaluationException {
        Accumulator accumulatorCreateAccumulator = createAccumulator();
        ErrorEval errorEval = null;
        double dAccumulate = 0.0d;
        boolean z = false;
        ErrorEval errorEval2 = null;
        for (int i2 = 0; i2 < i; i2++) {
            ValueEval item = valueVector.getItem(i2);
            ValueEval item2 = valueVector2.getItem(i2);
            if ((item instanceof ErrorEval) && errorEval == null) {
                errorEval = (ErrorEval) item;
            } else if ((item2 instanceof ErrorEval) && errorEval2 == null) {
                errorEval2 = (ErrorEval) item2;
            } else if ((item instanceof NumberEval) && (item2 instanceof NumberEval)) {
                dAccumulate += accumulatorCreateAccumulator.accumulate(((NumberEval) item).getNumberValue(), ((NumberEval) item2).getNumberValue());
                z = true;
            }
        }
        if (errorEval != null) {
            throw new EvaluationException(errorEval);
        }
        if (errorEval2 != null) {
            throw new EvaluationException(errorEval2);
        }
        if (z) {
            return dAccumulate;
        }
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    }

    private static LookupUtils.ValueVector createValueVector(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval instanceof TwoDEval) {
            return new AreaValueArray((TwoDEval) valueEval);
        }
        if (valueEval instanceof RefEval) {
            return new RefValueArray((RefEval) valueEval);
        }
        return new SingleCellValueArray(valueEval);
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Sumproduct implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        ValueEval valueEval = valueEvalArr[0];
        try {
            if (valueEval instanceof NumericValueEval) {
                return evaluateSingleProduct(valueEvalArr);
            }
            if (valueEval instanceof RefEval) {
                return evaluateSingleProduct(valueEvalArr);
            }
            if (valueEval instanceof TwoDEval) {
                TwoDEval twoDEval = (TwoDEval) valueEval;
                if (twoDEval.isRow() && twoDEval.isColumn()) {
                    return evaluateSingleProduct(valueEvalArr);
                }
                return evaluateAreaSumProduct(valueEvalArr);
            }
            throw new RuntimeException("Invalid arg type for SUMPRODUCT: (" + valueEval.getClass().getName() + ")");
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static ValueEval evaluateSingleProduct(ValueEval[] valueEvalArr) throws EvaluationException {
        double scalarValue = 1.0d;
        for (ValueEval valueEval : valueEvalArr) {
            scalarValue *= getScalarValue(valueEval);
        }
        return new NumberEval(scalarValue);
    }

    private static double getScalarValue(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            if (refEval.getNumberOfSheets() > 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
        }
        if (valueEval == null) {
            throw new RuntimeException("parameter may not be null");
        }
        if (valueEval instanceof AreaEval) {
            AreaEval areaEval = (AreaEval) valueEval;
            if (!areaEval.isColumn() || !areaEval.isRow()) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            valueEval = areaEval.getRelativeValue(0, 0);
        }
        return getProductTerm(valueEval, true);
    }

    private static ValueEval evaluateAreaSumProduct(ValueEval[] valueEvalArr) throws EvaluationException {
        int length = valueEvalArr.length;
        TwoDEval[] twoDEvalArr = new TwoDEval[length];
        try {
            System.arraycopy(valueEvalArr, 0, twoDEvalArr, 0, length);
            TwoDEval twoDEval = twoDEvalArr[0];
            int height = twoDEval.getHeight();
            int width = twoDEval.getWidth();
            if (!areasAllSameSize(twoDEvalArr, height, width)) {
                for (int i = 1; i < length; i++) {
                    throwFirstError(twoDEvalArr[i]);
                }
                return ErrorEval.VALUE_INVALID;
            }
            double d = 0.0d;
            for (int i2 = 0; i2 < height; i2++) {
                for (int i3 = 0; i3 < width; i3++) {
                    double productTerm = 1.0d;
                    for (int i4 = 0; i4 < length; i4++) {
                        productTerm *= getProductTerm(twoDEvalArr[i4].getValue(i2, i3), false);
                    }
                    d += productTerm;
                }
            }
            return new NumberEval(d);
        } catch (ArrayStoreException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    private static void throwFirstError(TwoDEval twoDEval) throws EvaluationException {
        int height = twoDEval.getHeight();
        int width = twoDEval.getWidth();
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                ValueEval value = twoDEval.getValue(i, i2);
                if (value instanceof ErrorEval) {
                    throw new EvaluationException((ErrorEval) value);
                }
            }
        }
    }

    private static boolean areasAllSameSize(TwoDEval[] twoDEvalArr, int i, int i2) {
        for (TwoDEval twoDEval : twoDEvalArr) {
            if (twoDEval.getHeight() != i || twoDEval.getWidth() != i2) {
                return false;
            }
        }
        return true;
    }

    private static double getProductTerm(ValueEval valueEval, boolean z) throws EvaluationException {
        if ((valueEval instanceof BlankEval) || valueEval == null) {
            if (z) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return 0.0d;
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval instanceof StringEval) {
            if (z) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return 0.0d;
        }
        if (valueEval instanceof NumericValueEval) {
            return ((NumericValueEval) valueEval).getNumberValue();
        }
        throw new RuntimeException("Unexpected value eval class (" + valueEval.getClass().getName() + ")");
    }
}

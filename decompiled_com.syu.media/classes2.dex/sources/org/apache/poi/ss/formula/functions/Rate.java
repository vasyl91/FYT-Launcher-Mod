package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Rate implements Function {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) Rate.class);

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 3) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dCalculateRate = calculateRate(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i, i2)), OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], i, i2)), OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[2], i, i2)), valueEvalArr.length >= 4 ? OperandResolver.coerceValueToDouble(valueEvalArr.length >= 4 ? OperandResolver.getSingleValue(valueEvalArr[3], i, i2) : null) : 0.0d, valueEvalArr.length >= 5 ? OperandResolver.coerceValueToDouble(valueEvalArr.length >= 5 ? OperandResolver.getSingleValue(valueEvalArr[4], i, i2) : null) : 0.0d, valueEvalArr.length >= 6 ? OperandResolver.coerceValueToDouble(valueEvalArr.length >= 6 ? OperandResolver.getSingleValue(valueEvalArr[5], i, i2) : null) : 0.1d);
            checkValue(dCalculateRate);
            return new NumberEval(dCalculateRate);
        } catch (EvaluationException e) {
            LOG.log(7, "Can't evaluate rate function", e);
            return e.getErrorEval();
        }
    }

    private double calculateRate(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8 = 0.0d;
        double dExp = Math.abs(d6) < 1.0E-7d ? 0.0d : Math.exp(Math.log(d6 + 1.0d) * d);
        double d9 = (d3 * dExp) + (((1.0d / d6) + d5) * d2 * (dExp - 1.0d)) + d4;
        double d10 = d6;
        double d11 = d9;
        double d12 = d3 + (d2 * d) + d4;
        double d13 = 0.0d;
        while (Math.abs(d12 - d11) > 1.0E-7d && d8 < 20) {
            double d14 = ((d13 * d11) - (d12 * d10)) / (d11 - d12);
            if (Math.abs(d14) < 1.0E-7d) {
                d7 = (((d * d14) + 1.0d) * d3) + (((d14 * d5) + 1.0d) * d2 * d) + d4;
            } else {
                double dExp2 = Math.exp(Math.log(d14 + 1.0d) * d);
                d7 = (d3 * dExp2) + (((1.0d / d14) + d5) * d2 * (dExp2 - 1.0d)) + d4;
            }
            d8 += 1.0d;
            double d15 = d7;
            d12 = d11;
            d11 = d15;
            double d16 = d10;
            d10 = d14;
            d13 = d16;
        }
        return d10;
    }

    static final void checkValue(double d) throws EvaluationException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
    }
}

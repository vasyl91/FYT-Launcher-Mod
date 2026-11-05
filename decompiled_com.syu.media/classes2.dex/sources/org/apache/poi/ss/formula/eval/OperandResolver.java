package org.apache.poi.ss.formula.eval;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OperandResolver {
    private static final String Digits = "(\\p{Digit}+)";
    private static final String Exp = "[eE][+-]?(\\p{Digit}+)";
    private static final String fpRegex = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?))))[\\x00-\\x20]*";

    private OperandResolver() {
    }

    public static ValueEval getSingleValue(ValueEval valueEval, int i, int i2) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            valueEval = chooseSingleElementFromRef((RefEval) valueEval);
        } else if (valueEval instanceof AreaEval) {
            valueEval = chooseSingleElementFromArea((AreaEval) valueEval, i, i2);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        return valueEval;
    }

    public static ValueEval chooseSingleElementFromArea(AreaEval areaEval, int i, int i2) throws EvaluationException {
        ValueEval valueEvalChooseSingleElementFromAreaInternal = chooseSingleElementFromAreaInternal(areaEval, i, i2);
        if (valueEvalChooseSingleElementFromAreaInternal instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEvalChooseSingleElementFromAreaInternal);
        }
        return valueEvalChooseSingleElementFromAreaInternal;
    }

    private static ValueEval chooseSingleElementFromAreaInternal(AreaEval areaEval, int i, int i2) throws EvaluationException {
        if (areaEval.isColumn()) {
            if (areaEval.isRow()) {
                return areaEval.getRelativeValue(0, 0);
            }
            if (!areaEval.containsRow(i)) {
                throw EvaluationException.invalidValue();
            }
            return areaEval.getAbsoluteValue(i, areaEval.getFirstColumn());
        }
        if (!areaEval.isRow()) {
            if (areaEval.containsRow(i) && areaEval.containsColumn(i2)) {
                return areaEval.getAbsoluteValue(areaEval.getFirstRow(), areaEval.getFirstColumn());
            }
            throw EvaluationException.invalidValue();
        }
        if (!areaEval.containsColumn(i2)) {
            throw EvaluationException.invalidValue();
        }
        return areaEval.getAbsoluteValue(areaEval.getFirstRow(), i2);
    }

    private static ValueEval chooseSingleElementFromRef(RefEval refEval) {
        return refEval.getInnerValueEval(refEval.getFirstSheetIndex());
    }

    public static int coerceValueToInt(ValueEval valueEval) throws EvaluationException {
        if (valueEval == BlankEval.instance) {
            return 0;
        }
        return (int) Math.floor(coerceValueToDouble(valueEval));
    }

    public static double coerceValueToDouble(ValueEval valueEval) throws EvaluationException {
        if (valueEval == BlankEval.instance) {
            return 0.0d;
        }
        if (valueEval instanceof NumericValueEval) {
            return ((NumericValueEval) valueEval).getNumberValue();
        }
        if (valueEval instanceof StringEval) {
            Double d = parseDouble(((StringEval) valueEval).getStringValue());
            if (d == null) {
                throw EvaluationException.invalidValue();
            }
            return d.doubleValue();
        }
        throw new RuntimeException("Unexpected arg eval type (" + valueEval.getClass().getName() + ")");
    }

    public static Double parseDouble(String str) {
        if (Pattern.matches(fpRegex, str)) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String coerceValueToString(ValueEval valueEval) {
        if (valueEval instanceof StringValueEval) {
            return ((StringValueEval) valueEval).getStringValue();
        }
        if (valueEval == BlankEval.instance) {
            return "";
        }
        throw new IllegalArgumentException("Unexpected eval class (" + valueEval.getClass().getName() + ")");
    }

    public static Boolean coerceValueToBoolean(ValueEval valueEval, boolean z) throws EvaluationException {
        if (valueEval == null || valueEval == BlankEval.instance) {
            return null;
        }
        if (valueEval instanceof BoolEval) {
            return Boolean.valueOf(((BoolEval) valueEval).getBooleanValue());
        }
        if (valueEval == BlankEval.instance) {
            return null;
        }
        if (valueEval instanceof StringEval) {
            if (z) {
                return null;
            }
            String stringValue = ((StringEval) valueEval).getStringValue();
            if (stringValue.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (stringValue.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        if (valueEval instanceof NumericValueEval) {
            double numberValue = ((NumericValueEval) valueEval).getNumberValue();
            if (Double.isNaN(numberValue)) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return Boolean.valueOf(numberValue != 0.0d);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new RuntimeException("Unexpected eval (" + valueEval.getClass().getName() + ")");
    }
}

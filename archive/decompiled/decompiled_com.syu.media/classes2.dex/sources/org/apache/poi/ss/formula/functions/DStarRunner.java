package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberComparer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DStarRunner implements Function3Arg {
    private final DStarAlgorithmEnum algoType;

    public enum DStarAlgorithmEnum {
        DGET,
        DMIN
    }

    private enum operator {
        largerThan,
        largerEqualThan,
        smallerThan,
        smallerEqualThan,
        equal
    }

    public DStarRunner(DStarAlgorithmEnum dStarAlgorithmEnum) {
        this.algoType = dStarAlgorithmEnum;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length == 3) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        IDStarAlgorithm dGet;
        if (!(valueEval instanceof AreaEval) || !(valueEval3 instanceof AreaEval)) {
            return ErrorEval.VALUE_INVALID;
        }
        AreaEval areaEval = (AreaEval) valueEval;
        AreaEval areaEval2 = (AreaEval) valueEval3;
        try {
            try {
                int columnForName = getColumnForName(OperandResolver.getSingleValue(valueEval2, i, i2), areaEval);
                if (columnForName == -1) {
                    return ErrorEval.VALUE_INVALID;
                }
                int i3 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$DStarAlgorithmEnum[this.algoType.ordinal()];
                if (i3 == 1) {
                    dGet = new DGet();
                } else if (i3 == 2) {
                    dGet = new DMin();
                } else {
                    throw new IllegalStateException("Unexpected algorithm type " + this.algoType + " encountered.");
                }
                int height = areaEval.getHeight();
                for (int i4 = 1; i4 < height; i4++) {
                    try {
                        if (fullfillsConditions(areaEval, i4, areaEval2) && !dGet.processMatch(resolveReference(areaEval, i4, columnForName))) {
                            break;
                        }
                    } catch (EvaluationException unused) {
                        return ErrorEval.VALUE_INVALID;
                    }
                }
                return dGet.getResult();
            } catch (EvaluationException unused2) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static int getColumnForName(ValueEval valueEval, AreaEval areaEval) throws EvaluationException {
        return getColumnForString(areaEval, OperandResolver.coerceValueToString(valueEval));
    }

    private static int getColumnForString(AreaEval areaEval, String str) throws EvaluationException {
        int width = areaEval.getWidth();
        for (int i = 0; i < width; i++) {
            ValueEval valueEvalResolveReference = resolveReference(areaEval, 0, i);
            if (!(valueEvalResolveReference instanceof BlankEval) && !(valueEvalResolveReference instanceof ErrorEval) && str.equals(OperandResolver.coerceValueToString(valueEvalResolveReference))) {
                return i;
            }
        }
        return -1;
    }

    private static boolean fullfillsConditions(AreaEval areaEval, int i, AreaEval areaEval2) throws EvaluationException {
        int height = areaEval2.getHeight();
        int i2 = 1;
        while (true) {
            boolean z = false;
            if (i2 >= height) {
                return false;
            }
            int width = areaEval2.getWidth();
            int i3 = 0;
            while (true) {
                if (i3 >= width) {
                    z = true;
                    break;
                }
                ValueEval valueEvalResolveReference = resolveReference(areaEval2, i2, i3);
                if (!(valueEvalResolveReference instanceof BlankEval)) {
                    ValueEval valueEvalResolveReference2 = resolveReference(areaEval2, 0, i3);
                    if (!(valueEvalResolveReference2 instanceof StringValueEval)) {
                        throw new EvaluationException(ErrorEval.VALUE_INVALID);
                    }
                    if (getColumnForName(valueEvalResolveReference2, areaEval) != -1) {
                        if (!testNormalCondition(resolveReference(areaEval, i, getColumnForName(valueEvalResolveReference2, areaEval)), valueEvalResolveReference)) {
                            break;
                        }
                    } else {
                        if (OperandResolver.coerceValueToString(valueEvalResolveReference).isEmpty()) {
                            throw new EvaluationException(ErrorEval.VALUE_INVALID);
                        }
                        throw new NotImplementedException("D* function with formula conditions");
                    }
                }
                i3++;
            }
            if (z) {
                return true;
            }
            i2++;
        }
    }

    private static boolean testNormalCondition(ValueEval valueEval, ValueEval valueEval2) throws EvaluationException {
        boolean z = false;
        if (valueEval2 instanceof StringEval) {
            String stringValue = ((StringEval) valueEval2).getStringValue();
            if (stringValue.startsWith("<")) {
                String strSubstring = stringValue.substring(1);
                if (strSubstring.startsWith("=")) {
                    return testNumericCondition(valueEval, operator.smallerEqualThan, strSubstring.substring(1));
                }
                return testNumericCondition(valueEval, operator.smallerThan, strSubstring);
            }
            if (stringValue.startsWith(">")) {
                String strSubstring2 = stringValue.substring(1);
                if (strSubstring2.startsWith("=")) {
                    return testNumericCondition(valueEval, operator.largerEqualThan, strSubstring2.substring(1));
                }
                return testNumericCondition(valueEval, operator.largerThan, strSubstring2);
            }
            if (stringValue.startsWith("=")) {
                String strSubstring3 = stringValue.substring(1);
                if (strSubstring3.isEmpty()) {
                    return valueEval instanceof BlankEval;
                }
                try {
                    try {
                        Integer.parseInt(strSubstring3);
                    } catch (NumberFormatException unused) {
                    }
                } catch (NumberFormatException unused2) {
                    Double.parseDouble(strSubstring3);
                }
                z = true;
                if (z) {
                    return testNumericCondition(valueEval, operator.equal, strSubstring3);
                }
                return strSubstring3.equals(valueEval instanceof BlankEval ? "" : OperandResolver.coerceValueToString(valueEval));
            }
            if (stringValue.isEmpty()) {
                return valueEval instanceof StringEval;
            }
            return (valueEval instanceof BlankEval ? "" : OperandResolver.coerceValueToString(valueEval)).startsWith(stringValue);
        }
        if (!(valueEval2 instanceof NumericValueEval)) {
            return (valueEval2 instanceof ErrorEval) && (valueEval instanceof ErrorEval) && ((ErrorEval) valueEval2).getErrorCode() == ((ErrorEval) valueEval).getErrorCode();
        }
        double numberValue = ((NumericValueEval) valueEval2).getNumberValue();
        Double numberFromValueEval = getNumberFromValueEval(valueEval);
        return numberFromValueEval != null && numberValue == numberFromValueEval.doubleValue();
    }

    private static boolean testNumericCondition(ValueEval valueEval, operator operatorVar, String str) throws EvaluationException {
        double d;
        if (!(valueEval instanceof NumericValueEval)) {
            return false;
        }
        double numberValue = ((NumericValueEval) valueEval).getNumberValue();
        try {
            try {
                d = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
        } catch (NumberFormatException unused2) {
            d = Double.parseDouble(str);
        }
        int iCompare = NumberComparer.compare(numberValue, d);
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operatorVar.ordinal()];
        if (i == 1) {
            return iCompare > 0;
        }
        if (i == 2) {
            return iCompare >= 0;
        }
        if (i == 3) {
            return iCompare < 0;
        }
        if (i != 4) {
            return i == 5 && iCompare == 0;
        }
        return iCompare <= 0;
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.DStarRunner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$DStarAlgorithmEnum;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator;

        static {
            int[] iArr = new int[operator.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator = iArr;
            try {
                iArr[operator.largerThan.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.largerEqualThan.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerThan.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerEqualThan.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.equal.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[DStarAlgorithmEnum.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$DStarAlgorithmEnum = iArr2;
            try {
                iArr2[DStarAlgorithmEnum.DGET.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$DStarAlgorithmEnum[DStarAlgorithmEnum.DMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static Double getNumberFromValueEval(ValueEval valueEval) {
        if (valueEval instanceof NumericValueEval) {
            return Double.valueOf(((NumericValueEval) valueEval).getNumberValue());
        }
        if (valueEval instanceof StringValueEval) {
            try {
                return Double.valueOf(Double.parseDouble(((StringValueEval) valueEval).getStringValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static ValueEval resolveReference(AreaEval areaEval, int i, int i2) {
        try {
            return OperandResolver.getSingleValue(areaEval.getValue(i, i2), areaEval.getFirstRow() + i, areaEval.getFirstColumn() + i2);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.util.NumberComparer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class RelationalOperationEval extends Fixed2ArgFunction {
    public static final Function EqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.1
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        protected boolean convertComparisonResult(int i) {
            return i == 0;
        }
    };
    public static final Function GreaterEqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.2
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        protected boolean convertComparisonResult(int i) {
            return i >= 0;
        }
    };
    public static final Function GreaterThanEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.3
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        protected boolean convertComparisonResult(int i) {
            return i > 0;
        }
    };
    public static final Function LessEqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.4
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        protected boolean convertComparisonResult(int i) {
            return i <= 0;
        }
    };
    public static final Function LessThanEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.5
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        protected boolean convertComparisonResult(int i) {
            return i < 0;
        }
    };
    public static final Function NotEqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.6
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        protected boolean convertComparisonResult(int i) {
            return i != 0;
        }
    };

    protected abstract boolean convertComparisonResult(int i);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return BoolEval.valueOf(convertComparisonResult(doCompare(OperandResolver.getSingleValue(valueEval, i, i2), OperandResolver.getSingleValue(valueEval2, i, i2))));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static int doCompare(ValueEval valueEval, ValueEval valueEval2) {
        if (valueEval == BlankEval.instance) {
            return compareBlank(valueEval2);
        }
        if (valueEval2 == BlankEval.instance) {
            return -compareBlank(valueEval);
        }
        if (valueEval instanceof BoolEval) {
            if (!(valueEval2 instanceof BoolEval)) {
                return 1;
            }
            BoolEval boolEval = (BoolEval) valueEval;
            if (boolEval.getBooleanValue() == ((BoolEval) valueEval2).getBooleanValue()) {
                return 0;
            }
            return boolEval.getBooleanValue() ? 1 : -1;
        }
        if (valueEval2 instanceof BoolEval) {
            return -1;
        }
        if (valueEval instanceof StringEval) {
            if (valueEval2 instanceof StringEval) {
                return ((StringEval) valueEval).getStringValue().compareToIgnoreCase(((StringEval) valueEval2).getStringValue());
            }
            return 1;
        }
        if (valueEval2 instanceof StringEval) {
            return -1;
        }
        if ((valueEval instanceof NumberEval) && (valueEval2 instanceof NumberEval)) {
            return NumberComparer.compare(((NumberEval) valueEval).getNumberValue(), ((NumberEval) valueEval2).getNumberValue());
        }
        throw new IllegalArgumentException("Bad operand types (" + valueEval.getClass().getName() + "), (" + valueEval2.getClass().getName() + ")");
    }

    private static int compareBlank(ValueEval valueEval) {
        if (valueEval == BlankEval.instance) {
            return 0;
        }
        if (valueEval instanceof BoolEval) {
            return ((BoolEval) valueEval).getBooleanValue() ? -1 : 0;
        }
        if (valueEval instanceof NumberEval) {
            return NumberComparer.compare(0.0d, ((NumberEval) valueEval).getNumberValue());
        }
        if (valueEval instanceof StringEval) {
            return ((StringEval) valueEval).getStringValue().length() < 1 ? 0 : -1;
        }
        throw new IllegalArgumentException("bad value class (" + valueEval.getClass().getName() + ")");
    }
}

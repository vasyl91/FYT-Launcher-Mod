package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class LogicalFunction extends Fixed1ArgFunction {
    public static final Function ISLOGICAL = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.1
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof BoolEval;
        }
    };
    public static final Function ISNONTEXT = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.2
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return !(valueEval instanceof StringEval);
        }
    };
    public static final Function ISNUMBER = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.3
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof NumberEval;
        }
    };
    public static final Function ISTEXT = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.4
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof StringEval;
        }
    };
    public static final Function ISBLANK = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.5
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof BlankEval;
        }
    };
    public static final Function ISERROR = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.6
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof ErrorEval;
        }
    };
    public static final Function ISERR = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.7
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return (valueEval instanceof ErrorEval) && valueEval != ErrorEval.NA;
        }
    };
    public static final Function ISNA = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.8
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        protected boolean evaluate(ValueEval valueEval) {
            return valueEval == ErrorEval.NA;
        }
    };
    public static final Function ISREF = new Fixed1ArgFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.9
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            if ((valueEval instanceof RefEval) || (valueEval instanceof AreaEval) || (valueEval instanceof RefListEval)) {
                return BoolEval.TRUE;
            }
            return BoolEval.FALSE;
        }
    };

    protected abstract boolean evaluate(ValueEval valueEval);

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        ValueEval errorEval;
        try {
            errorEval = OperandResolver.getSingleValue(valueEval, i, i2);
        } catch (EvaluationException e) {
            errorEval = e.getErrorEval();
        }
        return BoolEval.valueOf(evaluate(errorEval));
    }
}

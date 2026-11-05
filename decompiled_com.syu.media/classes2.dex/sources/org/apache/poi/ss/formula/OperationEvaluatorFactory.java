package org.apache.poi.ss.formula;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.eval.ConcatEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.IntersectionEval;
import org.apache.poi.ss.formula.eval.PercentEval;
import org.apache.poi.ss.formula.eval.RangeEval;
import org.apache.poi.ss.formula.eval.RelationalOperationEval;
import org.apache.poi.ss.formula.eval.TwoOperandNumericOperation;
import org.apache.poi.ss.formula.eval.UnaryMinusEval;
import org.apache.poi.ss.formula.eval.UnaryPlusEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.Indirect;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class OperationEvaluatorFactory {
    private static final Map<OperationPtg, Function> _instancesByPtgClass = initialiseInstancesMap();

    private OperationEvaluatorFactory() {
    }

    private static Map<OperationPtg, Function> initialiseInstancesMap() {
        HashMap map = new HashMap(32);
        put(map, EqualPtg.instance, RelationalOperationEval.EqualEval);
        put(map, GreaterEqualPtg.instance, RelationalOperationEval.GreaterEqualEval);
        put(map, GreaterThanPtg.instance, RelationalOperationEval.GreaterThanEval);
        put(map, LessEqualPtg.instance, RelationalOperationEval.LessEqualEval);
        put(map, LessThanPtg.instance, RelationalOperationEval.LessThanEval);
        put(map, NotEqualPtg.instance, RelationalOperationEval.NotEqualEval);
        put(map, ConcatPtg.instance, ConcatEval.instance);
        put(map, AddPtg.instance, TwoOperandNumericOperation.AddEval);
        put(map, DividePtg.instance, TwoOperandNumericOperation.DivideEval);
        put(map, MultiplyPtg.instance, TwoOperandNumericOperation.MultiplyEval);
        put(map, PercentPtg.instance, PercentEval.instance);
        put(map, PowerPtg.instance, TwoOperandNumericOperation.PowerEval);
        put(map, SubtractPtg.instance, TwoOperandNumericOperation.SubtractEval);
        put(map, UnaryMinusPtg.instance, UnaryMinusEval.instance);
        put(map, UnaryPlusPtg.instance, UnaryPlusEval.instance);
        put(map, RangePtg.instance, RangeEval.instance);
        put(map, IntersectionPtg.instance, IntersectionEval.instance);
        return map;
    }

    private static void put(Map<OperationPtg, Function> map, OperationPtg operationPtg, Function function) {
        Constructor<?>[] declaredConstructors = operationPtg.getClass().getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPrivate(declaredConstructors[0].getModifiers())) {
            throw new RuntimeException("Failed to verify instance (" + operationPtg.getClass().getName() + ") is a singleton.");
        }
        map.put(operationPtg, function);
    }

    public static ValueEval evaluate(OperationPtg operationPtg, ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (operationPtg == null) {
            throw new IllegalArgumentException("ptg must not be null");
        }
        Function function = _instancesByPtgClass.get(operationPtg);
        if (function != null) {
            return function.evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), (short) operationEvaluationContext.getColumnIndex());
        }
        if (operationPtg instanceof AbstractFunctionPtg) {
            short functionIndex = ((AbstractFunctionPtg) operationPtg).getFunctionIndex();
            if (functionIndex == 148) {
                return Indirect.instance.evaluate(valueEvalArr, operationEvaluationContext);
            }
            if (functionIndex == 255) {
                return UserDefinedFunction.instance.evaluate(valueEvalArr, operationEvaluationContext);
            }
            return FunctionEval.getBasicFunction(functionIndex).evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), (short) operationEvaluationContext.getColumnIndex());
        }
        throw new RuntimeException("Unexpected operation ptg class (" + operationPtg.getClass().getName() + ")");
    }
}

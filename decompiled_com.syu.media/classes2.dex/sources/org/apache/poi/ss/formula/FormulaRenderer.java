package org.apache.poi.ss.formula;

import java.util.Stack;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FormulaRenderer {
    /* JADX WARN: Multi-variable type inference failed */
    public static String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook, Ptg[] ptgArr) {
        if (ptgArr == 0 || ptgArr.length == 0) {
            throw new IllegalArgumentException("ptgs must not be null");
        }
        Stack stack = new Stack();
        for (ArrayPtg arrayPtg : ptgArr) {
            if (!(arrayPtg instanceof MemAreaPtg) && !(arrayPtg instanceof MemFuncPtg) && !(arrayPtg instanceof MemErrPtg)) {
                if (arrayPtg instanceof ParenthesisPtg) {
                    stack.push("(" + ((String) stack.pop()) + ")");
                } else if (arrayPtg instanceof AttrPtg) {
                    AttrPtg attrPtg = (AttrPtg) arrayPtg;
                    if (!attrPtg.isOptimizedIf() && !attrPtg.isOptimizedChoose() && !attrPtg.isSkip() && !attrPtg.isSpace() && !attrPtg.isSemiVolatile()) {
                        if (attrPtg.isSum()) {
                            stack.push(attrPtg.toFormulaString(getOperands(stack, attrPtg.getNumberOfOperands())));
                        } else {
                            throw new RuntimeException("Unexpected tAttr: " + attrPtg);
                        }
                    }
                } else if (arrayPtg instanceof WorkbookDependentFormula) {
                    stack.push(((WorkbookDependentFormula) arrayPtg).toFormulaString(formulaRenderingWorkbook));
                } else if (!(arrayPtg instanceof OperationPtg)) {
                    stack.push(arrayPtg.toFormulaString());
                } else {
                    OperationPtg operationPtg = (OperationPtg) arrayPtg;
                    stack.push(operationPtg.toFormulaString(getOperands(stack, operationPtg.getNumberOfOperands())));
                }
            }
        }
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        String str = (String) stack.pop();
        if (stack.isEmpty()) {
            return str;
        }
        throw new IllegalStateException("too much stuff left on the stack");
    }

    private static String[] getOperands(Stack<String> stack, int i) {
        String[] strArr = new String[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Too few arguments supplied to operation. Expected (" + i + ") operands but got (" + ((i - i2) - 1) + ")");
            }
            strArr[i2] = stack.pop();
        }
        return strArr;
    }
}

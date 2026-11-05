package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Address implements Function {
    public static final int REF_ABSOLUTE = 1;
    public static final int REF_RELATIVE = 4;
    public static final int REF_ROW_ABSOLUTE_COLUMN_RELATIVE = 2;
    public static final int REF_ROW_RELATIVE_RELATIVE_ABSOLUTE = 3;

    /* JADX WARN: Code duplicated, block: B:35:0x006a A[Catch: EvaluationException -> 0x0083, TryCatch #0 {EvaluationException -> 0x0083, blocks: (B:8:0x000b, B:10:0x001d, B:12:0x0023, B:27:0x0046, B:29:0x004a, B:32:0x0055, B:33:0x005a, B:35:0x006a, B:36:0x0072, B:21:0x0037, B:22:0x003e), top: B:43:0x000b }] */
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        boolean z;
        String strCoerceValueToString;
        StringBuffer stringBuffer;
        ValueEval singleValue;
        if (valueEvalArr.length < 2 || valueEvalArr.length > 5) {
            return ErrorEval.VALUE_INVALID;
        }
        boolean z2 = false;
        try {
            int iSingleOperandEvaluate = (int) NumericFunction.singleOperandEvaluate(valueEvalArr[0], i, i2);
            int iSingleOperandEvaluate2 = (int) NumericFunction.singleOperandEvaluate(valueEvalArr[1], i, i2);
            int iSingleOperandEvaluate3 = (valueEvalArr.length <= 2 || valueEvalArr[2] == MissingArgEval.instance) ? 1 : (int) NumericFunction.singleOperandEvaluate(valueEvalArr[2], i, i2);
            if (iSingleOperandEvaluate3 != 1) {
                if (iSingleOperandEvaluate3 == 2) {
                    z = false;
                    z2 = true;
                } else if (iSingleOperandEvaluate3 == 3) {
                    z = true;
                } else if (iSingleOperandEvaluate3 != 4) {
                    throw new EvaluationException(ErrorEval.VALUE_INVALID);
                }
                strCoerceValueToString = null;
                if (valueEvalArr.length == 5 && (singleValue = OperandResolver.getSingleValue(valueEvalArr[4], i, i2)) != MissingArgEval.instance) {
                    strCoerceValueToString = OperandResolver.coerceValueToString(singleValue);
                }
                CellReference cellReference = new CellReference(iSingleOperandEvaluate - 1, iSingleOperandEvaluate2 - 1, z2, z);
                stringBuffer = new StringBuffer(32);
                if (strCoerceValueToString != null) {
                    SheetNameFormatter.appendFormat(stringBuffer, strCoerceValueToString);
                    stringBuffer.append('!');
                }
                stringBuffer.append(cellReference.formatAsString());
                return new StringEval(stringBuffer.toString());
            }
            z2 = true;
            z = z2;
            strCoerceValueToString = null;
            if (valueEvalArr.length == 5) {
                strCoerceValueToString = OperandResolver.coerceValueToString(singleValue);
            }
            CellReference cellReference2 = new CellReference(iSingleOperandEvaluate - 1, iSingleOperandEvaluate2 - 1, z2, z);
            stringBuffer = new StringBuffer(32);
            if (strCoerceValueToString != null) {
                SheetNameFormatter.appendFormat(stringBuffer, strCoerceValueToString);
                stringBuffer.append('!');
            }
            stringBuffer.append(cellReference2.formatAsString());
            return new StringEval(stringBuffer.toString());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Table;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Indirect implements FreeRefFunction {
    public static final FreeRefFunction instance = new Indirect();

    private Indirect() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        boolean zEvaluateBooleanArg = true;
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            int length = valueEvalArr.length;
            if (length != 1) {
                if (length == 2) {
                    zEvaluateBooleanArg = evaluateBooleanArg(valueEvalArr[1], operationEvaluationContext);
                } else {
                    return ErrorEval.VALUE_INVALID;
                }
            }
            return evaluateIndirect(operationEvaluationContext, strCoerceValueToString, zEvaluateBooleanArg);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static boolean evaluateBooleanArg(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        if (singleValue == BlankEval.instance || singleValue == MissingArgEval.instance) {
            return false;
        }
        return OperandResolver.coerceValueToBoolean(singleValue, false).booleanValue();
    }

    private static ValueEval evaluateIndirect(OperationEvaluationContext operationEvaluationContext, String str, boolean z) {
        String str2;
        String str3;
        String strTrim;
        String strTrim2;
        int iLastIndexOf = str.lastIndexOf(33);
        if (iLastIndexOf < 0) {
            str2 = null;
            str3 = null;
        } else {
            String[] workbookAndSheetName = parseWorkbookAndSheetName(str.subSequence(0, iLastIndexOf));
            if (workbookAndSheetName == null) {
                return ErrorEval.REF_INVALID;
            }
            str2 = workbookAndSheetName[0];
            String str4 = workbookAndSheetName[1];
            str = str.substring(iLastIndexOf + 1);
            str3 = str4;
        }
        if (Table.isStructuredReference.matcher(str).matches()) {
            try {
                return operationEvaluationContext.getArea3DEval(FormulaParser.parseStructuredReference(str, (FormulaParsingWorkbook) operationEvaluationContext.getWorkbook(), operationEvaluationContext.getRowIndex()));
            } catch (FormulaParseException unused) {
                return ErrorEval.REF_INVALID;
            }
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf < 0) {
            strTrim2 = str.trim();
            strTrim = null;
        } else {
            String strTrim3 = str.substring(0, iIndexOf).trim();
            strTrim = str.substring(iIndexOf + 1).trim();
            strTrim2 = strTrim3;
        }
        return operationEvaluationContext.getDynamicReference(str2, str3, strTrim2, strTrim, z);
    }

    private static String[] parseWorkbookAndSheetName(CharSequence charSequence) {
        int i;
        String strUnescapeString;
        int length = charSequence.length() - 1;
        if (length < 0 || canTrim(charSequence)) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        if (Character.isWhitespace(cCharAt)) {
            return null;
        }
        if (cCharAt != '\'') {
            if (cCharAt != '[') {
                return new String[]{null, charSequence.toString()};
            }
            int iLastIndexOf = charSequence.toString().lastIndexOf(93);
            if (iLastIndexOf < 0) {
                return null;
            }
            CharSequence charSequenceSubSequence = charSequence.subSequence(1, iLastIndexOf);
            if (canTrim(charSequenceSubSequence)) {
                return null;
            }
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(iLastIndexOf + 1, charSequence.length());
            if (canTrim(charSequenceSubSequence2)) {
                return null;
            }
            return new String[]{charSequenceSubSequence.toString(), charSequenceSubSequence2.toString()};
        }
        if (charSequence.charAt(length) != '\'') {
            return null;
        }
        char cCharAt2 = charSequence.charAt(1);
        if (Character.isWhitespace(cCharAt2)) {
            return null;
        }
        if (cCharAt2 == '[') {
            int iLastIndexOf2 = charSequence.toString().lastIndexOf(93);
            if (iLastIndexOf2 < 0 || (strUnescapeString = unescapeString(charSequence.subSequence(2, iLastIndexOf2))) == null || canTrim(strUnescapeString)) {
                return null;
            }
            i = iLastIndexOf2 + 1;
        } else {
            i = 1;
            strUnescapeString = null;
        }
        String strUnescapeString2 = unescapeString(charSequence.subSequence(i, length));
        if (strUnescapeString2 == null) {
            return null;
        }
        return new String[]{strUnescapeString, strUnescapeString2};
    }

    private static String unescapeString(CharSequence charSequence) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt2 = charSequence.charAt(i);
            if (cCharAt2 == '\'') {
                i++;
                if (i >= length || (cCharAt = charSequence.charAt(i)) != '\'') {
                    return null;
                }
                cCharAt2 = cCharAt;
            }
            sb.append(cCharAt2);
            i++;
        }
        return sb.toString();
    }

    private static boolean canTrim(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        if (length < 0) {
            return false;
        }
        return Character.isWhitespace(charSequence.charAt(0)) || Character.isWhitespace(charSequence.charAt(length));
    }
}

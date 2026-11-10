package org.apache.poi.ss.formula.functions;

import module.canbus.FinalCanbus;
import module.customer.FinalCustomer;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Roman extends Fixed2ArgFunction {
    public static final int[] VALUES = {1000, 900, 500, FinalCanbus.CAR_FYTA_JILI_XiongMiao, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
            if (iCoerceValueToInt < 0) {
                return ErrorEval.VALUE_INVALID;
            }
            if (iCoerceValueToInt > 3999) {
                return ErrorEval.VALUE_INVALID;
            }
            if (iCoerceValueToInt == 0) {
                return new StringEval("");
            }
            try {
                int iCoerceValueToInt2 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i, i2));
                if (iCoerceValueToInt2 > 4 || iCoerceValueToInt2 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                String strIntegerToRoman = integerToRoman(iCoerceValueToInt);
                if (iCoerceValueToInt2 == 0) {
                    return new StringEval(strIntegerToRoman);
                }
                return new StringEval(makeConcise(strIntegerToRoman, iCoerceValueToInt2));
            } catch (EvaluationException unused) {
                return ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    private String integerToRoman(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 13; i2++) {
            while (true) {
                int i3 = VALUES[i2];
                if (i >= i3) {
                    i -= i3;
                    sb.append(ROMAN[i2]);
                }
            }
        }
        return sb.toString();
    }

    public String makeConcise(String str, int i) {
        if (i > 0) {
            str = str.replaceAll("XLV", "VL").replaceAll("XCV", "VC").replaceAll("CDL", "LD").replaceAll(FinalCustomer.VCustCheMeiLi, FinalCustomer.VCustLongMa).replaceAll("CMVC", "LMVL");
        }
        if (i == 1) {
            str = str.replaceAll("CDXC", "LDXL").replaceAll("CDVC", "LDVL").replaceAll("CMXC", "LMXL").replaceAll("XCIX", "VCIV").replaceAll("XLIX", "VLIV");
        }
        if (i > 1) {
            str = str.replaceAll("XLIX", "IL").replaceAll("XCIX", "IC").replaceAll("CDXC", "XD").replaceAll("CDVC", "XDV").replaceAll("CDIC", "XDIX").replaceAll("LMVL", "XMV").replaceAll("CMIC", "XMIX").replaceAll("CMXC", "XM");
        }
        if (i > 2) {
            str = str.replaceAll("XDV", "VD").replaceAll("XDIX", "VDIV").replaceAll("XMV", "VM").replaceAll("XMIX", "VMIV");
        }
        return i == 4 ? str.replaceAll("VDIV", "ID").replaceAll("VMIV", "IM") : str;
    }
}

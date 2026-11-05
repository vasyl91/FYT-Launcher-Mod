package org.apache.poi.ss.formula.atp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.functions.Bin2Dec;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.formula.functions.Countifs;
import org.apache.poi.ss.formula.functions.Dec2Bin;
import org.apache.poi.ss.formula.functions.Dec2Hex;
import org.apache.poi.ss.formula.functions.Delta;
import org.apache.poi.ss.formula.functions.EDate;
import org.apache.poi.ss.formula.functions.EOMonth;
import org.apache.poi.ss.formula.functions.FactDouble;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Hex2Dec;
import org.apache.poi.ss.formula.functions.ImReal;
import org.apache.poi.ss.formula.functions.Imaginary;
import org.apache.poi.ss.formula.functions.Oct2Dec;
import org.apache.poi.ss.formula.functions.Quotient;
import org.apache.poi.ss.formula.functions.Sumifs;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.apache.poi.ss.formula.udf.UDFFinder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AnalysisToolPak implements UDFFinder {
    public static final UDFFinder instance = new AnalysisToolPak();
    private final Map<String, FreeRefFunction> _functionsByName = createFunctionsMap();

    private static final class NotImplemented implements FreeRefFunction {
        private final String _functionName;

        public NotImplemented(String str) {
            this._functionName = str;
        }

        @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
        public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
            throw new NotImplementedFunctionException(this._functionName);
        }
    }

    private AnalysisToolPak() {
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        if (str.startsWith("_xlfn.")) {
            str = str.substring(6);
        }
        return this._functionsByName.get(str.toUpperCase(Locale.ROOT));
    }

    private Map<String, FreeRefFunction> createFunctionsMap() {
        HashMap map = new HashMap(108);
        r(map, "ACCRINT", null);
        r(map, "ACCRINTM", null);
        r(map, "AMORDEGRC", null);
        r(map, "AMORLINC", null);
        r(map, "AVERAGEIF", null);
        r(map, "AVERAGEIFS", null);
        r(map, "BAHTTEXT", null);
        r(map, "BESSELI", null);
        r(map, "BESSELJ", null);
        r(map, "BESSELK", null);
        r(map, "BESSELY", null);
        r(map, "BIN2DEC", Bin2Dec.instance);
        r(map, "BIN2HEX", null);
        r(map, "BIN2OCT", null);
        r(map, "COMPLEX", Complex.instance);
        r(map, "CONVERT", null);
        r(map, "COUNTIFS", Countifs.instance);
        r(map, "COUPDAYBS", null);
        r(map, "COUPDAYS", null);
        r(map, "COUPDAYSNC", null);
        r(map, "COUPNCD", null);
        r(map, "COUPNUM", null);
        r(map, "COUPPCD", null);
        r(map, "CUBEKPIMEMBER", null);
        r(map, "CUBEMEMBER", null);
        r(map, "CUBEMEMBERPROPERTY", null);
        r(map, "CUBERANKEDMEMBER", null);
        r(map, "CUBESET", null);
        r(map, "CUBESETCOUNT", null);
        r(map, "CUBEVALUE", null);
        r(map, "CUMIPMT", null);
        r(map, "CUMPRINC", null);
        r(map, "DEC2BIN", Dec2Bin.instance);
        r(map, "DEC2HEX", Dec2Hex.instance);
        r(map, "DEC2OCT", null);
        r(map, "DELTA", Delta.instance);
        r(map, "DISC", null);
        r(map, "DOLLARDE", null);
        r(map, "DOLLARFR", null);
        r(map, "DURATION", null);
        r(map, "EDATE", EDate.instance);
        r(map, "EFFECT", null);
        r(map, "EOMONTH", EOMonth.instance);
        r(map, "ERF", null);
        r(map, "ERFC", null);
        r(map, "FACTDOUBLE", FactDouble.instance);
        r(map, "FVSCHEDULE", null);
        r(map, "GCD", null);
        r(map, "GESTEP", null);
        r(map, "HEX2BIN", null);
        r(map, "HEX2DEC", Hex2Dec.instance);
        r(map, "HEX2OCT", null);
        r(map, "IFERROR", IfError.instance);
        r(map, "IMABS", null);
        r(map, "IMAGINARY", Imaginary.instance);
        r(map, "IMARGUMENT", null);
        r(map, "IMCONJUGATE", null);
        r(map, "IMCOS", null);
        r(map, "IMDIV", null);
        r(map, "IMEXP", null);
        r(map, "IMLN", null);
        r(map, "IMLOG10", null);
        r(map, "IMLOG2", null);
        r(map, "IMPOWER", null);
        r(map, "IMPRODUCT", null);
        r(map, "IMREAL", ImReal.instance);
        r(map, "IMSIN", null);
        r(map, "IMSQRT", null);
        r(map, "IMSUB", null);
        r(map, "IMSUM", null);
        r(map, "INTRATE", null);
        r(map, "ISEVEN", ParityFunction.IS_EVEN);
        r(map, "ISODD", ParityFunction.IS_ODD);
        r(map, "JIS", null);
        r(map, "LCM", null);
        r(map, "MDURATION", null);
        r(map, "MROUND", MRound.instance);
        r(map, "MULTINOMIAL", null);
        r(map, "NETWORKDAYS", NetworkdaysFunction.instance);
        r(map, "NOMINAL", null);
        r(map, "OCT2BIN", null);
        r(map, "OCT2DEC", Oct2Dec.instance);
        r(map, "OCT2HEX", null);
        r(map, "ODDFPRICE", null);
        r(map, "ODDFYIELD", null);
        r(map, "ODDLPRICE", null);
        r(map, "ODDLYIELD", null);
        r(map, "PRICE", null);
        r(map, "PRICEDISC", null);
        r(map, "PRICEMAT", null);
        r(map, "QUOTIENT", Quotient.instance);
        r(map, "RANDBETWEEN", RandBetween.instance);
        r(map, "RECEIVED", null);
        r(map, "RTD", null);
        r(map, "SERIESSUM", null);
        r(map, "SQRTPI", null);
        r(map, "SUMIFS", Sumifs.instance);
        r(map, "TBILLEQ", null);
        r(map, "TBILLPRICE", null);
        r(map, "TBILLYIELD", null);
        r(map, "WEEKNUM", WeekNum.instance);
        r(map, "WORKDAY", WorkdayFunction.instance);
        r(map, "XIRR", null);
        r(map, "XNPV", null);
        r(map, "YEARFRAC", YearFrac.instance);
        r(map, "YIELD", null);
        r(map, "YIELDDISC", null);
        r(map, "YIELDMAT", null);
        return map;
    }

    private static void r(Map<String, FreeRefFunction> map, String str, FreeRefFunction freeRefFunction) {
        if (freeRefFunction == null) {
            freeRefFunction = new NotImplemented(str);
        }
        map.put(str, freeRefFunction);
    }

    public static boolean isATPFunction(String str) {
        return ((AnalysisToolPak) instance)._functionsByName.containsKey(str);
    }

    public static Collection<String> getSupportedFunctionNames() {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        TreeSet treeSet = new TreeSet();
        for (Map.Entry<String, FreeRefFunction> entry : analysisToolPak._functionsByName.entrySet()) {
            FreeRefFunction value = entry.getValue();
            if (value != null && !(value instanceof NotImplemented)) {
                treeSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableCollection(treeSet);
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        TreeSet treeSet = new TreeSet();
        for (Map.Entry<String, FreeRefFunction> entry : analysisToolPak._functionsByName.entrySet()) {
            if (entry.getValue() instanceof NotImplemented) {
                treeSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableCollection(treeSet);
    }

    public static void registerFunction(String str, FreeRefFunction freeRefFunction) {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        if (!isATPFunction(str)) {
            if (FunctionMetadataRegistry.getFunctionByName(str) != null) {
                throw new IllegalArgumentException(str + " is a built-in Excel function. Use FunctoinEval.registerFunction(String name, Function func) instead.");
            }
            throw new IllegalArgumentException(str + " is not a function from the Excel Analysis Toolpack.");
        }
        FreeRefFunction freeRefFunctionFindFunction = analysisToolPak.findFunction(str);
        if (freeRefFunctionFindFunction != null && !(freeRefFunctionFindFunction instanceof NotImplemented)) {
            throw new IllegalArgumentException("POI already implememts " + str + ". You cannot override POI's implementations of Excel functions");
        }
        analysisToolPak._functionsByName.put(str, freeRefFunction);
    }
}

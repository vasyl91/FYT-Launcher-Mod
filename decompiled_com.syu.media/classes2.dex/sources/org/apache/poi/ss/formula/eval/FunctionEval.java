package org.apache.poi.ss.formula.eval;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;
import module.canbus.FinalCanbus;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.functions.Address;
import org.apache.poi.ss.formula.functions.AggregateFunction;
import org.apache.poi.ss.formula.functions.BooleanFunction;
import org.apache.poi.ss.formula.functions.CalendarFieldFunction;
import org.apache.poi.ss.formula.functions.Choose;
import org.apache.poi.ss.formula.functions.Code;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.poi.ss.formula.functions.Counta;
import org.apache.poi.ss.formula.functions.Countblank;
import org.apache.poi.ss.formula.functions.Countif;
import org.apache.poi.ss.formula.functions.DStarRunner;
import org.apache.poi.ss.formula.functions.DateFunc;
import org.apache.poi.ss.formula.functions.Days360;
import org.apache.poi.ss.formula.functions.Errortype;
import org.apache.poi.ss.formula.functions.Even;
import org.apache.poi.ss.formula.functions.FinanceFunction;
import org.apache.poi.ss.formula.functions.Fixed;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.Hlookup;
import org.apache.poi.ss.formula.functions.Hyperlink;
import org.apache.poi.ss.formula.functions.IPMT;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.formula.functions.Intercept;
import org.apache.poi.ss.formula.functions.Irr;
import org.apache.poi.ss.formula.functions.LogicalFunction;
import org.apache.poi.ss.formula.functions.Lookup;
import org.apache.poi.ss.formula.functions.Match;
import org.apache.poi.ss.formula.functions.MinaMaxa;
import org.apache.poi.ss.formula.functions.Mirr;
import org.apache.poi.ss.formula.functions.Mode;
import org.apache.poi.ss.formula.functions.Na;
import org.apache.poi.ss.formula.functions.NotImplementedFunction;
import org.apache.poi.ss.formula.functions.Now;
import org.apache.poi.ss.formula.functions.Npv;
import org.apache.poi.ss.formula.functions.NumericFunction;
import org.apache.poi.ss.formula.functions.Odd;
import org.apache.poi.ss.formula.functions.Offset;
import org.apache.poi.ss.formula.functions.PPMT;
import org.apache.poi.ss.formula.functions.Rank;
import org.apache.poi.ss.formula.functions.Rate;
import org.apache.poi.ss.formula.functions.Replace;
import org.apache.poi.ss.formula.functions.Rept;
import org.apache.poi.ss.formula.functions.Roman;
import org.apache.poi.ss.formula.functions.RowFunc;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.formula.functions.Slope;
import org.apache.poi.ss.formula.functions.Substitute;
import org.apache.poi.ss.formula.functions.Subtotal;
import org.apache.poi.ss.formula.functions.Sumif;
import org.apache.poi.ss.formula.functions.Sumproduct;
import org.apache.poi.ss.formula.functions.Sumx2my2;
import org.apache.poi.ss.formula.functions.Sumx2py2;
import org.apache.poi.ss.formula.functions.Sumxmy2;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.formula.functions.TextFunction;
import org.apache.poi.ss.formula.functions.TimeFunc;
import org.apache.poi.ss.formula.functions.Today;
import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.formula.functions.Vlookup;
import org.apache.poi.ss.formula.functions.WeekdayFunc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FunctionEval {
    protected static final Function[] functions = produceFunctions();

    private FunctionEval() {
    }

    private static final class FunctionID {
        public static final int CHOOSE = 100;
        public static final int EXTERNAL_FUNC = 255;
        public static final int IF = 1;
        public static final int INDIRECT = 148;
        public static final int OFFSET = 78;
        public static final int SUM = 4;

        private FunctionID() {
        }
    }

    private static Function[] produceFunctions() {
        FunctionMetadata functionByIndex;
        Function[] functionArr = new Function[FinalCanbus.CAR_WC1_ZYC_HAFO_H6];
        functionArr[0] = new Count();
        functionArr[1] = new IfFunc();
        functionArr[2] = LogicalFunction.ISNA;
        functionArr[3] = LogicalFunction.ISERROR;
        functionArr[4] = AggregateFunction.SUM;
        functionArr[5] = AggregateFunction.AVERAGE;
        functionArr[6] = AggregateFunction.MIN;
        functionArr[7] = AggregateFunction.MAX;
        functionArr[8] = new RowFunc();
        functionArr[9] = new Column();
        functionArr[10] = new Na();
        functionArr[11] = new Npv();
        functionArr[12] = AggregateFunction.STDEV;
        functionArr[13] = NumericFunction.DOLLAR;
        functionArr[14] = new Fixed();
        functionArr[15] = NumericFunction.SIN;
        functionArr[16] = NumericFunction.COS;
        functionArr[17] = NumericFunction.TAN;
        functionArr[18] = NumericFunction.ATAN;
        functionArr[19] = NumericFunction.PI;
        functionArr[20] = NumericFunction.SQRT;
        functionArr[21] = NumericFunction.EXP;
        functionArr[22] = NumericFunction.LN;
        functionArr[23] = NumericFunction.LOG10;
        functionArr[24] = NumericFunction.ABS;
        functionArr[25] = NumericFunction.INT;
        functionArr[26] = NumericFunction.SIGN;
        functionArr[27] = NumericFunction.ROUND;
        functionArr[28] = new Lookup();
        functionArr[29] = new Index();
        functionArr[30] = new Rept();
        functionArr[31] = TextFunction.MID;
        functionArr[32] = TextFunction.LEN;
        functionArr[33] = new Value();
        functionArr[34] = BooleanFunction.TRUE;
        functionArr[35] = BooleanFunction.FALSE;
        functionArr[36] = BooleanFunction.AND;
        functionArr[37] = BooleanFunction.OR;
        functionArr[38] = BooleanFunction.NOT;
        functionArr[39] = NumericFunction.MOD;
        functionArr[43] = new DStarRunner(DStarRunner.DStarAlgorithmEnum.DMIN);
        functionArr[46] = AggregateFunction.VAR;
        functionArr[48] = TextFunction.TEXT;
        functionArr[56] = FinanceFunction.PV;
        functionArr[57] = FinanceFunction.FV;
        functionArr[58] = FinanceFunction.NPER;
        functionArr[59] = FinanceFunction.PMT;
        functionArr[60] = new Rate();
        functionArr[61] = new Mirr();
        functionArr[62] = new Irr();
        functionArr[63] = NumericFunction.RAND;
        functionArr[64] = new Match();
        functionArr[65] = DateFunc.instance;
        functionArr[66] = new TimeFunc();
        functionArr[67] = CalendarFieldFunction.DAY;
        functionArr[68] = CalendarFieldFunction.MONTH;
        functionArr[69] = CalendarFieldFunction.YEAR;
        functionArr[70] = WeekdayFunc.instance;
        functionArr[71] = CalendarFieldFunction.HOUR;
        functionArr[72] = CalendarFieldFunction.MINUTE;
        functionArr[73] = CalendarFieldFunction.SECOND;
        functionArr[74] = new Now();
        functionArr[76] = new Rows();
        functionArr[77] = new Columns();
        functionArr[78] = new Offset();
        functionArr[82] = TextFunction.SEARCH;
        functionArr[97] = NumericFunction.ATAN2;
        functionArr[98] = NumericFunction.ASIN;
        functionArr[99] = NumericFunction.ACOS;
        functionArr[100] = new Choose();
        functionArr[101] = new Hlookup();
        functionArr[102] = new Vlookup();
        functionArr[105] = LogicalFunction.ISREF;
        functionArr[109] = NumericFunction.LOG;
        functionArr[111] = TextFunction.CHAR;
        functionArr[112] = TextFunction.LOWER;
        functionArr[113] = TextFunction.UPPER;
        functionArr[114] = TextFunction.PROPER;
        functionArr[115] = TextFunction.LEFT;
        functionArr[116] = TextFunction.RIGHT;
        functionArr[117] = TextFunction.EXACT;
        functionArr[118] = TextFunction.TRIM;
        functionArr[119] = new Replace();
        functionArr[120] = new Substitute();
        functionArr[121] = new Code();
        functionArr[124] = TextFunction.FIND;
        functionArr[126] = LogicalFunction.ISERR;
        functionArr[127] = LogicalFunction.ISTEXT;
        functionArr[128] = LogicalFunction.ISNUMBER;
        functionArr[129] = LogicalFunction.ISBLANK;
        functionArr[130] = new T();
        functionArr[148] = null;
        functionArr[162] = TextFunction.CLEAN;
        functionArr[167] = new IPMT();
        functionArr[168] = new PPMT();
        functionArr[169] = new Counta();
        functionArr[183] = AggregateFunction.PRODUCT;
        functionArr[184] = NumericFunction.FACT;
        functionArr[190] = LogicalFunction.ISNONTEXT;
        functionArr[194] = AggregateFunction.VARP;
        functionArr[197] = NumericFunction.TRUNC;
        functionArr[198] = LogicalFunction.ISLOGICAL;
        functionArr[212] = NumericFunction.ROUNDUP;
        functionArr[213] = NumericFunction.ROUNDDOWN;
        functionArr[216] = new Rank();
        functionArr[219] = new Address();
        functionArr[220] = new Days360();
        functionArr[221] = new Today();
        functionArr[227] = AggregateFunction.MEDIAN;
        functionArr[228] = new Sumproduct();
        functionArr[229] = NumericFunction.SINH;
        functionArr[230] = NumericFunction.COSH;
        functionArr[231] = NumericFunction.TANH;
        functionArr[232] = NumericFunction.ASINH;
        functionArr[233] = NumericFunction.ACOSH;
        functionArr[234] = NumericFunction.ATANH;
        functionArr[235] = new DStarRunner(DStarRunner.DStarAlgorithmEnum.DGET);
        functionArr[255] = null;
        functionArr[261] = new Errortype();
        functionArr[269] = AggregateFunction.AVEDEV;
        functionArr[276] = NumericFunction.COMBIN;
        functionArr[279] = new Even();
        functionArr[285] = NumericFunction.FLOOR;
        functionArr[288] = NumericFunction.CEILING;
        functionArr[298] = new Odd();
        functionArr[300] = NumericFunction.POISSON;
        functionArr[303] = new Sumxmy2();
        functionArr[304] = new Sumx2my2();
        functionArr[305] = new Sumx2py2();
        functionArr[311] = new Intercept();
        functionArr[315] = new Slope();
        functionArr[318] = AggregateFunction.DEVSQ;
        functionArr[321] = AggregateFunction.SUMSQ;
        functionArr[325] = AggregateFunction.LARGE;
        functionArr[326] = AggregateFunction.SMALL;
        functionArr[328] = AggregateFunction.PERCENTILE;
        functionArr[330] = new Mode();
        functionArr[336] = TextFunction.CONCATENATE;
        functionArr[337] = NumericFunction.POWER;
        functionArr[342] = NumericFunction.RADIANS;
        functionArr[343] = NumericFunction.DEGREES;
        functionArr[344] = new Subtotal();
        functionArr[345] = new Sumif();
        functionArr[346] = new Countif();
        functionArr[347] = new Countblank();
        functionArr[354] = new Roman();
        functionArr[359] = new Hyperlink();
        functionArr[362] = MinaMaxa.MAXA;
        functionArr[363] = MinaMaxa.MINA;
        for (int i = 0; i < 368; i++) {
            if (functionArr[i] == null && (functionByIndex = FunctionMetadataRegistry.getFunctionByIndex(i)) != null) {
                functionArr[i] = new NotImplementedFunction(functionByIndex.getName());
            }
        }
        return functionArr;
    }

    public static Function getBasicFunction(int i) {
        if (i == 148 || i == 255) {
            return null;
        }
        Function function = functions[i];
        if (function != null) {
            return function;
        }
        throw new NotImplementedException("FuncIx=" + i);
    }

    public static void registerFunction(String str, Function function) {
        FunctionMetadata functionByName = FunctionMetadataRegistry.getFunctionByName(str);
        if (functionByName == null) {
            if (AnalysisToolPak.isATPFunction(str)) {
                throw new IllegalArgumentException(str + " is a function from the Excel Analysis Toolpack. Use AnalysisToolpack.registerFunction(String name, FreeRefFunction func) instead.");
            }
            throw new IllegalArgumentException("Unknown function: " + str);
        }
        int index = functionByName.getIndex();
        Function[] functionArr = functions;
        if (functionArr[index] instanceof NotImplementedFunction) {
            functionArr[index] = function;
            return;
        }
        throw new IllegalArgumentException("POI already implememts " + str + ". You cannot override POI's implementations of Excel functions");
    }

    public static Collection<String> getSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        while (true) {
            Function[] functionArr = functions;
            if (i < functionArr.length) {
                Function function = functionArr[i];
                FunctionMetadata functionByIndex = FunctionMetadataRegistry.getFunctionByIndex(i);
                if (function != null && !(function instanceof NotImplementedFunction)) {
                    treeSet.add(functionByIndex.getName());
                }
                i++;
            } else {
                treeSet.add("INDIRECT");
                return Collections.unmodifiableCollection(treeSet);
            }
        }
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        while (true) {
            Function[] functionArr = functions;
            if (i < functionArr.length) {
                Function function = functionArr[i];
                if (function != null && (function instanceof NotImplementedFunction)) {
                    treeSet.add(FunctionMetadataRegistry.getFunctionByIndex(i).getName());
                }
                i++;
            } else {
                treeSet.remove("INDIRECT");
                return Collections.unmodifiableCollection(treeSet);
            }
        }
    }
}

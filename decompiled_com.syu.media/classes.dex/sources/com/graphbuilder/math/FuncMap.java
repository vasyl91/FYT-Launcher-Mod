package com.graphbuilder.math;

import com.graphbuilder.math.func.AbsFunction;
import com.graphbuilder.math.func.AcosFunction;
import com.graphbuilder.math.func.AcoshFunction;
import com.graphbuilder.math.func.AsinFunction;
import com.graphbuilder.math.func.AsinhFunction;
import com.graphbuilder.math.func.AtanFunction;
import com.graphbuilder.math.func.AtanhFunction;
import com.graphbuilder.math.func.AvgFunction;
import com.graphbuilder.math.func.CeilFunction;
import com.graphbuilder.math.func.CombinFunction;
import com.graphbuilder.math.func.CosFunction;
import com.graphbuilder.math.func.CoshFunction;
import com.graphbuilder.math.func.EFunction;
import com.graphbuilder.math.func.ExpFunction;
import com.graphbuilder.math.func.FactFunction;
import com.graphbuilder.math.func.FloorFunction;
import com.graphbuilder.math.func.Function;
import com.graphbuilder.math.func.LgFunction;
import com.graphbuilder.math.func.LnFunction;
import com.graphbuilder.math.func.LogFunction;
import com.graphbuilder.math.func.MaxFunction;
import com.graphbuilder.math.func.MinFunction;
import com.graphbuilder.math.func.ModFunction;
import com.graphbuilder.math.func.PiFunction;
import com.graphbuilder.math.func.PowFunction;
import com.graphbuilder.math.func.RandFunction;
import com.graphbuilder.math.func.RoundFunction;
import com.graphbuilder.math.func.SignFunction;
import com.graphbuilder.math.func.SinFunction;
import com.graphbuilder.math.func.SinhFunction;
import com.graphbuilder.math.func.SqrtFunction;
import com.graphbuilder.math.func.SumFunction;
import com.graphbuilder.math.func.TanFunction;
import com.graphbuilder.math.func.TanhFunction;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FuncMap {
    private boolean caseSensitive;
    private Function[] func;
    private String[] name;
    private int numFunc;

    public FuncMap() {
        this.name = new String[50];
        this.func = new Function[50];
        this.numFunc = 0;
        this.caseSensitive = false;
    }

    public FuncMap(boolean z) {
        this.name = new String[50];
        this.func = new Function[50];
        this.numFunc = 0;
        this.caseSensitive = z;
    }

    public void loadDefaultFunctions() {
        setFunction("min", new MinFunction());
        setFunction("max", new MaxFunction());
        setFunction("sum", new SumFunction());
        setFunction("avg", new AvgFunction());
        setFunction("pi", new PiFunction());
        setFunction("e", new EFunction());
        setFunction("rand", new RandFunction());
        setFunction("sin", new SinFunction());
        setFunction("cos", new CosFunction());
        setFunction("tan", new TanFunction());
        setFunction("sqrt", new SqrtFunction());
        setFunction("abs", new AbsFunction());
        setFunction("ceil", new CeilFunction());
        setFunction("floor", new FloorFunction());
        setFunction("exp", new ExpFunction());
        setFunction("lg", new LgFunction());
        setFunction("ln", new LnFunction());
        setFunction("sign", new SignFunction());
        setFunction("round", new RoundFunction());
        setFunction("fact", new FactFunction());
        setFunction("cosh", new CoshFunction());
        setFunction("sinh", new SinhFunction());
        setFunction("tanh", new TanhFunction());
        setFunction("acos", new AcosFunction());
        setFunction("asin", new AsinFunction());
        setFunction("atan", new AtanFunction());
        setFunction("acosh", new AcoshFunction());
        setFunction("asinh", new AsinhFunction());
        setFunction("atanh", new AtanhFunction());
        setFunction("pow", new PowFunction());
        setFunction("mod", new ModFunction());
        setFunction("combin", new CombinFunction());
        setFunction("log", new LogFunction());
    }

    public Function getFunction(String str, int i) {
        for (int i2 = 0; i2 < this.numFunc; i2++) {
            if (this.func[i2].acceptNumParam(i) && ((this.caseSensitive && this.name[i2].equals(str)) || (!this.caseSensitive && this.name[i2].equalsIgnoreCase(str)))) {
                return this.func[i2];
            }
        }
        throw new RuntimeException("function not found: " + str + " " + i);
    }

    public void setFunction(String str, Function function) {
        if (str == null) {
            throw new IllegalArgumentException("function name cannot be null");
        }
        if (function == null) {
            throw new IllegalArgumentException("function cannot be null");
        }
        int i = 0;
        while (true) {
            int i2 = this.numFunc;
            if (i < i2) {
                if ((this.caseSensitive && this.name[i].equals(str)) || (!this.caseSensitive && this.name[i].equalsIgnoreCase(str))) {
                    this.func[i] = function;
                    return;
                }
                i++;
            } else {
                if (i2 == this.name.length) {
                    int i3 = i2 * 2;
                    String[] strArr = new String[i3];
                    Function[] functionArr = new Function[i3];
                    for (int i4 = 0; i4 < this.numFunc; i4++) {
                        strArr[i4] = this.name[i4];
                        functionArr[i4] = this.func[i4];
                    }
                    this.name = strArr;
                    this.func = functionArr;
                }
                String[] strArr2 = this.name;
                int i5 = this.numFunc;
                strArr2[i5] = str;
                this.func[i5] = function;
                this.numFunc = i5 + 1;
                return;
            }
        }
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public String[] getFunctionNames() {
        int i = this.numFunc;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = this.name[i2];
        }
        return strArr;
    }

    public Function[] getFunctions() {
        int i = this.numFunc;
        Function[] functionArr = new Function[i];
        for (int i2 = 0; i2 < i; i2++) {
            functionArr[i2] = this.func[i2];
        }
        return functionArr;
    }

    public void remove(String str) {
        int i = 0;
        while (i < this.numFunc) {
            if (!(this.caseSensitive && this.name[i].equals(str)) && (this.caseSensitive || !this.name[i].equalsIgnoreCase(str))) {
                i++;
            } else {
                while (true) {
                    i++;
                    int i2 = this.numFunc;
                    if (i < i2) {
                        String[] strArr = this.name;
                        int i3 = i - 1;
                        strArr[i3] = strArr[i];
                        Function[] functionArr = this.func;
                        functionArr[i3] = functionArr[i];
                    } else {
                        int i4 = i2 - 1;
                        this.numFunc = i4;
                        this.name[i4] = null;
                        this.func[i4] = null;
                        return;
                    }
                }
            }
        }
    }
}

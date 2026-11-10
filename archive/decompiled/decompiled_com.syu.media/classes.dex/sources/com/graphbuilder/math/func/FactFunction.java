package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FactFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 1;
    }

    public String toString() {
        return "fact(n)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        double d = 1.0d;
        for (int i2 = (int) dArr[0]; i2 > 1; i2--) {
            d *= (double) i2;
        }
        return d;
    }
}

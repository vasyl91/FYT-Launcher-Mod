package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SumFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i > 0;
    }

    public String toString() {
        return "sum(x1, x2, ..., xn)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        double d = 0.0d;
        for (int i2 = 0; i2 < i; i2++) {
            d += dArr[i2];
        }
        return d;
    }
}

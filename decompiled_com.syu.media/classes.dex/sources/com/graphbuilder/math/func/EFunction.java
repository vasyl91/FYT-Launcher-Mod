package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class EFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 0;
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        return 2.718281828459045d;
    }

    public String toString() {
        return "e()";
    }
}

package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CeilFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 1;
    }

    public String toString() {
        return "ceil(x)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        return Math.ceil(dArr[0]);
    }
}

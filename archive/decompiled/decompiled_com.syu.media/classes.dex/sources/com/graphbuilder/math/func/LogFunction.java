package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class LogFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 1 || i == 2;
    }

    public String toString() {
        return "log(x):log(x, y)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        if (i == 1) {
            return Math.log(dArr[0]) / Math.log(10.0d);
        }
        return Math.log(dArr[0]) / Math.log(dArr[1]);
    }
}

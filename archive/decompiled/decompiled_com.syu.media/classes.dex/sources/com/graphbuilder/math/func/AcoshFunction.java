package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AcoshFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 1;
    }

    public String toString() {
        return "acosh(x)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        return Math.log(Math.sqrt((dArr[0] + 1.0d) / 2.0d) + Math.sqrt((dArr[0] - 1.0d) / 2.0d)) * 2.0d;
    }
}

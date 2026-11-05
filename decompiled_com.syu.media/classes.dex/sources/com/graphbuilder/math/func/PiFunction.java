package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PiFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 0;
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        return 3.141592653589793d;
    }

    public String toString() {
        return "pi()";
    }
}

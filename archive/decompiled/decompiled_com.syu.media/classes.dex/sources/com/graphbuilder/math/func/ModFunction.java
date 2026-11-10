package com.graphbuilder.math.func;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ModFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 2;
    }

    public String toString() {
        return "mod(x, y)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        return dArr[0] % dArr[1];
    }
}

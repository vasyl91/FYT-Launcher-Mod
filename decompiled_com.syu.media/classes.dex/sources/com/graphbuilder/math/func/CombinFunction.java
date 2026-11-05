package com.graphbuilder.math.func;

import com.graphbuilder.math.PascalsTriangle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CombinFunction implements Function {
    @Override // com.graphbuilder.math.func.Function
    public boolean acceptNumParam(int i) {
        return i == 2;
    }

    public String toString() {
        return "combin(n, r)";
    }

    @Override // com.graphbuilder.math.func.Function
    public double of(double[] dArr, int i) {
        return PascalsTriangle.nCr((int) dArr[0], (int) dArr[1]);
    }
}

package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ValNode extends Expression {
    protected double val;

    public ValNode(double d) {
        this.val = d;
    }

    @Override // com.graphbuilder.math.Expression
    public double eval(VarMap varMap, FuncMap funcMap) {
        return this.val;
    }

    public double getValue() {
        return this.val;
    }

    public void setValue(double d) {
        this.val = d;
    }
}

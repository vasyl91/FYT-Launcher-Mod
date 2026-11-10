package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class VarNode extends TermNode {
    public VarNode(String str, boolean z) {
        super(str, z);
    }

    @Override // com.graphbuilder.math.Expression
    public double eval(VarMap varMap, FuncMap funcMap) {
        double value = varMap.getValue(this.name);
        return this.negate ? -value : value;
    }
}

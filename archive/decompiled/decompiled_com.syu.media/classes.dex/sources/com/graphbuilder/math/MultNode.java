package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MultNode extends OpNode {
    @Override // com.graphbuilder.math.OpNode
    public String getSymbol() {
        return "*";
    }

    public MultNode(Expression expression, Expression expression2) {
        super(expression, expression2);
    }

    @Override // com.graphbuilder.math.Expression
    public double eval(VarMap varMap, FuncMap funcMap) {
        return this.leftChild.eval(varMap, funcMap) * this.rightChild.eval(varMap, funcMap);
    }
}

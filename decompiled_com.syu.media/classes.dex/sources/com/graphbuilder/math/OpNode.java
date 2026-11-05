package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class OpNode extends Expression {
    protected Expression leftChild = null;
    protected Expression rightChild = null;

    public abstract String getSymbol();

    public OpNode(Expression expression, Expression expression2) {
        setLeftChild(expression);
        setRightChild(expression2);
    }

    public void setLeftChild(Expression expression) {
        checkBeforeAccept(expression);
        Expression expression2 = this.leftChild;
        if (expression2 != null) {
            expression2.parent = null;
        }
        expression.parent = this;
        this.leftChild = expression;
    }

    public void setRightChild(Expression expression) {
        checkBeforeAccept(expression);
        Expression expression2 = this.rightChild;
        if (expression2 != null) {
            expression2.parent = null;
        }
        expression.parent = this;
        this.rightChild = expression;
    }

    public Expression getLeftChild() {
        return this.leftChild;
    }

    public Expression getRightChild() {
        return this.rightChild;
    }
}

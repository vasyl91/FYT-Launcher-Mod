package com.graphbuilder.math;

import com.graphbuilder.struc.Bag;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class Expression {
    protected Expression parent = null;

    public abstract double eval(VarMap varMap, FuncMap funcMap);

    public boolean isDescendent(Expression expression) {
        for (Expression expression2 = this; expression2 != null; expression2 = expression2.parent) {
            if (expression2 == expression) {
                return true;
            }
        }
        return false;
    }

    public Expression getParent() {
        return this.parent;
    }

    protected void checkBeforeAccept(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException("expression cannot be null");
        }
        if (expression.parent != null) {
            throw new IllegalArgumentException("expression must be removed parent");
        }
        if (isDescendent(expression)) {
            throw new IllegalArgumentException("cyclic reference");
        }
    }

    public String[] getVariableNames() {
        return getTermNames(true);
    }

    public String[] getFunctionNames() {
        return getTermNames(false);
    }

    private String[] getTermNames(boolean z) {
        Bag bag = new Bag();
        getTermNames(this, bag, z);
        int size = bag.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) bag.get(i);
        }
        return strArr;
    }

    private static void getTermNames(Expression expression, Bag bag, boolean z) {
        if (expression instanceof OpNode) {
            OpNode opNode = (OpNode) expression;
            getTermNames(opNode.leftChild, bag, z);
            getTermNames(opNode.rightChild, bag, z);
            return;
        }
        if (expression instanceof VarNode) {
            if (z) {
                VarNode varNode = (VarNode) expression;
                if (bag.contains(varNode.name)) {
                    return;
                }
                bag.add(varNode.name);
                return;
            }
            return;
        }
        if (expression instanceof FuncNode) {
            FuncNode funcNode = (FuncNode) expression;
            if (!z && !bag.contains(funcNode.name)) {
                bag.add(funcNode.name);
            }
            for (int i = 0; i < funcNode.numChildren(); i++) {
                getTermNames(funcNode.child(i), bag, z);
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        toString(this, stringBuffer);
        return stringBuffer.toString();
    }

    private static void toString(Expression expression, StringBuffer stringBuffer) {
        if (expression instanceof OpNode) {
            OpNode opNode = (OpNode) expression;
            stringBuffer.append("(");
            toString(opNode.leftChild, stringBuffer);
            stringBuffer.append(opNode.getSymbol());
            toString(opNode.rightChild, stringBuffer);
            stringBuffer.append(")");
            return;
        }
        if (expression instanceof TermNode) {
            TermNode termNode = (TermNode) expression;
            if (termNode.getNegate()) {
                stringBuffer.append("(");
                stringBuffer.append("-");
            }
            stringBuffer.append(termNode.getName());
            if (termNode instanceof FuncNode) {
                FuncNode funcNode = (FuncNode) termNode;
                stringBuffer.append("(");
                if (funcNode.numChildren() > 0) {
                    toString(funcNode.child(0), stringBuffer);
                }
                for (int i = 1; i < funcNode.numChildren(); i++) {
                    stringBuffer.append(", ");
                    toString(funcNode.child(i), stringBuffer);
                }
                stringBuffer.append(")");
            }
            if (termNode.getNegate()) {
                stringBuffer.append(")");
                return;
            }
            return;
        }
        if (expression instanceof ValNode) {
            stringBuffer.append(((ValNode) expression).val);
        }
    }
}

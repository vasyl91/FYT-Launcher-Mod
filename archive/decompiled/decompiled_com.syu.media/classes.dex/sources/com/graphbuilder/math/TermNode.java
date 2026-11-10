package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class TermNode extends Expression {
    protected String name = null;
    protected boolean negate = false;

    public TermNode(String str, boolean z) {
        setName(str);
        setNegate(z);
    }

    public boolean getNegate() {
        return this.negate;
    }

    public void setNegate(boolean z) {
        this.negate = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (!isValidName(str)) {
            throw new IllegalArgumentException("invalid name: " + str);
        }
        this.name = str;
    }

    private static boolean isValidName(String str) {
        if (str.length() == 0) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.' || cCharAt == ',' || cCharAt == '(' || cCharAt == ')' || cCharAt == '^' || cCharAt == '*' || cCharAt == '/' || cCharAt == '+' || cCharAt == '-' || cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\n') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 == ',' || cCharAt2 == '(' || cCharAt2 == ')' || cCharAt2 == '^' || cCharAt2 == '*' || cCharAt2 == '/' || cCharAt2 == '+' || cCharAt2 == '-' || cCharAt2 == ' ' || cCharAt2 == '\t' || cCharAt2 == '\n') {
                return false;
            }
        }
        return true;
    }
}

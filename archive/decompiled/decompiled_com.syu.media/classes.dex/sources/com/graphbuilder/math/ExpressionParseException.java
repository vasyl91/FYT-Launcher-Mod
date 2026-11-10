package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ExpressionParseException extends RuntimeException {
    private String descrip;
    private int index;

    public ExpressionParseException(String str, int i) {
        this.descrip = str;
        this.index = i;
    }

    public String getDescription() {
        return this.descrip;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "(" + this.index + ") " + this.descrip;
    }
}

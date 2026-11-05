package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class VarMap {
    private boolean caseSensitive;
    private String[] name;
    private int numVars;
    private double[] value;

    public VarMap() {
        this(true);
    }

    public VarMap(boolean z) {
        this.name = new String[2];
        this.value = new double[2];
        this.numVars = 0;
        this.caseSensitive = z;
    }

    public double getValue(String str) {
        for (int i = 0; i < this.numVars; i++) {
            if ((this.caseSensitive && this.name[i].equals(str)) || (!this.caseSensitive && this.name[i].equalsIgnoreCase(str))) {
                return this.value[i];
            }
        }
        throw new RuntimeException("variable value has not been set: " + str);
    }

    public void setValue(String str, double d) {
        if (str == null) {
            throw new IllegalArgumentException("varName cannot be null");
        }
        int i = 0;
        while (true) {
            int i2 = this.numVars;
            if (i < i2) {
                if ((this.caseSensitive && this.name[i].equals(str)) || (!this.caseSensitive && this.name[i].equalsIgnoreCase(str))) {
                    this.value[i] = d;
                    return;
                }
                i++;
            } else {
                if (i2 == this.name.length) {
                    int i3 = i2 * 2;
                    String[] strArr = new String[i3];
                    double[] dArr = new double[i3];
                    for (int i4 = 0; i4 < this.numVars; i4++) {
                        strArr[i4] = this.name[i4];
                        dArr[i4] = this.value[i4];
                    }
                    this.name = strArr;
                    this.value = dArr;
                }
                String[] strArr2 = this.name;
                int i5 = this.numVars;
                strArr2[i5] = str;
                this.value[i5] = d;
                this.numVars = i5 + 1;
                return;
            }
        }
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public String[] getVariableNames() {
        int i = this.numVars;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = this.name[i2];
        }
        return strArr;
    }

    public double[] getValues() {
        int i = this.numVars;
        double[] dArr = new double[i];
        for (int i2 = 0; i2 < i; i2++) {
            dArr[i2] = this.value[i2];
        }
        return dArr;
    }

    public void remove(String str) {
        int i = 0;
        while (i < this.numVars) {
            if (!(this.caseSensitive && this.name[i].equals(str)) && (this.caseSensitive || !this.name[i].equalsIgnoreCase(str))) {
                i++;
            } else {
                while (true) {
                    i++;
                    int i2 = this.numVars;
                    if (i < i2) {
                        String[] strArr = this.name;
                        int i3 = i - 1;
                        strArr[i3] = strArr[i];
                        double[] dArr = this.value;
                        dArr[i3] = dArr[i];
                    } else {
                        int i4 = i2 - 1;
                        this.numVars = i4;
                        this.name[i4] = null;
                        this.value[i4] = 0.0d;
                        return;
                    }
                }
            }
        }
    }
}

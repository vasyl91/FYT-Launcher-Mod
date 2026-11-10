package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum DataConsolidateFunction {
    AVERAGE(1, "Average"),
    COUNT(2, "Count"),
    COUNT_NUMS(3, "Count"),
    MAX(4, "Max"),
    MIN(5, "Min"),
    PRODUCT(6, "Product"),
    STD_DEV(7, "StdDev"),
    STD_DEVP(8, "StdDevp"),
    SUM(9, "Sum"),
    VAR(10, "Var"),
    VARP(11, "Varp");

    private final String name;
    private final int value;

    DataConsolidateFunction(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}

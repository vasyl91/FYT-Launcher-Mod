package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Pxg {
    int getExternalWorkbookNumber();

    String getSheetName();

    void setSheetName(String str);

    String toFormulaString();
}

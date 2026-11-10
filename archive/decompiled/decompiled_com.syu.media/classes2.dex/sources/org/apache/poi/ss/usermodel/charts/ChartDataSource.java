package org.apache.poi.ss.usermodel.charts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ChartDataSource<T> {
    String getFormulaString();

    T getPointAt(int i);

    int getPointCount();

    boolean isNumeric();

    boolean isReference();
}

package org.apache.poi.ss.usermodel.charts;

import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ChartSeries {
    CellReference getTitleCellReference();

    String getTitleString();

    TitleType getTitleType();

    void setTitle(String str);

    void setTitle(CellReference cellReference);
}

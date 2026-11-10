package org.apache.poi.ss.usermodel.charts;

import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ScatterChartData extends ChartData {
    ScatterChartSeries addSerie(ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2);

    List<? extends ScatterChartSeries> getSeries();
}

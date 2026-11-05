package org.apache.poi.ss.usermodel;

import java.util.List;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartAxisFactory;
import org.apache.poi.ss.usermodel.charts.ChartData;
import org.apache.poi.ss.usermodel.charts.ChartDataFactory;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.ManuallyPositionable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Chart extends ManuallyPositionable {
    void deleteLegend();

    List<? extends ChartAxis> getAxis();

    ChartAxisFactory getChartAxisFactory();

    ChartDataFactory getChartDataFactory();

    ChartLegend getOrCreateLegend();

    void plot(ChartData chartData, ChartAxis... chartAxisArr);
}

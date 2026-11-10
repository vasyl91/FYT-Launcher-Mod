package org.apache.poi.xssf.usermodel.charts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.LineChartSeries;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFLineChartData implements LineChartData {
    private List<Series> series = new ArrayList();

    static class Series extends AbstractXSSFChartSeries implements LineChartSeries {
        private ChartDataSource<?> categories;
        private int id;
        private int order;
        private ChartDataSource<? extends Number> values;

        protected Series(int i, int i2, ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2) {
            this.id = i;
            this.order = i2;
            this.categories = chartDataSource;
            this.values = chartDataSource2;
        }

        @Override // org.apache.poi.ss.usermodel.charts.LineChartSeries
        public ChartDataSource<?> getCategoryAxisData() {
            return this.categories;
        }

        @Override // org.apache.poi.ss.usermodel.charts.LineChartSeries
        public ChartDataSource<? extends Number> getValues() {
            return this.values;
        }

        protected void addToChart(CTLineChart cTLineChart) {
            CTLineSer cTLineSerAddNewSer = cTLineChart.addNewSer();
            cTLineSerAddNewSer.addNewIdx().setVal(this.id);
            cTLineSerAddNewSer.addNewOrder().setVal(this.order);
            cTLineSerAddNewSer.addNewMarker().addNewSymbol().setVal(STMarkerStyle.NONE);
            XSSFChartUtil.buildAxDataSource(cTLineSerAddNewSer.addNewCat(), this.categories);
            XSSFChartUtil.buildNumDataSource(cTLineSerAddNewSer.addNewVal(), this.values);
            if (isTitleSet()) {
                cTLineSerAddNewSer.setTx(getCTSerTx());
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.LineChartData
    public LineChartSeries addSeries(ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2) {
        if (!chartDataSource2.isNumeric()) {
            throw new IllegalArgumentException("Value data source must be numeric.");
        }
        int size = this.series.size();
        Series series = new Series(size, size, chartDataSource, chartDataSource2);
        this.series.add(series);
        return series;
    }

    @Override // org.apache.poi.ss.usermodel.charts.LineChartData
    public List<? extends LineChartSeries> getSeries() {
        return this.series;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartData
    public void fillChart(Chart chart, ChartAxis... chartAxisArr) {
        if (!(chart instanceof XSSFChart)) {
            throw new IllegalArgumentException("Chart must be instance of XSSFChart");
        }
        CTLineChart cTLineChartAddNewLineChart = ((XSSFChart) chart).getCTChart().getPlotArea().addNewLineChart();
        cTLineChartAddNewLineChart.addNewVaryColors().setVal(false);
        Iterator<Series> it = this.series.iterator();
        while (it.hasNext()) {
            it.next().addToChart(cTLineChartAddNewLineChart);
        }
        for (ChartAxis chartAxis : chartAxisArr) {
            cTLineChartAddNewLineChart.addNewAxId().setVal(chartAxis.getId());
        }
    }
}

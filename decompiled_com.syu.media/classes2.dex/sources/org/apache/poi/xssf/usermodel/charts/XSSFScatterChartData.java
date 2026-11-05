package org.apache.poi.xssf.usermodel.charts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.apache.poi.ss.usermodel.charts.ScatterChartSeries;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFScatterChartData implements ScatterChartData {
    private List<Series> series = new ArrayList();

    static class Series extends AbstractXSSFChartSeries implements ScatterChartSeries {
        private int id;
        private int order;
        private ChartDataSource<?> xs;
        private ChartDataSource<? extends Number> ys;

        protected Series(int i, int i2, ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2) {
            this.id = i;
            this.order = i2;
            this.xs = chartDataSource;
            this.ys = chartDataSource2;
        }

        @Override // org.apache.poi.ss.usermodel.charts.ScatterChartSeries
        public ChartDataSource<?> getXValues() {
            return this.xs;
        }

        @Override // org.apache.poi.ss.usermodel.charts.ScatterChartSeries
        public ChartDataSource<? extends Number> getYValues() {
            return this.ys;
        }

        protected void addToChart(CTScatterChart cTScatterChart) {
            CTScatterSer cTScatterSerAddNewSer = cTScatterChart.addNewSer();
            cTScatterSerAddNewSer.addNewIdx().setVal(this.id);
            cTScatterSerAddNewSer.addNewOrder().setVal(this.order);
            XSSFChartUtil.buildAxDataSource(cTScatterSerAddNewSer.addNewXVal(), this.xs);
            XSSFChartUtil.buildNumDataSource(cTScatterSerAddNewSer.addNewYVal(), this.ys);
            if (isTitleSet()) {
                cTScatterSerAddNewSer.setTx(getCTSerTx());
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.ScatterChartData
    public ScatterChartSeries addSerie(ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2) {
        if (!chartDataSource2.isNumeric()) {
            throw new IllegalArgumentException("Y axis data source must be numeric.");
        }
        int size = this.series.size();
        Series series = new Series(size, size, chartDataSource, chartDataSource2);
        this.series.add(series);
        return series;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartData
    public void fillChart(Chart chart, ChartAxis... chartAxisArr) {
        if (!(chart instanceof XSSFChart)) {
            throw new IllegalArgumentException("Chart must be instance of XSSFChart");
        }
        CTScatterChart cTScatterChartAddNewScatterChart = ((XSSFChart) chart).getCTChart().getPlotArea().addNewScatterChart();
        addStyle(cTScatterChartAddNewScatterChart);
        Iterator<Series> it = this.series.iterator();
        while (it.hasNext()) {
            it.next().addToChart(cTScatterChartAddNewScatterChart);
        }
        for (ChartAxis chartAxis : chartAxisArr) {
            cTScatterChartAddNewScatterChart.addNewAxId().setVal(chartAxis.getId());
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.ScatterChartData
    public List<? extends Series> getSeries() {
        return this.series;
    }

    private void addStyle(CTScatterChart cTScatterChart) {
        cTScatterChart.addNewScatterStyle().setVal(STScatterStyle.LINE_MARKER);
    }
}

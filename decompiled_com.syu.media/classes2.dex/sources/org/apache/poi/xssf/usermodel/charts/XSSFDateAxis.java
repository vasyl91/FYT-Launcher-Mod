package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisOrientation;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.AxisTickMark;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFDateAxis extends XSSFChartAxis {
    private CTDateAx ctDateAx;

    public XSSFDateAxis(XSSFChart xSSFChart, long j, AxisPosition axisPosition) {
        super(xSSFChart);
        createAxis(j, axisPosition);
    }

    public XSSFDateAxis(XSSFChart xSSFChart, CTDateAx cTDateAx) {
        super(xSSFChart);
        this.ctDateAx = cTDateAx;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public long getId() {
        return this.ctDateAx.getAxId().getVal();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    @Internal
    public CTShapeProperties getLine() {
        return this.ctDateAx.getSpPr();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTAxPos getCTAxPos() {
        return this.ctDateAx.getAxPos();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTNumFmt getCTNumFmt() {
        if (this.ctDateAx.isSetNumFmt()) {
            return this.ctDateAx.getNumFmt();
        }
        return this.ctDateAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTScaling getCTScaling() {
        return this.ctDateAx.getScaling();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTCrosses getCTCrosses() {
        return this.ctDateAx.getCrosses();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTBoolean getDelete() {
        return this.ctDateAx.getDelete();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTTickMark getMajorCTTickMark() {
        return this.ctDateAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTTickMark getMinorCTTickMark() {
        return this.ctDateAx.getMinorTickMark();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    @Internal
    public CTChartLines getMajorGridLines() {
        return this.ctDateAx.getMajorGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void crossAxis(ChartAxis chartAxis) {
        this.ctDateAx.getCrossAx().setVal(chartAxis.getId());
    }

    private void createAxis(long j, AxisPosition axisPosition) {
        CTDateAx cTDateAxAddNewDateAx = this.chart.getCTChart().getPlotArea().addNewDateAx();
        this.ctDateAx = cTDateAxAddNewDateAx;
        cTDateAxAddNewDateAx.addNewAxId().setVal(j);
        this.ctDateAx.addNewAxPos();
        this.ctDateAx.addNewScaling();
        this.ctDateAx.addNewCrosses();
        this.ctDateAx.addNewCrossAx();
        this.ctDateAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        this.ctDateAx.addNewDelete();
        this.ctDateAx.addNewMajorTickMark();
        this.ctDateAx.addNewMinorTickMark();
        setPosition(axisPosition);
        setOrientation(AxisOrientation.MIN_MAX);
        setCrosses(AxisCrosses.AUTO_ZERO);
        setVisible(true);
        setMajorTickMark(AxisTickMark.CROSS);
        setMinorTickMark(AxisTickMark.NONE);
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public boolean hasNumberFormat() {
        return this.ctDateAx.isSetNumFmt();
    }
}

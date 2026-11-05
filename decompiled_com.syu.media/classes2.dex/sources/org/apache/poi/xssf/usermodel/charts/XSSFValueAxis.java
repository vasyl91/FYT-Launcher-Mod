package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.AxisCrossBetween;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisOrientation;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.AxisTickMark;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFValueAxis extends XSSFChartAxis implements ValueAxis {
    private CTValAx ctValAx;

    public XSSFValueAxis(XSSFChart xSSFChart, long j, AxisPosition axisPosition) {
        super(xSSFChart);
        createAxis(j, axisPosition);
    }

    public XSSFValueAxis(XSSFChart xSSFChart, CTValAx cTValAx) {
        super(xSSFChart);
        this.ctValAx = cTValAx;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public long getId() {
        return this.ctValAx.getAxId().getVal();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    @Internal
    public CTShapeProperties getLine() {
        return this.ctValAx.getSpPr();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ValueAxis
    public void setCrossBetween(AxisCrossBetween axisCrossBetween) {
        this.ctValAx.getCrossBetween().setVal(fromCrossBetween(axisCrossBetween));
    }

    @Override // org.apache.poi.ss.usermodel.charts.ValueAxis
    public AxisCrossBetween getCrossBetween() {
        return toCrossBetween(this.ctValAx.getCrossBetween().getVal());
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTAxPos getCTAxPos() {
        return this.ctValAx.getAxPos();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTNumFmt getCTNumFmt() {
        if (this.ctValAx.isSetNumFmt()) {
            return this.ctValAx.getNumFmt();
        }
        return this.ctValAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTScaling getCTScaling() {
        return this.ctValAx.getScaling();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTCrosses getCTCrosses() {
        return this.ctValAx.getCrosses();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTBoolean getDelete() {
        return this.ctValAx.getDelete();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTTickMark getMajorCTTickMark() {
        return this.ctValAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTTickMark getMinorCTTickMark() {
        return this.ctValAx.getMinorTickMark();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    @Internal
    public CTChartLines getMajorGridLines() {
        return this.ctValAx.getMajorGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void crossAxis(ChartAxis chartAxis) {
        this.ctValAx.getCrossAx().setVal(chartAxis.getId());
    }

    private void createAxis(long j, AxisPosition axisPosition) {
        CTValAx cTValAxAddNewValAx = this.chart.getCTChart().getPlotArea().addNewValAx();
        this.ctValAx = cTValAxAddNewValAx;
        cTValAxAddNewValAx.addNewAxId().setVal(j);
        this.ctValAx.addNewAxPos();
        this.ctValAx.addNewScaling();
        this.ctValAx.addNewCrossBetween();
        this.ctValAx.addNewCrosses();
        this.ctValAx.addNewCrossAx();
        this.ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        this.ctValAx.addNewDelete();
        this.ctValAx.addNewMajorTickMark();
        this.ctValAx.addNewMinorTickMark();
        setPosition(axisPosition);
        setOrientation(AxisOrientation.MIN_MAX);
        setCrossBetween(AxisCrossBetween.MIDPOINT_CATEGORY);
        setCrosses(AxisCrosses.AUTO_ZERO);
        setVisible(true);
        setMajorTickMark(AxisTickMark.CROSS);
        setMinorTickMark(AxisTickMark.NONE);
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.charts.XSSFValueAxis$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrossBetween;

        static {
            int[] iArr = new int[AxisCrossBetween.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrossBetween = iArr;
            try {
                iArr[AxisCrossBetween.BETWEEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrossBetween[AxisCrossBetween.MIDPOINT_CATEGORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static STCrossBetween.Enum fromCrossBetween(AxisCrossBetween axisCrossBetween) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrossBetween[axisCrossBetween.ordinal()];
        if (i == 1) {
            return STCrossBetween.BETWEEN;
        }
        if (i == 2) {
            return STCrossBetween.MID_CAT;
        }
        throw new IllegalArgumentException();
    }

    private static AxisCrossBetween toCrossBetween(STCrossBetween.Enum r1) {
        int iIntValue = r1.intValue();
        if (iIntValue == 1) {
            return AxisCrossBetween.BETWEEN;
        }
        if (iIntValue == 2) {
            return AxisCrossBetween.MIDPOINT_CATEGORY;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public boolean hasNumberFormat() {
        return this.ctValAx.isSetNumFmt();
    }
}

package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTArea3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDTable;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLine3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPie3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStockChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPlotAreaImpl extends XmlComplexContentImpl implements CTPlotArea {
    private static final QName LAYOUT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout");
    private static final QName AREACHART$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "areaChart");
    private static final QName AREA3DCHART$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "area3DChart");
    private static final QName LINECHART$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "lineChart");
    private static final QName LINE3DCHART$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "line3DChart");
    private static final QName STOCKCHART$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "stockChart");
    private static final QName RADARCHART$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "radarChart");
    private static final QName SCATTERCHART$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "scatterChart");
    private static final QName PIECHART$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pieChart");
    private static final QName PIE3DCHART$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pie3DChart");
    private static final QName DOUGHNUTCHART$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "doughnutChart");
    private static final QName BARCHART$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "barChart");
    private static final QName BAR3DCHART$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bar3DChart");
    private static final QName OFPIECHART$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ofPieChart");
    private static final QName SURFACECHART$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "surfaceChart");
    private static final QName SURFACE3DCHART$30 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "surface3DChart");
    private static final QName BUBBLECHART$32 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubbleChart");
    private static final QName VALAX$34 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "valAx");
    private static final QName CATAX$36 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "catAx");
    private static final QName DATEAX$38 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dateAx");
    private static final QName SERAX$40 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "serAx");
    private static final QName DTABLE$42 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dTable");
    private static final QName SPPR$44 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
    private static final QName EXTLST$46 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTPlotAreaImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart addNewArea3DChart() {
        CTArea3DChart cTArea3DChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChartAdd_element_user = get_store().add_element_user(AREA3DCHART$4);
        }
        return cTArea3DChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart addNewAreaChart() {
        CTAreaChart cTAreaChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChartAdd_element_user = get_store().add_element_user(AREACHART$2);
        }
        return cTAreaChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart addNewBar3DChart() {
        CTBar3DChart cTBar3DChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChartAdd_element_user = get_store().add_element_user(BAR3DCHART$24);
        }
        return cTBar3DChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart addNewBarChart() {
        CTBarChart cTBarChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChartAdd_element_user = get_store().add_element_user(BARCHART$22);
        }
        return cTBarChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart addNewBubbleChart() {
        CTBubbleChart cTBubbleChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChartAdd_element_user = get_store().add_element_user(BUBBLECHART$32);
        }
        return cTBubbleChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx addNewCatAx() {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().add_element_user(CATAX$36);
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDTable addNewDTable() {
        CTDTable cTDTableAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDTableAdd_element_user = get_store().add_element_user(DTABLE$42);
        }
        return cTDTableAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx addNewDateAx() {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().add_element_user(DATEAX$38);
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart addNewDoughnutChart() {
        CTDoughnutChart cTDoughnutChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChartAdd_element_user = get_store().add_element_user(DOUGHNUTCHART$20);
        }
        return cTDoughnutChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$46);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLayout addNewLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().add_element_user(LAYOUT$0);
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart addNewLine3DChart() {
        CTLine3DChart cTLine3DChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChartAdd_element_user = get_store().add_element_user(LINE3DCHART$8);
        }
        return cTLine3DChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart addNewLineChart() {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().add_element_user(LINECHART$6);
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart addNewOfPieChart() {
        CTOfPieChart cTOfPieChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChartAdd_element_user = get_store().add_element_user(OFPIECHART$26);
        }
        return cTOfPieChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart addNewPie3DChart() {
        CTPie3DChart cTPie3DChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChartAdd_element_user = get_store().add_element_user(PIE3DCHART$18);
        }
        return cTPie3DChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart addNewPieChart() {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().add_element_user(PIECHART$16);
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart addNewRadarChart() {
        CTRadarChart cTRadarChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChartAdd_element_user = get_store().add_element_user(RADARCHART$12);
        }
        return cTRadarChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart addNewScatterChart() {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().add_element_user(SCATTERCHART$14);
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx addNewSerAx() {
        CTSerAx cTSerAxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAxAdd_element_user = get_store().add_element_user(SERAX$40);
        }
        return cTSerAxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$44);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart addNewStockChart() {
        CTStockChart cTStockChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartAdd_element_user = get_store().add_element_user(STOCKCHART$10);
        }
        return cTStockChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart addNewSurface3DChart() {
        CTSurface3DChart cTSurface3DChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChartAdd_element_user = get_store().add_element_user(SURFACE3DCHART$30);
        }
        return cTSurface3DChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart addNewSurfaceChart() {
        CTSurfaceChart cTSurfaceChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChartAdd_element_user = get_store().add_element_user(SURFACECHART$28);
        }
        return cTSurfaceChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx addNewValAx() {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().add_element_user(VALAX$34);
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart getArea3DChartArray(int i) {
        CTArea3DChart cTArea3DChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChartFind_element_user = get_store().find_element_user(AREA3DCHART$4, i);
            if (cTArea3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTArea3DChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart[] getArea3DChartArray() {
        CTArea3DChart[] cTArea3DChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AREA3DCHART$4, arrayList);
            cTArea3DChartArr = new CTArea3DChart[arrayList.size()];
            arrayList.toArray(cTArea3DChartArr);
        }
        return cTArea3DChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTArea3DChart> getArea3DChartList() {
        1Area3DChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Area3DChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart getAreaChartArray(int i) {
        CTAreaChart cTAreaChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChartFind_element_user = get_store().find_element_user(AREACHART$2, i);
            if (cTAreaChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAreaChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart[] getAreaChartArray() {
        CTAreaChart[] cTAreaChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AREACHART$2, arrayList);
            cTAreaChartArr = new CTAreaChart[arrayList.size()];
            arrayList.toArray(cTAreaChartArr);
        }
        return cTAreaChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTAreaChart> getAreaChartList() {
        1AreaChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AreaChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart getBar3DChartArray(int i) {
        CTBar3DChart cTBar3DChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChartFind_element_user = get_store().find_element_user(BAR3DCHART$24, i);
            if (cTBar3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBar3DChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart[] getBar3DChartArray() {
        CTBar3DChart[] cTBar3DChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BAR3DCHART$24, arrayList);
            cTBar3DChartArr = new CTBar3DChart[arrayList.size()];
            arrayList.toArray(cTBar3DChartArr);
        }
        return cTBar3DChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBar3DChart> getBar3DChartList() {
        1Bar3DChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Bar3DChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart getBarChartArray(int i) {
        CTBarChart cTBarChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChartFind_element_user = get_store().find_element_user(BARCHART$22, i);
            if (cTBarChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBarChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart[] getBarChartArray() {
        CTBarChart[] cTBarChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BARCHART$22, arrayList);
            cTBarChartArr = new CTBarChart[arrayList.size()];
            arrayList.toArray(cTBarChartArr);
        }
        return cTBarChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBarChart> getBarChartList() {
        1BarChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BarChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart getBubbleChartArray(int i) {
        CTBubbleChart cTBubbleChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChartFind_element_user = get_store().find_element_user(BUBBLECHART$32, i);
            if (cTBubbleChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBubbleChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart[] getBubbleChartArray() {
        CTBubbleChart[] cTBubbleChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BUBBLECHART$32, arrayList);
            cTBubbleChartArr = new CTBubbleChart[arrayList.size()];
            arrayList.toArray(cTBubbleChartArr);
        }
        return cTBubbleChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBubbleChart> getBubbleChartList() {
        1BubbleChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BubbleChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx getCatAxArray(int i) {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().find_element_user(CATAX$36, i);
            if (cTCatAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx[] getCatAxArray() {
        CTCatAx[] cTCatAxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CATAX$36, arrayList);
            cTCatAxArr = new CTCatAx[arrayList.size()];
            arrayList.toArray(cTCatAxArr);
        }
        return cTCatAxArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTCatAx> getCatAxList() {
        1CatAxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CatAxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDTable getDTable() {
        synchronized (monitor()) {
            check_orphaned();
            CTDTable cTDTableFind_element_user = get_store().find_element_user(DTABLE$42, 0);
            if (cTDTableFind_element_user == null) {
                return null;
            }
            return cTDTableFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx getDateAxArray(int i) {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().find_element_user(DATEAX$38, i);
            if (cTDateAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx[] getDateAxArray() {
        CTDateAx[] cTDateAxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATEAX$38, arrayList);
            cTDateAxArr = new CTDateAx[arrayList.size()];
            arrayList.toArray(cTDateAxArr);
        }
        return cTDateAxArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTDateAx> getDateAxList() {
        1DateAxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DateAxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart getDoughnutChartArray(int i) {
        CTDoughnutChart cTDoughnutChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChartFind_element_user = get_store().find_element_user(DOUGHNUTCHART$20, i);
            if (cTDoughnutChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDoughnutChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart[] getDoughnutChartArray() {
        CTDoughnutChart[] cTDoughnutChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DOUGHNUTCHART$20, arrayList);
            cTDoughnutChartArr = new CTDoughnutChart[arrayList.size()];
            arrayList.toArray(cTDoughnutChartArr);
        }
        return cTDoughnutChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTDoughnutChart> getDoughnutChartList() {
        1DoughnutChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DoughnutChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$46, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLayout getLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTLayout cTLayout = (CTLayout) get_store().find_element_user(LAYOUT$0, 0);
            if (cTLayout == null) {
                return null;
            }
            return cTLayout;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart getLine3DChartArray(int i) {
        CTLine3DChart cTLine3DChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChartFind_element_user = get_store().find_element_user(LINE3DCHART$8, i);
            if (cTLine3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLine3DChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart[] getLine3DChartArray() {
        CTLine3DChart[] cTLine3DChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LINE3DCHART$8, arrayList);
            cTLine3DChartArr = new CTLine3DChart[arrayList.size()];
            arrayList.toArray(cTLine3DChartArr);
        }
        return cTLine3DChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTLine3DChart> getLine3DChartList() {
        1Line3DChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Line3DChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart getLineChartArray(int i) {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().find_element_user(LINECHART$6, i);
            if (cTLineChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart[] getLineChartArray() {
        CTLineChart[] cTLineChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LINECHART$6, arrayList);
            cTLineChartArr = new CTLineChart[arrayList.size()];
            arrayList.toArray(cTLineChartArr);
        }
        return cTLineChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTLineChart> getLineChartList() {
        1LineChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LineChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart getOfPieChartArray(int i) {
        CTOfPieChart cTOfPieChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChartFind_element_user = get_store().find_element_user(OFPIECHART$26, i);
            if (cTOfPieChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOfPieChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart[] getOfPieChartArray() {
        CTOfPieChart[] cTOfPieChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OFPIECHART$26, arrayList);
            cTOfPieChartArr = new CTOfPieChart[arrayList.size()];
            arrayList.toArray(cTOfPieChartArr);
        }
        return cTOfPieChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTOfPieChart> getOfPieChartList() {
        1OfPieChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OfPieChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart getPie3DChartArray(int i) {
        CTPie3DChart cTPie3DChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChartFind_element_user = get_store().find_element_user(PIE3DCHART$18, i);
            if (cTPie3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPie3DChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart[] getPie3DChartArray() {
        CTPie3DChart[] cTPie3DChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PIE3DCHART$18, arrayList);
            cTPie3DChartArr = new CTPie3DChart[arrayList.size()];
            arrayList.toArray(cTPie3DChartArr);
        }
        return cTPie3DChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTPie3DChart> getPie3DChartList() {
        1Pie3DChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Pie3DChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart getPieChartArray(int i) {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().find_element_user(PIECHART$16, i);
            if (cTPieChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart[] getPieChartArray() {
        CTPieChart[] cTPieChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PIECHART$16, arrayList);
            cTPieChartArr = new CTPieChart[arrayList.size()];
            arrayList.toArray(cTPieChartArr);
        }
        return cTPieChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTPieChart> getPieChartList() {
        1PieChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PieChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart getRadarChartArray(int i) {
        CTRadarChart cTRadarChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChartFind_element_user = get_store().find_element_user(RADARCHART$12, i);
            if (cTRadarChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRadarChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart[] getRadarChartArray() {
        CTRadarChart[] cTRadarChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RADARCHART$12, arrayList);
            cTRadarChartArr = new CTRadarChart[arrayList.size()];
            arrayList.toArray(cTRadarChartArr);
        }
        return cTRadarChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTRadarChart> getRadarChartList() {
        1RadarChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RadarChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart getScatterChartArray(int i) {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().find_element_user(SCATTERCHART$14, i);
            if (cTScatterChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart[] getScatterChartArray() {
        CTScatterChart[] cTScatterChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCATTERCHART$14, arrayList);
            cTScatterChartArr = new CTScatterChart[arrayList.size()];
            arrayList.toArray(cTScatterChartArr);
        }
        return cTScatterChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTScatterChart> getScatterChartList() {
        1ScatterChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ScatterChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx getSerAxArray(int i) {
        CTSerAx cTSerAxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAxFind_element_user = get_store().find_element_user(SERAX$40, i);
            if (cTSerAxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSerAxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx[] getSerAxArray() {
        CTSerAx[] cTSerAxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SERAX$40, arrayList);
            cTSerAxArr = new CTSerAx[arrayList.size()];
            arrayList.toArray(cTSerAxArr);
        }
        return cTSerAxArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSerAx> getSerAxList() {
        1SerAxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SerAxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$44, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart getStockChartArray(int i) {
        CTStockChart cTStockChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartFind_element_user = get_store().find_element_user(STOCKCHART$10, i);
            if (cTStockChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStockChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart[] getStockChartArray() {
        CTStockChart[] cTStockChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STOCKCHART$10, arrayList);
            cTStockChartArr = new CTStockChart[arrayList.size()];
            arrayList.toArray(cTStockChartArr);
        }
        return cTStockChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTStockChart> getStockChartList() {
        1StockChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StockChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart getSurface3DChartArray(int i) {
        CTSurface3DChart cTSurface3DChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChartFind_element_user = get_store().find_element_user(SURFACE3DCHART$30, i);
            if (cTSurface3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSurface3DChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart[] getSurface3DChartArray() {
        CTSurface3DChart[] cTSurface3DChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SURFACE3DCHART$30, arrayList);
            cTSurface3DChartArr = new CTSurface3DChart[arrayList.size()];
            arrayList.toArray(cTSurface3DChartArr);
        }
        return cTSurface3DChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSurface3DChart> getSurface3DChartList() {
        1Surface3DChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Surface3DChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart getSurfaceChartArray(int i) {
        CTSurfaceChart cTSurfaceChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChartFind_element_user = get_store().find_element_user(SURFACECHART$28, i);
            if (cTSurfaceChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSurfaceChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart[] getSurfaceChartArray() {
        CTSurfaceChart[] cTSurfaceChartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SURFACECHART$28, arrayList);
            cTSurfaceChartArr = new CTSurfaceChart[arrayList.size()];
            arrayList.toArray(cTSurfaceChartArr);
        }
        return cTSurfaceChartArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSurfaceChart> getSurfaceChartList() {
        1SurfaceChartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SurfaceChartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx getValAxArray(int i) {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().find_element_user(VALAX$34, i);
            if (cTValAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx[] getValAxArray() {
        CTValAx[] cTValAxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VALAX$34, arrayList);
            cTValAxArr = new CTValAx[arrayList.size()];
            arrayList.toArray(cTValAxArr);
        }
        return cTValAxArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTValAx> getValAxList() {
        1ValAxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ValAxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart insertNewArea3DChart(int i) {
        CTArea3DChart cTArea3DChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChartInsert_element_user = get_store().insert_element_user(AREA3DCHART$4, i);
        }
        return cTArea3DChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart insertNewAreaChart(int i) {
        CTAreaChart cTAreaChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChartInsert_element_user = get_store().insert_element_user(AREACHART$2, i);
        }
        return cTAreaChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart insertNewBar3DChart(int i) {
        CTBar3DChart cTBar3DChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChartInsert_element_user = get_store().insert_element_user(BAR3DCHART$24, i);
        }
        return cTBar3DChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart insertNewBarChart(int i) {
        CTBarChart cTBarChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChartInsert_element_user = get_store().insert_element_user(BARCHART$22, i);
        }
        return cTBarChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart insertNewBubbleChart(int i) {
        CTBubbleChart cTBubbleChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChartInsert_element_user = get_store().insert_element_user(BUBBLECHART$32, i);
        }
        return cTBubbleChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx insertNewCatAx(int i) {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().insert_element_user(CATAX$36, i);
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx insertNewDateAx(int i) {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().insert_element_user(DATEAX$38, i);
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart insertNewDoughnutChart(int i) {
        CTDoughnutChart cTDoughnutChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChartInsert_element_user = get_store().insert_element_user(DOUGHNUTCHART$20, i);
        }
        return cTDoughnutChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart insertNewLine3DChart(int i) {
        CTLine3DChart cTLine3DChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChartInsert_element_user = get_store().insert_element_user(LINE3DCHART$8, i);
        }
        return cTLine3DChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart insertNewLineChart(int i) {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().insert_element_user(LINECHART$6, i);
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart insertNewOfPieChart(int i) {
        CTOfPieChart cTOfPieChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChartInsert_element_user = get_store().insert_element_user(OFPIECHART$26, i);
        }
        return cTOfPieChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart insertNewPie3DChart(int i) {
        CTPie3DChart cTPie3DChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChartInsert_element_user = get_store().insert_element_user(PIE3DCHART$18, i);
        }
        return cTPie3DChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart insertNewPieChart(int i) {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().insert_element_user(PIECHART$16, i);
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart insertNewRadarChart(int i) {
        CTRadarChart cTRadarChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChartInsert_element_user = get_store().insert_element_user(RADARCHART$12, i);
        }
        return cTRadarChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart insertNewScatterChart(int i) {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().insert_element_user(SCATTERCHART$14, i);
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx insertNewSerAx(int i) {
        CTSerAx cTSerAxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAxInsert_element_user = get_store().insert_element_user(SERAX$40, i);
        }
        return cTSerAxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart insertNewStockChart(int i) {
        CTStockChart cTStockChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartInsert_element_user = get_store().insert_element_user(STOCKCHART$10, i);
        }
        return cTStockChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart insertNewSurface3DChart(int i) {
        CTSurface3DChart cTSurface3DChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChartInsert_element_user = get_store().insert_element_user(SURFACE3DCHART$30, i);
        }
        return cTSurface3DChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart insertNewSurfaceChart(int i) {
        CTSurfaceChart cTSurfaceChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChartInsert_element_user = get_store().insert_element_user(SURFACECHART$28, i);
        }
        return cTSurfaceChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx insertNewValAx(int i) {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().insert_element_user(VALAX$34, i);
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetDTable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DTABLE$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LAYOUT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeArea3DChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AREA3DCHART$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeAreaChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AREACHART$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBar3DChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAR3DCHART$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBarChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BARCHART$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBubbleChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUBBLECHART$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeCatAx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CATAX$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeDateAx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATEAX$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeDoughnutChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOUGHNUTCHART$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeLine3DChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINE3DCHART$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeLineChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINECHART$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeOfPieChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OFPIECHART$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removePie3DChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIE3DCHART$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removePieChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIECHART$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeRadarChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RADARCHART$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeScatterChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCATTERCHART$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSerAx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SERAX$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeStockChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STOCKCHART$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSurface3DChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SURFACE3DCHART$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSurfaceChart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SURFACECHART$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeValAx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VALAX$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setArea3DChartArray(int i, CTArea3DChart cTArea3DChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTArea3DChart cTArea3DChartFind_element_user = get_store().find_element_user(AREA3DCHART$4, i);
            if (cTArea3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTArea3DChartFind_element_user.set(cTArea3DChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setArea3DChartArray(CTArea3DChart[] cTArea3DChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTArea3DChartArr, AREA3DCHART$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setAreaChartArray(int i, CTAreaChart cTAreaChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTAreaChart cTAreaChartFind_element_user = get_store().find_element_user(AREACHART$2, i);
            if (cTAreaChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAreaChartFind_element_user.set(cTAreaChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setAreaChartArray(CTAreaChart[] cTAreaChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAreaChartArr, AREACHART$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBar3DChartArray(int i, CTBar3DChart cTBar3DChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTBar3DChart cTBar3DChartFind_element_user = get_store().find_element_user(BAR3DCHART$24, i);
            if (cTBar3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBar3DChartFind_element_user.set(cTBar3DChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBar3DChartArray(CTBar3DChart[] cTBar3DChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBar3DChartArr, BAR3DCHART$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBarChartArray(int i, CTBarChart cTBarChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTBarChart cTBarChartFind_element_user = get_store().find_element_user(BARCHART$22, i);
            if (cTBarChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBarChartFind_element_user.set(cTBarChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBarChartArray(CTBarChart[] cTBarChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBarChartArr, BARCHART$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBubbleChartArray(int i, CTBubbleChart cTBubbleChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTBubbleChart cTBubbleChartFind_element_user = get_store().find_element_user(BUBBLECHART$32, i);
            if (cTBubbleChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBubbleChartFind_element_user.set(cTBubbleChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBubbleChartArray(CTBubbleChart[] cTBubbleChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBubbleChartArr, BUBBLECHART$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setCatAxArray(int i, CTCatAx cTCatAx) {
        synchronized (monitor()) {
            check_orphaned();
            CTCatAx cTCatAx2 = (CTCatAx) get_store().find_element_user(CATAX$36, i);
            if (cTCatAx2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCatAx2.set(cTCatAx);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setCatAxArray(CTCatAx[] cTCatAxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCatAxArr, CATAX$36);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDTable(CTDTable cTDTable) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DTABLE$42;
            CTDTable cTDTableFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDTableFind_element_user == null) {
                cTDTableFind_element_user = (CTDTable) get_store().add_element_user(qName);
            }
            cTDTableFind_element_user.set(cTDTable);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDateAxArray(int i, CTDateAx cTDateAx) {
        synchronized (monitor()) {
            check_orphaned();
            CTDateAx cTDateAx2 = (CTDateAx) get_store().find_element_user(DATEAX$38, i);
            if (cTDateAx2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDateAx2.set(cTDateAx);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDateAxArray(CTDateAx[] cTDateAxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDateAxArr, DATEAX$38);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDoughnutChartArray(int i, CTDoughnutChart cTDoughnutChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTDoughnutChart cTDoughnutChartFind_element_user = get_store().find_element_user(DOUGHNUTCHART$20, i);
            if (cTDoughnutChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDoughnutChartFind_element_user.set(cTDoughnutChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDoughnutChartArray(CTDoughnutChart[] cTDoughnutChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDoughnutChartArr, DOUGHNUTCHART$20);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$46;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLayout(CTLayout cTLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LAYOUT$0;
            CTLayout cTLayout2 = (CTLayout) typeStore.find_element_user(qName, 0);
            if (cTLayout2 == null) {
                cTLayout2 = (CTLayout) get_store().add_element_user(qName);
            }
            cTLayout2.set(cTLayout);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLine3DChartArray(int i, CTLine3DChart cTLine3DChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTLine3DChart cTLine3DChartFind_element_user = get_store().find_element_user(LINE3DCHART$8, i);
            if (cTLine3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLine3DChartFind_element_user.set(cTLine3DChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLine3DChartArray(CTLine3DChart[] cTLine3DChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLine3DChartArr, LINE3DCHART$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLineChartArray(int i, CTLineChart cTLineChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTLineChart cTLineChart2 = (CTLineChart) get_store().find_element_user(LINECHART$6, i);
            if (cTLineChart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLineChart2.set(cTLineChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLineChartArray(CTLineChart[] cTLineChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLineChartArr, LINECHART$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setOfPieChartArray(int i, CTOfPieChart cTOfPieChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTOfPieChart cTOfPieChartFind_element_user = get_store().find_element_user(OFPIECHART$26, i);
            if (cTOfPieChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOfPieChartFind_element_user.set(cTOfPieChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setOfPieChartArray(CTOfPieChart[] cTOfPieChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOfPieChartArr, OFPIECHART$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPie3DChartArray(int i, CTPie3DChart cTPie3DChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPie3DChart cTPie3DChartFind_element_user = get_store().find_element_user(PIE3DCHART$18, i);
            if (cTPie3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPie3DChartFind_element_user.set(cTPie3DChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPie3DChartArray(CTPie3DChart[] cTPie3DChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPie3DChartArr, PIE3DCHART$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPieChartArray(int i, CTPieChart cTPieChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPieChart cTPieChart2 = (CTPieChart) get_store().find_element_user(PIECHART$16, i);
            if (cTPieChart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPieChart2.set(cTPieChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPieChartArray(CTPieChart[] cTPieChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPieChartArr, PIECHART$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setRadarChartArray(int i, CTRadarChart cTRadarChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTRadarChart cTRadarChartFind_element_user = get_store().find_element_user(RADARCHART$12, i);
            if (cTRadarChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRadarChartFind_element_user.set(cTRadarChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setRadarChartArray(CTRadarChart[] cTRadarChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRadarChartArr, RADARCHART$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setScatterChartArray(int i, CTScatterChart cTScatterChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTScatterChart cTScatterChart2 = (CTScatterChart) get_store().find_element_user(SCATTERCHART$14, i);
            if (cTScatterChart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTScatterChart2.set(cTScatterChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setScatterChartArray(CTScatterChart[] cTScatterChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTScatterChartArr, SCATTERCHART$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSerAxArray(int i, CTSerAx cTSerAx) {
        synchronized (monitor()) {
            check_orphaned();
            CTSerAx cTSerAxFind_element_user = get_store().find_element_user(SERAX$40, i);
            if (cTSerAxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSerAxFind_element_user.set(cTSerAx);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSerAxArray(CTSerAx[] cTSerAxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSerAxArr, SERAX$40);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$44;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setStockChartArray(int i, CTStockChart cTStockChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTStockChart cTStockChartFind_element_user = get_store().find_element_user(STOCKCHART$10, i);
            if (cTStockChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStockChartFind_element_user.set(cTStockChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setStockChartArray(CTStockChart[] cTStockChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTStockChartArr, STOCKCHART$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurface3DChartArray(int i, CTSurface3DChart cTSurface3DChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTSurface3DChart cTSurface3DChartFind_element_user = get_store().find_element_user(SURFACE3DCHART$30, i);
            if (cTSurface3DChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSurface3DChartFind_element_user.set(cTSurface3DChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurface3DChartArray(CTSurface3DChart[] cTSurface3DChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSurface3DChartArr, SURFACE3DCHART$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurfaceChartArray(int i, CTSurfaceChart cTSurfaceChart) {
        synchronized (monitor()) {
            check_orphaned();
            CTSurfaceChart cTSurfaceChartFind_element_user = get_store().find_element_user(SURFACECHART$28, i);
            if (cTSurfaceChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSurfaceChartFind_element_user.set(cTSurfaceChart);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurfaceChartArray(CTSurfaceChart[] cTSurfaceChartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSurfaceChartArr, SURFACECHART$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setValAxArray(int i, CTValAx cTValAx) {
        synchronized (monitor()) {
            check_orphaned();
            CTValAx cTValAx2 = (CTValAx) get_store().find_element_user(VALAX$34, i);
            if (cTValAx2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTValAx2.set(cTValAx);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setValAxArray(CTValAx[] cTValAxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTValAxArr, VALAX$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfArea3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AREA3DCHART$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfAreaChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AREACHART$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBar3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BAR3DCHART$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBarChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BARCHART$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBubbleChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BUBBLECHART$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfCatAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CATAX$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfDateAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DATEAX$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfDoughnutChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DOUGHNUTCHART$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfLine3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LINE3DCHART$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfLineChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LINECHART$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfOfPieChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OFPIECHART$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfPie3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PIE3DCHART$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfPieChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PIECHART$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfRadarChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RADARCHART$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfScatterChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SCATTERCHART$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSerAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SERAX$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfStockChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STOCKCHART$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSurface3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SURFACE3DCHART$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSurfaceChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SURFACECHART$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfValAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(VALAX$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetDTable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DTABLE$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LAYOUT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$44, 0);
        }
    }
}

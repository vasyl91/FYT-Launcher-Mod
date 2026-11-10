package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartAxisFactory;
import org.apache.poi.ss.usermodel.charts.ChartData;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.charts.XSSFCategoryAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartDataFactory;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.apache.poi.xssf.usermodel.charts.XSSFDateAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFManualLayout;
import org.apache.poi.xssf.usermodel.charts.XSSFValueAxis;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFChart extends POIXMLDocumentPart implements Chart, ChartAxisFactory {
    List<XSSFChartAxis> axis;
    private CTChart chart;
    private CTChartSpace chartSpace;
    private XSSFGraphicFrame frame;

    @Override // org.apache.poi.ss.usermodel.Chart
    public XSSFChart getChartAxisFactory() {
        return this;
    }

    @Removal(version = "4.0")
    @Deprecated
    public void setTitle(String str) {
    }

    protected XSSFChart() {
        this.axis = new ArrayList();
        createChart();
    }

    protected XSSFChart(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        this.axis = new ArrayList();
        CTChartSpace chartSpace = ChartSpaceDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartSpace();
        this.chartSpace = chartSpace;
        this.chart = chartSpace.getChart();
    }

    private void createChart() {
        CTChartSpace cTChartSpaceNewInstance = CTChartSpace.Factory.newInstance();
        this.chartSpace = cTChartSpaceNewInstance;
        CTChart cTChartAddNewChart = cTChartSpaceNewInstance.addNewChart();
        this.chart = cTChartAddNewChart;
        cTChartAddNewChart.addNewPlotArea().addNewLayout();
        this.chart.addNewPlotVisOnly().setVal(true);
        CTPrintSettings cTPrintSettingsAddNewPrintSettings = this.chartSpace.addNewPrintSettings();
        cTPrintSettingsAddNewPrintSettings.addNewHeaderFooter();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTPrintSettingsAddNewPrintSettings.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setB(0.75d);
        cTPageMarginsAddNewPageMargins.setL(0.7d);
        cTPageMarginsAddNewPageMargins.setR(0.7d);
        cTPageMarginsAddNewPageMargins.setT(0.75d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPrintSettingsAddNewPrintSettings.addNewPageSetup();
    }

    @Internal
    public CTChartSpace getCTChartSpace() {
        return this.chartSpace;
    }

    @Internal
    public CTChart getCTChart() {
        return this.chart;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.chartSpace.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public XSSFGraphicFrame getGraphicFrame() {
        return this.frame;
    }

    protected void setGraphicFrame(XSSFGraphicFrame xSSFGraphicFrame) {
        this.frame = xSSFGraphicFrame;
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public XSSFChartDataFactory getChartDataFactory() {
        return XSSFChartDataFactory.getInstance();
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public void plot(ChartData chartData, ChartAxis... chartAxisArr) {
        chartData.fillChart(this, chartAxisArr);
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxisFactory
    public XSSFValueAxis createValueAxis(AxisPosition axisPosition) {
        XSSFValueAxis xSSFValueAxis = new XSSFValueAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            XSSFChartAxis xSSFChartAxis = this.axis.get(0);
            xSSFChartAxis.crossAxis(xSSFValueAxis);
            xSSFValueAxis.crossAxis(xSSFChartAxis);
        }
        this.axis.add(xSSFValueAxis);
        return xSSFValueAxis;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxisFactory
    public XSSFCategoryAxis createCategoryAxis(AxisPosition axisPosition) {
        XSSFCategoryAxis xSSFCategoryAxis = new XSSFCategoryAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            XSSFChartAxis xSSFChartAxis = this.axis.get(0);
            xSSFChartAxis.crossAxis(xSSFCategoryAxis);
            xSSFCategoryAxis.crossAxis(xSSFChartAxis);
        }
        this.axis.add(xSSFCategoryAxis);
        return xSSFCategoryAxis;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxisFactory
    public XSSFDateAxis createDateAxis(AxisPosition axisPosition) {
        XSSFDateAxis xSSFDateAxis = new XSSFDateAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            XSSFChartAxis xSSFChartAxis = this.axis.get(0);
            xSSFChartAxis.crossAxis(xSSFDateAxis);
            xSSFDateAxis.crossAxis(xSSFChartAxis);
        }
        this.axis.add(xSSFDateAxis);
        return xSSFDateAxis;
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public List<? extends XSSFChartAxis> getAxis() {
        if (this.axis.isEmpty() && hasAxis()) {
            parseAxis();
        }
        return this.axis;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ManuallyPositionable
    public XSSFManualLayout getManualLayout() {
        return new XSSFManualLayout(this);
    }

    public boolean isPlotOnlyVisibleCells() {
        return this.chart.getPlotVisOnly().getVal();
    }

    public void setPlotOnlyVisibleCells(boolean z) {
        this.chart.getPlotVisOnly().setVal(z);
    }

    @Removal(version = "4.0")
    @Deprecated
    public XSSFRichTextString getTitle() {
        return getTitleText();
    }

    public XSSFRichTextString getTitleText() {
        if (!this.chart.isSetTitle()) {
            return null;
        }
        CTTitle title = this.chart.getTitle();
        StringBuffer stringBuffer = new StringBuffer();
        for (XmlObject xmlObject : title.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t")) {
            NodeList childNodes = xmlObject.getDomNode().getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node nodeItem = childNodes.item(i);
                if (nodeItem instanceof Text) {
                    stringBuffer.append(nodeItem.getNodeValue());
                }
            }
        }
        return new XSSFRichTextString(stringBuffer.toString());
    }

    public void setTitleText(String str) {
        CTTitle cTTitleAddNewTitle;
        CTTx cTTxAddNewTx;
        CTTextBody cTTextBodyAddNewRich;
        CTTextParagraph cTTextParagraphAddNewP;
        if (this.chart.isSetTitle()) {
            cTTitleAddNewTitle = this.chart.getTitle();
        } else {
            cTTitleAddNewTitle = this.chart.addNewTitle();
        }
        if (cTTitleAddNewTitle.isSetTx()) {
            cTTxAddNewTx = cTTitleAddNewTitle.getTx();
        } else {
            cTTxAddNewTx = cTTitleAddNewTitle.addNewTx();
        }
        if (cTTxAddNewTx.isSetStrRef()) {
            cTTxAddNewTx.unsetStrRef();
        }
        if (cTTxAddNewTx.isSetRich()) {
            cTTextBodyAddNewRich = cTTxAddNewTx.getRich();
        } else {
            cTTextBodyAddNewRich = cTTxAddNewTx.addNewRich();
            cTTextBodyAddNewRich.addNewBodyPr();
        }
        if (cTTextBodyAddNewRich.sizeOfPArray() > 0) {
            cTTextParagraphAddNewP = cTTextBodyAddNewRich.getPArray(0);
        } else {
            cTTextParagraphAddNewP = cTTextBodyAddNewRich.addNewP();
        }
        if (cTTextParagraphAddNewP.sizeOfRArray() > 0) {
            cTTextParagraphAddNewP.getRArray(0).setT(str);
        } else if (cTTextParagraphAddNewP.sizeOfFldArray() > 0) {
            cTTextParagraphAddNewP.getFldArray(0).setT(str);
        } else {
            cTTextParagraphAddNewP.addNewR().setT(str);
        }
    }

    public String getTitleFormula() {
        if (!this.chart.isSetTitle()) {
            return null;
        }
        CTTitle title = this.chart.getTitle();
        if (!title.isSetTx()) {
            return null;
        }
        CTTx tx = title.getTx();
        if (tx.isSetStrRef()) {
            return tx.getStrRef().getF();
        }
        return null;
    }

    public void setTitleFormula(String str) {
        CTTitle cTTitleAddNewTitle;
        CTTx cTTxAddNewTx;
        CTStrRef cTStrRefAddNewStrRef;
        if (this.chart.isSetTitle()) {
            cTTitleAddNewTitle = this.chart.getTitle();
        } else {
            cTTitleAddNewTitle = this.chart.addNewTitle();
        }
        if (cTTitleAddNewTitle.isSetTx()) {
            cTTxAddNewTx = cTTitleAddNewTitle.getTx();
        } else {
            cTTxAddNewTx = cTTitleAddNewTitle.addNewTx();
        }
        if (cTTxAddNewTx.isSetRich()) {
            cTTxAddNewTx.unsetRich();
        }
        if (cTTxAddNewTx.isSetStrRef()) {
            cTStrRefAddNewStrRef = cTTxAddNewTx.getStrRef();
        } else {
            cTStrRefAddNewStrRef = cTTxAddNewTx.addNewStrRef();
        }
        cTStrRefAddNewStrRef.setF(str);
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public XSSFChartLegend getOrCreateLegend() {
        return new XSSFChartLegend(this);
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public void deleteLegend() {
        if (this.chart.isSetLegend()) {
            this.chart.unsetLegend();
        }
    }

    private boolean hasAxis() {
        CTPlotArea plotArea = this.chart.getPlotArea();
        return ((plotArea.sizeOfValAxArray() + plotArea.sizeOfCatAxArray()) + plotArea.sizeOfDateAxArray()) + plotArea.sizeOfSerAxArray() > 0;
    }

    private void parseAxis() {
        parseCategoryAxis();
        parseDateAxis();
        parseValueAxis();
    }

    private void parseCategoryAxis() {
        for (CTCatAx cTCatAx : this.chart.getPlotArea().getCatAxArray()) {
            this.axis.add(new XSSFCategoryAxis(this, cTCatAx));
        }
    }

    private void parseDateAxis() {
        for (CTDateAx cTDateAx : this.chart.getPlotArea().getDateAxArray()) {
            this.axis.add(new XSSFDateAxis(this, cTDateAx));
        }
    }

    private void parseValueAxis() {
        for (CTValAx cTValAx : this.chart.getPlotArea().getValAxArray()) {
            this.axis.add(new XSSFValueAxis(this, cTValAx));
        }
    }
}

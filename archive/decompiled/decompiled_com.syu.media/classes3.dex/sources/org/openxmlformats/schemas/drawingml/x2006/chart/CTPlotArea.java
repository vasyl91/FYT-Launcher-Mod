package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPlotArea extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPlotArea.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctplotarea106etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPlotArea newInstance() {
            return (CTPlotArea) POIXMLTypeLoader.newInstance(CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea newInstance(XmlOptions xmlOptions) {
            return (CTPlotArea) POIXMLTypeLoader.newInstance(CTPlotArea.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPlotArea.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(File file) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(file, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(file, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(inputStream, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(inputStream, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(Reader reader) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(reader, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(reader, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(String str) throws XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(str, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(str, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(URL url) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(url, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlotArea) POIXMLTypeLoader.parse(url, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(xMLStreamReader, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(xMLStreamReader, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(xMLInputStream, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(xMLInputStream, CTPlotArea.type, xmlOptions);
        }

        public static CTPlotArea parse(Node node) throws XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(node, CTPlotArea.type, (XmlOptions) null);
        }

        public static CTPlotArea parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPlotArea) POIXMLTypeLoader.parse(node, CTPlotArea.type, xmlOptions);
        }
    }

    CTArea3DChart addNewArea3DChart();

    CTAreaChart addNewAreaChart();

    CTBar3DChart addNewBar3DChart();

    CTBarChart addNewBarChart();

    CTBubbleChart addNewBubbleChart();

    CTCatAx addNewCatAx();

    CTDTable addNewDTable();

    CTDateAx addNewDateAx();

    CTDoughnutChart addNewDoughnutChart();

    CTExtensionList addNewExtLst();

    CTLayout addNewLayout();

    CTLine3DChart addNewLine3DChart();

    CTLineChart addNewLineChart();

    CTOfPieChart addNewOfPieChart();

    CTPie3DChart addNewPie3DChart();

    CTPieChart addNewPieChart();

    CTRadarChart addNewRadarChart();

    CTScatterChart addNewScatterChart();

    CTSerAx addNewSerAx();

    CTShapeProperties addNewSpPr();

    CTStockChart addNewStockChart();

    CTSurface3DChart addNewSurface3DChart();

    CTSurfaceChart addNewSurfaceChart();

    CTValAx addNewValAx();

    CTArea3DChart getArea3DChartArray(int i);

    CTArea3DChart[] getArea3DChartArray();

    List<CTArea3DChart> getArea3DChartList();

    CTAreaChart getAreaChartArray(int i);

    CTAreaChart[] getAreaChartArray();

    List<CTAreaChart> getAreaChartList();

    CTBar3DChart getBar3DChartArray(int i);

    CTBar3DChart[] getBar3DChartArray();

    List<CTBar3DChart> getBar3DChartList();

    CTBarChart getBarChartArray(int i);

    CTBarChart[] getBarChartArray();

    List<CTBarChart> getBarChartList();

    CTBubbleChart getBubbleChartArray(int i);

    CTBubbleChart[] getBubbleChartArray();

    List<CTBubbleChart> getBubbleChartList();

    CTCatAx getCatAxArray(int i);

    CTCatAx[] getCatAxArray();

    List<CTCatAx> getCatAxList();

    CTDTable getDTable();

    CTDateAx getDateAxArray(int i);

    CTDateAx[] getDateAxArray();

    List<CTDateAx> getDateAxList();

    CTDoughnutChart getDoughnutChartArray(int i);

    CTDoughnutChart[] getDoughnutChartArray();

    List<CTDoughnutChart> getDoughnutChartList();

    CTExtensionList getExtLst();

    CTLayout getLayout();

    CTLine3DChart getLine3DChartArray(int i);

    CTLine3DChart[] getLine3DChartArray();

    List<CTLine3DChart> getLine3DChartList();

    CTLineChart getLineChartArray(int i);

    CTLineChart[] getLineChartArray();

    List<CTLineChart> getLineChartList();

    CTOfPieChart getOfPieChartArray(int i);

    CTOfPieChart[] getOfPieChartArray();

    List<CTOfPieChart> getOfPieChartList();

    CTPie3DChart getPie3DChartArray(int i);

    CTPie3DChart[] getPie3DChartArray();

    List<CTPie3DChart> getPie3DChartList();

    CTPieChart getPieChartArray(int i);

    CTPieChart[] getPieChartArray();

    List<CTPieChart> getPieChartList();

    CTRadarChart getRadarChartArray(int i);

    CTRadarChart[] getRadarChartArray();

    List<CTRadarChart> getRadarChartList();

    CTScatterChart getScatterChartArray(int i);

    CTScatterChart[] getScatterChartArray();

    List<CTScatterChart> getScatterChartList();

    CTSerAx getSerAxArray(int i);

    CTSerAx[] getSerAxArray();

    List<CTSerAx> getSerAxList();

    CTShapeProperties getSpPr();

    CTStockChart getStockChartArray(int i);

    CTStockChart[] getStockChartArray();

    List<CTStockChart> getStockChartList();

    CTSurface3DChart getSurface3DChartArray(int i);

    CTSurface3DChart[] getSurface3DChartArray();

    List<CTSurface3DChart> getSurface3DChartList();

    CTSurfaceChart getSurfaceChartArray(int i);

    CTSurfaceChart[] getSurfaceChartArray();

    List<CTSurfaceChart> getSurfaceChartList();

    CTValAx getValAxArray(int i);

    CTValAx[] getValAxArray();

    List<CTValAx> getValAxList();

    CTArea3DChart insertNewArea3DChart(int i);

    CTAreaChart insertNewAreaChart(int i);

    CTBar3DChart insertNewBar3DChart(int i);

    CTBarChart insertNewBarChart(int i);

    CTBubbleChart insertNewBubbleChart(int i);

    CTCatAx insertNewCatAx(int i);

    CTDateAx insertNewDateAx(int i);

    CTDoughnutChart insertNewDoughnutChart(int i);

    CTLine3DChart insertNewLine3DChart(int i);

    CTLineChart insertNewLineChart(int i);

    CTOfPieChart insertNewOfPieChart(int i);

    CTPie3DChart insertNewPie3DChart(int i);

    CTPieChart insertNewPieChart(int i);

    CTRadarChart insertNewRadarChart(int i);

    CTScatterChart insertNewScatterChart(int i);

    CTSerAx insertNewSerAx(int i);

    CTStockChart insertNewStockChart(int i);

    CTSurface3DChart insertNewSurface3DChart(int i);

    CTSurfaceChart insertNewSurfaceChart(int i);

    CTValAx insertNewValAx(int i);

    boolean isSetDTable();

    boolean isSetExtLst();

    boolean isSetLayout();

    boolean isSetSpPr();

    void removeArea3DChart(int i);

    void removeAreaChart(int i);

    void removeBar3DChart(int i);

    void removeBarChart(int i);

    void removeBubbleChart(int i);

    void removeCatAx(int i);

    void removeDateAx(int i);

    void removeDoughnutChart(int i);

    void removeLine3DChart(int i);

    void removeLineChart(int i);

    void removeOfPieChart(int i);

    void removePie3DChart(int i);

    void removePieChart(int i);

    void removeRadarChart(int i);

    void removeScatterChart(int i);

    void removeSerAx(int i);

    void removeStockChart(int i);

    void removeSurface3DChart(int i);

    void removeSurfaceChart(int i);

    void removeValAx(int i);

    void setArea3DChartArray(int i, CTArea3DChart cTArea3DChart);

    void setArea3DChartArray(CTArea3DChart[] cTArea3DChartArr);

    void setAreaChartArray(int i, CTAreaChart cTAreaChart);

    void setAreaChartArray(CTAreaChart[] cTAreaChartArr);

    void setBar3DChartArray(int i, CTBar3DChart cTBar3DChart);

    void setBar3DChartArray(CTBar3DChart[] cTBar3DChartArr);

    void setBarChartArray(int i, CTBarChart cTBarChart);

    void setBarChartArray(CTBarChart[] cTBarChartArr);

    void setBubbleChartArray(int i, CTBubbleChart cTBubbleChart);

    void setBubbleChartArray(CTBubbleChart[] cTBubbleChartArr);

    void setCatAxArray(int i, CTCatAx cTCatAx);

    void setCatAxArray(CTCatAx[] cTCatAxArr);

    void setDTable(CTDTable cTDTable);

    void setDateAxArray(int i, CTDateAx cTDateAx);

    void setDateAxArray(CTDateAx[] cTDateAxArr);

    void setDoughnutChartArray(int i, CTDoughnutChart cTDoughnutChart);

    void setDoughnutChartArray(CTDoughnutChart[] cTDoughnutChartArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setLayout(CTLayout cTLayout);

    void setLine3DChartArray(int i, CTLine3DChart cTLine3DChart);

    void setLine3DChartArray(CTLine3DChart[] cTLine3DChartArr);

    void setLineChartArray(int i, CTLineChart cTLineChart);

    void setLineChartArray(CTLineChart[] cTLineChartArr);

    void setOfPieChartArray(int i, CTOfPieChart cTOfPieChart);

    void setOfPieChartArray(CTOfPieChart[] cTOfPieChartArr);

    void setPie3DChartArray(int i, CTPie3DChart cTPie3DChart);

    void setPie3DChartArray(CTPie3DChart[] cTPie3DChartArr);

    void setPieChartArray(int i, CTPieChart cTPieChart);

    void setPieChartArray(CTPieChart[] cTPieChartArr);

    void setRadarChartArray(int i, CTRadarChart cTRadarChart);

    void setRadarChartArray(CTRadarChart[] cTRadarChartArr);

    void setScatterChartArray(int i, CTScatterChart cTScatterChart);

    void setScatterChartArray(CTScatterChart[] cTScatterChartArr);

    void setSerAxArray(int i, CTSerAx cTSerAx);

    void setSerAxArray(CTSerAx[] cTSerAxArr);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStockChartArray(int i, CTStockChart cTStockChart);

    void setStockChartArray(CTStockChart[] cTStockChartArr);

    void setSurface3DChartArray(int i, CTSurface3DChart cTSurface3DChart);

    void setSurface3DChartArray(CTSurface3DChart[] cTSurface3DChartArr);

    void setSurfaceChartArray(int i, CTSurfaceChart cTSurfaceChart);

    void setSurfaceChartArray(CTSurfaceChart[] cTSurfaceChartArr);

    void setValAxArray(int i, CTValAx cTValAx);

    void setValAxArray(CTValAx[] cTValAxArr);

    int sizeOfArea3DChartArray();

    int sizeOfAreaChartArray();

    int sizeOfBar3DChartArray();

    int sizeOfBarChartArray();

    int sizeOfBubbleChartArray();

    int sizeOfCatAxArray();

    int sizeOfDateAxArray();

    int sizeOfDoughnutChartArray();

    int sizeOfLine3DChartArray();

    int sizeOfLineChartArray();

    int sizeOfOfPieChartArray();

    int sizeOfPie3DChartArray();

    int sizeOfPieChartArray();

    int sizeOfRadarChartArray();

    int sizeOfScatterChartArray();

    int sizeOfSerAxArray();

    int sizeOfStockChartArray();

    int sizeOfSurface3DChartArray();

    int sizeOfSurfaceChartArray();

    int sizeOfValAxArray();

    void unsetDTable();

    void unsetExtLst();

    void unsetLayout();

    void unsetSpPr();
}

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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTLineChart extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLineChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinechart249ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineChart newInstance() {
            return (CTLineChart) POIXMLTypeLoader.newInstance(CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart newInstance(XmlOptions xmlOptions) {
            return (CTLineChart) POIXMLTypeLoader.newInstance(CTLineChart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineChart.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(File file) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(file, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(file, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(inputStream, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(inputStream, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(Reader reader) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(reader, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(reader, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(String str) throws XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(str, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(str, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(URL url) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(url, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineChart) POIXMLTypeLoader.parse(url, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(xMLStreamReader, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(xMLStreamReader, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(xMLInputStream, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(xMLInputStream, CTLineChart.type, xmlOptions);
        }

        public static CTLineChart parse(Node node) throws XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(node, CTLineChart.type, (XmlOptions) null);
        }

        public static CTLineChart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineChart) POIXMLTypeLoader.parse(node, CTLineChart.type, xmlOptions);
        }
    }

    CTUnsignedInt addNewAxId();

    CTDLbls addNewDLbls();

    CTChartLines addNewDropLines();

    CTExtensionList addNewExtLst();

    CTGrouping addNewGrouping();

    CTChartLines addNewHiLowLines();

    CTBoolean addNewMarker();

    CTLineSer addNewSer();

    CTBoolean addNewSmooth();

    CTUpDownBars addNewUpDownBars();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTDLbls getDLbls();

    CTChartLines getDropLines();

    CTExtensionList getExtLst();

    CTGrouping getGrouping();

    CTChartLines getHiLowLines();

    CTBoolean getMarker();

    CTLineSer getSerArray(int i);

    CTLineSer[] getSerArray();

    List<CTLineSer> getSerList();

    CTBoolean getSmooth();

    CTUpDownBars getUpDownBars();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i);

    CTLineSer insertNewSer(int i);

    boolean isSetDLbls();

    boolean isSetDropLines();

    boolean isSetExtLst();

    boolean isSetHiLowLines();

    boolean isSetMarker();

    boolean isSetSmooth();

    boolean isSetUpDownBars();

    boolean isSetVaryColors();

    void removeAxId(int i);

    void removeSer(int i);

    void setAxIdArray(int i, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setDLbls(CTDLbls cTDLbls);

    void setDropLines(CTChartLines cTChartLines);

    void setExtLst(CTExtensionList cTExtensionList);

    void setGrouping(CTGrouping cTGrouping);

    void setHiLowLines(CTChartLines cTChartLines);

    void setMarker(CTBoolean cTBoolean);

    void setSerArray(int i, CTLineSer cTLineSer);

    void setSerArray(CTLineSer[] cTLineSerArr);

    void setSmooth(CTBoolean cTBoolean);

    void setUpDownBars(CTUpDownBars cTUpDownBars);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetDropLines();

    void unsetExtLst();

    void unsetHiLowLines();

    void unsetMarker();

    void unsetSmooth();

    void unsetUpDownBars();

    void unsetVaryColors();
}

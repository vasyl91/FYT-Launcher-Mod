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
public interface CTPieChart extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPieChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpiechartd34atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPieChart newInstance() {
            return (CTPieChart) POIXMLTypeLoader.newInstance(CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart newInstance(XmlOptions xmlOptions) {
            return (CTPieChart) POIXMLTypeLoader.newInstance(CTPieChart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPieChart.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(File file) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(file, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(file, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(inputStream, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(inputStream, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(Reader reader) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(reader, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(reader, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(String str) throws XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(str, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(str, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(URL url) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(url, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieChart) POIXMLTypeLoader.parse(url, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(xMLStreamReader, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(xMLStreamReader, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(xMLInputStream, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(xMLInputStream, CTPieChart.type, xmlOptions);
        }

        public static CTPieChart parse(Node node) throws XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(node, CTPieChart.type, (XmlOptions) null);
        }

        public static CTPieChart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPieChart) POIXMLTypeLoader.parse(node, CTPieChart.type, xmlOptions);
        }
    }

    CTDLbls addNewDLbls();

    CTExtensionList addNewExtLst();

    CTFirstSliceAng addNewFirstSliceAng();

    CTPieSer addNewSer();

    CTBoolean addNewVaryColors();

    CTDLbls getDLbls();

    CTExtensionList getExtLst();

    CTFirstSliceAng getFirstSliceAng();

    CTPieSer getSerArray(int i);

    CTPieSer[] getSerArray();

    List<CTPieSer> getSerList();

    CTBoolean getVaryColors();

    CTPieSer insertNewSer(int i);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetFirstSliceAng();

    boolean isSetVaryColors();

    void removeSer(int i);

    void setDLbls(CTDLbls cTDLbls);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFirstSliceAng(CTFirstSliceAng cTFirstSliceAng);

    void setSerArray(int i, CTPieSer cTPieSer);

    void setSerArray(CTPieSer[] cTPieSerArr);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetFirstSliceAng();

    void unsetVaryColors();
}

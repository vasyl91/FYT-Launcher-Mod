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
public interface CTScatterChart extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTScatterChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctscatterchart2bfctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTScatterChart newInstance() {
            return (CTScatterChart) POIXMLTypeLoader.newInstance(CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart newInstance(XmlOptions xmlOptions) {
            return (CTScatterChart) POIXMLTypeLoader.newInstance(CTScatterChart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTScatterChart.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(File file) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(file, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(file, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(inputStream, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(inputStream, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(Reader reader) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(reader, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(reader, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(String str) throws XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(str, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(str, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(URL url) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(url, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterChart) POIXMLTypeLoader.parse(url, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(xMLStreamReader, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(xMLStreamReader, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(xMLInputStream, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(xMLInputStream, CTScatterChart.type, xmlOptions);
        }

        public static CTScatterChart parse(Node node) throws XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(node, CTScatterChart.type, (XmlOptions) null);
        }

        public static CTScatterChart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterChart) POIXMLTypeLoader.parse(node, CTScatterChart.type, xmlOptions);
        }
    }

    CTUnsignedInt addNewAxId();

    CTDLbls addNewDLbls();

    CTExtensionList addNewExtLst();

    CTScatterStyle addNewScatterStyle();

    CTScatterSer addNewSer();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTDLbls getDLbls();

    CTExtensionList getExtLst();

    CTScatterStyle getScatterStyle();

    CTScatterSer getSerArray(int i);

    CTScatterSer[] getSerArray();

    List<CTScatterSer> getSerList();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i);

    CTScatterSer insertNewSer(int i);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetVaryColors();

    void removeAxId(int i);

    void removeSer(int i);

    void setAxIdArray(int i, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setDLbls(CTDLbls cTDLbls);

    void setExtLst(CTExtensionList cTExtensionList);

    void setScatterStyle(CTScatterStyle cTScatterStyle);

    void setSerArray(int i, CTScatterSer cTScatterSer);

    void setSerArray(CTScatterSer[] cTScatterSerArr);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetVaryColors();
}

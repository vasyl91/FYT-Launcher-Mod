package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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
public interface ChartSpaceDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ChartSpaceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("chartspace36e0doctype");

    public static final class Factory {
        private Factory() {
        }

        public static ChartSpaceDocument newInstance() {
            return (ChartSpaceDocument) POIXMLTypeLoader.newInstance(ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument newInstance(XmlOptions xmlOptions) {
            return (ChartSpaceDocument) POIXMLTypeLoader.newInstance(ChartSpaceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(File file) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(file, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(file, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(inputStream, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(inputStream, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(Reader reader) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(reader, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(reader, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(String str) throws XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(str, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(str, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(URL url) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(url, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(url, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(xMLStreamReader, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(xMLStreamReader, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(xMLInputStream, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(xMLInputStream, ChartSpaceDocument.type, xmlOptions);
        }

        public static ChartSpaceDocument parse(Node node) throws XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(node, ChartSpaceDocument.type, (XmlOptions) null);
        }

        public static ChartSpaceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ChartSpaceDocument) POIXMLTypeLoader.parse(node, ChartSpaceDocument.type, xmlOptions);
        }
    }

    CTChartSpace addNewChartSpace();

    CTChartSpace getChartSpace();

    void setChartSpace(CTChartSpace cTChartSpace);
}

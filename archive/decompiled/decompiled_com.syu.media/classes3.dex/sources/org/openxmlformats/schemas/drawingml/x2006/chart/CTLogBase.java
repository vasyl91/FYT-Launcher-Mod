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
public interface CTLogBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLogBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlogbase9191type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLogBase newInstance() {
            return (CTLogBase) POIXMLTypeLoader.newInstance(CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase newInstance(XmlOptions xmlOptions) {
            return (CTLogBase) POIXMLTypeLoader.newInstance(CTLogBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLogBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(File file) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(file, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(file, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(inputStream, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(inputStream, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(Reader reader) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(reader, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(reader, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(String str) throws XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(str, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(str, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(URL url) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(url, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) POIXMLTypeLoader.parse(url, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(xMLStreamReader, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(xMLStreamReader, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(xMLInputStream, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(xMLInputStream, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(Node node) throws XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(node, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLogBase) POIXMLTypeLoader.parse(node, CTLogBase.type, xmlOptions);
        }
    }

    double getVal();

    void setVal(double d);

    STLogBase xgetVal();

    void xsetVal(STLogBase sTLogBase);
}

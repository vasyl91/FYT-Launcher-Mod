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
public interface CTCrosses extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCrosses.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcrossesbcb8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCrosses newInstance() {
            return (CTCrosses) POIXMLTypeLoader.newInstance(CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses newInstance(XmlOptions xmlOptions) {
            return (CTCrosses) POIXMLTypeLoader.newInstance(CTCrosses.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCrosses.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(File file) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(file, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(file, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(inputStream, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(inputStream, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(Reader reader) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(reader, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(reader, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(String str) throws XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(str, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(str, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(URL url) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(url, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) POIXMLTypeLoader.parse(url, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(xMLStreamReader, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(xMLStreamReader, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(xMLInputStream, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(xMLInputStream, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(Node node) throws XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(node, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCrosses) POIXMLTypeLoader.parse(node, CTCrosses.type, xmlOptions);
        }
    }

    STCrosses.Enum getVal();

    void setVal(STCrosses.Enum r1);

    STCrosses xgetVal();

    void xsetVal(STCrosses sTCrosses);
}

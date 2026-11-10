package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STTextMargin extends STCoordinate32 {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextMargin.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextmargin9666type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextMargin newInstance() {
            return POIXMLTypeLoader.newInstance(STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextMargin.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin newValue(Object obj) {
            return STTextMargin.type.newValue(obj);
        }

        public static STTextMargin parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextMargin.type, xmlOptions);
        }
    }
}

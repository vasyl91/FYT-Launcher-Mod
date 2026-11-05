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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STTextPoint extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextpoint4284type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextPoint newInstance() {
            return POIXMLTypeLoader.newInstance(STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint newValue(Object obj) {
            return STTextPoint.type.newValue(obj);
        }

        public static STTextPoint parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextPoint.type, xmlOptions);
        }
    }
}

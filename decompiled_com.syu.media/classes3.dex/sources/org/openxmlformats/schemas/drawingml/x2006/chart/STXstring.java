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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STXstring extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STXstring.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stxstringb8cdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STXstring newInstance() {
            return POIXMLTypeLoader.newInstance(STXstring.type, (XmlOptions) null);
        }

        public static STXstring newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STXstring.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STXstring.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STXstring.type, xmlOptions);
        }

        public static STXstring newValue(Object obj) {
            return STXstring.type.newValue(obj);
        }

        public static STXstring parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STXstring.type, xmlOptions);
        }

        public static STXstring parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STXstring.type, xmlOptions);
        }

        public static STXstring parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STXstring.type, xmlOptions);
        }

        public static STXstring parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STXstring.type, xmlOptions);
        }

        public static STXstring parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STXstring.type, xmlOptions);
        }

        public static STXstring parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STXstring.type, xmlOptions);
        }

        public static STXstring parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STXstring.type, xmlOptions);
        }

        public static STXstring parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STXstring.type, xmlOptions);
        }
    }
}

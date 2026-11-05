package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STLangCode extends XmlHexBinary {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLangCode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlangcode02bdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STLangCode newInstance() {
            return POIXMLTypeLoader.newInstance(STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLangCode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLangCode.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLangCode.type, xmlOptions);
        }

        public static STLangCode newValue(Object obj) {
            return STLangCode.type.newValue(obj);
        }

        public static STLangCode parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLangCode.type, xmlOptions);
        }
    }
}

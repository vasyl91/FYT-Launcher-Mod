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
public interface STLongHexNumber extends XmlHexBinary {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLongHexNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlonghexnumberd6batype");

    public static final class Factory {
        private Factory() {
        }

        public static STLongHexNumber newInstance() {
            return POIXMLTypeLoader.newInstance(STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLongHexNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber newValue(Object obj) {
            return STLongHexNumber.type.newValue(obj);
        }

        public static STLongHexNumber parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLongHexNumber.type, xmlOptions);
        }
    }
}

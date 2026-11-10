package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STUnsignedShortHex extends XmlHexBinary {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STUnsignedShortHex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunsignedshorthex0bedtype");

    public static final class Factory {
        private Factory() {
        }

        public static STUnsignedShortHex newInstance() {
            return POIXMLTypeLoader.newInstance(STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STUnsignedShortHex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex newValue(Object obj) {
            return STUnsignedShortHex.type.newValue(obj);
        }

        public static STUnsignedShortHex parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STUnsignedShortHex.type, xmlOptions);
        }
    }
}

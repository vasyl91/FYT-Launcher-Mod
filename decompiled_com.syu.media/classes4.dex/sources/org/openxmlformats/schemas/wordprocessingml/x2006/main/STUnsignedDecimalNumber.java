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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STUnsignedDecimalNumber extends XmlUnsignedLong {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STUnsignedDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunsigneddecimalnumber74fdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STUnsignedDecimalNumber newInstance() {
            return POIXMLTypeLoader.newInstance(STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber newValue(Object obj) {
            return STUnsignedDecimalNumber.type.newValue(obj);
        }

        public static STUnsignedDecimalNumber parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STUnsignedDecimalNumber.type, xmlOptions);
        }
    }
}

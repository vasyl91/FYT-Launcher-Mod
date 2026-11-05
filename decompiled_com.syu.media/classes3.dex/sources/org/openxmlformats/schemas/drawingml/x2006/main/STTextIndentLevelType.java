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
public interface STTextIndentLevelType extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextIndentLevelType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextindentleveltypeaf86type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextIndentLevelType newInstance() {
            return POIXMLTypeLoader.newInstance(STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextIndentLevelType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType newValue(Object obj) {
            return STTextIndentLevelType.type.newValue(obj);
        }

        public static STTextIndentLevelType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextIndentLevelType.type, xmlOptions);
        }
    }
}

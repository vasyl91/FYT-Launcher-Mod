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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STGuid extends XmlToken {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STGuid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stguidd0f4type");

    public static final class Factory {
        private Factory() {
        }

        public static STGuid newInstance() {
            return POIXMLTypeLoader.newInstance(STGuid.type, (XmlOptions) null);
        }

        public static STGuid newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STGuid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGuid.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGuid.type, xmlOptions);
        }

        public static STGuid newValue(Object obj) {
            return STGuid.type.newValue(obj);
        }

        public static STGuid parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STGuid.type, xmlOptions);
        }

        public static STGuid parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STGuid.type, xmlOptions);
        }

        public static STGuid parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STGuid.type, xmlOptions);
        }

        public static STGuid parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STGuid.type, xmlOptions);
        }

        public static STGuid parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STGuid.type, xmlOptions);
        }

        public static STGuid parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STGuid.type, xmlOptions);
        }

        public static STGuid parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STGuid.type, xmlOptions);
        }

        public static STGuid parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STGuid.type, xmlOptions);
        }
    }
}

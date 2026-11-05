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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STRef extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stref90a2type");

    public static final class Factory {
        private Factory() {
        }

        public static STRef newInstance() {
            return POIXMLTypeLoader.newInstance(STRef.type, (XmlOptions) null);
        }

        public static STRef newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STRef.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STRef.type, xmlOptions);
        }

        public static STRef newValue(Object obj) {
            return STRef.type.newValue(obj);
        }

        public static STRef parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STRef.type, xmlOptions);
        }

        public static STRef parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STRef.type, xmlOptions);
        }

        public static STRef parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STRef.type, xmlOptions);
        }

        public static STRef parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STRef.type, xmlOptions);
        }

        public static STRef parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STRef.type, xmlOptions);
        }

        public static STRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STRef.type, xmlOptions);
        }

        public static STRef parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STRef.type, xmlOptions);
        }

        public static STRef parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STRef.type, xmlOptions);
        }
    }
}

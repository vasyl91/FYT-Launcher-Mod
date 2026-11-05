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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STString extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STString.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststringa627type");

    public static final class Factory {
        private Factory() {
        }

        public static STString newInstance() {
            return POIXMLTypeLoader.newInstance(STString.type, (XmlOptions) null);
        }

        public static STString newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STString.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STString.type, xmlOptions);
        }

        public static STString newValue(Object obj) {
            return STString.type.newValue(obj);
        }

        public static STString parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STString.type, (XmlOptions) null);
        }

        public static STString parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STString.type, xmlOptions);
        }

        public static STString parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STString.type, (XmlOptions) null);
        }

        public static STString parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STString.type, xmlOptions);
        }

        public static STString parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STString.type, (XmlOptions) null);
        }

        public static STString parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STString.type, xmlOptions);
        }

        public static STString parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STString.type, (XmlOptions) null);
        }

        public static STString parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STString.type, xmlOptions);
        }

        public static STString parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STString.type, (XmlOptions) null);
        }

        public static STString parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STString.type, xmlOptions);
        }

        public static STString parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STString.type, (XmlOptions) null);
        }

        public static STString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STString.type, xmlOptions);
        }

        public static STString parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STString.type, (XmlOptions) null);
        }

        public static STString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STString.type, xmlOptions);
        }

        public static STString parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STString.type, (XmlOptions) null);
        }

        public static STString parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STString.type, xmlOptions);
        }
    }
}

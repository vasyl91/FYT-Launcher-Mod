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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STLineWidth extends STCoordinate32 {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLineWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlinewidth8313type");

    public static final class Factory {
        private Factory() {
        }

        public static STLineWidth newInstance() {
            return POIXMLTypeLoader.newInstance(STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLineWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth newValue(Object obj) {
            return STLineWidth.type.newValue(obj);
        }

        public static STLineWidth parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLineWidth.type, xmlOptions);
        }
    }
}

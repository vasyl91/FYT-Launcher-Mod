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
public interface STGeomGuideName extends XmlToken {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STGeomGuideName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stgeomguidename366ctype");

    public static final class Factory {
        private Factory() {
        }

        public static STGeomGuideName newInstance() {
            return POIXMLTypeLoader.newInstance(STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STGeomGuideName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName newValue(Object obj) {
            return STGeomGuideName.type.newValue(obj);
        }

        public static STGeomGuideName parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STGeomGuideName.type, xmlOptions);
        }
    }
}

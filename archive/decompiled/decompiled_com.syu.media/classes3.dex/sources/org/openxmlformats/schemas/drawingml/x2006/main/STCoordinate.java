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
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STCoordinate extends XmlLong {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcoordinatefae3type");

    public static final class Factory {
        private Factory() {
        }

        public static STCoordinate newInstance() {
            return POIXMLTypeLoader.newInstance(STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate newValue(Object obj) {
            return STCoordinate.type.newValue(obj);
        }

        public static STCoordinate parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCoordinate.type, xmlOptions);
        }
    }
}

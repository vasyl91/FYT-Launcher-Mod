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
public interface STTextSpacingPoint extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextSpacingPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextspacingpointdd05type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextSpacingPoint newInstance() {
            return POIXMLTypeLoader.newInstance(STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextSpacingPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint newValue(Object obj) {
            return STTextSpacingPoint.type.newValue(obj);
        }

        public static STTextSpacingPoint parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextSpacingPoint.type, xmlOptions);
        }
    }
}

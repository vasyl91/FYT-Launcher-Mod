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
public interface STAngle extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STAngle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stangle8074type");

    public static final class Factory {
        private Factory() {
        }

        public static STAngle newInstance() {
            return POIXMLTypeLoader.newInstance(STAngle.type, (XmlOptions) null);
        }

        public static STAngle newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STAngle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAngle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAngle.type, xmlOptions);
        }

        public static STAngle newValue(Object obj) {
            return STAngle.type.newValue(obj);
        }

        public static STAngle parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAngle.type, xmlOptions);
        }

        public static STAngle parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAngle.type, xmlOptions);
        }

        public static STAngle parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAngle.type, xmlOptions);
        }

        public static STAngle parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAngle.type, xmlOptions);
        }

        public static STAngle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAngle.type, xmlOptions);
        }

        public static STAngle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAngle.type, xmlOptions);
        }
    }
}

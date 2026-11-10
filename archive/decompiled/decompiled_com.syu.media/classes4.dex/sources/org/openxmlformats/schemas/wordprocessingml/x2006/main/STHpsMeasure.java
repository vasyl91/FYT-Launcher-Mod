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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STHpsMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthpsmeasurec985type");

    public static final class Factory {
        private Factory() {
        }

        public static STHpsMeasure newInstance() {
            return POIXMLTypeLoader.newInstance(STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure newValue(Object obj) {
            return STHpsMeasure.type.newValue(obj);
        }

        public static STHpsMeasure parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHpsMeasure.type, xmlOptions);
        }
    }
}

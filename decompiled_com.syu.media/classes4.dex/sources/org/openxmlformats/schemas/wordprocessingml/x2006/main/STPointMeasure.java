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
public interface STPointMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STPointMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpointmeasurea96atype");

    public static final class Factory {
        private Factory() {
        }

        public static STPointMeasure newInstance() {
            return POIXMLTypeLoader.newInstance(STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STPointMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPointMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure newValue(Object obj) {
            return STPointMeasure.type.newValue(obj);
        }

        public static STPointMeasure parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPointMeasure.type, xmlOptions);
        }
    }
}

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
public interface STTwipsMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTwipsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttwipsmeasure1e23type");

    public static final class Factory {
        private Factory() {
        }

        public static STTwipsMeasure newInstance() {
            return POIXMLTypeLoader.newInstance(STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTwipsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure newValue(Object obj) {
            return STTwipsMeasure.type.newValue(obj);
        }

        public static STTwipsMeasure parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTwipsMeasure.type, xmlOptions);
        }
    }
}

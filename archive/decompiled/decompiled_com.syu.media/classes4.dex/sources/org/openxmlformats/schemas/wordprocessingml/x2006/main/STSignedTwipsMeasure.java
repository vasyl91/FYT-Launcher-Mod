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
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STSignedTwipsMeasure extends XmlInteger {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STSignedTwipsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsignedtwipsmeasureb227type");

    public static final class Factory {
        private Factory() {
        }

        public static STSignedTwipsMeasure newInstance() {
            return POIXMLTypeLoader.newInstance(STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STSignedTwipsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure newValue(Object obj) {
            return STSignedTwipsMeasure.type.newValue(obj);
        }

        public static STSignedTwipsMeasure parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSignedTwipsMeasure.type, xmlOptions);
        }

        public static STSignedTwipsMeasure parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSignedTwipsMeasure.type, (XmlOptions) null);
        }

        public static STSignedTwipsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSignedTwipsMeasure.type, xmlOptions);
        }
    }
}

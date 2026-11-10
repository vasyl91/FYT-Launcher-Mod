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
public interface STSignedHpsMeasure extends XmlInteger {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STSignedHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsignedhpsmeasure8e89type");

    public static final class Factory {
        private Factory() {
        }

        public static STSignedHpsMeasure newInstance() {
            return POIXMLTypeLoader.newInstance(STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STSignedHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure newValue(Object obj) {
            return STSignedHpsMeasure.type.newValue(obj);
        }

        public static STSignedHpsMeasure parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSignedHpsMeasure.type, xmlOptions);
        }
    }
}

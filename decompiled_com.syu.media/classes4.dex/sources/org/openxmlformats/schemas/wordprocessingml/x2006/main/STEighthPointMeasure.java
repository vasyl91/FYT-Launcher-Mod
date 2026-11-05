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
public interface STEighthPointMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STEighthPointMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("steighthpointmeasure3371type");

    public static final class Factory {
        private Factory() {
        }

        public static STEighthPointMeasure newInstance() {
            return POIXMLTypeLoader.newInstance(STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STEighthPointMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure newValue(Object obj) {
            return STEighthPointMeasure.type.newValue(obj);
        }

        public static STEighthPointMeasure parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STEighthPointMeasure.type, xmlOptions);
        }
    }
}

package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STValue extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STValue.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stvalueb6e1type");

    public static final class Factory {
        private Factory() {
        }

        public static STValue newInstance() {
            return POIXMLTypeLoader.newInstance(STValue.type, (XmlOptions) null);
        }

        public static STValue newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STValue.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STValue.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STValue.type, xmlOptions);
        }

        public static STValue newValue(Object obj) {
            return STValue.type.newValue(obj);
        }

        public static STValue parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STValue.type, xmlOptions);
        }

        public static STValue parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STValue.type, xmlOptions);
        }

        public static STValue parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STValue.type, xmlOptions);
        }

        public static STValue parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STValue.type, xmlOptions);
        }

        public static STValue parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STValue.type, xmlOptions);
        }

        public static STValue parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STValue.type, xmlOptions);
        }

        public static STValue parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STValue.type, xmlOptions);
        }

        public static STValue parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STValue.type, xmlOptions);
        }
    }
}

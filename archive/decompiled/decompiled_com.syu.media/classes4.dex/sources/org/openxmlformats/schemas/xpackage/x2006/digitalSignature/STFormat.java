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
public interface STFormat extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFormat.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stformat98d1type");

    public static final class Factory {
        private Factory() {
        }

        public static STFormat newInstance() {
            return POIXMLTypeLoader.newInstance(STFormat.type, (XmlOptions) null);
        }

        public static STFormat newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFormat.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFormat.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFormat.type, xmlOptions);
        }

        public static STFormat newValue(Object obj) {
            return STFormat.type.newValue(obj);
        }

        public static STFormat parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFormat.type, xmlOptions);
        }

        public static STFormat parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFormat.type, xmlOptions);
        }

        public static STFormat parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFormat.type, xmlOptions);
        }

        public static STFormat parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFormat.type, xmlOptions);
        }

        public static STFormat parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFormat.type, xmlOptions);
        }

        public static STFormat parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFormat.type, xmlOptions);
        }

        public static STFormat parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFormat.type, xmlOptions);
        }

        public static STFormat parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFormat.type, xmlOptions);
        }
    }
}

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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STHexBinary3 extends XmlHexBinary {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STHexBinary3.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthexbinary314e2type");

    public static final class Factory {
        private Factory() {
        }

        public static STHexBinary3 newInstance() {
            return POIXMLTypeLoader.newInstance(STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STHexBinary3.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 newValue(Object obj) {
            return STHexBinary3.type.newValue(obj);
        }

        public static STHexBinary3 parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHexBinary3.type, xmlOptions);
        }
    }
}

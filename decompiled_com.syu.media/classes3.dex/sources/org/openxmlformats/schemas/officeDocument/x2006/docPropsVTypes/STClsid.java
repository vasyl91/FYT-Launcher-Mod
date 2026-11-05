package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STClsid extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STClsid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stclsida7datype");

    public static final class Factory {
        private Factory() {
        }

        public static STClsid newInstance() {
            return POIXMLTypeLoader.newInstance(STClsid.type, (XmlOptions) null);
        }

        public static STClsid newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STClsid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STClsid.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STClsid.type, xmlOptions);
        }

        public static STClsid newValue(Object obj) {
            return STClsid.type.newValue(obj);
        }

        public static STClsid parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STClsid.type, xmlOptions);
        }

        public static STClsid parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STClsid.type, xmlOptions);
        }

        public static STClsid parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STClsid.type, xmlOptions);
        }

        public static STClsid parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STClsid.type, xmlOptions);
        }

        public static STClsid parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STClsid.type, xmlOptions);
        }

        public static STClsid parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STClsid.type, xmlOptions);
        }
    }
}

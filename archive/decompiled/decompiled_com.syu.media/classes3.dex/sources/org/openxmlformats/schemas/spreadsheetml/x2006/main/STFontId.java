package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STFontId extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFontId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfontid9d63type");

    public static final class Factory {
        private Factory() {
        }

        public static STFontId newInstance() {
            return POIXMLTypeLoader.newInstance(STFontId.type, (XmlOptions) null);
        }

        public static STFontId newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFontId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFontId.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFontId.type, xmlOptions);
        }

        public static STFontId newValue(Object obj) {
            return STFontId.type.newValue(obj);
        }

        public static STFontId parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFontId.type, xmlOptions);
        }

        public static STFontId parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFontId.type, xmlOptions);
        }

        public static STFontId parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFontId.type, xmlOptions);
        }

        public static STFontId parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFontId.type, xmlOptions);
        }

        public static STFontId parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFontId.type, xmlOptions);
        }

        public static STFontId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFontId.type, xmlOptions);
        }

        public static STFontId parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFontId.type, xmlOptions);
        }

        public static STFontId parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFontId.type, xmlOptions);
        }
    }
}

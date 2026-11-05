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
public interface STFillId extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFillId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfillida097type");

    public static final class Factory {
        private Factory() {
        }

        public static STFillId newInstance() {
            return POIXMLTypeLoader.newInstance(STFillId.type, (XmlOptions) null);
        }

        public static STFillId newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFillId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFillId.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFillId.type, xmlOptions);
        }

        public static STFillId newValue(Object obj) {
            return STFillId.type.newValue(obj);
        }

        public static STFillId parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFillId.type, xmlOptions);
        }

        public static STFillId parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFillId.type, xmlOptions);
        }

        public static STFillId parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFillId.type, xmlOptions);
        }

        public static STFillId parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFillId.type, xmlOptions);
        }

        public static STFillId parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFillId.type, xmlOptions);
        }

        public static STFillId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFillId.type, xmlOptions);
        }

        public static STFillId parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFillId.type, xmlOptions);
        }

        public static STFillId parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFillId.type, xmlOptions);
        }
    }
}

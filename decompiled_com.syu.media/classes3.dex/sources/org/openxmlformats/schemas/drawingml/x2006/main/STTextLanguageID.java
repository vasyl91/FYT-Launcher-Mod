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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STTextLanguageID extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextLanguageID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextlanguageid806btype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextLanguageID newInstance() {
            return POIXMLTypeLoader.newInstance(STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextLanguageID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID newValue(Object obj) {
            return STTextLanguageID.type.newValue(obj);
        }

        public static STTextLanguageID parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextLanguageID.type, xmlOptions);
        }
    }
}

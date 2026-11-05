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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface StyleSheetDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(StyleSheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stylesheet5d8bdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static StyleSheetDocument newInstance() {
            return (StyleSheetDocument) POIXMLTypeLoader.newInstance(StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument newInstance(XmlOptions xmlOptions) {
            return (StyleSheetDocument) POIXMLTypeLoader.newInstance(StyleSheetDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(File file) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(file, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(file, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(inputStream, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(inputStream, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(Reader reader) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(reader, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(reader, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(String str) throws XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(str, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(str, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(URL url) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(url, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(url, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(xMLStreamReader, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(xMLStreamReader, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(xMLInputStream, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(xMLInputStream, StyleSheetDocument.type, xmlOptions);
        }

        public static StyleSheetDocument parse(Node node) throws XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(node, StyleSheetDocument.type, (XmlOptions) null);
        }

        public static StyleSheetDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (StyleSheetDocument) POIXMLTypeLoader.parse(node, StyleSheetDocument.type, xmlOptions);
        }
    }

    CTStylesheet addNewStyleSheet();

    CTStylesheet getStyleSheet();

    void setStyleSheet(CTStylesheet cTStylesheet);
}

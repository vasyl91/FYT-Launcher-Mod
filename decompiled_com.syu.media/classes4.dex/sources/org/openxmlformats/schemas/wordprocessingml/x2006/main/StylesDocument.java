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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface StylesDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(StylesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("styles2732doctype");

    public static final class Factory {
        private Factory() {
        }

        public static StylesDocument newInstance() {
            return (StylesDocument) POIXMLTypeLoader.newInstance(StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument newInstance(XmlOptions xmlOptions) {
            return (StylesDocument) POIXMLTypeLoader.newInstance(StylesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, StylesDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(File file) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(file, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(file, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(inputStream, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(inputStream, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(Reader reader) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(reader, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(reader, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(String str) throws XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(str, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(str, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(URL url) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(url, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) POIXMLTypeLoader.parse(url, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(xMLStreamReader, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(xMLStreamReader, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(xMLInputStream, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(xMLInputStream, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(Node node) throws XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(node, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (StylesDocument) POIXMLTypeLoader.parse(node, StylesDocument.type, xmlOptions);
        }
    }

    CTStyles addNewStyles();

    CTStyles getStyles();

    void setStyles(CTStyles cTStyles);
}

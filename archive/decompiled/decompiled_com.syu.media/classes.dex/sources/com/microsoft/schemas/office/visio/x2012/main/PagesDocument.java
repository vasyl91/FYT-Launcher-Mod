package com.microsoft.schemas.office.visio.x2012.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface PagesDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PagesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pages52f4doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PagesDocument newInstance() {
            return (PagesDocument) POIXMLTypeLoader.newInstance(PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument newInstance(XmlOptions xmlOptions) {
            return (PagesDocument) POIXMLTypeLoader.newInstance(PagesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PagesDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(File file) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(file, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(file, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(inputStream, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(inputStream, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(Reader reader) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(reader, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(reader, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(String str) throws XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(str, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(str, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(URL url) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(url, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesDocument) POIXMLTypeLoader.parse(url, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(xMLStreamReader, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(xMLStreamReader, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(xMLInputStream, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(xMLInputStream, PagesDocument.type, xmlOptions);
        }

        public static PagesDocument parse(Node node) throws XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(node, PagesDocument.type, (XmlOptions) null);
        }

        public static PagesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PagesDocument) POIXMLTypeLoader.parse(node, PagesDocument.type, xmlOptions);
        }
    }

    PagesType addNewPages();

    PagesType getPages();

    void setPages(PagesType pagesType);
}

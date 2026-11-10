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
public interface VisioDocumentDocument1 extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(VisioDocumentDocument1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("visiodocumentd431doctype");

    public static final class Factory {
        private Factory() {
        }

        public static VisioDocumentDocument1 newInstance() {
            return (VisioDocumentDocument1) POIXMLTypeLoader.newInstance(VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 newInstance(XmlOptions xmlOptions) {
            return (VisioDocumentDocument1) POIXMLTypeLoader.newInstance(VisioDocumentDocument1.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(File file) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(file, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(file, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(InputStream inputStream) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(inputStream, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(inputStream, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(Reader reader) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(reader, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(reader, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(String str) throws XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(str, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(str, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(URL url) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(url, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(url, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(xMLStreamReader, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(xMLStreamReader, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(xMLInputStream, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(xMLInputStream, VisioDocumentDocument1.type, xmlOptions);
        }

        public static VisioDocumentDocument1 parse(Node node) throws XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(node, VisioDocumentDocument1.type, (XmlOptions) null);
        }

        public static VisioDocumentDocument1 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (VisioDocumentDocument1) POIXMLTypeLoader.parse(node, VisioDocumentDocument1.type, xmlOptions);
        }
    }

    VisioDocumentType addNewVisioDocument();

    VisioDocumentType getVisioDocument();

    void setVisioDocument(VisioDocumentType visioDocumentType);
}

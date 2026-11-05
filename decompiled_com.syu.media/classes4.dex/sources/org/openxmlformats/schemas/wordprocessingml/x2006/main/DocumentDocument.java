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
public interface DocumentDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DocumentDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("document2bd9doctype");

    public static final class Factory {
        private Factory() {
        }

        public static DocumentDocument newInstance() {
            return (DocumentDocument) POIXMLTypeLoader.newInstance(DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument newInstance(XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.newInstance(DocumentDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DocumentDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(File file) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(file, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(file, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(inputStream, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(inputStream, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(Reader reader) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(reader, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(reader, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(String str) throws XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(str, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(str, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(URL url) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(url, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentDocument) POIXMLTypeLoader.parse(url, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLStreamReader, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLStreamReader, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLInputStream, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLInputStream, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(Node node) throws XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(node, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DocumentDocument) POIXMLTypeLoader.parse(node, DocumentDocument.type, xmlOptions);
        }
    }

    CTDocument1 addNewDocument();

    CTDocument1 getDocument();

    void setDocument(CTDocument1 cTDocument1);
}

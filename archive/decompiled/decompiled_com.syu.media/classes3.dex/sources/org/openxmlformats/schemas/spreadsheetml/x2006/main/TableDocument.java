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
public interface TableDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TableDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("table0b99doctype");

    public static final class Factory {
        private Factory() {
        }

        public static TableDocument newInstance() {
            return (TableDocument) POIXMLTypeLoader.newInstance(TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument newInstance(XmlOptions xmlOptions) {
            return (TableDocument) POIXMLTypeLoader.newInstance(TableDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TableDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(File file) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(file, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(file, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(inputStream, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(inputStream, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(Reader reader) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(reader, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(reader, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(String str) throws XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(str, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(str, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(URL url) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(url, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) POIXMLTypeLoader.parse(url, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(xMLStreamReader, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(xMLStreamReader, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(xMLInputStream, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(xMLInputStream, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(Node node) throws XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(node, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TableDocument) POIXMLTypeLoader.parse(node, TableDocument.type, xmlOptions);
        }
    }

    CTTable addNewTable();

    CTTable getTable();

    void setTable(CTTable cTTable);
}

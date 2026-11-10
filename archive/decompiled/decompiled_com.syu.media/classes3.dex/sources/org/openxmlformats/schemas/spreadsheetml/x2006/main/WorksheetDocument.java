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
public interface WorksheetDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(WorksheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("worksheetf539doctype");

    public static final class Factory {
        private Factory() {
        }

        public static WorksheetDocument newInstance() {
            return (WorksheetDocument) POIXMLTypeLoader.newInstance(WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument newInstance(XmlOptions xmlOptions) {
            return (WorksheetDocument) POIXMLTypeLoader.newInstance(WorksheetDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, WorksheetDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(File file) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(file, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(file, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(inputStream, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(inputStream, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(Reader reader) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(reader, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(reader, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(String str) throws XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(str, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(str, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(URL url) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(url, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(url, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(xMLStreamReader, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(xMLStreamReader, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(xMLInputStream, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(xMLInputStream, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(Node node) throws XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(node, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (WorksheetDocument) POIXMLTypeLoader.parse(node, WorksheetDocument.type, xmlOptions);
        }
    }

    CTWorksheet addNewWorksheet();

    CTWorksheet getWorksheet();

    void setWorksheet(CTWorksheet cTWorksheet);
}

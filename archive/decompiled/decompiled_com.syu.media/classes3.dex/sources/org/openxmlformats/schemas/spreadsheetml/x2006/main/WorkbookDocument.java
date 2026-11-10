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
public interface WorkbookDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(WorkbookDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("workbookec17doctype");

    public static final class Factory {
        private Factory() {
        }

        public static WorkbookDocument newInstance() {
            return (WorkbookDocument) POIXMLTypeLoader.newInstance(WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument newInstance(XmlOptions xmlOptions) {
            return (WorkbookDocument) POIXMLTypeLoader.newInstance(WorkbookDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, WorkbookDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(File file) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(file, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(file, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(inputStream, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(inputStream, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(Reader reader) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(reader, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(reader, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(String str) throws XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(str, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(str, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(URL url) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(url, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(url, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(xMLStreamReader, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(xMLStreamReader, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(xMLInputStream, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(xMLInputStream, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(Node node) throws XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(node, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (WorkbookDocument) POIXMLTypeLoader.parse(node, WorkbookDocument.type, xmlOptions);
        }
    }

    CTWorkbook addNewWorkbook();

    CTWorkbook getWorkbook();

    void setWorkbook(CTWorkbook cTWorkbook);
}

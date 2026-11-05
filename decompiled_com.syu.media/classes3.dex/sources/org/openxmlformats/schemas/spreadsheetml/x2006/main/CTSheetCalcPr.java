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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSheetCalcPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSheetCalcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetcalcprc6d5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetCalcPr newInstance() {
            return (CTSheetCalcPr) POIXMLTypeLoader.newInstance(CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr newInstance(XmlOptions xmlOptions) {
            return (CTSheetCalcPr) POIXMLTypeLoader.newInstance(CTSheetCalcPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(File file) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(file, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(file, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(inputStream, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(inputStream, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(Reader reader) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(reader, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(reader, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(String str) throws XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(str, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(str, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(URL url) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(url, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(url, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(xMLInputStream, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(xMLInputStream, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(Node node) throws XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(node, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetCalcPr) POIXMLTypeLoader.parse(node, CTSheetCalcPr.type, xmlOptions);
        }
    }

    boolean getFullCalcOnLoad();

    boolean isSetFullCalcOnLoad();

    void setFullCalcOnLoad(boolean z);

    void unsetFullCalcOnLoad();

    XmlBoolean xgetFullCalcOnLoad();

    void xsetFullCalcOnLoad(XmlBoolean xmlBoolean);
}

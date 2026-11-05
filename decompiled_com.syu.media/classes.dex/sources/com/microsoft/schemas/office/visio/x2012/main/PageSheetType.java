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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface PageSheetType extends SheetType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PageSheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagesheettype679btype");

    public static final class Factory {
        private Factory() {
        }

        public static PageSheetType newInstance() {
            return (PageSheetType) POIXMLTypeLoader.newInstance(PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType newInstance(XmlOptions xmlOptions) {
            return (PageSheetType) POIXMLTypeLoader.newInstance(PageSheetType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PageSheetType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(File file) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(file, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(file, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(InputStream inputStream) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(inputStream, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(inputStream, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(Reader reader) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(reader, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(reader, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(String str) throws XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(str, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(str, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(URL url) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(url, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageSheetType) POIXMLTypeLoader.parse(url, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(xMLStreamReader, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(xMLStreamReader, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(xMLInputStream, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(xMLInputStream, PageSheetType.type, xmlOptions);
        }

        public static PageSheetType parse(Node node) throws XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(node, PageSheetType.type, (XmlOptions) null);
        }

        public static PageSheetType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PageSheetType) POIXMLTypeLoader.parse(node, PageSheetType.type, xmlOptions);
        }
    }

    String getUniqueID();

    boolean isSetUniqueID();

    void setUniqueID(String str);

    void unsetUniqueID();

    XmlString xgetUniqueID();

    void xsetUniqueID(XmlString xmlString);
}

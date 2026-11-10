package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface PagesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PagesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagestypef2e7type");

    public static final class Factory {
        private Factory() {
        }

        public static PagesType newInstance() {
            return (PagesType) POIXMLTypeLoader.newInstance(PagesType.type, (XmlOptions) null);
        }

        public static PagesType newInstance(XmlOptions xmlOptions) {
            return (PagesType) POIXMLTypeLoader.newInstance(PagesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PagesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PagesType.type, xmlOptions);
        }

        public static PagesType parse(File file) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(file, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(file, PagesType.type, xmlOptions);
        }

        public static PagesType parse(InputStream inputStream) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(inputStream, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(inputStream, PagesType.type, xmlOptions);
        }

        public static PagesType parse(Reader reader) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(reader, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(reader, PagesType.type, xmlOptions);
        }

        public static PagesType parse(String str) throws XmlException {
            return (PagesType) POIXMLTypeLoader.parse(str, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PagesType) POIXMLTypeLoader.parse(str, PagesType.type, xmlOptions);
        }

        public static PagesType parse(URL url) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(url, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PagesType) POIXMLTypeLoader.parse(url, PagesType.type, xmlOptions);
        }

        public static PagesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PagesType) POIXMLTypeLoader.parse(xMLStreamReader, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PagesType) POIXMLTypeLoader.parse(xMLStreamReader, PagesType.type, xmlOptions);
        }

        public static PagesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PagesType) POIXMLTypeLoader.parse(xMLInputStream, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PagesType) POIXMLTypeLoader.parse(xMLInputStream, PagesType.type, xmlOptions);
        }

        public static PagesType parse(Node node) throws XmlException {
            return (PagesType) POIXMLTypeLoader.parse(node, PagesType.type, (XmlOptions) null);
        }

        public static PagesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PagesType) POIXMLTypeLoader.parse(node, PagesType.type, xmlOptions);
        }
    }

    PageType addNewPage();

    PageType getPageArray(int i);

    PageType[] getPageArray();

    List<PageType> getPageList();

    PageType insertNewPage(int i);

    void removePage(int i);

    void setPageArray(int i, PageType pageType);

    void setPageArray(PageType[] pageTypeArr);

    int sizeOfPageArray();
}

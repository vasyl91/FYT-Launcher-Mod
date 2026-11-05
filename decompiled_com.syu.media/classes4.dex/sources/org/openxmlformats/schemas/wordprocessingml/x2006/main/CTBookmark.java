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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTBookmark extends CTBookmarkRange {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBookmark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbookmarkd672type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookmark newInstance() {
            return (CTBookmark) POIXMLTypeLoader.newInstance(CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark newInstance(XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.newInstance(CTBookmark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(File file) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(file, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(file, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(inputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(inputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(Reader reader) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(reader, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(reader, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(String str) throws XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(str, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(str, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(URL url) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(url, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) POIXMLTypeLoader.parse(url, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLStreamReader, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLStreamReader, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLInputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLInputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(Node node) throws XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(node, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmark) POIXMLTypeLoader.parse(node, CTBookmark.type, xmlOptions);
        }
    }

    String getName();

    void setName(String str);

    STString xgetName();

    void xsetName(STString sTString);
}

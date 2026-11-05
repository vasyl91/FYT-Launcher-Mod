package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTTabs extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTabs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttabsa2aatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTabs newInstance() {
            return (CTTabs) POIXMLTypeLoader.newInstance(CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs newInstance(XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.newInstance(CTTabs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTabs.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(File file) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(file, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(file, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(inputStream, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(inputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(Reader reader) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(reader, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(reader, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(String str) throws XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(str, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(str, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(URL url) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(url, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) POIXMLTypeLoader.parse(url, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(xMLStreamReader, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(xMLStreamReader, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(xMLInputStream, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(xMLInputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(Node node) throws XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(node, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTabs) POIXMLTypeLoader.parse(node, CTTabs.type, xmlOptions);
        }
    }

    CTTabStop addNewTab();

    CTTabStop getTabArray(int i);

    CTTabStop[] getTabArray();

    List<CTTabStop> getTabList();

    CTTabStop insertNewTab(int i);

    void removeTab(int i);

    void setTabArray(int i, CTTabStop cTTabStop);

    void setTabArray(CTTabStop[] cTTabStopArr);

    int sizeOfTabArray();
}

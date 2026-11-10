package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTextTabStopList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextTabStopList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttexttabstoplistf539type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextTabStopList newInstance() {
            return (CTTextTabStopList) POIXMLTypeLoader.newInstance(CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList newInstance(XmlOptions xmlOptions) {
            return (CTTextTabStopList) POIXMLTypeLoader.newInstance(CTTextTabStopList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(File file) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(file, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(file, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(inputStream, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(inputStream, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(Reader reader) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(reader, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(reader, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(String str) throws XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(str, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(str, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(URL url) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(url, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(url, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(xMLStreamReader, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(xMLStreamReader, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(xMLInputStream, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(xMLInputStream, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(Node node) throws XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(node, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStopList) POIXMLTypeLoader.parse(node, CTTextTabStopList.type, xmlOptions);
        }
    }

    CTTextTabStop addNewTab();

    CTTextTabStop getTabArray(int i);

    CTTextTabStop[] getTabArray();

    List<CTTextTabStop> getTabList();

    CTTextTabStop insertNewTab(int i);

    void removeTab(int i);

    void setTabArray(int i, CTTextTabStop cTTextTabStop);

    void setTabArray(CTTextTabStop[] cTTextTabStopArr);

    int sizeOfTabArray();
}

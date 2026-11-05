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
public interface CTConnectionSiteList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTConnectionSiteList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconnectionsitelistab9etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnectionSiteList newInstance() {
            return (CTConnectionSiteList) POIXMLTypeLoader.newInstance(CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList newInstance(XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.newInstance(CTConnectionSiteList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(File file) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(file, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(file, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(inputStream, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(inputStream, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(Reader reader) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(reader, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(reader, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(String str) throws XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(str, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(str, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(URL url) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(url, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(url, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLInputStream, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLInputStream, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(Node node) throws XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(node, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(node, CTConnectionSiteList.type, xmlOptions);
        }
    }

    CTConnectionSite addNewCxn();

    CTConnectionSite getCxnArray(int i);

    CTConnectionSite[] getCxnArray();

    List<CTConnectionSite> getCxnList();

    CTConnectionSite insertNewCxn(int i);

    void removeCxn(int i);

    void setCxnArray(int i, CTConnectionSite cTConnectionSite);

    void setCxnArray(CTConnectionSite[] cTConnectionSiteArr);

    int sizeOfCxnArray();
}

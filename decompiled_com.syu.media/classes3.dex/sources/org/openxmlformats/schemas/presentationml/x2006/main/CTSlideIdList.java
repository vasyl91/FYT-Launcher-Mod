package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTSlideIdList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSlideIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslideidlist70a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideIdList newInstance() {
            return (CTSlideIdList) POIXMLTypeLoader.newInstance(CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList newInstance(XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.newInstance(CTSlideIdList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(File file) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(file, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(file, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(inputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(inputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(Reader reader) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(reader, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(reader, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(String str) throws XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(str, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(str, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(URL url) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(url, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(url, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLInputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLInputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(Node node) throws XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(node, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdList) POIXMLTypeLoader.parse(node, CTSlideIdList.type, xmlOptions);
        }
    }

    CTSlideIdListEntry addNewSldId();

    CTSlideIdListEntry getSldIdArray(int i);

    CTSlideIdListEntry[] getSldIdArray();

    List<CTSlideIdListEntry> getSldIdList();

    CTSlideIdListEntry insertNewSldId(int i);

    void removeSldId(int i);

    void setSldIdArray(int i, CTSlideIdListEntry cTSlideIdListEntry);

    void setSldIdArray(CTSlideIdListEntry[] cTSlideIdListEntryArr);

    int sizeOfSldIdArray();
}

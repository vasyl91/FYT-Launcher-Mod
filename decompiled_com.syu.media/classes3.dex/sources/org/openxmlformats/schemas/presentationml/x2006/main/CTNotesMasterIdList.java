package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTNotesMasterIdList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNotesMasterIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnotesmasteridlist2853type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNotesMasterIdList newInstance() {
            return (CTNotesMasterIdList) POIXMLTypeLoader.newInstance(CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList newInstance(XmlOptions xmlOptions) {
            return (CTNotesMasterIdList) POIXMLTypeLoader.newInstance(CTNotesMasterIdList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(File file) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(file, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(file, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(inputStream, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(inputStream, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(Reader reader) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(reader, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(reader, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(String str) throws XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(str, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(str, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(URL url) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(url, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(url, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(xMLInputStream, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(xMLInputStream, CTNotesMasterIdList.type, xmlOptions);
        }

        public static CTNotesMasterIdList parse(Node node) throws XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(node, CTNotesMasterIdList.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdList) POIXMLTypeLoader.parse(node, CTNotesMasterIdList.type, xmlOptions);
        }
    }

    CTNotesMasterIdListEntry addNewNotesMasterId();

    CTNotesMasterIdListEntry getNotesMasterId();

    boolean isSetNotesMasterId();

    void setNotesMasterId(CTNotesMasterIdListEntry cTNotesMasterIdListEntry);

    void unsetNotesMasterId();
}

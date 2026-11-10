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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTNotesMasterIdListEntry extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNotesMasterIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnotesmasteridlistentry278ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNotesMasterIdListEntry newInstance() {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.newInstance(CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry newInstance(XmlOptions xmlOptions) {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.newInstance(CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(File file) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(file, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(file, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(inputStream, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(inputStream, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(Reader reader) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(reader, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(reader, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(String str) throws XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(str, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(str, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(URL url) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(url, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(url, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(xMLStreamReader, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(xMLStreamReader, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(xMLInputStream, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(xMLInputStream, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(Node node) throws XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(node, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdListEntry) POIXMLTypeLoader.parse(node, CTNotesMasterIdListEntry.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    String getId();

    boolean isSetExtLst();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(String str);

    void unsetExtLst();

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}

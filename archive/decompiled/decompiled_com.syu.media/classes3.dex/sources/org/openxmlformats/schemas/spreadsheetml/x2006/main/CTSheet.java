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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSheet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheet4dbetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheet newInstance() {
            return (CTSheet) POIXMLTypeLoader.newInstance(CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet newInstance(XmlOptions xmlOptions) {
            return (CTSheet) POIXMLTypeLoader.newInstance(CTSheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(File file) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(file, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(file, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(inputStream, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(inputStream, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(Reader reader) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(reader, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(reader, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(String str) throws XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(str, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(str, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(URL url) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(url, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) POIXMLTypeLoader.parse(url, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(xMLStreamReader, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(xMLStreamReader, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(xMLInputStream, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(xMLInputStream, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(Node node) throws XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(node, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheet) POIXMLTypeLoader.parse(node, CTSheet.type, xmlOptions);
        }
    }

    String getId();

    String getName();

    long getSheetId();

    STSheetState.Enum getState();

    boolean isSetState();

    void setId(String str);

    void setName(String str);

    void setSheetId(long j);

    void setState(STSheetState.Enum r1);

    void unsetState();

    STRelationshipId xgetId();

    STXstring xgetName();

    XmlUnsignedInt xgetSheetId();

    STSheetState xgetState();

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetName(STXstring sTXstring);

    void xsetSheetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetState(STSheetState sTSheetState);
}

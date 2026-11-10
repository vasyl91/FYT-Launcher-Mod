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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTExternalBook extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTExternalBook.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalbookc89dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalBook newInstance() {
            return (CTExternalBook) POIXMLTypeLoader.newInstance(CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook newInstance(XmlOptions xmlOptions) {
            return (CTExternalBook) POIXMLTypeLoader.newInstance(CTExternalBook.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalBook.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(File file) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(file, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(file, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(inputStream, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(inputStream, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(Reader reader) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(reader, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(reader, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(String str) throws XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(str, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(str, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(URL url) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(url, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) POIXMLTypeLoader.parse(url, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(xMLInputStream, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(xMLInputStream, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(Node node) throws XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(node, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalBook) POIXMLTypeLoader.parse(node, CTExternalBook.type, xmlOptions);
        }
    }

    CTExternalDefinedNames addNewDefinedNames();

    CTExternalSheetDataSet addNewSheetDataSet();

    CTExternalSheetNames addNewSheetNames();

    CTExternalDefinedNames getDefinedNames();

    String getId();

    CTExternalSheetDataSet getSheetDataSet();

    CTExternalSheetNames getSheetNames();

    boolean isSetDefinedNames();

    boolean isSetSheetDataSet();

    boolean isSetSheetNames();

    void setDefinedNames(CTExternalDefinedNames cTExternalDefinedNames);

    void setId(String str);

    void setSheetDataSet(CTExternalSheetDataSet cTExternalSheetDataSet);

    void setSheetNames(CTExternalSheetNames cTExternalSheetNames);

    void unsetDefinedNames();

    void unsetSheetDataSet();

    void unsetSheetNames();

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}

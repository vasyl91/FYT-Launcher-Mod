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
public interface CTExternalReference extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTExternalReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalreference945ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalReference newInstance() {
            return (CTExternalReference) POIXMLTypeLoader.newInstance(CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference newInstance(XmlOptions xmlOptions) {
            return (CTExternalReference) POIXMLTypeLoader.newInstance(CTExternalReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalReference.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(File file) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(file, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(file, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(inputStream, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(inputStream, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(Reader reader) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(reader, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(reader, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(String str) throws XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(str, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(str, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(URL url) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(url, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) POIXMLTypeLoader.parse(url, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(xMLInputStream, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(xMLInputStream, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(Node node) throws XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(node, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReference) POIXMLTypeLoader.parse(node, CTExternalReference.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}

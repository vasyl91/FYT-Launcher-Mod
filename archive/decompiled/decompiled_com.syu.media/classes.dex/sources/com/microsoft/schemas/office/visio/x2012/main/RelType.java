package com.microsoft.schemas.office.visio.x2012.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface RelType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RelType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("reltype05f2type");

    public static final class Factory {
        private Factory() {
        }

        public static RelType newInstance() {
            return (RelType) POIXMLTypeLoader.newInstance(RelType.type, (XmlOptions) null);
        }

        public static RelType newInstance(XmlOptions xmlOptions) {
            return (RelType) POIXMLTypeLoader.newInstance(RelType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RelType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RelType.type, xmlOptions);
        }

        public static RelType parse(File file) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(file, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(file, RelType.type, xmlOptions);
        }

        public static RelType parse(InputStream inputStream) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(inputStream, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(inputStream, RelType.type, xmlOptions);
        }

        public static RelType parse(Reader reader) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(reader, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(reader, RelType.type, xmlOptions);
        }

        public static RelType parse(String str) throws XmlException {
            return (RelType) POIXMLTypeLoader.parse(str, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RelType) POIXMLTypeLoader.parse(str, RelType.type, xmlOptions);
        }

        public static RelType parse(URL url) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(url, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelType) POIXMLTypeLoader.parse(url, RelType.type, xmlOptions);
        }

        public static RelType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RelType) POIXMLTypeLoader.parse(xMLStreamReader, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RelType) POIXMLTypeLoader.parse(xMLStreamReader, RelType.type, xmlOptions);
        }

        public static RelType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RelType) POIXMLTypeLoader.parse(xMLInputStream, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RelType) POIXMLTypeLoader.parse(xMLInputStream, RelType.type, xmlOptions);
        }

        public static RelType parse(Node node) throws XmlException {
            return (RelType) POIXMLTypeLoader.parse(node, RelType.type, (XmlOptions) null);
        }

        public static RelType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RelType) POIXMLTypeLoader.parse(node, RelType.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}

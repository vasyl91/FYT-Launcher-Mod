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
public interface CTLegacyDrawing extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLegacyDrawing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlegacydrawing49f4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLegacyDrawing newInstance() {
            return (CTLegacyDrawing) POIXMLTypeLoader.newInstance(CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing newInstance(XmlOptions xmlOptions) {
            return (CTLegacyDrawing) POIXMLTypeLoader.newInstance(CTLegacyDrawing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(File file) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(file, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(file, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(inputStream, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(inputStream, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(Reader reader) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(reader, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(reader, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(String str) throws XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(str, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(str, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(URL url) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(url, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(url, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(xMLStreamReader, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(xMLStreamReader, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(xMLInputStream, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(xMLInputStream, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(Node node) throws XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(node, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLegacyDrawing) POIXMLTypeLoader.parse(node, CTLegacyDrawing.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}

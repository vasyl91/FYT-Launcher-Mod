package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTRel extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrel4519type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRel newInstance() {
            return (CTRel) POIXMLTypeLoader.newInstance(CTRel.type, (XmlOptions) null);
        }

        public static CTRel newInstance(XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.newInstance(CTRel.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRel.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(File file) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(file, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(file, CTRel.type, xmlOptions);
        }

        public static CTRel parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(inputStream, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(inputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(Reader reader) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(reader, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(reader, CTRel.type, xmlOptions);
        }

        public static CTRel parse(String str) throws XmlException {
            return (CTRel) POIXMLTypeLoader.parse(str, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRel) POIXMLTypeLoader.parse(str, CTRel.type, xmlOptions);
        }

        public static CTRel parse(URL url) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(url, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) POIXMLTypeLoader.parse(url, CTRel.type, xmlOptions);
        }

        public static CTRel parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRel) POIXMLTypeLoader.parse(xMLStreamReader, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRel) POIXMLTypeLoader.parse(xMLStreamReader, CTRel.type, xmlOptions);
        }

        public static CTRel parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRel) POIXMLTypeLoader.parse(xMLInputStream, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRel) POIXMLTypeLoader.parse(xMLInputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(Node node) throws XmlException {
            return (CTRel) POIXMLTypeLoader.parse(node, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRel) POIXMLTypeLoader.parse(node, CTRel.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}

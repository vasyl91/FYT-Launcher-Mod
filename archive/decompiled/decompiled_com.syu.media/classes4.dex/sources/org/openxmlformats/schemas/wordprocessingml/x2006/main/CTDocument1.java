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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTDocument1 extends CTDocumentBase {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDocument1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdocument64adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocument1 newInstance() {
            return (CTDocument1) POIXMLTypeLoader.newInstance(CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 newInstance(XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.newInstance(CTDocument1.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(File file) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(file, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(file, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(inputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(inputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(Reader reader) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(reader, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(reader, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(String str) throws XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(str, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(str, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(URL url) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(url, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) POIXMLTypeLoader.parse(url, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLStreamReader, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLStreamReader, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLInputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLInputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(Node node) throws XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(node, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDocument1) POIXMLTypeLoader.parse(node, CTDocument1.type, xmlOptions);
        }
    }

    CTBody addNewBody();

    CTBody getBody();

    boolean isSetBody();

    void setBody(CTBody cTBody);

    void unsetBody();
}

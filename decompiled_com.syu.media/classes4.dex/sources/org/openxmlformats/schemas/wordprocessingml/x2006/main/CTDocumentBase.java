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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTDocumentBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDocumentBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdocumentbasedf5ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocumentBase newInstance() {
            return (CTDocumentBase) POIXMLTypeLoader.newInstance(CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase newInstance(XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.newInstance(CTDocumentBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(File file) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(file, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(file, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(inputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(inputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(Reader reader) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(reader, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(reader, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(String str) throws XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(str, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(str, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(URL url) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(url, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(url, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLStreamReader, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLStreamReader, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLInputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLInputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(Node node) throws XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(node, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDocumentBase) POIXMLTypeLoader.parse(node, CTDocumentBase.type, xmlOptions);
        }
    }

    CTBackground addNewBackground();

    CTBackground getBackground();

    boolean isSetBackground();

    void setBackground(CTBackground cTBackground);

    void unsetBackground();
}

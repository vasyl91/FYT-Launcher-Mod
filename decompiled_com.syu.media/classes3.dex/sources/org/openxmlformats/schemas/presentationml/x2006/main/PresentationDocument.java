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
public interface PresentationDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PresentationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("presentation02f7doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PresentationDocument newInstance() {
            return (PresentationDocument) POIXMLTypeLoader.newInstance(PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument newInstance(XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.newInstance(PresentationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(File file) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(file, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(file, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(inputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(inputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(Reader reader) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(reader, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(reader, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(String str) throws XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(str, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(str, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(URL url) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(url, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) POIXMLTypeLoader.parse(url, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLStreamReader, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLStreamReader, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLInputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLInputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(Node node) throws XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(node, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PresentationDocument) POIXMLTypeLoader.parse(node, PresentationDocument.type, xmlOptions);
        }
    }

    CTPresentation addNewPresentation();

    CTPresentation getPresentation();

    void setPresentation(CTPresentation cTPresentation);
}

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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ExternalLinkDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ExternalLinkDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("externallinkb4c2doctype");

    public static final class Factory {
        private Factory() {
        }

        public static ExternalLinkDocument newInstance() {
            return (ExternalLinkDocument) POIXMLTypeLoader.newInstance(ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument newInstance(XmlOptions xmlOptions) {
            return (ExternalLinkDocument) POIXMLTypeLoader.newInstance(ExternalLinkDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(File file) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(file, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(file, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(inputStream, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(inputStream, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(Reader reader) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(reader, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(reader, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(String str) throws XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(str, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(str, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(URL url) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(url, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(url, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(xMLStreamReader, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(xMLStreamReader, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(xMLInputStream, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(xMLInputStream, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(Node node) throws XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(node, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ExternalLinkDocument) POIXMLTypeLoader.parse(node, ExternalLinkDocument.type, xmlOptions);
        }
    }

    CTExternalLink addNewExternalLink();

    CTExternalLink getExternalLink();

    void setExternalLink(CTExternalLink cTExternalLink);
}

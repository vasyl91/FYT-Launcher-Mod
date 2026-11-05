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
public interface EndnotesDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(EndnotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("endnotes960edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static EndnotesDocument newInstance() {
            return (EndnotesDocument) POIXMLTypeLoader.newInstance(EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument newInstance(XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.newInstance(EndnotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(File file) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(file, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(file, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(inputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(inputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(Reader reader) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(reader, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(reader, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(String str) throws XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(str, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(str, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(URL url) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(url, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(url, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(Node node) throws XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(node, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EndnotesDocument) POIXMLTypeLoader.parse(node, EndnotesDocument.type, xmlOptions);
        }
    }

    CTEndnotes addNewEndnotes();

    CTEndnotes getEndnotes();

    void setEndnotes(CTEndnotes cTEndnotes);
}

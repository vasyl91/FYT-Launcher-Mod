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
public interface FootnotesDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(FootnotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("footnotes8773doctype");

    public static final class Factory {
        private Factory() {
        }

        public static FootnotesDocument newInstance() {
            return (FootnotesDocument) POIXMLTypeLoader.newInstance(FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument newInstance(XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.newInstance(FootnotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(File file) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(file, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(file, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(inputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(inputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(Reader reader) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(reader, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(reader, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(String str) throws XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(str, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(str, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(URL url) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(url, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(url, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(Node node) throws XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(node, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FootnotesDocument) POIXMLTypeLoader.parse(node, FootnotesDocument.type, xmlOptions);
        }
    }

    CTFootnotes addNewFootnotes();

    CTFootnotes getFootnotes();

    void setFootnotes(CTFootnotes cTFootnotes);
}

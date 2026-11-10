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
public interface NotesDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("notes4a02doctype");

    public static final class Factory {
        private Factory() {
        }

        public static NotesDocument newInstance() {
            return (NotesDocument) POIXMLTypeLoader.newInstance(NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument newInstance(XmlOptions xmlOptions) {
            return (NotesDocument) POIXMLTypeLoader.newInstance(NotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, NotesDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(File file) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(file, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(file, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(inputStream, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(inputStream, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(Reader reader) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(reader, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(reader, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(String str) throws XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(str, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(str, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(URL url) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(url, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) POIXMLTypeLoader.parse(url, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(xMLInputStream, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(xMLInputStream, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(Node node) throws XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(node, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NotesDocument) POIXMLTypeLoader.parse(node, NotesDocument.type, xmlOptions);
        }
    }

    CTNotesSlide addNewNotes();

    CTNotesSlide getNotes();

    void setNotes(CTNotesSlide cTNotesSlide);
}

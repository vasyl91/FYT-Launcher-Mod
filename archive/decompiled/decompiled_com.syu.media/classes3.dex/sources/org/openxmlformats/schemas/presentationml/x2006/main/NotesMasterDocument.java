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
public interface NotesMasterDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NotesMasterDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("notesmaster8840doctype");

    public static final class Factory {
        private Factory() {
        }

        public static NotesMasterDocument newInstance() {
            return (NotesMasterDocument) POIXMLTypeLoader.newInstance(NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument newInstance(XmlOptions xmlOptions) {
            return (NotesMasterDocument) POIXMLTypeLoader.newInstance(NotesMasterDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(File file) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(file, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(file, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(inputStream, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(inputStream, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(Reader reader) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(reader, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(reader, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(String str) throws XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(str, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(str, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(URL url) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(url, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(url, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(xMLStreamReader, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(xMLStreamReader, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(xMLInputStream, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(xMLInputStream, NotesMasterDocument.type, xmlOptions);
        }

        public static NotesMasterDocument parse(Node node) throws XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(node, NotesMasterDocument.type, (XmlOptions) null);
        }

        public static NotesMasterDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NotesMasterDocument) POIXMLTypeLoader.parse(node, NotesMasterDocument.type, xmlOptions);
        }
    }

    CTNotesMaster addNewNotesMaster();

    CTNotesMaster getNotesMaster();

    void setNotesMaster(CTNotesMaster cTNotesMaster);
}

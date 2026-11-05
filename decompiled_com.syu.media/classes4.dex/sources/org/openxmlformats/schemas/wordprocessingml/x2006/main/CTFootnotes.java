package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTFootnotes extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFootnotes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfootnotes691ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFootnotes newInstance() {
            return (CTFootnotes) POIXMLTypeLoader.newInstance(CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes newInstance(XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.newInstance(CTFootnotes.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(File file) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(file, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(file, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(inputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(inputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(Reader reader) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(reader, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(reader, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(String str) throws XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(str, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(str, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(URL url) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(url, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) POIXMLTypeLoader.parse(url, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLInputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLInputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(Node node) throws XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(node, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFootnotes) POIXMLTypeLoader.parse(node, CTFootnotes.type, xmlOptions);
        }
    }

    CTFtnEdn addNewFootnote();

    CTFtnEdn getFootnoteArray(int i);

    CTFtnEdn[] getFootnoteArray();

    List<CTFtnEdn> getFootnoteList();

    CTFtnEdn insertNewFootnote(int i);

    void removeFootnote(int i);

    void setFootnoteArray(int i, CTFtnEdn cTFtnEdn);

    void setFootnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfFootnoteArray();
}

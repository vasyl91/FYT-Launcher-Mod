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
public interface CTEndnotes extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTEndnotes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctendnotescee2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTEndnotes newInstance() {
            return (CTEndnotes) POIXMLTypeLoader.newInstance(CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes newInstance(XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.newInstance(CTEndnotes.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(File file) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(file, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(file, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(inputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(inputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(Reader reader) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(reader, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(reader, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(String str) throws XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(str, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(str, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(URL url) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(url, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) POIXMLTypeLoader.parse(url, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLInputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLInputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(Node node) throws XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(node, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEndnotes) POIXMLTypeLoader.parse(node, CTEndnotes.type, xmlOptions);
        }
    }

    CTFtnEdn addNewEndnote();

    CTFtnEdn getEndnoteArray(int i);

    CTFtnEdn[] getEndnoteArray();

    List<CTFtnEdn> getEndnoteList();

    CTFtnEdn insertNewEndnote(int i);

    void removeEndnote(int i);

    void setEndnoteArray(int i, CTFtnEdn cTFtnEdn);

    void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfEndnoteArray();
}

package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTHyperlinks extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTHyperlinks.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthyperlinks6416type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHyperlinks newInstance() {
            return (CTHyperlinks) POIXMLTypeLoader.newInstance(CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks newInstance(XmlOptions xmlOptions) {
            return (CTHyperlinks) POIXMLTypeLoader.newInstance(CTHyperlinks.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHyperlinks.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(File file) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(file, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(file, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(inputStream, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(inputStream, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(Reader reader) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(reader, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(reader, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(String str) throws XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(str, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(str, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(URL url) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(url, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(url, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(xMLStreamReader, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(xMLStreamReader, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(xMLInputStream, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(xMLInputStream, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(Node node) throws XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(node, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlinks) POIXMLTypeLoader.parse(node, CTHyperlinks.type, xmlOptions);
        }
    }

    CTHyperlink addNewHyperlink();

    CTHyperlink getHyperlinkArray(int i);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTHyperlink insertNewHyperlink(int i);

    void removeHyperlink(int i);

    void setHyperlinkArray(int i, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    int sizeOfHyperlinkArray();
}

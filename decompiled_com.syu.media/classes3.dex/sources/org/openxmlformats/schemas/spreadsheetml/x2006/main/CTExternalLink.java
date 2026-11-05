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
public interface CTExternalLink extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTExternalLink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternallink966etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalLink newInstance() {
            return (CTExternalLink) POIXMLTypeLoader.newInstance(CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink newInstance(XmlOptions xmlOptions) {
            return (CTExternalLink) POIXMLTypeLoader.newInstance(CTExternalLink.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalLink.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(File file) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(file, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(file, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(inputStream, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(inputStream, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(Reader reader) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(reader, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(reader, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(String str) throws XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(str, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(str, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(URL url) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(url, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) POIXMLTypeLoader.parse(url, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(xMLInputStream, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(xMLInputStream, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(Node node) throws XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(node, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalLink) POIXMLTypeLoader.parse(node, CTExternalLink.type, xmlOptions);
        }
    }

    CTDdeLink addNewDdeLink();

    CTExtensionList addNewExtLst();

    CTExternalBook addNewExternalBook();

    CTOleLink addNewOleLink();

    CTDdeLink getDdeLink();

    CTExtensionList getExtLst();

    CTExternalBook getExternalBook();

    CTOleLink getOleLink();

    boolean isSetDdeLink();

    boolean isSetExtLst();

    boolean isSetExternalBook();

    boolean isSetOleLink();

    void setDdeLink(CTDdeLink cTDdeLink);

    void setExtLst(CTExtensionList cTExtensionList);

    void setExternalBook(CTExternalBook cTExternalBook);

    void setOleLink(CTOleLink cTOleLink);

    void unsetDdeLink();

    void unsetExtLst();

    void unsetExternalBook();

    void unsetOleLink();
}

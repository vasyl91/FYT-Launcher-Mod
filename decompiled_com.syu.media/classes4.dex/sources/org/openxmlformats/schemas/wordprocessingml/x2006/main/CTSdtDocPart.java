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
public interface CTSdtDocPart extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSdtDocPart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtdocpartcea0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtDocPart newInstance() {
            return (CTSdtDocPart) POIXMLTypeLoader.newInstance(CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart newInstance(XmlOptions xmlOptions) {
            return (CTSdtDocPart) POIXMLTypeLoader.newInstance(CTSdtDocPart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(File file) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(file, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(file, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(inputStream, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(inputStream, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(Reader reader) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(reader, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(reader, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(String str) throws XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(str, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(str, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(URL url) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(url, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(url, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(xMLInputStream, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(xMLInputStream, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(Node node) throws XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(node, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtDocPart) POIXMLTypeLoader.parse(node, CTSdtDocPart.type, xmlOptions);
        }
    }

    CTString addNewDocPartCategory();

    CTString addNewDocPartGallery();

    CTOnOff addNewDocPartUnique();

    CTString getDocPartCategory();

    CTString getDocPartGallery();

    CTOnOff getDocPartUnique();

    boolean isSetDocPartCategory();

    boolean isSetDocPartGallery();

    boolean isSetDocPartUnique();

    void setDocPartCategory(CTString cTString);

    void setDocPartGallery(CTString cTString);

    void setDocPartUnique(CTOnOff cTOnOff);

    void unsetDocPartCategory();

    void unsetDocPartGallery();

    void unsetDocPartUnique();
}

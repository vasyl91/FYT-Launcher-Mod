package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTOfficeArtExtensionList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOfficeArtExtensionList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctofficeartextensionlista211type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeArtExtensionList newInstance() {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.newInstance(CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList newInstance(XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.newInstance(CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(File file) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(file, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(file, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(Reader reader) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(reader, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(reader, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(String str) throws XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(str, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(str, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(URL url) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(url, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(url, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(Node node) throws XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(node, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(node, CTOfficeArtExtensionList.type, xmlOptions);
        }
    }

    CTOfficeArtExtension addNewExt();

    CTOfficeArtExtension getExtArray(int i);

    CTOfficeArtExtension[] getExtArray();

    List<CTOfficeArtExtension> getExtList();

    CTOfficeArtExtension insertNewExt(int i);

    void removeExt(int i);

    void setExtArray(int i, CTOfficeArtExtension cTOfficeArtExtension);

    void setExtArray(CTOfficeArtExtension[] cTOfficeArtExtensionArr);

    int sizeOfExtArray();
}

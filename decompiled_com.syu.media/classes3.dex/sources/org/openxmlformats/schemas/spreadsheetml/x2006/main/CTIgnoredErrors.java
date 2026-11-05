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
public interface CTIgnoredErrors extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTIgnoredErrors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctignorederrorsbebctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTIgnoredErrors newInstance() {
            return (CTIgnoredErrors) POIXMLTypeLoader.newInstance(CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors newInstance(XmlOptions xmlOptions) {
            return (CTIgnoredErrors) POIXMLTypeLoader.newInstance(CTIgnoredErrors.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(File file) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(file, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(file, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(inputStream, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(inputStream, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(Reader reader) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(reader, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(reader, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(String str) throws XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(str, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(str, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(URL url) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(url, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(url, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(xMLStreamReader, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(xMLStreamReader, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(xMLInputStream, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(xMLInputStream, CTIgnoredErrors.type, xmlOptions);
        }

        public static CTIgnoredErrors parse(Node node) throws XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(node, CTIgnoredErrors.type, (XmlOptions) null);
        }

        public static CTIgnoredErrors parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIgnoredErrors) POIXMLTypeLoader.parse(node, CTIgnoredErrors.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTIgnoredError addNewIgnoredError();

    CTExtensionList getExtLst();

    CTIgnoredError getIgnoredErrorArray(int i);

    CTIgnoredError[] getIgnoredErrorArray();

    List<CTIgnoredError> getIgnoredErrorList();

    CTIgnoredError insertNewIgnoredError(int i);

    boolean isSetExtLst();

    void removeIgnoredError(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIgnoredErrorArray(int i, CTIgnoredError cTIgnoredError);

    void setIgnoredErrorArray(CTIgnoredError[] cTIgnoredErrorArr);

    int sizeOfIgnoredErrorArray();

    void unsetExtLst();
}

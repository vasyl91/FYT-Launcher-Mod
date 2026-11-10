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
public interface CTExternalDefinedNames extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTExternalDefinedNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternaldefinednamesccf3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalDefinedNames newInstance() {
            return (CTExternalDefinedNames) POIXMLTypeLoader.newInstance(CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames newInstance(XmlOptions xmlOptions) {
            return (CTExternalDefinedNames) POIXMLTypeLoader.newInstance(CTExternalDefinedNames.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(File file) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(file, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(file, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(inputStream, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(inputStream, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(Reader reader) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(reader, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(reader, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(String str) throws XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(str, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(str, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(URL url) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(url, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(url, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(xMLInputStream, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(xMLInputStream, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(Node node) throws XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(node, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedNames) POIXMLTypeLoader.parse(node, CTExternalDefinedNames.type, xmlOptions);
        }
    }

    CTExternalDefinedName addNewDefinedName();

    CTExternalDefinedName getDefinedNameArray(int i);

    CTExternalDefinedName[] getDefinedNameArray();

    List<CTExternalDefinedName> getDefinedNameList();

    CTExternalDefinedName insertNewDefinedName(int i);

    void removeDefinedName(int i);

    void setDefinedNameArray(int i, CTExternalDefinedName cTExternalDefinedName);

    void setDefinedNameArray(CTExternalDefinedName[] cTExternalDefinedNameArr);

    int sizeOfDefinedNameArray();
}

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
public interface CTDefinedNames extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDefinedNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdefinednamesce48type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDefinedNames newInstance() {
            return (CTDefinedNames) POIXMLTypeLoader.newInstance(CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames newInstance(XmlOptions xmlOptions) {
            return (CTDefinedNames) POIXMLTypeLoader.newInstance(CTDefinedNames.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDefinedNames.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(File file) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(file, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(file, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(inputStream, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(inputStream, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(Reader reader) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(reader, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(reader, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(String str) throws XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(str, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(str, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(URL url) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(url, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(url, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(xMLStreamReader, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(xMLStreamReader, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(xMLInputStream, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(xMLInputStream, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(Node node) throws XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(node, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDefinedNames) POIXMLTypeLoader.parse(node, CTDefinedNames.type, xmlOptions);
        }
    }

    CTDefinedName addNewDefinedName();

    CTDefinedName getDefinedNameArray(int i);

    CTDefinedName[] getDefinedNameArray();

    List<CTDefinedName> getDefinedNameList();

    CTDefinedName insertNewDefinedName(int i);

    void removeDefinedName(int i);

    void setDefinedNameArray(int i, CTDefinedName cTDefinedName);

    void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr);

    int sizeOfDefinedNameArray();
}

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
public interface CTExternalSheetNames extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTExternalSheetNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalsheetnames7eddtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalSheetNames newInstance() {
            return (CTExternalSheetNames) POIXMLTypeLoader.newInstance(CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames newInstance(XmlOptions xmlOptions) {
            return (CTExternalSheetNames) POIXMLTypeLoader.newInstance(CTExternalSheetNames.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(File file) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(file, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(file, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(inputStream, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(inputStream, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(Reader reader) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(reader, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(reader, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(String str) throws XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(str, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(str, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(URL url) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(url, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(url, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(xMLInputStream, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(xMLInputStream, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(Node node) throws XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(node, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetNames) POIXMLTypeLoader.parse(node, CTExternalSheetNames.type, xmlOptions);
        }
    }

    CTExternalSheetName addNewSheetName();

    CTExternalSheetName getSheetNameArray(int i);

    CTExternalSheetName[] getSheetNameArray();

    List<CTExternalSheetName> getSheetNameList();

    CTExternalSheetName insertNewSheetName(int i);

    void removeSheetName(int i);

    void setSheetNameArray(int i, CTExternalSheetName cTExternalSheetName);

    void setSheetNameArray(CTExternalSheetName[] cTExternalSheetNameArr);

    int sizeOfSheetNameArray();
}

package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

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
public interface CTProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctproperties2c18type");

    public static final class Factory {
        private Factory() {
        }

        public static CTProperties newInstance() {
            return (CTProperties) POIXMLTypeLoader.newInstance(CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties newInstance(XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.newInstance(CTProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(File file) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(file, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(file, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(inputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(inputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Reader reader) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(reader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(reader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(String str) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(str, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(str, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(URL url) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(url, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(url, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLInputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Node node) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(node, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(node, CTProperties.type, xmlOptions);
        }
    }

    CTProperty addNewProperty();

    CTProperty getPropertyArray(int i);

    CTProperty[] getPropertyArray();

    List<CTProperty> getPropertyList();

    CTProperty insertNewProperty(int i);

    void removeProperty(int i);

    void setPropertyArray(int i, CTProperty cTProperty);

    void setPropertyArray(CTProperty[] cTPropertyArr);

    int sizeOfPropertyArray();
}

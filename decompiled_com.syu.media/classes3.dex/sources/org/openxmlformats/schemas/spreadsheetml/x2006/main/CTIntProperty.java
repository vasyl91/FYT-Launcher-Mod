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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTIntProperty extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTIntProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctintproperty32c3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTIntProperty newInstance() {
            return (CTIntProperty) POIXMLTypeLoader.newInstance(CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty newInstance(XmlOptions xmlOptions) {
            return (CTIntProperty) POIXMLTypeLoader.newInstance(CTIntProperty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIntProperty.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(File file) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(file, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(file, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(inputStream, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(inputStream, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(Reader reader) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(reader, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(reader, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(String str) throws XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(str, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(str, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(URL url) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(url, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) POIXMLTypeLoader.parse(url, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(xMLStreamReader, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(xMLStreamReader, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(xMLInputStream, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(xMLInputStream, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(Node node) throws XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(node, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIntProperty) POIXMLTypeLoader.parse(node, CTIntProperty.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    XmlInt xgetVal();

    void xsetVal(XmlInt xmlInt);
}

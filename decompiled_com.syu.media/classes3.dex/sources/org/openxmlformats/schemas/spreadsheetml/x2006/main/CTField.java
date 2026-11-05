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
public interface CTField extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfieldc999type");

    public static final class Factory {
        private Factory() {
        }

        public static CTField newInstance() {
            return (CTField) POIXMLTypeLoader.newInstance(CTField.type, (XmlOptions) null);
        }

        public static CTField newInstance(XmlOptions xmlOptions) {
            return (CTField) POIXMLTypeLoader.newInstance(CTField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTField.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTField.type, xmlOptions);
        }

        public static CTField parse(File file) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(file, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(file, CTField.type, xmlOptions);
        }

        public static CTField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(inputStream, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(inputStream, CTField.type, xmlOptions);
        }

        public static CTField parse(Reader reader) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(reader, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(reader, CTField.type, xmlOptions);
        }

        public static CTField parse(String str) throws XmlException {
            return (CTField) POIXMLTypeLoader.parse(str, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTField) POIXMLTypeLoader.parse(str, CTField.type, xmlOptions);
        }

        public static CTField parse(URL url) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(url, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) POIXMLTypeLoader.parse(url, CTField.type, xmlOptions);
        }

        public static CTField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTField) POIXMLTypeLoader.parse(xMLStreamReader, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTField) POIXMLTypeLoader.parse(xMLStreamReader, CTField.type, xmlOptions);
        }

        public static CTField parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTField) POIXMLTypeLoader.parse(xMLInputStream, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTField) POIXMLTypeLoader.parse(xMLInputStream, CTField.type, xmlOptions);
        }

        public static CTField parse(Node node) throws XmlException {
            return (CTField) POIXMLTypeLoader.parse(node, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTField) POIXMLTypeLoader.parse(node, CTField.type, xmlOptions);
        }
    }

    int getX();

    void setX(int i);

    XmlInt xgetX();

    void xsetX(XmlInt xmlInt);
}

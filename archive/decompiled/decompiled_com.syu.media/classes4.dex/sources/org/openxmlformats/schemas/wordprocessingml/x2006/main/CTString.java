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
public interface CTString extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTString.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstring9c37type");

    public static final class Factory {
        private Factory() {
        }

        public static CTString newInstance() {
            return (CTString) POIXMLTypeLoader.newInstance(CTString.type, (XmlOptions) null);
        }

        public static CTString newInstance(XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.newInstance(CTString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTString.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTString.type, xmlOptions);
        }

        public static CTString parse(File file) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(file, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(file, CTString.type, xmlOptions);
        }

        public static CTString parse(InputStream inputStream) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(inputStream, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(inputStream, CTString.type, xmlOptions);
        }

        public static CTString parse(Reader reader) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(reader, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(reader, CTString.type, xmlOptions);
        }

        public static CTString parse(String str) throws XmlException {
            return (CTString) POIXMLTypeLoader.parse(str, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTString) POIXMLTypeLoader.parse(str, CTString.type, xmlOptions);
        }

        public static CTString parse(URL url) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(url, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTString) POIXMLTypeLoader.parse(url, CTString.type, xmlOptions);
        }

        public static CTString parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTString) POIXMLTypeLoader.parse(xMLStreamReader, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTString) POIXMLTypeLoader.parse(xMLStreamReader, CTString.type, xmlOptions);
        }

        public static CTString parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTString) POIXMLTypeLoader.parse(xMLInputStream, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTString) POIXMLTypeLoader.parse(xMLInputStream, CTString.type, xmlOptions);
        }

        public static CTString parse(Node node) throws XmlException {
            return (CTString) POIXMLTypeLoader.parse(node, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTString) POIXMLTypeLoader.parse(node, CTString.type, xmlOptions);
        }
    }

    String getVal();

    void setVal(String str);

    STString xgetVal();

    void xsetVal(STString sTString);
}

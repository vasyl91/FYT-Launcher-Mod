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
public interface CTLang extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLang.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlangda3atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLang newInstance() {
            return (CTLang) POIXMLTypeLoader.newInstance(CTLang.type, (XmlOptions) null);
        }

        public static CTLang newInstance(XmlOptions xmlOptions) {
            return (CTLang) POIXMLTypeLoader.newInstance(CTLang.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLang.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLang.type, xmlOptions);
        }

        public static CTLang parse(File file) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(file, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(file, CTLang.type, xmlOptions);
        }

        public static CTLang parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(inputStream, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(inputStream, CTLang.type, xmlOptions);
        }

        public static CTLang parse(Reader reader) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(reader, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(reader, CTLang.type, xmlOptions);
        }

        public static CTLang parse(String str) throws XmlException {
            return (CTLang) POIXMLTypeLoader.parse(str, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLang) POIXMLTypeLoader.parse(str, CTLang.type, xmlOptions);
        }

        public static CTLang parse(URL url) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(url, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLang) POIXMLTypeLoader.parse(url, CTLang.type, xmlOptions);
        }

        public static CTLang parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLang) POIXMLTypeLoader.parse(xMLStreamReader, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLang) POIXMLTypeLoader.parse(xMLStreamReader, CTLang.type, xmlOptions);
        }

        public static CTLang parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLang) POIXMLTypeLoader.parse(xMLInputStream, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLang) POIXMLTypeLoader.parse(xMLInputStream, CTLang.type, xmlOptions);
        }

        public static CTLang parse(Node node) throws XmlException {
            return (CTLang) POIXMLTypeLoader.parse(node, CTLang.type, (XmlOptions) null);
        }

        public static CTLang parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLang) POIXMLTypeLoader.parse(node, CTLang.type, xmlOptions);
        }
    }

    Object getVal();

    void setVal(Object obj);

    STLang xgetVal();

    void xsetVal(STLang sTLang);
}

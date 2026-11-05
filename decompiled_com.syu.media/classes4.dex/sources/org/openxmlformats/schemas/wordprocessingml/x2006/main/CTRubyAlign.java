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
public interface CTRubyAlign extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRubyAlign.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrubyalign41e7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRubyAlign newInstance() {
            return (CTRubyAlign) POIXMLTypeLoader.newInstance(CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign newInstance(XmlOptions xmlOptions) {
            return (CTRubyAlign) POIXMLTypeLoader.newInstance(CTRubyAlign.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRubyAlign.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(File file) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(file, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(file, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(inputStream, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(inputStream, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(Reader reader) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(reader, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(reader, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(String str) throws XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(str, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(str, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(URL url) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(url, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(url, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(xMLStreamReader, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(xMLStreamReader, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(xMLInputStream, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(xMLInputStream, CTRubyAlign.type, xmlOptions);
        }

        public static CTRubyAlign parse(Node node) throws XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(node, CTRubyAlign.type, (XmlOptions) null);
        }

        public static CTRubyAlign parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRubyAlign) POIXMLTypeLoader.parse(node, CTRubyAlign.type, xmlOptions);
        }
    }

    STRubyAlign$Enum getVal();

    void setVal(STRubyAlign$Enum sTRubyAlign$Enum);

    STRubyAlign xgetVal();

    void xsetVal(STRubyAlign sTRubyAlign);
}

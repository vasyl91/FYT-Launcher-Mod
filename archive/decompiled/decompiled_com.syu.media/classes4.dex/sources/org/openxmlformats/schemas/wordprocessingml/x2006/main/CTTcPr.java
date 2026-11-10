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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTTcPr extends CTTcPrInner {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttcpree37type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcPr newInstance() {
            return (CTTcPr) POIXMLTypeLoader.newInstance(CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr newInstance(XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.newInstance(CTTcPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(File file) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(file, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(file, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(inputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(inputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(Reader reader) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(reader, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(reader, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(String str) throws XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(str, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(str, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(URL url) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(url, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) POIXMLTypeLoader.parse(url, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLInputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLInputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(Node node) throws XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(node, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPr) POIXMLTypeLoader.parse(node, CTTcPr.type, xmlOptions);
        }
    }

    CTTcPrChange addNewTcPrChange();

    CTTcPrChange getTcPrChange();

    boolean isSetTcPrChange();

    void setTcPrChange(CTTcPrChange cTTcPrChange);

    void unsetTcPrChange();
}

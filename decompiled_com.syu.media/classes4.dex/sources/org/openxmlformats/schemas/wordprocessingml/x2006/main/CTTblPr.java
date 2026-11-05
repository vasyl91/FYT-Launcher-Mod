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
public interface CTTblPr extends CTTblPrBase {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblpr5b72type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPr newInstance() {
            return (CTTblPr) POIXMLTypeLoader.newInstance(CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr newInstance(XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.newInstance(CTTblPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(File file) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(file, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(file, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(inputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(inputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(Reader reader) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(reader, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(reader, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(String str) throws XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(str, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(str, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(URL url) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(url, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) POIXMLTypeLoader.parse(url, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLInputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLInputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(Node node) throws XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(node, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPr) POIXMLTypeLoader.parse(node, CTTblPr.type, xmlOptions);
        }
    }

    CTTblPrChange addNewTblPrChange();

    CTTblPrChange getTblPrChange();

    boolean isSetTblPrChange();

    void setTblPrChange(CTTblPrChange cTTblPrChange);

    void unsetTblPrChange();
}

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
public interface CTTblPrEx extends CTTblPrExBase {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblPrEx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblprex863ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrEx newInstance() {
            return (CTTblPrEx) POIXMLTypeLoader.newInstance(CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx newInstance(XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.newInstance(CTTblPrEx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(File file) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(file, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(file, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(inputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(inputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(Reader reader) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(reader, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(reader, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(String str) throws XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(str, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(str, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(URL url) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(url, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(url, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(Node node) throws XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(node, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrEx) POIXMLTypeLoader.parse(node, CTTblPrEx.type, xmlOptions);
        }
    }

    CTTblPrExChange addNewTblPrExChange();

    CTTblPrExChange getTblPrExChange();

    boolean isSetTblPrExChange();

    void setTblPrExChange(CTTblPrExChange cTTblPrExChange);

    void unsetTblPrExChange();
}

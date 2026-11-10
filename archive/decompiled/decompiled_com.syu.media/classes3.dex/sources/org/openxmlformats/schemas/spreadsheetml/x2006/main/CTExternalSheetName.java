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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTExternalSheetName extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTExternalSheetName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalsheetnamefcdetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalSheetName newInstance() {
            return (CTExternalSheetName) POIXMLTypeLoader.newInstance(CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName newInstance(XmlOptions xmlOptions) {
            return (CTExternalSheetName) POIXMLTypeLoader.newInstance(CTExternalSheetName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(File file) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(file, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(file, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(inputStream, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(inputStream, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(Reader reader) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(reader, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(reader, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(String str) throws XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(str, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(str, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(URL url) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(url, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(url, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(xMLStreamReader, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(xMLInputStream, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(xMLInputStream, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(Node node) throws XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(node, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetName) POIXMLTypeLoader.parse(node, CTExternalSheetName.type, xmlOptions);
        }
    }

    String getVal();

    boolean isSetVal();

    void setVal(String str);

    void unsetVal();

    STXstring xgetVal();

    void xsetVal(STXstring sTXstring);
}

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
public interface CTSheetDimension extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSheetDimension.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetdimensiond310type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetDimension newInstance() {
            return (CTSheetDimension) POIXMLTypeLoader.newInstance(CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension newInstance(XmlOptions xmlOptions) {
            return (CTSheetDimension) POIXMLTypeLoader.newInstance(CTSheetDimension.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetDimension.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(File file) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(file, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(file, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(inputStream, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(inputStream, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(Reader reader) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(reader, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(reader, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(String str) throws XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(str, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(str, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(URL url) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(url, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(url, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(xMLInputStream, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(xMLInputStream, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(Node node) throws XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(node, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetDimension) POIXMLTypeLoader.parse(node, CTSheetDimension.type, xmlOptions);
        }
    }

    String getRef();

    void setRef(String str);

    STRef xgetRef();

    void xsetRef(STRef sTRef);
}

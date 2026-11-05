package com.microsoft.schemas.office.visio.x2012.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface MastersDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MastersDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("masters0341doctype");

    public static final class Factory {
        private Factory() {
        }

        public static MastersDocument newInstance() {
            return (MastersDocument) POIXMLTypeLoader.newInstance(MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument newInstance(XmlOptions xmlOptions) {
            return (MastersDocument) POIXMLTypeLoader.newInstance(MastersDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MastersDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(File file) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(file, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(file, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(inputStream, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(inputStream, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(Reader reader) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(reader, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(reader, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(String str) throws XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(str, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(str, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(URL url) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(url, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersDocument) POIXMLTypeLoader.parse(url, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(xMLStreamReader, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(xMLStreamReader, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(xMLInputStream, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(xMLInputStream, MastersDocument.type, xmlOptions);
        }

        public static MastersDocument parse(Node node) throws XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(node, MastersDocument.type, (XmlOptions) null);
        }

        public static MastersDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MastersDocument) POIXMLTypeLoader.parse(node, MastersDocument.type, xmlOptions);
        }
    }

    MastersType addNewMasters();

    MastersType getMasters();

    void setMasters(MastersType mastersType);
}

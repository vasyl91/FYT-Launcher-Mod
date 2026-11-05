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
public interface MasterContentsDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MasterContentsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("mastercontentscb9edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static MasterContentsDocument newInstance() {
            return (MasterContentsDocument) POIXMLTypeLoader.newInstance(MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument newInstance(XmlOptions xmlOptions) {
            return (MasterContentsDocument) POIXMLTypeLoader.newInstance(MasterContentsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(File file) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(file, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(file, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(inputStream, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(inputStream, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(Reader reader) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(reader, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(reader, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(String str) throws XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(str, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(str, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(URL url) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(url, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(url, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(xMLStreamReader, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(xMLStreamReader, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(xMLInputStream, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(xMLInputStream, MasterContentsDocument.type, xmlOptions);
        }

        public static MasterContentsDocument parse(Node node) throws XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(node, MasterContentsDocument.type, (XmlOptions) null);
        }

        public static MasterContentsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MasterContentsDocument) POIXMLTypeLoader.parse(node, MasterContentsDocument.type, xmlOptions);
        }
    }

    PageContentsType addNewMasterContents();

    PageContentsType getMasterContents();

    void setMasterContents(PageContentsType pageContentsType);
}

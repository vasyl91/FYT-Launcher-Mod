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
public interface FtrDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(FtrDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ftre182doctype");

    public static final class Factory {
        private Factory() {
        }

        public static FtrDocument newInstance() {
            return (FtrDocument) POIXMLTypeLoader.newInstance(FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument newInstance(XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.newInstance(FtrDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(File file) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(file, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(file, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(inputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(inputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(Reader reader) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(reader, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(reader, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(String str) throws XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(str, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(str, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(URL url) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(url, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) POIXMLTypeLoader.parse(url, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLStreamReader, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLStreamReader, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLInputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLInputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(Node node) throws XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(node, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FtrDocument) POIXMLTypeLoader.parse(node, FtrDocument.type, xmlOptions);
        }
    }

    CTHdrFtr addNewFtr();

    CTHdrFtr getFtr();

    void setFtr(CTHdrFtr cTHdrFtr);
}

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
public interface HdrDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(HdrDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("hdra530doctype");

    public static final class Factory {
        private Factory() {
        }

        public static HdrDocument newInstance() {
            return (HdrDocument) POIXMLTypeLoader.newInstance(HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument newInstance(XmlOptions xmlOptions) {
            return (HdrDocument) POIXMLTypeLoader.newInstance(HdrDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, HdrDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(File file) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(file, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(file, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(inputStream, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(inputStream, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(Reader reader) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(reader, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(reader, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(String str) throws XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(str, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(str, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(URL url) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(url, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) POIXMLTypeLoader.parse(url, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(xMLStreamReader, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(xMLStreamReader, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(xMLInputStream, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(xMLInputStream, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(Node node) throws XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(node, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (HdrDocument) POIXMLTypeLoader.parse(node, HdrDocument.type, xmlOptions);
        }
    }

    CTHdrFtr addNewHdr();

    CTHdrFtr getHdr();

    void setHdr(CTHdrFtr cTHdrFtr);
}

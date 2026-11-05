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
public interface CTPictureBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPictureBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturebase5f83type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureBase newInstance() {
            return (CTPictureBase) POIXMLTypeLoader.newInstance(CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase newInstance(XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.newInstance(CTPictureBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(File file) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(file, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(file, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(inputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(inputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(Reader reader) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(reader, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(reader, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(String str) throws XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(str, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(str, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(URL url) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(url, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) POIXMLTypeLoader.parse(url, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLInputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLInputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(Node node) throws XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(node, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureBase) POIXMLTypeLoader.parse(node, CTPictureBase.type, xmlOptions);
        }
    }
}

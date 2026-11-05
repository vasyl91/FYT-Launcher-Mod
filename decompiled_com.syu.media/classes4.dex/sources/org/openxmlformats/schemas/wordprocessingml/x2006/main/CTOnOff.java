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
public interface CTOnOff extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOnOff.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctonoff04c2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOnOff newInstance() {
            return (CTOnOff) POIXMLTypeLoader.newInstance(CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff newInstance(XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.newInstance(CTOnOff.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(File file) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(file, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(file, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(inputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(inputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(Reader reader) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(reader, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(reader, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(String str) throws XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(str, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(str, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(URL url) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(url, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) POIXMLTypeLoader.parse(url, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLStreamReader, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLStreamReader, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLInputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLInputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(Node node) throws XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(node, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOnOff) POIXMLTypeLoader.parse(node, CTOnOff.type, xmlOptions);
        }
    }

    STOnOff.Enum getVal();

    boolean isSetVal();

    void setVal(STOnOff.Enum r1);

    void unsetVal();

    STOnOff xgetVal();

    void xsetVal(STOnOff sTOnOff);
}

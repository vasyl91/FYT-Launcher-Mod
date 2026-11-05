package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTFixedPercentage extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfixedpercentagea2dftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFixedPercentage newInstance() {
            return (CTFixedPercentage) POIXMLTypeLoader.newInstance(CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.newInstance(CTFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(File file) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(file, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(file, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(inputStream, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(inputStream, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(Reader reader) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(reader, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(reader, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(String str) throws XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(str, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(str, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(URL url) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(url, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(url, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(Node node) throws XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(node, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(node, CTFixedPercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STFixedPercentage xgetVal();

    void xsetVal(STFixedPercentage sTFixedPercentage);
}

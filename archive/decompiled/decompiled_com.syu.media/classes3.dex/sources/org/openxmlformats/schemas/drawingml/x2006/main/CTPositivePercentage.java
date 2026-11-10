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
public interface CTPositivePercentage extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPositivePercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpositivepercentage2f8etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositivePercentage newInstance() {
            return (CTPositivePercentage) POIXMLTypeLoader.newInstance(CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage newInstance(XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.newInstance(CTPositivePercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(File file) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(file, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(file, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(inputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(inputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(Reader reader) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(reader, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(reader, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(String str) throws XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(str, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(str, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(URL url) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(url, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(url, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(Node node) throws XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(node, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(node, CTPositivePercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPositivePercentage xgetVal();

    void xsetVal(STPositivePercentage sTPositivePercentage);
}

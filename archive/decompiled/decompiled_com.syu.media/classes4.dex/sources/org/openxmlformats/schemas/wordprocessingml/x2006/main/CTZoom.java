package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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
public interface CTZoom extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTZoom.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctzoomc275type");

    public static final class Factory {
        private Factory() {
        }

        public static CTZoom newInstance() {
            return (CTZoom) POIXMLTypeLoader.newInstance(CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom newInstance(XmlOptions xmlOptions) {
            return (CTZoom) POIXMLTypeLoader.newInstance(CTZoom.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTZoom.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(File file) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(file, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(file, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(InputStream inputStream) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(inputStream, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(inputStream, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(Reader reader) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(reader, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(reader, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(String str) throws XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(str, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(str, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(URL url) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(url, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) POIXMLTypeLoader.parse(url, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(xMLStreamReader, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(xMLStreamReader, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(xMLInputStream, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(xMLInputStream, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(Node node) throws XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(node, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTZoom) POIXMLTypeLoader.parse(node, CTZoom.type, xmlOptions);
        }
    }

    BigInteger getPercent();

    STZoom$Enum getVal();

    boolean isSetVal();

    void setPercent(BigInteger bigInteger);

    void setVal(STZoom$Enum sTZoom$Enum);

    void unsetVal();

    STDecimalNumber xgetPercent();

    STZoom xgetVal();

    void xsetPercent(STDecimalNumber sTDecimalNumber);

    void xsetVal(STZoom sTZoom);
}

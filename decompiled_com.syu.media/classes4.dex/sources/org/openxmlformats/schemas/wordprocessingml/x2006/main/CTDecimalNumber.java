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
public interface CTDecimalNumber extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdecimalnumbera518type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDecimalNumber newInstance() {
            return (CTDecimalNumber) POIXMLTypeLoader.newInstance(CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.newInstance(CTDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(File file) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(file, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(file, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(inputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(inputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(Reader reader) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(reader, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(reader, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(String str) throws XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(str, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(str, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(URL url) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(url, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(url, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(Node node) throws XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(node, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(node, CTDecimalNumber.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STDecimalNumber xgetVal();

    void xsetVal(STDecimalNumber sTDecimalNumber);
}

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
public interface CTSignedHpsMeasure extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSignedHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsignedhpsmeasure3099type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSignedHpsMeasure newInstance() {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.newInstance(CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.newInstance(CTSignedHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(File file) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(file, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(file, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(reader, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(reader, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(String str) throws XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(str, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(str, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(URL url) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(url, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(url, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(Node node) throws XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(node, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(node, CTSignedHpsMeasure.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STSignedHpsMeasure xgetVal();

    void xsetVal(STSignedHpsMeasure sTSignedHpsMeasure);
}

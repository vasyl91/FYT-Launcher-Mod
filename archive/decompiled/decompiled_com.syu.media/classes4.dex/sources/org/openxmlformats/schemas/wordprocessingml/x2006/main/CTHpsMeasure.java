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
public interface CTHpsMeasure extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthpsmeasure3795type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHpsMeasure newInstance() {
            return (CTHpsMeasure) POIXMLTypeLoader.newInstance(CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.newInstance(CTHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(File file) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(file, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(file, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(reader, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(reader, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(String str) throws XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(str, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(str, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(URL url) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(url, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(url, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(Node node) throws XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(node, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(node, CTHpsMeasure.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STHpsMeasure xgetVal();

    void xsetVal(STHpsMeasure sTHpsMeasure);
}

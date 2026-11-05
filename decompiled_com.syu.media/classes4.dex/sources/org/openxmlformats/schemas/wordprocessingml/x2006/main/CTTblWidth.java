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
public interface CTTblWidth extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblwidthec40type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblWidth newInstance() {
            return (CTTblWidth) POIXMLTypeLoader.newInstance(CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth newInstance(XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.newInstance(CTTblWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(File file) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(file, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(file, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(inputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(inputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(Reader reader) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(reader, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(reader, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(String str) throws XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(str, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(str, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(URL url) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(url, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) POIXMLTypeLoader.parse(url, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLStreamReader, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLStreamReader, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLInputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLInputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(Node node) throws XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(node, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblWidth) POIXMLTypeLoader.parse(node, CTTblWidth.type, xmlOptions);
        }
    }

    STTblWidth.Enum getType();

    BigInteger getW();

    boolean isSetType();

    boolean isSetW();

    void setType(STTblWidth.Enum r1);

    void setW(BigInteger bigInteger);

    void unsetType();

    void unsetW();

    STTblWidth xgetType();

    STDecimalNumber xgetW();

    void xsetType(STTblWidth sTTblWidth);

    void xsetW(STDecimalNumber sTDecimalNumber);
}

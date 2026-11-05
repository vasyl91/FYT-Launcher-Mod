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
public interface CTTblGridCol extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblGridCol.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblgridcolbfectype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblGridCol newInstance() {
            return (CTTblGridCol) POIXMLTypeLoader.newInstance(CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol newInstance(XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.newInstance(CTTblGridCol.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridCol.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(File file) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(file, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(file, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(inputStream, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(inputStream, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(Reader reader) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(reader, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(reader, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(String str) throws XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(str, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(str, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(URL url) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(url, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(url, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(Node node) throws XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(node, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGridCol) POIXMLTypeLoader.parse(node, CTTblGridCol.type, xmlOptions);
        }
    }

    BigInteger getW();

    boolean isSetW();

    void setW(BigInteger bigInteger);

    void unsetW();

    STTwipsMeasure xgetW();

    void xsetW(STTwipsMeasure sTTwipsMeasure);
}

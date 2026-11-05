package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTRElt extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRElt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrelt6464type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRElt newInstance() {
            return (CTRElt) POIXMLTypeLoader.newInstance(CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt newInstance(XmlOptions xmlOptions) {
            return (CTRElt) POIXMLTypeLoader.newInstance(CTRElt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRElt.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(File file) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(file, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(file, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(inputStream, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(inputStream, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(Reader reader) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(reader, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(reader, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(String str) throws XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(str, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(str, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(URL url) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(url, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) POIXMLTypeLoader.parse(url, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(xMLStreamReader, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(xMLStreamReader, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(xMLInputStream, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(xMLInputStream, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(Node node) throws XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(node, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRElt) POIXMLTypeLoader.parse(node, CTRElt.type, xmlOptions);
        }
    }

    CTRPrElt addNewRPr();

    CTRPrElt getRPr();

    String getT();

    boolean isSetRPr();

    void setRPr(CTRPrElt cTRPrElt);

    void setT(String str);

    void unsetRPr();

    STXstring xgetT();

    void xsetT(STXstring sTXstring);
}

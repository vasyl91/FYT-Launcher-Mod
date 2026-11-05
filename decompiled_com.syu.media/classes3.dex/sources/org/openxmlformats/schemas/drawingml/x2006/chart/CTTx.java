package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTx extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttx9678type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTx newInstance() {
            return (CTTx) POIXMLTypeLoader.newInstance(CTTx.type, (XmlOptions) null);
        }

        public static CTTx newInstance(XmlOptions xmlOptions) {
            return (CTTx) POIXMLTypeLoader.newInstance(CTTx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTx.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTx.type, xmlOptions);
        }

        public static CTTx parse(File file) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(file, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(file, CTTx.type, xmlOptions);
        }

        public static CTTx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(inputStream, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(inputStream, CTTx.type, xmlOptions);
        }

        public static CTTx parse(Reader reader) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(reader, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(reader, CTTx.type, xmlOptions);
        }

        public static CTTx parse(String str) throws XmlException {
            return (CTTx) POIXMLTypeLoader.parse(str, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTx) POIXMLTypeLoader.parse(str, CTTx.type, xmlOptions);
        }

        public static CTTx parse(URL url) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(url, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) POIXMLTypeLoader.parse(url, CTTx.type, xmlOptions);
        }

        public static CTTx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTx) POIXMLTypeLoader.parse(xMLStreamReader, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTx) POIXMLTypeLoader.parse(xMLStreamReader, CTTx.type, xmlOptions);
        }

        public static CTTx parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTx) POIXMLTypeLoader.parse(xMLInputStream, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTx) POIXMLTypeLoader.parse(xMLInputStream, CTTx.type, xmlOptions);
        }

        public static CTTx parse(Node node) throws XmlException {
            return (CTTx) POIXMLTypeLoader.parse(node, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTx) POIXMLTypeLoader.parse(node, CTTx.type, xmlOptions);
        }
    }

    CTTextBody addNewRich();

    CTStrRef addNewStrRef();

    CTTextBody getRich();

    CTStrRef getStrRef();

    boolean isSetRich();

    boolean isSetStrRef();

    void setRich(CTTextBody cTTextBody);

    void setStrRef(CTStrRef cTStrRef);

    void unsetRich();

    void unsetStrRef();
}

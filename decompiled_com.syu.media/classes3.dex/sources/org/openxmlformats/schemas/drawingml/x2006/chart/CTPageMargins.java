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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPageMargins extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPageMargins.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagemarginsb730type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageMargins newInstance() {
            return (CTPageMargins) POIXMLTypeLoader.newInstance(CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins newInstance(XmlOptions xmlOptions) {
            return (CTPageMargins) POIXMLTypeLoader.newInstance(CTPageMargins.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageMargins.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(File file) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(file, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(file, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(inputStream, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(inputStream, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(Reader reader) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(reader, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(reader, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(String str) throws XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(str, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(str, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(URL url) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(url, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) POIXMLTypeLoader.parse(url, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(xMLStreamReader, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(xMLStreamReader, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(xMLInputStream, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(xMLInputStream, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(Node node) throws XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(node, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageMargins) POIXMLTypeLoader.parse(node, CTPageMargins.type, xmlOptions);
        }
    }

    double getB();

    double getFooter();

    double getHeader();

    double getL();

    double getR();

    double getT();

    void setB(double d);

    void setFooter(double d);

    void setHeader(double d);

    void setL(double d);

    void setR(double d);

    void setT(double d);

    XmlDouble xgetB();

    XmlDouble xgetFooter();

    XmlDouble xgetHeader();

    XmlDouble xgetL();

    XmlDouble xgetR();

    XmlDouble xgetT();

    void xsetB(XmlDouble xmlDouble);

    void xsetFooter(XmlDouble xmlDouble);

    void xsetHeader(XmlDouble xmlDouble);

    void xsetL(XmlDouble xmlDouble);

    void xsetR(XmlDouble xmlDouble);

    void xsetT(XmlDouble xmlDouble);
}

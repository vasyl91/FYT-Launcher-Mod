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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTScatterStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTScatterStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctscatterstyle94c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTScatterStyle newInstance() {
            return (CTScatterStyle) POIXMLTypeLoader.newInstance(CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle newInstance(XmlOptions xmlOptions) {
            return (CTScatterStyle) POIXMLTypeLoader.newInstance(CTScatterStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTScatterStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(File file) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(file, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(file, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(inputStream, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(inputStream, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(Reader reader) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(reader, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(reader, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(String str) throws XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(str, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(str, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(URL url) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(url, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(url, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(xMLInputStream, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(xMLInputStream, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(Node node) throws XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(node, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterStyle) POIXMLTypeLoader.parse(node, CTScatterStyle.type, xmlOptions);
        }
    }

    STScatterStyle.Enum getVal();

    boolean isSetVal();

    void setVal(STScatterStyle.Enum r1);

    void unsetVal();

    STScatterStyle xgetVal();

    void xsetVal(STScatterStyle sTScatterStyle);
}

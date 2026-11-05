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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTBoolean extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBoolean.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbooleancc3etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBoolean newInstance() {
            return (CTBoolean) POIXMLTypeLoader.newInstance(CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean newInstance(XmlOptions xmlOptions) {
            return (CTBoolean) POIXMLTypeLoader.newInstance(CTBoolean.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBoolean.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(File file) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(file, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(file, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(inputStream, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(inputStream, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(Reader reader) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(reader, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(reader, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(String str) throws XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(str, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(str, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(URL url) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(url, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) POIXMLTypeLoader.parse(url, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(xMLStreamReader, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(xMLStreamReader, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(xMLInputStream, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(xMLInputStream, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(Node node) throws XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(node, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBoolean) POIXMLTypeLoader.parse(node, CTBoolean.type, xmlOptions);
        }
    }

    boolean getVal();

    boolean isSetVal();

    void setVal(boolean z);

    void unsetVal();

    XmlBoolean xgetVal();

    void xsetVal(XmlBoolean xmlBoolean);
}

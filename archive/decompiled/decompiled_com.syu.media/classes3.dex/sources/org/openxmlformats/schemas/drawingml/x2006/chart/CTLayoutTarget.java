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
public interface CTLayoutTarget extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLayoutTarget.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlayouttarget1001type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLayoutTarget newInstance() {
            return (CTLayoutTarget) POIXMLTypeLoader.newInstance(CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget newInstance(XmlOptions xmlOptions) {
            return (CTLayoutTarget) POIXMLTypeLoader.newInstance(CTLayoutTarget.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(File file) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(file, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(file, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(inputStream, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(inputStream, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(Reader reader) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(reader, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(reader, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(String str) throws XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(str, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(str, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(URL url) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(url, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(url, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(xMLStreamReader, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(xMLStreamReader, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(xMLInputStream, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(xMLInputStream, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(Node node) throws XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(node, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutTarget) POIXMLTypeLoader.parse(node, CTLayoutTarget.type, xmlOptions);
        }
    }

    STLayoutTarget.Enum getVal();

    boolean isSetVal();

    void setVal(STLayoutTarget.Enum r1);

    void unsetVal();

    STLayoutTarget xgetVal();

    void xsetVal(STLayoutTarget sTLayoutTarget);
}

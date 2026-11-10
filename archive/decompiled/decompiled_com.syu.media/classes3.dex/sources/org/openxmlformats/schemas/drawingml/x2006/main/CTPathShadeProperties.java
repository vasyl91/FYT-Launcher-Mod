package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTPathShadeProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPathShadeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpathshadeproperties7ccctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPathShadeProperties newInstance() {
            return (CTPathShadeProperties) POIXMLTypeLoader.newInstance(CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties newInstance(XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.newInstance(CTPathShadeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(File file) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(file, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(file, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(inputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(inputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(Reader reader) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(reader, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(reader, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(String str) throws XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(str, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(str, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(URL url) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(url, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(url, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(Node node) throws XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(node, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(node, CTPathShadeProperties.type, xmlOptions);
        }
    }

    CTRelativeRect addNewFillToRect();

    CTRelativeRect getFillToRect();

    STPathShadeType.Enum getPath();

    boolean isSetFillToRect();

    boolean isSetPath();

    void setFillToRect(CTRelativeRect cTRelativeRect);

    void setPath(STPathShadeType.Enum r1);

    void unsetFillToRect();

    void unsetPath();

    STPathShadeType xgetPath();

    void xsetPath(STPathShadeType sTPathShadeType);
}

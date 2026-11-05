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
public interface CTTextSpacingPoint extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextSpacingPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextspacingpoint6cf5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacingPoint newInstance() {
            return (CTTextSpacingPoint) POIXMLTypeLoader.newInstance(CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.newInstance(CTTextSpacingPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(File file) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(file, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(file, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(inputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(inputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(Reader reader) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(reader, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(reader, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(String str) throws XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(str, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(str, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(URL url) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(url, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(url, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(Node node) throws XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(node, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(node, CTTextSpacingPoint.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STTextSpacingPoint xgetVal();

    void xsetVal(STTextSpacingPoint sTTextSpacingPoint);
}

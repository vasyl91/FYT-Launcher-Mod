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
public interface CTTextShapeAutofit extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextShapeAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextshapeautofita009type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextShapeAutofit newInstance() {
            return (CTTextShapeAutofit) POIXMLTypeLoader.newInstance(CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.newInstance(CTTextShapeAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(File file) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(file, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(file, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(inputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(inputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(Reader reader) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(reader, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(reader, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(String str) throws XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(str, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(str, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(URL url) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(url, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(url, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(Node node) throws XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(node, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(node, CTTextShapeAutofit.type, xmlOptions);
        }
    }
}

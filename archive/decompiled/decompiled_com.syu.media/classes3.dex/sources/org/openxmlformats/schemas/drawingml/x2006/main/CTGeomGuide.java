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
public interface CTGeomGuide extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGeomGuide.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgeomguidef191type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomGuide newInstance() {
            return (CTGeomGuide) POIXMLTypeLoader.newInstance(CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide newInstance(XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.newInstance(CTGeomGuide.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(File file) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(file, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(file, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(inputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(inputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(Reader reader) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(reader, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(reader, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(String str) throws XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(str, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(str, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(URL url) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(url, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(url, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(Node node) throws XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(node, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuide) POIXMLTypeLoader.parse(node, CTGeomGuide.type, xmlOptions);
        }
    }

    String getFmla();

    String getName();

    void setFmla(String str);

    void setName(String str);

    STGeomGuideFormula xgetFmla();

    STGeomGuideName xgetName();

    void xsetFmla(STGeomGuideFormula sTGeomGuideFormula);

    void xsetName(STGeomGuideName sTGeomGuideName);
}

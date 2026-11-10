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
public interface CTPresetGeometry2D extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPresetGeometry2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpresetgeometry2db1detype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPresetGeometry2D newInstance() {
            return (CTPresetGeometry2D) POIXMLTypeLoader.newInstance(CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D newInstance(XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.newInstance(CTPresetGeometry2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(File file) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(file, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(file, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(inputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(inputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(Reader reader) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(reader, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(reader, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(String str) throws XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(str, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(str, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(URL url) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(url, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(url, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLInputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLInputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(Node node) throws XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(node, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(node, CTPresetGeometry2D.type, xmlOptions);
        }
    }

    CTGeomGuideList addNewAvLst();

    CTGeomGuideList getAvLst();

    STShapeType.Enum getPrst();

    boolean isSetAvLst();

    void setAvLst(CTGeomGuideList cTGeomGuideList);

    void setPrst(STShapeType.Enum r1);

    void unsetAvLst();

    STShapeType xgetPrst();

    void xsetPrst(STShapeType sTShapeType);
}

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
public interface CTCustomGeometry2D extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCustomGeometry2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcustomgeometry2dca70type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCustomGeometry2D newInstance() {
            return (CTCustomGeometry2D) POIXMLTypeLoader.newInstance(CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D newInstance(XmlOptions xmlOptions) {
            return (CTCustomGeometry2D) POIXMLTypeLoader.newInstance(CTCustomGeometry2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(File file) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(file, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(file, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(inputStream, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(inputStream, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(Reader reader) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(reader, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(reader, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(String str) throws XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(str, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(str, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(URL url) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(url, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(url, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(xMLStreamReader, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(xMLStreamReader, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(xMLInputStream, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(xMLInputStream, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(Node node) throws XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(node, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomGeometry2D) POIXMLTypeLoader.parse(node, CTCustomGeometry2D.type, xmlOptions);
        }
    }

    CTAdjustHandleList addNewAhLst();

    CTGeomGuideList addNewAvLst();

    CTConnectionSiteList addNewCxnLst();

    CTGeomGuideList addNewGdLst();

    CTPath2DList addNewPathLst();

    CTGeomRect addNewRect();

    CTAdjustHandleList getAhLst();

    CTGeomGuideList getAvLst();

    CTConnectionSiteList getCxnLst();

    CTGeomGuideList getGdLst();

    CTPath2DList getPathLst();

    CTGeomRect getRect();

    boolean isSetAhLst();

    boolean isSetAvLst();

    boolean isSetCxnLst();

    boolean isSetGdLst();

    boolean isSetRect();

    void setAhLst(CTAdjustHandleList cTAdjustHandleList);

    void setAvLst(CTGeomGuideList cTGeomGuideList);

    void setCxnLst(CTConnectionSiteList cTConnectionSiteList);

    void setGdLst(CTGeomGuideList cTGeomGuideList);

    void setPathLst(CTPath2DList cTPath2DList);

    void setRect(CTGeomRect cTGeomRect);

    void unsetAhLst();

    void unsetAvLst();

    void unsetCxnLst();

    void unsetGdLst();

    void unsetRect();
}

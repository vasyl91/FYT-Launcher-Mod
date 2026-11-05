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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTransform2D extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTransform2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttransform2d5deftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTransform2D newInstance() {
            return (CTTransform2D) POIXMLTypeLoader.newInstance(CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D newInstance(XmlOptions xmlOptions) {
            return (CTTransform2D) POIXMLTypeLoader.newInstance(CTTransform2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTransform2D.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(File file) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(file, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(file, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(inputStream, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(inputStream, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(Reader reader) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(reader, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(reader, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(String str) throws XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(str, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(str, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(URL url) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(url, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) POIXMLTypeLoader.parse(url, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(xMLStreamReader, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(xMLStreamReader, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(xMLInputStream, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(xMLInputStream, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(Node node) throws XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(node, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTransform2D) POIXMLTypeLoader.parse(node, CTTransform2D.type, xmlOptions);
        }
    }

    CTPositiveSize2D addNewExt();

    CTPoint2D addNewOff();

    CTPositiveSize2D getExt();

    boolean getFlipH();

    boolean getFlipV();

    CTPoint2D getOff();

    int getRot();

    boolean isSetExt();

    boolean isSetFlipH();

    boolean isSetFlipV();

    boolean isSetOff();

    boolean isSetRot();

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setFlipH(boolean z);

    void setFlipV(boolean z);

    void setOff(CTPoint2D cTPoint2D);

    void setRot(int i);

    void unsetExt();

    void unsetFlipH();

    void unsetFlipV();

    void unsetOff();

    void unsetRot();

    XmlBoolean xgetFlipH();

    XmlBoolean xgetFlipV();

    STAngle xgetRot();

    void xsetFlipH(XmlBoolean xmlBoolean);

    void xsetFlipV(XmlBoolean xmlBoolean);

    void xsetRot(STAngle sTAngle);
}

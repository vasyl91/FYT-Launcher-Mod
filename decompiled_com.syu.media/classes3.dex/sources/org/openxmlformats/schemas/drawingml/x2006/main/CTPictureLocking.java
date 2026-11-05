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
public interface CTPictureLocking extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPictureLocking.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturelockinga414type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureLocking newInstance() {
            return (CTPictureLocking) POIXMLTypeLoader.newInstance(CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking newInstance(XmlOptions xmlOptions) {
            return (CTPictureLocking) POIXMLTypeLoader.newInstance(CTPictureLocking.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureLocking.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(File file) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(file, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(file, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(inputStream, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(inputStream, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(Reader reader) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(reader, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(reader, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(String str) throws XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(str, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(str, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(URL url) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(url, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(url, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(xMLInputStream, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(xMLInputStream, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(Node node) throws XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(node, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureLocking) POIXMLTypeLoader.parse(node, CTPictureLocking.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getNoAdjustHandles();

    boolean getNoChangeArrowheads();

    boolean getNoChangeAspect();

    boolean getNoChangeShapeType();

    boolean getNoCrop();

    boolean getNoEditPoints();

    boolean getNoGrp();

    boolean getNoMove();

    boolean getNoResize();

    boolean getNoRot();

    boolean getNoSelect();

    boolean isSetExtLst();

    boolean isSetNoAdjustHandles();

    boolean isSetNoChangeArrowheads();

    boolean isSetNoChangeAspect();

    boolean isSetNoChangeShapeType();

    boolean isSetNoCrop();

    boolean isSetNoEditPoints();

    boolean isSetNoGrp();

    boolean isSetNoMove();

    boolean isSetNoResize();

    boolean isSetNoRot();

    boolean isSetNoSelect();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setNoAdjustHandles(boolean z);

    void setNoChangeArrowheads(boolean z);

    void setNoChangeAspect(boolean z);

    void setNoChangeShapeType(boolean z);

    void setNoCrop(boolean z);

    void setNoEditPoints(boolean z);

    void setNoGrp(boolean z);

    void setNoMove(boolean z);

    void setNoResize(boolean z);

    void setNoRot(boolean z);

    void setNoSelect(boolean z);

    void unsetExtLst();

    void unsetNoAdjustHandles();

    void unsetNoChangeArrowheads();

    void unsetNoChangeAspect();

    void unsetNoChangeShapeType();

    void unsetNoCrop();

    void unsetNoEditPoints();

    void unsetNoGrp();

    void unsetNoMove();

    void unsetNoResize();

    void unsetNoRot();

    void unsetNoSelect();

    XmlBoolean xgetNoAdjustHandles();

    XmlBoolean xgetNoChangeArrowheads();

    XmlBoolean xgetNoChangeAspect();

    XmlBoolean xgetNoChangeShapeType();

    XmlBoolean xgetNoCrop();

    XmlBoolean xgetNoEditPoints();

    XmlBoolean xgetNoGrp();

    XmlBoolean xgetNoMove();

    XmlBoolean xgetNoResize();

    XmlBoolean xgetNoRot();

    XmlBoolean xgetNoSelect();

    void xsetNoAdjustHandles(XmlBoolean xmlBoolean);

    void xsetNoChangeArrowheads(XmlBoolean xmlBoolean);

    void xsetNoChangeAspect(XmlBoolean xmlBoolean);

    void xsetNoChangeShapeType(XmlBoolean xmlBoolean);

    void xsetNoCrop(XmlBoolean xmlBoolean);

    void xsetNoEditPoints(XmlBoolean xmlBoolean);

    void xsetNoGrp(XmlBoolean xmlBoolean);

    void xsetNoMove(XmlBoolean xmlBoolean);

    void xsetNoResize(XmlBoolean xmlBoolean);

    void xsetNoRot(XmlBoolean xmlBoolean);

    void xsetNoSelect(XmlBoolean xmlBoolean);
}

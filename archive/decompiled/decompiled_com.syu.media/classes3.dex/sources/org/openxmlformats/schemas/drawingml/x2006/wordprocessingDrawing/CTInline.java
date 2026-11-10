package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTInline extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTInline.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctinline5726type");

    public static final class Factory {
        private Factory() {
        }

        public static CTInline newInstance() {
            return (CTInline) POIXMLTypeLoader.newInstance(CTInline.type, (XmlOptions) null);
        }

        public static CTInline newInstance(XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.newInstance(CTInline.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTInline.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(File file) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(file, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(file, CTInline.type, xmlOptions);
        }

        public static CTInline parse(InputStream inputStream) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(inputStream, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(inputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(Reader reader) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(reader, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(reader, CTInline.type, xmlOptions);
        }

        public static CTInline parse(String str) throws XmlException {
            return (CTInline) POIXMLTypeLoader.parse(str, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTInline) POIXMLTypeLoader.parse(str, CTInline.type, xmlOptions);
        }

        public static CTInline parse(URL url) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(url, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) POIXMLTypeLoader.parse(url, CTInline.type, xmlOptions);
        }

        public static CTInline parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTInline) POIXMLTypeLoader.parse(xMLStreamReader, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTInline) POIXMLTypeLoader.parse(xMLStreamReader, CTInline.type, xmlOptions);
        }

        public static CTInline parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTInline) POIXMLTypeLoader.parse(xMLInputStream, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTInline) POIXMLTypeLoader.parse(xMLInputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(Node node) throws XmlException {
            return (CTInline) POIXMLTypeLoader.parse(node, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTInline) POIXMLTypeLoader.parse(node, CTInline.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewDocPr();

    CTEffectExtent addNewEffectExtent();

    CTPositiveSize2D addNewExtent();

    CTGraphicalObject addNewGraphic();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    long getDistB();

    long getDistL();

    long getDistR();

    long getDistT();

    CTNonVisualDrawingProps getDocPr();

    CTEffectExtent getEffectExtent();

    CTPositiveSize2D getExtent();

    CTGraphicalObject getGraphic();

    boolean isSetCNvGraphicFramePr();

    boolean isSetDistB();

    boolean isSetDistL();

    boolean isSetDistR();

    boolean isSetDistT();

    boolean isSetEffectExtent();

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setDistB(long j);

    void setDistL(long j);

    void setDistR(long j);

    void setDistT(long j);

    void setDocPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setEffectExtent(CTEffectExtent cTEffectExtent);

    void setExtent(CTPositiveSize2D cTPositiveSize2D);

    void setGraphic(CTGraphicalObject cTGraphicalObject);

    void unsetCNvGraphicFramePr();

    void unsetDistB();

    void unsetDistL();

    void unsetDistR();

    void unsetDistT();

    void unsetEffectExtent();

    STWrapDistance xgetDistB();

    STWrapDistance xgetDistL();

    STWrapDistance xgetDistR();

    STWrapDistance xgetDistT();

    void xsetDistB(STWrapDistance sTWrapDistance);

    void xsetDistL(STWrapDistance sTWrapDistance);

    void xsetDistR(STWrapDistance sTWrapDistance);

    void xsetDistT(STWrapDistance sTWrapDistance);
}

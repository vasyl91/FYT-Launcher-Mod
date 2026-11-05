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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTAnchor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctanchorff8atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTAnchor newInstance() {
            return (CTAnchor) POIXMLTypeLoader.newInstance(CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor newInstance(XmlOptions xmlOptions) {
            return (CTAnchor) POIXMLTypeLoader.newInstance(CTAnchor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAnchor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(File file) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(file, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(file, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(inputStream, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(inputStream, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(Reader reader) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(reader, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(reader, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(String str) throws XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(str, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(str, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(URL url) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(url, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchor) POIXMLTypeLoader.parse(url, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTAnchor.type, xmlOptions);
        }

        public static CTAnchor parse(Node node) throws XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(node, CTAnchor.type, (XmlOptions) null);
        }

        public static CTAnchor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchor) POIXMLTypeLoader.parse(node, CTAnchor.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewDocPr();

    CTEffectExtent addNewEffectExtent();

    CTPositiveSize2D addNewExtent();

    CTGraphicalObject addNewGraphic();

    CTPosH addNewPositionH();

    CTPosV addNewPositionV();

    CTPoint2D addNewSimplePos();

    CTWrapNone addNewWrapNone();

    CTWrapSquare addNewWrapSquare();

    CTWrapThrough addNewWrapThrough();

    CTWrapTight addNewWrapTight();

    CTWrapTopBottom addNewWrapTopAndBottom();

    boolean getAllowOverlap();

    boolean getBehindDoc();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    long getDistB();

    long getDistL();

    long getDistR();

    long getDistT();

    CTNonVisualDrawingProps getDocPr();

    CTEffectExtent getEffectExtent();

    CTPositiveSize2D getExtent();

    CTGraphicalObject getGraphic();

    boolean getHidden();

    boolean getLayoutInCell();

    boolean getLocked();

    CTPosH getPositionH();

    CTPosV getPositionV();

    long getRelativeHeight();

    CTPoint2D getSimplePos();

    boolean getSimplePos2();

    CTWrapNone getWrapNone();

    CTWrapSquare getWrapSquare();

    CTWrapThrough getWrapThrough();

    CTWrapTight getWrapTight();

    CTWrapTopBottom getWrapTopAndBottom();

    boolean isSetCNvGraphicFramePr();

    boolean isSetDistB();

    boolean isSetDistL();

    boolean isSetDistR();

    boolean isSetDistT();

    boolean isSetEffectExtent();

    boolean isSetHidden();

    boolean isSetSimplePos2();

    boolean isSetWrapNone();

    boolean isSetWrapSquare();

    boolean isSetWrapThrough();

    boolean isSetWrapTight();

    boolean isSetWrapTopAndBottom();

    void setAllowOverlap(boolean z);

    void setBehindDoc(boolean z);

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setDistB(long j);

    void setDistL(long j);

    void setDistR(long j);

    void setDistT(long j);

    void setDocPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setEffectExtent(CTEffectExtent cTEffectExtent);

    void setExtent(CTPositiveSize2D cTPositiveSize2D);

    void setGraphic(CTGraphicalObject cTGraphicalObject);

    void setHidden(boolean z);

    void setLayoutInCell(boolean z);

    void setLocked(boolean z);

    void setPositionH(CTPosH cTPosH);

    void setPositionV(CTPosV cTPosV);

    void setRelativeHeight(long j);

    void setSimplePos(CTPoint2D cTPoint2D);

    void setSimplePos2(boolean z);

    void setWrapNone(CTWrapNone cTWrapNone);

    void setWrapSquare(CTWrapSquare cTWrapSquare);

    void setWrapThrough(CTWrapThrough cTWrapThrough);

    void setWrapTight(CTWrapTight cTWrapTight);

    void setWrapTopAndBottom(CTWrapTopBottom cTWrapTopBottom);

    void unsetCNvGraphicFramePr();

    void unsetDistB();

    void unsetDistL();

    void unsetDistR();

    void unsetDistT();

    void unsetEffectExtent();

    void unsetHidden();

    void unsetSimplePos2();

    void unsetWrapNone();

    void unsetWrapSquare();

    void unsetWrapThrough();

    void unsetWrapTight();

    void unsetWrapTopAndBottom();

    XmlBoolean xgetAllowOverlap();

    XmlBoolean xgetBehindDoc();

    STWrapDistance xgetDistB();

    STWrapDistance xgetDistL();

    STWrapDistance xgetDistR();

    STWrapDistance xgetDistT();

    XmlBoolean xgetHidden();

    XmlBoolean xgetLayoutInCell();

    XmlBoolean xgetLocked();

    XmlUnsignedInt xgetRelativeHeight();

    XmlBoolean xgetSimplePos2();

    void xsetAllowOverlap(XmlBoolean xmlBoolean);

    void xsetBehindDoc(XmlBoolean xmlBoolean);

    void xsetDistB(STWrapDistance sTWrapDistance);

    void xsetDistL(STWrapDistance sTWrapDistance);

    void xsetDistR(STWrapDistance sTWrapDistance);

    void xsetDistT(STWrapDistance sTWrapDistance);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetLayoutInCell(XmlBoolean xmlBoolean);

    void xsetLocked(XmlBoolean xmlBoolean);

    void xsetRelativeHeight(XmlUnsignedInt xmlUnsignedInt);

    void xsetSimplePos2(XmlBoolean xmlBoolean);
}

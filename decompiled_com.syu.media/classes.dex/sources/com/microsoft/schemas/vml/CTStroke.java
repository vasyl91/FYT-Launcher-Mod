package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.CTStrokeChild;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTStroke extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStroke.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstrokee2f6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStroke newInstance() {
            return (CTStroke) POIXMLTypeLoader.newInstance(CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke newInstance(XmlOptions xmlOptions) {
            return (CTStroke) POIXMLTypeLoader.newInstance(CTStroke.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStroke.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(File file) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(file, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(file, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(inputStream, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(inputStream, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(Reader reader) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(reader, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(reader, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(String str) throws XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(str, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(str, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(URL url) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(url, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStroke) POIXMLTypeLoader.parse(url, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(xMLStreamReader, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(xMLStreamReader, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(xMLInputStream, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(xMLInputStream, CTStroke.type, xmlOptions);
        }

        public static CTStroke parse(Node node) throws XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(node, CTStroke.type, (XmlOptions) null);
        }

        public static CTStroke parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStroke) POIXMLTypeLoader.parse(node, CTStroke.type, xmlOptions);
        }
    }

    CTStrokeChild addNewBottom();

    CTStrokeChild addNewColumn();

    CTStrokeChild addNewLeft();

    CTStrokeChild addNewRight();

    CTStrokeChild addNewTop();

    String getAlthref();

    CTStrokeChild getBottom();

    String getColor();

    String getColor2();

    CTStrokeChild getColumn();

    String getDashstyle();

    STStrokeArrowType$Enum getEndarrow();

    STStrokeArrowLength$Enum getEndarrowlength();

    STStrokeArrowWidth$Enum getEndarrowwidth();

    STStrokeEndCap$Enum getEndcap();

    STFillType$Enum getFilltype();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getForcedash();

    String getHref();

    String getId();

    String getId2();

    STTrueFalse.Enum getImagealignshape();

    STImageAspect$Enum getImageaspect();

    String getImagesize();

    STTrueFalse.Enum getInsetpen();

    STStrokeJoinStyle.Enum getJoinstyle();

    CTStrokeChild getLeft();

    STStrokeLineStyle$Enum getLinestyle();

    BigDecimal getMiterlimit();

    STTrueFalse.Enum getOn();

    String getOpacity();

    String getRelid();

    CTStrokeChild getRight();

    String getSrc();

    STStrokeArrowType$Enum getStartarrow();

    STStrokeArrowLength$Enum getStartarrowlength();

    STStrokeArrowWidth$Enum getStartarrowwidth();

    String getTitle();

    CTStrokeChild getTop();

    String getWeight();

    boolean isSetAlthref();

    boolean isSetBottom();

    boolean isSetColor();

    boolean isSetColor2();

    boolean isSetColumn();

    boolean isSetDashstyle();

    boolean isSetEndarrow();

    boolean isSetEndarrowlength();

    boolean isSetEndarrowwidth();

    boolean isSetEndcap();

    boolean isSetFilltype();

    boolean isSetForcedash();

    boolean isSetHref();

    boolean isSetId();

    boolean isSetId2();

    boolean isSetImagealignshape();

    boolean isSetImageaspect();

    boolean isSetImagesize();

    boolean isSetInsetpen();

    boolean isSetJoinstyle();

    boolean isSetLeft();

    boolean isSetLinestyle();

    boolean isSetMiterlimit();

    boolean isSetOn();

    boolean isSetOpacity();

    boolean isSetRelid();

    boolean isSetRight();

    boolean isSetSrc();

    boolean isSetStartarrow();

    boolean isSetStartarrowlength();

    boolean isSetStartarrowwidth();

    boolean isSetTitle();

    boolean isSetTop();

    boolean isSetWeight();

    void setAlthref(String str);

    void setBottom(CTStrokeChild cTStrokeChild);

    void setColor(String str);

    void setColor2(String str);

    void setColumn(CTStrokeChild cTStrokeChild);

    void setDashstyle(String str);

    void setEndarrow(STStrokeArrowType$Enum sTStrokeArrowType$Enum);

    void setEndarrowlength(STStrokeArrowLength$Enum sTStrokeArrowLength$Enum);

    void setEndarrowwidth(STStrokeArrowWidth$Enum sTStrokeArrowWidth$Enum);

    void setEndcap(STStrokeEndCap$Enum sTStrokeEndCap$Enum);

    void setFilltype(STFillType$Enum sTFillType$Enum);

    void setForcedash(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setHref(String str);

    void setId(String str);

    void setId2(String str);

    void setImagealignshape(STTrueFalse.Enum r1);

    void setImageaspect(STImageAspect$Enum sTImageAspect$Enum);

    void setImagesize(String str);

    void setInsetpen(STTrueFalse.Enum r1);

    void setJoinstyle(STStrokeJoinStyle.Enum r1);

    void setLeft(CTStrokeChild cTStrokeChild);

    void setLinestyle(STStrokeLineStyle$Enum sTStrokeLineStyle$Enum);

    void setMiterlimit(BigDecimal bigDecimal);

    void setOn(STTrueFalse.Enum r1);

    void setOpacity(String str);

    void setRelid(String str);

    void setRight(CTStrokeChild cTStrokeChild);

    void setSrc(String str);

    void setStartarrow(STStrokeArrowType$Enum sTStrokeArrowType$Enum);

    void setStartarrowlength(STStrokeArrowLength$Enum sTStrokeArrowLength$Enum);

    void setStartarrowwidth(STStrokeArrowWidth$Enum sTStrokeArrowWidth$Enum);

    void setTitle(String str);

    void setTop(CTStrokeChild cTStrokeChild);

    void setWeight(String str);

    void unsetAlthref();

    void unsetBottom();

    void unsetColor();

    void unsetColor2();

    void unsetColumn();

    void unsetDashstyle();

    void unsetEndarrow();

    void unsetEndarrowlength();

    void unsetEndarrowwidth();

    void unsetEndcap();

    void unsetFilltype();

    void unsetForcedash();

    void unsetHref();

    void unsetId();

    void unsetId2();

    void unsetImagealignshape();

    void unsetImageaspect();

    void unsetImagesize();

    void unsetInsetpen();

    void unsetJoinstyle();

    void unsetLeft();

    void unsetLinestyle();

    void unsetMiterlimit();

    void unsetOn();

    void unsetOpacity();

    void unsetRelid();

    void unsetRight();

    void unsetSrc();

    void unsetStartarrow();

    void unsetStartarrowlength();

    void unsetStartarrowwidth();

    void unsetTitle();

    void unsetTop();

    void unsetWeight();

    XmlString xgetAlthref();

    STColorType xgetColor();

    STColorType xgetColor2();

    XmlString xgetDashstyle();

    STStrokeArrowType xgetEndarrow();

    STStrokeArrowLength xgetEndarrowlength();

    STStrokeArrowWidth xgetEndarrowwidth();

    STStrokeEndCap xgetEndcap();

    STFillType xgetFilltype();

    com.microsoft.schemas.office.office.STTrueFalse xgetForcedash();

    XmlString xgetHref();

    XmlString xgetId();

    STRelationshipId xgetId2();

    STTrueFalse xgetImagealignshape();

    STImageAspect xgetImageaspect();

    XmlString xgetImagesize();

    STTrueFalse xgetInsetpen();

    STStrokeJoinStyle xgetJoinstyle();

    STStrokeLineStyle xgetLinestyle();

    XmlDecimal xgetMiterlimit();

    STTrueFalse xgetOn();

    XmlString xgetOpacity();

    com.microsoft.schemas.office.office.STRelationshipId xgetRelid();

    XmlString xgetSrc();

    STStrokeArrowType xgetStartarrow();

    STStrokeArrowLength xgetStartarrowlength();

    STStrokeArrowWidth xgetStartarrowwidth();

    XmlString xgetTitle();

    XmlString xgetWeight();

    void xsetAlthref(XmlString xmlString);

    void xsetColor(STColorType sTColorType);

    void xsetColor2(STColorType sTColorType);

    void xsetDashstyle(XmlString xmlString);

    void xsetEndarrow(STStrokeArrowType sTStrokeArrowType);

    void xsetEndarrowlength(STStrokeArrowLength sTStrokeArrowLength);

    void xsetEndarrowwidth(STStrokeArrowWidth sTStrokeArrowWidth);

    void xsetEndcap(STStrokeEndCap sTStrokeEndCap);

    void xsetFilltype(STFillType sTFillType);

    void xsetForcedash(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetHref(XmlString xmlString);

    void xsetId(XmlString xmlString);

    void xsetId2(STRelationshipId sTRelationshipId);

    void xsetImagealignshape(STTrueFalse sTTrueFalse);

    void xsetImageaspect(STImageAspect sTImageAspect);

    void xsetImagesize(XmlString xmlString);

    void xsetInsetpen(STTrueFalse sTTrueFalse);

    void xsetJoinstyle(STStrokeJoinStyle sTStrokeJoinStyle);

    void xsetLinestyle(STStrokeLineStyle sTStrokeLineStyle);

    void xsetMiterlimit(XmlDecimal xmlDecimal);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetRelid(com.microsoft.schemas.office.office.STRelationshipId sTRelationshipId);

    void xsetSrc(XmlString xmlString);

    void xsetStartarrow(STStrokeArrowType sTStrokeArrowType);

    void xsetStartarrowlength(STStrokeArrowLength sTStrokeArrowLength);

    void xsetStartarrowwidth(STStrokeArrowWidth sTStrokeArrowWidth);

    void xsetTitle(XmlString xmlString);

    void xsetWeight(XmlString xmlString);
}

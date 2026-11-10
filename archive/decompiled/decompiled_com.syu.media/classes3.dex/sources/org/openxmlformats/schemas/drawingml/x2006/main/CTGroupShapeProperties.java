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
public interface CTGroupShapeProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGroupShapeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupshapeproperties8690type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShapeProperties newInstance() {
            return (CTGroupShapeProperties) POIXMLTypeLoader.newInstance(CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties newInstance(XmlOptions xmlOptions) {
            return (CTGroupShapeProperties) POIXMLTypeLoader.newInstance(CTGroupShapeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(File file) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(file, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(file, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(inputStream, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(inputStream, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(Reader reader) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(reader, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(reader, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(String str) throws XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(str, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(str, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(URL url) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(url, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(url, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(Node node) throws XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(node, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeProperties) POIXMLTypeLoader.parse(node, CTGroupShapeProperties.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTEffectContainer addNewEffectDag();

    CTEffectList addNewEffectLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTScene3D addNewScene3D();

    CTSolidColorFillProperties addNewSolidFill();

    CTGroupTransform2D addNewXfrm();

    CTBlipFillProperties getBlipFill();

    STBlackWhiteMode$Enum getBwMode();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTScene3D getScene3D();

    CTSolidColorFillProperties getSolidFill();

    CTGroupTransform2D getXfrm();

    boolean isSetBlipFill();

    boolean isSetBwMode();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetScene3D();

    boolean isSetSolidFill();

    boolean isSetXfrm();

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setBwMode(STBlackWhiteMode$Enum sTBlackWhiteMode$Enum);

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setScene3D(CTScene3D cTScene3D);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setXfrm(CTGroupTransform2D cTGroupTransform2D);

    void unsetBlipFill();

    void unsetBwMode();

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetExtLst();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetNoFill();

    void unsetPattFill();

    void unsetScene3D();

    void unsetSolidFill();

    void unsetXfrm();

    STBlackWhiteMode xgetBwMode();

    void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode);
}

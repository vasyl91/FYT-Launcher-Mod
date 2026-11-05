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
public interface CTOuterShadowEffect extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOuterShadowEffect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctoutershadoweffect7b5dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTOuterShadowEffect newInstance() {
            return (CTOuterShadowEffect) POIXMLTypeLoader.newInstance(CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect newInstance(XmlOptions xmlOptions) {
            return (CTOuterShadowEffect) POIXMLTypeLoader.newInstance(CTOuterShadowEffect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(File file) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(file, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(file, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(inputStream, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(inputStream, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(Reader reader) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(reader, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(reader, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(String str) throws XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(str, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(str, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(URL url) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(url, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(url, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(xMLStreamReader, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(xMLStreamReader, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(xMLInputStream, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(xMLInputStream, CTOuterShadowEffect.type, xmlOptions);
        }

        public static CTOuterShadowEffect parse(Node node) throws XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(node, CTOuterShadowEffect.type, (XmlOptions) null);
        }

        public static CTOuterShadowEffect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOuterShadowEffect) POIXMLTypeLoader.parse(node, CTOuterShadowEffect.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    STRectAlignment$Enum getAlgn();

    long getBlurRad();

    int getDir();

    long getDist();

    CTHslColor getHslClr();

    int getKx();

    int getKy();

    CTPresetColor getPrstClr();

    boolean getRotWithShape();

    CTSchemeColor getSchemeClr();

    CTScRgbColor getScrgbClr();

    CTSRgbColor getSrgbClr();

    int getSx();

    int getSy();

    CTSystemColor getSysClr();

    boolean isSetAlgn();

    boolean isSetBlurRad();

    boolean isSetDir();

    boolean isSetDist();

    boolean isSetHslClr();

    boolean isSetKx();

    boolean isSetKy();

    boolean isSetPrstClr();

    boolean isSetRotWithShape();

    boolean isSetSchemeClr();

    boolean isSetScrgbClr();

    boolean isSetSrgbClr();

    boolean isSetSx();

    boolean isSetSy();

    boolean isSetSysClr();

    void setAlgn(STRectAlignment$Enum sTRectAlignment$Enum);

    void setBlurRad(long j);

    void setDir(int i);

    void setDist(long j);

    void setHslClr(CTHslColor cTHslColor);

    void setKx(int i);

    void setKy(int i);

    void setPrstClr(CTPresetColor cTPresetColor);

    void setRotWithShape(boolean z);

    void setSchemeClr(CTSchemeColor cTSchemeColor);

    void setScrgbClr(CTScRgbColor cTScRgbColor);

    void setSrgbClr(CTSRgbColor cTSRgbColor);

    void setSx(int i);

    void setSy(int i);

    void setSysClr(CTSystemColor cTSystemColor);

    void unsetAlgn();

    void unsetBlurRad();

    void unsetDir();

    void unsetDist();

    void unsetHslClr();

    void unsetKx();

    void unsetKy();

    void unsetPrstClr();

    void unsetRotWithShape();

    void unsetSchemeClr();

    void unsetScrgbClr();

    void unsetSrgbClr();

    void unsetSx();

    void unsetSy();

    void unsetSysClr();

    STRectAlignment xgetAlgn();

    STPositiveCoordinate xgetBlurRad();

    STPositiveFixedAngle xgetDir();

    STPositiveCoordinate xgetDist();

    STFixedAngle xgetKx();

    STFixedAngle xgetKy();

    XmlBoolean xgetRotWithShape();

    STPercentage xgetSx();

    STPercentage xgetSy();

    void xsetAlgn(STRectAlignment sTRectAlignment);

    void xsetBlurRad(STPositiveCoordinate sTPositiveCoordinate);

    void xsetDir(STPositiveFixedAngle sTPositiveFixedAngle);

    void xsetDist(STPositiveCoordinate sTPositiveCoordinate);

    void xsetKx(STFixedAngle sTFixedAngle);

    void xsetKy(STFixedAngle sTFixedAngle);

    void xsetRotWithShape(XmlBoolean xmlBoolean);

    void xsetSx(STPercentage sTPercentage);

    void xsetSy(STPercentage sTPercentage);
}

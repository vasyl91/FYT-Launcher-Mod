package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTLvl extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLvl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlvlf630type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLvl newInstance() {
            return (CTLvl) POIXMLTypeLoader.newInstance(CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl newInstance(XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.newInstance(CTLvl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLvl.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(File file) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(file, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(file, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(inputStream, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(inputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(Reader reader) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(reader, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(reader, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(String str) throws XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(str, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(str, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(URL url) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(url, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) POIXMLTypeLoader.parse(url, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(xMLStreamReader, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(xMLStreamReader, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(xMLInputStream, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(xMLInputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(Node node) throws XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(node, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLvl) POIXMLTypeLoader.parse(node, CTLvl.type, xmlOptions);
        }
    }

    CTOnOff addNewIsLgl();

    CTLvlLegacy addNewLegacy();

    CTJc addNewLvlJc();

    CTDecimalNumber addNewLvlPicBulletId();

    CTDecimalNumber addNewLvlRestart();

    CTLevelText addNewLvlText();

    CTNumFmt addNewNumFmt();

    CTPPr addNewPPr();

    CTString addNewPStyle();

    CTRPr addNewRPr();

    CTDecimalNumber addNewStart();

    CTLevelSuffix addNewSuff();

    BigInteger getIlvl();

    CTOnOff getIsLgl();

    CTLvlLegacy getLegacy();

    CTJc getLvlJc();

    CTDecimalNumber getLvlPicBulletId();

    CTDecimalNumber getLvlRestart();

    CTLevelText getLvlText();

    CTNumFmt getNumFmt();

    CTPPr getPPr();

    CTString getPStyle();

    CTRPr getRPr();

    CTDecimalNumber getStart();

    CTLevelSuffix getSuff();

    STOnOff.Enum getTentative();

    byte[] getTplc();

    boolean isSetIsLgl();

    boolean isSetLegacy();

    boolean isSetLvlJc();

    boolean isSetLvlPicBulletId();

    boolean isSetLvlRestart();

    boolean isSetLvlText();

    boolean isSetNumFmt();

    boolean isSetPPr();

    boolean isSetPStyle();

    boolean isSetRPr();

    boolean isSetStart();

    boolean isSetSuff();

    boolean isSetTentative();

    boolean isSetTplc();

    void setIlvl(BigInteger bigInteger);

    void setIsLgl(CTOnOff cTOnOff);

    void setLegacy(CTLvlLegacy cTLvlLegacy);

    void setLvlJc(CTJc cTJc);

    void setLvlPicBulletId(CTDecimalNumber cTDecimalNumber);

    void setLvlRestart(CTDecimalNumber cTDecimalNumber);

    void setLvlText(CTLevelText cTLevelText);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setPPr(CTPPr cTPPr);

    void setPStyle(CTString cTString);

    void setRPr(CTRPr cTRPr);

    void setStart(CTDecimalNumber cTDecimalNumber);

    void setSuff(CTLevelSuffix cTLevelSuffix);

    void setTentative(STOnOff.Enum r1);

    void setTplc(byte[] bArr);

    void unsetIsLgl();

    void unsetLegacy();

    void unsetLvlJc();

    void unsetLvlPicBulletId();

    void unsetLvlRestart();

    void unsetLvlText();

    void unsetNumFmt();

    void unsetPPr();

    void unsetPStyle();

    void unsetRPr();

    void unsetStart();

    void unsetSuff();

    void unsetTentative();

    void unsetTplc();

    STDecimalNumber xgetIlvl();

    STOnOff xgetTentative();

    STLongHexNumber xgetTplc();

    void xsetIlvl(STDecimalNumber sTDecimalNumber);

    void xsetTentative(STOnOff sTOnOff);

    void xsetTplc(STLongHexNumber sTLongHexNumber);
}

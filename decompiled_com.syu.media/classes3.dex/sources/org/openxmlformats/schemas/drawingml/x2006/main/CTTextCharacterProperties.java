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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTextCharacterProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextCharacterProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextcharacterproperties76c0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextCharacterProperties newInstance() {
            return (CTTextCharacterProperties) POIXMLTypeLoader.newInstance(CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties newInstance(XmlOptions xmlOptions) {
            return (CTTextCharacterProperties) POIXMLTypeLoader.newInstance(CTTextCharacterProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(File file) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(file, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(file, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(inputStream, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(inputStream, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(Reader reader) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(reader, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(reader, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(String str) throws XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(str, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(str, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(URL url) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(url, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(url, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(xMLInputStream, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(xMLInputStream, CTTextCharacterProperties.type, xmlOptions);
        }

        public static CTTextCharacterProperties parse(Node node) throws XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(node, CTTextCharacterProperties.type, (XmlOptions) null);
        }

        public static CTTextCharacterProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharacterProperties) POIXMLTypeLoader.parse(node, CTTextCharacterProperties.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTTextFont addNewCs();

    CTTextFont addNewEa();

    CTEffectContainer addNewEffectDag();

    CTEffectList addNewEffectLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTColor addNewHighlight();

    CTHyperlink addNewHlinkClick();

    CTHyperlink addNewHlinkMouseOver();

    CTTextFont addNewLatin();

    CTLineProperties addNewLn();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTTextFont addNewSym();

    CTTextUnderlineFillGroupWrapper addNewUFill();

    CTTextUnderlineFillFollowText addNewUFillTx();

    CTLineProperties addNewULn();

    CTTextUnderlineLineFollowText addNewULnTx();

    String getAltLang();

    boolean getB();

    int getBaseline();

    CTBlipFillProperties getBlipFill();

    String getBmk();

    STTextCapsType.Enum getCap();

    CTTextFont getCs();

    boolean getDirty();

    CTTextFont getEa();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    boolean getErr();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    CTColor getHighlight();

    CTHyperlink getHlinkClick();

    CTHyperlink getHlinkMouseOver();

    boolean getI();

    int getKern();

    boolean getKumimoji();

    String getLang();

    CTTextFont getLatin();

    CTLineProperties getLn();

    CTNoFillProperties getNoFill();

    boolean getNoProof();

    boolean getNormalizeH();

    CTPatternFillProperties getPattFill();

    boolean getSmtClean();

    long getSmtId();

    CTSolidColorFillProperties getSolidFill();

    int getSpc();

    STTextStrikeType.Enum getStrike();

    CTTextFont getSym();

    int getSz();

    STTextUnderlineType.Enum getU();

    CTTextUnderlineFillGroupWrapper getUFill();

    CTTextUnderlineFillFollowText getUFillTx();

    CTLineProperties getULn();

    CTTextUnderlineLineFollowText getULnTx();

    boolean isSetAltLang();

    boolean isSetB();

    boolean isSetBaseline();

    boolean isSetBlipFill();

    boolean isSetBmk();

    boolean isSetCap();

    boolean isSetCs();

    boolean isSetDirty();

    boolean isSetEa();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetErr();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetHighlight();

    boolean isSetHlinkClick();

    boolean isSetHlinkMouseOver();

    boolean isSetI();

    boolean isSetKern();

    boolean isSetKumimoji();

    boolean isSetLang();

    boolean isSetLatin();

    boolean isSetLn();

    boolean isSetNoFill();

    boolean isSetNoProof();

    boolean isSetNormalizeH();

    boolean isSetPattFill();

    boolean isSetSmtClean();

    boolean isSetSmtId();

    boolean isSetSolidFill();

    boolean isSetSpc();

    boolean isSetStrike();

    boolean isSetSym();

    boolean isSetSz();

    boolean isSetU();

    boolean isSetUFill();

    boolean isSetUFillTx();

    boolean isSetULn();

    boolean isSetULnTx();

    void setAltLang(String str);

    void setB(boolean z);

    void setBaseline(int i);

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setBmk(String str);

    void setCap(STTextCapsType.Enum r1);

    void setCs(CTTextFont cTTextFont);

    void setDirty(boolean z);

    void setEa(CTTextFont cTTextFont);

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setErr(boolean z);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setHighlight(CTColor cTColor);

    void setHlinkClick(CTHyperlink cTHyperlink);

    void setHlinkMouseOver(CTHyperlink cTHyperlink);

    void setI(boolean z);

    void setKern(int i);

    void setKumimoji(boolean z);

    void setLang(String str);

    void setLatin(CTTextFont cTTextFont);

    void setLn(CTLineProperties cTLineProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setNoProof(boolean z);

    void setNormalizeH(boolean z);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setSmtClean(boolean z);

    void setSmtId(long j);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setSpc(int i);

    void setStrike(STTextStrikeType.Enum r1);

    void setSym(CTTextFont cTTextFont);

    void setSz(int i);

    void setU(STTextUnderlineType.Enum r1);

    void setUFill(CTTextUnderlineFillGroupWrapper cTTextUnderlineFillGroupWrapper);

    void setUFillTx(CTTextUnderlineFillFollowText cTTextUnderlineFillFollowText);

    void setULn(CTLineProperties cTLineProperties);

    void setULnTx(CTTextUnderlineLineFollowText cTTextUnderlineLineFollowText);

    void unsetAltLang();

    void unsetB();

    void unsetBaseline();

    void unsetBlipFill();

    void unsetBmk();

    void unsetCap();

    void unsetCs();

    void unsetDirty();

    void unsetEa();

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetErr();

    void unsetExtLst();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetHighlight();

    void unsetHlinkClick();

    void unsetHlinkMouseOver();

    void unsetI();

    void unsetKern();

    void unsetKumimoji();

    void unsetLang();

    void unsetLatin();

    void unsetLn();

    void unsetNoFill();

    void unsetNoProof();

    void unsetNormalizeH();

    void unsetPattFill();

    void unsetSmtClean();

    void unsetSmtId();

    void unsetSolidFill();

    void unsetSpc();

    void unsetStrike();

    void unsetSym();

    void unsetSz();

    void unsetU();

    void unsetUFill();

    void unsetUFillTx();

    void unsetULn();

    void unsetULnTx();

    STTextLanguageID xgetAltLang();

    XmlBoolean xgetB();

    STPercentage xgetBaseline();

    XmlString xgetBmk();

    STTextCapsType xgetCap();

    XmlBoolean xgetDirty();

    XmlBoolean xgetErr();

    XmlBoolean xgetI();

    STTextNonNegativePoint xgetKern();

    XmlBoolean xgetKumimoji();

    STTextLanguageID xgetLang();

    XmlBoolean xgetNoProof();

    XmlBoolean xgetNormalizeH();

    XmlBoolean xgetSmtClean();

    XmlUnsignedInt xgetSmtId();

    STTextPoint xgetSpc();

    STTextStrikeType xgetStrike();

    STTextFontSize xgetSz();

    STTextUnderlineType xgetU();

    void xsetAltLang(STTextLanguageID sTTextLanguageID);

    void xsetB(XmlBoolean xmlBoolean);

    void xsetBaseline(STPercentage sTPercentage);

    void xsetBmk(XmlString xmlString);

    void xsetCap(STTextCapsType sTTextCapsType);

    void xsetDirty(XmlBoolean xmlBoolean);

    void xsetErr(XmlBoolean xmlBoolean);

    void xsetI(XmlBoolean xmlBoolean);

    void xsetKern(STTextNonNegativePoint sTTextNonNegativePoint);

    void xsetKumimoji(XmlBoolean xmlBoolean);

    void xsetLang(STTextLanguageID sTTextLanguageID);

    void xsetNoProof(XmlBoolean xmlBoolean);

    void xsetNormalizeH(XmlBoolean xmlBoolean);

    void xsetSmtClean(XmlBoolean xmlBoolean);

    void xsetSmtId(XmlUnsignedInt xmlUnsignedInt);

    void xsetSpc(STTextPoint sTTextPoint);

    void xsetStrike(STTextStrikeType sTTextStrikeType);

    void xsetSz(STTextFontSize sTTextFontSize);

    void xsetU(STTextUnderlineType sTTextUnderlineType);
}

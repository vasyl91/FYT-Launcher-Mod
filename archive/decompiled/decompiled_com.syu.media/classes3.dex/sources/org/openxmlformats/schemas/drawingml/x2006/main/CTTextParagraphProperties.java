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
public interface CTTextParagraphProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextParagraphProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextparagraphpropertiesdd05type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextParagraphProperties newInstance() {
            return (CTTextParagraphProperties) POIXMLTypeLoader.newInstance(CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties newInstance(XmlOptions xmlOptions) {
            return (CTTextParagraphProperties) POIXMLTypeLoader.newInstance(CTTextParagraphProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(File file) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(file, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(file, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(inputStream, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(inputStream, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(Reader reader) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(reader, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(reader, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(String str) throws XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(str, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(str, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(URL url) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(url, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(url, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(xMLInputStream, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(xMLInputStream, CTTextParagraphProperties.type, xmlOptions);
        }

        public static CTTextParagraphProperties parse(Node node) throws XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(node, CTTextParagraphProperties.type, (XmlOptions) null);
        }

        public static CTTextParagraphProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextParagraphProperties) POIXMLTypeLoader.parse(node, CTTextParagraphProperties.type, xmlOptions);
        }
    }

    CTTextAutonumberBullet addNewBuAutoNum();

    CTTextBlipBullet addNewBuBlip();

    CTTextCharBullet addNewBuChar();

    CTColor addNewBuClr();

    CTTextBulletColorFollowText addNewBuClrTx();

    CTTextFont addNewBuFont();

    CTTextBulletTypefaceFollowText addNewBuFontTx();

    CTTextNoBullet addNewBuNone();

    CTTextBulletSizePercent addNewBuSzPct();

    CTTextBulletSizePoint addNewBuSzPts();

    CTTextBulletSizeFollowText addNewBuSzTx();

    CTTextCharacterProperties addNewDefRPr();

    CTOfficeArtExtensionList addNewExtLst();

    CTTextSpacing addNewLnSpc();

    CTTextSpacing addNewSpcAft();

    CTTextSpacing addNewSpcBef();

    CTTextTabStopList addNewTabLst();

    STTextAlignType.Enum getAlgn();

    CTTextAutonumberBullet getBuAutoNum();

    CTTextBlipBullet getBuBlip();

    CTTextCharBullet getBuChar();

    CTColor getBuClr();

    CTTextBulletColorFollowText getBuClrTx();

    CTTextFont getBuFont();

    CTTextBulletTypefaceFollowText getBuFontTx();

    CTTextNoBullet getBuNone();

    CTTextBulletSizePercent getBuSzPct();

    CTTextBulletSizePoint getBuSzPts();

    CTTextBulletSizeFollowText getBuSzTx();

    CTTextCharacterProperties getDefRPr();

    int getDefTabSz();

    boolean getEaLnBrk();

    CTOfficeArtExtensionList getExtLst();

    STTextFontAlignType.Enum getFontAlgn();

    boolean getHangingPunct();

    int getIndent();

    boolean getLatinLnBrk();

    CTTextSpacing getLnSpc();

    int getLvl();

    int getMarL();

    int getMarR();

    boolean getRtl();

    CTTextSpacing getSpcAft();

    CTTextSpacing getSpcBef();

    CTTextTabStopList getTabLst();

    boolean isSetAlgn();

    boolean isSetBuAutoNum();

    boolean isSetBuBlip();

    boolean isSetBuChar();

    boolean isSetBuClr();

    boolean isSetBuClrTx();

    boolean isSetBuFont();

    boolean isSetBuFontTx();

    boolean isSetBuNone();

    boolean isSetBuSzPct();

    boolean isSetBuSzPts();

    boolean isSetBuSzTx();

    boolean isSetDefRPr();

    boolean isSetDefTabSz();

    boolean isSetEaLnBrk();

    boolean isSetExtLst();

    boolean isSetFontAlgn();

    boolean isSetHangingPunct();

    boolean isSetIndent();

    boolean isSetLatinLnBrk();

    boolean isSetLnSpc();

    boolean isSetLvl();

    boolean isSetMarL();

    boolean isSetMarR();

    boolean isSetRtl();

    boolean isSetSpcAft();

    boolean isSetSpcBef();

    boolean isSetTabLst();

    void setAlgn(STTextAlignType.Enum r1);

    void setBuAutoNum(CTTextAutonumberBullet cTTextAutonumberBullet);

    void setBuBlip(CTTextBlipBullet cTTextBlipBullet);

    void setBuChar(CTTextCharBullet cTTextCharBullet);

    void setBuClr(CTColor cTColor);

    void setBuClrTx(CTTextBulletColorFollowText cTTextBulletColorFollowText);

    void setBuFont(CTTextFont cTTextFont);

    void setBuFontTx(CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText);

    void setBuNone(CTTextNoBullet cTTextNoBullet);

    void setBuSzPct(CTTextBulletSizePercent cTTextBulletSizePercent);

    void setBuSzPts(CTTextBulletSizePoint cTTextBulletSizePoint);

    void setBuSzTx(CTTextBulletSizeFollowText cTTextBulletSizeFollowText);

    void setDefRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setDefTabSz(int i);

    void setEaLnBrk(boolean z);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFontAlgn(STTextFontAlignType.Enum r1);

    void setHangingPunct(boolean z);

    void setIndent(int i);

    void setLatinLnBrk(boolean z);

    void setLnSpc(CTTextSpacing cTTextSpacing);

    void setLvl(int i);

    void setMarL(int i);

    void setMarR(int i);

    void setRtl(boolean z);

    void setSpcAft(CTTextSpacing cTTextSpacing);

    void setSpcBef(CTTextSpacing cTTextSpacing);

    void setTabLst(CTTextTabStopList cTTextTabStopList);

    void unsetAlgn();

    void unsetBuAutoNum();

    void unsetBuBlip();

    void unsetBuChar();

    void unsetBuClr();

    void unsetBuClrTx();

    void unsetBuFont();

    void unsetBuFontTx();

    void unsetBuNone();

    void unsetBuSzPct();

    void unsetBuSzPts();

    void unsetBuSzTx();

    void unsetDefRPr();

    void unsetDefTabSz();

    void unsetEaLnBrk();

    void unsetExtLst();

    void unsetFontAlgn();

    void unsetHangingPunct();

    void unsetIndent();

    void unsetLatinLnBrk();

    void unsetLnSpc();

    void unsetLvl();

    void unsetMarL();

    void unsetMarR();

    void unsetRtl();

    void unsetSpcAft();

    void unsetSpcBef();

    void unsetTabLst();

    STTextAlignType xgetAlgn();

    STCoordinate32 xgetDefTabSz();

    XmlBoolean xgetEaLnBrk();

    STTextFontAlignType xgetFontAlgn();

    XmlBoolean xgetHangingPunct();

    STTextIndent xgetIndent();

    XmlBoolean xgetLatinLnBrk();

    STTextIndentLevelType xgetLvl();

    STTextMargin xgetMarL();

    STTextMargin xgetMarR();

    XmlBoolean xgetRtl();

    void xsetAlgn(STTextAlignType sTTextAlignType);

    void xsetDefTabSz(STCoordinate32 sTCoordinate32);

    void xsetEaLnBrk(XmlBoolean xmlBoolean);

    void xsetFontAlgn(STTextFontAlignType sTTextFontAlignType);

    void xsetHangingPunct(XmlBoolean xmlBoolean);

    void xsetIndent(STTextIndent sTTextIndent);

    void xsetLatinLnBrk(XmlBoolean xmlBoolean);

    void xsetLvl(STTextIndentLevelType sTTextIndentLevelType);

    void xsetMarL(STTextMargin sTTextMargin);

    void xsetMarR(STTextMargin sTTextMargin);

    void xsetRtl(XmlBoolean xmlBoolean);
}

package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTComplex;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STBWMode$Enum;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STConnectorType$Enum;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STHrAlign$Enum;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalseBlank;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTShapetype extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTShapetype.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapetype5c6ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapetype newInstance() {
            return (CTShapetype) POIXMLTypeLoader.newInstance(CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype newInstance(XmlOptions xmlOptions) {
            return (CTShapetype) POIXMLTypeLoader.newInstance(CTShapetype.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapetype.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(File file) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(file, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(file, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(inputStream, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(inputStream, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(Reader reader) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(reader, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(reader, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(String str) throws XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(str, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(str, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(URL url) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(url, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapetype) POIXMLTypeLoader.parse(url, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(xMLStreamReader, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(xMLStreamReader, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(xMLInputStream, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(xMLInputStream, CTShapetype.type, xmlOptions);
        }

        public static CTShapetype parse(Node node) throws XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(node, CTShapetype.type, (XmlOptions) null);
        }

        public static CTShapetype parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShapetype) POIXMLTypeLoader.parse(node, CTShapetype.type, xmlOptions);
        }
    }

    CTAnchorLock addNewAnchorlock();

    CTBorder addNewBorderbottom();

    CTBorder addNewBorderleft();

    CTBorder addNewBorderright();

    CTBorder addNewBordertop();

    CTCallout addNewCallout();

    CTClientData addNewClientData();

    CTClipPath addNewClippath();

    CTComplex addNewComplex();

    CTExtrusion addNewExtrusion();

    CTFill addNewFill();

    CTFormulas addNewFormulas();

    CTHandles addNewHandles();

    CTImageData addNewImagedata();

    CTLock addNewLock();

    CTPath addNewPath();

    CTShadow addNewShadow();

    CTSignatureLine addNewSignatureline();

    CTSkew addNewSkew();

    CTStroke addNewStroke();

    CTTextbox addNewTextbox();

    CTRel addNewTextdata();

    CTTextPath addNewTextpath();

    CTWrap addNewWrap();

    String getAdj();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getAllowincell();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getAllowoverlap();

    String getAlt();

    CTAnchorLock getAnchorlockArray(int i);

    CTAnchorLock[] getAnchorlockArray();

    List<CTAnchorLock> getAnchorlockList();

    CTBorder getBorderbottomArray(int i);

    CTBorder[] getBorderbottomArray();

    List<CTBorder> getBorderbottomList();

    String getBorderbottomcolor();

    CTBorder getBorderleftArray(int i);

    CTBorder[] getBorderleftArray();

    List<CTBorder> getBorderleftList();

    String getBorderleftcolor();

    CTBorder getBorderrightArray(int i);

    CTBorder[] getBorderrightArray();

    List<CTBorder> getBorderrightList();

    String getBorderrightcolor();

    CTBorder getBordertopArray(int i);

    CTBorder[] getBordertopArray();

    List<CTBorder> getBordertopList();

    String getBordertopcolor();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getBullet();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getButton();

    STBWMode$Enum getBwmode();

    STBWMode$Enum getBwnormal();

    STBWMode$Enum getBwpure();

    CTCallout getCalloutArray(int i);

    CTCallout[] getCalloutArray();

    List<CTCallout> getCalloutList();

    String getChromakey();

    String getClass1();

    CTClientData getClientDataArray(int i);

    CTClientData[] getClientDataArray();

    List<CTClientData> getClientDataList();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getClip();

    CTClipPath getClippathArray(int i);

    CTClipPath[] getClippathArray();

    List<CTClipPath> getClippathList();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getCliptowrap();

    CTComplex getComplex();

    STConnectorType$Enum getConnectortype();

    String getCoordorigin();

    String getCoordsize();

    BigInteger getDgmlayout();

    BigInteger getDgmlayoutmru();

    BigInteger getDgmnodekind();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getDoubleclicknotify();

    CTExtrusion getExtrusionArray(int i);

    CTExtrusion[] getExtrusionArray();

    List<CTExtrusion> getExtrusionList();

    CTFill getFillArray(int i);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    String getFillcolor();

    STTrueFalse.Enum getFilled();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getForcedash();

    CTFormulas getFormulasArray(int i);

    CTFormulas[] getFormulasArray();

    List<CTFormulas> getFormulasList();

    CTHandles getHandlesArray(int i);

    CTHandles[] getHandlesArray();

    List<CTHandles> getHandlesList();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getHr();

    STHrAlign$Enum getHralign();

    String getHref();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getHrnoshade();

    float getHrpct();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getHrstd();

    String getId();

    CTImageData getImagedataArray(int i);

    CTImageData[] getImagedataArray();

    List<CTImageData> getImagedataList();

    STInsetMode.Enum getInsetmode();

    STTrueFalse.Enum getInsetpen();

    CTLock getLockArray(int i);

    CTLock[] getLockArray();

    List<CTLock> getLockList();

    String getMaster();

    com.microsoft.schemas.office.office.STTrueFalseBlank$Enum getOle();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getOleicon();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getOned();

    String getOpacity();

    String getPath2();

    CTPath getPathArray(int i);

    CTPath[] getPathArray();

    List<CTPath> getPathList();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getPreferrelative();

    STTrueFalse.Enum getPrint();

    BigInteger getRegroupid();

    CTShadow getShadowArray(int i);

    CTShadow[] getShadowArray();

    List<CTShadow> getShadowList();

    CTSignatureLine getSignaturelineArray(int i);

    CTSignatureLine[] getSignaturelineArray();

    List<CTSignatureLine> getSignaturelineList();

    CTSkew getSkewArray(int i);

    CTSkew[] getSkewArray();

    List<CTSkew> getSkewList();

    String getSpid();

    float getSpt();

    CTStroke getStrokeArray(int i);

    CTStroke[] getStrokeArray();

    List<CTStroke> getStrokeList();

    String getStrokecolor();

    STTrueFalse.Enum getStroked();

    String getStrokeweight();

    String getStyle();

    String getTarget();

    CTTextbox getTextboxArray(int i);

    CTTextbox[] getTextboxArray();

    List<CTTextbox> getTextboxList();

    CTRel getTextdataArray(int i);

    CTRel[] getTextdataArray();

    List<CTRel> getTextdataList();

    CTTextPath getTextpathArray(int i);

    CTTextPath[] getTextpathArray();

    List<CTTextPath> getTextpathList();

    String getTitle();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getUserdrawn();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getUserhidden();

    CTWrap getWrapArray(int i);

    CTWrap[] getWrapArray();

    List<CTWrap> getWrapList();

    String getWrapcoords();

    CTAnchorLock insertNewAnchorlock(int i);

    CTBorder insertNewBorderbottom(int i);

    CTBorder insertNewBorderleft(int i);

    CTBorder insertNewBorderright(int i);

    CTBorder insertNewBordertop(int i);

    CTCallout insertNewCallout(int i);

    CTClientData insertNewClientData(int i);

    CTClipPath insertNewClippath(int i);

    CTExtrusion insertNewExtrusion(int i);

    CTFill insertNewFill(int i);

    CTFormulas insertNewFormulas(int i);

    CTHandles insertNewHandles(int i);

    CTImageData insertNewImagedata(int i);

    CTLock insertNewLock(int i);

    CTPath insertNewPath(int i);

    CTShadow insertNewShadow(int i);

    CTSignatureLine insertNewSignatureline(int i);

    CTSkew insertNewSkew(int i);

    CTStroke insertNewStroke(int i);

    CTTextbox insertNewTextbox(int i);

    CTRel insertNewTextdata(int i);

    CTTextPath insertNewTextpath(int i);

    CTWrap insertNewWrap(int i);

    boolean isSetAdj();

    boolean isSetAllowincell();

    boolean isSetAllowoverlap();

    boolean isSetAlt();

    boolean isSetBorderbottomcolor();

    boolean isSetBorderleftcolor();

    boolean isSetBorderrightcolor();

    boolean isSetBordertopcolor();

    boolean isSetBullet();

    boolean isSetButton();

    boolean isSetBwmode();

    boolean isSetBwnormal();

    boolean isSetBwpure();

    boolean isSetChromakey();

    boolean isSetClass1();

    boolean isSetClip();

    boolean isSetCliptowrap();

    boolean isSetComplex();

    boolean isSetConnectortype();

    boolean isSetCoordorigin();

    boolean isSetCoordsize();

    boolean isSetDgmlayout();

    boolean isSetDgmlayoutmru();

    boolean isSetDgmnodekind();

    boolean isSetDoubleclicknotify();

    boolean isSetFillcolor();

    boolean isSetFilled();

    boolean isSetForcedash();

    boolean isSetHr();

    boolean isSetHralign();

    boolean isSetHref();

    boolean isSetHrnoshade();

    boolean isSetHrpct();

    boolean isSetHrstd();

    boolean isSetId();

    boolean isSetInsetmode();

    boolean isSetInsetpen();

    boolean isSetMaster();

    boolean isSetOle();

    boolean isSetOleicon();

    boolean isSetOned();

    boolean isSetOpacity();

    boolean isSetPath2();

    boolean isSetPreferrelative();

    boolean isSetPrint();

    boolean isSetRegroupid();

    boolean isSetSpid();

    boolean isSetSpt();

    boolean isSetStrokecolor();

    boolean isSetStroked();

    boolean isSetStrokeweight();

    boolean isSetStyle();

    boolean isSetTarget();

    boolean isSetTitle();

    boolean isSetUserdrawn();

    boolean isSetUserhidden();

    boolean isSetWrapcoords();

    void removeAnchorlock(int i);

    void removeBorderbottom(int i);

    void removeBorderleft(int i);

    void removeBorderright(int i);

    void removeBordertop(int i);

    void removeCallout(int i);

    void removeClientData(int i);

    void removeClippath(int i);

    void removeExtrusion(int i);

    void removeFill(int i);

    void removeFormulas(int i);

    void removeHandles(int i);

    void removeImagedata(int i);

    void removeLock(int i);

    void removePath(int i);

    void removeShadow(int i);

    void removeSignatureline(int i);

    void removeSkew(int i);

    void removeStroke(int i);

    void removeTextbox(int i);

    void removeTextdata(int i);

    void removeTextpath(int i);

    void removeWrap(int i);

    void setAdj(String str);

    void setAllowincell(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setAllowoverlap(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setAlt(String str);

    void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock);

    void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr);

    void setBorderbottomArray(int i, CTBorder cTBorder);

    void setBorderbottomArray(CTBorder[] cTBorderArr);

    void setBorderbottomcolor(String str);

    void setBorderleftArray(int i, CTBorder cTBorder);

    void setBorderleftArray(CTBorder[] cTBorderArr);

    void setBorderleftcolor(String str);

    void setBorderrightArray(int i, CTBorder cTBorder);

    void setBorderrightArray(CTBorder[] cTBorderArr);

    void setBorderrightcolor(String str);

    void setBordertopArray(int i, CTBorder cTBorder);

    void setBordertopArray(CTBorder[] cTBorderArr);

    void setBordertopcolor(String str);

    void setBullet(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setButton(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setBwmode(STBWMode$Enum sTBWMode$Enum);

    void setBwnormal(STBWMode$Enum sTBWMode$Enum);

    void setBwpure(STBWMode$Enum sTBWMode$Enum);

    void setCalloutArray(int i, CTCallout cTCallout);

    void setCalloutArray(CTCallout[] cTCalloutArr);

    void setChromakey(String str);

    void setClass1(String str);

    void setClientDataArray(int i, CTClientData cTClientData);

    void setClientDataArray(CTClientData[] cTClientDataArr);

    void setClip(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setClippathArray(int i, CTClipPath cTClipPath);

    void setClippathArray(CTClipPath[] cTClipPathArr);

    void setCliptowrap(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setComplex(CTComplex cTComplex);

    void setConnectortype(STConnectorType$Enum sTConnectorType$Enum);

    void setCoordorigin(String str);

    void setCoordsize(String str);

    void setDgmlayout(BigInteger bigInteger);

    void setDgmlayoutmru(BigInteger bigInteger);

    void setDgmnodekind(BigInteger bigInteger);

    void setDoubleclicknotify(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setExtrusionArray(int i, CTExtrusion cTExtrusion);

    void setExtrusionArray(CTExtrusion[] cTExtrusionArr);

    void setFillArray(int i, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    void setFillcolor(String str);

    void setFilled(STTrueFalse.Enum r1);

    void setForcedash(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setFormulasArray(int i, CTFormulas cTFormulas);

    void setFormulasArray(CTFormulas[] cTFormulasArr);

    void setHandlesArray(int i, CTHandles cTHandles);

    void setHandlesArray(CTHandles[] cTHandlesArr);

    void setHr(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setHralign(STHrAlign$Enum sTHrAlign$Enum);

    void setHref(String str);

    void setHrnoshade(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setHrpct(float f);

    void setHrstd(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setId(String str);

    void setImagedataArray(int i, CTImageData cTImageData);

    void setImagedataArray(CTImageData[] cTImageDataArr);

    void setInsetmode(STInsetMode.Enum r1);

    void setInsetpen(STTrueFalse.Enum r1);

    void setLockArray(int i, CTLock cTLock);

    void setLockArray(CTLock[] cTLockArr);

    void setMaster(String str);

    void setOle(com.microsoft.schemas.office.office.STTrueFalseBlank$Enum sTTrueFalseBlank$Enum);

    void setOleicon(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setOned(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setOpacity(String str);

    void setPath2(String str);

    void setPathArray(int i, CTPath cTPath);

    void setPathArray(CTPath[] cTPathArr);

    void setPreferrelative(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setPrint(STTrueFalse.Enum r1);

    void setRegroupid(BigInteger bigInteger);

    void setShadowArray(int i, CTShadow cTShadow);

    void setShadowArray(CTShadow[] cTShadowArr);

    void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine);

    void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr);

    void setSkewArray(int i, CTSkew cTSkew);

    void setSkewArray(CTSkew[] cTSkewArr);

    void setSpid(String str);

    void setSpt(float f);

    void setStrokeArray(int i, CTStroke cTStroke);

    void setStrokeArray(CTStroke[] cTStrokeArr);

    void setStrokecolor(String str);

    void setStroked(STTrueFalse.Enum r1);

    void setStrokeweight(String str);

    void setStyle(String str);

    void setTarget(String str);

    void setTextboxArray(int i, CTTextbox cTTextbox);

    void setTextboxArray(CTTextbox[] cTTextboxArr);

    void setTextdataArray(int i, CTRel cTRel);

    void setTextdataArray(CTRel[] cTRelArr);

    void setTextpathArray(int i, CTTextPath cTTextPath);

    void setTextpathArray(CTTextPath[] cTTextPathArr);

    void setTitle(String str);

    void setUserdrawn(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setUserhidden(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setWrapArray(int i, CTWrap cTWrap);

    void setWrapArray(CTWrap[] cTWrapArr);

    void setWrapcoords(String str);

    int sizeOfAnchorlockArray();

    int sizeOfBorderbottomArray();

    int sizeOfBorderleftArray();

    int sizeOfBorderrightArray();

    int sizeOfBordertopArray();

    int sizeOfCalloutArray();

    int sizeOfClientDataArray();

    int sizeOfClippathArray();

    int sizeOfExtrusionArray();

    int sizeOfFillArray();

    int sizeOfFormulasArray();

    int sizeOfHandlesArray();

    int sizeOfImagedataArray();

    int sizeOfLockArray();

    int sizeOfPathArray();

    int sizeOfShadowArray();

    int sizeOfSignaturelineArray();

    int sizeOfSkewArray();

    int sizeOfStrokeArray();

    int sizeOfTextboxArray();

    int sizeOfTextdataArray();

    int sizeOfTextpathArray();

    int sizeOfWrapArray();

    void unsetAdj();

    void unsetAllowincell();

    void unsetAllowoverlap();

    void unsetAlt();

    void unsetBorderbottomcolor();

    void unsetBorderleftcolor();

    void unsetBorderrightcolor();

    void unsetBordertopcolor();

    void unsetBullet();

    void unsetButton();

    void unsetBwmode();

    void unsetBwnormal();

    void unsetBwpure();

    void unsetChromakey();

    void unsetClass1();

    void unsetClip();

    void unsetCliptowrap();

    void unsetComplex();

    void unsetConnectortype();

    void unsetCoordorigin();

    void unsetCoordsize();

    void unsetDgmlayout();

    void unsetDgmlayoutmru();

    void unsetDgmnodekind();

    void unsetDoubleclicknotify();

    void unsetFillcolor();

    void unsetFilled();

    void unsetForcedash();

    void unsetHr();

    void unsetHralign();

    void unsetHref();

    void unsetHrnoshade();

    void unsetHrpct();

    void unsetHrstd();

    void unsetId();

    void unsetInsetmode();

    void unsetInsetpen();

    void unsetMaster();

    void unsetOle();

    void unsetOleicon();

    void unsetOned();

    void unsetOpacity();

    void unsetPath2();

    void unsetPreferrelative();

    void unsetPrint();

    void unsetRegroupid();

    void unsetSpid();

    void unsetSpt();

    void unsetStrokecolor();

    void unsetStroked();

    void unsetStrokeweight();

    void unsetStyle();

    void unsetTarget();

    void unsetTitle();

    void unsetUserdrawn();

    void unsetUserhidden();

    void unsetWrapcoords();

    XmlString xgetAdj();

    com.microsoft.schemas.office.office.STTrueFalse xgetAllowincell();

    com.microsoft.schemas.office.office.STTrueFalse xgetAllowoverlap();

    XmlString xgetAlt();

    XmlString xgetBorderbottomcolor();

    XmlString xgetBorderleftcolor();

    XmlString xgetBorderrightcolor();

    XmlString xgetBordertopcolor();

    com.microsoft.schemas.office.office.STTrueFalse xgetBullet();

    com.microsoft.schemas.office.office.STTrueFalse xgetButton();

    STBWMode xgetBwmode();

    STBWMode xgetBwnormal();

    STBWMode xgetBwpure();

    STColorType xgetChromakey();

    XmlString xgetClass1();

    com.microsoft.schemas.office.office.STTrueFalse xgetClip();

    com.microsoft.schemas.office.office.STTrueFalse xgetCliptowrap();

    STConnectorType xgetConnectortype();

    XmlString xgetCoordorigin();

    XmlString xgetCoordsize();

    XmlInteger xgetDgmlayout();

    XmlInteger xgetDgmlayoutmru();

    XmlInteger xgetDgmnodekind();

    com.microsoft.schemas.office.office.STTrueFalse xgetDoubleclicknotify();

    STColorType xgetFillcolor();

    STTrueFalse xgetFilled();

    com.microsoft.schemas.office.office.STTrueFalse xgetForcedash();

    com.microsoft.schemas.office.office.STTrueFalse xgetHr();

    STHrAlign xgetHralign();

    XmlString xgetHref();

    com.microsoft.schemas.office.office.STTrueFalse xgetHrnoshade();

    XmlFloat xgetHrpct();

    com.microsoft.schemas.office.office.STTrueFalse xgetHrstd();

    XmlString xgetId();

    STInsetMode xgetInsetmode();

    STTrueFalse xgetInsetpen();

    XmlString xgetMaster();

    STTrueFalseBlank xgetOle();

    com.microsoft.schemas.office.office.STTrueFalse xgetOleicon();

    com.microsoft.schemas.office.office.STTrueFalse xgetOned();

    XmlString xgetOpacity();

    XmlString xgetPath2();

    com.microsoft.schemas.office.office.STTrueFalse xgetPreferrelative();

    STTrueFalse xgetPrint();

    XmlInteger xgetRegroupid();

    XmlString xgetSpid();

    XmlFloat xgetSpt();

    STColorType xgetStrokecolor();

    STTrueFalse xgetStroked();

    XmlString xgetStrokeweight();

    XmlString xgetStyle();

    XmlString xgetTarget();

    XmlString xgetTitle();

    com.microsoft.schemas.office.office.STTrueFalse xgetUserdrawn();

    com.microsoft.schemas.office.office.STTrueFalse xgetUserhidden();

    XmlString xgetWrapcoords();

    void xsetAdj(XmlString xmlString);

    void xsetAllowincell(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetAllowoverlap(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetAlt(XmlString xmlString);

    void xsetBorderbottomcolor(XmlString xmlString);

    void xsetBorderleftcolor(XmlString xmlString);

    void xsetBorderrightcolor(XmlString xmlString);

    void xsetBordertopcolor(XmlString xmlString);

    void xsetBullet(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetButton(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetBwmode(STBWMode sTBWMode);

    void xsetBwnormal(STBWMode sTBWMode);

    void xsetBwpure(STBWMode sTBWMode);

    void xsetChromakey(STColorType sTColorType);

    void xsetClass1(XmlString xmlString);

    void xsetClip(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetCliptowrap(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetConnectortype(STConnectorType sTConnectorType);

    void xsetCoordorigin(XmlString xmlString);

    void xsetCoordsize(XmlString xmlString);

    void xsetDgmlayout(XmlInteger xmlInteger);

    void xsetDgmlayoutmru(XmlInteger xmlInteger);

    void xsetDgmnodekind(XmlInteger xmlInteger);

    void xsetDoubleclicknotify(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetFillcolor(STColorType sTColorType);

    void xsetFilled(STTrueFalse sTTrueFalse);

    void xsetForcedash(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetHr(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetHralign(STHrAlign sTHrAlign);

    void xsetHref(XmlString xmlString);

    void xsetHrnoshade(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetHrpct(XmlFloat xmlFloat);

    void xsetHrstd(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetInsetpen(STTrueFalse sTTrueFalse);

    void xsetMaster(XmlString xmlString);

    void xsetOle(STTrueFalseBlank sTTrueFalseBlank);

    void xsetOleicon(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetOned(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetPath2(XmlString xmlString);

    void xsetPreferrelative(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetPrint(STTrueFalse sTTrueFalse);

    void xsetRegroupid(XmlInteger xmlInteger);

    void xsetSpid(XmlString xmlString);

    void xsetSpt(XmlFloat xmlFloat);

    void xsetStrokecolor(STColorType sTColorType);

    void xsetStroked(STTrueFalse sTTrueFalse);

    void xsetStrokeweight(XmlString xmlString);

    void xsetStyle(XmlString xmlString);

    void xsetTarget(XmlString xmlString);

    void xsetTitle(XmlString xmlString);

    void xsetUserdrawn(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetUserhidden(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetWrapcoords(XmlString xmlString);
}

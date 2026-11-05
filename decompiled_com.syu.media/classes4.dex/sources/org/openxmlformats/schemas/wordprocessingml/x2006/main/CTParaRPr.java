package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTParaRPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTParaRPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpararprd6fetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTParaRPr newInstance() {
            return (CTParaRPr) POIXMLTypeLoader.newInstance(CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr newInstance(XmlOptions xmlOptions) {
            return (CTParaRPr) POIXMLTypeLoader.newInstance(CTParaRPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTParaRPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(File file) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(file, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(file, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(inputStream, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(inputStream, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(Reader reader) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(reader, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(reader, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(String str) throws XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(str, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(str, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(URL url) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(url, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTParaRPr) POIXMLTypeLoader.parse(url, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(xMLStreamReader, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(xMLStreamReader, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(xMLInputStream, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(xMLInputStream, CTParaRPr.type, xmlOptions);
        }

        public static CTParaRPr parse(Node node) throws XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(node, CTParaRPr.type, (XmlOptions) null);
        }

        public static CTParaRPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTParaRPr) POIXMLTypeLoader.parse(node, CTParaRPr.type, xmlOptions);
        }
    }

    CTOnOff addNewB();

    CTOnOff addNewBCs();

    CTBorder addNewBdr();

    CTOnOff addNewCaps();

    CTColor addNewColor();

    CTOnOff addNewCs();

    CTTrackChange addNewDel();

    CTOnOff addNewDstrike();

    CTEastAsianLayout addNewEastAsianLayout();

    CTTextEffect addNewEffect();

    CTEm addNewEm();

    CTOnOff addNewEmboss();

    CTFitText addNewFitText();

    CTHighlight addNewHighlight();

    CTOnOff addNewI();

    CTOnOff addNewICs();

    CTOnOff addNewImprint();

    CTTrackChange addNewIns();

    CTHpsMeasure addNewKern();

    CTLanguage addNewLang();

    CTTrackChange addNewMoveFrom();

    CTTrackChange addNewMoveTo();

    CTOnOff addNewNoProof();

    CTOnOff addNewOMath();

    CTOnOff addNewOutline();

    CTSignedHpsMeasure addNewPosition();

    CTFonts addNewRFonts();

    CTParaRPrChange addNewRPrChange();

    CTString addNewRStyle();

    CTOnOff addNewRtl();

    CTOnOff addNewShadow();

    CTShd addNewShd();

    CTOnOff addNewSmallCaps();

    CTOnOff addNewSnapToGrid();

    CTSignedTwipsMeasure addNewSpacing();

    CTOnOff addNewSpecVanish();

    CTOnOff addNewStrike();

    CTHpsMeasure addNewSz();

    CTHpsMeasure addNewSzCs();

    CTUnderline addNewU();

    CTOnOff addNewVanish();

    CTVerticalAlignRun addNewVertAlign();

    CTTextScale addNewW();

    CTOnOff addNewWebHidden();

    CTOnOff getB();

    CTOnOff getBCs();

    CTBorder getBdr();

    CTOnOff getCaps();

    CTColor getColor();

    CTOnOff getCs();

    CTTrackChange getDel();

    CTOnOff getDstrike();

    CTEastAsianLayout getEastAsianLayout();

    CTTextEffect getEffect();

    CTEm getEm();

    CTOnOff getEmboss();

    CTFitText getFitText();

    CTHighlight getHighlight();

    CTOnOff getI();

    CTOnOff getICs();

    CTOnOff getImprint();

    CTTrackChange getIns();

    CTHpsMeasure getKern();

    CTLanguage getLang();

    CTTrackChange getMoveFrom();

    CTTrackChange getMoveTo();

    CTOnOff getNoProof();

    CTOnOff getOMath();

    CTOnOff getOutline();

    CTSignedHpsMeasure getPosition();

    CTFonts getRFonts();

    CTParaRPrChange getRPrChange();

    CTString getRStyle();

    CTOnOff getRtl();

    CTOnOff getShadow();

    CTShd getShd();

    CTOnOff getSmallCaps();

    CTOnOff getSnapToGrid();

    CTSignedTwipsMeasure getSpacing();

    CTOnOff getSpecVanish();

    CTOnOff getStrike();

    CTHpsMeasure getSz();

    CTHpsMeasure getSzCs();

    CTUnderline getU();

    CTOnOff getVanish();

    CTVerticalAlignRun getVertAlign();

    CTTextScale getW();

    CTOnOff getWebHidden();

    boolean isSetB();

    boolean isSetBCs();

    boolean isSetBdr();

    boolean isSetCaps();

    boolean isSetColor();

    boolean isSetCs();

    boolean isSetDel();

    boolean isSetDstrike();

    boolean isSetEastAsianLayout();

    boolean isSetEffect();

    boolean isSetEm();

    boolean isSetEmboss();

    boolean isSetFitText();

    boolean isSetHighlight();

    boolean isSetI();

    boolean isSetICs();

    boolean isSetImprint();

    boolean isSetIns();

    boolean isSetKern();

    boolean isSetLang();

    boolean isSetMoveFrom();

    boolean isSetMoveTo();

    boolean isSetNoProof();

    boolean isSetOMath();

    boolean isSetOutline();

    boolean isSetPosition();

    boolean isSetRFonts();

    boolean isSetRPrChange();

    boolean isSetRStyle();

    boolean isSetRtl();

    boolean isSetShadow();

    boolean isSetShd();

    boolean isSetSmallCaps();

    boolean isSetSnapToGrid();

    boolean isSetSpacing();

    boolean isSetSpecVanish();

    boolean isSetStrike();

    boolean isSetSz();

    boolean isSetSzCs();

    boolean isSetU();

    boolean isSetVanish();

    boolean isSetVertAlign();

    boolean isSetW();

    boolean isSetWebHidden();

    void setB(CTOnOff cTOnOff);

    void setBCs(CTOnOff cTOnOff);

    void setBdr(CTBorder cTBorder);

    void setCaps(CTOnOff cTOnOff);

    void setColor(CTColor cTColor);

    void setCs(CTOnOff cTOnOff);

    void setDel(CTTrackChange cTTrackChange);

    void setDstrike(CTOnOff cTOnOff);

    void setEastAsianLayout(CTEastAsianLayout cTEastAsianLayout);

    void setEffect(CTTextEffect cTTextEffect);

    void setEm(CTEm cTEm);

    void setEmboss(CTOnOff cTOnOff);

    void setFitText(CTFitText cTFitText);

    void setHighlight(CTHighlight cTHighlight);

    void setI(CTOnOff cTOnOff);

    void setICs(CTOnOff cTOnOff);

    void setImprint(CTOnOff cTOnOff);

    void setIns(CTTrackChange cTTrackChange);

    void setKern(CTHpsMeasure cTHpsMeasure);

    void setLang(CTLanguage cTLanguage);

    void setMoveFrom(CTTrackChange cTTrackChange);

    void setMoveTo(CTTrackChange cTTrackChange);

    void setNoProof(CTOnOff cTOnOff);

    void setOMath(CTOnOff cTOnOff);

    void setOutline(CTOnOff cTOnOff);

    void setPosition(CTSignedHpsMeasure cTSignedHpsMeasure);

    void setRFonts(CTFonts cTFonts);

    void setRPrChange(CTParaRPrChange cTParaRPrChange);

    void setRStyle(CTString cTString);

    void setRtl(CTOnOff cTOnOff);

    void setShadow(CTOnOff cTOnOff);

    void setShd(CTShd cTShd);

    void setSmallCaps(CTOnOff cTOnOff);

    void setSnapToGrid(CTOnOff cTOnOff);

    void setSpacing(CTSignedTwipsMeasure cTSignedTwipsMeasure);

    void setSpecVanish(CTOnOff cTOnOff);

    void setStrike(CTOnOff cTOnOff);

    void setSz(CTHpsMeasure cTHpsMeasure);

    void setSzCs(CTHpsMeasure cTHpsMeasure);

    void setU(CTUnderline cTUnderline);

    void setVanish(CTOnOff cTOnOff);

    void setVertAlign(CTVerticalAlignRun cTVerticalAlignRun);

    void setW(CTTextScale cTTextScale);

    void setWebHidden(CTOnOff cTOnOff);

    void unsetB();

    void unsetBCs();

    void unsetBdr();

    void unsetCaps();

    void unsetColor();

    void unsetCs();

    void unsetDel();

    void unsetDstrike();

    void unsetEastAsianLayout();

    void unsetEffect();

    void unsetEm();

    void unsetEmboss();

    void unsetFitText();

    void unsetHighlight();

    void unsetI();

    void unsetICs();

    void unsetImprint();

    void unsetIns();

    void unsetKern();

    void unsetLang();

    void unsetMoveFrom();

    void unsetMoveTo();

    void unsetNoProof();

    void unsetOMath();

    void unsetOutline();

    void unsetPosition();

    void unsetRFonts();

    void unsetRPrChange();

    void unsetRStyle();

    void unsetRtl();

    void unsetShadow();

    void unsetShd();

    void unsetSmallCaps();

    void unsetSnapToGrid();

    void unsetSpacing();

    void unsetSpecVanish();

    void unsetStrike();

    void unsetSz();

    void unsetSzCs();

    void unsetU();

    void unsetVanish();

    void unsetVertAlign();

    void unsetW();

    void unsetWebHidden();
}

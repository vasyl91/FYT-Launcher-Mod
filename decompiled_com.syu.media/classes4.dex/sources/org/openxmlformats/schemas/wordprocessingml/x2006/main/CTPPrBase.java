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
public interface CTPPrBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpprbasebaeftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPPrBase newInstance() {
            return (CTPPrBase) POIXMLTypeLoader.newInstance(CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase newInstance(XmlOptions xmlOptions) {
            return (CTPPrBase) POIXMLTypeLoader.newInstance(CTPPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPrBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(File file) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(file, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(file, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(inputStream, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(inputStream, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(Reader reader) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(reader, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(reader, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(String str) throws XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(str, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(str, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(URL url) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(url, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrBase) POIXMLTypeLoader.parse(url, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTPPrBase.type, xmlOptions);
        }

        public static CTPPrBase parse(Node node) throws XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(node, CTPPrBase.type, (XmlOptions) null);
        }

        public static CTPPrBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPPrBase) POIXMLTypeLoader.parse(node, CTPPrBase.type, xmlOptions);
        }
    }

    CTOnOff addNewAdjustRightInd();

    CTOnOff addNewAutoSpaceDE();

    CTOnOff addNewAutoSpaceDN();

    CTOnOff addNewBidi();

    CTCnf addNewCnfStyle();

    CTOnOff addNewContextualSpacing();

    CTDecimalNumber addNewDivId();

    CTFramePr addNewFramePr();

    CTInd addNewInd();

    CTJc addNewJc();

    CTOnOff addNewKeepLines();

    CTOnOff addNewKeepNext();

    CTOnOff addNewKinsoku();

    CTOnOff addNewMirrorIndents();

    CTNumPr addNewNumPr();

    CTDecimalNumber addNewOutlineLvl();

    CTOnOff addNewOverflowPunct();

    CTPBdr addNewPBdr();

    CTString addNewPStyle();

    CTOnOff addNewPageBreakBefore();

    CTShd addNewShd();

    CTOnOff addNewSnapToGrid();

    CTSpacing addNewSpacing();

    CTOnOff addNewSuppressAutoHyphens();

    CTOnOff addNewSuppressLineNumbers();

    CTOnOff addNewSuppressOverlap();

    CTTabs addNewTabs();

    CTTextAlignment addNewTextAlignment();

    CTTextDirection addNewTextDirection();

    CTTextboxTightWrap addNewTextboxTightWrap();

    CTOnOff addNewTopLinePunct();

    CTOnOff addNewWidowControl();

    CTOnOff addNewWordWrap();

    CTOnOff getAdjustRightInd();

    CTOnOff getAutoSpaceDE();

    CTOnOff getAutoSpaceDN();

    CTOnOff getBidi();

    CTCnf getCnfStyle();

    CTOnOff getContextualSpacing();

    CTDecimalNumber getDivId();

    CTFramePr getFramePr();

    CTInd getInd();

    CTJc getJc();

    CTOnOff getKeepLines();

    CTOnOff getKeepNext();

    CTOnOff getKinsoku();

    CTOnOff getMirrorIndents();

    CTNumPr getNumPr();

    CTDecimalNumber getOutlineLvl();

    CTOnOff getOverflowPunct();

    CTPBdr getPBdr();

    CTString getPStyle();

    CTOnOff getPageBreakBefore();

    CTShd getShd();

    CTOnOff getSnapToGrid();

    CTSpacing getSpacing();

    CTOnOff getSuppressAutoHyphens();

    CTOnOff getSuppressLineNumbers();

    CTOnOff getSuppressOverlap();

    CTTabs getTabs();

    CTTextAlignment getTextAlignment();

    CTTextDirection getTextDirection();

    CTTextboxTightWrap getTextboxTightWrap();

    CTOnOff getTopLinePunct();

    CTOnOff getWidowControl();

    CTOnOff getWordWrap();

    boolean isSetAdjustRightInd();

    boolean isSetAutoSpaceDE();

    boolean isSetAutoSpaceDN();

    boolean isSetBidi();

    boolean isSetCnfStyle();

    boolean isSetContextualSpacing();

    boolean isSetDivId();

    boolean isSetFramePr();

    boolean isSetInd();

    boolean isSetJc();

    boolean isSetKeepLines();

    boolean isSetKeepNext();

    boolean isSetKinsoku();

    boolean isSetMirrorIndents();

    boolean isSetNumPr();

    boolean isSetOutlineLvl();

    boolean isSetOverflowPunct();

    boolean isSetPBdr();

    boolean isSetPStyle();

    boolean isSetPageBreakBefore();

    boolean isSetShd();

    boolean isSetSnapToGrid();

    boolean isSetSpacing();

    boolean isSetSuppressAutoHyphens();

    boolean isSetSuppressLineNumbers();

    boolean isSetSuppressOverlap();

    boolean isSetTabs();

    boolean isSetTextAlignment();

    boolean isSetTextDirection();

    boolean isSetTextboxTightWrap();

    boolean isSetTopLinePunct();

    boolean isSetWidowControl();

    boolean isSetWordWrap();

    void setAdjustRightInd(CTOnOff cTOnOff);

    void setAutoSpaceDE(CTOnOff cTOnOff);

    void setAutoSpaceDN(CTOnOff cTOnOff);

    void setBidi(CTOnOff cTOnOff);

    void setCnfStyle(CTCnf cTCnf);

    void setContextualSpacing(CTOnOff cTOnOff);

    void setDivId(CTDecimalNumber cTDecimalNumber);

    void setFramePr(CTFramePr cTFramePr);

    void setInd(CTInd cTInd);

    void setJc(CTJc cTJc);

    void setKeepLines(CTOnOff cTOnOff);

    void setKeepNext(CTOnOff cTOnOff);

    void setKinsoku(CTOnOff cTOnOff);

    void setMirrorIndents(CTOnOff cTOnOff);

    void setNumPr(CTNumPr cTNumPr);

    void setOutlineLvl(CTDecimalNumber cTDecimalNumber);

    void setOverflowPunct(CTOnOff cTOnOff);

    void setPBdr(CTPBdr cTPBdr);

    void setPStyle(CTString cTString);

    void setPageBreakBefore(CTOnOff cTOnOff);

    void setShd(CTShd cTShd);

    void setSnapToGrid(CTOnOff cTOnOff);

    void setSpacing(CTSpacing cTSpacing);

    void setSuppressAutoHyphens(CTOnOff cTOnOff);

    void setSuppressLineNumbers(CTOnOff cTOnOff);

    void setSuppressOverlap(CTOnOff cTOnOff);

    void setTabs(CTTabs cTTabs);

    void setTextAlignment(CTTextAlignment cTTextAlignment);

    void setTextDirection(CTTextDirection cTTextDirection);

    void setTextboxTightWrap(CTTextboxTightWrap cTTextboxTightWrap);

    void setTopLinePunct(CTOnOff cTOnOff);

    void setWidowControl(CTOnOff cTOnOff);

    void setWordWrap(CTOnOff cTOnOff);

    void unsetAdjustRightInd();

    void unsetAutoSpaceDE();

    void unsetAutoSpaceDN();

    void unsetBidi();

    void unsetCnfStyle();

    void unsetContextualSpacing();

    void unsetDivId();

    void unsetFramePr();

    void unsetInd();

    void unsetJc();

    void unsetKeepLines();

    void unsetKeepNext();

    void unsetKinsoku();

    void unsetMirrorIndents();

    void unsetNumPr();

    void unsetOutlineLvl();

    void unsetOverflowPunct();

    void unsetPBdr();

    void unsetPStyle();

    void unsetPageBreakBefore();

    void unsetShd();

    void unsetSnapToGrid();

    void unsetSpacing();

    void unsetSuppressAutoHyphens();

    void unsetSuppressLineNumbers();

    void unsetSuppressOverlap();

    void unsetTabs();

    void unsetTextAlignment();

    void unsetTextDirection();

    void unsetTextboxTightWrap();

    void unsetTopLinePunct();

    void unsetWidowControl();

    void unsetWordWrap();
}

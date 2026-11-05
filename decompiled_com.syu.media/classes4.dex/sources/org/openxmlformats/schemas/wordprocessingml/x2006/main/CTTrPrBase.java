package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTTrPrBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTrPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttrprbase5d77type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrPrBase newInstance() {
            return (CTTrPrBase) POIXMLTypeLoader.newInstance(CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase newInstance(XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.newInstance(CTTrPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPrBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(File file) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(file, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(file, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(inputStream, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(inputStream, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(Reader reader) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(reader, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(reader, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(String str) throws XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(str, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(str, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(URL url) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(url, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(url, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(Node node) throws XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(node, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPrBase) POIXMLTypeLoader.parse(node, CTTrPrBase.type, xmlOptions);
        }
    }

    CTOnOff addNewCantSplit();

    CTCnf addNewCnfStyle();

    CTDecimalNumber addNewDivId();

    CTDecimalNumber addNewGridAfter();

    CTDecimalNumber addNewGridBefore();

    CTOnOff addNewHidden();

    CTJc addNewJc();

    CTTblWidth addNewTblCellSpacing();

    CTOnOff addNewTblHeader();

    CTHeight addNewTrHeight();

    CTTblWidth addNewWAfter();

    CTTblWidth addNewWBefore();

    CTOnOff getCantSplitArray(int i);

    CTOnOff[] getCantSplitArray();

    List<CTOnOff> getCantSplitList();

    CTCnf getCnfStyleArray(int i);

    CTCnf[] getCnfStyleArray();

    List<CTCnf> getCnfStyleList();

    CTDecimalNumber getDivIdArray(int i);

    CTDecimalNumber[] getDivIdArray();

    List<CTDecimalNumber> getDivIdList();

    CTDecimalNumber getGridAfterArray(int i);

    CTDecimalNumber[] getGridAfterArray();

    List<CTDecimalNumber> getGridAfterList();

    CTDecimalNumber getGridBeforeArray(int i);

    CTDecimalNumber[] getGridBeforeArray();

    List<CTDecimalNumber> getGridBeforeList();

    CTOnOff getHiddenArray(int i);

    CTOnOff[] getHiddenArray();

    List<CTOnOff> getHiddenList();

    CTJc getJcArray(int i);

    CTJc[] getJcArray();

    List<CTJc> getJcList();

    CTTblWidth getTblCellSpacingArray(int i);

    CTTblWidth[] getTblCellSpacingArray();

    List<CTTblWidth> getTblCellSpacingList();

    CTOnOff getTblHeaderArray(int i);

    CTOnOff[] getTblHeaderArray();

    List<CTOnOff> getTblHeaderList();

    CTHeight getTrHeightArray(int i);

    CTHeight[] getTrHeightArray();

    List<CTHeight> getTrHeightList();

    CTTblWidth getWAfterArray(int i);

    CTTblWidth[] getWAfterArray();

    List<CTTblWidth> getWAfterList();

    CTTblWidth getWBeforeArray(int i);

    CTTblWidth[] getWBeforeArray();

    List<CTTblWidth> getWBeforeList();

    CTOnOff insertNewCantSplit(int i);

    CTCnf insertNewCnfStyle(int i);

    CTDecimalNumber insertNewDivId(int i);

    CTDecimalNumber insertNewGridAfter(int i);

    CTDecimalNumber insertNewGridBefore(int i);

    CTOnOff insertNewHidden(int i);

    CTJc insertNewJc(int i);

    CTTblWidth insertNewTblCellSpacing(int i);

    CTOnOff insertNewTblHeader(int i);

    CTHeight insertNewTrHeight(int i);

    CTTblWidth insertNewWAfter(int i);

    CTTblWidth insertNewWBefore(int i);

    void removeCantSplit(int i);

    void removeCnfStyle(int i);

    void removeDivId(int i);

    void removeGridAfter(int i);

    void removeGridBefore(int i);

    void removeHidden(int i);

    void removeJc(int i);

    void removeTblCellSpacing(int i);

    void removeTblHeader(int i);

    void removeTrHeight(int i);

    void removeWAfter(int i);

    void removeWBefore(int i);

    void setCantSplitArray(int i, CTOnOff cTOnOff);

    void setCantSplitArray(CTOnOff[] cTOnOffArr);

    void setCnfStyleArray(int i, CTCnf cTCnf);

    void setCnfStyleArray(CTCnf[] cTCnfArr);

    void setDivIdArray(int i, CTDecimalNumber cTDecimalNumber);

    void setDivIdArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setGridAfterArray(int i, CTDecimalNumber cTDecimalNumber);

    void setGridAfterArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setGridBeforeArray(int i, CTDecimalNumber cTDecimalNumber);

    void setGridBeforeArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setHiddenArray(int i, CTOnOff cTOnOff);

    void setHiddenArray(CTOnOff[] cTOnOffArr);

    void setJcArray(int i, CTJc cTJc);

    void setJcArray(CTJc[] cTJcArr);

    void setTblCellSpacingArray(int i, CTTblWidth cTTblWidth);

    void setTblCellSpacingArray(CTTblWidth[] cTTblWidthArr);

    void setTblHeaderArray(int i, CTOnOff cTOnOff);

    void setTblHeaderArray(CTOnOff[] cTOnOffArr);

    void setTrHeightArray(int i, CTHeight cTHeight);

    void setTrHeightArray(CTHeight[] cTHeightArr);

    void setWAfterArray(int i, CTTblWidth cTTblWidth);

    void setWAfterArray(CTTblWidth[] cTTblWidthArr);

    void setWBeforeArray(int i, CTTblWidth cTTblWidth);

    void setWBeforeArray(CTTblWidth[] cTTblWidthArr);

    int sizeOfCantSplitArray();

    int sizeOfCnfStyleArray();

    int sizeOfDivIdArray();

    int sizeOfGridAfterArray();

    int sizeOfGridBeforeArray();

    int sizeOfHiddenArray();

    int sizeOfJcArray();

    int sizeOfTblCellSpacingArray();

    int sizeOfTblHeaderArray();

    int sizeOfTrHeightArray();

    int sizeOfWAfterArray();

    int sizeOfWBeforeArray();
}

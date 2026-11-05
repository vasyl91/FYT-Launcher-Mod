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
public interface CTR extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTR.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctr8120type");

    public static final class Factory {
        private Factory() {
        }

        public static CTR newInstance() {
            return (CTR) POIXMLTypeLoader.newInstance(CTR.type, (XmlOptions) null);
        }

        public static CTR newInstance(XmlOptions xmlOptions) {
            return (CTR) POIXMLTypeLoader.newInstance(CTR.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTR.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTR.type, xmlOptions);
        }

        public static CTR parse(File file) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(file, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(file, CTR.type, xmlOptions);
        }

        public static CTR parse(InputStream inputStream) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(inputStream, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(inputStream, CTR.type, xmlOptions);
        }

        public static CTR parse(Reader reader) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(reader, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(reader, CTR.type, xmlOptions);
        }

        public static CTR parse(String str) throws XmlException {
            return (CTR) POIXMLTypeLoader.parse(str, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTR) POIXMLTypeLoader.parse(str, CTR.type, xmlOptions);
        }

        public static CTR parse(URL url) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(url, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTR) POIXMLTypeLoader.parse(url, CTR.type, xmlOptions);
        }

        public static CTR parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTR) POIXMLTypeLoader.parse(xMLStreamReader, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTR) POIXMLTypeLoader.parse(xMLStreamReader, CTR.type, xmlOptions);
        }

        public static CTR parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTR) POIXMLTypeLoader.parse(xMLInputStream, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTR) POIXMLTypeLoader.parse(xMLInputStream, CTR.type, xmlOptions);
        }

        public static CTR parse(Node node) throws XmlException {
            return (CTR) POIXMLTypeLoader.parse(node, CTR.type, (XmlOptions) null);
        }

        public static CTR parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTR) POIXMLTypeLoader.parse(node, CTR.type, xmlOptions);
        }
    }

    CTEmpty addNewAnnotationRef();

    CTBr addNewBr();

    CTMarkup addNewCommentReference();

    CTEmpty addNewContinuationSeparator();

    CTEmpty addNewCr();

    CTEmpty addNewDayLong();

    CTEmpty addNewDayShort();

    CTText addNewDelInstrText();

    CTText addNewDelText();

    CTDrawing addNewDrawing();

    CTEmpty addNewEndnoteRef();

    CTFtnEdnRef addNewEndnoteReference();

    CTFldChar addNewFldChar();

    CTEmpty addNewFootnoteRef();

    CTFtnEdnRef addNewFootnoteReference();

    CTText addNewInstrText();

    CTEmpty addNewLastRenderedPageBreak();

    CTEmpty addNewMonthLong();

    CTEmpty addNewMonthShort();

    CTEmpty addNewNoBreakHyphen();

    CTObject addNewObject();

    CTEmpty addNewPgNum();

    CTPicture addNewPict();

    CTPTab addNewPtab();

    CTRPr addNewRPr();

    CTRuby addNewRuby();

    CTEmpty addNewSeparator();

    CTEmpty addNewSoftHyphen();

    CTSym addNewSym();

    CTText addNewT();

    CTEmpty addNewTab();

    CTEmpty addNewYearLong();

    CTEmpty addNewYearShort();

    CTEmpty getAnnotationRefArray(int i);

    CTEmpty[] getAnnotationRefArray();

    List<CTEmpty> getAnnotationRefList();

    CTBr getBrArray(int i);

    CTBr[] getBrArray();

    List<CTBr> getBrList();

    CTMarkup getCommentReferenceArray(int i);

    CTMarkup[] getCommentReferenceArray();

    List<CTMarkup> getCommentReferenceList();

    CTEmpty getContinuationSeparatorArray(int i);

    CTEmpty[] getContinuationSeparatorArray();

    List<CTEmpty> getContinuationSeparatorList();

    CTEmpty getCrArray(int i);

    CTEmpty[] getCrArray();

    List<CTEmpty> getCrList();

    CTEmpty getDayLongArray(int i);

    CTEmpty[] getDayLongArray();

    List<CTEmpty> getDayLongList();

    CTEmpty getDayShortArray(int i);

    CTEmpty[] getDayShortArray();

    List<CTEmpty> getDayShortList();

    CTText getDelInstrTextArray(int i);

    CTText[] getDelInstrTextArray();

    List<CTText> getDelInstrTextList();

    CTText getDelTextArray(int i);

    CTText[] getDelTextArray();

    List<CTText> getDelTextList();

    CTDrawing getDrawingArray(int i);

    CTDrawing[] getDrawingArray();

    List<CTDrawing> getDrawingList();

    CTEmpty getEndnoteRefArray(int i);

    CTEmpty[] getEndnoteRefArray();

    List<CTEmpty> getEndnoteRefList();

    CTFtnEdnRef getEndnoteReferenceArray(int i);

    CTFtnEdnRef[] getEndnoteReferenceArray();

    List<CTFtnEdnRef> getEndnoteReferenceList();

    CTFldChar getFldCharArray(int i);

    CTFldChar[] getFldCharArray();

    List<CTFldChar> getFldCharList();

    CTEmpty getFootnoteRefArray(int i);

    CTEmpty[] getFootnoteRefArray();

    List<CTEmpty> getFootnoteRefList();

    CTFtnEdnRef getFootnoteReferenceArray(int i);

    CTFtnEdnRef[] getFootnoteReferenceArray();

    List<CTFtnEdnRef> getFootnoteReferenceList();

    CTText getInstrTextArray(int i);

    CTText[] getInstrTextArray();

    List<CTText> getInstrTextList();

    CTEmpty getLastRenderedPageBreakArray(int i);

    CTEmpty[] getLastRenderedPageBreakArray();

    List<CTEmpty> getLastRenderedPageBreakList();

    CTEmpty getMonthLongArray(int i);

    CTEmpty[] getMonthLongArray();

    List<CTEmpty> getMonthLongList();

    CTEmpty getMonthShortArray(int i);

    CTEmpty[] getMonthShortArray();

    List<CTEmpty> getMonthShortList();

    CTEmpty getNoBreakHyphenArray(int i);

    CTEmpty[] getNoBreakHyphenArray();

    List<CTEmpty> getNoBreakHyphenList();

    CTObject getObjectArray(int i);

    CTObject[] getObjectArray();

    List<CTObject> getObjectList();

    CTEmpty getPgNumArray(int i);

    CTEmpty[] getPgNumArray();

    List<CTEmpty> getPgNumList();

    CTPicture getPictArray(int i);

    CTPicture[] getPictArray();

    List<CTPicture> getPictList();

    CTPTab getPtabArray(int i);

    CTPTab[] getPtabArray();

    List<CTPTab> getPtabList();

    CTRPr getRPr();

    byte[] getRsidDel();

    byte[] getRsidR();

    byte[] getRsidRPr();

    CTRuby getRubyArray(int i);

    CTRuby[] getRubyArray();

    List<CTRuby> getRubyList();

    CTEmpty getSeparatorArray(int i);

    CTEmpty[] getSeparatorArray();

    List<CTEmpty> getSeparatorList();

    CTEmpty getSoftHyphenArray(int i);

    CTEmpty[] getSoftHyphenArray();

    List<CTEmpty> getSoftHyphenList();

    CTSym getSymArray(int i);

    CTSym[] getSymArray();

    List<CTSym> getSymList();

    CTText getTArray(int i);

    CTText[] getTArray();

    List<CTText> getTList();

    CTEmpty getTabArray(int i);

    CTEmpty[] getTabArray();

    List<CTEmpty> getTabList();

    CTEmpty getYearLongArray(int i);

    CTEmpty[] getYearLongArray();

    List<CTEmpty> getYearLongList();

    CTEmpty getYearShortArray(int i);

    CTEmpty[] getYearShortArray();

    List<CTEmpty> getYearShortList();

    CTEmpty insertNewAnnotationRef(int i);

    CTBr insertNewBr(int i);

    CTMarkup insertNewCommentReference(int i);

    CTEmpty insertNewContinuationSeparator(int i);

    CTEmpty insertNewCr(int i);

    CTEmpty insertNewDayLong(int i);

    CTEmpty insertNewDayShort(int i);

    CTText insertNewDelInstrText(int i);

    CTText insertNewDelText(int i);

    CTDrawing insertNewDrawing(int i);

    CTEmpty insertNewEndnoteRef(int i);

    CTFtnEdnRef insertNewEndnoteReference(int i);

    CTFldChar insertNewFldChar(int i);

    CTEmpty insertNewFootnoteRef(int i);

    CTFtnEdnRef insertNewFootnoteReference(int i);

    CTText insertNewInstrText(int i);

    CTEmpty insertNewLastRenderedPageBreak(int i);

    CTEmpty insertNewMonthLong(int i);

    CTEmpty insertNewMonthShort(int i);

    CTEmpty insertNewNoBreakHyphen(int i);

    CTObject insertNewObject(int i);

    CTEmpty insertNewPgNum(int i);

    CTPicture insertNewPict(int i);

    CTPTab insertNewPtab(int i);

    CTRuby insertNewRuby(int i);

    CTEmpty insertNewSeparator(int i);

    CTEmpty insertNewSoftHyphen(int i);

    CTSym insertNewSym(int i);

    CTText insertNewT(int i);

    CTEmpty insertNewTab(int i);

    CTEmpty insertNewYearLong(int i);

    CTEmpty insertNewYearShort(int i);

    boolean isSetRPr();

    boolean isSetRsidDel();

    boolean isSetRsidR();

    boolean isSetRsidRPr();

    void removeAnnotationRef(int i);

    void removeBr(int i);

    void removeCommentReference(int i);

    void removeContinuationSeparator(int i);

    void removeCr(int i);

    void removeDayLong(int i);

    void removeDayShort(int i);

    void removeDelInstrText(int i);

    void removeDelText(int i);

    void removeDrawing(int i);

    void removeEndnoteRef(int i);

    void removeEndnoteReference(int i);

    void removeFldChar(int i);

    void removeFootnoteRef(int i);

    void removeFootnoteReference(int i);

    void removeInstrText(int i);

    void removeLastRenderedPageBreak(int i);

    void removeMonthLong(int i);

    void removeMonthShort(int i);

    void removeNoBreakHyphen(int i);

    void removeObject(int i);

    void removePgNum(int i);

    void removePict(int i);

    void removePtab(int i);

    void removeRuby(int i);

    void removeSeparator(int i);

    void removeSoftHyphen(int i);

    void removeSym(int i);

    void removeT(int i);

    void removeTab(int i);

    void removeYearLong(int i);

    void removeYearShort(int i);

    void setAnnotationRefArray(int i, CTEmpty cTEmpty);

    void setAnnotationRefArray(CTEmpty[] cTEmptyArr);

    void setBrArray(int i, CTBr cTBr);

    void setBrArray(CTBr[] cTBrArr);

    void setCommentReferenceArray(int i, CTMarkup cTMarkup);

    void setCommentReferenceArray(CTMarkup[] cTMarkupArr);

    void setContinuationSeparatorArray(int i, CTEmpty cTEmpty);

    void setContinuationSeparatorArray(CTEmpty[] cTEmptyArr);

    void setCrArray(int i, CTEmpty cTEmpty);

    void setCrArray(CTEmpty[] cTEmptyArr);

    void setDayLongArray(int i, CTEmpty cTEmpty);

    void setDayLongArray(CTEmpty[] cTEmptyArr);

    void setDayShortArray(int i, CTEmpty cTEmpty);

    void setDayShortArray(CTEmpty[] cTEmptyArr);

    void setDelInstrTextArray(int i, CTText cTText);

    void setDelInstrTextArray(CTText[] cTTextArr);

    void setDelTextArray(int i, CTText cTText);

    void setDelTextArray(CTText[] cTTextArr);

    void setDrawingArray(int i, CTDrawing cTDrawing);

    void setDrawingArray(CTDrawing[] cTDrawingArr);

    void setEndnoteRefArray(int i, CTEmpty cTEmpty);

    void setEndnoteRefArray(CTEmpty[] cTEmptyArr);

    void setEndnoteReferenceArray(int i, CTFtnEdnRef cTFtnEdnRef);

    void setEndnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr);

    void setFldCharArray(int i, CTFldChar cTFldChar);

    void setFldCharArray(CTFldChar[] cTFldCharArr);

    void setFootnoteRefArray(int i, CTEmpty cTEmpty);

    void setFootnoteRefArray(CTEmpty[] cTEmptyArr);

    void setFootnoteReferenceArray(int i, CTFtnEdnRef cTFtnEdnRef);

    void setFootnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr);

    void setInstrTextArray(int i, CTText cTText);

    void setInstrTextArray(CTText[] cTTextArr);

    void setLastRenderedPageBreakArray(int i, CTEmpty cTEmpty);

    void setLastRenderedPageBreakArray(CTEmpty[] cTEmptyArr);

    void setMonthLongArray(int i, CTEmpty cTEmpty);

    void setMonthLongArray(CTEmpty[] cTEmptyArr);

    void setMonthShortArray(int i, CTEmpty cTEmpty);

    void setMonthShortArray(CTEmpty[] cTEmptyArr);

    void setNoBreakHyphenArray(int i, CTEmpty cTEmpty);

    void setNoBreakHyphenArray(CTEmpty[] cTEmptyArr);

    void setObjectArray(int i, CTObject cTObject);

    void setObjectArray(CTObject[] cTObjectArr);

    void setPgNumArray(int i, CTEmpty cTEmpty);

    void setPgNumArray(CTEmpty[] cTEmptyArr);

    void setPictArray(int i, CTPicture cTPicture);

    void setPictArray(CTPicture[] cTPictureArr);

    void setPtabArray(int i, CTPTab cTPTab);

    void setPtabArray(CTPTab[] cTPTabArr);

    void setRPr(CTRPr cTRPr);

    void setRsidDel(byte[] bArr);

    void setRsidR(byte[] bArr);

    void setRsidRPr(byte[] bArr);

    void setRubyArray(int i, CTRuby cTRuby);

    void setRubyArray(CTRuby[] cTRubyArr);

    void setSeparatorArray(int i, CTEmpty cTEmpty);

    void setSeparatorArray(CTEmpty[] cTEmptyArr);

    void setSoftHyphenArray(int i, CTEmpty cTEmpty);

    void setSoftHyphenArray(CTEmpty[] cTEmptyArr);

    void setSymArray(int i, CTSym cTSym);

    void setSymArray(CTSym[] cTSymArr);

    void setTArray(int i, CTText cTText);

    void setTArray(CTText[] cTTextArr);

    void setTabArray(int i, CTEmpty cTEmpty);

    void setTabArray(CTEmpty[] cTEmptyArr);

    void setYearLongArray(int i, CTEmpty cTEmpty);

    void setYearLongArray(CTEmpty[] cTEmptyArr);

    void setYearShortArray(int i, CTEmpty cTEmpty);

    void setYearShortArray(CTEmpty[] cTEmptyArr);

    int sizeOfAnnotationRefArray();

    int sizeOfBrArray();

    int sizeOfCommentReferenceArray();

    int sizeOfContinuationSeparatorArray();

    int sizeOfCrArray();

    int sizeOfDayLongArray();

    int sizeOfDayShortArray();

    int sizeOfDelInstrTextArray();

    int sizeOfDelTextArray();

    int sizeOfDrawingArray();

    int sizeOfEndnoteRefArray();

    int sizeOfEndnoteReferenceArray();

    int sizeOfFldCharArray();

    int sizeOfFootnoteRefArray();

    int sizeOfFootnoteReferenceArray();

    int sizeOfInstrTextArray();

    int sizeOfLastRenderedPageBreakArray();

    int sizeOfMonthLongArray();

    int sizeOfMonthShortArray();

    int sizeOfNoBreakHyphenArray();

    int sizeOfObjectArray();

    int sizeOfPgNumArray();

    int sizeOfPictArray();

    int sizeOfPtabArray();

    int sizeOfRubyArray();

    int sizeOfSeparatorArray();

    int sizeOfSoftHyphenArray();

    int sizeOfSymArray();

    int sizeOfTArray();

    int sizeOfTabArray();

    int sizeOfYearLongArray();

    int sizeOfYearShortArray();

    void unsetRPr();

    void unsetRsidDel();

    void unsetRsidR();

    void unsetRsidRPr();

    STLongHexNumber xgetRsidDel();

    STLongHexNumber xgetRsidR();

    STLongHexNumber xgetRsidRPr();

    void xsetRsidDel(STLongHexNumber sTLongHexNumber);

    void xsetRsidR(STLongHexNumber sTLongHexNumber);

    void xsetRsidRPr(STLongHexNumber sTLongHexNumber);
}

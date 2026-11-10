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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTRow extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrow3b78type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRow newInstance() {
            return (CTRow) POIXMLTypeLoader.newInstance(CTRow.type, (XmlOptions) null);
        }

        public static CTRow newInstance(XmlOptions xmlOptions) {
            return (CTRow) POIXMLTypeLoader.newInstance(CTRow.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRow.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRow.type, xmlOptions);
        }

        public static CTRow parse(File file) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(file, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(file, CTRow.type, xmlOptions);
        }

        public static CTRow parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(inputStream, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(inputStream, CTRow.type, xmlOptions);
        }

        public static CTRow parse(Reader reader) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(reader, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(reader, CTRow.type, xmlOptions);
        }

        public static CTRow parse(String str) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(str, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(str, CTRow.type, xmlOptions);
        }

        public static CTRow parse(URL url) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(url, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(url, CTRow.type, xmlOptions);
        }

        public static CTRow parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLStreamReader, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLStreamReader, CTRow.type, xmlOptions);
        }

        public static CTRow parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLInputStream, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLInputStream, CTRow.type, xmlOptions);
        }

        public static CTRow parse(Node node) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(node, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(node, CTRow.type, xmlOptions);
        }
    }

    CTMarkupRange addNewBookmarkEnd();

    CTBookmark addNewBookmarkStart();

    CTMarkupRange addNewCommentRangeEnd();

    CTMarkupRange addNewCommentRangeStart();

    CTCustomXmlCell addNewCustomXml();

    CTMarkup addNewCustomXmlDelRangeEnd();

    CTTrackChange addNewCustomXmlDelRangeStart();

    CTMarkup addNewCustomXmlInsRangeEnd();

    CTTrackChange addNewCustomXmlInsRangeStart();

    CTMarkup addNewCustomXmlMoveFromRangeEnd();

    CTTrackChange addNewCustomXmlMoveFromRangeStart();

    CTMarkup addNewCustomXmlMoveToRangeEnd();

    CTTrackChange addNewCustomXmlMoveToRangeStart();

    CTRunTrackChange addNewDel();

    CTRunTrackChange addNewIns();

    CTRunTrackChange addNewMoveFrom();

    CTMarkupRange addNewMoveFromRangeEnd();

    CTMoveBookmark addNewMoveFromRangeStart();

    CTRunTrackChange addNewMoveTo();

    CTMarkupRange addNewMoveToRangeEnd();

    CTMoveBookmark addNewMoveToRangeStart();

    CTOMath addNewOMath();

    CTOMathPara addNewOMathPara();

    CTPerm addNewPermEnd();

    CTPermStart addNewPermStart();

    CTProofErr addNewProofErr();

    CTSdtCell addNewSdt();

    CTTblPrEx addNewTblPrEx();

    CTTc addNewTc();

    CTTrPr addNewTrPr();

    CTMarkupRange getBookmarkEndArray(int i);

    CTMarkupRange[] getBookmarkEndArray();

    List<CTMarkupRange> getBookmarkEndList();

    CTBookmark getBookmarkStartArray(int i);

    CTBookmark[] getBookmarkStartArray();

    List<CTBookmark> getBookmarkStartList();

    CTMarkupRange getCommentRangeEndArray(int i);

    CTMarkupRange[] getCommentRangeEndArray();

    List<CTMarkupRange> getCommentRangeEndList();

    CTMarkupRange getCommentRangeStartArray(int i);

    CTMarkupRange[] getCommentRangeStartArray();

    List<CTMarkupRange> getCommentRangeStartList();

    CTCustomXmlCell getCustomXmlArray(int i);

    CTCustomXmlCell[] getCustomXmlArray();

    CTMarkup getCustomXmlDelRangeEndArray(int i);

    CTMarkup[] getCustomXmlDelRangeEndArray();

    List<CTMarkup> getCustomXmlDelRangeEndList();

    CTTrackChange getCustomXmlDelRangeStartArray(int i);

    CTTrackChange[] getCustomXmlDelRangeStartArray();

    List<CTTrackChange> getCustomXmlDelRangeStartList();

    CTMarkup getCustomXmlInsRangeEndArray(int i);

    CTMarkup[] getCustomXmlInsRangeEndArray();

    List<CTMarkup> getCustomXmlInsRangeEndList();

    CTTrackChange getCustomXmlInsRangeStartArray(int i);

    CTTrackChange[] getCustomXmlInsRangeStartArray();

    List<CTTrackChange> getCustomXmlInsRangeStartList();

    List<CTCustomXmlCell> getCustomXmlList();

    CTMarkup getCustomXmlMoveFromRangeEndArray(int i);

    CTMarkup[] getCustomXmlMoveFromRangeEndArray();

    List<CTMarkup> getCustomXmlMoveFromRangeEndList();

    CTTrackChange getCustomXmlMoveFromRangeStartArray(int i);

    CTTrackChange[] getCustomXmlMoveFromRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveFromRangeStartList();

    CTMarkup getCustomXmlMoveToRangeEndArray(int i);

    CTMarkup[] getCustomXmlMoveToRangeEndArray();

    List<CTMarkup> getCustomXmlMoveToRangeEndList();

    CTTrackChange getCustomXmlMoveToRangeStartArray(int i);

    CTTrackChange[] getCustomXmlMoveToRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveToRangeStartList();

    CTRunTrackChange getDelArray(int i);

    CTRunTrackChange[] getDelArray();

    List<CTRunTrackChange> getDelList();

    CTRunTrackChange getInsArray(int i);

    CTRunTrackChange[] getInsArray();

    List<CTRunTrackChange> getInsList();

    CTRunTrackChange getMoveFromArray(int i);

    CTRunTrackChange[] getMoveFromArray();

    List<CTRunTrackChange> getMoveFromList();

    CTMarkupRange getMoveFromRangeEndArray(int i);

    CTMarkupRange[] getMoveFromRangeEndArray();

    List<CTMarkupRange> getMoveFromRangeEndList();

    CTMoveBookmark getMoveFromRangeStartArray(int i);

    CTMoveBookmark[] getMoveFromRangeStartArray();

    List<CTMoveBookmark> getMoveFromRangeStartList();

    CTRunTrackChange getMoveToArray(int i);

    CTRunTrackChange[] getMoveToArray();

    List<CTRunTrackChange> getMoveToList();

    CTMarkupRange getMoveToRangeEndArray(int i);

    CTMarkupRange[] getMoveToRangeEndArray();

    List<CTMarkupRange> getMoveToRangeEndList();

    CTMoveBookmark getMoveToRangeStartArray(int i);

    CTMoveBookmark[] getMoveToRangeStartArray();

    List<CTMoveBookmark> getMoveToRangeStartList();

    CTOMath getOMathArray(int i);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathPara getOMathParaArray(int i);

    CTOMathPara[] getOMathParaArray();

    List<CTOMathPara> getOMathParaList();

    CTPerm getPermEndArray(int i);

    CTPerm[] getPermEndArray();

    List<CTPerm> getPermEndList();

    CTPermStart getPermStartArray(int i);

    CTPermStart[] getPermStartArray();

    List<CTPermStart> getPermStartList();

    CTProofErr getProofErrArray(int i);

    CTProofErr[] getProofErrArray();

    List<CTProofErr> getProofErrList();

    byte[] getRsidDel();

    byte[] getRsidR();

    byte[] getRsidRPr();

    byte[] getRsidTr();

    CTSdtCell getSdtArray(int i);

    CTSdtCell[] getSdtArray();

    List<CTSdtCell> getSdtList();

    CTTblPrEx getTblPrEx();

    CTTc getTcArray(int i);

    CTTc[] getTcArray();

    List<CTTc> getTcList();

    CTTrPr getTrPr();

    CTMarkupRange insertNewBookmarkEnd(int i);

    CTBookmark insertNewBookmarkStart(int i);

    CTMarkupRange insertNewCommentRangeEnd(int i);

    CTMarkupRange insertNewCommentRangeStart(int i);

    CTCustomXmlCell insertNewCustomXml(int i);

    CTMarkup insertNewCustomXmlDelRangeEnd(int i);

    CTTrackChange insertNewCustomXmlDelRangeStart(int i);

    CTMarkup insertNewCustomXmlInsRangeEnd(int i);

    CTTrackChange insertNewCustomXmlInsRangeStart(int i);

    CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i);

    CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i);

    CTMarkup insertNewCustomXmlMoveToRangeEnd(int i);

    CTTrackChange insertNewCustomXmlMoveToRangeStart(int i);

    CTRunTrackChange insertNewDel(int i);

    CTRunTrackChange insertNewIns(int i);

    CTRunTrackChange insertNewMoveFrom(int i);

    CTMarkupRange insertNewMoveFromRangeEnd(int i);

    CTMoveBookmark insertNewMoveFromRangeStart(int i);

    CTRunTrackChange insertNewMoveTo(int i);

    CTMarkupRange insertNewMoveToRangeEnd(int i);

    CTMoveBookmark insertNewMoveToRangeStart(int i);

    CTOMath insertNewOMath(int i);

    CTOMathPara insertNewOMathPara(int i);

    CTPerm insertNewPermEnd(int i);

    CTPermStart insertNewPermStart(int i);

    CTProofErr insertNewProofErr(int i);

    CTSdtCell insertNewSdt(int i);

    CTTc insertNewTc(int i);

    boolean isSetRsidDel();

    boolean isSetRsidR();

    boolean isSetRsidRPr();

    boolean isSetRsidTr();

    boolean isSetTblPrEx();

    boolean isSetTrPr();

    void removeBookmarkEnd(int i);

    void removeBookmarkStart(int i);

    void removeCommentRangeEnd(int i);

    void removeCommentRangeStart(int i);

    void removeCustomXml(int i);

    void removeCustomXmlDelRangeEnd(int i);

    void removeCustomXmlDelRangeStart(int i);

    void removeCustomXmlInsRangeEnd(int i);

    void removeCustomXmlInsRangeStart(int i);

    void removeCustomXmlMoveFromRangeEnd(int i);

    void removeCustomXmlMoveFromRangeStart(int i);

    void removeCustomXmlMoveToRangeEnd(int i);

    void removeCustomXmlMoveToRangeStart(int i);

    void removeDel(int i);

    void removeIns(int i);

    void removeMoveFrom(int i);

    void removeMoveFromRangeEnd(int i);

    void removeMoveFromRangeStart(int i);

    void removeMoveTo(int i);

    void removeMoveToRangeEnd(int i);

    void removeMoveToRangeStart(int i);

    void removeOMath(int i);

    void removeOMathPara(int i);

    void removePermEnd(int i);

    void removePermStart(int i);

    void removeProofErr(int i);

    void removeSdt(int i);

    void removeTc(int i);

    void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange);

    void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setBookmarkStartArray(int i, CTBookmark cTBookmark);

    void setBookmarkStartArray(CTBookmark[] cTBookmarkArr);

    void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange);

    void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange);

    void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCustomXmlArray(int i, CTCustomXmlCell cTCustomXmlCell);

    void setCustomXmlArray(CTCustomXmlCell[] cTCustomXmlCellArr);

    void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setDelArray(int i, CTRunTrackChange cTRunTrackChange);

    void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setInsArray(int i, CTRunTrackChange cTRunTrackChange);

    void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange);

    void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange);

    void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark);

    void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange);

    void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange);

    void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark);

    void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setOMathArray(int i, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaArray(int i, CTOMathPara cTOMathPara);

    void setOMathParaArray(CTOMathPara[] cTOMathParaArr);

    void setPermEndArray(int i, CTPerm cTPerm);

    void setPermEndArray(CTPerm[] cTPermArr);

    void setPermStartArray(int i, CTPermStart cTPermStart);

    void setPermStartArray(CTPermStart[] cTPermStartArr);

    void setProofErrArray(int i, CTProofErr cTProofErr);

    void setProofErrArray(CTProofErr[] cTProofErrArr);

    void setRsidDel(byte[] bArr);

    void setRsidR(byte[] bArr);

    void setRsidRPr(byte[] bArr);

    void setRsidTr(byte[] bArr);

    void setSdtArray(int i, CTSdtCell cTSdtCell);

    void setSdtArray(CTSdtCell[] cTSdtCellArr);

    void setTblPrEx(CTTblPrEx cTTblPrEx);

    void setTcArray(int i, CTTc cTTc);

    void setTcArray(CTTc[] cTTcArr);

    void setTrPr(CTTrPr cTTrPr);

    int sizeOfBookmarkEndArray();

    int sizeOfBookmarkStartArray();

    int sizeOfCommentRangeEndArray();

    int sizeOfCommentRangeStartArray();

    int sizeOfCustomXmlArray();

    int sizeOfCustomXmlDelRangeEndArray();

    int sizeOfCustomXmlDelRangeStartArray();

    int sizeOfCustomXmlInsRangeEndArray();

    int sizeOfCustomXmlInsRangeStartArray();

    int sizeOfCustomXmlMoveFromRangeEndArray();

    int sizeOfCustomXmlMoveFromRangeStartArray();

    int sizeOfCustomXmlMoveToRangeEndArray();

    int sizeOfCustomXmlMoveToRangeStartArray();

    int sizeOfDelArray();

    int sizeOfInsArray();

    int sizeOfMoveFromArray();

    int sizeOfMoveFromRangeEndArray();

    int sizeOfMoveFromRangeStartArray();

    int sizeOfMoveToArray();

    int sizeOfMoveToRangeEndArray();

    int sizeOfMoveToRangeStartArray();

    int sizeOfOMathArray();

    int sizeOfOMathParaArray();

    int sizeOfPermEndArray();

    int sizeOfPermStartArray();

    int sizeOfProofErrArray();

    int sizeOfSdtArray();

    int sizeOfTcArray();

    void unsetRsidDel();

    void unsetRsidR();

    void unsetRsidRPr();

    void unsetRsidTr();

    void unsetTblPrEx();

    void unsetTrPr();

    STLongHexNumber xgetRsidDel();

    STLongHexNumber xgetRsidR();

    STLongHexNumber xgetRsidRPr();

    STLongHexNumber xgetRsidTr();

    void xsetRsidDel(STLongHexNumber sTLongHexNumber);

    void xsetRsidR(STLongHexNumber sTLongHexNumber);

    void xsetRsidRPr(STLongHexNumber sTLongHexNumber);

    void xsetRsidTr(STLongHexNumber sTLongHexNumber);
}

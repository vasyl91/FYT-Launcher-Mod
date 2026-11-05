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
public interface CTSdtPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSdtPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtpre24dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtPr newInstance() {
            return (CTSdtPr) POIXMLTypeLoader.newInstance(CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr newInstance(XmlOptions xmlOptions) {
            return (CTSdtPr) POIXMLTypeLoader.newInstance(CTSdtPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(File file) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(file, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(file, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(inputStream, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(inputStream, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(Reader reader) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(reader, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(reader, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(String str) throws XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(str, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(str, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(URL url) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(url, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtPr) POIXMLTypeLoader.parse(url, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(xMLInputStream, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(xMLInputStream, CTSdtPr.type, xmlOptions);
        }

        public static CTSdtPr parse(Node node) throws XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(node, CTSdtPr.type, (XmlOptions) null);
        }

        public static CTSdtPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtPr) POIXMLTypeLoader.parse(node, CTSdtPr.type, xmlOptions);
        }
    }

    CTString addNewAlias();

    CTEmpty addNewBibliography();

    CTEmpty addNewCitation();

    CTSdtComboBox addNewComboBox();

    CTDataBinding addNewDataBinding();

    CTSdtDate addNewDate();

    CTSdtDocPart addNewDocPartList();

    CTSdtDocPart addNewDocPartObj();

    CTSdtDropDownList addNewDropDownList();

    CTEmpty addNewEquation();

    CTEmpty addNewGroup();

    CTDecimalNumber addNewId();

    CTLock addNewLock();

    CTEmpty addNewPicture();

    CTPlaceholder addNewPlaceholder();

    CTRPr addNewRPr();

    CTEmpty addNewRichText();

    CTOnOff addNewShowingPlcHdr();

    CTString addNewTag();

    CTOnOff addNewTemporary();

    CTSdtText addNewText();

    CTString getAliasArray(int i);

    CTString[] getAliasArray();

    List<CTString> getAliasList();

    CTEmpty getBibliographyArray(int i);

    CTEmpty[] getBibliographyArray();

    List<CTEmpty> getBibliographyList();

    CTEmpty getCitationArray(int i);

    CTEmpty[] getCitationArray();

    List<CTEmpty> getCitationList();

    CTSdtComboBox getComboBoxArray(int i);

    CTSdtComboBox[] getComboBoxArray();

    List<CTSdtComboBox> getComboBoxList();

    CTDataBinding getDataBindingArray(int i);

    CTDataBinding[] getDataBindingArray();

    List<CTDataBinding> getDataBindingList();

    CTSdtDate getDateArray(int i);

    CTSdtDate[] getDateArray();

    List<CTSdtDate> getDateList();

    CTSdtDocPart getDocPartListArray(int i);

    CTSdtDocPart[] getDocPartListArray();

    List<CTSdtDocPart> getDocPartListList();

    CTSdtDocPart getDocPartObjArray(int i);

    CTSdtDocPart[] getDocPartObjArray();

    List<CTSdtDocPart> getDocPartObjList();

    CTSdtDropDownList getDropDownListArray(int i);

    CTSdtDropDownList[] getDropDownListArray();

    List<CTSdtDropDownList> getDropDownListList();

    CTEmpty getEquationArray(int i);

    CTEmpty[] getEquationArray();

    List<CTEmpty> getEquationList();

    CTEmpty getGroupArray(int i);

    CTEmpty[] getGroupArray();

    List<CTEmpty> getGroupList();

    CTDecimalNumber getIdArray(int i);

    CTDecimalNumber[] getIdArray();

    List<CTDecimalNumber> getIdList();

    CTLock getLockArray(int i);

    CTLock[] getLockArray();

    List<CTLock> getLockList();

    CTEmpty getPictureArray(int i);

    CTEmpty[] getPictureArray();

    List<CTEmpty> getPictureList();

    CTPlaceholder getPlaceholderArray(int i);

    CTPlaceholder[] getPlaceholderArray();

    List<CTPlaceholder> getPlaceholderList();

    CTRPr getRPrArray(int i);

    CTRPr[] getRPrArray();

    List<CTRPr> getRPrList();

    CTEmpty getRichTextArray(int i);

    CTEmpty[] getRichTextArray();

    List<CTEmpty> getRichTextList();

    CTOnOff getShowingPlcHdrArray(int i);

    CTOnOff[] getShowingPlcHdrArray();

    List<CTOnOff> getShowingPlcHdrList();

    CTString getTagArray(int i);

    CTString[] getTagArray();

    List<CTString> getTagList();

    CTOnOff getTemporaryArray(int i);

    CTOnOff[] getTemporaryArray();

    List<CTOnOff> getTemporaryList();

    CTSdtText getTextArray(int i);

    CTSdtText[] getTextArray();

    List<CTSdtText> getTextList();

    CTString insertNewAlias(int i);

    CTEmpty insertNewBibliography(int i);

    CTEmpty insertNewCitation(int i);

    CTSdtComboBox insertNewComboBox(int i);

    CTDataBinding insertNewDataBinding(int i);

    CTSdtDate insertNewDate(int i);

    CTSdtDocPart insertNewDocPartList(int i);

    CTSdtDocPart insertNewDocPartObj(int i);

    CTSdtDropDownList insertNewDropDownList(int i);

    CTEmpty insertNewEquation(int i);

    CTEmpty insertNewGroup(int i);

    CTDecimalNumber insertNewId(int i);

    CTLock insertNewLock(int i);

    CTEmpty insertNewPicture(int i);

    CTPlaceholder insertNewPlaceholder(int i);

    CTRPr insertNewRPr(int i);

    CTEmpty insertNewRichText(int i);

    CTOnOff insertNewShowingPlcHdr(int i);

    CTString insertNewTag(int i);

    CTOnOff insertNewTemporary(int i);

    CTSdtText insertNewText(int i);

    void removeAlias(int i);

    void removeBibliography(int i);

    void removeCitation(int i);

    void removeComboBox(int i);

    void removeDataBinding(int i);

    void removeDate(int i);

    void removeDocPartList(int i);

    void removeDocPartObj(int i);

    void removeDropDownList(int i);

    void removeEquation(int i);

    void removeGroup(int i);

    void removeId(int i);

    void removeLock(int i);

    void removePicture(int i);

    void removePlaceholder(int i);

    void removeRPr(int i);

    void removeRichText(int i);

    void removeShowingPlcHdr(int i);

    void removeTag(int i);

    void removeTemporary(int i);

    void removeText(int i);

    void setAliasArray(int i, CTString cTString);

    void setAliasArray(CTString[] cTStringArr);

    void setBibliographyArray(int i, CTEmpty cTEmpty);

    void setBibliographyArray(CTEmpty[] cTEmptyArr);

    void setCitationArray(int i, CTEmpty cTEmpty);

    void setCitationArray(CTEmpty[] cTEmptyArr);

    void setComboBoxArray(int i, CTSdtComboBox cTSdtComboBox);

    void setComboBoxArray(CTSdtComboBox[] cTSdtComboBoxArr);

    void setDataBindingArray(int i, CTDataBinding cTDataBinding);

    void setDataBindingArray(CTDataBinding[] cTDataBindingArr);

    void setDateArray(int i, CTSdtDate cTSdtDate);

    void setDateArray(CTSdtDate[] cTSdtDateArr);

    void setDocPartListArray(int i, CTSdtDocPart cTSdtDocPart);

    void setDocPartListArray(CTSdtDocPart[] cTSdtDocPartArr);

    void setDocPartObjArray(int i, CTSdtDocPart cTSdtDocPart);

    void setDocPartObjArray(CTSdtDocPart[] cTSdtDocPartArr);

    void setDropDownListArray(int i, CTSdtDropDownList cTSdtDropDownList);

    void setDropDownListArray(CTSdtDropDownList[] cTSdtDropDownListArr);

    void setEquationArray(int i, CTEmpty cTEmpty);

    void setEquationArray(CTEmpty[] cTEmptyArr);

    void setGroupArray(int i, CTEmpty cTEmpty);

    void setGroupArray(CTEmpty[] cTEmptyArr);

    void setIdArray(int i, CTDecimalNumber cTDecimalNumber);

    void setIdArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setLockArray(int i, CTLock cTLock);

    void setLockArray(CTLock[] cTLockArr);

    void setPictureArray(int i, CTEmpty cTEmpty);

    void setPictureArray(CTEmpty[] cTEmptyArr);

    void setPlaceholderArray(int i, CTPlaceholder cTPlaceholder);

    void setPlaceholderArray(CTPlaceholder[] cTPlaceholderArr);

    void setRPrArray(int i, CTRPr cTRPr);

    void setRPrArray(CTRPr[] cTRPrArr);

    void setRichTextArray(int i, CTEmpty cTEmpty);

    void setRichTextArray(CTEmpty[] cTEmptyArr);

    void setShowingPlcHdrArray(int i, CTOnOff cTOnOff);

    void setShowingPlcHdrArray(CTOnOff[] cTOnOffArr);

    void setTagArray(int i, CTString cTString);

    void setTagArray(CTString[] cTStringArr);

    void setTemporaryArray(int i, CTOnOff cTOnOff);

    void setTemporaryArray(CTOnOff[] cTOnOffArr);

    void setTextArray(int i, CTSdtText cTSdtText);

    void setTextArray(CTSdtText[] cTSdtTextArr);

    int sizeOfAliasArray();

    int sizeOfBibliographyArray();

    int sizeOfCitationArray();

    int sizeOfComboBoxArray();

    int sizeOfDataBindingArray();

    int sizeOfDateArray();

    int sizeOfDocPartListArray();

    int sizeOfDocPartObjArray();

    int sizeOfDropDownListArray();

    int sizeOfEquationArray();

    int sizeOfGroupArray();

    int sizeOfIdArray();

    int sizeOfLockArray();

    int sizeOfPictureArray();

    int sizeOfPlaceholderArray();

    int sizeOfRPrArray();

    int sizeOfRichTextArray();

    int sizeOfShowingPlcHdrArray();

    int sizeOfTagArray();

    int sizeOfTemporaryArray();

    int sizeOfTextArray();
}

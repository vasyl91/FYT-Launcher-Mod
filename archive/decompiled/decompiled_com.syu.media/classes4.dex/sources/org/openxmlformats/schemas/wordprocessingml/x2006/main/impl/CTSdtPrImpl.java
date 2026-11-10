package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDataBinding;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDropDownList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSdtPrImpl extends XmlComplexContentImpl implements CTSdtPr {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName ALIAS$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alias");
    private static final QName LOCK$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lock");
    private static final QName PLACEHOLDER$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "placeholder");
    private static final QName SHOWINGPLCHDR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showingPlcHdr");
    private static final QName DATABINDING$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dataBinding");
    private static final QName TEMPORARY$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "temporary");
    private static final QName ID$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "id");
    private static final QName TAG$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tag");
    private static final QName EQUATION$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "equation");
    private static final QName COMBOBOX$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comboBox");
    private static final QName DATE$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "date");
    private static final QName DOCPARTOBJ$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartObj");
    private static final QName DOCPARTLIST$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartList");
    private static final QName DROPDOWNLIST$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dropDownList");
    private static final QName PICTURE$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "picture");
    private static final QName RICHTEXT$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "richText");
    private static final QName TEXT$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "text");
    private static final QName CITATION$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "citation");
    private static final QName GROUP$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "group");
    private static final QName BIBLIOGRAPHY$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bibliography");

    public CTSdtPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString addNewAlias() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(ALIAS$2);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewBibliography() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(BIBLIOGRAPHY$40);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewCitation() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(CITATION$36);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox addNewComboBox() {
        CTSdtComboBox cTSdtComboBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtComboBoxAdd_element_user = get_store().add_element_user(COMBOBOX$20);
        }
        return cTSdtComboBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding addNewDataBinding() {
        CTDataBinding cTDataBindingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBindingAdd_element_user = get_store().add_element_user(DATABINDING$10);
        }
        return cTDataBindingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate addNewDate() {
        CTSdtDate cTSdtDateAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDateAdd_element_user = get_store().add_element_user(DATE$22);
        }
        return cTSdtDateAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart addNewDocPartList() {
        CTSdtDocPart cTSdtDocPartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPartAdd_element_user = get_store().add_element_user(DOCPARTLIST$26);
        }
        return cTSdtDocPartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart addNewDocPartObj() {
        CTSdtDocPart cTSdtDocPartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPartAdd_element_user = get_store().add_element_user(DOCPARTOBJ$24);
        }
        return cTSdtDocPartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList addNewDropDownList() {
        CTSdtDropDownList cTSdtDropDownListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDropDownListAdd_element_user = get_store().add_element_user(DROPDOWNLIST$28);
        }
        return cTSdtDropDownListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewEquation() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(EQUATION$18);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewGroup() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(GROUP$38);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber addNewId() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(ID$14);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock addNewLock() {
        CTLock cTLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockAdd_element_user = get_store().add_element_user(LOCK$4);
        }
        return cTLockAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewPicture() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(PICTURE$30);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder addNewPlaceholder() {
        CTPlaceholder cTPlaceholderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPlaceholderAdd_element_user = get_store().add_element_user(PLACEHOLDER$6);
        }
        return cTPlaceholderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr addNewRPr() {
        CTRPr cTRPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrAdd_element_user = get_store().add_element_user(RPR$0);
        }
        return cTRPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewRichText() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(RICHTEXT$32);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff addNewShowingPlcHdr() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SHOWINGPLCHDR$8);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString addNewTag() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(TAG$16);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff addNewTemporary() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(TEMPORARY$12);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText addNewText() {
        CTSdtText cTSdtTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtTextAdd_element_user = get_store().add_element_user(TEXT$34);
        }
        return cTSdtTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString getAliasArray(int i) {
        CTString cTStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringFind_element_user = get_store().find_element_user(ALIAS$2, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString[] getAliasArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALIAS$2, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTString> getAliasList() {
        1AliasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AliasList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getBibliographyArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(BIBLIOGRAPHY$40, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getBibliographyArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BIBLIOGRAPHY$40, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getBibliographyList() {
        1BibliographyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BibliographyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getCitationArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(CITATION$36, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getCitationArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CITATION$36, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getCitationList() {
        1CitationList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CitationList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox getComboBoxArray(int i) {
        CTSdtComboBox cTSdtComboBoxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtComboBoxFind_element_user = get_store().find_element_user(COMBOBOX$20, i);
            if (cTSdtComboBoxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtComboBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox[] getComboBoxArray() {
        CTSdtComboBox[] cTSdtComboBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMBOBOX$20, arrayList);
            cTSdtComboBoxArr = new CTSdtComboBox[arrayList.size()];
            arrayList.toArray(cTSdtComboBoxArr);
        }
        return cTSdtComboBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtComboBox> getComboBoxList() {
        1ComboBoxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ComboBoxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding getDataBindingArray(int i) {
        CTDataBinding cTDataBindingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBindingFind_element_user = get_store().find_element_user(DATABINDING$10, i);
            if (cTDataBindingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDataBindingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding[] getDataBindingArray() {
        CTDataBinding[] cTDataBindingArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATABINDING$10, arrayList);
            cTDataBindingArr = new CTDataBinding[arrayList.size()];
            arrayList.toArray(cTDataBindingArr);
        }
        return cTDataBindingArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTDataBinding> getDataBindingList() {
        1DataBindingList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DataBindingList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate getDateArray(int i) {
        CTSdtDate cTSdtDateFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDateFind_element_user = get_store().find_element_user(DATE$22, i);
            if (cTSdtDateFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtDateFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate[] getDateArray() {
        CTSdtDate[] cTSdtDateArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATE$22, arrayList);
            cTSdtDateArr = new CTSdtDate[arrayList.size()];
            arrayList.toArray(cTSdtDateArr);
        }
        return cTSdtDateArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDate> getDateList() {
        1DateList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DateList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart getDocPartListArray(int i) {
        CTSdtDocPart cTSdtDocPartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPartFind_element_user = get_store().find_element_user(DOCPARTLIST$26, i);
            if (cTSdtDocPartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtDocPartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart[] getDocPartListArray() {
        CTSdtDocPart[] cTSdtDocPartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DOCPARTLIST$26, arrayList);
            cTSdtDocPartArr = new CTSdtDocPart[arrayList.size()];
            arrayList.toArray(cTSdtDocPartArr);
        }
        return cTSdtDocPartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDocPart> getDocPartListList() {
        1DocPartListList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DocPartListList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart getDocPartObjArray(int i) {
        CTSdtDocPart cTSdtDocPartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPartFind_element_user = get_store().find_element_user(DOCPARTOBJ$24, i);
            if (cTSdtDocPartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtDocPartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart[] getDocPartObjArray() {
        CTSdtDocPart[] cTSdtDocPartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DOCPARTOBJ$24, arrayList);
            cTSdtDocPartArr = new CTSdtDocPart[arrayList.size()];
            arrayList.toArray(cTSdtDocPartArr);
        }
        return cTSdtDocPartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDocPart> getDocPartObjList() {
        1DocPartObjList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DocPartObjList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList getDropDownListArray(int i) {
        CTSdtDropDownList cTSdtDropDownListFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDropDownListFind_element_user = get_store().find_element_user(DROPDOWNLIST$28, i);
            if (cTSdtDropDownListFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtDropDownListFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList[] getDropDownListArray() {
        CTSdtDropDownList[] cTSdtDropDownListArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DROPDOWNLIST$28, arrayList);
            cTSdtDropDownListArr = new CTSdtDropDownList[arrayList.size()];
            arrayList.toArray(cTSdtDropDownListArr);
        }
        return cTSdtDropDownListArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDropDownList> getDropDownListList() {
        1DropDownListList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DropDownListList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getEquationArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(EQUATION$18, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getEquationArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EQUATION$18, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getEquationList() {
        1EquationList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EquationList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getGroupArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(GROUP$38, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getGroupArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUP$38, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getGroupList() {
        1GroupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GroupList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber getIdArray(int i) {
        CTDecimalNumber cTDecimalNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberFind_element_user = get_store().find_element_user(ID$14, i);
            if (cTDecimalNumberFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber[] getIdArray() {
        CTDecimalNumber[] cTDecimalNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ID$14, arrayList);
            cTDecimalNumberArr = new CTDecimalNumber[arrayList.size()];
            arrayList.toArray(cTDecimalNumberArr);
        }
        return cTDecimalNumberArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTDecimalNumber> getIdList() {
        1IdList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IdList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock getLockArray(int i) {
        CTLock cTLockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockFind_element_user = get_store().find_element_user(LOCK$4, i);
            if (cTLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLockFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock[] getLockArray() {
        CTLock[] cTLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCK$4, arrayList);
            cTLockArr = new CTLock[arrayList.size()];
            arrayList.toArray(cTLockArr);
        }
        return cTLockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getPictureArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(PICTURE$30, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getPictureArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PICTURE$30, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getPictureList() {
        1PictureList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PictureList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder getPlaceholderArray(int i) {
        CTPlaceholder cTPlaceholderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPlaceholderFind_element_user = get_store().find_element_user(PLACEHOLDER$6, i);
            if (cTPlaceholderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPlaceholderFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder[] getPlaceholderArray() {
        CTPlaceholder[] cTPlaceholderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PLACEHOLDER$6, arrayList);
            cTPlaceholderArr = new CTPlaceholder[arrayList.size()];
            arrayList.toArray(cTPlaceholderArr);
        }
        return cTPlaceholderArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTPlaceholder> getPlaceholderList() {
        1PlaceholderList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PlaceholderList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr getRPrArray(int i) {
        CTRPr cTRPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrFind_element_user = get_store().find_element_user(RPR$0, i);
            if (cTRPrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr[] getRPrArray() {
        CTRPr[] cTRPrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RPR$0, arrayList);
            cTRPrArr = new CTRPr[arrayList.size()];
            arrayList.toArray(cTRPrArr);
        }
        return cTRPrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTRPr> getRPrList() {
        1RPrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RPrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getRichTextArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(RICHTEXT$32, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getRichTextArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RICHTEXT$32, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getRichTextList() {
        1RichTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RichTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff getShowingPlcHdrArray(int i) {
        CTOnOff cTOnOffFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffFind_element_user = get_store().find_element_user(SHOWINGPLCHDR$8, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOffFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff[] getShowingPlcHdrArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHOWINGPLCHDR$8, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTOnOff> getShowingPlcHdrList() {
        1ShowingPlcHdrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShowingPlcHdrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString getTagArray(int i) {
        CTString cTStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringFind_element_user = get_store().find_element_user(TAG$16, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString[] getTagArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TAG$16, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTString> getTagList() {
        1TagList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TagList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff getTemporaryArray(int i) {
        CTOnOff cTOnOffFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffFind_element_user = get_store().find_element_user(TEMPORARY$12, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOffFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff[] getTemporaryArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEMPORARY$12, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTOnOff> getTemporaryList() {
        1TemporaryList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TemporaryList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText getTextArray(int i) {
        CTSdtText cTSdtTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtTextFind_element_user = get_store().find_element_user(TEXT$34, i);
            if (cTSdtTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText[] getTextArray() {
        CTSdtText[] cTSdtTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXT$34, arrayList);
            cTSdtTextArr = new CTSdtText[arrayList.size()];
            arrayList.toArray(cTSdtTextArr);
        }
        return cTSdtTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtText> getTextList() {
        1TextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString insertNewAlias(int i) {
        CTString cTStringInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringInsert_element_user = get_store().insert_element_user(ALIAS$2, i);
        }
        return cTStringInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewBibliography(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(BIBLIOGRAPHY$40, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewCitation(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(CITATION$36, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox insertNewComboBox(int i) {
        CTSdtComboBox cTSdtComboBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtComboBoxInsert_element_user = get_store().insert_element_user(COMBOBOX$20, i);
        }
        return cTSdtComboBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding insertNewDataBinding(int i) {
        CTDataBinding cTDataBindingInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBindingInsert_element_user = get_store().insert_element_user(DATABINDING$10, i);
        }
        return cTDataBindingInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate insertNewDate(int i) {
        CTSdtDate cTSdtDateInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDateInsert_element_user = get_store().insert_element_user(DATE$22, i);
        }
        return cTSdtDateInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart insertNewDocPartList(int i) {
        CTSdtDocPart cTSdtDocPartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPartInsert_element_user = get_store().insert_element_user(DOCPARTLIST$26, i);
        }
        return cTSdtDocPartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart insertNewDocPartObj(int i) {
        CTSdtDocPart cTSdtDocPartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPartInsert_element_user = get_store().insert_element_user(DOCPARTOBJ$24, i);
        }
        return cTSdtDocPartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList insertNewDropDownList(int i) {
        CTSdtDropDownList cTSdtDropDownListInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDropDownListInsert_element_user = get_store().insert_element_user(DROPDOWNLIST$28, i);
        }
        return cTSdtDropDownListInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewEquation(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(EQUATION$18, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewGroup(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(GROUP$38, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber insertNewId(int i) {
        CTDecimalNumber cTDecimalNumberInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberInsert_element_user = get_store().insert_element_user(ID$14, i);
        }
        return cTDecimalNumberInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock insertNewLock(int i) {
        CTLock cTLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockInsert_element_user = get_store().insert_element_user(LOCK$4, i);
        }
        return cTLockInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewPicture(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(PICTURE$30, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder insertNewPlaceholder(int i) {
        CTPlaceholder cTPlaceholderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPlaceholderInsert_element_user = get_store().insert_element_user(PLACEHOLDER$6, i);
        }
        return cTPlaceholderInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr insertNewRPr(int i) {
        CTRPr cTRPrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrInsert_element_user = get_store().insert_element_user(RPR$0, i);
        }
        return cTRPrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewRichText(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(RICHTEXT$32, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff insertNewShowingPlcHdr(int i) {
        CTOnOff cTOnOffInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffInsert_element_user = get_store().insert_element_user(SHOWINGPLCHDR$8, i);
        }
        return cTOnOffInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString insertNewTag(int i) {
        CTString cTStringInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringInsert_element_user = get_store().insert_element_user(TAG$16, i);
        }
        return cTStringInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff insertNewTemporary(int i) {
        CTOnOff cTOnOffInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffInsert_element_user = get_store().insert_element_user(TEMPORARY$12, i);
        }
        return cTOnOffInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText insertNewText(int i) {
        CTSdtText cTSdtTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtTextInsert_element_user = get_store().insert_element_user(TEXT$34, i);
        }
        return cTSdtTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeAlias(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALIAS$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeBibliography(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIBLIOGRAPHY$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeCitation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CITATION$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeComboBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMBOBOX$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDataBinding(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATABINDING$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDate(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATE$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDocPartList(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTLIST$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDocPartObj(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTOBJ$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDropDownList(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DROPDOWNLIST$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeEquation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EQUATION$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ID$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removePicture(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PICTURE$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removePlaceholder(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PLACEHOLDER$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeRPr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeRichText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RICHTEXT$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeShowingPlcHdr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHOWINGPLCHDR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeTag(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAG$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeTemporary(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEMPORARY$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXT$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setAliasArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(ALIAS$2, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setAliasArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStringArr, ALIAS$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setBibliographyArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(BIBLIOGRAPHY$40, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setBibliographyArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, BIBLIOGRAPHY$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setCitationArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(CITATION$36, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setCitationArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, CITATION$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setComboBoxArray(int i, CTSdtComboBox cTSdtComboBox) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtComboBox cTSdtComboBoxFind_element_user = get_store().find_element_user(COMBOBOX$20, i);
            if (cTSdtComboBoxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtComboBoxFind_element_user.set(cTSdtComboBox);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setComboBoxArray(CTSdtComboBox[] cTSdtComboBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtComboBoxArr, COMBOBOX$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDataBindingArray(int i, CTDataBinding cTDataBinding) {
        synchronized (monitor()) {
            check_orphaned();
            CTDataBinding cTDataBindingFind_element_user = get_store().find_element_user(DATABINDING$10, i);
            if (cTDataBindingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDataBindingFind_element_user.set(cTDataBinding);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDataBindingArray(CTDataBinding[] cTDataBindingArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDataBindingArr, DATABINDING$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDateArray(int i, CTSdtDate cTSdtDate) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDate cTSdtDateFind_element_user = get_store().find_element_user(DATE$22, i);
            if (cTSdtDateFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtDateFind_element_user.set(cTSdtDate);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDateArray(CTSdtDate[] cTSdtDateArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtDateArr, DATE$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartListArray(int i, CTSdtDocPart cTSdtDocPart) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDocPart cTSdtDocPartFind_element_user = get_store().find_element_user(DOCPARTLIST$26, i);
            if (cTSdtDocPartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtDocPartFind_element_user.set(cTSdtDocPart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartListArray(CTSdtDocPart[] cTSdtDocPartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtDocPartArr, DOCPARTLIST$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartObjArray(int i, CTSdtDocPart cTSdtDocPart) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDocPart cTSdtDocPartFind_element_user = get_store().find_element_user(DOCPARTOBJ$24, i);
            if (cTSdtDocPartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtDocPartFind_element_user.set(cTSdtDocPart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartObjArray(CTSdtDocPart[] cTSdtDocPartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtDocPartArr, DOCPARTOBJ$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDropDownListArray(int i, CTSdtDropDownList cTSdtDropDownList) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDropDownList cTSdtDropDownListFind_element_user = get_store().find_element_user(DROPDOWNLIST$28, i);
            if (cTSdtDropDownListFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtDropDownListFind_element_user.set(cTSdtDropDownList);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDropDownListArray(CTSdtDropDownList[] cTSdtDropDownListArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtDropDownListArr, DROPDOWNLIST$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setEquationArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(EQUATION$18, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setEquationArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, EQUATION$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setGroupArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(GROUP$38, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setGroupArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, GROUP$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setIdArray(int i, CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(ID$14, i);
            if (cTDecimalNumberFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setIdArray(CTDecimalNumber[] cTDecimalNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDecimalNumberArr, ID$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setLockArray(int i, CTLock cTLock) {
        synchronized (monitor()) {
            check_orphaned();
            CTLock cTLockFind_element_user = get_store().find_element_user(LOCK$4, i);
            if (cTLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLockFind_element_user.set(cTLock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLockArr, LOCK$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPictureArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(PICTURE$30, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPictureArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, PICTURE$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPlaceholderArray(int i, CTPlaceholder cTPlaceholder) {
        synchronized (monitor()) {
            check_orphaned();
            CTPlaceholder cTPlaceholderFind_element_user = get_store().find_element_user(PLACEHOLDER$6, i);
            if (cTPlaceholderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPlaceholderFind_element_user.set(cTPlaceholder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPlaceholderArray(CTPlaceholder[] cTPlaceholderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPlaceholderArr, PLACEHOLDER$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRPrArray(int i, CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPrFind_element_user = get_store().find_element_user(RPR$0, i);
            if (cTRPrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRPrFind_element_user.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRPrArray(CTRPr[] cTRPrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRPrArr, RPR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRichTextArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(RICHTEXT$32, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRichTextArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, RICHTEXT$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setShowingPlcHdrArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SHOWINGPLCHDR$8, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setShowingPlcHdrArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, SHOWINGPLCHDR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTagArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(TAG$16, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTagArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStringArr, TAG$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTemporaryArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(TEMPORARY$12, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTemporaryArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, TEMPORARY$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTextArray(int i, CTSdtText cTSdtText) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtText cTSdtTextFind_element_user = get_store().find_element_user(TEXT$34, i);
            if (cTSdtTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtTextFind_element_user.set(cTSdtText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTextArray(CTSdtText[] cTSdtTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtTextArr, TEXT$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfAliasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ALIAS$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfBibliographyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BIBLIOGRAPHY$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfCitationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CITATION$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfComboBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMBOBOX$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDataBindingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DATABINDING$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDateArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DATE$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDocPartListArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DOCPARTLIST$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDocPartObjArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DOCPARTOBJ$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDropDownListArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DROPDOWNLIST$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfEquationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EQUATION$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GROUP$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ID$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LOCK$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfPictureArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PICTURE$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfPlaceholderArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PLACEHOLDER$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfRPrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RPR$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfRichTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RICHTEXT$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfShowingPlcHdrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHOWINGPLCHDR$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfTagArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TAG$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfTemporaryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEMPORARY$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXT$34);
        }
        return iCount_elements;
    }
}

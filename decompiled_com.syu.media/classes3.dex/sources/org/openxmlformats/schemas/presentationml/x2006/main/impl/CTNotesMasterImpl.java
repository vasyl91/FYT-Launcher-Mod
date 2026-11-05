package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNotesMasterImpl extends XmlComplexContentImpl implements CTNotesMaster {
    private static final QName CSLD$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
    private static final QName CLRMAP$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMap");
    private static final QName HF$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "hf");
    private static final QName NOTESSTYLE$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesStyle");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");

    public CTNotesMasterImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(CSLD$0);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTColorMapping addNewClrMap() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().add_element_user(CLRMAP$2);
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(EXTLST$8);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTHeaderFooter addNewHf() {
        CTHeaderFooter cTHeaderFooterAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooterAdd_element_user = get_store().add_element_user(HF$4);
        }
        return cTHeaderFooterAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTTextListStyle addNewNotesStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(NOTESSTYLE$6);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTCommonSlideData getCSld() {
        synchronized (monitor()) {
            check_orphaned();
            CTCommonSlideData cTCommonSlideData = (CTCommonSlideData) get_store().find_element_user(CSLD$0, 0);
            if (cTCommonSlideData == null) {
                return null;
            }
            return cTCommonSlideData;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTColorMapping getClrMap() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorMapping cTColorMapping = (CTColorMapping) get_store().find_element_user(CLRMAP$2, 0);
            if (cTColorMapping == null) {
                return null;
            }
            return cTColorMapping;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify cTExtensionListModifyFind_element_user = get_store().find_element_user(EXTLST$8, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                return null;
            }
            return cTExtensionListModifyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTHeaderFooter getHf() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooterFind_element_user = get_store().find_element_user(HF$4, 0);
            if (cTHeaderFooterFind_element_user == null) {
                return null;
            }
            return cTHeaderFooterFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTTextListStyle getNotesStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextListStyle cTTextListStyle = (CTTextListStyle) get_store().find_element_user(NOTESSTYLE$6, 0);
            if (cTTextListStyle == null) {
                return null;
            }
            return cTTextListStyle;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public boolean isSetHf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HF$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public boolean isSetNotesStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOTESSTYLE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setCSld(CTCommonSlideData cTCommonSlideData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSLD$0;
            CTCommonSlideData cTCommonSlideData2 = (CTCommonSlideData) typeStore.find_element_user(qName, 0);
            if (cTCommonSlideData2 == null) {
                cTCommonSlideData2 = (CTCommonSlideData) get_store().add_element_user(qName);
            }
            cTCommonSlideData2.set(cTCommonSlideData);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setClrMap(CTColorMapping cTColorMapping) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLRMAP$2;
            CTColorMapping cTColorMapping2 = (CTColorMapping) typeStore.find_element_user(qName, 0);
            if (cTColorMapping2 == null) {
                cTColorMapping2 = (CTColorMapping) get_store().add_element_user(qName);
            }
            cTColorMapping2.set(cTColorMapping);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$8;
            CTExtensionListModify cTExtensionListModifyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            cTExtensionListModifyFind_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setHf(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HF$4;
            CTHeaderFooter cTHeaderFooterFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHeaderFooterFind_element_user == null) {
                cTHeaderFooterFind_element_user = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooterFind_element_user.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setNotesStyle(CTTextListStyle cTTextListStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTESSTYLE$6;
            CTTextListStyle cTTextListStyle2 = (CTTextListStyle) typeStore.find_element_user(qName, 0);
            if (cTTextListStyle2 == null) {
                cTTextListStyle2 = (CTTextListStyle) get_store().add_element_user(qName);
            }
            cTTextListStyle2.set(cTTextListStyle);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void unsetHf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HF$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void unsetNotesStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOTESSTYLE$6, 0);
        }
    }
}

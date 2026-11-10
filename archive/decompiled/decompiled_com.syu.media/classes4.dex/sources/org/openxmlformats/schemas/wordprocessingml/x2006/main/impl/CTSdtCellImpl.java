package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSdtCellImpl extends XmlComplexContentImpl implements CTSdtCell {
    private static final QName SDTPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtPr");
    private static final QName SDTENDPR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtEndPr");
    private static final QName SDTCONTENT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtContent");

    public CTSdtCellImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtContentCell addNewSdtContent() {
        CTSdtContentCell cTSdtContentCellAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtContentCellAdd_element_user = get_store().add_element_user(SDTCONTENT$4);
        }
        return cTSdtContentCellAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtEndPr addNewSdtEndPr() {
        CTSdtEndPr cTSdtEndPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtEndPrAdd_element_user = get_store().add_element_user(SDTENDPR$2);
        }
        return cTSdtEndPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtPr addNewSdtPr() {
        CTSdtPr cTSdtPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtPrAdd_element_user = get_store().add_element_user(SDTPR$0);
        }
        return cTSdtPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtContentCell getSdtContent() {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtContentCell cTSdtContentCellFind_element_user = get_store().find_element_user(SDTCONTENT$4, 0);
            if (cTSdtContentCellFind_element_user == null) {
                return null;
            }
            return cTSdtContentCellFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtEndPr getSdtEndPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtEndPr cTSdtEndPrFind_element_user = get_store().find_element_user(SDTENDPR$2, 0);
            if (cTSdtEndPrFind_element_user == null) {
                return null;
            }
            return cTSdtEndPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtPr getSdtPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtPr cTSdtPrFind_element_user = get_store().find_element_user(SDTPR$0, 0);
            if (cTSdtPrFind_element_user == null) {
                return null;
            }
            return cTSdtPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public boolean isSetSdtContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SDTCONTENT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public boolean isSetSdtEndPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SDTENDPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public boolean isSetSdtPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SDTPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void setSdtContent(CTSdtContentCell cTSdtContentCell) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SDTCONTENT$4;
            CTSdtContentCell cTSdtContentCellFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSdtContentCellFind_element_user == null) {
                cTSdtContentCellFind_element_user = (CTSdtContentCell) get_store().add_element_user(qName);
            }
            cTSdtContentCellFind_element_user.set(cTSdtContentCell);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void setSdtEndPr(CTSdtEndPr cTSdtEndPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SDTENDPR$2;
            CTSdtEndPr cTSdtEndPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSdtEndPrFind_element_user == null) {
                cTSdtEndPrFind_element_user = (CTSdtEndPr) get_store().add_element_user(qName);
            }
            cTSdtEndPrFind_element_user.set(cTSdtEndPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void setSdtPr(CTSdtPr cTSdtPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SDTPR$0;
            CTSdtPr cTSdtPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSdtPrFind_element_user == null) {
                cTSdtPrFind_element_user = (CTSdtPr) get_store().add_element_user(qName);
            }
            cTSdtPrFind_element_user.set(cTSdtPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void unsetSdtContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDTCONTENT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void unsetSdtEndPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDTENDPR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void unsetSdtPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDTPR$0, 0);
        }
    }
}

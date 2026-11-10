package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTrPrImpl extends CTTrPrBaseImpl implements CTTrPr {
    private static final QName INS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName TRPRCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trPrChange");

    public CTTrPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange addNewDel() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(DEL$2);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange addNewIns() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(INS$0);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrPrChange addNewTrPrChange() {
        CTTrPrChange cTTrPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrPrChangeAdd_element_user = get_store().add_element_user(TRPRCHANGE$4);
        }
        return cTTrPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange getDel() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(DEL$2, 0);
            if (cTTrackChangeFind_element_user == null) {
                return null;
            }
            return cTTrackChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange getIns() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(INS$0, 0);
            if (cTTrackChangeFind_element_user == null) {
                return null;
            }
            return cTTrackChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrPrChange getTrPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrPrChange cTTrPrChangeFind_element_user = get_store().find_element_user(TRPRCHANGE$4, 0);
            if (cTTrPrChangeFind_element_user == null) {
                return null;
            }
            return cTTrPrChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public boolean isSetDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public boolean isSetIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public boolean isSetTrPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRPRCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void setDel(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEL$2;
            CTTrackChange cTTrackChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeFind_element_user == null) {
                cTTrackChangeFind_element_user = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void setIns(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INS$0;
            CTTrackChange cTTrackChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeFind_element_user == null) {
                cTTrackChangeFind_element_user = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void setTrPrChange(CTTrPrChange cTTrPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRPRCHANGE$4;
            CTTrPrChange cTTrPrChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrPrChangeFind_element_user == null) {
                cTTrPrChangeFind_element_user = (CTTrPrChange) get_store().add_element_user(qName);
            }
            cTTrPrChangeFind_element_user.set(cTTrPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void unsetDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void unsetIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void unsetTrPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRPRCHANGE$4, 0);
        }
    }
}

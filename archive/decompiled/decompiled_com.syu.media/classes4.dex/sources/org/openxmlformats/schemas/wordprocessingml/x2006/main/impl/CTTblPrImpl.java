package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblPrImpl extends CTTblPrBaseImpl implements CTTblPr {
    private static final QName TBLPRCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrChange");

    public CTTblPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public CTTblPrChange addNewTblPrChange() {
        CTTblPrChange cTTblPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrChangeAdd_element_user = get_store().add_element_user(TBLPRCHANGE$0);
        }
        return cTTblPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public CTTblPrChange getTblPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPrChange cTTblPrChangeFind_element_user = get_store().find_element_user(TBLPRCHANGE$0, 0);
            if (cTTblPrChangeFind_element_user == null) {
                return null;
            }
            return cTTblPrChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public boolean isSetTblPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPRCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public void setTblPrChange(CTTblPrChange cTTblPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPRCHANGE$0;
            CTTblPrChange cTTblPrChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblPrChangeFind_element_user == null) {
                cTTblPrChangeFind_element_user = (CTTblPrChange) get_store().add_element_user(qName);
            }
            cTTblPrChangeFind_element_user.set(cTTblPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public void unsetTblPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPRCHANGE$0, 0);
        }
    }
}

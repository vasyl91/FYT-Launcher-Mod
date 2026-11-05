package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblPrExImpl extends CTTblPrExBaseImpl implements CTTblPrEx {
    private static final QName TBLPREXCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrExChange");

    public CTTblPrExImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange addNewTblPrExChange() {
        CTTblPrExChange cTTblPrExChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrExChangeAdd_element_user = get_store().add_element_user(TBLPREXCHANGE$0);
        }
        return cTTblPrExChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange getTblPrExChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPrExChange cTTblPrExChangeFind_element_user = get_store().find_element_user(TBLPREXCHANGE$0, 0);
            if (cTTblPrExChangeFind_element_user == null) {
                return null;
            }
            return cTTblPrExChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public boolean isSetTblPrExChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPREXCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void setTblPrExChange(CTTblPrExChange cTTblPrExChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPREXCHANGE$0;
            CTTblPrExChange cTTblPrExChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblPrExChangeFind_element_user == null) {
                cTTblPrExChangeFind_element_user = (CTTblPrExChange) get_store().add_element_user(qName);
            }
            cTTblPrExChangeFind_element_user.set(cTTblPrExChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void unsetTblPrExChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPREXCHANGE$0, 0);
        }
    }
}

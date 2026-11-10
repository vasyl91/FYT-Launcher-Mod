package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblGridImpl extends CTTblGridBaseImpl implements CTTblGrid {
    private static final QName TBLGRIDCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblGridChange");

    public CTTblGridImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public CTTblGridChange addNewTblGridChange() {
        CTTblGridChange cTTblGridChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridChangeAdd_element_user = get_store().add_element_user(TBLGRIDCHANGE$0);
        }
        return cTTblGridChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public CTTblGridChange getTblGridChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblGridChange cTTblGridChangeFind_element_user = get_store().find_element_user(TBLGRIDCHANGE$0, 0);
            if (cTTblGridChangeFind_element_user == null) {
                return null;
            }
            return cTTblGridChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public boolean isSetTblGridChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLGRIDCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public void setTblGridChange(CTTblGridChange cTTblGridChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLGRIDCHANGE$0;
            CTTblGridChange cTTblGridChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblGridChangeFind_element_user == null) {
                cTTblGridChangeFind_element_user = (CTTblGridChange) get_store().add_element_user(qName);
            }
            cTTblGridChangeFind_element_user.set(cTTblGridChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public void unsetTblGridChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLGRIDCHANGE$0, 0);
        }
    }
}

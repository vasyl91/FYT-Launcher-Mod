package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTcPrImpl extends CTTcPrInnerImpl implements CTTcPr {
    private static final QName TCPRCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPrChange");

    public CTTcPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public CTTcPrChange addNewTcPrChange() {
        CTTcPrChange cTTcPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPrChangeAdd_element_user = get_store().add_element_user(TCPRCHANGE$0);
        }
        return cTTcPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public CTTcPrChange getTcPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcPrChange cTTcPrChangeFind_element_user = get_store().find_element_user(TCPRCHANGE$0, 0);
            if (cTTcPrChangeFind_element_user == null) {
                return null;
            }
            return cTTcPrChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public boolean isSetTcPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCPRCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public void setTcPrChange(CTTcPrChange cTTcPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCPRCHANGE$0;
            CTTcPrChange cTTcPrChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTcPrChangeFind_element_user == null) {
                cTTcPrChangeFind_element_user = (CTTcPrChange) get_store().add_element_user(qName);
            }
            cTTcPrChangeFind_element_user.set(cTTcPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public void unsetTcPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCPRCHANGE$0, 0);
        }
    }
}

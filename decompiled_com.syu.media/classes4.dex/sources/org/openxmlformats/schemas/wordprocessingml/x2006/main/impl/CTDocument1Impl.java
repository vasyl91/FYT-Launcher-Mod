package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTDocument1Impl extends CTDocumentBaseImpl implements CTDocument1 {
    private static final QName BODY$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "body");

    public CTDocument1Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public CTBody addNewBody() {
        CTBody cTBodyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBodyAdd_element_user = get_store().add_element_user(BODY$0);
        }
        return cTBodyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public CTBody getBody() {
        synchronized (monitor()) {
            check_orphaned();
            CTBody cTBodyFind_element_user = get_store().find_element_user(BODY$0, 0);
            if (cTBodyFind_element_user == null) {
                return null;
            }
            return cTBodyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public boolean isSetBody() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BODY$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public void setBody(CTBody cTBody) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BODY$0;
            CTBody cTBodyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBodyFind_element_user == null) {
                cTBodyFind_element_user = (CTBody) get_store().add_element_user(qName);
            }
            cTBodyFind_element_user.set(cTBody);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public void unsetBody() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BODY$0, 0);
        }
    }
}

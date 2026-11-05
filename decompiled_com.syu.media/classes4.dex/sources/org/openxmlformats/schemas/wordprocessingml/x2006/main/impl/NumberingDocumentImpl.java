package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class NumberingDocumentImpl extends XmlComplexContentImpl implements NumberingDocument {
    private static final QName NUMBERING$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numbering");

    public NumberingDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument
    public CTNumbering addNewNumbering() {
        CTNumbering cTNumberingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberingAdd_element_user = get_store().add_element_user(NUMBERING$0);
        }
        return cTNumberingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument
    public CTNumbering getNumbering() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumbering cTNumberingFind_element_user = get_store().find_element_user(NUMBERING$0, 0);
            if (cTNumberingFind_element_user == null) {
                return null;
            }
            return cTNumberingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument
    public void setNumbering(CTNumbering cTNumbering) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBERING$0;
            CTNumbering cTNumberingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTNumberingFind_element_user == null) {
                cTNumberingFind_element_user = (CTNumbering) get_store().add_element_user(qName);
            }
            cTNumberingFind_element_user.set(cTNumbering);
        }
    }
}

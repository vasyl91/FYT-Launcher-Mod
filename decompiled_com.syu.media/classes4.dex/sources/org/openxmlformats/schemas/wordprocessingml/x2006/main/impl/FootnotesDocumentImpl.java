package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class FootnotesDocumentImpl extends XmlComplexContentImpl implements FootnotesDocument {
    private static final QName FOOTNOTES$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnotes");

    public FootnotesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument
    public CTFootnotes addNewFootnotes() {
        CTFootnotes cTFootnotesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFootnotesAdd_element_user = get_store().add_element_user(FOOTNOTES$0);
        }
        return cTFootnotesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument
    public CTFootnotes getFootnotes() {
        synchronized (monitor()) {
            check_orphaned();
            CTFootnotes cTFootnotesFind_element_user = get_store().find_element_user(FOOTNOTES$0, 0);
            if (cTFootnotesFind_element_user == null) {
                return null;
            }
            return cTFootnotesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument
    public void setFootnotes(CTFootnotes cTFootnotes) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOOTNOTES$0;
            CTFootnotes cTFootnotesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFootnotesFind_element_user == null) {
                cTFootnotesFind_element_user = (CTFootnotes) get_store().add_element_user(qName);
            }
            cTFootnotesFind_element_user.set(cTFootnotes);
        }
    }
}

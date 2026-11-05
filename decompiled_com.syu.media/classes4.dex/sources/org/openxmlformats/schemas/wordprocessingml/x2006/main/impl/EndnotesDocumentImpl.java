package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class EndnotesDocumentImpl extends XmlComplexContentImpl implements EndnotesDocument {
    private static final QName ENDNOTES$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotes");

    public EndnotesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument
    public CTEndnotes addNewEndnotes() {
        CTEndnotes cTEndnotesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEndnotesAdd_element_user = get_store().add_element_user(ENDNOTES$0);
        }
        return cTEndnotesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument
    public CTEndnotes getEndnotes() {
        synchronized (monitor()) {
            check_orphaned();
            CTEndnotes cTEndnotesFind_element_user = get_store().find_element_user(ENDNOTES$0, 0);
            if (cTEndnotesFind_element_user == null) {
                return null;
            }
            return cTEndnotesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument
    public void setEndnotes(CTEndnotes cTEndnotes) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDNOTES$0;
            CTEndnotes cTEndnotesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEndnotesFind_element_user == null) {
                cTEndnotesFind_element_user = (CTEndnotes) get_store().add_element_user(qName);
            }
            cTEndnotesFind_element_user.set(cTEndnotes);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBackground;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTDocumentBaseImpl extends XmlComplexContentImpl implements CTDocumentBase {
    private static final QName BACKGROUND$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "background");

    public CTDocumentBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public CTBackground addNewBackground() {
        CTBackground cTBackgroundAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBackgroundAdd_element_user = get_store().add_element_user(BACKGROUND$0);
        }
        return cTBackgroundAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public CTBackground getBackground() {
        synchronized (monitor()) {
            check_orphaned();
            CTBackground cTBackgroundFind_element_user = get_store().find_element_user(BACKGROUND$0, 0);
            if (cTBackgroundFind_element_user == null) {
                return null;
            }
            return cTBackgroundFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public boolean isSetBackground() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BACKGROUND$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public void setBackground(CTBackground cTBackground) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUND$0;
            CTBackground cTBackgroundFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBackgroundFind_element_user == null) {
                cTBackgroundFind_element_user = (CTBackground) get_store().add_element_user(qName);
            }
            cTBackgroundFind_element_user.set(cTBackground);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public void unsetBackground() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BACKGROUND$0, 0);
        }
    }
}

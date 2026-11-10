package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdListEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNotesMasterIdListImpl extends XmlComplexContentImpl implements CTNotesMasterIdList {
    private static final QName NOTESMASTERID$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMasterId");

    public CTNotesMasterIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public CTNotesMasterIdListEntry addNewNotesMasterId() {
        CTNotesMasterIdListEntry cTNotesMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry) get_store().add_element_user(NOTESMASTERID$0);
        }
        return cTNotesMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public CTNotesMasterIdListEntry getNotesMasterId() {
        synchronized (monitor()) {
            check_orphaned();
            CTNotesMasterIdListEntry cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry) get_store().find_element_user(NOTESMASTERID$0, 0);
            if (cTNotesMasterIdListEntry == null) {
                return null;
            }
            return cTNotesMasterIdListEntry;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public boolean isSetNotesMasterId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOTESMASTERID$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public void setNotesMasterId(CTNotesMasterIdListEntry cTNotesMasterIdListEntry) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTESMASTERID$0;
            CTNotesMasterIdListEntry cTNotesMasterIdListEntry2 = (CTNotesMasterIdListEntry) typeStore.find_element_user(qName, 0);
            if (cTNotesMasterIdListEntry2 == null) {
                cTNotesMasterIdListEntry2 = (CTNotesMasterIdListEntry) get_store().add_element_user(qName);
            }
            cTNotesMasterIdListEntry2.set(cTNotesMasterIdListEntry);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public void unsetNotesMasterId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOTESMASTERID$0, 0);
        }
    }
}

package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideMasterId;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideMasterIdListEntryImpl extends XmlComplexContentImpl implements CTSlideMasterIdListEntry {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName ID$2 = new QName("", "id");
    private static final QName ID2$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");

    public CTSlideMasterIdListEntryImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$0);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$0, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public long getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$2);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public String getId2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID2$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$0;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void setId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void setId2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public STSlideMasterId xgetId() {
        STSlideMasterId sTSlideMasterId;
        synchronized (monitor()) {
            check_orphaned();
            sTSlideMasterId = (STSlideMasterId) get_store().find_attribute_user(ID$2);
        }
        return sTSlideMasterId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public STRelationshipId xgetId2() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID2$4);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void xsetId(STSlideMasterId sTSlideMasterId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            STSlideMasterId sTSlideMasterId2 = (STSlideMasterId) typeStore.find_attribute_user(qName);
            if (sTSlideMasterId2 == null) {
                sTSlideMasterId2 = (STSlideMasterId) get_store().add_attribute_user(qName);
            }
            sTSlideMasterId2.set(sTSlideMasterId);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry
    public void xsetId2(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$4;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }
}

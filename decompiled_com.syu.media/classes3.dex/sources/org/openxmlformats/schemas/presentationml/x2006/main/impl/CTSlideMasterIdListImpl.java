package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideMasterIdListImpl extends XmlComplexContentImpl implements CTSlideMasterIdList {
    private static final QName SLDMASTERID$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMasterId");

    public CTSlideMasterIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry addNewSldMasterId() {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().add_element_user(SLDMASTERID$0);
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry getSldMasterIdArray(int i) {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().find_element_user(SLDMASTERID$0, i);
            if (cTSlideMasterIdListEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry[] getSldMasterIdArray() {
        CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SLDMASTERID$0, arrayList);
            cTSlideMasterIdListEntryArr = new CTSlideMasterIdListEntry[arrayList.size()];
            arrayList.toArray(cTSlideMasterIdListEntryArr);
        }
        return cTSlideMasterIdListEntryArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public List<CTSlideMasterIdListEntry> getSldMasterIdList() {
        AbstractList<CTSlideMasterIdListEntry> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSlideMasterIdListEntry>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTSlideMasterIdListImpl.1SldMasterIdList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSlideMasterIdListEntry cTSlideMasterIdListEntry) {
                    CTSlideMasterIdListImpl.this.insertNewSldMasterId(i).set(cTSlideMasterIdListEntry);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSlideMasterIdListEntry get(int i) {
                    return CTSlideMasterIdListImpl.this.getSldMasterIdArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSlideMasterIdListEntry remove(int i) {
                    CTSlideMasterIdListEntry sldMasterIdArray = CTSlideMasterIdListImpl.this.getSldMasterIdArray(i);
                    CTSlideMasterIdListImpl.this.removeSldMasterId(i);
                    return sldMasterIdArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSlideMasterIdListEntry set(int i, CTSlideMasterIdListEntry cTSlideMasterIdListEntry) {
                    CTSlideMasterIdListEntry sldMasterIdArray = CTSlideMasterIdListImpl.this.getSldMasterIdArray(i);
                    CTSlideMasterIdListImpl.this.setSldMasterIdArray(i, cTSlideMasterIdListEntry);
                    return sldMasterIdArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTSlideMasterIdListImpl.this.sizeOfSldMasterIdArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry insertNewSldMasterId(int i) {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().insert_element_user(SLDMASTERID$0, i);
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void removeSldMasterId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDMASTERID$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void setSldMasterIdArray(int i, CTSlideMasterIdListEntry cTSlideMasterIdListEntry) {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideMasterIdListEntry cTSlideMasterIdListEntry2 = (CTSlideMasterIdListEntry) get_store().find_element_user(SLDMASTERID$0, i);
            if (cTSlideMasterIdListEntry2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSlideMasterIdListEntry2.set(cTSlideMasterIdListEntry);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void setSldMasterIdArray(CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSlideMasterIdListEntryArr, SLDMASTERID$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public int sizeOfSldMasterIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SLDMASTERID$0);
        }
        return iCount_elements;
    }
}

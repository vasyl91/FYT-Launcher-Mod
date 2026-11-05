package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideIdListImpl extends XmlComplexContentImpl implements CTSlideIdList {
    private static final QName SLDID$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldId");

    public CTSlideIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry addNewSldId() {
        CTSlideIdListEntry cTSlideIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdListEntry = (CTSlideIdListEntry) get_store().add_element_user(SLDID$0);
        }
        return cTSlideIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry getSldIdArray(int i) {
        CTSlideIdListEntry cTSlideIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdListEntry = (CTSlideIdListEntry) get_store().find_element_user(SLDID$0, i);
            if (cTSlideIdListEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSlideIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry[] getSldIdArray() {
        CTSlideIdListEntry[] cTSlideIdListEntryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SLDID$0, arrayList);
            cTSlideIdListEntryArr = new CTSlideIdListEntry[arrayList.size()];
            arrayList.toArray(cTSlideIdListEntryArr);
        }
        return cTSlideIdListEntryArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public List<CTSlideIdListEntry> getSldIdList() {
        AbstractList<CTSlideIdListEntry> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSlideIdListEntry>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTSlideIdListImpl.1SldIdList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSlideIdListEntry cTSlideIdListEntry) {
                    CTSlideIdListImpl.this.insertNewSldId(i).set(cTSlideIdListEntry);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSlideIdListEntry get(int i) {
                    return CTSlideIdListImpl.this.getSldIdArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSlideIdListEntry remove(int i) {
                    CTSlideIdListEntry sldIdArray = CTSlideIdListImpl.this.getSldIdArray(i);
                    CTSlideIdListImpl.this.removeSldId(i);
                    return sldIdArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSlideIdListEntry set(int i, CTSlideIdListEntry cTSlideIdListEntry) {
                    CTSlideIdListEntry sldIdArray = CTSlideIdListImpl.this.getSldIdArray(i);
                    CTSlideIdListImpl.this.setSldIdArray(i, cTSlideIdListEntry);
                    return sldIdArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTSlideIdListImpl.this.sizeOfSldIdArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry insertNewSldId(int i) {
        CTSlideIdListEntry cTSlideIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdListEntry = (CTSlideIdListEntry) get_store().insert_element_user(SLDID$0, i);
        }
        return cTSlideIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public void removeSldId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDID$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public void setSldIdArray(int i, CTSlideIdListEntry cTSlideIdListEntry) {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideIdListEntry cTSlideIdListEntry2 = (CTSlideIdListEntry) get_store().find_element_user(SLDID$0, i);
            if (cTSlideIdListEntry2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSlideIdListEntry2.set(cTSlideIdListEntry);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public void setSldIdArray(CTSlideIdListEntry[] cTSlideIdListEntryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSlideIdListEntryArr, SLDID$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public int sizeOfSldIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SLDID$0);
        }
        return iCount_elements;
    }
}

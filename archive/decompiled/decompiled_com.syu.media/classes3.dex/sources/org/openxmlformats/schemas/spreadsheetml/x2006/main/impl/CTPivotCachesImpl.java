package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPivotCachesImpl extends XmlComplexContentImpl implements CTPivotCaches {
    private static final QName PIVOTCACHE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotCache");

    public CTPivotCachesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache addNewPivotCache() {
        CTPivotCache cTPivotCache;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCache = (CTPivotCache) get_store().add_element_user(PIVOTCACHE$0);
        }
        return cTPivotCache;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache getPivotCacheArray(int i) {
        CTPivotCache cTPivotCache;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCache = (CTPivotCache) get_store().find_element_user(PIVOTCACHE$0, i);
            if (cTPivotCache == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPivotCache;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache[] getPivotCacheArray() {
        CTPivotCache[] cTPivotCacheArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PIVOTCACHE$0, arrayList);
            cTPivotCacheArr = new CTPivotCache[arrayList.size()];
            arrayList.toArray(cTPivotCacheArr);
        }
        return cTPivotCacheArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public List<CTPivotCache> getPivotCacheList() {
        1PivotCacheList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PivotCacheList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache insertNewPivotCache(int i) {
        CTPivotCache cTPivotCache;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCache = (CTPivotCache) get_store().insert_element_user(PIVOTCACHE$0, i);
        }
        return cTPivotCache;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public void removePivotCache(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIVOTCACHE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public void setPivotCacheArray(int i, CTPivotCache cTPivotCache) {
        synchronized (monitor()) {
            check_orphaned();
            CTPivotCache cTPivotCache2 = (CTPivotCache) get_store().find_element_user(PIVOTCACHE$0, i);
            if (cTPivotCache2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPivotCache2.set(cTPivotCache);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public void setPivotCacheArray(CTPivotCache[] cTPivotCacheArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPivotCacheArr, PIVOTCACHE$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public int sizeOfPivotCacheArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PIVOTCACHE$0);
        }
        return iCount_elements;
    }
}

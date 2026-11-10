package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTabsImpl extends XmlComplexContentImpl implements CTTabs {
    private static final QName TAB$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab");

    public CTTabsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop addNewTab() {
        CTTabStop cTTabStopAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStopAdd_element_user = get_store().add_element_user(TAB$0);
        }
        return cTTabStopAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop getTabArray(int i) {
        CTTabStop cTTabStopFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStopFind_element_user = get_store().find_element_user(TAB$0, i);
            if (cTTabStopFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTabStopFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop[] getTabArray() {
        CTTabStop[] cTTabStopArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TAB$0, arrayList);
            cTTabStopArr = new CTTabStop[arrayList.size()];
            arrayList.toArray(cTTabStopArr);
        }
        return cTTabStopArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public List<CTTabStop> getTabList() {
        1TabList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TabList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop insertNewTab(int i) {
        CTTabStop cTTabStopInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStopInsert_element_user = get_store().insert_element_user(TAB$0, i);
        }
        return cTTabStopInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void removeTab(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAB$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void setTabArray(int i, CTTabStop cTTabStop) {
        synchronized (monitor()) {
            check_orphaned();
            CTTabStop cTTabStopFind_element_user = get_store().find_element_user(TAB$0, i);
            if (cTTabStopFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTabStopFind_element_user.set(cTTabStop);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void setTabArray(CTTabStop[] cTTabStopArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTabStopArr, TAB$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TAB$0);
        }
        return iCount_elements;
    }
}

package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextTabStopListImpl extends XmlComplexContentImpl implements CTTextTabStopList {
    private static final QName TAB$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tab");

    public CTTextTabStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop addNewTab() {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().add_element_user(TAB$0);
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop getTabArray(int i) {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().find_element_user(TAB$0, i);
            if (cTTextTabStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop[] getTabArray() {
        CTTextTabStop[] cTTextTabStopArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TAB$0, arrayList);
            cTTextTabStopArr = new CTTextTabStop[arrayList.size()];
            arrayList.toArray(cTTextTabStopArr);
        }
        return cTTextTabStopArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public List<CTTextTabStop> getTabList() {
        1TabList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TabList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop insertNewTab(int i) {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().insert_element_user(TAB$0, i);
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void removeTab(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAB$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void setTabArray(int i, CTTextTabStop cTTextTabStop) {
        synchronized (monitor()) {
            check_orphaned();
            CTTextTabStop cTTextTabStop2 = (CTTextTabStop) get_store().find_element_user(TAB$0, i);
            if (cTTextTabStop2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextTabStop2.set(cTTextTabStop);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void setTabArray(CTTextTabStop[] cTTextTabStopArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextTabStopArr, TAB$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TAB$0);
        }
        return iCount_elements;
    }
}

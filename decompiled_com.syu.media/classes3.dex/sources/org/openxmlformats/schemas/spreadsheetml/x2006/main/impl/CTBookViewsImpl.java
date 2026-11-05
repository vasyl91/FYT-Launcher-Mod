package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTBookViewsImpl extends XmlComplexContentImpl implements CTBookViews {
    private static final QName WORKBOOKVIEW$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookView");

    public CTBookViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView addNewWorkbookView() {
        CTBookView cTBookView;
        synchronized (monitor()) {
            check_orphaned();
            cTBookView = (CTBookView) get_store().add_element_user(WORKBOOKVIEW$0);
        }
        return cTBookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView getWorkbookViewArray(int i) {
        CTBookView cTBookView;
        synchronized (monitor()) {
            check_orphaned();
            cTBookView = (CTBookView) get_store().find_element_user(WORKBOOKVIEW$0, i);
            if (cTBookView == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView[] getWorkbookViewArray() {
        CTBookView[] cTBookViewArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WORKBOOKVIEW$0, arrayList);
            cTBookViewArr = new CTBookView[arrayList.size()];
            arrayList.toArray(cTBookViewArr);
        }
        return cTBookViewArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public List<CTBookView> getWorkbookViewList() {
        1WorkbookViewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WorkbookViewList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView insertNewWorkbookView(int i) {
        CTBookView cTBookView;
        synchronized (monitor()) {
            check_orphaned();
            cTBookView = (CTBookView) get_store().insert_element_user(WORKBOOKVIEW$0, i);
        }
        return cTBookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public void removeWorkbookView(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORKBOOKVIEW$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public void setWorkbookViewArray(int i, CTBookView cTBookView) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookView cTBookView2 = (CTBookView) get_store().find_element_user(WORKBOOKVIEW$0, i);
            if (cTBookView2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookView2.set(cTBookView);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public void setWorkbookViewArray(CTBookView[] cTBookViewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookViewArr, WORKBOOKVIEW$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public int sizeOfWorkbookViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WORKBOOKVIEW$0);
        }
        return iCount_elements;
    }
}

package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSheetViewsImpl extends XmlComplexContentImpl implements CTSheetViews {
    private static final QName SHEETVIEW$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetView");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTSheetViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$2);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView addNewSheetView() {
        CTSheetView cTSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetView = (CTSheetView) get_store().add_element_user(SHEETVIEW$0);
        }
        return cTSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$2, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView getSheetViewArray(int i) {
        CTSheetView cTSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetView = (CTSheetView) get_store().find_element_user(SHEETVIEW$0, i);
            if (cTSheetView == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView[] getSheetViewArray() {
        CTSheetView[] cTSheetViewArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHEETVIEW$0, arrayList);
            cTSheetViewArr = new CTSheetView[arrayList.size()];
            arrayList.toArray(cTSheetViewArr);
        }
        return cTSheetViewArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public List<CTSheetView> getSheetViewList() {
        1SheetViewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SheetViewList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView insertNewSheetView(int i) {
        CTSheetView cTSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetView = (CTSheetView) get_store().insert_element_user(SHEETVIEW$0, i);
        }
        return cTSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void removeSheetView(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETVIEW$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void setSheetViewArray(int i, CTSheetView cTSheetView) {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetView cTSheetView2 = (CTSheetView) get_store().find_element_user(SHEETVIEW$0, i);
            if (cTSheetView2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSheetView2.set(cTSheetView);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void setSheetViewArray(CTSheetView[] cTSheetViewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSheetViewArr, SHEETVIEW$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public int sizeOfSheetViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHEETVIEW$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }
}

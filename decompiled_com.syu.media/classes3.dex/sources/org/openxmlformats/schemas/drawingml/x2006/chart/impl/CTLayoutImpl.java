package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLayoutImpl extends XmlComplexContentImpl implements CTLayout {
    private static final QName MANUALLAYOUT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "manualLayout");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$2);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public CTManualLayout addNewManualLayout() {
        CTManualLayout cTManualLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTManualLayout = (CTManualLayout) get_store().add_element_user(MANUALLAYOUT$0);
        }
        return cTManualLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public CTManualLayout getManualLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTManualLayout cTManualLayout = (CTManualLayout) get_store().find_element_user(MANUALLAYOUT$0, 0);
            if (cTManualLayout == null) {
                return null;
            }
            return cTManualLayout;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public boolean isSetManualLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MANUALLAYOUT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public void setManualLayout(CTManualLayout cTManualLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANUALLAYOUT$0;
            CTManualLayout cTManualLayout2 = (CTManualLayout) typeStore.find_element_user(qName, 0);
            if (cTManualLayout2 == null) {
                cTManualLayout2 = (CTManualLayout) get_store().add_element_user(qName);
            }
            cTManualLayout2.set(cTManualLayout);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout
    public void unsetManualLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MANUALLAYOUT$0, 0);
        }
    }
}

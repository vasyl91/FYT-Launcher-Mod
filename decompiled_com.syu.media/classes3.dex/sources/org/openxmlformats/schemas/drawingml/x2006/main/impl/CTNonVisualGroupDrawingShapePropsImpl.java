package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNonVisualGroupDrawingShapePropsImpl extends XmlComplexContentImpl implements CTNonVisualGroupDrawingShapeProps {
    private static final QName GRPSPLOCKS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpSpLocks");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");

    public CTNonVisualGroupDrawingShapePropsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$2);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTGroupLocking addNewGrpSpLocks() {
        CTGroupLocking cTGroupLockingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupLockingAdd_element_user = get_store().add_element_user(GRPSPLOCKS$0);
        }
        return cTGroupLockingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$2, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTGroupLocking getGrpSpLocks() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupLocking cTGroupLockingFind_element_user = get_store().find_element_user(GRPSPLOCKS$0, 0);
            if (cTGroupLockingFind_element_user == null) {
                return null;
            }
            return cTGroupLockingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public boolean isSetGrpSpLocks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPSPLOCKS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void setGrpSpLocks(CTGroupLocking cTGroupLocking) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRPSPLOCKS$0;
            CTGroupLocking cTGroupLockingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTGroupLockingFind_element_user == null) {
                cTGroupLockingFind_element_user = (CTGroupLocking) get_store().add_element_user(qName);
            }
            cTGroupLockingFind_element_user.set(cTGroupLocking);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void unsetGrpSpLocks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPSPLOCKS$0, 0);
        }
    }
}

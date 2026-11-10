package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTEffectStyleItemImpl extends XmlComplexContentImpl implements CTEffectStyleItem {
    private static final QName EFFECTLST$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
    private static final QName EFFECTDAG$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
    private static final QName SCENE3D$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
    private static final QName SP3D$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sp3d");

    public CTEffectStyleItemImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTEffectContainer addNewEffectDag() {
        CTEffectContainer cTEffectContainerAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainerAdd_element_user = get_store().add_element_user(EFFECTDAG$2);
        }
        return cTEffectContainerAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTEffectList addNewEffectLst() {
        CTEffectList cTEffectList;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectList = (CTEffectList) get_store().add_element_user(EFFECTLST$0);
        }
        return cTEffectList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTScene3D addNewScene3D() {
        CTScene3D cTScene3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTScene3DAdd_element_user = get_store().add_element_user(SCENE3D$4);
        }
        return cTScene3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTShape3D addNewSp3D() {
        CTShape3D cTShape3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShape3DAdd_element_user = get_store().add_element_user(SP3D$6);
        }
        return cTShape3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTEffectContainer getEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectContainer cTEffectContainerFind_element_user = get_store().find_element_user(EFFECTDAG$2, 0);
            if (cTEffectContainerFind_element_user == null) {
                return null;
            }
            return cTEffectContainerFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTEffectList getEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectList cTEffectList = (CTEffectList) get_store().find_element_user(EFFECTLST$0, 0);
            if (cTEffectList == null) {
                return null;
            }
            return cTEffectList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTScene3D getScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTScene3D cTScene3DFind_element_user = get_store().find_element_user(SCENE3D$4, 0);
            if (cTScene3DFind_element_user == null) {
                return null;
            }
            return cTScene3DFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public CTShape3D getSp3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTShape3D cTShape3DFind_element_user = get_store().find_element_user(SP3D$6, 0);
            if (cTShape3DFind_element_user == null) {
                return null;
            }
            return cTShape3DFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public boolean isSetEffectDag() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTDAG$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public boolean isSetEffectLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public boolean isSetScene3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCENE3D$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public boolean isSetSp3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SP3D$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void setEffectDag(CTEffectContainer cTEffectContainer) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTDAG$2;
            CTEffectContainer cTEffectContainerFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEffectContainerFind_element_user == null) {
                cTEffectContainerFind_element_user = (CTEffectContainer) get_store().add_element_user(qName);
            }
            cTEffectContainerFind_element_user.set(cTEffectContainer);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void setEffectLst(CTEffectList cTEffectList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTLST$0;
            CTEffectList cTEffectList2 = (CTEffectList) typeStore.find_element_user(qName, 0);
            if (cTEffectList2 == null) {
                cTEffectList2 = (CTEffectList) get_store().add_element_user(qName);
            }
            cTEffectList2.set(cTEffectList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void setScene3D(CTScene3D cTScene3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCENE3D$4;
            CTScene3D cTScene3DFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTScene3DFind_element_user == null) {
                cTScene3DFind_element_user = (CTScene3D) get_store().add_element_user(qName);
            }
            cTScene3DFind_element_user.set(cTScene3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void setSp3D(CTShape3D cTShape3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SP3D$6;
            CTShape3D cTShape3DFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShape3DFind_element_user == null) {
                cTShape3DFind_element_user = (CTShape3D) get_store().add_element_user(qName);
            }
            cTShape3DFind_element_user.set(cTShape3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void unsetEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTDAG$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void unsetEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void unsetScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCENE3D$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem
    public void unsetSp3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SP3D$6, 0);
        }
    }
}

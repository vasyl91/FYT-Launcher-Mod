package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectorLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNonVisualConnectorPropertiesImpl extends XmlComplexContentImpl implements CTNonVisualConnectorProperties {
    private static final QName CXNSPLOCKS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cxnSpLocks");
    private static final QName STCXN$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "stCxn");
    private static final QName ENDCXN$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "endCxn");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");

    public CTNonVisualConnectorPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnectorLocking addNewCxnSpLocks() {
        CTConnectorLocking cTConnectorLockingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectorLockingAdd_element_user = get_store().add_element_user(CXNSPLOCKS$0);
        }
        return cTConnectorLockingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection addNewEndCxn() {
        CTConnection cTConnection;
        synchronized (monitor()) {
            check_orphaned();
            cTConnection = (CTConnection) get_store().add_element_user(ENDCXN$4);
        }
        return cTConnection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$6);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection addNewStCxn() {
        CTConnection cTConnection;
        synchronized (monitor()) {
            check_orphaned();
            cTConnection = (CTConnection) get_store().add_element_user(STCXN$2);
        }
        return cTConnection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnectorLocking getCxnSpLocks() {
        synchronized (monitor()) {
            check_orphaned();
            CTConnectorLocking cTConnectorLockingFind_element_user = get_store().find_element_user(CXNSPLOCKS$0, 0);
            if (cTConnectorLockingFind_element_user == null) {
                return null;
            }
            return cTConnectorLockingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection getEndCxn() {
        synchronized (monitor()) {
            check_orphaned();
            CTConnection cTConnection = (CTConnection) get_store().find_element_user(ENDCXN$4, 0);
            if (cTConnection == null) {
                return null;
            }
            return cTConnection;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$6, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection getStCxn() {
        synchronized (monitor()) {
            check_orphaned();
            CTConnection cTConnection = (CTConnection) get_store().find_element_user(STCXN$2, 0);
            if (cTConnection == null) {
                return null;
            }
            return cTConnection;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetCxnSpLocks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CXNSPLOCKS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetEndCxn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENDCXN$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetStCxn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STCXN$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setCxnSpLocks(CTConnectorLocking cTConnectorLocking) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CXNSPLOCKS$0;
            CTConnectorLocking cTConnectorLockingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTConnectorLockingFind_element_user == null) {
                cTConnectorLockingFind_element_user = (CTConnectorLocking) get_store().add_element_user(qName);
            }
            cTConnectorLockingFind_element_user.set(cTConnectorLocking);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setEndCxn(CTConnection cTConnection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDCXN$4;
            CTConnection cTConnection2 = (CTConnection) typeStore.find_element_user(qName, 0);
            if (cTConnection2 == null) {
                cTConnection2 = (CTConnection) get_store().add_element_user(qName);
            }
            cTConnection2.set(cTConnection);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setStCxn(CTConnection cTConnection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STCXN$2;
            CTConnection cTConnection2 = (CTConnection) typeStore.find_element_user(qName, 0);
            if (cTConnection2 == null) {
                cTConnection2 = (CTConnection) get_store().add_element_user(qName);
            }
            cTConnection2.set(cTConnection);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetCxnSpLocks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CXNSPLOCKS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetEndCxn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDCXN$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetStCxn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STCXN$2, 0);
        }
    }
}

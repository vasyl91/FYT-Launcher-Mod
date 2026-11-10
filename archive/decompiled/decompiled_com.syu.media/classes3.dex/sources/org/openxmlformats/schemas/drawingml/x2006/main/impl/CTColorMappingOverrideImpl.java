package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmptyElement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTColorMappingOverrideImpl extends XmlComplexContentImpl implements CTColorMappingOverride {
    private static final QName MASTERCLRMAPPING$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "masterClrMapping");
    private static final QName OVERRIDECLRMAPPING$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "overrideClrMapping");

    public CTColorMappingOverrideImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTEmptyElement addNewMasterClrMapping() {
        CTEmptyElement cTEmptyElement;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyElement = (CTEmptyElement) get_store().add_element_user(MASTERCLRMAPPING$0);
        }
        return cTEmptyElement;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTColorMapping addNewOverrideClrMapping() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().add_element_user(OVERRIDECLRMAPPING$2);
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTEmptyElement getMasterClrMapping() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmptyElement cTEmptyElement = (CTEmptyElement) get_store().find_element_user(MASTERCLRMAPPING$0, 0);
            if (cTEmptyElement == null) {
                return null;
            }
            return cTEmptyElement;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTColorMapping getOverrideClrMapping() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorMapping cTColorMapping = (CTColorMapping) get_store().find_element_user(OVERRIDECLRMAPPING$2, 0);
            if (cTColorMapping == null) {
                return null;
            }
            return cTColorMapping;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public boolean isSetMasterClrMapping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MASTERCLRMAPPING$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public boolean isSetOverrideClrMapping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OVERRIDECLRMAPPING$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void setMasterClrMapping(CTEmptyElement cTEmptyElement) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTERCLRMAPPING$0;
            CTEmptyElement cTEmptyElement2 = (CTEmptyElement) typeStore.find_element_user(qName, 0);
            if (cTEmptyElement2 == null) {
                cTEmptyElement2 = (CTEmptyElement) get_store().add_element_user(qName);
            }
            cTEmptyElement2.set(cTEmptyElement);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void setOverrideClrMapping(CTColorMapping cTColorMapping) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OVERRIDECLRMAPPING$2;
            CTColorMapping cTColorMapping2 = (CTColorMapping) typeStore.find_element_user(qName, 0);
            if (cTColorMapping2 == null) {
                cTColorMapping2 = (CTColorMapping) get_store().add_element_user(qName);
            }
            cTColorMapping2.set(cTColorMapping);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void unsetMasterClrMapping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MASTERCLRMAPPING$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void unsetOverrideClrMapping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVERRIDECLRMAPPING$2, 0);
        }
    }
}

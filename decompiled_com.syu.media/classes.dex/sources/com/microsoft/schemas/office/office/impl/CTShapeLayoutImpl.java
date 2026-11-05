package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.office.office.CTRegroupTable;
import com.microsoft.schemas.office.office.CTRules;
import com.microsoft.schemas.office.office.CTShapeLayout;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTShapeLayoutImpl extends XmlComplexContentImpl implements CTShapeLayout {
    private static final QName IDMAP$0 = new QName("urn:schemas-microsoft-com:office:office", "idmap");
    private static final QName REGROUPTABLE$2 = new QName("urn:schemas-microsoft-com:office:office", "regrouptable");
    private static final QName RULES$4 = new QName("urn:schemas-microsoft-com:office:office", "rules");
    private static final QName EXT$6 = new QName("urn:schemas-microsoft-com:vml", "ext");

    public CTShapeLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTIdMap addNewIdmap() {
        CTIdMap cTIdMapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTIdMapAdd_element_user = get_store().add_element_user(IDMAP$0);
        }
        return cTIdMapAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRegroupTable addNewRegrouptable() {
        CTRegroupTable cTRegroupTableAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRegroupTableAdd_element_user = get_store().add_element_user(REGROUPTABLE$2);
        }
        return cTRegroupTableAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRules addNewRules() {
        CTRules cTRulesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRulesAdd_element_user = get_store().add_element_user(RULES$4);
        }
        return cTRulesAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public STExt.Enum getExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EXT$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STExt.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTIdMap getIdmap() {
        synchronized (monitor()) {
            check_orphaned();
            CTIdMap cTIdMapFind_element_user = get_store().find_element_user(IDMAP$0, 0);
            if (cTIdMapFind_element_user == null) {
                return null;
            }
            return cTIdMapFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRegroupTable getRegrouptable() {
        synchronized (monitor()) {
            check_orphaned();
            CTRegroupTable cTRegroupTableFind_element_user = get_store().find_element_user(REGROUPTABLE$2, 0);
            if (cTRegroupTableFind_element_user == null) {
                return null;
            }
            return cTRegroupTableFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRules getRules() {
        synchronized (monitor()) {
            check_orphaned();
            CTRules cTRulesFind_element_user = get_store().find_element_user(RULES$4, 0);
            if (cTRulesFind_element_user == null) {
                return null;
            }
            return cTRulesFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXT$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetIdmap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IDMAP$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetRegrouptable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(REGROUPTABLE$2) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetRules() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RULES$4) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setExt(STExt.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setIdmap(CTIdMap cTIdMap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDMAP$0;
            CTIdMap cTIdMapFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTIdMapFind_element_user == null) {
                cTIdMapFind_element_user = (CTIdMap) get_store().add_element_user(qName);
            }
            cTIdMapFind_element_user.set(cTIdMap);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setRegrouptable(CTRegroupTable cTRegroupTable) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPTABLE$2;
            CTRegroupTable cTRegroupTableFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRegroupTableFind_element_user == null) {
                cTRegroupTableFind_element_user = (CTRegroupTable) get_store().add_element_user(qName);
            }
            cTRegroupTableFind_element_user.set(cTRegroupTable);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setRules(CTRules cTRules) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RULES$4;
            CTRules cTRulesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRulesFind_element_user == null) {
                cTRulesFind_element_user = (CTRules) get_store().add_element_user(qName);
            }
            cTRulesFind_element_user.set(cTRules);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXT$6);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetIdmap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IDMAP$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetRegrouptable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REGROUPTABLE$2, 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetRules() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RULES$4, 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public STExt xgetExt() {
        STExt sTExtFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTExtFind_attribute_user = get_store().find_attribute_user(EXT$6);
        }
        return sTExtFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$6;
            STExt sTExtFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTExtFind_attribute_user == null) {
                sTExtFind_attribute_user = (STExt) get_store().add_attribute_user(qName);
            }
            sTExtFind_attribute_user.set((XmlObject) sTExt);
        }
    }
}

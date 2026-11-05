package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTExternalBookImpl extends XmlComplexContentImpl implements CTExternalBook {
    private static final QName SHEETNAMES$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetNames");
    private static final QName DEFINEDNAMES$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedNames");
    private static final QName SHEETDATASET$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetDataSet");
    private static final QName ID$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");

    public CTExternalBookImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalDefinedNames addNewDefinedNames() {
        CTExternalDefinedNames cTExternalDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedNames = (CTExternalDefinedNames) get_store().add_element_user(DEFINEDNAMES$2);
        }
        return cTExternalDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetDataSet addNewSheetDataSet() {
        CTExternalSheetDataSet cTExternalSheetDataSetAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetDataSetAdd_element_user = get_store().add_element_user(SHEETDATASET$4);
        }
        return cTExternalSheetDataSetAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetNames addNewSheetNames() {
        CTExternalSheetNames cTExternalSheetNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetNames = (CTExternalSheetNames) get_store().add_element_user(SHEETNAMES$0);
        }
        return cTExternalSheetNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalDefinedNames getDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalDefinedNames cTExternalDefinedNames = (CTExternalDefinedNames) get_store().find_element_user(DEFINEDNAMES$2, 0);
            if (cTExternalDefinedNames == null) {
                return null;
            }
            return cTExternalDefinedNames;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetDataSet getSheetDataSet() {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalSheetDataSet cTExternalSheetDataSetFind_element_user = get_store().find_element_user(SHEETDATASET$4, 0);
            if (cTExternalSheetDataSetFind_element_user == null) {
                return null;
            }
            return cTExternalSheetDataSetFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetNames getSheetNames() {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalSheetNames cTExternalSheetNames = (CTExternalSheetNames) get_store().find_element_user(SHEETNAMES$0, 0);
            if (cTExternalSheetNames == null) {
                return null;
            }
            return cTExternalSheetNames;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetDefinedNames() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFINEDNAMES$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetSheetDataSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETDATASET$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetSheetNames() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETNAMES$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setDefinedNames(CTExternalDefinedNames cTExternalDefinedNames) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFINEDNAMES$2;
            CTExternalDefinedNames cTExternalDefinedNames2 = (CTExternalDefinedNames) typeStore.find_element_user(qName, 0);
            if (cTExternalDefinedNames2 == null) {
                cTExternalDefinedNames2 = (CTExternalDefinedNames) get_store().add_element_user(qName);
            }
            cTExternalDefinedNames2.set(cTExternalDefinedNames);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setSheetDataSet(CTExternalSheetDataSet cTExternalSheetDataSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETDATASET$4;
            CTExternalSheetDataSet cTExternalSheetDataSetFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExternalSheetDataSetFind_element_user == null) {
                cTExternalSheetDataSetFind_element_user = (CTExternalSheetDataSet) get_store().add_element_user(qName);
            }
            cTExternalSheetDataSetFind_element_user.set(cTExternalSheetDataSet);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setSheetNames(CTExternalSheetNames cTExternalSheetNames) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETNAMES$0;
            CTExternalSheetNames cTExternalSheetNames2 = (CTExternalSheetNames) typeStore.find_element_user(qName, 0);
            if (cTExternalSheetNames2 == null) {
                cTExternalSheetNames2 = (CTExternalSheetNames) get_store().add_element_user(qName);
            }
            cTExternalSheetNames2.set(cTExternalSheetNames);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFINEDNAMES$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetSheetDataSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETDATASET$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetSheetNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETNAMES$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID$6);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }
}

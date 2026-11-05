package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPropertiesImpl extends XmlComplexContentImpl implements CTProperties {
    private static final QName PROPERTY$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "property");

    public CTPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty addNewProperty() {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().add_element_user(PROPERTY$0);
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty getPropertyArray(int i) {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().find_element_user(PROPERTY$0, i);
            if (cTProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty[] getPropertyArray() {
        CTProperty[] cTPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROPERTY$0, arrayList);
            cTPropertyArr = new CTProperty[arrayList.size()];
            arrayList.toArray(cTPropertyArr);
        }
        return cTPropertyArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public List<CTProperty> getPropertyList() {
        AbstractList<CTProperty> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTProperty>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.CTPropertiesImpl.1PropertyList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTProperty cTProperty) {
                    CTPropertiesImpl.this.insertNewProperty(i).set(cTProperty);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTProperty get(int i) {
                    return CTPropertiesImpl.this.getPropertyArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTProperty remove(int i) {
                    CTProperty propertyArray = CTPropertiesImpl.this.getPropertyArray(i);
                    CTPropertiesImpl.this.removeProperty(i);
                    return propertyArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTProperty set(int i, CTProperty cTProperty) {
                    CTProperty propertyArray = CTPropertiesImpl.this.getPropertyArray(i);
                    CTPropertiesImpl.this.setPropertyArray(i, cTProperty);
                    return propertyArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTPropertiesImpl.this.sizeOfPropertyArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty insertNewProperty(int i) {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().insert_element_user(PROPERTY$0, i);
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void removeProperty(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void setPropertyArray(int i, CTProperty cTProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTProperty cTProperty2 = (CTProperty) get_store().find_element_user(PROPERTY$0, i);
            if (cTProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProperty2.set(cTProperty);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void setPropertyArray(CTProperty[] cTPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPropertyArr, PROPERTY$0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public int sizeOfPropertyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY$0);
        }
        return iCount_elements;
    }
}

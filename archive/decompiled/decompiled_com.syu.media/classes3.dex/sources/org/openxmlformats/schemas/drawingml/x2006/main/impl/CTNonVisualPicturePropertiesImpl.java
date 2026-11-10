package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPictureLocking;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNonVisualPicturePropertiesImpl extends XmlComplexContentImpl implements CTNonVisualPictureProperties {
    private static final QName PICLOCKS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "picLocks");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName PREFERRELATIVERESIZE$4 = new QName("", "preferRelativeResize");

    public CTNonVisualPicturePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$2);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public CTPictureLocking addNewPicLocks() {
        CTPictureLocking cTPictureLocking;
        synchronized (monitor()) {
            check_orphaned();
            cTPictureLocking = (CTPictureLocking) get_store().add_element_user(PICLOCKS$0);
        }
        return cTPictureLocking;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public CTPictureLocking getPicLocks() {
        synchronized (monitor()) {
            check_orphaned();
            CTPictureLocking cTPictureLocking = (CTPictureLocking) get_store().find_element_user(PICLOCKS$0, 0);
            if (cTPictureLocking == null) {
                return null;
            }
            return cTPictureLocking;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public boolean getPreferRelativeResize() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVERESIZE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public boolean isSetPicLocks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PICLOCKS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public boolean isSetPreferRelativeResize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVERESIZE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public void setPicLocks(CTPictureLocking cTPictureLocking) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PICLOCKS$0;
            CTPictureLocking cTPictureLocking2 = (CTPictureLocking) typeStore.find_element_user(qName, 0);
            if (cTPictureLocking2 == null) {
                cTPictureLocking2 = (CTPictureLocking) get_store().add_element_user(qName);
            }
            cTPictureLocking2.set(cTPictureLocking);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public void setPreferRelativeResize(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVERESIZE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public void unsetPicLocks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PICLOCKS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public void unsetPreferRelativeResize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVERESIZE$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public XmlBoolean xgetPreferRelativeResize() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVERESIZE$4;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties
    public void xsetPreferRelativeResize(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVERESIZE$4;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

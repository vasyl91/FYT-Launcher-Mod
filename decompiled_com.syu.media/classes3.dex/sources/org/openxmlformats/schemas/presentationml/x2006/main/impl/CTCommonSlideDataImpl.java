package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTControlList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCommonSlideDataImpl extends XmlComplexContentImpl implements CTCommonSlideData {
    private static final QName BG$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "bg");
    private static final QName SPTREE$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "spTree");
    private static final QName CUSTDATALST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
    private static final QName CONTROLS$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "controls");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName NAME$10 = new QName("", "name");

    public CTCommonSlideDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTBackground addNewBg() {
        CTBackground cTBackground;
        synchronized (monitor()) {
            check_orphaned();
            cTBackground = (CTBackground) get_store().add_element_user(BG$0);
        }
        return cTBackground;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTControlList addNewControls() {
        CTControlList cTControlListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTControlListAdd_element_user = get_store().add_element_user(CONTROLS$6);
        }
        return cTControlListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTCustomerDataList addNewCustDataLst() {
        CTCustomerDataList cTCustomerDataList;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataList = (CTCustomerDataList) get_store().add_element_user(CUSTDATALST$4);
        }
        return cTCustomerDataList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$8);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTGroupShape addNewSpTree() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().add_element_user(SPTREE$2);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTBackground getBg() {
        synchronized (monitor()) {
            check_orphaned();
            CTBackground cTBackground = (CTBackground) get_store().find_element_user(BG$0, 0);
            if (cTBackground == null) {
                return null;
            }
            return cTBackground;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTControlList getControls() {
        synchronized (monitor()) {
            check_orphaned();
            CTControlList cTControlListFind_element_user = get_store().find_element_user(CONTROLS$6, 0);
            if (cTControlListFind_element_user == null) {
                return null;
            }
            return cTControlListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTCustomerDataList getCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomerDataList cTCustomerDataList = (CTCustomerDataList) get_store().find_element_user(CUSTDATALST$4, 0);
            if (cTCustomerDataList == null) {
                return null;
            }
            return cTCustomerDataList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$8, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTGroupShape getSpTree() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupShape cTGroupShape = (CTGroupShape) get_store().find_element_user(SPTREE$2, 0);
            if (cTGroupShape == null) {
                return null;
            }
            return cTGroupShape;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BG$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetControls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTROLS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetCustDataLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTDATALST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setBg(CTBackground cTBackground) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BG$0;
            CTBackground cTBackground2 = (CTBackground) typeStore.find_element_user(qName, 0);
            if (cTBackground2 == null) {
                cTBackground2 = (CTBackground) get_store().add_element_user(qName);
            }
            cTBackground2.set(cTBackground);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setControls(CTControlList cTControlList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTROLS$6;
            CTControlList cTControlListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTControlListFind_element_user == null) {
                cTControlListFind_element_user = (CTControlList) get_store().add_element_user(qName);
            }
            cTControlListFind_element_user.set(cTControlList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setCustDataLst(CTCustomerDataList cTCustomerDataList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTDATALST$4;
            CTCustomerDataList cTCustomerDataList2 = (CTCustomerDataList) typeStore.find_element_user(qName, 0);
            if (cTCustomerDataList2 == null) {
                cTCustomerDataList2 = (CTCustomerDataList) get_store().add_element_user(qName);
            }
            cTCustomerDataList2.set(cTCustomerDataList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$8;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setSpTree(CTGroupShape cTGroupShape) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPTREE$2;
            CTGroupShape cTGroupShape2 = (CTGroupShape) typeStore.find_element_user(qName, 0);
            if (cTGroupShape2 == null) {
                cTGroupShape2 = (CTGroupShape) get_store().add_element_user(qName);
            }
            cTGroupShape2.set(cTGroupShape);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BG$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetControls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTROLS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTDATALST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_default_attribute_value(qName);
            }
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}

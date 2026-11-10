package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNotesSlideImpl extends XmlComplexContentImpl implements CTNotesSlide {
    private static final QName CSLD$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
    private static final QName CLRMAPOVR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMapOvr");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName SHOWMASTERSP$6 = new QName("", "showMasterSp");
    private static final QName SHOWMASTERPHANIM$8 = new QName("", "showMasterPhAnim");

    public CTNotesSlideImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(CSLD$0);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public CTColorMappingOverride addNewClrMapOvr() {
        CTColorMappingOverride cTColorMappingOverride;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMappingOverride = (CTColorMappingOverride) get_store().add_element_user(CLRMAPOVR$2);
        }
        return cTColorMappingOverride;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(EXTLST$4);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public CTCommonSlideData getCSld() {
        synchronized (monitor()) {
            check_orphaned();
            CTCommonSlideData cTCommonSlideData = (CTCommonSlideData) get_store().find_element_user(CSLD$0, 0);
            if (cTCommonSlideData == null) {
                return null;
            }
            return cTCommonSlideData;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public CTColorMappingOverride getClrMapOvr() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorMappingOverride cTColorMappingOverride = (CTColorMappingOverride) get_store().find_element_user(CLRMAPOVR$2, 0);
            if (cTColorMappingOverride == null) {
                return null;
            }
            return cTColorMappingOverride;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify cTExtensionListModifyFind_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                return null;
            }
            return cTExtensionListModifyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public boolean getShowMasterPhAnim() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$8;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public boolean getShowMasterSp() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$6;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public boolean isSetClrMapOvr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLRMAPOVR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public boolean isSetShowMasterPhAnim() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWMASTERPHANIM$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public boolean isSetShowMasterSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWMASTERSP$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void setCSld(CTCommonSlideData cTCommonSlideData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSLD$0;
            CTCommonSlideData cTCommonSlideData2 = (CTCommonSlideData) typeStore.find_element_user(qName, 0);
            if (cTCommonSlideData2 == null) {
                cTCommonSlideData2 = (CTCommonSlideData) get_store().add_element_user(qName);
            }
            cTCommonSlideData2.set(cTCommonSlideData);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLRMAPOVR$2;
            CTColorMappingOverride cTColorMappingOverride2 = (CTColorMappingOverride) typeStore.find_element_user(qName, 0);
            if (cTColorMappingOverride2 == null) {
                cTColorMappingOverride2 = (CTColorMappingOverride) get_store().add_element_user(qName);
            }
            cTColorMappingOverride2.set(cTColorMappingOverride);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionListModify cTExtensionListModifyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            cTExtensionListModifyFind_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void setShowMasterPhAnim(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void setShowMasterSp(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void unsetClrMapOvr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLRMAPOVR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void unsetShowMasterPhAnim() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWMASTERPHANIM$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void unsetShowMasterSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWMASTERSP$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public XmlBoolean xgetShowMasterPhAnim() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$8;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public XmlBoolean xgetShowMasterSp() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$6;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void xsetShowMasterPhAnim(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide
    public void xsetShowMasterSp(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTransition;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideLayoutType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideLayoutImpl extends XmlComplexContentImpl implements CTSlideLayout {
    private static final QName CSLD$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
    private static final QName CLRMAPOVR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMapOvr");
    private static final QName TRANSITION$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "transition");
    private static final QName TIMING$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "timing");
    private static final QName HF$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "hf");
    private static final QName EXTLST$10 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName SHOWMASTERSP$12 = new QName("", "showMasterSp");
    private static final QName SHOWMASTERPHANIM$14 = new QName("", "showMasterPhAnim");
    private static final QName MATCHINGNAME$16 = new QName("", "matchingName");
    private static final QName TYPE$18 = new QName("", JamXmlElements.TYPE);
    private static final QName PRESERVE$20 = new QName("", "preserve");
    private static final QName USERDRAWN$22 = new QName("", "userDrawn");

    public CTSlideLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(CSLD$0);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTColorMappingOverride addNewClrMapOvr() {
        CTColorMappingOverride cTColorMappingOverride;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMappingOverride = (CTColorMappingOverride) get_store().add_element_user(CLRMAPOVR$2);
        }
        return cTColorMappingOverride;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(EXTLST$10);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTHeaderFooter addNewHf() {
        CTHeaderFooter cTHeaderFooterAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooterAdd_element_user = get_store().add_element_user(HF$8);
        }
        return cTHeaderFooterAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTiming addNewTiming() {
        CTSlideTiming cTSlideTimingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTimingAdd_element_user = get_store().add_element_user(TIMING$6);
        }
        return cTSlideTimingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTransition addNewTransition() {
        CTSlideTransition cTSlideTransitionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTransitionAdd_element_user = get_store().add_element_user(TRANSITION$4);
        }
        return cTSlideTransitionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify cTExtensionListModifyFind_element_user = get_store().find_element_user(EXTLST$10, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                return null;
            }
            return cTExtensionListModifyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTHeaderFooter getHf() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooterFind_element_user = get_store().find_element_user(HF$8, 0);
            if (cTHeaderFooterFind_element_user == null) {
                return null;
            }
            return cTHeaderFooterFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public String getMatchingName() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATCHINGNAME$16;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getPreserve() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getShowMasterPhAnim() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$14;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getShowMasterSp() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$12;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTiming getTiming() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideTiming cTSlideTimingFind_element_user = get_store().find_element_user(TIMING$6, 0);
            if (cTSlideTimingFind_element_user == null) {
                return null;
            }
            return cTSlideTimingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTransition getTransition() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideTransition cTSlideTransitionFind_element_user = get_store().find_element_user(TRANSITION$4, 0);
            if (cTSlideTransitionFind_element_user == null) {
                return null;
            }
            return cTSlideTransitionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public STSlideLayoutType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STSlideLayoutType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getUserDrawn() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$22;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetClrMapOvr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLRMAPOVR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetHf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HF$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetMatchingName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MATCHINGNAME$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetPreserve() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRESERVE$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetShowMasterPhAnim() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWMASTERPHANIM$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetShowMasterSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWMASTERSP$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetTiming() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TIMING$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetTransition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRANSITION$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetUserDrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$10;
            CTExtensionListModify cTExtensionListModifyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            cTExtensionListModifyFind_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setHf(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HF$8;
            CTHeaderFooter cTHeaderFooterFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHeaderFooterFind_element_user == null) {
                cTHeaderFooterFind_element_user = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooterFind_element_user.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setMatchingName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATCHINGNAME$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setPreserve(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setShowMasterPhAnim(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setShowMasterSp(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setTiming(CTSlideTiming cTSlideTiming) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TIMING$6;
            CTSlideTiming cTSlideTimingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSlideTimingFind_element_user == null) {
                cTSlideTimingFind_element_user = (CTSlideTiming) get_store().add_element_user(qName);
            }
            cTSlideTimingFind_element_user.set(cTSlideTiming);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setTransition(CTSlideTransition cTSlideTransition) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITION$4;
            CTSlideTransition cTSlideTransitionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSlideTransitionFind_element_user == null) {
                cTSlideTransitionFind_element_user = (CTSlideTransition) get_store().add_element_user(qName);
            }
            cTSlideTransitionFind_element_user.set(cTSlideTransition);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setType(STSlideLayoutType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setUserDrawn(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetClrMapOvr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLRMAPOVR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetHf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HF$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetMatchingName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MATCHINGNAME$16);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetPreserve() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRESERVE$20);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetShowMasterPhAnim() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWMASTERPHANIM$14);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetShowMasterSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWMASTERSP$12);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetTiming() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TIMING$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetTransition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRANSITION$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$18);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetUserDrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$22);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlString xgetMatchingName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATCHINGNAME$16;
            xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_default_attribute_value(qName);
            }
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetPreserve() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$20;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetShowMasterPhAnim() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$14;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetShowMasterSp() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public STSlideLayoutType xgetType() {
        STSlideLayoutType sTSlideLayoutType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$18;
            sTSlideLayoutType = (STSlideLayoutType) typeStore.find_attribute_user(qName);
            if (sTSlideLayoutType == null) {
                sTSlideLayoutType = (STSlideLayoutType) get_default_attribute_value(qName);
            }
        }
        return sTSlideLayoutType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetUserDrawn() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$22;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetMatchingName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATCHINGNAME$16;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetPreserve(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$20;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetShowMasterPhAnim(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERPHANIM$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetShowMasterSp(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWMASTERSP$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetType(STSlideLayoutType sTSlideLayoutType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$18;
            STSlideLayoutType sTSlideLayoutType2 = (STSlideLayoutType) typeStore.find_attribute_user(qName);
            if (sTSlideLayoutType2 == null) {
                sTSlideLayoutType2 = (STSlideLayoutType) get_store().add_attribute_user(qName);
            }
            sTSlideLayoutType2.set((XmlObject) sTSlideLayoutType);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetUserDrawn(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$22;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

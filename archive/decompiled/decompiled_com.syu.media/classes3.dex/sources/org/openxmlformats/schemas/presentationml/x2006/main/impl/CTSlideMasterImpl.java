package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayoutIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTransition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideMasterImpl extends XmlComplexContentImpl implements CTSlideMaster {
    private static final QName CSLD$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
    private static final QName CLRMAP$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMap");
    private static final QName SLDLAYOUTIDLST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldLayoutIdLst");
    private static final QName TRANSITION$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "transition");
    private static final QName TIMING$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "timing");
    private static final QName HF$10 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "hf");
    private static final QName TXSTYLES$12 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "txStyles");
    private static final QName EXTLST$14 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName PRESERVE$16 = new QName("", "preserve");

    public CTSlideMasterImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(CSLD$0);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTColorMapping addNewClrMap() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().add_element_user(CLRMAP$2);
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(EXTLST$14);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTHeaderFooter addNewHf() {
        CTHeaderFooter cTHeaderFooterAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooterAdd_element_user = get_store().add_element_user(HF$10);
        }
        return cTHeaderFooterAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideLayoutIdList addNewSldLayoutIdLst() {
        CTSlideLayoutIdList cTSlideLayoutIdListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideLayoutIdListAdd_element_user = get_store().add_element_user(SLDLAYOUTIDLST$4);
        }
        return cTSlideLayoutIdListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideTiming addNewTiming() {
        CTSlideTiming cTSlideTimingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTimingAdd_element_user = get_store().add_element_user(TIMING$8);
        }
        return cTSlideTimingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideTransition addNewTransition() {
        CTSlideTransition cTSlideTransitionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTransitionAdd_element_user = get_store().add_element_user(TRANSITION$6);
        }
        return cTSlideTransitionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideMasterTextStyles addNewTxStyles() {
        CTSlideMasterTextStyles cTSlideMasterTextStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterTextStyles = (CTSlideMasterTextStyles) get_store().add_element_user(TXSTYLES$12);
        }
        return cTSlideMasterTextStyles;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTColorMapping getClrMap() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorMapping cTColorMapping = (CTColorMapping) get_store().find_element_user(CLRMAP$2, 0);
            if (cTColorMapping == null) {
                return null;
            }
            return cTColorMapping;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify cTExtensionListModifyFind_element_user = get_store().find_element_user(EXTLST$14, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                return null;
            }
            return cTExtensionListModifyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTHeaderFooter getHf() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooterFind_element_user = get_store().find_element_user(HF$10, 0);
            if (cTHeaderFooterFind_element_user == null) {
                return null;
            }
            return cTHeaderFooterFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean getPreserve() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$16;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideLayoutIdList getSldLayoutIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideLayoutIdList cTSlideLayoutIdListFind_element_user = get_store().find_element_user(SLDLAYOUTIDLST$4, 0);
            if (cTSlideLayoutIdListFind_element_user == null) {
                return null;
            }
            return cTSlideLayoutIdListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideTiming getTiming() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideTiming cTSlideTimingFind_element_user = get_store().find_element_user(TIMING$8, 0);
            if (cTSlideTimingFind_element_user == null) {
                return null;
            }
            return cTSlideTimingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideTransition getTransition() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideTransition cTSlideTransitionFind_element_user = get_store().find_element_user(TRANSITION$6, 0);
            if (cTSlideTransitionFind_element_user == null) {
                return null;
            }
            return cTSlideTransitionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public CTSlideMasterTextStyles getTxStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideMasterTextStyles cTSlideMasterTextStyles = (CTSlideMasterTextStyles) get_store().find_element_user(TXSTYLES$12, 0);
            if (cTSlideMasterTextStyles == null) {
                return null;
            }
            return cTSlideMasterTextStyles;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetHf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HF$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetPreserve() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRESERVE$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetSldLayoutIdLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SLDLAYOUTIDLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetTiming() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TIMING$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetTransition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRANSITION$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public boolean isSetTxStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXSTYLES$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setClrMap(CTColorMapping cTColorMapping) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLRMAP$2;
            CTColorMapping cTColorMapping2 = (CTColorMapping) typeStore.find_element_user(qName, 0);
            if (cTColorMapping2 == null) {
                cTColorMapping2 = (CTColorMapping) get_store().add_element_user(qName);
            }
            cTColorMapping2.set(cTColorMapping);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$14;
            CTExtensionListModify cTExtensionListModifyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            cTExtensionListModifyFind_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setHf(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HF$10;
            CTHeaderFooter cTHeaderFooterFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHeaderFooterFind_element_user == null) {
                cTHeaderFooterFind_element_user = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooterFind_element_user.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setPreserve(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setSldLayoutIdLst(CTSlideLayoutIdList cTSlideLayoutIdList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLDLAYOUTIDLST$4;
            CTSlideLayoutIdList cTSlideLayoutIdListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSlideLayoutIdListFind_element_user == null) {
                cTSlideLayoutIdListFind_element_user = (CTSlideLayoutIdList) get_store().add_element_user(qName);
            }
            cTSlideLayoutIdListFind_element_user.set(cTSlideLayoutIdList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setTiming(CTSlideTiming cTSlideTiming) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TIMING$8;
            CTSlideTiming cTSlideTimingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSlideTimingFind_element_user == null) {
                cTSlideTimingFind_element_user = (CTSlideTiming) get_store().add_element_user(qName);
            }
            cTSlideTimingFind_element_user.set(cTSlideTiming);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setTransition(CTSlideTransition cTSlideTransition) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITION$6;
            CTSlideTransition cTSlideTransitionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSlideTransitionFind_element_user == null) {
                cTSlideTransitionFind_element_user = (CTSlideTransition) get_store().add_element_user(qName);
            }
            cTSlideTransitionFind_element_user.set(cTSlideTransition);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void setTxStyles(CTSlideMasterTextStyles cTSlideMasterTextStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TXSTYLES$12;
            CTSlideMasterTextStyles cTSlideMasterTextStyles2 = (CTSlideMasterTextStyles) typeStore.find_element_user(qName, 0);
            if (cTSlideMasterTextStyles2 == null) {
                cTSlideMasterTextStyles2 = (CTSlideMasterTextStyles) get_store().add_element_user(qName);
            }
            cTSlideMasterTextStyles2.set(cTSlideMasterTextStyles);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetHf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HF$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetPreserve() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRESERVE$16);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetSldLayoutIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDLAYOUTIDLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetTiming() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TIMING$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetTransition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRANSITION$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void unsetTxStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXSTYLES$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public XmlBoolean xgetPreserve() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$16;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster
    public void xsetPreserve(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESERVE$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSheetPrImpl extends XmlComplexContentImpl implements CTSheetPr {
    private static final QName TABCOLOR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tabColor");
    private static final QName OUTLINEPR$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outlinePr");
    private static final QName PAGESETUPPR$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetUpPr");
    private static final QName SYNCHORIZONTAL$6 = new QName("", "syncHorizontal");
    private static final QName SYNCVERTICAL$8 = new QName("", "syncVertical");
    private static final QName SYNCREF$10 = new QName("", "syncRef");
    private static final QName TRANSITIONEVALUATION$12 = new QName("", "transitionEvaluation");
    private static final QName TRANSITIONENTRY$14 = new QName("", "transitionEntry");
    private static final QName PUBLISHED$16 = new QName("", "published");
    private static final QName CODENAME$18 = new QName("", "codeName");
    private static final QName FILTERMODE$20 = new QName("", "filterMode");
    private static final QName ENABLEFORMATCONDITIONSCALCULATION$22 = new QName("", "enableFormatConditionsCalculation");

    public CTSheetPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public CTOutlinePr addNewOutlinePr() {
        CTOutlinePr cTOutlinePr;
        synchronized (monitor()) {
            check_orphaned();
            cTOutlinePr = (CTOutlinePr) get_store().add_element_user(OUTLINEPR$2);
        }
        return cTOutlinePr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public CTPageSetUpPr addNewPageSetUpPr() {
        CTPageSetUpPr cTPageSetUpPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSetUpPr = (CTPageSetUpPr) get_store().add_element_user(PAGESETUPPR$4);
        }
        return cTPageSetUpPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public CTColor addNewTabColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(TABCOLOR$0);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public String getCodeName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CODENAME$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getEnableFormatConditionsCalculation() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEFORMATCONDITIONSCALCULATION$22;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getFilterMode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILTERMODE$20;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public CTOutlinePr getOutlinePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTOutlinePr cTOutlinePr = (CTOutlinePr) get_store().find_element_user(OUTLINEPR$2, 0);
            if (cTOutlinePr == null) {
                return null;
            }
            return cTOutlinePr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public CTPageSetUpPr getPageSetUpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageSetUpPr cTPageSetUpPr = (CTPageSetUpPr) get_store().find_element_user(PAGESETUPPR$4, 0);
            if (cTPageSetUpPr == null) {
                return null;
            }
            return cTPageSetUpPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getPublished() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PUBLISHED$16;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getSyncHorizontal() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCHORIZONTAL$6;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public String getSyncRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SYNCREF$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getSyncVertical() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCVERTICAL$8;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public CTColor getTabColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(TABCOLOR$0, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getTransitionEntry() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONENTRY$14;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean getTransitionEvaluation() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONEVALUATION$12;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetCodeName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CODENAME$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetEnableFormatConditionsCalculation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetFilterMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILTERMODE$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetOutlinePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTLINEPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetPageSetUpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESETUPPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetPublished() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PUBLISHED$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetSyncHorizontal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SYNCHORIZONTAL$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetSyncRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SYNCREF$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetSyncVertical() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SYNCVERTICAL$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetTabColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABCOLOR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetTransitionEntry() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TRANSITIONENTRY$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public boolean isSetTransitionEvaluation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TRANSITIONEVALUATION$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setCodeName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CODENAME$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setEnableFormatConditionsCalculation(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEFORMATCONDITIONSCALCULATION$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setFilterMode(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILTERMODE$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setOutlinePr(CTOutlinePr cTOutlinePr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINEPR$2;
            CTOutlinePr cTOutlinePr2 = (CTOutlinePr) typeStore.find_element_user(qName, 0);
            if (cTOutlinePr2 == null) {
                cTOutlinePr2 = (CTOutlinePr) get_store().add_element_user(qName);
            }
            cTOutlinePr2.set(cTOutlinePr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setPageSetUpPr(CTPageSetUpPr cTPageSetUpPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGESETUPPR$4;
            CTPageSetUpPr cTPageSetUpPr2 = (CTPageSetUpPr) typeStore.find_element_user(qName, 0);
            if (cTPageSetUpPr2 == null) {
                cTPageSetUpPr2 = (CTPageSetUpPr) get_store().add_element_user(qName);
            }
            cTPageSetUpPr2.set(cTPageSetUpPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setPublished(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PUBLISHED$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setSyncHorizontal(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCHORIZONTAL$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setSyncRef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCREF$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setSyncVertical(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCVERTICAL$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setTabColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABCOLOR$0;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setTransitionEntry(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONENTRY$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void setTransitionEvaluation(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONEVALUATION$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetCodeName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CODENAME$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetEnableFormatConditionsCalculation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENABLEFORMATCONDITIONSCALCULATION$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetFilterMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILTERMODE$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetOutlinePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINEPR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetPageSetUpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESETUPPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetPublished() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PUBLISHED$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetSyncHorizontal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SYNCHORIZONTAL$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetSyncRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SYNCREF$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetSyncVertical() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SYNCVERTICAL$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetTabColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABCOLOR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetTransitionEntry() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TRANSITIONENTRY$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void unsetTransitionEvaluation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TRANSITIONEVALUATION$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlString xgetCodeName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(CODENAME$18);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetEnableFormatConditionsCalculation() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEFORMATCONDITIONSCALCULATION$22;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetFilterMode() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILTERMODE$20;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetPublished() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PUBLISHED$16;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetSyncHorizontal() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCHORIZONTAL$6;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public STRef xgetSyncRef() {
        STRef sTRef;
        synchronized (monitor()) {
            check_orphaned();
            sTRef = (STRef) get_store().find_attribute_user(SYNCREF$10);
        }
        return sTRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetSyncVertical() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCVERTICAL$8;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetTransitionEntry() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONENTRY$14;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public XmlBoolean xgetTransitionEvaluation() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONEVALUATION$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetCodeName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CODENAME$18;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetEnableFormatConditionsCalculation(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEFORMATCONDITIONSCALCULATION$22;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetFilterMode(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILTERMODE$20;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetPublished(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PUBLISHED$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetSyncHorizontal(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCHORIZONTAL$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetSyncRef(STRef sTRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCREF$10;
            STRef sTRef2 = (STRef) typeStore.find_attribute_user(qName);
            if (sTRef2 == null) {
                sTRef2 = (STRef) get_store().add_attribute_user(qName);
            }
            sTRef2.set(sTRef);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetSyncVertical(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYNCVERTICAL$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetTransitionEntry(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONENTRY$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr
    public void xsetTransitionEvaluation(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSITIONEVALUATION$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

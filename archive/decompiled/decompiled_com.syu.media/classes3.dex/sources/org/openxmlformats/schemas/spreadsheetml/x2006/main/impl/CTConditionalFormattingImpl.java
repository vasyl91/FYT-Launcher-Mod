package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTConditionalFormattingImpl extends XmlComplexContentImpl implements CTConditionalFormatting {
    private static final QName CFRULE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfRule");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName PIVOT$4 = new QName("", "pivot");
    private static final QName SQREF$6 = new QName("", "sqref");

    public CTConditionalFormattingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public CTCfRule addNewCfRule() {
        CTCfRule cTCfRule;
        synchronized (monitor()) {
            check_orphaned();
            cTCfRule = (CTCfRule) get_store().add_element_user(CFRULE$0);
        }
        return cTCfRule;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$2);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public CTCfRule getCfRuleArray(int i) {
        CTCfRule cTCfRule;
        synchronized (monitor()) {
            check_orphaned();
            cTCfRule = (CTCfRule) get_store().find_element_user(CFRULE$0, i);
            if (cTCfRule == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCfRule;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public CTCfRule[] getCfRuleArray() {
        CTCfRule[] cTCfRuleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CFRULE$0, arrayList);
            cTCfRuleArr = new CTCfRule[arrayList.size()];
            arrayList.toArray(cTCfRuleArr);
        }
        return cTCfRuleArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public List<CTCfRule> getCfRuleList() {
        1CfRuleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CfRuleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$2, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public boolean getPivot() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public List getSqref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SQREF$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getListValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public CTCfRule insertNewCfRule(int i) {
        CTCfRule cTCfRule;
        synchronized (monitor()) {
            check_orphaned();
            cTCfRule = (CTCfRule) get_store().insert_element_user(CFRULE$0, i);
        }
        return cTCfRule;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public boolean isSetPivot() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PIVOT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public boolean isSetSqref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SQREF$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void removeCfRule(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CFRULE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void setCfRuleArray(int i, CTCfRule cTCfRule) {
        synchronized (monitor()) {
            check_orphaned();
            CTCfRule cTCfRule2 = (CTCfRule) get_store().find_element_user(CFRULE$0, i);
            if (cTCfRule2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCfRule2.set(cTCfRule);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void setCfRuleArray(CTCfRule[] cTCfRuleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCfRuleArr, CFRULE$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void setPivot(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void setSqref(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setListValue(list);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public int sizeOfCfRuleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CFRULE$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void unsetPivot() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PIVOT$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void unsetSqref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SQREF$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public XmlBoolean xgetPivot() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public STSqref xgetSqref() {
        STSqref sTSqref;
        synchronized (monitor()) {
            check_orphaned();
            sTSqref = (STSqref) get_store().find_attribute_user(SQREF$6);
        }
        return sTSqref;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void xsetPivot(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting
    public void xsetSqref(STSqref sTSqref) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$6;
            STSqref sTSqref2 = (STSqref) typeStore.find_attribute_user(qName);
            if (sTSqref2 == null) {
                sTSqref2 = (STSqref) get_store().add_attribute_user(qName);
            }
            sTSqref2.set((XmlObject) sTSqref);
        }
    }
}

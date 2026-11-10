package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationImeMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationImeMode$Enum;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDataValidationImpl extends XmlComplexContentImpl implements CTDataValidation {
    private static final QName FORMULA1$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula1");
    private static final QName FORMULA2$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula2");
    private static final QName TYPE$4 = new QName("", JamXmlElements.TYPE);
    private static final QName ERRORSTYLE$6 = new QName("", "errorStyle");
    private static final QName IMEMODE$8 = new QName("", "imeMode");
    private static final QName OPERATOR$10 = new QName("", "operator");
    private static final QName ALLOWBLANK$12 = new QName("", "allowBlank");
    private static final QName SHOWDROPDOWN$14 = new QName("", "showDropDown");
    private static final QName SHOWINPUTMESSAGE$16 = new QName("", "showInputMessage");
    private static final QName SHOWERRORMESSAGE$18 = new QName("", "showErrorMessage");
    private static final QName ERRORTITLE$20 = new QName("", "errorTitle");
    private static final QName ERROR$22 = new QName("", "error");
    private static final QName PROMPTTITLE$24 = new QName("", "promptTitle");
    private static final QName PROMPT$26 = new QName("", "prompt");
    private static final QName SQREF$28 = new QName("", "sqref");

    public CTDataValidationImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean getAllowBlank() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWBLANK$12;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public String getError() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ERROR$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationErrorStyle.Enum getErrorStyle() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORSTYLE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STDataValidationErrorStyle.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public String getErrorTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ERRORTITLE$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public String getFormula1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FORMULA1$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public String getFormula2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FORMULA2$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationImeMode$Enum getImeMode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMEMODE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STDataValidationImeMode$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationOperator.Enum getOperator() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPERATOR$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STDataValidationOperator.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public String getPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PROMPT$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public String getPromptTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PROMPTTITLE$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean getShowDropDown() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWDROPDOWN$14;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean getShowErrorMessage() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWERRORMESSAGE$18;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean getShowInputMessage() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWINPUTMESSAGE$16;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public List getSqref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SQREF$28);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getListValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STDataValidationType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetAllowBlank() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWBLANK$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetError() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ERROR$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetErrorStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ERRORSTYLE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetErrorTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ERRORTITLE$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetFormula1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FORMULA1$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetFormula2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FORMULA2$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetImeMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IMEMODE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetOperator() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPERATOR$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetPrompt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROMPT$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetPromptTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROMPTTITLE$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetShowDropDown() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWDROPDOWN$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetShowErrorMessage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWERRORMESSAGE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetShowInputMessage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWINPUTMESSAGE$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setAllowBlank(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWBLANK$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setError(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setErrorStyle(STDataValidationErrorStyle.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORSTYLE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setErrorTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORTITLE$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setFormula1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMULA1$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setFormula2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMULA2$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setImeMode(STDataValidationImeMode$Enum sTDataValidationImeMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMEMODE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTDataValidationImeMode$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setOperator(STDataValidationOperator.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPERATOR$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setPrompt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROMPT$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setPromptTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROMPTTITLE$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setShowDropDown(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWDROPDOWN$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setShowErrorMessage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWERRORMESSAGE$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setShowInputMessage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWINPUTMESSAGE$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setSqref(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setListValue(list);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void setType(STDataValidationType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetAllowBlank() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWBLANK$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetError() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ERROR$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetErrorStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ERRORSTYLE$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetErrorTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ERRORTITLE$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetFormula1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULA1$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetFormula2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULA2$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetImeMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IMEMODE$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetOperator() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPERATOR$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROMPT$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetPromptTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROMPTTITLE$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetShowDropDown() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWDROPDOWN$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetShowErrorMessage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWERRORMESSAGE$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetShowInputMessage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWINPUTMESSAGE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public XmlBoolean xgetAllowBlank() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWBLANK$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STXstring xgetError() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(ERROR$22);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationErrorStyle xgetErrorStyle() {
        STDataValidationErrorStyle sTDataValidationErrorStyle;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORSTYLE$6;
            sTDataValidationErrorStyle = (STDataValidationErrorStyle) typeStore.find_attribute_user(qName);
            if (sTDataValidationErrorStyle == null) {
                sTDataValidationErrorStyle = (STDataValidationErrorStyle) get_default_attribute_value(qName);
            }
        }
        return sTDataValidationErrorStyle;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STXstring xgetErrorTitle() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(ERRORTITLE$20);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STFormula xgetFormula1() {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().find_element_user(FORMULA1$0, 0);
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STFormula xgetFormula2() {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().find_element_user(FORMULA2$2, 0);
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationImeMode xgetImeMode() {
        STDataValidationImeMode sTDataValidationImeModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMEMODE$8;
            sTDataValidationImeModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDataValidationImeModeFind_attribute_user == null) {
                sTDataValidationImeModeFind_attribute_user = (STDataValidationImeMode) get_default_attribute_value(qName);
            }
        }
        return sTDataValidationImeModeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationOperator xgetOperator() {
        STDataValidationOperator sTDataValidationOperator;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPERATOR$10;
            sTDataValidationOperator = (STDataValidationOperator) typeStore.find_attribute_user(qName);
            if (sTDataValidationOperator == null) {
                sTDataValidationOperator = (STDataValidationOperator) get_default_attribute_value(qName);
            }
        }
        return sTDataValidationOperator;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STXstring xgetPrompt() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(PROMPT$26);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STXstring xgetPromptTitle() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(PROMPTTITLE$24);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public XmlBoolean xgetShowDropDown() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWDROPDOWN$14;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public XmlBoolean xgetShowErrorMessage() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWERRORMESSAGE$18;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public XmlBoolean xgetShowInputMessage() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWINPUTMESSAGE$16;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STSqref xgetSqref() {
        STSqref sTSqref;
        synchronized (monitor()) {
            check_orphaned();
            sTSqref = (STSqref) get_store().find_attribute_user(SQREF$28);
        }
        return sTSqref;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public STDataValidationType xgetType() {
        STDataValidationType sTDataValidationType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            sTDataValidationType = (STDataValidationType) typeStore.find_attribute_user(qName);
            if (sTDataValidationType == null) {
                sTDataValidationType = (STDataValidationType) get_default_attribute_value(qName);
            }
        }
        return sTDataValidationType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetAllowBlank(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWBLANK$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetError(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$22;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetErrorStyle(STDataValidationErrorStyle sTDataValidationErrorStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORSTYLE$6;
            STDataValidationErrorStyle sTDataValidationErrorStyle2 = (STDataValidationErrorStyle) typeStore.find_attribute_user(qName);
            if (sTDataValidationErrorStyle2 == null) {
                sTDataValidationErrorStyle2 = (STDataValidationErrorStyle) get_store().add_attribute_user(qName);
            }
            sTDataValidationErrorStyle2.set((XmlObject) sTDataValidationErrorStyle);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetErrorTitle(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORTITLE$20;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetFormula1(STFormula sTFormula) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMULA1$0;
            STFormula sTFormula2 = (STFormula) typeStore.find_element_user(qName, 0);
            if (sTFormula2 == null) {
                sTFormula2 = (STFormula) get_store().add_element_user(qName);
            }
            sTFormula2.set(sTFormula);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetFormula2(STFormula sTFormula) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMULA2$2;
            STFormula sTFormula2 = (STFormula) typeStore.find_element_user(qName, 0);
            if (sTFormula2 == null) {
                sTFormula2 = (STFormula) get_store().add_element_user(qName);
            }
            sTFormula2.set(sTFormula);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetImeMode(STDataValidationImeMode sTDataValidationImeMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMEMODE$8;
            STDataValidationImeMode sTDataValidationImeModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDataValidationImeModeFind_attribute_user == null) {
                sTDataValidationImeModeFind_attribute_user = (STDataValidationImeMode) get_store().add_attribute_user(qName);
            }
            sTDataValidationImeModeFind_attribute_user.set(sTDataValidationImeMode);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetOperator(STDataValidationOperator sTDataValidationOperator) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPERATOR$10;
            STDataValidationOperator sTDataValidationOperator2 = (STDataValidationOperator) typeStore.find_attribute_user(qName);
            if (sTDataValidationOperator2 == null) {
                sTDataValidationOperator2 = (STDataValidationOperator) get_store().add_attribute_user(qName);
            }
            sTDataValidationOperator2.set((XmlObject) sTDataValidationOperator);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetPrompt(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROMPT$26;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetPromptTitle(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROMPTTITLE$24;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetShowDropDown(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWDROPDOWN$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetShowErrorMessage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWERRORMESSAGE$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetShowInputMessage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWINPUTMESSAGE$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetSqref(STSqref sTSqref) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$28;
            STSqref sTSqref2 = (STSqref) typeStore.find_attribute_user(qName);
            if (sTSqref2 == null) {
                sTSqref2 = (STSqref) get_store().add_attribute_user(qName);
            }
            sTSqref2.set((XmlObject) sTSqref);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation
    public void xsetType(STDataValidationType sTDataValidationType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            STDataValidationType sTDataValidationType2 = (STDataValidationType) typeStore.find_attribute_user(qName);
            if (sTDataValidationType2 == null) {
                sTDataValidationType2 = (STDataValidationType) get_store().add_attribute_user(qName);
            }
            sTDataValidationType2.set((XmlObject) sTDataValidationType);
        }
    }
}

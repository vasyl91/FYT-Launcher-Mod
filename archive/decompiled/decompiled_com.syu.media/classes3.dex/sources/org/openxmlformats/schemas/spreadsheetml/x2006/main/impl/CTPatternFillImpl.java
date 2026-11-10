package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPatternFillImpl extends XmlComplexContentImpl implements CTPatternFill {
    private static final QName FGCOLOR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fgColor");
    private static final QName BGCOLOR$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bgColor");
    private static final QName PATTERNTYPE$4 = new QName("", "patternType");

    public CTPatternFillImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public CTColor addNewBgColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(BGCOLOR$2);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public CTColor addNewFgColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(FGCOLOR$0);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public CTColor getBgColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(BGCOLOR$2, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public CTColor getFgColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(FGCOLOR$0, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public STPatternType.Enum getPatternType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PATTERNTYPE$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPatternType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public boolean isSetBgColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BGCOLOR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public boolean isSetFgColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FGCOLOR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public boolean isSetPatternType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATTERNTYPE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void setBgColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BGCOLOR$2;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void setFgColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FGCOLOR$0;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void setPatternType(STPatternType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTERNTYPE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void unsetBgColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BGCOLOR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void unsetFgColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FGCOLOR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void unsetPatternType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATTERNTYPE$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public STPatternType xgetPatternType() {
        STPatternType sTPatternType;
        synchronized (monitor()) {
            check_orphaned();
            sTPatternType = (STPatternType) get_store().find_attribute_user(PATTERNTYPE$4);
        }
        return sTPatternType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill
    public void xsetPatternType(STPatternType sTPatternType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTERNTYPE$4;
            STPatternType sTPatternType2 = (STPatternType) typeStore.find_attribute_user(qName);
            if (sTPatternType2 == null) {
                sTPatternType2 = (STPatternType) get_store().add_attribute_user(qName);
            }
            sTPatternType2.set((XmlObject) sTPatternType);
        }
    }
}

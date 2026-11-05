package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTBorderImpl extends XmlComplexContentImpl implements CTBorder {
    private static final QName LEFT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "left");
    private static final QName RIGHT$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "right");
    private static final QName TOP$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "top");
    private static final QName BOTTOM$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bottom");
    private static final QName DIAGONAL$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "diagonal");
    private static final QName VERTICAL$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertical");
    private static final QName HORIZONTAL$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "horizontal");
    private static final QName DIAGONALUP$14 = new QName("", "diagonalUp");
    private static final QName DIAGONALDOWN$16 = new QName("", "diagonalDown");
    private static final QName OUTLINE$18 = new QName("", "outline");

    public CTBorderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewBottom() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(BOTTOM$6);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewDiagonal() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(DIAGONAL$8);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewHorizontal() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(HORIZONTAL$12);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewLeft() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(LEFT$0);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewRight() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(RIGHT$2);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewTop() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(TOP$4);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewVertical() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(VERTICAL$10);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(BOTTOM$6, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getDiagonal() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(DIAGONAL$8, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean getDiagonalDown() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DIAGONALDOWN$16);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean getDiagonalUp() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DIAGONALUP$14);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getHorizontal() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(HORIZONTAL$12, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(LEFT$0, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean getOutline() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$18;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getRight() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(RIGHT$2, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getTop() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(TOP$4, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getVertical() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderPr cTBorderPr = (CTBorderPr) get_store().find_element_user(VERTICAL$10, 0);
            if (cTBorderPr == null) {
                return null;
            }
            return cTBorderPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetDiagonal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIAGONAL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetDiagonalDown() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DIAGONALDOWN$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetDiagonalUp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DIAGONALUP$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetHorizontal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HORIZONTAL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetOutline() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OUTLINE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetVertical() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VERTICAL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setBottom(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$6;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setDiagonal(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIAGONAL$8;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setDiagonalDown(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIAGONALDOWN$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setDiagonalUp(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIAGONALUP$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setHorizontal(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTAL$12;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setLeft(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$0;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setOutline(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setRight(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$2;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setTop(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$4;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setVertical(CTBorderPr cTBorderPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICAL$10;
            CTBorderPr cTBorderPr2 = (CTBorderPr) typeStore.find_element_user(qName, 0);
            if (cTBorderPr2 == null) {
                cTBorderPr2 = (CTBorderPr) get_store().add_element_user(qName);
            }
            cTBorderPr2.set(cTBorderPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetDiagonal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIAGONAL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetDiagonalDown() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DIAGONALDOWN$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetDiagonalUp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DIAGONALUP$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetHorizontal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HORIZONTAL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetOutline() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OUTLINE$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetVertical() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VERTICAL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public XmlBoolean xgetDiagonalDown() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(DIAGONALDOWN$16);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public XmlBoolean xgetDiagonalUp() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(DIAGONALUP$14);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public XmlBoolean xgetOutline() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$18;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void xsetDiagonalDown(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIAGONALDOWN$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void xsetDiagonalUp(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIAGONALUP$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void xsetOutline(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

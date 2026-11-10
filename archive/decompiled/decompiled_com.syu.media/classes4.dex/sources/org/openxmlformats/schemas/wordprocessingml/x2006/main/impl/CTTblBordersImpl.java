package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblBordersImpl extends XmlComplexContentImpl implements CTTblBorders {
    private static final QName TOP$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
    private static final QName LEFT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName BOTTOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
    private static final QName RIGHT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
    private static final QName INSIDEH$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "insideH");
    private static final QName INSIDEV$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "insideV");

    public CTTblBordersImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder addNewBottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BOTTOM$4);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder addNewInsideH() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(INSIDEH$8);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder addNewInsideV() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(INSIDEV$10);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder addNewLeft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(LEFT$2);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder addNewRight() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(RIGHT$6);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder addNewTop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(TOP$0);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(BOTTOM$4, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder getInsideH() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(INSIDEH$8, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder getInsideV() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(INSIDEV$10, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(LEFT$2, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder getRight() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(RIGHT$6, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public CTBorder getTop() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(TOP$0, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public boolean isSetInsideH() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INSIDEH$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public boolean isSetInsideV() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INSIDEV$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void setBottom(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$4;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void setInsideH(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSIDEH$8;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void setInsideV(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSIDEV$10;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void setLeft(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$2;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void setRight(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$6;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void setTop(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$0;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void unsetInsideH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INSIDEH$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void unsetInsideV() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INSIDEV$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$0, 0);
        }
    }
}

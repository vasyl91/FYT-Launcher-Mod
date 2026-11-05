package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDxfImpl extends XmlComplexContentImpl implements CTDxf {
    private static final QName FONT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "font");
    private static final QName NUMFMT$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmt");
    private static final QName FILL$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fill");
    private static final QName ALIGNMENT$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "alignment");
    private static final QName BORDER$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "border");
    private static final QName PROTECTION$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protection");
    private static final QName EXTLST$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTDxfImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTCellAlignment addNewAlignment() {
        CTCellAlignment cTCellAlignment;
        synchronized (monitor()) {
            check_orphaned();
            cTCellAlignment = (CTCellAlignment) get_store().add_element_user(ALIGNMENT$6);
        }
        return cTCellAlignment;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTBorder addNewBorder() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BORDER$8);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$12);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTFill addNewFill() {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().add_element_user(FILL$4);
        }
        return cTFill;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTFont addNewFont() {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().add_element_user(FONT$0);
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$2);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTCellProtection addNewProtection() {
        CTCellProtection cTCellProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTCellProtection = (CTCellProtection) get_store().add_element_user(PROTECTION$10);
        }
        return cTCellProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTCellAlignment getAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellAlignment cTCellAlignment = (CTCellAlignment) get_store().find_element_user(ALIGNMENT$6, 0);
            if (cTCellAlignment == null) {
                return null;
            }
            return cTCellAlignment;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTBorder getBorder() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(BORDER$8, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$12, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTFill getFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTFill cTFill = (CTFill) get_store().find_element_user(FILL$4, 0);
            if (cTFill == null) {
                return null;
            }
            return cTFill;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTFont getFont() {
        synchronized (monitor()) {
            check_orphaned();
            CTFont cTFont = (CTFont) get_store().find_element_user(FONT$0, 0);
            if (cTFont == null) {
                return null;
            }
            return cTFont;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTNumFmt getNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmt cTNumFmt = (CTNumFmt) get_store().find_element_user(NUMFMT$2, 0);
            if (cTNumFmt == null) {
                return null;
            }
            return cTNumFmt;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public CTCellProtection getProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellProtection cTCellProtection = (CTCellProtection) get_store().find_element_user(PROTECTION$10, 0);
            if (cTCellProtection == null) {
                return null;
            }
            return cTCellProtection;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetAlignment() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALIGNMENT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetBorder() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BORDER$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetFont() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FONT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public boolean isSetProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTION$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setAlignment(CTCellAlignment cTCellAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$6;
            CTCellAlignment cTCellAlignment2 = (CTCellAlignment) typeStore.find_element_user(qName, 0);
            if (cTCellAlignment2 == null) {
                cTCellAlignment2 = (CTCellAlignment) get_store().add_element_user(qName);
            }
            cTCellAlignment2.set(cTCellAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setBorder(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDER$8;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$12;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setFill(CTFill cTFill) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$4;
            CTFill cTFill2 = (CTFill) typeStore.find_element_user(qName, 0);
            if (cTFill2 == null) {
                cTFill2 = (CTFill) get_store().add_element_user(qName);
            }
            cTFill2.set(cTFill);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setFont(CTFont cTFont) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONT$0;
            CTFont cTFont2 = (CTFont) typeStore.find_element_user(qName, 0);
            if (cTFont2 == null) {
                cTFont2 = (CTFont) get_store().add_element_user(qName);
            }
            cTFont2.set(cTFont);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setNumFmt(CTNumFmt cTNumFmt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMT$2;
            CTNumFmt cTNumFmt2 = (CTNumFmt) typeStore.find_element_user(qName, 0);
            if (cTNumFmt2 == null) {
                cTNumFmt2 = (CTNumFmt) get_store().add_element_user(qName);
            }
            cTNumFmt2.set(cTNumFmt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void setProtection(CTCellProtection cTCellProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTION$10;
            CTCellProtection cTCellProtection2 = (CTCellProtection) typeStore.find_element_user(qName, 0);
            if (cTCellProtection2 == null) {
                cTCellProtection2 = (CTCellProtection) get_store().add_element_user(qName);
            }
            cTCellProtection2.set(cTCellProtection);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALIGNMENT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetBorder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDER$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FONT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf
    public void unsetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTION$10, 0);
        }
    }
}

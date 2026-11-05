package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSupplementalFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTFontCollectionImpl extends XmlComplexContentImpl implements CTFontCollection {
    private static final QName LATIN$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "latin");
    private static final QName EA$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ea");
    private static final QName CS$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cs");
    private static final QName FONT$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "font");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");

    public CTFontCollectionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont addNewCs() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(CS$4);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont addNewEa() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(EA$2);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$8);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont addNewFont() {
        CTSupplementalFont cTSupplementalFontAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSupplementalFontAdd_element_user = get_store().add_element_user(FONT$6);
        }
        return cTSupplementalFontAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont addNewLatin() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(LATIN$0);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont getCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextFont cTTextFont = (CTTextFont) get_store().find_element_user(CS$4, 0);
            if (cTTextFont == null) {
                return null;
            }
            return cTTextFont;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont getEa() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextFont cTTextFont = (CTTextFont) get_store().find_element_user(EA$2, 0);
            if (cTTextFont == null) {
                return null;
            }
            return cTTextFont;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$8, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont getFontArray(int i) {
        CTSupplementalFont cTSupplementalFontFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSupplementalFontFind_element_user = get_store().find_element_user(FONT$6, i);
            if (cTSupplementalFontFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSupplementalFontFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont[] getFontArray() {
        CTSupplementalFont[] cTSupplementalFontArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FONT$6, arrayList);
            cTSupplementalFontArr = new CTSupplementalFont[arrayList.size()];
            arrayList.toArray(cTSupplementalFontArr);
        }
        return cTSupplementalFontArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public List<CTSupplementalFont> getFontList() {
        1FontList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FontList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont getLatin() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextFont cTTextFont = (CTTextFont) get_store().find_element_user(LATIN$0, 0);
            if (cTTextFont == null) {
                return null;
            }
            return cTTextFont;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont insertNewFont(int i) {
        CTSupplementalFont cTSupplementalFontInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSupplementalFontInsert_element_user = get_store().insert_element_user(FONT$6, i);
        }
        return cTSupplementalFontInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void removeFont(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FONT$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setCs(CTTextFont cTTextFont) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CS$4;
            CTTextFont cTTextFont2 = (CTTextFont) typeStore.find_element_user(qName, 0);
            if (cTTextFont2 == null) {
                cTTextFont2 = (CTTextFont) get_store().add_element_user(qName);
            }
            cTTextFont2.set(cTTextFont);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setEa(CTTextFont cTTextFont) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EA$2;
            CTTextFont cTTextFont2 = (CTTextFont) typeStore.find_element_user(qName, 0);
            if (cTTextFont2 == null) {
                cTTextFont2 = (CTTextFont) get_store().add_element_user(qName);
            }
            cTTextFont2.set(cTTextFont);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$8;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setFontArray(int i, CTSupplementalFont cTSupplementalFont) {
        synchronized (monitor()) {
            check_orphaned();
            CTSupplementalFont cTSupplementalFontFind_element_user = get_store().find_element_user(FONT$6, i);
            if (cTSupplementalFontFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSupplementalFontFind_element_user.set(cTSupplementalFont);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setFontArray(CTSupplementalFont[] cTSupplementalFontArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSupplementalFontArr, FONT$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setLatin(CTTextFont cTTextFont) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LATIN$0;
            CTTextFont cTTextFont2 = (CTTextFont) typeStore.find_element_user(qName, 0);
            if (cTTextFont2 == null) {
                cTTextFont2 = (CTTextFont) get_store().add_element_user(qName);
            }
            cTTextFont2.set(cTTextFont);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public int sizeOfFontArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FONT$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }
}

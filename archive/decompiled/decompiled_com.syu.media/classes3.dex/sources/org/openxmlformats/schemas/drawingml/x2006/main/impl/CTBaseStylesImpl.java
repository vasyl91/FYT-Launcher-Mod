package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTBaseStylesImpl extends XmlComplexContentImpl implements CTBaseStyles {
    private static final QName CLRSCHEME$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrScheme");
    private static final QName FONTSCHEME$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fontScheme");
    private static final QName FMTSCHEME$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fmtScheme");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");

    public CTBaseStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTColorScheme addNewClrScheme() {
        CTColorScheme cTColorScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTColorScheme = (CTColorScheme) get_store().add_element_user(CLRSCHEME$0);
        }
        return cTColorScheme;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$6);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTStyleMatrix addNewFmtScheme() {
        CTStyleMatrix cTStyleMatrix;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrix = (CTStyleMatrix) get_store().add_element_user(FMTSCHEME$4);
        }
        return cTStyleMatrix;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTFontScheme addNewFontScheme() {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().add_element_user(FONTSCHEME$2);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTColorScheme getClrScheme() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorScheme cTColorScheme = (CTColorScheme) get_store().find_element_user(CLRSCHEME$0, 0);
            if (cTColorScheme == null) {
                return null;
            }
            return cTColorScheme;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$6, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTStyleMatrix getFmtScheme() {
        synchronized (monitor()) {
            check_orphaned();
            CTStyleMatrix cTStyleMatrix = (CTStyleMatrix) get_store().find_element_user(FMTSCHEME$4, 0);
            if (cTStyleMatrix == null) {
                return null;
            }
            return cTStyleMatrix;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTFontScheme getFontScheme() {
        synchronized (monitor()) {
            check_orphaned();
            CTFontScheme cTFontScheme = (CTFontScheme) get_store().find_element_user(FONTSCHEME$2, 0);
            if (cTFontScheme == null) {
                return null;
            }
            return cTFontScheme;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setClrScheme(CTColorScheme cTColorScheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLRSCHEME$0;
            CTColorScheme cTColorScheme2 = (CTColorScheme) typeStore.find_element_user(qName, 0);
            if (cTColorScheme2 == null) {
                cTColorScheme2 = (CTColorScheme) get_store().add_element_user(qName);
            }
            cTColorScheme2.set(cTColorScheme);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setFmtScheme(CTStyleMatrix cTStyleMatrix) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMTSCHEME$4;
            CTStyleMatrix cTStyleMatrix2 = (CTStyleMatrix) typeStore.find_element_user(qName, 0);
            if (cTStyleMatrix2 == null) {
                cTStyleMatrix2 = (CTStyleMatrix) get_store().add_element_user(qName);
            }
            cTStyleMatrix2.set(cTStyleMatrix);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setFontScheme(CTFontScheme cTFontScheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTSCHEME$2;
            CTFontScheme cTFontScheme2 = (CTFontScheme) typeStore.find_element_user(qName, 0);
            if (cTFontScheme2 == null) {
                cTFontScheme2 = (CTFontScheme) get_store().add_element_user(qName);
            }
            cTFontScheme2.set(cTFontScheme);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextListStyleImpl extends XmlComplexContentImpl implements CTTextListStyle {
    private static final QName DEFPPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "defPPr");
    private static final QName LVL1PPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl1pPr");
    private static final QName LVL2PPR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl2pPr");
    private static final QName LVL3PPR$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl3pPr");
    private static final QName LVL4PPR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl4pPr");
    private static final QName LVL5PPR$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl5pPr");
    private static final QName LVL6PPR$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl6pPr");
    private static final QName LVL7PPR$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl7pPr");
    private static final QName LVL8PPR$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl8pPr");
    private static final QName LVL9PPR$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl9pPr");
    private static final QName EXTLST$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");

    public CTTextListStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewDefPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(DEFPPR$0);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$20);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl1PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL1PPR$2);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl2PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL2PPR$4);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl3PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL3PPR$6);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl4PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL4PPR$8);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl5PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL5PPR$10);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl6PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL6PPR$12);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl7PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL7PPR$14);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl8PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL8PPR$16);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl9PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(LVL9PPR$18);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getDefPPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(DEFPPR$0, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$20, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl1PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL1PPR$2, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl2PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL2PPR$4, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl3PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL3PPR$6, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl4PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL4PPR$8, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl5PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL5PPR$10, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl6PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL6PPR$12, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl7PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL7PPR$14, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl8PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL8PPR$16, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl9PPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(LVL9PPR$18, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetDefPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFPPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl1PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL1PPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl2PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL2PPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl3PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL3PPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl4PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL4PPR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl5PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL5PPR$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl6PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL6PPR$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl7PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL7PPR$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl8PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL8PPR$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl9PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL9PPR$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setDefPPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFPPR$0;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$20;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl1PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL1PPR$2;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl2PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL2PPR$4;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl3PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL3PPR$6;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl4PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL4PPR$8;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl5PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL5PPR$10;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl6PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL6PPR$12;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl7PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL7PPR$14;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl8PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL8PPR$16;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl9PPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL9PPR$18;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetDefPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFPPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl1PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL1PPR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl2PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL2PPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl3PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL3PPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl4PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL4PPR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl5PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL5PPR$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl6PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL6PPR$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl7PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL7PPR$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl8PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL8PPR$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl9PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL9PPR$18, 0);
        }
    }
}

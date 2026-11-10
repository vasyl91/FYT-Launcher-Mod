package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorSchemeList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomColorList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTObjectStyleDefaults;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTOfficeStyleSheetImpl extends XmlComplexContentImpl implements CTOfficeStyleSheet {
    private static final QName THEMEELEMENTS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "themeElements");
    private static final QName OBJECTDEFAULTS$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "objectDefaults");
    private static final QName EXTRACLRSCHEMELST$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extraClrSchemeLst");
    private static final QName CUSTCLRLST$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "custClrLst");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName NAME$10 = new QName("", "name");

    public CTOfficeStyleSheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTCustomColorList addNewCustClrLst() {
        CTCustomColorList cTCustomColorListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomColorListAdd_element_user = get_store().add_element_user(CUSTCLRLST$6);
        }
        return cTCustomColorListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$8);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTColorSchemeList addNewExtraClrSchemeLst() {
        CTColorSchemeList cTColorSchemeListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorSchemeListAdd_element_user = get_store().add_element_user(EXTRACLRSCHEMELST$4);
        }
        return cTColorSchemeListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTObjectStyleDefaults addNewObjectDefaults() {
        CTObjectStyleDefaults cTObjectStyleDefaultsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTObjectStyleDefaultsAdd_element_user = get_store().add_element_user(OBJECTDEFAULTS$2);
        }
        return cTObjectStyleDefaultsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTBaseStyles addNewThemeElements() {
        CTBaseStyles cTBaseStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTBaseStyles = (CTBaseStyles) get_store().add_element_user(THEMEELEMENTS$0);
        }
        return cTBaseStyles;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTCustomColorList getCustClrLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomColorList cTCustomColorListFind_element_user = get_store().find_element_user(CUSTCLRLST$6, 0);
            if (cTCustomColorListFind_element_user == null) {
                return null;
            }
            return cTCustomColorListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTColorSchemeList getExtraClrSchemeLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorSchemeList cTColorSchemeListFind_element_user = get_store().find_element_user(EXTRACLRSCHEMELST$4, 0);
            if (cTColorSchemeListFind_element_user == null) {
                return null;
            }
            return cTColorSchemeListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTObjectStyleDefaults getObjectDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            CTObjectStyleDefaults cTObjectStyleDefaultsFind_element_user = get_store().find_element_user(OBJECTDEFAULTS$2, 0);
            if (cTObjectStyleDefaultsFind_element_user == null) {
                return null;
            }
            return cTObjectStyleDefaultsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public CTBaseStyles getThemeElements() {
        synchronized (monitor()) {
            check_orphaned();
            CTBaseStyles cTBaseStyles = (CTBaseStyles) get_store().find_element_user(THEMEELEMENTS$0, 0);
            if (cTBaseStyles == null) {
                return null;
            }
            return cTBaseStyles;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public boolean isSetCustClrLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTCLRLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public boolean isSetExtraClrSchemeLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTRACLRSCHEMELST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public boolean isSetObjectDefaults() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OBJECTDEFAULTS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void setCustClrLst(CTCustomColorList cTCustomColorList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTCLRLST$6;
            CTCustomColorList cTCustomColorListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCustomColorListFind_element_user == null) {
                cTCustomColorListFind_element_user = (CTCustomColorList) get_store().add_element_user(qName);
            }
            cTCustomColorListFind_element_user.set(cTCustomColorList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void setExtraClrSchemeLst(CTColorSchemeList cTColorSchemeList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTRACLRSCHEMELST$4;
            CTColorSchemeList cTColorSchemeListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTColorSchemeListFind_element_user == null) {
                cTColorSchemeListFind_element_user = (CTColorSchemeList) get_store().add_element_user(qName);
            }
            cTColorSchemeListFind_element_user.set(cTColorSchemeList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void setObjectDefaults(CTObjectStyleDefaults cTObjectStyleDefaults) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBJECTDEFAULTS$2;
            CTObjectStyleDefaults cTObjectStyleDefaultsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTObjectStyleDefaultsFind_element_user == null) {
                cTObjectStyleDefaultsFind_element_user = (CTObjectStyleDefaults) get_store().add_element_user(qName);
            }
            cTObjectStyleDefaultsFind_element_user.set(cTObjectStyleDefaults);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void setThemeElements(CTBaseStyles cTBaseStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMEELEMENTS$0;
            CTBaseStyles cTBaseStyles2 = (CTBaseStyles) typeStore.find_element_user(qName, 0);
            if (cTBaseStyles2 == null) {
                cTBaseStyles2 = (CTBaseStyles) get_store().add_element_user(qName);
            }
            cTBaseStyles2.set(cTBaseStyles);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void unsetCustClrLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTCLRLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void unsetExtraClrSchemeLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRACLRSCHEMELST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void unsetObjectDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OBJECTDEFAULTS$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_default_attribute_value(qName);
            }
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}

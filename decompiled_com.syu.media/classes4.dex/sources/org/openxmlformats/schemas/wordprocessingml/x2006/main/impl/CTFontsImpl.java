package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHint;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHint$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTFontsImpl extends XmlComplexContentImpl implements CTFonts {
    private static final QName HINT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hint");
    private static final QName ASCII$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ascii");
    private static final QName HANSI$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hAnsi");
    private static final QName EASTASIA$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsia");
    private static final QName CS$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
    private static final QName ASCIITHEME$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "asciiTheme");
    private static final QName HANSITHEME$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hAnsiTheme");
    private static final QName EASTASIATHEME$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsiaTheme");
    private static final QName CSTHEME$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cstheme");

    public CTFontsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public String getAscii() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ASCII$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme.Enum getAsciiTheme() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ASCIITHEME$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTheme.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public String getCs() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CS$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme.Enum getCstheme() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CSTHEME$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTheme.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public String getEastAsia() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EASTASIA$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme.Enum getEastAsiaTheme() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EASTASIATHEME$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTheme.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public String getHAnsi() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HANSI$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme.Enum getHAnsiTheme() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HANSITHEME$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTheme.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STHint$Enum getHint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HINT$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STHint$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetAscii() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASCII$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetAsciiTheme() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASCIITHEME$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CS$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetCstheme() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CSTHEME$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetEastAsia() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EASTASIA$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetEastAsiaTheme() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EASTASIATHEME$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetHAnsi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HANSI$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetHAnsiTheme() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HANSITHEME$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public boolean isSetHint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HINT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setAscii(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASCII$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setAsciiTheme(STTheme.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASCIITHEME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setCs(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CS$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setCstheme(STTheme.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSTHEME$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setEastAsia(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIA$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setEastAsiaTheme(STTheme.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIATHEME$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setHAnsi(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANSI$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setHAnsiTheme(STTheme.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANSITHEME$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void setHint(STHint$Enum sTHint$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HINT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTHint$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetAscii() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASCII$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetAsciiTheme() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASCIITHEME$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CS$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetCstheme() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CSTHEME$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetEastAsia() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EASTASIA$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetEastAsiaTheme() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EASTASIATHEME$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetHAnsi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HANSI$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetHAnsiTheme() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HANSITHEME$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void unsetHint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HINT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STString xgetAscii() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(ASCII$2);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme xgetAsciiTheme() {
        STTheme sTThemeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeFind_attribute_user = get_store().find_attribute_user(ASCIITHEME$10);
        }
        return sTThemeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STString xgetCs() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(CS$8);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme xgetCstheme() {
        STTheme sTThemeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeFind_attribute_user = get_store().find_attribute_user(CSTHEME$16);
        }
        return sTThemeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STString xgetEastAsia() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(EASTASIA$6);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme xgetEastAsiaTheme() {
        STTheme sTThemeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeFind_attribute_user = get_store().find_attribute_user(EASTASIATHEME$14);
        }
        return sTThemeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STString xgetHAnsi() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(HANSI$4);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STTheme xgetHAnsiTheme() {
        STTheme sTThemeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeFind_attribute_user = get_store().find_attribute_user(HANSITHEME$12);
        }
        return sTThemeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public STHint xgetHint() {
        STHint sTHintFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHintFind_attribute_user = get_store().find_attribute_user(HINT$0);
        }
        return sTHintFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetAscii(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASCII$2;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetAsciiTheme(STTheme sTTheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASCIITHEME$10;
            STTheme sTThemeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTThemeFind_attribute_user == null) {
                sTThemeFind_attribute_user = (STTheme) get_store().add_attribute_user(qName);
            }
            sTThemeFind_attribute_user.set((XmlObject) sTTheme);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetCs(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CS$8;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetCstheme(STTheme sTTheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSTHEME$16;
            STTheme sTThemeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTThemeFind_attribute_user == null) {
                sTThemeFind_attribute_user = (STTheme) get_store().add_attribute_user(qName);
            }
            sTThemeFind_attribute_user.set((XmlObject) sTTheme);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetEastAsia(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIA$6;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetEastAsiaTheme(STTheme sTTheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIATHEME$14;
            STTheme sTThemeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTThemeFind_attribute_user == null) {
                sTThemeFind_attribute_user = (STTheme) get_store().add_attribute_user(qName);
            }
            sTThemeFind_attribute_user.set((XmlObject) sTTheme);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetHAnsi(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANSI$4;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetHAnsiTheme(STTheme sTTheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANSITHEME$12;
            STTheme sTThemeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTThemeFind_attribute_user == null) {
                sTThemeFind_attribute_user = (STTheme) get_store().add_attribute_user(qName);
            }
            sTThemeFind_attribute_user.set((XmlObject) sTTheme);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts
    public void xsetHint(STHint sTHint) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HINT$0;
            STHint sTHintFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHintFind_attribute_user == null) {
                sTHintFind_attribute_user = (STHint) get_store().add_attribute_user(qName);
            }
            sTHintFind_attribute_user.set(sTHint);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTUnderlineImpl extends XmlComplexContentImpl implements CTUnderline {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName COLOR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
    private static final QName THEMECOLOR$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
    private static final QName THEMETINT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
    private static final QName THEMESHADE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");

    public CTUnderlineImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public Object getColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COLOR$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STThemeColor$Enum getThemeColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(THEMECOLOR$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STThemeColor$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public byte[] getThemeShade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(THEMESHADE$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public byte[] getThemeTint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(THEMETINT$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUnderline.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STUnderline.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetThemeColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMECOLOR$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetThemeShade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMESHADE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetThemeTint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMETINT$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setColor(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setThemeColor(STThemeColor$Enum sTThemeColor$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMECOLOR$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTThemeColor$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setThemeShade(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMESHADE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setThemeTint(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMETINT$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setVal(STUnderline.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetThemeColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMECOLOR$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetThemeShade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMESHADE$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetThemeTint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMETINT$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STHexColor xgetColor() {
        STHexColor sTHexColorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHexColorFind_attribute_user = get_store().find_attribute_user(COLOR$2);
        }
        return sTHexColorFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STThemeColor xgetThemeColor() {
        STThemeColor sTThemeColorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeColorFind_attribute_user = get_store().find_attribute_user(THEMECOLOR$4);
        }
        return sTThemeColorFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUcharHexNumber xgetThemeShade() {
        STUcharHexNumber sTUcharHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUcharHexNumberFind_attribute_user = get_store().find_attribute_user(THEMESHADE$8);
        }
        return sTUcharHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUcharHexNumber xgetThemeTint() {
        STUcharHexNumber sTUcharHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUcharHexNumberFind_attribute_user = get_store().find_attribute_user(THEMETINT$6);
        }
        return sTUcharHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUnderline xgetVal() {
        STUnderline sTUnderlineFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUnderlineFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTUnderlineFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetColor(STHexColor sTHexColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$2;
            STHexColor sTHexColorFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHexColorFind_attribute_user == null) {
                sTHexColorFind_attribute_user = (STHexColor) get_store().add_attribute_user(qName);
            }
            sTHexColorFind_attribute_user.set(sTHexColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetThemeColor(STThemeColor sTThemeColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMECOLOR$4;
            STThemeColor sTThemeColorFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTThemeColorFind_attribute_user == null) {
                sTThemeColorFind_attribute_user = (STThemeColor) get_store().add_attribute_user(qName);
            }
            sTThemeColorFind_attribute_user.set(sTThemeColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetThemeShade(STUcharHexNumber sTUcharHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMESHADE$8;
            STUcharHexNumber sTUcharHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTUcharHexNumberFind_attribute_user == null) {
                sTUcharHexNumberFind_attribute_user = (STUcharHexNumber) get_store().add_attribute_user(qName);
            }
            sTUcharHexNumberFind_attribute_user.set(sTUcharHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetThemeTint(STUcharHexNumber sTUcharHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMETINT$6;
            STUcharHexNumber sTUcharHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTUcharHexNumberFind_attribute_user == null) {
                sTUcharHexNumberFind_attribute_user = (STUcharHexNumber) get_store().add_attribute_user(qName);
            }
            sTUcharHexNumberFind_attribute_user.set(sTUcharHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetVal(STUnderline sTUnderline) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STUnderline sTUnderlineFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTUnderlineFind_attribute_user == null) {
                sTUnderlineFind_attribute_user = (STUnderline) get_store().add_attribute_user(qName);
            }
            sTUnderlineFind_attribute_user.set((XmlObject) sTUnderline);
        }
    }
}

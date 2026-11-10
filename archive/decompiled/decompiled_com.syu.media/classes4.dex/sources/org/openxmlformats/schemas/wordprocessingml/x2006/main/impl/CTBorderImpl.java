package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEighthPointMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPointMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTBorderImpl extends XmlComplexContentImpl implements CTBorder {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName COLOR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
    private static final QName THEMECOLOR$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
    private static final QName THEMETINT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
    private static final QName THEMESHADE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");
    private static final QName SZ$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
    private static final QName SPACE$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "space");
    private static final QName SHADOW$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
    private static final QName FRAME$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "frame");

    public CTBorderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff.Enum getFrame() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FRAME$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff.Enum getShadow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SHADOW$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public BigInteger getSpace() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPACE$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public BigInteger getSz() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SZ$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STBorder.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STBorder.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetFrame() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FRAME$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetShadow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHADOW$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetSpace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPACE$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SZ$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetThemeColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMECOLOR$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetThemeShade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMESHADE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetThemeTint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMETINT$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setFrame(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FRAME$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setShadow(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setSpace(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setSz(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setVal(STBorder.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetFrame() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FRAME$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetShadow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHADOW$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetSpace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPACE$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SZ$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetThemeColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMECOLOR$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetThemeShade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMESHADE$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetThemeTint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMETINT$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STHexColor xgetColor() {
        STHexColor sTHexColorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHexColorFind_attribute_user = get_store().find_attribute_user(COLOR$2);
        }
        return sTHexColorFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff xgetFrame() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(FRAME$16);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff xgetShadow() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(SHADOW$14);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STPointMeasure xgetSpace() {
        STPointMeasure sTPointMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPointMeasureFind_attribute_user = get_store().find_attribute_user(SPACE$12);
        }
        return sTPointMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STEighthPointMeasure xgetSz() {
        STEighthPointMeasure sTEighthPointMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTEighthPointMeasureFind_attribute_user = get_store().find_attribute_user(SZ$10);
        }
        return sTEighthPointMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STThemeColor xgetThemeColor() {
        STThemeColor sTThemeColorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeColorFind_attribute_user = get_store().find_attribute_user(THEMECOLOR$4);
        }
        return sTThemeColorFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STUcharHexNumber xgetThemeShade() {
        STUcharHexNumber sTUcharHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUcharHexNumberFind_attribute_user = get_store().find_attribute_user(THEMESHADE$8);
        }
        return sTUcharHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STUcharHexNumber xgetThemeTint() {
        STUcharHexNumber sTUcharHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUcharHexNumberFind_attribute_user = get_store().find_attribute_user(THEMETINT$6);
        }
        return sTUcharHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STBorder xgetVal() {
        STBorder sTBorderFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBorderFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTBorderFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetFrame(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FRAME$16;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetShadow(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$14;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetSpace(STPointMeasure sTPointMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$12;
            STPointMeasure sTPointMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPointMeasureFind_attribute_user == null) {
                sTPointMeasureFind_attribute_user = (STPointMeasure) get_store().add_attribute_user(qName);
            }
            sTPointMeasureFind_attribute_user.set(sTPointMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetSz(STEighthPointMeasure sTEighthPointMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$10;
            STEighthPointMeasure sTEighthPointMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTEighthPointMeasureFind_attribute_user == null) {
                sTEighthPointMeasureFind_attribute_user = (STEighthPointMeasure) get_store().add_attribute_user(qName);
            }
            sTEighthPointMeasureFind_attribute_user.set(sTEighthPointMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetVal(STBorder sTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STBorder sTBorderFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBorderFind_attribute_user == null) {
                sTBorderFind_attribute_user = (STBorder) get_store().add_attribute_user(qName);
            }
            sTBorderFind_attribute_user.set((XmlObject) sTBorder);
        }
    }
}

package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnsignedIntHex;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTRgbColorImpl extends XmlComplexContentImpl implements CTRgbColor {
    private static final QName RGB$0 = new QName("", "rgb");

    public CTRgbColorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor
    public byte[] getRgb() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RGB$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor
    public boolean isSetRgb() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RGB$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor
    public void setRgb(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RGB$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor
    public void unsetRgb() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RGB$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor
    public STUnsignedIntHex xgetRgb() {
        STUnsignedIntHex sTUnsignedIntHex;
        synchronized (monitor()) {
            check_orphaned();
            sTUnsignedIntHex = (STUnsignedIntHex) get_store().find_attribute_user(RGB$0);
        }
        return sTUnsignedIntHex;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor
    public void xsetRgb(STUnsignedIntHex sTUnsignedIntHex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RGB$0;
            STUnsignedIntHex sTUnsignedIntHex2 = (STUnsignedIntHex) typeStore.find_attribute_user(qName);
            if (sTUnsignedIntHex2 == null) {
                sTUnsignedIntHex2 = (STUnsignedIntHex) get_store().add_attribute_user(qName);
            }
            sTUnsignedIntHex2.set(sTUnsignedIntHex);
        }
    }
}

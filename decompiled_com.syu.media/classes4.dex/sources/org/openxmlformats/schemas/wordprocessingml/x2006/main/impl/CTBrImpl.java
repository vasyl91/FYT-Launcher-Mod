package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTBrImpl extends XmlComplexContentImpl implements CTBr {
    private static final QName TYPE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
    private static final QName CLEAR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clear");

    public CTBrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrClear.Enum getClear() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLEAR$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STBrClear.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STBrType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public boolean isSetClear() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLEAR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void setClear(STBrClear.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLEAR$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void setType(STBrType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void unsetClear() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLEAR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrClear xgetClear() {
        STBrClear sTBrClearFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBrClearFind_attribute_user = get_store().find_attribute_user(CLEAR$2);
        }
        return sTBrClearFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrType xgetType() {
        STBrType sTBrTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBrTypeFind_attribute_user = get_store().find_attribute_user(TYPE$0);
        }
        return sTBrTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void xsetClear(STBrClear sTBrClear) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLEAR$2;
            STBrClear sTBrClearFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBrClearFind_attribute_user == null) {
                sTBrClearFind_attribute_user = (STBrClear) get_store().add_attribute_user(qName);
            }
            sTBrClearFind_attribute_user.set((XmlObject) sTBrClear);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void xsetType(STBrType sTBrType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STBrType sTBrTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBrTypeFind_attribute_user == null) {
                sTBrTypeFind_attribute_user = (STBrType) get_store().add_attribute_user(qName);
            }
            sTBrTypeFind_attribute_user.set((XmlObject) sTBrType);
        }
    }
}

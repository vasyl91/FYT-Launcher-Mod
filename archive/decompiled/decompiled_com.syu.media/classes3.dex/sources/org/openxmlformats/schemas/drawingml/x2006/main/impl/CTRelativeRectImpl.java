package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTRelativeRectImpl extends XmlComplexContentImpl implements CTRelativeRect {
    private static final QName L$0 = new QName("", "l");
    private static final QName T$2 = new QName("", "t");
    private static final QName R$4 = new QName("", "r");
    private static final QName B$6 = new QName("", "b");

    public CTRelativeRectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public int getB() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public int getL() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public int getR() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public int getT() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public boolean isSetB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(B$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public boolean isSetL() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(L$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public boolean isSetR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(R$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public boolean isSetT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(T$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void setB(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void setL(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void setR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void setT(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void unsetB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(B$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void unsetL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(L$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void unsetR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(R$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void unsetT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(T$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public STPercentage xgetB() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public STPercentage xgetL() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public STPercentage xgetR() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$4;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public STPercentage xgetT() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void xsetB(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void xsetL(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void xsetR(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$4;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect
    public void xsetT(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }
}

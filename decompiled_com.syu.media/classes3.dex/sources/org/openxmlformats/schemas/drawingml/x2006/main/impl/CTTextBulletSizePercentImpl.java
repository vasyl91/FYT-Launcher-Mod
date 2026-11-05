package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextBulletSizePercent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextBulletSizePercentImpl extends XmlComplexContentImpl implements CTTextBulletSizePercent {
    private static final QName VAL$0 = new QName("", "val");

    public CTTextBulletSizePercentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public int getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public void setVal(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public STTextBulletSizePercent xgetVal() {
        STTextBulletSizePercent sTTextBulletSizePercent;
        synchronized (monitor()) {
            check_orphaned();
            sTTextBulletSizePercent = (STTextBulletSizePercent) get_store().find_attribute_user(VAL$0);
        }
        return sTTextBulletSizePercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public void xsetVal(STTextBulletSizePercent sTTextBulletSizePercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTextBulletSizePercent sTTextBulletSizePercent2 = (STTextBulletSizePercent) typeStore.find_attribute_user(qName);
            if (sTTextBulletSizePercent2 == null) {
                sTTextBulletSizePercent2 = (STTextBulletSizePercent) get_store().add_attribute_user(qName);
            }
            sTTextBulletSizePercent2.set(sTTextBulletSizePercent);
        }
    }
}

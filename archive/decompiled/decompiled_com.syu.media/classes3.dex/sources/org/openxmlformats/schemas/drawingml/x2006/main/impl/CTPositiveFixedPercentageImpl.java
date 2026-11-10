package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPositiveFixedPercentageImpl extends XmlComplexContentImpl implements CTPositiveFixedPercentage {
    private static final QName VAL$0 = new QName("", "val");

    public CTPositiveFixedPercentageImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
    public STPositiveFixedPercentage xgetVal() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveFixedPercentage = (STPositiveFixedPercentage) get_store().find_attribute_user(VAL$0);
        }
        return sTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
    public void xsetVal(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STPositiveFixedPercentage sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) typeStore.find_attribute_user(qName);
            if (sTPositiveFixedPercentage2 == null) {
                sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) get_store().add_attribute_user(qName);
            }
            sTPositiveFixedPercentage2.set(sTPositiveFixedPercentage);
        }
    }
}

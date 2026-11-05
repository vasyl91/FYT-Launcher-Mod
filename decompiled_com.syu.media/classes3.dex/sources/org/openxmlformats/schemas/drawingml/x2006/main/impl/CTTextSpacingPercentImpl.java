package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextSpacingPercentImpl extends XmlComplexContentImpl implements CTTextSpacingPercent {
    private static final QName VAL$0 = new QName("", "val");

    public CTTextSpacingPercentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
    public STTextSpacingPercent xgetVal() {
        STTextSpacingPercent sTTextSpacingPercent;
        synchronized (monitor()) {
            check_orphaned();
            sTTextSpacingPercent = (STTextSpacingPercent) get_store().find_attribute_user(VAL$0);
        }
        return sTTextSpacingPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
    public void xsetVal(STTextSpacingPercent sTTextSpacingPercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTextSpacingPercent sTTextSpacingPercent2 = (STTextSpacingPercent) typeStore.find_attribute_user(qName);
            if (sTTextSpacingPercent2 == null) {
                sTTextSpacingPercent2 = (STTextSpacingPercent) get_store().add_attribute_user(qName);
            }
            sTTextSpacingPercent2.set(sTTextSpacingPercent);
        }
    }
}

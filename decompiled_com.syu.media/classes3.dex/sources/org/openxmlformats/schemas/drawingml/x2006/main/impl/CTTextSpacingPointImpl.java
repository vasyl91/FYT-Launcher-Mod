package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPoint;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextSpacingPointImpl extends XmlComplexContentImpl implements CTTextSpacingPoint {
    private static final QName VAL$0 = new QName("", "val");

    public CTTextSpacingPointImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
    public STTextSpacingPoint xgetVal() {
        STTextSpacingPoint sTTextSpacingPoint;
        synchronized (monitor()) {
            check_orphaned();
            sTTextSpacingPoint = (STTextSpacingPoint) get_store().find_attribute_user(VAL$0);
        }
        return sTTextSpacingPoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
    public void xsetVal(STTextSpacingPoint sTTextSpacingPoint) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTextSpacingPoint sTTextSpacingPoint2 = (STTextSpacingPoint) typeStore.find_attribute_user(qName);
            if (sTTextSpacingPoint2 == null) {
                sTTextSpacingPoint2 = (STTextSpacingPoint) get_store().add_attribute_user(qName);
            }
            sTTextSpacingPoint2.set(sTTextSpacingPoint);
        }
    }
}

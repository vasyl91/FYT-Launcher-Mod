package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTickLblPosImpl extends XmlComplexContentImpl implements CTTickLblPos {
    private static final QName VAL$0 = new QName("", "val");

    public CTTickLblPosImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos
    public STTickLblPos.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTickLblPos.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos
    public void setVal(STTickLblPos.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos
    public STTickLblPos xgetVal() {
        STTickLblPos sTTickLblPos;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTTickLblPos = (STTickLblPos) typeStore.find_attribute_user(qName);
            if (sTTickLblPos == null) {
                sTTickLblPos = (STTickLblPos) get_default_attribute_value(qName);
            }
        }
        return sTTickLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos
    public void xsetVal(STTickLblPos sTTickLblPos) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTickLblPos sTTickLblPos2 = (STTickLblPos) typeStore.find_attribute_user(qName);
            if (sTTickLblPos2 == null) {
                sTTickLblPos2 = (STTickLblPos) get_store().add_attribute_user(qName);
            }
            sTTickLblPos2.set((XmlObject) sTTickLblPos);
        }
    }
}

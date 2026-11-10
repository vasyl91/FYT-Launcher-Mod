package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTickMarkImpl extends XmlComplexContentImpl implements CTTickMark {
    private static final QName VAL$0 = new QName("", "val");

    public CTTickMarkImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark
    public STTickMark.Enum getVal() {
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
            return (STTickMark.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark
    public void setVal(STTickMark.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark
    public STTickMark xgetVal() {
        STTickMark sTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTTickMark = (STTickMark) typeStore.find_attribute_user(qName);
            if (sTTickMark == null) {
                sTTickMark = (STTickMark) get_default_attribute_value(qName);
            }
        }
        return sTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark
    public void xsetVal(STTickMark sTTickMark) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTickMark sTTickMark2 = (STTickMark) typeStore.find_attribute_user(qName);
            if (sTTickMark2 == null) {
                sTTickMark2 = (STTickMark) get_store().add_attribute_user(qName);
            }
            sTTickMark2.set((XmlObject) sTTickMark);
        }
    }
}

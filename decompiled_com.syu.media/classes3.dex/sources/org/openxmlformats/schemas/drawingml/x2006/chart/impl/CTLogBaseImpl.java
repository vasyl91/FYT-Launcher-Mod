package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLogBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLogBaseImpl extends XmlComplexContentImpl implements CTLogBase {
    private static final QName VAL$0 = new QName("", "val");

    public CTLogBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase
    public double getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase
    public void setVal(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase
    public STLogBase xgetVal() {
        STLogBase sTLogBase;
        synchronized (monitor()) {
            check_orphaned();
            sTLogBase = (STLogBase) get_store().find_attribute_user(VAL$0);
        }
        return sTLogBase;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase
    public void xsetVal(STLogBase sTLogBase) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STLogBase sTLogBase2 = (STLogBase) typeStore.find_attribute_user(qName);
            if (sTLogBase2 == null) {
                sTLogBase2 = (STLogBase) get_store().add_attribute_user(qName);
            }
            sTLogBase2.set(sTLogBase);
        }
    }
}

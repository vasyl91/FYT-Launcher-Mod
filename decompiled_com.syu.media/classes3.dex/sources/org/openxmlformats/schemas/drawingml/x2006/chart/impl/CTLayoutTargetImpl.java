package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutTarget;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLayoutTargetImpl extends XmlComplexContentImpl implements CTLayoutTarget {
    private static final QName VAL$0 = new QName("", "val");

    public CTLayoutTargetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget
    public STLayoutTarget.Enum getVal() {
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
            return (STLayoutTarget.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget
    public void setVal(STLayoutTarget.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget
    public STLayoutTarget xgetVal() {
        STLayoutTarget sTLayoutTarget;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTLayoutTarget = (STLayoutTarget) typeStore.find_attribute_user(qName);
            if (sTLayoutTarget == null) {
                sTLayoutTarget = (STLayoutTarget) get_default_attribute_value(qName);
            }
        }
        return sTLayoutTarget;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget
    public void xsetVal(STLayoutTarget sTLayoutTarget) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STLayoutTarget sTLayoutTarget2 = (STLayoutTarget) typeStore.find_attribute_user(qName);
            if (sTLayoutTarget2 == null) {
                sTLayoutTarget2 = (STLayoutTarget) get_store().add_attribute_user(qName);
            }
            sTLayoutTarget2.set((XmlObject) sTLayoutTarget);
        }
    }
}

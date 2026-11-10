package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrosses;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCrossesImpl extends XmlComplexContentImpl implements CTCrosses {
    private static final QName VAL$0 = new QName("", "val");

    public CTCrossesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses
    public STCrosses.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STCrosses.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses
    public void setVal(STCrosses.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses
    public STCrosses xgetVal() {
        STCrosses sTCrosses;
        synchronized (monitor()) {
            check_orphaned();
            sTCrosses = (STCrosses) get_store().find_attribute_user(VAL$0);
        }
        return sTCrosses;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses
    public void xsetVal(STCrosses sTCrosses) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STCrosses sTCrosses2 = (STCrosses) typeStore.find_attribute_user(qName);
            if (sTCrosses2 == null) {
                sTCrosses2 = (STCrosses) get_store().add_attribute_user(qName);
            }
            sTCrosses2.set((XmlObject) sTCrosses);
        }
    }
}

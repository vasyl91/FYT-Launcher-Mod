package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTAxPosImpl extends XmlComplexContentImpl implements CTAxPos {
    private static final QName VAL$0 = new QName("", "val");

    public CTAxPosImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos
    public STAxPos.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STAxPos.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos
    public void setVal(STAxPos.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos
    public STAxPos xgetVal() {
        STAxPos sTAxPos;
        synchronized (monitor()) {
            check_orphaned();
            sTAxPos = (STAxPos) get_store().find_attribute_user(VAL$0);
        }
        return sTAxPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos
    public void xsetVal(STAxPos sTAxPos) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STAxPos sTAxPos2 = (STAxPos) typeStore.find_attribute_user(qName);
            if (sTAxPos2 == null) {
                sTAxPos2 = (STAxPos) get_store().add_attribute_user(qName);
            }
            sTAxPos2.set((XmlObject) sTAxPos);
        }
    }
}

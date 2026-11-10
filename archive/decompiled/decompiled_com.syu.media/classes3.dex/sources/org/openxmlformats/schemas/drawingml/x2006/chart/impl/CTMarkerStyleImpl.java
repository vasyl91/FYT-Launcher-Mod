package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTMarkerStyleImpl extends XmlComplexContentImpl implements CTMarkerStyle {
    private static final QName VAL$0 = new QName("", "val");

    public CTMarkerStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle
    public STMarkerStyle.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STMarkerStyle.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle
    public void setVal(STMarkerStyle.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle
    public STMarkerStyle xgetVal() {
        STMarkerStyle sTMarkerStyle;
        synchronized (monitor()) {
            check_orphaned();
            sTMarkerStyle = (STMarkerStyle) get_store().find_attribute_user(VAL$0);
        }
        return sTMarkerStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle
    public void xsetVal(STMarkerStyle sTMarkerStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STMarkerStyle sTMarkerStyle2 = (STMarkerStyle) typeStore.find_attribute_user(qName);
            if (sTMarkerStyle2 == null) {
                sTMarkerStyle2 = (STMarkerStyle) get_store().add_attribute_user(qName);
            }
            sTMarkerStyle2.set((XmlObject) sTMarkerStyle);
        }
    }
}

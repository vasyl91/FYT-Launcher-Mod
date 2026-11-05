package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTVerticalAlignRunImpl extends XmlComplexContentImpl implements CTVerticalAlignRun {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTVerticalAlignRunImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun
    public STVerticalAlignRun.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STVerticalAlignRun.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun
    public void setVal(STVerticalAlignRun.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun
    public STVerticalAlignRun xgetVal() {
        STVerticalAlignRun sTVerticalAlignRunFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVerticalAlignRunFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTVerticalAlignRunFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun
    public void xsetVal(STVerticalAlignRun sTVerticalAlignRun) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STVerticalAlignRun sTVerticalAlignRunFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTVerticalAlignRunFind_attribute_user == null) {
                sTVerticalAlignRunFind_attribute_user = (STVerticalAlignRun) get_store().add_attribute_user(qName);
            }
            sTVerticalAlignRunFind_attribute_user.set((XmlObject) sTVerticalAlignRun);
        }
    }
}

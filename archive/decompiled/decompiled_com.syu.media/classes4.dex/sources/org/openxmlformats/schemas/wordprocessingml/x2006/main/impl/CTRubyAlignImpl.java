package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STRubyAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STRubyAlign$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRubyAlignImpl extends XmlComplexContentImpl implements CTRubyAlign {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTRubyAlignImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public STRubyAlign$Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STRubyAlign$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public void setVal(STRubyAlign$Enum sTRubyAlign$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTRubyAlign$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public STRubyAlign xgetVal() {
        STRubyAlign sTRubyAlignFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTRubyAlignFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTRubyAlignFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public void xsetVal(STRubyAlign sTRubyAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STRubyAlign sTRubyAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTRubyAlignFind_attribute_user == null) {
                sTRubyAlignFind_attribute_user = (STRubyAlign) get_store().add_attribute_user(qName);
            }
            sTRubyAlignFind_attribute_user.set(sTRubyAlign);
        }
    }
}

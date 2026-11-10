package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTLangImpl extends XmlComplexContentImpl implements CTLang {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTLangImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang
    public Object getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang
    public void setVal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang
    public STLang xgetVal() {
        STLang sTLangFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLangFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTLangFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang
    public void xsetVal(STLang sTLang) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STLang sTLangFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLangFind_attribute_user == null) {
                sTLangFind_attribute_user = (STLang) get_store().add_attribute_user(qName);
            }
            sTLangFind_attribute_user.set(sTLang);
        }
    }
}

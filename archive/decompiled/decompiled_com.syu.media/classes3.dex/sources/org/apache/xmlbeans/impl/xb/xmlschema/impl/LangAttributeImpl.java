package org.apache.xmlbeans.impl.xb.xmlschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class LangAttributeImpl extends XmlComplexContentImpl implements LangAttribute {
    private static final QName LANG$0 = new QName(XMLValidationSchema.SCHEMA_ID_DTD, "lang");
    private static final long serialVersionUID = 1;

    public LangAttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public String getLang() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LANG$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public XmlLanguage xgetLang() {
        XmlLanguage xmlLanguageFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlLanguageFind_attribute_user = get_store().find_attribute_user(LANG$0);
        }
        return xmlLanguageFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public boolean isSetLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LANG$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void setLang(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void xsetLang(XmlLanguage xmlLanguage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$0;
            XmlLanguage xmlLanguageFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlLanguageFind_attribute_user == null) {
                xmlLanguageFind_attribute_user = (XmlLanguage) get_store().add_attribute_user(qName);
            }
            xmlLanguageFind_attribute_user.set(xmlLanguage);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void unsetLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LANG$0);
        }
    }
}

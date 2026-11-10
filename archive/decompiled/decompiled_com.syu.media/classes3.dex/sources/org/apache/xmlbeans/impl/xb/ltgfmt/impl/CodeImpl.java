package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CodeImpl extends XmlComplexContentImpl implements Code {
    private static final QName ID$0 = new QName("", "ID");
    private static final long serialVersionUID = 1;

    public CodeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public String getID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public XmlToken xgetID() {
        XmlToken xmlTokenFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_attribute_user = get_store().find_attribute_user(ID$0);
        }
        return xmlTokenFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public boolean isSetID() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public void setID(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public void xsetID(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlTokenFind_attribute_user == null) {
                xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlTokenFind_attribute_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public void unsetID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }
}

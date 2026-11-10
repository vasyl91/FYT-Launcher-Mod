package com.microsoft.schemas.vml.impl;

import chip.FinalChip;
import com.microsoft.schemas.vml.CTF;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTFImpl extends XmlComplexContentImpl implements CTF {
    private static final QName EQN$0 = new QName(FinalChip.BSP_PLATFORM_Null, "eqn");

    public CTFImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTF
    public String getEqn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EQN$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTF
    public boolean isSetEqn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EQN$0) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTF
    public void setEqn(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQN$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTF
    public void unsetEqn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EQN$0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTF
    public XmlString xgetEqn() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(EQN$0);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTF
    public void xsetEqn(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQN$0;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}

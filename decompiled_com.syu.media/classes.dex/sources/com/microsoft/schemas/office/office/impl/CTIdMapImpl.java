package com.microsoft.schemas.office.office.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTIdMapImpl extends XmlComplexContentImpl implements CTIdMap {
    private static final QName EXT$0 = new QName("urn:schemas-microsoft-com:vml", "ext");
    private static final QName DATA$2 = new QName(FinalChip.BSP_PLATFORM_Null, "data");

    public CTIdMapImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public String getData() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DATA$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public STExt.Enum getExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EXT$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STExt.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public boolean isSetData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DATA$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXT$0) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public void setData(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATA$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public void setExt(STExt.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public void unsetData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DATA$2);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXT$0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public XmlString xgetData() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(DATA$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public STExt xgetExt() {
        STExt sTExtFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTExtFind_attribute_user = get_store().find_attribute_user(EXT$0);
        }
        return sTExtFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public void xsetData(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATA$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTIdMap
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            STExt sTExtFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTExtFind_attribute_user == null) {
                sTExtFind_attribute_user = (STExt) get_store().add_attribute_user(qName);
            }
            sTExtFind_attribute_user.set((XmlObject) sTExt);
        }
    }
}

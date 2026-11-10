package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class StyleSheetTypeImpl extends SheetTypeImpl implements StyleSheetType {
    private static final QName ID$0 = new QName(FinalChip.BSP_PLATFORM_Null, "ID");
    private static final QName NAME$2 = new QName(FinalChip.BSP_PLATFORM_Null, "Name");
    private static final QName NAMEU$4 = new QName(FinalChip.BSP_PLATFORM_Null, "NameU");
    private static final QName ISCUSTOMNAME$6 = new QName(FinalChip.BSP_PLATFORM_Null, "IsCustomName");
    private static final QName ISCUSTOMNAMEU$8 = new QName(FinalChip.BSP_PLATFORM_Null, "IsCustomNameU");

    public StyleSheetTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public long getID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$0);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public boolean getIsCustomName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAME$6);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public boolean getIsCustomNameU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAMEU$8);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public String getNameU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAMEU$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public boolean isSetIsCustomName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISCUSTOMNAME$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public boolean isSetIsCustomNameU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISCUSTOMNAMEU$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public boolean isSetNameU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAMEU$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void setID(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void setIsCustomName(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAME$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void setIsCustomNameU(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAMEU$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void setNameU(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMEU$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void unsetIsCustomName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISCUSTOMNAME$6);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void unsetIsCustomNameU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISCUSTOMNAMEU$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$2);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void unsetNameU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAMEU$4);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public XmlUnsignedInt xgetID() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(ID$0);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public XmlBoolean xgetIsCustomName() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAME$6);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public XmlBoolean xgetIsCustomNameU() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAMEU$8);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public XmlString xgetNameU() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAMEU$4);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void xsetID(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void xsetIsCustomName(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAME$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void xsetIsCustomNameU(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAMEU$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetType
    public void xsetNameU(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMEU$4;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}

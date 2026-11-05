package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ConnectTypeImpl extends XmlComplexContentImpl implements ConnectType {
    private static final QName FROMSHEET$0 = new QName(FinalChip.BSP_PLATFORM_Null, "FromSheet");
    private static final QName FROMCELL$2 = new QName(FinalChip.BSP_PLATFORM_Null, "FromCell");
    private static final QName FROMPART$4 = new QName(FinalChip.BSP_PLATFORM_Null, "FromPart");
    private static final QName TOSHEET$6 = new QName(FinalChip.BSP_PLATFORM_Null, "ToSheet");
    private static final QName TOCELL$8 = new QName(FinalChip.BSP_PLATFORM_Null, "ToCell");
    private static final QName TOPART$10 = new QName(FinalChip.BSP_PLATFORM_Null, "ToPart");

    public ConnectTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public String getFromCell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FROMCELL$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public int getFromPart() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FROMPART$4);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public long getFromSheet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FROMSHEET$0);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public String getToCell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TOCELL$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public int getToPart() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TOPART$10);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public long getToSheet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TOSHEET$6);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public boolean isSetFromCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FROMCELL$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public boolean isSetFromPart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FROMPART$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public boolean isSetToCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOCELL$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public boolean isSetToPart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOPART$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void setFromCell(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMCELL$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void setFromPart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMPART$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void setFromSheet(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMSHEET$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void setToCell(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOCELL$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void setToPart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPART$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void setToSheet(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOSHEET$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void unsetFromCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FROMCELL$2);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void unsetFromPart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FROMPART$4);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void unsetToCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOCELL$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void unsetToPart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOPART$10);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public XmlString xgetFromCell() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(FROMCELL$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public XmlInt xgetFromPart() {
        XmlInt xmlIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_attribute_user = get_store().find_attribute_user(FROMPART$4);
        }
        return xmlIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public XmlUnsignedInt xgetFromSheet() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(FROMSHEET$0);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public XmlString xgetToCell() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TOCELL$8);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public XmlInt xgetToPart() {
        XmlInt xmlIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_attribute_user = get_store().find_attribute_user(TOPART$10);
        }
        return xmlIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public XmlUnsignedInt xgetToSheet() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(TOSHEET$6);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void xsetFromCell(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMCELL$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void xsetFromPart(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMPART$4;
            XmlInt xmlIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntFind_attribute_user == null) {
                xmlIntFind_attribute_user = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlIntFind_attribute_user.set(xmlInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void xsetFromSheet(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMSHEET$0;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void xsetToCell(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOCELL$8;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void xsetToPart(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPART$10;
            XmlInt xmlIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntFind_attribute_user == null) {
                xmlIntFind_attribute_user = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlIntFind_attribute_user.set(xmlInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectType
    public void xsetToSheet(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOSHEET$6;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}

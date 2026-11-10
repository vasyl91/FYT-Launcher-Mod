package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTableStyleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableStyleElementImpl extends XmlComplexContentImpl implements CTTableStyleElement {
    private static final QName TYPE$0 = new QName("", JamXmlElements.TYPE);
    private static final QName SIZE$2 = new QName("", "size");
    private static final QName DXFID$4 = new QName("", "dxfId");

    public CTTableStyleElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public long getDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DXFID$4);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public long getSize() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public STTableStyleType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTableStyleType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public boolean isSetDxfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DXFID$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public boolean isSetSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SIZE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void setDxfId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXFID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void setSize(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void setType(STTableStyleType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void unsetDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DXFID$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void unsetSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SIZE$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public STDxfId xgetDxfId() {
        STDxfId sTDxfId;
        synchronized (monitor()) {
            check_orphaned();
            sTDxfId = (STDxfId) get_store().find_attribute_user(DXFID$4);
        }
        return sTDxfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public XmlUnsignedInt xgetSize() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$2;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public STTableStyleType xgetType() {
        STTableStyleType sTTableStyleType;
        synchronized (monitor()) {
            check_orphaned();
            sTTableStyleType = (STTableStyleType) get_store().find_attribute_user(TYPE$0);
        }
        return sTTableStyleType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void xsetDxfId(STDxfId sTDxfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXFID$4;
            STDxfId sTDxfId2 = (STDxfId) typeStore.find_attribute_user(qName);
            if (sTDxfId2 == null) {
                sTDxfId2 = (STDxfId) get_store().add_attribute_user(qName);
            }
            sTDxfId2.set(sTDxfId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void xsetSize(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$2;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement
    public void xsetType(STTableStyleType sTTableStyleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STTableStyleType sTTableStyleType2 = (STTableStyleType) typeStore.find_attribute_user(qName);
            if (sTTableStyleType2 == null) {
                sTTableStyleType2 = (STTableStyleType) get_store().add_attribute_user(qName);
            }
            sTTableStyleType2.set((XmlObject) sTTableStyleType);
        }
    }
}

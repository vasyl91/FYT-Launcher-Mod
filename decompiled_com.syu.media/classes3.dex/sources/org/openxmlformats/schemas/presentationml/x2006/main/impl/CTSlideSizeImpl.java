package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeCoordinate;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeType;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeType$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideSizeImpl extends XmlComplexContentImpl implements CTSlideSize {
    private static final QName CX$0 = new QName("", "cx");
    private static final QName CY$2 = new QName("", "cy");
    private static final QName TYPE$4 = new QName("", JamXmlElements.TYPE);

    public CTSlideSizeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public int getCx() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CX$0);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public int getCy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CY$2);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeType$Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STSlideSizeType$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void setCx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CX$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void setCy(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void setType(STSlideSizeType$Enum sTSlideSizeType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTSlideSizeType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeCoordinate xgetCx() {
        STSlideSizeCoordinate sTSlideSizeCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTSlideSizeCoordinate = (STSlideSizeCoordinate) get_store().find_attribute_user(CX$0);
        }
        return sTSlideSizeCoordinate;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeCoordinate xgetCy() {
        STSlideSizeCoordinate sTSlideSizeCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTSlideSizeCoordinate = (STSlideSizeCoordinate) get_store().find_attribute_user(CY$2);
        }
        return sTSlideSizeCoordinate;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeType xgetType() {
        STSlideSizeType sTSlideSizeTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            sTSlideSizeTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSlideSizeTypeFind_attribute_user == null) {
                sTSlideSizeTypeFind_attribute_user = (STSlideSizeType) get_default_attribute_value(qName);
            }
        }
        return sTSlideSizeTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void xsetCx(STSlideSizeCoordinate sTSlideSizeCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CX$0;
            STSlideSizeCoordinate sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) typeStore.find_attribute_user(qName);
            if (sTSlideSizeCoordinate2 == null) {
                sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) get_store().add_attribute_user(qName);
            }
            sTSlideSizeCoordinate2.set(sTSlideSizeCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void xsetCy(STSlideSizeCoordinate sTSlideSizeCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$2;
            STSlideSizeCoordinate sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) typeStore.find_attribute_user(qName);
            if (sTSlideSizeCoordinate2 == null) {
                sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) get_store().add_attribute_user(qName);
            }
            sTSlideSizeCoordinate2.set(sTSlideSizeCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void xsetType(STSlideSizeType sTSlideSizeType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            STSlideSizeType sTSlideSizeTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSlideSizeTypeFind_attribute_user == null) {
                sTSlideSizeTypeFind_attribute_user = (STSlideSizeType) get_store().add_attribute_user(qName);
            }
            sTSlideSizeTypeFind_attribute_user.set(sTSlideSizeType);
        }
    }
}

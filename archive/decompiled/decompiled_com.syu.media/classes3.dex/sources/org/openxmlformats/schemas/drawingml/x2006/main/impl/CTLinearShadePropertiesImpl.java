package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedAngle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLinearShadePropertiesImpl extends XmlComplexContentImpl implements CTLinearShadeProperties {
    private static final QName ANG$0 = new QName("", "ang");
    private static final QName SCALED$2 = new QName("", "scaled");

    public CTLinearShadePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public int getAng() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ANG$0);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public boolean getScaled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SCALED$2);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public boolean isSetAng() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANG$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public boolean isSetScaled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SCALED$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void setAng(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANG$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void setScaled(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALED$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void unsetAng() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANG$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void unsetScaled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SCALED$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public STPositiveFixedAngle xgetAng() {
        STPositiveFixedAngle sTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveFixedAngle = (STPositiveFixedAngle) get_store().find_attribute_user(ANG$0);
        }
        return sTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public XmlBoolean xgetScaled() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(SCALED$2);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void xsetAng(STPositiveFixedAngle sTPositiveFixedAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANG$0;
            STPositiveFixedAngle sTPositiveFixedAngle2 = (STPositiveFixedAngle) typeStore.find_attribute_user(qName);
            if (sTPositiveFixedAngle2 == null) {
                sTPositiveFixedAngle2 = (STPositiveFixedAngle) get_store().add_attribute_user(qName);
            }
            sTPositiveFixedAngle2.set(sTPositiveFixedAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void xsetScaled(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALED$2;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}

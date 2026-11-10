package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STAngle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGroupTransform2DImpl extends XmlComplexContentImpl implements CTGroupTransform2D {
    private static final QName OFF$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "off");
    private static final QName EXT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ext");
    private static final QName CHOFF$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "chOff");
    private static final QName CHEXT$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "chExt");
    private static final QName ROT$8 = new QName("", "rot");
    private static final QName FLIPH$10 = new QName("", "flipH");
    private static final QName FLIPV$12 = new QName("", "flipV");

    public CTGroupTransform2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPositiveSize2D addNewChExt() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().add_element_user(CHEXT$6);
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPoint2D addNewChOff() {
        CTPoint2D cTPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPoint2D = (CTPoint2D) get_store().add_element_user(CHOFF$4);
        }
        return cTPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPositiveSize2D addNewExt() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().add_element_user(EXT$2);
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPoint2D addNewOff() {
        CTPoint2D cTPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPoint2D = (CTPoint2D) get_store().add_element_user(OFF$0);
        }
        return cTPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPositiveSize2D getChExt() {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveSize2D cTPositiveSize2D = (CTPositiveSize2D) get_store().find_element_user(CHEXT$6, 0);
            if (cTPositiveSize2D == null) {
                return null;
            }
            return cTPositiveSize2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPoint2D getChOff() {
        synchronized (monitor()) {
            check_orphaned();
            CTPoint2D cTPoint2D = (CTPoint2D) get_store().find_element_user(CHOFF$4, 0);
            if (cTPoint2D == null) {
                return null;
            }
            return cTPoint2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPositiveSize2D getExt() {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveSize2D cTPositiveSize2D = (CTPositiveSize2D) get_store().find_element_user(EXT$2, 0);
            if (cTPositiveSize2D == null) {
                return null;
            }
            return cTPositiveSize2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean getFlipH() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPH$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean getFlipV() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPV$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public CTPoint2D getOff() {
        synchronized (monitor()) {
            check_orphaned();
            CTPoint2D cTPoint2D = (CTPoint2D) get_store().find_element_user(OFF$0, 0);
            if (cTPoint2D == null) {
                return null;
            }
            return cTPoint2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public int getRot() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROT$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetChExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHEXT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetChOff() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHOFF$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetFlipH() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLIPH$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetFlipV() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLIPV$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetOff() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OFF$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public boolean isSetRot() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROT$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setChExt(CTPositiveSize2D cTPositiveSize2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHEXT$6;
            CTPositiveSize2D cTPositiveSize2D2 = (CTPositiveSize2D) typeStore.find_element_user(qName, 0);
            if (cTPositiveSize2D2 == null) {
                cTPositiveSize2D2 = (CTPositiveSize2D) get_store().add_element_user(qName);
            }
            cTPositiveSize2D2.set(cTPositiveSize2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setChOff(CTPoint2D cTPoint2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHOFF$4;
            CTPoint2D cTPoint2D2 = (CTPoint2D) typeStore.find_element_user(qName, 0);
            if (cTPoint2D2 == null) {
                cTPoint2D2 = (CTPoint2D) get_store().add_element_user(qName);
            }
            cTPoint2D2.set(cTPoint2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setExt(CTPositiveSize2D cTPositiveSize2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$2;
            CTPositiveSize2D cTPositiveSize2D2 = (CTPositiveSize2D) typeStore.find_element_user(qName, 0);
            if (cTPositiveSize2D2 == null) {
                cTPositiveSize2D2 = (CTPositiveSize2D) get_store().add_element_user(qName);
            }
            cTPositiveSize2D2.set(cTPositiveSize2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setFlipH(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPH$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setFlipV(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPV$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setOff(CTPoint2D cTPoint2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OFF$0;
            CTPoint2D cTPoint2D2 = (CTPoint2D) typeStore.find_element_user(qName, 0);
            if (cTPoint2D2 == null) {
                cTPoint2D2 = (CTPoint2D) get_store().add_element_user(qName);
            }
            cTPoint2D2.set(cTPoint2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void setRot(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROT$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetChExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHEXT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetChOff() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOFF$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetFlipH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLIPH$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetFlipV() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLIPV$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetOff() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OFF$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void unsetRot() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROT$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public XmlBoolean xgetFlipH() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPH$10;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public XmlBoolean xgetFlipV() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPV$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public STAngle xgetRot() {
        STAngle sTAngle;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROT$8;
            sTAngle = (STAngle) typeStore.find_attribute_user(qName);
            if (sTAngle == null) {
                sTAngle = (STAngle) get_default_attribute_value(qName);
            }
        }
        return sTAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void xsetFlipH(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPH$10;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void xsetFlipV(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIPV$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D
    public void xsetRot(STAngle sTAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROT$8;
            STAngle sTAngle2 = (STAngle) typeStore.find_attribute_user(qName);
            if (sTAngle2 == null) {
                sTAngle2 = (STAngle) get_store().add_attribute_user(qName);
            }
            sTAngle2.set(sTAngle);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGeomRectImpl extends XmlComplexContentImpl implements CTGeomRect {
    private static final QName L$0 = new QName("", "l");
    private static final QName T$2 = new QName("", "t");
    private static final QName R$4 = new QName("", "r");
    private static final QName B$6 = new QName("", "b");

    public CTGeomRectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public Object getB() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(B$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public Object getL() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(L$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public Object getR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(R$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public Object getT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(T$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void setB(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void setL(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void setR(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void setT(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public STAdjCoordinate xgetB() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(B$6);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public STAdjCoordinate xgetL() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(L$0);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public STAdjCoordinate xgetR() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(R$4);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public STAdjCoordinate xgetT() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(T$2);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void xsetB(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
            if (sTAdjCoordinate2 == null) {
                sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
            }
            sTAdjCoordinate2.set(sTAdjCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void xsetL(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
            if (sTAdjCoordinate2 == null) {
                sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
            }
            sTAdjCoordinate2.set(sTAdjCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void xsetR(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$4;
            STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
            if (sTAdjCoordinate2 == null) {
                sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
            }
            sTAdjCoordinate2.set(sTAdjCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect
    public void xsetT(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
            if (sTAdjCoordinate2 == null) {
                sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
            }
            sTAdjCoordinate2.set(sTAdjCoordinate);
        }
    }
}

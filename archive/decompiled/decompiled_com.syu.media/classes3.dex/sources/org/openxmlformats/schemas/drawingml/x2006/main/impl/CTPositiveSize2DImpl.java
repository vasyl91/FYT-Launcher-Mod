package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPositiveSize2DImpl extends XmlComplexContentImpl implements CTPositiveSize2D {
    private static final QName CX$0 = new QName("", "cx");
    private static final QName CY$2 = new QName("", "cy");

    public CTPositiveSize2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public long getCx() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CX$0);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public long getCy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CY$2);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public void setCx(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CX$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public void setCy(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public STPositiveCoordinate xgetCx() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveCoordinate = (STPositiveCoordinate) get_store().find_attribute_user(CX$0);
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public STPositiveCoordinate xgetCy() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveCoordinate = (STPositiveCoordinate) get_store().find_attribute_user(CY$2);
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public void xsetCx(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CX$0;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D
    public void xsetCy(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$2;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }
}

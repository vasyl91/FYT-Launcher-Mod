package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STZoom$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTZoomImpl extends XmlComplexContentImpl implements CTZoom {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName PERCENT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "percent");

    public CTZoomImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public BigInteger getPercent() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PERCENT$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public STZoom$Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STZoom$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void setPercent(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void setVal(STZoom$Enum sTZoom$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTZoom$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public STDecimalNumber xgetPercent() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(PERCENT$2);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public STZoom xgetVal() {
        STZoom sTZoomFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTZoomFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTZoomFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void xsetPercent(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$2;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void xsetVal(STZoom sTZoom) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STZoom sTZoomFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTZoomFind_attribute_user == null) {
                sTZoomFind_attribute_user = (STZoom) get_store().add_attribute_user(qName);
            }
            sTZoomFind_attribute_user.set(sTZoom);
        }
    }
}

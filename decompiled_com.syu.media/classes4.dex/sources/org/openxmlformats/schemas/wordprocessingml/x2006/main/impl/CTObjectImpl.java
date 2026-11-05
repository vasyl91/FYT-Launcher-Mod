package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTControl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTObjectImpl extends CTPictureBaseImpl implements CTObject {
    private static final QName CONTROL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "control");
    private static final QName DXAORIG$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dxaOrig");
    private static final QName DYAORIG$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dyaOrig");

    public CTObjectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public CTControl addNewControl() {
        CTControl cTControlAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTControlAdd_element_user = get_store().add_element_user(CONTROL$0);
        }
        return cTControlAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public CTControl getControl() {
        synchronized (monitor()) {
            check_orphaned();
            CTControl cTControlFind_element_user = get_store().find_element_user(CONTROL$0, 0);
            if (cTControlFind_element_user == null) {
                return null;
            }
            return cTControlFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public BigInteger getDxaOrig() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DXAORIG$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public BigInteger getDyaOrig() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DYAORIG$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public boolean isSetControl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTROL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public boolean isSetDxaOrig() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DXAORIG$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public boolean isSetDyaOrig() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DYAORIG$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void setControl(CTControl cTControl) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTROL$0;
            CTControl cTControlFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTControlFind_element_user == null) {
                cTControlFind_element_user = (CTControl) get_store().add_element_user(qName);
            }
            cTControlFind_element_user.set(cTControl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void setDxaOrig(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXAORIG$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void setDyaOrig(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DYAORIG$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void unsetControl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTROL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void unsetDxaOrig() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DXAORIG$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void unsetDyaOrig() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DYAORIG$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public STTwipsMeasure xgetDxaOrig() {
        STTwipsMeasure sTTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasureFind_attribute_user = get_store().find_attribute_user(DXAORIG$2);
        }
        return sTTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public STTwipsMeasure xgetDyaOrig() {
        STTwipsMeasure sTTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasureFind_attribute_user = get_store().find_attribute_user(DYAORIG$4);
        }
        return sTTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void xsetDxaOrig(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXAORIG$2;
            STTwipsMeasure sTTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTwipsMeasureFind_attribute_user == null) {
                sTTwipsMeasureFind_attribute_user = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasureFind_attribute_user.set(sTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject
    public void xsetDyaOrig(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DYAORIG$4;
            STTwipsMeasure sTTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTwipsMeasureFind_attribute_user == null) {
                sTTwipsMeasureFind_attribute_user = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasureFind_attribute_user.set(sTTwipsMeasure);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblWidthImpl extends XmlComplexContentImpl implements CTTblWidth {
    private static final QName W$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
    private static final QName TYPE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");

    public CTTblWidthImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public STTblWidth.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTblWidth.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public BigInteger getW() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(W$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(W$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public void setType(STTblWidth.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public void setW(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(W$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public STTblWidth xgetType() {
        STTblWidth sTTblWidthFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTblWidthFind_attribute_user = get_store().find_attribute_user(TYPE$2);
        }
        return sTTblWidthFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public STDecimalNumber xgetW() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(W$0);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public void xsetType(STTblWidth sTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            STTblWidth sTTblWidthFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTblWidthFind_attribute_user == null) {
                sTTblWidthFind_attribute_user = (STTblWidth) get_store().add_attribute_user(qName);
            }
            sTTblWidthFind_attribute_user.set((XmlObject) sTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
    public void xsetW(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$0;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }
}

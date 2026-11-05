package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedHpsMeasure;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSignedHpsMeasureImpl extends XmlComplexContentImpl implements CTSignedHpsMeasure {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTSignedHpsMeasureImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public BigInteger getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public void setVal(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public STSignedHpsMeasure xgetVal() {
        STSignedHpsMeasure sTSignedHpsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedHpsMeasureFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTSignedHpsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public void xsetVal(STSignedHpsMeasure sTSignedHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STSignedHpsMeasure sTSignedHpsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSignedHpsMeasureFind_attribute_user == null) {
                sTSignedHpsMeasureFind_attribute_user = (STSignedHpsMeasure) get_store().add_attribute_user(qName);
            }
            sTSignedHpsMeasureFind_attribute_user.set(sTSignedHpsMeasure);
        }
    }
}

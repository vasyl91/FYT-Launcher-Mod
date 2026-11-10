package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTHeightImpl extends XmlComplexContentImpl implements CTHeight {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName HRULE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hRule");

    public CTHeightImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public STHeightRule$Enum getHRule() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRULE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STHeightRule$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public boolean isSetHRule() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRULE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void setHRule(STHeightRule$Enum sTHeightRule$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRULE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTHeightRule$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void unsetHRule() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRULE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public STHeightRule xgetHRule() {
        STHeightRule sTHeightRuleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHeightRuleFind_attribute_user = get_store().find_attribute_user(HRULE$2);
        }
        return sTHeightRuleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public STTwipsMeasure xgetVal() {
        STTwipsMeasure sTTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasureFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void xsetHRule(STHeightRule sTHeightRule) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRULE$2;
            STHeightRule sTHeightRuleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHeightRuleFind_attribute_user == null) {
                sTHeightRuleFind_attribute_user = (STHeightRule) get_store().add_attribute_user(qName);
            }
            sTHeightRuleFind_attribute_user.set(sTHeightRule);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void xsetVal(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTwipsMeasure sTTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTwipsMeasureFind_attribute_user == null) {
                sTTwipsMeasureFind_attribute_user = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasureFind_attribute_user.set(sTTwipsMeasure);
        }
    }
}

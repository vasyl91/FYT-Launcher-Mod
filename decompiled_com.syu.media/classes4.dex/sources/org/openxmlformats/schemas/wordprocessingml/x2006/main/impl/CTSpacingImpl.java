package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSpacingImpl extends XmlComplexContentImpl implements CTSpacing {
    private static final QName BEFORE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "before");
    private static final QName BEFORELINES$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "beforeLines");
    private static final QName BEFOREAUTOSPACING$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "beforeAutospacing");
    private static final QName AFTER$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "after");
    private static final QName AFTERLINES$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "afterLines");
    private static final QName AFTERAUTOSPACING$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "afterAutospacing");
    private static final QName LINE$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "line");
    private static final QName LINERULE$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lineRule");

    public CTSpacingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public BigInteger getAfter() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(AFTER$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STOnOff.Enum getAfterAutospacing() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(AFTERAUTOSPACING$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public BigInteger getAfterLines() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(AFTERLINES$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public BigInteger getBefore() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BEFORE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STOnOff.Enum getBeforeAutospacing() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BEFOREAUTOSPACING$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public BigInteger getBeforeLines() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BEFORELINES$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public BigInteger getLine() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LINE$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STLineSpacingRule.Enum getLineRule() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LINERULE$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STLineSpacingRule.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetAfter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AFTER$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetAfterAutospacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AFTERAUTOSPACING$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetAfterLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AFTERLINES$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetBefore() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BEFORE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetBeforeAutospacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BEFOREAUTOSPACING$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetBeforeLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BEFORELINES$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetLine() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINE$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public boolean isSetLineRule() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINERULE$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setAfter(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AFTER$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setAfterAutospacing(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AFTERAUTOSPACING$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setAfterLines(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AFTERLINES$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setBefore(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEFORE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setBeforeAutospacing(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEFOREAUTOSPACING$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setBeforeLines(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEFORELINES$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setLine(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINE$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void setLineRule(STLineSpacingRule.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINERULE$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetAfter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AFTER$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetAfterAutospacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AFTERAUTOSPACING$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetAfterLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AFTERLINES$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetBefore() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BEFORE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetBeforeAutospacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BEFOREAUTOSPACING$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetBeforeLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BEFORELINES$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetLine() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINE$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void unsetLineRule() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINERULE$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STTwipsMeasure xgetAfter() {
        STTwipsMeasure sTTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasureFind_attribute_user = get_store().find_attribute_user(AFTER$6);
        }
        return sTTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STOnOff xgetAfterAutospacing() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(AFTERAUTOSPACING$10);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STDecimalNumber xgetAfterLines() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(AFTERLINES$8);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STTwipsMeasure xgetBefore() {
        STTwipsMeasure sTTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasureFind_attribute_user = get_store().find_attribute_user(BEFORE$0);
        }
        return sTTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STOnOff xgetBeforeAutospacing() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(BEFOREAUTOSPACING$4);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STDecimalNumber xgetBeforeLines() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(BEFORELINES$2);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STSignedTwipsMeasure xgetLine() {
        STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedTwipsMeasureFind_attribute_user = get_store().find_attribute_user(LINE$12);
        }
        return sTSignedTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public STLineSpacingRule xgetLineRule() {
        STLineSpacingRule sTLineSpacingRuleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLineSpacingRuleFind_attribute_user = get_store().find_attribute_user(LINERULE$14);
        }
        return sTLineSpacingRuleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetAfter(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AFTER$6;
            STTwipsMeasure sTTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTwipsMeasureFind_attribute_user == null) {
                sTTwipsMeasureFind_attribute_user = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasureFind_attribute_user.set(sTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetAfterAutospacing(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AFTERAUTOSPACING$10;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetAfterLines(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AFTERLINES$8;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetBefore(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEFORE$0;
            STTwipsMeasure sTTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTwipsMeasureFind_attribute_user == null) {
                sTTwipsMeasureFind_attribute_user = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasureFind_attribute_user.set(sTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetBeforeAutospacing(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEFOREAUTOSPACING$4;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetBeforeLines(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEFORELINES$2;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetLine(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINE$12;
            STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSignedTwipsMeasureFind_attribute_user == null) {
                sTSignedTwipsMeasureFind_attribute_user = (STSignedTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTSignedTwipsMeasureFind_attribute_user.set(sTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
    public void xsetLineRule(STLineSpacingRule sTLineSpacingRule) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINERULE$14;
            STLineSpacingRule sTLineSpacingRuleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLineSpacingRuleFind_attribute_user == null) {
                sTLineSpacingRuleFind_attribute_user = (STLineSpacingRule) get_store().add_attribute_user(qName);
            }
            sTLineSpacingRuleFind_attribute_user.set((XmlObject) sTLineSpacingRule);
        }
    }
}

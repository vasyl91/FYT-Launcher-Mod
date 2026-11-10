package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTabStopImpl extends XmlComplexContentImpl implements CTTabStop {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName LEADER$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "leader");
    private static final QName POS$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pos");

    public CTTabStopImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public STTabTlc.Enum getLeader() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LEADER$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTabTlc.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public BigInteger getPos() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(POS$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public STTabJc.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTabJc.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public boolean isSetLeader() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LEADER$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void setLeader(STTabTlc.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEADER$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void setPos(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POS$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void setVal(STTabJc.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void unsetLeader() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LEADER$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public STTabTlc xgetLeader() {
        STTabTlc sTTabTlcFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTabTlcFind_attribute_user = get_store().find_attribute_user(LEADER$2);
        }
        return sTTabTlcFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public STSignedTwipsMeasure xgetPos() {
        STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedTwipsMeasureFind_attribute_user = get_store().find_attribute_user(POS$4);
        }
        return sTSignedTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public STTabJc xgetVal() {
        STTabJc sTTabJcFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTabJcFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTTabJcFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void xsetLeader(STTabTlc sTTabTlc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEADER$2;
            STTabTlc sTTabTlcFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTabTlcFind_attribute_user == null) {
                sTTabTlcFind_attribute_user = (STTabTlc) get_store().add_attribute_user(qName);
            }
            sTTabTlcFind_attribute_user.set((XmlObject) sTTabTlc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void xsetPos(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POS$4;
            STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSignedTwipsMeasureFind_attribute_user == null) {
                sTSignedTwipsMeasureFind_attribute_user = (STSignedTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTSignedTwipsMeasureFind_attribute_user.set(sTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop
    public void xsetVal(STTabJc sTTabJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTabJc sTTabJcFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTabJcFind_attribute_user == null) {
                sTTabJcFind_attribute_user = (STTabJc) get_store().add_attribute_user(qName);
            }
            sTTabJcFind_attribute_user.set((XmlObject) sTTabJc);
        }
    }
}

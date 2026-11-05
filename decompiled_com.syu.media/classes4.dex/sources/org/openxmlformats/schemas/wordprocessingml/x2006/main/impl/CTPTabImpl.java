package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabAlignment$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabLeader;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabLeader$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabRelativeTo;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabRelativeTo$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTPTabImpl extends XmlComplexContentImpl implements CTPTab {
    private static final QName ALIGNMENT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alignment");
    private static final QName RELATIVETO$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "relativeTo");
    private static final QName LEADER$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "leader");

    public CTPTabImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabAlignment$Enum getAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALIGNMENT$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPTabAlignment$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabLeader$Enum getLeader() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LEADER$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPTabLeader$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabRelativeTo$Enum getRelativeTo() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RELATIVETO$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPTabRelativeTo$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void setAlignment(STPTabAlignment$Enum sTPTabAlignment$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTPTabAlignment$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void setLeader(STPTabLeader$Enum sTPTabLeader$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEADER$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTPTabLeader$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void setRelativeTo(STPTabRelativeTo$Enum sTPTabRelativeTo$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELATIVETO$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTPTabRelativeTo$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabAlignment xgetAlignment() {
        STPTabAlignment sTPTabAlignmentFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPTabAlignmentFind_attribute_user = get_store().find_attribute_user(ALIGNMENT$0);
        }
        return sTPTabAlignmentFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabLeader xgetLeader() {
        STPTabLeader sTPTabLeaderFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPTabLeaderFind_attribute_user = get_store().find_attribute_user(LEADER$4);
        }
        return sTPTabLeaderFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabRelativeTo xgetRelativeTo() {
        STPTabRelativeTo sTPTabRelativeToFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPTabRelativeToFind_attribute_user = get_store().find_attribute_user(RELATIVETO$2);
        }
        return sTPTabRelativeToFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void xsetAlignment(STPTabAlignment sTPTabAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$0;
            STPTabAlignment sTPTabAlignmentFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPTabAlignmentFind_attribute_user == null) {
                sTPTabAlignmentFind_attribute_user = (STPTabAlignment) get_store().add_attribute_user(qName);
            }
            sTPTabAlignmentFind_attribute_user.set(sTPTabAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void xsetLeader(STPTabLeader sTPTabLeader) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEADER$4;
            STPTabLeader sTPTabLeaderFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPTabLeaderFind_attribute_user == null) {
                sTPTabLeaderFind_attribute_user = (STPTabLeader) get_store().add_attribute_user(qName);
            }
            sTPTabLeaderFind_attribute_user.set(sTPTabLeader);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void xsetRelativeTo(STPTabRelativeTo sTPTabRelativeTo) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELATIVETO$2;
            STPTabRelativeTo sTPTabRelativeToFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPTabRelativeToFind_attribute_user == null) {
                sTPTabRelativeToFind_attribute_user = (STPTabRelativeTo) get_store().add_attribute_user(qName);
            }
            sTPTabRelativeToFind_attribute_user.set(sTPTabRelativeTo);
        }
    }
}

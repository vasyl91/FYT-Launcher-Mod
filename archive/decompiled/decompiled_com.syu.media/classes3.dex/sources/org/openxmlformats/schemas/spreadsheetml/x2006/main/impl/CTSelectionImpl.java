package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSelectionImpl extends XmlComplexContentImpl implements CTSelection {
    private static final QName PANE$0 = new QName("", "pane");
    private static final QName ACTIVECELL$2 = new QName("", "activeCell");
    private static final QName ACTIVECELLID$4 = new QName("", "activeCellId");
    private static final QName SQREF$6 = new QName("", "sqref");

    public CTSelectionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public String getActiveCell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACTIVECELL$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public long getActiveCellId() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVECELLID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public STPane.Enum getPane() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PANE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPane.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public List getSqref() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getListValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public boolean isSetActiveCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ACTIVECELL$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public boolean isSetActiveCellId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ACTIVECELLID$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public boolean isSetPane() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PANE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public boolean isSetSqref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SQREF$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void setActiveCell(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVECELL$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void setActiveCellId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVECELLID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void setPane(STPane.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PANE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void setSqref(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setListValue(list);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void unsetActiveCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ACTIVECELL$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void unsetActiveCellId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ACTIVECELLID$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void unsetPane() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PANE$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void unsetSqref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SQREF$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public STCellRef xgetActiveCell() {
        STCellRef sTCellRef;
        synchronized (monitor()) {
            check_orphaned();
            sTCellRef = (STCellRef) get_store().find_attribute_user(ACTIVECELL$2);
        }
        return sTCellRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public XmlUnsignedInt xgetActiveCellId() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVECELLID$4;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public STPane xgetPane() {
        STPane sTPane;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PANE$0;
            sTPane = (STPane) typeStore.find_attribute_user(qName);
            if (sTPane == null) {
                sTPane = (STPane) get_default_attribute_value(qName);
            }
        }
        return sTPane;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public STSqref xgetSqref() {
        STSqref sTSqref;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$6;
            sTSqref = (STSqref) typeStore.find_attribute_user(qName);
            if (sTSqref == null) {
                sTSqref = (STSqref) get_default_attribute_value(qName);
            }
        }
        return sTSqref;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void xsetActiveCell(STCellRef sTCellRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVECELL$2;
            STCellRef sTCellRef2 = (STCellRef) typeStore.find_attribute_user(qName);
            if (sTCellRef2 == null) {
                sTCellRef2 = (STCellRef) get_store().add_attribute_user(qName);
            }
            sTCellRef2.set(sTCellRef);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void xsetActiveCellId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVECELLID$4;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void xsetPane(STPane sTPane) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PANE$0;
            STPane sTPane2 = (STPane) typeStore.find_attribute_user(qName);
            if (sTPane2 == null) {
                sTPane2 = (STPane) get_store().add_attribute_user(qName);
            }
            sTPane2.set((XmlObject) sTPane);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection
    public void xsetSqref(STSqref sTSqref) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SQREF$6;
            STSqref sTSqref2 = (STSqref) typeStore.find_attribute_user(qName);
            if (sTSqref2 == null) {
                sTSqref2 = (STSqref) get_store().add_attribute_user(qName);
            }
            sTSqref2.set((XmlObject) sTSqref);
        }
    }
}

package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPaneImpl extends XmlComplexContentImpl implements CTPane {
    private static final QName XSPLIT$0 = new QName("", "xSplit");
    private static final QName YSPLIT$2 = new QName("", "ySplit");
    private static final QName TOPLEFTCELL$4 = new QName("", "topLeftCell");
    private static final QName ACTIVEPANE$6 = new QName("", "activePane");
    private static final QName STATE$8 = new QName("", "state");

    public CTPaneImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public STPane.Enum getActivePane() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVEPANE$6;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public STPaneState.Enum getState() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPaneState.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public String getTopLeftCell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TOPLEFTCELL$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public double getXSplit() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSPLIT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public double getYSplit() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YSPLIT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public boolean isSetActivePane() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ACTIVEPANE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public boolean isSetState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STATE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public boolean isSetTopLeftCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOPLEFTCELL$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public boolean isSetXSplit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(XSPLIT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public boolean isSetYSplit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(YSPLIT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void setActivePane(STPane.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVEPANE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void setState(STPaneState.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void setTopLeftCell(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPLEFTCELL$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void setXSplit(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSPLIT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void setYSplit(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YSPLIT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void unsetActivePane() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ACTIVEPANE$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void unsetState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STATE$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void unsetTopLeftCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOPLEFTCELL$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void unsetXSplit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(XSPLIT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void unsetYSplit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(YSPLIT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public STPane xgetActivePane() {
        STPane sTPane;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVEPANE$6;
            sTPane = (STPane) typeStore.find_attribute_user(qName);
            if (sTPane == null) {
                sTPane = (STPane) get_default_attribute_value(qName);
            }
        }
        return sTPane;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public STPaneState xgetState() {
        STPaneState sTPaneState;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$8;
            sTPaneState = (STPaneState) typeStore.find_attribute_user(qName);
            if (sTPaneState == null) {
                sTPaneState = (STPaneState) get_default_attribute_value(qName);
            }
        }
        return sTPaneState;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public STCellRef xgetTopLeftCell() {
        STCellRef sTCellRef;
        synchronized (monitor()) {
            check_orphaned();
            sTCellRef = (STCellRef) get_store().find_attribute_user(TOPLEFTCELL$4);
        }
        return sTCellRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public XmlDouble xgetXSplit() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSPLIT$0;
            xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_default_attribute_value(qName);
            }
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public XmlDouble xgetYSplit() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YSPLIT$2;
            xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_default_attribute_value(qName);
            }
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void xsetActivePane(STPane sTPane) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVEPANE$6;
            STPane sTPane2 = (STPane) typeStore.find_attribute_user(qName);
            if (sTPane2 == null) {
                sTPane2 = (STPane) get_store().add_attribute_user(qName);
            }
            sTPane2.set((XmlObject) sTPane);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void xsetState(STPaneState sTPaneState) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$8;
            STPaneState sTPaneState2 = (STPaneState) typeStore.find_attribute_user(qName);
            if (sTPaneState2 == null) {
                sTPaneState2 = (STPaneState) get_store().add_attribute_user(qName);
            }
            sTPaneState2.set((XmlObject) sTPaneState);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void xsetTopLeftCell(STCellRef sTCellRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPLEFTCELL$4;
            STCellRef sTCellRef2 = (STCellRef) typeStore.find_attribute_user(qName);
            if (sTCellRef2 == null) {
                sTCellRef2 = (STCellRef) get_store().add_attribute_user(qName);
            }
            sTCellRef2.set(sTCellRef);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void xsetXSplit(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSPLIT$0;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane
    public void xsetYSplit(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YSPLIT$2;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }
}

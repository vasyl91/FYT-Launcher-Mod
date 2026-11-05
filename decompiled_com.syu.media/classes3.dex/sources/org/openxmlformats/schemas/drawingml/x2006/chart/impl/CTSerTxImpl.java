package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSerTxImpl extends XmlComplexContentImpl implements CTSerTx {
    private static final QName STRREF$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef");
    private static final QName V$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "v");

    public CTSerTxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public CTStrRef addNewStrRef() {
        CTStrRef cTStrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTStrRef = (CTStrRef) get_store().add_element_user(STRREF$0);
        }
        return cTStrRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public CTStrRef getStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrRef cTStrRef = (CTStrRef) get_store().find_element_user(STRREF$0, 0);
            if (cTStrRef == null) {
                return null;
            }
            return cTStrRef;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public String getV() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(V$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public boolean isSetStrRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRREF$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public boolean isSetV() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(V$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public void setStrRef(CTStrRef cTStrRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRREF$0;
            CTStrRef cTStrRef2 = (CTStrRef) typeStore.find_element_user(qName, 0);
            if (cTStrRef2 == null) {
                cTStrRef2 = (CTStrRef) get_store().add_element_user(qName);
            }
            cTStrRef2.set(cTStrRef);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public void setV(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = V$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public void unsetStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRREF$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public void unsetV() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(V$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public STXstring xgetV() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(V$2, 0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx
    public void xsetV(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = V$2;
            STXstring sTXstring2 = (STXstring) typeStore.find_element_user(qName, 0);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_element_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTxImpl extends XmlComplexContentImpl implements CTTx {
    private static final QName STRREF$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef");
    private static final QName RICH$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "rich");

    public CTTxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public CTTextBody addNewRich() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(RICH$2);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public CTStrRef addNewStrRef() {
        CTStrRef cTStrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTStrRef = (CTStrRef) get_store().add_element_user(STRREF$0);
        }
        return cTStrRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public CTTextBody getRich() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBody cTTextBody = (CTTextBody) get_store().find_element_user(RICH$2, 0);
            if (cTTextBody == null) {
                return null;
            }
            return cTTextBody;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public boolean isSetRich() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RICH$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public boolean isSetStrRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRREF$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public void setRich(CTTextBody cTTextBody) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RICH$2;
            CTTextBody cTTextBody2 = (CTTextBody) typeStore.find_element_user(qName, 0);
            if (cTTextBody2 == null) {
                cTTextBody2 = (CTTextBody) get_store().add_element_user(qName);
            }
            cTTextBody2.set(cTTextBody);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public void unsetRich() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RICH$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTx
    public void unsetStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRREF$0, 0);
        }
    }
}

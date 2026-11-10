package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTitleImpl extends XmlComplexContentImpl implements CTTitle {
    private static final QName TX$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx");
    private static final QName LAYOUT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout");
    private static final QName OVERLAY$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "overlay");
    private static final QName SPPR$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
    private static final QName TXPR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
    private static final QName EXTLST$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTTitleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$10);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTLayout addNewLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().add_element_user(LAYOUT$2);
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTBoolean addNewOverlay() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(OVERLAY$4);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$6);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTTx addNewTx() {
        CTTx cTTx;
        synchronized (monitor()) {
            check_orphaned();
            cTTx = (CTTx) get_store().add_element_user(TX$0);
        }
        return cTTx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXPR$8);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$10, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTLayout getLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTLayout cTLayout = (CTLayout) get_store().find_element_user(LAYOUT$2, 0);
            if (cTLayout == null) {
                return null;
            }
            return cTLayout;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTBoolean getOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(OVERLAY$4, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$6, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTTx getTx() {
        synchronized (monitor()) {
            check_orphaned();
            CTTx cTTx = (CTTx) get_store().find_element_user(TX$0, 0);
            if (cTTx == null) {
                return null;
            }
            return cTTx;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public CTTextBody getTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBody cTTextBody = (CTTextBody) get_store().find_element_user(TXPR$8, 0);
            if (cTTextBody == null) {
                return null;
            }
            return cTTextBody;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public boolean isSetLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LAYOUT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public boolean isSetOverlay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OVERLAY$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public boolean isSetTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TX$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXPR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$10;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void setLayout(CTLayout cTLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LAYOUT$2;
            CTLayout cTLayout2 = (CTLayout) typeStore.find_element_user(qName, 0);
            if (cTLayout2 == null) {
                cTLayout2 = (CTLayout) get_store().add_element_user(qName);
            }
            cTLayout2.set(cTLayout);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void setOverlay(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OVERLAY$4;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$6;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void setTx(CTTx cTTx) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TX$0;
            CTTx cTTx2 = (CTTx) typeStore.find_element_user(qName, 0);
            if (cTTx2 == null) {
                cTTx2 = (CTTx) get_store().add_element_user(qName);
            }
            cTTx2.set(cTTx);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void setTxPr(CTTextBody cTTextBody) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TXPR$8;
            CTTextBody cTTextBody2 = (CTTextBody) typeStore.find_element_user(qName, 0);
            if (cTTextBody2 == null) {
                cTTextBody2 = (CTTextBody) get_store().add_element_user(qName);
            }
            cTTextBody2.set(cTTextBody);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void unsetLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LAYOUT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void unsetOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVERLAY$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void unsetTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TX$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXPR$8, 0);
        }
    }
}

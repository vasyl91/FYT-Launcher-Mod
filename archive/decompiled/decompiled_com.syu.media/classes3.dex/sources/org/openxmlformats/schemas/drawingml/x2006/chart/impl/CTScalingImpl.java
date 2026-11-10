package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTScalingImpl extends XmlComplexContentImpl implements CTScaling {
    private static final QName LOGBASE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "logBase");
    private static final QName ORIENTATION$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "orientation");
    private static final QName MAX$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "max");
    private static final QName MIN$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "min");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTScalingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$8);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTLogBase addNewLogBase() {
        CTLogBase cTLogBase;
        synchronized (monitor()) {
            check_orphaned();
            cTLogBase = (CTLogBase) get_store().add_element_user(LOGBASE$0);
        }
        return cTLogBase;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTDouble addNewMax() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(MAX$4);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTDouble addNewMin() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(MIN$6);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTOrientation addNewOrientation() {
        CTOrientation cTOrientation;
        synchronized (monitor()) {
            check_orphaned();
            cTOrientation = (CTOrientation) get_store().add_element_user(ORIENTATION$2);
        }
        return cTOrientation;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$8, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTLogBase getLogBase() {
        synchronized (monitor()) {
            check_orphaned();
            CTLogBase cTLogBase = (CTLogBase) get_store().find_element_user(LOGBASE$0, 0);
            if (cTLogBase == null) {
                return null;
            }
            return cTLogBase;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTDouble getMax() {
        synchronized (monitor()) {
            check_orphaned();
            CTDouble cTDouble = (CTDouble) get_store().find_element_user(MAX$4, 0);
            if (cTDouble == null) {
                return null;
            }
            return cTDouble;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTDouble getMin() {
        synchronized (monitor()) {
            check_orphaned();
            CTDouble cTDouble = (CTDouble) get_store().find_element_user(MIN$6, 0);
            if (cTDouble == null) {
                return null;
            }
            return cTDouble;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public CTOrientation getOrientation() {
        synchronized (monitor()) {
            check_orphaned();
            CTOrientation cTOrientation = (CTOrientation) get_store().find_element_user(ORIENTATION$2, 0);
            if (cTOrientation == null) {
                return null;
            }
            return cTOrientation;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public boolean isSetLogBase() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LOGBASE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public boolean isSetMax() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAX$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public boolean isSetMin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MIN$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public boolean isSetOrientation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ORIENTATION$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$8;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void setLogBase(CTLogBase cTLogBase) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOGBASE$0;
            CTLogBase cTLogBase2 = (CTLogBase) typeStore.find_element_user(qName, 0);
            if (cTLogBase2 == null) {
                cTLogBase2 = (CTLogBase) get_store().add_element_user(qName);
            }
            cTLogBase2.set(cTLogBase);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void setMax(CTDouble cTDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAX$4;
            CTDouble cTDouble2 = (CTDouble) typeStore.find_element_user(qName, 0);
            if (cTDouble2 == null) {
                cTDouble2 = (CTDouble) get_store().add_element_user(qName);
            }
            cTDouble2.set(cTDouble);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void setMin(CTDouble cTDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIN$6;
            CTDouble cTDouble2 = (CTDouble) typeStore.find_element_user(qName, 0);
            if (cTDouble2 == null) {
                cTDouble2 = (CTDouble) get_store().add_element_user(qName);
            }
            cTDouble2.set(cTDouble);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void setOrientation(CTOrientation cTOrientation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENTATION$2;
            CTOrientation cTOrientation2 = (CTOrientation) typeStore.find_element_user(qName, 0);
            if (cTOrientation2 == null) {
                cTOrientation2 = (CTOrientation) get_store().add_element_user(qName);
            }
            cTOrientation2.set(cTOrientation);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void unsetLogBase() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOGBASE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void unsetMax() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAX$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void unsetMin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MIN$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling
    public void unsetOrientation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ORIENTATION$2, 0);
        }
    }
}

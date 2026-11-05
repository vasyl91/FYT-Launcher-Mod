package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMultiLvlStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTAxDataSourceImpl extends XmlComplexContentImpl implements CTAxDataSource {
    private static final QName MULTILVLSTRREF$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "multiLvlStrRef");
    private static final QName NUMREF$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numRef");
    private static final QName NUMLIT$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numLit");
    private static final QName STRREF$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef");
    private static final QName STRLIT$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "strLit");

    public CTAxDataSourceImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTMultiLvlStrRef addNewMultiLvlStrRef() {
        CTMultiLvlStrRef cTMultiLvlStrRefAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMultiLvlStrRefAdd_element_user = get_store().add_element_user(MULTILVLSTRREF$0);
        }
        return cTMultiLvlStrRefAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumData addNewNumLit() {
        CTNumData cTNumData;
        synchronized (monitor()) {
            check_orphaned();
            cTNumData = (CTNumData) get_store().add_element_user(NUMLIT$4);
        }
        return cTNumData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumRef addNewNumRef() {
        CTNumRef cTNumRef;
        synchronized (monitor()) {
            check_orphaned();
            cTNumRef = (CTNumRef) get_store().add_element_user(NUMREF$2);
        }
        return cTNumRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrData addNewStrLit() {
        CTStrData cTStrData;
        synchronized (monitor()) {
            check_orphaned();
            cTStrData = (CTStrData) get_store().add_element_user(STRLIT$8);
        }
        return cTStrData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrRef addNewStrRef() {
        CTStrRef cTStrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTStrRef = (CTStrRef) get_store().add_element_user(STRREF$6);
        }
        return cTStrRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTMultiLvlStrRef getMultiLvlStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTMultiLvlStrRef cTMultiLvlStrRefFind_element_user = get_store().find_element_user(MULTILVLSTRREF$0, 0);
            if (cTMultiLvlStrRefFind_element_user == null) {
                return null;
            }
            return cTMultiLvlStrRefFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumData getNumLit() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumData cTNumData = (CTNumData) get_store().find_element_user(NUMLIT$4, 0);
            if (cTNumData == null) {
                return null;
            }
            return cTNumData;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumRef getNumRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumRef cTNumRef = (CTNumRef) get_store().find_element_user(NUMREF$2, 0);
            if (cTNumRef == null) {
                return null;
            }
            return cTNumRef;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrData getStrLit() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrData cTStrData = (CTStrData) get_store().find_element_user(STRLIT$8, 0);
            if (cTStrData == null) {
                return null;
            }
            return cTStrData;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrRef getStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrRef cTStrRef = (CTStrRef) get_store().find_element_user(STRREF$6, 0);
            if (cTStrRef == null) {
                return null;
            }
            return cTStrRef;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetMultiLvlStrRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MULTILVLSTRREF$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetNumLit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMLIT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetNumRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMREF$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetStrLit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRLIT$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetStrRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRREF$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setMultiLvlStrRef(CTMultiLvlStrRef cTMultiLvlStrRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MULTILVLSTRREF$0;
            CTMultiLvlStrRef cTMultiLvlStrRefFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMultiLvlStrRefFind_element_user == null) {
                cTMultiLvlStrRefFind_element_user = (CTMultiLvlStrRef) get_store().add_element_user(qName);
            }
            cTMultiLvlStrRefFind_element_user.set(cTMultiLvlStrRef);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setNumLit(CTNumData cTNumData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMLIT$4;
            CTNumData cTNumData2 = (CTNumData) typeStore.find_element_user(qName, 0);
            if (cTNumData2 == null) {
                cTNumData2 = (CTNumData) get_store().add_element_user(qName);
            }
            cTNumData2.set(cTNumData);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setNumRef(CTNumRef cTNumRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMREF$2;
            CTNumRef cTNumRef2 = (CTNumRef) typeStore.find_element_user(qName, 0);
            if (cTNumRef2 == null) {
                cTNumRef2 = (CTNumRef) get_store().add_element_user(qName);
            }
            cTNumRef2.set(cTNumRef);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setStrLit(CTStrData cTStrData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRLIT$8;
            CTStrData cTStrData2 = (CTStrData) typeStore.find_element_user(qName, 0);
            if (cTStrData2 == null) {
                cTStrData2 = (CTStrData) get_store().add_element_user(qName);
            }
            cTStrData2.set(cTStrData);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setStrRef(CTStrRef cTStrRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRREF$6;
            CTStrRef cTStrRef2 = (CTStrRef) typeStore.find_element_user(qName, 0);
            if (cTStrRef2 == null) {
                cTStrRef2 = (CTStrRef) get_store().add_element_user(qName);
            }
            cTStrRef2.set(cTStrRef);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetMultiLvlStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MULTILVLSTRREF$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetNumLit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMLIT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetNumRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMREF$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetStrLit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRLIT$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRREF$6, 0);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTScatterChartImpl extends XmlComplexContentImpl implements CTScatterChart {
    private static final QName SCATTERSTYLE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "scatterStyle");
    private static final QName VARYCOLORS$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors");
    private static final QName SER$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser");
    private static final QName DLBLS$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
    private static final QName AXID$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId");
    private static final QName EXTLST$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTScatterChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(AXID$8);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLblsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblsAdd_element_user = get_store().add_element_user(DLBLS$6);
        }
        return cTDLblsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$10);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTScatterStyle addNewScatterStyle() {
        CTScatterStyle cTScatterStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterStyle = (CTScatterStyle) get_store().add_element_user(SCATTERSTYLE$0);
        }
        return cTScatterStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTScatterSer addNewSer() {
        CTScatterSer cTScatterSer;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterSer = (CTScatterSer) get_store().add_element_user(SER$4);
        }
        return cTScatterSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(VARYCOLORS$2);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTUnsignedInt getAxIdArray(int i) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(AXID$8, i);
            if (cTUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTUnsignedInt[] getAxIdArray() {
        CTUnsignedInt[] cTUnsignedIntArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AXID$8, arrayList);
            cTUnsignedIntArr = new CTUnsignedInt[arrayList.size()];
            arrayList.toArray(cTUnsignedIntArr);
        }
        return cTUnsignedIntArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public List<CTUnsignedInt> getAxIdList() {
        1AxIdList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AxIdList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTDLbls getDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            CTDLbls cTDLblsFind_element_user = get_store().find_element_user(DLBLS$6, 0);
            if (cTDLblsFind_element_user == null) {
                return null;
            }
            return cTDLblsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTScatterStyle getScatterStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTScatterStyle cTScatterStyle = (CTScatterStyle) get_store().find_element_user(SCATTERSTYLE$0, 0);
            if (cTScatterStyle == null) {
                return null;
            }
            return cTScatterStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTScatterSer getSerArray(int i) {
        CTScatterSer cTScatterSer;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterSer = (CTScatterSer) get_store().find_element_user(SER$4, i);
            if (cTScatterSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTScatterSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTScatterSer[] getSerArray() {
        CTScatterSer[] cTScatterSerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SER$4, arrayList);
            cTScatterSerArr = new CTScatterSer[arrayList.size()];
            arrayList.toArray(cTScatterSerArr);
        }
        return cTScatterSerArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public List<CTScatterSer> getSerList() {
        1SerList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SerList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTBoolean getVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(VARYCOLORS$2, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTUnsignedInt insertNewAxId(int i) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(AXID$8, i);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public CTScatterSer insertNewSer(int i) {
        CTScatterSer cTScatterSer;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterSer = (CTScatterSer) get_store().insert_element_user(SER$4, i);
        }
        return cTScatterSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DLBLS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VARYCOLORS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void removeAxId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AXID$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void removeSer(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SER$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setAxIdArray(int i, CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) get_store().find_element_user(AXID$8, i);
            if (cTUnsignedInt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTUnsignedIntArr, AXID$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setDLbls(CTDLbls cTDLbls) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DLBLS$6;
            CTDLbls cTDLblsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDLblsFind_element_user == null) {
                cTDLblsFind_element_user = (CTDLbls) get_store().add_element_user(qName);
            }
            cTDLblsFind_element_user.set(cTDLbls);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setScatterStyle(CTScatterStyle cTScatterStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCATTERSTYLE$0;
            CTScatterStyle cTScatterStyle2 = (CTScatterStyle) typeStore.find_element_user(qName, 0);
            if (cTScatterStyle2 == null) {
                cTScatterStyle2 = (CTScatterStyle) get_store().add_element_user(qName);
            }
            cTScatterStyle2.set(cTScatterStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setSerArray(int i, CTScatterSer cTScatterSer) {
        synchronized (monitor()) {
            check_orphaned();
            CTScatterSer cTScatterSer2 = (CTScatterSer) get_store().find_element_user(SER$4, i);
            if (cTScatterSer2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTScatterSer2.set(cTScatterSer);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setSerArray(CTScatterSer[] cTScatterSerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTScatterSerArr, SER$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void setVaryColors(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VARYCOLORS$2;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public int sizeOfAxIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AXID$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SER$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DLBLS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VARYCOLORS$2, 0);
        }
    }
}

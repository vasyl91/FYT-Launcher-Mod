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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPieChartImpl extends XmlComplexContentImpl implements CTPieChart {
    private static final QName VARYCOLORS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors");
    private static final QName SER$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser");
    private static final QName DLBLS$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
    private static final QName FIRSTSLICEANG$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "firstSliceAng");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTPieChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLblsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblsAdd_element_user = get_store().add_element_user(DLBLS$4);
        }
        return cTDLblsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$8);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTFirstSliceAng addNewFirstSliceAng() {
        CTFirstSliceAng cTFirstSliceAngAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFirstSliceAngAdd_element_user = get_store().add_element_user(FIRSTSLICEANG$6);
        }
        return cTFirstSliceAngAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTPieSer addNewSer() {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().add_element_user(SER$2);
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(VARYCOLORS$0);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTDLbls getDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            CTDLbls cTDLblsFind_element_user = get_store().find_element_user(DLBLS$4, 0);
            if (cTDLblsFind_element_user == null) {
                return null;
            }
            return cTDLblsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTFirstSliceAng getFirstSliceAng() {
        synchronized (monitor()) {
            check_orphaned();
            CTFirstSliceAng cTFirstSliceAngFind_element_user = get_store().find_element_user(FIRSTSLICEANG$6, 0);
            if (cTFirstSliceAngFind_element_user == null) {
                return null;
            }
            return cTFirstSliceAngFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTPieSer getSerArray(int i) {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().find_element_user(SER$2, i);
            if (cTPieSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTPieSer[] getSerArray() {
        CTPieSer[] cTPieSerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SER$2, arrayList);
            cTPieSerArr = new CTPieSer[arrayList.size()];
            arrayList.toArray(cTPieSerArr);
        }
        return cTPieSerArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public List<CTPieSer> getSerList() {
        1SerList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SerList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTBoolean getVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(VARYCOLORS$0, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public CTPieSer insertNewSer(int i) {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().insert_element_user(SER$2, i);
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DLBLS$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public boolean isSetFirstSliceAng() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FIRSTSLICEANG$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VARYCOLORS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void removeSer(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SER$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void setDLbls(CTDLbls cTDLbls) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DLBLS$4;
            CTDLbls cTDLblsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDLblsFind_element_user == null) {
                cTDLblsFind_element_user = (CTDLbls) get_store().add_element_user(qName);
            }
            cTDLblsFind_element_user.set(cTDLbls);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void setFirstSliceAng(CTFirstSliceAng cTFirstSliceAng) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSLICEANG$6;
            CTFirstSliceAng cTFirstSliceAngFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFirstSliceAngFind_element_user == null) {
                cTFirstSliceAngFind_element_user = (CTFirstSliceAng) get_store().add_element_user(qName);
            }
            cTFirstSliceAngFind_element_user.set(cTFirstSliceAng);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void setSerArray(int i, CTPieSer cTPieSer) {
        synchronized (monitor()) {
            check_orphaned();
            CTPieSer cTPieSer2 = (CTPieSer) get_store().find_element_user(SER$2, i);
            if (cTPieSer2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPieSer2.set(cTPieSer);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void setSerArray(CTPieSer[] cTPieSerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPieSerArr, SER$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void setVaryColors(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VARYCOLORS$0;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SER$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DLBLS$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void unsetFirstSliceAng() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIRSTSLICEANG$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VARYCOLORS$0, 0);
        }
    }
}

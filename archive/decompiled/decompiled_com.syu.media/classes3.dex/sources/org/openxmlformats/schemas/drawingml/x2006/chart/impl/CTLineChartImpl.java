package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTGrouping;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUpDownBars;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLineChartImpl extends XmlComplexContentImpl implements CTLineChart {
    private static final QName GROUPING$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "grouping");
    private static final QName VARYCOLORS$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors");
    private static final QName SER$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser");
    private static final QName DLBLS$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
    private static final QName DROPLINES$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dropLines");
    private static final QName HILOWLINES$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "hiLowLines");
    private static final QName UPDOWNBARS$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "upDownBars");
    private static final QName MARKER$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "marker");
    private static final QName SMOOTH$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "smooth");
    private static final QName AXID$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId");
    private static final QName EXTLST$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTLineChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(AXID$18);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLblsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblsAdd_element_user = get_store().add_element_user(DLBLS$6);
        }
        return cTDLblsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTChartLines addNewDropLines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(DROPLINES$8);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$20);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTGrouping addNewGrouping() {
        CTGrouping cTGroupingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupingAdd_element_user = get_store().add_element_user(GROUPING$0);
        }
        return cTGroupingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTChartLines addNewHiLowLines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(HILOWLINES$10);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTBoolean addNewMarker() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(MARKER$14);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTLineSer addNewSer() {
        CTLineSer cTLineSer;
        synchronized (monitor()) {
            check_orphaned();
            cTLineSer = (CTLineSer) get_store().add_element_user(SER$4);
        }
        return cTLineSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTBoolean addNewSmooth() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(SMOOTH$16);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTUpDownBars addNewUpDownBars() {
        CTUpDownBars cTUpDownBarsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUpDownBarsAdd_element_user = get_store().add_element_user(UPDOWNBARS$12);
        }
        return cTUpDownBarsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(VARYCOLORS$2);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTUnsignedInt getAxIdArray(int i) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(AXID$18, i);
            if (cTUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTUnsignedInt[] getAxIdArray() {
        CTUnsignedInt[] cTUnsignedIntArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AXID$18, arrayList);
            cTUnsignedIntArr = new CTUnsignedInt[arrayList.size()];
            arrayList.toArray(cTUnsignedIntArr);
        }
        return cTUnsignedIntArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public List<CTUnsignedInt> getAxIdList() {
        1AxIdList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AxIdList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTChartLines getDropLines() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartLines cTChartLinesFind_element_user = get_store().find_element_user(DROPLINES$8, 0);
            if (cTChartLinesFind_element_user == null) {
                return null;
            }
            return cTChartLinesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$20, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTGrouping getGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            CTGrouping cTGroupingFind_element_user = get_store().find_element_user(GROUPING$0, 0);
            if (cTGroupingFind_element_user == null) {
                return null;
            }
            return cTGroupingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTChartLines getHiLowLines() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartLines cTChartLinesFind_element_user = get_store().find_element_user(HILOWLINES$10, 0);
            if (cTChartLinesFind_element_user == null) {
                return null;
            }
            return cTChartLinesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTBoolean getMarker() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(MARKER$14, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTLineSer getSerArray(int i) {
        CTLineSer cTLineSer;
        synchronized (monitor()) {
            check_orphaned();
            cTLineSer = (CTLineSer) get_store().find_element_user(SER$4, i);
            if (cTLineSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLineSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTLineSer[] getSerArray() {
        CTLineSer[] cTLineSerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SER$4, arrayList);
            cTLineSerArr = new CTLineSer[arrayList.size()];
            arrayList.toArray(cTLineSerArr);
        }
        return cTLineSerArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public List<CTLineSer> getSerList() {
        1SerList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SerList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTBoolean getSmooth() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(SMOOTH$16, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTUpDownBars getUpDownBars() {
        synchronized (monitor()) {
            check_orphaned();
            CTUpDownBars cTUpDownBarsFind_element_user = get_store().find_element_user(UPDOWNBARS$12, 0);
            if (cTUpDownBarsFind_element_user == null) {
                return null;
            }
            return cTUpDownBarsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTUnsignedInt insertNewAxId(int i) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(AXID$18, i);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public CTLineSer insertNewSer(int i) {
        CTLineSer cTLineSer;
        synchronized (monitor()) {
            check_orphaned();
            cTLineSer = (CTLineSer) get_store().insert_element_user(SER$4, i);
        }
        return cTLineSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DLBLS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetDropLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DROPLINES$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetHiLowLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HILOWLINES$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetMarker() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MARKER$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetSmooth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMOOTH$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetUpDownBars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UPDOWNBARS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VARYCOLORS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void removeAxId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AXID$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void removeSer(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SER$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setAxIdArray(int i, CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) get_store().find_element_user(AXID$18, i);
            if (cTUnsignedInt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTUnsignedIntArr, AXID$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setDropLines(CTChartLines cTChartLines) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DROPLINES$8;
            CTChartLines cTChartLinesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTChartLinesFind_element_user == null) {
                cTChartLinesFind_element_user = (CTChartLines) get_store().add_element_user(qName);
            }
            cTChartLinesFind_element_user.set(cTChartLines);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$20;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setGrouping(CTGrouping cTGrouping) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUPING$0;
            CTGrouping cTGroupingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTGroupingFind_element_user == null) {
                cTGroupingFind_element_user = (CTGrouping) get_store().add_element_user(qName);
            }
            cTGroupingFind_element_user.set(cTGrouping);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setHiLowLines(CTChartLines cTChartLines) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HILOWLINES$10;
            CTChartLines cTChartLinesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTChartLinesFind_element_user == null) {
                cTChartLinesFind_element_user = (CTChartLines) get_store().add_element_user(qName);
            }
            cTChartLinesFind_element_user.set(cTChartLines);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setMarker(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARKER$14;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setSerArray(int i, CTLineSer cTLineSer) {
        synchronized (monitor()) {
            check_orphaned();
            CTLineSer cTLineSer2 = (CTLineSer) get_store().find_element_user(SER$4, i);
            if (cTLineSer2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLineSer2.set(cTLineSer);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setSerArray(CTLineSer[] cTLineSerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLineSerArr, SER$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setSmooth(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMOOTH$16;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void setUpDownBars(CTUpDownBars cTUpDownBars) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPDOWNBARS$12;
            CTUpDownBars cTUpDownBarsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTUpDownBarsFind_element_user == null) {
                cTUpDownBarsFind_element_user = (CTUpDownBars) get_store().add_element_user(qName);
            }
            cTUpDownBarsFind_element_user.set(cTUpDownBars);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public int sizeOfAxIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AXID$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SER$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DLBLS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetDropLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DROPLINES$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetHiLowLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HILOWLINES$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetMarker() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MARKER$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetSmooth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMOOTH$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetUpDownBars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UPDOWNBARS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VARYCOLORS$2, 0);
        }
    }
}

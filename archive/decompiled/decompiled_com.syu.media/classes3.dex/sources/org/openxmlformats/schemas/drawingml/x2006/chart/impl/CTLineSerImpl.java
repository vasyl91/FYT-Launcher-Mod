package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTrendline;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLineSerImpl extends XmlComplexContentImpl implements CTLineSer {
    private static final QName IDX$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "idx");
    private static final QName ORDER$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "order");
    private static final QName TX$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx");
    private static final QName SPPR$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
    private static final QName MARKER$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "marker");
    private static final QName DPT$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dPt");
    private static final QName DLBLS$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
    private static final QName TRENDLINE$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "trendline");
    private static final QName ERRBARS$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "errBars");
    private static final QName CAT$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "cat");
    private static final QName VAL$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "val");
    private static final QName SMOOTH$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "smooth");
    private static final QName EXTLST$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTLineSerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTAxDataSource addNewCat() {
        CTAxDataSource cTAxDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTAxDataSource = (CTAxDataSource) get_store().add_element_user(CAT$18);
        }
        return cTAxDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLblsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblsAdd_element_user = get_store().add_element_user(DLBLS$12);
        }
        return cTDLblsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTDPt addNewDPt() {
        CTDPt cTDPtAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDPtAdd_element_user = get_store().add_element_user(DPT$10);
        }
        return cTDPtAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTErrBars addNewErrBars() {
        CTErrBars cTErrBarsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrBarsAdd_element_user = get_store().add_element_user(ERRBARS$16);
        }
        return cTErrBarsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$24);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTUnsignedInt addNewIdx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(IDX$0);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTMarker addNewMarker() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().add_element_user(MARKER$8);
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTUnsignedInt addNewOrder() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(ORDER$2);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTBoolean addNewSmooth() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(SMOOTH$22);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$6);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTTrendline addNewTrendline() {
        CTTrendline cTTrendlineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineAdd_element_user = get_store().add_element_user(TRENDLINE$14);
        }
        return cTTrendlineAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTSerTx addNewTx() {
        CTSerTx cTSerTx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerTx = (CTSerTx) get_store().add_element_user(TX$4);
        }
        return cTSerTx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTNumDataSource addNewVal() {
        CTNumDataSource cTNumDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTNumDataSource = (CTNumDataSource) get_store().add_element_user(VAL$20);
        }
        return cTNumDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTAxDataSource getCat() {
        synchronized (monitor()) {
            check_orphaned();
            CTAxDataSource cTAxDataSource = (CTAxDataSource) get_store().find_element_user(CAT$18, 0);
            if (cTAxDataSource == null) {
                return null;
            }
            return cTAxDataSource;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTDLbls getDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            CTDLbls cTDLblsFind_element_user = get_store().find_element_user(DLBLS$12, 0);
            if (cTDLblsFind_element_user == null) {
                return null;
            }
            return cTDLblsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTDPt getDPtArray(int i) {
        CTDPt cTDPtFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDPtFind_element_user = get_store().find_element_user(DPT$10, i);
            if (cTDPtFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDPtFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTDPt[] getDPtArray() {
        CTDPt[] cTDPtArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DPT$10, arrayList);
            cTDPtArr = new CTDPt[arrayList.size()];
            arrayList.toArray(cTDPtArr);
        }
        return cTDPtArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public List<CTDPt> getDPtList() {
        1DPtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DPtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTErrBars getErrBars() {
        synchronized (monitor()) {
            check_orphaned();
            CTErrBars cTErrBarsFind_element_user = get_store().find_element_user(ERRBARS$16, 0);
            if (cTErrBarsFind_element_user == null) {
                return null;
            }
            return cTErrBarsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$24, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTUnsignedInt getIdx() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(IDX$0, 0);
            if (cTUnsignedInt == null) {
                return null;
            }
            return cTUnsignedInt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTMarker getMarker() {
        synchronized (monitor()) {
            check_orphaned();
            CTMarker cTMarker = (CTMarker) get_store().find_element_user(MARKER$8, 0);
            if (cTMarker == null) {
                return null;
            }
            return cTMarker;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTUnsignedInt getOrder() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(ORDER$2, 0);
            if (cTUnsignedInt == null) {
                return null;
            }
            return cTUnsignedInt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTBoolean getSmooth() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(SMOOTH$22, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTTrendline getTrendlineArray(int i) {
        CTTrendline cTTrendlineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineFind_element_user = get_store().find_element_user(TRENDLINE$14, i);
            if (cTTrendlineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrendlineFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTTrendline[] getTrendlineArray() {
        CTTrendline[] cTTrendlineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TRENDLINE$14, arrayList);
            cTTrendlineArr = new CTTrendline[arrayList.size()];
            arrayList.toArray(cTTrendlineArr);
        }
        return cTTrendlineArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public List<CTTrendline> getTrendlineList() {
        1TrendlineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TrendlineList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTSerTx getTx() {
        synchronized (monitor()) {
            check_orphaned();
            CTSerTx cTSerTx = (CTSerTx) get_store().find_element_user(TX$4, 0);
            if (cTSerTx == null) {
                return null;
            }
            return cTSerTx;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTNumDataSource getVal() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumDataSource cTNumDataSource = (CTNumDataSource) get_store().find_element_user(VAL$20, 0);
            if (cTNumDataSource == null) {
                return null;
            }
            return cTNumDataSource;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTDPt insertNewDPt(int i) {
        CTDPt cTDPtInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDPtInsert_element_user = get_store().insert_element_user(DPT$10, i);
        }
        return cTDPtInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public CTTrendline insertNewTrendline(int i) {
        CTTrendline cTTrendlineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineInsert_element_user = get_store().insert_element_user(TRENDLINE$14, i);
        }
        return cTTrendlineInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetCat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CAT$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DLBLS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetErrBars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ERRBARS$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetMarker() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MARKER$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetSmooth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMOOTH$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TX$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VAL$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void removeDPt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DPT$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void removeTrendline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRENDLINE$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setCat(CTAxDataSource cTAxDataSource) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAT$18;
            CTAxDataSource cTAxDataSource2 = (CTAxDataSource) typeStore.find_element_user(qName, 0);
            if (cTAxDataSource2 == null) {
                cTAxDataSource2 = (CTAxDataSource) get_store().add_element_user(qName);
            }
            cTAxDataSource2.set(cTAxDataSource);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setDLbls(CTDLbls cTDLbls) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DLBLS$12;
            CTDLbls cTDLblsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDLblsFind_element_user == null) {
                cTDLblsFind_element_user = (CTDLbls) get_store().add_element_user(qName);
            }
            cTDLblsFind_element_user.set(cTDLbls);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setDPtArray(int i, CTDPt cTDPt) {
        synchronized (monitor()) {
            check_orphaned();
            CTDPt cTDPtFind_element_user = get_store().find_element_user(DPT$10, i);
            if (cTDPtFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDPtFind_element_user.set(cTDPt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setDPtArray(CTDPt[] cTDPtArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDPtArr, DPT$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setErrBars(CTErrBars cTErrBars) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRBARS$16;
            CTErrBars cTErrBarsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTErrBarsFind_element_user == null) {
                cTErrBarsFind_element_user = (CTErrBars) get_store().add_element_user(qName);
            }
            cTErrBarsFind_element_user.set(cTErrBars);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$24;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setIdx(CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$0;
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) typeStore.find_element_user(qName, 0);
            if (cTUnsignedInt2 == null) {
                cTUnsignedInt2 = (CTUnsignedInt) get_store().add_element_user(qName);
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setMarker(CTMarker cTMarker) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARKER$8;
            CTMarker cTMarker2 = (CTMarker) typeStore.find_element_user(qName, 0);
            if (cTMarker2 == null) {
                cTMarker2 = (CTMarker) get_store().add_element_user(qName);
            }
            cTMarker2.set(cTMarker);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setOrder(CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORDER$2;
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) typeStore.find_element_user(qName, 0);
            if (cTUnsignedInt2 == null) {
                cTUnsignedInt2 = (CTUnsignedInt) get_store().add_element_user(qName);
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setSmooth(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMOOTH$22;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setTrendlineArray(int i, CTTrendline cTTrendline) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrendline cTTrendlineFind_element_user = get_store().find_element_user(TRENDLINE$14, i);
            if (cTTrendlineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrendlineFind_element_user.set(cTTrendline);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setTrendlineArray(CTTrendline[] cTTrendlineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTrendlineArr, TRENDLINE$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setTx(CTSerTx cTSerTx) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TX$4;
            CTSerTx cTSerTx2 = (CTSerTx) typeStore.find_element_user(qName, 0);
            if (cTSerTx2 == null) {
                cTSerTx2 = (CTSerTx) get_store().add_element_user(qName);
            }
            cTSerTx2.set(cTSerTx);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void setVal(CTNumDataSource cTNumDataSource) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$20;
            CTNumDataSource cTNumDataSource2 = (CTNumDataSource) typeStore.find_element_user(qName, 0);
            if (cTNumDataSource2 == null) {
                cTNumDataSource2 = (CTNumDataSource) get_store().add_element_user(qName);
            }
            cTNumDataSource2.set(cTNumDataSource);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public int sizeOfDPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DPT$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public int sizeOfTrendlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TRENDLINE$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetCat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CAT$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DLBLS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetErrBars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ERRBARS$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetMarker() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MARKER$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetSmooth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMOOTH$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TX$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VAL$20, 0);
        }
    }
}

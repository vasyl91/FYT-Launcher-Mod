package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDispBlanksAs;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPivotFmts;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTChartImpl extends XmlComplexContentImpl implements CTChart {
    private static final QName TITLE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "title");
    private static final QName AUTOTITLEDELETED$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "autoTitleDeleted");
    private static final QName PIVOTFMTS$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pivotFmts");
    private static final QName VIEW3D$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "view3D");
    private static final QName FLOOR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "floor");
    private static final QName SIDEWALL$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "sideWall");
    private static final QName BACKWALL$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "backWall");
    private static final QName PLOTAREA$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "plotArea");
    private static final QName LEGEND$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legend");
    private static final QName PLOTVISONLY$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "plotVisOnly");
    private static final QName DISPBLANKSAS$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dispBlanksAs");
    private static final QName SHOWDLBLSOVERMAX$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showDLblsOverMax");
    private static final QName EXTLST$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean addNewAutoTitleDeleted() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(AUTOTITLEDELETED$2);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface addNewBackWall() {
        CTSurface cTSurfaceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceAdd_element_user = get_store().add_element_user(BACKWALL$12);
        }
        return cTSurfaceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTDispBlanksAs addNewDispBlanksAs() {
        CTDispBlanksAs cTDispBlanksAsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDispBlanksAsAdd_element_user = get_store().add_element_user(DISPBLANKSAS$20);
        }
        return cTDispBlanksAsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$24);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface addNewFloor() {
        CTSurface cTSurfaceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceAdd_element_user = get_store().add_element_user(FLOOR$8);
        }
        return cTSurfaceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTLegend addNewLegend() {
        CTLegend cTLegend;
        synchronized (monitor()) {
            check_orphaned();
            cTLegend = (CTLegend) get_store().add_element_user(LEGEND$16);
        }
        return cTLegend;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPivotFmts addNewPivotFmts() {
        CTPivotFmts cTPivotFmtsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotFmtsAdd_element_user = get_store().add_element_user(PIVOTFMTS$4);
        }
        return cTPivotFmtsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPlotArea addNewPlotArea() {
        CTPlotArea cTPlotArea;
        synchronized (monitor()) {
            check_orphaned();
            cTPlotArea = (CTPlotArea) get_store().add_element_user(PLOTAREA$14);
        }
        return cTPlotArea;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean addNewPlotVisOnly() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PLOTVISONLY$18);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean addNewShowDLblsOverMax() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(SHOWDLBLSOVERMAX$22);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface addNewSideWall() {
        CTSurface cTSurfaceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceAdd_element_user = get_store().add_element_user(SIDEWALL$10);
        }
        return cTSurfaceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTTitle addNewTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().add_element_user(TITLE$0);
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTView3D addNewView3D() {
        CTView3D cTView3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTView3DAdd_element_user = get_store().add_element_user(VIEW3D$6);
        }
        return cTView3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean getAutoTitleDeleted() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(AUTOTITLEDELETED$2, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface getBackWall() {
        synchronized (monitor()) {
            check_orphaned();
            CTSurface cTSurfaceFind_element_user = get_store().find_element_user(BACKWALL$12, 0);
            if (cTSurfaceFind_element_user == null) {
                return null;
            }
            return cTSurfaceFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTDispBlanksAs getDispBlanksAs() {
        synchronized (monitor()) {
            check_orphaned();
            CTDispBlanksAs cTDispBlanksAsFind_element_user = get_store().find_element_user(DISPBLANKSAS$20, 0);
            if (cTDispBlanksAsFind_element_user == null) {
                return null;
            }
            return cTDispBlanksAsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface getFloor() {
        synchronized (monitor()) {
            check_orphaned();
            CTSurface cTSurfaceFind_element_user = get_store().find_element_user(FLOOR$8, 0);
            if (cTSurfaceFind_element_user == null) {
                return null;
            }
            return cTSurfaceFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTLegend getLegend() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegend cTLegend = (CTLegend) get_store().find_element_user(LEGEND$16, 0);
            if (cTLegend == null) {
                return null;
            }
            return cTLegend;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPivotFmts getPivotFmts() {
        synchronized (monitor()) {
            check_orphaned();
            CTPivotFmts cTPivotFmtsFind_element_user = get_store().find_element_user(PIVOTFMTS$4, 0);
            if (cTPivotFmtsFind_element_user == null) {
                return null;
            }
            return cTPivotFmtsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPlotArea getPlotArea() {
        synchronized (monitor()) {
            check_orphaned();
            CTPlotArea cTPlotArea = (CTPlotArea) get_store().find_element_user(PLOTAREA$14, 0);
            if (cTPlotArea == null) {
                return null;
            }
            return cTPlotArea;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean getPlotVisOnly() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(PLOTVISONLY$18, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean getShowDLblsOverMax() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(SHOWDLBLSOVERMAX$22, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface getSideWall() {
        synchronized (monitor()) {
            check_orphaned();
            CTSurface cTSurfaceFind_element_user = get_store().find_element_user(SIDEWALL$10, 0);
            if (cTSurfaceFind_element_user == null) {
                return null;
            }
            return cTSurfaceFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTTitle getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTitle cTTitle = (CTTitle) get_store().find_element_user(TITLE$0, 0);
            if (cTTitle == null) {
                return null;
            }
            return cTTitle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTView3D getView3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTView3D cTView3DFind_element_user = get_store().find_element_user(VIEW3D$6, 0);
            if (cTView3DFind_element_user == null) {
                return null;
            }
            return cTView3DFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetAutoTitleDeleted() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOTITLEDELETED$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetBackWall() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BACKWALL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetDispBlanksAs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DISPBLANKSAS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetFloor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FLOOR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetLegend() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGEND$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetPivotFmts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PIVOTFMTS$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetPlotVisOnly() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PLOTVISONLY$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetShowDLblsOverMax() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHOWDLBLSOVERMAX$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetSideWall() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIDEWALL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetView3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VIEW3D$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setAutoTitleDeleted(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOTITLEDELETED$2;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setBackWall(CTSurface cTSurface) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKWALL$12;
            CTSurface cTSurfaceFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSurfaceFind_element_user == null) {
                cTSurfaceFind_element_user = (CTSurface) get_store().add_element_user(qName);
            }
            cTSurfaceFind_element_user.set(cTSurface);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setDispBlanksAs(CTDispBlanksAs cTDispBlanksAs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISPBLANKSAS$20;
            CTDispBlanksAs cTDispBlanksAsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDispBlanksAsFind_element_user == null) {
                cTDispBlanksAsFind_element_user = (CTDispBlanksAs) get_store().add_element_user(qName);
            }
            cTDispBlanksAsFind_element_user.set(cTDispBlanksAs);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setFloor(CTSurface cTSurface) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOOR$8;
            CTSurface cTSurfaceFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSurfaceFind_element_user == null) {
                cTSurfaceFind_element_user = (CTSurface) get_store().add_element_user(qName);
            }
            cTSurfaceFind_element_user.set(cTSurface);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setLegend(CTLegend cTLegend) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGEND$16;
            CTLegend cTLegend2 = (CTLegend) typeStore.find_element_user(qName, 0);
            if (cTLegend2 == null) {
                cTLegend2 = (CTLegend) get_store().add_element_user(qName);
            }
            cTLegend2.set(cTLegend);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setPivotFmts(CTPivotFmts cTPivotFmts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOTFMTS$4;
            CTPivotFmts cTPivotFmtsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPivotFmtsFind_element_user == null) {
                cTPivotFmtsFind_element_user = (CTPivotFmts) get_store().add_element_user(qName);
            }
            cTPivotFmtsFind_element_user.set(cTPivotFmts);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setPlotArea(CTPlotArea cTPlotArea) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PLOTAREA$14;
            CTPlotArea cTPlotArea2 = (CTPlotArea) typeStore.find_element_user(qName, 0);
            if (cTPlotArea2 == null) {
                cTPlotArea2 = (CTPlotArea) get_store().add_element_user(qName);
            }
            cTPlotArea2.set(cTPlotArea);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setPlotVisOnly(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PLOTVISONLY$18;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setShowDLblsOverMax(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWDLBLSOVERMAX$22;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setSideWall(CTSurface cTSurface) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIDEWALL$10;
            CTSurface cTSurfaceFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSurfaceFind_element_user == null) {
                cTSurfaceFind_element_user = (CTSurface) get_store().add_element_user(qName);
            }
            cTSurfaceFind_element_user.set(cTSurface);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setTitle(CTTitle cTTitle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$0;
            CTTitle cTTitle2 = (CTTitle) typeStore.find_element_user(qName, 0);
            if (cTTitle2 == null) {
                cTTitle2 = (CTTitle) get_store().add_element_user(qName);
            }
            cTTitle2.set(cTTitle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setView3D(CTView3D cTView3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEW3D$6;
            CTView3D cTView3DFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTView3DFind_element_user == null) {
                cTView3DFind_element_user = (CTView3D) get_store().add_element_user(qName);
            }
            cTView3DFind_element_user.set(cTView3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetAutoTitleDeleted() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOTITLEDELETED$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetBackWall() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BACKWALL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetDispBlanksAs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISPBLANKSAS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetFloor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLOOR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetLegend() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGEND$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetPivotFmts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIVOTFMTS$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetPlotVisOnly() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PLOTVISONLY$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetShowDLblsOverMax() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHOWDLBLSOVERMAX$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetSideWall() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIDEWALL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetView3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VIEW3D$6, 0);
        }
    }
}

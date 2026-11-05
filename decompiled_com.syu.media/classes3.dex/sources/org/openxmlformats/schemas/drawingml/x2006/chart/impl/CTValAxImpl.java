package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxisUnit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDispUnits;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTValAxImpl extends XmlComplexContentImpl implements CTValAx {
    private static final QName AXID$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId");
    private static final QName SCALING$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "scaling");
    private static final QName DELETE$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "delete");
    private static final QName AXPOS$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axPos");
    private static final QName MAJORGRIDLINES$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorGridlines");
    private static final QName MINORGRIDLINES$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorGridlines");
    private static final QName TITLE$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "title");
    private static final QName NUMFMT$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numFmt");
    private static final QName MAJORTICKMARK$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorTickMark");
    private static final QName MINORTICKMARK$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorTickMark");
    private static final QName TICKLBLPOS$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickLblPos");
    private static final QName SPPR$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
    private static final QName TXPR$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
    private static final QName CROSSAX$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossAx");
    private static final QName CROSSES$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crosses");
    private static final QName CROSSESAT$30 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossesAt");
    private static final QName CROSSBETWEEN$32 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossBetween");
    private static final QName MAJORUNIT$34 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorUnit");
    private static final QName MINORUNIT$36 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorUnit");
    private static final QName DISPUNITS$38 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dispUnits");
    private static final QName EXTLST$40 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTValAxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(AXID$0);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTAxPos addNewAxPos() {
        CTAxPos cTAxPos;
        synchronized (monitor()) {
            check_orphaned();
            cTAxPos = (CTAxPos) get_store().add_element_user(AXPOS$6);
        }
        return cTAxPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTUnsignedInt addNewCrossAx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(CROSSAX$26);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTCrossBetween addNewCrossBetween() {
        CTCrossBetween cTCrossBetween;
        synchronized (monitor()) {
            check_orphaned();
            cTCrossBetween = (CTCrossBetween) get_store().add_element_user(CROSSBETWEEN$32);
        }
        return cTCrossBetween;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTCrosses addNewCrosses() {
        CTCrosses cTCrosses;
        synchronized (monitor()) {
            check_orphaned();
            cTCrosses = (CTCrosses) get_store().add_element_user(CROSSES$28);
        }
        return cTCrosses;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTDouble addNewCrossesAt() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(CROSSESAT$30);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTBoolean addNewDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(DELETE$4);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTDispUnits addNewDispUnits() {
        CTDispUnits cTDispUnitsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDispUnitsAdd_element_user = get_store().add_element_user(DISPUNITS$38);
        }
        return cTDispUnitsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$40);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTChartLines addNewMajorGridlines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(MAJORGRIDLINES$8);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTickMark addNewMajorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(MAJORTICKMARK$16);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTAxisUnit addNewMajorUnit() {
        CTAxisUnit cTAxisUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnitAdd_element_user = get_store().add_element_user(MAJORUNIT$34);
        }
        return cTAxisUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTChartLines addNewMinorGridlines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(MINORGRIDLINES$10);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTickMark addNewMinorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(MINORTICKMARK$18);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTAxisUnit addNewMinorUnit() {
        CTAxisUnit cTAxisUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnitAdd_element_user = get_store().add_element_user(MINORUNIT$36);
        }
        return cTAxisUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$14);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTScaling addNewScaling() {
        CTScaling cTScaling;
        synchronized (monitor()) {
            check_orphaned();
            cTScaling = (CTScaling) get_store().add_element_user(SCALING$2);
        }
        return cTScaling;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$22);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTickLblPos addNewTickLblPos() {
        CTTickLblPos cTTickLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTTickLblPos = (CTTickLblPos) get_store().add_element_user(TICKLBLPOS$20);
        }
        return cTTickLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTitle addNewTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().add_element_user(TITLE$12);
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXPR$24);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTUnsignedInt getAxId() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(AXID$0, 0);
            if (cTUnsignedInt == null) {
                return null;
            }
            return cTUnsignedInt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTAxPos getAxPos() {
        synchronized (monitor()) {
            check_orphaned();
            CTAxPos cTAxPos = (CTAxPos) get_store().find_element_user(AXPOS$6, 0);
            if (cTAxPos == null) {
                return null;
            }
            return cTAxPos;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTUnsignedInt getCrossAx() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(CROSSAX$26, 0);
            if (cTUnsignedInt == null) {
                return null;
            }
            return cTUnsignedInt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTCrossBetween getCrossBetween() {
        synchronized (monitor()) {
            check_orphaned();
            CTCrossBetween cTCrossBetween = (CTCrossBetween) get_store().find_element_user(CROSSBETWEEN$32, 0);
            if (cTCrossBetween == null) {
                return null;
            }
            return cTCrossBetween;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTCrosses getCrosses() {
        synchronized (monitor()) {
            check_orphaned();
            CTCrosses cTCrosses = (CTCrosses) get_store().find_element_user(CROSSES$28, 0);
            if (cTCrosses == null) {
                return null;
            }
            return cTCrosses;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTDouble getCrossesAt() {
        synchronized (monitor()) {
            check_orphaned();
            CTDouble cTDouble = (CTDouble) get_store().find_element_user(CROSSESAT$30, 0);
            if (cTDouble == null) {
                return null;
            }
            return cTDouble;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTBoolean getDelete() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(DELETE$4, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTDispUnits getDispUnits() {
        synchronized (monitor()) {
            check_orphaned();
            CTDispUnits cTDispUnitsFind_element_user = get_store().find_element_user(DISPUNITS$38, 0);
            if (cTDispUnitsFind_element_user == null) {
                return null;
            }
            return cTDispUnitsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$40, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTChartLines getMajorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartLines cTChartLinesFind_element_user = get_store().find_element_user(MAJORGRIDLINES$8, 0);
            if (cTChartLinesFind_element_user == null) {
                return null;
            }
            return cTChartLinesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTickMark getMajorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            CTTickMark cTTickMark = (CTTickMark) get_store().find_element_user(MAJORTICKMARK$16, 0);
            if (cTTickMark == null) {
                return null;
            }
            return cTTickMark;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTAxisUnit getMajorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTAxisUnit cTAxisUnitFind_element_user = get_store().find_element_user(MAJORUNIT$34, 0);
            if (cTAxisUnitFind_element_user == null) {
                return null;
            }
            return cTAxisUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTChartLines getMinorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartLines cTChartLinesFind_element_user = get_store().find_element_user(MINORGRIDLINES$10, 0);
            if (cTChartLinesFind_element_user == null) {
                return null;
            }
            return cTChartLinesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTickMark getMinorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            CTTickMark cTTickMark = (CTTickMark) get_store().find_element_user(MINORTICKMARK$18, 0);
            if (cTTickMark == null) {
                return null;
            }
            return cTTickMark;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTAxisUnit getMinorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTAxisUnit cTAxisUnitFind_element_user = get_store().find_element_user(MINORUNIT$36, 0);
            if (cTAxisUnitFind_element_user == null) {
                return null;
            }
            return cTAxisUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTNumFmt getNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmt cTNumFmt = (CTNumFmt) get_store().find_element_user(NUMFMT$14, 0);
            if (cTNumFmt == null) {
                return null;
            }
            return cTNumFmt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTScaling getScaling() {
        synchronized (monitor()) {
            check_orphaned();
            CTScaling cTScaling = (CTScaling) get_store().find_element_user(SCALING$2, 0);
            if (cTScaling == null) {
                return null;
            }
            return cTScaling;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$22, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTickLblPos getTickLblPos() {
        synchronized (monitor()) {
            check_orphaned();
            CTTickLblPos cTTickLblPos = (CTTickLblPos) get_store().find_element_user(TICKLBLPOS$20, 0);
            if (cTTickLblPos == null) {
                return null;
            }
            return cTTickLblPos;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTitle getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTitle cTTitle = (CTTitle) get_store().find_element_user(TITLE$12, 0);
            if (cTTitle == null) {
                return null;
            }
            return cTTitle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public CTTextBody getTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBody cTTextBody = (CTTextBody) get_store().find_element_user(TXPR$24, 0);
            if (cTTextBody == null) {
                return null;
            }
            return cTTextBody;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetCrossBetween() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSBETWEEN$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetCrosses() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSES$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetCrossesAt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSESAT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetDelete() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DELETE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetDispUnits() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DISPUNITS$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetMajorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORGRIDLINES$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetMajorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORTICKMARK$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetMajorUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORUNIT$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetMinorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORGRIDLINES$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetMinorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORTICKMARK$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetMinorUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORUNIT$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMT$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetTickLblPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TICKLBLPOS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLE$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXPR$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setAxId(CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AXID$0;
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) typeStore.find_element_user(qName, 0);
            if (cTUnsignedInt2 == null) {
                cTUnsignedInt2 = (CTUnsignedInt) get_store().add_element_user(qName);
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setAxPos(CTAxPos cTAxPos) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AXPOS$6;
            CTAxPos cTAxPos2 = (CTAxPos) typeStore.find_element_user(qName, 0);
            if (cTAxPos2 == null) {
                cTAxPos2 = (CTAxPos) get_store().add_element_user(qName);
            }
            cTAxPos2.set(cTAxPos);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setCrossAx(CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROSSAX$26;
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) typeStore.find_element_user(qName, 0);
            if (cTUnsignedInt2 == null) {
                cTUnsignedInt2 = (CTUnsignedInt) get_store().add_element_user(qName);
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setCrossBetween(CTCrossBetween cTCrossBetween) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROSSBETWEEN$32;
            CTCrossBetween cTCrossBetween2 = (CTCrossBetween) typeStore.find_element_user(qName, 0);
            if (cTCrossBetween2 == null) {
                cTCrossBetween2 = (CTCrossBetween) get_store().add_element_user(qName);
            }
            cTCrossBetween2.set(cTCrossBetween);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setCrosses(CTCrosses cTCrosses) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROSSES$28;
            CTCrosses cTCrosses2 = (CTCrosses) typeStore.find_element_user(qName, 0);
            if (cTCrosses2 == null) {
                cTCrosses2 = (CTCrosses) get_store().add_element_user(qName);
            }
            cTCrosses2.set(cTCrosses);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setCrossesAt(CTDouble cTDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROSSESAT$30;
            CTDouble cTDouble2 = (CTDouble) typeStore.find_element_user(qName, 0);
            if (cTDouble2 == null) {
                cTDouble2 = (CTDouble) get_store().add_element_user(qName);
            }
            cTDouble2.set(cTDouble);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setDelete(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELETE$4;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setDispUnits(CTDispUnits cTDispUnits) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISPUNITS$38;
            CTDispUnits cTDispUnitsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDispUnitsFind_element_user == null) {
                cTDispUnitsFind_element_user = (CTDispUnits) get_store().add_element_user(qName);
            }
            cTDispUnitsFind_element_user.set(cTDispUnits);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$40;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setMajorGridlines(CTChartLines cTChartLines) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAJORGRIDLINES$8;
            CTChartLines cTChartLinesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTChartLinesFind_element_user == null) {
                cTChartLinesFind_element_user = (CTChartLines) get_store().add_element_user(qName);
            }
            cTChartLinesFind_element_user.set(cTChartLines);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setMajorTickMark(CTTickMark cTTickMark) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAJORTICKMARK$16;
            CTTickMark cTTickMark2 = (CTTickMark) typeStore.find_element_user(qName, 0);
            if (cTTickMark2 == null) {
                cTTickMark2 = (CTTickMark) get_store().add_element_user(qName);
            }
            cTTickMark2.set(cTTickMark);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setMajorUnit(CTAxisUnit cTAxisUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAJORUNIT$34;
            CTAxisUnit cTAxisUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTAxisUnitFind_element_user == null) {
                cTAxisUnitFind_element_user = (CTAxisUnit) get_store().add_element_user(qName);
            }
            cTAxisUnitFind_element_user.set(cTAxisUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setMinorGridlines(CTChartLines cTChartLines) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINORGRIDLINES$10;
            CTChartLines cTChartLinesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTChartLinesFind_element_user == null) {
                cTChartLinesFind_element_user = (CTChartLines) get_store().add_element_user(qName);
            }
            cTChartLinesFind_element_user.set(cTChartLines);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setMinorTickMark(CTTickMark cTTickMark) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINORTICKMARK$18;
            CTTickMark cTTickMark2 = (CTTickMark) typeStore.find_element_user(qName, 0);
            if (cTTickMark2 == null) {
                cTTickMark2 = (CTTickMark) get_store().add_element_user(qName);
            }
            cTTickMark2.set(cTTickMark);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setMinorUnit(CTAxisUnit cTAxisUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINORUNIT$36;
            CTAxisUnit cTAxisUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTAxisUnitFind_element_user == null) {
                cTAxisUnitFind_element_user = (CTAxisUnit) get_store().add_element_user(qName);
            }
            cTAxisUnitFind_element_user.set(cTAxisUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setNumFmt(CTNumFmt cTNumFmt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMT$14;
            CTNumFmt cTNumFmt2 = (CTNumFmt) typeStore.find_element_user(qName, 0);
            if (cTNumFmt2 == null) {
                cTNumFmt2 = (CTNumFmt) get_store().add_element_user(qName);
            }
            cTNumFmt2.set(cTNumFmt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setScaling(CTScaling cTScaling) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALING$2;
            CTScaling cTScaling2 = (CTScaling) typeStore.find_element_user(qName, 0);
            if (cTScaling2 == null) {
                cTScaling2 = (CTScaling) get_store().add_element_user(qName);
            }
            cTScaling2.set(cTScaling);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$22;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setTickLblPos(CTTickLblPos cTTickLblPos) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TICKLBLPOS$20;
            CTTickLblPos cTTickLblPos2 = (CTTickLblPos) typeStore.find_element_user(qName, 0);
            if (cTTickLblPos2 == null) {
                cTTickLblPos2 = (CTTickLblPos) get_store().add_element_user(qName);
            }
            cTTickLblPos2.set(cTTickLblPos);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setTitle(CTTitle cTTitle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$12;
            CTTitle cTTitle2 = (CTTitle) typeStore.find_element_user(qName, 0);
            if (cTTitle2 == null) {
                cTTitle2 = (CTTitle) get_store().add_element_user(qName);
            }
            cTTitle2.set(cTTitle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void setTxPr(CTTextBody cTTextBody) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TXPR$24;
            CTTextBody cTTextBody2 = (CTTextBody) typeStore.find_element_user(qName, 0);
            if (cTTextBody2 == null) {
                cTTextBody2 = (CTTextBody) get_store().add_element_user(qName);
            }
            cTTextBody2.set(cTTextBody);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetCrossBetween() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSBETWEEN$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetCrosses() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSES$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetCrossesAt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSESAT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetDelete() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELETE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetDispUnits() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISPUNITS$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetMajorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORGRIDLINES$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetMajorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORTICKMARK$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetMajorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORUNIT$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetMinorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORGRIDLINES$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetMinorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORTICKMARK$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetMinorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORUNIT$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetTickLblPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TICKLBLPOS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLE$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXPR$24, 0);
        }
    }
}

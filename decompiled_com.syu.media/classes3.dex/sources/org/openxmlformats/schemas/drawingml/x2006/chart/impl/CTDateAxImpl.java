package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxisUnit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblOffset;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTimeUnit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDateAxImpl extends XmlComplexContentImpl implements CTDateAx {
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
    private static final QName AUTO$32 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "auto");
    private static final QName LBLOFFSET$34 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "lblOffset");
    private static final QName BASETIMEUNIT$36 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "baseTimeUnit");
    private static final QName MAJORUNIT$38 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorUnit");
    private static final QName MAJORTIMEUNIT$40 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorTimeUnit");
    private static final QName MINORUNIT$42 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorUnit");
    private static final QName MINORTIMEUNIT$44 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorTimeUnit");
    private static final QName EXTLST$46 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTDateAxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean addNewAuto() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(AUTO$32);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(AXID$0);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxPos addNewAxPos() {
        CTAxPos cTAxPos;
        synchronized (monitor()) {
            check_orphaned();
            cTAxPos = (CTAxPos) get_store().add_element_user(AXPOS$6);
        }
        return cTAxPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit addNewBaseTimeUnit() {
        CTTimeUnit cTTimeUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitAdd_element_user = get_store().add_element_user(BASETIMEUNIT$36);
        }
        return cTTimeUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTUnsignedInt addNewCrossAx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(CROSSAX$26);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTCrosses addNewCrosses() {
        CTCrosses cTCrosses;
        synchronized (monitor()) {
            check_orphaned();
            cTCrosses = (CTCrosses) get_store().add_element_user(CROSSES$28);
        }
        return cTCrosses;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTDouble addNewCrossesAt() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(CROSSESAT$30);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean addNewDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(DELETE$4);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$46);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTLblOffset addNewLblOffset() {
        CTLblOffset cTLblOffsetAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLblOffsetAdd_element_user = get_store().add_element_user(LBLOFFSET$34);
        }
        return cTLblOffsetAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTChartLines addNewMajorGridlines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(MAJORGRIDLINES$8);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickMark addNewMajorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(MAJORTICKMARK$16);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit addNewMajorTimeUnit() {
        CTTimeUnit cTTimeUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitAdd_element_user = get_store().add_element_user(MAJORTIMEUNIT$40);
        }
        return cTTimeUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit addNewMajorUnit() {
        CTAxisUnit cTAxisUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnitAdd_element_user = get_store().add_element_user(MAJORUNIT$38);
        }
        return cTAxisUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTChartLines addNewMinorGridlines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(MINORGRIDLINES$10);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickMark addNewMinorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(MINORTICKMARK$18);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit addNewMinorTimeUnit() {
        CTTimeUnit cTTimeUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitAdd_element_user = get_store().add_element_user(MINORTIMEUNIT$44);
        }
        return cTTimeUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit addNewMinorUnit() {
        CTAxisUnit cTAxisUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnitAdd_element_user = get_store().add_element_user(MINORUNIT$42);
        }
        return cTAxisUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$14);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTScaling addNewScaling() {
        CTScaling cTScaling;
        synchronized (monitor()) {
            check_orphaned();
            cTScaling = (CTScaling) get_store().add_element_user(SCALING$2);
        }
        return cTScaling;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$22);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickLblPos addNewTickLblPos() {
        CTTickLblPos cTTickLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTTickLblPos = (CTTickLblPos) get_store().add_element_user(TICKLBLPOS$20);
        }
        return cTTickLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTitle addNewTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().add_element_user(TITLE$12);
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXPR$24);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean getAuto() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(AUTO$32, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit getBaseTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTTimeUnit cTTimeUnitFind_element_user = get_store().find_element_user(BASETIMEUNIT$36, 0);
            if (cTTimeUnitFind_element_user == null) {
                return null;
            }
            return cTTimeUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$46, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTLblOffset getLblOffset() {
        synchronized (monitor()) {
            check_orphaned();
            CTLblOffset cTLblOffsetFind_element_user = get_store().find_element_user(LBLOFFSET$34, 0);
            if (cTLblOffsetFind_element_user == null) {
                return null;
            }
            return cTLblOffsetFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit getMajorTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTTimeUnit cTTimeUnitFind_element_user = get_store().find_element_user(MAJORTIMEUNIT$40, 0);
            if (cTTimeUnitFind_element_user == null) {
                return null;
            }
            return cTTimeUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit getMajorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTAxisUnit cTAxisUnitFind_element_user = get_store().find_element_user(MAJORUNIT$38, 0);
            if (cTAxisUnitFind_element_user == null) {
                return null;
            }
            return cTAxisUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit getMinorTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTTimeUnit cTTimeUnitFind_element_user = get_store().find_element_user(MINORTIMEUNIT$44, 0);
            if (cTTimeUnitFind_element_user == null) {
                return null;
            }
            return cTTimeUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit getMinorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            CTAxisUnit cTAxisUnitFind_element_user = get_store().find_element_user(MINORUNIT$42, 0);
            if (cTAxisUnitFind_element_user == null) {
                return null;
            }
            return cTAxisUnitFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetAuto() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTO$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetBaseTimeUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BASETIMEUNIT$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetCrosses() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSES$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetCrossesAt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSESAT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetDelete() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DELETE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetLblOffset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LBLOFFSET$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORGRIDLINES$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORTICKMARK$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorTimeUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORTIMEUNIT$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORUNIT$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORGRIDLINES$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORTICKMARK$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorTimeUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORTIMEUNIT$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORUNIT$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMT$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetTickLblPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TICKLBLPOS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLE$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXPR$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setAuto(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTO$32;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setBaseTimeUnit(CTTimeUnit cTTimeUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASETIMEUNIT$36;
            CTTimeUnit cTTimeUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTimeUnitFind_element_user == null) {
                cTTimeUnitFind_element_user = (CTTimeUnit) get_store().add_element_user(qName);
            }
            cTTimeUnitFind_element_user.set(cTTimeUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$46;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setLblOffset(CTLblOffset cTLblOffset) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LBLOFFSET$34;
            CTLblOffset cTLblOffsetFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLblOffsetFind_element_user == null) {
                cTLblOffsetFind_element_user = (CTLblOffset) get_store().add_element_user(qName);
            }
            cTLblOffsetFind_element_user.set(cTLblOffset);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMajorTimeUnit(CTTimeUnit cTTimeUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAJORTIMEUNIT$40;
            CTTimeUnit cTTimeUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTimeUnitFind_element_user == null) {
                cTTimeUnitFind_element_user = (CTTimeUnit) get_store().add_element_user(qName);
            }
            cTTimeUnitFind_element_user.set(cTTimeUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMajorUnit(CTAxisUnit cTAxisUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAJORUNIT$38;
            CTAxisUnit cTAxisUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTAxisUnitFind_element_user == null) {
                cTAxisUnitFind_element_user = (CTAxisUnit) get_store().add_element_user(qName);
            }
            cTAxisUnitFind_element_user.set(cTAxisUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMinorTimeUnit(CTTimeUnit cTTimeUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINORTIMEUNIT$44;
            CTTimeUnit cTTimeUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTimeUnitFind_element_user == null) {
                cTTimeUnitFind_element_user = (CTTimeUnit) get_store().add_element_user(qName);
            }
            cTTimeUnitFind_element_user.set(cTTimeUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMinorUnit(CTAxisUnit cTAxisUnit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINORUNIT$42;
            CTAxisUnit cTAxisUnitFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTAxisUnitFind_element_user == null) {
                cTAxisUnitFind_element_user = (CTAxisUnit) get_store().add_element_user(qName);
            }
            cTAxisUnitFind_element_user.set(cTAxisUnit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetAuto() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTO$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetBaseTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BASETIMEUNIT$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetCrosses() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSES$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetCrossesAt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSESAT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetDelete() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELETE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetLblOffset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LBLOFFSET$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORGRIDLINES$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORTICKMARK$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORTIMEUNIT$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORUNIT$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORGRIDLINES$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORTICKMARK$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORTIMEUNIT$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORUNIT$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetTickLblPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TICKLBLPOS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLE$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXPR$24, 0);
        }
    }
}

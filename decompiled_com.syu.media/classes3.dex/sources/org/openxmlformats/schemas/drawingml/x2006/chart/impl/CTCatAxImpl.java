package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblOffset;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSkip;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCatAxImpl extends XmlComplexContentImpl implements CTCatAx {
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
    private static final QName LBLALGN$34 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "lblAlgn");
    private static final QName LBLOFFSET$36 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "lblOffset");
    private static final QName TICKLBLSKIP$38 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickLblSkip");
    private static final QName TICKMARKSKIP$40 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickMarkSkip");
    private static final QName NOMULTILVLLBL$42 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "noMultiLvlLbl");
    private static final QName EXTLST$44 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTCatAxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTBoolean addNewAuto() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(AUTO$32);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(AXID$0);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTAxPos addNewAxPos() {
        CTAxPos cTAxPos;
        synchronized (monitor()) {
            check_orphaned();
            cTAxPos = (CTAxPos) get_store().add_element_user(AXPOS$6);
        }
        return cTAxPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTUnsignedInt addNewCrossAx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(CROSSAX$26);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTCrosses addNewCrosses() {
        CTCrosses cTCrosses;
        synchronized (monitor()) {
            check_orphaned();
            cTCrosses = (CTCrosses) get_store().add_element_user(CROSSES$28);
        }
        return cTCrosses;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTDouble addNewCrossesAt() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(CROSSESAT$30);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTBoolean addNewDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(DELETE$4);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$44);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTLblAlgn addNewLblAlgn() {
        CTLblAlgn cTLblAlgnAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLblAlgnAdd_element_user = get_store().add_element_user(LBLALGN$34);
        }
        return cTLblAlgnAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTLblOffset addNewLblOffset() {
        CTLblOffset cTLblOffsetAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLblOffsetAdd_element_user = get_store().add_element_user(LBLOFFSET$36);
        }
        return cTLblOffsetAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTChartLines addNewMajorGridlines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(MAJORGRIDLINES$8);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTTickMark addNewMajorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(MAJORTICKMARK$16);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTChartLines addNewMinorGridlines() {
        CTChartLines cTChartLinesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLinesAdd_element_user = get_store().add_element_user(MINORGRIDLINES$10);
        }
        return cTChartLinesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTTickMark addNewMinorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(MINORTICKMARK$18);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTBoolean addNewNoMultiLvlLbl() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(NOMULTILVLLBL$42);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$14);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTScaling addNewScaling() {
        CTScaling cTScaling;
        synchronized (monitor()) {
            check_orphaned();
            cTScaling = (CTScaling) get_store().add_element_user(SCALING$2);
        }
        return cTScaling;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$22);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTTickLblPos addNewTickLblPos() {
        CTTickLblPos cTTickLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTTickLblPos = (CTTickLblPos) get_store().add_element_user(TICKLBLPOS$20);
        }
        return cTTickLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTSkip addNewTickLblSkip() {
        CTSkip cTSkipAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkipAdd_element_user = get_store().add_element_user(TICKLBLSKIP$38);
        }
        return cTSkipAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTSkip addNewTickMarkSkip() {
        CTSkip cTSkipAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkipAdd_element_user = get_store().add_element_user(TICKMARKSKIP$40);
        }
        return cTSkipAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTTitle addNewTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().add_element_user(TITLE$12);
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXPR$24);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$44, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTLblAlgn getLblAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            CTLblAlgn cTLblAlgnFind_element_user = get_store().find_element_user(LBLALGN$34, 0);
            if (cTLblAlgnFind_element_user == null) {
                return null;
            }
            return cTLblAlgnFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTLblOffset getLblOffset() {
        synchronized (monitor()) {
            check_orphaned();
            CTLblOffset cTLblOffsetFind_element_user = get_store().find_element_user(LBLOFFSET$36, 0);
            if (cTLblOffsetFind_element_user == null) {
                return null;
            }
            return cTLblOffsetFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTBoolean getNoMultiLvlLbl() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(NOMULTILVLLBL$42, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTSkip getTickLblSkip() {
        synchronized (monitor()) {
            check_orphaned();
            CTSkip cTSkipFind_element_user = get_store().find_element_user(TICKLBLSKIP$38, 0);
            if (cTSkipFind_element_user == null) {
                return null;
            }
            return cTSkipFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public CTSkip getTickMarkSkip() {
        synchronized (monitor()) {
            check_orphaned();
            CTSkip cTSkipFind_element_user = get_store().find_element_user(TICKMARKSKIP$40, 0);
            if (cTSkipFind_element_user == null) {
                return null;
            }
            return cTSkipFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetAuto() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTO$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetCrosses() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSES$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetCrossesAt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CROSSESAT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetDelete() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DELETE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetLblAlgn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LBLALGN$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetLblOffset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LBLOFFSET$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetMajorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORGRIDLINES$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetMajorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAJORTICKMARK$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetMinorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORGRIDLINES$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetMinorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MINORTICKMARK$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetNoMultiLvlLbl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOMULTILVLLBL$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMT$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetTickLblPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TICKLBLPOS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetTickLblSkip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TICKLBLSKIP$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetTickMarkSkip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TICKMARKSKIP$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLE$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXPR$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$44;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void setLblAlgn(CTLblAlgn cTLblAlgn) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LBLALGN$34;
            CTLblAlgn cTLblAlgnFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLblAlgnFind_element_user == null) {
                cTLblAlgnFind_element_user = (CTLblAlgn) get_store().add_element_user(qName);
            }
            cTLblAlgnFind_element_user.set(cTLblAlgn);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void setLblOffset(CTLblOffset cTLblOffset) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LBLOFFSET$36;
            CTLblOffset cTLblOffsetFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLblOffsetFind_element_user == null) {
                cTLblOffsetFind_element_user = (CTLblOffset) get_store().add_element_user(qName);
            }
            cTLblOffsetFind_element_user.set(cTLblOffset);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void setNoMultiLvlLbl(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOMULTILVLLBL$42;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void setTickLblSkip(CTSkip cTSkip) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TICKLBLSKIP$38;
            CTSkip cTSkipFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSkipFind_element_user == null) {
                cTSkipFind_element_user = (CTSkip) get_store().add_element_user(qName);
            }
            cTSkipFind_element_user.set(cTSkip);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void setTickMarkSkip(CTSkip cTSkip) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TICKMARKSKIP$40;
            CTSkip cTSkipFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSkipFind_element_user == null) {
                cTSkipFind_element_user = (CTSkip) get_store().add_element_user(qName);
            }
            cTSkipFind_element_user.set(cTSkip);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetAuto() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTO$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetCrosses() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSES$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetCrossesAt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CROSSESAT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetDelete() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELETE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetLblAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LBLALGN$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetLblOffset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LBLOFFSET$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetMajorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORGRIDLINES$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetMajorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAJORTICKMARK$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetMinorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORGRIDLINES$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetMinorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINORTICKMARK$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetNoMultiLvlLbl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOMULTILVLLBL$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetTickLblPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TICKLBLPOS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetTickLblSkip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TICKLBLSKIP$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetTickMarkSkip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TICKMARKSKIP$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLE$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXPR$24, 0);
        }
    }
}

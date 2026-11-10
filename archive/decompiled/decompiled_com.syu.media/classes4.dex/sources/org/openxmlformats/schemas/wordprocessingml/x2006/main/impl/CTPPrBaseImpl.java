package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFramePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextboxTightWrap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTPPrBaseImpl extends XmlComplexContentImpl implements CTPPrBase {
    private static final QName PSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pStyle");
    private static final QName KEEPNEXT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "keepNext");
    private static final QName KEEPLINES$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "keepLines");
    private static final QName PAGEBREAKBEFORE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pageBreakBefore");
    private static final QName FRAMEPR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "framePr");
    private static final QName WIDOWCONTROL$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "widowControl");
    private static final QName NUMPR$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPr");
    private static final QName SUPPRESSLINENUMBERS$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressLineNumbers");
    private static final QName PBDR$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pBdr");
    private static final QName SHD$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName TABS$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tabs");
    private static final QName SUPPRESSAUTOHYPHENS$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressAutoHyphens");
    private static final QName KINSOKU$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kinsoku");
    private static final QName WORDWRAP$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wordWrap");
    private static final QName OVERFLOWPUNCT$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "overflowPunct");
    private static final QName TOPLINEPUNCT$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "topLinePunct");
    private static final QName AUTOSPACEDE$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoSpaceDE");
    private static final QName AUTOSPACEDN$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoSpaceDN");
    private static final QName BIDI$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");
    private static final QName ADJUSTRIGHTIND$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "adjustRightInd");
    private static final QName SNAPTOGRID$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
    private static final QName SPACING$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
    private static final QName IND$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ind");
    private static final QName CONTEXTUALSPACING$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "contextualSpacing");
    private static final QName MIRRORINDENTS$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mirrorIndents");
    private static final QName SUPPRESSOVERLAP$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressOverlap");
    private static final QName JC$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
    private static final QName TEXTDIRECTION$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
    private static final QName TEXTALIGNMENT$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textAlignment");
    private static final QName TEXTBOXTIGHTWRAP$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textboxTightWrap");
    private static final QName OUTLINELVL$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outlineLvl");
    private static final QName DIVID$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId");
    private static final QName CNFSTYLE$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");

    public CTPPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewAdjustRightInd() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ADJUSTRIGHTIND$38);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewAutoSpaceDE() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(AUTOSPACEDE$32);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewAutoSpaceDN() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(AUTOSPACEDN$34);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewBidi() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BIDI$36);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf cTCnfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCnfAdd_element_user = get_store().add_element_user(CNFSTYLE$64);
        }
        return cTCnfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewContextualSpacing() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(CONTEXTUALSPACING$46);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber addNewDivId() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(DIVID$62);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTFramePr addNewFramePr() {
        CTFramePr cTFramePrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFramePrAdd_element_user = get_store().add_element_user(FRAMEPR$8);
        }
        return cTFramePrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTInd addNewInd() {
        CTInd cTIndAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTIndAdd_element_user = get_store().add_element_user(IND$44);
        }
        return cTIndAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTJc addNewJc() {
        CTJc cTJcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTJcAdd_element_user = get_store().add_element_user(JC$52);
        }
        return cTJcAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewKeepLines() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(KEEPLINES$4);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewKeepNext() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(KEEPNEXT$2);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewKinsoku() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(KINSOKU$24);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewMirrorIndents() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(MIRRORINDENTS$48);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTNumPr addNewNumPr() {
        CTNumPr cTNumPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPrAdd_element_user = get_store().add_element_user(NUMPR$12);
        }
        return cTNumPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber addNewOutlineLvl() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(OUTLINELVL$60);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewOverflowPunct() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(OVERFLOWPUNCT$28);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTPBdr addNewPBdr() {
        CTPBdr cTPBdrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPBdrAdd_element_user = get_store().add_element_user(PBDR$16);
        }
        return cTPBdrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTString addNewPStyle() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(PSTYLE$0);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewPageBreakBefore() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(PAGEBREAKBEFORE$6);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTShd addNewShd() {
        CTShd cTShdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShdAdd_element_user = get_store().add_element_user(SHD$18);
        }
        return cTShdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSnapToGrid() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SNAPTOGRID$40);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTSpacing addNewSpacing() {
        CTSpacing cTSpacingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSpacingAdd_element_user = get_store().add_element_user(SPACING$42);
        }
        return cTSpacingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSuppressAutoHyphens() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SUPPRESSAUTOHYPHENS$22);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSuppressLineNumbers() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SUPPRESSLINENUMBERS$14);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSuppressOverlap() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SUPPRESSOVERLAP$50);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTabs addNewTabs() {
        CTTabs cTTabsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTabsAdd_element_user = get_store().add_element_user(TABS$20);
        }
        return cTTabsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextAlignment addNewTextAlignment() {
        CTTextAlignment cTTextAlignmentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAlignmentAdd_element_user = get_store().add_element_user(TEXTALIGNMENT$56);
        }
        return cTTextAlignmentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextDirection addNewTextDirection() {
        CTTextDirection cTTextDirectionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirectionAdd_element_user = get_store().add_element_user(TEXTDIRECTION$54);
        }
        return cTTextDirectionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextboxTightWrap addNewTextboxTightWrap() {
        CTTextboxTightWrap cTTextboxTightWrapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxTightWrapAdd_element_user = get_store().add_element_user(TEXTBOXTIGHTWRAP$58);
        }
        return cTTextboxTightWrapAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewTopLinePunct() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(TOPLINEPUNCT$30);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewWidowControl() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(WIDOWCONTROL$10);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewWordWrap() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(WORDWRAP$26);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getAdjustRightInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ADJUSTRIGHTIND$38, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getAutoSpaceDE() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(AUTOSPACEDE$32, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getAutoSpaceDN() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(AUTOSPACEDN$34, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getBidi() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BIDI$36, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTCnf getCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTCnf cTCnfFind_element_user = get_store().find_element_user(CNFSTYLE$64, 0);
            if (cTCnfFind_element_user == null) {
                return null;
            }
            return cTCnfFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getContextualSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(CONTEXTUALSPACING$46, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber getDivId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(DIVID$62, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTFramePr getFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTFramePr cTFramePrFind_element_user = get_store().find_element_user(FRAMEPR$8, 0);
            if (cTFramePrFind_element_user == null) {
                return null;
            }
            return cTFramePrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTInd getInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTInd cTIndFind_element_user = get_store().find_element_user(IND$44, 0);
            if (cTIndFind_element_user == null) {
                return null;
            }
            return cTIndFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTJc getJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJcFind_element_user = get_store().find_element_user(JC$52, 0);
            if (cTJcFind_element_user == null) {
                return null;
            }
            return cTJcFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getKeepLines() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(KEEPLINES$4, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getKeepNext() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(KEEPNEXT$2, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(KINSOKU$24, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getMirrorIndents() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(MIRRORINDENTS$48, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTNumPr getNumPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumPr cTNumPrFind_element_user = get_store().find_element_user(NUMPR$12, 0);
            if (cTNumPrFind_element_user == null) {
                return null;
            }
            return cTNumPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber getOutlineLvl() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(OUTLINELVL$60, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getOverflowPunct() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(OVERFLOWPUNCT$28, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTPBdr getPBdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPBdr cTPBdrFind_element_user = get_store().find_element_user(PBDR$16, 0);
            if (cTPBdrFind_element_user == null) {
                return null;
            }
            return cTPBdrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTString getPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(PSTYLE$0, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getPageBreakBefore() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(PAGEBREAKBEFORE$6, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShdFind_element_user = get_store().find_element_user(SHD$18, 0);
            if (cTShdFind_element_user == null) {
                return null;
            }
            return cTShdFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SNAPTOGRID$40, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTSpacing getSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTSpacing cTSpacingFind_element_user = get_store().find_element_user(SPACING$42, 0);
            if (cTSpacingFind_element_user == null) {
                return null;
            }
            return cTSpacingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSuppressAutoHyphens() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SUPPRESSAUTOHYPHENS$22, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSuppressLineNumbers() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SUPPRESSLINENUMBERS$14, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSuppressOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SUPPRESSOVERLAP$50, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTabs getTabs() {
        synchronized (monitor()) {
            check_orphaned();
            CTTabs cTTabsFind_element_user = get_store().find_element_user(TABS$20, 0);
            if (cTTabsFind_element_user == null) {
                return null;
            }
            return cTTabsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextAlignment getTextAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextAlignment cTTextAlignmentFind_element_user = get_store().find_element_user(TEXTALIGNMENT$56, 0);
            if (cTTextAlignmentFind_element_user == null) {
                return null;
            }
            return cTTextAlignmentFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextDirection getTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextDirection cTTextDirectionFind_element_user = get_store().find_element_user(TEXTDIRECTION$54, 0);
            if (cTTextDirectionFind_element_user == null) {
                return null;
            }
            return cTTextDirectionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextboxTightWrap getTextboxTightWrap() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextboxTightWrap cTTextboxTightWrapFind_element_user = get_store().find_element_user(TEXTBOXTIGHTWRAP$58, 0);
            if (cTTextboxTightWrapFind_element_user == null) {
                return null;
            }
            return cTTextboxTightWrapFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getTopLinePunct() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(TOPLINEPUNCT$30, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getWidowControl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(WIDOWCONTROL$10, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getWordWrap() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(WORDWRAP$26, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetAdjustRightInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ADJUSTRIGHTIND$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetAutoSpaceDE() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOSPACEDE$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetAutoSpaceDN() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOSPACEDN$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetBidi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BIDI$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetCnfStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CNFSTYLE$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetContextualSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTEXTUALSPACING$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetDivId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIVID$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetFramePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FRAMEPR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IND$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(JC$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetKeepLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KEEPLINES$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetKeepNext() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KEEPNEXT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetKinsoku() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KINSOKU$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetMirrorIndents() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MIRRORINDENTS$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetNumPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMPR$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetOutlineLvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTLINELVL$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetOverflowPunct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OVERFLOWPUNCT$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetPBdr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PBDR$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetPStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetPageBreakBefore() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGEBREAKBEFORE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSnapToGrid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPTOGRID$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPACING$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSuppressAutoHyphens() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUPPRESSAUTOHYPHENS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSuppressLineNumbers() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUPPRESSLINENUMBERS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSuppressOverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUPPRESSOVERLAP$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTabs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTextAlignment() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTALIGNMENT$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTextDirection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTDIRECTION$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTextboxTightWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTBOXTIGHTWRAP$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTopLinePunct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOPLINEPUNCT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetWidowControl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WIDOWCONTROL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetWordWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WORDWRAP$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setAdjustRightInd(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJUSTRIGHTIND$38;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setAutoSpaceDE(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOSPACEDE$32;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setAutoSpaceDN(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOSPACEDN$34;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setBidi(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDI$36;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setCnfStyle(CTCnf cTCnf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNFSTYLE$64;
            CTCnf cTCnfFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCnfFind_element_user == null) {
                cTCnfFind_element_user = (CTCnf) get_store().add_element_user(qName);
            }
            cTCnfFind_element_user.set(cTCnf);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setContextualSpacing(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTEXTUALSPACING$46;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setDivId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIVID$62;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setFramePr(CTFramePr cTFramePr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FRAMEPR$8;
            CTFramePr cTFramePrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFramePrFind_element_user == null) {
                cTFramePrFind_element_user = (CTFramePr) get_store().add_element_user(qName);
            }
            cTFramePrFind_element_user.set(cTFramePr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setInd(CTInd cTInd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IND$44;
            CTInd cTIndFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTIndFind_element_user == null) {
                cTIndFind_element_user = (CTInd) get_store().add_element_user(qName);
            }
            cTIndFind_element_user.set(cTInd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JC$52;
            CTJc cTJcFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTJcFind_element_user == null) {
                cTJcFind_element_user = (CTJc) get_store().add_element_user(qName);
            }
            cTJcFind_element_user.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setKeepLines(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEEPLINES$4;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setKeepNext(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEEPNEXT$2;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setKinsoku(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KINSOKU$24;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setMirrorIndents(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIRRORINDENTS$48;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setNumPr(CTNumPr cTNumPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMPR$12;
            CTNumPr cTNumPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTNumPrFind_element_user == null) {
                cTNumPrFind_element_user = (CTNumPr) get_store().add_element_user(qName);
            }
            cTNumPrFind_element_user.set(cTNumPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setOutlineLvl(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINELVL$60;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setOverflowPunct(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OVERFLOWPUNCT$28;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setPBdr(CTPBdr cTPBdr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PBDR$16;
            CTPBdr cTPBdrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPBdrFind_element_user == null) {
                cTPBdrFind_element_user = (CTPBdr) get_store().add_element_user(qName);
            }
            cTPBdrFind_element_user.set(cTPBdr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setPStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PSTYLE$0;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setPageBreakBefore(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEBREAKBEFORE$6;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$18;
            CTShd cTShdFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShdFind_element_user == null) {
                cTShdFind_element_user = (CTShd) get_store().add_element_user(qName);
            }
            cTShdFind_element_user.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSnapToGrid(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPTOGRID$40;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSpacing(CTSpacing cTSpacing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACING$42;
            CTSpacing cTSpacingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSpacingFind_element_user == null) {
                cTSpacingFind_element_user = (CTSpacing) get_store().add_element_user(qName);
            }
            cTSpacingFind_element_user.set(cTSpacing);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSuppressAutoHyphens(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPRESSAUTOHYPHENS$22;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSuppressLineNumbers(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPRESSLINENUMBERS$14;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSuppressOverlap(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPRESSOVERLAP$50;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTabs(CTTabs cTTabs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABS$20;
            CTTabs cTTabsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTabsFind_element_user == null) {
                cTTabsFind_element_user = (CTTabs) get_store().add_element_user(qName);
            }
            cTTabsFind_element_user.set(cTTabs);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTextAlignment(CTTextAlignment cTTextAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTALIGNMENT$56;
            CTTextAlignment cTTextAlignmentFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextAlignmentFind_element_user == null) {
                cTTextAlignmentFind_element_user = (CTTextAlignment) get_store().add_element_user(qName);
            }
            cTTextAlignmentFind_element_user.set(cTTextAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTextDirection(CTTextDirection cTTextDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTDIRECTION$54;
            CTTextDirection cTTextDirectionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextDirectionFind_element_user == null) {
                cTTextDirectionFind_element_user = (CTTextDirection) get_store().add_element_user(qName);
            }
            cTTextDirectionFind_element_user.set(cTTextDirection);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTextboxTightWrap(CTTextboxTightWrap cTTextboxTightWrap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTBOXTIGHTWRAP$58;
            CTTextboxTightWrap cTTextboxTightWrapFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextboxTightWrapFind_element_user == null) {
                cTTextboxTightWrapFind_element_user = (CTTextboxTightWrap) get_store().add_element_user(qName);
            }
            cTTextboxTightWrapFind_element_user.set(cTTextboxTightWrap);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTopLinePunct(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPLINEPUNCT$30;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setWidowControl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WIDOWCONTROL$10;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setWordWrap(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORDWRAP$26;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetAdjustRightInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ADJUSTRIGHTIND$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetAutoSpaceDE() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOSPACEDE$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetAutoSpaceDN() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOSPACEDN$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetBidi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIDI$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNFSTYLE$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetContextualSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTEXTUALSPACING$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetDivId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIVID$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FRAMEPR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IND$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetKeepLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEEPLINES$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetKeepNext() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEEPNEXT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KINSOKU$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetMirrorIndents() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MIRRORINDENTS$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetNumPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMPR$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetOutlineLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINELVL$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetOverflowPunct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVERFLOWPUNCT$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetPBdr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PBDR$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetPageBreakBefore() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEBREAKBEFORE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPTOGRID$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPACING$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSuppressAutoHyphens() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUPPRESSAUTOHYPHENS$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSuppressLineNumbers() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUPPRESSLINENUMBERS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSuppressOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUPPRESSOVERLAP$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTabs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTextAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTALIGNMENT$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDIRECTION$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTextboxTightWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOXTIGHTWRAP$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTopLinePunct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOPLINEPUNCT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetWidowControl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WIDOWCONTROL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetWordWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORDWRAP$26, 0);
        }
    }
}

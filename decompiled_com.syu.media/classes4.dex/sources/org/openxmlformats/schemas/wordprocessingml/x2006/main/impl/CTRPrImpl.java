package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEastAsianLayout;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRPrImpl extends XmlComplexContentImpl implements CTRPr {
    private static final QName RSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle");
    private static final QName RFONTS$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts");
    private static final QName B$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b");
    private static final QName BCS$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs");
    private static final QName I$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "i");
    private static final QName ICS$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs");
    private static final QName CAPS$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps");
    private static final QName SMALLCAPS$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps");
    private static final QName STRIKE$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike");
    private static final QName DSTRIKE$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike");
    private static final QName OUTLINE$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline");
    private static final QName SHADOW$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
    private static final QName EMBOSS$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss");
    private static final QName IMPRINT$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint");
    private static final QName NOPROOF$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof");
    private static final QName SNAPTOGRID$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
    private static final QName VANISH$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish");
    private static final QName WEBHIDDEN$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden");
    private static final QName COLOR$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
    private static final QName SPACING$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
    private static final QName W$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
    private static final QName KERN$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern");
    private static final QName POSITION$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position");
    private static final QName SZ$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
    private static final QName SZCS$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs");
    private static final QName HIGHLIGHT$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight");
    private static final QName U$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u");
    private static final QName EFFECT$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect");
    private static final QName BDR$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr");
    private static final QName SHD$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName FITTEXT$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText");
    private static final QName VERTALIGN$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign");
    private static final QName RTL$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl");
    private static final QName CS$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
    private static final QName EM$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em");
    private static final QName LANG$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang");
    private static final QName EASTASIANLAYOUT$72 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout");
    private static final QName SPECVANISH$74 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish");
    private static final QName OMATH$76 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath");
    private static final QName RPRCHANGE$78 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrChange");

    public CTRPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewB() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(B$4);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewBCs() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BCS$6);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTBorder addNewBdr() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BDR$56);
        }
        return cTBorderAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewCaps() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(CAPS$12);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTColor addNewColor() {
        CTColor cTColorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorAdd_element_user = get_store().add_element_user(COLOR$36);
        }
        return cTColorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewCs() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(CS$66);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewDstrike() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DSTRIKE$18);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEastAsianLayout addNewEastAsianLayout() {
        CTEastAsianLayout cTEastAsianLayoutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEastAsianLayoutAdd_element_user = get_store().add_element_user(EASTASIANLAYOUT$72);
        }
        return cTEastAsianLayoutAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextEffect addNewEffect() {
        CTTextEffect cTTextEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextEffectAdd_element_user = get_store().add_element_user(EFFECT$54);
        }
        return cTTextEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEm addNewEm() {
        CTEm cTEmAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmAdd_element_user = get_store().add_element_user(EM$68);
        }
        return cTEmAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewEmboss() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(EMBOSS$24);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFitText addNewFitText() {
        CTFitText cTFitTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFitTextAdd_element_user = get_store().add_element_user(FITTEXT$60);
        }
        return cTFitTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHighlight addNewHighlight() {
        CTHighlight cTHighlightAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHighlightAdd_element_user = get_store().add_element_user(HIGHLIGHT$50);
        }
        return cTHighlightAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewI() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(I$8);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewICs() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ICS$10);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewImprint() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(IMPRINT$26);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure addNewKern() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(KERN$42);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTLanguage addNewLang() {
        CTLanguage cTLanguageAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguageAdd_element_user = get_store().add_element_user(LANG$70);
        }
        return cTLanguageAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewNoProof() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(NOPROOF$28);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewOMath() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(OMATH$76);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewOutline() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(OUTLINE$20);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedHpsMeasure addNewPosition() {
        CTSignedHpsMeasure cTSignedHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedHpsMeasureAdd_element_user = get_store().add_element_user(POSITION$44);
        }
        return cTSignedHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFonts addNewRFonts() {
        CTFonts cTFontsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFontsAdd_element_user = get_store().add_element_user(RFONTS$2);
        }
        return cTFontsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTRPrChange addNewRPrChange() {
        CTRPrChange cTRPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrChangeAdd_element_user = get_store().add_element_user(RPRCHANGE$78);
        }
        return cTRPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTString addNewRStyle() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(RSTYLE$0);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewRtl() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(RTL$64);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewShadow() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SHADOW$22);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTShd addNewShd() {
        CTShd cTShdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShdAdd_element_user = get_store().add_element_user(SHD$58);
        }
        return cTShdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewSmallCaps() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SMALLCAPS$14);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewSnapToGrid() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SNAPTOGRID$30);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedTwipsMeasure addNewSpacing() {
        CTSignedTwipsMeasure cTSignedTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedTwipsMeasureAdd_element_user = get_store().add_element_user(SPACING$38);
        }
        return cTSignedTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewSpecVanish() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SPECVANISH$74);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewStrike() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(STRIKE$16);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure addNewSz() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(SZ$46);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure addNewSzCs() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(SZCS$48);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTUnderline addNewU() {
        CTUnderline cTUnderlineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineAdd_element_user = get_store().add_element_user(U$52);
        }
        return cTUnderlineAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewVanish() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(VANISH$32);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTVerticalAlignRun addNewVertAlign() {
        CTVerticalAlignRun cTVerticalAlignRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignRunAdd_element_user = get_store().add_element_user(VERTALIGN$62);
        }
        return cTVerticalAlignRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextScale addNewW() {
        CTTextScale cTTextScaleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextScaleAdd_element_user = get_store().add_element_user(W$40);
        }
        return cTTextScaleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewWebHidden() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(WEBHIDDEN$34);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getB() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(B$4, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getBCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BCS$6, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTBorder getBdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(BDR$56, 0);
            if (cTBorderFind_element_user == null) {
                return null;
            }
            return cTBorderFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(CAPS$12, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTColor getColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColorFind_element_user = get_store().find_element_user(COLOR$36, 0);
            if (cTColorFind_element_user == null) {
                return null;
            }
            return cTColorFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(CS$66, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getDstrike() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DSTRIKE$18, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEastAsianLayout getEastAsianLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTEastAsianLayout cTEastAsianLayoutFind_element_user = get_store().find_element_user(EASTASIANLAYOUT$72, 0);
            if (cTEastAsianLayoutFind_element_user == null) {
                return null;
            }
            return cTEastAsianLayoutFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextEffect getEffect() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextEffect cTTextEffectFind_element_user = get_store().find_element_user(EFFECT$54, 0);
            if (cTTextEffectFind_element_user == null) {
                return null;
            }
            return cTTextEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEm getEm() {
        synchronized (monitor()) {
            check_orphaned();
            CTEm cTEmFind_element_user = get_store().find_element_user(EM$68, 0);
            if (cTEmFind_element_user == null) {
                return null;
            }
            return cTEmFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getEmboss() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(EMBOSS$24, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFitText getFitText() {
        synchronized (monitor()) {
            check_orphaned();
            CTFitText cTFitTextFind_element_user = get_store().find_element_user(FITTEXT$60, 0);
            if (cTFitTextFind_element_user == null) {
                return null;
            }
            return cTFitTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHighlight getHighlight() {
        synchronized (monitor()) {
            check_orphaned();
            CTHighlight cTHighlightFind_element_user = get_store().find_element_user(HIGHLIGHT$50, 0);
            if (cTHighlightFind_element_user == null) {
                return null;
            }
            return cTHighlightFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getI() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(I$8, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getICs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ICS$10, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getImprint() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(IMPRINT$26, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure getKern() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(KERN$42, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTLanguage getLang() {
        synchronized (monitor()) {
            check_orphaned();
            CTLanguage cTLanguageFind_element_user = get_store().find_element_user(LANG$70, 0);
            if (cTLanguageFind_element_user == null) {
                return null;
            }
            return cTLanguageFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getNoProof() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(NOPROOF$28, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getOMath() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(OMATH$76, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getOutline() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(OUTLINE$20, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedHpsMeasure getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignedHpsMeasure cTSignedHpsMeasureFind_element_user = get_store().find_element_user(POSITION$44, 0);
            if (cTSignedHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTSignedHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFonts getRFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTFonts cTFontsFind_element_user = get_store().find_element_user(RFONTS$2, 0);
            if (cTFontsFind_element_user == null) {
                return null;
            }
            return cTFontsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTRPrChange getRPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPrChange cTRPrChangeFind_element_user = get_store().find_element_user(RPRCHANGE$78, 0);
            if (cTRPrChangeFind_element_user == null) {
                return null;
            }
            return cTRPrChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTString getRStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(RSTYLE$0, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getRtl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(RTL$64, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getShadow() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SHADOW$22, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShdFind_element_user = get_store().find_element_user(SHD$58, 0);
            if (cTShdFind_element_user == null) {
                return null;
            }
            return cTShdFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getSmallCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SMALLCAPS$14, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SNAPTOGRID$30, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedTwipsMeasure getSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignedTwipsMeasure cTSignedTwipsMeasureFind_element_user = get_store().find_element_user(SPACING$38, 0);
            if (cTSignedTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTSignedTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getSpecVanish() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SPECVANISH$74, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getStrike() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(STRIKE$16, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure getSz() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(SZ$46, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure getSzCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(SZCS$48, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTUnderline getU() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnderline cTUnderlineFind_element_user = get_store().find_element_user(U$52, 0);
            if (cTUnderlineFind_element_user == null) {
                return null;
            }
            return cTUnderlineFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getVanish() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(VANISH$32, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTVerticalAlignRun getVertAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalAlignRun cTVerticalAlignRunFind_element_user = get_store().find_element_user(VERTALIGN$62, 0);
            if (cTVerticalAlignRunFind_element_user == null) {
                return null;
            }
            return cTVerticalAlignRunFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextScale getW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextScale cTTextScaleFind_element_user = get_store().find_element_user(W$40, 0);
            if (cTTextScaleFind_element_user == null) {
                return null;
            }
            return cTTextScaleFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getWebHidden() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(WEBHIDDEN$34, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(B$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetBCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BCS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetBdr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BDR$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CAPS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLOR$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CS$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetDstrike() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DSTRIKE$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEastAsianLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EASTASIANLAYOUT$72) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEffect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECT$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EM$68) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEmboss() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMBOSS$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetFitText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FITTEXT$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetHighlight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIGHLIGHT$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetICs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ICS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetImprint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IMPRINT$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetKern() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KERN$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LANG$70) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetNoProof() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOPROOF$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetOMath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OMATH$76) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetOutline() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTLINE$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(POSITION$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RFONTS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPRCHANGE$78) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRtl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RTL$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetShadow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHADOW$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSmallCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMALLCAPS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSnapToGrid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPTOGRID$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPACING$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSpecVanish() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPECVANISH$74) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetStrike() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRIKE$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SZ$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSzCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SZCS$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(U$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetVanish() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VANISH$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetVertAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VERTALIGN$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(W$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetWebHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBHIDDEN$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setB(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$4;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setBCs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BCS$6;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setBdr(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BDR$56;
            CTBorder cTBorderFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBorderFind_element_user == null) {
                cTBorderFind_element_user = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAPS$12;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$36;
            CTColor cTColorFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTColorFind_element_user == null) {
                cTColorFind_element_user = (CTColor) get_store().add_element_user(qName);
            }
            cTColorFind_element_user.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setCs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CS$66;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setDstrike(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DSTRIKE$18;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEastAsianLayout(CTEastAsianLayout cTEastAsianLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIANLAYOUT$72;
            CTEastAsianLayout cTEastAsianLayoutFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEastAsianLayoutFind_element_user == null) {
                cTEastAsianLayoutFind_element_user = (CTEastAsianLayout) get_store().add_element_user(qName);
            }
            cTEastAsianLayoutFind_element_user.set(cTEastAsianLayout);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEffect(CTTextEffect cTTextEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECT$54;
            CTTextEffect cTTextEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextEffectFind_element_user == null) {
                cTTextEffectFind_element_user = (CTTextEffect) get_store().add_element_user(qName);
            }
            cTTextEffectFind_element_user.set(cTTextEffect);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEm(CTEm cTEm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EM$68;
            CTEm cTEmFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEmFind_element_user == null) {
                cTEmFind_element_user = (CTEm) get_store().add_element_user(qName);
            }
            cTEmFind_element_user.set(cTEm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEmboss(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBOSS$24;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setFitText(CTFitText cTFitText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTEXT$60;
            CTFitText cTFitTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFitTextFind_element_user == null) {
                cTFitTextFind_element_user = (CTFitText) get_store().add_element_user(qName);
            }
            cTFitTextFind_element_user.set(cTFitText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setHighlight(CTHighlight cTHighlight) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIGHLIGHT$50;
            CTHighlight cTHighlightFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHighlightFind_element_user == null) {
                cTHighlightFind_element_user = (CTHighlight) get_store().add_element_user(qName);
            }
            cTHighlightFind_element_user.set(cTHighlight);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setI(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I$8;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setICs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICS$10;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setImprint(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMPRINT$26;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setKern(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KERN$42;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setLang(CTLanguage cTLanguage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$70;
            CTLanguage cTLanguageFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLanguageFind_element_user == null) {
                cTLanguageFind_element_user = (CTLanguage) get_store().add_element_user(qName);
            }
            cTLanguageFind_element_user.set(cTLanguage);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setNoProof(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOPROOF$28;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setOMath(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OMATH$76;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setOutline(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$20;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setPosition(CTSignedHpsMeasure cTSignedHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$44;
            CTSignedHpsMeasure cTSignedHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSignedHpsMeasureFind_element_user == null) {
                cTSignedHpsMeasureFind_element_user = (CTSignedHpsMeasure) get_store().add_element_user(qName);
            }
            cTSignedHpsMeasureFind_element_user.set(cTSignedHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRFonts(CTFonts cTFonts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RFONTS$2;
            CTFonts cTFontsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFontsFind_element_user == null) {
                cTFontsFind_element_user = (CTFonts) get_store().add_element_user(qName);
            }
            cTFontsFind_element_user.set(cTFonts);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRPrChange(CTRPrChange cTRPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPRCHANGE$78;
            CTRPrChange cTRPrChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRPrChangeFind_element_user == null) {
                cTRPrChangeFind_element_user = (CTRPrChange) get_store().add_element_user(qName);
            }
            cTRPrChangeFind_element_user.set(cTRPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSTYLE$0;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRtl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$64;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setShadow(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$22;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$58;
            CTShd cTShdFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShdFind_element_user == null) {
                cTShdFind_element_user = (CTShd) get_store().add_element_user(qName);
            }
            cTShdFind_element_user.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSmallCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMALLCAPS$14;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSnapToGrid(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPTOGRID$30;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSpacing(CTSignedTwipsMeasure cTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACING$38;
            CTSignedTwipsMeasure cTSignedTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSignedTwipsMeasureFind_element_user == null) {
                cTSignedTwipsMeasureFind_element_user = (CTSignedTwipsMeasure) get_store().add_element_user(qName);
            }
            cTSignedTwipsMeasureFind_element_user.set(cTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSpecVanish(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPECVANISH$74;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setStrike(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRIKE$16;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSz(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$46;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSzCs(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZCS$48;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setU(CTUnderline cTUnderline) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = U$52;
            CTUnderline cTUnderlineFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTUnderlineFind_element_user == null) {
                cTUnderlineFind_element_user = (CTUnderline) get_store().add_element_user(qName);
            }
            cTUnderlineFind_element_user.set(cTUnderline);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setVanish(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VANISH$32;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setVertAlign(CTVerticalAlignRun cTVerticalAlignRun) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTALIGN$62;
            CTVerticalAlignRun cTVerticalAlignRunFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVerticalAlignRunFind_element_user == null) {
                cTVerticalAlignRunFind_element_user = (CTVerticalAlignRun) get_store().add_element_user(qName);
            }
            cTVerticalAlignRunFind_element_user.set(cTVerticalAlignRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setW(CTTextScale cTTextScale) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$40;
            CTTextScale cTTextScaleFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextScaleFind_element_user == null) {
                cTTextScaleFind_element_user = (CTTextScale) get_store().add_element_user(qName);
            }
            cTTextScaleFind_element_user.set(cTTextScale);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setWebHidden(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBHIDDEN$34;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetBCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BCS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetBdr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BDR$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CAPS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLOR$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CS$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetDstrike() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DSTRIKE$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEastAsianLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EASTASIANLAYOUT$72, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEffect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECT$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EM$68, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEmboss() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMBOSS$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetFitText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FITTEXT$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetHighlight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIGHLIGHT$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetICs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ICS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetImprint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMPRINT$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetKern() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KERN$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LANG$70, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetNoProof() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOPROOF$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetOMath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$76, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetOutline() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINE$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(POSITION$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RFONTS$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPRCHANGE$78, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RTL$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetShadow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSmallCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMALLCAPS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPTOGRID$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPACING$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSpecVanish() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPECVANISH$74, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetStrike() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRIKE$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZ$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSzCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZCS$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(U$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetVanish() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VANISH$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetVertAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VERTALIGN$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(W$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetWebHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBHIDDEN$34, 0);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEdnProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLineNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPaperSource;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSectPrImpl extends XmlComplexContentImpl implements CTSectPr {
    private static final QName HEADERREFERENCE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "headerReference");
    private static final QName FOOTERREFERENCE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footerReference");
    private static final QName FOOTNOTEPR$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnotePr");
    private static final QName ENDNOTEPR$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotePr");
    private static final QName TYPE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
    private static final QName PGSZ$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgSz");
    private static final QName PGMAR$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgMar");
    private static final QName PAPERSRC$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "paperSrc");
    private static final QName PGBORDERS$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgBorders");
    private static final QName LNNUMTYPE$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lnNumType");
    private static final QName PGNUMTYPE$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgNumType");
    private static final QName COLS$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cols");
    private static final QName FORMPROT$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formProt");
    private static final QName VALIGN$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vAlign");
    private static final QName NOENDNOTE$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noEndnote");
    private static final QName TITLEPG$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "titlePg");
    private static final QName TEXTDIRECTION$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
    private static final QName BIDI$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");
    private static final QName RTLGUTTER$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtlGutter");
    private static final QName DOCGRID$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docGrid");
    private static final QName PRINTERSETTINGS$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printerSettings");
    private static final QName SECTPRCHANGE$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sectPrChange");
    private static final QName RSIDRPR$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidRPr");
    private static final QName RSIDDEL$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidDel");
    private static final QName RSIDR$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidR");
    private static final QName RSIDSECT$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidSect");

    public CTSectPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewBidi() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BIDI$34);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTColumns addNewCols() {
        CTColumns cTColumnsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColumnsAdd_element_user = get_store().add_element_user(COLS$22);
        }
        return cTColumnsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTDocGrid addNewDocGrid() {
        CTDocGrid cTDocGridAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocGridAdd_element_user = get_store().add_element_user(DOCGRID$38);
        }
        return cTDocGridAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTEdnProps addNewEndnotePr() {
        CTEdnProps cTEdnPropsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEdnPropsAdd_element_user = get_store().add_element_user(ENDNOTEPR$6);
        }
        return cTEdnPropsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef addNewFooterReference() {
        CTHdrFtrRef cTHdrFtrRefAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRefAdd_element_user = get_store().add_element_user(FOOTERREFERENCE$2);
        }
        return cTHdrFtrRefAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTFtnProps addNewFootnotePr() {
        CTFtnProps cTFtnPropsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnPropsAdd_element_user = get_store().add_element_user(FOOTNOTEPR$4);
        }
        return cTFtnPropsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewFormProt() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(FORMPROT$24);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef addNewHeaderReference() {
        CTHdrFtrRef cTHdrFtrRefAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRefAdd_element_user = get_store().add_element_user(HEADERREFERENCE$0);
        }
        return cTHdrFtrRefAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTLineNumber addNewLnNumType() {
        CTLineNumber cTLineNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineNumberAdd_element_user = get_store().add_element_user(LNNUMTYPE$18);
        }
        return cTLineNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewNoEndnote() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(NOENDNOTE$28);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPaperSource addNewPaperSrc() {
        CTPaperSource cTPaperSourceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPaperSourceAdd_element_user = get_store().add_element_user(PAPERSRC$14);
        }
        return cTPaperSourceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageBorders addNewPgBorders() {
        CTPageBorders cTPageBordersAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBordersAdd_element_user = get_store().add_element_user(PGBORDERS$16);
        }
        return cTPageBordersAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageMar addNewPgMar() {
        CTPageMar cTPageMarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMarAdd_element_user = get_store().add_element_user(PGMAR$12);
        }
        return cTPageMarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageNumber addNewPgNumType() {
        CTPageNumber cTPageNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPageNumberAdd_element_user = get_store().add_element_user(PGNUMTYPE$20);
        }
        return cTPageNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageSz addNewPgSz() {
        CTPageSz cTPageSzAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSzAdd_element_user = get_store().add_element_user(PGSZ$10);
        }
        return cTPageSzAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTRel addNewPrinterSettings() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(PRINTERSETTINGS$40);
        }
        return cTRelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewRtlGutter() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(RTLGUTTER$36);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectPrChange addNewSectPrChange() {
        CTSectPrChange cTSectPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSectPrChangeAdd_element_user = get_store().add_element_user(SECTPRCHANGE$42);
        }
        return cTSectPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTTextDirection addNewTextDirection() {
        CTTextDirection cTTextDirectionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirectionAdd_element_user = get_store().add_element_user(TEXTDIRECTION$32);
        }
        return cTTextDirectionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewTitlePg() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(TITLEPG$30);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectType addNewType() {
        CTSectType cTSectTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSectTypeAdd_element_user = get_store().add_element_user(TYPE$8);
        }
        return cTSectTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTVerticalJc addNewVAlign() {
        CTVerticalJc cTVerticalJcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJcAdd_element_user = get_store().add_element_user(VALIGN$26);
        }
        return cTVerticalJcAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getBidi() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BIDI$34, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTColumns getCols() {
        synchronized (monitor()) {
            check_orphaned();
            CTColumns cTColumnsFind_element_user = get_store().find_element_user(COLS$22, 0);
            if (cTColumnsFind_element_user == null) {
                return null;
            }
            return cTColumnsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTDocGrid getDocGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocGrid cTDocGridFind_element_user = get_store().find_element_user(DOCGRID$38, 0);
            if (cTDocGridFind_element_user == null) {
                return null;
            }
            return cTDocGridFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTEdnProps getEndnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTEdnProps cTEdnPropsFind_element_user = get_store().find_element_user(ENDNOTEPR$6, 0);
            if (cTEdnPropsFind_element_user == null) {
                return null;
            }
            return cTEdnPropsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef getFooterReferenceArray(int i) {
        CTHdrFtrRef cTHdrFtrRefFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRefFind_element_user = get_store().find_element_user(FOOTERREFERENCE$2, i);
            if (cTHdrFtrRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHdrFtrRefFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef[] getFooterReferenceArray() {
        CTHdrFtrRef[] cTHdrFtrRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FOOTERREFERENCE$2, arrayList);
            cTHdrFtrRefArr = new CTHdrFtrRef[arrayList.size()];
            arrayList.toArray(cTHdrFtrRefArr);
        }
        return cTHdrFtrRefArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public List<CTHdrFtrRef> getFooterReferenceList() {
        1FooterReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FooterReferenceList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTFtnProps getFootnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTFtnProps cTFtnPropsFind_element_user = get_store().find_element_user(FOOTNOTEPR$4, 0);
            if (cTFtnPropsFind_element_user == null) {
                return null;
            }
            return cTFtnPropsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getFormProt() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(FORMPROT$24, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef getHeaderReferenceArray(int i) {
        CTHdrFtrRef cTHdrFtrRefFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRefFind_element_user = get_store().find_element_user(HEADERREFERENCE$0, i);
            if (cTHdrFtrRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHdrFtrRefFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef[] getHeaderReferenceArray() {
        CTHdrFtrRef[] cTHdrFtrRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HEADERREFERENCE$0, arrayList);
            cTHdrFtrRefArr = new CTHdrFtrRef[arrayList.size()];
            arrayList.toArray(cTHdrFtrRefArr);
        }
        return cTHdrFtrRefArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public List<CTHdrFtrRef> getHeaderReferenceList() {
        1HeaderReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HeaderReferenceList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTLineNumber getLnNumType() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineNumber cTLineNumberFind_element_user = get_store().find_element_user(LNNUMTYPE$18, 0);
            if (cTLineNumberFind_element_user == null) {
                return null;
            }
            return cTLineNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getNoEndnote() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(NOENDNOTE$28, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPaperSource getPaperSrc() {
        synchronized (monitor()) {
            check_orphaned();
            CTPaperSource cTPaperSourceFind_element_user = get_store().find_element_user(PAPERSRC$14, 0);
            if (cTPaperSourceFind_element_user == null) {
                return null;
            }
            return cTPaperSourceFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageBorders getPgBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageBorders cTPageBordersFind_element_user = get_store().find_element_user(PGBORDERS$16, 0);
            if (cTPageBordersFind_element_user == null) {
                return null;
            }
            return cTPageBordersFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageMar getPgMar() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageMar cTPageMarFind_element_user = get_store().find_element_user(PGMAR$12, 0);
            if (cTPageMarFind_element_user == null) {
                return null;
            }
            return cTPageMarFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageNumber getPgNumType() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageNumber cTPageNumberFind_element_user = get_store().find_element_user(PGNUMTYPE$20, 0);
            if (cTPageNumberFind_element_user == null) {
                return null;
            }
            return cTPageNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageSz getPgSz() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageSz cTPageSzFind_element_user = get_store().find_element_user(PGSZ$10, 0);
            if (cTPageSzFind_element_user == null) {
                return null;
            }
            return cTPageSzFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTRel getPrinterSettings() {
        synchronized (monitor()) {
            check_orphaned();
            CTRel cTRelFind_element_user = get_store().find_element_user(PRINTERSETTINGS$40, 0);
            if (cTRelFind_element_user == null) {
                return null;
            }
            return cTRelFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidDel() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDDEL$46);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDR$48);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidRPr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDRPR$44);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidSect() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDSECT$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getRtlGutter() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(RTLGUTTER$36, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectPrChange getSectPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTSectPrChange cTSectPrChangeFind_element_user = get_store().find_element_user(SECTPRCHANGE$42, 0);
            if (cTSectPrChangeFind_element_user == null) {
                return null;
            }
            return cTSectPrChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTTextDirection getTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextDirection cTTextDirectionFind_element_user = get_store().find_element_user(TEXTDIRECTION$32, 0);
            if (cTTextDirectionFind_element_user == null) {
                return null;
            }
            return cTTextDirectionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getTitlePg() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(TITLEPG$30, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectType getType() {
        synchronized (monitor()) {
            check_orphaned();
            CTSectType cTSectTypeFind_element_user = get_store().find_element_user(TYPE$8, 0);
            if (cTSectTypeFind_element_user == null) {
                return null;
            }
            return cTSectTypeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTVerticalJc getVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalJc cTVerticalJcFind_element_user = get_store().find_element_user(VALIGN$26, 0);
            if (cTVerticalJcFind_element_user == null) {
                return null;
            }
            return cTVerticalJcFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef insertNewFooterReference(int i) {
        CTHdrFtrRef cTHdrFtrRefInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRefInsert_element_user = get_store().insert_element_user(FOOTERREFERENCE$2, i);
        }
        return cTHdrFtrRefInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef insertNewHeaderReference(int i) {
        CTHdrFtrRef cTHdrFtrRefInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRefInsert_element_user = get_store().insert_element_user(HEADERREFERENCE$0, i);
        }
        return cTHdrFtrRefInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetBidi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BIDI$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetCols() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetDocGrid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCGRID$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetEndnotePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENDNOTEPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetFootnotePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FOOTNOTEPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetFormProt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FORMPROT$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetLnNumType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNNUMTYPE$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetNoEndnote() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOENDNOTE$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPaperSrc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAPERSRC$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PGBORDERS$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PGMAR$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgNumType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PGNUMTYPE$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PGSZ$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPrinterSettings() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTERSETTINGS$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDDEL$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDR$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDRPR$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidSect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDSECT$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRtlGutter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RTLGUTTER$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetSectPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SECTPRCHANGE$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetTextDirection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTDIRECTION$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetTitlePg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLEPG$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TYPE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetVAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VALIGN$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void removeFooterReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FOOTERREFERENCE$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void removeHeaderReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADERREFERENCE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setBidi(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDI$34;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setCols(CTColumns cTColumns) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLS$22;
            CTColumns cTColumnsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTColumnsFind_element_user == null) {
                cTColumnsFind_element_user = (CTColumns) get_store().add_element_user(qName);
            }
            cTColumnsFind_element_user.set(cTColumns);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setDocGrid(CTDocGrid cTDocGrid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCGRID$38;
            CTDocGrid cTDocGridFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDocGridFind_element_user == null) {
                cTDocGridFind_element_user = (CTDocGrid) get_store().add_element_user(qName);
            }
            cTDocGridFind_element_user.set(cTDocGrid);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setEndnotePr(CTEdnProps cTEdnProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDNOTEPR$6;
            CTEdnProps cTEdnPropsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEdnPropsFind_element_user == null) {
                cTEdnPropsFind_element_user = (CTEdnProps) get_store().add_element_user(qName);
            }
            cTEdnPropsFind_element_user.set(cTEdnProps);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFooterReferenceArray(int i, CTHdrFtrRef cTHdrFtrRef) {
        synchronized (monitor()) {
            check_orphaned();
            CTHdrFtrRef cTHdrFtrRefFind_element_user = get_store().find_element_user(FOOTERREFERENCE$2, i);
            if (cTHdrFtrRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHdrFtrRefFind_element_user.set(cTHdrFtrRef);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFooterReferenceArray(CTHdrFtrRef[] cTHdrFtrRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHdrFtrRefArr, FOOTERREFERENCE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFootnotePr(CTFtnProps cTFtnProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOOTNOTEPR$4;
            CTFtnProps cTFtnPropsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFtnPropsFind_element_user == null) {
                cTFtnPropsFind_element_user = (CTFtnProps) get_store().add_element_user(qName);
            }
            cTFtnPropsFind_element_user.set(cTFtnProps);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFormProt(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMPROT$24;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setHeaderReferenceArray(int i, CTHdrFtrRef cTHdrFtrRef) {
        synchronized (monitor()) {
            check_orphaned();
            CTHdrFtrRef cTHdrFtrRefFind_element_user = get_store().find_element_user(HEADERREFERENCE$0, i);
            if (cTHdrFtrRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHdrFtrRefFind_element_user.set(cTHdrFtrRef);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setHeaderReferenceArray(CTHdrFtrRef[] cTHdrFtrRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHdrFtrRefArr, HEADERREFERENCE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setLnNumType(CTLineNumber cTLineNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNNUMTYPE$18;
            CTLineNumber cTLineNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLineNumberFind_element_user == null) {
                cTLineNumberFind_element_user = (CTLineNumber) get_store().add_element_user(qName);
            }
            cTLineNumberFind_element_user.set(cTLineNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setNoEndnote(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOENDNOTE$28;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPaperSrc(CTPaperSource cTPaperSource) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAPERSRC$14;
            CTPaperSource cTPaperSourceFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPaperSourceFind_element_user == null) {
                cTPaperSourceFind_element_user = (CTPaperSource) get_store().add_element_user(qName);
            }
            cTPaperSourceFind_element_user.set(cTPaperSource);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgBorders(CTPageBorders cTPageBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PGBORDERS$16;
            CTPageBorders cTPageBordersFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPageBordersFind_element_user == null) {
                cTPageBordersFind_element_user = (CTPageBorders) get_store().add_element_user(qName);
            }
            cTPageBordersFind_element_user.set(cTPageBorders);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgMar(CTPageMar cTPageMar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PGMAR$12;
            CTPageMar cTPageMarFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPageMarFind_element_user == null) {
                cTPageMarFind_element_user = (CTPageMar) get_store().add_element_user(qName);
            }
            cTPageMarFind_element_user.set(cTPageMar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgNumType(CTPageNumber cTPageNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PGNUMTYPE$20;
            CTPageNumber cTPageNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPageNumberFind_element_user == null) {
                cTPageNumberFind_element_user = (CTPageNumber) get_store().add_element_user(qName);
            }
            cTPageNumberFind_element_user.set(cTPageNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgSz(CTPageSz cTPageSz) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PGSZ$10;
            CTPageSz cTPageSzFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPageSzFind_element_user == null) {
                cTPageSzFind_element_user = (CTPageSz) get_store().add_element_user(qName);
            }
            cTPageSzFind_element_user.set(cTPageSz);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPrinterSettings(CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTERSETTINGS$40;
            CTRel cTRelFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRelFind_element_user == null) {
                cTRelFind_element_user = (CTRel) get_store().add_element_user(qName);
            }
            cTRelFind_element_user.set(cTRel);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidDel(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDDEL$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidR(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDR$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidRPr(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDRPR$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidSect(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDSECT$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRtlGutter(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTLGUTTER$36;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setSectPrChange(CTSectPrChange cTSectPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SECTPRCHANGE$42;
            CTSectPrChange cTSectPrChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSectPrChangeFind_element_user == null) {
                cTSectPrChangeFind_element_user = (CTSectPrChange) get_store().add_element_user(qName);
            }
            cTSectPrChangeFind_element_user.set(cTSectPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setTextDirection(CTTextDirection cTTextDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTDIRECTION$32;
            CTTextDirection cTTextDirectionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextDirectionFind_element_user == null) {
                cTTextDirectionFind_element_user = (CTTextDirection) get_store().add_element_user(qName);
            }
            cTTextDirectionFind_element_user.set(cTTextDirection);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setTitlePg(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLEPG$30;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setType(CTSectType cTSectType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$8;
            CTSectType cTSectTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSectTypeFind_element_user == null) {
                cTSectTypeFind_element_user = (CTSectType) get_store().add_element_user(qName);
            }
            cTSectTypeFind_element_user.set(cTSectType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setVAlign(CTVerticalJc cTVerticalJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIGN$26;
            CTVerticalJc cTVerticalJcFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVerticalJcFind_element_user == null) {
                cTVerticalJcFind_element_user = (CTVerticalJc) get_store().add_element_user(qName);
            }
            cTVerticalJcFind_element_user.set(cTVerticalJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public int sizeOfFooterReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FOOTERREFERENCE$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public int sizeOfHeaderReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HEADERREFERENCE$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetBidi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIDI$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetCols() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLS$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetDocGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCGRID$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetEndnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDNOTEPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetFootnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FOOTNOTEPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetFormProt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMPROT$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetLnNumType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNNUMTYPE$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetNoEndnote() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOENDNOTE$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPaperSrc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAPERSRC$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PGBORDERS$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PGMAR$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgNumType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PGNUMTYPE$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PGSZ$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPrinterSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTERSETTINGS$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDDEL$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDR$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDRPR$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidSect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDSECT$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRtlGutter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RTLGUTTER$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetSectPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SECTPRCHANGE$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDIRECTION$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetTitlePg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLEPG$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TYPE$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VALIGN$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidDel() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDDEL$46);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidR() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDR$48);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidRPr() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDRPR$44);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidSect() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDSECT$50);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidDel(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDDEL$46;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidR(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDR$48;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidRPr(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDRPR$44;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidSect(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDSECT$50;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }
}

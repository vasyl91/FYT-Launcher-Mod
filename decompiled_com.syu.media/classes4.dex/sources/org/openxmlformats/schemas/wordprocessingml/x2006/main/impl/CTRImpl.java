package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRImpl extends XmlComplexContentImpl implements CTR {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName BR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "br");
    private static final QName T$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "t");
    private static final QName DELTEXT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "delText");
    private static final QName INSTRTEXT$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "instrText");
    private static final QName DELINSTRTEXT$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "delInstrText");
    private static final QName NOBREAKHYPHEN$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noBreakHyphen");
    private static final QName SOFTHYPHEN$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "softHyphen");
    private static final QName DAYSHORT$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dayShort");
    private static final QName MONTHSHORT$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "monthShort");
    private static final QName YEARSHORT$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "yearShort");
    private static final QName DAYLONG$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dayLong");
    private static final QName MONTHLONG$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "monthLong");
    private static final QName YEARLONG$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "yearLong");
    private static final QName ANNOTATIONREF$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "annotationRef");
    private static final QName FOOTNOTEREF$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnoteRef");
    private static final QName ENDNOTEREF$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnoteRef");
    private static final QName SEPARATOR$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "separator");
    private static final QName CONTINUATIONSEPARATOR$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "continuationSeparator");
    private static final QName SYM$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sym");
    private static final QName PGNUM$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgNum");
    private static final QName CR$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cr");
    private static final QName TAB$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab");
    private static final QName OBJECT$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "object");
    private static final QName PICT$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pict");
    private static final QName FLDCHAR$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldChar");
    private static final QName RUBY$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ruby");
    private static final QName FOOTNOTEREFERENCE$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnoteReference");
    private static final QName ENDNOTEREFERENCE$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnoteReference");
    private static final QName COMMENTREFERENCE$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentReference");
    private static final QName DRAWING$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawing");
    private static final QName PTAB$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ptab");
    private static final QName LASTRENDEREDPAGEBREAK$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lastRenderedPageBreak");
    private static final QName RSIDRPR$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidRPr");
    private static final QName RSIDDEL$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidDel");
    private static final QName RSIDR$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidR");

    public CTRImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewAnnotationRef() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(ANNOTATIONREF$28);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTBr addNewBr() {
        CTBr cTBrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBrAdd_element_user = get_store().add_element_user(BR$2);
        }
        return cTBrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTMarkup addNewCommentReference() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(COMMENTREFERENCE$58);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewContinuationSeparator() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(CONTINUATIONSEPARATOR$36);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewCr() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(CR$42);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewDayLong() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(DAYLONG$22);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewDayShort() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(DAYSHORT$16);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText addNewDelInstrText() {
        CTText cTTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAdd_element_user = get_store().add_element_user(DELINSTRTEXT$10);
        }
        return cTTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText addNewDelText() {
        CTText cTTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAdd_element_user = get_store().add_element_user(DELTEXT$6);
        }
        return cTTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingAdd_element_user = get_store().add_element_user(DRAWING$60);
        }
        return cTDrawingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewEndnoteRef() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(ENDNOTEREF$32);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef addNewEndnoteReference() {
        CTFtnEdnRef cTFtnEdnRefAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRefAdd_element_user = get_store().add_element_user(ENDNOTEREFERENCE$56);
        }
        return cTFtnEdnRefAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFldChar addNewFldChar() {
        CTFldChar cTFldCharAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFldCharAdd_element_user = get_store().add_element_user(FLDCHAR$50);
        }
        return cTFldCharAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewFootnoteRef() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(FOOTNOTEREF$30);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef addNewFootnoteReference() {
        CTFtnEdnRef cTFtnEdnRefAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRefAdd_element_user = get_store().add_element_user(FOOTNOTEREFERENCE$54);
        }
        return cTFtnEdnRefAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText addNewInstrText() {
        CTText cTTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAdd_element_user = get_store().add_element_user(INSTRTEXT$8);
        }
        return cTTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewLastRenderedPageBreak() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(LASTRENDEREDPAGEBREAK$64);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewMonthLong() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(MONTHLONG$24);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewMonthShort() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(MONTHSHORT$18);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewNoBreakHyphen() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(NOBREAKHYPHEN$12);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTObject addNewObject() {
        CTObject cTObjectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTObjectAdd_element_user = get_store().add_element_user(OBJECT$46);
        }
        return cTObjectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewPgNum() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(PGNUM$40);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPicture addNewPict() {
        CTPicture cTPictureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPictureAdd_element_user = get_store().add_element_user(PICT$48);
        }
        return cTPictureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPTab addNewPtab() {
        CTPTab cTPTabAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPTabAdd_element_user = get_store().add_element_user(PTAB$62);
        }
        return cTPTabAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTRPr addNewRPr() {
        CTRPr cTRPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrAdd_element_user = get_store().add_element_user(RPR$0);
        }
        return cTRPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTRuby addNewRuby() {
        CTRuby cTRubyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyAdd_element_user = get_store().add_element_user(RUBY$52);
        }
        return cTRubyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewSeparator() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(SEPARATOR$34);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewSoftHyphen() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(SOFTHYPHEN$14);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTSym addNewSym() {
        CTSym cTSymAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSymAdd_element_user = get_store().add_element_user(SYM$38);
        }
        return cTSymAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText addNewT() {
        CTText cTTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAdd_element_user = get_store().add_element_user(T$4);
        }
        return cTTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewTab() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(TAB$44);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewYearLong() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(YEARLONG$26);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty addNewYearShort() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(YEARSHORT$20);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getAnnotationRefArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(ANNOTATIONREF$28, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getAnnotationRefArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANNOTATIONREF$28, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getAnnotationRefList() {
        1AnnotationRefList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnnotationRefList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTBr getBrArray(int i) {
        CTBr cTBrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBrFind_element_user = get_store().find_element_user(BR$2, i);
            if (cTBrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTBr[] getBrArray() {
        CTBr[] cTBrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BR$2, arrayList);
            cTBrArr = new CTBr[arrayList.size()];
            arrayList.toArray(cTBrArr);
        }
        return cTBrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTBr> getBrList() {
        1BrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTMarkup getCommentReferenceArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(COMMENTREFERENCE$58, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTMarkup[] getCommentReferenceArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTREFERENCE$58, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTMarkup> getCommentReferenceList() {
        1CommentReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentReferenceList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getContinuationSeparatorArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(CONTINUATIONSEPARATOR$36, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getContinuationSeparatorArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CONTINUATIONSEPARATOR$36, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getContinuationSeparatorList() {
        1ContinuationSeparatorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ContinuationSeparatorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getCrArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(CR$42, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getCrArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CR$42, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getCrList() {
        1CrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getDayLongArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(DAYLONG$22, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getDayLongArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DAYLONG$22, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getDayLongList() {
        1DayLongList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DayLongList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getDayShortArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(DAYSHORT$16, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getDayShortArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DAYSHORT$16, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getDayShortList() {
        1DayShortList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DayShortList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText getDelInstrTextArray(int i) {
        CTText cTTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFind_element_user = get_store().find_element_user(DELINSTRTEXT$10, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText[] getDelInstrTextArray() {
        CTText[] cTTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DELINSTRTEXT$10, arrayList);
            cTTextArr = new CTText[arrayList.size()];
            arrayList.toArray(cTTextArr);
        }
        return cTTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTText> getDelInstrTextList() {
        1DelInstrTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelInstrTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText getDelTextArray(int i) {
        CTText cTTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFind_element_user = get_store().find_element_user(DELTEXT$6, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText[] getDelTextArray() {
        CTText[] cTTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DELTEXT$6, arrayList);
            cTTextArr = new CTText[arrayList.size()];
            arrayList.toArray(cTTextArr);
        }
        return cTTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTText> getDelTextList() {
        1DelTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTDrawing getDrawingArray(int i) {
        CTDrawing cTDrawingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingFind_element_user = get_store().find_element_user(DRAWING$60, i);
            if (cTDrawingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDrawingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTDrawing[] getDrawingArray() {
        CTDrawing[] cTDrawingArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DRAWING$60, arrayList);
            cTDrawingArr = new CTDrawing[arrayList.size()];
            arrayList.toArray(cTDrawingArr);
        }
        return cTDrawingArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTDrawing> getDrawingList() {
        1DrawingList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DrawingList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getEndnoteRefArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(ENDNOTEREF$32, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getEndnoteRefArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENDNOTEREF$32, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getEndnoteRefList() {
        1EndnoteRefList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EndnoteRefList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef getEndnoteReferenceArray(int i) {
        CTFtnEdnRef cTFtnEdnRefFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRefFind_element_user = get_store().find_element_user(ENDNOTEREFERENCE$56, i);
            if (cTFtnEdnRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdnRefFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef[] getEndnoteReferenceArray() {
        CTFtnEdnRef[] cTFtnEdnRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENDNOTEREFERENCE$56, arrayList);
            cTFtnEdnRefArr = new CTFtnEdnRef[arrayList.size()];
            arrayList.toArray(cTFtnEdnRefArr);
        }
        return cTFtnEdnRefArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTFtnEdnRef> getEndnoteReferenceList() {
        1EndnoteReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EndnoteReferenceList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFldChar getFldCharArray(int i) {
        CTFldChar cTFldCharFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFldCharFind_element_user = get_store().find_element_user(FLDCHAR$50, i);
            if (cTFldCharFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFldCharFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFldChar[] getFldCharArray() {
        CTFldChar[] cTFldCharArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FLDCHAR$50, arrayList);
            cTFldCharArr = new CTFldChar[arrayList.size()];
            arrayList.toArray(cTFldCharArr);
        }
        return cTFldCharArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTFldChar> getFldCharList() {
        1FldCharList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FldCharList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getFootnoteRefArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(FOOTNOTEREF$30, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getFootnoteRefArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FOOTNOTEREF$30, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getFootnoteRefList() {
        1FootnoteRefList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FootnoteRefList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef getFootnoteReferenceArray(int i) {
        CTFtnEdnRef cTFtnEdnRefFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRefFind_element_user = get_store().find_element_user(FOOTNOTEREFERENCE$54, i);
            if (cTFtnEdnRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdnRefFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef[] getFootnoteReferenceArray() {
        CTFtnEdnRef[] cTFtnEdnRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FOOTNOTEREFERENCE$54, arrayList);
            cTFtnEdnRefArr = new CTFtnEdnRef[arrayList.size()];
            arrayList.toArray(cTFtnEdnRefArr);
        }
        return cTFtnEdnRefArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTFtnEdnRef> getFootnoteReferenceList() {
        1FootnoteReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FootnoteReferenceList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText getInstrTextArray(int i) {
        CTText cTTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFind_element_user = get_store().find_element_user(INSTRTEXT$8, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText[] getInstrTextArray() {
        CTText[] cTTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INSTRTEXT$8, arrayList);
            cTTextArr = new CTText[arrayList.size()];
            arrayList.toArray(cTTextArr);
        }
        return cTTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTText> getInstrTextList() {
        1InstrTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InstrTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getLastRenderedPageBreakArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(LASTRENDEREDPAGEBREAK$64, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getLastRenderedPageBreakArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LASTRENDEREDPAGEBREAK$64, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getLastRenderedPageBreakList() {
        1LastRenderedPageBreakList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LastRenderedPageBreakList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getMonthLongArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(MONTHLONG$24, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getMonthLongArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MONTHLONG$24, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getMonthLongList() {
        1MonthLongList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MonthLongList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getMonthShortArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(MONTHSHORT$18, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getMonthShortArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MONTHSHORT$18, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getMonthShortList() {
        1MonthShortList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MonthShortList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getNoBreakHyphenArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(NOBREAKHYPHEN$12, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getNoBreakHyphenArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NOBREAKHYPHEN$12, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getNoBreakHyphenList() {
        1NoBreakHyphenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NoBreakHyphenList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTObject getObjectArray(int i) {
        CTObject cTObjectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTObjectFind_element_user = get_store().find_element_user(OBJECT$46, i);
            if (cTObjectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTObjectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTObject[] getObjectArray() {
        CTObject[] cTObjectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OBJECT$46, arrayList);
            cTObjectArr = new CTObject[arrayList.size()];
            arrayList.toArray(cTObjectArr);
        }
        return cTObjectArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTObject> getObjectList() {
        1ObjectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ObjectList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getPgNumArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(PGNUM$40, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getPgNumArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PGNUM$40, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getPgNumList() {
        1PgNumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PgNumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPicture getPictArray(int i) {
        CTPicture cTPictureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPictureFind_element_user = get_store().find_element_user(PICT$48, i);
            if (cTPictureFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPictureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPicture[] getPictArray() {
        CTPicture[] cTPictureArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PICT$48, arrayList);
            cTPictureArr = new CTPicture[arrayList.size()];
            arrayList.toArray(cTPictureArr);
        }
        return cTPictureArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTPicture> getPictList() {
        1PictList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PictList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPTab getPtabArray(int i) {
        CTPTab cTPTabFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPTabFind_element_user = get_store().find_element_user(PTAB$62, i);
            if (cTPTabFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPTabFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPTab[] getPtabArray() {
        CTPTab[] cTPTabArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PTAB$62, arrayList);
            cTPTabArr = new CTPTab[arrayList.size()];
            arrayList.toArray(cTPTabArr);
        }
        return cTPTabArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTPTab> getPtabList() {
        1PtabList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PtabList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTRPr getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPrFind_element_user = get_store().find_element_user(RPR$0, 0);
            if (cTRPrFind_element_user == null) {
                return null;
            }
            return cTRPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public byte[] getRsidDel() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDDEL$68);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public byte[] getRsidR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDR$70);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public byte[] getRsidRPr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RSIDRPR$66);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTRuby getRubyArray(int i) {
        CTRuby cTRubyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyFind_element_user = get_store().find_element_user(RUBY$52, i);
            if (cTRubyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRubyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTRuby[] getRubyArray() {
        CTRuby[] cTRubyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RUBY$52, arrayList);
            cTRubyArr = new CTRuby[arrayList.size()];
            arrayList.toArray(cTRubyArr);
        }
        return cTRubyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTRuby> getRubyList() {
        1RubyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RubyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getSeparatorArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(SEPARATOR$34, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getSeparatorArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEPARATOR$34, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getSeparatorList() {
        1SeparatorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SeparatorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getSoftHyphenArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(SOFTHYPHEN$14, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getSoftHyphenArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SOFTHYPHEN$14, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getSoftHyphenList() {
        1SoftHyphenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SoftHyphenList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTSym getSymArray(int i) {
        CTSym cTSymFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSymFind_element_user = get_store().find_element_user(SYM$38, i);
            if (cTSymFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSymFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTSym[] getSymArray() {
        CTSym[] cTSymArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SYM$38, arrayList);
            cTSymArr = new CTSym[arrayList.size()];
            arrayList.toArray(cTSymArr);
        }
        return cTSymArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTSym> getSymList() {
        1SymList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SymList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText getTArray(int i) {
        CTText cTTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFind_element_user = get_store().find_element_user(T$4, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText[] getTArray() {
        CTText[] cTTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(T$4, arrayList);
            cTTextArr = new CTText[arrayList.size()];
            arrayList.toArray(cTTextArr);
        }
        return cTTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTText> getTList() {
        1TList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getTabArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(TAB$44, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getTabArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TAB$44, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getTabList() {
        1TabList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TabList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getYearLongArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(YEARLONG$26, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getYearLongArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(YEARLONG$26, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getYearLongList() {
        1YearLongList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1YearLongList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty getYearShortArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(YEARSHORT$20, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty[] getYearShortArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(YEARSHORT$20, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public List<CTEmpty> getYearShortList() {
        1YearShortList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1YearShortList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewAnnotationRef(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(ANNOTATIONREF$28, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTBr insertNewBr(int i) {
        CTBr cTBrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBrInsert_element_user = get_store().insert_element_user(BR$2, i);
        }
        return cTBrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTMarkup insertNewCommentReference(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(COMMENTREFERENCE$58, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewContinuationSeparator(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(CONTINUATIONSEPARATOR$36, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewCr(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(CR$42, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewDayLong(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(DAYLONG$22, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewDayShort(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(DAYSHORT$16, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText insertNewDelInstrText(int i) {
        CTText cTTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextInsert_element_user = get_store().insert_element_user(DELINSTRTEXT$10, i);
        }
        return cTTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText insertNewDelText(int i) {
        CTText cTTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextInsert_element_user = get_store().insert_element_user(DELTEXT$6, i);
        }
        return cTTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTDrawing insertNewDrawing(int i) {
        CTDrawing cTDrawingInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingInsert_element_user = get_store().insert_element_user(DRAWING$60, i);
        }
        return cTDrawingInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewEndnoteRef(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(ENDNOTEREF$32, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef insertNewEndnoteReference(int i) {
        CTFtnEdnRef cTFtnEdnRefInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRefInsert_element_user = get_store().insert_element_user(ENDNOTEREFERENCE$56, i);
        }
        return cTFtnEdnRefInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFldChar insertNewFldChar(int i) {
        CTFldChar cTFldCharInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFldCharInsert_element_user = get_store().insert_element_user(FLDCHAR$50, i);
        }
        return cTFldCharInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewFootnoteRef(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(FOOTNOTEREF$30, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTFtnEdnRef insertNewFootnoteReference(int i) {
        CTFtnEdnRef cTFtnEdnRefInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRefInsert_element_user = get_store().insert_element_user(FOOTNOTEREFERENCE$54, i);
        }
        return cTFtnEdnRefInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText insertNewInstrText(int i) {
        CTText cTTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextInsert_element_user = get_store().insert_element_user(INSTRTEXT$8, i);
        }
        return cTTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewLastRenderedPageBreak(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(LASTRENDEREDPAGEBREAK$64, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewMonthLong(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(MONTHLONG$24, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewMonthShort(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(MONTHSHORT$18, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewNoBreakHyphen(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(NOBREAKHYPHEN$12, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTObject insertNewObject(int i) {
        CTObject cTObjectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTObjectInsert_element_user = get_store().insert_element_user(OBJECT$46, i);
        }
        return cTObjectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewPgNum(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(PGNUM$40, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPicture insertNewPict(int i) {
        CTPicture cTPictureInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPictureInsert_element_user = get_store().insert_element_user(PICT$48, i);
        }
        return cTPictureInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTPTab insertNewPtab(int i) {
        CTPTab cTPTabInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPTabInsert_element_user = get_store().insert_element_user(PTAB$62, i);
        }
        return cTPTabInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTRuby insertNewRuby(int i) {
        CTRuby cTRubyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyInsert_element_user = get_store().insert_element_user(RUBY$52, i);
        }
        return cTRubyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewSeparator(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(SEPARATOR$34, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewSoftHyphen(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(SOFTHYPHEN$14, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTSym insertNewSym(int i) {
        CTSym cTSymInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSymInsert_element_user = get_store().insert_element_user(SYM$38, i);
        }
        return cTSymInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTText insertNewT(int i) {
        CTText cTTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextInsert_element_user = get_store().insert_element_user(T$4, i);
        }
        return cTTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewTab(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(TAB$44, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewYearLong(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(YEARLONG$26, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public CTEmpty insertNewYearShort(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(YEARSHORT$20, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public boolean isSetRsidDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDDEL$68) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public boolean isSetRsidR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDR$70) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public boolean isSetRsidRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RSIDRPR$66) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeAnnotationRef(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANNOTATIONREF$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeBr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BR$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeCommentReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTREFERENCE$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeContinuationSeparator(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTINUATIONSEPARATOR$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeCr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CR$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeDayLong(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DAYLONG$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeDayShort(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DAYSHORT$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeDelInstrText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELINSTRTEXT$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeDelText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELTEXT$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeDrawing(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWING$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeEndnoteRef(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDNOTEREF$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeEndnoteReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDNOTEREFERENCE$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeFldChar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLDCHAR$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeFootnoteRef(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FOOTNOTEREF$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeFootnoteReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FOOTNOTEREFERENCE$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeInstrText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INSTRTEXT$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeLastRenderedPageBreak(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LASTRENDEREDPAGEBREAK$64, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeMonthLong(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MONTHLONG$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeMonthShort(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MONTHSHORT$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeNoBreakHyphen(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOBREAKHYPHEN$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeObject(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OBJECT$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removePgNum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PGNUM$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removePict(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PICT$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removePtab(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PTAB$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeRuby(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RUBY$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeSeparator(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEPARATOR$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeSoftHyphen(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOFTHYPHEN$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeSym(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SYM$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeT(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(T$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeTab(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAB$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeYearLong(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(YEARLONG$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void removeYearShort(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(YEARSHORT$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setAnnotationRefArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(ANNOTATIONREF$28, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setAnnotationRefArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, ANNOTATIONREF$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setBrArray(int i, CTBr cTBr) {
        synchronized (monitor()) {
            check_orphaned();
            CTBr cTBrFind_element_user = get_store().find_element_user(BR$2, i);
            if (cTBrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBrFind_element_user.set(cTBr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setBrArray(CTBr[] cTBrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBrArr, BR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setCommentReferenceArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(COMMENTREFERENCE$58, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setCommentReferenceArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, COMMENTREFERENCE$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setContinuationSeparatorArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(CONTINUATIONSEPARATOR$36, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setContinuationSeparatorArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, CONTINUATIONSEPARATOR$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setCrArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(CR$42, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setCrArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, CR$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDayLongArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(DAYLONG$22, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDayLongArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, DAYLONG$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDayShortArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(DAYSHORT$16, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDayShortArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, DAYSHORT$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDelInstrTextArray(int i, CTText cTText) {
        synchronized (monitor()) {
            check_orphaned();
            CTText cTTextFind_element_user = get_store().find_element_user(DELINSTRTEXT$10, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextFind_element_user.set(cTText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDelInstrTextArray(CTText[] cTTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextArr, DELINSTRTEXT$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDelTextArray(int i, CTText cTText) {
        synchronized (monitor()) {
            check_orphaned();
            CTText cTTextFind_element_user = get_store().find_element_user(DELTEXT$6, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextFind_element_user.set(cTText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDelTextArray(CTText[] cTTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextArr, DELTEXT$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDrawingArray(int i, CTDrawing cTDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            CTDrawing cTDrawingFind_element_user = get_store().find_element_user(DRAWING$60, i);
            if (cTDrawingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDrawingFind_element_user.set(cTDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setDrawingArray(CTDrawing[] cTDrawingArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDrawingArr, DRAWING$60);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setEndnoteRefArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(ENDNOTEREF$32, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setEndnoteRefArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, ENDNOTEREF$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setEndnoteReferenceArray(int i, CTFtnEdnRef cTFtnEdnRef) {
        synchronized (monitor()) {
            check_orphaned();
            CTFtnEdnRef cTFtnEdnRefFind_element_user = get_store().find_element_user(ENDNOTEREFERENCE$56, i);
            if (cTFtnEdnRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFtnEdnRefFind_element_user.set(cTFtnEdnRef);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setEndnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFtnEdnRefArr, ENDNOTEREFERENCE$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setFldCharArray(int i, CTFldChar cTFldChar) {
        synchronized (monitor()) {
            check_orphaned();
            CTFldChar cTFldCharFind_element_user = get_store().find_element_user(FLDCHAR$50, i);
            if (cTFldCharFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFldCharFind_element_user.set(cTFldChar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setFldCharArray(CTFldChar[] cTFldCharArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFldCharArr, FLDCHAR$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setFootnoteRefArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(FOOTNOTEREF$30, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setFootnoteRefArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, FOOTNOTEREF$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setFootnoteReferenceArray(int i, CTFtnEdnRef cTFtnEdnRef) {
        synchronized (monitor()) {
            check_orphaned();
            CTFtnEdnRef cTFtnEdnRefFind_element_user = get_store().find_element_user(FOOTNOTEREFERENCE$54, i);
            if (cTFtnEdnRefFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFtnEdnRefFind_element_user.set(cTFtnEdnRef);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setFootnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFtnEdnRefArr, FOOTNOTEREFERENCE$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setInstrTextArray(int i, CTText cTText) {
        synchronized (monitor()) {
            check_orphaned();
            CTText cTTextFind_element_user = get_store().find_element_user(INSTRTEXT$8, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextFind_element_user.set(cTText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setInstrTextArray(CTText[] cTTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextArr, INSTRTEXT$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setLastRenderedPageBreakArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(LASTRENDEREDPAGEBREAK$64, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setLastRenderedPageBreakArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, LASTRENDEREDPAGEBREAK$64);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setMonthLongArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(MONTHLONG$24, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setMonthLongArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, MONTHLONG$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setMonthShortArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(MONTHSHORT$18, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setMonthShortArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, MONTHSHORT$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setNoBreakHyphenArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(NOBREAKHYPHEN$12, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setNoBreakHyphenArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, NOBREAKHYPHEN$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setObjectArray(int i, CTObject cTObject) {
        synchronized (monitor()) {
            check_orphaned();
            CTObject cTObjectFind_element_user = get_store().find_element_user(OBJECT$46, i);
            if (cTObjectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTObjectFind_element_user.set(cTObject);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setObjectArray(CTObject[] cTObjectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTObjectArr, OBJECT$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setPgNumArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(PGNUM$40, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setPgNumArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, PGNUM$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setPictArray(int i, CTPicture cTPicture) {
        synchronized (monitor()) {
            check_orphaned();
            CTPicture cTPictureFind_element_user = get_store().find_element_user(PICT$48, i);
            if (cTPictureFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPictureFind_element_user.set(cTPicture);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setPictArray(CTPicture[] cTPictureArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPictureArr, PICT$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setPtabArray(int i, CTPTab cTPTab) {
        synchronized (monitor()) {
            check_orphaned();
            CTPTab cTPTabFind_element_user = get_store().find_element_user(PTAB$62, i);
            if (cTPTabFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPTabFind_element_user.set(cTPTab);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setPtabArray(CTPTab[] cTPTabArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPTabArr, PTAB$62);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setRPr(CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$0;
            CTRPr cTRPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRPrFind_element_user == null) {
                cTRPrFind_element_user = (CTRPr) get_store().add_element_user(qName);
            }
            cTRPrFind_element_user.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setRsidDel(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDDEL$68;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setRsidR(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDR$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setRsidRPr(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDRPR$66;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setRubyArray(int i, CTRuby cTRuby) {
        synchronized (monitor()) {
            check_orphaned();
            CTRuby cTRubyFind_element_user = get_store().find_element_user(RUBY$52, i);
            if (cTRubyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRubyFind_element_user.set(cTRuby);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setRubyArray(CTRuby[] cTRubyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRubyArr, RUBY$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setSeparatorArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(SEPARATOR$34, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setSeparatorArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, SEPARATOR$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setSoftHyphenArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(SOFTHYPHEN$14, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setSoftHyphenArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, SOFTHYPHEN$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setSymArray(int i, CTSym cTSym) {
        synchronized (monitor()) {
            check_orphaned();
            CTSym cTSymFind_element_user = get_store().find_element_user(SYM$38, i);
            if (cTSymFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSymFind_element_user.set(cTSym);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setSymArray(CTSym[] cTSymArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSymArr, SYM$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setTArray(int i, CTText cTText) {
        synchronized (monitor()) {
            check_orphaned();
            CTText cTTextFind_element_user = get_store().find_element_user(T$4, i);
            if (cTTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextFind_element_user.set(cTText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setTArray(CTText[] cTTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextArr, T$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setTabArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(TAB$44, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setTabArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, TAB$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setYearLongArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(YEARLONG$26, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setYearLongArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, YEARLONG$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setYearShortArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(YEARSHORT$20, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void setYearShortArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, YEARSHORT$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfAnnotationRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANNOTATIONREF$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfBrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BR$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfCommentReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTREFERENCE$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfContinuationSeparatorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CONTINUATIONSEPARATOR$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfCrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CR$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfDayLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DAYLONG$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfDayShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DAYSHORT$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfDelInstrTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DELINSTRTEXT$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfDelTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DELTEXT$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfDrawingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DRAWING$60);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfEndnoteRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENDNOTEREF$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfEndnoteReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENDNOTEREFERENCE$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfFldCharArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FLDCHAR$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfFootnoteRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FOOTNOTEREF$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfFootnoteReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FOOTNOTEREFERENCE$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfInstrTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INSTRTEXT$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfLastRenderedPageBreakArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LASTRENDEREDPAGEBREAK$64);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfMonthLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MONTHLONG$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfMonthShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MONTHSHORT$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfNoBreakHyphenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NOBREAKHYPHEN$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OBJECT$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfPgNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PGNUM$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfPictArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PICT$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfPtabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PTAB$62);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfRubyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RUBY$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfSeparatorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SEPARATOR$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfSoftHyphenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SOFTHYPHEN$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfSymArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SYM$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfTArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(T$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TAB$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfYearLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(YEARLONG$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public int sizeOfYearShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(YEARSHORT$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void unsetRsidDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDDEL$68);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void unsetRsidR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDR$70);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void unsetRsidRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RSIDRPR$66);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public STLongHexNumber xgetRsidDel() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDDEL$68);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public STLongHexNumber xgetRsidR() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDR$70);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public STLongHexNumber xgetRsidRPr() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(RSIDRPR$66);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void xsetRsidDel(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDDEL$68;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void xsetRsidR(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDR$70;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR
    public void xsetRsidRPr(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDRPR$66;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }
}

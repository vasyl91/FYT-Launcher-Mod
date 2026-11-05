package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblImpl extends XmlComplexContentImpl implements CTTbl {
    private static final QName BOOKMARKSTART$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName TBLPR$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPr");
    private static final QName TBLGRID$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblGrid");
    private static final QName TR$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tr");
    private static final QName CUSTOMXML$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SDT$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName PROOFERR$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName INS$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");

    public CTTblImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(BOOKMARKEND$2);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkAdd_element_user = get_store().add_element_user(BOOKMARKSTART$0);
        }
        return cTBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGEEND$14);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGESTART$12);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTCustomXmlRow addNewCustomXml() {
        CTCustomXmlRow cTCustomXmlRowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRowAdd_element_user = get_store().add_element_user(CUSTOMXML$38);
        }
        return cTCustomXmlRowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGEEND$22);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGESTART$20);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGEEND$18);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGESTART$16);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$26);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$24);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$30);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$28);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(DEL$50);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(INS$48);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVEFROM$52);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVEFROMRANGEEND$6);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVEFROMRANGESTART$4);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVETO$54);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVETORANGEEND$10);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVETORANGESTART$8);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMath addNewOMath() {
        CTOMath cTOMathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathAdd_element_user = get_store().add_element_user(OMATH$58);
        }
        return cTOMathAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathParaAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaAdd_element_user = get_store().add_element_user(OMATHPARA$56);
        }
        return cTOMathParaAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$46);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$44);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$42);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTSdtRow addNewSdt() {
        CTSdtRow cTSdtRowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRowAdd_element_user = get_store().add_element_user(SDT$40);
        }
        return cTSdtRowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTblGrid addNewTblGrid() {
        CTTblGrid cTTblGridAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridAdd_element_user = get_store().add_element_user(TBLGRID$34);
        }
        return cTTblGridAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTblPr addNewTblPr() {
        CTTblPr cTTblPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrAdd_element_user = get_store().add_element_user(TBLPR$32);
        }
        return cTTblPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRow addNewTr() {
        CTRow cTRowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRowAdd_element_user = get_store().add_element_user(TR$36);
        }
        return cTRowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(BOOKMARKEND$2, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$2, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkFind_element_user = get_store().find_element_user(BOOKMARKSTART$0, i);
            if (cTBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$0, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGEEND$14, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$14, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGESTART$12, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$12, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTCustomXmlRow getCustomXmlArray(int i) {
        CTCustomXmlRow cTCustomXmlRowFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRowFind_element_user = get_store().find_element_user(CUSTOMXML$38, i);
            if (cTCustomXmlRowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlRowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTCustomXmlRow[] getCustomXmlArray() {
        CTCustomXmlRow[] cTCustomXmlRowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$38, arrayList);
            cTCustomXmlRowArr = new CTCustomXmlRow[arrayList.size()];
            arrayList.toArray(cTCustomXmlRowArr);
        }
        return cTCustomXmlRowArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGEEND$22, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$22, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGESTART$20, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$20, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGEEND$18, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$18, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGESTART$16, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$16, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTCustomXmlRow> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$26, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$26, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$24, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$24, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$30, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$30, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$28, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$28, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(DEL$50, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$50, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(INS$48, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$48, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVEFROM$52, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$52, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(MOVEFROMRANGEEND$6, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$6, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVEFROMRANGESTART$4, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$4, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVETO$54, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$54, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(MOVETORANGEEND$10, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$10, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVETORANGESTART$8, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$8, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathFind_element_user = get_store().find_element_user(OMATH$58, i);
            if (cTOMathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$58, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara cTOMathParaFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaFind_element_user = get_store().find_element_user(OMATHPARA$56, i);
            if (cTOMathParaFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathParaFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$56, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPerm getPermEndArray(int i) {
        CTPerm cTPermFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermFind_element_user = get_store().find_element_user(PERMEND$46, i);
            if (cTPermFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$46, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPermStart getPermStartArray(int i) {
        CTPermStart cTPermStartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$44, i);
            if (cTPermStartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$44, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$42, i);
            if (cTProofErrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$42, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTSdtRow getSdtArray(int i) {
        CTSdtRow cTSdtRowFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRowFind_element_user = get_store().find_element_user(SDT$40, i);
            if (cTSdtRowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtRowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTSdtRow[] getSdtArray() {
        CTSdtRow[] cTSdtRowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$40, arrayList);
            cTSdtRowArr = new CTSdtRow[arrayList.size()];
            arrayList.toArray(cTSdtRowArr);
        }
        return cTSdtRowArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTSdtRow> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTblGrid getTblGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblGrid cTTblGridFind_element_user = get_store().find_element_user(TBLGRID$34, 0);
            if (cTTblGridFind_element_user == null) {
                return null;
            }
            return cTTblGridFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTblPr getTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPr cTTblPrFind_element_user = get_store().find_element_user(TBLPR$32, 0);
            if (cTTblPrFind_element_user == null) {
                return null;
            }
            return cTTblPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRow getTrArray(int i) {
        CTRow cTRowFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRowFind_element_user = get_store().find_element_user(TR$36, i);
            if (cTRowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRow[] getTrArray() {
        CTRow[] cTRowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TR$36, arrayList);
            cTRowArr = new CTRow[arrayList.size()];
            arrayList.toArray(cTRowArr);
        }
        return cTRowArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public List<CTRow> getTrList() {
        1TrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(BOOKMARKEND$2, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkInsert_element_user = get_store().insert_element_user(BOOKMARKSTART$0, i);
        }
        return cTBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGEEND$14, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGESTART$12, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTCustomXmlRow insertNewCustomXml(int i) {
        CTCustomXmlRow cTCustomXmlRowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRowInsert_element_user = get_store().insert_element_user(CUSTOMXML$38, i);
        }
        return cTCustomXmlRowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGEEND$22, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGESTART$20, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGEEND$18, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGESTART$16, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$26, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$24, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$30, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$28, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(DEL$50, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(INS$48, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVEFROM$52, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVEFROMRANGEEND$6, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVEFROMRANGESTART$4, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVETO$54, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVETORANGEEND$10, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVETORANGESTART$8, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathInsert_element_user = get_store().insert_element_user(OMATH$58, i);
        }
        return cTOMathInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathParaInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaInsert_element_user = get_store().insert_element_user(OMATHPARA$56, i);
        }
        return cTOMathParaInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$46, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$44, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$42, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTSdtRow insertNewSdt(int i) {
        CTSdtRow cTSdtRowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRowInsert_element_user = get_store().insert_element_user(SDT$40, i);
        }
        return cTSdtRowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public CTRow insertNewTr(int i) {
        CTRow cTRowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRowInsert_element_user = get_store().insert_element_user(TR$36, i);
        }
        return cTRowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void removeTr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TR$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(BOOKMARKEND$2, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookmark cTBookmarkFind_element_user = get_store().find_element_user(BOOKMARKSTART$0, i);
            if (cTBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookmarkFind_element_user.set(cTBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGEEND$14, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGESTART$12, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlArray(int i, CTCustomXmlRow cTCustomXmlRow) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlRow cTCustomXmlRowFind_element_user = get_store().find_element_user(CUSTOMXML$38, i);
            if (cTCustomXmlRowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCustomXmlRowFind_element_user.set(cTCustomXmlRow);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlArray(CTCustomXmlRow[] cTCustomXmlRowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCustomXmlRowArr, CUSTOMXML$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGEEND$22, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGESTART$20, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGEEND$18, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGESTART$16, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$26, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$24, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$30, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$28, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(DEL$50, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(INS$48, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVEFROM$52, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(MOVEFROMRANGEEND$6, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVEFROMRANGESTART$4, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmarkFind_element_user.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVETO$54, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(MOVETORANGEEND$10, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVETORANGESTART$8, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmarkFind_element_user.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMath cTOMathFind_element_user = get_store().find_element_user(OMATH$58, i);
            if (cTOMathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOMathFind_element_user.set(cTOMath);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMathPara cTOMathParaFind_element_user = get_store().find_element_user(OMATHPARA$56, i);
            if (cTOMathParaFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOMathParaFind_element_user.set(cTOMathPara);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            check_orphaned();
            CTPerm cTPermFind_element_user = get_store().find_element_user(PERMEND$46, i);
            if (cTPermFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPermFind_element_user.set(cTPerm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermArr, PERMEND$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPermStart cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$44, i);
            if (cTPermStartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPermStartFind_element_user.set(cTPermStart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermStartArr, PERMSTART$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            CTProofErr cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$42, i);
            if (cTProofErrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProofErrFind_element_user.set(cTProofErr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setSdtArray(int i, CTSdtRow cTSdtRow) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtRow cTSdtRowFind_element_user = get_store().find_element_user(SDT$40, i);
            if (cTSdtRowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtRowFind_element_user.set(cTSdtRow);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setSdtArray(CTSdtRow[] cTSdtRowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtRowArr, SDT$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setTblGrid(CTTblGrid cTTblGrid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLGRID$34;
            CTTblGrid cTTblGridFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblGridFind_element_user == null) {
                cTTblGridFind_element_user = (CTTblGrid) get_store().add_element_user(qName);
            }
            cTTblGridFind_element_user.set(cTTblGrid);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setTblPr(CTTblPr cTTblPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPR$32;
            CTTblPr cTTblPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblPrFind_element_user == null) {
                cTTblPrFind_element_user = (CTTblPr) get_store().add_element_user(qName);
            }
            cTTblPrFind_element_user.set(cTTblPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setTrArray(int i, CTRow cTRow) {
        synchronized (monitor()) {
            check_orphaned();
            CTRow cTRowFind_element_user = get_store().find_element_user(TR$36, i);
            if (cTRowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRowFind_element_user.set(cTRow);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public void setTrArray(CTRow[] cTRowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRowArr, TR$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXML$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SDT$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl
    public int sizeOfTrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TR$36);
        }
        return iCount_elements;
    }
}

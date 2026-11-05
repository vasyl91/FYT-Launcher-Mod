package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTHdrFtrImpl extends XmlComplexContentImpl implements CTHdrFtr {
    private static final QName CUSTOMXML$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SDT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName P$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "p");
    private static final QName TBL$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tbl");
    private static final QName PROOFERR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
    private static final QName ALTCHUNK$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk");

    public CTHdrFtrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTAltChunk addNewAltChunk() {
        CTAltChunk cTAltChunkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAltChunkAdd_element_user = get_store().add_element_user(ALTCHUNK$58);
        }
        return cTAltChunkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(BOOKMARKEND$16);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkAdd_element_user = get_store().add_element_user(BOOKMARKSTART$14);
        }
        return cTBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGEEND$28);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGESTART$26);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTCustomXmlBlock addNewCustomXml() {
        CTCustomXmlBlock cTCustomXmlBlockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlBlockAdd_element_user = get_store().add_element_user(CUSTOMXML$0);
        }
        return cTCustomXmlBlockAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGEEND$36);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGESTART$34);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGEEND$32);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGESTART$30);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$44);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$42);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(DEL$48);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(INS$46);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVEFROM$50);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVEFROMRANGEEND$20);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVEFROMRANGESTART$18);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVETO$52);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVETORANGEEND$24);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVETORANGESTART$22);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMath addNewOMath() {
        CTOMath cTOMathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathAdd_element_user = get_store().add_element_user(OMATH$56);
        }
        return cTOMathAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathParaAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaAdd_element_user = get_store().add_element_user(OMATHPARA$54);
        }
        return cTOMathParaAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTP addNewP() {
        CTP ctpAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctpAdd_element_user = get_store().add_element_user(P$4);
        }
        return ctpAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$12);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$10);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$8);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTSdtBlock addNewSdt() {
        CTSdtBlock cTSdtBlockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlockAdd_element_user = get_store().add_element_user(SDT$2);
        }
        return cTSdtBlockAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTbl addNewTbl() {
        CTTbl cTTblAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblAdd_element_user = get_store().add_element_user(TBL$6);
        }
        return cTTblAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTAltChunk getAltChunkArray(int i) {
        CTAltChunk cTAltChunkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAltChunkFind_element_user = get_store().find_element_user(ALTCHUNK$58, i);
            if (cTAltChunkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAltChunkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTAltChunk[] getAltChunkArray() {
        CTAltChunk[] cTAltChunkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALTCHUNK$58, arrayList);
            cTAltChunkArr = new CTAltChunk[arrayList.size()];
            arrayList.toArray(cTAltChunkArr);
        }
        return cTAltChunkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTAltChunk> getAltChunkList() {
        1AltChunkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AltChunkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(BOOKMARKEND$16, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$16, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkFind_element_user = get_store().find_element_user(BOOKMARKSTART$14, i);
            if (cTBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$14, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGEEND$28, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$28, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGESTART$26, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$26, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTCustomXmlBlock getCustomXmlArray(int i) {
        CTCustomXmlBlock cTCustomXmlBlockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlBlockFind_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (cTCustomXmlBlockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlBlockFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTCustomXmlBlock[] getCustomXmlArray() {
        CTCustomXmlBlock[] cTCustomXmlBlockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$0, arrayList);
            cTCustomXmlBlockArr = new CTCustomXmlBlock[arrayList.size()];
            arrayList.toArray(cTCustomXmlBlockArr);
        }
        return cTCustomXmlBlockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$36, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$34, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$32, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$30, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTCustomXmlBlock> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$40, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$38, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$44, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$42, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(DEL$48, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$48, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(INS$46, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$46, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVEFROM$50, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$50, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(MOVEFROMRANGEEND$20, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$20, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVEFROMRANGESTART$18, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$18, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVETO$52, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$52, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(MOVETORANGEEND$24, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$24, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVETORANGESTART$22, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$22, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathFind_element_user = get_store().find_element_user(OMATH$56, i);
            if (cTOMathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$56, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara cTOMathParaFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaFind_element_user = get_store().find_element_user(OMATHPARA$54, i);
            if (cTOMathParaFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathParaFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$54, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTP getPArray(int i) {
        CTP ctpFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctpFind_element_user = get_store().find_element_user(P$4, i);
            if (ctpFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctpFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTP[] getPArray() {
        CTP[] ctpArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(P$4, arrayList);
            ctpArr = new CTP[arrayList.size()];
            arrayList.toArray(ctpArr);
        }
        return ctpArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTP> getPList() {
        1PList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPerm getPermEndArray(int i) {
        CTPerm cTPermFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermFind_element_user = get_store().find_element_user(PERMEND$12, i);
            if (cTPermFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$12, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPermStart getPermStartArray(int i) {
        CTPermStart cTPermStartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$10, i);
            if (cTPermStartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$10, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$8, i);
            if (cTProofErrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$8, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTSdtBlock getSdtArray(int i) {
        CTSdtBlock cTSdtBlockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlockFind_element_user = get_store().find_element_user(SDT$2, i);
            if (cTSdtBlockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtBlockFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTSdtBlock[] getSdtArray() {
        CTSdtBlock[] cTSdtBlockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$2, arrayList);
            cTSdtBlockArr = new CTSdtBlock[arrayList.size()];
            arrayList.toArray(cTSdtBlockArr);
        }
        return cTSdtBlockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTSdtBlock> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTbl getTblArray(int i) {
        CTTbl cTTblFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblFind_element_user = get_store().find_element_user(TBL$6, i);
            if (cTTblFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTbl[] getTblArray() {
        CTTbl[] cTTblArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBL$6, arrayList);
            cTTblArr = new CTTbl[arrayList.size()];
            arrayList.toArray(cTTblArr);
        }
        return cTTblArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public List<CTTbl> getTblList() {
        1TblList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTAltChunk insertNewAltChunk(int i) {
        CTAltChunk cTAltChunkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAltChunkInsert_element_user = get_store().insert_element_user(ALTCHUNK$58, i);
        }
        return cTAltChunkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(BOOKMARKEND$16, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkInsert_element_user = get_store().insert_element_user(BOOKMARKSTART$14, i);
        }
        return cTBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGEEND$28, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGESTART$26, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTCustomXmlBlock insertNewCustomXml(int i) {
        CTCustomXmlBlock cTCustomXmlBlockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlBlockInsert_element_user = get_store().insert_element_user(CUSTOMXML$0, i);
        }
        return cTCustomXmlBlockInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGEEND$36, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGESTART$34, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGEEND$32, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGESTART$30, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(DEL$48, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(INS$46, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVEFROM$50, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVEFROMRANGEEND$20, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVEFROMRANGESTART$18, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVETO$52, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVETORANGEEND$24, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVETORANGESTART$22, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathInsert_element_user = get_store().insert_element_user(OMATH$56, i);
        }
        return cTOMathInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathParaInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaInsert_element_user = get_store().insert_element_user(OMATHPARA$54, i);
        }
        return cTOMathParaInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTP insertNewP(int i) {
        CTP ctpInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctpInsert_element_user = get_store().insert_element_user(P$4, i);
        }
        return ctpInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$12, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$10, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$8, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTSdtBlock insertNewSdt(int i) {
        CTSdtBlock cTSdtBlockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlockInsert_element_user = get_store().insert_element_user(SDT$2, i);
        }
        return cTSdtBlockInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public CTTbl insertNewTbl(int i) {
        CTTbl cTTblInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblInsert_element_user = get_store().insert_element_user(TBL$6, i);
        }
        return cTTblInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeAltChunk(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALTCHUNK$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeP(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(P$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void removeTbl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBL$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setAltChunkArray(int i, CTAltChunk cTAltChunk) {
        synchronized (monitor()) {
            check_orphaned();
            CTAltChunk cTAltChunkFind_element_user = get_store().find_element_user(ALTCHUNK$58, i);
            if (cTAltChunkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAltChunkFind_element_user.set(cTAltChunk);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setAltChunkArray(CTAltChunk[] cTAltChunkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAltChunkArr, ALTCHUNK$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(BOOKMARKEND$16, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookmark cTBookmarkFind_element_user = get_store().find_element_user(BOOKMARKSTART$14, i);
            if (cTBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookmarkFind_element_user.set(cTBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGEEND$28, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGESTART$26, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlArray(int i, CTCustomXmlBlock cTCustomXmlBlock) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlBlock cTCustomXmlBlockFind_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (cTCustomXmlBlockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCustomXmlBlockFind_element_user.set(cTCustomXmlBlock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlArray(CTCustomXmlBlock[] cTCustomXmlBlockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCustomXmlBlockArr, CUSTOMXML$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(DEL$48, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(INS$46, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVEFROM$50, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(MOVEFROMRANGEEND$20, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVEFROMRANGESTART$18, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmarkFind_element_user.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVETO$52, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(MOVETORANGEEND$24, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVETORANGESTART$22, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmarkFind_element_user.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMath cTOMathFind_element_user = get_store().find_element_user(OMATH$56, i);
            if (cTOMathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOMathFind_element_user.set(cTOMath);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMathPara cTOMathParaFind_element_user = get_store().find_element_user(OMATHPARA$54, i);
            if (cTOMathParaFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOMathParaFind_element_user.set(cTOMathPara);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setPArray(int i, CTP ctp) {
        synchronized (monitor()) {
            check_orphaned();
            CTP ctpFind_element_user = get_store().find_element_user(P$4, i);
            if (ctpFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            ctpFind_element_user.set(ctp);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setPArray(CTP[] ctpArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctpArr, P$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            check_orphaned();
            CTPerm cTPermFind_element_user = get_store().find_element_user(PERMEND$12, i);
            if (cTPermFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPermFind_element_user.set(cTPerm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermArr, PERMEND$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPermStart cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$10, i);
            if (cTPermStartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPermStartFind_element_user.set(cTPermStart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermStartArr, PERMSTART$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            CTProofErr cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$8, i);
            if (cTProofErrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProofErrFind_element_user.set(cTProofErr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setSdtArray(int i, CTSdtBlock cTSdtBlock) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtBlock cTSdtBlockFind_element_user = get_store().find_element_user(SDT$2, i);
            if (cTSdtBlockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtBlockFind_element_user.set(cTSdtBlock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setSdtArray(CTSdtBlock[] cTSdtBlockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtBlockArr, SDT$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setTblArray(int i, CTTbl cTTbl) {
        synchronized (monitor()) {
            check_orphaned();
            CTTbl cTTblFind_element_user = get_store().find_element_user(TBL$6, i);
            if (cTTblFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTblFind_element_user.set(cTTbl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public void setTblArray(CTTbl[] cTTblArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTblArr, TBL$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfAltChunkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ALTCHUNK$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXML$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfPArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(P$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SDT$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr
    public int sizeOfTblArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TBL$6);
        }
        return iCount_elements;
    }
}

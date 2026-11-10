package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRubyContentImpl extends XmlComplexContentImpl implements CTRubyContent {
    private static final QName R$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "r");
    private static final QName PROOFERR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$48 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$50 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");

    public CTRubyContentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(BOOKMARKEND$10);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkAdd_element_user = get_store().add_element_user(BOOKMARKSTART$8);
        }
        return cTBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGEEND$22);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGESTART$20);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGEEND$30);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGESTART$28);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGEEND$26);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGESTART$24);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$34);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$32);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$38);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$36);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(DEL$42);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(INS$40);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVEFROM$44);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVEFROMRANGEEND$14);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVEFROMRANGESTART$12);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVETO$46);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVETORANGEEND$18);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVETORANGESTART$16);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMath addNewOMath() {
        CTOMath cTOMathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathAdd_element_user = get_store().add_element_user(OMATH$50);
        }
        return cTOMathAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathParaAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaAdd_element_user = get_store().add_element_user(OMATHPARA$48);
        }
        return cTOMathParaAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$6);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$4);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$2);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTR addNewR() {
        CTR ctrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrAdd_element_user = get_store().add_element_user(R$0);
        }
        return ctrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(BOOKMARKEND$10, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$10, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkFind_element_user = get_store().find_element_user(BOOKMARKSTART$8, i);
            if (cTBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$8, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGEEND$22, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$22, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGESTART$20, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$20, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGEEND$30, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$30, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGESTART$28, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$28, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGEEND$26, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$26, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGESTART$24, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$24, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$34, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$34, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$32, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$32, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$38, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$38, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$36, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$36, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(DEL$42, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$42, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(INS$40, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$40, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVEFROM$44, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$44, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(MOVEFROMRANGEEND$14, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$14, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVEFROMRANGESTART$12, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$12, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVETO$46, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$46, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeFind_element_user = get_store().find_element_user(MOVETORANGEEND$18, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$18, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmarkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVETORANGESTART$16, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmarkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$16, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathFind_element_user = get_store().find_element_user(OMATH$50, i);
            if (cTOMathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$50, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara cTOMathParaFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaFind_element_user = get_store().find_element_user(OMATHPARA$48, i);
            if (cTOMathParaFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathParaFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$48, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPerm getPermEndArray(int i) {
        CTPerm cTPermFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermFind_element_user = get_store().find_element_user(PERMEND$6, i);
            if (cTPermFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$6, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPermStart getPermStartArray(int i) {
        CTPermStart cTPermStartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$4, i);
            if (cTPermStartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$4, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$2, i);
            if (cTProofErrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$2, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTR getRArray(int i) {
        CTR ctrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrFind_element_user = get_store().find_element_user(R$0, i);
            if (ctrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$0, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public List<CTR> getRList() {
        1RList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(BOOKMARKEND$10, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkInsert_element_user = get_store().insert_element_user(BOOKMARKSTART$8, i);
        }
        return cTBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGEEND$22, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGESTART$20, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGEEND$30, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGESTART$28, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGEEND$26, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGESTART$24, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$34, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$32, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$38, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$36, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(DEL$42, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(INS$40, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVEFROM$44, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVEFROMRANGEEND$14, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVEFROMRANGESTART$12, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVETO$46, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVETORANGEEND$18, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVETORANGESTART$16, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathInsert_element_user = get_store().insert_element_user(OMATH$50, i);
        }
        return cTOMathInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathParaInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaInsert_element_user = get_store().insert_element_user(OMATHPARA$48, i);
        }
        return cTOMathParaInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$6, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$4, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$2, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public CTR insertNewR(int i) {
        CTR ctrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrInsert_element_user = get_store().insert_element_user(R$0, i);
        }
        return ctrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(BOOKMARKEND$10, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookmark cTBookmarkFind_element_user = get_store().find_element_user(BOOKMARKSTART$8, i);
            if (cTBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookmarkFind_element_user.set(cTBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGEEND$22, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(COMMENTRANGESTART$20, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGEEND$30, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLDELRANGESTART$28, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGEEND$26, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLINSRANGESTART$24, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$34, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$32, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkupFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$38, i);
            if (cTMarkupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupFind_element_user.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$36, i);
            if (cTTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(DEL$42, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(INS$40, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVEFROM$44, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(MOVEFROMRANGEEND$14, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVEFROMRANGESTART$12, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmarkFind_element_user.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChangeFind_element_user = get_store().find_element_user(MOVETO$46, i);
            if (cTRunTrackChangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChangeFind_element_user.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRangeFind_element_user = get_store().find_element_user(MOVETORANGEEND$18, i);
            if (cTMarkupRangeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRangeFind_element_user.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmarkFind_element_user = get_store().find_element_user(MOVETORANGESTART$16, i);
            if (cTMoveBookmarkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmarkFind_element_user.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMath cTOMathFind_element_user = get_store().find_element_user(OMATH$50, i);
            if (cTOMathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOMathFind_element_user.set(cTOMath);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMathPara cTOMathParaFind_element_user = get_store().find_element_user(OMATHPARA$48, i);
            if (cTOMathParaFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOMathParaFind_element_user.set(cTOMathPara);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            check_orphaned();
            CTPerm cTPermFind_element_user = get_store().find_element_user(PERMEND$6, i);
            if (cTPermFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPermFind_element_user.set(cTPerm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermArr, PERMEND$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPermStart cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$4, i);
            if (cTPermStartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPermStartFind_element_user.set(cTPermStart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermStartArr, PERMSTART$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            CTProofErr cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$2, i);
            if (cTProofErrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProofErrFind_element_user.set(cTProofErr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            check_orphaned();
            CTR ctrFind_element_user = get_store().find_element_user(R$0, i);
            if (ctrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            ctrFind_element_user.set(ctr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctrArr, R$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$0);
        }
        return iCount_elements;
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSdtContentRunImpl extends XmlComplexContentImpl implements CTSdtContentRun {
    private static final QName CUSTOMXML$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SMARTTAG$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag");
    private static final QName SDT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName R$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "r");
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
    private static final QName FLDSIMPLE$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldSimple");
    private static final QName HYPERLINK$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hyperlink");
    private static final QName SUBDOC$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "subDoc");

    public CTSdtContentRunImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(BOOKMARKEND$16);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkAdd_element_user = get_store().add_element_user(BOOKMARKSTART$14);
        }
        return cTBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGEEND$28);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(COMMENTRANGESTART$26);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTCustomXmlRun addNewCustomXml() {
        CTCustomXmlRun cTCustomXmlRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRunAdd_element_user = get_store().add_element_user(CUSTOMXML$0);
        }
        return cTCustomXmlRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGEEND$36);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLDELRANGESTART$34);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGEEND$32);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLINSRANGESTART$30);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$44);
        }
        return cTMarkupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$42);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(DEL$48);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSimpleField addNewFldSimple() {
        CTSimpleField cTSimpleFieldAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleFieldAdd_element_user = get_store().add_element_user(FLDSIMPLE$58);
        }
        return cTSimpleFieldAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTHyperlink addNewHyperlink() {
        CTHyperlink cTHyperlinkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlinkAdd_element_user = get_store().add_element_user(HYPERLINK$60);
        }
        return cTHyperlinkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(INS$46);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVEFROM$50);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVEFROMRANGEEND$20);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVEFROMRANGESTART$18);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeAdd_element_user = get_store().add_element_user(MOVETO$52);
        }
        return cTRunTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeAdd_element_user = get_store().add_element_user(MOVETORANGEEND$24);
        }
        return cTMarkupRangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmarkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkAdd_element_user = get_store().add_element_user(MOVETORANGESTART$22);
        }
        return cTMoveBookmarkAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTOMath addNewOMath() {
        CTOMath cTOMathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathAdd_element_user = get_store().add_element_user(OMATH$56);
        }
        return cTOMathAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathParaAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaAdd_element_user = get_store().add_element_user(OMATHPARA$54);
        }
        return cTOMathParaAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$12);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$10);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$8);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTR addNewR() {
        CTR ctrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrAdd_element_user = get_store().add_element_user(R$6);
        }
        return ctrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSdtRun addNewSdt() {
        CTSdtRun cTSdtRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRunAdd_element_user = get_store().add_element_user(SDT$4);
        }
        return cTSdtRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSmartTagRun addNewSmartTag() {
        CTSmartTagRun cTSmartTagRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRunAdd_element_user = get_store().add_element_user(SMARTTAG$2);
        }
        return cTSmartTagRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRel addNewSubDoc() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(SUBDOC$62);
        }
        return cTRelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTCustomXmlRun getCustomXmlArray(int i) {
        CTCustomXmlRun cTCustomXmlRunFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRunFind_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (cTCustomXmlRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlRunFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTCustomXmlRun[] getCustomXmlArray() {
        CTCustomXmlRun[] cTCustomXmlRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$0, arrayList);
            cTCustomXmlRunArr = new CTCustomXmlRun[arrayList.size()];
            arrayList.toArray(cTCustomXmlRunArr);
        }
        return cTCustomXmlRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTCustomXmlRun> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSimpleField getFldSimpleArray(int i) {
        CTSimpleField cTSimpleFieldFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleFieldFind_element_user = get_store().find_element_user(FLDSIMPLE$58, i);
            if (cTSimpleFieldFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSimpleFieldFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSimpleField[] getFldSimpleArray() {
        CTSimpleField[] cTSimpleFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FLDSIMPLE$58, arrayList);
            cTSimpleFieldArr = new CTSimpleField[arrayList.size()];
            arrayList.toArray(cTSimpleFieldArr);
        }
        return cTSimpleFieldArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTSimpleField> getFldSimpleList() {
        1FldSimpleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FldSimpleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTHyperlink getHyperlinkArray(int i) {
        CTHyperlink cTHyperlinkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlinkFind_element_user = get_store().find_element_user(HYPERLINK$60, i);
            if (cTHyperlinkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHyperlinkFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTHyperlink[] getHyperlinkArray() {
        CTHyperlink[] cTHyperlinkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HYPERLINK$60, arrayList);
            cTHyperlinkArr = new CTHyperlink[arrayList.size()];
            arrayList.toArray(cTHyperlinkArr);
        }
        return cTHyperlinkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTHyperlink> getHyperlinkList() {
        1HyperlinkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HyperlinkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTR getRArray(int i) {
        CTR ctrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrFind_element_user = get_store().find_element_user(R$6, i);
            if (ctrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$6, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTR> getRList() {
        1RList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSdtRun getSdtArray(int i) {
        CTSdtRun cTSdtRunFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRunFind_element_user = get_store().find_element_user(SDT$4, i);
            if (cTSdtRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtRunFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSdtRun[] getSdtArray() {
        CTSdtRun[] cTSdtRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$4, arrayList);
            cTSdtRunArr = new CTSdtRun[arrayList.size()];
            arrayList.toArray(cTSdtRunArr);
        }
        return cTSdtRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTSdtRun> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSmartTagRun getSmartTagArray(int i) {
        CTSmartTagRun cTSmartTagRunFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRunFind_element_user = get_store().find_element_user(SMARTTAG$2, i);
            if (cTSmartTagRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSmartTagRunFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSmartTagRun[] getSmartTagArray() {
        CTSmartTagRun[] cTSmartTagRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SMARTTAG$2, arrayList);
            cTSmartTagRunArr = new CTSmartTagRun[arrayList.size()];
            arrayList.toArray(cTSmartTagRunArr);
        }
        return cTSmartTagRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTSmartTagRun> getSmartTagList() {
        1SmartTagList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SmartTagList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRel getSubDocArray(int i) {
        CTRel cTRelFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelFind_element_user = get_store().find_element_user(SUBDOC$62, i);
            if (cTRelFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRelFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRel[] getSubDocArray() {
        CTRel[] cTRelArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SUBDOC$62, arrayList);
            cTRelArr = new CTRel[arrayList.size()];
            arrayList.toArray(cTRelArr);
        }
        return cTRelArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public List<CTRel> getSubDocList() {
        1SubDocList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SubDocList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(BOOKMARKEND$16, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmarkInsert_element_user = get_store().insert_element_user(BOOKMARKSTART$14, i);
        }
        return cTBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGEEND$28, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(COMMENTRANGESTART$26, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTCustomXmlRun insertNewCustomXml(int i) {
        CTCustomXmlRun cTCustomXmlRunInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRunInsert_element_user = get_store().insert_element_user(CUSTOMXML$0, i);
        }
        return cTCustomXmlRunInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGEEND$36, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLDELRANGESTART$34, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGEEND$32, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLINSRANGESTART$30, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
        }
        return cTMarkupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeInsert_element_user = get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
        }
        return cTTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(DEL$48, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSimpleField insertNewFldSimple(int i) {
        CTSimpleField cTSimpleFieldInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleFieldInsert_element_user = get_store().insert_element_user(FLDSIMPLE$58, i);
        }
        return cTSimpleFieldInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTHyperlink insertNewHyperlink(int i) {
        CTHyperlink cTHyperlinkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlinkInsert_element_user = get_store().insert_element_user(HYPERLINK$60, i);
        }
        return cTHyperlinkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(INS$46, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVEFROM$50, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVEFROMRANGEEND$20, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVEFROMRANGESTART$18, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChangeInsert_element_user = get_store().insert_element_user(MOVETO$52, i);
        }
        return cTRunTrackChangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRangeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRangeInsert_element_user = get_store().insert_element_user(MOVETORANGEEND$24, i);
        }
        return cTMarkupRangeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmarkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmarkInsert_element_user = get_store().insert_element_user(MOVETORANGESTART$22, i);
        }
        return cTMoveBookmarkInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathInsert_element_user = get_store().insert_element_user(OMATH$56, i);
        }
        return cTOMathInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathParaInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaInsert_element_user = get_store().insert_element_user(OMATHPARA$54, i);
        }
        return cTOMathParaInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$12, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$10, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$8, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTR insertNewR(int i) {
        CTR ctrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrInsert_element_user = get_store().insert_element_user(R$6, i);
        }
        return ctrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSdtRun insertNewSdt(int i) {
        CTSdtRun cTSdtRunInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRunInsert_element_user = get_store().insert_element_user(SDT$4, i);
        }
        return cTSdtRunInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTSmartTagRun insertNewSmartTag(int i) {
        CTSmartTagRun cTSmartTagRunInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRunInsert_element_user = get_store().insert_element_user(SMARTTAG$2, i);
        }
        return cTSmartTagRunInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public CTRel insertNewSubDoc(int i) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(SUBDOC$62, i);
        }
        return cTRelInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeFldSimple(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLDSIMPLE$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeHyperlink(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPERLINK$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeSmartTag(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAG$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void removeSubDoc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUBDOC$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlArray(int i, CTCustomXmlRun cTCustomXmlRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlRun cTCustomXmlRunFind_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (cTCustomXmlRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCustomXmlRunFind_element_user.set(cTCustomXmlRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCustomXmlRunArr, CUSTOMXML$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setFldSimpleArray(int i, CTSimpleField cTSimpleField) {
        synchronized (monitor()) {
            check_orphaned();
            CTSimpleField cTSimpleFieldFind_element_user = get_store().find_element_user(FLDSIMPLE$58, i);
            if (cTSimpleFieldFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSimpleFieldFind_element_user.set(cTSimpleField);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSimpleFieldArr, FLDSIMPLE$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setHyperlinkArray(int i, CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlinkFind_element_user = get_store().find_element_user(HYPERLINK$60, i);
            if (cTHyperlinkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHyperlinkFind_element_user.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHyperlinkArr, HYPERLINK$60);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermArr, PERMEND$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermStartArr, PERMSTART$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            check_orphaned();
            CTR ctrFind_element_user = get_store().find_element_user(R$6, i);
            if (ctrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            ctrFind_element_user.set(ctr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctrArr, R$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setSdtArray(int i, CTSdtRun cTSdtRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtRun cTSdtRunFind_element_user = get_store().find_element_user(SDT$4, i);
            if (cTSdtRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtRunFind_element_user.set(cTSdtRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setSdtArray(CTSdtRun[] cTSdtRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtRunArr, SDT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setSmartTagArray(int i, CTSmartTagRun cTSmartTagRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagRun cTSmartTagRunFind_element_user = get_store().find_element_user(SMARTTAG$2, i);
            if (cTSmartTagRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSmartTagRunFind_element_user.set(cTSmartTagRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSmartTagRunArr, SMARTTAG$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setSubDocArray(int i, CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            CTRel cTRelFind_element_user = get_store().find_element_user(SUBDOC$62, i);
            if (cTRelFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRelFind_element_user.set(cTRel);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public void setSubDocArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRelArr, SUBDOC$62);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXML$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfFldSimpleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FLDSIMPLE$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfHyperlinkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HYPERLINK$60);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SDT$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfSmartTagArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SMARTTAG$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun
    public int sizeOfSubDocArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SUBDOC$62);
        }
        return iCount_elements;
    }
}

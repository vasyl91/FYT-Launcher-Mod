package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.codehaus.stax2.validation.ValidatorPair;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
final class Cur {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int DISPOSED = 3;
    static final int ELEM = 2;
    static final int EMBEDDED = 2;
    static final int END_POS = -1;
    static final String LOAD_USE_LOCALE_CHAR_UTIL = "LOAD_USE_LOCALE_CHAR_UTIL";
    static final int NO_POS = -2;
    static final int POOLED = 0;
    static final int PROCINST = 5;
    static final int REGISTERED = 1;
    static final int ROOT = 1;
    static final int TEXT = 0;
    int _cchSrc;
    String _id;
    Locale _locale;
    Cur _next;
    Cur _nextTemp;
    int _offSrc;
    private int _posTemp;
    Cur _prev;
    Cur _prevTemp;
    Locale.Ref _ref;
    Xobj _xobj;
    int _pos = -2;
    int _tempFrame = -1;
    int _state = 0;
    int _stackTop = -1;
    int _selectionFirst = -1;
    int _selectionN = -1;
    int _selectionLoc = -1;
    int _selectionCount = 0;

    static void dump(PrintStream printStream, DomImpl.Dom dom, Object obj) {
    }

    static boolean kindIsContainer(int i) {
        if (i == 2 || i == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    static boolean kindIsFinish(int i) {
        if (i == -2 || i == -1) {
            return true;
        }
        return $assertionsDisabled;
    }

    Cur(Locale locale) {
        this._locale = locale;
    }

    boolean isPositioned() {
        if (this._xobj != null) {
            return true;
        }
        return $assertionsDisabled;
    }

    int kind() {
        int iKind = this._xobj.kind();
        int i = this._pos;
        if (i == 0) {
            return iKind;
        }
        if (i == -1) {
            return -iKind;
        }
        return 0;
    }

    boolean isRoot() {
        if (this._pos == 0 && this._xobj.kind() == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isElem() {
        if (this._pos == 0 && this._xobj.kind() == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isAttr() {
        if (this._pos == 0 && this._xobj.kind() == 3) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isComment() {
        if (this._pos == 0 && this._xobj.kind() == 4) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isProcinst() {
        if (this._pos == 0 && this._xobj.kind() == 5) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isText() {
        if (this._pos > 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isEnd() {
        if (this._pos == -1 && this._xobj.kind() == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isEndRoot() {
        if (this._pos == -1 && this._xobj.kind() == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isNode() {
        if (this._pos == 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isContainer() {
        if (this._pos == 0 && kindIsContainer(this._xobj.kind())) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isFinish() {
        if (this._pos == -1 && kindIsContainer(this._xobj.kind())) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isUserNode() {
        int iKind = kind();
        if (iKind == 2 || iKind == 1) {
            return true;
        }
        if (iKind != 3 || isXmlns()) {
            return $assertionsDisabled;
        }
        return true;
    }

    boolean isContainerOrFinish() {
        int i = this._pos;
        if (i != 0 && i != -1) {
            return $assertionsDisabled;
        }
        int iKind = this._xobj.kind();
        if (iKind == 2 || iKind == -2 || iKind == 1 || iKind == -1) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isNormalAttr() {
        if (isNode() && this._xobj.isNormalAttr()) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isXmlns() {
        if (isNode() && this._xobj.isXmlns()) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isTextCData() {
        return this._xobj.hasBookmark(CDataBookmark.class, this._pos);
    }

    QName getName() {
        return this._xobj._name;
    }

    String getLocal() {
        return getName().getLocalPart();
    }

    String getUri() {
        return getName().getNamespaceURI();
    }

    String getXmlnsPrefix() {
        return this._xobj.getXmlnsPrefix();
    }

    String getXmlnsUri() {
        return this._xobj.getXmlnsUri();
    }

    boolean isDomDocRoot() {
        if (isRoot() && (this._xobj.getDom() instanceof Document)) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isDomFragRoot() {
        if (isRoot() && (this._xobj.getDom() instanceof DocumentFragment)) {
            return true;
        }
        return $assertionsDisabled;
    }

    int cchRight() {
        return this._xobj.cchRight(this._pos);
    }

    int cchLeft() {
        return this._xobj.cchLeft(this._pos);
    }

    void createRoot() {
        createDomDocFragRoot();
    }

    void createDomDocFragRoot() {
        moveTo(new Xobj.DocumentFragXobj(this._locale));
    }

    void createDomDocumentRoot() {
        moveTo(createDomDocumentRootXobj(this._locale));
    }

    void createAttr(QName qName) {
        createHelper(new Xobj.AttrXobj(this._locale, qName));
    }

    void createComment() {
        createHelper(new Xobj.CommentXobj(this._locale));
    }

    void createProcinst(String str) {
        createHelper(new Xobj.ProcInstXobj(this._locale, str));
    }

    void createElement(QName qName) {
        createElement(qName, null);
    }

    void createElement(QName qName, QName qName2) {
        createHelper(createElementXobj(this._locale, qName, qName2));
    }

    static Xobj createDomDocumentRootXobj(Locale locale) {
        return createDomDocumentRootXobj(locale, $assertionsDisabled);
    }

    static Xobj createDomDocumentRootXobj(Locale locale, boolean z) {
        Xobj soapPartDocXobj;
        if (locale._saaj != null) {
            soapPartDocXobj = new Xobj.SoapPartDocXobj(locale);
        } else if (z) {
            soapPartDocXobj = new Xobj.DocumentFragXobj(locale);
        } else {
            soapPartDocXobj = new Xobj.DocumentXobj(locale);
        }
        if (locale._ownerDoc == null) {
            locale._ownerDoc = soapPartDocXobj.getDom();
        }
        return soapPartDocXobj;
    }

    static Xobj createElementXobj(Locale locale, QName qName, QName qName2) {
        if (locale._saaj == null) {
            return new Xobj.ElementXobj(locale, qName);
        }
        Class clsIdentifyElement = locale._saaj.identifyElement(qName, qName2);
        if (clsIdentifyElement == SOAPElement.class) {
            return new Xobj.SoapElementXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPBody.class) {
            return new Xobj.SoapBodyXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPBodyElement.class) {
            return new Xobj.SoapBodyElementXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPEnvelope.class) {
            return new Xobj.SoapEnvelopeXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPHeader.class) {
            return new Xobj.SoapHeaderXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPHeaderElement.class) {
            return new Xobj.SoapHeaderElementXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPFaultElement.class) {
            return new Xobj.SoapFaultElementXobj(locale, qName);
        }
        if (clsIdentifyElement == Detail.class) {
            return new Xobj.DetailXobj(locale, qName);
        }
        if (clsIdentifyElement == DetailEntry.class) {
            return new Xobj.DetailEntryXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPFault.class) {
            return new Xobj.SoapFaultXobj(locale, qName);
        }
        throw new IllegalStateException("Unknown SAAJ element class: " + clsIdentifyElement);
    }

    private void createHelper(Xobj xobj) {
        if (isPositioned()) {
            Cur curTempCur = tempCur(xobj, 0);
            curTempCur.moveNode(this);
            curTempCur.release();
        }
        moveTo(xobj);
    }

    boolean isSamePos(Cur cur) {
        if (this._xobj == cur._xobj && this._pos == cur._pos) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isJustAfterEnd(Cur cur) {
        return cur._xobj.isJustAfterEnd(this._xobj, this._pos);
    }

    boolean isJustAfterEnd(Xobj xobj) {
        return xobj.isJustAfterEnd(this._xobj, this._pos);
    }

    boolean isAtEndOf(Cur cur) {
        if (this._xobj == cur._xobj && this._pos == -1) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isInSameTree(Cur cur) {
        return this._xobj.isInSameTree(cur._xobj);
    }

    int comparePosition(Cur cur) {
        if (this._locale != cur._locale) {
            return 2;
        }
        Xobj xobj = this._xobj;
        int iPosAfter = this._pos;
        if (iPosAfter == -1) {
            iPosAfter = xobj.posAfter() - 1;
        }
        Xobj xobj2 = cur._xobj;
        int iPosAfter2 = cur._pos;
        if (iPosAfter2 == -1) {
            iPosAfter2 = xobj2.posAfter() - 1;
        }
        int i = 0;
        if (xobj == xobj2) {
            if (iPosAfter < iPosAfter2) {
                return -1;
            }
            return iPosAfter == iPosAfter2 ? 0 : 1;
        }
        int i2 = 0;
        for (Xobj xobj3 = xobj._parent; xobj3 != null; xobj3 = xobj3._parent) {
            i2++;
            if (xobj3 == xobj2) {
                return iPosAfter2 < xobj2.posAfter() - 1 ? 1 : -1;
            }
        }
        for (Xobj xobj4 = xobj2._parent; xobj4 != null; xobj4 = xobj4._parent) {
            i++;
            if (xobj4 == xobj) {
                return iPosAfter < xobj.posAfter() - 1 ? -1 : 1;
            }
        }
        while (i2 > i) {
            i2--;
            xobj = xobj._parent;
        }
        while (i > i2) {
            i--;
            xobj2 = xobj2._parent;
        }
        if (i == 0) {
            return 2;
        }
        while (xobj._parent != xobj2._parent) {
            xobj = xobj._parent;
            if (xobj == null) {
                return 2;
            }
            xobj2 = xobj2._parent;
        }
        if (xobj._prevSibling == null || xobj2._nextSibling == null) {
            return -1;
        }
        if (xobj._nextSibling == null || xobj2._prevSibling == null) {
            return 1;
        }
        while (xobj != null) {
            xobj = xobj._prevSibling;
            if (xobj == xobj2) {
                return 1;
            }
        }
        return -1;
    }

    void setName(QName qName) {
        this._xobj.setName(qName);
    }

    void moveTo(Xobj xobj) {
        moveTo(xobj, 0);
    }

    void moveTo(Xobj xobj, int i) {
        moveToNoCheck(xobj, i);
    }

    void moveToNoCheck(Xobj xobj, int i) {
        Xobj xobj2;
        if (this._state == 2 && xobj != (xobj2 = this._xobj)) {
            xobj2._embedded = listRemove(xobj2._embedded);
            Locale locale = this._locale;
            locale._registered = listInsert(locale._registered);
            this._state = 1;
        }
        this._xobj = xobj;
        this._pos = i;
    }

    void moveToCur(Cur cur) {
        if (cur == null) {
            moveTo(null, -2);
        } else {
            moveTo(cur._xobj, cur._pos);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void moveToDom(DomImpl.Dom dom) {
        moveTo(dom instanceof Xobj ? (Xobj) dom : ((Xobj.SoapPartDom) dom)._docXobj);
    }

    static final class Locations {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int NULL = -1;
        private static final int _initialSize = 32;
        private int _free;
        private Locale _locale;
        private int _naked;
        private Xobj[] _xobjs = new Xobj[32];
        private int[] _poses = new int[32];
        private Cur[] _curs = new Cur[32];
        private int[] _next = new int[32];
        private int[] _prev = new int[32];
        private int[] _nextN = new int[32];
        private int[] _prevN = new int[32];

        Locations(Locale locale) {
            this._locale = locale;
            for (int i = 31; i >= 0; i--) {
                this._poses[i] = -2;
                this._next[i] = i + 1;
                this._prev[i] = -1;
                this._nextN[i] = -1;
                this._prevN[i] = -1;
            }
            this._next[31] = -1;
            this._free = 0;
            this._naked = -1;
        }

        boolean isSamePos(int i, Cur cur) {
            Cur cur2 = this._curs[i];
            if (cur2 == null) {
                if (cur._xobj == this._xobjs[i] && cur._pos == this._poses[i]) {
                    return true;
                }
                return $assertionsDisabled;
            }
            return cur.isSamePos(cur2);
        }

        boolean isAtEndOf(int i, Cur cur) {
            Cur cur2 = this._curs[i];
            if (cur2 == null) {
                if (cur._xobj == this._xobjs[i] && cur._pos == -1) {
                    return true;
                }
                return $assertionsDisabled;
            }
            return cur.isAtEndOf(cur2);
        }

        void moveTo(int i, Cur cur) {
            Cur cur2 = this._curs[i];
            if (cur2 == null) {
                cur.moveTo(this._xobjs[i], this._poses[i]);
            } else {
                cur.moveToCur(cur2);
            }
        }

        int insert(int i, int i2, int i3) {
            return insert(i, i2, i3, this._next, this._prev);
        }

        int remove(int i, int i2) {
            Cur cur = this._curs[i2];
            if (cur != null) {
                cur.release();
                this._curs[i2] = null;
            } else {
                this._xobjs[i2] = null;
                this._poses[i2] = -2;
                this._naked = remove(this._naked, i2, this._nextN, this._prevN);
            }
            int iRemove = remove(i, i2, this._next, this._prev);
            this._next[i2] = this._free;
            this._free = i2;
            return iRemove;
        }

        int allocate(Cur cur) {
            if (this._free == -1) {
                makeRoom();
            }
            int i = this._free;
            int[] iArr = this._next;
            this._free = iArr[i];
            iArr[i] = -1;
            this._xobjs[i] = cur._xobj;
            this._poses[i] = cur._pos;
            this._naked = insert(this._naked, -1, i, this._nextN, this._prevN);
            return i;
        }

        private static int insert(int i, int i2, int i3, int[] iArr, int[] iArr2) {
            if (i == -1) {
                iArr2[i3] = i3;
            } else if (i2 != -1) {
                iArr2[i3] = iArr2[i2];
                iArr[i3] = i2;
                iArr2[i2] = i3;
                if (i != i2) {
                    return i;
                }
            } else {
                iArr2[i3] = iArr2[i];
                iArr[iArr2[i]] = i3;
                iArr2[i] = i3;
                return i;
            }
            return i3;
        }

        private static int remove(int i, int i2, int[] iArr, int[] iArr2) {
            int i3 = iArr2[i2];
            if (i3 == i2) {
                i = -1;
            } else {
                if (i == i2) {
                    i = iArr[i2];
                } else {
                    iArr[i3] = iArr[i2];
                }
                int i4 = iArr[i2];
                if (i4 == -1) {
                    iArr2[i] = iArr2[i2];
                } else {
                    iArr2[i4] = iArr2[i2];
                    iArr[i2] = -1;
                }
            }
            iArr2[i2] = -1;
            return i;
        }

        void notifyChange() {
            while (true) {
                int i = this._naked;
                if (i == -1) {
                    return;
                }
                this._naked = remove(i, i, this._nextN, this._prevN);
                this._curs[i] = this._locale.getCur();
                this._curs[i].moveTo(this._xobjs[i], this._poses[i]);
                this._xobjs[i] = null;
                this._poses[i] = -2;
            }
        }

        int next(int i) {
            return this._next[i];
        }

        int prev(int i) {
            return this._prev[i];
        }

        private void makeRoom() {
            Xobj[] xobjArr = this._xobjs;
            int length = xobjArr.length;
            int[] iArr = this._poses;
            Cur[] curArr = this._curs;
            int[] iArr2 = this._next;
            int[] iArr3 = this._prev;
            int[] iArr4 = this._nextN;
            int[] iArr5 = this._prevN;
            int i = length * 2;
            Xobj[] xobjArr2 = new Xobj[i];
            this._xobjs = xobjArr2;
            this._poses = new int[i];
            this._curs = new Cur[i];
            this._next = new int[i];
            this._prev = new int[i];
            this._nextN = new int[i];
            this._prevN = new int[i];
            System.arraycopy(xobjArr, 0, xobjArr2, 0, length);
            System.arraycopy(iArr, 0, this._poses, 0, length);
            System.arraycopy(curArr, 0, this._curs, 0, length);
            System.arraycopy(iArr2, 0, this._next, 0, length);
            System.arraycopy(iArr3, 0, this._prev, 0, length);
            System.arraycopy(iArr4, 0, this._nextN, 0, length);
            System.arraycopy(iArr5, 0, this._prevN, 0, length);
            int i2 = i - 1;
            for (int i3 = i2; i3 >= length; i3--) {
                this._next[i3] = i3 + 1;
                this._prev[i3] = -1;
                this._nextN[i3] = -1;
                this._prevN[i3] = -1;
                this._poses[i3] = -2;
            }
            this._next[i2] = -1;
            this._free = length;
        }
    }

    void push() {
        int iAllocate = this._locale._locations.allocate(this);
        Locations locations = this._locale._locations;
        int i = this._stackTop;
        this._stackTop = locations.insert(i, i, iAllocate);
    }

    void pop(boolean z) {
        if (z) {
            popButStay();
        } else {
            pop();
        }
    }

    void popButStay() {
        if (this._stackTop != -1) {
            Locations locations = this._locale._locations;
            int i = this._stackTop;
            this._stackTop = locations.remove(i, i);
        }
    }

    boolean pop() {
        if (this._stackTop == -1) {
            return $assertionsDisabled;
        }
        this._locale._locations.moveTo(this._stackTop, this);
        Locations locations = this._locale._locations;
        int i = this._stackTop;
        this._stackTop = locations.remove(i, i);
        return true;
    }

    boolean isAtLastPush() {
        return this._locale._locations.isSamePos(this._stackTop, this);
    }

    boolean isAtEndOfLastPush() {
        return this._locale._locations.isAtEndOf(this._stackTop, this);
    }

    void addToSelection(Cur cur) {
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(cur));
        this._selectionCount++;
    }

    void addToSelection() {
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(this));
        this._selectionCount++;
    }

    private int selectionIndex(int i) {
        if (this._selectionN == -1) {
            this._selectionN = 0;
            this._selectionLoc = this._selectionFirst;
        }
        while (this._selectionN < i) {
            this._selectionLoc = this._locale._locations.next(this._selectionLoc);
            this._selectionN++;
        }
        while (this._selectionN > i) {
            this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            this._selectionN--;
        }
        return this._selectionLoc;
    }

    void removeSelection(int i) {
        int iSelectionIndex = selectionIndex(i);
        int i2 = this._selectionN;
        if (i < i2) {
            this._selectionN = i2 - 1;
        } else if (i == i2) {
            this._selectionN = i2 - 1;
            if (i == 0) {
                this._selectionLoc = -1;
            } else {
                this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            }
        }
        this._selectionFirst = this._locale._locations.remove(this._selectionFirst, iSelectionIndex);
        this._selectionCount--;
    }

    int selectionCount() {
        return this._selectionCount;
    }

    void moveToSelection(int i) {
        this._locale._locations.moveTo(selectionIndex(i), this);
    }

    void clearSelection() {
        while (this._selectionCount > 0) {
            removeSelection(0);
        }
    }

    boolean toParent() {
        return toParent($assertionsDisabled);
    }

    boolean toParentRaw() {
        return toParent(true);
    }

    Xobj getParent() {
        return getParent($assertionsDisabled);
    }

    Xobj getParentRaw() {
        return getParent(true);
    }

    boolean hasParent() {
        int i = this._pos;
        if (i == -1) {
            return true;
        }
        if ((i < 1 || i >= this._xobj.posAfter()) && this._xobj._parent == null) {
            return $assertionsDisabled;
        }
        return true;
    }

    Xobj getParentNoRoot() {
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return this._xobj;
        }
        if (this._xobj._parent != null) {
            return this._xobj._parent;
        }
        return null;
    }

    Xobj getParent(boolean z) {
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return this._xobj;
        }
        if (this._xobj._parent != null) {
            return this._xobj._parent;
        }
        if (z || this._xobj.isRoot()) {
            return null;
        }
        Cur curTempCur = this._locale.tempCur();
        curTempCur.createRoot();
        Xobj xobj = curTempCur._xobj;
        curTempCur.next();
        moveNode(curTempCur);
        curTempCur.release();
        return xobj;
    }

    boolean toParent(boolean z) {
        Xobj parent = getParent(z);
        if (parent == null) {
            return $assertionsDisabled;
        }
        moveTo(parent);
        return true;
    }

    void toRoot() {
        Xobj xobj = this._xobj;
        while (!xobj.isRoot()) {
            if (xobj._parent == null) {
                Cur curTempCur = this._locale.tempCur();
                curTempCur.createRoot();
                Xobj xobj2 = curTempCur._xobj;
                curTempCur.next();
                moveNode(curTempCur);
                curTempCur.release();
                xobj = xobj2;
                break;
            }
            xobj = xobj._parent;
        }
        moveTo(xobj);
    }

    boolean hasText() {
        return this._xobj.hasTextEnsureOccupancy();
    }

    boolean hasAttrs() {
        return this._xobj.hasAttrs();
    }

    boolean hasChildren() {
        return this._xobj.hasChildren();
    }

    boolean toFirstChild() {
        if (!this._xobj.hasChildren()) {
            return $assertionsDisabled;
        }
        Xobj xobj = this._xobj._firstChild;
        while (xobj.isAttr()) {
            xobj = xobj._nextSibling;
        }
        moveTo(xobj);
        return true;
    }

    protected boolean toLastChild() {
        if (!this._xobj.hasChildren()) {
            return $assertionsDisabled;
        }
        moveTo(this._xobj._lastChild);
        return true;
    }

    boolean toNextSibling() {
        if (this._xobj.isAttr()) {
            if (this._xobj._nextSibling == null || !this._xobj._nextSibling.isAttr()) {
                return $assertionsDisabled;
            }
            moveTo(this._xobj._nextSibling);
            return true;
        }
        if (this._xobj._nextSibling == null) {
            return $assertionsDisabled;
        }
        moveTo(this._xobj._nextSibling);
        return true;
    }

    void setValueAsQName(QName qName) {
        String localPart = qName.getLocalPart();
        String strPrefixForNamespace = prefixForNamespace(qName.getNamespaceURI(), qName.getPrefix().length() > 0 ? qName.getPrefix() : null, true);
        if (strPrefixForNamespace.length() > 0) {
            localPart = strPrefixForNamespace + ":" + localPart;
        }
        setValue(localPart);
    }

    void setValue(String str) {
        moveNodeContents(null, $assertionsDisabled);
        next();
        insertString(str);
        toParent();
    }

    void removeFollowingAttrs() {
        QName name = getName();
        push();
        if (toNextAttr()) {
            while (isAttr()) {
                if (getName().equals(name)) {
                    moveNode(null);
                } else if (!toNextAttr()) {
                    break;
                }
            }
        }
        pop();
    }

    String getAttrValue(QName qName) {
        push();
        String valueAsString = toAttr(qName) ? getValueAsString() : null;
        pop();
        return valueAsString;
    }

    void setAttrValueAsQName(QName qName, QName qName2) {
        if (qName2 == null) {
            this._xobj.removeAttr(qName);
            return;
        }
        if (toAttr(qName)) {
            removeFollowingAttrs();
        } else {
            next();
            createAttr(qName);
        }
        setValueAsQName(qName2);
        toParent();
    }

    boolean removeAttr(QName qName) {
        return this._xobj.removeAttr(qName);
    }

    void setAttrValue(QName qName, String str) {
        this._xobj.setAttr(qName, str);
    }

    boolean toAttr(QName qName) {
        Xobj attr = this._xobj.getAttr(qName);
        if (attr == null) {
            return $assertionsDisabled;
        }
        moveTo(attr);
        return true;
    }

    boolean toFirstAttr() {
        Xobj xobjFirstAttr = this._xobj.firstAttr();
        if (xobjFirstAttr == null) {
            return $assertionsDisabled;
        }
        moveTo(xobjFirstAttr);
        return true;
    }

    boolean toLastAttr() {
        if (!toFirstAttr()) {
            return $assertionsDisabled;
        }
        while (toNextAttr()) {
        }
        return true;
    }

    boolean toNextAttr() {
        Xobj xobjNextAttr = this._xobj.nextAttr();
        if (xobjNextAttr == null) {
            return $assertionsDisabled;
        }
        moveTo(xobjNextAttr);
        return true;
    }

    boolean toPrevAttr() {
        if (isAttr()) {
            if (this._xobj._prevSibling == null) {
                moveTo(this._xobj.ensureParent());
                return true;
            }
            moveTo(this._xobj._prevSibling);
            return true;
        }
        prev();
        if (!isContainer()) {
            next();
            return $assertionsDisabled;
        }
        return toLastAttr();
    }

    boolean skipWithAttrs() {
        if (skip()) {
            return true;
        }
        if (this._xobj.isRoot()) {
            return $assertionsDisabled;
        }
        toParent();
        next();
        return true;
    }

    boolean skip() {
        if (this._xobj.isRoot()) {
            return $assertionsDisabled;
        }
        if (this._xobj.isAttr()) {
            if (this._xobj._nextSibling == null || !this._xobj._nextSibling.isAttr()) {
                return $assertionsDisabled;
            }
            moveTo(this._xobj._nextSibling, 0);
            return true;
        }
        Xobj xobj = this._xobj;
        moveTo(getNormal(xobj, xobj.posAfter()), this._posTemp);
        return true;
    }

    void toEnd() {
        moveTo(this._xobj, -1);
    }

    void moveToCharNode(DomImpl.CharNode charNode) {
        moveToDom(charNode.getDom());
        this._xobj.ensureOccupancy();
        Xobj xobj = this._xobj;
        DomImpl.CharNode charNodeUpdateCharNodes = updateCharNodes(this._locale, xobj, xobj._charNodesValue, this._xobj._cchValue);
        xobj._charNodesValue = charNodeUpdateCharNodes;
        while (charNodeUpdateCharNodes != null) {
            if (charNode != charNodeUpdateCharNodes) {
                charNodeUpdateCharNodes = charNodeUpdateCharNodes._next;
            } else {
                moveTo(getNormal(this._xobj, charNodeUpdateCharNodes._off + 1), this._posTemp);
                return;
            }
        }
        Xobj xobj2 = this._xobj;
        DomImpl.CharNode charNodeUpdateCharNodes2 = updateCharNodes(this._locale, xobj2, xobj2._charNodesAfter, this._xobj._cchAfter);
        xobj2._charNodesAfter = charNodeUpdateCharNodes2;
        while (charNodeUpdateCharNodes2 != null) {
            if (charNode != charNodeUpdateCharNodes2) {
                charNodeUpdateCharNodes2 = charNodeUpdateCharNodes2._next;
            } else {
                moveTo(getNormal(this._xobj, charNodeUpdateCharNodes2._off + this._xobj._cchValue + 2), this._posTemp);
                return;
            }
        }
    }

    boolean prevWithAttrs() {
        if (prev()) {
            return true;
        }
        if (!isAttr()) {
            return $assertionsDisabled;
        }
        toParent();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    boolean prev() {
        int i = 0;
        if (this._xobj.isRoot() && this._pos == 0) {
            return $assertionsDisabled;
        }
        if (this._xobj.isAttr() && this._pos == 0 && this._xobj._prevSibling == null) {
            return $assertionsDisabled;
        }
        Xobj denormal = getDenormal();
        int i2 = this._posTemp;
        int iPosAfter = denormal.posAfter();
        if (i2 > iPosAfter) {
            i = iPosAfter;
        } else if (i2 == iPosAfter) {
            if (!denormal.isAttr() || (denormal._cchAfter <= 0 && denormal._nextSibling != null && denormal._nextSibling.isAttr())) {
                i = -1;
            } else {
                denormal = denormal.ensureParent();
            }
        } else if (i2 == iPosAfter - 1) {
            denormal.ensureOccupancy();
            if (denormal._cchValue > 0) {
                i = 1;
            }
        } else if (i2 > 1) {
            i = 1;
        }
        moveTo(getNormal(denormal, i), this._posTemp);
        return true;
    }

    boolean next(boolean z) {
        return z ? nextWithAttrs() : next();
    }

    boolean nextWithAttrs() {
        int iKind = kind();
        if (kindIsContainer(iKind)) {
            if (toFirstAttr()) {
                return true;
            }
        } else if (iKind == -3) {
            if (next()) {
                return true;
            }
            toParent();
            if (!toParentRaw()) {
                return $assertionsDisabled;
            }
        }
        return next();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    boolean next() {
        Xobj xobj = this._xobj;
        int i = this._pos;
        int iPosAfter = xobj.posAfter();
        if (i >= iPosAfter) {
            iPosAfter = this._xobj.posMax();
        } else if (i == -1) {
            if (xobj.isRoot() || (xobj.isAttr() && (xobj._nextSibling == null || !xobj._nextSibling.isAttr()))) {
                return $assertionsDisabled;
            }
        } else if (i > 0) {
            if (xobj._firstChild != null) {
                xobj = xobj._firstChild;
                iPosAfter = 0;
            } else {
                iPosAfter = -1;
            }
        } else {
            xobj.ensureOccupancy();
            if (xobj._cchValue != 0 || xobj._firstChild == null) {
                iPosAfter = 1;
            } else {
                if (xobj._firstChild.isAttr()) {
                    Xobj xobj2 = xobj._firstChild;
                    while (xobj2._nextSibling != null && xobj2._nextSibling.isAttr()) {
                        xobj2 = xobj2._nextSibling;
                    }
                    if (xobj2._cchAfter > 0) {
                        iPosAfter = xobj2.posAfter();
                        xobj = xobj2;
                    } else if (xobj2._nextSibling != null) {
                        xobj = xobj2._nextSibling;
                    } else {
                        iPosAfter = 1;
                    }
                } else {
                    xobj = xobj._firstChild;
                }
                iPosAfter = 0;
            }
        }
        moveTo(getNormal(xobj, iPosAfter), this._posTemp);
        return true;
    }

    int prevChars(int i) {
        int iCchLeft = cchLeft();
        if (i < 0 || i > iCchLeft) {
            i = iCchLeft;
        }
        if (i != 0) {
            moveTo(getNormal(getDenormal(), this._posTemp - i), this._posTemp);
        }
        return i;
    }

    int nextChars(int i) {
        int iCchRight = cchRight();
        if (iCchRight == 0) {
            return 0;
        }
        if (i < 0 || i >= iCchRight) {
            next();
            return iCchRight;
        }
        moveTo(getNormal(this._xobj, this._pos + i), this._posTemp);
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void setCharNodes(DomImpl.CharNode charNode) {
        Xobj denormal = getDenormal();
        if (this._posTemp >= denormal.posAfter()) {
            denormal._charNodesAfter = charNode;
        } else {
            denormal._charNodesValue = charNode;
        }
        while (charNode != null) {
            charNode.setDom((DomImpl.Dom) denormal);
            charNode = charNode._next;
        }
    }

    DomImpl.CharNode getCharNodes() {
        Xobj denormal = getDenormal();
        if (this._posTemp >= denormal.posAfter()) {
            DomImpl.CharNode charNodeUpdateCharNodes = updateCharNodes(this._locale, denormal, denormal._charNodesAfter, denormal._cchAfter);
            denormal._charNodesAfter = charNodeUpdateCharNodes;
            return charNodeUpdateCharNodes;
        }
        denormal.ensureOccupancy();
        DomImpl.CharNode charNodeUpdateCharNodes2 = updateCharNodes(this._locale, denormal, denormal._charNodesValue, denormal._cchValue);
        denormal._charNodesValue = charNodeUpdateCharNodes2;
        return charNodeUpdateCharNodes2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static DomImpl.CharNode updateCharNodes(Locale locale, Xobj xobj, DomImpl.CharNode charNode, int i) {
        DomImpl.CharNode charNode2 = charNode;
        int i2 = 0;
        while (charNode2 != null && i > 0) {
            if (charNode2._cch > i) {
                charNode2._cch = i;
            }
            charNode2._off = i2;
            i2 += charNode2._cch;
            i -= charNode2._cch;
            charNode2 = charNode2._next;
        }
        if (i > 0) {
            DomImpl.TextNode textNodeCreateTextNode = locale.createTextNode();
            textNodeCreateTextNode.setDom((DomImpl.Dom) xobj);
            textNodeCreateTextNode._cch = i;
            textNodeCreateTextNode._off = i2;
            return DomImpl.CharNode.appendNode(charNode, textNodeCreateTextNode);
        }
        while (charNode2 != null) {
            if (charNode2._cch != 0) {
                charNode2._cch = 0;
            }
            charNode2._off = i2;
            charNode2 = charNode2._next;
        }
        return charNode;
    }

    final QName getXsiTypeName() {
        return this._xobj.getXsiTypeName();
    }

    final void setXsiType(QName qName) {
        setAttrValueAsQName(Locale._xsiType, qName);
    }

    final QName valueAsQName() {
        throw new RuntimeException("Not implemented");
    }

    final String namespaceForPrefix(String str, boolean z) {
        return this._xobj.namespaceForPrefix(str, z);
    }

    final String prefixForNamespace(String str, String str2, boolean z) {
        return (isContainer() ? this._xobj : getParent()).prefixForNamespace(str, str2, z);
    }

    boolean contains(Cur cur) {
        return this._xobj.contains(cur);
    }

    void insertString(String str) {
        if (str != null) {
            insertChars(str, 0, str.length());
        }
    }

    void insertChars(Object obj, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this._locale.notifyChange();
        if (this._pos == -1) {
            this._xobj.ensureOccupancy();
        }
        Xobj denormal = getDenormal();
        int i3 = this._posTemp;
        denormal.insertCharsHelper(i3, obj, i, i2, true);
        moveTo(denormal, i3);
        this._locale._versionAll++;
    }

    Object moveChars(Cur cur, int i) {
        if (i < 0) {
            i = cchRight();
        }
        if (i == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        Object chars = getChars(i);
        int i2 = this._offSrc;
        if (cur == null) {
            for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (inChars(bookmark, i, $assertionsDisabled)) {
                    Cur curTempCur = this._locale.tempCur();
                    curTempCur.createRoot();
                    curTempCur.next();
                    Object objMoveChars = moveChars(curTempCur, i);
                    curTempCur.release();
                    return objMoveChars;
                }
            }
        } else {
            if (inChars(cur, i, true)) {
                cur.moveToCur(this);
                nextChars(i);
                this._offSrc = i2;
                this._cchSrc = i;
                return chars;
            }
            cur.insertChars(chars, i2, i);
        }
        this._locale.notifyChange();
        if (cur == null) {
            this._xobj.removeCharsHelper(this._pos, i, null, -2, $assertionsDisabled, true);
        } else {
            this._xobj.removeCharsHelper(this._pos, i, cur._xobj, cur._pos, $assertionsDisabled, true);
        }
        this._locale._versionAll++;
        this._offSrc = i2;
        this._cchSrc = i;
        return chars;
    }

    void moveNode(Cur cur) {
        Xobj xobj = this._xobj;
        skip();
        moveNode(xobj, cur);
    }

    private static void transferChars(Xobj xobj, int i, Xobj xobj2, int i2, int i3) {
        xobj2.insertCharsHelper(i2, xobj.getCharsHelper(i, i3), xobj._locale._offSrc, xobj._locale._cchSrc, $assertionsDisabled);
        xobj.removeCharsHelper(i, i3, xobj2, i2, true, $assertionsDisabled);
    }

    static void moveNode(Xobj xobj, Cur cur) {
        if (cur != null) {
            if (cur._pos == -1) {
                cur._xobj.ensureOccupancy();
            }
            if ((cur._pos == 0 && cur._xobj == xobj) || cur.isJustAfterEnd(xobj)) {
                cur.moveTo(xobj);
                return;
            }
        }
        xobj._locale.notifyChange();
        xobj._locale._versionAll++;
        xobj._locale._versionSansText++;
        if (cur != null && cur._locale != xobj._locale) {
            cur._locale.notifyChange();
            cur._locale._versionAll++;
            cur._locale._versionSansText++;
        }
        if (xobj.isAttr()) {
            xobj.invalidateSpecialAttr(cur == null ? null : cur.getParentRaw());
        } else {
            if (xobj._parent != null) {
                xobj._parent.invalidateUser();
            }
            if (cur != null && cur.hasParent()) {
                cur.getParent().invalidateUser();
            }
        }
        int i = xobj._cchAfter;
        boolean z = $assertionsDisabled;
        if (i > 0) {
            transferChars(xobj, xobj.posAfter(), xobj.getDenormal(0), xobj.posTemp(), xobj._cchAfter);
        }
        xobj._locale.embedCurs();
        Xobj xobjWalk = xobj;
        while (xobjWalk != null) {
            while (xobjWalk._embedded != null) {
                xobjWalk._embedded.moveTo(xobj.getNormal(xobj.posAfter()));
            }
            xobjWalk.disconnectUser();
            if (cur != null) {
                xobjWalk._locale = cur._locale;
            }
            xobjWalk = xobjWalk.walk(xobj, true);
        }
        xobj.removeXobj();
        if (cur != null) {
            Xobj xobj2 = cur._xobj;
            boolean z2 = cur._pos != 0;
            int iCchRight = cur.cchRight();
            if (iCchRight > 0) {
                cur.push();
                cur.next();
                xobj2 = cur._xobj;
                if (cur._pos != 0) {
                    z = true;
                }
                cur.pop();
                z2 = z;
            }
            if (z2) {
                xobj2.appendXobj(xobj);
            } else {
                xobj2.insertXobj(xobj);
            }
            if (iCchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj, xobj.posAfter(), iCchRight);
            }
            cur.moveTo(xobj);
        }
    }

    void moveNodeContents(Cur cur, boolean z) {
        moveNodeContents(this._xobj, cur, z);
    }

    /* JADX WARN: Code duplicated, block: B:126:0x00cc A[EDGE_INSN: B:126:0x00cc->B:62:0x00cc BREAK  A[LOOP:1: B:59:0x00c4->B:61:0x00c8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8 A[LOOP:1: B:59:0x00c4->B:61:0x00c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00de  */
    static void moveNodeContents(Xobj xobj, Cur cur, boolean z) {
        int i;
        int i2;
        Cur cur2;
        boolean zIsAtLastPush;
        boolean zHasAttrs = xobj.hasAttrs();
        boolean zHasChildren = xobj.hasChildren();
        int iPosAfter = 1;
        boolean z2 = $assertionsDisabled;
        Cur cur3 = null;
        cur3 = null;
        if ((zHasChildren || (z && zHasAttrs)) ? false : true) {
            if (xobj.isVacant() && cur == null) {
                xobj.clearBit(256);
                xobj.invalidateUser();
                xobj.invalidateSpecialAttr(null);
                xobj._locale._versionAll++;
                return;
            }
            if (xobj.hasTextEnsureOccupancy()) {
                Cur curTempCur = xobj.tempCur();
                curTempCur.next();
                curTempCur.moveChars(cur, -1);
                curTempCur.release();
                return;
            }
            return;
        }
        if (cur != null) {
            if (xobj == cur._xobj && cur._pos == -1) {
                cur.moveTo(xobj);
                cur.next(z && zHasAttrs);
                return;
            }
            if (cur._locale == xobj._locale) {
                cur.push();
                cur.moveTo(xobj);
                cur.next(z && zHasAttrs);
                zIsAtLastPush = cur.isAtLastPush();
                cur.pop();
            } else {
                zIsAtLastPush = false;
            }
            if (zIsAtLastPush) {
                return;
            }
        }
        if (xobj.hasTextNoEnsureOccupancy()) {
            Cur curTempCur2 = xobj.tempCur();
            curTempCur2.next();
            curTempCur2.moveChars(cur, -1);
            curTempCur2.release();
            if (cur != null) {
                i = curTempCur2._cchSrc;
                cur.nextChars(i);
            } else {
                i = 0;
            }
        } else {
            i = 0;
        }
        xobj._locale.embedCurs();
        Xobj xobjWalk = xobj.walk(xobj, true);
        Xobj xobj2 = xobjWalk;
        boolean z3 = false;
        while (xobjWalk != null) {
            if (xobjWalk._parent != xobj || !xobjWalk.isAttr()) {
                while (true) {
                    cur2 = xobjWalk._embedded;
                    if (cur2 != null) {
                        break;
                    } else {
                        cur2.moveTo(xobj, -1);
                    }
                }
                xobjWalk.disconnectUser();
                if (cur != null) {
                    xobjWalk._locale = cur._locale;
                }
                if (z3 && xobjWalk._bookmarks == null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } else if (!z) {
                xobj2 = xobjWalk._nextSibling;
            } else {
                xobjWalk.invalidateSpecialAttr(cur == null ? null : cur.getParent());
                while (true) {
                    cur2 = xobjWalk._embedded;
                    if (cur2 != null) {
                        break;
                        break;
                    }
                    cur2.moveTo(xobj, -1);
                }
                xobjWalk.disconnectUser();
                if (cur != null) {
                    xobjWalk._locale = cur._locale;
                }
                if (z3) {
                    z3 = true;
                } else {
                    z3 = true;
                }
            }
            xobjWalk = xobjWalk.walk(xobj, true);
            z3 = z3;
        }
        Xobj xobj3 = xobj._lastChild;
        if (z3 && cur == null) {
            cur = xobj._locale.tempCur();
            cur.createRoot();
            cur.next();
            cur3 = cur;
        }
        if (!xobj3.isAttr()) {
            xobj.invalidateUser();
        }
        xobj._locale._versionAll++;
        xobj._locale._versionSansText++;
        if (cur != null && i == 0) {
            cur.getParent().invalidateUser();
            cur._locale._versionAll++;
            cur._locale._versionSansText++;
        }
        xobj.removeXobjs(xobj2, xobj3);
        if (cur != null) {
            Xobj xobj4 = cur._xobj;
            boolean z4 = cur._pos != 0;
            int iCchRight = cur.cchRight();
            if (iCchRight > 0) {
                cur.push();
                cur.next();
                xobj4 = cur._xobj;
                if (cur._pos != 0) {
                    z2 = true;
                }
                cur.pop();
                z4 = z2;
            }
            if (xobj2.isAttr()) {
                Xobj xobj5 = xobj2;
                while (xobj5._nextSibling != null && xobj5._nextSibling.isAttr()) {
                    xobj5 = xobj5._nextSibling;
                }
                Xobj parent = cur.getParent();
                if (iCchRight > 0) {
                    transferChars(cur._xobj, cur._pos, xobj5, xobj5.posMax(), iCchRight);
                }
                if (parent.hasTextNoEnsureOccupancy()) {
                    if (parent._cchValue > 0) {
                        i2 = parent._cchValue;
                    } else {
                        parent = parent.lastAttr();
                        iPosAfter = parent.posAfter();
                        i2 = parent._cchAfter;
                    }
                    transferChars(parent, iPosAfter, xobj5, xobj5.posAfter(), i2);
                }
            } else if (iCchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj3, xobj3.posMax(), iCchRight);
            }
            if (z4) {
                xobj4.appendXobjs(xobj2, xobj3);
            } else {
                xobj4.insertXobjs(xobj2, xobj3);
            }
            cur.moveTo(xobj2);
            cur.prevChars(i);
        }
        if (cur3 != null) {
            cur3.release();
        }
    }

    protected final Xobj.Bookmark setBookmark(Object obj, Object obj2) {
        return this._xobj.setBookmark(this._pos, obj, obj2);
    }

    Object getBookmark(Object obj) {
        for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == this._pos && bookmark._key == obj) {
                return bookmark._value;
            }
        }
        return null;
    }

    int firstBookmarkInChars(Object obj, int i) {
        if (!isText()) {
            return -1;
        }
        int i2 = -1;
        for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._key == obj && inChars(bookmark, i, $assertionsDisabled) && (i2 == -1 || bookmark._pos - this._pos < i2)) {
                i2 = bookmark._pos - this._pos;
            }
        }
        return i2;
    }

    int firstBookmarkInCharsLeft(Object obj, int i) {
        if (cchLeft() <= 0) {
            return -1;
        }
        Xobj denormal = getDenormal();
        int i2 = this._posTemp - i;
        int i3 = -1;
        for (Xobj.Bookmark bookmark = denormal._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._key == obj && denormal.inChars(i2, bookmark._xobj, bookmark._pos, i, $assertionsDisabled) && (i3 == -1 || bookmark._pos - i2 < i3)) {
                i3 = bookmark._pos - i2;
            }
        }
        return i3;
    }

    String getCharsAsString(int i) {
        return getCharsAsString(i, 1);
    }

    String getCharsAsString(int i, int i2) {
        return this._xobj.getCharsAsString(this._pos, i, i2);
    }

    String getValueAsString(int i) {
        return this._xobj.getValueAsString(i);
    }

    String getValueAsString() {
        return this._xobj.getValueAsString();
    }

    Object getChars(int i) {
        return this._xobj.getChars(this._pos, i, this);
    }

    Object getFirstChars() {
        Object firstChars = this._xobj.getFirstChars();
        this._offSrc = this._locale._offSrc;
        this._cchSrc = this._locale._cchSrc;
        return firstChars;
    }

    void copyNode(Cur cur) {
        Xobj xobjCopyNode = this._xobj.copyNode(cur._locale);
        if (cur.isPositioned()) {
            moveNode(xobjCopyNode, cur);
        } else {
            cur.moveTo(xobjCopyNode);
        }
    }

    Cur weakCur(Object obj) {
        Cur curWeakCur = this._locale.weakCur(obj);
        curWeakCur.moveToCur(this);
        return curWeakCur;
    }

    Cur tempCur() {
        return tempCur(null);
    }

    Cur tempCur(String str) {
        Cur curTempCur = this._locale.tempCur(str);
        curTempCur.moveToCur(this);
        return curTempCur;
    }

    private Cur tempCur(Xobj xobj, int i) {
        Cur curTempCur = this._locale.tempCur();
        if (xobj != null) {
            curTempCur.moveTo(getNormal(xobj, i), this._posTemp);
        }
        return curTempCur;
    }

    boolean inChars(Cur cur, int i, boolean z) {
        return this._xobj.inChars(this._pos, cur._xobj, cur._pos, i, z);
    }

    boolean inChars(Xobj.Bookmark bookmark, int i, boolean z) {
        return this._xobj.inChars(this._pos, bookmark._xobj, bookmark._pos, i, z);
    }

    private Xobj getNormal(Xobj xobj, int i) {
        Xobj normal = xobj.getNormal(i);
        this._posTemp = xobj._locale._posTemp;
        return normal;
    }

    private Xobj getDenormal() {
        return getDenormal(this._xobj, this._pos);
    }

    private Xobj getDenormal(Xobj xobj, int i) {
        Xobj denormal = xobj.getDenormal(i);
        this._posTemp = xobj._locale._posTemp;
        return denormal;
    }

    void setType(SchemaType schemaType) {
        setType(schemaType, true);
    }

    void setType(SchemaType schemaType, boolean z) {
        TypeStoreUser typeStoreUserPeekUser = peekUser();
        if (typeStoreUserPeekUser == null || typeStoreUserPeekUser.get_schema_type() != schemaType) {
            if (isRoot()) {
                this._xobj.setStableType(schemaType);
                return;
            }
            TypeStoreUser user = this._xobj.ensureParent().getUser();
            if (isAttr()) {
                if (z && user.get_attribute_type(getName()) != schemaType) {
                    throw new IllegalArgumentException("Can't set type of attribute to " + schemaType.toString());
                }
            } else {
                if (user.get_element_type(getName(), null) == schemaType) {
                    removeAttr(Locale._xsiType);
                    return;
                }
                QName name = schemaType.getName();
                if (name == null) {
                    if (z) {
                        throw new IllegalArgumentException("Can't set type of element, type is un-named");
                    }
                } else if (user.get_element_type(getName(), name) == schemaType) {
                    setAttrValueAsQName(Locale._xsiType, name);
                } else if (z) {
                    throw new IllegalArgumentException("Can't set type of element, invalid type");
                }
            }
        }
    }

    void setSubstitution(QName qName, SchemaType schemaType) {
        setSubstitution(qName, schemaType, true);
    }

    void setSubstitution(QName qName, SchemaType schemaType, boolean z) {
        TypeStoreUser typeStoreUserPeekUser = peekUser();
        if ((typeStoreUserPeekUser != null && typeStoreUserPeekUser.get_schema_type() == schemaType && qName.equals(getName())) || isRoot()) {
            return;
        }
        TypeStoreUser user = this._xobj.ensureParent().getUser();
        if (isAttr()) {
            if (z) {
                throw new IllegalArgumentException("Can't use substitution with attributes");
            }
            return;
        }
        if (user.get_element_type(qName, null) == schemaType) {
            setName(qName);
            removeAttr(Locale._xsiType);
            return;
        }
        QName name = schemaType.getName();
        if (name == null) {
            if (z) {
                throw new IllegalArgumentException("Can't set xsi:type on element, type is un-named");
            }
        } else if (user.get_element_type(qName, name) != schemaType) {
            if (z) {
                throw new IllegalArgumentException("Can't set xsi:type on element, invalid type");
            }
        } else {
            setName(qName);
            setAttrValueAsQName(Locale._xsiType, name);
        }
    }

    TypeStoreUser peekUser() {
        return this._xobj._user;
    }

    XmlObject getObject() {
        if (isUserNode()) {
            return getUser();
        }
        return null;
    }

    TypeStoreUser getUser() {
        return this._xobj.getUser();
    }

    DomImpl.Dom getDom() {
        if (isText()) {
            int iCchLeft = cchLeft();
            DomImpl.CharNode charNodes = getCharNodes();
            while (true) {
                iCchLeft -= charNodes._cch;
                if (iCchLeft < 0) {
                    return charNodes;
                }
                charNodes = charNodes._next;
            }
        } else {
            return this._xobj.getDom();
        }
    }

    static void release(Cur cur) {
        if (cur != null) {
            cur.release();
        }
    }

    void release() {
        if (this._tempFrame >= 0) {
            Cur cur = this._nextTemp;
            if (cur != null) {
                cur._prevTemp = this._prevTemp;
            }
            Cur cur2 = this._prevTemp;
            if (cur2 == null) {
                this._locale._tempFrames[this._tempFrame] = this._nextTemp;
            } else {
                cur2._nextTemp = cur;
            }
            this._nextTemp = null;
            this._prevTemp = null;
            this._tempFrame = -1;
        }
        int i = this._state;
        if (i == 0 || i == 3) {
            return;
        }
        while (this._stackTop != -1) {
            popButStay();
        }
        clearSelection();
        this._id = null;
        moveToCur(null);
        Locale.Ref ref = this._ref;
        if (ref != null) {
            ref.clear();
            this._ref._cur = null;
        }
        this._ref = null;
        Locale locale = this._locale;
        locale._registered = listRemove(locale._registered);
        if (this._locale._curPoolCount < 16) {
            Locale locale2 = this._locale;
            locale2._curPool = listInsert(locale2._curPool);
            this._state = 0;
            this._locale._curPoolCount++;
            return;
        }
        this._locale = null;
        this._state = 3;
    }

    boolean isOnList(Cur cur) {
        while (cur != null) {
            if (cur == this) {
                return true;
            }
            cur = cur._next;
        }
        return $assertionsDisabled;
    }

    Cur listInsert(Cur cur) {
        if (cur == null) {
            this._prev = this;
            return this;
        }
        this._prev = cur._prev;
        cur._prev._next = this;
        cur._prev = this;
        return cur;
    }

    Cur listRemove(Cur cur) {
        Cur cur2 = this._prev;
        if (cur2 == this) {
            cur = null;
        } else {
            if (cur == this) {
                cur = this._next;
            } else {
                cur2._next = this._next;
            }
            Cur cur3 = this._next;
            if (cur3 == null) {
                cur._prev = cur2;
            } else {
                cur3._prev = cur2;
                this._next = null;
            }
        }
        this._prev = null;
        return cur;
    }

    boolean isNormal() {
        int i = this._state;
        if (i == 0 || i == 3) {
            return $assertionsDisabled;
        }
        Xobj xobj = this._xobj;
        if (xobj == null) {
            if (this._pos == -2) {
                return true;
            }
            return $assertionsDisabled;
        }
        if (!xobj.isNormal(this._pos)) {
            return $assertionsDisabled;
        }
        if (this._state == 2) {
            return isOnList(this._xobj._embedded);
        }
        return isOnList(this._locale._registered);
    }

    static final class CurLoadContext extends Locale.LoadContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Map _additionalNamespaces;
        private boolean _after;
        private CharUtil _charUtil;
        private boolean _discardDocElem;
        private String _doctypeName;
        private String _doctypePublicId;
        private String _doctypeSystemId;
        private Xobj _frontier;
        private int _lastPos;
        private Xobj _lastXobj;
        private Locale _locale;
        private QName _replaceDocElem;
        private boolean _stripComments;
        private boolean _stripLeft = true;
        private boolean _stripProcinsts;
        private boolean _stripWhitespace;
        private Map _substituteNamespaces;

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void endDTD() {
        }

        CurLoadContext(Locale locale, XmlOptions xmlOptions) {
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._locale = locale;
            this._charUtil = xmlOptionsMaskNull.hasOption(Cur.LOAD_USE_LOCALE_CHAR_UTIL) ? this._locale.getCharUtil() : CharUtil.getThreadLocalCharUtil();
            Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale);
            this._frontier = xobjCreateDomDocumentRootXobj;
            this._after = Cur.$assertionsDisabled;
            this._lastXobj = xobjCreateDomDocumentRootXobj;
            this._lastPos = 0;
            if (xmlOptionsMaskNull.hasOption("LOAD_REPLACE_DOCUMENT_ELEMENT")) {
                this._replaceDocElem = (QName) xmlOptionsMaskNull.get("LOAD_REPLACE_DOCUMENT_ELEMENT");
                this._discardDocElem = true;
            }
            this._stripWhitespace = xmlOptionsMaskNull.hasOption("LOAD_STRIP_WHITESPACE");
            this._stripComments = xmlOptionsMaskNull.hasOption("LOAD_STRIP_COMMENTS");
            this._stripProcinsts = xmlOptionsMaskNull.hasOption("LOAD_STRIP_PROCINSTS");
            this._substituteNamespaces = (Map) xmlOptionsMaskNull.get("LOAD_SUBSTITUTE_NAMESPACES");
            this._additionalNamespaces = (Map) xmlOptionsMaskNull.get("LOAD_ADDITIONAL_NAMESPACES");
            this._locale._versionAll++;
            this._locale._versionSansText++;
        }

        private void start(Xobj xobj) {
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
                this._after = Cur.$assertionsDisabled;
            }
            this._frontier.appendXobj(xobj);
            this._frontier = xobj;
            this._lastXobj = xobj;
            this._lastPos = 0;
        }

        private void end() {
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            } else {
                this._after = true;
            }
            this._lastXobj = this._frontier;
            this._lastPos = -1;
        }

        private void text(Object obj, int i, int i2) {
            if (i2 <= 0) {
                return;
            }
            Xobj xobj = this._frontier;
            this._lastXobj = xobj;
            int i3 = xobj._cchValue + 1;
            this._lastPos = i3;
            if (this._after) {
                this._lastPos = i3 + this._frontier._cchAfter + 1;
                Xobj xobj2 = this._frontier;
                xobj2._srcAfter = this._charUtil.saveChars(obj, i, i2, xobj2._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
                this._frontier._offAfter = this._charUtil._offSrc;
                this._frontier._cchAfter = this._charUtil._cchSrc;
                return;
            }
            Xobj xobj3 = this._frontier;
            xobj3._srcValue = this._charUtil.saveChars(obj, i, i2, xobj3._srcValue, this._frontier._offValue, this._frontier._cchValue);
            this._frontier._offValue = this._charUtil._offSrc;
            this._frontier._cchValue = this._charUtil._cchSrc;
        }

        private void flushText() {
            if (this._stripWhitespace) {
                if (this._after) {
                    Xobj xobj = this._frontier;
                    xobj._srcAfter = this._charUtil.stripRight(xobj._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
                    this._frontier._offAfter = this._charUtil._offSrc;
                    this._frontier._cchAfter = this._charUtil._cchSrc;
                    return;
                }
                Xobj xobj2 = this._frontier;
                xobj2._srcValue = this._charUtil.stripRight(xobj2._srcValue, this._frontier._offValue, this._frontier._cchValue);
                this._frontier._offValue = this._charUtil._offSrc;
                this._frontier._cchValue = this._charUtil._cchSrc;
            }
        }

        private Xobj parent() {
            return this._after ? this._frontier._parent : this._frontier;
        }

        private QName checkName(QName qName, boolean z) {
            String str;
            if (this._substituteNamespaces != null) {
                return ((!z || qName.getNamespaceURI().length() > 0) && (str = (String) this._substituteNamespaces.get(qName.getNamespaceURI())) != null) ? this._locale.makeQName(str, qName.getLocalPart(), qName.getPrefix()) : qName;
            }
            return qName;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void startDTD(String str, String str2, String str3) {
            this._doctypeName = str;
            this._doctypePublicId = str2;
            this._doctypeSystemId = str3;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void startElement(QName qName) {
            start(Cur.createElementXobj(this._locale, checkName(qName, Cur.$assertionsDisabled), parent()._name));
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void endElement() {
            end();
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void xmlns(String str, String str2) {
            String str3;
            Map map = this._substituteNamespaces;
            if (map != null && (str3 = (String) map.get(str2)) != null) {
                str2 = str3;
            }
            Locale locale = this._locale;
            Xobj.AttrXobj attrXobj = new Xobj.AttrXobj(locale, locale.createXmlns(str));
            start(attrXobj);
            text(str2, 0, str2.length());
            end();
            this._lastXobj = attrXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void attr(QName qName, String str) {
            boolean zIsAttrOfTypeId = isAttrOfTypeId(qName, (this._after ? this._lastXobj._parent : this._lastXobj).getQName());
            Xobj attrIdXobj = zIsAttrOfTypeId ? new Xobj.AttrIdXobj(this._locale, checkName(qName, true)) : new Xobj.AttrXobj(this._locale, checkName(qName, true));
            start(attrIdXobj);
            text(str, 0, str.length());
            end();
            if (zIsAttrOfTypeId) {
                Cur curTempCur = attrIdXobj.tempCur();
                curTempCur.toRoot();
                Xobj xobj = curTempCur._xobj;
                curTempCur.release();
                if (xobj instanceof Xobj.DocumentXobj) {
                    ((Xobj.DocumentXobj) xobj).addIdElement(str, attrIdXobj._parent.getDom());
                }
            }
            this._lastXobj = attrIdXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void attr(String str, String str2, String str3, String str4) {
            attr(this._locale.makeQName(str2, str, str3), str4);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void procInst(String str, String str2) {
            if (!this._stripProcinsts) {
                Xobj.ProcInstXobj procInstXobj = new Xobj.ProcInstXobj(this._locale, str);
                start(procInstXobj);
                text(str2, 0, str2.length());
                end();
                this._lastXobj = procInstXobj;
                this._lastPos = 0;
            }
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void comment(String str) {
            if (!this._stripComments) {
                comment(str, 0, str.length());
            }
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void comment(char[] cArr, int i, int i2) {
            if (!this._stripComments) {
                comment(this._charUtil.saveChars(cArr, i, i2), this._charUtil._offSrc, this._charUtil._cchSrc);
            }
            this._stripLeft = true;
        }

        private void comment(Object obj, int i, int i2) {
            Xobj.CommentXobj commentXobj = new Xobj.CommentXobj(this._locale);
            start(commentXobj);
            text(obj, i, i2);
            end();
            this._lastXobj = commentXobj;
            this._lastPos = 0;
        }

        private void stripText(Object obj, int i, int i2) {
            if (this._stripWhitespace && this._stripLeft) {
                obj = this._charUtil.stripLeft(obj, i, i2);
                this._stripLeft = Cur.$assertionsDisabled;
                i = this._charUtil._offSrc;
                i2 = this._charUtil._cchSrc;
            }
            text(obj, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void text(String str) {
            if (str == null) {
                return;
            }
            stripText(str, 0, str.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void text(char[] cArr, int i, int i2) {
            stripText(cArr, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void bookmark(XmlCursor.XmlBookmark xmlBookmark) {
            this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark) {
            if (this._lastPos > 0 || !this._lastXobj.isAttr()) {
                this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
            } else {
                this._lastXobj._parent.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            Xobj attr;
            if (this._lastPos == 0 && this._lastXobj.isAttr() && (attr = this._lastXobj._parent.getAttr(qName)) != null) {
                attr.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void lineNumber(int i, int i2, int i3) {
            this._lastXobj.setBookmark(this._lastPos, XmlLineNumber.class, new XmlLineNumber(i, i2, i3));
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void abort() {
            this._stripLeft = true;
            while (!parent().isRoot()) {
                end();
            }
            finish().release();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected Cur finish() {
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            }
            Cur curTempCur = this._frontier.tempCur();
            if (!Locale.toFirstChildElement(curTempCur)) {
                return curTempCur;
            }
            boolean zIsFragmentQName = Locale.isFragmentQName(curTempCur.getName());
            if (this._discardDocElem || zIsFragmentQName) {
                QName qName = this._replaceDocElem;
                if (qName != null) {
                    curTempCur.setName(qName);
                } else {
                    while (curTempCur.toParent()) {
                    }
                    curTempCur.next();
                    while (!curTempCur.isElem()) {
                        if (curTempCur.isText()) {
                            curTempCur.moveChars(null, -1);
                        } else {
                            curTempCur.moveNode(null);
                        }
                    }
                    curTempCur.skip();
                    while (!curTempCur.isFinish()) {
                        if (curTempCur.isText()) {
                            curTempCur.moveChars(null, -1);
                        } else {
                            curTempCur.moveNode(null);
                        }
                    }
                    curTempCur.toParent();
                    curTempCur.next();
                    Cur curTempCur2 = curTempCur.tempCur();
                    curTempCur.moveNodeContents(curTempCur, true);
                    curTempCur.moveToCur(curTempCur2);
                    curTempCur2.release();
                    curTempCur.moveNode(null);
                }
                if (zIsFragmentQName) {
                    curTempCur.moveTo(this._frontier);
                    if (curTempCur.toFirstAttr()) {
                        while (true) {
                            if (curTempCur.isXmlns() && curTempCur.getXmlnsUri().equals("http://www.openuri.org/fragment")) {
                                curTempCur.moveNode(null);
                                if (!curTempCur.isAttr()) {
                                    break;
                                }
                            } else if (!curTempCur.toNextAttr()) {
                                break;
                            }
                        }
                    }
                    curTempCur.moveTo(this._frontier);
                    Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale, true);
                    this._frontier = xobjCreateDomDocumentRootXobj;
                    Cur curTempCur3 = xobjCreateDomDocumentRootXobj.tempCur();
                    curTempCur3.next();
                    curTempCur.moveNodeContents(curTempCur3, true);
                    curTempCur.moveTo(this._frontier);
                    curTempCur3.release();
                }
            }
            if (this._additionalNamespaces != null) {
                curTempCur.moveTo(this._frontier);
                Locale.toFirstChildElement(curTempCur);
                Locale.applyNamespaces(curTempCur, this._additionalNamespaces);
            }
            if (this._doctypeName != null && (this._doctypePublicId != null || this._doctypeSystemId != null)) {
                XmlDocumentProperties docProps = Locale.getDocProps(curTempCur, true);
                docProps.setDoctypeName(this._doctypeName);
                String str = this._doctypePublicId;
                if (str != null) {
                    docProps.setDoctypePublicId(str);
                }
                String str2 = this._doctypeSystemId;
                if (str2 != null) {
                    docProps.setDoctypeSystemId(str2);
                }
            }
            curTempCur.moveTo(this._frontier);
            return curTempCur;
        }

        public void dump() {
            this._frontier.dump();
        }
    }

    static String kindName(int i) {
        if (i == 0) {
            return "TEXT";
        }
        if (i == 1) {
            return "ROOT";
        }
        if (i == 2) {
            return "ELEM";
        }
        if (i == 3) {
            return "ATTR";
        }
        if (i != 4) {
            return i != 5 ? "<< Unknown Kind (" + i + ") >>" : "PROCINST";
        }
        return "COMMENT";
    }

    static void dump(PrintStream printStream, DomImpl.Dom dom) {
        dom.dump(printStream);
    }

    static void dump(DomImpl.Dom dom) {
        dump(System.out, dom);
    }

    static void dump(Node node) {
        dump(System.out, node);
    }

    static void dump(PrintStream printStream, Node node) {
        dump(printStream, (DomImpl.Dom) node);
    }

    void dump() {
        dump(System.out, this._xobj, this);
    }

    void dump(PrintStream printStream) {
        Xobj xobj = this._xobj;
        if (xobj == null) {
            printStream.println("Unpositioned xptr");
        } else {
            dump(printStream, xobj, this);
        }
    }

    public static void dump(PrintStream printStream, Xobj xobj, Object obj) {
        if (obj == null) {
            obj = xobj;
        }
        while (xobj._parent != null) {
            xobj = xobj._parent;
        }
        dumpXobj(printStream, xobj, 0, obj);
        printStream.println();
    }

    private static void dumpCur(PrintStream printStream, String str, Cur cur, Object obj) {
        printStream.print(" ");
        if (obj == cur) {
            printStream.print("*:");
        }
        StringBuilder sbAppend = new StringBuilder().append(str);
        String str2 = cur._id;
        if (str2 == null) {
            str2 = "<cur>";
        }
        printStream.print(sbAppend.append(str2).append("[").append(cur._pos).append("]").toString());
    }

    private static void dumpCurs(PrintStream printStream, Xobj xobj, Object obj) {
        for (Cur cur = xobj._embedded; cur != null; cur = cur._next) {
            dumpCur(printStream, "E:", cur, obj);
        }
        for (Cur cur2 = xobj._locale._registered; cur2 != null; cur2 = cur2._next) {
            if (cur2._xobj == xobj) {
                dumpCur(printStream, "R:", cur2, obj);
            }
        }
    }

    private static void dumpBookmarks(PrintStream printStream, Xobj xobj, Object obj) {
        for (Xobj.Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            printStream.print(" ");
            if (obj == bookmark) {
                printStream.print("*:");
            }
            if (bookmark._value instanceof XmlLineNumber) {
                printStream.print("<line:" + ((XmlLineNumber) bookmark._value).getLine() + ">[" + bookmark._pos + "]");
            } else {
                printStream.print("<mark>[" + bookmark._pos + "]");
            }
        }
    }

    private static void dumpCharNodes(PrintStream printStream, DomImpl.CharNode charNode, Object obj) {
        while (charNode != null) {
            printStream.print(" ");
            if (charNode == obj) {
                printStream.print("*");
            }
            printStream.print((charNode instanceof DomImpl.TextNode ? "TEXT" : ValidatorPair.ATTR_TYPE_DEFAULT) + "[" + charNode._cch + "]");
            charNode = charNode._next;
        }
    }

    private static void dumpChars(PrintStream printStream, Object obj, int i, int i2) {
        printStream.print("\"");
        String string = CharUtil.getString(obj, i, i2);
        int iCharCount = 0;
        while (iCharCount < string.length()) {
            if (iCharCount == 36) {
                printStream.print("...");
                break;
            }
            int iCodePointAt = string.codePointAt(iCharCount);
            char[] chars = Character.toChars(iCodePointAt);
            if (chars.length == 1) {
                char c = chars[0];
                if (c >= ' ' && c < 127) {
                    printStream.print(c);
                } else if (c == '\n') {
                    printStream.print("\\n");
                } else if (c == '\r') {
                    printStream.print("\\r");
                } else if (c == '\t') {
                    printStream.print("\\t");
                } else if (c == '\"') {
                    printStream.print("\\\"");
                } else {
                    printStream.print("<#" + ((int) c) + ">");
                }
            } else {
                printStream.print("<#" + iCodePointAt + ">");
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        printStream.print("\"");
    }

    private static void dumpXobj(PrintStream printStream, Xobj xobj, int i, Object obj) {
        int iLastIndexOf;
        if (xobj == null) {
            return;
        }
        if (xobj == obj) {
            printStream.print("* ");
        } else {
            printStream.print("  ");
        }
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print("  ");
        }
        printStream.print(kindName(xobj.kind()));
        if (xobj._name != null) {
            printStream.print(" ");
            if (xobj._name.getPrefix().length() > 0) {
                printStream.print(xobj._name.getPrefix() + ":");
            }
            printStream.print(xobj._name.getLocalPart());
            if (xobj._name.getNamespaceURI().length() > 0) {
                printStream.print("@" + xobj._name.getNamespaceURI());
            }
        }
        if (xobj._srcValue != null || xobj._charNodesValue != null) {
            printStream.print(" Value( ");
            dumpChars(printStream, xobj._srcValue, xobj._offValue, xobj._cchValue);
            dumpCharNodes(printStream, xobj._charNodesValue, obj);
            printStream.print(" )");
        }
        if (xobj._user != null) {
            printStream.print(" (USER)");
        }
        if (xobj.isVacant()) {
            printStream.print(" (VACANT)");
        }
        if (xobj._srcAfter != null || xobj._charNodesAfter != null) {
            printStream.print(" After( ");
            dumpChars(printStream, xobj._srcAfter, xobj._offAfter, xobj._cchAfter);
            dumpCharNodes(printStream, xobj._charNodesAfter, obj);
            printStream.print(" )");
        }
        dumpCurs(printStream, xobj, obj);
        dumpBookmarks(printStream, xobj, obj);
        String name = xobj.getClass().getName();
        int iLastIndexOf2 = name.lastIndexOf(46);
        if (iLastIndexOf2 > 0 && (iLastIndexOf = (name = name.substring(iLastIndexOf2 + 1)).lastIndexOf(36)) > 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        printStream.print(" (");
        printStream.print(name);
        printStream.print(")");
        printStream.println();
        for (Xobj xobj2 = xobj._firstChild; xobj2 != null; xobj2 = xobj2._nextSibling) {
            dumpXobj(printStream, xobj2, i + 1, obj);
        }
    }

    void setId(String str) {
        this._id = str;
    }
}

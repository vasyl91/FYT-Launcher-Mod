package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
abstract class Xobj implements TypeStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int END_POS = -1;
    static final int INHIBIT_DISCONNECT = 1024;
    static final int NO_POS = -2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int STABLE_USER = 512;
    static final int TEXT = 0;
    static final int VACANT = 256;
    int _bits;
    Bookmark _bookmarks;
    int _cchAfter;
    int _cchValue;
    DomImpl.CharNode _charNodesAfter;
    DomImpl.CharNode _charNodesValue;
    Cur _embedded;
    Xobj _firstChild;
    Xobj _lastChild;
    Locale _locale;
    QName _name;
    Xobj _nextSibling;
    int _offAfter;
    int _offValue;
    Xobj _parent;
    Xobj _prevSibling;
    Object _srcAfter;
    Object _srcValue;
    TypeStoreUser _user;

    abstract DomImpl.Dom getDom();

    abstract Xobj newNode(Locale locale);

    Xobj(Locale locale, int i, int i2) {
        this._locale = locale;
        this._bits = (i2 << 4) + i;
    }

    final boolean entered() {
        return this._locale.entered();
    }

    final int kind() {
        return this._bits & 15;
    }

    final int domType() {
        return (this._bits & 240) >> 4;
    }

    final boolean isRoot() {
        if (kind() == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean isAttr() {
        if (kind() == 3) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean isElem() {
        if (kind() == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean isProcinst() {
        if (kind() == 5) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean isComment() {
        if (kind() == 4) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean isContainer() {
        return Cur.kindIsContainer(kind());
    }

    final boolean isUserNode() {
        int iKind = kind();
        if (iKind == 2 || iKind == 1) {
            return true;
        }
        if (iKind != 3 || isXmlns()) {
            return $assertionsDisabled;
        }
        return true;
    }

    final boolean isNormalAttr() {
        if (!isAttr() || Locale.isXmlns(this._name)) {
            return $assertionsDisabled;
        }
        return true;
    }

    final boolean isXmlns() {
        if (isAttr() && Locale.isXmlns(this._name)) {
            return true;
        }
        return $assertionsDisabled;
    }

    final int cchValue() {
        return this._cchValue;
    }

    final int cchAfter() {
        return this._cchAfter;
    }

    final int posAfter() {
        return this._cchValue + 2;
    }

    final int posMax() {
        return this._cchValue + 2 + this._cchAfter;
    }

    final String getXmlnsPrefix() {
        return Locale.xmlnsPrefix(this._name);
    }

    final String getXmlnsUri() {
        return getValueAsString();
    }

    final boolean hasTextEnsureOccupancy() {
        ensureOccupancy();
        return hasTextNoEnsureOccupancy();
    }

    final boolean hasTextNoEnsureOccupancy() {
        if (this._cchValue > 0) {
            return true;
        }
        Xobj xobjLastAttr = lastAttr();
        if (xobjLastAttr == null || xobjLastAttr._cchAfter <= 0) {
            return $assertionsDisabled;
        }
        return true;
    }

    final boolean hasAttrs() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return $assertionsDisabled;
        }
        return true;
    }

    final boolean hasChildren() {
        Xobj xobj = this._lastChild;
        if (xobj == null || xobj.isAttr()) {
            return $assertionsDisabled;
        }
        return true;
    }

    protected final int getDomZeroOneChildren() {
        DomImpl.CharNode charNode;
        if (this._firstChild == null && this._srcValue == null && this._charNodesValue == null) {
            return 0;
        }
        Xobj xobj = this._lastChild;
        if (xobj != null && xobj.isAttr()) {
            Xobj xobj2 = this._lastChild;
            if (xobj2._charNodesAfter == null && xobj2._srcAfter == null && this._srcValue == null && this._charNodesValue == null) {
                return 0;
            }
        }
        Xobj xobj3 = this._firstChild;
        if (xobj3 == this._lastChild && xobj3 != null && !xobj3.isAttr() && this._srcValue == null && this._charNodesValue == null && this._firstChild._srcAfter == null) {
            return 1;
        }
        if (this._firstChild == null && this._srcValue != null && ((charNode = this._charNodesValue) == null || (charNode._next == null && this._charNodesValue._cch == this._cchValue))) {
            return 1;
        }
        Xobj xobjLastAttr = lastAttr();
        Xobj xobj4 = xobjLastAttr == null ? null : xobjLastAttr._nextSibling;
        return (xobjLastAttr != null && xobjLastAttr._srcAfter == null && xobj4 != null && xobj4._srcAfter == null && xobj4._nextSibling == null) ? 1 : 2;
    }

    protected final boolean isFirstChildPtrDomUsable() {
        Xobj xobj = this._firstChild;
        if (xobj == null && this._srcValue == null && this._charNodesValue == null) {
            return true;
        }
        if (xobj == null || xobj.isAttr() || this._srcValue != null || this._charNodesValue != null) {
            return $assertionsDisabled;
        }
        return true;
    }

    protected final boolean isNextSiblingPtrDomUsable() {
        if (this._charNodesAfter == null && this._srcAfter == null) {
            return true;
        }
        return $assertionsDisabled;
    }

    protected final boolean isExistingCharNodesValueUsable() {
        DomImpl.CharNode charNode;
        if (this._srcValue != null && (charNode = this._charNodesValue) != null && charNode._next == null && this._charNodesValue._cch == this._cchValue) {
            return true;
        }
        return $assertionsDisabled;
    }

    protected final boolean isCharNodesValueUsable() {
        if (!isExistingCharNodesValueUsable()) {
            DomImpl.CharNode charNodeUpdateCharNodes = Cur.updateCharNodes(this._locale, this, this._charNodesValue, this._cchValue);
            this._charNodesValue = charNodeUpdateCharNodes;
            if (charNodeUpdateCharNodes == null) {
                return $assertionsDisabled;
            }
        }
        return true;
    }

    protected final boolean isCharNodesAfterUsable() {
        if (this._srcAfter == null) {
            return $assertionsDisabled;
        }
        DomImpl.CharNode charNode = this._charNodesAfter;
        if (charNode != null && charNode._next == null && this._charNodesAfter._cch == this._cchAfter) {
            return true;
        }
        DomImpl.CharNode charNodeUpdateCharNodes = Cur.updateCharNodes(this._locale, this, this._charNodesAfter, this._cchAfter);
        this._charNodesAfter = charNodeUpdateCharNodes;
        if (charNodeUpdateCharNodes != null) {
            return true;
        }
        return $assertionsDisabled;
    }

    final Xobj lastAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        Xobj xobj2 = this._firstChild;
        while (true) {
            Xobj xobj3 = xobj2._nextSibling;
            if (xobj3 == null || !xobj3.isAttr()) {
                break;
            }
            xobj2 = xobj2._nextSibling;
        }
        return xobj2;
    }

    final int cchLeft(int i) {
        if (isRoot() && i == 0) {
            return 0;
        }
        Xobj denormal = getDenormal(i);
        int iPosTemp = posTemp();
        int iPosAfter = denormal.posAfter();
        if (iPosTemp < iPosAfter) {
            iPosAfter = 1;
        }
        return iPosTemp - iPosAfter;
    }

    final int cchRight(int i) {
        if (i <= 0) {
            return 0;
        }
        int iPosAfter = posAfter();
        return i < iPosAfter ? (iPosAfter - i) - 1 : posMax() - i;
    }

    public final Locale locale() {
        return this._locale;
    }

    public final int nodeType() {
        return domType();
    }

    public final QName getQName() {
        return this._name;
    }

    public final Cur tempCur() {
        Cur curTempCur = this._locale.tempCur();
        curTempCur.moveTo(this);
        return curTempCur;
    }

    public void dump(PrintStream printStream, Object obj) {
        Cur.dump(printStream, this, obj);
    }

    public void dump(PrintStream printStream) {
        Cur.dump(printStream, this, this);
    }

    public void dump() {
        dump(System.out);
    }

    final Cur getEmbedded() {
        this._locale.embedCurs();
        return this._embedded;
    }

    final boolean inChars(int i, Xobj xobj, int i2, int i3, boolean z) {
        int i4;
        if (!z) {
            i4 = 0;
        } else {
            if (xobj.isRoot() && i2 == 0) {
                return $assertionsDisabled;
            }
            xobj = xobj.getDenormal(i2);
            i2 = xobj.posTemp();
            i4 = 1;
        }
        if (xobj == this && i2 >= i) {
            if (i3 < 0) {
                i3 = cchRight(i);
            }
            if (i2 < i + i3 + i4) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    final boolean isJustAfterEnd(Xobj xobj, int i) {
        if (xobj.isRoot() && i == 0) {
            return $assertionsDisabled;
        }
        if (xobj == this) {
            if (i != posAfter()) {
                return $assertionsDisabled;
            }
        } else if (xobj.getDenormal(i) != this || xobj.posTemp() != posAfter()) {
            return $assertionsDisabled;
        }
        return true;
    }

    final boolean isInSameTree(Xobj xobj) {
        if (this._locale != xobj._locale) {
            return $assertionsDisabled;
        }
        Xobj xobj2 = this;
        while (xobj2 != xobj) {
            Xobj xobj3 = xobj2._parent;
            if (xobj3 == null) {
                while (xobj != this) {
                    Xobj xobj4 = xobj._parent;
                    if (xobj4 == null) {
                        if (xobj == xobj2) {
                            return true;
                        }
                        return $assertionsDisabled;
                    }
                    xobj = xobj4;
                }
                return true;
            }
            xobj2 = xobj3;
        }
        return true;
    }

    final boolean contains(Cur cur) {
        return contains(cur._xobj, cur._pos);
    }

    final boolean contains(Xobj xobj, int i) {
        if (this == xobj) {
            if (i == -1) {
                return true;
            }
            if (i <= 0 || i >= posAfter()) {
                return $assertionsDisabled;
            }
            return true;
        }
        if (this._firstChild == null) {
            return $assertionsDisabled;
        }
        while (xobj != null) {
            if (xobj == this) {
                return true;
            }
            xobj = xobj._parent;
        }
        return $assertionsDisabled;
    }

    final Bookmark setBookmark(int i, Object obj, Object obj2) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (i == bookmark._pos && obj == bookmark._key) {
                if (obj2 == null) {
                    this._bookmarks = bookmark.listRemove(this._bookmarks);
                    return null;
                }
                bookmark._value = obj2;
                return bookmark;
            }
        }
        if (obj2 == null) {
            return null;
        }
        Bookmark bookmark2 = new Bookmark();
        bookmark2._xobj = this;
        bookmark2._pos = i;
        bookmark2._key = obj;
        bookmark2._value = obj2;
        this._bookmarks = bookmark2.listInsert(this._bookmarks);
        return bookmark2;
    }

    final boolean hasBookmark(Object obj, int i) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == i && obj == bookmark._key) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    final Xobj findXmlnsForPrefix(String str) {
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobjFirstAttr = xobj.firstAttr(); xobjFirstAttr != null; xobjFirstAttr = xobjFirstAttr.nextAttr()) {
                if (xobjFirstAttr.isXmlns() && xobjFirstAttr.getXmlnsPrefix().equals(str)) {
                    return xobjFirstAttr;
                }
            }
        }
        return null;
    }

    final boolean removeAttr(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return $assertionsDisabled;
        }
        Cur curTempCur = attr.tempCur();
        while (true) {
            curTempCur.moveNode(null);
            Xobj attr2 = getAttr(qName);
            if (attr2 != null) {
                curTempCur.moveTo(attr2);
            } else {
                curTempCur.release();
                return true;
            }
        }
    }

    final Xobj setAttr(QName qName, String str) {
        Cur curTempCur = tempCur();
        if (curTempCur.toAttr(qName)) {
            curTempCur.removeFollowingAttrs();
        } else {
            curTempCur.next();
            curTempCur.createAttr(qName);
        }
        curTempCur.setValue(str);
        Xobj xobj = curTempCur._xobj;
        curTempCur.release();
        return xobj;
    }

    final void setName(QName qName) {
        Xobj xobj;
        if (this._name.equals(qName) && this._name.getPrefix().equals(qName.getPrefix())) {
            return;
        }
        this._locale.notifyChange();
        QName qName2 = this._name;
        this._name = qName;
        if (this instanceof NamedNodeXobj) {
            ((NamedNodeXobj) this)._canHavePrefixUri = true;
        }
        if (!isProcinst()) {
            if (!isAttr() || this._parent == null) {
                xobj = this;
            } else {
                xobj = (qName2.equals(Locale._xsiType) || qName.equals(Locale._xsiType)) ? this._parent : this;
                if (qName2.equals(Locale._xsiNil) || qName.equals(Locale._xsiNil)) {
                    this._parent.invalidateNil();
                }
            }
            xobj.disconnectNonRootUsers();
        }
        this._locale._versionAll++;
        this._locale._versionSansText++;
    }

    final Xobj ensureParent() {
        Xobj xobj = this._parent;
        return xobj == null ? new DocumentFragXobj(this._locale).appendXobj(this) : xobj;
    }

    final Xobj firstAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        return this._firstChild;
    }

    final Xobj nextAttr() {
        Xobj xobj = this._firstChild;
        if (xobj != null && xobj.isAttr()) {
            return this._firstChild;
        }
        Xobj xobj2 = this._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return null;
        }
        return this._nextSibling;
    }

    final boolean isValid() {
        if (!isVacant()) {
            return true;
        }
        if (this._cchValue != 0 || this._user == null) {
            return $assertionsDisabled;
        }
        return true;
    }

    final int posTemp() {
        return this._locale._posTemp;
    }

    final Xobj getNormal(int i) {
        Xobj xobjEnsureParent;
        if (i == posMax()) {
            Xobj xobj = this._nextSibling;
            if (xobj != null) {
                xobjEnsureParent = xobj;
                i = 0;
            } else {
                xobjEnsureParent = ensureParent();
                i = -1;
            }
        } else if (i == posAfter() - 1) {
            xobjEnsureParent = this;
            i = -1;
        } else {
            xobjEnsureParent = this;
        }
        this._locale._posTemp = i;
        return xobjEnsureParent;
    }

    final Xobj getDenormal(int i) {
        Xobj xobj;
        Xobj xobjEnsureParent;
        int iPosMax;
        if (i == 0) {
            xobjEnsureParent = this._prevSibling;
            if (xobjEnsureParent == null) {
                xobjEnsureParent = ensureParent();
                iPosMax = xobjEnsureParent.posAfter() - 1;
            } else {
                iPosMax = xobjEnsureParent.posMax();
            }
        } else {
            if (i == -1) {
                xobjEnsureParent = this._lastChild;
                if (xobjEnsureParent == null) {
                    i = posAfter() - 1;
                } else {
                    iPosMax = xobjEnsureParent.posMax();
                }
            }
            xobj = this;
            this._locale._posTemp = i;
            return xobj;
        }
        int i2 = iPosMax;
        xobj = xobjEnsureParent;
        i = i2;
        this._locale._posTemp = i;
        return xobj;
    }

    final boolean isNormal(int i) {
        Xobj xobj;
        if (!isValid()) {
            return $assertionsDisabled;
        }
        if (i == -1 || i == 0) {
            return true;
        }
        if (i < 0 || i >= posMax()) {
            return $assertionsDisabled;
        }
        if (i >= posAfter()) {
            if (isRoot()) {
                return $assertionsDisabled;
            }
            Xobj xobj2 = this._nextSibling;
            if ((xobj2 != null && xobj2.isAttr()) || (xobj = this._parent) == null || !xobj.isContainer()) {
                return $assertionsDisabled;
            }
        }
        if (i == posAfter() - 1) {
            return $assertionsDisabled;
        }
        return true;
    }

    final Xobj walk(Xobj xobj, boolean z) {
        Xobj xobj2 = this._firstChild;
        if (xobj2 != null && z) {
            return xobj2;
        }
        for (Xobj xobj3 = this; xobj3 != xobj; xobj3 = xobj3._parent) {
            Xobj xobj4 = xobj3._nextSibling;
            if (xobj4 != null) {
                return xobj4;
            }
        }
        return null;
    }

    final Xobj removeXobj() {
        Xobj xobj = this._parent;
        if (xobj != null) {
            if (xobj._firstChild == this) {
                xobj._firstChild = this._nextSibling;
            }
            if (xobj._lastChild == this) {
                xobj._lastChild = this._prevSibling;
            }
            Xobj xobj2 = this._prevSibling;
            if (xobj2 != null) {
                xobj2._nextSibling = this._nextSibling;
            }
            Xobj xobj3 = this._nextSibling;
            if (xobj3 != null) {
                xobj3._prevSibling = xobj2;
            }
            this._parent = null;
            this._prevSibling = null;
            this._nextSibling = null;
        }
        return this;
    }

    final Xobj insertXobj(Xobj xobj) {
        ensureParent();
        xobj._parent = this._parent;
        xobj._prevSibling = this._prevSibling;
        xobj._nextSibling = this;
        Xobj xobj2 = this._prevSibling;
        if (xobj2 != null) {
            xobj2._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj;
        return this;
    }

    final Xobj appendXobj(Xobj xobj) {
        xobj._parent = this;
        Xobj xobj2 = this._lastChild;
        xobj._prevSibling = xobj2;
        if (xobj2 == null) {
            this._firstChild = xobj;
        } else {
            xobj2._nextSibling = xobj;
        }
        this._lastChild = xobj;
        return this;
    }

    final void removeXobjs(Xobj xobj, Xobj xobj2) {
        if (this._firstChild == xobj) {
            this._firstChild = xobj2._nextSibling;
        }
        if (this._lastChild == xobj2) {
            this._lastChild = xobj._prevSibling;
        }
        Xobj xobj3 = xobj._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj2._nextSibling;
        }
        Xobj xobj4 = xobj2._nextSibling;
        if (xobj4 != null) {
            xobj4._prevSibling = xobj3;
        }
        xobj._prevSibling = null;
        xobj2._nextSibling = null;
        while (xobj != null) {
            xobj._parent = null;
            xobj = xobj._nextSibling;
        }
    }

    final void insertXobjs(Xobj xobj, Xobj xobj2) {
        xobj._prevSibling = this._prevSibling;
        xobj2._nextSibling = this;
        Xobj xobj3 = this._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj2;
        while (xobj != this) {
            xobj._parent = this._parent;
            xobj = xobj._nextSibling;
        }
    }

    final void appendXobjs(Xobj xobj, Xobj xobj2) {
        Xobj xobj3 = this._lastChild;
        xobj._prevSibling = xobj3;
        if (xobj3 == null) {
            this._firstChild = xobj;
        } else {
            xobj3._nextSibling = xobj;
        }
        this._lastChild = xobj2;
        while (xobj != null) {
            xobj._parent = this;
            xobj = xobj._nextSibling;
        }
    }

    static final void disbandXobjs(Xobj xobj, Xobj xobj2) {
        while (xobj != null) {
            Xobj xobj3 = xobj._nextSibling;
            xobj._prevSibling = null;
            xobj._nextSibling = null;
            xobj = xobj3;
        }
    }

    final void invalidateSpecialAttr(Xobj xobj) {
        if (isAttr()) {
            if (this._name.equals(Locale._xsiType)) {
                Xobj xobj2 = this._parent;
                if (xobj2 != null) {
                    xobj2.disconnectNonRootUsers();
                }
                if (xobj != null) {
                    xobj.disconnectNonRootUsers();
                }
            }
            if (this._name.equals(Locale._xsiNil)) {
                Xobj xobj3 = this._parent;
                if (xobj3 != null) {
                    xobj3.invalidateNil();
                }
                if (xobj != null) {
                    xobj.invalidateNil();
                }
            }
        }
    }

    final void removeCharsHelper(int i, int i2, Xobj xobj, int i3, boolean z, boolean z2) {
        Xobj xobj2;
        Cur embedded = getEmbedded();
        while (embedded != null) {
            Cur cur = embedded._next;
            if (embedded._pos >= i && embedded._pos < i + i2) {
                if (z) {
                    embedded.moveToNoCheck(xobj, (embedded._pos + i3) - i);
                } else {
                    embedded.nextChars((i2 - embedded._pos) + i);
                }
            }
            if (embedded._xobj == this && embedded._pos >= i + i2) {
                embedded._pos -= i2;
            }
            embedded = cur;
        }
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            Bookmark bookmark2 = bookmark._next;
            if (bookmark._pos >= i && bookmark._pos < i + i2) {
                bookmark.moveTo(xobj, (bookmark._pos + i3) - i);
            }
            if (bookmark._xobj == this && bookmark._pos >= i + i2) {
                bookmark._pos -= i2;
            }
        }
        int iPosAfter = posAfter();
        CharUtil charUtil = this._locale.getCharUtil();
        if (i < iPosAfter) {
            this._srcValue = charUtil.removeChars(i - 1, i2, this._srcValue, this._offValue, this._cchValue);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z2) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.removeChars(i - iPosAfter, i2, this._srcAfter, this._offAfter, this._cchAfter);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z2 || (xobj2 = this._parent) == null) {
            return;
        }
        xobj2.invalidateUser();
    }

    final void insertCharsHelper(int i, Object obj, int i2, int i3, boolean z) {
        Xobj xobj;
        int iPosAfter = posAfter();
        if (i - (i < iPosAfter ? 1 : 2) < this._cchValue + this._cchAfter) {
            for (Cur embedded = getEmbedded(); embedded != null; embedded = embedded._next) {
                if (embedded._pos >= i) {
                    embedded._pos += i3;
                }
            }
            for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (bookmark._pos >= i) {
                    bookmark._pos += i3;
                }
            }
        }
        CharUtil charUtil = this._locale.getCharUtil();
        if (i < iPosAfter) {
            this._srcValue = charUtil.insertChars(i - 1, this._srcValue, this._offValue, this._cchValue, obj, i2, i3);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.insertChars(i - iPosAfter, this._srcAfter, this._offAfter, this._cchAfter, obj, i2, i3);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z || (xobj = this._parent) == null) {
            return;
        }
        xobj.invalidateUser();
    }

    Xobj copyNode(Locale locale) {
        Xobj xobj = this;
        Xobj xobj2 = null;
        Xobj xobj3 = null;
        while (true) {
            xobj.ensureOccupancy();
            Xobj xobjNewNode = xobj.newNode(locale);
            xobjNewNode._srcValue = xobj._srcValue;
            xobjNewNode._offValue = xobj._offValue;
            xobjNewNode._cchValue = xobj._cchValue;
            xobjNewNode._srcAfter = xobj._srcAfter;
            xobjNewNode._offAfter = xobj._offAfter;
            xobjNewNode._cchAfter = xobj._cchAfter;
            for (Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (xobj.hasBookmark(CDataBookmark.CDATA_BOOKMARK.getKey(), bookmark._pos)) {
                    xobjNewNode.setBookmark(bookmark._pos, CDataBookmark.CDATA_BOOKMARK.getKey(), CDataBookmark.CDATA_BOOKMARK);
                }
            }
            if (xobj2 == null) {
                xobj3 = xobjNewNode;
            } else {
                xobj2.appendXobj(xobjNewNode);
            }
            Xobj xobjWalk = xobj.walk(this, true);
            if (xobjWalk != null) {
                if (xobj == xobjWalk._parent) {
                    xobj2 = xobjNewNode;
                } else {
                    while (true) {
                        xobj = xobj._parent;
                        if (xobj != xobjWalk._parent) {
                            xobj2 = xobj2._parent;
                        }
                    }
                }
                xobj = xobjWalk;
            } else {
                xobj3._srcAfter = null;
                xobj3._offAfter = 0;
                xobj3._cchAfter = 0;
                return xobj3;
            }
        }
    }

    String getCharsAsString(int i, int i2, int i3) {
        if (cchRight(i) == 0) {
            return "";
        }
        Object chars = getChars(i, i2);
        if (i3 == 1) {
            return CharUtil.getString(chars, this._locale._offSrc, this._locale._cchSrc);
        }
        Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i3);
        scrubBuffer.scrub(chars, this._locale._offSrc, this._locale._cchSrc);
        return scrubBuffer.getResultAsString();
    }

    String getCharsAfterAsString(int i, int i2) {
        int i3 = i + this._cchValue + 2;
        if (i3 == posMax()) {
            i3 = -1;
        }
        return getCharsAsString(i3, i2, 1);
    }

    String getCharsValueAsString(int i, int i2) {
        return getCharsAsString(i + 1, i2, 1);
    }

    String getValueAsString(int i) {
        if (!hasChildren()) {
            Object firstChars = getFirstChars();
            if (i == 1) {
                String string = CharUtil.getString(firstChars, this._locale._offSrc, this._locale._cchSrc);
                if (string.length() > 0) {
                    Xobj xobjLastAttr = lastAttr();
                    if (xobjLastAttr != null) {
                        xobjLastAttr._srcAfter = string;
                        xobjLastAttr._offAfter = 0;
                    } else {
                        this._srcValue = string;
                        this._offValue = 0;
                    }
                }
                return string;
            }
            Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i);
            scrubBuffer.scrub(firstChars, this._locale._offSrc, this._locale._cchSrc);
            return scrubBuffer.getResultAsString();
        }
        Locale.ScrubBuffer scrubBuffer2 = Locale.getScrubBuffer(i);
        Cur curTempCur = tempCur();
        curTempCur.push();
        curTempCur.next();
        while (!curTempCur.isAtEndOfLastPush()) {
            if (curTempCur.isText()) {
                scrubBuffer2.scrub(curTempCur.getChars(-1), curTempCur._offSrc, curTempCur._cchSrc);
            }
            if (curTempCur.isComment() || curTempCur.isProcinst()) {
                curTempCur.skip();
            } else {
                curTempCur.next();
            }
        }
        String resultAsString = scrubBuffer2.getResultAsString();
        curTempCur.release();
        return resultAsString;
    }

    String getValueAsString() {
        return getValueAsString(1);
    }

    String getString(int i, int i2) {
        String string;
        int iCchRight = cchRight(i);
        if (iCchRight == 0) {
            return "";
        }
        if (i2 < 0 || i2 > iCchRight) {
            i2 = iCchRight;
        }
        int iPosAfter = posAfter();
        if (i >= iPosAfter) {
            string = CharUtil.getString(this._srcAfter, (this._offAfter + i) - iPosAfter, i2);
            if (i == iPosAfter && i2 == this._cchAfter) {
                this._srcAfter = string;
                this._offAfter = 0;
            }
        } else {
            string = CharUtil.getString(this._srcValue, (this._offValue + i) - 1, i2);
            if (i == 1 && i2 == this._cchValue) {
                this._srcValue = string;
                this._offValue = 0;
            }
        }
        return string;
    }

    Object getFirstChars() {
        ensureOccupancy();
        if (this._cchValue > 0) {
            return getChars(1, -1);
        }
        Xobj xobjLastAttr = lastAttr();
        if (xobjLastAttr == null || xobjLastAttr._cchAfter <= 0) {
            this._locale._offSrc = 0;
            this._locale._cchSrc = 0;
            return null;
        }
        return xobjLastAttr.getChars(xobjLastAttr.posAfter(), -1);
    }

    Object getChars(int i, int i2, Cur cur) {
        Object chars = getChars(i, i2);
        cur._offSrc = this._locale._offSrc;
        cur._cchSrc = this._locale._cchSrc;
        return chars;
    }

    Object getChars(int i, int i2) {
        int iCchRight = cchRight(i);
        if (i2 < 0 || i2 > iCchRight) {
            i2 = iCchRight;
        }
        if (i2 == 0) {
            this._locale._offSrc = 0;
            this._locale._cchSrc = 0;
            return null;
        }
        return getCharsHelper(i, i2);
    }

    Object getCharsHelper(int i, int i2) {
        Object obj;
        int iPosAfter = posAfter();
        if (i >= iPosAfter) {
            obj = this._srcAfter;
            this._locale._offSrc = (this._offAfter + i) - iPosAfter;
        } else {
            obj = this._srcValue;
            this._locale._offSrc = (this._offValue + i) - 1;
        }
        this._locale._cchSrc = i2;
        return obj;
    }

    final void setBit(int i) {
        this._bits = i | this._bits;
    }

    final void clearBit(int i) {
        this._bits = (~i) & this._bits;
    }

    final boolean bitIsSet(int i) {
        if ((i & this._bits) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean bitIsClear(int i) {
        if ((i & this._bits) == 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    final boolean isVacant() {
        return bitIsSet(256);
    }

    final boolean isOccupied() {
        return bitIsClear(256);
    }

    final boolean inhibitDisconnect() {
        return bitIsSet(1024);
    }

    final boolean isStableUser() {
        return bitIsSet(512);
    }

    void invalidateNil() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_nilvalue();
        }
    }

    void setStableType(SchemaType schemaType) {
        setStableUser(((TypeStoreUserFactory) schemaType).createTypeStoreUser());
    }

    void setStableUser(TypeStoreUser typeStoreUser) {
        disconnectNonRootUsers();
        disconnectUser();
        this._user = typeStoreUser;
        typeStoreUser.attach_store(this);
        setBit(512);
    }

    void disconnectUser() {
        if (this._user == null || inhibitDisconnect()) {
            return;
        }
        ensureOccupancy();
        this._user.disconnect_store();
        this._user = null;
    }

    void disconnectNonRootUsers() {
        Xobj xobj = this;
        while (xobj != null) {
            Xobj xobjWalk = xobj.walk(this, xobj._user != null ? true : $assertionsDisabled);
            if (!xobj.isRoot()) {
                xobj.disconnectUser();
            }
            xobj = xobjWalk;
        }
    }

    void disconnectChildrenUsers() {
        Xobj xobjWalk = walk(this, this._user == null);
        while (xobjWalk != null) {
            Xobj xobjWalk2 = xobjWalk.walk(this, xobjWalk._user != null);
            xobjWalk.disconnectUser();
            xobjWalk = xobjWalk2;
        }
    }

    final String namespaceForPrefix(String str, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str.equals(Sax2Dom.XML_PREFIX)) {
            return XMLValidationSchema.SCHEMA_ID_DTD;
        }
        if (str.equals(Sax2Dom.XMLNS_PREFIX)) {
            return Sax2Dom.XMLNS_URI;
        }
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobj2 = xobj._firstChild; xobj2 != null && xobj2.isAttr(); xobj2 = xobj2._nextSibling) {
                if (xobj2.isXmlns() && xobj2.getXmlnsPrefix().equals(str)) {
                    return xobj2.getXmlnsUri();
                }
            }
        }
        if (z && str.length() == 0) {
            return "";
        }
        return null;
    }

    final String prefixForNamespace(String str, String str2, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str.equals(XMLValidationSchema.SCHEMA_ID_DTD)) {
            return Sax2Dom.XML_PREFIX;
        }
        if (str.equals(Sax2Dom.XMLNS_URI)) {
            return Sax2Dom.XMLNS_PREFIX;
        }
        Xobj xobjEnsureParent = this;
        while (!xobjEnsureParent.isContainer()) {
            xobjEnsureParent = xobjEnsureParent.ensureParent();
        }
        if (str.length() == 0) {
            Xobj xobjFindXmlnsForPrefix = xobjEnsureParent.findXmlnsForPrefix("");
            if (xobjFindXmlnsForPrefix != null && xobjFindXmlnsForPrefix.getXmlnsUri().length() != 0) {
                if (!z) {
                    return null;
                }
                xobjEnsureParent.setAttr(this._locale.createXmlns(null), "");
            }
            return "";
        }
        for (Xobj xobj = xobjEnsureParent; xobj != null; xobj = xobj._parent) {
            for (Xobj xobjFirstAttr = xobj.firstAttr(); xobjFirstAttr != null; xobjFirstAttr = xobjFirstAttr.nextAttr()) {
                if (xobjFirstAttr.isXmlns() && xobjFirstAttr.getXmlnsUri().equals(str) && xobjEnsureParent.findXmlnsForPrefix(xobjFirstAttr.getXmlnsPrefix()) == xobjFirstAttr) {
                    return xobjFirstAttr.getXmlnsPrefix();
                }
            }
        }
        if (!z) {
            return null;
        }
        if (str2 != null && (str2.length() == 0 || str2.toLowerCase().startsWith(Sax2Dom.XML_PREFIX) || xobjEnsureParent.findXmlnsForPrefix(str2) != null)) {
            str2 = null;
        }
        if (str2 == null) {
            String strSuggestPrefix = QNameHelper.suggestPrefix(str);
            int i = 1;
            str2 = strSuggestPrefix;
            while (xobjEnsureParent.findXmlnsForPrefix(str2) != null) {
                str2 = strSuggestPrefix + i;
                i++;
            }
        }
        for (Xobj xobj2 = xobjEnsureParent; !xobj2.isRoot() && !xobj2.ensureParent().isRoot(); xobj2 = xobj2._parent) {
        }
        xobjEnsureParent.setAttr(this._locale.createXmlns(str2), str);
        return str2;
    }

    final QName getValueAsQName() {
        String strSubstring;
        String valueAsString = getValueAsString(3);
        int iIndexOf = valueAsString.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = valueAsString.substring(0, iIndexOf);
            valueAsString = valueAsString.substring(iIndexOf + 1);
        } else {
            strSubstring = "";
        }
        String strNamespaceForPrefix = namespaceForPrefix(strSubstring, true);
        if (strNamespaceForPrefix == null) {
            return null;
        }
        return new QName(strNamespaceForPrefix, valueAsString);
    }

    final Xobj getAttr(QName qName) {
        for (Xobj xobj = this._firstChild; xobj != null && xobj.isAttr(); xobj = xobj._nextSibling) {
            if (xobj._name.equals(qName)) {
                return xobj;
            }
        }
        return null;
    }

    final QName getXsiTypeName() {
        Xobj attr = getAttr(Locale._xsiType);
        if (attr == null) {
            return null;
        }
        return attr.getValueAsQName();
    }

    final XmlObject getObject() {
        if (isUserNode()) {
            return getUser();
        }
        return null;
    }

    final TypeStoreUser getUser() {
        if (this._user == null) {
            Xobj xobj = this._parent;
            TypeStoreUser typeStoreUserCreateTypeStoreUser = xobj == null ? XmlBeans.NO_TYPE.createTypeStoreUser() : xobj.getUser();
            TypeStoreUser typeStoreUserCreate_element_user = isElem() ? typeStoreUserCreateTypeStoreUser.create_element_user(this._name, getXsiTypeName()) : typeStoreUserCreateTypeStoreUser.create_attribute_user(this._name);
            this._user = typeStoreUserCreate_element_user;
            typeStoreUserCreate_element_user.attach_store(this);
        }
        return this._user;
    }

    final void invalidateUser() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_value();
        }
    }

    final void ensureOccupancy() {
        if (isVacant()) {
            clearBit(256);
            TypeStoreUser typeStoreUser = this._user;
            this._user = null;
            String strBuild_text = typeStoreUser.build_text(this);
            long j = this._locale._versionAll;
            long j2 = this._locale._versionSansText;
            setValue(strBuild_text);
            this._locale._versionAll = j;
            this._user = typeStoreUser;
        }
    }

    private void setValue(String str) {
        int iPosAfter;
        Xobj xobj;
        if (str.length() <= 0) {
            return;
        }
        this._locale.notifyChange();
        Xobj xobjLastAttr = lastAttr();
        if (xobjLastAttr != null) {
            iPosAfter = xobjLastAttr.posAfter();
            xobj = xobjLastAttr;
        } else {
            iPosAfter = 1;
            xobj = this;
        }
        xobj.insertCharsHelper(iPosAfter, str, 0, str.length(), true);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaTypeLoader get_schematypeloader() {
        return this._locale._schemaTypeLoader;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlLocale get_locale() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public Object get_root_object() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean is_attribute() {
        return isAttr();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean validate_on_set() {
        return this._locale._validateOnSet;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_text() {
        this._locale.enter();
        try {
            if (isOccupied()) {
                if (hasTextNoEnsureOccupancy() || hasChildren()) {
                    TypeStoreUser typeStoreUser = this._user;
                    this._user = null;
                    Cur curTempCur = tempCur();
                    curTempCur.moveNodeContents(null, $assertionsDisabled);
                    curTempCur.release();
                    this._user = typeStoreUser;
                }
                setBit(256);
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String fetch_text(int i) {
        this._locale.enter();
        try {
            return getValueAsString(i);
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlCursor new_cursor() {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            Cursor cursor = new Cursor(curTempCur);
            curTempCur.release();
            return cursor;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaField get_schema_field() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attribute_field(this._name);
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_schema_field();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void validate(ValidatorListener validatorListener) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            new Validate(curTempCur, validatorListener);
            curTempCur.release();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser change_type(SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            curTempCur.setType(schemaType, $assertionsDisabled);
            curTempCur.release();
            return getUser();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser substitute(QName qName, SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            curTempCur.setSubstitution(qName, schemaType, $assertionsDisabled);
            curTempCur.release();
            return getUser();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public QName get_xsi_type() {
        return getXsiTypeName();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void store_text(String str) {
        this._locale.enter();
        TypeStoreUser typeStoreUser = this._user;
        this._user = null;
        try {
            Cur curTempCur = tempCur();
            curTempCur.moveNodeContents(null, $assertionsDisabled);
            if (str != null && str.length() > 0) {
                curTempCur.next();
                curTempCur.insertString(str);
            }
            curTempCur.release();
        } finally {
            this._user = typeStoreUser;
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int compute_flags() {
        if (isRoot()) {
            return 0;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attributeflags(this._name);
        }
        int i = user.get_elementflags(this._name);
        if (i != -1) {
            return i;
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return 0;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_elementflags();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String compute_default_text() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_default_attribute_text(this._name);
        }
        String str = user.get_default_element_text(this._name);
        if (str != null) {
            return str;
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_default_text();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean find_nil() {
        boolean zIsAttr = isAttr();
        boolean z = $assertionsDisabled;
        if (zIsAttr) {
            return $assertionsDisabled;
        }
        this._locale.enter();
        try {
            Xobj attr = getAttr(Locale._xsiNil);
            if (attr != null) {
                String valueAsString = attr.getValueAsString(3);
                if (valueAsString.equals("true") || valueAsString.equals("1")) {
                    z = true;
                }
            }
            return z;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_nil() {
        if (isAttr()) {
            return;
        }
        this._locale.enter();
        try {
            if (!this._user.build_nil()) {
                removeAttr(Locale._xsiNil);
            } else {
                setAttr(Locale._xsiNil, "true");
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QName qName) {
        return this._locale.count(this, qName, null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QNameSet qNameSet) {
        return this._locale.count(this, null, qNameSet);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QName qName, int i) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName) && (i = i - 1) < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QNameSet qNameSet, int i) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name) && (i = i - 1) < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void find_all_element_users(QName qName, List list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName)) {
                list.add(xobj.getUser());
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void find_all_element_users(QNameSet qNameSet, List list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name)) {
                list.add(xobj.getUser());
            }
        }
    }

    private static TypeStoreUser insertElement(QName qName, Xobj xobj, int i) {
        xobj._locale.enter();
        try {
            Cur curTempCur = xobj._locale.tempCur();
            curTempCur.moveTo(xobj, i);
            curTempCur.createElement(qName);
            TypeStoreUser user = curTempCur.getUser();
            curTempCur.release();
            return user;
        } finally {
            xobj._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QName qName, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobjFindNthChildElem = this._locale.findNthChildElem(this, qName, null, i);
        if (xobjFindNthChildElem == null) {
            if (i > this._locale.count(this, qName, null) + 1) {
                throw new IndexOutOfBoundsException();
            }
            return add_element_user(qName);
        }
        return insertElement(qName, xobjFindNthChildElem, 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QNameSet qNameSet, QName qName, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobjFindNthChildElem = this._locale.findNthChildElem(this, null, qNameSet, i);
        if (xobjFindNthChildElem == null) {
            if (i > this._locale.count(this, null, qNameSet) + 1) {
                throw new IndexOutOfBoundsException();
            }
            return add_element_user(qName);
        }
        return insertElement(qName, xobjFindNthChildElem, 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_element_user(QName qName) {
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = null;
        boolean z = false;
        QNameSet qNameSet = null;
        for (Xobj xobj2 = this._lastChild; xobj2 != null; xobj2 = xobj2._prevSibling) {
            if (xobj2.isContainer()) {
                if (xobj2._name.equals(qName)) {
                    break;
                }
                if (!z) {
                    qNameSet = this._user.get_element_ending_delimiters(qName);
                    z = true;
                }
                if (qNameSet == null || qNameSet.contains(xobj2._name)) {
                    xobj = xobj2;
                }
            }
        }
        return xobj == null ? insertElement(qName, this, -1) : insertElement(qName, xobj, 0);
    }

    private static void removeElement(Xobj xobj) {
        if (xobj == null) {
            throw new IndexOutOfBoundsException();
        }
        xobj._locale.enter();
        try {
            Cur curTempCur = xobj.tempCur();
            curTempCur.moveNode(null);
            curTempCur.release();
        } finally {
            xobj._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QName qName, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = this._firstChild;
        while (xobj != null && (!xobj.isElem() || !xobj._name.equals(qName) || (i = i - 1) >= 0)) {
            xobj = xobj._nextSibling;
        }
        removeElement(xobj);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QNameSet qNameSet, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = this._firstChild;
        while (xobj != null && (!xobj.isElem() || !qNameSet.contains(xobj._name) || (i = i - 1) >= 0)) {
            xobj = xobj._nextSibling;
        }
        removeElement(xobj);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_attribute_user(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return null;
        }
        return attr.getUser();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_attribute_user(QName qName) {
        if (getAttr(qName) != null) {
            throw new IndexOutOfBoundsException();
        }
        this._locale.enter();
        try {
            return setAttr(qName, "").getUser();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_attribute(QName qName) {
        this._locale.enter();
        try {
            if (!removeAttr(qName)) {
                throw new IndexOutOfBoundsException();
            }
            this._locale.exit();
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy_contents_from(TypeStore typeStore) {
        Xobj xobj = (Xobj) typeStore;
        if (xobj == this) {
            return getUser();
        }
        this._locale.enter();
        try {
            xobj._locale.enter();
            Cur curTempCur = tempCur();
            try {
                Cur curTempCur2 = xobj.tempCur();
                Map allNamespaces = Locale.getAllNamespaces(curTempCur2, null);
                curTempCur2.release();
                if (isAttr()) {
                    Cur curTempCur3 = xobj.tempCur();
                    String textValue = Locale.getTextValue(curTempCur3);
                    curTempCur3.release();
                    curTempCur.setValue(textValue);
                } else {
                    disconnectChildrenUsers();
                    setBit(1024);
                    QName xsiTypeName = isContainer() ? getXsiTypeName() : null;
                    Xobj xobjCopyNode = xobj.copyNode(this._locale);
                    Cur.moveNodeContents(this, null, true);
                    curTempCur.next();
                    Cur.moveNodeContents(xobjCopyNode, curTempCur, true);
                    curTempCur.moveTo(this);
                    if (xsiTypeName != null) {
                        curTempCur.setXsiType(xsiTypeName);
                    }
                    clearBit(1024);
                }
                if (allNamespaces != null) {
                    if (!curTempCur.isContainer()) {
                        curTempCur.toParent();
                    }
                    Locale.applyNamespaces(curTempCur, allNamespaces);
                }
                curTempCur.release();
                xobj._locale.exit();
                Locale locale = this._locale;
                return getUser();
            } finally {
                curTempCur.release();
                xobj._locale.exit();
            }
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        Xobj xobjCreateDomDocumentRootXobj;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        SchemaType schemaType2 = (SchemaType) xmlOptionsMaskNull.get("DOCUMENT_TYPE");
        if (schemaType2 == null) {
            schemaType2 = schemaType == null ? XmlObject.type : schemaType;
        }
        Locale locale = locale();
        if (Boolean.TRUE.equals(xmlOptionsMaskNull.get(Locale.COPY_USE_NEW_LOCALE))) {
            locale = Locale.getLocale(schemaTypeLoader, xmlOptionsMaskNull);
        }
        if (schemaType2.isDocumentType() || (schemaType2.isNoType() && (this instanceof DocumentXobj))) {
            xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale, $assertionsDisabled);
        } else {
            xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale, true);
        }
        locale.enter();
        try {
            Cur curTempCur = xobjCreateDomDocumentRootXobj.tempCur();
            curTempCur.setType(schemaType);
            curTempCur.release();
            return xobjCreateDomDocumentRootXobj.copy_contents_from(this);
        } finally {
            locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void array_setter(XmlObject[] xmlObjectArr, QName qName) {
        this._locale.enter();
        try {
            int length = xmlObjectArr.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < length; i++) {
                XmlObject xmlObject = xmlObjectArr[i];
                if (xmlObject == null) {
                    throw new IllegalArgumentException("Array element null");
                }
                if (xmlObject.isImmutable()) {
                    arrayList.add(null);
                    arrayList2.add(null);
                } else {
                    Xobj xobj = (Xobj) ((TypeStoreUser) xmlObjectArr[i]).get_store();
                    Locale locale = xobj._locale;
                    Locale locale2 = this._locale;
                    if (locale == locale2) {
                        arrayList.add(xobj.copyNode(locale2));
                    } else {
                        locale.enter();
                        try {
                            arrayList.add(xobj.copyNode(this._locale));
                            xobj._locale.exit();
                        } catch (Throwable th) {
                            xobj._locale.exit();
                            throw th;
                        }
                    }
                    arrayList2.add(xmlObjectArr[i].schemaType());
                }
            }
            int iCount_elements = count_elements(qName);
            while (iCount_elements > length) {
                remove_element(qName, length);
                iCount_elements--;
            }
            while (length > iCount_elements) {
                add_element_user(qName);
                iCount_elements++;
            }
            ArrayList arrayList3 = new ArrayList();
            find_all_element_users(qName, arrayList3);
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                arrayList3.set(i2, (Xobj) ((TypeStoreUser) arrayList3.get(i2)).get_store());
            }
            Cur curTempCur = tempCur();
            for (int i3 = 0; i3 < iCount_elements; i3++) {
                Xobj xobj2 = (Xobj) arrayList3.get(i3);
                if (xmlObjectArr[i3].isImmutable()) {
                    xobj2.getObject().set(xmlObjectArr[i3]);
                } else {
                    Cur.moveNodeContents(xobj2, null, true);
                    curTempCur.moveTo(xobj2);
                    curTempCur.next();
                    Cur.moveNodeContents((Xobj) arrayList.get(i3), curTempCur, true);
                    xobj2.change_type((SchemaType) arrayList2.get(i3));
                }
            }
            curTempCur.release();
            this._locale.exit();
        } catch (Throwable th2) {
            this._locale.exit();
            throw th2;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void visit_elements(TypeStoreVisitor typeStoreVisitor) {
        throw new RuntimeException("Not implemeneted");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlObject[] exec_query(String str, XmlOptions xmlOptions) throws XmlException {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            XmlObject[] xmlObjectArrObjectExecQuery = Query.objectExecQuery(curTempCur, str, xmlOptions);
            curTempCur.release();
            return xmlObjectArrObjectExecQuery;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.NamespaceManager
    public String find_prefix_for_nsuri(String str, String str2) {
        this._locale.enter();
        try {
            return prefixForNamespace(str, str2, true);
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        return namespaceForPrefix(str, true);
    }

    static abstract class NodeXobj extends Xobj implements DomImpl.Dom, Node, NodeList {
        public NamedNodeMap getAttributes() {
            return null;
        }

        public NodeList getChildNodes() {
            return this;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        DomImpl.Dom getDom() {
            return this;
        }

        public boolean nodeCanHavePrefixUri() {
            return Xobj.$assertionsDisabled;
        }

        NodeXobj(Locale locale, int i, int i2) {
            super(locale, i, i2);
        }

        public int getLength() {
            return DomImpl._childNodes_getLength(this);
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return DomImpl._childNodes_item(this, i);
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        public Node getFirstChild() {
            return DomImpl._node_getFirstChild(this);
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return DomImpl._node_getLastChild(this);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return DomImpl._node_hasAttributes(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return DomImpl._node_hasChildNodes(this);
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        @Override // org.w3c.dom.Node
        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        @Override // org.w3c.dom.Node
        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        @Override // org.w3c.dom.Node
        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        @Override // org.w3c.dom.Node
        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        @Override // org.w3c.dom.Node
        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }
    }

    static class DocumentXobj extends NodeXobj implements Document {
        private Hashtable _idToElement;

        DocumentXobj(Locale locale) {
            super(locale, 1, 9);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DocumentXobj(locale);
        }

        @Override // org.w3c.dom.Document
        public Attr createAttribute(String str) {
            return DomImpl._document_createAttribute(this, str);
        }

        @Override // org.w3c.dom.Document
        public Attr createAttributeNS(String str, String str2) {
            return DomImpl._document_createAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public CDATASection createCDATASection(String str) {
            return DomImpl._document_createCDATASection(this, str);
        }

        @Override // org.w3c.dom.Document
        public Comment createComment(String str) {
            return DomImpl._document_createComment(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentFragment createDocumentFragment() {
            return DomImpl._document_createDocumentFragment(this);
        }

        @Override // org.w3c.dom.Document
        public Element createElement(String str) {
            return DomImpl._document_createElement(this, str);
        }

        @Override // org.w3c.dom.Document
        public Element createElementNS(String str, String str2) {
            return DomImpl._document_createElementNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public EntityReference createEntityReference(String str) {
            return DomImpl._document_createEntityReference(this, str);
        }

        @Override // org.w3c.dom.Document
        public ProcessingInstruction createProcessingInstruction(String str, String str2) {
            return DomImpl._document_createProcessingInstruction(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public Text createTextNode(String str) {
            return DomImpl._document_createTextNode(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentType getDoctype() {
            return DomImpl._document_getDoctype(this);
        }

        @Override // org.w3c.dom.Document
        public Element getDocumentElement() {
            return DomImpl._document_getDocumentElement(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.w3c.dom.Document
        public Element getElementById(String str) {
            Xobj xobj;
            Hashtable hashtable = this._idToElement;
            if (hashtable == null || (xobj = (Xobj) hashtable.get(str)) == 0) {
                return null;
            }
            if (!isInSameTree(xobj)) {
                this._idToElement.remove(str);
            }
            return (Element) xobj;
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagName(String str) {
            return DomImpl._document_getElementsByTagName(this, str);
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagNameNS(String str, String str2) {
            return DomImpl._document_getElementsByTagNameNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public DOMImplementation getImplementation() {
            return DomImpl._document_getImplementation(this);
        }

        @Override // org.w3c.dom.Document
        public Node importNode(Node node, boolean z) {
            return DomImpl._document_importNode(this, node, z);
        }

        @Override // org.w3c.dom.Document
        public Node adoptNode(Node node) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getDocumentURI() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public DOMConfiguration getDomConfig() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getInputEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public boolean getStrictErrorChecking() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getXmlEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public boolean getXmlStandalone() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getXmlVersion() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void normalizeDocument() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public Node renameNode(Node node, String str, String str2) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setDocumentURI(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setStrictErrorChecking(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setXmlStandalone(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setXmlVersion(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        protected void addIdElement(String str, DomImpl.Dom dom) {
            if (this._idToElement == null) {
                this._idToElement = new Hashtable();
            }
            this._idToElement.put(str, dom);
        }

        void removeIdElement(String str) {
            Hashtable hashtable = this._idToElement;
            if (hashtable != null) {
                hashtable.remove(str);
            }
        }
    }

    static class DocumentFragXobj extends NodeXobj implements DocumentFragment {
        DocumentFragXobj(Locale locale) {
            super(locale, 1, 11);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DocumentFragXobj(locale);
        }
    }

    static final class ElementAttributes implements NamedNodeMap {
        private ElementXobj _elementXobj;

        ElementAttributes(ElementXobj elementXobj) {
            this._elementXobj = elementXobj;
        }

        @Override // org.w3c.dom.NamedNodeMap
        public int getLength() {
            return DomImpl._attributes_getLength(this._elementXobj);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node getNamedItem(String str) {
            return DomImpl._attributes_getNamedItem(this._elementXobj, str);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node getNamedItemNS(String str, String str2) {
            return DomImpl._attributes_getNamedItemNS(this._elementXobj, str, str2);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node item(int i) {
            return DomImpl._attributes_item(this._elementXobj, i);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node removeNamedItem(String str) {
            return DomImpl._attributes_removeNamedItem(this._elementXobj, str);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node removeNamedItemNS(String str, String str2) {
            return DomImpl._attributes_removeNamedItemNS(this._elementXobj, str, str2);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node setNamedItem(Node node) {
            return DomImpl._attributes_setNamedItem(this._elementXobj, node);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node setNamedItemNS(Node node) {
            return DomImpl._attributes_setNamedItemNS(this._elementXobj, node);
        }
    }

    static abstract class NamedNodeXobj extends NodeXobj {
        boolean _canHavePrefixUri;

        NamedNodeXobj(Locale locale, int i, int i2) {
            super(locale, i, i2);
            this._canHavePrefixUri = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return this._canHavePrefixUri;
        }
    }

    static class ElementXobj extends NamedNodeXobj implements Element {
        private ElementAttributes _attributes;

        ElementXobj(Locale locale, QName qName) {
            super(locale, 2, 1);
            this._name = qName;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new ElementXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            if (this._attributes == null) {
                this._attributes = new ElementAttributes(this);
            }
            return this._attributes;
        }

        @Override // org.w3c.dom.Element
        public String getAttribute(String str) {
            return DomImpl._element_getAttribute(this, str);
        }

        @Override // org.w3c.dom.Element
        public Attr getAttributeNode(String str) {
            return DomImpl._element_getAttributeNode(this, str);
        }

        @Override // org.w3c.dom.Element
        public Attr getAttributeNodeNS(String str, String str2) {
            return DomImpl._element_getAttributeNodeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public String getAttributeNS(String str, String str2) {
            return DomImpl._element_getAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public NodeList getElementsByTagName(String str) {
            return DomImpl._element_getElementsByTagName(this, str);
        }

        @Override // org.w3c.dom.Element
        public NodeList getElementsByTagNameNS(String str, String str2) {
            return DomImpl._element_getElementsByTagNameNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public String getTagName() {
            return DomImpl._element_getTagName(this);
        }

        @Override // org.w3c.dom.Element
        public boolean hasAttribute(String str) {
            return DomImpl._element_hasAttribute(this, str);
        }

        @Override // org.w3c.dom.Element
        public boolean hasAttributeNS(String str, String str2) {
            return DomImpl._element_hasAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public void removeAttribute(String str) {
            DomImpl._element_removeAttribute(this, str);
        }

        @Override // org.w3c.dom.Element
        public Attr removeAttributeNode(Attr attr) {
            return DomImpl._element_removeAttributeNode(this, attr);
        }

        @Override // org.w3c.dom.Element
        public void removeAttributeNS(String str, String str2) {
            DomImpl._element_removeAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public void setAttribute(String str, String str2) {
            DomImpl._element_setAttribute(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public Attr setAttributeNode(Attr attr) {
            return DomImpl._element_setAttributeNode(this, attr);
        }

        @Override // org.w3c.dom.Element
        public Attr setAttributeNodeNS(Attr attr) {
            return DomImpl._element_setAttributeNodeNS(this, attr);
        }

        @Override // org.w3c.dom.Element
        public void setAttributeNS(String str, String str2, String str3) {
            DomImpl._element_setAttributeNS(this, str, str2, str3);
        }

        @Override // org.w3c.dom.Element
        public TypeInfo getSchemaTypeInfo() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Element
        public void setIdAttribute(String str, boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Element
        public void setIdAttributeNS(String str, String str2, boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Element
        public void setIdAttributeNode(Attr attr, boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }
    }

    static class AttrXobj extends NamedNodeXobj implements Attr {
        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public Node getNextSibling() {
            return null;
        }

        public boolean isId() {
            return Xobj.$assertionsDisabled;
        }

        AttrXobj(Locale locale, QName qName) {
            super(locale, 3, 2);
            this._name = qName;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new AttrXobj(locale, this._name);
        }

        @Override // org.w3c.dom.Attr
        public String getName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Attr
        public Element getOwnerElement() {
            return DomImpl._attr_getOwnerElement(this);
        }

        @Override // org.w3c.dom.Attr
        public boolean getSpecified() {
            return DomImpl._attr_getSpecified(this);
        }

        @Override // org.w3c.dom.Attr
        public String getValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Attr
        public void setValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Attr
        public TypeInfo getSchemaTypeInfo() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }
    }

    static class AttrIdXobj extends AttrXobj {
        @Override // org.apache.xmlbeans.impl.store.Xobj.AttrXobj, org.w3c.dom.Attr
        public boolean isId() {
            return true;
        }

        AttrIdXobj(Locale locale, QName qName) {
            super(locale, qName);
        }
    }

    static class CommentXobj extends NodeXobj implements Comment {
        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        CommentXobj(Locale locale) {
            super(locale, 4, 8);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new CommentXobj(locale);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public NodeList getChildNodes() {
            return DomImpl._emptyNodeList;
        }

        @Override // org.w3c.dom.CharacterData
        public void appendData(String str) {
            DomImpl._characterData_appendData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void deleteData(int i, int i2) {
            DomImpl._characterData_deleteData(this, i, i2);
        }

        @Override // org.w3c.dom.CharacterData
        public String getData() {
            return DomImpl._characterData_getData(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
        public int getLength() {
            return DomImpl._characterData_getLength(this);
        }

        @Override // org.w3c.dom.CharacterData
        public void insertData(int i, String str) {
            DomImpl._characterData_insertData(this, i, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void replaceData(int i, int i2, String str) {
            DomImpl._characterData_replaceData(this, i, i2, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void setData(String str) {
            DomImpl._characterData_setData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public String substringData(int i, int i2) {
            return DomImpl._characterData_substringData(this, i, i2);
        }
    }

    static class ProcInstXobj extends NodeXobj implements ProcessingInstruction {
        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
        public int getLength() {
            return 0;
        }

        ProcInstXobj(Locale locale, String str) {
            super(locale, 5, 7);
            this._name = this._locale.makeQName(null, str);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new ProcInstXobj(locale, this._name.getLocalPart());
        }

        @Override // org.w3c.dom.ProcessingInstruction
        public String getData() {
            return DomImpl._processingInstruction_getData(this);
        }

        @Override // org.w3c.dom.ProcessingInstruction
        public String getTarget() {
            return DomImpl._processingInstruction_getTarget(this);
        }

        @Override // org.w3c.dom.ProcessingInstruction
        public void setData(String str) {
            DomImpl._processingInstruction_setData(this, str);
        }
    }

    static class SoapPartDocXobj extends DocumentXobj {
        SoapPartDom _soapPartDom;

        SoapPartDocXobj(Locale locale) {
            super(locale);
            this._soapPartDom = new SoapPartDom(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.apache.xmlbeans.impl.store.Xobj
        DomImpl.Dom getDom() {
            return this._soapPartDom;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.DocumentXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapPartDocXobj(locale);
        }
    }

    static class SoapPartDom extends SOAPPart implements DomImpl.Dom, Document, NodeList {
        SoapPartDocXobj _docXobj;

        @Override // org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public NodeList getChildNodes() {
            return this;
        }

        public String name() {
            return "#document";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 9;
        }

        SoapPartDom(SoapPartDocXobj soapPartDocXobj) {
            this._docXobj = soapPartDocXobj;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Locale locale() {
            return this._docXobj._locale;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Cur tempCur() {
            return this._docXobj.tempCur();
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public QName getQName() {
            return this._docXobj._name;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump() {
            dump(System.out);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream) {
            this._docXobj.dump(printStream);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream, Object obj) {
            this._docXobj.dump(printStream, obj);
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node getFirstChild() {
            return DomImpl._node_getFirstChild(this);
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return DomImpl._node_getLastChild(this);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        @Override // org.w3c.dom.Node
        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return DomImpl._node_hasAttributes(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return DomImpl._node_hasChildNodes(this);
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        @Override // org.w3c.dom.Node
        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        @Override // org.w3c.dom.Node
        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        @Override // org.w3c.dom.Node
        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        @Override // org.w3c.dom.Node
        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        @Override // org.w3c.dom.Node
        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }

        @Override // org.w3c.dom.Document
        public Node adoptNode(Node node) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getDocumentURI() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public DOMConfiguration getDomConfig() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getInputEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public boolean getStrictErrorChecking() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getXmlEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public boolean getXmlStandalone() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public String getXmlVersion() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void normalizeDocument() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public Node renameNode(Node node, String str, String str2) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setDocumentURI(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setStrictErrorChecking(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setXmlStandalone(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public void setXmlVersion(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public Attr createAttribute(String str) {
            return DomImpl._document_createAttribute(this, str);
        }

        @Override // org.w3c.dom.Document
        public Attr createAttributeNS(String str, String str2) {
            return DomImpl._document_createAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public CDATASection createCDATASection(String str) {
            return DomImpl._document_createCDATASection(this, str);
        }

        @Override // org.w3c.dom.Document
        public Comment createComment(String str) {
            return DomImpl._document_createComment(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentFragment createDocumentFragment() {
            return DomImpl._document_createDocumentFragment(this);
        }

        @Override // org.w3c.dom.Document
        public Element createElement(String str) {
            return DomImpl._document_createElement(this, str);
        }

        @Override // org.w3c.dom.Document
        public Element createElementNS(String str, String str2) {
            return DomImpl._document_createElementNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public EntityReference createEntityReference(String str) {
            return DomImpl._document_createEntityReference(this, str);
        }

        @Override // org.w3c.dom.Document
        public ProcessingInstruction createProcessingInstruction(String str, String str2) {
            return DomImpl._document_createProcessingInstruction(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public Text createTextNode(String str) {
            return DomImpl._document_createTextNode(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentType getDoctype() {
            return DomImpl._document_getDoctype(this);
        }

        @Override // org.w3c.dom.Document
        public Element getDocumentElement() {
            return DomImpl._document_getDocumentElement(this);
        }

        @Override // org.w3c.dom.Document
        public Element getElementById(String str) {
            return DomImpl._document_getElementById(this, str);
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagName(String str) {
            return DomImpl._document_getElementsByTagName(this, str);
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagNameNS(String str, String str2) {
            return DomImpl._document_getElementsByTagNameNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public DOMImplementation getImplementation() {
            return DomImpl._document_getImplementation(this);
        }

        @Override // org.w3c.dom.Document
        public Node importNode(Node node, boolean z) {
            return DomImpl._document_importNode(this, node, z);
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return DomImpl._childNodes_getLength(this);
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return DomImpl._childNodes_item(this, i);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void removeAllMimeHeaders() {
            DomImpl._soapPart_removeAllMimeHeaders(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void removeMimeHeader(String str) {
            DomImpl._soapPart_removeMimeHeader(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Iterator getAllMimeHeaders() {
            return DomImpl._soapPart_getAllMimeHeaders(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public SOAPEnvelope getEnvelope() {
            return DomImpl._soapPart_getEnvelope(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Source getContent() {
            return DomImpl._soapPart_getContent(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void setContent(Source source) {
            DomImpl._soapPart_setContent(this, source);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public String[] getMimeHeader(String str) {
            return DomImpl._soapPart_getMimeHeader(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void addMimeHeader(String str, String str2) {
            DomImpl._soapPart_addMimeHeader(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void setMimeHeader(String str, String str2) {
            DomImpl._soapPart_setMimeHeader(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Iterator getMatchingMimeHeaders(String[] strArr) {
            return DomImpl._soapPart_getMatchingMimeHeaders(this, strArr);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Iterator getNonMatchingMimeHeaders(String[] strArr) {
            return DomImpl._soapPart_getNonMatchingMimeHeaders(this, strArr);
        }
    }

    static class SoapElementXobj extends ElementXobj implements SOAPElement, org.apache.xmlbeans.impl.soap.Node {
        SoapElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapElementXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public void removeContents() {
            DomImpl._soapElement_removeContents(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public String getEncodingStyle() {
            return DomImpl._soapElement_getEncodingStyle(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public void setEncodingStyle(String str) {
            DomImpl._soapElement_setEncodingStyle(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public boolean removeNamespaceDeclaration(String str) {
            return DomImpl._soapElement_removeNamespaceDeclaration(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getAllAttributes() {
            return DomImpl._soapElement_getAllAttributes(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getChildElements() {
            return DomImpl._soapElement_getChildElements(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getNamespacePrefixes() {
            return DomImpl._soapElement_getNamespacePrefixes(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addAttribute(Name name, String str) throws SOAPException {
            return DomImpl._soapElement_addAttribute(this, name, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(SOAPElement sOAPElement) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, sOAPElement);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(Name name) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(String str) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(String str, String str2) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(String str, String str2, String str3) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addNamespaceDeclaration(String str, String str2) {
            return DomImpl._soapElement_addNamespaceDeclaration(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addTextNode(String str) {
            return DomImpl._soapElement_addTextNode(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public String getAttributeValue(Name name) {
            return DomImpl._soapElement_getAttributeValue(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getChildElements(Name name) {
            return DomImpl._soapElement_getChildElements(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Name getElementName() {
            return DomImpl._soapElement_getElementName(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public String getNamespaceURI(String str) {
            return DomImpl._soapElement_getNamespaceURI(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getVisibleNamespacePrefixes() {
            return DomImpl._soapElement_getVisibleNamespacePrefixes(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public boolean removeAttribute(Name name) {
            return DomImpl._soapElement_removeAttribute(this, name);
        }
    }

    static class SoapBodyXobj extends SoapElementXobj implements SOAPBody {
        SoapBodyXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapBodyXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public boolean hasFault() {
            return DomImpl.soapBody_hasFault(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault addFault() throws SOAPException {
            return DomImpl.soapBody_addFault(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault getFault() {
            return DomImpl.soapBody_getFault(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPBodyElement addBodyElement(Name name) {
            return DomImpl.soapBody_addBodyElement(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPBodyElement addDocument(Document document) {
            return DomImpl.soapBody_addDocument(this, document);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault addFault(Name name, String str) throws SOAPException {
            return DomImpl.soapBody_addFault(this, name, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault addFault(Name name, String str, java.util.Locale locale) throws SOAPException {
            return DomImpl.soapBody_addFault(this, name, str, locale);
        }
    }

    static class SoapBodyElementXobj extends SoapElementXobj implements SOAPBodyElement {
        SoapBodyElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapBodyElementXobj(locale, this._name);
        }
    }

    static class SoapEnvelopeXobj extends SoapElementXobj implements SOAPEnvelope {
        SoapEnvelopeXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapEnvelopeXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPBody addBody() throws SOAPException {
            return DomImpl._soapEnvelope_addBody(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPBody getBody() throws SOAPException {
            return DomImpl._soapEnvelope_getBody(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPHeader getHeader() throws SOAPException {
            return DomImpl._soapEnvelope_getHeader(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPHeader addHeader() throws SOAPException {
            return DomImpl._soapEnvelope_addHeader(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public Name createName(String str) {
            return DomImpl._soapEnvelope_createName(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public Name createName(String str, String str2, String str3) {
            return DomImpl._soapEnvelope_createName(this, str, str2, str3);
        }
    }

    static class SoapHeaderXobj extends SoapElementXobj implements SOAPHeader {
        SoapHeaderXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapHeaderXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator examineAllHeaderElements() {
            return DomImpl.soapHeader_examineAllHeaderElements(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator extractAllHeaderElements() {
            return DomImpl.soapHeader_extractAllHeaderElements(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator examineHeaderElements(String str) {
            return DomImpl.soapHeader_examineHeaderElements(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator examineMustUnderstandHeaderElements(String str) {
            return DomImpl.soapHeader_examineMustUnderstandHeaderElements(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator extractHeaderElements(String str) {
            return DomImpl.soapHeader_extractHeaderElements(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public SOAPHeaderElement addHeaderElement(Name name) {
            return DomImpl.soapHeader_addHeaderElement(this, name);
        }
    }

    static class SoapHeaderElementXobj extends SoapElementXobj implements SOAPHeaderElement {
        SoapHeaderElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapHeaderElementXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public void setMustUnderstand(boolean z) {
            DomImpl.soapHeaderElement_setMustUnderstand(this, z);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public boolean getMustUnderstand() {
            return DomImpl.soapHeaderElement_getMustUnderstand(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public void setActor(String str) {
            DomImpl.soapHeaderElement_setActor(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public String getActor() {
            return DomImpl.soapHeaderElement_getActor(this);
        }
    }

    static class SoapFaultXobj extends SoapBodyElementXobj implements SOAPFault {
        SoapFaultXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapBodyElementXobj, org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapFaultXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultString(String str) {
            DomImpl.soapFault_setFaultString(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultString(String str, java.util.Locale locale) {
            DomImpl.soapFault_setFaultString(this, str, locale);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultCode(Name name) throws SOAPException {
            DomImpl.soapFault_setFaultCode(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultActor(String str) {
            DomImpl.soapFault_setFaultActor(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public String getFaultActor() {
            return DomImpl.soapFault_getFaultActor(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public String getFaultCode() {
            return DomImpl.soapFault_getFaultCode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultCode(String str) throws SOAPException {
            DomImpl.soapFault_setFaultCode(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public java.util.Locale getFaultStringLocale() {
            return DomImpl.soapFault_getFaultStringLocale(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public Name getFaultCodeAsName() {
            return DomImpl.soapFault_getFaultCodeAsName(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public String getFaultString() {
            return DomImpl.soapFault_getFaultString(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public Detail addDetail() throws SOAPException {
            return DomImpl.soapFault_addDetail(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public Detail getDetail() {
            return DomImpl.soapFault_getDetail(this);
        }
    }

    static class SoapFaultElementXobj extends SoapElementXobj implements SOAPFaultElement {
        SoapFaultElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapFaultElementXobj(locale, this._name);
        }
    }

    static class DetailXobj extends SoapFaultElementXobj implements Detail {
        DetailXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapFaultElementXobj, org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DetailXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.Detail
        public DetailEntry addDetailEntry(Name name) {
            return DomImpl.detail_addDetailEntry(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.Detail
        public Iterator getDetailEntries() {
            return DomImpl.detail_getDetailEntries(this);
        }
    }

    static class DetailEntryXobj extends SoapElementXobj implements DetailEntry {
        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DetailEntryXobj(locale, this._name);
        }

        DetailEntryXobj(Locale locale, QName qName) {
            super(locale, qName);
        }
    }

    static class Bookmark implements XmlCursor.XmlMark {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        Object _key;
        Bookmark _next;
        int _pos;
        Bookmark _prev;
        Object _value;
        Xobj _xobj;

        Bookmark() {
        }

        boolean isOnList(Bookmark bookmark) {
            while (bookmark != null) {
                if (bookmark == this) {
                    return true;
                }
                bookmark = bookmark._next;
            }
            return Xobj.$assertionsDisabled;
        }

        Bookmark listInsert(Bookmark bookmark) {
            if (bookmark == null) {
                this._prev = this;
                return this;
            }
            this._prev = bookmark._prev;
            bookmark._prev._next = this;
            bookmark._prev = this;
            return bookmark;
        }

        Bookmark listRemove(Bookmark bookmark) {
            Bookmark bookmark2 = this._prev;
            if (bookmark2 == this) {
                bookmark = null;
            } else {
                if (bookmark == this) {
                    bookmark = this._next;
                } else {
                    bookmark2._next = this._next;
                }
                Bookmark bookmark3 = this._next;
                if (bookmark3 == null) {
                    bookmark._prev = bookmark2;
                } else {
                    bookmark3._prev = bookmark2;
                    this._next = null;
                }
            }
            this._prev = null;
            return bookmark;
        }

        void moveTo(Xobj xobj, int i) {
            Xobj xobj2 = this._xobj;
            if (xobj2 != xobj) {
                xobj2._bookmarks = listRemove(xobj2._bookmarks);
                xobj._bookmarks = listInsert(xobj._bookmarks);
                this._xobj = xobj;
            }
            this._pos = i;
        }

        public XmlCursor createCursor() {
            Xobj xobj = this._xobj;
            if (xobj == null) {
                throw new IllegalStateException("Attempting to create a cursor on a bookmark that has been cleared or replaced.");
            }
            return Cursor.newCursor(xobj, this._pos);
        }
    }
}

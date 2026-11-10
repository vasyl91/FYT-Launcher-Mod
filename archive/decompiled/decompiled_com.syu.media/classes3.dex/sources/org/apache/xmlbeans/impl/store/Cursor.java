package org.apache.xmlbeans.impl.store;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.codehaus.stax2.typed.Base64Variant;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class Cursor implements XmlCursor, Locale.ChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    private static final int COPY_CHARS = 5;
    private static final int COPY_XML = 1;
    private static final int COPY_XML_CONTENTS = 3;
    static final int ELEM = 2;
    private static final int MOVE_CHARS = 4;
    private static final int MOVE_XML = 0;
    private static final int MOVE_XML_CONTENTS = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    private Cur _cur;
    private int _currentSelection;
    private Locale.ChangeListener _nextChangeListener;
    private Path.PathEngine _pathEngine;

    Cursor(Xobj xobj, int i) {
        Cur curWeakCur = xobj._locale.weakCur(this);
        this._cur = curWeakCur;
        curWeakCur.moveTo(xobj, i);
        this._currentSelection = -1;
    }

    Cursor(Cur cur) {
        this(cur._xobj, cur._pos);
    }

    private static boolean isValid(Cur cur) {
        int iKind;
        if (cur.kind() > 0) {
            return true;
        }
        cur.push();
        if (cur.toParentRaw() && ((iKind = cur.kind()) == 4 || iKind == 5 || iKind == 3)) {
            return $assertionsDisabled;
        }
        cur.pop();
        return true;
    }

    private boolean isValid() {
        return isValid(this._cur);
    }

    Locale locale() {
        return this._cur._locale;
    }

    Cur tempCur() {
        return this._cur.tempCur();
    }

    public void dump(PrintStream printStream) {
        this._cur.dump(printStream);
    }

    static void validateLocalName(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("QName is null");
        }
        validateLocalName(qName.getLocalPart());
    }

    static void validateLocalName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidNCName(str)) {
            throw new IllegalArgumentException("Name is not valid");
        }
    }

    static void validatePrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Prefix is empty");
        }
        if (Locale.beginsWithXml(str)) {
            throw new IllegalArgumentException("Prefix begins with 'xml'");
        }
        if (!XMLChar.isValidNCName(str)) {
            throw new IllegalArgumentException("Prefix is not valid");
        }
    }

    private static void complain(String str) {
        throw new IllegalArgumentException(str);
    }

    private void checkInsertionValidity(Cur cur) {
        int iKind = cur.kind();
        if (iKind < 0) {
            complain("Can't move/copy/insert an end token.");
        }
        if (iKind == 1) {
            complain("Can't move/copy/insert a whole document.");
        }
        int iKind2 = this._cur.kind();
        if (iKind2 == 1) {
            complain("Can't insert before the start of the document.");
        }
        if (iKind == 3) {
            this._cur.push();
            this._cur.prevWithAttrs();
            int iKind3 = this._cur.kind();
            this._cur.pop();
            if (iKind3 != 2 && iKind3 != 1 && iKind3 != -3) {
                complain("Can only insert attributes before other attributes or after containers.");
            }
        }
        if (iKind2 != 3 || iKind == 3) {
            return;
        }
        complain("Can only insert attributes before other attributes or after containers.");
    }

    private void insertNode(Cur cur, String str) {
        if (str != null && str.length() > 0) {
            cur.next();
            cur.insertString(str);
            cur.toParent();
        }
        checkInsertionValidity(cur);
        cur.moveNode(this._cur);
        this._cur.toEnd();
        this._cur.nextWithAttrs();
    }

    public void _dispose() {
        this._cur.release();
        this._cur = null;
    }

    public XmlCursor _newCursor() {
        return new Cursor(this._cur);
    }

    public QName _getName() {
        int iKind = this._cur.kind();
        if (iKind != 2) {
            if (iKind != 3) {
                if (iKind != 5) {
                    return null;
                }
            } else if (this._cur.isXmlns()) {
                return this._cur._locale.makeQNameNoCheck(this._cur.getXmlnsUri(), this._cur.getXmlnsPrefix());
            }
        }
        return this._cur.getName();
    }

    public void _setName(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Name is null");
        }
        int iKind = this._cur.kind();
        if (iKind == 2 || iKind == 3) {
            validateLocalName(qName.getLocalPart());
        } else if (iKind == 5) {
            validatePrefix(qName.getLocalPart());
            if (qName.getNamespaceURI().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no URI");
            }
            if (qName.getPrefix().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no prefix");
            }
        } else {
            throw new IllegalStateException("Can set name on element, atrtribute and procinst only");
        }
        this._cur.setName(qName);
    }

    public XmlCursor.TokenType _currentTokenType() {
        switch (this._cur.kind()) {
            case Base64Variant.BASE64_VALUE_PADDING /* -2 */:
                return XmlCursor.TokenType.END;
            case -1:
                return XmlCursor.TokenType.ENDDOC;
            case 0:
                return XmlCursor.TokenType.TEXT;
            case 1:
                return XmlCursor.TokenType.STARTDOC;
            case 2:
                return XmlCursor.TokenType.START;
            case 3:
                return this._cur.isXmlns() ? XmlCursor.TokenType.NAMESPACE : XmlCursor.TokenType.ATTR;
            case 4:
                return XmlCursor.TokenType.COMMENT;
            case 5:
                return XmlCursor.TokenType.PROCINST;
            default:
                throw new IllegalStateException();
        }
    }

    public boolean _isStartdoc() {
        return this._cur.isRoot();
    }

    public boolean _isEnddoc() {
        return this._cur.isEndRoot();
    }

    public boolean _isStart() {
        return this._cur.isElem();
    }

    public boolean _isEnd() {
        return this._cur.isEnd();
    }

    public boolean _isText() {
        return this._cur.isText();
    }

    public boolean _isAttr() {
        return this._cur.isNormalAttr();
    }

    public boolean _isNamespace() {
        return this._cur.isXmlns();
    }

    public boolean _isComment() {
        return this._cur.isComment();
    }

    public boolean _isProcinst() {
        return this._cur.isProcinst();
    }

    public boolean _isContainer() {
        return this._cur.isContainer();
    }

    public boolean _isFinish() {
        return this._cur.isFinish();
    }

    public boolean _isAnyAttr() {
        return this._cur.isAttr();
    }

    public XmlCursor.TokenType _toNextToken() {
        int iKind = this._cur.kind();
        if (iKind == 1 || iKind == 2) {
            if (!this._cur.toFirstAttr()) {
                this._cur.next();
            }
        } else if (iKind != 3) {
            if (iKind == 4 || iKind == 5) {
                this._cur.skip();
            } else if (!this._cur.next()) {
                return XmlCursor.TokenType.NONE;
            }
        } else if (!this._cur.toNextSibling()) {
            this._cur.toParent();
            this._cur.next();
        }
        return _currentTokenType();
    }

    public XmlCursor.TokenType _toPrevToken() {
        boolean zIsText = this._cur.isText();
        if (!this._cur.prev()) {
            if (this._cur.isRoot()) {
                return XmlCursor.TokenType.NONE;
            }
            this._cur.toParent();
        } else {
            int iKind = this._cur.kind();
            if (iKind < 0 && (iKind == -4 || iKind == -5 || iKind == -3)) {
                this._cur.toParent();
            } else if (this._cur.isContainer()) {
                this._cur.toLastAttr();
            } else if (zIsText && this._cur.isText()) {
                return _toPrevToken();
            }
        }
        return _currentTokenType();
    }

    public Object _monitor() {
        return this._cur._locale;
    }

    public boolean _toParent() {
        Cur curTempCur = this._cur.tempCur();
        if (!curTempCur.toParent()) {
            return $assertionsDisabled;
        }
        this._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    private static final class ChangeStampImpl implements XmlCursor.ChangeStamp {
        private final Locale _locale;
        private final long _versionStamp;

        ChangeStampImpl(Locale locale) {
            this._locale = locale;
            this._versionStamp = locale.version();
        }

        public boolean hasChanged() {
            if (this._versionStamp != this._locale.version()) {
                return true;
            }
            return Cursor.$assertionsDisabled;
        }
    }

    public XmlCursor.ChangeStamp _getDocChangeStamp() {
        return new ChangeStampImpl(this._cur._locale);
    }

    public XMLInputStream _newXMLInputStream() {
        return _newXMLInputStream(null);
    }

    public XMLStreamReader _newXMLStreamReader() {
        return _newXMLStreamReader(null);
    }

    public Node _newDomNode() {
        return _newDomNode(null);
    }

    public InputStream _newInputStream() {
        return _newInputStream(null);
    }

    public String _xmlText() {
        return _xmlText(null);
    }

    public Reader _newReader() {
        return _newReader(null);
    }

    public void _save(File file) throws IOException {
        _save(file, (XmlOptions) null);
    }

    public void _save(OutputStream outputStream) throws IOException {
        _save(outputStream, (XmlOptions) null);
    }

    public void _save(Writer writer) throws IOException {
        _save(writer, (XmlOptions) null);
    }

    public void _save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        _save(contentHandler, lexicalHandler, null);
    }

    public XmlDocumentProperties _documentProperties() {
        return Locale.getDocProps(this._cur, true);
    }

    public XMLStreamReader _newXMLStreamReader(XmlOptions xmlOptions) {
        return Jsr173.newXmlStreamReader(this._cur, xmlOptions);
    }

    public XMLInputStream _newXMLInputStream(XmlOptions xmlOptions) {
        return new Saver.XmlInputStreamImpl(this._cur, xmlOptions);
    }

    public String _xmlText(XmlOptions xmlOptions) {
        return new Saver.TextSaver(this._cur, xmlOptions, null).saveToString();
    }

    public InputStream _newInputStream(XmlOptions xmlOptions) {
        return new Saver.InputStreamSaver(this._cur, xmlOptions);
    }

    public Reader _newReader(XmlOptions xmlOptions) {
        return new Saver.TextReader(this._cur, xmlOptions);
    }

    public void _save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        new Saver.SaxSaver(this._cur, xmlOptions, contentHandler, lexicalHandler);
    }

    public void _save(File file, XmlOptions xmlOptions) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Null file specified");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            _save(fileOutputStream, xmlOptions);
        } finally {
            fileOutputStream.close();
        }
    }

    public void _save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null OutputStream specified");
        }
        InputStream inputStream_newInputStream = _newInputStream(xmlOptions);
        try {
            byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
            while (true) {
                int i = inputStream_newInputStream.read(bArr);
                if (i >= 0) {
                    outputStream.write(bArr, 0, i);
                } else {
                    inputStream_newInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            inputStream_newInputStream.close();
            throw th;
        }
    }

    public void _save(Writer writer, XmlOptions xmlOptions) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("Null Writer specified");
        }
        if (xmlOptions != null && xmlOptions.hasOption("SAVE_OPTIMIZE_FOR_SPEED")) {
            Saver.OptimizedForSpeedSaver.save(this._cur, writer);
            return;
        }
        Reader reader_newReader = _newReader(xmlOptions);
        try {
            char[] cArr = new char[XMLEvent.ENTITY_REFERENCE];
            while (true) {
                int i = reader_newReader.read(cArr);
                if (i >= 0) {
                    writer.write(cArr, 0, i);
                } else {
                    reader_newReader.close();
                    return;
                }
            }
        } catch (Throwable th) {
            reader_newReader.close();
            throw th;
        }
    }

    public Node _getDomNode() {
        return (Node) this._cur.getDom();
    }

    private boolean isDomFragment() {
        if (!isStartdoc()) {
            return true;
        }
        XmlCursor xmlCursorNewCursor = newCursor();
        int iIntValue = xmlCursorNewCursor.toNextToken().intValue();
        boolean z = $assertionsDisabled;
        while (true) {
            switch (iIntValue) {
                case 0:
                case 1:
                case 2:
                    xmlCursorNewCursor.dispose();
                    return !z;
                case 3:
                    if (z) {
                        xmlCursorNewCursor.dispose();
                        return true;
                    }
                    iIntValue = xmlCursorNewCursor.toEndToken().intValue();
                    z = true;
                    break;
                case 4:
                case 8:
                case 9:
                    iIntValue = xmlCursorNewCursor.toNextToken().intValue();
                    break;
                case 5:
                    try {
                        if (!Locale.isWhiteSpace(xmlCursorNewCursor.getChars())) {
                            xmlCursorNewCursor.dispose();
                            return true;
                        }
                        iIntValue = xmlCursorNewCursor.toNextToken().intValue();
                    } catch (Throwable th) {
                        xmlCursorNewCursor.dispose();
                        throw th;
                    }
                    break;
                case 6:
                case 7:
                    xmlCursorNewCursor.dispose();
                    return true;
            }
        }
    }

    private static final class DomSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean _isFrag;
        private Cur _nodeCur;
        private XmlOptions _options;
        private SchemaTypeLoader _stl;
        private SchemaType _type;

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(Saver.SaveCur saveCur) {
        }

        DomSaver(Cur cur, boolean z, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
            if (cur.isUserNode()) {
                this._type = cur.getUser().get_schema_type();
            }
            this._stl = cur._locale._schemaTypeLoader;
            this._options = xmlOptions;
            this._isFrag = z;
        }

        Node saveDom() {
            Locale locale = Locale.getLocale(this._stl, this._options);
            locale.enter();
            try {
                this._nodeCur = locale.getCur();
                while (process()) {
                }
                while (!this._nodeCur.isRoot()) {
                    this._nodeCur.toParent();
                }
                SchemaType schemaType = this._type;
                if (schemaType != null) {
                    this._nodeCur.setType(schemaType);
                }
                Node node = (Node) this._nodeCur.getDom();
                this._nodeCur.release();
                this._nodeCur = null;
                return node;
            } finally {
                locale.exit();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(Saver.SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            if (Locale.isFragmentQName(saveCur.getName())) {
                this._nodeCur.moveTo(null, -2);
            }
            ensureDoc();
            this._nodeCur.createElement(getQualifiedName(saveCur, saveCur.getName()));
            this._nodeCur.next();
            iterateMappings();
            while (hasMapping()) {
                Cur cur = this._nodeCur;
                cur.createAttr(cur._locale.createXmlns(mappingPrefix()));
                this._nodeCur.next();
                this._nodeCur.insertString(mappingUri());
                this._nodeCur.toParent();
                this._nodeCur.skipWithAttrs();
                nextMapping();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                this._nodeCur.createAttr(getQualifiedName(saveCur, (QName) arrayList.get(i)));
                this._nodeCur.next();
                this._nodeCur.insertString((String) arrayList2.get(i));
                this._nodeCur.toParent();
                this._nodeCur.skipWithAttrs();
            }
            return Cursor.$assertionsDisabled;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(Saver.SaveCur saveCur) {
            if (Locale.isFragmentQName(saveCur.getName())) {
                return;
            }
            this._nodeCur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(Saver.SaveCur saveCur) {
            ensureDoc();
            Object chars = saveCur.getChars();
            if (saveCur._cchSrc > 0) {
                this._nodeCur.insertChars(chars, saveCur._offSrc, saveCur._cchSrc);
                this._nodeCur.next();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(Saver.SaveCur saveCur) {
            ensureDoc();
            this._nodeCur.createComment();
            emitTextValue(saveCur);
            this._nodeCur.skip();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(Saver.SaveCur saveCur) {
            ensureDoc();
            this._nodeCur.createProcinst(saveCur.getName().getLocalPart());
            emitTextValue(saveCur);
            this._nodeCur.skip();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            ensureDoc();
            XmlDocumentProperties docProps = Locale.getDocProps(this._nodeCur, true);
            docProps.setDoctypeName(str);
            docProps.setDoctypePublicId(str2);
            docProps.setDoctypeSystemId(str3);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(Saver.SaveCur saveCur) {
            ensureDoc();
        }

        private QName getQualifiedName(Saver.SaveCur saveCur, QName qName) {
            String namespaceURI = qName.getNamespaceURI();
            String uriMapping = namespaceURI.length() > 0 ? getUriMapping(namespaceURI) : "";
            return uriMapping.equals(qName.getPrefix()) ? qName : this._nodeCur._locale.makeQName(namespaceURI, qName.getLocalPart(), uriMapping);
        }

        private void emitTextValue(Saver.SaveCur saveCur) {
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                this._nodeCur.next();
                this._nodeCur.insertChars(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
                this._nodeCur.toParent();
            }
            saveCur.pop();
        }

        private void ensureDoc() {
            if (this._nodeCur.isPositioned()) {
                return;
            }
            if (this._isFrag) {
                this._nodeCur.createDomDocFragRoot();
            } else {
                this._nodeCur.createDomDocumentRoot();
            }
            this._nodeCur.next();
        }
    }

    public Node _newDomNode(XmlOptions xmlOptions) {
        if (XmlOptions.hasOption(xmlOptions, "SAVE_INNER")) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.remove("SAVE_INNER");
            xmlOptions = xmlOptions2;
        }
        return new DomSaver(this._cur, isDomFragment(), xmlOptions).saveDom();
    }

    public boolean _toCursor(Cursor cursor) {
        this._cur.moveToCur(cursor._cur);
        return true;
    }

    public void _push() {
        this._cur.push();
    }

    public boolean _pop() {
        return this._cur.pop();
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void notifyChange() {
        if (this._cur != null) {
            _getSelectionCount();
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void setNextChangeListener(Locale.ChangeListener changeListener) {
        this._nextChangeListener = changeListener;
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public Locale.ChangeListener getNextChangeListener() {
        return this._nextChangeListener;
    }

    public void _selectPath(String str) {
        _selectPath(str, null);
    }

    public void _selectPath(String str, XmlOptions xmlOptions) {
        _clearSelections();
        this._pathEngine = Path.getCompiledPath(str, xmlOptions).execute(this._cur, xmlOptions);
        this._cur._locale.registerForChange(this);
    }

    public boolean _hasNextSelection() {
        int i = this._currentSelection;
        push();
        try {
            return _toNextSelection();
        } finally {
            this._currentSelection = i;
            pop();
        }
    }

    public boolean _toNextSelection() {
        return _toSelection(this._currentSelection + 1);
    }

    public boolean _toSelection(int i) {
        if (i < 0) {
            return $assertionsDisabled;
        }
        while (i >= this._cur.selectionCount()) {
            Path.PathEngine pathEngine = this._pathEngine;
            if (pathEngine == null) {
                return $assertionsDisabled;
            }
            if (!pathEngine.next(this._cur)) {
                this._pathEngine.release();
                this._pathEngine = null;
                return $assertionsDisabled;
            }
        }
        Cur cur = this._cur;
        this._currentSelection = i;
        cur.moveToSelection(i);
        return true;
    }

    public int _getSelectionCount() {
        _toSelection(Integer.MAX_VALUE);
        return this._cur.selectionCount();
    }

    public void _addToSelection() {
        _toSelection(Integer.MAX_VALUE);
        this._cur.addToSelection();
    }

    public void _clearSelections() {
        Path.PathEngine pathEngine = this._pathEngine;
        if (pathEngine != null) {
            pathEngine.release();
            this._pathEngine = null;
        }
        this._cur.clearSelection();
        this._currentSelection = -1;
    }

    public String _namespaceForPrefix(String str) {
        if (!this._cur.isContainer()) {
            throw new IllegalStateException("Not on a container");
        }
        return this._cur.namespaceForPrefix(str, true);
    }

    public String _prefixForNamespace(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must specify a namespace");
        }
        return this._cur.prefixForNamespace(str, null, true);
    }

    public void _getAllNamespaces(Map map) {
        if (!this._cur.isContainer()) {
            throw new IllegalStateException("Not on a container");
        }
        if (map != null) {
            Locale.getAllNamespaces(this._cur, map);
        }
    }

    public XmlObject _getObject() {
        return this._cur.getObject();
    }

    public XmlCursor.TokenType _prevTokenType() {
        this._cur.push();
        XmlCursor.TokenType tokenType_toPrevToken = _toPrevToken();
        this._cur.pop();
        return tokenType_toPrevToken;
    }

    public boolean _hasNextToken() {
        if (this._cur._pos == -1 && this._cur._xobj.kind() == 1) {
            return $assertionsDisabled;
        }
        return true;
    }

    public boolean _hasPrevToken() {
        if (this._cur.kind() != 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    public XmlCursor.TokenType _toFirstContentToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.next();
        return currentTokenType();
    }

    public XmlCursor.TokenType _toEndToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.toEnd();
        return currentTokenType();
    }

    public boolean _toChild(String str) {
        return _toChild((String) null, str);
    }

    public boolean _toChild(QName qName) {
        return _toChild(qName, 0);
    }

    public boolean _toChild(int i) {
        return _toChild((QName) null, i);
    }

    public boolean _toChild(String str, String str2) {
        validateLocalName(str2);
        return _toChild(this._cur._locale.makeQName(str, str2), 0);
    }

    public boolean _toChild(QName qName, int i) {
        return Locale.toChild(this._cur, qName, i);
    }

    public int _toNextChar(int i) {
        return this._cur.nextChars(i);
    }

    public int _toPrevChar(int i) {
        return this._cur.prevChars(i);
    }

    public boolean _toPrevSibling() {
        return Locale.toPrevSiblingElement(this._cur);
    }

    public boolean _toLastChild() {
        return Locale.toLastChildElement(this._cur);
    }

    public boolean _toFirstChild() {
        return Locale.toFirstChildElement(this._cur);
    }

    public boolean _toNextSibling(String str) {
        return _toNextSibling(new QName(str));
    }

    public boolean _toNextSibling(String str, String str2) {
        validateLocalName(str2);
        return _toNextSibling(this._cur._locale._qnameFactory.getQName(str, str2));
    }

    public boolean _toNextSibling(QName qName) {
        this._cur.push();
        while (___toNextSibling()) {
            if (this._cur.getName().equals(qName)) {
                this._cur.popButStay();
                return true;
            }
        }
        this._cur.pop();
        return $assertionsDisabled;
    }

    public boolean _toFirstAttribute() {
        if (this._cur.isContainer() && Locale.toFirstNormalAttr(this._cur)) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean _toLastAttribute() {
        if (this._cur.isContainer()) {
            this._cur.push();
            this._cur.push();
            boolean z = false;
            while (this._cur.toNextAttr()) {
                if (this._cur.isNormalAttr()) {
                    this._cur.popButStay();
                    this._cur.push();
                    z = true;
                }
            }
            this._cur.pop();
            if (z) {
                this._cur.popButStay();
                return true;
            }
            this._cur.pop();
        }
        return $assertionsDisabled;
    }

    public boolean _toNextAttribute() {
        if (this._cur.isAttr() && Locale.toNextNormalAttr(this._cur)) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean _toPrevAttribute() {
        if (this._cur.isAttr() && Locale.toPrevNormalAttr(this._cur)) {
            return true;
        }
        return $assertionsDisabled;
    }

    public String _getAttributeText(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.getAttrValue(qName);
        }
        return null;
    }

    public boolean _setAttributeText(QName qName, String str) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        validateLocalName(qName.getLocalPart());
        if (!this._cur.isContainer()) {
            return $assertionsDisabled;
        }
        this._cur.setAttrValue(qName, str);
        return true;
    }

    public boolean _removeAttribute(QName qName) {
        if (qName != null) {
            return !this._cur.isContainer() ? $assertionsDisabled : this._cur.removeAttr(qName);
        }
        throw new IllegalArgumentException("Attr name is null");
    }

    public String _getTextValue() {
        if (this._cur.isText()) {
            return _getChars();
        }
        if (this._cur.isNode()) {
            return this._cur.hasChildren() ? Locale.getTextValue(this._cur) : this._cur.getValueAsString();
        }
        throw new IllegalStateException("Can't get text value, current token can have no text value");
    }

    public int _getTextValue(char[] cArr, int i, int i2) {
        if (this._cur.isText()) {
            return _getChars(cArr, i, i2);
        }
        if (cArr == null) {
            throw new IllegalArgumentException("char buffer is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (i >= cArr.length) {
            throw new IllegalArgumentException("offset off end");
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        if (i + i2 > cArr.length) {
            i2 = cArr.length - i;
        }
        if (!this._cur.isNode()) {
            throw new IllegalStateException("Can't get text value, current token can have no text value");
        }
        if (this._cur.hasChildren()) {
            return Locale.getTextValue(this._cur, 1, cArr, i, i2);
        }
        Object firstChars = this._cur.getFirstChars();
        if (this._cur._cchSrc > i2) {
            this._cur._cchSrc = i2;
        }
        if (this._cur._cchSrc <= 0) {
            return 0;
        }
        CharUtil.getChars(cArr, i, firstChars, this._cur._offSrc, this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    private void setTextValue(Object obj, int i, int i2) {
        if (!this._cur.isNode()) {
            throw new IllegalStateException("Can't set text value, current token can have no text value");
        }
        this._cur.moveNodeContents(null, $assertionsDisabled);
        this._cur.next();
        this._cur.insertChars(obj, i, i2);
        this._cur.toParent();
    }

    public void _setTextValue(String str) {
        if (str == null) {
            str = "";
        }
        setTextValue(str, 0, str.length());
    }

    public void _setTextValue(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("setTextValue: length < 0");
        }
        if (cArr == null) {
            if (i2 > 0) {
                throw new IllegalArgumentException("setTextValue: sourceChars == null");
            }
            setTextValue((char[]) null, 0, 0);
        } else {
            if (i < 0 || i >= cArr.length) {
                throw new IndexOutOfBoundsException("setTextValue: offset out of bounds");
            }
            if (i + i2 > cArr.length) {
                i2 = cArr.length - i;
            }
            CharUtil charUtil = this._cur._locale.getCharUtil();
            setTextValue(charUtil.saveChars(cArr, i, i2), charUtil._offSrc, charUtil._cchSrc);
        }
    }

    public String _getChars() {
        return this._cur.getCharsAsString(-1);
    }

    public int _getChars(char[] cArr, int i, int i2) {
        int iCchRight = this._cur.cchRight();
        if (i2 < 0 || i2 > iCchRight) {
            i2 = iCchRight;
        }
        if (cArr == null || i >= cArr.length) {
            return 0;
        }
        if (cArr.length - i < i2) {
            i2 = cArr.length - i;
        }
        CharUtil.getChars(cArr, i, this._cur.getChars(i2), this._cur._offSrc, this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public void _toStartDoc() {
        this._cur.toRoot();
    }

    public void _toEndDoc() {
        _toStartDoc();
        this._cur.toEnd();
    }

    public int _comparePosition(Cursor cursor) {
        int iComparePosition = this._cur.comparePosition(cursor._cur);
        if (iComparePosition != 2) {
            return iComparePosition;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    public boolean _isLeftOf(Cursor cursor) {
        if (_comparePosition(cursor) < 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean _isAtSamePositionAs(Cursor cursor) {
        return this._cur.isSamePos(cursor._cur);
    }

    public boolean _isRightOf(Cursor cursor) {
        if (_comparePosition(cursor) > 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public XmlCursor _execQuery(String str) {
        return _execQuery(str, null);
    }

    public XmlCursor _execQuery(String str, XmlOptions xmlOptions) {
        checkThisCursor();
        return Query.cursorExecQuery(this._cur, str, xmlOptions);
    }

    public boolean _toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        if (xmlBookmark != null && (xmlBookmark._currentMark instanceof Xobj.Bookmark)) {
            Xobj.Bookmark bookmark = (Xobj.Bookmark) xmlBookmark._currentMark;
            if (bookmark._xobj != null && bookmark._xobj._locale == this._cur._locale) {
                this._cur.moveTo(bookmark._xobj, bookmark._pos);
                return true;
            }
        }
        return $assertionsDisabled;
    }

    public XmlCursor.XmlBookmark _toNextBookmark(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int iCchRight = this._cur.cchRight();
            if (iCchRight > 1) {
                this._cur.nextChars(1);
                Cur cur = this._cur;
                int iFirstBookmarkInChars = cur.firstBookmarkInChars(obj, iCchRight - 1);
                if (iFirstBookmarkInChars < 0) {
                    iFirstBookmarkInChars = -1;
                }
                cur.nextChars(iFirstBookmarkInChars);
            } else if (_toNextToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != -1);
        this._cur.pop();
        return null;
    }

    public XmlCursor.XmlBookmark _toPrevBookmark(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int iCchLeft = this._cur.cchLeft();
            if (iCchLeft > 1) {
                this._cur.prevChars(1);
                Cur cur = this._cur;
                int iFirstBookmarkInCharsLeft = cur.firstBookmarkInCharsLeft(obj, iCchLeft - 1);
                if (iFirstBookmarkInCharsLeft < 0) {
                    iFirstBookmarkInCharsLeft = -1;
                }
                cur.prevChars(iFirstBookmarkInCharsLeft);
            } else if (iCchLeft == 1) {
                this._cur.prevChars(1);
            } else if (_toPrevToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != 1);
        this._cur.pop();
        return null;
    }

    public void _setBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        if (xmlBookmark != null) {
            if (xmlBookmark.getKey() == null) {
                throw new IllegalArgumentException("Annotation key is null");
            }
            xmlBookmark._currentMark = this._cur.setBookmark(xmlBookmark.getKey(), xmlBookmark);
        }
    }

    static XmlCursor.XmlBookmark getBookmark(Object obj, Cur cur) {
        Object bookmark;
        if (obj == null || (bookmark = cur.getBookmark(obj)) == null || !(bookmark instanceof XmlCursor.XmlBookmark)) {
            return null;
        }
        return (XmlCursor.XmlBookmark) bookmark;
    }

    public XmlCursor.XmlBookmark _getBookmark(Object obj) {
        if (obj == null) {
            return null;
        }
        return getBookmark(obj, this._cur);
    }

    public void _clearBookmark(Object obj) {
        if (obj != null) {
            this._cur.setBookmark(obj, null);
        }
    }

    public void _getAllBookmarkRefs(Collection collection) {
        if (collection != null) {
            for (Xobj.Bookmark bookmark = this._cur._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (bookmark._value instanceof XmlCursor.XmlBookmark) {
                    collection.add(bookmark._value);
                }
            }
        }
    }

    public boolean _removeXml() {
        if (this._cur.isRoot()) {
            throw new IllegalStateException("Can't remove a whole document.");
        }
        if (this._cur.isFinish()) {
            return $assertionsDisabled;
        }
        if (this._cur.isText()) {
            this._cur.moveChars(null, -1);
            return true;
        }
        this._cur.moveNode(null);
        return true;
    }

    public boolean _moveXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        if (this._cur.isText()) {
            int iCchRight = this._cur.cchRight();
            if (this._cur.inChars(cursor._cur, iCchRight, true)) {
                return $assertionsDisabled;
            }
            this._cur.moveChars(cursor._cur, iCchRight);
            cursor._cur.nextChars(iCchRight);
            return true;
        }
        if (this._cur.contains(cursor._cur)) {
            return $assertionsDisabled;
        }
        Cur curTempCur = cursor.tempCur();
        this._cur.moveNode(cursor._cur);
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _copyXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        Cur curTempCur = cursor.tempCur();
        if (this._cur.isText()) {
            cursor._cur.insertChars(this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
        } else {
            this._cur.copyNode(cursor._cur);
        }
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _removeXmlContents() {
        if (!this._cur.isContainer()) {
            return $assertionsDisabled;
        }
        this._cur.moveNodeContents(null, $assertionsDisabled);
        return true;
    }

    private boolean checkContentInsertionValidity(Cursor cursor) {
        this._cur.push();
        this._cur.next();
        if (this._cur.isFinish()) {
            this._cur.pop();
            return $assertionsDisabled;
        }
        try {
            cursor.checkInsertionValidity(this._cur);
            this._cur.pop();
            return true;
        } catch (IllegalArgumentException e) {
            this._cur.pop();
            throw e;
        }
    }

    public boolean _moveXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return $assertionsDisabled;
        }
        Cur curTempCur = cursor.tempCur();
        this._cur.moveNodeContents(cursor._cur, $assertionsDisabled);
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _copyXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return $assertionsDisabled;
        }
        Cur curTempCur = this._cur._locale.tempCur();
        this._cur.copyNode(curTempCur);
        Cur curTempCur2 = cursor._cur.tempCur();
        curTempCur.moveNodeContents(cursor._cur, $assertionsDisabled);
        curTempCur.release();
        cursor._cur.moveToCur(curTempCur2);
        curTempCur2.release();
        return true;
    }

    public int _removeChars(int i) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight == 0 || i == 0) {
            return 0;
        }
        if (i < 0 || i > iCchRight) {
            i = iCchRight;
        }
        this._cur.moveChars(null, i);
        return this._cur._cchSrc;
    }

    public int _moveChars(int i, Cursor cursor) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight <= 0 || i == 0) {
            return 0;
        }
        if (i < 0 || i > iCchRight) {
            i = iCchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        this._cur.moveChars(cursor._cur, i);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public int _copyChars(int i, Cursor cursor) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight <= 0 || i == 0) {
            return 0;
        }
        if (i < 0 || i > iCchRight) {
            i = iCchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        cursor._cur.insertChars(this._cur.getChars(i), this._cur._offSrc, this._cur._cchSrc);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public void _insertChars(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            if (this._cur.isRoot() || this._cur.isAttr()) {
                throw new IllegalStateException("Can't insert before the document or an attribute.");
            }
            this._cur.insertChars(str, 0, length);
            this._cur.nextChars(length);
        }
    }

    public void _beginElement(String str) {
        _insertElementWithText(str, null, null);
        _toPrevToken();
    }

    public void _beginElement(String str, String str2) {
        _insertElementWithText(str, str2, null);
        _toPrevToken();
    }

    public void _beginElement(QName qName) {
        _insertElementWithText(qName, (String) null);
        _toPrevToken();
    }

    public void _insertElement(String str) {
        _insertElementWithText(str, null, null);
    }

    public void _insertElement(String str, String str2) {
        _insertElementWithText(str, str2, null);
    }

    public void _insertElement(QName qName) {
        _insertElementWithText(qName, (String) null);
    }

    public void _insertElementWithText(String str, String str2) {
        _insertElementWithText(str, null, str2);
    }

    public void _insertElementWithText(String str, String str2, String str3) {
        validateLocalName(str);
        _insertElementWithText(this._cur._locale.makeQName(str2, str), str3);
    }

    public void _insertElementWithText(QName qName, String str) {
        validateLocalName(qName.getLocalPart());
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createElement(qName);
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    public void _insertAttribute(String str) {
        _insertAttributeWithValue(str, (String) null);
    }

    public void _insertAttribute(String str, String str2) {
        _insertAttributeWithValue(str, str2, null);
    }

    public void _insertAttribute(QName qName) {
        _insertAttributeWithValue(qName, (String) null);
    }

    public void _insertAttributeWithValue(String str, String str2) {
        _insertAttributeWithValue(str, null, str2);
    }

    public void _insertAttributeWithValue(String str, String str2, String str3) {
        validateLocalName(str);
        _insertAttributeWithValue(this._cur._locale.makeQName(str2, str), str3);
    }

    public void _insertAttributeWithValue(QName qName, String str) {
        validateLocalName(qName.getLocalPart());
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createAttr(qName);
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    public void _insertNamespace(String str, String str2) {
        _insertAttributeWithValue(this._cur._locale.createXmlns(str), str2);
    }

    public void _insertComment(String str) {
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createComment();
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    public void _insertProcInst(String str, String str2) {
        validateLocalName(str);
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new IllegalArgumentException("Target is 'xml'");
        }
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createProcinst(str);
        insertNode(curTempCur, str2);
        curTempCur.release();
    }

    public void _dump() {
        this._cur.dump();
    }

    private void checkThisCursor() {
        if (this._cur == null) {
            throw new IllegalStateException("This cursor has been disposed");
        }
    }

    private Cursor checkCursors(XmlCursor xmlCursor) {
        checkThisCursor();
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Other cursor is <null>");
        }
        if (!(xmlCursor instanceof Cursor)) {
            throw new IllegalArgumentException("Incompatible cursors: " + xmlCursor);
        }
        Cursor cursor = (Cursor) xmlCursor;
        if (cursor._cur != null) {
            return cursor;
        }
        throw new IllegalStateException("Other cursor has been disposed");
    }

    private int twoLocaleOp(XmlCursor xmlCursor, int i, int i2) throws Throwable {
        int iTwoLocaleOp;
        int iTwoLocaleOp2;
        int iTwoLocaleOp3;
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        Locale locale = this._cur._locale;
        Locale locale2 = cursorCheckCursors._cur._locale;
        if (locale == locale2) {
            if (locale.noSync()) {
                return twoLocaleOp(cursorCheckCursors, i, i2);
            }
            synchronized (locale) {
                iTwoLocaleOp3 = twoLocaleOp(cursorCheckCursors, i, i2);
            }
            return iTwoLocaleOp3;
        }
        if (locale.noSync()) {
            if (locale2.noSync()) {
                return twoLocaleOp(cursorCheckCursors, i, i2);
            }
            synchronized (locale2) {
                iTwoLocaleOp2 = twoLocaleOp(cursorCheckCursors, i, i2);
            }
            return iTwoLocaleOp2;
        }
        if (locale2.noSync()) {
            synchronized (locale) {
                iTwoLocaleOp = twoLocaleOp(cursorCheckCursors, i, i2);
            }
            return iTwoLocaleOp;
        }
        boolean z = $assertionsDisabled;
        try {
            try {
                GlobalLock.acquire();
                try {
                    try {
                        synchronized (locale) {
                            try {
                                try {
                                    synchronized (locale2) {
                                        try {
                                            GlobalLock.release();
                                            return twoLocaleOp(cursorCheckCursors, i, i2);
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    throw new RuntimeException(e.getMessage(), e);
                } catch (Throwable th5) {
                    th = th5;
                    z = true;
                    if (z) {
                        GlobalLock.release();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (InterruptedException e2) {
            e = e2;
        }
    }

    private int twoLocaleOp(Cursor cursor, int i, int i2) {
        Locale locale = this._cur._locale;
        Locale locale2 = cursor._cur._locale;
        locale.enter(locale2);
        try {
            if (i == 0) {
                boolean z_moveXml = _moveXml(cursor);
                locale.exit(locale2);
                return z_moveXml ? 1 : 0;
            }
            if (i == 1) {
                boolean z_copyXml = _copyXml(cursor);
                locale.exit(locale2);
                return z_copyXml ? 1 : 0;
            }
            if (i == 2) {
                boolean z_moveXmlContents = _moveXmlContents(cursor);
                locale.exit(locale2);
                return z_moveXmlContents ? 1 : 0;
            }
            if (i == 3) {
                boolean z_copyXmlContents = _copyXmlContents(cursor);
                locale.exit(locale2);
                return z_copyXmlContents ? 1 : 0;
            }
            if (i == 4) {
                int i_moveChars = _moveChars(i2, cursor);
                locale.exit(locale2);
                return i_moveChars;
            }
            if (i != 5) {
                throw new RuntimeException("Unknown operation: " + i);
            }
            int i_copyChars = _copyChars(i2, cursor);
            locale.exit(locale2);
            return i_copyChars;
        } catch (Throwable th) {
            locale.exit(locale2);
            throw th;
        }
    }

    public boolean moveXml(XmlCursor xmlCursor) {
        if (twoLocaleOp(xmlCursor, 0, 0) == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean copyXml(XmlCursor xmlCursor) {
        if (twoLocaleOp(xmlCursor, 1, 0) == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean moveXmlContents(XmlCursor xmlCursor) {
        if (twoLocaleOp(xmlCursor, 2, 0) == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean copyXmlContents(XmlCursor xmlCursor) {
        if (twoLocaleOp(xmlCursor, 3, 0) == 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    public int moveChars(int i, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 4, i);
    }

    public int copyChars(int i, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 5, i);
    }

    public boolean toCursor(XmlCursor xmlCursor) {
        boolean z_toCursor;
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        if (this._cur._locale != cursorCheckCursors._cur._locale) {
            return $assertionsDisabled;
        }
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _toCursor(cursorCheckCursors);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toCursor = _toCursor(cursorCheckCursors);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toCursor;
    }

    public boolean isInSameDocument(XmlCursor xmlCursor) {
        return xmlCursor == null ? $assertionsDisabled : this._cur.isInSameTree(checkCursors(xmlCursor)._cur);
    }

    private Cursor preCheck(XmlCursor xmlCursor) {
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        if (this._cur._locale == cursorCheckCursors._cur._locale) {
            return cursorCheckCursors;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    public int comparePosition(XmlCursor xmlCursor) {
        int i_comparePosition;
        Cursor cursorPreCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _comparePosition(cursorPreCheck);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_comparePosition = _comparePosition(cursorPreCheck);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_comparePosition;
    }

    public boolean isLeftOf(XmlCursor xmlCursor) {
        boolean z_isLeftOf;
        Cursor cursorPreCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _isLeftOf(cursorPreCheck);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_isLeftOf = _isLeftOf(cursorPreCheck);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_isLeftOf;
    }

    public boolean isAtSamePositionAs(XmlCursor xmlCursor) {
        boolean z_isAtSamePositionAs;
        Cursor cursorPreCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _isAtSamePositionAs(cursorPreCheck);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_isAtSamePositionAs = _isAtSamePositionAs(cursorPreCheck);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_isAtSamePositionAs;
    }

    public boolean isRightOf(XmlCursor xmlCursor) {
        boolean z_isRightOf;
        Cursor cursorPreCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _isRightOf(cursorPreCheck);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_isRightOf = _isRightOf(cursorPreCheck);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_isRightOf;
    }

    public static XmlCursor newCursor(Xobj xobj, int i) {
        Cursor cursor;
        Locale locale = xobj._locale;
        if (locale.noSync()) {
            locale.enter();
            try {
                return new Cursor(xobj, i);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                cursor = new Cursor(xobj, i);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return cursor;
    }

    private boolean preCheck() {
        checkThisCursor();
        return this._cur._locale.noSync();
    }

    public void dispose() {
        Cur cur = this._cur;
        if (cur != null) {
            Locale locale = cur._locale;
            if (preCheck()) {
                locale.enter();
                try {
                    _dispose();
                    return;
                } finally {
                    locale.exit();
                }
            }
            synchronized (locale) {
                locale.enter();
                try {
                    _dispose();
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
    }

    public Object monitor() {
        Object obj_monitor;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _monitor();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                obj_monitor = _monitor();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return obj_monitor;
    }

    public XmlDocumentProperties documentProperties() {
        XmlDocumentProperties xmlDocumentProperties_documentProperties;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _documentProperties();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlDocumentProperties_documentProperties = _documentProperties();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlDocumentProperties_documentProperties;
    }

    public XmlCursor newCursor() {
        XmlCursor xmlCursor_newCursor;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newCursor();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlCursor_newCursor = _newCursor();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlCursor_newCursor;
    }

    public XMLStreamReader newXMLStreamReader() {
        XMLStreamReader xMLStreamReader_newXMLStreamReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLStreamReader();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xMLStreamReader_newXMLStreamReader = _newXMLStreamReader();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xMLStreamReader_newXMLStreamReader;
    }

    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        XMLStreamReader xMLStreamReader_newXMLStreamReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLStreamReader(xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xMLStreamReader_newXMLStreamReader = _newXMLStreamReader(xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xMLStreamReader_newXMLStreamReader;
    }

    public XMLInputStream newXMLInputStream() {
        XMLInputStream xMLInputStream_newXMLInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLInputStream();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xMLInputStream_newXMLInputStream = _newXMLInputStream();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xMLInputStream_newXMLInputStream;
    }

    public String xmlText() {
        String str_xmlText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _xmlText();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_xmlText = _xmlText();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_xmlText;
    }

    public InputStream newInputStream() {
        InputStream inputStream_newInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newInputStream();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                inputStream_newInputStream = _newInputStream();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return inputStream_newInputStream;
    }

    public Reader newReader() {
        Reader reader_newReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newReader();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                reader_newReader = _newReader();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return reader_newReader;
    }

    public Node newDomNode() {
        Node node_newDomNode;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newDomNode();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                node_newDomNode = _newDomNode();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return node_newDomNode;
    }

    public Node getDomNode() {
        Node node_getDomNode;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getDomNode();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                node_getDomNode = _getDomNode();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return node_getDomNode;
    }

    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(contentHandler, lexicalHandler);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(contentHandler, lexicalHandler);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void save(File file) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(file);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(file);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void save(OutputStream outputStream) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(outputStream);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(outputStream);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void save(Writer writer) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(writer);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(writer);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public XMLInputStream newXMLInputStream(XmlOptions xmlOptions) {
        XMLInputStream xMLInputStream_newXMLInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLInputStream(xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xMLInputStream_newXMLInputStream = _newXMLInputStream(xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xMLInputStream_newXMLInputStream;
    }

    public String xmlText(XmlOptions xmlOptions) {
        String str_xmlText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _xmlText(xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_xmlText = _xmlText(xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_xmlText;
    }

    public InputStream newInputStream(XmlOptions xmlOptions) {
        InputStream inputStream_newInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newInputStream(xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                inputStream_newInputStream = _newInputStream(xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return inputStream_newInputStream;
    }

    public Reader newReader(XmlOptions xmlOptions) {
        Reader reader_newReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newReader(xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                reader_newReader = _newReader(xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return reader_newReader;
    }

    public Node newDomNode(XmlOptions xmlOptions) {
        Node node_newDomNode;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newDomNode(xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                node_newDomNode = _newDomNode(xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return node_newDomNode;
    }

    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(contentHandler, lexicalHandler, xmlOptions);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(contentHandler, lexicalHandler, xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void save(File file, XmlOptions xmlOptions) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(file, xmlOptions);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(file, xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(outputStream, xmlOptions);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(outputStream, xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void save(Writer writer, XmlOptions xmlOptions) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(writer, xmlOptions);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _save(writer, xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void push() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _push();
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _push();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public boolean pop() {
        boolean z_pop;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _pop();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_pop = _pop();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_pop;
    }

    public void selectPath(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _selectPath(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _selectPath(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void selectPath(String str, XmlOptions xmlOptions) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _selectPath(str, xmlOptions);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _selectPath(str, xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public boolean hasNextSelection() {
        boolean z_hasNextSelection;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _hasNextSelection();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_hasNextSelection = _hasNextSelection();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_hasNextSelection;
    }

    public boolean toNextSelection() {
        boolean z_toNextSelection;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSelection();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toNextSelection = _toNextSelection();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toNextSelection;
    }

    public boolean toSelection(int i) {
        boolean z_toSelection;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toSelection(i);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toSelection = _toSelection(i);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toSelection;
    }

    public int getSelectionCount() {
        int i_getSelectionCount;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getSelectionCount();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_getSelectionCount = _getSelectionCount();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_getSelectionCount;
    }

    public void addToSelection() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _addToSelection();
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _addToSelection();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void clearSelections() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _clearSelections();
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _clearSelections();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public boolean toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        boolean z_toBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toBookmark(xmlBookmark);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toBookmark = _toBookmark(xmlBookmark);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toBookmark;
    }

    public XmlCursor.XmlBookmark toNextBookmark(Object obj) {
        XmlCursor.XmlBookmark xmlBookmark_toNextBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextBookmark(obj);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlBookmark_toNextBookmark = _toNextBookmark(obj);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlBookmark_toNextBookmark;
    }

    public XmlCursor.XmlBookmark toPrevBookmark(Object obj) {
        XmlCursor.XmlBookmark xmlBookmark_toPrevBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevBookmark(obj);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlBookmark_toPrevBookmark = _toPrevBookmark(obj);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlBookmark_toPrevBookmark;
    }

    public QName getName() {
        QName qName_getName;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getName();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                qName_getName = _getName();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return qName_getName;
    }

    public void setName(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setName(qName);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _setName(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public String namespaceForPrefix(String str) {
        String str_namespaceForPrefix;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _namespaceForPrefix(str);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_namespaceForPrefix = _namespaceForPrefix(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_namespaceForPrefix;
    }

    public String prefixForNamespace(String str) {
        String str_prefixForNamespace;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _prefixForNamespace(str);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_prefixForNamespace = _prefixForNamespace(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_prefixForNamespace;
    }

    public void getAllNamespaces(Map map) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _getAllNamespaces(map);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getAllNamespaces(map);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public XmlObject getObject() {
        XmlObject xmlObject_getObject;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getObject();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlObject_getObject = _getObject();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlObject_getObject;
    }

    public XmlCursor.TokenType currentTokenType() {
        XmlCursor.TokenType tokenType_currentTokenType;
        if (preCheck()) {
            return _currentTokenType();
        }
        synchronized (this._cur._locale) {
            tokenType_currentTokenType = _currentTokenType();
        }
        return tokenType_currentTokenType;
    }

    public boolean isStartdoc() {
        boolean z_isStartdoc;
        if (preCheck()) {
            return _isStartdoc();
        }
        synchronized (this._cur._locale) {
            z_isStartdoc = _isStartdoc();
        }
        return z_isStartdoc;
    }

    public boolean isEnddoc() {
        boolean z_isEnddoc;
        if (preCheck()) {
            return _isEnddoc();
        }
        synchronized (this._cur._locale) {
            z_isEnddoc = _isEnddoc();
        }
        return z_isEnddoc;
    }

    public boolean isStart() {
        boolean z_isStart;
        if (preCheck()) {
            return _isStart();
        }
        synchronized (this._cur._locale) {
            z_isStart = _isStart();
        }
        return z_isStart;
    }

    public boolean isEnd() {
        boolean z_isEnd;
        if (preCheck()) {
            return _isEnd();
        }
        synchronized (this._cur._locale) {
            z_isEnd = _isEnd();
        }
        return z_isEnd;
    }

    public boolean isText() {
        boolean z_isText;
        if (preCheck()) {
            return _isText();
        }
        synchronized (this._cur._locale) {
            z_isText = _isText();
        }
        return z_isText;
    }

    public boolean isAttr() {
        boolean z_isAttr;
        if (preCheck()) {
            return _isAttr();
        }
        synchronized (this._cur._locale) {
            z_isAttr = _isAttr();
        }
        return z_isAttr;
    }

    public boolean isNamespace() {
        boolean z_isNamespace;
        if (preCheck()) {
            return _isNamespace();
        }
        synchronized (this._cur._locale) {
            z_isNamespace = _isNamespace();
        }
        return z_isNamespace;
    }

    public boolean isComment() {
        boolean z_isComment;
        if (preCheck()) {
            return _isComment();
        }
        synchronized (this._cur._locale) {
            z_isComment = _isComment();
        }
        return z_isComment;
    }

    public boolean isProcinst() {
        boolean z_isProcinst;
        if (preCheck()) {
            return _isProcinst();
        }
        synchronized (this._cur._locale) {
            z_isProcinst = _isProcinst();
        }
        return z_isProcinst;
    }

    public boolean isContainer() {
        boolean z_isContainer;
        if (preCheck()) {
            return _isContainer();
        }
        synchronized (this._cur._locale) {
            z_isContainer = _isContainer();
        }
        return z_isContainer;
    }

    public boolean isFinish() {
        boolean z_isFinish;
        if (preCheck()) {
            return _isFinish();
        }
        synchronized (this._cur._locale) {
            z_isFinish = _isFinish();
        }
        return z_isFinish;
    }

    public boolean isAnyAttr() {
        boolean z_isAnyAttr;
        if (preCheck()) {
            return _isAnyAttr();
        }
        synchronized (this._cur._locale) {
            z_isAnyAttr = _isAnyAttr();
        }
        return z_isAnyAttr;
    }

    public XmlCursor.TokenType prevTokenType() {
        XmlCursor.TokenType tokenType_prevTokenType;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _prevTokenType();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                tokenType_prevTokenType = _prevTokenType();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return tokenType_prevTokenType;
    }

    public boolean hasNextToken() {
        boolean z_hasNextToken;
        if (preCheck()) {
            return _hasNextToken();
        }
        synchronized (this._cur._locale) {
            z_hasNextToken = _hasNextToken();
        }
        return z_hasNextToken;
    }

    public boolean hasPrevToken() {
        boolean z_hasPrevToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _hasPrevToken();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_hasPrevToken = _hasPrevToken();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_hasPrevToken;
    }

    public XmlCursor.TokenType toNextToken() {
        XmlCursor.TokenType tokenType_toNextToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextToken();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                tokenType_toNextToken = _toNextToken();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return tokenType_toNextToken;
    }

    public XmlCursor.TokenType toPrevToken() {
        XmlCursor.TokenType tokenType_toPrevToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevToken();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                tokenType_toPrevToken = _toPrevToken();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return tokenType_toPrevToken;
    }

    public XmlCursor.TokenType toFirstContentToken() {
        XmlCursor.TokenType tokenType_toFirstContentToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toFirstContentToken();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                tokenType_toFirstContentToken = _toFirstContentToken();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return tokenType_toFirstContentToken;
    }

    public XmlCursor.TokenType toEndToken() {
        XmlCursor.TokenType tokenType_toEndToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toEndToken();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                tokenType_toEndToken = _toEndToken();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return tokenType_toEndToken;
    }

    public int toNextChar(int i) {
        int i_toNextChar;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextChar(i);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_toNextChar = _toNextChar(i);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_toNextChar;
    }

    public int toPrevChar(int i) {
        int i_toPrevChar;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevChar(i);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_toPrevChar = _toPrevChar(i);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_toPrevChar;
    }

    public boolean ___toNextSibling() {
        if (!this._cur.hasParent()) {
            return $assertionsDisabled;
        }
        Xobj parentNoRoot = this._cur.getParentNoRoot();
        if (parentNoRoot == null) {
            this._cur._locale.enter();
            try {
                parentNoRoot = this._cur.getParent();
            } finally {
                this._cur._locale.exit();
            }
        }
        return Locale.toNextSiblingElement(this._cur, parentNoRoot);
    }

    public boolean toNextSibling() {
        boolean z___toNextSibling;
        if (preCheck()) {
            return ___toNextSibling();
        }
        synchronized (this._cur._locale) {
            z___toNextSibling = ___toNextSibling();
        }
        return z___toNextSibling;
    }

    public boolean toPrevSibling() {
        boolean z_toPrevSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevSibling();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toPrevSibling = _toPrevSibling();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toPrevSibling;
    }

    public boolean toParent() {
        boolean z_toParent;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toParent();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toParent = _toParent();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toParent;
    }

    public boolean toFirstChild() {
        boolean z_toFirstChild;
        if (preCheck()) {
            return _toFirstChild();
        }
        synchronized (this._cur._locale) {
            z_toFirstChild = _toFirstChild();
        }
        return z_toFirstChild;
    }

    public boolean toLastChild() {
        boolean z_toLastChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toLastChild();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toLastChild = _toLastChild();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toLastChild;
    }

    public boolean toChild(String str) {
        boolean z_toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(str);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toChild = _toChild(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toChild;
    }

    public boolean toChild(String str, String str2) {
        boolean z_toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(str, str2);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toChild = _toChild(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toChild;
    }

    public boolean toChild(QName qName) {
        boolean z_toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(qName);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toChild = _toChild(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toChild;
    }

    public boolean toChild(int i) {
        boolean z_toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(i);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toChild = _toChild(i);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toChild;
    }

    public boolean toChild(QName qName, int i) {
        boolean z_toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(qName, i);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toChild = _toChild(qName, i);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toChild;
    }

    public boolean toNextSibling(String str) {
        boolean z_toNextSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSibling(str);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toNextSibling = _toNextSibling(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toNextSibling;
    }

    public boolean toNextSibling(String str, String str2) {
        boolean z_toNextSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSibling(str, str2);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toNextSibling = _toNextSibling(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toNextSibling;
    }

    public boolean toNextSibling(QName qName) {
        boolean z_toNextSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSibling(qName);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toNextSibling = _toNextSibling(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toNextSibling;
    }

    public boolean toFirstAttribute() {
        boolean z_toFirstAttribute;
        if (preCheck()) {
            return _toFirstAttribute();
        }
        synchronized (this._cur._locale) {
            z_toFirstAttribute = _toFirstAttribute();
        }
        return z_toFirstAttribute;
    }

    public boolean toLastAttribute() {
        boolean z_toLastAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toLastAttribute();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toLastAttribute = _toLastAttribute();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toLastAttribute;
    }

    public boolean toNextAttribute() {
        boolean z_toNextAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextAttribute();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toNextAttribute = _toNextAttribute();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toNextAttribute;
    }

    public boolean toPrevAttribute() {
        boolean z_toPrevAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevAttribute();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_toPrevAttribute = _toPrevAttribute();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_toPrevAttribute;
    }

    public String getAttributeText(QName qName) {
        String str_getAttributeText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getAttributeText(qName);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_getAttributeText = _getAttributeText(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_getAttributeText;
    }

    public boolean setAttributeText(QName qName, String str) {
        boolean z_setAttributeText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _setAttributeText(qName, str);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_setAttributeText = _setAttributeText(qName, str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_setAttributeText;
    }

    public boolean removeAttribute(QName qName) {
        boolean z_removeAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeAttribute(qName);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_removeAttribute = _removeAttribute(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_removeAttribute;
    }

    public String getTextValue() {
        String str_getTextValue;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getTextValue();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_getTextValue = _getTextValue();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_getTextValue;
    }

    public int getTextValue(char[] cArr, int i, int i2) {
        int i_getTextValue;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getTextValue(cArr, i, i2);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_getTextValue = _getTextValue(cArr, i, i2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_getTextValue;
    }

    public void setTextValue(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setTextValue(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _setTextValue(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void setTextValue(char[] cArr, int i, int i2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setTextValue(cArr, i, i2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _setTextValue(cArr, i, i2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public String getChars() {
        String str_getChars;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getChars();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                str_getChars = _getChars();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return str_getChars;
    }

    public int getChars(char[] cArr, int i, int i2) {
        int i_getChars;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getChars(cArr, i, i2);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_getChars = _getChars(cArr, i, i2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_getChars;
    }

    public void toStartDoc() {
        if (preCheck()) {
            _toStartDoc();
            return;
        }
        synchronized (this._cur._locale) {
            _toStartDoc();
        }
    }

    public void toEndDoc() {
        if (preCheck()) {
            _toEndDoc();
            return;
        }
        synchronized (this._cur._locale) {
            _toEndDoc();
        }
    }

    public XmlCursor execQuery(String str) {
        XmlCursor xmlCursor_execQuery;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _execQuery(str);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlCursor_execQuery = _execQuery(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlCursor_execQuery;
    }

    public XmlCursor execQuery(String str, XmlOptions xmlOptions) {
        XmlCursor xmlCursor_execQuery;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _execQuery(str, xmlOptions);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlCursor_execQuery = _execQuery(str, xmlOptions);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlCursor_execQuery;
    }

    public XmlCursor.ChangeStamp getDocChangeStamp() {
        XmlCursor.ChangeStamp changeStamp_getDocChangeStamp;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getDocChangeStamp();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                changeStamp_getDocChangeStamp = _getDocChangeStamp();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return changeStamp_getDocChangeStamp;
    }

    public void setBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setBookmark(xmlBookmark);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _setBookmark(xmlBookmark);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public XmlCursor.XmlBookmark getBookmark(Object obj) {
        XmlCursor.XmlBookmark xmlBookmark_getBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getBookmark(obj);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                xmlBookmark_getBookmark = _getBookmark(obj);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return xmlBookmark_getBookmark;
    }

    public void clearBookmark(Object obj) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _clearBookmark(obj);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _clearBookmark(obj);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void getAllBookmarkRefs(Collection collection) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _getAllBookmarkRefs(collection);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getAllBookmarkRefs(collection);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public boolean removeXml() {
        boolean z_removeXml;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeXml();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_removeXml = _removeXml();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_removeXml;
    }

    public boolean removeXmlContents() {
        boolean z_removeXmlContents;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeXmlContents();
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                z_removeXmlContents = _removeXmlContents();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return z_removeXmlContents;
    }

    public int removeChars(int i) {
        int i_removeChars;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeChars(i);
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                i_removeChars = _removeChars(i);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
        return i_removeChars;
    }

    public void insertChars(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertChars(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertChars(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertElement(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElement(qName);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertElement(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertElement(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElement(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertElement(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertElement(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElement(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertElement(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void beginElement(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _beginElement(qName);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _beginElement(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void beginElement(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _beginElement(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _beginElement(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void beginElement(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _beginElement(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _beginElement(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertElementWithText(QName qName, String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(qName, str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(qName, str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertElementWithText(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertElementWithText(String str, String str2, String str3) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(str, str2, str3);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(str, str2, str3);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertAttribute(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttribute(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertAttribute(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertAttribute(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttribute(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertAttribute(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertAttribute(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttribute(qName);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertAttribute(qName);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertAttributeWithValue(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertAttributeWithValue(String str, String str2, String str3) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(str, str2, str3);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(str, str2, str3);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertAttributeWithValue(QName qName, String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(qName, str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(qName, str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertNamespace(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertNamespace(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertNamespace(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertComment(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertComment(str);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertComment(str);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void insertProcInst(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertProcInst(str, str2);
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _insertProcInst(str, str2);
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }

    public void dump() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _dump();
                return;
            } finally {
                this._cur._locale.exit();
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _dump();
                this._cur._locale.exit();
            } catch (Throwable th) {
                this._cur._locale.exit();
                throw th;
            }
        }
    }
}

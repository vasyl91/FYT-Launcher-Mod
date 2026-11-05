package com.fasterxml.aalto.async;

import com.fasterxml.aalto.AsyncInputFeeder;
import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.in.ByteBasedPName;
import com.fasterxml.aalto.in.ByteBasedPNameTable;
import com.fasterxml.aalto.in.ByteBasedScanner;
import com.fasterxml.aalto.in.PName;
import com.fasterxml.aalto.in.ReaderConfig;
import com.fasterxml.aalto.util.CharsetNames;
import com.fasterxml.aalto.util.DataUtil;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlConsts;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class AsyncByteScanner extends ByteBasedScanner implements AsyncInputFeeder {
    protected static final int EVENT_INCOMPLETE = 257;
    protected static final int PENDING_STATE_ATTR_VALUE_AMP = -60;
    protected static final int PENDING_STATE_ATTR_VALUE_AMP_HASH = -61;
    protected static final int PENDING_STATE_ATTR_VALUE_AMP_HASH_X = -62;
    protected static final int PENDING_STATE_ATTR_VALUE_DEC_DIGIT = -64;
    protected static final int PENDING_STATE_ATTR_VALUE_ENTITY_NAME = -63;
    protected static final int PENDING_STATE_ATTR_VALUE_HEX_DIGIT = -65;
    protected static final int PENDING_STATE_CDATA_BRACKET1 = -30;
    protected static final int PENDING_STATE_CDATA_BRACKET2 = -31;
    protected static final int PENDING_STATE_COMMENT_HYPHEN1 = -20;
    protected static final int PENDING_STATE_COMMENT_HYPHEN2 = -21;
    protected static final int PENDING_STATE_CR = -1;
    protected static final int PENDING_STATE_ENT_IN_DEC_DIGIT = -72;
    protected static final int PENDING_STATE_ENT_IN_HEX_DIGIT = -73;
    protected static final int PENDING_STATE_ENT_SEEN_HASH = -70;
    protected static final int PENDING_STATE_ENT_SEEN_HASH_X = -71;
    protected static final int PENDING_STATE_PI_QMARK = -15;
    protected static final int PENDING_STATE_TEXT_AMP = -80;
    protected static final int PENDING_STATE_TEXT_AMP_HASH = -81;
    protected static final int PENDING_STATE_TEXT_BRACKET1 = -85;
    protected static final int PENDING_STATE_TEXT_BRACKET2 = -86;
    protected static final int PENDING_STATE_TEXT_DEC_ENTITY = -82;
    protected static final int PENDING_STATE_TEXT_HEX_ENTITY = -83;
    protected static final int PENDING_STATE_TEXT_IN_ENTITY = -84;
    protected static final int PENDING_STATE_XMLDECL_LT = -5;
    protected static final int PENDING_STATE_XMLDECL_LTQ = -6;
    protected static final int PENDING_STATE_XMLDECL_TARGET = -7;
    protected static final int STATE_CDATA_C = 2;
    protected static final int STATE_CDATA_CD = 3;
    protected static final int STATE_CDATA_CDA = 4;
    protected static final int STATE_CDATA_CDAT = 5;
    protected static final int STATE_CDATA_CDATA = 6;
    protected static final int STATE_CDATA_CONTENT = 1;
    protected static final int STATE_COMMENT_CONTENT = 1;
    protected static final int STATE_COMMENT_HYPHEN = 2;
    protected static final int STATE_COMMENT_HYPHEN2 = 3;
    protected static final int STATE_DEFAULT = 0;
    protected static final int STATE_DTD_AFTER_DOCTYPE = 2;
    protected static final int STATE_DTD_AFTER_PUBLIC = 8;
    protected static final int STATE_DTD_AFTER_PUBLIC_ID = 12;
    protected static final int STATE_DTD_AFTER_ROOT_NAME = 5;
    protected static final int STATE_DTD_AFTER_SYSTEM = 9;
    protected static final int STATE_DTD_AFTER_SYSTEM_ID = 15;
    protected static final int STATE_DTD_BEFORE_IDS = 6;
    protected static final int STATE_DTD_BEFORE_PUBLIC_ID = 10;
    protected static final int STATE_DTD_BEFORE_ROOT_NAME = 3;
    protected static final int STATE_DTD_BEFORE_SYSTEM_ID = 13;
    protected static final int STATE_DTD_DOCTYPE = 1;
    protected static final int STATE_DTD_EXPECT_CLOSING_GT = 50;
    protected static final int STATE_DTD_INT_SUBSET = 16;
    protected static final int STATE_DTD_PUBLIC_ID = 11;
    protected static final int STATE_DTD_PUBLIC_OR_SYSTEM = 7;
    protected static final int STATE_DTD_ROOT_NAME = 4;
    protected static final int STATE_DTD_SYSTEM_ID = 14;
    protected static final int STATE_EE_NEED_GT = 1;
    protected static final int STATE_PI_AFTER_TARGET = 1;
    protected static final int STATE_PI_AFTER_TARGET_QMARK = 3;
    protected static final int STATE_PI_AFTER_TARGET_WS = 2;
    protected static final int STATE_PI_IN_DATA = 5;
    protected static final int STATE_PI_IN_TARGET = 4;
    protected static final int STATE_PROLOG_DECL = 3;
    protected static final int STATE_PROLOG_INITIAL = 1;
    protected static final int STATE_PROLOG_SEEN_LT = 2;
    protected static final int STATE_SE_ATTR_NAME = 4;
    protected static final int STATE_SE_ATTR_VALUE_NORMAL = 7;
    protected static final int STATE_SE_ATTR_VALUE_NSDECL = 8;
    protected static final int STATE_SE_ELEM_NAME = 1;
    protected static final int STATE_SE_SEEN_SLASH = 9;
    protected static final int STATE_SE_SPACE_OR_ATTRNAME = 3;
    protected static final int STATE_SE_SPACE_OR_ATTRVALUE = 6;
    protected static final int STATE_SE_SPACE_OR_END = 2;
    protected static final int STATE_SE_SPACE_OR_EQ = 5;
    protected static final int STATE_TEXT_AMP = 4;
    protected static final int STATE_TEXT_AMP_NAME = 6;
    protected static final int STATE_TREE_NAMED_ENTITY_START = 6;
    protected static final int STATE_TREE_NUMERIC_ENTITY_START = 5;
    protected static final int STATE_TREE_SEEN_AMP = 2;
    protected static final int STATE_TREE_SEEN_EXCL = 3;
    protected static final int STATE_TREE_SEEN_LT = 1;
    protected static final int STATE_TREE_SEEN_SLASH = 4;
    protected static final int STATE_XMLDECL_AFTER_ENCODING = 10;
    protected static final int STATE_XMLDECL_AFTER_ENCODING_VALUE = 13;
    protected static final int STATE_XMLDECL_AFTER_STANDALONE = 16;
    protected static final int STATE_XMLDECL_AFTER_STANDALONE_VALUE = 19;
    protected static final int STATE_XMLDECL_AFTER_VERSION = 4;
    protected static final int STATE_XMLDECL_AFTER_VERSION_VALUE = 7;
    protected static final int STATE_XMLDECL_AFTER_XML = 1;
    protected static final int STATE_XMLDECL_BEFORE_ENCODING = 8;
    protected static final int STATE_XMLDECL_BEFORE_STANDALONE = 14;
    protected static final int STATE_XMLDECL_BEFORE_VERSION = 2;
    protected static final int STATE_XMLDECL_ENCODING = 9;
    protected static final int STATE_XMLDECL_ENCODING_EQ = 11;
    protected static final int STATE_XMLDECL_ENCODING_VALUE = 12;
    protected static final int STATE_XMLDECL_ENDQ = 20;
    protected static final int STATE_XMLDECL_STANDALONE = 15;
    protected static final int STATE_XMLDECL_STANDALONE_EQ = 17;
    protected static final int STATE_XMLDECL_STANDALONE_VALUE = 18;
    protected static final int STATE_XMLDECL_VERSION = 3;
    protected static final int STATE_XMLDECL_VERSION_EQ = 5;
    protected static final int STATE_XMLDECL_VERSION_VALUE = 6;
    protected XmlCharTypes _charTypes;
    protected int _currQuad;
    protected int _currQuadBytes;
    protected boolean _elemAllNsBound;
    protected boolean _elemAttrCount;
    protected PName _elemAttrName;
    protected int _elemAttrPtr;
    protected byte _elemAttrQuote;
    protected int _elemNsPtr;
    protected boolean _endOfInput;
    protected int _entityValue;
    protected boolean _inDtdDeclaration;
    protected int _nextEvent;
    protected int _pendingInput;
    protected int[] _quadBuffer;
    protected int _quadCount;
    protected int _state;
    protected int _surroundingEvent;
    protected ByteBasedPNameTable _symbols;

    protected abstract byte _currentByte() throws XMLStreamException;

    protected abstract byte _nextByte() throws XMLStreamException;

    protected abstract byte _prevByte() throws XMLStreamException;

    protected abstract boolean asyncSkipSpace() throws XMLStreamException;

    @Override // com.fasterxml.aalto.in.ByteBasedScanner
    protected int decodeCharForError(byte b) throws XMLStreamException {
        return b;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected abstract void finishCharacters() throws XMLStreamException;

    protected abstract boolean handleAttrValue() throws XMLStreamException;

    protected abstract int handleComment() throws XMLStreamException;

    protected abstract boolean handleDTDInternalSubset(boolean z) throws XMLStreamException;

    protected abstract boolean handleNsDecl() throws XMLStreamException;

    protected abstract int handlePI() throws XMLStreamException;

    protected abstract boolean handlePartialCR() throws XMLStreamException;

    protected abstract int handleStartElement() throws XMLStreamException;

    protected abstract int handleStartElementStart(byte b) throws XMLStreamException;

    protected abstract PName parseNewName(byte b) throws XMLStreamException;

    protected abstract PName parsePName() throws XMLStreamException;

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected abstract boolean skipCharacters() throws XMLStreamException;

    protected abstract int startCharacters(byte b) throws XMLStreamException;

    protected boolean validPublicIdChar(int i) {
        return i == 10 || i == 13 || i == 32 || (i >= 48 && i <= 57) || ((i >= 64 && i <= 90) || ((i >= 97 && i <= 122) || i == 33 || ((i >= 35 && i <= 37) || ((i >= 39 && i <= 47) || ((i >= 58 && i <= 59) || i == 61 || i == 63 || i == 95)))));
    }

    protected AsyncByteScanner(ReaderConfig readerConfig) {
        super(readerConfig);
        this._quadBuffer = new int[32];
        this._nextEvent = 257;
        this._surroundingEvent = 257;
        this._pendingInput = 0;
        this._endOfInput = false;
        this._currQuadBytes = 0;
        this._entityValue = 0;
    }

    protected void _activateEncoding() {
        if (this._symbols == null) {
            this._charTypes = this._config.getCharTypes();
            this._symbols = this._config.getBBSymbols();
        }
    }

    @Override // com.fasterxml.aalto.AsyncInputFeeder
    public void endOfInput() {
        this._endOfInput = true;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void _releaseBuffers() {
        super._releaseBuffers();
        if (this._symbols.maybeDirty()) {
            this._config.updateBBSymbols(this._symbols);
        }
    }

    @Override // com.fasterxml.aalto.in.ByteBasedScanner, com.fasterxml.aalto.in.XmlScanner
    protected void _closeSource() throws IOException {
        this._endOfInput = true;
    }

    protected void verifyAndSetXmlVersion() throws XMLStreamException {
        if (this._textBuilder.equalsString("1.0")) {
            this._config.setXmlVersion("1.0");
        } else if (this._textBuilder.equalsString(XmlConsts.XML_V_11_STR)) {
            this._config.setXmlVersion(XmlConsts.XML_V_11_STR);
        } else {
            reportInputProblem("Unrecognized XML version '" + this._textBuilder.contentsAsString() + "' (expected '1.0' or '1.1')");
        }
    }

    protected void verifyAndSetXmlEncoding() throws XMLStreamException {
        String strNormalize = CharsetNames.normalize(this._textBuilder.contentsAsString());
        if ("UTF-8" != strNormalize && CharsetNames.CS_US_ASCII != strNormalize && CharsetNames.CS_ISO_LATIN1 != strNormalize) {
            reportInputProblem("Unsupported encoding '" + strNormalize + "': only UTF-8 and US-ASCII support by async parser");
        }
        this._config.setXmlEncoding(strNormalize);
        if (strNormalize != null) {
            this._config.setActualEncoding(strNormalize);
        }
        this._charTypes = this._config.getCharTypes();
    }

    protected void verifyAndSetXmlStandalone() throws XMLStreamException {
        if (this._textBuilder.equalsString(XmlConsts.XML_SA_YES)) {
            this._config.setXmlStandalone(Boolean.TRUE);
        } else if (this._textBuilder.equalsString(XmlConsts.XML_SA_NO)) {
            this._config.setXmlStandalone(Boolean.FALSE);
        } else {
            reportInputProblem("Invalid standalone value '" + this._textBuilder.contentsAsString() + "': can only use 'yes' and 'no'");
        }
    }

    protected void verifyAndSetPublicId() throws XMLStreamException {
        this._publicId = this._textBuilder.contentsAsString();
    }

    protected void verifyAndSetSystemId() throws XMLStreamException {
        this._systemId = this._textBuilder.contentsAsString();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishToken() throws XMLStreamException {
        this._tokenIncomplete = false;
        int i = this._currToken;
        if (i == 3) {
            finishPI();
            return;
        }
        if (i == 4) {
            finishCharacters();
            return;
        }
        if (i == 5) {
            finishComment();
            return;
        }
        if (i == 6) {
            finishSpace();
            return;
        }
        if (i == 11) {
            finishDTD(true);
        } else if (i == 12) {
            finishCData();
        } else {
            ErrorConsts.throwInternalError();
        }
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void finishCData() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void finishComment() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void finishDTD(boolean z) throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void finishPI() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void finishSpace() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void skipCData() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void skipComment() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void skipPI() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void skipSpace() throws XMLStreamException {
        throwInternal();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected boolean loadMore() throws XMLStreamException {
        throwInternal();
        return false;
    }

    protected final PName findPName(int i, int i2) throws XMLStreamException {
        this._inputPtr--;
        int i3 = this._quadCount;
        if (i2 == 0) {
            i3--;
            i = this._quadBuffer[i3];
            i2 = 4;
        }
        int i4 = i2;
        if (i3 > 1) {
            int[] iArr = this._quadBuffer;
            if (i3 >= iArr.length) {
                this._quadBuffer = DataUtil.growArrayBy(iArr, iArr.length);
            }
            int[] iArr2 = this._quadBuffer;
            int i5 = i3 + 1;
            iArr2[i3] = i;
            int iCalcHash = ByteBasedPNameTable.calcHash(iArr2, i5);
            ByteBasedPName byteBasedPNameFindSymbol = this._symbols.findSymbol(iCalcHash, this._quadBuffer, i5);
            return byteBasedPNameFindSymbol == null ? addPName(this._symbols, iCalcHash, this._quadBuffer, i5, i4) : byteBasedPNameFindSymbol;
        }
        if (i3 == 0) {
            int iCalcHash2 = ByteBasedPNameTable.calcHash(i);
            ByteBasedPName byteBasedPNameFindSymbol2 = this._symbols.findSymbol(iCalcHash2, i, 0);
            if (byteBasedPNameFindSymbol2 != null) {
                return byteBasedPNameFindSymbol2;
            }
            int[] iArr3 = this._quadBuffer;
            iArr3[0] = i;
            return addPName(this._symbols, iCalcHash2, iArr3, 1, i4);
        }
        int i6 = this._quadBuffer[0];
        int iCalcHash3 = ByteBasedPNameTable.calcHash(i6, i);
        ByteBasedPName byteBasedPNameFindSymbol3 = this._symbols.findSymbol(iCalcHash3, i6, i);
        if (byteBasedPNameFindSymbol3 != null) {
            return byteBasedPNameFindSymbol3;
        }
        int[] iArr4 = this._quadBuffer;
        iArr4[1] = i;
        return addPName(this._symbols, iCalcHash3, iArr4, 2, i4);
    }

    protected final PName addPName(ByteBasedPNameTable byteBasedPNameTable, int i, int[] iArr, int i2, int i3) throws XMLStreamException {
        return addUTFPName(byteBasedPNameTable, this._charTypes, i, iArr, i2, i3);
    }

    protected void verifyAndAppendEntityCharacter(int i) throws XMLStreamException {
        verifyXmlChar(i);
        if ((i >> 16) != 0) {
            int i2 = i - 65536;
            this._textBuilder.append((char) ((i2 >> 10) | 55296));
            i = (i2 & 1023) | 56320;
        }
        this._textBuilder.append((char) i);
    }

    protected void checkPITargetName(PName pName) throws XMLStreamException {
        String localName = pName.getLocalName();
        if (localName.length() == 3 && localName.equalsIgnoreCase("xml") && !pName.hasPrefix()) {
            reportInputProblem(ErrorConsts.ERR_WF_PI_XML_TARGET);
        }
    }

    protected int throwInternal() {
        throw new IllegalStateException("Internal error: should never execute this code path");
    }

    protected void reportInvalidOther(int i, int i2) throws XMLStreamException {
        this._inputPtr = i2;
        reportInvalidOther(i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    public final int nextFromProlog(boolean z) throws XMLStreamException {
        if (this._currToken != 257) {
            setStartLocation();
            if (this._currToken == 7) {
                this._currToken = 257;
                if (this._tokenName != null) {
                    this._nextEvent = 3;
                    this._state = 1;
                    checkPITargetName(this._tokenName);
                    return handlePI();
                }
            } else {
                this._nextEvent = 257;
                this._currToken = 257;
                this._state = 0;
            }
        }
        int i = this._nextEvent;
        if (i != 257) {
            if (i == 1) {
                return handleStartElement();
            }
            if (i == 3) {
                return handlePI();
            }
            if (i == 5) {
                return handleComment();
            }
            if (i == 7) {
                return handleXmlDeclaration();
            }
            if (i == 11) {
                return handleDTD();
            }
            return throwInternal();
        }
        if (this._state == 1) {
            if (this._inputPtr >= this._inputEnd) {
                return this._currToken;
            }
            if (this._pendingInput != 0) {
                Boolean boolStartXmlDeclaration = startXmlDeclaration();
                if (boolStartXmlDeclaration == null) {
                    return 257;
                }
                if (boolStartXmlDeclaration == Boolean.FALSE) {
                    return _startDocumentNoXmlDecl();
                }
                return handleXmlDeclaration();
            }
            if (_currentByte() == 60) {
                this._inputPtr++;
                this._pendingInput = PENDING_STATE_XMLDECL_LT;
                Boolean boolStartXmlDeclaration2 = startXmlDeclaration();
                if (boolStartXmlDeclaration2 == null) {
                    return 257;
                }
                if (boolStartXmlDeclaration2 == Boolean.FALSE) {
                    return _startDocumentNoXmlDecl();
                }
                return handleXmlDeclaration();
            }
            this._state = 0;
            return _startDocumentNoXmlDecl();
        }
        if (this._pendingInput != 0 && !handlePartialCR()) {
            return this._currToken;
        }
        while (this._state == 0) {
            if (this._inputPtr >= this._inputEnd) {
                if (this._endOfInput) {
                    setStartLocation();
                    return -1;
                }
                return this._currToken;
            }
            byte b_nextByte = _nextByte();
            if (b_nextByte == 60) {
                this._state = 2;
                break;
            }
            if (b_nextByte == 32 || b_nextByte == 13 || b_nextByte == 10 || b_nextByte == 9) {
                if (!asyncSkipSpace()) {
                    if (this._endOfInput) {
                        setStartLocation();
                        return -1;
                    }
                    return this._currToken;
                }
            } else {
                reportPrologUnexpChar(z, decodeCharForError(b_nextByte), null);
            }
        }
        int i2 = this._state;
        if (i2 != 2) {
            if (i2 == 3) {
                return handlePrologDeclStart(z);
            }
            return throwInternal();
        }
        if (this._inputPtr >= this._inputEnd) {
            return this._currToken;
        }
        byte b_nextByte2 = _nextByte();
        if (b_nextByte2 == 33) {
            this._state = 3;
            return handlePrologDeclStart(z);
        }
        if (b_nextByte2 == 63) {
            this._nextEvent = 3;
            this._state = 0;
            return handlePI();
        }
        if (b_nextByte2 == 47 || !z) {
            reportPrologUnexpElement(z, b_nextByte2);
        }
        return handleStartElementStart(b_nextByte2);
    }

    protected int _startDocumentNoXmlDecl() throws XMLStreamException {
        _activateEncoding();
        this._currToken = 7;
        return 7;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int handlePrologDeclStart(boolean z) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte b_nextByte = _nextByte();
        if (b_nextByte == 45) {
            this._nextEvent = 5;
            this._state = 0;
            return handleComment();
        }
        if (b_nextByte == 68) {
            this._nextEvent = 11;
            this._state = 0;
            return handleDTD();
        }
        reportPrologUnexpChar(z, decodeCharForError(b_nextByte), " (expected '-' for COMMENT)");
        return 257;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final Boolean startXmlDeclaration() throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            return null;
        }
        if (this._pendingInput == PENDING_STATE_XMLDECL_LT) {
            if (_currentByte() != 63) {
                this._pendingInput = 0;
                this._state = 2;
                return Boolean.FALSE;
            }
            this._inputPtr++;
            this._pendingInput = PENDING_STATE_XMLDECL_LTQ;
            if (this._inputPtr >= this._inputEnd) {
                return null;
            }
        }
        int i = this._pendingInput;
        if (i == PENDING_STATE_XMLDECL_LTQ) {
            this._tokenName = _parseNewXmlDeclName(_nextByte());
            if (this._tokenName == null) {
                this._pendingInput = PENDING_STATE_XMLDECL_TARGET;
                return null;
            }
            if (!"xml".equals(this._tokenName.getPrefixedName())) {
                this._pendingInput = 0;
                this._state = 1;
                this._nextEvent = 3;
                checkPITargetName(this._tokenName);
                return Boolean.FALSE;
            }
        } else if (i == PENDING_STATE_XMLDECL_TARGET) {
            PName pName_parseXmlDeclName = _parseXmlDeclName();
            this._tokenName = pName_parseXmlDeclName;
            if (pName_parseXmlDeclName == null) {
                return null;
            }
            if (!"xml".equals(this._tokenName.getPrefixedName())) {
                this._pendingInput = 0;
                this._state = 1;
                this._nextEvent = 3;
                checkPITargetName(this._tokenName);
                return Boolean.FALSE;
            }
        } else {
            throwInternal();
        }
        this._pendingInput = 0;
        this._nextEvent = 7;
        this._state = 1;
        return Boolean.TRUE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:119:0x0211  */
    /* JADX WARN: Code duplicated, block: B:128:0x0238  */
    /* JADX WARN: Code duplicated, block: B:133:0x0255  */
    /* JADX WARN: Code duplicated, block: B:157:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:191:0x035f  */
    /* JADX WARN: Code duplicated, block: B:200:0x0385  */
    /* JADX WARN: Code duplicated, block: B:205:0x039e  */
    /* JADX WARN: Code duplicated, block: B:232:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:23:0x0064  */
    /* JADX WARN: Code duplicated, block: B:260:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:264:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:266:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x0117 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0182 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:284:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x0226 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x022e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x0265 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x0299 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:0x02d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0089  */
    /* JADX WARN: Code duplicated, block: B:300:0x02ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:301:0x02e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:302:0x02da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x02ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x02e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x02fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x02f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:0x0373 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x037b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:312:0x03ac A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:0x03e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x03f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:0x03ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:321:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:322:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:326:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:331:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:332:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:342:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:343:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:344:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:348:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:349:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:359:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:365:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x0109  */
    /* JADX WARN: Code duplicated, block: B:84:0x0168  */
    /* JADX WARN: Code duplicated, block: B:99:0x019c  */
    private int handleXmlDeclaration() throws XMLStreamException {
        PName pName_parseNewXmlDeclName;
        byte b_nextByte;
        byte b_nextByte2;
        byte b_nextByte3;
        PName pName_parseNewXmlDeclName2;
        byte b_nextByte4;
        byte b_nextByte5;
        byte b_nextByte6;
        byte b;
        byte b_nextByte7;
        PName pName_parseNewXmlDeclName3;
        byte b_nextByte8;
        byte b_nextByte9;
        byte b_nextByte10;
        if (this._pendingInput == -1 && !handlePartialCR()) {
            return 257;
        }
        while (this._inputPtr < this._inputEnd) {
            switch (this._state) {
                case 1:
                    byte b_nextByte11 = _nextByte();
                    if (b_nextByte11 == 32 || b_nextByte11 == 13 || b_nextByte11 == 10 || b_nextByte11 == 9) {
                        this._state = 2;
                    } else {
                        reportPrologUnexpChar(true, decodeCharForError(b_nextByte11), " (expected space after 'xml' in xml declaration)");
                    }
                    if (this._inputPtr < this._inputEnd) {
                        if (!asyncSkipSpace()) {
                            pName_parseNewXmlDeclName = _parseNewXmlDeclName(_nextByte());
                            this._tokenName = pName_parseNewXmlDeclName;
                            if (pName_parseNewXmlDeclName == null) {
                                this._state = 3;
                            } else {
                                if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_VERSION)) {
                                    reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'version'");
                                }
                                this._state = 4;
                            }
                        }
                    }
                    break;
                case 2:
                    if (!asyncSkipSpace()) {
                        pName_parseNewXmlDeclName = _parseNewXmlDeclName(_nextByte());
                        this._tokenName = pName_parseNewXmlDeclName;
                        if (pName_parseNewXmlDeclName == null) {
                            this._state = 3;
                        } else {
                            if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_VERSION)) {
                                reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'version'");
                            }
                            this._state = 4;
                        }
                    }
                    break;
                case 3:
                    PName pName_parseXmlDeclName = _parseXmlDeclName();
                    this._tokenName = pName_parseXmlDeclName;
                    if (pName_parseXmlDeclName != null) {
                        if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_VERSION)) {
                            reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'version'");
                        }
                        this._state = 4;
                        if (this._inputPtr < this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte2 = _nextByte();
                                if (b_nextByte2 != 61) {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte2), " (expected '=' after 'version' in xml declaration)");
                                }
                                this._state = 5;
                                if (this._inputPtr >= this._inputEnd) {
                                    if (asyncSkipSpace()) {
                                        b_nextByte = _nextByte();
                                        this._elemAttrQuote = b_nextByte;
                                        if (b_nextByte != 34 && b_nextByte != 39) {
                                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte), " (expected '\"' or ''' in xml declaration for version value)");
                                        }
                                        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
                                        if (this._inputPtr < this._inputEnd || !parseXmlDeclAttr(cArrResetWithEmpty, 0)) {
                                            this._state = 6;
                                        } else {
                                            verifyAndSetXmlVersion();
                                            this._state = 7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    if (asyncSkipSpace()) {
                        b_nextByte2 = _nextByte();
                        if (b_nextByte2 != 61) {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte2), " (expected '=' after 'version' in xml declaration)");
                        }
                        this._state = 5;
                        if (this._inputPtr >= this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte = _nextByte();
                                this._elemAttrQuote = b_nextByte;
                                if (b_nextByte != 34) {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte), " (expected '\"' or ''' in xml declaration for version value)");
                                }
                                char[] cArrResetWithEmpty2 = this._textBuilder.resetWithEmpty();
                                if (this._inputPtr < this._inputEnd) {
                                }
                                this._state = 6;
                            }
                        }
                    }
                    break;
                case 5:
                    if (asyncSkipSpace()) {
                        b_nextByte = _nextByte();
                        this._elemAttrQuote = b_nextByte;
                        if (b_nextByte != 34) {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte), " (expected '\"' or ''' in xml declaration for version value)");
                        }
                        char[] cArrResetWithEmpty3 = this._textBuilder.resetWithEmpty();
                        if (this._inputPtr < this._inputEnd) {
                        }
                        this._state = 6;
                    }
                    break;
                case 6:
                    if (!parseXmlDeclAttr(this._textBuilder.getBufferWithoutReset(), this._textBuilder.getCurrentLength())) {
                        this._state = 6;
                    } else {
                        verifyAndSetXmlVersion();
                        this._state = 7;
                        if (this._inputPtr < this._inputEnd) {
                            b_nextByte4 = _nextByte();
                            if (b_nextByte4 == 63) {
                                this._state = 20;
                            } else {
                                if (b_nextByte4 != 32 || b_nextByte4 == 13 || b_nextByte4 == 10 || b_nextByte4 == 9) {
                                    this._state = 8;
                                } else {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte4), " (expected space after version value in xml declaration)");
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    if (asyncSkipSpace()) {
                                        b_nextByte3 = _nextByte();
                                        if (b_nextByte3 == 63) {
                                            this._state = 20;
                                        } else {
                                            pName_parseNewXmlDeclName2 = _parseNewXmlDeclName(b_nextByte3);
                                            this._tokenName = pName_parseNewXmlDeclName2;
                                            if (pName_parseNewXmlDeclName2 == null) {
                                                this._state = 9;
                                            } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_ENCODING)) {
                                                this._state = 10;
                                            } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                                                this._state = 16;
                                            } else {
                                                reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'encoding'");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    b_nextByte4 = _nextByte();
                    if (b_nextByte4 == 63) {
                        this._state = 20;
                    } else {
                        if (b_nextByte4 != 32) {
                            this._state = 8;
                        } else {
                            this._state = 8;
                        }
                        if (this._inputPtr >= this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte3 = _nextByte();
                                if (b_nextByte3 == 63) {
                                    this._state = 20;
                                } else {
                                    pName_parseNewXmlDeclName2 = _parseNewXmlDeclName(b_nextByte3);
                                    this._tokenName = pName_parseNewXmlDeclName2;
                                    if (pName_parseNewXmlDeclName2 == null) {
                                        this._state = 9;
                                    } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_ENCODING)) {
                                        this._state = 10;
                                    } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                                        this._state = 16;
                                    } else {
                                        reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'encoding'");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    if (asyncSkipSpace()) {
                        b_nextByte3 = _nextByte();
                        if (b_nextByte3 == 63) {
                            this._state = 20;
                        } else {
                            pName_parseNewXmlDeclName2 = _parseNewXmlDeclName(b_nextByte3);
                            this._tokenName = pName_parseNewXmlDeclName2;
                            if (pName_parseNewXmlDeclName2 == null) {
                                this._state = 9;
                            } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_ENCODING)) {
                                this._state = 10;
                            } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                                this._state = 16;
                            } else {
                                reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'encoding'");
                            }
                        }
                    }
                    break;
                case 9:
                    PName pName_parseXmlDeclName2 = _parseXmlDeclName();
                    this._tokenName = pName_parseXmlDeclName2;
                    if (pName_parseXmlDeclName2 != null) {
                        if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_ENCODING)) {
                            this._state = 10;
                        } else if (this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                            this._state = 16;
                        } else {
                            reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'encoding'");
                        }
                        if (this._inputPtr < this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte6 = _nextByte();
                                if (b_nextByte6 != 61) {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte6), " (expected '=' after 'encoding' in xml declaration)");
                                }
                                this._state = 11;
                                if (this._inputPtr >= this._inputEnd) {
                                    if (asyncSkipSpace()) {
                                        b_nextByte5 = _nextByte();
                                        this._elemAttrQuote = b_nextByte5;
                                        if (b_nextByte5 != 34 && b_nextByte5 != 39) {
                                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte5), " (expected '\"' or ''' in xml declaration for encoding value)");
                                        }
                                        this._state = 12;
                                        char[] cArrResetWithEmpty4 = this._textBuilder.resetWithEmpty();
                                        if (this._inputPtr < this._inputEnd || !parseXmlDeclAttr(cArrResetWithEmpty4, 0)) {
                                            this._state = 12;
                                        } else {
                                            verifyAndSetXmlEncoding();
                                            this._state = 13;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 10:
                    if (asyncSkipSpace()) {
                        b_nextByte6 = _nextByte();
                        if (b_nextByte6 != 61) {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte6), " (expected '=' after 'encoding' in xml declaration)");
                        }
                        this._state = 11;
                        if (this._inputPtr >= this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte5 = _nextByte();
                                this._elemAttrQuote = b_nextByte5;
                                if (b_nextByte5 != 34) {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte5), " (expected '\"' or ''' in xml declaration for encoding value)");
                                }
                                this._state = 12;
                                char[] cArrResetWithEmpty5 = this._textBuilder.resetWithEmpty();
                                if (this._inputPtr < this._inputEnd) {
                                }
                                this._state = 12;
                            }
                        }
                    }
                    break;
                case 11:
                    if (asyncSkipSpace()) {
                        b_nextByte5 = _nextByte();
                        this._elemAttrQuote = b_nextByte5;
                        if (b_nextByte5 != 34) {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte5), " (expected '\"' or ''' in xml declaration for encoding value)");
                        }
                        this._state = 12;
                        char[] cArrResetWithEmpty6 = this._textBuilder.resetWithEmpty();
                        if (this._inputPtr < this._inputEnd) {
                        }
                        this._state = 12;
                    }
                    break;
                case 12:
                    if (!parseXmlDeclAttr(this._textBuilder.getBufferWithoutReset(), this._textBuilder.getCurrentLength())) {
                        this._state = 12;
                    } else {
                        verifyAndSetXmlEncoding();
                        b = 13;
                        this._state = 13;
                        if (this._inputPtr < this._inputEnd) {
                            b_nextByte8 = _nextByte();
                            if (b_nextByte8 == 63) {
                                this._state = 20;
                            } else {
                                if (b_nextByte8 != 32 || b_nextByte8 == b || b_nextByte8 == 10 || b_nextByte8 == 9) {
                                    this._state = 14;
                                } else {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte8), " (expected space after encoding value in xml declaration)");
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    if (asyncSkipSpace()) {
                                        b_nextByte7 = _nextByte();
                                        if (b_nextByte7 == 63) {
                                            this._state = 20;
                                        } else {
                                            pName_parseNewXmlDeclName3 = _parseNewXmlDeclName(b_nextByte7);
                                            this._tokenName = pName_parseNewXmlDeclName3;
                                            if (pName_parseNewXmlDeclName3 == null) {
                                                this._state = 15;
                                            } else {
                                                if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                                                    reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'standalone'");
                                                }
                                                this._state = 16;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 13:
                    b = 13;
                    b_nextByte8 = _nextByte();
                    if (b_nextByte8 == 63) {
                        this._state = 20;
                    } else {
                        if (b_nextByte8 != 32) {
                            this._state = 14;
                        } else {
                            this._state = 14;
                        }
                        if (this._inputPtr >= this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte7 = _nextByte();
                                if (b_nextByte7 == 63) {
                                    this._state = 20;
                                } else {
                                    pName_parseNewXmlDeclName3 = _parseNewXmlDeclName(b_nextByte7);
                                    this._tokenName = pName_parseNewXmlDeclName3;
                                    if (pName_parseNewXmlDeclName3 == null) {
                                        this._state = 15;
                                    } else {
                                        if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                                            reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'standalone'");
                                        }
                                        this._state = 16;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 14:
                    if (asyncSkipSpace()) {
                        b_nextByte7 = _nextByte();
                        if (b_nextByte7 == 63) {
                            this._state = 20;
                        } else {
                            pName_parseNewXmlDeclName3 = _parseNewXmlDeclName(b_nextByte7);
                            this._tokenName = pName_parseNewXmlDeclName3;
                            if (pName_parseNewXmlDeclName3 == null) {
                                this._state = 15;
                            } else {
                                if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                                    reportInputProblem("Unexpected keyword '" + this._tokenName.getPrefixedName() + "' in XML declaration: expected 'standalone'");
                                }
                                this._state = 16;
                            }
                        }
                    }
                    break;
                case 15:
                    PName pName_parseXmlDeclName3 = _parseXmlDeclName();
                    this._tokenName = pName_parseXmlDeclName3;
                    if (pName_parseXmlDeclName3 != null) {
                        if (!this._tokenName.hasPrefixedName(XmlConsts.XML_DECL_KW_STANDALONE)) {
                            reportInputProblem("Unexpected keyword 'encoding' in XML declaration: expected 'standalone'");
                        }
                        this._state = 16;
                        if (this._inputPtr < this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte10 = _nextByte();
                                if (b_nextByte10 != 61) {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte10), " (expected '=' after 'standalone' in xml declaration)");
                                }
                                this._state = 17;
                                if (this._inputPtr >= this._inputEnd) {
                                    if (asyncSkipSpace()) {
                                        b_nextByte9 = _nextByte();
                                        this._elemAttrQuote = b_nextByte9;
                                        if (b_nextByte9 != 34 && b_nextByte9 != 39) {
                                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte9), " (expected '\"' or ''' in xml declaration for standalone value)");
                                        }
                                        char[] cArrResetWithEmpty7 = this._textBuilder.resetWithEmpty();
                                        if (this._inputPtr < this._inputEnd || !parseXmlDeclAttr(cArrResetWithEmpty7, 0)) {
                                            this._state = 18;
                                        } else {
                                            verifyAndSetXmlStandalone();
                                            this._state = 19;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 16:
                    if (asyncSkipSpace()) {
                        b_nextByte10 = _nextByte();
                        if (b_nextByte10 != 61) {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte10), " (expected '=' after 'standalone' in xml declaration)");
                        }
                        this._state = 17;
                        if (this._inputPtr >= this._inputEnd) {
                            if (asyncSkipSpace()) {
                                b_nextByte9 = _nextByte();
                                this._elemAttrQuote = b_nextByte9;
                                if (b_nextByte9 != 34) {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte9), " (expected '\"' or ''' in xml declaration for standalone value)");
                                }
                                char[] cArrResetWithEmpty8 = this._textBuilder.resetWithEmpty();
                                if (this._inputPtr < this._inputEnd) {
                                }
                                this._state = 18;
                            }
                        }
                    }
                    break;
                case 17:
                    if (asyncSkipSpace()) {
                        b_nextByte9 = _nextByte();
                        this._elemAttrQuote = b_nextByte9;
                        if (b_nextByte9 != 34) {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte9), " (expected '\"' or ''' in xml declaration for standalone value)");
                        }
                        char[] cArrResetWithEmpty9 = this._textBuilder.resetWithEmpty();
                        if (this._inputPtr < this._inputEnd) {
                        }
                        this._state = 18;
                    }
                    break;
                case 18:
                    if (!parseXmlDeclAttr(this._textBuilder.getBufferWithoutReset(), this._textBuilder.getCurrentLength())) {
                        this._state = 18;
                    } else {
                        verifyAndSetXmlStandalone();
                        this._state = 19;
                        if (this._inputPtr >= this._inputEnd) {
                            continue;
                        } else if (asyncSkipSpace()) {
                            if (_nextByte() != 63) {
                                reportPrologUnexpChar(true, decodeCharForError(_prevByte()), " (expected '?>' to end xml declaration)");
                            }
                            this._state = 20;
                            if (this._inputPtr >= this._inputEnd) {
                                this._tokenName = null;
                                this._state = 0;
                                this._nextEvent = 257;
                                if (_nextByte() != 62) {
                                    reportPrologUnexpChar(true, decodeCharForError(_prevByte()), " (expected '>' to end xml declaration)");
                                }
                                _activateEncoding();
                                return 7;
                            }
                        } else {
                            continue;
                        }
                    }
                    break;
                case 19:
                    if (asyncSkipSpace()) {
                        if (_nextByte() != 63) {
                            reportPrologUnexpChar(true, decodeCharForError(_prevByte()), " (expected '?>' to end xml declaration)");
                        }
                        this._state = 20;
                        if (this._inputPtr >= this._inputEnd) {
                            this._tokenName = null;
                            this._state = 0;
                            this._nextEvent = 257;
                            if (_nextByte() != 62) {
                                reportPrologUnexpChar(true, decodeCharForError(_prevByte()), " (expected '>' to end xml declaration)");
                            }
                            _activateEncoding();
                            return 7;
                        }
                    } else {
                        continue;
                    }
                case 20:
                    this._tokenName = null;
                    this._state = 0;
                    this._nextEvent = 257;
                    if (_nextByte() != 62) {
                        reportPrologUnexpChar(true, decodeCharForError(_prevByte()), " (expected '>' to end xml declaration)");
                    }
                    _activateEncoding();
                    return 7;
                default:
                    throwInternal();
                    break;
            }
        }
        return 257;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:127:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:136:0x0210  */
    /* JADX WARN: Code duplicated, block: B:144:0x0226  */
    /* JADX WARN: Code duplicated, block: B:173:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:220:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x010d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x021b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x024d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x02b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:264:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0078  */
    /* JADX WARN: Code duplicated, block: B:35:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    private int handleDTD() throws XMLStreamException {
        PName newName;
        byte b_nextByte;
        byte b_nextByte2;
        PName newName2;
        String prefixedName;
        byte b_nextByte3;
        int i;
        byte b_nextByte4;
        byte b_nextByte5;
        byte b_nextByte6;
        if (this._pendingInput == -1 && !handlePartialCR()) {
            return 257;
        }
        if (this._state == 16) {
            if (!handleDTDInternalSubset(false)) {
                return 257;
            }
            this._state = 50;
        }
        while (this._inputPtr < this._inputEnd) {
            int i2 = this._state;
            if (i2 != 50) {
                switch (i2) {
                    case 0:
                        this._tokenName = parseNewName((byte) 68);
                        if (this._tokenName == null) {
                            this._state = 1;
                            return 257;
                        }
                        if (!"DOCTYPE".equals(this._tokenName.getPrefixedName())) {
                            reportPrologProblem(true, "expected 'DOCTYPE'");
                        }
                        this._state = 2;
                        break;
                        break;
                    case 1:
                        this._tokenName = parsePName();
                        if (this._tokenName == null) {
                            this._state = 1;
                            return 257;
                        }
                        if (!"DOCTYPE".equals(this._tokenName.getPrefixedName())) {
                            reportPrologProblem(true, "expected 'DOCTYPE'");
                        }
                        if (this._inputPtr < this._inputEnd) {
                            b_nextByte = _nextByte();
                            if (b_nextByte != 32 || b_nextByte == 13 || b_nextByte == 10 || b_nextByte == 9) {
                                this._state = 3;
                            } else {
                                reportPrologUnexpChar(true, decodeCharForError(b_nextByte), " (expected space after 'DOCTYPE')");
                            }
                            if (asyncSkipSpace()) {
                                newName = parseNewName(_nextByte());
                                this._tokenName = newName;
                                if (newName == null) {
                                    this._state = 4;
                                } else {
                                    this._state = 4;
                                }
                            }
                        }
                        break;
                        break;
                    case 2:
                        b_nextByte = _nextByte();
                        if (b_nextByte != 32) {
                            this._state = 3;
                        } else {
                            this._state = 3;
                        }
                        if (asyncSkipSpace()) {
                            newName = parseNewName(_nextByte());
                            this._tokenName = newName;
                            if (newName == null) {
                                this._state = 4;
                            } else {
                                this._state = 4;
                            }
                        }
                        break;
                    case 3:
                        if (asyncSkipSpace()) {
                            newName = parseNewName(_nextByte());
                            this._tokenName = newName;
                            if (newName == null) {
                                this._state = 4;
                            } else {
                                this._state = 4;
                            }
                        }
                        break;
                    case 4:
                        PName pName = parsePName();
                        this._tokenName = pName;
                        if (pName == null) {
                            continue;
                        } else {
                            this._state = 5;
                            if (this._inputPtr >= this._inputEnd) {
                                continue;
                            } else {
                                b_nextByte3 = _nextByte();
                                if (b_nextByte3 == 62) {
                                    this._state = 0;
                                    this._nextEvent = 257;
                                    return 11;
                                }
                                if (b_nextByte3 != 32 || b_nextByte3 == 13 || b_nextByte3 == 10 || b_nextByte3 == 9) {
                                    this._state = 6;
                                } else {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte3), " (expected space after root name in DOCTYPE declaration)");
                                }
                                if (asyncSkipSpace()) {
                                    b_nextByte2 = _nextByte();
                                    if (b_nextByte2 == 62) {
                                        this._state = 0;
                                        this._nextEvent = 257;
                                        return 11;
                                    }
                                    newName2 = parseNewName(b_nextByte2);
                                    if (newName2 == null) {
                                        this._state = 7;
                                    } else {
                                        prefixedName = newName2.getPrefixedName();
                                        if ("PUBLIC".equals(prefixedName)) {
                                            this._state = 8;
                                        } else if ("SYSTEM".equals(prefixedName)) {
                                            this._state = 9;
                                        } else {
                                            reportPrologProblem(true, "unexpected token '" + prefixedName + "': expected either PUBLIC or SYSTEM");
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        break;
                    case 5:
                        b_nextByte3 = _nextByte();
                        if (b_nextByte3 == 62) {
                            this._state = 0;
                            this._nextEvent = 257;
                            return 11;
                        }
                        if (b_nextByte3 != 32) {
                            this._state = 6;
                        } else {
                            this._state = 6;
                        }
                        if (asyncSkipSpace()) {
                            b_nextByte2 = _nextByte();
                            if (b_nextByte2 == 62) {
                                this._state = 0;
                                this._nextEvent = 257;
                                return 11;
                            }
                            newName2 = parseNewName(b_nextByte2);
                            if (newName2 == null) {
                                this._state = 7;
                            } else {
                                prefixedName = newName2.getPrefixedName();
                                if ("PUBLIC".equals(prefixedName)) {
                                    this._state = 8;
                                } else if ("SYSTEM".equals(prefixedName)) {
                                    this._state = 9;
                                } else {
                                    reportPrologProblem(true, "unexpected token '" + prefixedName + "': expected either PUBLIC or SYSTEM");
                                }
                            }
                        } else {
                            continue;
                        }
                        break;
                        break;
                    case 6:
                        if (asyncSkipSpace()) {
                            b_nextByte2 = _nextByte();
                            if (b_nextByte2 == 62) {
                                this._state = 0;
                                this._nextEvent = 257;
                                return 11;
                            }
                            newName2 = parseNewName(b_nextByte2);
                            if (newName2 == null) {
                                this._state = 7;
                            } else {
                                prefixedName = newName2.getPrefixedName();
                                if ("PUBLIC".equals(prefixedName)) {
                                    this._state = 8;
                                } else if ("SYSTEM".equals(prefixedName)) {
                                    this._state = 9;
                                } else {
                                    reportPrologProblem(true, "unexpected token '" + prefixedName + "': expected either PUBLIC or SYSTEM");
                                }
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 7:
                        PName pName2 = parsePName();
                        if (pName2 == null) {
                            this._state = 7;
                        } else {
                            String prefixedName2 = pName2.getPrefixedName();
                            if ("PUBLIC".equals(prefixedName2)) {
                                this._state = 8;
                            } else if ("SYSTEM".equals(prefixedName2)) {
                                this._state = 9;
                            } else {
                                reportPrologProblem(true, "unexpected token '" + prefixedName2 + "': expected either PUBLIC or SYSTEM");
                            }
                        }
                        break;
                    case 8:
                        byte b_nextByte7 = _nextByte();
                        if (b_nextByte7 == 32 || b_nextByte7 == 13) {
                            i = 10;
                            this._state = i;
                        } else {
                            i = 10;
                            if (b_nextByte7 == 10 || b_nextByte7 == 9) {
                                this._state = i;
                            } else {
                                reportPrologUnexpChar(true, decodeCharForError(b_nextByte7), " (expected space after PUBLIC keyword)");
                            }
                        }
                        break;
                    case 9:
                        byte b_nextByte8 = _nextByte();
                        if (b_nextByte8 == 32 || b_nextByte8 == 13 || b_nextByte8 == 10 || b_nextByte8 == 9) {
                            this._state = 13;
                        } else {
                            reportPrologUnexpChar(true, decodeCharForError(b_nextByte8), " (expected space after SYSTEM keyword)");
                        }
                        break;
                    case 10:
                        if (asyncSkipSpace()) {
                            byte b_nextByte9 = _nextByte();
                            this._elemAttrQuote = b_nextByte9;
                            if (b_nextByte9 != 34 && b_nextByte9 != 39) {
                                reportPrologUnexpChar(true, decodeCharForError(b_nextByte9), " (expected '\"' or ''' for PUBLIC ID)");
                            }
                            char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
                            if (this._inputPtr >= this._inputEnd || !parseDtdId(cArrResetWithEmpty, 0, false)) {
                                this._state = 11;
                            } else {
                                verifyAndSetPublicId();
                                this._state = 12;
                            }
                        }
                        break;
                    case 11:
                        if (parseDtdId(this._textBuilder.getBufferWithoutReset(), this._textBuilder.getCurrentLength(), false)) {
                            verifyAndSetPublicId();
                            this._state = 12;
                            if (this._inputPtr < this._inputEnd) {
                                b_nextByte5 = _nextByte();
                                if (b_nextByte5 != 32 || b_nextByte5 == 13 || b_nextByte5 == 10 || b_nextByte5 == 9) {
                                    this._state = 13;
                                } else {
                                    reportPrologUnexpChar(true, decodeCharForError(b_nextByte5), " (expected space after PUBLIC ID)");
                                }
                                if (asyncSkipSpace()) {
                                    b_nextByte4 = _nextByte();
                                    this._elemAttrQuote = b_nextByte4;
                                    if (b_nextByte4 != 34 && b_nextByte4 != 39) {
                                        reportPrologUnexpChar(true, decodeCharForError(b_nextByte4), " (expected '\"' or ''' for SYSTEM ID)");
                                    }
                                    char[] cArrResetWithEmpty2 = this._textBuilder.resetWithEmpty();
                                    if (this._inputPtr < this._inputEnd || !parseDtdId(cArrResetWithEmpty2, 0, true)) {
                                        this._state = 14;
                                    } else {
                                        verifyAndSetSystemId();
                                        this._state = 15;
                                    }
                                }
                            }
                        }
                        break;
                    case 12:
                        b_nextByte5 = _nextByte();
                        if (b_nextByte5 != 32) {
                            this._state = 13;
                        } else {
                            this._state = 13;
                        }
                        if (asyncSkipSpace()) {
                            b_nextByte4 = _nextByte();
                            this._elemAttrQuote = b_nextByte4;
                            if (b_nextByte4 != 34) {
                                reportPrologUnexpChar(true, decodeCharForError(b_nextByte4), " (expected '\"' or ''' for SYSTEM ID)");
                            }
                            char[] cArrResetWithEmpty3 = this._textBuilder.resetWithEmpty();
                            if (this._inputPtr < this._inputEnd) {
                            }
                            this._state = 14;
                        }
                        break;
                    case 13:
                        if (asyncSkipSpace()) {
                            b_nextByte4 = _nextByte();
                            this._elemAttrQuote = b_nextByte4;
                            if (b_nextByte4 != 34) {
                                reportPrologUnexpChar(true, decodeCharForError(b_nextByte4), " (expected '\"' or ''' for SYSTEM ID)");
                            }
                            char[] cArrResetWithEmpty4 = this._textBuilder.resetWithEmpty();
                            if (this._inputPtr < this._inputEnd) {
                            }
                            this._state = 14;
                        }
                        break;
                    case 14:
                        if (parseDtdId(this._textBuilder.getBufferWithoutReset(), this._textBuilder.getCurrentLength(), true)) {
                            verifyAndSetSystemId();
                            this._state = 15;
                            if (this._inputPtr >= this._inputEnd) {
                                continue;
                            } else if (asyncSkipSpace()) {
                                b_nextByte6 = _nextByte();
                                if (b_nextByte6 == 62) {
                                    this._state = 0;
                                    this._nextEvent = 257;
                                    return 11;
                                }
                                if (b_nextByte6 != 91) {
                                    reportPrologUnexpChar(true, decodeCharForError(this._elemAttrQuote), " (expected either '[' for internal subset, or '>' to end DOCTYPE)");
                                }
                                this._state = 16;
                                if (handleDTDInternalSubset(true)) {
                                    return 257;
                                }
                                this._state = 50;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 15:
                        if (asyncSkipSpace()) {
                            b_nextByte6 = _nextByte();
                            if (b_nextByte6 == 62) {
                                this._state = 0;
                                this._nextEvent = 257;
                                return 11;
                            }
                            if (b_nextByte6 != 91) {
                                reportPrologUnexpChar(true, decodeCharForError(this._elemAttrQuote), " (expected either '[' for internal subset, or '>' to end DOCTYPE)");
                            }
                            this._state = 16;
                            if (handleDTDInternalSubset(true)) {
                                return 257;
                            }
                            this._state = 50;
                        } else {
                            continue;
                        }
                        break;
                    default:
                        throwInternal();
                        break;
                }
            }
            if (asyncSkipSpace()) {
                byte b_nextByte10 = _nextByte();
                if (b_nextByte10 != 62) {
                    reportPrologUnexpChar(true, b_nextByte10, "expected '>' to end DTD");
                }
                this._state = 0;
                this._nextEvent = 257;
                return 11;
            }
        }
        return this._currToken;
    }

    private final boolean parseDtdId(char[] cArr, int i, boolean z) throws XMLStreamException {
        byte b = this._elemAttrQuote;
        while (this._inputPtr < this._inputEnd) {
            int i_nextByte = _nextByte() & 255;
            if (i_nextByte == b) {
                this._textBuilder.setCurrentLength(i);
                return true;
            }
            if (!z && !validPublicIdChar(i_nextByte)) {
                reportPrologUnexpChar(true, decodeCharForError((byte) i_nextByte), " (not valid in " + (z ? "SYSTEM" : "PUBLIC") + " ID)");
            }
            if (i >= cArr.length) {
                cArr = this._textBuilder.finishCurrentSegment();
                i = 0;
            }
            cArr[i] = (char) i_nextByte;
            i++;
        }
        this._textBuilder.setCurrentLength(i);
        return false;
    }

    private final PName _parseNewXmlDeclName(byte b) throws XMLStreamException {
        int i = b & 255;
        if (i < 65) {
            throwUnexpectedChar(i, "; expected a name start character");
        }
        this._quadCount = 0;
        this._currQuad = i;
        this._currQuadBytes = 1;
        return _parseXmlDeclName();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:71:0x005c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x007d A[SYNTHETIC] */
    private final PName _parseXmlDeclName() throws XMLStreamException {
        int i_nextByte;
        int i;
        int[] iArr;
        int i_nextByte2;
        int i_nextByte3 = this._currQuad;
        while (true) {
            int i2 = this._currQuadBytes;
            if (i2 == 0) {
                if (this._inputPtr >= this._inputEnd) {
                    return null;
                }
                i_nextByte3 = _nextByte() & 255;
                if (i_nextByte3 < 65 && (i_nextByte3 < 45 || i_nextByte3 > 58 || i_nextByte3 == 47)) {
                    return _findXmlDeclName(i_nextByte3, 0);
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                        }
                        i = this._quadCount;
                        if (i == 0) {
                            this._quadBuffer[0] = i_nextByte3;
                            this._quadCount = 1;
                        } else {
                            iArr = this._quadBuffer;
                            if (i >= iArr.length) {
                                this._quadBuffer = DataUtil.growArrayBy(iArr, iArr.length);
                            }
                            int[] iArr2 = this._quadBuffer;
                            int i3 = this._quadCount;
                            this._quadCount = i3 + 1;
                            iArr2[i3] = i_nextByte3;
                        }
                        this._currQuadBytes = 0;
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        this._currQuad = i_nextByte3;
                        this._currQuadBytes = 3;
                        return null;
                    }
                    i_nextByte2 = _nextByte() & 255;
                    if (i_nextByte2 >= 65 && (i_nextByte2 < 45 || i_nextByte2 > 58 || i_nextByte2 == 47)) {
                        return _findXmlDeclName(i_nextByte3, 3);
                    }
                    i_nextByte3 = (i_nextByte3 << 8) | i_nextByte2;
                    i = this._quadCount;
                    if (i == 0) {
                        this._quadBuffer[0] = i_nextByte3;
                        this._quadCount = 1;
                    } else {
                        iArr = this._quadBuffer;
                        if (i >= iArr.length) {
                            this._quadBuffer = DataUtil.growArrayBy(iArr, iArr.length);
                        }
                        int[] iArr3 = this._quadBuffer;
                        int i4 = this._quadCount;
                        this._quadCount = i4 + 1;
                        iArr3[i4] = i_nextByte3;
                    }
                    this._currQuadBytes = 0;
                }
                if (this._inputPtr >= this._inputEnd) {
                    this._currQuad = i_nextByte3;
                    this._currQuadBytes = 2;
                    return null;
                }
                i_nextByte = _nextByte() & 255;
                if (i_nextByte >= 65 && (i_nextByte < 45 || i_nextByte > 58 || i_nextByte == 47)) {
                    return _findXmlDeclName(i_nextByte3, 2);
                }
                i_nextByte3 = (i_nextByte3 << 8) | i_nextByte;
                if (this._inputPtr >= this._inputEnd) {
                    this._currQuad = i_nextByte3;
                    this._currQuadBytes = 3;
                    return null;
                }
                i_nextByte2 = _nextByte() & 255;
                if (i_nextByte2 >= 65) {
                }
                i_nextByte3 = (i_nextByte3 << 8) | i_nextByte2;
                i = this._quadCount;
                if (i == 0) {
                    this._quadBuffer[0] = i_nextByte3;
                    this._quadCount = 1;
                } else {
                    iArr = this._quadBuffer;
                    if (i >= iArr.length) {
                        this._quadBuffer = DataUtil.growArrayBy(iArr, iArr.length);
                    }
                    int[] iArr4 = this._quadBuffer;
                    int i5 = this._quadCount;
                    this._quadCount = i5 + 1;
                    iArr4[i5] = i_nextByte3;
                }
                this._currQuadBytes = 0;
            }
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i_nextByte3;
                this._currQuadBytes = 1;
                return null;
            }
            int i_nextByte4 = _nextByte() & 255;
            if (i_nextByte4 < 65 && (i_nextByte4 < 45 || i_nextByte4 > 58 || i_nextByte4 == 47)) {
                return _findXmlDeclName(i_nextByte3, 1);
            }
            i_nextByte3 = (i_nextByte3 << 8) | i_nextByte4;
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i_nextByte3;
                this._currQuadBytes = 2;
                return null;
            }
            i_nextByte = _nextByte() & 255;
            if (i_nextByte >= 65) {
            }
            i_nextByte3 = (i_nextByte3 << 8) | i_nextByte;
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i_nextByte3;
                this._currQuadBytes = 3;
                return null;
            }
            i_nextByte2 = _nextByte() & 255;
            if (i_nextByte2 >= 65) {
            }
            i_nextByte3 = (i_nextByte3 << 8) | i_nextByte2;
            i = this._quadCount;
            if (i == 0) {
                this._quadBuffer[0] = i_nextByte3;
                this._quadCount = 1;
            } else {
                iArr = this._quadBuffer;
                if (i >= iArr.length) {
                    this._quadBuffer = DataUtil.growArrayBy(iArr, iArr.length);
                }
                int[] iArr5 = this._quadBuffer;
                int i6 = this._quadCount;
                this._quadCount = i6 + 1;
                iArr5[i6] = i_nextByte3;
            }
            this._currQuadBytes = 0;
        }
    }

    protected final PName _findXmlDeclName(int i, int i2) throws XMLStreamException {
        PName pNameFind;
        int i3 = this._quadCount;
        if (i2 == 0) {
            i3--;
            i = this._quadBuffer[i3];
        }
        if (i3 == 0) {
            pNameFind = AsyncXmlDeclHelper.find(i);
        } else if (i3 == 1) {
            pNameFind = AsyncXmlDeclHelper.find(this._quadBuffer[0], i);
        } else if (i3 != 2) {
            pNameFind = null;
        } else {
            int[] iArr = this._quadBuffer;
            pNameFind = AsyncXmlDeclHelper.find(iArr[0], iArr[1], i);
        }
        if (pNameFind != null) {
            this._inputPtr--;
            return pNameFind;
        }
        _activateEncoding();
        return findPName(i, i2);
    }

    protected boolean parseXmlDeclAttr(char[] cArr, int i) throws XMLStreamException {
        byte b = this._elemAttrQuote;
        while (this._inputPtr < this._inputEnd) {
            int i_nextByte = _nextByte() & 255;
            if (i_nextByte == b) {
                this._textBuilder.setCurrentLength(i);
                return true;
            }
            if (i_nextByte <= 32 || i_nextByte > 122) {
                reportPrologUnexpChar(true, decodeCharForError((byte) i_nextByte), " (not valid in XML pseudo-attribute values)");
            }
            if (i >= cArr.length) {
                cArr = this._textBuilder.finishCurrentSegment();
                i = 0;
            }
            cArr[i] = (char) i_nextByte;
            i++;
        }
        this._textBuilder.setCurrentLength(i);
        return false;
    }
}

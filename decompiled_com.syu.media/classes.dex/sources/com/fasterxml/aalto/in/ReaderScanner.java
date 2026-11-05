package com.fasterxml.aalto.in;

import chip.FinalChip;
import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.impl.LocationImpl;
import com.fasterxml.aalto.util.DataUtil;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlChars;
import com.fasterxml.aalto.util.XmlConsts;
import java.io.IOException;
import java.io.Reader;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamLocation2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ReaderScanner extends XmlScanner {
    private static final XmlCharTypes sCharTypes = InputCharTypes.getLatin1CharTypes();
    protected Reader _in;
    protected char[] _inputBuffer;
    protected int _inputEnd;
    protected int _inputPtr;
    protected final CharBasedPNameTable _symbols;
    protected int mTmpChar;

    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getEndingByteOffset() throws XMLStreamException {
        return -1L;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getStartingByteOffset() {
        return -1L;
    }

    public ReaderScanner(ReaderConfig readerConfig, Reader reader, char[] cArr, int i, int i2) {
        super(readerConfig);
        this.mTmpChar = 0;
        this._in = reader;
        this._inputBuffer = cArr;
        this._inputPtr = i;
        this._inputEnd = i2;
        this._pastBytesOrChars = 0L;
        this._rowStartOffset = 0;
        this._symbols = readerConfig.getCBSymbols();
    }

    public ReaderScanner(ReaderConfig readerConfig, Reader reader) {
        super(readerConfig);
        this.mTmpChar = 0;
        this._in = reader;
        this._inputBuffer = readerConfig.allocFullCBuffer(4000);
        this._inputEnd = 0;
        this._inputPtr = 0;
        this._pastBytesOrChars = 0L;
        this._rowStartOffset = 0;
        this._symbols = readerConfig.getCBSymbols();
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void _releaseBuffers() {
        super._releaseBuffers();
        if (this._symbols.maybeDirty()) {
            this._config.updateCBSymbols(this._symbols);
        }
        if (this._in == null || this._inputBuffer == null) {
            return;
        }
        this._config.freeFullCBuffer(this._inputBuffer);
        this._inputBuffer = null;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected void _closeSource() throws IOException {
        Reader reader = this._in;
        if (reader != null) {
            reader.close();
            this._in = null;
        }
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
    public final int nextFromProlog(boolean z) throws XMLStreamException {
        if (this._tokenIncomplete) {
            skipToken();
        }
        setStartLocation();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                setStartLocation();
                return -1;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            int i2 = i + 1;
            this._inputPtr = i2;
            int i3 = cArr[i] & 255;
            if (i3 == 60) {
                if (i2 >= this._inputEnd) {
                    loadMoreGuaranteed(5);
                }
                char[] cArr2 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                char c = cArr2[i4];
                if (c == '!') {
                    return handlePrologDeclStart(z);
                }
                if (c == '?') {
                    return handlePIStart();
                }
                if (c == '/' || !z) {
                    reportPrologUnexpElement(z, c);
                }
                return handleStartElement(c);
            }
            if (i3 != 32) {
                if (i3 == 10) {
                    markLF();
                } else if (i3 == 13) {
                    if (i2 >= this._inputEnd && !loadMore()) {
                        markLF();
                        setStartLocation();
                        return -1;
                    }
                    char[] cArr3 = this._inputBuffer;
                    int i5 = this._inputPtr;
                    if (cArr3[i5] == '\n') {
                        this._inputPtr = i5 + 1;
                    }
                    markLF();
                } else if (i3 != 9) {
                    reportPrologUnexpChar(z, i3, null);
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    public final int nextFromTree() throws XMLStreamException {
        char cLoadOne;
        if (this._tokenIncomplete) {
            if (skipToken()) {
                return _nextEntity();
            }
        } else if (this._currToken == 1) {
            if (this._isEmptyTag) {
                this._depth--;
                this._currToken = 2;
                return 2;
            }
        } else if (this._currToken == 2) {
            this._currElem = this._currElem.getParent();
            while (this._lastNsDecl != null && this._lastNsDecl.getLevel() >= this._depth) {
                this._lastNsDecl = this._lastNsDecl.unbind();
            }
        } else if (this._entityPending) {
            this._entityPending = false;
            return _nextEntity();
        }
        setStartLocation();
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            setStartLocation();
            return -1;
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        char c = cArr[i];
        if (c == '<') {
            int i2 = i + 1;
            this._inputPtr = i2;
            if (i2 < this._inputEnd) {
                this._inputPtr = i2 + 1;
                cLoadOne = cArr[i2];
            } else {
                cLoadOne = loadOne(5);
            }
            if (cLoadOne == '!') {
                return handleCommentOrCdataStart();
            }
            if (cLoadOne == '?') {
                return handlePIStart();
            }
            if (cLoadOne == '/') {
                return handleEndElement();
            }
            return handleStartElement(cLoadOne);
        }
        if (c == '&') {
            this._inputPtr = i + 1;
            int iHandleEntityInText = handleEntityInText(false);
            if (iHandleEntityInText == 0) {
                this._currToken = 9;
                return 9;
            }
            this.mTmpChar = -iHandleEntityInText;
        } else {
            this.mTmpChar = c;
        }
        if (this._cfgLazyParsing) {
            this._tokenIncomplete = true;
        } else {
            finishCharacters();
        }
        this._currToken = 4;
        return 4;
    }

    protected int _nextEntity() {
        this._textBuilder.resetWithEmpty();
        this._currToken = 9;
        return 9;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final int handlePrologDeclStart(boolean z) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        int i2 = i + 1;
        this._inputPtr = i2;
        char c = cArr[i];
        if (c == '-') {
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            c = cArr2[i3];
            if (c == '-') {
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishComment();
                }
                this._currToken = 5;
                return 5;
            }
        } else if (c == 'D' && z) {
            handleDtdStart();
            if (this._cfgLazyParsing || !this._tokenIncomplete) {
                return 11;
            }
            finishDTD(true);
            this._tokenIncomplete = false;
            return 11;
        }
        this._tokenIncomplete = true;
        this._currToken = 4;
        reportPrologUnexpChar(z, c, " (expected '-' for COMMENT)");
        return this._currToken;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int handleDtdStart() throws XMLStreamException {
        matchAsciiKeyword("DOCTYPE");
        this._tokenName = parsePName(skipInternalWs(true, "after DOCTYPE keyword, before root name"));
        char cSkipInternalWs = skipInternalWs(false, null);
        if (cSkipInternalWs == 'P') {
            matchAsciiKeyword("PUBLIC");
            this._publicId = parsePublicId(skipInternalWs(true, null));
            this._systemId = parseSystemId(skipInternalWs(true, null));
            cSkipInternalWs = skipInternalWs(false, null);
        } else if (cSkipInternalWs == 'S') {
            matchAsciiKeyword("SYSTEM");
            char cSkipInternalWs2 = skipInternalWs(true, null);
            this._publicId = null;
            this._systemId = parseSystemId(cSkipInternalWs2);
            cSkipInternalWs = skipInternalWs(false, null);
        } else {
            this._systemId = null;
            this._publicId = null;
        }
        if (cSkipInternalWs == '>') {
            this._tokenIncomplete = false;
            this._currToken = 11;
            return 11;
        }
        if (cSkipInternalWs != '[') {
            reportTreeUnexpChar(cSkipInternalWs, this._systemId != null ? " (expected '[' for the internal subset, or '>' to end DOCTYPE declaration)" : " (expected a 'PUBLIC' or 'SYSTEM' keyword, '[' for the internal subset, or '>' to end DOCTYPE declaration)");
        }
        this._tokenIncomplete = true;
        this._currToken = 11;
        return 11;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final int handleCommentOrCdataStart() throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        int i2 = i + 1;
        this._inputPtr = i2;
        char c = cArr[i];
        if (c == '-') {
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            char c2 = cArr2[i3];
            if (c2 != '-') {
                reportTreeUnexpChar(c2, " (expected '-' for COMMENT)");
            }
            if (this._cfgLazyParsing) {
                this._tokenIncomplete = true;
            } else {
                finishComment();
            }
            this._currToken = 5;
            return 5;
        }
        if (c == '[') {
            this._currToken = 12;
            for (int i4 = 0; i4 < 6; i4++) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                char c3 = cArr3[i5];
                if (c3 != "CDATA[".charAt(i4)) {
                    reportTreeUnexpChar(c3, " (expected '" + "CDATA[".charAt(i4) + "' for CDATA section)");
                }
            }
            if (this._cfgLazyParsing) {
                this._tokenIncomplete = true;
            } else {
                finishCData();
            }
            return 12;
        }
        reportTreeUnexpChar(c, " (expected either '-' for COMMENT or '[CDATA[' for CDATA section)");
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final int handlePIStart() throws XMLStreamException {
        this._currToken = 3;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        this._tokenName = parsePName(cArr[i]);
        String localName = this._tokenName.getLocalName();
        if (localName.length() == 3 && localName.equalsIgnoreCase("xml") && this._tokenName.getPrefix() == null) {
            reportInputProblem(ErrorConsts.ERR_WF_PI_XML_TARGET);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        char c = cArr2[i2];
        if (c <= ' ') {
            while (true) {
                if (c == '\n') {
                    markLF();
                } else if (c == '\r') {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr3 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    if (cArr3[i3] == '\n') {
                        this._inputPtr = i3 + 1;
                    }
                    markLF();
                } else if (c != ' ' && c != '\t') {
                    throwInvalidSpace(c);
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                c = cArr4[i4];
                if (c > ' ') {
                    break;
                }
                this._inputPtr = i4 + 1;
            }
            if (this._cfgLazyParsing) {
                this._tokenIncomplete = true;
            } else {
                finishPI();
            }
        } else {
            if (c != '?') {
                reportMissingPISpace(c);
            }
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr5 = this._inputBuffer;
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            char c2 = cArr5[i5];
            if (c2 != '>') {
                reportMissingPISpace(c2);
            }
            this._textBuilder.resetWithEmpty();
            this._tokenIncomplete = false;
        }
        return 3;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0023 A[SYNTHETIC] */
    protected final int handleCharEntity() throws XMLStreamException {
        int i;
        int i2;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        char c = cArr[i3];
        int i4 = 0;
        if (c == 'x') {
            while (true) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                char c2 = cArr2[i5];
                if (c2 == ';') {
                    break;
                }
                int i6 = i4 << 4;
                if (c2 > '9' || c2 < '0') {
                    if (c2 < 'a' || c2 > 'f') {
                        if (c2 < 'A' || c2 > 'F') {
                            throwUnexpectedChar(c2, "; expected a hex digit (0-9a-fA-F)");
                        } else {
                            i = c2 - 'A';
                        }
                        i4 = i6;
                        if (i4 > 1114111) {
                            reportEntityOverflow();
                        }
                    } else {
                        i = c2 - 'a';
                    }
                    i2 = i + 10;
                } else {
                    i2 = c2 - '0';
                }
                i6 += i2;
                i4 = i6;
                if (i4 > 1114111) {
                    reportEntityOverflow();
                }
            }
        } else {
            while (c != ';') {
                if (c > '9' || c < '0') {
                    throwUnexpectedChar(c, "; expected a decimal number");
                } else {
                    i4 = (i4 * 10) + (c - '0');
                    if (i4 > 1114111) {
                        reportEntityOverflow();
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                c = cArr3[i7];
            }
        }
        if (i4 >= 55296) {
            if (i4 < 57344) {
                reportInvalidXmlChar(i4);
            }
            if (i4 == 65534 || i4 == 65535) {
                reportInvalidXmlChar(i4);
            }
        } else if (i4 < 32 && i4 != 10 && i4 != 13 && i4 != 9 && (!this._xml11 || i4 == 0)) {
            reportInvalidXmlChar(i4);
        }
        return i4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    protected final int handleStartElement(char c) throws XMLStreamException {
        boolean zIsBound;
        boolean z;
        char c2;
        char c3;
        this._currToken = 1;
        this._currNsCount = 0;
        PName pName = parsePName(c);
        String prefix = pName.getPrefix();
        if (prefix == null) {
            zIsBound = true;
        } else {
            pName = bindName(pName, prefix);
            zIsBound = pName.isBound();
        }
        this._tokenName = pName;
        this._currElem = new ElementScope(pName, this._currElem);
        int iCollectValue = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c4 = cArr[i];
            if (c4 <= ' ') {
                do {
                    if (c4 == '\n') {
                        markLF();
                    } else if (c4 == '\r') {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        char[] cArr2 = this._inputBuffer;
                        int i2 = this._inputPtr;
                        if (cArr2[i2] == '\n') {
                            this._inputPtr = i2 + 1;
                        }
                        markLF();
                    } else if (c4 != ' ' && c4 != '\t') {
                        throwInvalidSpace(c4);
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr3 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    c4 = cArr3[i3];
                } while (c4 <= ' ');
            } else if (c4 != '/' && c4 != '>') {
                throwUnexpectedChar(c4, " expected space, or '>' or \"/>\"");
            }
            if (c4 == '/') {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                char c5 = cArr4[i4];
                if (c5 != '>') {
                    throwUnexpectedChar(c5, " expected '>'");
                }
                this._isEmptyTag = true;
                break;
            }
            if (c4 == '>') {
                this._isEmptyTag = false;
                break;
            }
            if (c4 == '<') {
                reportInputProblem("Unexpected '<' character in element (missing closing '>'?)");
            }
            PName pName2 = parsePName(c4);
            String prefix2 = pName2.getPrefix();
            if (prefix2 == null) {
                if (pName2.getLocalName() == "xmlns") {
                    z = true;
                } else {
                    z = false;
                }
            } else if (prefix2 == "xmlns") {
                z = true;
            } else {
                pName2 = bindName(pName2, prefix2);
                if (zIsBound) {
                    zIsBound = pName2.isBound();
                }
                z = false;
            }
            while (true) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                int i6 = i5 + 1;
                this._inputPtr = i6;
                c2 = cArr5[i5];
                if (c2 > ' ') {
                    break;
                }
                if (c2 == '\n') {
                    markLF();
                } else if (c2 == '\r') {
                    if (i6 >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr6 = this._inputBuffer;
                    int i7 = this._inputPtr;
                    if (cArr6[i7] == '\n') {
                        this._inputPtr = i7 + 1;
                    }
                    markLF();
                } else if (c2 != ' ' && c2 != '\t') {
                    throwInvalidSpace(c2);
                }
            }
            if (c2 != '=') {
                throwUnexpectedChar(c2, " expected '='");
            }
            while (true) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr7 = this._inputBuffer;
                int i8 = this._inputPtr;
                int i9 = i8 + 1;
                this._inputPtr = i9;
                c3 = cArr7[i8];
                if (c3 > ' ') {
                    break;
                }
                if (c3 == '\n') {
                    markLF();
                } else if (c3 == '\r') {
                    if (i9 >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr8 = this._inputBuffer;
                    int i10 = this._inputPtr;
                    if (cArr8[i10] == '\n') {
                        this._inputPtr = i10 + 1;
                    }
                    markLF();
                } else if (c3 != ' ' && c3 != '\t') {
                    throwInvalidSpace(c3);
                }
            }
            if (c3 != '\"' && c3 != '\'') {
                throwUnexpectedChar(c3, " Expected a quote");
            }
            if (z) {
                handleNsDeclaration(pName2, c3);
                this._currNsCount++;
            } else {
                iCollectValue = collectValue(iCollectValue, c3, pName2);
            }
        }
        int iFinishLastValue = this._attrCollector.finishLastValue(iCollectValue);
        if (iFinishLastValue < 0) {
            iFinishLastValue = this._attrCollector.getCount();
            reportInputProblem(this._attrCollector.getErrorMsg());
        }
        this._attrCount = iFinishLastValue;
        this._depth++;
        if (!zIsBound) {
            if (!pName.isBound()) {
                reportUnboundPrefix(this._tokenName, false);
            }
            int i11 = this._attrCount;
            for (int i12 = 0; i12 < i11; i12++) {
                PName name = this._attrCollector.getName(i12);
                if (!name.isBound()) {
                    reportUnboundPrefix(name, true);
                }
            }
        }
        return 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x008a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x0089 A[SYNTHETIC] */
    private final int collectValue(int i, char c, PName pName) throws XMLStreamException {
        int i2;
        int i3;
        char[] cArr;
        int i4;
        int iHandleEntityInText;
        int i5;
        char[] cArrStartNewValue = this._attrCollector.startNewValue(pName, i);
        int[] iArr = sCharTypes.ATTR_CHARS;
        while (true) {
            int i6 = this._inputPtr;
            if (i6 >= this._inputEnd) {
                loadMoreGuaranteed();
                i6 = this._inputPtr;
            }
            if (i >= cArrStartNewValue.length) {
                cArrStartNewValue = this._attrCollector.valueBufferFull();
            }
            int i7 = this._inputEnd;
            int length = (cArrStartNewValue.length - i) + i6;
            if (length < i7) {
                i7 = length;
            }
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char cHandleInvalidXmlChar = this._inputBuffer[i6];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i8;
                            if (cHandleInvalidXmlChar <= 255) {
                                i3 = iArr[cHandleInvalidXmlChar];
                                if (i3 != 1) {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                } else {
                                    if (i3 != 2) {
                                        if (i3 != 3) {
                                            if (i3 != 14) {
                                                switch (i3) {
                                                    case 9:
                                                        throwUnexpectedChar(cHandleInvalidXmlChar, "'<' not allowed in attribute value");
                                                    case 10:
                                                        iHandleEntityInText = handleEntityInText(false);
                                                        if (iHandleEntityInText == 0) {
                                                            reportUnexpandedEntityInAttr(pName, false);
                                                        }
                                                        if ((iHandleEntityInText >> 16) != 0) {
                                                            int i9 = iHandleEntityInText - 65536;
                                                            i5 = i + 1;
                                                            cArrStartNewValue[i] = (char) ((i9 >> 10) | 55296);
                                                            iHandleEntityInText = 56320 | (i9 & 1023);
                                                            if (i5 >= cArrStartNewValue.length) {
                                                                cArrStartNewValue = this._attrCollector.valueBufferFull();
                                                            }
                                                            i = i5;
                                                        }
                                                        cHandleInvalidXmlChar = (char) iHandleEntityInText;
                                                        break;
                                                }
                                            } else if (cHandleInvalidXmlChar == c) {
                                                return i;
                                            }
                                        }
                                        cHandleInvalidXmlChar = XmlConsts.CHAR_SPACE;
                                    }
                                    markLF();
                                    cHandleInvalidXmlChar = XmlConsts.CHAR_SPACE;
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                cArr = this._inputBuffer;
                                i4 = this._inputPtr;
                                if (cArr[i4] == '\n') {
                                    this._inputPtr = i4 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = XmlConsts.CHAR_SPACE;
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i2 = i + 1;
                                    cArrStartNewValue[i] = cHandleInvalidXmlChar;
                                    if (i2 >= cArrStartNewValue.length) {
                                        cArrStartNewValue = this._attrCollector.valueBufferFull();
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                    i = i2;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            cArrStartNewValue[i] = cHandleInvalidXmlChar;
                            i++;
                        } else {
                            cArrStartNewValue[i] = cHandleInvalidXmlChar;
                            i++;
                            i6 = i8;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i8;
                        if (cHandleInvalidXmlChar <= 255) {
                            i3 = iArr[cHandleInvalidXmlChar];
                            if (i3 != 1) {
                                handleInvalidXmlChar(cHandleInvalidXmlChar);
                            } else {
                                if (i3 != 2) {
                                    if (i3 != 3) {
                                        if (i3 != 14) {
                                            switch (i3) {
                                                case 9:
                                                    throwUnexpectedChar(cHandleInvalidXmlChar, "'<' not allowed in attribute value");
                                                case 10:
                                                    iHandleEntityInText = handleEntityInText(false);
                                                    if (iHandleEntityInText == 0) {
                                                        reportUnexpandedEntityInAttr(pName, false);
                                                    }
                                                    if ((iHandleEntityInText >> 16) != 0) {
                                                        int i10 = iHandleEntityInText - 65536;
                                                        i5 = i + 1;
                                                        cArrStartNewValue[i] = (char) ((i10 >> 10) | 55296);
                                                        iHandleEntityInText = 56320 | (i10 & 1023);
                                                        if (i5 >= cArrStartNewValue.length) {
                                                            cArrStartNewValue = this._attrCollector.valueBufferFull();
                                                        }
                                                        i = i5;
                                                    }
                                                    cHandleInvalidXmlChar = (char) iHandleEntityInText;
                                                    break;
                                            }
                                        } else if (cHandleInvalidXmlChar == c) {
                                            return i;
                                        }
                                    }
                                    cHandleInvalidXmlChar = XmlConsts.CHAR_SPACE;
                                }
                                markLF();
                                cHandleInvalidXmlChar = XmlConsts.CHAR_SPACE;
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            cArr = this._inputBuffer;
                            i4 = this._inputPtr;
                            if (cArr[i4] == '\n') {
                                this._inputPtr = i4 + 1;
                            }
                            markLF();
                            cHandleInvalidXmlChar = XmlConsts.CHAR_SPACE;
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i2 = i + 1;
                                cArrStartNewValue[i] = cHandleInvalidXmlChar;
                                if (i2 >= cArrStartNewValue.length) {
                                    cArrStartNewValue = this._attrCollector.valueBufferFull();
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                                i = i2;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        cArrStartNewValue[i] = cHandleInvalidXmlChar;
                        i++;
                    } else {
                        cArrStartNewValue[i] = cHandleInvalidXmlChar;
                        i++;
                        i6 = i8;
                    }
                } else {
                    this._inputPtr = i6;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void handleNsDeclaration(PName pName, char c) throws XMLStreamException {
        char[] cArrGrowArrayBy = this._nameBuffer;
        int i = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            int i3 = i2 + 1;
            this._inputPtr = i3;
            char c2 = cArr[i2];
            if (c2 == c) {
                break;
            }
            if (c2 == '&') {
                int iHandleEntityInText = handleEntityInText(false);
                if (iHandleEntityInText == 0) {
                    reportUnexpandedEntityInAttr(pName, true);
                }
                if ((iHandleEntityInText >> 16) != 0) {
                    if (i >= cArrGrowArrayBy.length) {
                        cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                        this._nameBuffer = cArrGrowArrayBy;
                    }
                    int i4 = iHandleEntityInText - 65536;
                    cArrGrowArrayBy[i] = (char) ((i4 >> 10) | 55296);
                    iHandleEntityInText = 56320 | (i4 & 1023);
                    i++;
                }
                c2 = (char) iHandleEntityInText;
            } else if (c2 == '<') {
                throwUnexpectedChar(c2, "'<' not allowed in attribute value");
            } else if (c2 < ' ') {
                if (c2 == '\n') {
                    markLF();
                } else if (c2 == '\r') {
                    if (i3 >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr2 = this._inputBuffer;
                    int i5 = this._inputPtr;
                    if (cArr2[i5] == '\n') {
                        this._inputPtr = i5 + 1;
                    }
                    markLF();
                    c2 = '\n';
                } else if (c2 != '\t') {
                    throwInvalidSpace(c2);
                }
            }
            if (i >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
            }
            cArrGrowArrayBy[i] = c2;
            i++;
        }
        if (i == 0) {
            bindNs(pName, FinalChip.BSP_PLATFORM_Null);
        } else {
            bindNs(pName, this._config.canonicalizeURI(cArrGrowArrayBy, i));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final int handleEndElement() throws XMLStreamException {
        this._depth--;
        this._currToken = 2;
        this._tokenName = this._currElem.getName();
        String prefixedName = this._tokenName.getPrefixedName();
        int length = prefixedName.length();
        int i = 0;
        do {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            if (cArr[i2] != prefixedName.charAt(i)) {
                reportUnexpectedEndTag(prefixedName);
            }
            i++;
        } while (i < length);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr2 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        char cSkipInternalWs = cArr2[i3];
        if (cSkipInternalWs <= ' ') {
            cSkipInternalWs = skipInternalWs(false, null);
        } else if (cSkipInternalWs != '>' && (cSkipInternalWs == ':' || XmlChars.is10NameChar(cSkipInternalWs))) {
            reportUnexpectedEndTag(prefixedName);
        }
        if (cSkipInternalWs != '>') {
            throwUnexpectedChar(cSkipInternalWs, " expected space or closing '>'");
        }
        return 2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final int handleEntityInText(boolean z) throws XMLStreamException {
        String str;
        boolean zIs10NameChar;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        int i2 = i + 1;
        this._inputPtr = i2;
        char cHandleInvalidXmlChar = cArr[i];
        if (cHandleInvalidXmlChar == '#') {
            return handleCharEntity();
        }
        if (cHandleInvalidXmlChar == 'a') {
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            int i4 = i3 + 1;
            this._inputPtr = i4;
            cHandleInvalidXmlChar = cArr2[i3];
            if (cHandleInvalidXmlChar == 'm') {
                if (i4 >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i5 = this._inputPtr;
                int i6 = i5 + 1;
                this._inputPtr = i6;
                cHandleInvalidXmlChar = cArr3[i5];
                if (cHandleInvalidXmlChar == 'p') {
                    if (i6 >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr4 = this._inputBuffer;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    cHandleInvalidXmlChar = cArr4[i7];
                    if (cHandleInvalidXmlChar == ';') {
                        return 38;
                    }
                    str = "amp";
                } else {
                    str = "am";
                }
            } else if (cHandleInvalidXmlChar == 'p') {
                if (i4 >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i8 = this._inputPtr;
                int i9 = i8 + 1;
                this._inputPtr = i9;
                cHandleInvalidXmlChar = cArr5[i8];
                if (cHandleInvalidXmlChar == 'o') {
                    if (i9 >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr6 = this._inputBuffer;
                    int i10 = this._inputPtr;
                    int i11 = i10 + 1;
                    this._inputPtr = i11;
                    cHandleInvalidXmlChar = cArr6[i10];
                    if (cHandleInvalidXmlChar == 's') {
                        if (i11 >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        char[] cArr7 = this._inputBuffer;
                        int i12 = this._inputPtr;
                        this._inputPtr = i12 + 1;
                        cHandleInvalidXmlChar = cArr7[i12];
                        if (cHandleInvalidXmlChar == ';') {
                            return 39;
                        }
                        str = "apos";
                    } else {
                        str = "apo";
                    }
                } else {
                    str = "ap";
                }
            } else {
                str = "a";
            }
        } else if (cHandleInvalidXmlChar == 'l') {
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr8 = this._inputBuffer;
            int i13 = this._inputPtr;
            int i14 = i13 + 1;
            this._inputPtr = i14;
            cHandleInvalidXmlChar = cArr8[i13];
            if (cHandleInvalidXmlChar == 't') {
                if (i14 >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr9 = this._inputBuffer;
                int i15 = this._inputPtr;
                this._inputPtr = i15 + 1;
                cHandleInvalidXmlChar = cArr9[i15];
                if (cHandleInvalidXmlChar == ';') {
                    return 60;
                }
                str = "lt";
            } else {
                str = "l";
            }
        } else if (cHandleInvalidXmlChar == 'g') {
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr10 = this._inputBuffer;
            int i16 = this._inputPtr;
            int i17 = i16 + 1;
            this._inputPtr = i17;
            cHandleInvalidXmlChar = cArr10[i16];
            if (cHandleInvalidXmlChar == 't') {
                if (i17 >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr11 = this._inputBuffer;
                int i18 = this._inputPtr;
                this._inputPtr = i18 + 1;
                cHandleInvalidXmlChar = cArr11[i18];
                if (cHandleInvalidXmlChar == ';') {
                    return 62;
                }
                str = "gt";
            } else {
                str = "g";
            }
        } else if (cHandleInvalidXmlChar == 'q') {
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr12 = this._inputBuffer;
            int i19 = this._inputPtr;
            int i20 = i19 + 1;
            this._inputPtr = i20;
            cHandleInvalidXmlChar = cArr12[i19];
            if (cHandleInvalidXmlChar == 'u') {
                if (i20 >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr13 = this._inputBuffer;
                int i21 = this._inputPtr;
                int i22 = i21 + 1;
                this._inputPtr = i22;
                cHandleInvalidXmlChar = cArr13[i21];
                if (cHandleInvalidXmlChar == 'o') {
                    if (i22 >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr14 = this._inputBuffer;
                    int i23 = this._inputPtr;
                    int i24 = i23 + 1;
                    this._inputPtr = i24;
                    cHandleInvalidXmlChar = cArr14[i23];
                    if (cHandleInvalidXmlChar == 't') {
                        if (i24 >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        char[] cArr15 = this._inputBuffer;
                        int i25 = this._inputPtr;
                        this._inputPtr = i25 + 1;
                        cHandleInvalidXmlChar = cArr15[i25];
                        if (cHandleInvalidXmlChar == ';') {
                            return 34;
                        }
                        str = "quot";
                    } else {
                        str = "quo";
                    }
                } else {
                    str = "qu";
                }
            } else {
                str = "q";
            }
        } else {
            str = FinalChip.BSP_PLATFORM_Null;
        }
        int[] iArr = sCharTypes.NAME_CHARS;
        char[] cArrGrowArrayBy = this._nameBuffer;
        int length = str.length();
        int i26 = 0;
        while (i26 < length) {
            cArrGrowArrayBy[i26] = str.charAt(i26);
            i26++;
        }
        while (cHandleInvalidXmlChar != ';') {
            boolean z2 = true;
            if (cHandleInvalidXmlChar <= 255) {
                z2 = (r1 = iArr[cHandleInvalidXmlChar]) != 0 ? false : false;
            } else if (cHandleInvalidXmlChar < 57344) {
                int iDecodeSurrogate = decodeSurrogate(cHandleInvalidXmlChar);
                if (i26 >= cArrGrowArrayBy.length) {
                    cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                    this._nameBuffer = cArrGrowArrayBy;
                }
                int i27 = i26 + 1;
                cArrGrowArrayBy[i26] = cHandleInvalidXmlChar;
                cHandleInvalidXmlChar = this._inputBuffer[this._inputPtr - 1];
                if (i27 == 0) {
                    zIs10NameChar = XmlChars.is10NameStartChar(iDecodeSurrogate);
                } else {
                    zIs10NameChar = XmlChars.is10NameChar(iDecodeSurrogate);
                }
                z2 = zIs10NameChar;
                i26 = i27;
            } else if (cHandleInvalidXmlChar >= 65534) {
                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
            }
            if (!z2) {
                reportInvalidNameChar(cHandleInvalidXmlChar, i26);
            }
            if (i26 >= cArrGrowArrayBy.length) {
                char[] cArrGrowArrayBy2 = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy2;
                cArrGrowArrayBy = cArrGrowArrayBy2;
            }
            int i28 = i26 + 1;
            cArrGrowArrayBy[i26] = cHandleInvalidXmlChar;
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr16 = this._inputBuffer;
            int i29 = this._inputPtr;
            this._inputPtr = i29 + 1;
            cHandleInvalidXmlChar = cArr16[i29];
            i26 = i28;
        }
        String str2 = new String(cArrGrowArrayBy, 0, i26);
        this._tokenName = new PNameC(str2, null, str2, 0);
        if (this._config.willExpandEntities()) {
            reportInputProblem("General entity reference (&" + str2 + ";) encountered in entity expanding mode: operation not (yet) implemented");
        }
        if (z) {
            reportInputProblem("General entity reference (&" + str2 + ";) encountered in attribute value, in non-entity-expanding mode: no way to handle it");
        }
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0045  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:44:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0097  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x0069 A[EDGE_INSN: B:67:0x0069->B:35:0x0069 BREAK  A[LOOP:0: B:3:0x000e->B:70:0x000e], SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishComment() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        char[] cArr;
        int i4;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr2 = this._inputBuffer;
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        int i5 = 0;
        while (true) {
            int i6 = this._inputPtr;
            if (i6 >= this._inputEnd) {
                loadMoreGuaranteed();
                i6 = this._inputPtr;
            }
            if (i5 >= cArrResetWithEmpty.length) {
                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                i5 = 0;
            }
            int i7 = this._inputEnd;
            int length = (cArrResetWithEmpty.length - i5) + i6;
            if (length < i7) {
                i7 = length;
            }
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char cHandleInvalidXmlChar = cArr2[i6];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i8;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                } else if (i2 != 2) {
                                    if (i2 != 3) {
                                        markLF();
                                    } else if (i2 == 13) {
                                        if (this._inputPtr >= this._inputEnd) {
                                            loadMoreGuaranteed();
                                        }
                                        cArr = this._inputBuffer;
                                        i4 = this._inputPtr;
                                        if (cArr[i4] == '-') {
                                            break;
                                        }
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i3 = this._inputPtr;
                                if (cArr2[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i = i5 + 1;
                                    cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                                    if (i >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i5 = 0;
                                    } else {
                                        i5 = i;
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                            i5++;
                        } else {
                            cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                            i6 = i8;
                            i5++;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i8;
                        if (cHandleInvalidXmlChar <= 255) {
                            i2 = iArr[cHandleInvalidXmlChar];
                            if (i2 != 1) {
                                handleInvalidXmlChar(cHandleInvalidXmlChar);
                            } else if (i2 != 2) {
                                if (i2 != 3) {
                                    markLF();
                                } else if (i2 == 13) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    cArr = this._inputBuffer;
                                    i4 = this._inputPtr;
                                    if (cArr[i4] == '-') {
                                        break;
                                        break;
                                    }
                                }
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            i3 = this._inputPtr;
                            if (cArr2[i3] == '\n') {
                                this._inputPtr = i3 + 1;
                            }
                            markLF();
                            cHandleInvalidXmlChar = '\n';
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i = i5 + 1;
                                cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                                if (i >= cArrResetWithEmpty.length) {
                                    cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                    i5 = 0;
                                } else {
                                    i5 = i;
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                        i5++;
                    } else {
                        cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                        i6 = i8;
                        i5++;
                    }
                } else {
                    this._inputPtr = i6;
                }
            }
        }
        int i9 = i4 + 1;
        this._inputPtr = i9;
        if (i9 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr3 = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        if (cArr3[i10] != '>') {
            reportDoubleHyphenInComments();
        }
        this._textBuilder.setCurrentLength(i5);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0045  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:53:0x00af  */
    /* JADX WARN: Code duplicated, block: B:58:0x0065 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishPI() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        char[] cArr;
        int i4;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr2 = this._inputBuffer;
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        int i5 = 0;
        while (true) {
            int i6 = this._inputPtr;
            if (i6 >= this._inputEnd) {
                loadMoreGuaranteed();
                i6 = this._inputPtr;
            }
            if (i5 >= cArrResetWithEmpty.length) {
                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                i5 = 0;
            }
            int i7 = this._inputEnd;
            int length = (cArrResetWithEmpty.length - i5) + i6;
            if (length < i7) {
                i7 = length;
            }
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char cHandleInvalidXmlChar = cArr2[i6];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i8;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 2) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    i3 = this._inputPtr;
                                    if (cArr2[i3] == '\n') {
                                        this._inputPtr = i3 + 1;
                                    }
                                    markLF();
                                    cHandleInvalidXmlChar = '\n';
                                } else if (i2 != 3) {
                                    markLF();
                                } else if (i2 == 12) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    cArr = this._inputBuffer;
                                    i4 = this._inputPtr;
                                    if (cArr[i4] == '>') {
                                        this._inputPtr = i4 + 1;
                                        this._textBuilder.setCurrentLength(i5);
                                        return;
                                    }
                                }
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i = i5 + 1;
                                    cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                                    if (i >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i5 = 0;
                                    } else {
                                        i5 = i;
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                            i5++;
                        } else {
                            cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                            i6 = i8;
                            i5++;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i8;
                        if (cHandleInvalidXmlChar <= 255) {
                            i2 = iArr[cHandleInvalidXmlChar];
                            if (i2 != 2) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i3 = this._inputPtr;
                                if (cArr2[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (i2 != 3) {
                                markLF();
                            } else if (i2 == 12) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                cArr = this._inputBuffer;
                                i4 = this._inputPtr;
                                if (cArr[i4] == '>') {
                                    this._inputPtr = i4 + 1;
                                    this._textBuilder.setCurrentLength(i5);
                                    return;
                                }
                            }
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i = i5 + 1;
                                cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                                if (i >= cArrResetWithEmpty.length) {
                                    cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                    i5 = 0;
                                } else {
                                    i5 = i;
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                        i5++;
                    } else {
                        cArrResetWithEmpty[i5] = cHandleInvalidXmlChar;
                        i6 = i8;
                        i5++;
                    }
                } else {
                    this._inputPtr = i6;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0056  */
    /* JADX WARN: Code duplicated, block: B:33:0x0059  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x0059. Please report as an issue. */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishDTD(boolean z) throws XMLStreamException {
        int i;
        int i2;
        char[] cArr;
        int i3;
        char cSkipInternalWs;
        char[] cArrResetWithEmpty = z ? this._textBuilder.resetWithEmpty() : null;
        int[] iArr = sCharTypes.DTD_CHARS;
        int i4 = 0;
        char c = 0;
        boolean z2 = false;
        while (true) {
            int i5 = this._inputPtr;
            if (i5 >= this._inputEnd) {
                loadMoreGuaranteed();
                i5 = this._inputPtr;
            }
            int i6 = this._inputEnd;
            if (cArrResetWithEmpty != null) {
                if (i4 >= cArrResetWithEmpty.length) {
                    cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                    i4 = 0;
                }
                int length = (cArrResetWithEmpty.length - i4) + i5;
                if (length < i6) {
                    i6 = length;
                }
            }
            while (true) {
                if (i5 < i6) {
                    int i7 = i5 + 1;
                    char cHandleInvalidXmlChar = this._inputBuffer[i5];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i7;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                } else if (i2 != 2) {
                                    if (i2 != 3) {
                                        switch (i2) {
                                            case 8:
                                                if (c == 0) {
                                                    c = cHandleInvalidXmlChar;
                                                } else if (c == cHandleInvalidXmlChar) {
                                                    c = 0;
                                                }
                                                break;
                                            case 9:
                                                if (!z2) {
                                                    z2 = true;
                                                }
                                                break;
                                            case 10:
                                                if (c == 0) {
                                                    z2 = false;
                                                }
                                                break;
                                        }
                                        if (!z2 && c == 0) {
                                            if (cArrResetWithEmpty != null) {
                                                this._textBuilder.setCurrentLength(i4);
                                            }
                                            cSkipInternalWs = skipInternalWs(false, null);
                                            if (cSkipInternalWs != '>') {
                                                throwUnexpectedChar(cSkipInternalWs, " expected '>' after the internal subset");
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        markLF();
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                cArr = this._inputBuffer;
                                i3 = this._inputPtr;
                                if (cArr[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    if (cArrResetWithEmpty != null) {
                                        i = i4 + 1;
                                        cArrResetWithEmpty[i4] = cHandleInvalidXmlChar;
                                        if (i >= cArrResetWithEmpty.length) {
                                            cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                            i4 = 0;
                                        } else {
                                            i4 = i;
                                        }
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            if (cArrResetWithEmpty != null) {
                                cArrResetWithEmpty[i4] = cHandleInvalidXmlChar;
                                i4++;
                            }
                        }
                        if (cArrResetWithEmpty != null) {
                            cArrResetWithEmpty[i4] = cHandleInvalidXmlChar;
                            i4++;
                        }
                        i5 = i7;
                    } else {
                        if (cHandleInvalidXmlChar >= 55296) {
                            this._inputPtr = i7;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                } else if (i2 != 2) {
                                    if (i2 != 3) {
                                        switch (i2) {
                                            case 8:
                                                if (c == 0) {
                                                    c = cHandleInvalidXmlChar;
                                                } else if (c == cHandleInvalidXmlChar) {
                                                    c = 0;
                                                }
                                                break;
                                            case 9:
                                                if (!z2) {
                                                    z2 = true;
                                                }
                                                break;
                                            case 10:
                                                if (c == 0) {
                                                    z2 = false;
                                                }
                                                break;
                                        }
                                        if (!z2) {
                                            if (cArrResetWithEmpty != null) {
                                                this._textBuilder.setCurrentLength(i4);
                                            }
                                            cSkipInternalWs = skipInternalWs(false, null);
                                            if (cSkipInternalWs != '>') {
                                                throwUnexpectedChar(cSkipInternalWs, " expected '>' after the internal subset");
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        markLF();
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                cArr = this._inputBuffer;
                                i3 = this._inputPtr;
                                if (cArr[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                    if (cArrResetWithEmpty != null) {
                                        i = i4 + 1;
                                        cArrResetWithEmpty[i4] = cHandleInvalidXmlChar;
                                        if (i >= cArrResetWithEmpty.length) {
                                            cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                            i4 = 0;
                                        } else {
                                            i4 = i;
                                        }
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate2;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            if (cArrResetWithEmpty != null) {
                                cArrResetWithEmpty[i4] = cHandleInvalidXmlChar;
                                i4++;
                            }
                        }
                        if (cArrResetWithEmpty != null) {
                            cArrResetWithEmpty[i4] = cHandleInvalidXmlChar;
                            i4++;
                        }
                        i5 = i7;
                    }
                } else {
                    this._inputPtr = i5;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0045  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2 A[LOOP:2: B:31:0x0057->B:55:0x00a2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x008c A[EDGE_INSN: B:82:0x008c->B:49:0x008c BREAK  A[LOOP:0: B:3:0x000e->B:85:0x000e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x006a A[EDGE_INSN: B:91:0x006a->B:36:0x006a BREAK  A[LOOP:2: B:31:0x0057->B:55:0x00a2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0080 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishCData() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        boolean z;
        int i6;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr = this._inputBuffer;
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        int i7 = 0;
        while (true) {
            int i8 = this._inputPtr;
            if (i8 >= this._inputEnd) {
                loadMoreGuaranteed();
                i8 = this._inputPtr;
            }
            if (i7 >= cArrResetWithEmpty.length) {
                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                i7 = 0;
            }
            int i9 = this._inputEnd;
            int length = (cArrResetWithEmpty.length - i7) + i8;
            if (length < i9) {
                i9 = length;
            }
            while (true) {
                if (i8 < i9) {
                    int i10 = i8 + 1;
                    char cHandleInvalidXmlChar = cArr[i8];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i10;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                } else if (i2 != 2) {
                                    if (i2 != 3) {
                                        markLF();
                                    } else if (i2 == 11) {
                                        i4 = 0;
                                        while (true) {
                                            if (this._inputPtr >= this._inputEnd) {
                                                loadMoreGuaranteed();
                                            }
                                            char[] cArr2 = this._inputBuffer;
                                            i5 = this._inputPtr;
                                            c = cArr2[i5];
                                            if (c != ']') {
                                                break;
                                            }
                                            this._inputPtr = i5 + 1;
                                            i4++;
                                        }
                                        if (c == '>' || i4 < 1) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        if (z) {
                                            i4--;
                                        }
                                        while (i4 > 0) {
                                            i6 = i7 + 1;
                                            cArrResetWithEmpty[i7] = ']';
                                            if (i6 >= cArrResetWithEmpty.length) {
                                                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                                i7 = 0;
                                                i4--;
                                            } else {
                                                i7 = i6;
                                                i4--;
                                            }
                                        }
                                        if (z) {
                                            break;
                                        }
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i3 = this._inputPtr;
                                if (cArr[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i = i7 + 1;
                                    cArrResetWithEmpty[i7] = cHandleInvalidXmlChar;
                                    if (i >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i7 = 0;
                                    } else {
                                        i7 = i;
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            cArrResetWithEmpty[i7] = cHandleInvalidXmlChar;
                            i7++;
                        } else {
                            cArrResetWithEmpty[i7] = cHandleInvalidXmlChar;
                            i8 = i10;
                            i7++;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i10;
                        if (cHandleInvalidXmlChar <= 255) {
                            i2 = iArr[cHandleInvalidXmlChar];
                            if (i2 != 1) {
                                handleInvalidXmlChar(cHandleInvalidXmlChar);
                            } else if (i2 != 2) {
                                if (i2 != 3) {
                                    markLF();
                                } else if (i2 == 11) {
                                    i4 = 0;
                                    while (true) {
                                        if (this._inputPtr >= this._inputEnd) {
                                            loadMoreGuaranteed();
                                        }
                                        char[] cArr3 = this._inputBuffer;
                                        i5 = this._inputPtr;
                                        c = cArr3[i5];
                                        if (c != ']') {
                                            break;
                                            break;
                                        } else {
                                            this._inputPtr = i5 + 1;
                                            i4++;
                                        }
                                    }
                                    if (c == '>') {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        i4--;
                                    }
                                    while (i4 > 0) {
                                        i6 = i7 + 1;
                                        cArrResetWithEmpty[i7] = ']';
                                        if (i6 >= cArrResetWithEmpty.length) {
                                            cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                            i7 = 0;
                                            i4--;
                                        } else {
                                            i7 = i6;
                                            i4--;
                                        }
                                    }
                                    if (z) {
                                        break;
                                        break;
                                    }
                                }
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            i3 = this._inputPtr;
                            if (cArr[i3] == '\n') {
                                this._inputPtr = i3 + 1;
                            }
                            markLF();
                            cHandleInvalidXmlChar = '\n';
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i = i7 + 1;
                                cArrResetWithEmpty[i7] = cHandleInvalidXmlChar;
                                if (i >= cArrResetWithEmpty.length) {
                                    cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                    i7 = 0;
                                } else {
                                    i7 = i;
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        cArrResetWithEmpty[i7] = cHandleInvalidXmlChar;
                        i7++;
                    } else {
                        cArrResetWithEmpty[i7] = cHandleInvalidXmlChar;
                        i8 = i10;
                        i7++;
                    }
                } else {
                    this._inputPtr = i8;
                }
            }
        }
        this._inputPtr++;
        this._textBuilder.setCurrentLength(i7);
        if (!this._cfgCoalescing || this._entityPending) {
            return;
        }
        finishCoalescedText();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0152  */
    /* JADX WARN: Code duplicated, block: B:105:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:45:0x0099  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc A[LOOP:2: B:46:0x009a->B:62:0x00cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:81:0x0110  */
    /* JADX WARN: Code duplicated, block: B:82:0x0114  */
    /* JADX WARN: Code duplicated, block: B:85:0x011d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0126  */
    /* JADX WARN: Code duplicated, block: B:90:0x0130  */
    /* JADX WARN: Code duplicated, block: B:91:0x0132  */
    /* JADX WARN: Code duplicated, block: B:93:0x0137  */
    /* JADX WARN: Code duplicated, block: B:95:0x0142  */
    /* JADX WARN: Code duplicated, block: B:96:0x014a  */
    /* JADX WARN: Code duplicated, block: B:98:0x014d  */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishCharacters() throws XMLStreamException {
        int iCheckInTreeIndentation;
        char[] bufferWithoutReset;
        int i;
        int i2;
        int i3;
        int iHandleEntityInText;
        int i4;
        int i5;
        int i6;
        char c;
        int i7;
        int i8;
        int i9 = this.mTmpChar;
        if (i9 < 0) {
            int i10 = -i9;
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            if ((i10 >> 16) != 0) {
                int i11 = i10 - 65536;
                bufferWithoutReset[0] = (char) ((i11 >> 10) | 55296);
                i10 = (i11 & 1023) | 56320;
                i8 = 1;
            } else {
                i8 = 0;
            }
            iCheckInTreeIndentation = i8 + 1;
            bufferWithoutReset[i8] = (char) i10;
        } else if (i9 == 13 || i9 == 10) {
            this._inputPtr++;
            iCheckInTreeIndentation = checkInTreeIndentation((char) i9);
            if (iCheckInTreeIndentation < 0) {
                return;
            } else {
                bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
            }
        } else {
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            iCheckInTreeIndentation = 0;
        }
        int[] iArr = sCharTypes.TEXT_CHARS;
        char[] cArr = this._inputBuffer;
        while (true) {
            int i12 = this._inputPtr;
            if (i12 >= this._inputEnd) {
                loadMoreGuaranteed();
                i12 = this._inputPtr;
            }
            if (iCheckInTreeIndentation >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                iCheckInTreeIndentation = 0;
            }
            int i13 = this._inputEnd;
            int length = (bufferWithoutReset.length - iCheckInTreeIndentation) + i12;
            if (length < i13) {
                i13 = length;
            }
            while (true) {
                if (i12 < i13) {
                    int i14 = i12 + 1;
                    char cHandleInvalidXmlChar = cArr[i12];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i14;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        if (i2 != 3) {
                                            markLF();
                                        } else {
                                            switch (i2) {
                                                case 9:
                                                    this._inputPtr--;
                                                    break;
                                                case 10:
                                                    iHandleEntityInText = handleEntityInText(false);
                                                    if (iHandleEntityInText == 0) {
                                                        if ((iHandleEntityInText >> 16) != 0) {
                                                            int i15 = iHandleEntityInText - 65536;
                                                            i4 = iCheckInTreeIndentation + 1;
                                                            bufferWithoutReset[iCheckInTreeIndentation] = (char) ((i15 >> 10) | 55296);
                                                            if (i4 >= bufferWithoutReset.length) {
                                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                                iCheckInTreeIndentation = 0;
                                                            } else {
                                                                iCheckInTreeIndentation = i4;
                                                            }
                                                            iHandleEntityInText = (i15 & 1023) | 56320;
                                                        }
                                                        cHandleInvalidXmlChar = (char) iHandleEntityInText;
                                                    } else {
                                                        this._entityPending = true;
                                                    }
                                                    break;
                                                case 11:
                                                    i5 = 1;
                                                    while (true) {
                                                        if (this._inputPtr >= this._inputEnd) {
                                                            loadMoreGuaranteed();
                                                        }
                                                        i6 = this._inputPtr;
                                                        c = cArr[i6];
                                                        if (c != ']') {
                                                            if (c == '>' && i5 > 1) {
                                                                reportIllegalCDataEnd();
                                                            }
                                                            while (i5 > 1) {
                                                                i7 = iCheckInTreeIndentation + 1;
                                                                bufferWithoutReset[iCheckInTreeIndentation] = ']';
                                                                if (i7 >= bufferWithoutReset.length) {
                                                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                                    iCheckInTreeIndentation = 0;
                                                                } else {
                                                                    iCheckInTreeIndentation = i7;
                                                                }
                                                                i5--;
                                                            }
                                                            cHandleInvalidXmlChar = ']';
                                                        } else {
                                                            this._inputPtr = i6 + 1;
                                                            i5++;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                } else {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                                i3 = this._inputPtr;
                                if (i3 >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                    i3 = this._inputPtr;
                                }
                                if (cArr[i3] == '\n') {
                                    this._inputPtr++;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i = iCheckInTreeIndentation + 1;
                                    bufferWithoutReset[iCheckInTreeIndentation] = cHandleInvalidXmlChar;
                                    if (i >= bufferWithoutReset.length) {
                                        bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                        iCheckInTreeIndentation = 0;
                                    } else {
                                        iCheckInTreeIndentation = i;
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            bufferWithoutReset[iCheckInTreeIndentation] = cHandleInvalidXmlChar;
                            iCheckInTreeIndentation++;
                        } else {
                            bufferWithoutReset[iCheckInTreeIndentation] = cHandleInvalidXmlChar;
                            i12 = i14;
                            iCheckInTreeIndentation++;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i14;
                        if (cHandleInvalidXmlChar <= 255) {
                            i2 = iArr[cHandleInvalidXmlChar];
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        markLF();
                                    } else {
                                        switch (i2) {
                                            case 9:
                                                this._inputPtr--;
                                                break;
                                            case 10:
                                                iHandleEntityInText = handleEntityInText(false);
                                                if (iHandleEntityInText == 0) {
                                                    if ((iHandleEntityInText >> 16) != 0) {
                                                        int i16 = iHandleEntityInText - 65536;
                                                        i4 = iCheckInTreeIndentation + 1;
                                                        bufferWithoutReset[iCheckInTreeIndentation] = (char) ((i16 >> 10) | 55296);
                                                        if (i4 >= bufferWithoutReset.length) {
                                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                            iCheckInTreeIndentation = 0;
                                                        } else {
                                                            iCheckInTreeIndentation = i4;
                                                        }
                                                        iHandleEntityInText = (i16 & 1023) | 56320;
                                                    }
                                                    cHandleInvalidXmlChar = (char) iHandleEntityInText;
                                                } else {
                                                    this._entityPending = true;
                                                }
                                                break;
                                            case 11:
                                                i5 = 1;
                                                while (true) {
                                                    if (this._inputPtr >= this._inputEnd) {
                                                        loadMoreGuaranteed();
                                                    }
                                                    i6 = this._inputPtr;
                                                    c = cArr[i6];
                                                    if (c != ']') {
                                                        if (c == '>') {
                                                            reportIllegalCDataEnd();
                                                        }
                                                        while (i5 > 1) {
                                                            i7 = iCheckInTreeIndentation + 1;
                                                            bufferWithoutReset[iCheckInTreeIndentation] = ']';
                                                            if (i7 >= bufferWithoutReset.length) {
                                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                                iCheckInTreeIndentation = 0;
                                                            } else {
                                                                iCheckInTreeIndentation = i7;
                                                            }
                                                            i5--;
                                                        }
                                                        cHandleInvalidXmlChar = ']';
                                                    } else {
                                                        this._inputPtr = i6 + 1;
                                                        i5++;
                                                    }
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                }
                            } else {
                                handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                            i3 = this._inputPtr;
                            if (i3 >= this._inputEnd) {
                                loadMoreGuaranteed();
                                i3 = this._inputPtr;
                            }
                            if (cArr[i3] == '\n') {
                                this._inputPtr++;
                            }
                            markLF();
                            cHandleInvalidXmlChar = '\n';
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i = iCheckInTreeIndentation + 1;
                                bufferWithoutReset[iCheckInTreeIndentation] = cHandleInvalidXmlChar;
                                if (i >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    iCheckInTreeIndentation = 0;
                                } else {
                                    iCheckInTreeIndentation = i;
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        bufferWithoutReset[iCheckInTreeIndentation] = cHandleInvalidXmlChar;
                        iCheckInTreeIndentation++;
                    } else {
                        bufferWithoutReset[iCheckInTreeIndentation] = cHandleInvalidXmlChar;
                        i12 = i14;
                        iCheckInTreeIndentation++;
                    }
                } else {
                    this._inputPtr = i12;
                }
            }
        }
        this._textBuilder.setCurrentLength(iCheckInTreeIndentation);
        if (!this._cfgCoalescing || this._entityPending) {
            return;
        }
        finishCoalescedText();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:24:0x0044 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x005f A[EDGE_INSN: B:50:0x005f->B:34:0x005f BREAK  A[LOOP:0: B:12:0x0026->B:48:0x008c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x008c A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishSpace() throws XMLStreamException {
        int iCheckPrologIndentation;
        char[] bufferWithoutReset;
        char c;
        char c2 = (char) this.mTmpChar;
        int i = 0;
        if (c2 == '\r' || c2 == '\n') {
            iCheckPrologIndentation = checkPrologIndentation(c2);
            if (iCheckPrologIndentation < 0) {
                return;
            } else {
                bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
            }
        } else {
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            bufferWithoutReset[0] = c2;
            iCheckPrologIndentation = 1;
        }
        int i2 = this._inputPtr;
        while (true) {
            if (i2 >= this._inputEnd) {
                if (!loadMore()) {
                    break;
                }
                i2 = this._inputPtr;
                c = this._inputBuffer[i2];
                if (c > ' ') {
                    break;
                    break;
                }
                i2++;
                if (c == '\n') {
                    markLF(i2);
                } else if (c == '\r') {
                    if (i2 >= this._inputEnd) {
                        if (!loadMore()) {
                            if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                            } else {
                                i = iCheckPrologIndentation;
                            }
                            iCheckPrologIndentation = i + 1;
                            bufferWithoutReset[i] = '\n';
                            break;
                        }
                        i2 = this._inputPtr;
                    }
                    if (this._inputBuffer[i2] == '\n') {
                        i2++;
                    }
                    markLF(i2);
                    c = '\n';
                } else if (c != ' ') {
                    this._inputPtr = i2;
                    throwInvalidSpace(c);
                }
                if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                    iCheckPrologIndentation = 0;
                }
                bufferWithoutReset[iCheckPrologIndentation] = c;
                iCheckPrologIndentation++;
            } else {
                c = this._inputBuffer[i2];
                if (c > ' ') {
                    break;
                }
                i2++;
                if (c == '\n') {
                    markLF(i2);
                } else if (c == '\r') {
                    if (i2 >= this._inputEnd) {
                        if (!loadMore()) {
                            if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                            } else {
                                i = iCheckPrologIndentation;
                            }
                            iCheckPrologIndentation = i + 1;
                            bufferWithoutReset[i] = '\n';
                            break;
                        }
                        i2 = this._inputPtr;
                    }
                    if (this._inputBuffer[i2] == '\n') {
                        i2++;
                    }
                    markLF(i2);
                    c = '\n';
                } else if (c != ' ' && c != '\t') {
                    this._inputPtr = i2;
                    throwInvalidSpace(c);
                }
                if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                    iCheckPrologIndentation = 0;
                }
                bufferWithoutReset[iCheckPrologIndentation] = c;
                iCheckPrologIndentation++;
            }
        }
        this._inputPtr = i2;
        this._textBuilder.setCurrentLength(iCheckPrologIndentation);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void finishCoalescedText() throws XMLStreamException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            if (cArr[i] == '<') {
                if (i + 3 >= this._inputEnd && !loadAndRetain(3)) {
                    return;
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                if (cArr2[i2 + 1] != '!' || cArr2[i2 + 2] != '[') {
                    return;
                }
                this._inputPtr = i2 + 3;
                for (int i3 = 0; i3 < 6; i3++) {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr3 = this._inputBuffer;
                    int i4 = this._inputPtr;
                    this._inputPtr = i4 + 1;
                    char c = cArr3[i4];
                    if (c != "CDATA[".charAt(i3)) {
                        reportTreeUnexpChar(c, " (expected '" + "CDATA[".charAt(i3) + "' for CDATA section)");
                    }
                }
                finishCoalescedCData();
            } else {
                finishCoalescedCharacters();
                if (this._entityPending) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c A[LOOP:2: B:31:0x005c->B:51:0x009c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:78:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x006f A[EDGE_INSN: B:87:0x006f->B:36:0x006f BREAK  A[LOOP:2: B:31:0x005c->B:51:0x009c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x008d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0085 A[SYNTHETIC] */
    protected final void finishCoalescedCData() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        boolean z;
        int i6;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr = this._inputBuffer;
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        while (true) {
            int i7 = this._inputPtr;
            if (i7 >= this._inputEnd) {
                loadMoreGuaranteed();
                i7 = this._inputPtr;
            }
            int i8 = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i9 = this._inputEnd;
            int length = (bufferWithoutReset.length - currentLength) + i7;
            if (length < i9) {
                i9 = length;
            }
            while (true) {
                if (i7 < i9) {
                    int i10 = i7 + 1;
                    char cHandleInvalidXmlChar = cArr[i7];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i10;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                } else if (i2 != 2) {
                                    if (i2 != 3) {
                                        markLF();
                                    } else if (i2 == 11) {
                                        i4 = 0;
                                        while (true) {
                                            if (this._inputPtr >= this._inputEnd) {
                                                loadMoreGuaranteed();
                                            }
                                            char[] cArr2 = this._inputBuffer;
                                            i5 = this._inputPtr;
                                            c = cArr2[i5];
                                            if (c != ']') {
                                                break;
                                            }
                                            this._inputPtr = i5 + 1;
                                            i4++;
                                        }
                                        if (c == '>' || i4 < 1) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        if (z) {
                                            i4--;
                                        }
                                        while (i4 > 0) {
                                            i6 = currentLength + 1;
                                            bufferWithoutReset[currentLength] = ']';
                                            if (i6 >= bufferWithoutReset.length) {
                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                currentLength = 0;
                                                i4--;
                                            } else {
                                                currentLength = i6;
                                                i4--;
                                            }
                                        }
                                        if (z) {
                                            this._inputPtr++;
                                            this._textBuilder.setCurrentLength(currentLength);
                                            return;
                                        }
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i3 = this._inputPtr;
                                if (cArr[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i = currentLength + 1;
                                    bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                                    if (i >= bufferWithoutReset.length) {
                                        bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    } else {
                                        i8 = i;
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                    currentLength = i8;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                            currentLength++;
                        } else {
                            bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                            i7 = i10;
                            currentLength++;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i10;
                        if (cHandleInvalidXmlChar <= 255) {
                            i2 = iArr[cHandleInvalidXmlChar];
                            if (i2 != 1) {
                                handleInvalidXmlChar(cHandleInvalidXmlChar);
                            } else if (i2 != 2) {
                                if (i2 != 3) {
                                    markLF();
                                } else if (i2 == 11) {
                                    i4 = 0;
                                    while (true) {
                                        if (this._inputPtr >= this._inputEnd) {
                                            loadMoreGuaranteed();
                                        }
                                        char[] cArr3 = this._inputBuffer;
                                        i5 = this._inputPtr;
                                        c = cArr3[i5];
                                        if (c != ']') {
                                            break;
                                            break;
                                        } else {
                                            this._inputPtr = i5 + 1;
                                            i4++;
                                        }
                                    }
                                    if (c == '>') {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        i4--;
                                    }
                                    while (i4 > 0) {
                                        i6 = currentLength + 1;
                                        bufferWithoutReset[currentLength] = ']';
                                        if (i6 >= bufferWithoutReset.length) {
                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                            currentLength = 0;
                                            i4--;
                                        } else {
                                            currentLength = i6;
                                            i4--;
                                        }
                                    }
                                    if (z) {
                                        this._inputPtr++;
                                        this._textBuilder.setCurrentLength(currentLength);
                                        return;
                                    }
                                }
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            i3 = this._inputPtr;
                            if (cArr[i3] == '\n') {
                                this._inputPtr = i3 + 1;
                            }
                            markLF();
                            cHandleInvalidXmlChar = '\n';
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i = currentLength + 1;
                                bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                                if (i >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                } else {
                                    i8 = i;
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                                currentLength = i8;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                        currentLength++;
                    } else {
                        bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                        i7 = i10;
                        currentLength++;
                    }
                } else {
                    this._inputPtr = i7;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x008d A[LOOP:2: B:30:0x005b->B:46:0x008d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:50:0x009d  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00af  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x0106  */
    /* JADX WARN: Code duplicated, block: B:78:0x010a  */
    /* JADX WARN: Code duplicated, block: B:80:0x010f  */
    /* JADX WARN: Code duplicated, block: B:85:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x006c A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0055. Please report as an issue. */
    protected final void finishCoalescedCharacters() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        int iHandleEntityInText;
        int i4;
        int i5;
        int i6;
        char c;
        int i7;
        int[] iArr = sCharTypes.TEXT_CHARS;
        char[] cArr = this._inputBuffer;
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        while (true) {
            int i8 = this._inputPtr;
            if (i8 >= this._inputEnd) {
                loadMoreGuaranteed();
                i8 = this._inputPtr;
            }
            int i9 = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i10 = this._inputEnd;
            int length = (bufferWithoutReset.length - currentLength) + i8;
            if (length < i10) {
                i10 = length;
            }
            while (true) {
                if (i8 < i10) {
                    int i11 = i8 + 1;
                    char cHandleInvalidXmlChar = cArr[i8];
                    if (cHandleInvalidXmlChar <= 255) {
                        if (iArr[cHandleInvalidXmlChar] != 0) {
                            this._inputPtr = i11;
                            if (cHandleInvalidXmlChar <= 255) {
                                i2 = iArr[cHandleInvalidXmlChar];
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        if (i2 != 3) {
                                            markLF();
                                        } else {
                                            switch (i2) {
                                                case 9:
                                                    this._inputPtr--;
                                                    break;
                                                case 10:
                                                    iHandleEntityInText = handleEntityInText(false);
                                                    if (iHandleEntityInText == 0) {
                                                        if ((iHandleEntityInText >> 16) != 0) {
                                                            int i12 = iHandleEntityInText - 65536;
                                                            i4 = currentLength + 1;
                                                            bufferWithoutReset[currentLength] = (char) ((i12 >> 10) | 55296);
                                                            if (i4 >= bufferWithoutReset.length) {
                                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                            } else {
                                                                i9 = i4;
                                                            }
                                                            iHandleEntityInText = 56320 | (i12 & 1023);
                                                            currentLength = i9;
                                                        }
                                                        cHandleInvalidXmlChar = (char) iHandleEntityInText;
                                                    } else {
                                                        this._entityPending = true;
                                                    }
                                                    break;
                                                case 11:
                                                    i5 = 1;
                                                    while (true) {
                                                        if (this._inputPtr >= this._inputEnd) {
                                                            loadMoreGuaranteed();
                                                        }
                                                        i6 = this._inputPtr;
                                                        c = cArr[i6];
                                                        if (c != ']') {
                                                            if (c == '>' && i5 > 1) {
                                                                reportIllegalCDataEnd();
                                                            }
                                                            while (i5 > 1) {
                                                                i7 = currentLength + 1;
                                                                bufferWithoutReset[currentLength] = ']';
                                                                if (i7 >= bufferWithoutReset.length) {
                                                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                                    currentLength = 0;
                                                                } else {
                                                                    currentLength = i7;
                                                                }
                                                                i5--;
                                                            }
                                                            cHandleInvalidXmlChar = ']';
                                                        } else {
                                                            this._inputPtr = i6 + 1;
                                                            i5++;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                } else {
                                    handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                                i3 = this._inputPtr;
                                if (i3 >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                    i3 = this._inputPtr;
                                }
                                if (cArr[i3] == '\n') {
                                    this._inputPtr++;
                                }
                                markLF();
                                cHandleInvalidXmlChar = '\n';
                            } else if (cHandleInvalidXmlChar >= 55296) {
                                if (cHandleInvalidXmlChar < 57344) {
                                    char cCheckSurrogate = checkSurrogate(cHandleInvalidXmlChar);
                                    i = currentLength + 1;
                                    bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                                    if (i >= bufferWithoutReset.length) {
                                        bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    } else {
                                        i9 = i;
                                    }
                                    cHandleInvalidXmlChar = cCheckSurrogate;
                                    currentLength = i9;
                                } else if (cHandleInvalidXmlChar >= 65534) {
                                    cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                                }
                            }
                            bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                            currentLength++;
                        } else {
                            bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                            i8 = i11;
                            currentLength++;
                        }
                    } else if (cHandleInvalidXmlChar >= 55296) {
                        this._inputPtr = i11;
                        if (cHandleInvalidXmlChar <= 255) {
                            i2 = iArr[cHandleInvalidXmlChar];
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        markLF();
                                    } else {
                                        switch (i2) {
                                            case 9:
                                                this._inputPtr--;
                                                break;
                                            case 10:
                                                iHandleEntityInText = handleEntityInText(false);
                                                if (iHandleEntityInText == 0) {
                                                    if ((iHandleEntityInText >> 16) != 0) {
                                                        int i13 = iHandleEntityInText - 65536;
                                                        i4 = currentLength + 1;
                                                        bufferWithoutReset[currentLength] = (char) ((i13 >> 10) | 55296);
                                                        if (i4 >= bufferWithoutReset.length) {
                                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                        } else {
                                                            i9 = i4;
                                                        }
                                                        iHandleEntityInText = 56320 | (i13 & 1023);
                                                        currentLength = i9;
                                                    }
                                                    cHandleInvalidXmlChar = (char) iHandleEntityInText;
                                                } else {
                                                    this._entityPending = true;
                                                }
                                                break;
                                            case 11:
                                                i5 = 1;
                                                while (true) {
                                                    if (this._inputPtr >= this._inputEnd) {
                                                        loadMoreGuaranteed();
                                                    }
                                                    i6 = this._inputPtr;
                                                    c = cArr[i6];
                                                    if (c != ']') {
                                                        if (c == '>') {
                                                            reportIllegalCDataEnd();
                                                        }
                                                        while (i5 > 1) {
                                                            i7 = currentLength + 1;
                                                            bufferWithoutReset[currentLength] = ']';
                                                            if (i7 >= bufferWithoutReset.length) {
                                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                                currentLength = 0;
                                                            } else {
                                                                currentLength = i7;
                                                            }
                                                            i5--;
                                                        }
                                                        cHandleInvalidXmlChar = ']';
                                                    } else {
                                                        this._inputPtr = i6 + 1;
                                                        i5++;
                                                    }
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                }
                            } else {
                                handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                            i3 = this._inputPtr;
                            if (i3 >= this._inputEnd) {
                                loadMoreGuaranteed();
                                i3 = this._inputPtr;
                            }
                            if (cArr[i3] == '\n') {
                                this._inputPtr++;
                            }
                            markLF();
                            cHandleInvalidXmlChar = '\n';
                        } else if (cHandleInvalidXmlChar >= 55296) {
                            if (cHandleInvalidXmlChar < 57344) {
                                char cCheckSurrogate2 = checkSurrogate(cHandleInvalidXmlChar);
                                i = currentLength + 1;
                                bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                                if (i >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                } else {
                                    i9 = i;
                                }
                                cHandleInvalidXmlChar = cCheckSurrogate2;
                                currentLength = i9;
                            } else if (cHandleInvalidXmlChar >= 65534) {
                                cHandleInvalidXmlChar = handleInvalidXmlChar(cHandleInvalidXmlChar);
                            }
                        }
                        bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                        currentLength++;
                    } else {
                        bufferWithoutReset[currentLength] = cHandleInvalidXmlChar;
                        i8 = i11;
                        currentLength++;
                    }
                } else {
                    this._inputPtr = i8;
                }
            }
        }
        this._textBuilder.setCurrentLength(currentLength);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final boolean skipCoalescedText() throws XMLStreamException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return false;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            if (cArr[i] == '<') {
                if (i + 3 >= this._inputEnd && !loadAndRetain(3)) {
                    return false;
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                if (cArr2[i2 + 1] != '!' || cArr2[i2 + 2] != '[') {
                    return false;
                }
                this._inputPtr = i2 + 3;
                for (int i3 = 0; i3 < 6; i3++) {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    char[] cArr3 = this._inputBuffer;
                    int i4 = this._inputPtr;
                    this._inputPtr = i4 + 1;
                    char c = cArr3[i4];
                    if (c != "CDATA[".charAt(i3)) {
                        reportTreeUnexpChar(c, " (expected '" + "CDATA[".charAt(i3) + "' for CDATA section)");
                    }
                }
                skipCData();
            } else if (skipCharacters()) {
                return true;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x006c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0050 A[EDGE_INSN: B:54:0x0050->B:30:0x0050 BREAK  A[LOOP:0: B:3:0x0006->B:59:0x0006], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0006 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipComment() throws XMLStreamException {
        int i;
        int i2;
        char[] cArr;
        int i3;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr2 = this._inputBuffer;
        while (true) {
            int i4 = this._inputPtr;
            int i5 = this._inputEnd;
            if (i4 >= i5) {
                loadMoreGuaranteed();
                i4 = this._inputPtr;
                i5 = this._inputEnd;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    char c = cArr2[i4];
                    if (c <= 255) {
                        if (iArr[c] != 0) {
                            this._inputPtr = i6;
                            if (c > 255) {
                                continue;
                            } else {
                                i = iArr[c];
                                if (i != 1) {
                                    handleInvalidXmlChar(c);
                                } else if (i != 2) {
                                    if (i != 3) {
                                        markLF();
                                    } else if (i == 13) {
                                        if (this._inputPtr >= this._inputEnd) {
                                            loadMoreGuaranteed();
                                        }
                                        cArr = this._inputBuffer;
                                        i3 = this._inputPtr;
                                        if (cArr[i3] == '-') {
                                            break;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i2 = this._inputPtr;
                                if (cArr2[i2] == '\n') {
                                    this._inputPtr = i2 + 1;
                                }
                                markLF();
                            }
                        } else {
                            i4 = i6;
                        }
                    } else if (c >= 55296) {
                        this._inputPtr = i6;
                        if (c > 255) {
                            continue;
                        } else {
                            i = iArr[c];
                            if (i != 1) {
                                handleInvalidXmlChar(c);
                            } else if (i != 2) {
                                if (i != 3) {
                                    markLF();
                                } else if (i == 13) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    cArr = this._inputBuffer;
                                    i3 = this._inputPtr;
                                    if (cArr[i3] == '-') {
                                        break;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            i2 = this._inputPtr;
                            if (cArr2[i2] == '\n') {
                                this._inputPtr = i2 + 1;
                            }
                            markLF();
                        }
                    } else {
                        i4 = i6;
                    }
                } else {
                    this._inputPtr = i4;
                }
            }
        }
        int i7 = i3 + 1;
        this._inputPtr = i7;
        if (i7 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr3 = this._inputBuffer;
        int i8 = this._inputPtr;
        this._inputPtr = i8 + 1;
        if (cArr3[i8] != '>') {
            reportDoubleHyphenInComments();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:47:0x006f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x003a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x004d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x007f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0006 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipPI() throws XMLStreamException {
        int i;
        char[] cArr;
        int i2;
        int i3;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr2 = this._inputBuffer;
        while (true) {
            int i4 = this._inputPtr;
            int i5 = this._inputEnd;
            if (i4 >= i5) {
                loadMoreGuaranteed();
                i4 = this._inputPtr;
                i5 = this._inputEnd;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    char c = cArr2[i4];
                    if (c <= 255) {
                        if (iArr[c] != 0) {
                            this._inputPtr = i6;
                            if (c <= 255) {
                                i = iArr[c];
                                if (i != 2) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    i3 = this._inputPtr;
                                    if (cArr2[i3] == '\n') {
                                        this._inputPtr = i3 + 1;
                                    }
                                    markLF();
                                } else if (i != 3) {
                                    markLF();
                                } else if (i == 12) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    cArr = this._inputBuffer;
                                    i2 = this._inputPtr;
                                    if (cArr[i2] == '>') {
                                        this._inputPtr = i2 + 1;
                                        return;
                                    }
                                } else {
                                    continue;
                                }
                            } else if (c < 55296) {
                                if (c < 57344) {
                                    checkSurrogate(c);
                                } else if (c >= 65534) {
                                    handleInvalidXmlChar(c);
                                }
                            }
                        } else {
                            i4 = i6;
                        }
                    } else if (c >= 55296) {
                        this._inputPtr = i6;
                        if (c <= 255) {
                            i = iArr[c];
                            if (i != 2) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i3 = this._inputPtr;
                                if (cArr2[i3] == '\n') {
                                    this._inputPtr = i3 + 1;
                                }
                                markLF();
                            } else if (i != 3) {
                                markLF();
                            } else if (i == 12) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                cArr = this._inputBuffer;
                                i2 = this._inputPtr;
                                if (cArr[i2] == '>') {
                                    this._inputPtr = i2 + 1;
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else if (c < 55296) {
                            if (c < 57344) {
                                checkSurrogate(c);
                            } else if (c >= 65534) {
                                handleInvalidXmlChar(c);
                            }
                        }
                    } else {
                        i4 = i6;
                    }
                } else {
                    this._inputPtr = i4;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    /* JADX WARN: Code duplicated, block: B:27:0x0044  */
    /* JADX WARN: Code duplicated, block: B:34:0x0059 A[LOOP:2: B:25:0x003e->B:34:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:59:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0006 A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x004f A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final boolean skipCharacters() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int[] iArr = sCharTypes.TEXT_CHARS;
        char[] cArr = this._inputBuffer;
        while (true) {
            int i5 = this._inputPtr;
            int i6 = this._inputEnd;
            if (i5 >= i6) {
                loadMoreGuaranteed();
                i5 = this._inputPtr;
                i6 = this._inputEnd;
            }
            while (true) {
                if (i5 < i6) {
                    int i7 = i5 + 1;
                    char c2 = cArr[i5];
                    if (c2 <= 255) {
                        if (iArr[c2] != 0) {
                            this._inputPtr = i7;
                            if (c2 <= 255) {
                                i = iArr[c2];
                                if (i != 1) {
                                    handleInvalidXmlChar(c2);
                                } else if (i != 2) {
                                    if (i != 3) {
                                        markLF();
                                    } else {
                                        switch (i) {
                                            case 9:
                                                this._inputPtr--;
                                                return false;
                                            case 10:
                                                if (handleEntityInText(false) == 0) {
                                                    return true;
                                                }
                                                break;
                                            case 11:
                                                i3 = 1;
                                                while (true) {
                                                    if (this._inputPtr >= this._inputEnd) {
                                                        loadMoreGuaranteed();
                                                    }
                                                    i4 = this._inputPtr;
                                                    c = cArr[i4];
                                                    if (c != ']') {
                                                        this._inputPtr = i4 + 1;
                                                        i3++;
                                                    } else if (c == '>' && i3 > 1) {
                                                        reportIllegalCDataEnd();
                                                    }
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                }
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                i2 = this._inputPtr;
                                if (cArr[i2] == '\n') {
                                    this._inputPtr = i2 + 1;
                                }
                                markLF();
                            } else if (c2 < 55296) {
                                if (c2 < 57344) {
                                    checkSurrogate(c2);
                                } else if (c2 >= 65534) {
                                    handleInvalidXmlChar(c2);
                                }
                            }
                        } else {
                            i5 = i7;
                        }
                    } else if (c2 >= 55296) {
                        this._inputPtr = i7;
                        if (c2 <= 255) {
                            i = iArr[c2];
                            if (i != 1) {
                                handleInvalidXmlChar(c2);
                            } else if (i != 2) {
                                if (i != 3) {
                                    markLF();
                                } else {
                                    switch (i) {
                                        case 9:
                                            this._inputPtr--;
                                            return false;
                                        case 10:
                                            if (handleEntityInText(false) == 0) {
                                                return true;
                                            }
                                            break;
                                        case 11:
                                            i3 = 1;
                                            while (true) {
                                                if (this._inputPtr >= this._inputEnd) {
                                                    loadMoreGuaranteed();
                                                }
                                                i4 = this._inputPtr;
                                                c = cArr[i4];
                                                if (c != ']') {
                                                    this._inputPtr = i4 + 1;
                                                    i3++;
                                                } else if (c == '>') {
                                                }
                                                break;
                                            }
                                            break;
                                    }
                                }
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            i2 = this._inputPtr;
                            if (cArr[i2] == '\n') {
                                this._inputPtr = i2 + 1;
                            }
                            markLF();
                        } else if (c2 < 55296) {
                            if (c2 < 57344) {
                                checkSurrogate(c2);
                            } else if (c2 >= 65534) {
                                handleInvalidXmlChar(c2);
                            }
                        }
                    } else {
                        i5 = i7;
                    }
                } else {
                    this._inputPtr = i5;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    /* JADX WARN: Code duplicated, block: B:27:0x0044  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x005d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x005c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x008c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0006 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipCData() throws XMLStreamException {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int[] iArr = sCharTypes.OTHER_CHARS;
        char[] cArr = this._inputBuffer;
        while (true) {
            int i5 = this._inputPtr;
            int i6 = this._inputEnd;
            if (i5 >= i6) {
                loadMoreGuaranteed();
                i5 = this._inputPtr;
                i6 = this._inputEnd;
            }
            while (true) {
                if (i5 < i6) {
                    int i7 = i5 + 1;
                    char c2 = cArr[i5];
                    if (c2 <= 255) {
                        if (iArr[c2] != 0) {
                            this._inputPtr = i7;
                            if (c2 <= 255) {
                                i = iArr[c2];
                                if (i != 1) {
                                    handleInvalidXmlChar(c2);
                                } else if (i != 2) {
                                    if (i != 3) {
                                        markLF();
                                    } else if (i != 11) {
                                        continue;
                                    } else {
                                        i3 = 0;
                                        do {
                                            if (this._inputPtr >= this._inputEnd) {
                                                loadMoreGuaranteed();
                                            }
                                            i3++;
                                            char[] cArr2 = this._inputBuffer;
                                            int i8 = this._inputPtr;
                                            i4 = i8 + 1;
                                            this._inputPtr = i4;
                                            c = cArr2[i8];
                                        } while (c == ']');
                                        if (c == '>') {
                                            this._inputPtr = i4 - 1;
                                        } else if (i3 > 1) {
                                            return;
                                        }
                                    }
                                }
                                i2 = this._inputPtr;
                                if (i2 >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                    i2 = this._inputPtr;
                                }
                                if (cArr[i2] == '\n') {
                                    i2++;
                                    this._inputPtr++;
                                }
                                markLF(i2);
                            } else if (c2 < 55296) {
                                if (c2 < 57344) {
                                    checkSurrogate(c2);
                                } else if (c2 >= 65534) {
                                    handleInvalidXmlChar(c2);
                                }
                            }
                        } else {
                            i5 = i7;
                        }
                    } else if (c2 >= 55296) {
                        this._inputPtr = i7;
                        if (c2 <= 255) {
                            i = iArr[c2];
                            if (i != 1) {
                                handleInvalidXmlChar(c2);
                            } else if (i != 2) {
                                if (i != 3) {
                                    markLF();
                                } else if (i != 11) {
                                    continue;
                                } else {
                                    i3 = 0;
                                    do {
                                        if (this._inputPtr >= this._inputEnd) {
                                            loadMoreGuaranteed();
                                        }
                                        i3++;
                                        char[] cArr3 = this._inputBuffer;
                                        int i9 = this._inputPtr;
                                        i4 = i9 + 1;
                                        this._inputPtr = i4;
                                        c = cArr3[i9];
                                    } while (c == ']');
                                    if (c == '>') {
                                        this._inputPtr = i4 - 1;
                                    } else if (i3 > 1) {
                                        return;
                                    }
                                }
                            }
                            i2 = this._inputPtr;
                            if (i2 >= this._inputEnd) {
                                loadMoreGuaranteed();
                                i2 = this._inputPtr;
                            }
                            if (cArr[i2] == '\n') {
                                i2++;
                                this._inputPtr++;
                            }
                            markLF(i2);
                        } else if (c2 < 55296) {
                            if (c2 < 57344) {
                                checkSurrogate(c2);
                            } else if (c2 >= 65534) {
                                handleInvalidXmlChar(c2);
                            }
                        }
                    } else {
                        i5 = i7;
                    }
                } else {
                    this._inputPtr = i5;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0018  */
    /* JADX WARN: Code duplicated, block: B:19:0x002a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0033  */
    /* JADX WARN: Code duplicated, block: B:26:0x003b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0030 A[EDGE_INSN: B:33:0x0030->B:21:0x0030 BREAK  A[LOOP:0: B:3:0x0002->B:41:0x0002], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x001e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0030 A[EDGE_INSN: B:37:0x0030->B:21:0x0030 BREAK  A[LOOP:0: B:3:0x0002->B:41:0x0002], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0026 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipSpace() throws XMLStreamException {
        char c;
        int i = this._inputPtr;
        while (true) {
            if (i >= this._inputEnd) {
                if (!loadMore()) {
                    break;
                }
                i = this._inputPtr;
                c = this._inputBuffer[i];
                if (c > ' ') {
                    break;
                    break;
                }
                i++;
                if (c == '\n') {
                    markLF(i);
                } else if (c == '\r') {
                    if (i >= this._inputEnd) {
                        if (!loadMore()) {
                            break;
                            break;
                        }
                        i = this._inputPtr;
                    }
                    if (this._inputBuffer[i] == '\n') {
                        i++;
                    }
                    markLF(i);
                } else if (c == ' ') {
                }
            } else {
                c = this._inputBuffer[i];
                if (c > ' ') {
                    break;
                }
                i++;
                if (c == '\n') {
                    markLF(i);
                } else if (c == '\r') {
                    if (i >= this._inputEnd) {
                        if (!loadMore()) {
                            break;
                        } else {
                            i = this._inputPtr;
                        }
                    }
                    if (this._inputBuffer[i] == '\n') {
                        i++;
                    }
                    markLF(i);
                } else if (c == ' ' && c != '\t') {
                    this._inputPtr = i;
                    throwInvalidSpace(c);
                }
            }
        }
        this._inputPtr = i;
    }

    protected char skipInternalWs(boolean z, String str) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        if (c > ' ') {
            if (!z) {
                return c;
            }
            reportTreeUnexpChar(c, " (expected white space " + str + ")");
        }
        do {
            if (c == '\n') {
                markLF();
            } else if (c == '\r') {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                if (cArr2[i2] == '\n') {
                    this._inputPtr = i2 + 1;
                }
                markLF();
            } else if (c != ' ' && c != '\t') {
                throwInvalidSpace(c);
            }
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr3 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            c = cArr3[i3];
        } while (c <= ' ');
        return c;
    }

    private final void matchAsciiKeyword(String str) throws XMLStreamException {
        int length = str.length();
        for (int i = 1; i < length; i++) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            char c = cArr[i2];
            if (c != str.charAt(i)) {
                reportTreeUnexpChar(c, " (expected '" + str.charAt(i) + "' for " + str + " keyword)");
            }
        }
    }

    protected final int checkInTreeIndentation(char c) throws XMLStreamException {
        if (c == '\r') {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                this._textBuilder.resetWithIndentation(0, XmlConsts.CHAR_SPACE);
                return -1;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            if (cArr[i] == '\n') {
                this._inputPtr = i + 1;
            }
        }
        markLF();
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        char c2 = cArr2[i2];
        if (c2 != ' ' && c2 != '\t') {
            if (c2 == '<' && i2 + 1 < this._inputEnd && cArr2[i2 + 1] != '!') {
                this._textBuilder.resetWithIndentation(0, XmlConsts.CHAR_SPACE);
                return -1;
            }
            this._textBuilder.resetWithEmpty()[0] = '\n';
            this._textBuilder.setCurrentLength(1);
            return 1;
        }
        this._inputPtr = i2 + 1;
        int i3 = c2 != ' ' ? 8 : 32;
        int i4 = 1;
        while (i4 <= i3) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr3 = this._inputBuffer;
            int i5 = this._inputPtr;
            char c3 = cArr3[i5];
            if (c3 != c2) {
                if (c3 != '<' || i5 + 1 >= this._inputEnd || cArr3[i5 + 1] == '!') {
                    break;
                    break;
                    break;
                }
                this._textBuilder.resetWithIndentation(i4, c2);
                return -1;
            }
            this._inputPtr = i5 + 1;
            i4++;
        }
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        cArrResetWithEmpty[0] = '\n';
        for (int i6 = 1; i6 <= i4; i6++) {
            cArrResetWithEmpty[i6] = c2;
        }
        int i7 = i4 + 1;
        this._textBuilder.setCurrentLength(i7);
        return i7;
    }

    protected final int checkPrologIndentation(char c) throws XMLStreamException {
        if (c == '\r') {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                this._textBuilder.resetWithIndentation(0, XmlConsts.CHAR_SPACE);
                return -1;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            if (cArr[i] == '\n') {
                this._inputPtr = i + 1;
            }
        }
        markLF();
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            this._textBuilder.resetWithIndentation(0, XmlConsts.CHAR_SPACE);
            return -1;
        }
        char[] cArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        char c2 = cArr2[i2];
        if (c2 != ' ' && c2 != '\t') {
            if (c2 == '<') {
                this._textBuilder.resetWithIndentation(0, XmlConsts.CHAR_SPACE);
                return -1;
            }
            this._textBuilder.resetWithEmpty()[0] = '\n';
            this._textBuilder.setCurrentLength(1);
            return 1;
        }
        this._inputPtr = i2 + 1;
        int i3 = c2 != ' ' ? 8 : 32;
        int i4 = 1;
        do {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr3 = this._inputBuffer;
                int i5 = this._inputPtr;
                if (cArr3[i5] == c2) {
                    this._inputPtr = i5 + 1;
                    i4++;
                }
            }
            this._textBuilder.resetWithIndentation(i4, c2);
            return -1;
        } while (i4 < i3);
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        cArrResetWithEmpty[0] = '\n';
        for (int i6 = 1; i6 <= i4; i6++) {
            cArrResetWithEmpty[i6] = c2;
        }
        int i7 = i4 + 1;
        this._textBuilder.setCurrentLength(i7);
        return i7;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected PName parsePName(char c) throws XMLStreamException {
        char[] cArrGrowArrayBy = this._nameBuffer;
        if (c < 'A') {
            throwUnexpectedChar(c, "; expected a name start character");
        }
        cArrGrowArrayBy[0] = c;
        int i = 1;
        int i2 = c;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i3 = this._inputPtr;
            char c2 = cArr[i3];
            if (c2 < 'A' && (c2 < '-' || c2 > ':' || c2 == '/')) {
                break;
            }
            this._inputPtr = i3 + 1;
            if (i >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
            }
            cArrGrowArrayBy[i] = c2;
            i++;
            i2 = (i2 * 31) + c2;
        }
        PNameC pNameCFindSymbol = this._symbols.findSymbol(cArrGrowArrayBy, 0, i, i2);
        return pNameCFindSymbol == null ? addPName(cArrGrowArrayBy, i, i2) : pNameCFindSymbol;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final PName addPName(char[] cArr, int i, int i2) throws XMLStreamException {
        char c = cArr[0];
        int i3 = 1;
        int i4 = -1;
        if (c < 55296 || c >= 57344) {
            if (!XmlChars.is10NameStartChar(c)) {
                reportInvalidNameChar(c, 0);
            }
        } else {
            if (i == 1) {
                reportInvalidFirstSurrogate(c);
            }
            checkSurrogateNameChar(c, cArr[1], 0);
            i3 = 2;
        }
        while (i3 < i) {
            char c2 = cArr[i3];
            if (c2 >= 55296 && c2 < 57344) {
                int i5 = i3 + 1;
                if (i5 >= i) {
                    reportInvalidFirstSurrogate(c2);
                }
                checkSurrogateNameChar(c2, cArr[i5], i3);
            } else if (c2 == ':') {
                if (i4 >= 0) {
                    reportMultipleColonsInName();
                }
                i4 = i3;
            } else if (!XmlChars.is10NameChar(c2)) {
                reportInvalidNameChar(c2, i3);
            }
            i3++;
        }
        return this._symbols.addSymbol(cArr, 0, i, i2);
    }

    protected String parsePublicId(char c) throws XMLStreamException {
        char[] cArrGrowArrayBy = this._nameBuffer;
        int[] iArr = XmlCharTypes.PUBID_CHARS;
        int i = 0;
        boolean z = false;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            char c2 = cArr[i2];
            if (c2 != c) {
                if (c2 > 255 || iArr[c2] != 1) {
                    throwUnexpectedChar(c2, " in public identifier");
                }
                if (c2 <= ' ') {
                    z = true;
                } else {
                    if (z) {
                        if (i >= cArrGrowArrayBy.length) {
                            cArrGrowArrayBy = this._textBuilder.finishCurrentSegment();
                            i = 0;
                        }
                        cArrGrowArrayBy[i] = XmlConsts.CHAR_SPACE;
                        i++;
                        z = false;
                    }
                    if (i >= cArrGrowArrayBy.length) {
                        cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                        this._nameBuffer = cArrGrowArrayBy;
                        i = 0;
                    }
                    cArrGrowArrayBy[i] = c2;
                    i++;
                }
            } else {
                return new String(cArrGrowArrayBy, 0, i);
            }
        }
    }

    protected String parseSystemId(char c) throws XMLStreamException {
        char[] cArrGrowArrayBy = this._nameBuffer;
        int[] iArr = sCharTypes.ATTR_CHARS;
        int i = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            char c2 = cArr[i2];
            int i3 = iArr[c2];
            if (i3 != 0) {
                if (i3 == 1) {
                    handleInvalidXmlChar(c2);
                } else if (i3 != 2) {
                    if (i3 == 3) {
                        markLF();
                    } else if (i3 == 14 && c2 == c) {
                        return new String(cArrGrowArrayBy, 0, i);
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i4 = this._inputPtr;
                if (cArr2[i4] == '\n') {
                    this._inputPtr = i4 + 1;
                }
                markLF();
                c2 = '\n';
            }
            if (i >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
                i = 0;
            }
            cArrGrowArrayBy[i] = c2;
            i++;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private char checkSurrogate(char c) throws XMLStreamException {
        if (c >= 56320) {
            reportInvalidFirstSurrogate(c);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c2 = cArr[i];
        if (c2 < 56320 || c2 >= 57344) {
            reportInvalidSecondSurrogate(c2);
        }
        int i2 = ((c - 55296) << 10) + 65536;
        if (i2 > 1114111) {
            reportInvalidXmlChar(i2);
        }
        return c2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private int checkSurrogateNameChar(char c, char c2, int i) throws XMLStreamException {
        if (c >= 56320) {
            reportInvalidFirstSurrogate(c);
        }
        if (c2 < 56320 || c2 >= 57344) {
            reportInvalidSecondSurrogate(c2);
        }
        int i2 = ((c - 55296) << 10) + 65536;
        if (i2 > 1114111) {
            reportInvalidXmlChar(i2);
        }
        reportInvalidNameChar(i2, i);
        return i2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private int decodeSurrogate(char c) throws XMLStreamException {
        if (c >= 56320) {
            reportInvalidFirstSurrogate(c);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c2 = cArr[i];
        if (c2 < 56320 || c2 >= 57344) {
            reportInvalidSecondSurrogate(c2);
        }
        int i2 = ((c - 55296) << 10) + 65536;
        if (i2 > 1114111) {
            reportInvalidXmlChar(i2);
        }
        return i2;
    }

    private void reportInvalidFirstSurrogate(char c) throws XMLStreamException {
        reportInputProblem("Invalid surrogate character (code 0x" + Integer.toHexString(c) + "): can not start a surrogate pair");
    }

    private void reportInvalidSecondSurrogate(char c) throws XMLStreamException {
        reportInputProblem("Invalid surrogate character (code " + Integer.toHexString(c) + "): is not legal as the second part of a surrogate pair");
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public XMLStreamLocation2 getCurrentLocation() {
        return LocationImpl.fromZeroBased(this._config.getPublicId(), this._config.getSystemId(), this._pastBytesOrChars + ((long) this._inputPtr), this._currRow, this._inputPtr - this._rowStartOffset);
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public int getCurrentColumnNr() {
        return this._inputPtr - this._rowStartOffset;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getStartingCharOffset() {
        return this._startRawOffset;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getEndingCharOffset() throws XMLStreamException {
        if (this._tokenIncomplete) {
            finishToken();
        }
        return this._pastBytesOrChars + ((long) this._inputPtr);
    }

    protected final void markLF(int i) {
        this._rowStartOffset = i;
        this._currRow++;
    }

    protected final void markLF() {
        this._rowStartOffset = this._inputPtr;
        this._currRow++;
    }

    protected final void setStartLocation() {
        this._startRawOffset = this._pastBytesOrChars + ((long) this._inputPtr);
        this._startRow = this._currRow;
        this._startColumn = this._inputPtr - this._rowStartOffset;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final boolean loadMore() throws XMLStreamException {
        if (this._in == null) {
            this._inputEnd = 0;
            return false;
        }
        this._pastBytesOrChars += (long) this._inputEnd;
        this._rowStartOffset -= this._inputEnd;
        this._inputPtr = 0;
        try {
            Reader reader = this._in;
            char[] cArr = this._inputBuffer;
            int i = reader.read(cArr, 0, cArr.length);
            if (i < 1) {
                this._inputEnd = 0;
                if (i == 0) {
                    reportInputProblem("Reader returned 0 bytes, even when asked to read up to " + this._inputBuffer.length);
                }
                return false;
            }
            this._inputEnd = i;
            return true;
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    protected final char loadOne() throws XMLStreamException {
        if (!loadMore()) {
            reportInputProblem("Unexpected end-of-input when trying to parse " + ErrorConsts.tokenTypeDesc(this._currToken));
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return cArr[i];
    }

    protected final char loadOne(int i) throws XMLStreamException {
        if (!loadMore()) {
            reportInputProblem("Unexpected end-of-input when trying to parse " + ErrorConsts.tokenTypeDesc(i));
        }
        char[] cArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        return cArr[i2];
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final boolean loadAndRetain(int i) throws XMLStreamException {
        int i2;
        if (this._in == null) {
            return false;
        }
        this._pastBytesOrChars += (long) this._inputPtr;
        this._rowStartOffset -= this._inputPtr;
        int i3 = this._inputEnd;
        int i4 = this._inputPtr;
        int i5 = i3 - i4;
        char[] cArr = this._inputBuffer;
        System.arraycopy(cArr, i4, cArr, 0, i5);
        this._inputPtr = 0;
        this._inputEnd = i5;
        do {
            try {
                char[] cArr2 = this._inputBuffer;
                int length = cArr2.length;
                int i6 = this._inputEnd;
                int i7 = length - i6;
                int i8 = this._in.read(cArr2, i6, i7);
                if (i8 < 1) {
                    if (i8 == 0) {
                        reportInputProblem("Reader returned 0 bytes, even when asked to read up to " + i7);
                    }
                    return false;
                }
                i2 = this._inputEnd + i8;
                this._inputEnd = i2;
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        } while (i2 < i);
        return true;
    }
}

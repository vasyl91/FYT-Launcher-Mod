package com.fasterxml.aalto.in;

import bsp.FinalBsp;
import chip.FinalChip;
import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.util.DataUtil;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlChars;
import com.fasterxml.aalto.util.XmlConsts;
import java.io.InputStream;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class Utf8Scanner extends StreamScanner {
    public Utf8Scanner(ReaderConfig readerConfig, InputStream inputStream, byte[] bArr, int i, int i2) {
        super(readerConfig, inputStream, bArr, i, i2);
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:68:0x011e  */
    @Override // com.fasterxml.aalto.in.StreamScanner
    protected int handleStartElement(byte b) throws XMLStreamException {
        boolean zIsBound;
        boolean z;
        byte b2;
        int i;
        byte b3;
        int i2;
        this._currToken = 1;
        this._currNsCount = 0;
        PName pName = parsePName(b);
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
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            byte b4 = bArr[i3];
            int iDecodeCharForError = b4 & 255;
            if (iDecodeCharForError <= 32) {
                do {
                    if (iDecodeCharForError == 10) {
                        markLF();
                    } else if (iDecodeCharForError == 13) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        if (this._inputBuffer[this._inputPtr] == 10) {
                            this._inputPtr++;
                        }
                        markLF();
                    } else if (iDecodeCharForError != 32 && iDecodeCharForError != 9) {
                        throwInvalidSpace(iDecodeCharForError);
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i4 = this._inputPtr;
                    this._inputPtr = i4 + 1;
                    b4 = bArr2[i4];
                    iDecodeCharForError = b4 & 255;
                } while (iDecodeCharForError <= 32);
            } else if (iDecodeCharForError != 47 && iDecodeCharForError != 62) {
                iDecodeCharForError = decodeCharForError(b4);
                throwUnexpectedChar(iDecodeCharForError, " expected space, or '>' or \"/>\"");
            }
            if (iDecodeCharForError == 47) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                byte b5 = bArr3[i5];
                if (b5 != 62) {
                    throwUnexpectedChar(decodeCharForError(b5), " expected '>'");
                }
                this._isEmptyTag = true;
                break;
            }
            if (iDecodeCharForError == 62) {
                this._isEmptyTag = false;
                break;
            }
            if (iDecodeCharForError == 60) {
                reportInputProblem("Unexpected '<' character in element (missing closing '>'?)");
            }
            PName pName2 = parsePName(b4);
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
                byte[] bArr4 = this._inputBuffer;
                int i6 = this._inputPtr;
                this._inputPtr = i6 + 1;
                b2 = bArr4[i6];
                i = b2 & 255;
                if (i > 32) {
                    break;
                }
                if (i == 10) {
                    markLF();
                } else if (i == 13) {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    if (this._inputBuffer[this._inputPtr] == 10) {
                        this._inputPtr++;
                    }
                    markLF();
                } else if (i != 32 && i != 9) {
                    throwInvalidSpace(i);
                }
            }
            if (i != 61) {
                throwUnexpectedChar(decodeCharForError(b2), " expected '='");
            }
            while (true) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr5 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                b3 = bArr5[i7];
                i2 = b3 & 255;
                if (i2 > 32) {
                    break;
                }
                if (i2 == 10) {
                    markLF();
                } else if (i2 == 13) {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    if (this._inputBuffer[this._inputPtr] == 10) {
                        this._inputPtr++;
                    }
                    markLF();
                } else if (i2 != 32 && i2 != 9) {
                    throwInvalidSpace(i2);
                }
            }
            if (i2 != 34 && i2 != 39) {
                throwUnexpectedChar(decodeCharForError(b3), " Expected a quote");
            }
            if (z) {
                handleNsDeclaration(pName2, b3);
                this._currNsCount++;
            } else {
                iCollectValue = collectValue(iCollectValue, b3, pName2);
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
            int i8 = this._attrCount;
            for (int i9 = 0; i9 < i8; i9++) {
                PName name = this._attrCollector.getName(i9);
                if (!name.isBound()) {
                    reportUnboundPrefix(name, true);
                }
            }
        }
        return 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0083  */
    /* JADX WARN: Code duplicated, block: B:35:0x0094  */
    /* JADX WARN: Code duplicated, block: B:37:0x009e  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b6  */
    private final int collectValue(int i, byte b, PName pName) throws XMLStreamException {
        int iHandleEntityInText;
        int i2;
        char[] cArrStartNewValue = this._attrCollector.startNewValue(pName, i);
        int[] iArr = this._charTypes.ATTR_CHARS;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            if (i >= cArrStartNewValue.length) {
                cArrStartNewValue = this._attrCollector.valueBufferFull();
            }
            int i4 = this._inputEnd;
            int length = (cArrStartNewValue.length - i) + i3;
            if (length < i4) {
                i4 = length;
            }
            while (true) {
                if (i3 < i4) {
                    int i5 = i3 + 1;
                    int iDecodeUtf8_2 = this._inputBuffer[i3] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i5;
                        int i6 = iArr[iDecodeUtf8_2];
                        if (i6 != 14) {
                            switch (i6) {
                                case 1:
                                    handleInvalidXmlChar(iDecodeUtf8_2);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (this._inputBuffer[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 32;
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (this._inputBuffer[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 32;
                                    break;
                                case 3:
                                    markLF();
                                    iDecodeUtf8_2 = 32;
                                    break;
                                case 4:
                                    reportInvalidInitial(iDecodeUtf8_2);
                                    throwUnexpectedChar(iDecodeUtf8_2, "'<' not allowed in attribute value");
                                    iHandleEntityInText = handleEntityInText(false);
                                    if (iHandleEntityInText == 0) {
                                        reportUnexpandedEntityInAttr(pName, false);
                                    }
                                    if ((iHandleEntityInText >> 16) == 0) {
                                        iDecodeUtf8_2 = iHandleEntityInText;
                                    } else {
                                        int i7 = iHandleEntityInText - 65536;
                                        i2 = i + 1;
                                        cArrStartNewValue[i] = (char) (55296 | (i7 >> 10));
                                        int i8 = (i7 & 1023) | 56320;
                                        if (i2 >= cArrStartNewValue.length) {
                                            cArrStartNewValue = this._attrCollector.valueBufferFull();
                                        }
                                        iDecodeUtf8_2 = i8;
                                        i = i2;
                                    }
                                    break;
                                case 5:
                                    iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                    break;
                                case 6:
                                    iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                    break;
                                case 7:
                                    int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                    int i9 = i + 1;
                                    cArrStartNewValue[i] = (char) (55296 | (iDecodeUtf8_4 >> 10));
                                    iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                    if (i9 >= cArrStartNewValue.length) {
                                        cArrStartNewValue = this._attrCollector.valueBufferFull();
                                    }
                                    i = i9;
                                    break;
                                case 8:
                                    iDecodeUtf8_2 = 32;
                                    break;
                                case 9:
                                    throwUnexpectedChar(iDecodeUtf8_2, "'<' not allowed in attribute value");
                                    iHandleEntityInText = handleEntityInText(false);
                                    if (iHandleEntityInText == 0) {
                                        reportUnexpandedEntityInAttr(pName, false);
                                    }
                                    if ((iHandleEntityInText >> 16) == 0) {
                                        iDecodeUtf8_2 = iHandleEntityInText;
                                    } else {
                                        int i10 = iHandleEntityInText - 65536;
                                        i2 = i + 1;
                                        cArrStartNewValue[i] = (char) (55296 | (i10 >> 10));
                                        int i11 = (i10 & 1023) | 56320;
                                        if (i2 >= cArrStartNewValue.length) {
                                            cArrStartNewValue = this._attrCollector.valueBufferFull();
                                        }
                                        iDecodeUtf8_2 = i11;
                                        i = i2;
                                    }
                                    break;
                                case 10:
                                    iHandleEntityInText = handleEntityInText(false);
                                    if (iHandleEntityInText == 0) {
                                        reportUnexpandedEntityInAttr(pName, false);
                                    }
                                    if ((iHandleEntityInText >> 16) == 0) {
                                        iDecodeUtf8_2 = iHandleEntityInText;
                                    } else {
                                        int i12 = iHandleEntityInText - 65536;
                                        i2 = i + 1;
                                        cArrStartNewValue[i] = (char) (55296 | (i12 >> 10));
                                        int i13 = (i12 & 1023) | 56320;
                                        if (i2 >= cArrStartNewValue.length) {
                                            cArrStartNewValue = this._attrCollector.valueBufferFull();
                                        }
                                        iDecodeUtf8_2 = i13;
                                        i = i2;
                                    }
                                    break;
                            }
                        } else if (iDecodeUtf8_2 == b) {
                            return i;
                        }
                        cArrStartNewValue[i] = (char) iDecodeUtf8_2;
                        i++;
                        break;
                    }
                    cArrStartNewValue[i] = (char) iDecodeUtf8_2;
                    i++;
                    i3 = i5;
                } else {
                    this._inputPtr = i3;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void handleNsDeclaration(PName pName, byte b) throws XMLStreamException {
        int i;
        int i2;
        char[] cArrGrowArrayBy = this._nameBuffer;
        int i3 = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            int iDecodeMultiByteChar = bArr[i4];
            if (iDecodeMultiByteChar == b) {
                break;
            }
            if (iDecodeMultiByteChar == 38) {
                iDecodeMultiByteChar = handleEntityInText(false);
                if (iDecodeMultiByteChar == 0) {
                    reportUnexpandedEntityInAttr(pName, true);
                }
                if ((iDecodeMultiByteChar >> 16) != 0) {
                    if (i3 >= cArrGrowArrayBy.length) {
                        cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                        this._nameBuffer = cArrGrowArrayBy;
                    }
                    i = iDecodeMultiByteChar - 65536;
                    i2 = i3 + 1;
                    cArrGrowArrayBy[i3] = (char) (55296 | (i >> 10));
                    iDecodeMultiByteChar = (i & 1023) | 56320;
                    i3 = i2;
                }
            } else if (iDecodeMultiByteChar == 60) {
                throwUnexpectedChar(iDecodeMultiByteChar, "'<' not allowed in attribute value");
            } else {
                iDecodeMultiByteChar &= 255;
                if (iDecodeMultiByteChar < 32) {
                    if (iDecodeMultiByteChar == 10) {
                        markLF();
                    } else if (iDecodeMultiByteChar == 13) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        if (this._inputBuffer[this._inputPtr] == 10) {
                            this._inputPtr++;
                        }
                        markLF();
                    } else if (iDecodeMultiByteChar < 0) {
                        iDecodeMultiByteChar = decodeMultiByteChar(iDecodeMultiByteChar, this._inputPtr);
                        if (iDecodeMultiByteChar < 0) {
                            int i5 = -iDecodeMultiByteChar;
                            if (i3 >= cArrGrowArrayBy.length) {
                                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                                this._nameBuffer = cArrGrowArrayBy;
                            }
                            i = i5 - 65536;
                            i2 = i3 + 1;
                            cArrGrowArrayBy[i3] = (char) (55296 | (i >> 10));
                            iDecodeMultiByteChar = (i & 1023) | 56320;
                            i3 = i2;
                        }
                    } else if (iDecodeMultiByteChar != 9) {
                        throwInvalidSpace(iDecodeMultiByteChar);
                    }
                }
            }
            if (i3 >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
            }
            cArrGrowArrayBy[i3] = (char) iDecodeMultiByteChar;
            i3++;
        }
        if (i3 == 0) {
            bindNs(pName, FinalChip.BSP_PLATFORM_Null);
        } else {
            bindNs(pName, this._config.canonicalizeURI(cArrGrowArrayBy, i3));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:133:0x01f4  */
    @Override // com.fasterxml.aalto.in.StreamScanner
    protected final int handleEntityInText(boolean z) throws XMLStreamException {
        String str;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte bLoadOne = bArr[i];
        if (bLoadOne == 35) {
            return handleCharEntity();
        }
        if (bLoadOne == 97) {
            if (this._inputPtr < this._inputEnd) {
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                bLoadOne = bArr2[i2];
            } else {
                bLoadOne = loadOne();
            }
            if (bLoadOne == 109) {
                if (this._inputPtr < this._inputEnd) {
                    byte[] bArr3 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    bLoadOne = bArr3[i3];
                } else {
                    bLoadOne = loadOne();
                }
                if (bLoadOne == 112) {
                    if (this._inputPtr < this._inputEnd) {
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        bLoadOne = bArr4[i4];
                    } else {
                        bLoadOne = loadOne();
                    }
                    if (bLoadOne == 59) {
                        return 38;
                    }
                    str = "amp";
                } else {
                    str = "am";
                }
            } else if (bLoadOne == 112) {
                if (this._inputPtr < this._inputEnd) {
                    byte[] bArr5 = this._inputBuffer;
                    int i5 = this._inputPtr;
                    this._inputPtr = i5 + 1;
                    bLoadOne = bArr5[i5];
                } else {
                    bLoadOne = loadOne();
                }
                if (bLoadOne == 111) {
                    if (this._inputPtr < this._inputEnd) {
                        byte[] bArr6 = this._inputBuffer;
                        int i6 = this._inputPtr;
                        this._inputPtr = i6 + 1;
                        bLoadOne = bArr6[i6];
                    } else {
                        bLoadOne = loadOne();
                    }
                    if (bLoadOne == 115) {
                        if (this._inputPtr < this._inputEnd) {
                            byte[] bArr7 = this._inputBuffer;
                            int i7 = this._inputPtr;
                            this._inputPtr = i7 + 1;
                            bLoadOne = bArr7[i7];
                        } else {
                            bLoadOne = loadOne();
                        }
                        if (bLoadOne == 59) {
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
        } else if (bLoadOne == 108) {
            if (this._inputPtr < this._inputEnd) {
                byte[] bArr8 = this._inputBuffer;
                int i8 = this._inputPtr;
                this._inputPtr = i8 + 1;
                bLoadOne = bArr8[i8];
            } else {
                bLoadOne = loadOne();
            }
            if (bLoadOne == 116) {
                if (this._inputPtr < this._inputEnd) {
                    byte[] bArr9 = this._inputBuffer;
                    int i9 = this._inputPtr;
                    this._inputPtr = i9 + 1;
                    bLoadOne = bArr9[i9];
                } else {
                    bLoadOne = loadOne();
                }
                if (bLoadOne == 59) {
                    return 60;
                }
                str = "lt";
            } else {
                str = "l";
            }
        } else if (bLoadOne == 103) {
            if (this._inputPtr < this._inputEnd) {
                byte[] bArr10 = this._inputBuffer;
                int i10 = this._inputPtr;
                this._inputPtr = i10 + 1;
                bLoadOne = bArr10[i10];
            } else {
                bLoadOne = loadOne();
            }
            if (bLoadOne == 116) {
                if (this._inputPtr < this._inputEnd) {
                    byte[] bArr11 = this._inputBuffer;
                    int i11 = this._inputPtr;
                    this._inputPtr = i11 + 1;
                    bLoadOne = bArr11[i11];
                } else {
                    bLoadOne = loadOne();
                }
                if (bLoadOne == 59) {
                    return 62;
                }
                str = "gt";
            } else {
                str = "g";
            }
        } else if (bLoadOne == 113) {
            if (this._inputPtr < this._inputEnd) {
                byte[] bArr12 = this._inputBuffer;
                int i12 = this._inputPtr;
                this._inputPtr = i12 + 1;
                bLoadOne = bArr12[i12];
            } else {
                bLoadOne = loadOne();
            }
            if (bLoadOne == 117) {
                if (this._inputPtr < this._inputEnd) {
                    byte[] bArr13 = this._inputBuffer;
                    int i13 = this._inputPtr;
                    this._inputPtr = i13 + 1;
                    bLoadOne = bArr13[i13];
                } else {
                    bLoadOne = loadOne();
                }
                if (bLoadOne == 111) {
                    if (this._inputPtr < this._inputEnd) {
                        byte[] bArr14 = this._inputBuffer;
                        int i14 = this._inputPtr;
                        this._inputPtr = i14 + 1;
                        bLoadOne = bArr14[i14];
                    } else {
                        bLoadOne = loadOne();
                    }
                    if (bLoadOne == 116) {
                        if (this._inputPtr < this._inputEnd) {
                            byte[] bArr15 = this._inputBuffer;
                            int i15 = this._inputPtr;
                            this._inputPtr = i15 + 1;
                            bLoadOne = bArr15[i15];
                        } else {
                            bLoadOne = loadOne();
                        }
                        if (bLoadOne == 59) {
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
        int[] iArr = this._charTypes.NAME_CHARS;
        char[] cArr = this._nameBuffer;
        int length = str.length();
        int i16 = 0;
        while (i16 < length) {
            cArr[i16] = str.charAt(i16);
            i16++;
        }
        while (bLoadOne != 59) {
            int iDecodeUtf8_2 = bLoadOne & 255;
            int i17 = iArr[iDecodeUtf8_2];
            boolean zIs10NameStartChar = true;
            if (i17 == 0 || i17 == 1 || i17 == 2) {
                if (i16 <= 0) {
                    zIs10NameStartChar = false;
                }
            } else if (i17 != 3) {
                if (i17 == 5) {
                    iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                    zIs10NameStartChar = XmlChars.is10NameStartChar(iDecodeUtf8_2);
                } else if (i17 == 6) {
                    iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                    zIs10NameStartChar = XmlChars.is10NameStartChar(iDecodeUtf8_2);
                } else if (i17 != 7) {
                    zIs10NameStartChar = false;
                } else {
                    iDecodeUtf8_2 = decodeUtf8_4(iDecodeUtf8_2);
                    zIs10NameStartChar = XmlChars.is10NameStartChar(iDecodeUtf8_2);
                    if (zIs10NameStartChar) {
                        if (i16 >= cArr.length) {
                            char[] cArrGrowArrayBy = DataUtil.growArrayBy(cArr, cArr.length);
                            this._nameBuffer = cArrGrowArrayBy;
                            cArr = cArrGrowArrayBy;
                        }
                        int i18 = iDecodeUtf8_2 - 65536;
                        cArr[i16] = (char) ((i18 >> 10) | 55296);
                        iDecodeUtf8_2 = (i18 & 1023) | 56320;
                        i16++;
                    }
                }
            }
            if (!zIs10NameStartChar) {
                reportInvalidNameChar(iDecodeUtf8_2, i16);
            }
            if (i16 >= cArr.length) {
                char[] cArrGrowArrayBy2 = DataUtil.growArrayBy(cArr, cArr.length);
                this._nameBuffer = cArrGrowArrayBy2;
                cArr = cArrGrowArrayBy2;
            }
            int i19 = i16 + 1;
            cArr[i16] = (char) iDecodeUtf8_2;
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr16 = this._inputBuffer;
            int i20 = this._inputPtr;
            this._inputPtr = i20 + 1;
            bLoadOne = bArr16[i20];
            i16 = i19;
        }
        String str2 = new String(cArr, 0, i16);
        this._tokenName = new PNameC(str2, null, str2, 0);
        if (this._config.willExpandEntities()) {
            reportInputProblem("General entity reference (&" + str2 + ";) encountered in entity expanding mode: operation not (yet) implemented");
        }
        if (z) {
            reportInputProblem("General entity reference (&" + str2 + ";) encountered in attribute value, in non-entity-expanding mode: no way to handle it");
        }
        return 0;
    }

    @Override // com.fasterxml.aalto.in.StreamScanner
    protected String parsePublicId(byte b) throws XMLStreamException {
        char[] cArrGrowArrayBy = this._nameBuffer;
        int[] iArr = XmlCharTypes.PUBID_CHARS;
        int i = 0;
        boolean z = false;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 != b) {
                int i3 = b2 & 255;
                if (iArr[i3] != 1) {
                    throwUnexpectedChar(i3, " in public identifier");
                }
                if (i3 <= 32) {
                    z = true;
                } else {
                    if (z) {
                        if (i >= cArrGrowArrayBy.length) {
                            cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                            this._nameBuffer = cArrGrowArrayBy;
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
                    cArrGrowArrayBy[i] = (char) i3;
                    i++;
                }
            } else {
                return new String(cArrGrowArrayBy, 0, i);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0065  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:35:0x007f A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.StreamScanner
    protected String parseSystemId(byte b) throws XMLStreamException {
        char[] cArrGrowArrayBy = this._nameBuffer;
        int[] iArr = this._charTypes.ATTR_CHARS;
        int i = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            int iDecodeUtf8_2 = bArr[i2] & 255;
            int i3 = iArr[iDecodeUtf8_2];
            if (i3 != 0) {
                if (i3 != 14) {
                    switch (i3) {
                        case 1:
                            handleInvalidXmlChar(iDecodeUtf8_2);
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            if (this._inputBuffer[this._inputPtr] == 10) {
                                this._inputPtr++;
                            }
                            markLF();
                            iDecodeUtf8_2 = 10;
                            break;
                        case 2:
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            if (this._inputBuffer[this._inputPtr] == 10) {
                                this._inputPtr++;
                            }
                            markLF();
                            iDecodeUtf8_2 = 10;
                            break;
                        case 3:
                            markLF();
                            break;
                        case 4:
                            reportInvalidInitial(iDecodeUtf8_2);
                            break;
                        case 5:
                            iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                            break;
                        case 6:
                            iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                            break;
                        case 7:
                            int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                            if (i >= cArrGrowArrayBy.length) {
                                cArrGrowArrayBy = this._textBuilder.finishCurrentSegment();
                                i = 0;
                            }
                            cArrGrowArrayBy[i] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                            iDecodeUtf8_2 = 56320 | (iDecodeUtf8_4 & 1023);
                            i++;
                            break;
                    }
                    if (iDecodeUtf8_2 == b) {
                        return new String(cArrGrowArrayBy, 0, i);
                    }
                } else if (iDecodeUtf8_2 == b) {
                    return new String(cArrGrowArrayBy, 0, i);
                }
            }
            if (i >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
                i = 0;
            }
            cArrGrowArrayBy[i] = (char) iDecodeUtf8_2;
            i++;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final boolean skipCharacters() throws XMLStreamException {
        int[] iArr = this._charTypes.TEXT_CHARS;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i >= i2) {
                loadMoreGuaranteed();
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this._inputPtr = i3;
                        switch (iArr[i4]) {
                            case 1:
                                handleInvalidXmlChar(i4);
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                break;
                                break;
                            case 3:
                                markLF();
                                break;
                            case 4:
                                reportInvalidInitial(i4);
                                break;
                            case 5:
                                skipUtf8_2(i4);
                                break;
                            case 6:
                                skipUtf8_3(i4);
                                break;
                            case 7:
                                skipUtf8_4(i4);
                                break;
                            case 8:
                            default:
                                break;
                            case 9:
                                break;
                            case 10:
                                if (handleEntityInText(false) != 0) {
                                    break;
                                }
                                return true;
                            case 11:
                                int i5 = 1;
                                while (true) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    byte b = bArr[this._inputPtr];
                                    if (b != 93) {
                                        if (b == 62 && i5 > 1) {
                                            reportIllegalCDataEnd();
                                        }
                                    }
                                    this._inputPtr++;
                                    i5++;
                                    break;
                                }
                                break;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    this._inputPtr = i;
                    break;
                }
            }
        }
        this._inputPtr--;
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipComment() throws XMLStreamException {
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i >= i2) {
                loadMoreGuaranteed();
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this._inputPtr = i3;
                        int i5 = iArr[i4];
                        if (i5 != 13) {
                            switch (i5) {
                                case 1:
                                    handleInvalidXmlChar(i4);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    break;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(i4);
                                    break;
                                case 5:
                                    skipUtf8_2(i4);
                                    break;
                                case 6:
                                    skipUtf8_3(i4);
                                    break;
                                case 7:
                                    skipUtf8_4(i4);
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        if (this._inputBuffer[this._inputPtr] != 45) {
                            break;
                        }
                        this._inputPtr++;
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr2 = this._inputBuffer;
                        int i6 = this._inputPtr;
                        this._inputPtr = i6 + 1;
                        if (bArr2[i6] != 62) {
                            reportDoubleHyphenInComments();
                            return;
                        }
                        return;
                    }
                    i = i3;
                } else {
                    this._inputPtr = i;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipCData() throws XMLStreamException {
        byte b;
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i >= i2) {
                loadMoreGuaranteed();
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this._inputPtr = i3;
                        int i5 = iArr[i4];
                        if (i5 != 11) {
                            switch (i5) {
                                case 1:
                                    handleInvalidXmlChar(i4);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    break;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(i4);
                                    break;
                                case 5:
                                    skipUtf8_2(i4);
                                    break;
                                case 6:
                                    skipUtf8_3(i4);
                                    break;
                                case 7:
                                    skipUtf8_4(i4);
                                    break;
                                default:
                                    break;
                            }
                        }
                        int i6 = 0;
                        do {
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            i6++;
                            byte[] bArr2 = this._inputBuffer;
                            int i7 = this._inputPtr;
                            this._inputPtr = i7 + 1;
                            b = bArr2[i7];
                        } while (b == 93);
                        if (b != 62) {
                            this._inputPtr--;
                            break;
                        } else if (i6 <= 1) {
                            break;
                        } else {
                            return;
                        }
                    }
                    i = i3;
                } else {
                    this._inputPtr = i;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipPI() throws XMLStreamException {
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i >= i2) {
                loadMoreGuaranteed();
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this._inputPtr = i3;
                        int i5 = iArr[i4];
                        if (i5 != 12) {
                            switch (i5) {
                                case 1:
                                    handleInvalidXmlChar(i4);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    break;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(i4);
                                    break;
                                case 5:
                                    skipUtf8_2(i4);
                                    break;
                                case 6:
                                    skipUtf8_3(i4);
                                    break;
                                case 7:
                                    skipUtf8_4(i4);
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        if (this._inputBuffer[this._inputPtr] != 62) {
                            break;
                        }
                        this._inputPtr++;
                        return;
                    }
                    i = i3;
                } else {
                    this._inputPtr = i;
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0035  */
    /* JADX WARN: Code duplicated, block: B:26:0x003d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0032 A[EDGE_INSN: B:33:0x0032->B:21:0x0032 BREAK  A[LOOP:0: B:3:0x0002->B:41:0x0002], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0032 A[EDGE_INSN: B:37:0x0032->B:21:0x0032 BREAK  A[LOOP:0: B:3:0x0002->B:41:0x0002], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0028 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void skipSpace() throws XMLStreamException {
        int i;
        int i2 = this._inputPtr;
        while (true) {
            if (i2 >= this._inputEnd) {
                if (!loadMore()) {
                    break;
                }
                i2 = this._inputPtr;
                i = this._inputBuffer[i2] & 255;
                if (i > 32) {
                    break;
                    break;
                }
                i2++;
                if (i == 10) {
                    markLF(i2);
                } else if (i == 13) {
                    if (i2 >= this._inputEnd) {
                        if (!loadMore()) {
                            break;
                            break;
                        }
                        i2 = this._inputPtr;
                    }
                    if (this._inputBuffer[i2] == 10) {
                        i2++;
                    }
                    markLF(i2);
                } else if (i == 32) {
                }
            } else {
                i = this._inputBuffer[i2] & 255;
                if (i > 32) {
                    break;
                }
                i2++;
                if (i == 10) {
                    markLF(i2);
                } else if (i == 13) {
                    if (i2 >= this._inputEnd) {
                        if (!loadMore()) {
                            break;
                        } else {
                            i2 = this._inputPtr;
                        }
                    }
                    if (this._inputBuffer[i2] == 10) {
                        i2++;
                    }
                    markLF(i2);
                } else if (i == 32 && i != 9) {
                    this._inputPtr = i2;
                    throwInvalidSpace(i);
                }
            }
        }
        this._inputPtr = i2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void skipUtf8_2(int i) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void skipUtf8_3(int i) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        int i2 = i & 15;
        if (i2 >= 13) {
            int i3 = i2 << 6;
            byte[] bArr = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            byte b = bArr[i4];
            if ((b & 192) != 128) {
                reportInvalidOther(b & 255, this._inputPtr);
            }
            int i5 = i3 | (b & 63);
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i6 = this._inputPtr;
            this._inputPtr = i6 + 1;
            byte b2 = bArr2[i6];
            if ((b2 & 192) != 128) {
                reportInvalidOther(b2 & 255, this._inputPtr);
            }
            int i7 = (i5 << 6) | (b2 & 63);
            if (i7 >= 55296) {
                if (i7 < 57344 || (i7 >= 65534 && i7 <= 65535)) {
                    handleInvalidXmlChar(i7);
                    return;
                }
                return;
            }
            return;
        }
        byte[] bArr3 = this._inputBuffer;
        int i8 = this._inputPtr;
        this._inputPtr = i8 + 1;
        byte b3 = bArr3[i8];
        if ((b3 & 192) != 128) {
            reportInvalidOther(b3 & 255, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr4 = this._inputBuffer;
        int i9 = this._inputPtr;
        this._inputPtr = i9 + 1;
        byte b4 = bArr4[i9];
        if ((b4 & 192) != 128) {
            reportInvalidOther(b4 & 255, this._inputPtr);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void skipUtf8_4(int i) throws XMLStreamException {
        if (this._inputPtr + 4 > this._inputEnd) {
            skipUtf8_4Slow(i);
            return;
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        byte[] bArr2 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            reportInvalidOther(b2 & 255, this._inputPtr);
        }
        byte[] bArr3 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        byte b3 = bArr3[i4];
        if ((b3 & 192) != 128) {
            reportInvalidOther(b3 & 255, this._inputPtr);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void skipUtf8_4Slow(int i) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            reportInvalidOther(b2 & 255, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        byte b3 = bArr3[i4];
        if ((b3 & 192) != 128) {
            reportInvalidOther(b3 & 255, this._inputPtr);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    /* JADX WARN: Code duplicated, block: B:34:0x0091  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00be  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ef A[LOOP:2: B:37:0x009c->B:62:0x00ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00c5 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishCData() throws XMLStreamException {
        int i;
        byte b;
        boolean z;
        int i2;
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        int i3 = 0;
        while (true) {
            int i4 = this._inputPtr;
            if (i4 >= this._inputEnd) {
                loadMoreGuaranteed();
                i4 = this._inputPtr;
            }
            if (i3 >= cArrResetWithEmpty.length) {
                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                i3 = 0;
            }
            int i5 = this._inputEnd;
            int length = (cArrResetWithEmpty.length - i3) + i4;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    int iDecodeUtf8_2 = bArr[i4] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i6;
                        int i7 = iArr[iDecodeUtf8_2];
                        if (i7 != 11) {
                            switch (i7) {
                                case 1:
                                    handleInvalidXmlChar(iDecodeUtf8_2);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(iDecodeUtf8_2);
                                    break;
                                case 5:
                                    iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                    break;
                                case 6:
                                    iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                    break;
                                case 7:
                                    int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                    int i8 = i3 + 1;
                                    cArrResetWithEmpty[i3] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                    if (i8 >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i3 = 0;
                                    } else {
                                        i3 = i8;
                                    }
                                    iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                    break;
                            }
                            i = 0;
                            while (true) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                b = this._inputBuffer[this._inputPtr];
                                if (b != 93) {
                                    if (b == 62 || i < 1) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        i--;
                                    }
                                    while (i > 0) {
                                        i2 = i3 + 1;
                                        cArrResetWithEmpty[i3] = ']';
                                        if (i2 >= cArrResetWithEmpty.length) {
                                            cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                            i3 = 0;
                                            i--;
                                        } else {
                                            i3 = i2;
                                            i--;
                                        }
                                    }
                                    if (z) {
                                        this._inputPtr++;
                                        this._textBuilder.setCurrentLength(i3);
                                        if (this._cfgCoalescing || this._entityPending) {
                                            return;
                                        }
                                        finishCoalescedText();
                                        return;
                                    }
                                } else {
                                    this._inputPtr++;
                                    i++;
                                }
                            }
                        } else {
                            i = 0;
                            while (true) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                b = this._inputBuffer[this._inputPtr];
                                if (b != 93) {
                                    if (b == 62) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        i--;
                                    }
                                    while (i > 0) {
                                        i2 = i3 + 1;
                                        cArrResetWithEmpty[i3] = ']';
                                        if (i2 >= cArrResetWithEmpty.length) {
                                            cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                            i3 = 0;
                                            i--;
                                        } else {
                                            i3 = i2;
                                            i--;
                                        }
                                    }
                                    if (z) {
                                        this._inputPtr++;
                                        this._textBuilder.setCurrentLength(i3);
                                        if (this._cfgCoalescing) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                } else {
                                    this._inputPtr++;
                                    i++;
                                }
                            }
                        }
                        cArrResetWithEmpty[i3] = (char) iDecodeUtf8_2;
                        i3++;
                        break;
                    }
                    cArrResetWithEmpty[i3] = (char) iDecodeUtf8_2;
                    i4 = i6;
                    i3++;
                } else {
                    this._inputPtr = i4;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6 A[PHI: r10 r11
  0x00f6: PHI (r10v17 int) = (r10v16 int), (r10v23 int) binds: [B:60:0x00ec, B:57:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00f6: PHI (r11v10 int) = (r11v9 int), (r11v12 int) binds: [B:60:0x00ec, B:57:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x0138  */
    /* JADX WARN: Code duplicated, block: B:85:0x0141  */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishCharacters() throws XMLStreamException {
        int iCheckInTreeIndentation;
        char[] bufferWithoutReset;
        int iDecodeUtf8_4;
        int i;
        int i2;
        int i3 = this._tmpChar;
        if (i3 < 0) {
            int i4 = -i3;
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            if ((i4 >> 16) != 0) {
                int i5 = i4 - 65536;
                bufferWithoutReset[0] = (char) ((i5 >> 10) | 55296);
                i4 = (i5 & 1023) | 56320;
                i2 = 1;
            } else {
                i2 = 0;
            }
            iCheckInTreeIndentation = i2 + 1;
            bufferWithoutReset[i2] = (char) i4;
        } else if (i3 == 13 || i3 == 10) {
            this._inputPtr++;
            iCheckInTreeIndentation = checkInTreeIndentation(i3);
            if (iCheckInTreeIndentation < 0) {
                return;
            } else {
                bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
            }
        } else {
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            iCheckInTreeIndentation = 0;
        }
        int[] iArr = this._charTypes.TEXT_CHARS;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i6 = this._inputPtr;
            if (i6 >= this._inputEnd) {
                loadMoreGuaranteed();
                i6 = this._inputPtr;
            }
            if (iCheckInTreeIndentation >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                iCheckInTreeIndentation = 0;
            }
            int i7 = this._inputEnd;
            int length = (bufferWithoutReset.length - iCheckInTreeIndentation) + i6;
            if (length < i7) {
                i7 = length;
            }
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    int iDecodeUtf8_2 = bArr[i6] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i8;
                        switch (iArr[iDecodeUtf8_2]) {
                            case 1:
                                handleInvalidXmlChar(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iDecodeUtf8_2 = 10;
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iDecodeUtf8_2 = 10;
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                                break;
                            case 3:
                                markLF();
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                                break;
                            case 4:
                                reportInvalidInitial(iDecodeUtf8_2);
                                this._inputPtr--;
                                break;
                            case 5:
                                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                                break;
                            case 6:
                                iDecodeUtf8_2 = this._inputEnd - this._inputPtr >= 2 ? decodeUtf8_3fast(iDecodeUtf8_2) : decodeUtf8_3(iDecodeUtf8_2);
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                                break;
                            case 7:
                                iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                i = iCheckInTreeIndentation + 1;
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                if (i >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    iCheckInTreeIndentation = 0;
                                } else {
                                    iCheckInTreeIndentation = i;
                                }
                                iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                                break;
                            case 8:
                            default:
                                bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                iCheckInTreeIndentation++;
                                break;
                            case 9:
                                this._inputPtr--;
                                break;
                            case 10:
                                iDecodeUtf8_2 = handleEntityInText(false);
                                if (iDecodeUtf8_2 == 0) {
                                    this._entityPending = true;
                                } else {
                                    if ((iDecodeUtf8_2 >> 16) != 0) {
                                        iDecodeUtf8_4 = iDecodeUtf8_2 - 65536;
                                        i = iCheckInTreeIndentation + 1;
                                        bufferWithoutReset[iCheckInTreeIndentation] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                        if (i >= bufferWithoutReset.length) {
                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                            iCheckInTreeIndentation = 0;
                                        } else {
                                            iCheckInTreeIndentation = i;
                                        }
                                        iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                    }
                                    bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                    iCheckInTreeIndentation++;
                                }
                                break;
                            case 11:
                                int i9 = 1;
                                while (true) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    byte b = bArr[this._inputPtr];
                                    if (b == 93) {
                                        this._inputPtr++;
                                        i9++;
                                    } else {
                                        if (b == 62 && i9 > 1) {
                                            reportIllegalCDataEnd();
                                        }
                                        while (i9 > 1) {
                                            int i10 = iCheckInTreeIndentation + 1;
                                            bufferWithoutReset[iCheckInTreeIndentation] = ']';
                                            if (i10 >= bufferWithoutReset.length) {
                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                iCheckInTreeIndentation = 0;
                                            } else {
                                                iCheckInTreeIndentation = i10;
                                            }
                                            i9--;
                                        }
                                        bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                                        iCheckInTreeIndentation++;
                                    }
                                    break;
                                }
                                break;
                        }
                    } else {
                        bufferWithoutReset[iCheckInTreeIndentation] = (char) iDecodeUtf8_2;
                        i6 = i8;
                        iCheckInTreeIndentation++;
                    }
                } else {
                    this._inputPtr = i6;
                    break;
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
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x009d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishComment() throws XMLStreamException {
        byte[] bArr;
        int i;
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr2 = this._inputBuffer;
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        int i2 = 0;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            if (i2 >= cArrResetWithEmpty.length) {
                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                i2 = 0;
            }
            int i4 = this._inputEnd;
            int length = (cArrResetWithEmpty.length - i2) + i3;
            if (length < i4) {
                i4 = length;
            }
            while (true) {
                if (i3 < i4) {
                    int i5 = i3 + 1;
                    int iDecodeUtf8_2 = bArr2[i3] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i5;
                        int i6 = iArr[iDecodeUtf8_2];
                        if (i6 != 13) {
                            switch (i6) {
                                case 1:
                                    handleInvalidXmlChar(iDecodeUtf8_2);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr2[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr2[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(iDecodeUtf8_2);
                                    break;
                                case 5:
                                    iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                    break;
                                case 6:
                                    iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                    break;
                                case 7:
                                    int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                    int i7 = i2 + 1;
                                    cArrResetWithEmpty[i2] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                    if (i7 >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i2 = 0;
                                    } else {
                                        i2 = i7;
                                    }
                                    iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                    break;
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            if (this._inputBuffer[this._inputPtr] == 45) {
                                this._inputPtr++;
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                bArr = this._inputBuffer;
                                i = this._inputPtr;
                                this._inputPtr = i + 1;
                                if (bArr[i] != 62) {
                                    reportDoubleHyphenInComments();
                                }
                                this._textBuilder.setCurrentLength(i2);
                                return;
                            }
                        } else {
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            if (this._inputBuffer[this._inputPtr] == 45) {
                                this._inputPtr++;
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                bArr = this._inputBuffer;
                                i = this._inputPtr;
                                this._inputPtr = i + 1;
                                if (bArr[i] != 62) {
                                    reportDoubleHyphenInComments();
                                }
                                this._textBuilder.setCurrentLength(i2);
                                return;
                            }
                        }
                        cArrResetWithEmpty[i2] = (char) iDecodeUtf8_2;
                        i2++;
                        break;
                    }
                    cArrResetWithEmpty[i2] = (char) iDecodeUtf8_2;
                    i3 = i5;
                    i2++;
                } else {
                    this._inputPtr = i3;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0013 A[EDGE_INSN: B:69:0x0013->B:68:0x0013 BREAK  A[LOOP:1: B:18:0x0032->B:62:0x00de], SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0045. Please report as an issue. */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishDTD(boolean z) throws XMLStreamException {
        char[] cArrResetWithEmpty = z ? this._textBuilder.resetWithEmpty() : null;
        int[] iArr = this._charTypes.DTD_CHARS;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            int i4 = this._inputEnd;
            if (cArrResetWithEmpty != null) {
                if (i >= cArrResetWithEmpty.length) {
                    cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                    i = 0;
                }
                int length = (cArrResetWithEmpty.length - i) + i3;
                if (length < i4) {
                    i4 = length;
                }
            }
            while (true) {
                if (i3 < i4) {
                    int i5 = i3 + 1;
                    int iDecodeUtf8_2 = this._inputBuffer[i3] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i5;
                        switch (iArr[iDecodeUtf8_2]) {
                            case 1:
                                handleInvalidXmlChar(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iDecodeUtf8_2 = 10;
                                if (cArrResetWithEmpty != null) {
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iDecodeUtf8_2 = 10;
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 3:
                                markLF();
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 4:
                                reportInvalidInitial(iDecodeUtf8_2);
                                if (i2 == 0) {
                                    i2 = iDecodeUtf8_2;
                                } else if (i2 == iDecodeUtf8_2) {
                                    i2 = 0;
                                }
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 5:
                                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 6:
                                iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 7:
                                iDecodeUtf8_2 = decodeUtf8_4(iDecodeUtf8_2);
                                if (cArrResetWithEmpty != null) {
                                    int i6 = i + 1;
                                    cArrResetWithEmpty[i] = (char) ((iDecodeUtf8_2 >> 10) | 55296);
                                    iDecodeUtf8_2 = 56320 | (iDecodeUtf8_2 & 1023);
                                    if (i6 >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i = 0;
                                    } else {
                                        i = i6;
                                    }
                                }
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 8:
                                if (i2 == 0) {
                                    i2 = iDecodeUtf8_2;
                                } else if (i2 == iDecodeUtf8_2) {
                                    i2 = 0;
                                }
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 9:
                                if (!z2) {
                                    z2 = true;
                                }
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 10:
                                if (i2 == 0) {
                                    z2 = false;
                                }
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                            case 11:
                                break;
                            default:
                                if (cArrResetWithEmpty != null) {
                                    break;
                                    break;
                                }
                                cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                                i++;
                                break;
                                break;
                        }
                        if (!z2 && i2 == 0) {
                            if (cArrResetWithEmpty != null) {
                                this._textBuilder.setCurrentLength(i);
                            }
                            byte bSkipInternalWs = skipInternalWs(false, null);
                            if (bSkipInternalWs != 62) {
                                throwUnexpectedChar(decodeCharForError(bSkipInternalWs), " expected '>' after the internal subset");
                                return;
                            }
                            return;
                        }
                        if (cArrResetWithEmpty != null) {
                            break;
                            break;
                        }
                        cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                        i++;
                        break;
                        break;
                    }
                    if (cArrResetWithEmpty != null) {
                        cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                        i++;
                    }
                    i3 = i5;
                } else {
                    this._inputPtr = i3;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00aa A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishPI() throws XMLStreamException {
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        char[] cArrResetWithEmpty = this._textBuilder.resetWithEmpty();
        int i = 0;
        while (true) {
            int i2 = this._inputPtr;
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
                i2 = this._inputPtr;
            }
            if (i >= cArrResetWithEmpty.length) {
                cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                i = 0;
            }
            int i3 = this._inputEnd;
            int length = (cArrResetWithEmpty.length - i) + i2;
            if (length < i3) {
                i3 = length;
            }
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    int iDecodeUtf8_2 = bArr[i2] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i4;
                        int i5 = iArr[iDecodeUtf8_2];
                        if (i5 != 12) {
                            switch (i5) {
                                case 1:
                                    handleInvalidXmlChar(iDecodeUtf8_2);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(iDecodeUtf8_2);
                                    break;
                                case 5:
                                    iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                    break;
                                case 6:
                                    iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                    break;
                                case 7:
                                    int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                    int i6 = i + 1;
                                    cArrResetWithEmpty[i] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                    if (i6 >= cArrResetWithEmpty.length) {
                                        cArrResetWithEmpty = this._textBuilder.finishCurrentSegment();
                                        i = 0;
                                    } else {
                                        i = i6;
                                    }
                                    iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                    break;
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            if (this._inputBuffer[this._inputPtr] == 62) {
                                this._inputPtr++;
                                this._textBuilder.setCurrentLength(i);
                                return;
                            }
                        } else {
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            if (this._inputBuffer[this._inputPtr] == 62) {
                                this._inputPtr++;
                                this._textBuilder.setCurrentLength(i);
                                return;
                            }
                        }
                        cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                        i++;
                        break;
                    }
                    cArrResetWithEmpty[i] = (char) iDecodeUtf8_2;
                    i2 = i4;
                    i++;
                } else {
                    this._inputPtr = i2;
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0046 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0055  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0061 A[EDGE_INSN: B:50:0x0061->B:34:0x0061 BREAK  A[LOOP:0: B:12:0x0026->B:48:0x008e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x008e A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final void finishSpace() throws XMLStreamException {
        int iCheckPrologIndentation;
        char[] bufferWithoutReset;
        int i;
        int i2 = this._tmpChar;
        int i3 = 0;
        if (i2 == 13 || i2 == 10) {
            iCheckPrologIndentation = checkPrologIndentation(i2);
            if (iCheckPrologIndentation < 0) {
                return;
            } else {
                bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
            }
        } else {
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            bufferWithoutReset[0] = (char) i2;
            iCheckPrologIndentation = 1;
        }
        int i4 = this._inputPtr;
        while (true) {
            if (i4 >= this._inputEnd) {
                if (!loadMore()) {
                    break;
                }
                i4 = this._inputPtr;
                i = this._inputBuffer[i4] & 255;
                if (i > 32) {
                    break;
                    break;
                }
                i4++;
                if (i == 10) {
                    markLF(i4);
                } else if (i == 13) {
                    if (i4 >= this._inputEnd) {
                        if (!loadMore()) {
                            if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                            } else {
                                i3 = iCheckPrologIndentation;
                            }
                            iCheckPrologIndentation = i3 + 1;
                            bufferWithoutReset[i3] = '\n';
                            break;
                        }
                        i4 = this._inputPtr;
                    }
                    if (this._inputBuffer[i4] == 10) {
                        i4++;
                    }
                    markLF(i4);
                    i = 10;
                } else if (i != 32) {
                    this._inputPtr = i4;
                    throwInvalidSpace(i);
                }
                if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                    iCheckPrologIndentation = 0;
                }
                bufferWithoutReset[iCheckPrologIndentation] = (char) i;
                iCheckPrologIndentation++;
            } else {
                i = this._inputBuffer[i4] & 255;
                if (i > 32) {
                    break;
                }
                i4++;
                if (i == 10) {
                    markLF(i4);
                } else if (i == 13) {
                    if (i4 >= this._inputEnd) {
                        if (!loadMore()) {
                            if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                            } else {
                                i3 = iCheckPrologIndentation;
                            }
                            iCheckPrologIndentation = i3 + 1;
                            bufferWithoutReset[i3] = '\n';
                            break;
                        }
                        i4 = this._inputPtr;
                    }
                    if (this._inputBuffer[i4] == 10) {
                        i4++;
                    }
                    markLF(i4);
                    i = 10;
                } else if (i != 32 && i != 9) {
                    this._inputPtr = i4;
                    throwInvalidSpace(i);
                }
                if (iCheckPrologIndentation >= bufferWithoutReset.length) {
                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                    iCheckPrologIndentation = 0;
                }
                bufferWithoutReset[iCheckPrologIndentation] = (char) i;
                iCheckPrologIndentation++;
            }
        }
        this._inputPtr = i4;
        this._textBuilder.setCurrentLength(iCheckPrologIndentation);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void finishCoalescedText() throws XMLStreamException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return;
            }
            if (this._inputBuffer[this._inputPtr] == 60) {
                if ((this._inputPtr + 3 >= this._inputEnd && !loadAndRetain(3)) || this._inputBuffer[this._inputPtr + 1] != 33 || this._inputBuffer[this._inputPtr + 2] != 91) {
                    return;
                }
                this._inputPtr += 3;
                for (int i = 0; i < 6; i++) {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    byte[] bArr = this._inputBuffer;
                    int i2 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    byte b = bArr[i2];
                    if (b != ((byte) "CDATA[".charAt(i))) {
                        reportTreeUnexpChar(decodeCharForError(b), " (expected '" + "CDATA[".charAt(i) + "' for CDATA section)");
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
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x00bc A[PHI: r4 r5
  0x00bc: PHI (r4v17 int) = (r4v16 int), (r4v21 int) binds: [B:44:0x00b3, B:41:0x009d] A[DONT_GENERATE, DONT_INLINE]
  0x00bc: PHI (r5v11 int) = (r5v10 int), (r5v14 int) binds: [B:44:0x00b3, B:41:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x0100  */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0047. Please report as an issue. */
    protected final void finishCoalescedCharacters() throws XMLStreamException {
        int iDecodeUtf8_4;
        int i;
        int[] iArr = this._charTypes.TEXT_CHARS;
        byte[] bArr = this._inputBuffer;
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        while (true) {
            int i2 = this._inputPtr;
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
                i2 = this._inputPtr;
            }
            int i3 = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i4 = this._inputEnd;
            int length = (bufferWithoutReset.length - currentLength) + i2;
            if (length < i4) {
                i4 = length;
            }
            while (true) {
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    int iDecodeUtf8_2 = bArr[i2] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i5;
                        switch (iArr[iDecodeUtf8_2]) {
                            case 1:
                                handleInvalidXmlChar(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iDecodeUtf8_2 = 10;
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iDecodeUtf8_2 = 10;
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 3:
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 4:
                                reportInvalidInitial(iDecodeUtf8_2);
                                break;
                            case 5:
                                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 6:
                                iDecodeUtf8_2 = this._inputEnd - this._inputPtr >= 2 ? decodeUtf8_3fast(iDecodeUtf8_2) : decodeUtf8_3(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 7:
                                iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                i = currentLength + 1;
                                bufferWithoutReset[currentLength] = (char) (55296 | (iDecodeUtf8_4 >> 10));
                                if (i >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                } else {
                                    i3 = i;
                                }
                                iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                currentLength = i3;
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 8:
                            default:
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 9:
                                break;
                            case 10:
                                iDecodeUtf8_2 = handleEntityInText(false);
                                if (iDecodeUtf8_2 == 0) {
                                    this._entityPending = true;
                                } else {
                                    if ((iDecodeUtf8_2 >> 16) != 0) {
                                        iDecodeUtf8_4 = iDecodeUtf8_2 - 65536;
                                        i = currentLength + 1;
                                        bufferWithoutReset[currentLength] = (char) (55296 | (iDecodeUtf8_4 >> 10));
                                        if (i >= bufferWithoutReset.length) {
                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                        } else {
                                            i3 = i;
                                        }
                                        iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                        currentLength = i3;
                                    }
                                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                    currentLength++;
                                }
                                break;
                            case 11:
                                int i6 = 1;
                                while (true) {
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    byte b = bArr[this._inputPtr];
                                    if (b == 93) {
                                        this._inputPtr++;
                                        i6++;
                                    } else {
                                        if (b == 62 && i6 > 1) {
                                            reportIllegalCDataEnd();
                                        }
                                        while (i6 > 1) {
                                            int i7 = currentLength + 1;
                                            bufferWithoutReset[currentLength] = ']';
                                            if (i7 >= bufferWithoutReset.length) {
                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                currentLength = 0;
                                            } else {
                                                currentLength = i7;
                                            }
                                            i6--;
                                        }
                                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                        currentLength++;
                                    }
                                    break;
                                }
                                break;
                        }
                        this._textBuilder.setCurrentLength(currentLength);
                    }
                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                    i2 = i5;
                    currentLength++;
                } else {
                    this._inputPtr = i2;
                    break;
                }
            }
        }
        this._inputPtr--;
        this._textBuilder.setCurrentLength(currentLength);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x008b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e9 A[LOOP:2: B:37:0x00a1->B:58:0x00e9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca A[SYNTHETIC] */
    protected final void finishCoalescedCData() throws XMLStreamException {
        int i;
        byte b;
        boolean z;
        int i2;
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            int i4 = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i5 = this._inputEnd;
            int length = (bufferWithoutReset.length - currentLength) + i3;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    int iDecodeUtf8_2 = bArr[i3] & 255;
                    if (iArr[iDecodeUtf8_2] != 0) {
                        this._inputPtr = i6;
                        int i7 = iArr[iDecodeUtf8_2];
                        if (i7 != 11) {
                            switch (i7) {
                                case 1:
                                    handleInvalidXmlChar(iDecodeUtf8_2);
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        loadMoreGuaranteed();
                                    }
                                    if (bArr[this._inputPtr] == 10) {
                                        this._inputPtr++;
                                    }
                                    markLF();
                                    iDecodeUtf8_2 = 10;
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(iDecodeUtf8_2);
                                    break;
                                case 5:
                                    iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                    break;
                                case 6:
                                    iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                    break;
                                case 7:
                                    int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                    int i8 = currentLength + 1;
                                    bufferWithoutReset[currentLength] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                    if (i8 >= bufferWithoutReset.length) {
                                        bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    } else {
                                        i4 = i8;
                                    }
                                    iDecodeUtf8_2 = 56320 | (iDecodeUtf8_4 & 1023);
                                    currentLength = i4;
                                    break;
                            }
                            i = 0;
                            while (true) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                b = this._inputBuffer[this._inputPtr];
                                if (b != 93) {
                                    if (b == 62 || i < 1) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        i--;
                                    }
                                    while (i > 0) {
                                        i2 = currentLength + 1;
                                        bufferWithoutReset[currentLength] = ']';
                                        if (i2 >= bufferWithoutReset.length) {
                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                            currentLength = 0;
                                            i--;
                                        } else {
                                            currentLength = i2;
                                            i--;
                                        }
                                    }
                                    if (z) {
                                        this._inputPtr++;
                                        this._textBuilder.setCurrentLength(currentLength);
                                        return;
                                    }
                                } else {
                                    this._inputPtr++;
                                    i++;
                                }
                            }
                        } else {
                            i = 0;
                            while (true) {
                                if (this._inputPtr >= this._inputEnd) {
                                    loadMoreGuaranteed();
                                }
                                b = this._inputBuffer[this._inputPtr];
                                if (b != 93) {
                                    if (b == 62) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        i--;
                                    }
                                    while (i > 0) {
                                        i2 = currentLength + 1;
                                        bufferWithoutReset[currentLength] = ']';
                                        if (i2 >= bufferWithoutReset.length) {
                                            bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                            currentLength = 0;
                                            i--;
                                        } else {
                                            currentLength = i2;
                                            i--;
                                        }
                                    }
                                    if (z) {
                                        this._inputPtr++;
                                        this._textBuilder.setCurrentLength(currentLength);
                                        return;
                                    }
                                } else {
                                    this._inputPtr++;
                                    i++;
                                }
                            }
                        }
                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                        currentLength++;
                        break;
                    }
                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                    i3 = i6;
                    currentLength++;
                } else {
                    this._inputPtr = i3;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.XmlScanner
    protected final boolean skipCoalescedText() throws XMLStreamException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return false;
            }
            if (this._inputBuffer[this._inputPtr] == 60) {
                if ((this._inputPtr + 3 >= this._inputEnd && !loadAndRetain(3)) || this._inputBuffer[this._inputPtr + 1] != 33 || this._inputBuffer[this._inputPtr + 2] != 91) {
                    return false;
                }
                this._inputPtr += 3;
                for (int i = 0; i < 6; i++) {
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    byte[] bArr = this._inputBuffer;
                    int i2 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    byte b = bArr[i2];
                    if (b != ((byte) "CDATA[".charAt(i))) {
                        reportTreeUnexpChar(decodeCharForError(b), " (expected '" + "CDATA[".charAt(i) + "' for CDATA section)");
                    }
                }
                skipCData();
            } else if (skipCharacters()) {
                return true;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    private final int decodeMultiByteChar(int i, int i2) throws XMLStreamException {
        char c;
        int i3;
        byte b;
        int i4;
        int i5;
        byte b2;
        byte b3;
        if ((i & FinalBsp.KEY_CODE_NEXT) != 192) {
            if ((i & FinalBsp.KEY_CODE_TONE_MINUS) == 224) {
                i &= 15;
                c = 2;
            } else if ((i & FinalBsp.KEY_AIR_CYCLE) == 240) {
                i &= 7;
                c = 3;
            } else {
                reportInvalidInitial(i & 255);
            }
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
                i2 = this._inputPtr;
            }
            i3 = i2 + 1;
            b = this._inputBuffer[i2];
            if ((b & 192) != 128) {
                reportInvalidOther(b & 255, i3);
            }
            i4 = (i << 6) | (b & 63);
            if (c > 1) {
                if (i3 >= this._inputEnd) {
                    loadMoreGuaranteed();
                    i3 = this._inputPtr;
                }
                i5 = i3 + 1;
                b2 = this._inputBuffer[i3];
                if ((b2 & 192) != 128) {
                    reportInvalidOther(b2 & 255, i5);
                }
                i4 = (i4 << 6) | (b2 & 63);
                if (c > 2) {
                    if (i5 >= this._inputEnd) {
                        loadMoreGuaranteed();
                        i5 = this._inputPtr;
                    }
                    i3 = i5 + 1;
                    b3 = this._inputBuffer[i5];
                    if ((b3 & 192) != 128) {
                        reportInvalidOther(b3 & 255, i3);
                    }
                    i4 = -((i4 << 6) | (b3 & 63));
                } else {
                    i3 = i5;
                }
            }
            this._inputPtr = i3;
            return i4;
        }
        i &= 31;
        c = 1;
        if (i2 >= this._inputEnd) {
            loadMoreGuaranteed();
            i2 = this._inputPtr;
        }
        i3 = i2 + 1;
        b = this._inputBuffer[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, i3);
        }
        i4 = (i << 6) | (b & 63);
        if (c > 1) {
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            i5 = i3 + 1;
            b2 = this._inputBuffer[i3];
            if ((b2 & 192) != 128) {
                reportInvalidOther(b2 & 255, i5);
            }
            i4 = (i4 << 6) | (b2 & 63);
            if (c > 2) {
                if (i5 >= this._inputEnd) {
                    loadMoreGuaranteed();
                    i5 = this._inputPtr;
                }
                i3 = i5 + 1;
                b3 = this._inputBuffer[i5];
                if ((b3 & 192) != 128) {
                    reportInvalidOther(b3 & 255, i3);
                }
                i4 = -((i4 << 6) | (b3 & 63));
            } else {
                i3 = i5;
            }
        }
        this._inputPtr = i3;
        return i4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int decodeUtf8_2(int i) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        return ((i & 31) << 6) | (b & 63);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int decodeUtf8_3(int i) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        int i2 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        int i4 = (b & 63) | (i2 << 6);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        this._inputPtr = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            reportInvalidOther(b2 & 255, this._inputPtr);
        }
        int i6 = (i4 << 6) | (b2 & 63);
        if (i2 < 13 || i6 < 55296) {
            return i6;
        }
        return (i6 < 57344 || (i6 >= 65534 && i6 <= 65535)) ? handleInvalidXmlChar(i6) : i6;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int decodeUtf8_3fast(int i) throws XMLStreamException {
        int i2 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        int i4 = (b & 63) | (i2 << 6);
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        this._inputPtr = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            reportInvalidOther(b2 & 255, this._inputPtr);
        }
        int i6 = (i4 << 6) | (b2 & 63);
        if (i2 < 13 || i6 < 55296) {
            return i6;
        }
        return (i6 < 57344 || (i6 >= 65534 && i6 <= 65535)) ? handleInvalidXmlChar(i6) : i6;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int decodeUtf8_4(int i) throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        int i3 = ((i & 7) << 6) | (b & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            reportInvalidOther(b2 & 255, this._inputPtr);
        }
        int i5 = (i3 << 6) | (b2 & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i6 = this._inputPtr;
        this._inputPtr = i6 + 1;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            reportInvalidOther(b3 & 255, this._inputPtr);
        }
        return ((i5 << 6) | (b3 & 63)) - 65536;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.fasterxml.aalto.in.ByteBasedScanner
    public int decodeCharForError(byte b) throws XMLStreamException {
        char c;
        int i;
        byte bNextByte;
        int i2;
        byte bNextByte2;
        int i3;
        byte bNextByte3;
        int i4;
        if (b >= 0) {
            return b;
        }
        if ((b & 224) != 192) {
            if ((b & 240) == 224) {
                c = 2;
                i = b & 15;
            } else if ((b & 248) == 240) {
                c = 3;
                i = b & 7;
            } else {
                reportInvalidInitial(b & 255);
                i4 = b;
            }
            bNextByte = nextByte();
            if ((bNextByte & 192) != 128) {
                reportInvalidOther(bNextByte & 255);
            }
            i2 = (i << 6) | (bNextByte & 63);
            if (c > 1) {
                return i2;
            }
            bNextByte2 = nextByte();
            if ((bNextByte2 & 192) != 128) {
                reportInvalidOther(bNextByte2 & 255);
            }
            i3 = (i2 << 6) | (bNextByte2 & 63);
            if (c > 2) {
                return i3;
            }
            bNextByte3 = nextByte();
            if ((bNextByte3 & 192) != 128) {
                reportInvalidOther(bNextByte3 & 255);
            }
            return (i3 << 6) | (bNextByte3 & 63);
        }
        i4 = b & 31;
        c = 1;
        i = i4;
        bNextByte = nextByte();
        if ((bNextByte & 192) != 128) {
            reportInvalidOther(bNextByte & 255);
        }
        i2 = (i << 6) | (bNextByte & 63);
        if (c > 1) {
            return i2;
        }
        bNextByte2 = nextByte();
        if ((bNextByte2 & 192) != 128) {
            reportInvalidOther(bNextByte2 & 255);
        }
        i3 = (i2 << 6) | (bNextByte2 & 63);
        if (c > 2) {
            return i3;
        }
        bNextByte3 = nextByte();
        if ((bNextByte3 & 192) != 128) {
            reportInvalidOther(bNextByte3 & 255);
        }
        return (i3 << 6) | (bNextByte3 & 63);
    }

    protected void reportInvalidOther(int i, int i2) throws XMLStreamException {
        this._inputPtr = i2;
        reportInvalidOther(i);
    }
}

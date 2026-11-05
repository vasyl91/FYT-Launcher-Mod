package com.fasterxml.aalto.async;

import chip.FinalChip;
import com.fasterxml.aalto.AsyncByteArrayFeeder;
import com.fasterxml.aalto.in.ElementScope;
import com.fasterxml.aalto.in.EntityNames;
import com.fasterxml.aalto.in.PName;
import com.fasterxml.aalto.in.ReaderConfig;
import com.fasterxml.aalto.util.DataUtil;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.ListCondition01;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AsyncByteArrayScanner extends AsyncByteScanner implements AsyncByteArrayFeeder {
    protected byte[] _inputBuffer;
    protected int _origBufferLen;

    public AsyncByteArrayScanner(ReaderConfig readerConfig) {
        super(readerConfig);
        this._state = 1;
        this._currToken = 257;
    }

    public String toString() {
        return "asyncScanner; curr=" + this._currToken + " next=" + this._nextEvent + ", state = " + this._state;
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final byte _currentByte() throws XMLStreamException {
        return this._inputBuffer[this._inputPtr];
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final byte _nextByte() throws XMLStreamException {
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i];
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final byte _prevByte() throws XMLStreamException {
        return this._inputBuffer[this._inputPtr - 1];
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:55:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:57:0x0103  */
    /* JADX WARN: Code duplicated, block: B:62:0x0118  */
    /* JADX WARN: Code duplicated, block: B:66:0x012e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0138  */
    /* JADX WARN: Code duplicated, block: B:71:0x0146  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0122 A[SYNTHETIC] */
    protected int parseCommentContents() throws XMLStreamException {
        byte[] bArr;
        int i;
        int iHandleCommentPending;
        if (this._pendingInput != 0 && (iHandleCommentPending = handleCommentPending()) != 0) {
            return iHandleCommentPending;
        }
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr2 = this._inputBuffer;
        while (this._inputPtr < this._inputEnd) {
            int i2 = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i3 = this._inputEnd;
            int length = this._inputPtr + (bufferWithoutReset.length - currentLength);
            if (length < i3) {
                i3 = length;
            }
            while (this._inputPtr < i3) {
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                int iDecodeUtf8_2 = bArr2[i4] & 255;
                int i5 = iArr[iDecodeUtf8_2];
                if (i5 != 0) {
                    if (i5 != 13) {
                        switch (i5) {
                            case 1:
                                handleInvalidXmlChar(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = 10;
                                if (bArr2[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = 10;
                                if (bArr2[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 3:
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 4:
                                reportInvalidInitial(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -20;
                                } else {
                                    if (this._inputBuffer[this._inputPtr] == 45) {
                                        this._inputPtr++;
                                        if (this._inputPtr >= this._inputEnd) {
                                            this._pendingInput = -21;
                                        } else {
                                            bArr = this._inputBuffer;
                                            i = this._inputPtr;
                                            this._inputPtr = i + 1;
                                            if (bArr[i] != 62) {
                                                reportDoubleHyphenInComments();
                                            }
                                            this._textBuilder.setCurrentLength(currentLength);
                                            this._state = 0;
                                            this._nextEvent = 257;
                                            return 5;
                                        }
                                    }
                                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                    currentLength++;
                                    break;
                                    break;
                                }
                                this._textBuilder.setCurrentLength(currentLength);
                                return 257;
                            case 5:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 6:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr3 = this._inputBuffer;
                                        int i6 = this._inputPtr;
                                        this._inputPtr = i6 + 1;
                                        iDecodeUtf8_2 |= (bArr3[i6] & 255) << 8;
                                    }
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 7:
                                if (this._inputEnd - this._inputPtr < 3) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr4 = this._inputBuffer;
                                        int i7 = this._inputPtr;
                                        this._inputPtr = i7 + 1;
                                        iDecodeUtf8_2 |= (bArr4[i7] & 255) << 8;
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr5 = this._inputBuffer;
                                            int i8 = this._inputPtr;
                                            this._inputPtr = i8 + 1;
                                            iDecodeUtf8_2 |= (bArr5[i8] & 255) << 16;
                                        }
                                    }
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                int i9 = currentLength + 1;
                                bufferWithoutReset[currentLength] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                if (i9 >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                } else {
                                    i2 = i9;
                                }
                                iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                currentLength = i2;
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            default:
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                        }
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = -20;
                    } else {
                        if (this._inputBuffer[this._inputPtr] == 45) {
                            this._inputPtr++;
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = -21;
                            } else {
                                bArr = this._inputBuffer;
                                i = this._inputPtr;
                                this._inputPtr = i + 1;
                                if (bArr[i] != 62) {
                                    reportDoubleHyphenInComments();
                                }
                                this._textBuilder.setCurrentLength(currentLength);
                                this._state = 0;
                                this._nextEvent = 257;
                                return 5;
                            }
                        }
                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                        currentLength++;
                        break;
                        break;
                    }
                    this._textBuilder.setCurrentLength(currentLength);
                    return 257;
                }
                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                currentLength++;
            }
        }
        this._textBuilder.setCurrentLength(currentLength);
        return 257;
    }

    protected int handleCommentPending() throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        if (this._pendingInput == -20) {
            if (this._inputBuffer[this._inputPtr] != 45) {
                this._pendingInput = 0;
                this._textBuilder.append("-");
                return 0;
            }
            this._inputPtr++;
            this._pendingInput = -21;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
        }
        if (this._pendingInput != -21) {
            return handleAndAppendPending() ? 0 : 257;
        }
        this._pendingInput = 0;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        if (bArr[i] != 62) {
            reportDoubleHyphenInComments();
        }
        this._state = 0;
        this._nextEvent = 257;
        return 5;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:55:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:64:0x011b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0111 A[SYNTHETIC] */
    protected int parsePIData() throws XMLStreamException {
        int iHandlePIPending;
        if (this._pendingInput != 0 && (iHandlePIPending = handlePIPending()) != 0) {
            return iHandlePIPending;
        }
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        while (this._inputPtr < this._inputEnd) {
            int i = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i2 = this._inputEnd;
            int length = this._inputPtr + (bufferWithoutReset.length - currentLength);
            if (length < i2) {
                i2 = length;
            }
            while (this._inputPtr < i2) {
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int iDecodeUtf8_2 = bArr[i3] & 255;
                int i4 = iArr[iDecodeUtf8_2];
                if (i4 != 0) {
                    if (i4 != 12) {
                        switch (i4) {
                            case 1:
                                handleInvalidXmlChar(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = 10;
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = 10;
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 3:
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 4:
                                reportInvalidInitial(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -15;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                if (this._inputBuffer[this._inputPtr] == 62) {
                                    this._inputPtr++;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    this._state = 0;
                                    this._nextEvent = 257;
                                    return 3;
                                }
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 5:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 6:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr2 = this._inputBuffer;
                                        int i5 = this._inputPtr;
                                        this._inputPtr = i5 + 1;
                                        iDecodeUtf8_2 |= (bArr2[i5] & 255) << 8;
                                    }
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 7:
                                if (this._inputEnd - this._inputPtr < 3) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr3 = this._inputBuffer;
                                        int i6 = this._inputPtr;
                                        this._inputPtr = i6 + 1;
                                        iDecodeUtf8_2 |= (bArr3[i6] & 255) << 8;
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr4 = this._inputBuffer;
                                            int i7 = this._inputPtr;
                                            this._inputPtr = i7 + 1;
                                            iDecodeUtf8_2 |= (bArr4[i7] & 255) << 16;
                                        }
                                    }
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                int i8 = currentLength + 1;
                                bufferWithoutReset[currentLength] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                if (i8 >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                } else {
                                    i = i8;
                                }
                                iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                currentLength = i;
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            default:
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                        }
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = -15;
                        this._textBuilder.setCurrentLength(currentLength);
                        return 257;
                    }
                    if (this._inputBuffer[this._inputPtr] == 62) {
                        this._inputPtr++;
                        this._textBuilder.setCurrentLength(currentLength);
                        this._state = 0;
                        this._nextEvent = 257;
                        return 3;
                    }
                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                    currentLength++;
                    break;
                    break;
                }
                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                currentLength++;
            }
        }
        this._textBuilder.setCurrentLength(currentLength);
        return 257;
    }

    protected int handlePIPending() throws XMLStreamException {
        if (this._pendingInput != -15) {
            return handleAndAppendPending() ? 0 : 257;
        }
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte b = this._inputBuffer[this._inputPtr];
        this._pendingInput = 0;
        if (b != 62) {
            this._textBuilder.append('?');
            return 0;
        }
        this._inputPtr++;
        this._state = 0;
        this._nextEvent = 257;
        return 3;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x0111  */
    /* JADX WARN: Code duplicated, block: B:68:0x0115  */
    /* JADX WARN: Code duplicated, block: B:70:0x0119  */
    /* JADX WARN: Code duplicated, block: B:78:0x0132  */
    /* JADX WARN: Code duplicated, block: B:80:0x013a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0129 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final boolean handleDTDInternalSubset(boolean z) throws XMLStreamException {
        char[] bufferWithoutReset;
        int currentLength;
        if (z) {
            bufferWithoutReset = this._textBuilder.resetWithEmpty();
            this._elemAttrQuote = (byte) 0;
            this._inDtdDeclaration = false;
            currentLength = 0;
        } else {
            if (this._pendingInput != 0 && !handleAndAppendPending()) {
                return false;
            }
            bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
            currentLength = this._textBuilder.getCurrentLength();
        }
        int[] iArr = this._charTypes.DTD_CHARS;
        byte[] bArr = this._inputBuffer;
        while (this._inputPtr < this._inputEnd) {
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i = this._inputEnd;
            int length = this._inputPtr + (bufferWithoutReset.length - currentLength);
            if (length < i) {
                i = length;
            }
            while (this._inputPtr < i) {
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int iDecodeUtf8_2 = bArr[i2] & 255;
                int i3 = iArr[iDecodeUtf8_2];
                if (i3 == 0) {
                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                    currentLength++;
                } else {
                    switch (i3) {
                        case 1:
                            handleInvalidXmlChar(iDecodeUtf8_2);
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = -1;
                                this._textBuilder.setCurrentLength(currentLength);
                                return false;
                            }
                            if (bArr[this._inputPtr] == 10) {
                                this._inputPtr++;
                            }
                            markLF();
                            iDecodeUtf8_2 = 10;
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                        case 2:
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = -1;
                                this._textBuilder.setCurrentLength(currentLength);
                                return false;
                            }
                            if (bArr[this._inputPtr] == 10) {
                                this._inputPtr++;
                            }
                            markLF();
                            iDecodeUtf8_2 = 10;
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 3:
                            markLF();
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 4:
                            reportInvalidInitial(iDecodeUtf8_2);
                            if (this._elemAttrQuote == 0) {
                                this._elemAttrQuote = (byte) iDecodeUtf8_2;
                            } else if (this._elemAttrQuote == iDecodeUtf8_2) {
                                this._elemAttrQuote = (byte) 0;
                            }
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 5:
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = iDecodeUtf8_2;
                                this._textBuilder.setCurrentLength(currentLength);
                                return false;
                            }
                            iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 6:
                            if (this._inputEnd - this._inputPtr < 2) {
                                if (this._inputEnd > this._inputPtr) {
                                    byte[] bArr2 = this._inputBuffer;
                                    int i4 = this._inputPtr;
                                    this._inputPtr = i4 + 1;
                                    iDecodeUtf8_2 |= (bArr2[i4] & 255) << 8;
                                }
                                this._pendingInput = iDecodeUtf8_2;
                                this._textBuilder.setCurrentLength(currentLength);
                                return false;
                            }
                            iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 7:
                            if (this._inputEnd - this._inputPtr < 3) {
                                if (this._inputEnd > this._inputPtr) {
                                    byte[] bArr3 = this._inputBuffer;
                                    int i5 = this._inputPtr;
                                    this._inputPtr = i5 + 1;
                                    iDecodeUtf8_2 |= (bArr3[i5] & 255) << 8;
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr4 = this._inputBuffer;
                                        int i6 = this._inputPtr;
                                        this._inputPtr = i6 + 1;
                                        iDecodeUtf8_2 |= (bArr4[i6] & 255) << 16;
                                    }
                                }
                                this._pendingInput = iDecodeUtf8_2;
                                this._textBuilder.setCurrentLength(currentLength);
                                return false;
                            }
                            int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                            int i7 = currentLength + 1;
                            bufferWithoutReset[currentLength] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                            if (i7 >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                currentLength = 0;
                            } else {
                                currentLength = i7;
                            }
                            iDecodeUtf8_2 = 56320 | (iDecodeUtf8_4 & 1023);
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 8:
                            if (this._elemAttrQuote == 0) {
                                this._elemAttrQuote = (byte) iDecodeUtf8_2;
                            } else if (this._elemAttrQuote == iDecodeUtf8_2) {
                                this._elemAttrQuote = (byte) 0;
                            }
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 9:
                            if (!this._inDtdDeclaration) {
                                this._inDtdDeclaration = true;
                            }
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 10:
                            if (this._elemAttrQuote == 0) {
                                this._inDtdDeclaration = false;
                            }
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        case 11:
                            if (!this._inDtdDeclaration && this._elemAttrQuote == 0) {
                                this._textBuilder.setCurrentLength(currentLength);
                                return true;
                            }
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                        default:
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            currentLength++;
                            break;
                            break;
                    }
                }
            }
        }
        this._textBuilder.setCurrentLength(currentLength);
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:104:0x018a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:57:0x0104  */
    /* JADX WARN: Code duplicated, block: B:62:0x011a  */
    /* JADX WARN: Code duplicated, block: B:70:0x013a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0156  */
    /* JADX WARN: Code duplicated, block: B:78:0x0165  */
    /* JADX WARN: Code duplicated, block: B:79:0x016c  */
    /* JADX WARN: Code duplicated, block: B:81:0x0173  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0144 A[SYNTHETIC] */
    protected final int parseCDataContents() throws XMLStreamException {
        int i;
        int i2;
        int iHandleCDataPending;
        if (this._pendingInput != 0 && (iHandleCDataPending = handleCDataPending()) != 0) {
            return iHandleCDataPending;
        }
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        int[] iArr = this._charTypes.OTHER_CHARS;
        byte[] bArr = this._inputBuffer;
        while (this._inputPtr < this._inputEnd) {
            int i3 = 0;
            if (currentLength >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                currentLength = 0;
            }
            int i4 = this._inputEnd;
            int length = this._inputPtr + (bufferWithoutReset.length - currentLength);
            if (length < i4) {
                i4 = length;
            }
            while (this._inputPtr < i4) {
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int iDecodeUtf8_2 = bArr[i5] & 255;
                int i6 = iArr[iDecodeUtf8_2];
                if (i6 != 0) {
                    if (i6 != 11) {
                        switch (i6) {
                            case 1:
                                handleInvalidXmlChar(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = 10;
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = 10;
                                if (bArr[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 3:
                                markLF();
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 4:
                                reportInvalidInitial(iDecodeUtf8_2);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -30;
                                } else {
                                    if (this._inputBuffer[this._inputPtr] == 93) {
                                        this._inputPtr++;
                                        while (true) {
                                            if (this._inputPtr >= this._inputEnd) {
                                                this._pendingInput = -31;
                                            } else {
                                                if (this._inputBuffer[this._inputPtr] == 62) {
                                                    this._inputPtr++;
                                                    this._textBuilder.setCurrentLength(currentLength);
                                                    this._state = 0;
                                                    this._nextEvent = 257;
                                                    return 12;
                                                }
                                                if (this._inputBuffer[this._inputPtr] != 93) {
                                                    i = currentLength + 1;
                                                    bufferWithoutReset[currentLength] = ']';
                                                    if (i >= bufferWithoutReset.length) {
                                                        bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                    } else {
                                                        i3 = i;
                                                    }
                                                    currentLength = i3 + 1;
                                                    bufferWithoutReset[i3] = ']';
                                                }
                                                this._inputPtr++;
                                                i2 = currentLength + 1;
                                                bufferWithoutReset[currentLength] = ']';
                                                if (i2 >= bufferWithoutReset.length) {
                                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                    currentLength = 0;
                                                } else {
                                                    currentLength = i2;
                                                }
                                            }
                                        }
                                    } else {
                                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                        currentLength++;
                                        break;
                                    }
                                    break;
                                }
                                this._textBuilder.setCurrentLength(currentLength);
                                return 257;
                            case 5:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 6:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr2 = this._inputBuffer;
                                        int i7 = this._inputPtr;
                                        this._inputPtr = i7 + 1;
                                        iDecodeUtf8_2 |= (bArr2[i7] & 255) << 8;
                                    }
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            case 7:
                                if (this._inputEnd - this._inputPtr < 3) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr3 = this._inputBuffer;
                                        int i8 = this._inputPtr;
                                        this._inputPtr = i8 + 1;
                                        iDecodeUtf8_2 |= (bArr3[i8] & 255) << 8;
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr4 = this._inputBuffer;
                                            int i9 = this._inputPtr;
                                            this._inputPtr = i9 + 1;
                                            iDecodeUtf8_2 |= (bArr4[i9] & 255) << 16;
                                        }
                                    }
                                    this._pendingInput = iDecodeUtf8_2;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    return 257;
                                }
                                int iDecodeUtf8_4 = decodeUtf8_4(iDecodeUtf8_2);
                                int i10 = currentLength + 1;
                                bufferWithoutReset[currentLength] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                if (i10 >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                } else {
                                    i3 = i10;
                                }
                                iDecodeUtf8_2 = (iDecodeUtf8_4 & 1023) | 56320;
                                currentLength = i3;
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                            default:
                                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                currentLength++;
                                break;
                                break;
                        }
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = -30;
                    } else if (this._inputBuffer[this._inputPtr] == 93) {
                        this._inputPtr++;
                        while (true) {
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = -31;
                            } else {
                                if (this._inputBuffer[this._inputPtr] == 62) {
                                    this._inputPtr++;
                                    this._textBuilder.setCurrentLength(currentLength);
                                    this._state = 0;
                                    this._nextEvent = 257;
                                    return 12;
                                }
                                if (this._inputBuffer[this._inputPtr] != 93) {
                                    i = currentLength + 1;
                                    bufferWithoutReset[currentLength] = ']';
                                    if (i >= bufferWithoutReset.length) {
                                        bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    } else {
                                        i3 = i;
                                    }
                                    currentLength = i3 + 1;
                                    bufferWithoutReset[i3] = ']';
                                    break;
                                }
                                this._inputPtr++;
                                i2 = currentLength + 1;
                                bufferWithoutReset[currentLength] = ']';
                                if (i2 >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                    currentLength = 0;
                                } else {
                                    currentLength = i2;
                                }
                            }
                        }
                    } else {
                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                        currentLength++;
                        break;
                        break;
                    }
                    this._textBuilder.setCurrentLength(currentLength);
                    return 257;
                }
                bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                currentLength++;
            }
        }
        this._textBuilder.setCurrentLength(currentLength);
        return 257;
    }

    protected final int handleCDataPending() throws XMLStreamException {
        if (this._pendingInput == -30) {
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            if (this._inputBuffer[this._inputPtr] != 93) {
                this._textBuilder.append(']');
                this._pendingInput = 0;
                return 0;
            }
            this._inputPtr++;
            this._pendingInput = -31;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
        }
        while (this._pendingInput == -31) {
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            byte b = bArr[i];
            if (b == 62) {
                this._pendingInput = 0;
                this._state = 0;
                this._nextEvent = 257;
                return 12;
            }
            if (b != 93) {
                this._inputPtr--;
                this._textBuilder.append("]]");
                this._pendingInput = 0;
                return 0;
            }
            this._textBuilder.append(']');
        }
        return handleAndAppendPending() ? 0 : 257;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int startCharactersPending() throws XMLStreamException {
        int iDecodeUtf8_3;
        int iDecodeUtf8_4;
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        int i = this._pendingInput;
        this._pendingInput = 0;
        if (i == -1) {
            if (this._inputBuffer[this._inputPtr] == 10) {
                this._inputPtr++;
            }
            markLF();
            this._textBuilder.resetWithChar('\n');
        } else {
            int i2 = i & 255;
            int i3 = this._charTypes.TEXT_CHARS[i2];
            if (i3 == 5) {
                this._textBuilder.resetWithChar((char) decodeUtf8_2(i));
            } else if (i3 == 6) {
                byte[] bArr = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                int i5 = bArr[i4] & 255;
                int i6 = i >> 8;
                if (i6 == 0) {
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = i | (i5 << 8);
                        return 257;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    iDecodeUtf8_3 = decodeUtf8_3(i, i5, bArr2[i7] & 255);
                } else {
                    iDecodeUtf8_3 = decodeUtf8_3(i2, i6, i5);
                }
                this._textBuilder.resetWithChar((char) iDecodeUtf8_3);
            } else {
                if (i3 == 7) {
                    byte[] bArr3 = this._inputBuffer;
                    int i8 = this._inputPtr;
                    this._inputPtr = i8 + 1;
                    int i9 = bArr3[i8] & 255;
                    int i10 = i >> 8;
                    if (i10 != 0) {
                        int i11 = i10 & 255;
                        int i12 = i >> 16;
                        if (i12 == 0) {
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = i | (i9 << 16);
                                return 257;
                            }
                            byte[] bArr4 = this._inputBuffer;
                            int i13 = this._inputPtr;
                            this._inputPtr = i13 + 1;
                            iDecodeUtf8_4 = decodeUtf8_4(i2, i11, i9, bArr4[i13] & 255);
                        } else {
                            iDecodeUtf8_4 = decodeUtf8_4(i2, i11, i12, i9);
                        }
                    } else {
                        if (this._inputPtr >= this._inputEnd) {
                            this._pendingInput = i | (i9 << 8);
                            return 257;
                        }
                        byte[] bArr5 = this._inputBuffer;
                        int i14 = this._inputPtr;
                        this._inputPtr = i14 + 1;
                        int i15 = bArr5[i14] & 255;
                        if (this._inputPtr >= this._inputEnd) {
                            this._pendingInput = i | (i9 << 8) | (i15 << 16);
                            return 257;
                        }
                        byte[] bArr6 = this._inputBuffer;
                        int i16 = this._inputPtr;
                        this._inputPtr = i16 + 1;
                        iDecodeUtf8_4 = decodeUtf8_4(i, i9, i15, bArr6[i16] & 255);
                    }
                    this._textBuilder.resetWithSurrogate(iDecodeUtf8_4);
                    this._currToken = 4;
                    return 4;
                }
                throwInternal();
            }
        }
        if (this._cfgCoalescing && !this._cfgLazyParsing) {
            return finishCharactersCoalescing();
        }
        this._currToken = 4;
        if (this._cfgLazyParsing) {
            this._tokenIncomplete = true;
        } else {
            finishCharacters();
        }
        return this._currToken;
    }

    protected final int finishCharactersCoalescing() throws XMLStreamException {
        if (this._pendingInput == 0 || handleAndAppendPending()) {
            throw new UnsupportedOperationException();
        }
        return 257;
    }

    @Override // com.fasterxml.aalto.AsyncInputFeeder
    public final boolean needMoreInput() {
        return this._inputPtr >= this._inputEnd && !this._endOfInput;
    }

    @Override // com.fasterxml.aalto.AsyncByteArrayFeeder
    public void feedInput(byte[] bArr, int i, int i2) throws XMLStreamException {
        if (this._inputPtr < this._inputEnd) {
            throw new XMLStreamException("Still have " + (this._inputEnd - this._inputPtr) + " unread bytes");
        }
        if (this._endOfInput) {
            throw new XMLStreamException("Already closed, can not feed more input");
        }
        this._pastBytesOrChars += (long) this._origBufferLen;
        this._rowStartOffset -= this._origBufferLen;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputEnd = i + i2;
        this._origBufferLen = i2;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public int nextFromTree() throws XMLStreamException {
        if (this._currToken != 257) {
            if (this._currToken == 1) {
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
            }
            setStartLocation();
            if (this._tokenIncomplete) {
                if (!skipCharacters()) {
                    return 257;
                }
                this._tokenIncomplete = false;
            }
            this._nextEvent = 257;
            this._currToken = 257;
            this._state = 0;
        }
        if (this._nextEvent == 257) {
            if (this._state == 0) {
                if (this._pendingInput != 0) {
                    this._nextEvent = 4;
                    return startCharactersPending();
                }
                if (this._inputPtr >= this._inputEnd) {
                    return this._currToken;
                }
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                byte b = bArr[i];
                if (b == 60) {
                    this._state = 1;
                } else if (b == 38) {
                    this._state = 2;
                } else {
                    this._nextEvent = 4;
                    return startCharacters(b);
                }
            }
            if (this._inputPtr >= this._inputEnd) {
                return this._currToken;
            }
            if (this._state == 1) {
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                byte b2 = bArr2[i2];
                if (b2 != 33) {
                    if (b2 == 63) {
                        this._nextEvent = 3;
                        this._state = 0;
                        return handlePI();
                    }
                    if (b2 == 47) {
                        return handleEndElementStart();
                    }
                    return handleStartElementStart(b2);
                }
                this._state = 3;
            } else {
                if (this._state == 2) {
                    return handleEntityStartingToken();
                }
                if (this._state == 6) {
                    return handleNamedEntityStartingToken();
                }
                if (this._state == 5) {
                    return handleNumericEntityStartingToken();
                }
            }
            if (this._state == 3) {
                if (this._inputPtr >= this._inputEnd) {
                    return this._currToken;
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                byte b3 = bArr3[i3];
                if (b3 == 45) {
                    this._nextEvent = 5;
                    this._state = 0;
                } else if (b3 == 91) {
                    this._nextEvent = 12;
                    this._state = 0;
                } else {
                    reportTreeUnexpChar(decodeCharForError(b3), " (expected either '-' for COMMENT or '[CDATA[' for CDATA section)");
                }
            } else {
                throwInternal();
            }
        }
        int i4 = this._nextEvent;
        if (i4 == 1) {
            return handleStartElement();
        }
        if (i4 == 2) {
            return handleEndElement();
        }
        if (i4 == 3) {
            return handlePI();
        }
        if (i4 != 4) {
            if (i4 == 5) {
                return handleComment();
            }
            if (i4 == 12) {
                return handleCData();
            }
        } else {
            if (!this._cfgLazyParsing && this._cfgCoalescing) {
                return finishCharactersCoalescing();
            }
            if (this._pendingInput != 0) {
                return startCharactersPending();
            }
            throwInternal();
        }
        return throwInternal();
    }

    private int handleCData() throws XMLStreamException {
        if (this._state == 1) {
            return parseCDataContents();
        }
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return handleCDataStartMarker(bArr[i]);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0070  */
    /* JADX WARN: Code duplicated, block: B:33:0x007e  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0090  */
    /* JADX WARN: Code duplicated, block: B:39:0x009c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d2  */
    private int handleCDataStartMarker(byte b) throws XMLStreamException {
        int i = this._state;
        if (i == 0) {
            if (b != 67) {
                reportTreeUnexpChar(decodeCharForError(b), " (expected 'C' for CDATA)");
            }
            this._state = 2;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            b = bArr[i2];
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                return throwInternal();
                            }
                        }
                        if (b != 91) {
                            reportTreeUnexpChar(decodeCharForError(b), " (expected '[' for CDATA)");
                        }
                        this._textBuilder.resetWithEmpty();
                        this._state = 1;
                        if (this._inputPtr >= this._inputEnd) {
                            return 257;
                        }
                        return parseCDataContents();
                    }
                    if (b != 65) {
                        reportTreeUnexpChar(decodeCharForError(b), " (expected 'A' for CDATA)");
                    }
                    this._state = 6;
                    if (this._inputPtr >= this._inputEnd) {
                        return 257;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    b = bArr2[i3];
                    if (b != 91) {
                        reportTreeUnexpChar(decodeCharForError(b), " (expected '[' for CDATA)");
                    }
                    this._textBuilder.resetWithEmpty();
                    this._state = 1;
                    if (this._inputPtr >= this._inputEnd) {
                        return 257;
                    }
                    return parseCDataContents();
                }
                if (b != 84) {
                    reportTreeUnexpChar(decodeCharForError(b), " (expected 'T' for CDATA)");
                }
                this._state = 5;
                if (this._inputPtr >= this._inputEnd) {
                    return 257;
                }
                byte[] bArr3 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                b = bArr3[i4];
                if (b != 65) {
                    reportTreeUnexpChar(decodeCharForError(b), " (expected 'A' for CDATA)");
                }
                this._state = 6;
                if (this._inputPtr >= this._inputEnd) {
                    return 257;
                }
                byte[] bArr4 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                b = bArr4[i5];
                if (b != 91) {
                    reportTreeUnexpChar(decodeCharForError(b), " (expected '[' for CDATA)");
                }
                this._textBuilder.resetWithEmpty();
                this._state = 1;
                if (this._inputPtr >= this._inputEnd) {
                    return 257;
                }
                return parseCDataContents();
            }
            if (b != 65) {
                reportTreeUnexpChar(decodeCharForError(b), " (expected 'A' for CDATA)");
            }
            this._state = 4;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            byte[] bArr5 = this._inputBuffer;
            int i6 = this._inputPtr;
            this._inputPtr = i6 + 1;
            b = bArr5[i6];
            if (b != 84) {
                reportTreeUnexpChar(decodeCharForError(b), " (expected 'T' for CDATA)");
            }
            this._state = 5;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            byte[] bArr6 = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            b = bArr6[i7];
            if (b != 65) {
                reportTreeUnexpChar(decodeCharForError(b), " (expected 'A' for CDATA)");
            }
            this._state = 6;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            byte[] bArr7 = this._inputBuffer;
            int i8 = this._inputPtr;
            this._inputPtr = i8 + 1;
            b = bArr7[i8];
            if (b != 91) {
                reportTreeUnexpChar(decodeCharForError(b), " (expected '[' for CDATA)");
            }
            this._textBuilder.resetWithEmpty();
            this._state = 1;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            return parseCDataContents();
        }
        if (b != 68) {
            reportTreeUnexpChar(decodeCharForError(b), " (expected 'D' for CDATA)");
        }
        this._state = 3;
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte[] bArr8 = this._inputBuffer;
        int i9 = this._inputPtr;
        this._inputPtr = i9 + 1;
        b = bArr8[i9];
        if (b != 65) {
            reportTreeUnexpChar(decodeCharForError(b), " (expected 'A' for CDATA)");
        }
        this._state = 4;
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte[] bArr9 = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        b = bArr9[i10];
        if (b != 84) {
            reportTreeUnexpChar(decodeCharForError(b), " (expected 'T' for CDATA)");
        }
        this._state = 5;
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte[] bArr10 = this._inputBuffer;
        int i11 = this._inputPtr;
        this._inputPtr = i11 + 1;
        b = bArr10[i11];
        if (b != 65) {
            reportTreeUnexpChar(decodeCharForError(b), " (expected 'A' for CDATA)");
        }
        this._state = 6;
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte[] bArr11 = this._inputBuffer;
        int i12 = this._inputPtr;
        this._inputPtr = i12 + 1;
        b = bArr11[i12];
        if (b != 91) {
            reportTreeUnexpChar(decodeCharForError(b), " (expected '[' for CDATA)");
        }
        this._textBuilder.resetWithEmpty();
        this._state = 1;
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        return parseCDataContents();
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x00bc  */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected int handlePI() throws XMLStreamException {
        if (this._state == 5) {
            return parsePIData();
        }
        while (this._inputPtr < this._inputEnd) {
            int i = this._state;
            if (i == 0) {
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                this._tokenName = parseNewName(bArr[i2]);
                if (this._tokenName == null) {
                    this._state = 4;
                    return 257;
                }
                this._state = 1;
                checkPITargetName(this._tokenName);
                if (this._inputPtr >= this._inputEnd) {
                    return 257;
                }
            } else if (i != 1) {
                if (i == 2) {
                    if (!asyncSkipSpace()) {
                        return 257;
                    }
                    this._state = 5;
                    this._textBuilder.resetWithEmpty();
                    return parsePIData();
                }
                if (i == 3) {
                    byte[] bArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    byte b = bArr2[i3];
                    if (b != 62) {
                        reportMissingPISpace(decodeCharForError(b));
                    }
                    this._state = 0;
                    this._nextEvent = 257;
                    return 3;
                }
                if (i == 4) {
                    this._tokenName = parsePName();
                    if (this._tokenName == null) {
                        return 257;
                    }
                    checkPITargetName(this._tokenName);
                    this._state = 1;
                } else {
                    return throwInternal();
                }
            }
            byte[] bArr3 = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            byte b2 = bArr3[i4];
            if (b2 == 63) {
                if (this._inputPtr < this._inputEnd && this._inputBuffer[this._inputPtr] == 62) {
                    this._inputPtr++;
                } else {
                    this._state = 3;
                }
            } else if (b2 == 32 || b2 == 13 || b2 == 10 || b2 == 9) {
                if (!asyncSkipSpace()) {
                    this._state = 2;
                    return 257;
                }
                this._textBuilder.resetWithEmpty();
                if (this._inputPtr + 1 < this._inputEnd && this._inputBuffer[this._inputPtr] == 63 && this._inputBuffer[this._inputPtr + 1] == 62) {
                    this._inputPtr += 2;
                } else {
                    this._state = 5;
                    return parsePIData();
                }
            } else {
                reportMissingPISpace(decodeCharForError(b2));
                if (!asyncSkipSpace()) {
                    return 257;
                }
                this._state = 5;
                this._textBuilder.resetWithEmpty();
                return parsePIData();
            }
            this._state = 0;
            this._nextEvent = 257;
            return 3;
        }
        return 257;
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final int handleComment() throws XMLStreamException {
        if (this._state == 1) {
            return parseCommentContents();
        }
        if (this._inputPtr >= this._inputEnd) {
            return 257;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (this._state == 0) {
            if (b != 45) {
                reportTreeUnexpChar(decodeCharForError(b), " (expected '-' for COMMENT)");
            }
            this._state = 1;
            this._textBuilder.resetWithEmpty();
            return parseCommentContents();
        }
        if (this._state == 3) {
            if (b != 62) {
                reportDoubleHyphenInComments();
            }
            this._state = 0;
            this._nextEvent = 257;
            return 5;
        }
        return throwInternal();
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected boolean asyncSkipSpace() throws XMLStreamException {
        while (this._inputPtr < this._inputEnd) {
            byte b = this._inputBuffer[this._inputPtr];
            if ((b & 255) > 32) {
                if (this._pendingInput == -1) {
                    markLF();
                    this._pendingInput = 0;
                }
                return true;
            }
            this._inputPtr++;
            if (b == 10) {
                markLF();
            } else if (b == 13) {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = -1;
                    break;
                }
                if (this._inputBuffer[this._inputPtr] == 10) {
                    this._inputPtr++;
                }
                markLF();
            } else if (b != 32 && b != 9) {
                throwInvalidSpace(b);
            }
        }
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int handleEntityStartingToken() throws XMLStreamException {
        this._textBuilder.resetWithEmpty();
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (b == 35) {
            this._textBuilder.resetWithEmpty();
            this._state = 5;
            this._pendingInput = -70;
            if (this._inputPtr >= this._inputEnd) {
                return 257;
            }
            return handleNumericEntityStartingToken();
        }
        PName newEntityName = parseNewEntityName(b);
        if (newEntityName == null) {
            this._state = 6;
            return 257;
        }
        int iDecodeGeneralEntity = decodeGeneralEntity(newEntityName);
        if (iDecodeGeneralEntity == 0) {
            this._tokenName = newEntityName;
            this._currToken = 9;
            this._nextEvent = 9;
            return 9;
        }
        this._textBuilder.resetWithChar((char) iDecodeGeneralEntity);
        this._nextEvent = 0;
        this._currToken = 4;
        if (this._cfgLazyParsing) {
            this._tokenIncomplete = true;
        } else {
            finishCharacters();
        }
        return this._currToken;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int handleNamedEntityStartingToken() throws XMLStreamException {
        PName entityName = parseEntityName();
        if (entityName == null) {
            return this._nextEvent;
        }
        int iDecodeGeneralEntity = decodeGeneralEntity(entityName);
        if (iDecodeGeneralEntity == 0) {
            this._tokenName = entityName;
            this._currToken = 9;
            return 9;
        }
        this._textBuilder.resetWithChar((char) iDecodeGeneralEntity);
        this._nextEvent = 0;
        this._currToken = 4;
        if (this._cfgLazyParsing) {
            this._tokenIncomplete = true;
        } else {
            finishCharacters();
        }
        return this._currToken;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int handleNumericEntityStartingToken() throws XMLStreamException {
        if (this._pendingInput == -70) {
            byte b = this._inputBuffer[this._inputPtr];
            this._entityValue = 0;
            if (b == 120) {
                this._pendingInput = -73;
                int i = this._inputPtr + 1;
                this._inputPtr = i;
                if (i >= this._inputEnd) {
                    return 257;
                }
            } else {
                this._pendingInput = -72;
            }
        }
        if (this._pendingInput == -73) {
            if (!decodeHexEntity()) {
                return 257;
            }
        } else if (!decodeDecEntity()) {
            return 257;
        }
        verifyAndAppendEntityCharacter(this._entityValue);
        this._currToken = 4;
        if (this._cfgLazyParsing) {
            this._tokenIncomplete = true;
        } else {
            finishCharacters();
        }
        this._pendingInput = 0;
        return this._currToken;
    }

    protected final boolean decodeHexEntity() throws XMLStreamException {
        int i;
        int i2;
        int i3 = this._entityValue;
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            byte b = bArr[i4];
            if (b == 59) {
                this._entityValue = i3;
                return true;
            }
            if (b > 57 || b < 48) {
                if (b <= 70 && b >= 65) {
                    i = b - 65;
                } else if (b > 102 || b < 97) {
                    throwUnexpectedChar(decodeCharForError(b), " expected a hex digit (0-9a-fA-F) for character entity");
                    i2 = b;
                } else {
                    i = b - 97;
                }
                i2 = i + 10;
            } else {
                i2 = b - 48;
            }
            i3 = (i3 << 4) + i2;
            if (i3 > 1114111) {
                this._entityValue = i3;
                reportEntityOverflow();
            }
        }
        this._entityValue = i3;
        return false;
    }

    protected final boolean decodeDecEntity() throws XMLStreamException {
        int i = this._entityValue;
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b = bArr[i2];
            if (b == 59) {
                this._entityValue = i;
                return true;
            }
            int i3 = b - 48;
            if (i3 < 0 || i3 > 9) {
                throwUnexpectedChar(decodeCharForError(b), " expected a digit (0 - 9) for character entity");
            }
            i = (i * 10) + i3;
            if (i > 1114111) {
                this._entityValue = i;
                reportEntityOverflow();
            }
        }
        this._entityValue = i;
        return false;
    }

    protected final int decodeGeneralEntity(PName pName) throws XMLStreamException {
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (b != 59) {
            throwUnexpectedChar(decodeCharForError(b), " expected ';' following entity name (\"" + pName.getPrefixedName() + "\")");
        }
        String prefixedName = pName.getPrefixedName();
        if (prefixedName == "amp") {
            return 38;
        }
        if (prefixedName == "lt") {
            return 60;
        }
        if (prefixedName == "apos") {
            return 39;
        }
        if (prefixedName == "quot") {
            return 34;
        }
        return prefixedName == "gt" ? 62 : 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected int handleStartElementStart(byte b) throws XMLStreamException {
        PName newName = parseNewName(b);
        this._nextEvent = 1;
        if (newName == null) {
            this._state = 1;
            return 257;
        }
        initStartElement(newName);
        return handleStartElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:104:0x0153  */
    /* JADX WARN: Code duplicated, block: B:111:0x016d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0177  */
    /* JADX WARN: Code duplicated, block: B:129:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x006e  */
    /* JADX WARN: Code duplicated, block: B:35:0x007e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0082 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x0084  */
    /* JADX WARN: Code duplicated, block: B:41:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0095  */
    /* JADX WARN: Code duplicated, block: B:45:0x009e  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:80:0x0109 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x0115 A[LOOP:1: B:66:0x00e1->B:85:0x0115, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x0133  */
    /* JADX WARN: Code duplicated, block: B:98:0x013d  */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected int handleStartElement() throws XMLStreamException {
        PName pName;
        byte b;
        int i;
        int i2;
        PName newName;
        byte b2;
        int i3;
        while (this._inputPtr < this._inputEnd) {
            switch (this._state) {
                case 1:
                    PName pName2 = parsePName();
                    if (pName2 == null) {
                        return 257;
                    }
                    initStartElement(pName2);
                    if (this._inputPtr >= this._inputEnd) {
                        return 257;
                    }
                    if (this._pendingInput != 0) {
                        if (!handlePartialCR()) {
                            return 257;
                        }
                    } else {
                        byte[] bArr = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        b2 = bArr[i4];
                        i3 = b2 & 255;
                        if (i3 <= 32) {
                            if (i3 == 62) {
                                return finishStartElement(false);
                            }
                            if (i3 == 47) {
                                this._state = 9;
                            } else {
                                throwUnexpectedChar(decodeCharForError(b2), " expected space, or '>' or \"/>\"");
                            }
                            break;
                        } else if (i3 == 10) {
                            markLF();
                        } else if (i3 == 13) {
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = -1;
                                return 257;
                            }
                            if (this._inputBuffer[this._inputPtr] == 10) {
                                this._inputPtr++;
                            }
                            markLF();
                        } else if (i3 != 32 && i3 != 9) {
                            throwInvalidSpace(i3);
                        }
                    }
                    this._state = 3;
                    if (this._inputPtr >= this._inputEnd) {
                        return 257;
                    }
                    if (this._pendingInput == 0 && (!handlePartialCR() || this._inputPtr >= this._inputEnd)) {
                        return 257;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i5 = this._inputPtr;
                    this._inputPtr = i5 + 1;
                    b = bArr2[i5];
                    while (true) {
                        i = b & 255;
                        if (i <= 32) {
                            if (i == 10) {
                                markLF();
                            } else if (i == 13) {
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return 257;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                            } else if (i != 32 && i != 9) {
                                throwInvalidSpace(i);
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                return 257;
                            }
                            byte[] bArr3 = this._inputBuffer;
                            int i6 = this._inputPtr;
                            this._inputPtr = i6 + 1;
                            b = bArr3[i6];
                        } else {
                            i2 = this._state;
                            if (i2 != 3) {
                                if (i2 == 5) {
                                    if (b != 61) {
                                        throwUnexpectedChar(decodeCharForError(b), " expected '='");
                                    }
                                    this._state = 6;
                                } else if (i2 == 6) {
                                    if (b != 34 && b != 39) {
                                        throwUnexpectedChar(decodeCharForError(b), " Expected a quote");
                                    }
                                    initAttribute(b);
                                } else {
                                    throwInternal();
                                    pName = parsePName();
                                    if (pName == null) {
                                        return 257;
                                    }
                                    this._elemAttrName = pName;
                                    this._state = 5;
                                }
                            } else if (b == 47) {
                                this._state = 9;
                            } else {
                                if (b == 62) {
                                    return finishStartElement(false);
                                }
                                newName = parseNewName(b);
                                if (newName == null) {
                                    this._state = 4;
                                    return 257;
                                }
                                this._state = 5;
                                this._elemAttrName = newName;
                            }
                        }
                        break;
                    }
                    break;
                case 2:
                    if (this._pendingInput != 0) {
                        if (!handlePartialCR()) {
                            return 257;
                        }
                    } else {
                        byte[] bArr4 = this._inputBuffer;
                        int i7 = this._inputPtr;
                        this._inputPtr = i7 + 1;
                        b2 = bArr4[i7];
                        i3 = b2 & 255;
                        if (i3 <= 32) {
                            if (i3 == 62) {
                                return finishStartElement(false);
                            }
                            if (i3 == 47) {
                                this._state = 9;
                            } else {
                                throwUnexpectedChar(decodeCharForError(b2), " expected space, or '>' or \"/>\"");
                            }
                            break;
                        } else if (i3 == 10) {
                            markLF();
                        } else if (i3 == 13) {
                            if (this._inputPtr >= this._inputEnd) {
                                this._pendingInput = -1;
                                return 257;
                            }
                            if (this._inputBuffer[this._inputPtr] == 10) {
                                this._inputPtr++;
                            }
                            markLF();
                        } else if (i3 != 32) {
                            throwInvalidSpace(i3);
                        }
                    }
                    this._state = 3;
                    if (this._inputPtr >= this._inputEnd) {
                        return 257;
                    }
                    if (this._pendingInput == 0) {
                    }
                    byte[] bArr5 = this._inputBuffer;
                    int i8 = this._inputPtr;
                    this._inputPtr = i8 + 1;
                    b = bArr5[i8];
                    while (true) {
                        i = b & 255;
                        if (i <= 32) {
                            if (i == 10) {
                                markLF();
                            } else if (i == 13) {
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return 257;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                            } else if (i != 32) {
                                throwInvalidSpace(i);
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                return 257;
                            }
                            byte[] bArr6 = this._inputBuffer;
                            int i9 = this._inputPtr;
                            this._inputPtr = i9 + 1;
                            b = bArr6[i9];
                        } else {
                            i2 = this._state;
                            if (i2 != 3) {
                                if (i2 == 5) {
                                    if (b != 61) {
                                        throwUnexpectedChar(decodeCharForError(b), " expected '='");
                                    }
                                    this._state = 6;
                                } else if (i2 == 6) {
                                    if (b != 34) {
                                        throwUnexpectedChar(decodeCharForError(b), " Expected a quote");
                                    }
                                    initAttribute(b);
                                } else {
                                    throwInternal();
                                    pName = parsePName();
                                    if (pName == null) {
                                        return 257;
                                    }
                                    this._elemAttrName = pName;
                                    this._state = 5;
                                }
                            } else if (b == 47) {
                                this._state = 9;
                            } else {
                                if (b == 62) {
                                    return finishStartElement(false);
                                }
                                newName = parseNewName(b);
                                if (newName == null) {
                                    this._state = 4;
                                    return 257;
                                }
                                this._state = 5;
                                this._elemAttrName = newName;
                            }
                        }
                        break;
                    }
                    break;
                case 3:
                case 5:
                case 6:
                    if (this._pendingInput == 0) {
                    }
                    byte[] bArr7 = this._inputBuffer;
                    int i10 = this._inputPtr;
                    this._inputPtr = i10 + 1;
                    b = bArr7[i10];
                    while (true) {
                        i = b & 255;
                        if (i <= 32) {
                            if (i == 10) {
                                markLF();
                            } else if (i == 13) {
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return 257;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                            } else if (i != 32) {
                                throwInvalidSpace(i);
                            }
                            if (this._inputPtr >= this._inputEnd) {
                                return 257;
                            }
                            byte[] bArr8 = this._inputBuffer;
                            int i11 = this._inputPtr;
                            this._inputPtr = i11 + 1;
                            b = bArr8[i11];
                        } else {
                            i2 = this._state;
                            if (i2 != 3) {
                                if (i2 == 5) {
                                    if (b != 61) {
                                        throwUnexpectedChar(decodeCharForError(b), " expected '='");
                                    }
                                    this._state = 6;
                                } else if (i2 == 6) {
                                    if (b != 34) {
                                        throwUnexpectedChar(decodeCharForError(b), " Expected a quote");
                                    }
                                    initAttribute(b);
                                } else {
                                    throwInternal();
                                    pName = parsePName();
                                    if (pName == null) {
                                        return 257;
                                    }
                                    this._elemAttrName = pName;
                                    this._state = 5;
                                }
                            } else if (b == 47) {
                                this._state = 9;
                            } else {
                                if (b == 62) {
                                    return finishStartElement(false);
                                }
                                newName = parseNewName(b);
                                if (newName == null) {
                                    this._state = 4;
                                    return 257;
                                }
                                this._state = 5;
                                this._elemAttrName = newName;
                            }
                        }
                        break;
                    }
                    break;
                case 4:
                    pName = parsePName();
                    if (pName == null) {
                        return 257;
                    }
                    this._elemAttrName = pName;
                    this._state = 5;
                    break;
                case 7:
                    if (!handleAttrValue()) {
                        return 257;
                    }
                    this._state = 2;
                    break;
                    break;
                case 8:
                    if (!handleNsDecl()) {
                        return 257;
                    }
                    this._state = 2;
                    break;
                    break;
                case 9:
                    byte[] bArr9 = this._inputBuffer;
                    int i12 = this._inputPtr;
                    this._inputPtr = i12 + 1;
                    byte b3 = bArr9[i12];
                    if (b3 != 62) {
                        throwUnexpectedChar(decodeCharForError(b3), " expected '>'");
                    }
                    return finishStartElement(true);
                default:
                    throwInternal();
                    break;
            }
        }
        return 257;
    }

    private void initStartElement(PName pName) {
        String prefix = pName.getPrefix();
        if (prefix == null) {
            this._elemAllNsBound = true;
        } else {
            pName = bindName(pName, prefix);
            this._elemAllNsBound = pName.isBound();
        }
        this._tokenName = pName;
        this._currElem = new ElementScope(pName, this._currElem);
        this._attrCount = 0;
        this._currNsCount = 0;
        this._elemAttrPtr = 0;
        this._state = 2;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    private void initAttribute(byte b) {
        boolean z;
        this._elemAttrQuote = b;
        PName pNameBindName = this._elemAttrName;
        String prefix = pNameBindName.getPrefix();
        if (prefix == null) {
            if (pNameBindName.getLocalName() == "xmlns") {
                z = true;
            } else {
                z = false;
            }
        } else if (prefix == "xmlns") {
            z = true;
        } else {
            pNameBindName = bindName(pNameBindName, prefix);
            if (this._elemAllNsBound) {
                this._elemAllNsBound = pNameBindName.isBound();
            }
            z = false;
        }
        if (z) {
            this._state = 8;
            this._elemNsPtr = 0;
            this._currNsCount++;
        } else {
            this._state = 7;
            this._attrCollector.startNewValue(pNameBindName, this._elemAttrPtr);
        }
    }

    private int finishStartElement(boolean z) throws XMLStreamException {
        this._isEmptyTag = z;
        int iFinishLastValue = this._attrCollector.finishLastValue(this._elemAttrPtr);
        if (iFinishLastValue < 0) {
            iFinishLastValue = this._attrCollector.getCount();
            reportInputProblem(this._attrCollector.getErrorMsg());
        }
        this._attrCount = iFinishLastValue;
        this._depth++;
        if (!this._elemAllNsBound) {
            if (!this._tokenName.isBound()) {
                reportUnboundPrefix(this._tokenName, false);
            }
            int i = this._attrCount;
            for (int i2 = 0; i2 < i; i2++) {
                PName name = this._attrCollector.getName(i2);
                if (!name.isBound()) {
                    reportUnboundPrefix(name, true);
                }
            }
        }
        this._currToken = 1;
        return 1;
    }

    private int handleEndElementStart() throws XMLStreamException {
        this._depth--;
        this._tokenName = this._currElem.getName();
        int iSizeInQuads = this._tokenName.sizeInQuads();
        if (this._inputEnd - this._inputPtr < (iSizeInQuads << 2) + 1) {
            this._nextEvent = 2;
            this._state = 0;
            this._currQuadBytes = 0;
            this._currQuad = 0;
            this._quadCount = 0;
            return handleEndElement();
        }
        byte[] bArr = this._inputBuffer;
        int i = iSizeInQuads - 1;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this._inputPtr;
            int i4 = (bArr[i3 + 3] & 255) | (bArr[i3] << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
            this._inputPtr += 4;
            if (i4 != this._tokenName.getQuad(i2)) {
                reportUnexpectedEndTag(this._tokenName.getPrefixedName());
            }
        }
        int quad = this._tokenName.getQuad(i);
        int i5 = this._inputPtr;
        this._inputPtr = i5 + 1;
        int i6 = bArr[i5] & 255;
        if (i6 != quad) {
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            int i8 = (i6 << 8) | (bArr[i7] & 255);
            if (i8 != quad) {
                int i9 = this._inputPtr;
                this._inputPtr = i9 + 1;
                int i10 = (i8 << 8) | (bArr[i9] & 255);
                if (i10 != quad) {
                    int i11 = this._inputPtr;
                    this._inputPtr = i11 + 1;
                    if (((bArr[i11] & 255) | (i10 << 8)) != quad) {
                        reportUnexpectedEndTag(this._tokenName.getPrefixedName());
                    }
                }
            }
        }
        byte[] bArr2 = this._inputBuffer;
        int i12 = this._inputPtr;
        this._inputPtr = i12 + 1;
        byte b = bArr2[i12];
        while (true) {
            int i13 = b & 255;
            if (i13 <= 32) {
                if (i13 == 10) {
                    markLF();
                } else if (i13 == 13) {
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = -1;
                        this._nextEvent = 2;
                        this._state = 1;
                        return 257;
                    }
                    if (this._inputBuffer[this._inputPtr] == 10) {
                        this._inputPtr++;
                    }
                    markLF();
                } else if (i13 != 32 && i13 != 9) {
                    throwInvalidSpace(i13);
                }
                if (this._inputPtr >= this._inputEnd) {
                    this._nextEvent = 2;
                    this._state = 1;
                    return 257;
                }
                byte[] bArr3 = this._inputBuffer;
                int i14 = this._inputPtr;
                this._inputPtr = i14 + 1;
                b = bArr3[i14];
            } else {
                if (i13 != 62) {
                    throwUnexpectedChar(decodeCharForError((byte) i13), " expected space or closing '>'");
                }
                this._currToken = 2;
                return 2;
            }
        }
    }

    private int handleEndElement() throws XMLStreamException {
        if (this._state == 0) {
            PName pName = this._tokenName;
            int iSizeInQuads = pName.sizeInQuads() - 1;
            while (this._quadCount < iSizeInQuads) {
                while (this._currQuadBytes < 4) {
                    if (this._inputPtr >= this._inputEnd) {
                        return 257;
                    }
                    int i = this._currQuad << 8;
                    byte[] bArr = this._inputBuffer;
                    int i2 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    this._currQuad = i | (bArr[i2] & 255);
                    this._currQuadBytes++;
                }
                if (this._currQuad != pName.getQuad(this._quadCount)) {
                    reportUnexpectedEndTag(pName.getPrefixedName());
                }
                this._currQuadBytes = 0;
                this._currQuad = 0;
                this._quadCount++;
            }
            int lastQuad = pName.getLastQuad();
            while (this._inputPtr < this._inputEnd) {
                int i3 = this._currQuad << 8;
                byte[] bArr2 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                int i5 = i3 | (bArr2[i4] & 255);
                this._currQuad = i5;
                if (i5 != lastQuad) {
                    int i6 = this._currQuadBytes + 1;
                    this._currQuadBytes = i6;
                    if (i6 > 3) {
                        reportUnexpectedEndTag(pName.getPrefixedName());
                    }
                }
                this._state = 1;
            }
            return 257;
        }
        if (this._state != 1) {
            throwInternal();
        }
        if (this._pendingInput != 0 && !handlePartialCR()) {
            return 257;
        }
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr3 = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            int i8 = bArr3[i7] & 255;
            if (i8 > 32) {
                if (i8 != 62) {
                    throwUnexpectedChar(decodeCharForError((byte) i8), " expected space or closing '>'");
                }
                this._currToken = 2;
                return 2;
            }
            if (i8 == 10) {
                markLF();
            } else if (i8 == 13) {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = -1;
                    return 257;
                }
                if (this._inputBuffer[this._inputPtr] == 10) {
                    this._inputPtr++;
                }
                markLF();
            } else if (i8 != 32 && i8 != 9) {
                throwInvalidSpace(i8);
            }
        }
        return 257;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX WARN: Code duplicated, block: B:36:0x009c  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final int startCharacters(byte b) throws XMLStreamException {
        int iDecodeUtf8_2 = b & 255;
        switch (this._charTypes.TEXT_CHARS[iDecodeUtf8_2]) {
            case 1:
                handleInvalidXmlChar(iDecodeUtf8_2);
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = -1;
                    return 257;
                }
                if (this._inputBuffer[this._inputPtr] == 10) {
                    this._inputPtr++;
                }
                markLF();
                iDecodeUtf8_2 = 10;
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing && !this._cfgLazyParsing) {
                    return finishCharactersCoalescing();
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 2:
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = -1;
                    return 257;
                }
                if (this._inputBuffer[this._inputPtr] == 10) {
                    this._inputPtr++;
                }
                markLF();
                iDecodeUtf8_2 = 10;
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 3:
                markLF();
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 4:
                reportInvalidInitial(iDecodeUtf8_2);
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 5:
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = iDecodeUtf8_2;
                    return 257;
                }
                iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 6:
                if (this._inputEnd - this._inputPtr < 2) {
                    if (this._inputEnd > this._inputPtr) {
                        byte[] bArr = this._inputBuffer;
                        int i = this._inputPtr;
                        this._inputPtr = i + 1;
                        iDecodeUtf8_2 |= (bArr[i] & 255) << 8;
                    }
                    this._pendingInput = iDecodeUtf8_2;
                    return 257;
                }
                iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 7:
                if (this._inputEnd - this._inputPtr < 3) {
                    if (this._inputEnd > this._inputPtr) {
                        byte[] bArr2 = this._inputBuffer;
                        int i2 = this._inputPtr;
                        this._inputPtr = i2 + 1;
                        iDecodeUtf8_2 |= (bArr2[i2] & 255) << 8;
                        if (this._inputEnd > this._inputPtr) {
                            byte[] bArr3 = this._inputBuffer;
                            int i3 = this._inputPtr;
                            this._inputPtr = i3 + 1;
                            iDecodeUtf8_2 |= (bArr3[i3] & 255) << 16;
                        }
                    }
                    this._pendingInput = iDecodeUtf8_2;
                    return 257;
                }
                this._textBuilder.resetWithSurrogate(decodeUtf8_4(iDecodeUtf8_2));
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 8:
            default:
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
            case 9:
            case 10:
                throwInternal();
                this._textBuilder.resetWithChar((char) iDecodeUtf8_2);
                if (!this._cfgCoalescing) {
                    break;
                }
                this._currToken = 4;
                if (this._cfgLazyParsing) {
                    this._tokenIncomplete = true;
                } else {
                    finishCharacters();
                }
                return this._currToken;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x00f9 A[PHI: r4 r5
  0x00f9: PHI (r4v20 int) = (r4v19 int), (r4v24 int) binds: [B:55:0x00f0, B:44:0x00a4] A[DONT_GENERATE, DONT_INLINE]
  0x00f9: PHI (r5v14 int) = (r5v13 int), (r5v17 int) binds: [B:55:0x00f0, B:44:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x0151  */
    /* JADX WARN: Code duplicated, block: B:81:0x0159  */
    /* JADX WARN: Code duplicated, block: B:94:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x004c. Please report as an issue. */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner, com.fasterxml.aalto.in.XmlScanner
    protected final void finishCharacters() throws XMLStreamException {
        int iDecodeUtf8_4;
        int i;
        if (this._pendingInput != 0) {
            throwInternal();
        }
        int[] iArr = this._charTypes.TEXT_CHARS;
        byte[] bArr = this._inputBuffer;
        char[] bufferWithoutReset = this._textBuilder.getBufferWithoutReset();
        int currentLength = this._textBuilder.getCurrentLength();
        while (true) {
            int i2 = this._inputPtr;
            if (i2 < this._inputEnd) {
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
                                        this._pendingInput = -1;
                                    } else {
                                        if (bArr[this._inputPtr] == 10) {
                                            this._inputPtr++;
                                        }
                                        markLF();
                                        iDecodeUtf8_2 = 10;
                                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                        currentLength++;
                                    }
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        this._pendingInput = -1;
                                    } else {
                                        if (bArr[this._inputPtr] == 10) {
                                            this._inputPtr++;
                                        }
                                        markLF();
                                        iDecodeUtf8_2 = 10;
                                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                        currentLength++;
                                    }
                                    break;
                                case 3:
                                    markLF();
                                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                    currentLength++;
                                    break;
                                case 4:
                                    reportInvalidInitial(iDecodeUtf8_2);
                                    this._inputPtr--;
                                    break;
                                case 5:
                                    if (this._inputPtr >= this._inputEnd) {
                                        this._pendingInput = iDecodeUtf8_2;
                                    } else {
                                        iDecodeUtf8_2 = decodeUtf8_2(iDecodeUtf8_2);
                                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                        currentLength++;
                                    }
                                    break;
                                case 6:
                                    if (this._inputEnd - this._inputPtr < 2) {
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr2 = this._inputBuffer;
                                            int i6 = this._inputPtr;
                                            this._inputPtr = i6 + 1;
                                            iDecodeUtf8_2 |= (bArr2[i6] & 255) << 8;
                                        }
                                        this._pendingInput = iDecodeUtf8_2;
                                    } else {
                                        iDecodeUtf8_2 = decodeUtf8_3(iDecodeUtf8_2);
                                        bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                        currentLength++;
                                    }
                                    break;
                                case 7:
                                    if (this._inputEnd - this._inputPtr < 3) {
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr3 = this._inputBuffer;
                                            int i7 = this._inputPtr;
                                            this._inputPtr = i7 + 1;
                                            iDecodeUtf8_2 |= (bArr3[i7] & 255) << 8;
                                            if (this._inputEnd > this._inputPtr) {
                                                byte[] bArr4 = this._inputBuffer;
                                                int i8 = this._inputPtr;
                                                this._inputPtr = i8 + 1;
                                                iDecodeUtf8_2 |= (bArr4[i8] & 255) << 16;
                                            }
                                        }
                                        this._pendingInput = iDecodeUtf8_2;
                                    } else {
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
                                    }
                                    break;
                                case 8:
                                default:
                                    bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                    currentLength++;
                                    break;
                                case 9:
                                    this._inputPtr--;
                                    break;
                                case 10:
                                    iDecodeUtf8_2 = handleEntityInCharacters();
                                    if (iDecodeUtf8_2 == 0) {
                                        this._inputPtr--;
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
                                    byte b = 0;
                                    int i9 = 1;
                                    while (this._inputPtr < this._inputEnd && (b = bArr[this._inputPtr]) == 93) {
                                        this._inputPtr++;
                                        i9++;
                                    }
                                    if (b == 62 && i9 > 1) {
                                        reportIllegalCDataEnd();
                                    }
                                    while (true) {
                                        i9--;
                                        if (i9 > 0) {
                                            int i10 = currentLength + 1;
                                            bufferWithoutReset[currentLength] = ']';
                                            if (i10 >= bufferWithoutReset.length) {
                                                bufferWithoutReset = this._textBuilder.finishCurrentSegment();
                                                currentLength = 0;
                                            } else {
                                                currentLength = i10;
                                            }
                                        } else {
                                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                                            currentLength++;
                                            break;
                                        }
                                    }
                                    break;
                            }
                        } else {
                            bufferWithoutReset[currentLength] = (char) iDecodeUtf8_2;
                            i2 = i5;
                            currentLength++;
                        }
                    } else {
                        this._inputPtr = i2;
                        break;
                    }
                }
            }
        }
        this._textBuilder.setCurrentLength(currentLength);
    }

    protected int handleEntityInCharacters() throws XMLStreamException {
        int i;
        int i2;
        int i3 = this._inputPtr;
        if (i3 + 3 > this._inputEnd) {
            return 0;
        }
        byte[] bArr = this._inputBuffer;
        int i4 = i3 + 1;
        byte b = bArr[i3];
        if (b == 35) {
            if (bArr[i4] == 120) {
                return handleHexEntityInCharacters(i4 + 1);
            }
            return handleDecEntityInCharacters(i4);
        }
        if (b == 97) {
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 == 109) {
                int i6 = i5 + 1;
                if (i6 >= this._inputPtr) {
                    return 0;
                }
                byte[] bArr2 = this._inputBuffer;
                if (bArr2[i5] != 112 || bArr2[i6] != 59) {
                    return 0;
                }
                this._inputPtr = i5 + 2;
                return 38;
            }
            if (b2 != 112 || (i2 = i5 + 2) >= this._inputPtr) {
                return 0;
            }
            byte[] bArr3 = this._inputBuffer;
            if (bArr3[i5] != 111 || bArr3[i5 + 1] != 115 || bArr3[i2] != 59) {
                return 0;
            }
            this._inputPtr = i5 + 3;
            return 39;
        }
        if (b == 103) {
            if (bArr[i4] != 116 || bArr[i4 + 1] != 59) {
                return 0;
            }
            this._inputPtr = i4 + 2;
            return 62;
        }
        if (b == 108) {
            if (bArr[i4] != 116 || bArr[i4 + 1] != 59) {
                return 0;
            }
            this._inputPtr = i4 + 2;
            return 60;
        }
        if (b != 113 || (i = i4 + 3) >= this._inputPtr) {
            return 0;
        }
        byte[] bArr4 = this._inputBuffer;
        if (bArr4[i4] != 117 || bArr4[i4 + 1] != 111 || bArr4[i4 + 2] != 116 || bArr4[i] != 59) {
            return 0;
        }
        this._inputPtr = i4 + 4;
        return 39;
    }

    protected int handleDecEntityInCharacters(int i) throws XMLStreamException {
        int i2 = i + 1;
        byte b = this._inputBuffer[i];
        int i3 = this._inputEnd;
        int i4 = 0;
        while (true) {
            if (b > 57 || b < 48) {
                throwUnexpectedChar(decodeCharForError(b), " expected a digit (0 - 9) for character entity");
            }
            i4 = (i4 * 10) + (b - 48);
            if (i4 > 1114111) {
                reportEntityOverflow();
            }
            if (i2 >= i3) {
                return 0;
            }
            int i5 = i2 + 1;
            b = this._inputBuffer[i2];
            if (b == 59) {
                this._inputPtr = i5;
                verifyXmlChar(i4);
                return i4;
            }
            i2 = i5;
        }
    }

    protected int handleHexEntityInCharacters(int i) throws XMLStreamException {
        int i2;
        int i3;
        int i4 = i + 1;
        byte b = this._inputBuffer[i];
        int i5 = this._inputEnd;
        int i6 = 0;
        byte b2 = b;
        while (true) {
            if (b2 > 57 || b2 < 48) {
                if (b2 <= 70 && b2 >= 65) {
                    i2 = b2 - 65;
                } else if (b2 > 102 || b2 < 97) {
                    throwUnexpectedChar(decodeCharForError(b2), " expected a hex digit (0-9a-fA-F) for character entity");
                    i3 = b2;
                } else {
                    i2 = b2 - 97;
                }
                i3 = i2 + 10;
            } else {
                i3 = b2 - 48;
            }
            i6 = (i6 << 4) + i3;
            if (i6 > 1114111) {
                reportEntityOverflow();
            }
            if (i4 >= i5) {
                return 0;
            }
            int i7 = i4 + 1;
            byte b3 = this._inputBuffer[i4];
            if (b3 == 59) {
                this._inputPtr = i7;
                verifyXmlChar(i6);
                return i6;
            }
            i4 = i7;
            b2 = b3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final boolean handleAndAppendPending() throws XMLStreamException {
        int iDecodeUtf8_3;
        int iDecodeUtf8_4;
        if (this._inputPtr >= this._inputEnd) {
            return false;
        }
        int i = this._pendingInput;
        this._pendingInput = 0;
        if (i < 0) {
            if (i == -1) {
                if (this._inputBuffer[this._inputPtr] == 10) {
                    this._inputPtr++;
                }
                markLF();
                this._textBuilder.append('\n');
                return true;
            }
            throwInternal();
        }
        int i2 = i & 255;
        int i3 = this._charTypes.TEXT_CHARS[i2];
        if (i3 == 5) {
            this._textBuilder.append((char) decodeUtf8_2(i));
        } else if (i3 == 6) {
            byte[] bArr = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            int i5 = bArr[i4] & 255;
            int i6 = i >> 8;
            if (i6 == 0) {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i | (i5 << 8);
                    return false;
                }
                byte[] bArr2 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                iDecodeUtf8_3 = decodeUtf8_3(i, i5, bArr2[i7] & 255);
            } else {
                iDecodeUtf8_3 = decodeUtf8_3(i2, i6, i5);
            }
            this._textBuilder.append((char) iDecodeUtf8_3);
        } else if (i3 == 7) {
            byte[] bArr3 = this._inputBuffer;
            int i8 = this._inputPtr;
            this._inputPtr = i8 + 1;
            int i9 = bArr3[i8] & 255;
            int i10 = i >> 8;
            if (i10 != 0) {
                int i11 = i10 & 255;
                int i12 = i >> 16;
                if (i12 == 0) {
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = i | (i9 << 16);
                        return false;
                    }
                    byte[] bArr4 = this._inputBuffer;
                    int i13 = this._inputPtr;
                    this._inputPtr = i13 + 1;
                    iDecodeUtf8_4 = decodeUtf8_4(i2, i11, i9, bArr4[i13] & 255);
                } else {
                    iDecodeUtf8_4 = decodeUtf8_4(i2, i11, i12, i9);
                }
            } else {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i | (i9 << 8);
                    return false;
                }
                byte[] bArr5 = this._inputBuffer;
                int i14 = this._inputPtr;
                this._inputPtr = i14 + 1;
                int i15 = bArr5[i14] & 255;
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i | (i9 << 8) | (i15 << 16);
                    return false;
                }
                byte[] bArr6 = this._inputBuffer;
                int i16 = this._inputPtr;
                this._inputPtr = i16 + 1;
                iDecodeUtf8_4 = decodeUtf8_4(i, i9, i15, bArr6[i16] & 255);
            }
            this._textBuilder.appendSurrogate(iDecodeUtf8_4);
        } else {
            throwInternal();
        }
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:65:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ee A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner, com.fasterxml.aalto.in.XmlScanner
    protected boolean skipCharacters() throws XMLStreamException {
        if (this._pendingInput != 0 && !skipPending()) {
            return false;
        }
        int[] iArr = this._charTypes.TEXT_CHARS;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i < i2) {
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
                                        this._pendingInput = -1;
                                    } else {
                                        if (bArr[this._inputPtr] == 10) {
                                            this._inputPtr++;
                                        }
                                        markLF();
                                    }
                                    break;
                                case 2:
                                    if (this._inputPtr >= this._inputEnd) {
                                        this._pendingInput = -1;
                                    } else {
                                        if (bArr[this._inputPtr] == 10) {
                                            this._inputPtr++;
                                        }
                                        markLF();
                                    }
                                    break;
                                case 3:
                                    markLF();
                                    break;
                                case 4:
                                    reportInvalidInitial(i4);
                                    this._inputPtr--;
                                    return true;
                                case 5:
                                    if (this._inputPtr >= this._inputEnd) {
                                        this._pendingInput = i4;
                                    } else {
                                        skipUtf8_2(i4);
                                    }
                                    break;
                                case 6:
                                    if (this._inputEnd - this._inputPtr < 2) {
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr2 = this._inputBuffer;
                                            int i5 = this._inputPtr;
                                            this._inputPtr = i5 + 1;
                                            i4 |= (bArr2[i5] & 255) << 8;
                                        }
                                        this._pendingInput = i4;
                                    } else {
                                        decodeUtf8_3(i4);
                                    }
                                    break;
                                case 7:
                                    if (this._inputEnd - this._inputPtr < 3) {
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr3 = this._inputBuffer;
                                            int i6 = this._inputPtr;
                                            this._inputPtr = i6 + 1;
                                            i4 |= (bArr3[i6] & 255) << 8;
                                            if (this._inputEnd > this._inputPtr) {
                                                byte[] bArr4 = this._inputBuffer;
                                                int i7 = this._inputPtr;
                                                this._inputPtr = i7 + 1;
                                                i4 |= (bArr4[i7] & 255) << 16;
                                            }
                                        }
                                        this._pendingInput = i4;
                                    } else {
                                        decodeUtf8_4(i4);
                                    }
                                    break;
                                case 8:
                                default:
                                    break;
                                case 9:
                                    this._inputPtr--;
                                    return true;
                                case 10:
                                    if (skipEntityInCharacters() != 0) {
                                        break;
                                    }
                                    this._pendingInput = -80;
                                    return this._inputPtr < this._inputEnd && skipPending();
                                case 11:
                                    byte b = 0;
                                    int i8 = 1;
                                    while (this._inputPtr < this._inputEnd && (b = bArr[this._inputPtr]) == 93) {
                                        this._inputPtr++;
                                        i8++;
                                    }
                                    if (b == 62 && i8 > 1) {
                                        reportIllegalCDataEnd();
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
        }
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final boolean skipPending() throws XMLStreamException {
        if (this._inputPtr >= this._inputEnd) {
            return false;
        }
        if (this._pendingInput < 0) {
            do {
                int i = this._pendingInput;
                if (i == -1) {
                    this._pendingInput = 0;
                    if (this._inputBuffer[this._inputPtr] == 10) {
                        this._inputPtr++;
                    }
                    markLF();
                    return true;
                }
                switch (i) {
                    case -86:
                        byte b = this._inputBuffer[this._inputPtr];
                        if (b == 93) {
                            this._inputPtr++;
                        } else {
                            if (b == 62) {
                                this._inputPtr++;
                                reportInputProblem("Encountered ']]>' in text segment");
                            }
                            this._pendingInput = 0;
                            return true;
                        }
                        break;
                    case -85:
                        if (this._inputBuffer[this._inputPtr] != 93) {
                            this._pendingInput = 0;
                            return true;
                        }
                        this._inputPtr++;
                        this._pendingInput = -86;
                        break;
                        break;
                    case -84:
                        PName entityName = parseEntityName();
                        if (entityName == null) {
                            return false;
                        }
                        if (decodeGeneralEntity(entityName) == 0) {
                            this._tokenName = entityName;
                            this._nextEvent = 9;
                        }
                        this._pendingInput = 0;
                        return true;
                    case -83:
                        if (!decodeHexEntity()) {
                            return false;
                        }
                        this._pendingInput = 0;
                        return true;
                    case -82:
                        if (!decodeDecEntity()) {
                            return false;
                        }
                        this._pendingInput = 0;
                        return true;
                    case -81:
                        this._entityValue = 0;
                        if (this._inputBuffer[this._inputPtr] == 120) {
                            this._inputPtr++;
                            if (decodeHexEntity()) {
                                this._pendingInput = 0;
                                return true;
                            }
                            this._pendingInput = -83;
                            return false;
                        }
                        if (decodeDecEntity()) {
                            this._pendingInput = 0;
                            return true;
                        }
                        this._pendingInput = -82;
                        return false;
                    case -80:
                        byte[] bArr = this._inputBuffer;
                        int i2 = this._inputPtr;
                        this._inputPtr = i2 + 1;
                        byte b2 = bArr[i2];
                        if (b2 == 35) {
                            this._pendingInput = -81;
                        } else {
                            PName newEntityName = parseNewEntityName(b2);
                            if (newEntityName == null) {
                                this._pendingInput = -84;
                                return false;
                            }
                            if (decodeGeneralEntity(newEntityName) == 0) {
                                this._tokenName = newEntityName;
                                this._nextEvent = 9;
                            }
                            this._pendingInput = 0;
                            return true;
                        }
                        break;
                    default:
                        throwInternal();
                        break;
                }
            } while (this._inputPtr < this._inputEnd);
            return false;
        }
        int i3 = this._pendingInput;
        int i4 = i3 & 255;
        int i5 = this._charTypes.TEXT_CHARS[i4];
        if (i5 == 5) {
            skipUtf8_2(i3);
        } else if (i5 == 6) {
            byte[] bArr2 = this._inputBuffer;
            int i6 = this._inputPtr;
            this._inputPtr = i6 + 1;
            int i7 = bArr2[i6] & 255;
            int i8 = i3 >> 8;
            if (i8 == 0) {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i3 | (i7 << 8);
                    return false;
                }
                byte[] bArr3 = this._inputBuffer;
                int i9 = this._inputPtr;
                this._inputPtr = i9 + 1;
                decodeUtf8_3(i3, i7, bArr3[i9] & 255);
            } else {
                decodeUtf8_3(i4, i8, i7);
            }
        } else if (i5 == 7) {
            byte[] bArr4 = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            int i11 = bArr4[i10] & 255;
            int i12 = i3 >> 8;
            if (i12 != 0) {
                int i13 = i12 & 255;
                int i14 = i3 >> 16;
                if (i14 == 0) {
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = i3 | (i11 << 16);
                        return false;
                    }
                    byte[] bArr5 = this._inputBuffer;
                    int i15 = this._inputPtr;
                    this._inputPtr = i15 + 1;
                    decodeUtf8_4(i4, i13, i11, bArr5[i15] & 255);
                } else {
                    decodeUtf8_4(i4, i13, i14, i11);
                }
            } else {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i3 | (i11 << 8);
                    return false;
                }
                byte[] bArr6 = this._inputBuffer;
                int i16 = this._inputPtr;
                this._inputPtr = i16 + 1;
                int i17 = bArr6[i16] & 255;
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i3 | (i11 << 8) | (i17 << 16);
                    return false;
                }
                byte[] bArr7 = this._inputBuffer;
                int i18 = this._inputPtr;
                this._inputPtr = i18 + 1;
                decodeUtf8_4(i3, i11, i17, bArr7[i18] & 255);
            }
        } else {
            throwInternal();
        }
        this._pendingInput = 0;
        return true;
    }

    private int skipEntityInCharacters() throws XMLStreamException {
        int i;
        int i2;
        int i3 = this._inputPtr;
        if (i3 + 3 > this._inputEnd) {
            return 0;
        }
        byte[] bArr = this._inputBuffer;
        int i4 = i3 + 1;
        byte b = bArr[i3];
        if (b == 35) {
            if (bArr[i4] == 120) {
                return handleHexEntityInCharacters(i4 + 1);
            }
            return handleDecEntityInCharacters(i4);
        }
        if (b == 97) {
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 == 109) {
                int i6 = i5 + 1;
                if (i6 >= this._inputPtr) {
                    return 0;
                }
                byte[] bArr2 = this._inputBuffer;
                if (bArr2[i5] != 112 || bArr2[i6] != 59) {
                    return 0;
                }
                this._inputPtr = i5 + 2;
                return 38;
            }
            if (b2 != 112 || (i2 = i5 + 2) >= this._inputPtr) {
                return 0;
            }
            byte[] bArr3 = this._inputBuffer;
            if (bArr3[i5] != 111 || bArr3[i5 + 1] != 115 || bArr3[i2] != 59) {
                return 0;
            }
            this._inputPtr = i5 + 3;
            return 39;
        }
        if (b == 103) {
            if (bArr[i4] != 116 || bArr[i4 + 1] != 59) {
                return 0;
            }
            this._inputPtr = i4 + 2;
            return 62;
        }
        if (b == 108) {
            if (bArr[i4] != 116 || bArr[i4 + 1] != 59) {
                return 0;
            }
            this._inputPtr = i4 + 2;
            return 60;
        }
        if (b != 113 || (i = i4 + 3) >= this._inputPtr) {
            return 0;
        }
        byte[] bArr4 = this._inputBuffer;
        if (bArr4[i4] != 117 || bArr4[i4 + 1] != 111 || bArr4[i4 + 2] != 116 || bArr4[i] != 59) {
            return 0;
        }
        this._inputPtr = i4 + 4;
        return 39;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected boolean skipCoalescedText() throws XMLStreamException {
        throwInternal();
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:56:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:63:0x0115  */
    /* JADX WARN: Code duplicated, block: B:69:0x0129  */
    /* JADX WARN: Code duplicated, block: B:71:0x0133  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0125 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected boolean handleAttrValue() throws XMLStreamException {
        if (this._pendingInput != 0) {
            if (!handleAttrValuePending()) {
                return false;
            }
            this._pendingInput = 0;
        }
        char[] cArrContinueValue = this._attrCollector.continueValue();
        int[] iArr = this._charTypes.ATTR_CHARS;
        byte b = this._elemAttrQuote;
        while (this._inputPtr < this._inputEnd) {
            if (this._elemAttrPtr >= cArrContinueValue.length) {
                cArrContinueValue = this._attrCollector.valueBufferFull();
            }
            int i = this._inputEnd;
            int length = this._inputPtr + (cArrContinueValue.length - this._elemAttrPtr);
            if (length < i) {
                i = length;
            }
            while (this._inputPtr < i) {
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int iHandleEntityInAttributeValue = bArr[i2] & 255;
                int i3 = iArr[iHandleEntityInAttributeValue];
                if (i3 == 0) {
                    int i4 = this._elemAttrPtr;
                    this._elemAttrPtr = i4 + 1;
                    cArrContinueValue[i4] = (char) iHandleEntityInAttributeValue;
                } else {
                    if (i3 != 14) {
                        switch (i3) {
                            case 1:
                                handleInvalidXmlChar(iHandleEntityInAttributeValue);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return false;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iHandleEntityInAttributeValue = 32;
                                break;
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return false;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iHandleEntityInAttributeValue = 32;
                                break;
                                break;
                            case 3:
                                markLF();
                                iHandleEntityInAttributeValue = 32;
                                break;
                            case 4:
                                reportInvalidInitial(iHandleEntityInAttributeValue);
                                throwUnexpectedChar(iHandleEntityInAttributeValue, "'<' not allowed in attribute value");
                                iHandleEntityInAttributeValue = handleEntityInAttributeValue();
                                if (iHandleEntityInAttributeValue <= 0) {
                                    if (iHandleEntityInAttributeValue < 0) {
                                        return false;
                                    }
                                    reportUnexpandedEntityInAttr(this._elemAttrName, false);
                                }
                                if ((iHandleEntityInAttributeValue >> 16) != 0) {
                                    int i5 = iHandleEntityInAttributeValue - 65536;
                                    int i6 = this._elemAttrPtr;
                                    this._elemAttrPtr = i6 + 1;
                                    cArrContinueValue[i6] = (char) ((i5 >> 10) | 55296);
                                    iHandleEntityInAttributeValue = (i5 & 1023) | 56320;
                                    if (this._elemAttrPtr >= cArrContinueValue.length) {
                                        cArrContinueValue = this._attrCollector.valueBufferFull();
                                    }
                                }
                                break;
                            case 5:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = iHandleEntityInAttributeValue;
                                    return false;
                                }
                                iHandleEntityInAttributeValue = decodeUtf8_2(iHandleEntityInAttributeValue);
                                break;
                                break;
                            case 6:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr2 = this._inputBuffer;
                                        int i7 = this._inputPtr;
                                        this._inputPtr = i7 + 1;
                                        iHandleEntityInAttributeValue |= (bArr2[i7] & 255) << 8;
                                    }
                                    this._pendingInput = iHandleEntityInAttributeValue;
                                    return false;
                                }
                                iHandleEntityInAttributeValue = decodeUtf8_3(iHandleEntityInAttributeValue);
                                break;
                                break;
                            case 7:
                                if (this._inputEnd - this._inputPtr < 3) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr3 = this._inputBuffer;
                                        int i8 = this._inputPtr;
                                        this._inputPtr = i8 + 1;
                                        iHandleEntityInAttributeValue |= (bArr3[i8] & 255) << 8;
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr4 = this._inputBuffer;
                                            int i9 = this._inputPtr;
                                            this._inputPtr = i9 + 1;
                                            iHandleEntityInAttributeValue |= (bArr4[i9] & 255) << 16;
                                        }
                                    }
                                    this._pendingInput = iHandleEntityInAttributeValue;
                                    return false;
                                }
                                int iDecodeUtf8_4 = decodeUtf8_4(iHandleEntityInAttributeValue);
                                int i10 = this._elemAttrPtr;
                                this._elemAttrPtr = i10 + 1;
                                cArrContinueValue[i10] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                iHandleEntityInAttributeValue = (iDecodeUtf8_4 & 1023) | 56320;
                                if (this._elemAttrPtr >= cArrContinueValue.length) {
                                    cArrContinueValue = this._attrCollector.valueBufferFull();
                                }
                                break;
                                break;
                            case 8:
                                iHandleEntityInAttributeValue = 32;
                                break;
                            case 9:
                                throwUnexpectedChar(iHandleEntityInAttributeValue, "'<' not allowed in attribute value");
                                iHandleEntityInAttributeValue = handleEntityInAttributeValue();
                                if (iHandleEntityInAttributeValue <= 0) {
                                    if (iHandleEntityInAttributeValue < 0) {
                                        return false;
                                    }
                                    reportUnexpandedEntityInAttr(this._elemAttrName, false);
                                }
                                if ((iHandleEntityInAttributeValue >> 16) != 0) {
                                    int i11 = iHandleEntityInAttributeValue - 65536;
                                    int i12 = this._elemAttrPtr;
                                    this._elemAttrPtr = i12 + 1;
                                    cArrContinueValue[i12] = (char) ((i11 >> 10) | 55296);
                                    iHandleEntityInAttributeValue = (i11 & 1023) | 56320;
                                    if (this._elemAttrPtr >= cArrContinueValue.length) {
                                        cArrContinueValue = this._attrCollector.valueBufferFull();
                                    }
                                }
                                break;
                            case 10:
                                iHandleEntityInAttributeValue = handleEntityInAttributeValue();
                                if (iHandleEntityInAttributeValue <= 0) {
                                    if (iHandleEntityInAttributeValue < 0) {
                                        return false;
                                    }
                                    reportUnexpandedEntityInAttr(this._elemAttrName, false);
                                }
                                if ((iHandleEntityInAttributeValue >> 16) != 0) {
                                    int i13 = iHandleEntityInAttributeValue - 65536;
                                    int i14 = this._elemAttrPtr;
                                    this._elemAttrPtr = i14 + 1;
                                    cArrContinueValue[i14] = (char) ((i13 >> 10) | 55296);
                                    iHandleEntityInAttributeValue = (i13 & 1023) | 56320;
                                    if (this._elemAttrPtr >= cArrContinueValue.length) {
                                        cArrContinueValue = this._attrCollector.valueBufferFull();
                                    }
                                }
                                break;
                        }
                    } else if (iHandleEntityInAttributeValue == b) {
                        return true;
                    }
                    int i15 = this._elemAttrPtr;
                    this._elemAttrPtr = i15 + 1;
                    cArrContinueValue[i15] = (char) iHandleEntityInAttributeValue;
                    break;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final boolean handleAttrValuePending() throws XMLStreamException {
        int iHandleAttrValuePendingUTF8;
        int iDecodeGeneralEntity;
        if (this._pendingInput == -1) {
            if (!handlePartialCR()) {
                return false;
            }
            char[] cArrContinueValue = this._attrCollector.continueValue();
            if (this._elemAttrPtr >= cArrContinueValue.length) {
                cArrContinueValue = this._attrCollector.valueBufferFull();
            }
            int i = this._elemAttrPtr;
            this._elemAttrPtr = i + 1;
            cArrContinueValue[i] = XmlConsts.CHAR_SPACE;
            return true;
        }
        if (this._inputPtr >= this._inputEnd) {
            return false;
        }
        if (this._pendingInput == -60) {
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b = bArr[i2];
            if (b == 35) {
                this._pendingInput = -61;
                if (this._inputPtr >= this._inputEnd) {
                    return false;
                }
                if (this._inputBuffer[this._inputPtr] == 120) {
                    this._pendingInput = -62;
                    this._inputPtr++;
                    if (this._inputPtr >= this._inputEnd) {
                        return false;
                    }
                    iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(true);
                } else {
                    iHandleAttrValuePendingUTF8 = handleDecEntityInAttribute(true);
                }
            } else {
                PName newEntityName = parseNewEntityName(b);
                if (newEntityName == null) {
                    this._pendingInput = -63;
                    return false;
                }
                iDecodeGeneralEntity = decodeGeneralEntity(newEntityName);
                if (iDecodeGeneralEntity == 0) {
                    this._tokenName = newEntityName;
                    reportUnexpandedEntityInAttr(this._elemAttrName, false);
                }
                iHandleAttrValuePendingUTF8 = iDecodeGeneralEntity;
            }
        } else if (this._pendingInput == -61) {
            if (this._inputBuffer[this._inputPtr] == 120) {
                this._pendingInput = -62;
                this._inputPtr++;
                if (this._inputPtr >= this._inputEnd) {
                    return false;
                }
                iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(true);
            } else {
                iHandleAttrValuePendingUTF8 = handleDecEntityInAttribute(true);
            }
        } else if (this._pendingInput == -62) {
            iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(true);
        } else if (this._pendingInput == -63) {
            PName entityName = parseEntityName();
            if (entityName == null) {
                return false;
            }
            iDecodeGeneralEntity = decodeGeneralEntity(entityName);
            if (iDecodeGeneralEntity == 0) {
                this._tokenName = entityName;
                reportUnexpandedEntityInAttr(this._elemAttrName, false);
            }
            iHandleAttrValuePendingUTF8 = iDecodeGeneralEntity;
        } else if (this._pendingInput == -64) {
            iHandleAttrValuePendingUTF8 = handleDecEntityInAttribute(false);
        } else if (this._pendingInput == -65) {
            iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(false);
        } else {
            iHandleAttrValuePendingUTF8 = handleAttrValuePendingUTF8();
        }
        if (iHandleAttrValuePendingUTF8 == 0) {
            return false;
        }
        char[] cArrContinueValue2 = this._attrCollector.continueValue();
        if ((iHandleAttrValuePendingUTF8 >> 16) != 0) {
            int i3 = iHandleAttrValuePendingUTF8 - 65536;
            if (this._elemAttrPtr >= cArrContinueValue2.length) {
                cArrContinueValue2 = this._attrCollector.valueBufferFull();
            }
            int i4 = this._elemAttrPtr;
            this._elemAttrPtr = i4 + 1;
            cArrContinueValue2[i4] = (char) ((i3 >> 10) | 55296);
            iHandleAttrValuePendingUTF8 = (i3 & 1023) | 56320;
        }
        if (this._elemAttrPtr >= cArrContinueValue2.length) {
            cArrContinueValue2 = this._attrCollector.valueBufferFull();
        }
        int i5 = this._elemAttrPtr;
        this._elemAttrPtr = i5 + 1;
        cArrContinueValue2[i5] = (char) iHandleAttrValuePendingUTF8;
        return true;
    }

    private final int handleAttrValuePendingUTF8() throws XMLStreamException {
        int i = this._pendingInput;
        this._pendingInput = 0;
        int i2 = i & 255;
        int i3 = this._charTypes.TEXT_CHARS[i2];
        if (i3 == 5) {
            return decodeUtf8_2(i);
        }
        if (i3 == 6) {
            byte[] bArr = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            int i5 = bArr[i4] & 255;
            int i6 = i >> 8;
            if (i6 == 0) {
                if (this._inputPtr >= this._inputEnd) {
                    this._pendingInput = i | (i5 << 8);
                    return 0;
                }
                byte[] bArr2 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                return decodeUtf8_3(i, i5, bArr2[i7] & 255);
            }
            return decodeUtf8_3(i2, i6, i5);
        }
        if (i3 == 7) {
            byte[] bArr3 = this._inputBuffer;
            int i8 = this._inputPtr;
            this._inputPtr = i8 + 1;
            int i9 = bArr3[i8] & 255;
            int i10 = i >> 8;
            if (i10 != 0) {
                int i11 = i10 & 255;
                int i12 = i >> 16;
                if (i12 == 0) {
                    if (this._inputPtr >= this._inputEnd) {
                        this._pendingInput = i | (i9 << 16);
                        return 0;
                    }
                    byte[] bArr4 = this._inputBuffer;
                    int i13 = this._inputPtr;
                    this._inputPtr = i13 + 1;
                    return decodeUtf8_4(i2, i11, i9, bArr4[i13] & 255);
                }
                return decodeUtf8_4(i2, i11, i12, i9);
            }
            if (this._inputPtr >= this._inputEnd) {
                this._pendingInput = i | (i9 << 8);
                return 0;
            }
            byte[] bArr5 = this._inputBuffer;
            int i14 = this._inputPtr;
            this._inputPtr = i14 + 1;
            int i15 = bArr5[i14] & 255;
            if (this._inputPtr >= this._inputEnd) {
                this._pendingInput = i | (i9 << 8) | (i15 << 16);
                return 0;
            }
            byte[] bArr6 = this._inputBuffer;
            int i16 = this._inputPtr;
            this._inputPtr = i16 + 1;
            return decodeUtf8_4(i, i9, i15, bArr6[i16] & 255);
        }
        throwInternal();
        return 0;
    }

    private final int handleDecEntityInAttribute(boolean z) throws XMLStreamException {
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (z) {
            if (b < 48 || b > 57) {
                throwUnexpectedChar(decodeCharForError(b), " expected a digit (0 - 9) for character entity");
            }
            this._pendingInput = -64;
            this._entityValue = b - 48;
            if (this._inputPtr >= this._inputEnd) {
                return 0;
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            b = bArr2[i2];
        }
        while (b != 59) {
            int i3 = b - 48;
            if (i3 < 0 || i3 > 9) {
                throwUnexpectedChar(decodeCharForError(b), " expected a digit (0 - 9) for character entity");
            }
            int i4 = (this._entityValue * 10) + i3;
            this._entityValue = i4;
            if (i4 > 1114111) {
                reportEntityOverflow();
            }
            if (this._inputPtr >= this._inputEnd) {
                return 0;
            }
            byte[] bArr3 = this._inputBuffer;
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            b = bArr3[i5];
        }
        verifyXmlChar(this._entityValue);
        this._pendingInput = 0;
        return this._entityValue;
    }

    private final int handleHexEntityInAttribute(boolean z) throws XMLStreamException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        byte[] bArr = this._inputBuffer;
        int i6 = this._inputPtr;
        this._inputPtr = i6 + 1;
        byte b = bArr[i6];
        while (b != 59) {
            if (b > 57 || b < 48) {
                if (b <= 70 && b >= 65) {
                    i = b - 65;
                } else if (b > 102 || b < 97) {
                    throwUnexpectedChar(decodeCharForError(b), " expected a hex digit (0-9a-fA-F) for character entity");
                    i2 = b;
                } else {
                    i = b - 97;
                }
                i2 = i + 10;
            } else {
                i5 = b - 48;
            }
            if (z) {
                i2 = i5;
                this._pendingInput = -65;
                z = false;
                i4 = i2;
            } else {
                i3 = i2 + (this._entityValue << 4);
                if (i3 > 1114111) {
                    i2 = i5;
                    i4 = i3;
                    reportEntityOverflow();
                    i4 = i3;
                }
            }
            i2 = i5;
            i4 = i3;
            this._entityValue = i4;
            if (this._inputPtr >= this._inputEnd) {
                return 0;
            }
            byte[] bArr2 = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            b = bArr2[i7];
        }
        verifyXmlChar(this._entityValue);
        this._pendingInput = 0;
        return this._entityValue;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int handleEntityInAttributeValue() throws XMLStreamException {
        int iHandleDecEntityInAttribute;
        if (this._inputPtr >= this._inputEnd) {
            this._pendingInput = -60;
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (b == 35) {
            this._pendingInput = -61;
            if (this._inputPtr >= this._inputEnd) {
                return -1;
            }
            if (this._inputBuffer[this._inputPtr] == 120) {
                this._pendingInput = -62;
                this._inputPtr++;
                if (this._inputPtr >= this._inputEnd) {
                    return -1;
                }
                iHandleDecEntityInAttribute = handleHexEntityInAttribute(true);
            } else {
                iHandleDecEntityInAttribute = handleDecEntityInAttribute(true);
            }
            if (iHandleDecEntityInAttribute == 0) {
                return -1;
            }
            return iHandleDecEntityInAttribute;
        }
        PName newEntityName = parseNewEntityName(b);
        if (newEntityName == null) {
            this._pendingInput = -63;
            return -1;
        }
        int iDecodeGeneralEntity = decodeGeneralEntity(newEntityName);
        if (iDecodeGeneralEntity != 0) {
            return iDecodeGeneralEntity;
        }
        this._tokenName = newEntityName;
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:55:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:62:0x0115  */
    /* JADX WARN: Code duplicated, block: B:68:0x012a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0134  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0126 A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected boolean handleNsDecl() throws XMLStreamException {
        int[] iArr = this._charTypes.ATTR_CHARS;
        char[] cArrGrowArrayBy = this._nameBuffer;
        byte b = this._elemAttrQuote;
        if (this._pendingInput != 0) {
            if (!handleNsValuePending()) {
                return false;
            }
            this._pendingInput = 0;
        }
        while (this._inputPtr < this._inputEnd) {
            if (this._elemNsPtr >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
            }
            int i = this._inputEnd;
            int length = this._inputPtr + (cArrGrowArrayBy.length - this._elemNsPtr);
            if (length < i) {
                i = length;
            }
            while (this._inputPtr < i) {
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int iHandleEntityInAttributeValue = bArr[i2] & 255;
                int i3 = iArr[iHandleEntityInAttributeValue];
                if (i3 == 0) {
                    int i4 = this._elemNsPtr;
                    this._elemNsPtr = i4 + 1;
                    cArrGrowArrayBy[i4] = (char) iHandleEntityInAttributeValue;
                } else {
                    if (i3 != 14) {
                        switch (i3) {
                            case 1:
                                handleInvalidXmlChar(iHandleEntityInAttributeValue);
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return false;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iHandleEntityInAttributeValue = 32;
                                break;
                                break;
                            case 2:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = -1;
                                    return false;
                                }
                                if (this._inputBuffer[this._inputPtr] == 10) {
                                    this._inputPtr++;
                                }
                                markLF();
                                iHandleEntityInAttributeValue = 32;
                                break;
                                break;
                            case 3:
                                markLF();
                                iHandleEntityInAttributeValue = 32;
                                break;
                            case 4:
                                reportInvalidInitial(iHandleEntityInAttributeValue);
                                throwUnexpectedChar(iHandleEntityInAttributeValue, "'<' not allowed in attribute value");
                                iHandleEntityInAttributeValue = handleEntityInAttributeValue();
                                if (iHandleEntityInAttributeValue <= 0) {
                                    if (iHandleEntityInAttributeValue < 0) {
                                        return false;
                                    }
                                    reportUnexpandedEntityInAttr(this._elemAttrName, true);
                                }
                                if ((iHandleEntityInAttributeValue >> 16) != 0) {
                                    int i5 = iHandleEntityInAttributeValue - 65536;
                                    int i6 = this._elemNsPtr;
                                    this._elemNsPtr = i6 + 1;
                                    cArrGrowArrayBy[i6] = (char) ((i5 >> 10) | 55296);
                                    iHandleEntityInAttributeValue = (i5 & 1023) | 56320;
                                    if (this._elemNsPtr >= cArrGrowArrayBy.length) {
                                        cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                                        this._nameBuffer = cArrGrowArrayBy;
                                    }
                                }
                                break;
                            case 5:
                                if (this._inputPtr >= this._inputEnd) {
                                    this._pendingInput = iHandleEntityInAttributeValue;
                                    return false;
                                }
                                iHandleEntityInAttributeValue = decodeUtf8_2(iHandleEntityInAttributeValue);
                                break;
                                break;
                            case 6:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr2 = this._inputBuffer;
                                        int i7 = this._inputPtr;
                                        this._inputPtr = i7 + 1;
                                        iHandleEntityInAttributeValue |= (bArr2[i7] & 255) << 8;
                                    }
                                    this._pendingInput = iHandleEntityInAttributeValue;
                                    return false;
                                }
                                iHandleEntityInAttributeValue = decodeUtf8_3(iHandleEntityInAttributeValue);
                                break;
                                break;
                            case 7:
                                if (this._inputEnd - this._inputPtr < 3) {
                                    if (this._inputEnd > this._inputPtr) {
                                        byte[] bArr3 = this._inputBuffer;
                                        int i8 = this._inputPtr;
                                        this._inputPtr = i8 + 1;
                                        iHandleEntityInAttributeValue |= (bArr3[i8] & 255) << 8;
                                        if (this._inputEnd > this._inputPtr) {
                                            byte[] bArr4 = this._inputBuffer;
                                            int i9 = this._inputPtr;
                                            this._inputPtr = i9 + 1;
                                            iHandleEntityInAttributeValue |= (bArr4[i9] & 255) << 16;
                                        }
                                    }
                                    this._pendingInput = iHandleEntityInAttributeValue;
                                    return false;
                                }
                                int iDecodeUtf8_4 = decodeUtf8_4(iHandleEntityInAttributeValue);
                                int i10 = this._elemNsPtr;
                                this._elemNsPtr = i10 + 1;
                                cArrGrowArrayBy[i10] = (char) ((iDecodeUtf8_4 >> 10) | 55296);
                                iHandleEntityInAttributeValue = (iDecodeUtf8_4 & 1023) | 56320;
                                if (this._elemNsPtr >= cArrGrowArrayBy.length) {
                                    cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                                    this._nameBuffer = cArrGrowArrayBy;
                                }
                                break;
                                break;
                            case 8:
                                iHandleEntityInAttributeValue = 32;
                                break;
                            case 9:
                                throwUnexpectedChar(iHandleEntityInAttributeValue, "'<' not allowed in attribute value");
                                iHandleEntityInAttributeValue = handleEntityInAttributeValue();
                                if (iHandleEntityInAttributeValue <= 0) {
                                    if (iHandleEntityInAttributeValue < 0) {
                                        return false;
                                    }
                                    reportUnexpandedEntityInAttr(this._elemAttrName, true);
                                }
                                if ((iHandleEntityInAttributeValue >> 16) != 0) {
                                    int i11 = iHandleEntityInAttributeValue - 65536;
                                    int i12 = this._elemNsPtr;
                                    this._elemNsPtr = i12 + 1;
                                    cArrGrowArrayBy[i12] = (char) ((i11 >> 10) | 55296);
                                    iHandleEntityInAttributeValue = (i11 & 1023) | 56320;
                                    if (this._elemNsPtr >= cArrGrowArrayBy.length) {
                                        cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                                        this._nameBuffer = cArrGrowArrayBy;
                                    }
                                }
                                break;
                            case 10:
                                iHandleEntityInAttributeValue = handleEntityInAttributeValue();
                                if (iHandleEntityInAttributeValue <= 0) {
                                    if (iHandleEntityInAttributeValue < 0) {
                                        return false;
                                    }
                                    reportUnexpandedEntityInAttr(this._elemAttrName, true);
                                }
                                if ((iHandleEntityInAttributeValue >> 16) != 0) {
                                    int i13 = iHandleEntityInAttributeValue - 65536;
                                    int i14 = this._elemNsPtr;
                                    this._elemNsPtr = i14 + 1;
                                    cArrGrowArrayBy[i14] = (char) ((i13 >> 10) | 55296);
                                    iHandleEntityInAttributeValue = (i13 & 1023) | 56320;
                                    if (this._elemNsPtr >= cArrGrowArrayBy.length) {
                                        cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                                        this._nameBuffer = cArrGrowArrayBy;
                                    }
                                }
                                break;
                        }
                    } else if (iHandleEntityInAttributeValue == b) {
                        int i15 = this._elemNsPtr;
                        if (i15 == 0) {
                            bindNs(this._elemAttrName, FinalChip.BSP_PLATFORM_Null);
                        } else {
                            bindNs(this._elemAttrName, this._config.canonicalizeURI(cArrGrowArrayBy, i15));
                        }
                        return true;
                    }
                    int i16 = this._elemNsPtr;
                    this._elemNsPtr = i16 + 1;
                    cArrGrowArrayBy[i16] = (char) iHandleEntityInAttributeValue;
                    break;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final boolean handleNsValuePending() throws XMLStreamException {
        int iHandleAttrValuePendingUTF8;
        int iDecodeGeneralEntity;
        if (this._pendingInput == -1) {
            if (!handlePartialCR()) {
                return false;
            }
            char[] cArrGrowArrayBy = this._nameBuffer;
            if (this._elemNsPtr >= cArrGrowArrayBy.length) {
                cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy;
            }
            int i = this._elemNsPtr;
            this._elemNsPtr = i + 1;
            cArrGrowArrayBy[i] = XmlConsts.CHAR_SPACE;
            return true;
        }
        if (this._inputPtr >= this._inputEnd) {
            return false;
        }
        if (this._pendingInput == -60) {
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b = bArr[i2];
            if (b == 35) {
                this._pendingInput = -61;
                if (this._inputPtr >= this._inputEnd) {
                    return false;
                }
                if (this._inputBuffer[this._inputPtr] == 120) {
                    this._pendingInput = -62;
                    this._inputPtr++;
                    if (this._inputPtr >= this._inputEnd) {
                        return false;
                    }
                    iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(true);
                } else {
                    iHandleAttrValuePendingUTF8 = handleDecEntityInAttribute(true);
                }
            } else {
                PName newEntityName = parseNewEntityName(b);
                if (newEntityName == null) {
                    this._pendingInput = -63;
                    return false;
                }
                iDecodeGeneralEntity = decodeGeneralEntity(newEntityName);
                if (iDecodeGeneralEntity == 0) {
                    this._tokenName = newEntityName;
                    reportUnexpandedEntityInAttr(this._elemAttrName, false);
                }
                iHandleAttrValuePendingUTF8 = iDecodeGeneralEntity;
            }
        } else if (this._pendingInput == -61) {
            if (this._inputBuffer[this._inputPtr] == 120) {
                this._pendingInput = -62;
                this._inputPtr++;
                if (this._inputPtr >= this._inputEnd) {
                    return false;
                }
                iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(true);
            } else {
                iHandleAttrValuePendingUTF8 = handleDecEntityInAttribute(true);
            }
        } else if (this._pendingInput == -62) {
            iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(true);
        } else if (this._pendingInput == -63) {
            PName entityName = parseEntityName();
            if (entityName == null) {
                return false;
            }
            iDecodeGeneralEntity = decodeGeneralEntity(entityName);
            if (iDecodeGeneralEntity == 0) {
                this._tokenName = entityName;
                reportUnexpandedEntityInAttr(this._elemAttrName, false);
            }
            iHandleAttrValuePendingUTF8 = iDecodeGeneralEntity;
        } else if (this._pendingInput == -64) {
            iHandleAttrValuePendingUTF8 = handleDecEntityInAttribute(false);
        } else if (this._pendingInput == -65) {
            iHandleAttrValuePendingUTF8 = handleHexEntityInAttribute(false);
        } else {
            iHandleAttrValuePendingUTF8 = handleAttrValuePendingUTF8();
        }
        if (iHandleAttrValuePendingUTF8 == 0) {
            return false;
        }
        char[] cArrGrowArrayBy2 = this._nameBuffer;
        if ((iHandleAttrValuePendingUTF8 >> 16) != 0) {
            int i3 = iHandleAttrValuePendingUTF8 - 65536;
            if (this._elemNsPtr >= cArrGrowArrayBy2.length) {
                cArrGrowArrayBy2 = DataUtil.growArrayBy(cArrGrowArrayBy2, cArrGrowArrayBy2.length);
                this._nameBuffer = cArrGrowArrayBy2;
            }
            int i4 = this._elemNsPtr;
            this._elemNsPtr = i4 + 1;
            cArrGrowArrayBy2[i4] = (char) ((i3 >> 10) | 55296);
            iHandleAttrValuePendingUTF8 = (i3 & 1023) | 56320;
        }
        if (this._elemNsPtr >= cArrGrowArrayBy2.length) {
            cArrGrowArrayBy2 = DataUtil.growArrayBy(cArrGrowArrayBy2, cArrGrowArrayBy2.length);
            this._nameBuffer = cArrGrowArrayBy2;
        }
        int i5 = this._elemNsPtr;
        this._elemNsPtr = i5 + 1;
        cArrGrowArrayBy2[i5] = (char) iHandleAttrValuePendingUTF8;
        return true;
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final PName parseNewName(byte b) throws XMLStreamException {
        int i = b & 255;
        if (i < 65) {
            throwUnexpectedChar(i, "; expected a name start character");
        }
        this._quadCount = 0;
        this._currQuad = i;
        this._currQuadBytes = 1;
        return parsePName();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x008f A[SYNTHETIC] */
    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final PName parsePName() throws XMLStreamException {
        int i;
        int i2;
        int i3 = this._currQuad;
        while (true) {
            int i4 = this._currQuadBytes;
            if (i4 == 0) {
                if (this._inputPtr >= this._inputEnd) {
                    return null;
                }
                byte[] bArr = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                i3 = bArr[i5] & 255;
                if (i3 < 65 && (i3 < 45 || i3 > 58 || i3 == 47)) {
                    return findPName(i3, 0);
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                        }
                        if (this._quadCount == 0) {
                            this._quadBuffer[0] = i3;
                            this._quadCount = 1;
                        } else {
                            if (this._quadCount >= this._quadBuffer.length) {
                                this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                            }
                            int[] iArr = this._quadBuffer;
                            int i6 = this._quadCount;
                            this._quadCount = i6 + 1;
                            iArr[i6] = i3;
                        }
                        this._currQuadBytes = 0;
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        this._currQuad = i3;
                        this._currQuadBytes = 3;
                        return null;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    i2 = bArr2[i7] & 255;
                    if (i2 >= 65 && (i2 < 45 || i2 > 58 || i2 == 47)) {
                        return findPName(i3, 3);
                    }
                    i3 = (i3 << 8) | i2;
                    if (this._quadCount == 0) {
                        this._quadBuffer[0] = i3;
                        this._quadCount = 1;
                    } else {
                        if (this._quadCount >= this._quadBuffer.length) {
                            this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                        }
                        int[] iArr2 = this._quadBuffer;
                        int i8 = this._quadCount;
                        this._quadCount = i8 + 1;
                        iArr2[i8] = i3;
                    }
                    this._currQuadBytes = 0;
                }
                if (this._inputPtr >= this._inputEnd) {
                    this._currQuad = i3;
                    this._currQuadBytes = 2;
                    return null;
                }
                byte[] bArr3 = this._inputBuffer;
                int i9 = this._inputPtr;
                this._inputPtr = i9 + 1;
                i = bArr3[i9] & 255;
                if (i >= 65 && (i < 45 || i > 58 || i == 47)) {
                    return findPName(i3, 2);
                }
                i3 = (i3 << 8) | i;
                if (this._inputPtr >= this._inputEnd) {
                    this._currQuad = i3;
                    this._currQuadBytes = 3;
                    return null;
                }
                byte[] bArr4 = this._inputBuffer;
                int i10 = this._inputPtr;
                this._inputPtr = i10 + 1;
                i2 = bArr4[i10] & 255;
                if (i2 >= 65) {
                }
                i3 = (i3 << 8) | i2;
                if (this._quadCount == 0) {
                    this._quadBuffer[0] = i3;
                    this._quadCount = 1;
                } else {
                    if (this._quadCount >= this._quadBuffer.length) {
                        this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                    }
                    int[] iArr3 = this._quadBuffer;
                    int i11 = this._quadCount;
                    this._quadCount = i11 + 1;
                    iArr3[i11] = i3;
                }
                this._currQuadBytes = 0;
            }
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i3;
                this._currQuadBytes = 1;
                return null;
            }
            byte[] bArr5 = this._inputBuffer;
            int i12 = this._inputPtr;
            this._inputPtr = i12 + 1;
            int i13 = bArr5[i12] & 255;
            if (i13 < 65 && (i13 < 45 || i13 > 58 || i13 == 47)) {
                return findPName(i3, 1);
            }
            i3 = (i3 << 8) | i13;
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i3;
                this._currQuadBytes = 2;
                return null;
            }
            byte[] bArr6 = this._inputBuffer;
            int i14 = this._inputPtr;
            this._inputPtr = i14 + 1;
            i = bArr6[i14] & 255;
            if (i >= 65) {
            }
            i3 = (i3 << 8) | i;
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i3;
                this._currQuadBytes = 3;
                return null;
            }
            byte[] bArr7 = this._inputBuffer;
            int i15 = this._inputPtr;
            this._inputPtr = i15 + 1;
            i2 = bArr7[i15] & 255;
            if (i2 >= 65) {
            }
            i3 = (i3 << 8) | i2;
            if (this._quadCount == 0) {
                this._quadBuffer[0] = i3;
                this._quadCount = 1;
            } else {
                if (this._quadCount >= this._quadBuffer.length) {
                    this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                }
                int[] iArr4 = this._quadBuffer;
                int i16 = this._quadCount;
                this._quadCount = i16 + 1;
                iArr4[i16] = i3;
            }
            this._currQuadBytes = 0;
        }
    }

    protected final PName parseNewEntityName(byte b) throws XMLStreamException {
        int i = b & 255;
        if (i < 65) {
            throwUnexpectedChar(i, "; expected a name start character");
        }
        this._quadCount = 0;
        this._currQuad = i;
        this._currQuadBytes = 1;
        return parseEntityName();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00de A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:83:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0107  */
    /* JADX WARN: Code duplicated, block: B:86:0x010e  */
    /* JADX WARN: Code duplicated, block: B:89:0x00cb A[SYNTHETIC] */
    protected final PName parseEntityName() throws XMLStreamException {
        int i;
        int i2;
        int i3 = this._currQuad;
        while (true) {
            int i4 = this._currQuadBytes;
            if (i4 == 0) {
                if (this._inputPtr >= this._inputEnd) {
                    return null;
                }
                byte[] bArr = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                i3 = bArr[i5] & 255;
                if (i3 < 65 && (i3 < 45 || i3 > 58 || i3 == 47)) {
                    if (this._quadCount == 1) {
                        i3 = this._quadBuffer[0];
                        if (i3 == EntityNames.ENTITY_APOS_QUAD) {
                            this._inputPtr--;
                            return EntityNames.ENTITY_APOS;
                        }
                        if (i3 == EntityNames.ENTITY_QUOT_QUAD) {
                            this._inputPtr--;
                            return EntityNames.ENTITY_QUOT;
                        }
                    }
                    return findPName(i3, 0);
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                        }
                        if (this._quadCount == 0) {
                            this._quadBuffer[0] = i3;
                            this._quadCount = 1;
                        } else {
                            if (this._quadCount >= this._quadBuffer.length) {
                                this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                            }
                            int[] iArr = this._quadBuffer;
                            int i6 = this._quadCount;
                            this._quadCount = i6 + 1;
                            iArr[i6] = i3;
                        }
                        this._currQuadBytes = 0;
                    }
                    if (this._inputPtr >= this._inputEnd) {
                        this._currQuad = i3;
                        this._currQuadBytes = 3;
                        return null;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    i2 = bArr2[i7] & 255;
                    if (i2 >= 65 && (i2 < 45 || i2 > 58 || i2 == 47)) {
                        if (this._quadCount == 0 && i3 == EntityNames.ENTITY_AMP_QUAD) {
                            this._inputPtr--;
                            return EntityNames.ENTITY_AMP;
                        }
                        return findPName(i3, 3);
                    }
                    i3 = (i3 << 8) | i2;
                    if (this._quadCount == 0) {
                        this._quadBuffer[0] = i3;
                        this._quadCount = 1;
                    } else {
                        if (this._quadCount >= this._quadBuffer.length) {
                            this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                        }
                        int[] iArr2 = this._quadBuffer;
                        int i8 = this._quadCount;
                        this._quadCount = i8 + 1;
                        iArr2[i8] = i3;
                    }
                    this._currQuadBytes = 0;
                }
                if (this._inputPtr >= this._inputEnd) {
                    this._currQuad = i3;
                    this._currQuadBytes = 2;
                    return null;
                }
                byte[] bArr3 = this._inputBuffer;
                int i9 = this._inputPtr;
                this._inputPtr = i9 + 1;
                i = bArr3[i9] & 255;
                if (i >= 65 && (i < 45 || i > 58 || i == 47)) {
                    if (this._quadCount == 0) {
                        if (i3 == EntityNames.ENTITY_GT_QUAD) {
                            this._inputPtr--;
                            return EntityNames.ENTITY_GT;
                        }
                        if (i3 == EntityNames.ENTITY_LT_QUAD) {
                            this._inputPtr--;
                            return EntityNames.ENTITY_LT;
                        }
                    }
                    return findPName(i3, 2);
                }
                i3 = (i3 << 8) | i;
                if (this._inputPtr >= this._inputEnd) {
                    this._currQuad = i3;
                    this._currQuadBytes = 3;
                    return null;
                }
                byte[] bArr4 = this._inputBuffer;
                int i10 = this._inputPtr;
                this._inputPtr = i10 + 1;
                i2 = bArr4[i10] & 255;
                if (i2 >= 65) {
                }
                i3 = (i3 << 8) | i2;
                if (this._quadCount == 0) {
                    this._quadBuffer[0] = i3;
                    this._quadCount = 1;
                } else {
                    if (this._quadCount >= this._quadBuffer.length) {
                        this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                    }
                    int[] iArr3 = this._quadBuffer;
                    int i11 = this._quadCount;
                    this._quadCount = i11 + 1;
                    iArr3[i11] = i3;
                }
                this._currQuadBytes = 0;
            }
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i3;
                this._currQuadBytes = 1;
                return null;
            }
            byte[] bArr5 = this._inputBuffer;
            int i12 = this._inputPtr;
            this._inputPtr = i12 + 1;
            int i13 = bArr5[i12] & 255;
            if (i13 < 65 && (i13 < 45 || i13 > 58 || i13 == 47)) {
                return findPName(i3, 1);
            }
            i3 = (i3 << 8) | i13;
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i3;
                this._currQuadBytes = 2;
                return null;
            }
            byte[] bArr6 = this._inputBuffer;
            int i14 = this._inputPtr;
            this._inputPtr = i14 + 1;
            i = bArr6[i14] & 255;
            if (i >= 65) {
            }
            i3 = (i3 << 8) | i;
            if (this._inputPtr >= this._inputEnd) {
                this._currQuad = i3;
                this._currQuadBytes = 3;
                return null;
            }
            byte[] bArr7 = this._inputBuffer;
            int i15 = this._inputPtr;
            this._inputPtr = i15 + 1;
            i2 = bArr7[i15] & 255;
            if (i2 >= 65) {
            }
            i3 = (i3 << 8) | i2;
            if (this._quadCount == 0) {
                this._quadBuffer[0] = i3;
                this._quadCount = 1;
            } else {
                if (this._quadCount >= this._quadBuffer.length) {
                    this._quadBuffer = DataUtil.growArrayBy(this._quadBuffer, this._quadBuffer.length);
                }
                int[] iArr4 = this._quadBuffer;
                int i16 = this._quadCount;
                this._quadCount = i16 + 1;
                iArr4[i16] = i3;
            }
            this._currQuadBytes = 0;
        }
    }

    @Override // com.fasterxml.aalto.async.AsyncByteScanner
    protected final boolean handlePartialCR() {
        if (this._pendingInput != -1) {
            throwInternal();
        }
        if (this._inputPtr >= this._inputEnd) {
            return false;
        }
        this._pendingInput = 0;
        if (this._inputBuffer[this._inputPtr] == 10) {
            this._inputPtr++;
        }
        this._currRow++;
        this._rowStartOffset = this._inputPtr;
        return true;
    }

    protected final int decodeUtf8_2(int i) throws XMLStreamException {
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        return ((i & 31) << 6) | (b & 63);
    }

    protected final void skipUtf8_2(int i) throws XMLStreamException {
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
    }

    protected final int decodeUtf8_3(int i) throws XMLStreamException {
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

    protected final int decodeUtf8_3(int i, int i2, int i3) throws XMLStreamException {
        if ((i2 & ListCondition01.USB) != 128) {
            reportInvalidOther(i2 & 255, this._inputPtr - 1);
        }
        if ((i3 & ListCondition01.USB) != 128) {
            reportInvalidOther(i3 & 255, this._inputPtr);
        }
        int i4 = ((i2 & 63) << 6) | ((i & 15) << 12) | (i3 & 63);
        if (i < 13 || i4 < 55296) {
            return i4;
        }
        return (i4 < 57344 || (i4 >= 65534 && i4 <= 65535)) ? handleInvalidXmlChar(i4) : i4;
    }

    protected final int decodeUtf8_4(int i) throws XMLStreamException {
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            reportInvalidOther(b & 255, this._inputPtr);
        }
        int i3 = ((i & 7) << 6) | (b & 63);
        byte[] bArr2 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            reportInvalidOther(b2 & 255, this._inputPtr);
        }
        int i5 = (i3 << 6) | (b2 & 63);
        byte[] bArr3 = this._inputBuffer;
        int i6 = this._inputPtr;
        this._inputPtr = i6 + 1;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            reportInvalidOther(b3 & 255, this._inputPtr);
        }
        return ((i5 << 6) | (b3 & 63)) - 65536;
    }

    protected final int decodeUtf8_4(int i, int i2, int i3, int i4) throws XMLStreamException {
        if ((i2 & ListCondition01.USB) != 128) {
            reportInvalidOther(i2 & 255, this._inputPtr - 2);
        }
        int i5 = ((i & 7) << 6) | (i2 & 63);
        if ((i3 & ListCondition01.USB) != 128) {
            reportInvalidOther(i3 & 255, this._inputPtr - 1);
        }
        int i6 = (i5 << 6) | (i3 & 63);
        if ((i4 & ListCondition01.USB) != 128) {
            reportInvalidOther(i4 & 255, this._inputPtr);
        }
        return ((i6 << 6) | (i4 & 63)) - 65536;
    }
}

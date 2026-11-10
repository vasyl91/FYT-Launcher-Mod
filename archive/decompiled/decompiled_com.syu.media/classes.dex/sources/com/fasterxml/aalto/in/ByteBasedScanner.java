package com.fasterxml.aalto.in;

import bsp.FinalBsp;
import com.fasterxml.aalto.impl.LocationImpl;
import com.fasterxml.aalto.util.DataUtil;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlChars;
import com.syu.media.ListCondition01;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamLocation2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class ByteBasedScanner extends XmlScanner {
    protected static final byte BYTE_A = 65;
    protected static final byte BYTE_AMP = 38;
    protected static final byte BYTE_APOS = 39;
    protected static final byte BYTE_C = 67;
    protected static final byte BYTE_CR = 13;
    protected static final byte BYTE_D = 68;
    protected static final byte BYTE_EQ = 61;
    protected static final byte BYTE_EXCL = 33;
    protected static final byte BYTE_GT = 62;
    protected static final byte BYTE_HASH = 35;
    protected static final byte BYTE_HYPHEN = 45;
    protected static final byte BYTE_LBRACKET = 91;
    protected static final byte BYTE_LF = 10;
    protected static final byte BYTE_LT = 60;
    protected static final byte BYTE_NULL = 0;
    protected static final byte BYTE_P = 80;
    protected static final byte BYTE_QMARK = 63;
    protected static final byte BYTE_QUOT = 34;
    protected static final byte BYTE_RBRACKET = 93;
    protected static final byte BYTE_S = 83;
    protected static final byte BYTE_SEMICOLON = 59;
    protected static final byte BYTE_SLASH = 47;
    protected static final byte BYTE_SPACE = 32;
    protected static final byte BYTE_T = 84;
    protected static final byte BYTE_TAB = 9;
    protected static final byte BYTE_a = 97;
    protected static final byte BYTE_g = 103;
    protected static final byte BYTE_l = 108;
    protected static final byte BYTE_m = 109;
    protected static final byte BYTE_o = 111;
    protected static final byte BYTE_p = 112;
    protected static final byte BYTE_q = 113;
    protected static final byte BYTE_s = 115;
    protected static final byte BYTE_t = 116;
    protected static final byte BYTE_u = 117;
    protected static final byte BYTE_x = 120;
    protected int _inputEnd;
    protected int _inputPtr;
    protected int _tmpChar;

    @Override // com.fasterxml.aalto.in.XmlScanner
    protected abstract void _closeSource() throws IOException;

    protected abstract int decodeCharForError(byte b) throws XMLStreamException;

    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getEndingCharOffset() throws XMLStreamException {
        return -1L;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getStartingCharOffset() {
        return -1L;
    }

    protected ByteBasedScanner(ReaderConfig readerConfig) {
        super(readerConfig);
        this._tmpChar = 0;
        this._pastBytesOrChars = 0L;
        this._rowStartOffset = 0;
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
    public long getStartingByteOffset() {
        return this._startRawOffset;
    }

    @Override // com.fasterxml.aalto.in.XmlScanner
    public long getEndingByteOffset() throws XMLStreamException {
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
    /* JADX WARN: Code duplicated, block: B:102:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:114:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:83:0x016d A[PHI: r4 r14
  0x016d: PHI (r4v14 int) = (r4v13 int), (r4v18 int) binds: [B:73:0x0130, B:78:0x014d] A[DONT_GENERATE, DONT_INLINE]
  0x016d: PHI (r14v7 int) = (r14v6 int), (r14v9 int) binds: [B:73:0x0130, B:78:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    protected final PName addUTFPName(ByteBasedPNameTable byteBasedPNameTable, XmlCharTypes xmlCharTypes, int i, int[] iArr, int i2, int i3) throws XMLStreamException {
        int i4;
        boolean zIs10NameStartChar;
        int i5;
        int i6;
        boolean zIs10NameChar;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = ((i2 << 2) - 4) + i3;
        if (i3 < 4) {
            int i12 = i2 - 1;
            i4 = iArr[i12];
            iArr[i12] = i4 << ((4 - i3) << 3);
        } else {
            i4 = 0;
        }
        int i13 = iArr[0] >>> 24;
        char[] cArrGrowArrayBy = this._nameBuffer;
        int[] iArr2 = xmlCharTypes.NAME_CHARS;
        int i14 = iArr2[i13];
        int i15 = 1;
        if (i14 == 0 || i14 == 1 || i14 == 2) {
            zIs10NameStartChar = false;
            i5 = 0;
            i6 = 1;
        } else if (i14 == 3) {
            i5 = 0;
            zIs10NameStartChar = true;
            i6 = 1;
        } else if (i14 != 4) {
            if ((i13 & FinalBsp.KEY_CODE_NEXT) == 192) {
                i9 = i13 & 31;
                i10 = 1;
            } else if ((i13 & FinalBsp.KEY_CODE_TONE_MINUS) == 224) {
                i9 = i13 & 15;
                i10 = 2;
            } else if ((i13 & FinalBsp.KEY_AIR_CYCLE) == 240) {
                i9 = i13 & 7;
                i10 = 3;
            } else {
                reportInvalidInitial(i13);
                i9 = 1;
                i10 = 1;
            }
            i6 = 1 + i10;
            if (i6 > i11) {
                reportEofInName(cArrGrowArrayBy, 0);
            }
            int i16 = iArr[0];
            int i17 = (i16 >> 16) & 255;
            if ((i17 & ListCondition01.USB) != 128) {
                reportInvalidOther(i17);
            }
            int i18 = (i9 << 6) | (i17 & 63);
            if (i10 > 1) {
                int i19 = (i16 >> 8) & 255;
                if ((i19 & ListCondition01.USB) != 128) {
                    reportInvalidOther(i19);
                }
                i18 = (i18 << 6) | (i19 & 63);
                if (i10 > 2) {
                    int i20 = i16 & 255;
                    if ((i20 & ListCondition01.USB) != 128) {
                        reportInvalidOther(i20 & 255);
                    }
                    i18 = (i18 << 6) | (i20 & 63);
                }
            }
            i13 = i18;
            zIs10NameStartChar = XmlChars.is10NameStartChar(i13);
            if (i10 > 2) {
                int i21 = i13 - 65536;
                cArrGrowArrayBy[0] = (char) ((i21 >> 10) + 55296);
                i13 = (i21 & 1023) | 56320;
                i5 = 1;
            } else {
                i5 = 0;
            }
        } else {
            zIs10NameStartChar = false;
            i5 = 0;
            i6 = 1;
        }
        if (!zIs10NameStartChar) {
            reportInvalidNameChar(i13, 0);
        }
        int i22 = i5 + 1;
        cArrGrowArrayBy[i5] = (char) i13;
        int i23 = -1;
        while (i6 < i11) {
            int i24 = (iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3)) & 255;
            i6++;
            int i25 = iArr2[i24];
            if (i25 != 0) {
                if (i25 != i15) {
                    if (i25 != 2 && i25 != 3) {
                        if (i25 != 4) {
                            if ((i24 & FinalBsp.KEY_CODE_NEXT) == 192) {
                                i7 = i24 & 31;
                                i8 = i15;
                            } else if ((i24 & FinalBsp.KEY_CODE_TONE_MINUS) == 224) {
                                i7 = i24 & 15;
                                i8 = 2;
                            } else if ((i24 & FinalBsp.KEY_AIR_CYCLE) == 240) {
                                i7 = i24 & 7;
                                i8 = 3;
                            } else {
                                reportInvalidInitial(i24);
                                i7 = i15;
                                i8 = i7;
                            }
                            if (i6 + i8 > i11) {
                                reportEofInName(cArrGrowArrayBy, i22);
                            }
                            int i26 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                            i6++;
                            if ((i26 & ListCondition01.USB) != 128) {
                                reportInvalidOther(i26);
                            }
                            int i27 = (i7 << 6) | (i26 & 63);
                            if (i8 > i15) {
                                int i28 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                                i6++;
                                if ((i28 & ListCondition01.USB) != 128) {
                                    reportInvalidOther(i28);
                                }
                                i27 = (i27 << 6) | (i28 & 63);
                                if (i8 > 2) {
                                    int i29 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                                    i6++;
                                    if ((i29 & ListCondition01.USB) != 128) {
                                        reportInvalidOther(i29 & 255);
                                    }
                                    i27 = (i27 << 6) | (i29 & 63);
                                }
                            }
                            i24 = i27;
                            zIs10NameChar = XmlChars.is10NameChar(i24);
                            if (i8 > 2) {
                                int i30 = i24 - 65536;
                                if (i22 >= cArrGrowArrayBy.length) {
                                    cArrGrowArrayBy = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                                    this._nameBuffer = cArrGrowArrayBy;
                                }
                                cArrGrowArrayBy[i22] = (char) ((i30 >> 10) + 55296);
                                i24 = (i30 & 1023) | 56320;
                                i22++;
                            }
                        }
                    }
                    if (!zIs10NameChar) {
                        reportInvalidNameChar(i24, i22);
                    }
                    if (i22 >= cArrGrowArrayBy.length) {
                        char[] cArrGrowArrayBy2 = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                        this._nameBuffer = cArrGrowArrayBy2;
                        cArrGrowArrayBy = cArrGrowArrayBy2;
                    }
                    cArrGrowArrayBy[i22] = (char) i24;
                    i22++;
                    i15 = 1;
                } else {
                    if (i23 >= 0) {
                        reportMultipleColonsInName();
                    }
                    i23 = i22;
                }
                zIs10NameChar = true;
                if (!zIs10NameChar) {
                    reportInvalidNameChar(i24, i22);
                }
                if (i22 >= cArrGrowArrayBy.length) {
                    char[] cArrGrowArrayBy3 = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                    this._nameBuffer = cArrGrowArrayBy3;
                    cArrGrowArrayBy = cArrGrowArrayBy3;
                }
                cArrGrowArrayBy[i22] = (char) i24;
                i22++;
                i15 = 1;
            }
            zIs10NameChar = false;
            if (!zIs10NameChar) {
                reportInvalidNameChar(i24, i22);
            }
            if (i22 >= cArrGrowArrayBy.length) {
                char[] cArrGrowArrayBy4 = DataUtil.growArrayBy(cArrGrowArrayBy, cArrGrowArrayBy.length);
                this._nameBuffer = cArrGrowArrayBy4;
                cArrGrowArrayBy = cArrGrowArrayBy4;
            }
            cArrGrowArrayBy[i22] = (char) i24;
            i22++;
            i15 = 1;
        }
        String str = new String(cArrGrowArrayBy, 0, i22);
        if (i3 < 4) {
            iArr[i2 - 1] = i4;
        }
        return byteBasedPNameTable.addSymbol(i, str, i23, iArr, i2);
    }

    protected void reportInvalidInitial(int i) throws XMLStreamException {
        reportInputProblem("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void reportInvalidOther(int i) throws XMLStreamException {
        reportInputProblem("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }
}

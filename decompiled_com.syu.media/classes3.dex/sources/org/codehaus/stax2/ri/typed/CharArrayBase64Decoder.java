package org.codehaus.stax2.ri.typed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.codehaus.stax2.ri.Stax2Util;
import org.codehaus.stax2.typed.Base64Variant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CharArrayBase64Decoder extends Base64DecoderBase {
    protected char[] _currSegment;
    protected int _currSegmentEnd;
    protected int _currSegmentPtr;
    protected int _lastSegmentEnd;
    protected int _lastSegmentOffset;
    protected int _nextSegmentIndex;
    protected final ArrayList<char[]> _nextSegments = new ArrayList<>();

    @Override // org.codehaus.stax2.ri.typed.Base64DecoderBase
    public /* bridge */ /* synthetic */ byte[] decodeCompletely() {
        return super.decodeCompletely();
    }

    @Override // org.codehaus.stax2.ri.typed.Base64DecoderBase
    public /* bridge */ /* synthetic */ Stax2Util.ByteAggregator getByteAggregator() {
        return super.getByteAggregator();
    }

    public void init(Base64Variant base64Variant, boolean z, char[] cArr, int i, int i2, List<char[]> list) {
        this._variant = base64Variant;
        if (z) {
            this._state = 0;
        }
        this._nextSegments.clear();
        if (list == null || list.isEmpty()) {
            this._currSegment = cArr;
            this._currSegmentPtr = i;
            this._currSegmentEnd = i + i2;
        } else {
            if (cArr == null) {
                throw new IllegalArgumentException();
            }
            Iterator<char[]> it = list.iterator();
            char[] next = it.next();
            this._currSegment = next;
            this._currSegmentPtr = 0;
            this._currSegmentEnd = next.length;
            while (it.hasNext()) {
                this._nextSegments.add(it.next());
            }
            this._nextSegmentIndex = 0;
            this._nextSegments.add(cArr);
            this._lastSegmentOffset = i;
            this._lastSegmentEnd = i + i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:55:0x0113  */
    /* JADX WARN: Code duplicated, block: B:61:0x012c  */
    /* JADX WARN: Code duplicated, block: B:64:0x013b  */
    /* JADX WARN: Code duplicated, block: B:69:0x014b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0138 A[SYNTHETIC] */
    @Override // org.codehaus.stax2.ri.typed.Base64DecoderBase
    public int decode(byte[] bArr, int i, int i2) throws IllegalArgumentException {
        char c;
        int iDecodeBase64Char;
        char c2;
        int iDecodeBase64Char2;
        char c3;
        int iDecodeBase64Char3;
        char c4;
        int i3 = i2 + i;
        int i4 = i;
        while (true) {
            switch (this._state) {
                case 0:
                    do {
                        if (this._currSegmentPtr < this._currSegmentEnd || nextSegment()) {
                            char[] cArr = this._currSegment;
                            int i5 = this._currSegmentPtr;
                            this._currSegmentPtr = i5 + 1;
                            c4 = cArr[i5];
                        }
                        return i4 - i;
                    } while (c4 <= ' ');
                    int iDecodeBase64Char4 = this._variant.decodeBase64Char(c4);
                    if (iDecodeBase64Char4 < 0) {
                        throw reportInvalidChar(c4, 0);
                    }
                    this._decodedData = iDecodeBase64Char4;
                    if (this._currSegmentPtr < this._currSegmentEnd && !nextSegment()) {
                        this._state = 1;
                    } else {
                        char[] cArr2 = this._currSegment;
                        int i6 = this._currSegmentPtr;
                        this._currSegmentPtr = i6 + 1;
                        c3 = cArr2[i6];
                        iDecodeBase64Char3 = this._variant.decodeBase64Char(c3);
                        if (iDecodeBase64Char3 >= 0) {
                            throw reportInvalidChar(c3, 1);
                        }
                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char3;
                        if (this._currSegmentPtr < this._currSegmentEnd && !nextSegment()) {
                            this._state = 2;
                        } else {
                            char[] cArr3 = this._currSegment;
                            int i7 = this._currSegmentPtr;
                            this._currSegmentPtr = i7 + 1;
                            c2 = cArr3[i7];
                            iDecodeBase64Char2 = this._variant.decodeBase64Char(c2);
                            if (iDecodeBase64Char2 < 0) {
                                if (iDecodeBase64Char2 != -2) {
                                    throw reportInvalidChar(c2, 2);
                                }
                                this._state = 7;
                            } else {
                                this._decodedData = (this._decodedData << 6) | iDecodeBase64Char2;
                                if (this._currSegmentPtr < this._currSegmentEnd && !nextSegment()) {
                                    this._state = 3;
                                } else {
                                    char[] cArr4 = this._currSegment;
                                    int i8 = this._currSegmentPtr;
                                    this._currSegmentPtr = i8 + 1;
                                    c = cArr4[i8];
                                    iDecodeBase64Char = this._variant.decodeBase64Char(c);
                                    if (iDecodeBase64Char >= 0) {
                                        if (iDecodeBase64Char == -2) {
                                            throw reportInvalidChar(c, 3);
                                        }
                                        this._decodedData >>= 2;
                                        this._state = 5;
                                    } else {
                                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                                        if (i4 >= i3) {
                                            this._state = 4;
                                        } else {
                                            bArr[i4] = (byte) (this._decodedData >> 16);
                                            i4++;
                                            if (i4 >= i3) {
                                                this._state = 5;
                                            } else {
                                                bArr[i4] = (byte) (this._decodedData >> 8);
                                                i4++;
                                                if (i4 >= i3) {
                                                    this._state = 6;
                                                } else {
                                                    bArr[i4] = (byte) this._decodedData;
                                                    this._state = 0;
                                                    i4++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return i4 - i;
                case 1:
                    if (this._currSegmentPtr < this._currSegmentEnd) {
                    }
                    char[] cArr5 = this._currSegment;
                    int i9 = this._currSegmentPtr;
                    this._currSegmentPtr = i9 + 1;
                    c3 = cArr5[i9];
                    iDecodeBase64Char3 = this._variant.decodeBase64Char(c3);
                    if (iDecodeBase64Char3 >= 0) {
                        throw reportInvalidChar(c3, 1);
                    }
                    this._decodedData = (this._decodedData << 6) | iDecodeBase64Char3;
                    if (this._currSegmentPtr < this._currSegmentEnd) {
                    }
                    char[] cArr6 = this._currSegment;
                    int i10 = this._currSegmentPtr;
                    this._currSegmentPtr = i10 + 1;
                    c2 = cArr6[i10];
                    iDecodeBase64Char2 = this._variant.decodeBase64Char(c2);
                    if (iDecodeBase64Char2 < 0) {
                        if (iDecodeBase64Char2 != -2) {
                            throw reportInvalidChar(c2, 2);
                        }
                        this._state = 7;
                    } else {
                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char2;
                        if (this._currSegmentPtr < this._currSegmentEnd) {
                        }
                        char[] cArr7 = this._currSegment;
                        int i11 = this._currSegmentPtr;
                        this._currSegmentPtr = i11 + 1;
                        c = cArr7[i11];
                        iDecodeBase64Char = this._variant.decodeBase64Char(c);
                        if (iDecodeBase64Char >= 0) {
                            this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                            if (i4 >= i3) {
                                this._state = 4;
                            } else {
                                bArr[i4] = (byte) (this._decodedData >> 16);
                                i4++;
                                if (i4 >= i3) {
                                    this._state = 5;
                                } else {
                                    bArr[i4] = (byte) (this._decodedData >> 8);
                                    i4++;
                                    if (i4 >= i3) {
                                        this._state = 6;
                                    } else {
                                        bArr[i4] = (byte) this._decodedData;
                                        this._state = 0;
                                        i4++;
                                    }
                                }
                            }
                            return i4 - i;
                        }
                        if (iDecodeBase64Char == -2) {
                            throw reportInvalidChar(c, 3);
                        }
                        this._decodedData >>= 2;
                        this._state = 5;
                    }
                    break;
                    break;
                case 2:
                    if (this._currSegmentPtr < this._currSegmentEnd) {
                    }
                    char[] cArr8 = this._currSegment;
                    int i12 = this._currSegmentPtr;
                    this._currSegmentPtr = i12 + 1;
                    c2 = cArr8[i12];
                    iDecodeBase64Char2 = this._variant.decodeBase64Char(c2);
                    if (iDecodeBase64Char2 < 0) {
                        if (iDecodeBase64Char2 != -2) {
                            throw reportInvalidChar(c2, 2);
                        }
                        this._state = 7;
                    } else {
                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char2;
                        if (this._currSegmentPtr < this._currSegmentEnd) {
                        }
                        char[] cArr9 = this._currSegment;
                        int i13 = this._currSegmentPtr;
                        this._currSegmentPtr = i13 + 1;
                        c = cArr9[i13];
                        iDecodeBase64Char = this._variant.decodeBase64Char(c);
                        if (iDecodeBase64Char >= 0) {
                            this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                            if (i4 >= i3) {
                                this._state = 4;
                            } else {
                                bArr[i4] = (byte) (this._decodedData >> 16);
                                i4++;
                                if (i4 >= i3) {
                                    this._state = 5;
                                } else {
                                    bArr[i4] = (byte) (this._decodedData >> 8);
                                    i4++;
                                    if (i4 >= i3) {
                                        this._state = 6;
                                    } else {
                                        bArr[i4] = (byte) this._decodedData;
                                        this._state = 0;
                                        i4++;
                                    }
                                }
                            }
                            return i4 - i;
                        }
                        if (iDecodeBase64Char == -2) {
                            throw reportInvalidChar(c, 3);
                        }
                        this._decodedData >>= 2;
                        this._state = 5;
                    }
                    break;
                case 3:
                    if (this._currSegmentPtr < this._currSegmentEnd) {
                    }
                    char[] cArr10 = this._currSegment;
                    int i14 = this._currSegmentPtr;
                    this._currSegmentPtr = i14 + 1;
                    c = cArr10[i14];
                    iDecodeBase64Char = this._variant.decodeBase64Char(c);
                    if (iDecodeBase64Char >= 0) {
                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                        if (i4 >= i3) {
                            this._state = 4;
                        } else {
                            bArr[i4] = (byte) (this._decodedData >> 16);
                            i4++;
                            if (i4 >= i3) {
                                this._state = 5;
                            } else {
                                bArr[i4] = (byte) (this._decodedData >> 8);
                                i4++;
                                if (i4 >= i3) {
                                    this._state = 6;
                                } else {
                                    bArr[i4] = (byte) this._decodedData;
                                    this._state = 0;
                                    i4++;
                                }
                            }
                        }
                        return i4 - i;
                    }
                    if (iDecodeBase64Char == -2) {
                        throw reportInvalidChar(c, 3);
                    }
                    this._decodedData >>= 2;
                    this._state = 5;
                    break;
                case 4:
                    if (i4 >= i3) {
                        this._state = 4;
                    } else {
                        bArr[i4] = (byte) (this._decodedData >> 16);
                        i4++;
                        if (i4 >= i3) {
                            this._state = 5;
                        } else {
                            bArr[i4] = (byte) (this._decodedData >> 8);
                            i4++;
                            if (i4 >= i3) {
                                this._state = 6;
                            } else {
                                bArr[i4] = (byte) this._decodedData;
                                this._state = 0;
                                i4++;
                            }
                        }
                        break;
                    }
                    return i4 - i;
                case 5:
                    if (i4 >= i3) {
                        this._state = 5;
                    } else {
                        bArr[i4] = (byte) (this._decodedData >> 8);
                        i4++;
                        if (i4 >= i3) {
                            this._state = 6;
                        } else {
                            bArr[i4] = (byte) this._decodedData;
                            this._state = 0;
                            i4++;
                        }
                        break;
                    }
                    return i4 - i;
                case 6:
                    if (i4 >= i3) {
                        this._state = 6;
                        return i4 - i;
                    }
                    bArr[i4] = (byte) this._decodedData;
                    this._state = 0;
                    i4++;
                    break;
                    break;
                case 7:
                    if (this._currSegmentPtr >= this._currSegmentEnd && !nextSegment()) {
                        return i4 - i;
                    }
                    char[] cArr11 = this._currSegment;
                    int i15 = this._currSegmentPtr;
                    this._currSegmentPtr = i15 + 1;
                    char c5 = cArr11[i15];
                    if (!this._variant.usesPaddingChar(c5)) {
                        throw reportInvalidChar(c5, 3, "expected padding character '" + this._variant.getPaddingChar() + "'");
                    }
                    this._state = 6;
                    this._decodedData >>= 4;
                    break;
                    break;
                default:
                    throw new IllegalStateException("Illegal internal state " + this._state);
            }
        }
    }

    private boolean nextSegment() {
        if (this._nextSegmentIndex >= this._nextSegments.size()) {
            return false;
        }
        ArrayList<char[]> arrayList = this._nextSegments;
        int i = this._nextSegmentIndex;
        this._nextSegmentIndex = i + 1;
        this._currSegment = arrayList.get(i);
        if (this._nextSegmentIndex == this._nextSegments.size()) {
            this._currSegmentPtr = this._lastSegmentOffset;
            this._currSegmentEnd = this._lastSegmentEnd;
            return true;
        }
        this._currSegmentPtr = 0;
        this._currSegmentEnd = this._currSegment.length;
        return true;
    }
}

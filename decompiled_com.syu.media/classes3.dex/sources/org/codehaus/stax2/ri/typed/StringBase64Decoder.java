package org.codehaus.stax2.ri.typed;

import org.codehaus.stax2.ri.Stax2Util;
import org.codehaus.stax2.typed.Base64Variant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class StringBase64Decoder extends Base64DecoderBase {
    String _currSegment;
    int _currSegmentEnd;
    int _currSegmentPtr;

    @Override // org.codehaus.stax2.ri.typed.Base64DecoderBase
    public /* bridge */ /* synthetic */ byte[] decodeCompletely() {
        return super.decodeCompletely();
    }

    @Override // org.codehaus.stax2.ri.typed.Base64DecoderBase
    public /* bridge */ /* synthetic */ Stax2Util.ByteAggregator getByteAggregator() {
        return super.getByteAggregator();
    }

    public void init(Base64Variant base64Variant, boolean z, String str) {
        this._variant = base64Variant;
        if (z) {
            this._state = 0;
        }
        this._currSegment = str;
        this._currSegmentPtr = 0;
        this._currSegmentEnd = str.length();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:28:0x008b  */
    /* JADX WARN: Code duplicated, block: B:32:0x009b  */
    /* JADX WARN: Code duplicated, block: B:35:0x00af  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:54:0x0104  */
    /* JADX WARN: Code duplicated, block: B:59:0x0114  */
    /* JADX WARN: Code duplicated, block: B:74:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0110 A[SYNTHETIC] */
    @Override // org.codehaus.stax2.ri.typed.Base64DecoderBase
    public int decode(byte[] bArr, int i, int i2) throws IllegalArgumentException {
        int i3;
        char cCharAt;
        int iDecodeBase64Char;
        int i4;
        char cCharAt2;
        int iDecodeBase64Char2;
        int i5;
        char cCharAt3;
        int iDecodeBase64Char3;
        char cCharAt4;
        int i6 = i2 + i;
        int i7 = i;
        while (true) {
            switch (this._state) {
                case 0:
                    do {
                        int i8 = this._currSegmentPtr;
                        if (i8 < this._currSegmentEnd) {
                            String str = this._currSegment;
                            this._currSegmentPtr = i8 + 1;
                            cCharAt4 = str.charAt(i8);
                        }
                        return i7 - i;
                    } while (cCharAt4 <= ' ');
                    int iDecodeBase64Char4 = this._variant.decodeBase64Char(cCharAt4);
                    if (iDecodeBase64Char4 < 0) {
                        throw reportInvalidChar(cCharAt4, 0);
                    }
                    this._decodedData = iDecodeBase64Char4;
                    i5 = this._currSegmentPtr;
                    if (i5 >= this._currSegmentEnd) {
                        this._state = 1;
                    } else {
                        String str2 = this._currSegment;
                        this._currSegmentPtr = i5 + 1;
                        cCharAt3 = str2.charAt(i5);
                        iDecodeBase64Char3 = this._variant.decodeBase64Char(cCharAt3);
                        if (iDecodeBase64Char3 >= 0) {
                            throw reportInvalidChar(cCharAt3, 1);
                        }
                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char3;
                        i4 = this._currSegmentPtr;
                        if (i4 >= this._currSegmentEnd) {
                            this._state = 2;
                        } else {
                            String str3 = this._currSegment;
                            this._currSegmentPtr = i4 + 1;
                            cCharAt2 = str3.charAt(i4);
                            iDecodeBase64Char2 = this._variant.decodeBase64Char(cCharAt2);
                            if (iDecodeBase64Char2 < 0) {
                                if (iDecodeBase64Char2 != -2) {
                                    throw reportInvalidChar(cCharAt2, 2);
                                }
                                this._state = 7;
                            } else {
                                this._decodedData = (this._decodedData << 6) | iDecodeBase64Char2;
                                i3 = this._currSegmentPtr;
                                if (i3 >= this._currSegmentEnd) {
                                    this._state = 3;
                                } else {
                                    String str4 = this._currSegment;
                                    this._currSegmentPtr = i3 + 1;
                                    cCharAt = str4.charAt(i3);
                                    iDecodeBase64Char = this._variant.decodeBase64Char(cCharAt);
                                    if (iDecodeBase64Char < 0) {
                                        if (iDecodeBase64Char == -2) {
                                            throw reportInvalidChar(cCharAt, 3);
                                        }
                                        this._decodedData >>= 2;
                                        this._state = 5;
                                    } else {
                                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                                        if (i7 >= i6) {
                                            this._state = 4;
                                        } else {
                                            bArr[i7] = (byte) (this._decodedData >> 16);
                                            i7++;
                                            if (i7 >= i6) {
                                                this._state = 5;
                                            } else {
                                                bArr[i7] = (byte) (this._decodedData >> 8);
                                                i7++;
                                                if (i7 >= i6) {
                                                    this._state = 6;
                                                } else {
                                                    bArr[i7] = (byte) this._decodedData;
                                                    this._state = 0;
                                                    i7++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return i7 - i;
                case 1:
                    i5 = this._currSegmentPtr;
                    if (i5 >= this._currSegmentEnd) {
                        this._state = 1;
                    } else {
                        String str5 = this._currSegment;
                        this._currSegmentPtr = i5 + 1;
                        cCharAt3 = str5.charAt(i5);
                        iDecodeBase64Char3 = this._variant.decodeBase64Char(cCharAt3);
                        if (iDecodeBase64Char3 >= 0) {
                            throw reportInvalidChar(cCharAt3, 1);
                        }
                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char3;
                        i4 = this._currSegmentPtr;
                        if (i4 >= this._currSegmentEnd) {
                            this._state = 2;
                        } else {
                            String str6 = this._currSegment;
                            this._currSegmentPtr = i4 + 1;
                            cCharAt2 = str6.charAt(i4);
                            iDecodeBase64Char2 = this._variant.decodeBase64Char(cCharAt2);
                            if (iDecodeBase64Char2 < 0) {
                                if (iDecodeBase64Char2 != -2) {
                                    throw reportInvalidChar(cCharAt2, 2);
                                }
                                this._state = 7;
                            } else {
                                this._decodedData = (this._decodedData << 6) | iDecodeBase64Char2;
                                i3 = this._currSegmentPtr;
                                if (i3 >= this._currSegmentEnd) {
                                    this._state = 3;
                                } else {
                                    String str7 = this._currSegment;
                                    this._currSegmentPtr = i3 + 1;
                                    cCharAt = str7.charAt(i3);
                                    iDecodeBase64Char = this._variant.decodeBase64Char(cCharAt);
                                    if (iDecodeBase64Char < 0) {
                                        if (iDecodeBase64Char == -2) {
                                            throw reportInvalidChar(cCharAt, 3);
                                        }
                                        this._decodedData >>= 2;
                                        this._state = 5;
                                    } else {
                                        this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                                        if (i7 >= i6) {
                                            this._state = 4;
                                        } else {
                                            bArr[i7] = (byte) (this._decodedData >> 16);
                                            i7++;
                                            if (i7 >= i6) {
                                                this._state = 5;
                                            } else {
                                                bArr[i7] = (byte) (this._decodedData >> 8);
                                                i7++;
                                                if (i7 >= i6) {
                                                    this._state = 6;
                                                } else {
                                                    bArr[i7] = (byte) this._decodedData;
                                                    this._state = 0;
                                                    i7++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return i7 - i;
                case 2:
                    i4 = this._currSegmentPtr;
                    if (i4 >= this._currSegmentEnd) {
                        this._state = 2;
                    } else {
                        String str8 = this._currSegment;
                        this._currSegmentPtr = i4 + 1;
                        cCharAt2 = str8.charAt(i4);
                        iDecodeBase64Char2 = this._variant.decodeBase64Char(cCharAt2);
                        if (iDecodeBase64Char2 < 0) {
                            if (iDecodeBase64Char2 != -2) {
                                throw reportInvalidChar(cCharAt2, 2);
                            }
                            this._state = 7;
                        } else {
                            this._decodedData = (this._decodedData << 6) | iDecodeBase64Char2;
                            i3 = this._currSegmentPtr;
                            if (i3 >= this._currSegmentEnd) {
                                this._state = 3;
                            } else {
                                String str9 = this._currSegment;
                                this._currSegmentPtr = i3 + 1;
                                cCharAt = str9.charAt(i3);
                                iDecodeBase64Char = this._variant.decodeBase64Char(cCharAt);
                                if (iDecodeBase64Char < 0) {
                                    if (iDecodeBase64Char == -2) {
                                        throw reportInvalidChar(cCharAt, 3);
                                    }
                                    this._decodedData >>= 2;
                                    this._state = 5;
                                } else {
                                    this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                                    if (i7 >= i6) {
                                        this._state = 4;
                                    } else {
                                        bArr[i7] = (byte) (this._decodedData >> 16);
                                        i7++;
                                        if (i7 >= i6) {
                                            this._state = 5;
                                        } else {
                                            bArr[i7] = (byte) (this._decodedData >> 8);
                                            i7++;
                                            if (i7 >= i6) {
                                                this._state = 6;
                                            } else {
                                                bArr[i7] = (byte) this._decodedData;
                                                this._state = 0;
                                                i7++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return i7 - i;
                case 3:
                    i3 = this._currSegmentPtr;
                    if (i3 >= this._currSegmentEnd) {
                        this._state = 3;
                    } else {
                        String str10 = this._currSegment;
                        this._currSegmentPtr = i3 + 1;
                        cCharAt = str10.charAt(i3);
                        iDecodeBase64Char = this._variant.decodeBase64Char(cCharAt);
                        if (iDecodeBase64Char < 0) {
                            if (iDecodeBase64Char == -2) {
                                throw reportInvalidChar(cCharAt, 3);
                            }
                            this._decodedData >>= 2;
                            this._state = 5;
                        } else {
                            this._decodedData = (this._decodedData << 6) | iDecodeBase64Char;
                            if (i7 >= i6) {
                                this._state = 4;
                            } else {
                                bArr[i7] = (byte) (this._decodedData >> 16);
                                i7++;
                                if (i7 >= i6) {
                                    this._state = 5;
                                } else {
                                    bArr[i7] = (byte) (this._decodedData >> 8);
                                    i7++;
                                    if (i7 >= i6) {
                                        this._state = 6;
                                    } else {
                                        bArr[i7] = (byte) this._decodedData;
                                        this._state = 0;
                                        i7++;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return i7 - i;
                case 4:
                    if (i7 >= i6) {
                        this._state = 4;
                    } else {
                        bArr[i7] = (byte) (this._decodedData >> 16);
                        i7++;
                        if (i7 >= i6) {
                            this._state = 5;
                        } else {
                            bArr[i7] = (byte) (this._decodedData >> 8);
                            i7++;
                            if (i7 >= i6) {
                                this._state = 6;
                            } else {
                                bArr[i7] = (byte) this._decodedData;
                                this._state = 0;
                                i7++;
                            }
                        }
                        break;
                    }
                    return i7 - i;
                case 5:
                    if (i7 >= i6) {
                        this._state = 5;
                    } else {
                        bArr[i7] = (byte) (this._decodedData >> 8);
                        i7++;
                        if (i7 >= i6) {
                            this._state = 6;
                        } else {
                            bArr[i7] = (byte) this._decodedData;
                            this._state = 0;
                            i7++;
                        }
                        break;
                    }
                    return i7 - i;
                case 6:
                    if (i7 >= i6) {
                        this._state = 6;
                        return i7 - i;
                    }
                    bArr[i7] = (byte) this._decodedData;
                    this._state = 0;
                    i7++;
                    break;
                    break;
                case 7:
                    int i9 = this._currSegmentPtr;
                    if (i9 >= this._currSegmentEnd) {
                        return i7 - i;
                    }
                    String str11 = this._currSegment;
                    this._currSegmentPtr = i9 + 1;
                    char cCharAt5 = str11.charAt(i9);
                    if (!this._variant.usesPaddingChar(cCharAt5)) {
                        throw reportInvalidChar(cCharAt5, 3, "expected padding character '='");
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
}

package com.fasterxml.aalto.io;

import bsp.FinalBsp;
import com.fasterxml.aalto.out.WriterConfig;
import com.syu.media.ListCondition01;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    final boolean mAutoCloseOutput;
    final WriterConfig mConfig;
    OutputStream mOut;
    byte[] mOutBuffer;
    final int mOutBufferLast;
    int mOutPtr;
    int mSurrogate = 0;

    public UTF8Writer(WriterConfig writerConfig, OutputStream outputStream, boolean z) {
        this.mConfig = writerConfig;
        this.mAutoCloseOutput = z;
        this.mOut = outputStream;
        byte[] bArrAllocFullBBuffer = writerConfig.allocFullBBuffer(4000);
        this.mOutBuffer = bArrAllocFullBBuffer;
        this.mOutBufferLast = bArrAllocFullBBuffer.length - 4;
        this.mOutPtr = 0;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.mOut;
        if (outputStream != null) {
            int i = this.mOutPtr;
            if (i > 0) {
                outputStream.write(this.mOutBuffer, 0, i);
                this.mOutPtr = 0;
            }
            OutputStream outputStream2 = this.mOut;
            this.mOut = null;
            byte[] bArr = this.mOutBuffer;
            this.mOutBuffer = null;
            if (this.mAutoCloseOutput) {
                outputStream2.close();
            }
            this.mConfig.freeFullBBuffer(bArr);
            int i2 = this.mSurrogate;
            this.mSurrogate = 0;
            if (i2 > 0) {
                throwIllegal(i2);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        int i = this.mOutPtr;
        if (i > 0) {
            this.mOut.write(this.mOutBuffer, 0, i);
            this.mOutPtr = 0;
        }
        this.mOut.flush();
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write(cArr[i]);
                return;
            }
            return;
        }
        if (this.mSurrogate > 0) {
            i2--;
            write(convertSurrogate(cArr[i]));
            i++;
        }
        int i3 = this.mOutPtr;
        byte[] bArr = this.mOutBuffer;
        int i4 = this.mOutBufferLast;
        int i5 = i2 + i;
        while (i < i5) {
            if (i3 >= i4) {
                this.mOut.write(bArr, 0, i3);
                i3 = 0;
            }
            int i6 = i + 1;
            char c = cArr[i];
            if (c < 128) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) c;
                int i8 = i5 - i6;
                int i9 = i4 - i7;
                if (i8 > i9) {
                    i8 = i9;
                }
                int i10 = i8 + i6;
                while (true) {
                    i = i6;
                    i3 = i7;
                    if (i >= i10) {
                        continue;
                    } else {
                        i6 = i + 1;
                        c = cArr[i];
                        if (c < 128) {
                            i7 = i3 + 1;
                            bArr[i3] = (byte) c;
                        }
                    }
                }
            }
            if (c < 2048) {
                int i11 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | ListCondition01.USB);
                i3 = i11 + 1;
                bArr[i11] = (byte) ((c & '?') | 128);
                i = i6;
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                int i12 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | FinalBsp.KEY_CODE_NEXT);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((c >> 6) & 63) | 128);
                bArr[i13] = (byte) ((c & '?') | 128);
                i = i6;
                i3 = i13 + 1;
            } else {
                if (c > SURR1_LAST) {
                    this.mOutPtr = i3;
                    throwIllegal(c);
                }
                this.mSurrogate = c;
                if (i6 >= i5) {
                    break;
                }
                i = i6 + 1;
                int iConvertSurrogate = convertSurrogate(cArr[i6]);
                if (iConvertSurrogate > 1114111) {
                    this.mOutPtr = i3;
                    throwIllegal(iConvertSurrogate);
                }
                int i14 = i3 + 1;
                bArr[i3] = (byte) ((iConvertSurrogate >> 18) | FinalBsp.KEY_CODE_TONE_MINUS);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((iConvertSurrogate >> 12) & 63) | 128);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((iConvertSurrogate >> 6) & 63) | 128);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((iConvertSurrogate & 63) | 128);
            }
        }
        this.mOutPtr = i3;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this.mSurrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= SURR1_FIRST && i <= SURR2_LAST) {
            if (i > SURR1_LAST) {
                throwIllegal(i);
            }
            this.mSurrogate = i;
            return;
        }
        int i3 = this.mOutPtr;
        if (i3 >= this.mOutBufferLast) {
            this.mOut.write(this.mOutBuffer, 0, i3);
            this.mOutPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this.mOutBuffer;
            int i4 = this.mOutPtr;
            this.mOutPtr = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        int i5 = this.mOutPtr;
        if (i < 2048) {
            byte[] bArr2 = this.mOutBuffer;
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((i >> 6) | ListCondition01.USB);
            i2 = i6 + 1;
            bArr2[i6] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this.mOutBuffer;
            int i7 = i5 + 1;
            bArr3[i5] = (byte) ((i >> 12) | FinalBsp.KEY_CODE_NEXT);
            int i8 = i7 + 1;
            bArr3[i7] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i8] = (byte) ((i & 63) | 128);
            i2 = i8 + 1;
        } else {
            if (i > 1114111) {
                throwIllegal(i);
            }
            byte[] bArr4 = this.mOutBuffer;
            int i9 = i5 + 1;
            bArr4[i5] = (byte) ((i >> 18) | FinalBsp.KEY_CODE_TONE_MINUS);
            int i10 = i9 + 1;
            bArr4[i9] = (byte) (((i >> 12) & 63) | 128);
            int i11 = i10 + 1;
            bArr4[i10] = (byte) (((i >> 6) & 63) | 128);
            i2 = i11 + 1;
            bArr4[i11] = (byte) ((i & 63) | 128);
        }
        this.mOutPtr = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write(str.charAt(i));
                return;
            }
            return;
        }
        if (this.mSurrogate > 0) {
            i2--;
            write(convertSurrogate(str.charAt(i)));
            i++;
        }
        int i3 = this.mOutPtr;
        byte[] bArr = this.mOutBuffer;
        int i4 = this.mOutBufferLast;
        int i5 = i2 + i;
        while (i < i5) {
            if (i3 >= i4) {
                this.mOut.write(bArr, 0, i3);
                i3 = 0;
            }
            int i6 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) cCharAt;
                int i8 = i5 - i6;
                int i9 = i4 - i7;
                if (i8 > i9) {
                    i8 = i9;
                }
                int i10 = i8 + i6;
                while (true) {
                    i = i6;
                    i3 = i7;
                    if (i >= i10) {
                        continue;
                    } else {
                        i6 = i + 1;
                        cCharAt = str.charAt(i);
                        if (cCharAt < 128) {
                            i7 = i3 + 1;
                            bArr[i3] = (byte) cCharAt;
                        }
                    }
                }
            }
            if (cCharAt < 2048) {
                int i11 = i3 + 1;
                bArr[i3] = (byte) ((cCharAt >> 6) | ListCondition01.USB);
                i3 = i11 + 1;
                bArr[i11] = (byte) ((cCharAt & '?') | 128);
                i = i6;
            } else if (cCharAt < SURR1_FIRST || cCharAt > SURR2_LAST) {
                int i12 = i3 + 1;
                bArr[i3] = (byte) ((cCharAt >> '\f') | FinalBsp.KEY_CODE_NEXT);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((cCharAt >> 6) & 63) | 128);
                bArr[i13] = (byte) ((cCharAt & '?') | 128);
                i = i6;
                i3 = i13 + 1;
            } else {
                if (cCharAt > SURR1_LAST) {
                    this.mOutPtr = i3;
                    throwIllegal(cCharAt);
                }
                this.mSurrogate = cCharAt;
                if (i6 >= i5) {
                    break;
                }
                i = i6 + 1;
                int iConvertSurrogate = convertSurrogate(str.charAt(i6));
                if (iConvertSurrogate > 1114111) {
                    this.mOutPtr = i3;
                    throwIllegal(iConvertSurrogate);
                }
                int i14 = i3 + 1;
                bArr[i3] = (byte) ((iConvertSurrogate >> 18) | FinalBsp.KEY_CODE_TONE_MINUS);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((iConvertSurrogate >> 12) & 63) | 128);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((iConvertSurrogate >> 6) & 63) | 128);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((iConvertSurrogate & 63) | 128);
            }
        }
        this.mOutPtr = i3;
    }

    private int convertSurrogate(int i) throws IOException {
        int i2 = this.mSurrogate;
        this.mSurrogate = 0;
        if (i < SURR2_FIRST || i > SURR2_LAST) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
        }
        return ((i2 - SURR1_FIRST) << 10) + 65536 + (i - SURR2_FIRST);
    }

    private void throwIllegal(int i) throws IOException {
        if (i > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 3629");
        }
        if (i < SURR1_FIRST) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i <= SURR1_LAST) {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }
}

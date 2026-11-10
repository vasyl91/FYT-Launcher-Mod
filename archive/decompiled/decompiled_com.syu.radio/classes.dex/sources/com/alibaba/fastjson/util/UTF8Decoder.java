package com.alibaba.fastjson.util;

import com.lsec.core.util.data.FinalCanbus;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName(HTTP.UTF_8);

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private static boolean isNotContinuation(int b) {
        return (b & 192) != 128;
    }

    private static boolean isMalformed2(int b1, int b2) {
        return (b1 & 30) == 0 || (b2 & 192) != 128;
    }

    private static boolean isMalformed3(int b1, int b2, int b3) {
        return ((b1 != -32 || (b2 & 224) != 128) && (b2 & 192) == 128 && (b3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int b2, int b3, int b4) {
        return ((b2 & 192) == 128 && (b3 & 192) == 128 && (b4 & 192) == 128) ? false : true;
    }

    private static CoderResult lookupN(ByteBuffer src, int n) {
        for (int i = 1; i < n; i++) {
            if (isNotContinuation(src.get())) {
                return CoderResult.malformedForLength(i);
            }
        }
        return CoderResult.malformedForLength(n);
    }

    public static CoderResult malformedN(ByteBuffer src, int nb) {
        switch (nb) {
            case 1:
                int b1 = src.get();
                if ((b1 >> 2) == -2) {
                    return src.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(src, 5);
                }
                if ((b1 >> 1) == -2) {
                    if (src.remaining() < 5) {
                        return CoderResult.UNDERFLOW;
                    }
                    return lookupN(src, 6);
                }
                return CoderResult.malformedForLength(1);
            case 2:
                return CoderResult.malformedForLength(1);
            case 3:
                int b2 = src.get();
                int b3 = src.get();
                return CoderResult.malformedForLength(((b2 == -32 && (b3 & 224) == 128) || isNotContinuation(b3)) ? 1 : 2);
            case 4:
                int b4 = src.get() & 255;
                int b5 = src.get() & 255;
                if (b4 > 244 || ((b4 == 240 && (b5 < 144 || b5 > 191)) || ((b4 == 244 && (b5 & 240) != 128) || isNotContinuation(b5)))) {
                    return CoderResult.malformedForLength(1);
                }
                return isNotContinuation(src.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
            default:
                throw new IllegalStateException();
        }
    }

    private static CoderResult malformed(ByteBuffer src, int sp, CharBuffer dst, int dp, int nb) {
        src.position(sp - src.arrayOffset());
        CoderResult cr = malformedN(src, nb);
        updatePositions(src, sp, dst, dp);
        return cr;
    }

    private static CoderResult xflow(Buffer src, int sp, int sl, Buffer dst, int dp, int nb) {
        updatePositions(src, sp, dst, dp);
        return (nb == 0 || sl - sp < nb) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    private CoderResult decodeArrayLoop(ByteBuffer src, CharBuffer dst) {
        byte[] srcArray = src.array();
        int srcPosition = src.arrayOffset() + src.position();
        int srcLength = src.arrayOffset() + src.limit();
        char[] destArray = dst.array();
        int destPosition = dst.arrayOffset() + dst.position();
        int destLength = dst.arrayOffset() + dst.limit();
        int destLengthASCII = destPosition + Math.min(srcLength - srcPosition, destLength - destPosition);
        int destPosition2 = destPosition;
        int srcPosition2 = srcPosition;
        while (destPosition2 < destLengthASCII && srcArray[srcPosition2] >= 0) {
            destArray[destPosition2] = (char) srcArray[srcPosition2];
            destPosition2++;
            srcPosition2++;
        }
        while (srcPosition2 < srcLength) {
            int b1 = srcArray[srcPosition2];
            if (b1 >= 0) {
                if (destPosition2 >= destLength) {
                    return xflow(src, srcPosition2, srcLength, dst, destPosition2, 1);
                }
                destArray[destPosition2] = (char) b1;
                srcPosition2++;
                destPosition2++;
            } else if ((b1 >> 5) == -2) {
                if (srcLength - srcPosition2 < 2 || destPosition2 >= destLength) {
                    return xflow(src, srcPosition2, srcLength, dst, destPosition2, 2);
                }
                int b2 = srcArray[srcPosition2 + 1];
                if (isMalformed2(b1, b2)) {
                    return malformed(src, srcPosition2, dst, destPosition2, 2);
                }
                destArray[destPosition2] = (char) (((b1 << 6) ^ b2) ^ 3968);
                srcPosition2 += 2;
                destPosition2++;
            } else if ((b1 >> 4) == -2) {
                if (srcLength - srcPosition2 < 3 || destPosition2 >= destLength) {
                    return xflow(src, srcPosition2, srcLength, dst, destPosition2, 3);
                }
                int b3 = srcArray[srcPosition2 + 1];
                int b4 = srcArray[srcPosition2 + 2];
                if (isMalformed3(b1, b3, b4)) {
                    return malformed(src, srcPosition2, dst, destPosition2, 3);
                }
                destArray[destPosition2] = (char) ((((b1 << 12) ^ (b3 << 6)) ^ b4) ^ 8064);
                srcPosition2 += 3;
                destPosition2++;
            } else if ((b1 >> 3) == -2) {
                if (srcLength - srcPosition2 < 4 || destLength - destPosition2 < 2) {
                    return xflow(src, srcPosition2, srcLength, dst, destPosition2, 4);
                }
                int b5 = srcArray[srcPosition2 + 1];
                int b6 = srcArray[srcPosition2 + 2];
                int b7 = srcArray[srcPosition2 + 3];
                int uc = ((b1 & 7) << 18) | ((b5 & 63) << 12) | ((b6 & 63) << 6) | (b7 & 63);
                if (isMalformed4(b5, b6, b7) || !Surrogate.neededFor(uc)) {
                    return malformed(src, srcPosition2, dst, destPosition2, 4);
                }
                int destPosition3 = destPosition2 + 1;
                destArray[destPosition2] = Surrogate.high(uc);
                destPosition2 = destPosition3 + 1;
                destArray[destPosition3] = Surrogate.low(uc);
                srcPosition2 += 4;
            } else {
                return malformed(src, srcPosition2, dst, destPosition2, 1);
            }
        }
        return xflow(src, srcPosition2, srcLength, dst, destPosition2, 0);
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer src, CharBuffer dst) {
        return decodeArrayLoop(src, dst);
    }

    static void updatePositions(Buffer src, int sp, Buffer dst, int dp) {
        src.position(sp);
        dst.position(dp);
    }

    private static class Surrogate {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        static {
            $assertionsDisabled = !UTF8Decoder.class.desiredAssertionStatus();
        }

        private Surrogate() {
        }

        public static boolean neededFor(int uc) {
            return uc >= 65536 && uc <= 1114111;
        }

        public static char high(int uc) {
            if ($assertionsDisabled || neededFor(uc)) {
                return (char) (55296 | (((uc - 65536) >> 10) & FinalCanbus.U_CANBUS_AIR_VER));
            }
            throw new AssertionError();
        }

        public static char low(int uc) {
            if ($assertionsDisabled || neededFor(uc)) {
                return (char) (56320 | ((uc - 65536) & FinalCanbus.U_CANBUS_AIR_VER));
            }
            throw new AssertionError();
        }
    }
}

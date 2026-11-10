package org.codehaus.stax2.ri.typed;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import org.codehaus.stax2.typed.TypedArrayDecoder;
import org.codehaus.stax2.typed.TypedValueDecoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class ValueDecoderFactory {
    protected BooleanDecoder mBooleanDecoder = null;
    protected IntDecoder mIntDecoder = null;
    protected LongDecoder mLongDecoder = null;
    protected FloatDecoder mFloatDecoder = null;
    protected DoubleDecoder mDoubleDecoder = null;

    public BooleanDecoder getBooleanDecoder() {
        if (this.mBooleanDecoder == null) {
            this.mBooleanDecoder = new BooleanDecoder();
        }
        return this.mBooleanDecoder;
    }

    public IntDecoder getIntDecoder() {
        if (this.mIntDecoder == null) {
            this.mIntDecoder = new IntDecoder();
        }
        return this.mIntDecoder;
    }

    public LongDecoder getLongDecoder() {
        if (this.mLongDecoder == null) {
            this.mLongDecoder = new LongDecoder();
        }
        return this.mLongDecoder;
    }

    public FloatDecoder getFloatDecoder() {
        if (this.mFloatDecoder == null) {
            this.mFloatDecoder = new FloatDecoder();
        }
        return this.mFloatDecoder;
    }

    public DoubleDecoder getDoubleDecoder() {
        if (this.mDoubleDecoder == null) {
            this.mDoubleDecoder = new DoubleDecoder();
        }
        return this.mDoubleDecoder;
    }

    public IntegerDecoder getIntegerDecoder() {
        return new IntegerDecoder();
    }

    public DecimalDecoder getDecimalDecoder() {
        return new DecimalDecoder();
    }

    public QNameDecoder getQNameDecoder(NamespaceContext namespaceContext) {
        return new QNameDecoder(namespaceContext);
    }

    public IntArrayDecoder getIntArrayDecoder(int[] iArr, int i, int i2) {
        return new IntArrayDecoder(iArr, i, i2, getIntDecoder());
    }

    public IntArrayDecoder getIntArrayDecoder() {
        return new IntArrayDecoder(getIntDecoder());
    }

    public LongArrayDecoder getLongArrayDecoder(long[] jArr, int i, int i2) {
        return new LongArrayDecoder(jArr, i, i2, getLongDecoder());
    }

    public LongArrayDecoder getLongArrayDecoder() {
        return new LongArrayDecoder(getLongDecoder());
    }

    public FloatArrayDecoder getFloatArrayDecoder(float[] fArr, int i, int i2) {
        return new FloatArrayDecoder(fArr, i, i2, getFloatDecoder());
    }

    public FloatArrayDecoder getFloatArrayDecoder() {
        return new FloatArrayDecoder(getFloatDecoder());
    }

    public DoubleArrayDecoder getDoubleArrayDecoder(double[] dArr, int i, int i2) {
        return new DoubleArrayDecoder(dArr, i, i2, getDoubleDecoder());
    }

    public DoubleArrayDecoder getDoubleArrayDecoder() {
        return new DoubleArrayDecoder(getDoubleDecoder());
    }

    public static abstract class DecoderBase extends TypedValueDecoder {
        static final long L_BILLION = 1000000000;
        static final long L_MAX_INT = 2147483647L;
        static final long L_MIN_INT = -2147483648L;
        protected int mNextPtr;
        static final BigInteger BD_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
        static final BigInteger BD_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

        public abstract String getType();

        protected DecoderBase() {
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void handleEmptyValue() {
            throw new IllegalArgumentException("Empty value (all white space) not a valid lexical representation of " + getType());
        }

        protected void verifyDigits(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt > '9' || cCharAt < '0') {
                    throw constructInvalidValue(str);
                }
                i++;
            }
        }

        protected void verifyDigits(char[] cArr, int i, int i2, int i3) {
            while (i3 < i2) {
                char c = cArr[i3];
                if (c > '9' || c < '0') {
                    throw constructInvalidValue(cArr, i, i2);
                }
                i3++;
            }
        }

        protected int skipSignAndZeroes(String str, char c, boolean z, int i) {
            int i2 = 1;
            if (z) {
                if (1 >= i) {
                    throw constructInvalidValue(str);
                }
                c = str.charAt(1);
                i2 = 2;
            }
            int i3 = c - '0';
            if (i3 < 0 || i3 > 9) {
                throw constructInvalidValue(str);
            }
            while (i3 == 0 && i2 < i) {
                int iCharAt = str.charAt(i2) - '0';
                if (iCharAt < 0 || iCharAt > 9) {
                    break;
                }
                i2++;
                i3 = iCharAt;
            }
            this.mNextPtr = i2;
            return i3;
        }

        protected int skipSignAndZeroes(char[] cArr, char c, boolean z, int i, int i2) {
            int i3 = i + 1;
            if (z) {
                if (i3 >= i2) {
                    throw constructInvalidValue(cArr, i, i2);
                }
                char c2 = cArr[i3];
                i3++;
                c = c2;
            }
            int i4 = c - '0';
            if (i4 < 0 || i4 > 9) {
                throw constructInvalidValue(cArr, i, i2);
            }
            while (i4 == 0 && i3 < i2) {
                int i5 = cArr[i3] - '0';
                if (i5 < 0 || i5 > 9) {
                    break;
                }
                i3++;
                i4 = i5;
            }
            this.mNextPtr = i3;
            return i4;
        }

        protected static final int parseInt(char[] cArr, int i, int i2) {
            int i3 = cArr[i] - '0';
            int i4 = i + 1;
            if (i4 >= i2) {
                return i3;
            }
            int i5 = (i3 * 10) + (cArr[i4] - '0');
            int i6 = i4 + 1;
            if (i6 >= i2) {
                return i5;
            }
            int i7 = (i5 * 10) + (cArr[i6] - '0');
            int i8 = i6 + 1;
            if (i8 >= i2) {
                return i7;
            }
            int i9 = (i7 * 10) + (cArr[i8] - '0');
            int i10 = i8 + 1;
            if (i10 >= i2) {
                return i9;
            }
            int i11 = (i9 * 10) + (cArr[i10] - '0');
            int i12 = i10 + 1;
            if (i12 >= i2) {
                return i11;
            }
            int i13 = (i11 * 10) + (cArr[i12] - '0');
            int i14 = i12 + 1;
            if (i14 >= i2) {
                return i13;
            }
            int i15 = (i13 * 10) + (cArr[i14] - '0');
            int i16 = i14 + 1;
            if (i16 >= i2) {
                return i15;
            }
            int i17 = (i15 * 10) + (cArr[i16] - '0');
            int i18 = i16 + 1;
            return i18 < i2 ? (i17 * 10) + (cArr[i18] - '0') : i17;
        }

        protected static final int parseInt(int i, char[] cArr, int i2, int i3) {
            int i4 = (i * 10) + (cArr[i2] - '0');
            int i5 = i2 + 1;
            if (i5 >= i3) {
                return i4;
            }
            int i6 = (i4 * 10) + (cArr[i5] - '0');
            int i7 = i5 + 1;
            if (i7 >= i3) {
                return i6;
            }
            int i8 = (i6 * 10) + (cArr[i7] - '0');
            int i9 = i7 + 1;
            if (i9 >= i3) {
                return i8;
            }
            int i10 = (i8 * 10) + (cArr[i9] - '0');
            int i11 = i9 + 1;
            if (i11 >= i3) {
                return i10;
            }
            int i12 = (i10 * 10) + (cArr[i11] - '0');
            int i13 = i11 + 1;
            if (i13 >= i3) {
                return i12;
            }
            int i14 = (i12 * 10) + (cArr[i13] - '0');
            int i15 = i13 + 1;
            if (i15 >= i3) {
                return i14;
            }
            int i16 = (i14 * 10) + (cArr[i15] - '0');
            int i17 = i15 + 1;
            return i17 < i3 ? (i16 * 10) + (cArr[i17] - '0') : i16;
        }

        protected static final int parseInt(String str, int i, int i2) {
            int iCharAt = str.charAt(i) - '0';
            int i3 = i + 1;
            if (i3 >= i2) {
                return iCharAt;
            }
            int iCharAt2 = (iCharAt * 10) + (str.charAt(i3) - '0');
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return iCharAt2;
            }
            int iCharAt3 = (iCharAt2 * 10) + (str.charAt(i4) - '0');
            int i5 = i4 + 1;
            if (i5 >= i2) {
                return iCharAt3;
            }
            int iCharAt4 = (iCharAt3 * 10) + (str.charAt(i5) - '0');
            int i6 = i5 + 1;
            if (i6 >= i2) {
                return iCharAt4;
            }
            int iCharAt5 = (iCharAt4 * 10) + (str.charAt(i6) - '0');
            int i7 = i6 + 1;
            if (i7 >= i2) {
                return iCharAt5;
            }
            int iCharAt6 = (iCharAt5 * 10) + (str.charAt(i7) - '0');
            int i8 = i7 + 1;
            if (i8 >= i2) {
                return iCharAt6;
            }
            int iCharAt7 = (iCharAt6 * 10) + (str.charAt(i8) - '0');
            int i9 = i8 + 1;
            if (i9 >= i2) {
                return iCharAt7;
            }
            int iCharAt8 = (iCharAt7 * 10) + (str.charAt(i9) - '0');
            int i10 = i9 + 1;
            return i10 < i2 ? (iCharAt8 * 10) + (str.charAt(i10) - '0') : iCharAt8;
        }

        protected static final int parseInt(int i, String str, int i2, int i3) {
            int iCharAt = (i * 10) + (str.charAt(i2) - '0');
            int i4 = i2 + 1;
            if (i4 >= i3) {
                return iCharAt;
            }
            int iCharAt2 = (iCharAt * 10) + (str.charAt(i4) - '0');
            int i5 = i4 + 1;
            if (i5 >= i3) {
                return iCharAt2;
            }
            int iCharAt3 = (iCharAt2 * 10) + (str.charAt(i5) - '0');
            int i6 = i5 + 1;
            if (i6 >= i3) {
                return iCharAt3;
            }
            int iCharAt4 = (iCharAt3 * 10) + (str.charAt(i6) - '0');
            int i7 = i6 + 1;
            if (i7 >= i3) {
                return iCharAt4;
            }
            int iCharAt5 = (iCharAt4 * 10) + (str.charAt(i7) - '0');
            int i8 = i7 + 1;
            if (i8 >= i3) {
                return iCharAt5;
            }
            int iCharAt6 = (iCharAt5 * 10) + (str.charAt(i8) - '0');
            int i9 = i8 + 1;
            if (i9 >= i3) {
                return iCharAt6;
            }
            int iCharAt7 = (iCharAt6 * 10) + (str.charAt(i9) - '0');
            int i10 = i9 + 1;
            return i10 < i3 ? (iCharAt7 * 10) + (str.charAt(i10) - '0') : iCharAt7;
        }

        protected static final long parseLong(char[] cArr, int i, int i2) {
            int i3 = i2 - 9;
            return (((long) parseInt(cArr, i, i3)) * L_BILLION) + ((long) parseInt(cArr, i3, i2));
        }

        protected static final long parseLong(String str, int i, int i2) {
            int i3 = i2 - 9;
            return (((long) parseInt(str, i, i3)) * L_BILLION) + ((long) parseInt(str, i3, i2));
        }

        protected IllegalArgumentException constructInvalidValue(String str) {
            return new IllegalArgumentException("Value \"" + str + "\" not a valid lexical representation of " + getType());
        }

        protected IllegalArgumentException constructInvalidValue(char[] cArr, int i, int i2) {
            return new IllegalArgumentException("Value \"" + lexicalDesc(cArr, i, i2) + "\" not a valid lexical representation of " + getType());
        }

        protected String lexicalDesc(char[] cArr, int i, int i2) {
            return _clean(new String(cArr, i, i2 - i));
        }

        protected String lexicalDesc(String str) {
            return _clean(str);
        }

        protected String _clean(String str) {
            return str.trim();
        }
    }

    public static final class BooleanDecoder extends DecoderBase {
        protected boolean mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "boolean";
        }

        public boolean getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            int length = str.length();
            char cCharAt = str.charAt(0);
            if (cCharAt == 't') {
                if (length == 4 && str.charAt(1) == 'r' && str.charAt(2) == 'u' && str.charAt(3) == 'e') {
                    this.mValue = true;
                    return;
                }
            } else if (cCharAt == 'f') {
                if (length == 5 && str.charAt(1) == 'a' && str.charAt(2) == 'l' && str.charAt(3) == 's' && str.charAt(4) == 'e') {
                    this.mValue = false;
                    return;
                }
            } else if (cCharAt == '0') {
                if (length == 1) {
                    this.mValue = false;
                    return;
                }
            } else if (cCharAt == '1' && length == 1) {
                this.mValue = true;
                return;
            }
            throw constructInvalidValue(str);
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            int i3 = i2 - i;
            char c = cArr[i];
            if (c == 't') {
                if (i3 == 4 && cArr[i + 1] == 'r' && cArr[i + 2] == 'u' && cArr[i + 3] == 'e') {
                    this.mValue = true;
                    return;
                }
            } else if (c == 'f') {
                if (i3 == 5 && cArr[i + 1] == 'a' && cArr[i + 2] == 'l' && cArr[i + 3] == 's' && cArr[i + 4] == 'e') {
                    this.mValue = false;
                    return;
                }
            } else if (c == '0') {
                if (i3 == 1) {
                    this.mValue = false;
                    return;
                }
            } else if (c == '1' && i3 == 1) {
                this.mValue = true;
                return;
            }
            throw constructInvalidValue(cArr, i, i2);
        }
    }

    public static final class IntDecoder extends DecoderBase {
        protected int mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "int";
        }

        public int getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            int iSkipSignAndZeroes;
            int length = str.length();
            char cCharAt = str.charAt(0);
            boolean z = cCharAt == '-';
            if (z || cCharAt == '+') {
                iSkipSignAndZeroes = skipSignAndZeroes(str, cCharAt, true, length);
            } else {
                iSkipSignAndZeroes = skipSignAndZeroes(str, cCharAt, false, length);
            }
            int i = this.mNextPtr;
            int i2 = length - i;
            if (i2 == 0) {
                if (z) {
                    iSkipSignAndZeroes = -iSkipSignAndZeroes;
                }
                this.mValue = iSkipSignAndZeroes;
                return;
            }
            verifyDigits(str, i, length);
            if (i2 <= 8) {
                int i3 = parseInt(iSkipSignAndZeroes, str, i, i2 + i);
                if (z) {
                    i3 = -i3;
                }
                this.mValue = i3;
                return;
            }
            if (i2 == 9 && iSkipSignAndZeroes < 3) {
                long j = (iSkipSignAndZeroes == 2 ? 2000000000L : 1000000000L) + ((long) parseInt(str, i, i2 + i));
                if (z) {
                    long j2 = -j;
                    if (j2 >= -2147483648L) {
                        this.mValue = (int) j2;
                        return;
                    }
                } else if (j <= 2147483647L) {
                    this.mValue = (int) j;
                    return;
                }
            }
            throw new IllegalArgumentException("value \"" + lexicalDesc(str) + "\" not a valid 32-bit integer: overflow.");
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            int iSkipSignAndZeroes;
            char c = cArr[i];
            boolean z = c == '-';
            if (z || c == '+') {
                iSkipSignAndZeroes = skipSignAndZeroes(cArr, c, true, i, i2);
            } else {
                iSkipSignAndZeroes = skipSignAndZeroes(cArr, c, false, i, i2);
            }
            int i3 = this.mNextPtr;
            int i4 = i2 - i3;
            if (i4 == 0) {
                if (z) {
                    iSkipSignAndZeroes = -iSkipSignAndZeroes;
                }
                this.mValue = iSkipSignAndZeroes;
                return;
            }
            verifyDigits(cArr, i, i2, i3);
            if (i4 <= 8) {
                int i5 = parseInt(iSkipSignAndZeroes, cArr, i3, i4 + i3);
                if (z) {
                    i5 = -i5;
                }
                this.mValue = i5;
                return;
            }
            if (i4 == 9 && iSkipSignAndZeroes < 3) {
                long j = (iSkipSignAndZeroes == 2 ? 2000000000L : 1000000000L) + ((long) parseInt(cArr, i3, i4 + i3));
                if (z) {
                    long j2 = -j;
                    if (j2 >= -2147483648L) {
                        this.mValue = (int) j2;
                        return;
                    }
                } else if (j <= 2147483647L) {
                    this.mValue = (int) j;
                    return;
                }
            }
            throw new IllegalArgumentException("value \"" + lexicalDesc(cArr, i, i2) + "\" not a valid 32-bit integer: overflow.");
        }
    }

    public static final class LongDecoder extends DecoderBase {
        protected long mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "long";
        }

        public long getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            int iSkipSignAndZeroes;
            int length = str.length();
            char cCharAt = str.charAt(0);
            boolean z = cCharAt == '-';
            if (z || cCharAt == '+') {
                iSkipSignAndZeroes = skipSignAndZeroes(str, cCharAt, true, length);
            } else {
                iSkipSignAndZeroes = skipSignAndZeroes(str, cCharAt, false, length);
            }
            int i = this.mNextPtr;
            int i2 = length - i;
            if (i2 == 0) {
                if (z) {
                    iSkipSignAndZeroes = -iSkipSignAndZeroes;
                }
                this.mValue = iSkipSignAndZeroes;
                return;
            }
            verifyDigits(str, i, length);
            if (i2 <= 8) {
                int i3 = parseInt(iSkipSignAndZeroes, str, i, i2 + i);
                if (z) {
                    i3 = -i3;
                }
                this.mValue = i3;
                return;
            }
            int i4 = i - 1;
            int i5 = i2 + 1;
            if (i5 <= 18) {
                long j = parseLong(str, i4, i5 + i4);
                if (z) {
                    j = -j;
                }
                this.mValue = j;
                return;
            }
            this.mValue = parseUsingBD(str.substring(i4, i5 + i4), z);
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            int iSkipSignAndZeroes;
            char c = cArr[i];
            boolean z = c == '-';
            if (z || c == '+') {
                iSkipSignAndZeroes = skipSignAndZeroes(cArr, c, true, i, i2);
            } else {
                iSkipSignAndZeroes = skipSignAndZeroes(cArr, c, false, i, i2);
            }
            int i3 = this.mNextPtr;
            int i4 = i2 - i3;
            if (i4 == 0) {
                if (z) {
                    iSkipSignAndZeroes = -iSkipSignAndZeroes;
                }
                this.mValue = iSkipSignAndZeroes;
                return;
            }
            verifyDigits(cArr, i, i2, i3);
            if (i4 <= 8) {
                int i5 = parseInt(iSkipSignAndZeroes, cArr, i3, i4 + i3);
                if (z) {
                    i5 = -i5;
                }
                this.mValue = i5;
                return;
            }
            int i6 = i3 - 1;
            int i7 = i4 + 1;
            if (i7 <= 18) {
                long j = parseLong(cArr, i6, i7 + i6);
                if (z) {
                    j = -j;
                }
                this.mValue = j;
                return;
            }
            this.mValue = parseUsingBD(new String(cArr, i6, i7), z);
        }

        private long parseUsingBD(String str, boolean z) {
            BigInteger bigInteger = new BigInteger(str);
            if (z) {
                BigInteger bigIntegerNegate = bigInteger.negate();
                if (bigIntegerNegate.compareTo(BD_MIN_LONG) >= 0) {
                    return bigIntegerNegate.longValue();
                }
            } else if (bigInteger.compareTo(BD_MAX_LONG) <= 0) {
                return bigInteger.longValue();
            }
            throw new IllegalArgumentException("value \"" + lexicalDesc(str) + "\" not a valid long: overflow.");
        }
    }

    public static final class FloatDecoder extends DecoderBase {
        protected float mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "float";
        }

        public float getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            int length = str.length();
            if (length == 3) {
                char cCharAt = str.charAt(0);
                if (cCharAt == 'I') {
                    if (str.charAt(1) == 'N' && str.charAt(2) == 'F') {
                        this.mValue = Float.POSITIVE_INFINITY;
                        return;
                    }
                } else if (cCharAt == 'N' && str.charAt(1) == 'a' && str.charAt(2) == 'N') {
                    this.mValue = Float.NaN;
                    return;
                }
            } else if (length == 4 && str.charAt(0) == '-' && str.charAt(1) == 'I' && str.charAt(2) == 'N' && str.charAt(3) == 'F') {
                this.mValue = Float.NEGATIVE_INFINITY;
                return;
            }
            try {
                this.mValue = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            int i3 = i2 - i;
            if (i3 == 3) {
                char c = cArr[i];
                if (c == 'I') {
                    if (cArr[i + 1] == 'N' && cArr[i + 2] == 'F') {
                        this.mValue = Float.POSITIVE_INFINITY;
                        return;
                    }
                } else if (c == 'N' && cArr[i + 1] == 'a' && cArr[i + 2] == 'N') {
                    this.mValue = Float.NaN;
                    return;
                }
            } else if (i3 == 4 && cArr[i] == '-' && cArr[i + 1] == 'I' && cArr[i + 2] == 'N' && cArr[i + 3] == 'F') {
                this.mValue = Float.NEGATIVE_INFINITY;
                return;
            }
            String str = new String(cArr, i, i3);
            try {
                this.mValue = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }
    }

    public static final class DoubleDecoder extends DecoderBase {
        protected double mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "double";
        }

        public double getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            int length = str.length();
            if (length == 3) {
                char cCharAt = str.charAt(0);
                if (cCharAt == 'I') {
                    if (str.charAt(1) == 'N' && str.charAt(2) == 'F') {
                        this.mValue = Double.POSITIVE_INFINITY;
                        return;
                    }
                } else if (cCharAt == 'N' && str.charAt(1) == 'a' && str.charAt(2) == 'N') {
                    this.mValue = Double.NaN;
                    return;
                }
            } else if (length == 4 && str.charAt(0) == '-' && str.charAt(1) == 'I' && str.charAt(2) == 'N' && str.charAt(3) == 'F') {
                this.mValue = Double.NEGATIVE_INFINITY;
                return;
            }
            try {
                this.mValue = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            int i3 = i2 - i;
            if (i3 == 3) {
                char c = cArr[i];
                if (c == 'I') {
                    if (cArr[i + 1] == 'N' && cArr[i + 2] == 'F') {
                        this.mValue = Double.POSITIVE_INFINITY;
                        return;
                    }
                } else if (c == 'N' && cArr[i + 1] == 'a' && cArr[i + 2] == 'N') {
                    this.mValue = Double.NaN;
                    return;
                }
            } else if (i3 == 4 && cArr[i] == '-' && cArr[i + 1] == 'I' && cArr[i + 2] == 'N' && cArr[i + 3] == 'F') {
                this.mValue = Double.NEGATIVE_INFINITY;
                return;
            }
            String str = new String(cArr, i, i3);
            try {
                this.mValue = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }
    }

    public static final class IntegerDecoder extends DecoderBase {
        protected BigInteger mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "integer";
        }

        public BigInteger getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            try {
                this.mValue = new BigInteger(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            String str = new String(cArr, i, i2 - i);
            try {
                this.mValue = new BigInteger(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }
    }

    public static final class DecimalDecoder extends DecoderBase {
        protected BigDecimal mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "decimal";
        }

        public BigDecimal getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            try {
                this.mValue = new BigDecimal(str);
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(str);
            }
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            int i3 = i2 - i;
            try {
                this.mValue = new BigDecimal(new String(cArr, i, i3));
            } catch (NumberFormatException unused) {
                throw constructInvalidValue(new String(cArr, i, i3));
            }
        }
    }

    public static final class QNameDecoder extends DecoderBase {
        final NamespaceContext mNsCtxt;
        protected QName mValue;

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecoderBase
        public String getType() {
            return "QName";
        }

        public QNameDecoder(NamespaceContext namespaceContext) {
            this.mNsCtxt = namespaceContext;
        }

        public QName getValue() {
            return this.mValue;
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(String str) throws IllegalArgumentException {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf >= 0) {
                this.mValue = resolveQName(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            } else {
                this.mValue = resolveQName(str);
            }
        }

        @Override // org.codehaus.stax2.typed.TypedValueDecoder
        public void decode(char[] cArr, int i, int i2) throws IllegalArgumentException {
            for (int i3 = i; i3 < i2; i3++) {
                if (cArr[i3] == ':') {
                    this.mValue = resolveQName(new String(cArr, i, i3 - i), new String(cArr, i3 + 1, (i2 - i3) - 1));
                    return;
                }
            }
            this.mValue = resolveQName(new String(cArr, i, i2 - i));
        }

        protected QName resolveQName(String str) throws IllegalArgumentException {
            String namespaceURI = this.mNsCtxt.getNamespaceURI("");
            return new QName(namespaceURI != null ? namespaceURI : "", str);
        }

        protected QName resolveQName(String str, String str2) throws IllegalArgumentException {
            if (str.length() == 0 || str2.length() == 0) {
                throw constructInvalidValue(str + ":" + str2);
            }
            String namespaceURI = this.mNsCtxt.getNamespaceURI(str);
            if (namespaceURI == null || namespaceURI.length() == 0) {
                throw new IllegalArgumentException("Value \"" + lexicalDesc(str + ":" + str2) + "\" not a valid QName: prefix '" + str + "' not bound to a namespace");
            }
            return new QName(namespaceURI, str2, str);
        }
    }

    public static abstract class BaseArrayDecoder extends TypedArrayDecoder {
        protected static final int INITIAL_RESULT_BUFFER_SIZE = 40;
        protected static final int SMALL_RESULT_BUFFER_SIZE = 4000;
        protected int mCount = 0;
        protected int mEnd;
        protected int mStart;

        protected int calcNewSize(int i) {
            return i < SMALL_RESULT_BUFFER_SIZE ? i << 2 : i + i;
        }

        public abstract void expand();

        protected BaseArrayDecoder(int i, int i2) {
            this.mStart = i;
            if (i2 < 1) {
                throw new IllegalArgumentException("Number of elements to read can not be less than 1");
            }
            this.mEnd = i2;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public final int getCount() {
            return this.mCount;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public final boolean hasRoom() {
            return this.mCount < this.mEnd;
        }
    }

    public static final class IntArrayDecoder extends BaseArrayDecoder {
        final IntDecoder mDecoder;
        int[] mResult;

        public IntArrayDecoder(int[] iArr, int i, int i2, IntDecoder intDecoder) {
            super(i, i2);
            this.mResult = iArr;
            this.mDecoder = intDecoder;
        }

        public IntArrayDecoder(IntDecoder intDecoder) {
            super(0, 40);
            this.mResult = new int[40];
            this.mDecoder = intDecoder;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.BaseArrayDecoder
        public void expand() {
            int[] iArr = this.mResult;
            int length = iArr.length;
            int iCalcNewSize = calcNewSize(length);
            this.mResult = new int[iCalcNewSize];
            System.arraycopy(iArr, this.mStart, this.mResult, 0, length);
            this.mStart = 0;
            this.mEnd = iCalcNewSize;
        }

        public int[] getValues() {
            int[] iArr = new int[this.mCount];
            System.arraycopy(this.mResult, this.mStart, iArr, 0, this.mCount);
            return iArr;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(String str) throws IllegalArgumentException {
            this.mDecoder.decode(str);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i = this.mCount + 1;
            this.mCount = i;
            return i >= this.mEnd;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(char[] cArr, int i, int i2) throws IllegalArgumentException {
            this.mDecoder.decode(cArr, i, i2);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i3 = this.mCount + 1;
            this.mCount = i3;
            return i3 >= this.mEnd;
        }
    }

    public static final class LongArrayDecoder extends BaseArrayDecoder {
        final LongDecoder mDecoder;
        long[] mResult;

        public LongArrayDecoder(long[] jArr, int i, int i2, LongDecoder longDecoder) {
            super(i, i2);
            this.mResult = jArr;
            this.mDecoder = longDecoder;
        }

        public LongArrayDecoder(LongDecoder longDecoder) {
            super(0, 40);
            this.mResult = new long[40];
            this.mDecoder = longDecoder;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.BaseArrayDecoder
        public void expand() {
            long[] jArr = this.mResult;
            int length = jArr.length;
            int iCalcNewSize = calcNewSize(length);
            this.mResult = new long[iCalcNewSize];
            System.arraycopy(jArr, this.mStart, this.mResult, 0, length);
            this.mStart = 0;
            this.mEnd = iCalcNewSize;
        }

        public long[] getValues() {
            long[] jArr = new long[this.mCount];
            System.arraycopy(this.mResult, this.mStart, jArr, 0, this.mCount);
            return jArr;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(String str) throws IllegalArgumentException {
            this.mDecoder.decode(str);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i = this.mCount + 1;
            this.mCount = i;
            return i >= this.mEnd;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(char[] cArr, int i, int i2) throws IllegalArgumentException {
            this.mDecoder.decode(cArr, i, i2);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i3 = this.mCount + 1;
            this.mCount = i3;
            return i3 >= this.mEnd;
        }
    }

    public static final class FloatArrayDecoder extends BaseArrayDecoder {
        final FloatDecoder mDecoder;
        float[] mResult;

        public FloatArrayDecoder(float[] fArr, int i, int i2, FloatDecoder floatDecoder) {
            super(i, i2);
            this.mResult = fArr;
            this.mDecoder = floatDecoder;
        }

        public FloatArrayDecoder(FloatDecoder floatDecoder) {
            super(0, 40);
            this.mResult = new float[40];
            this.mDecoder = floatDecoder;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.BaseArrayDecoder
        public void expand() {
            float[] fArr = this.mResult;
            int length = fArr.length;
            int iCalcNewSize = calcNewSize(length);
            this.mResult = new float[iCalcNewSize];
            System.arraycopy(fArr, this.mStart, this.mResult, 0, length);
            this.mStart = 0;
            this.mEnd = iCalcNewSize;
        }

        public float[] getValues() {
            float[] fArr = new float[this.mCount];
            System.arraycopy(this.mResult, this.mStart, fArr, 0, this.mCount);
            return fArr;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(String str) throws IllegalArgumentException {
            this.mDecoder.decode(str);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i = this.mCount + 1;
            this.mCount = i;
            return i >= this.mEnd;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(char[] cArr, int i, int i2) throws IllegalArgumentException {
            this.mDecoder.decode(cArr, i, i2);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i3 = this.mCount + 1;
            this.mCount = i3;
            return i3 >= this.mEnd;
        }
    }

    public static final class DoubleArrayDecoder extends BaseArrayDecoder {
        final DoubleDecoder mDecoder;
        double[] mResult;

        public DoubleArrayDecoder(double[] dArr, int i, int i2, DoubleDecoder doubleDecoder) {
            super(i, i2);
            this.mResult = dArr;
            this.mDecoder = doubleDecoder;
        }

        public DoubleArrayDecoder(DoubleDecoder doubleDecoder) {
            super(0, 40);
            this.mResult = new double[40];
            this.mDecoder = doubleDecoder;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueDecoderFactory.BaseArrayDecoder
        public void expand() {
            double[] dArr = this.mResult;
            int length = dArr.length;
            int iCalcNewSize = calcNewSize(length);
            this.mResult = new double[iCalcNewSize];
            System.arraycopy(dArr, this.mStart, this.mResult, 0, length);
            this.mStart = 0;
            this.mEnd = iCalcNewSize;
        }

        public double[] getValues() {
            double[] dArr = new double[this.mCount];
            System.arraycopy(this.mResult, this.mStart, dArr, 0, this.mCount);
            return dArr;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(String str) throws IllegalArgumentException {
            this.mDecoder.decode(str);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i = this.mCount + 1;
            this.mCount = i;
            return i >= this.mEnd;
        }

        @Override // org.codehaus.stax2.typed.TypedArrayDecoder
        public boolean decodeValue(char[] cArr, int i, int i2) throws IllegalArgumentException {
            this.mDecoder.decode(cArr, i, i2);
            this.mResult[this.mStart + this.mCount] = this.mDecoder.getValue();
            int i3 = this.mCount + 1;
            this.mCount = i3;
            return i3 >= this.mEnd;
        }
    }
}

package org.codehaus.stax2.ri.typed;

import org.codehaus.stax2.typed.Base64Variant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class ValueEncoderFactory {
    static final byte BYTE_SPACE = 32;
    protected TokenEncoder _tokenEncoder = null;
    protected IntEncoder _intEncoder = null;
    protected LongEncoder _longEncoder = null;
    protected FloatEncoder _floatEncoder = null;
    protected DoubleEncoder _doubleEncoder = null;

    public ScalarEncoder getScalarEncoder(String str) {
        if (str.length() > 64) {
            if (this._tokenEncoder == null) {
                this._tokenEncoder = new TokenEncoder();
            }
            this._tokenEncoder.reset(str);
            return this._tokenEncoder;
        }
        return new StringEncoder(str);
    }

    public ScalarEncoder getEncoder(boolean z) {
        return getScalarEncoder(z ? "true" : "false");
    }

    public IntEncoder getEncoder(int i) {
        if (this._intEncoder == null) {
            this._intEncoder = new IntEncoder();
        }
        this._intEncoder.reset(i);
        return this._intEncoder;
    }

    public LongEncoder getEncoder(long j) {
        if (this._longEncoder == null) {
            this._longEncoder = new LongEncoder();
        }
        this._longEncoder.reset(j);
        return this._longEncoder;
    }

    public FloatEncoder getEncoder(float f) {
        if (this._floatEncoder == null) {
            this._floatEncoder = new FloatEncoder();
        }
        this._floatEncoder.reset(f);
        return this._floatEncoder;
    }

    public DoubleEncoder getEncoder(double d) {
        if (this._doubleEncoder == null) {
            this._doubleEncoder = new DoubleEncoder();
        }
        this._doubleEncoder.reset(d);
        return this._doubleEncoder;
    }

    public IntArrayEncoder getEncoder(int[] iArr, int i, int i2) {
        return new IntArrayEncoder(iArr, i, i2 + i);
    }

    public LongArrayEncoder getEncoder(long[] jArr, int i, int i2) {
        return new LongArrayEncoder(jArr, i, i2 + i);
    }

    public FloatArrayEncoder getEncoder(float[] fArr, int i, int i2) {
        return new FloatArrayEncoder(fArr, i, i2 + i);
    }

    public DoubleArrayEncoder getEncoder(double[] dArr, int i, int i2) {
        return new DoubleArrayEncoder(dArr, i, i2 + i);
    }

    public Base64Encoder getEncoder(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        return new Base64Encoder(base64Variant, bArr, i, i2 + i);
    }

    static abstract class ScalarEncoder extends AsciiValueEncoder {
        protected ScalarEncoder() {
        }
    }

    static final class TokenEncoder extends ScalarEncoder {
        String _value;

        protected TokenEncoder() {
        }

        protected void reset(String str) {
            this._value = str;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public boolean isCompleted() {
            return this._value == null;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            String str = this._value;
            this._value = null;
            int length = str.length();
            str.getChars(0, length, cArr, i);
            return i + length;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            String str = this._value;
            this._value = null;
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                bArr[i] = (byte) str.charAt(i3);
                i3++;
                i++;
            }
            return i;
        }
    }

    static final class StringEncoder extends ScalarEncoder {
        int _offset;
        String _value;

        protected StringEncoder(String str) {
            this._value = str;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public boolean isCompleted() {
            return this._value == null;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            int length = this._value.length();
            int i3 = this._offset;
            int i4 = length - i3;
            int i5 = i2 - i;
            if (i5 >= i4) {
                this._value.getChars(i3, i4, cArr, i);
                this._value = null;
                return i + i4;
            }
            this._value.getChars(i3, i5, cArr, i);
            this._offset += i5;
            return i2;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            if (i2 - i < this._value.length() - this._offset) {
                while (i < i2) {
                    String str = this._value;
                    int i3 = this._offset;
                    this._offset = i3 + 1;
                    bArr[i] = (byte) str.charAt(i3);
                    i++;
                }
                return i;
            }
            String str2 = this._value;
            this._value = null;
            int length = str2.length();
            int i4 = this._offset;
            while (i4 < length) {
                bArr[i] = (byte) str2.charAt(i4);
                i4++;
                i++;
            }
            return i;
        }
    }

    static abstract class TypedScalarEncoder extends ScalarEncoder {
        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public final boolean isCompleted() {
            return true;
        }

        protected TypedScalarEncoder() {
        }
    }

    static final class IntEncoder extends TypedScalarEncoder {
        int _value;

        protected IntEncoder() {
        }

        protected void reset(int i) {
            this._value = i;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            return NumberUtil.writeInt(this._value, cArr, i);
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            return NumberUtil.writeInt(this._value, bArr, i);
        }
    }

    static final class LongEncoder extends TypedScalarEncoder {
        long _value;

        protected LongEncoder() {
        }

        protected void reset(long j) {
            this._value = j;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            return NumberUtil.writeLong(this._value, cArr, i);
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            return NumberUtil.writeLong(this._value, bArr, i);
        }
    }

    static final class FloatEncoder extends TypedScalarEncoder {
        float _value;

        protected FloatEncoder() {
        }

        protected void reset(float f) {
            this._value = f;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            return NumberUtil.writeFloat(this._value, cArr, i);
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            return NumberUtil.writeFloat(this._value, bArr, i);
        }
    }

    static final class DoubleEncoder extends TypedScalarEncoder {
        double _value;

        protected DoubleEncoder() {
        }

        protected void reset(double d) {
            this._value = d;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            return NumberUtil.writeDouble(this._value, cArr, i);
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            return NumberUtil.writeDouble(this._value, bArr, i);
        }
    }

    static abstract class ArrayEncoder extends AsciiValueEncoder {
        final int _end;
        int _ptr;

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public abstract int encodeMore(char[] cArr, int i, int i2);

        protected ArrayEncoder(int i, int i2) {
            this._ptr = i;
            this._end = i2;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public final boolean isCompleted() {
            return this._ptr >= this._end;
        }
    }

    static final class IntArrayEncoder extends ArrayEncoder {
        final int[] _values;

        protected IntArrayEncoder(int[] iArr, int i, int i2) {
            super(i, i2);
            this._values = iArr;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueEncoderFactory.ArrayEncoder, org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            int i3 = i2 - 12;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                cArr[i] = ' ';
                int[] iArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeInt(iArr[i5], cArr, i4);
            }
            return i;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            int i3 = i2 - 12;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                bArr[i] = ValueEncoderFactory.BYTE_SPACE;
                int[] iArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeInt(iArr[i5], bArr, i4);
            }
            return i;
        }
    }

    static final class LongArrayEncoder extends ArrayEncoder {
        final long[] _values;

        protected LongArrayEncoder(long[] jArr, int i, int i2) {
            super(i, i2);
            this._values = jArr;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueEncoderFactory.ArrayEncoder, org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            int i3 = i2 - 22;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                cArr[i] = ' ';
                long[] jArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeLong(jArr[i5], cArr, i4);
            }
            return i;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            int i3 = i2 - 22;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                bArr[i] = ValueEncoderFactory.BYTE_SPACE;
                long[] jArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeLong(jArr[i5], bArr, i4);
            }
            return i;
        }
    }

    static final class FloatArrayEncoder extends ArrayEncoder {
        final float[] _values;

        protected FloatArrayEncoder(float[] fArr, int i, int i2) {
            super(i, i2);
            this._values = fArr;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueEncoderFactory.ArrayEncoder, org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            int i3 = i2 - 33;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                cArr[i] = ' ';
                float[] fArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeFloat(fArr[i5], cArr, i4);
            }
            return i;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            int i3 = i2 - 33;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                bArr[i] = ValueEncoderFactory.BYTE_SPACE;
                float[] fArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeFloat(fArr[i5], bArr, i4);
            }
            return i;
        }
    }

    static final class DoubleArrayEncoder extends ArrayEncoder {
        final double[] _values;

        protected DoubleArrayEncoder(double[] dArr, int i, int i2) {
            super(i, i2);
            this._values = dArr;
        }

        @Override // org.codehaus.stax2.ri.typed.ValueEncoderFactory.ArrayEncoder, org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            int i3 = i2 - 33;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                cArr[i] = ' ';
                double[] dArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeDouble(dArr[i5], cArr, i4);
            }
            return i;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            int i3 = i2 - 33;
            while (i <= i3 && this._ptr < this._end) {
                int i4 = i + 1;
                bArr[i] = ValueEncoderFactory.BYTE_SPACE;
                double[] dArr = this._values;
                int i5 = this._ptr;
                this._ptr = i5 + 1;
                i = NumberUtil.writeDouble(dArr[i5], bArr, i4);
            }
            return i;
        }
    }

    static final class Base64Encoder extends AsciiValueEncoder {
        static final byte LF_BYTE = 10;
        static final byte LF_CHAR = 10;
        static final byte PAD_BYTE = 61;
        static final char PAD_CHAR = '=';
        int _chunksBeforeLf;
        final byte[] _input;
        final int _inputEnd;
        int _inputPtr;
        final Base64Variant _variant;

        protected Base64Encoder(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
            this._variant = base64Variant;
            this._input = bArr;
            this._inputPtr = i;
            this._inputEnd = i2;
            this._chunksBeforeLf = base64Variant.getMaxLineLength() >> 2;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public boolean isCompleted() {
            return this._inputPtr >= this._inputEnd;
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(char[] cArr, int i, int i2) {
            int i3 = this._inputEnd - 3;
            int i4 = i2 - 5;
            while (true) {
                int i5 = this._inputPtr;
                if (i5 > i3) {
                    int i6 = this._inputEnd - i5;
                    if (i6 <= 0 || i > i4) {
                        return i;
                    }
                    byte[] bArr = this._input;
                    int i7 = i5 + 1;
                    this._inputPtr = i7;
                    int i8 = bArr[i5] << 16;
                    if (i6 == 2) {
                        this._inputPtr = i7 + 1;
                        i8 |= (bArr[i7] & 255) << 8;
                    }
                    return this._variant.encodeBase64Partial(i8, i6, cArr, i);
                }
                if (i > i4) {
                    return i;
                }
                byte[] bArr2 = this._input;
                int i9 = i5 + 1;
                int i10 = i9 + 1;
                int i11 = ((bArr2[i5] << 8) | (bArr2[i9] & 255)) << 8;
                this._inputPtr = i10 + 1;
                i = this._variant.encodeBase64Chunk(i11 | (bArr2[i10] & 255), cArr, i);
                int i12 = this._chunksBeforeLf - 1;
                this._chunksBeforeLf = i12;
                if (i12 <= 0) {
                    cArr[i] = '\n';
                    this._chunksBeforeLf = this._variant.getMaxLineLength() >> 2;
                    i++;
                }
            }
        }

        @Override // org.codehaus.stax2.ri.typed.AsciiValueEncoder
        public int encodeMore(byte[] bArr, int i, int i2) {
            int i3 = this._inputEnd - 3;
            int i4 = i2 - 5;
            while (true) {
                int i5 = this._inputPtr;
                if (i5 > i3) {
                    int i6 = this._inputEnd - i5;
                    if (i6 <= 0 || i > i4) {
                        return i;
                    }
                    byte[] bArr2 = this._input;
                    int i7 = i5 + 1;
                    this._inputPtr = i7;
                    int i8 = bArr2[i5] << 16;
                    if (i6 == 2) {
                        this._inputPtr = i7 + 1;
                        i8 |= (bArr2[i7] & 255) << 8;
                    }
                    return this._variant.encodeBase64Partial(i8, i6, bArr, i);
                }
                if (i > i4) {
                    return i;
                }
                byte[] bArr3 = this._input;
                int i9 = i5 + 1;
                int i10 = i9 + 1;
                int i11 = ((bArr3[i5] << 8) | (bArr3[i9] & 255)) << 8;
                this._inputPtr = i10 + 1;
                i = this._variant.encodeBase64Chunk(i11 | (bArr3[i10] & 255), bArr, i);
                int i12 = this._chunksBeforeLf - 1;
                this._chunksBeforeLf = i12;
                if (i12 <= 0) {
                    bArr[i] = 10;
                    this._chunksBeforeLf = this._variant.getMaxLineLength() >> 2;
                    i++;
                }
            }
        }
    }
}

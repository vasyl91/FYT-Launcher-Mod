package org.apache.commons.codec.binary;

import java.util.Arrays;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;

    @Deprecated
    protected final byte PAD;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;

    protected static boolean isWhiteSpace(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    abstract void decode(byte[] bArr, int i, int i2, Context context);

    abstract void encode(byte[] bArr, int i, int i2, Context context);

    protected int getDefaultBufferSize() {
        return 8192;
    }

    protected abstract boolean isInAlphabet(byte b);

    static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos));
        }
    }

    protected BaseNCodec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, (byte) 61);
    }

    protected BaseNCodec(int i, int i2, int i3, int i4, byte b) {
        this.PAD = (byte) 61;
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        this.lineLength = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.chunkSeparatorLength = i4;
        this.pad = b;
    }

    boolean hasData(Context context) {
        return context.buffer != null;
    }

    int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    private byte[] resizeBuffer(Context context) {
        if (context.buffer == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr = new byte[context.buffer.length * 2];
            System.arraycopy(context.buffer, 0, bArr, 0, context.buffer.length);
            context.buffer = bArr;
        }
        return context.buffer;
    }

    protected byte[] ensureBufferSize(int i, Context context) {
        if (context.buffer == null || context.buffer.length < context.pos + i) {
            return resizeBuffer(context);
        }
        return context.buffer;
    }

    int readResults(byte[] bArr, int i, int i2, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int iMin = Math.min(available(context), i2);
        System.arraycopy(context.buffer, context.readPos, bArr, i, iMin);
        context.readPos += iMin;
        if (context.readPos >= context.pos) {
            context.buffer = null;
        }
        return iMin;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
        }
        return encode((byte[]) obj);
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i = context.pos;
        byte[] bArr2 = new byte[i];
        readResults(bArr2, 0, i, context);
        return bArr2;
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, 0, bArr.length, context);
        encode(bArr, 0, -1, context);
        int i = context.pos - context.readPos;
        byte[] bArr2 = new byte[i];
        readResults(bArr2, 0, i, context);
        return bArr2;
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        byte b;
        for (int i = 0; i < bArr.length; i++) {
            if (!isInAlphabet(bArr[i]) && (!z || ((b = bArr[i]) != this.pad && !isWhiteSpace(b)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    protected boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (this.pad == b || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i = this.unencodedBlockSize;
        long j = ((long) (((length + i) - 1) / i)) * ((long) this.encodedBlockSize);
        int i2 = this.lineLength;
        return i2 > 0 ? j + ((((((long) i2) + j) - 1) / ((long) i2)) * ((long) this.chunkSeparatorLength)) : j;
    }
}

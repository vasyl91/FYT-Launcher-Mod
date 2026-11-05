package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    private final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public FlexBuffersBuilder(int i) {
        this(new ArrayReadWriteBuf(i), 1);
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i);
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b;
                byte b2;
                int i2 = value.key;
                int i3 = value2.key;
                do {
                    b = FlexBuffersBuilder.this.bb.get(i2);
                    b2 = FlexBuffersBuilder.this.bb.get(i3);
                    if (b == 0) {
                        return b - b2;
                    }
                    i2++;
                    i3++;
                } while (b == b2);
                return b - b2;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i;
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public void putBoolean(boolean z) {
        putBoolean(null, z);
    }

    public void putBoolean(String str, boolean z) {
        this.stack.add(Value.bool(putKey(str), z));
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int iWritePosition = this.bb.writePosition();
        if ((this.flags & 1) != 0) {
            Integer num = this.keyPool.get(str);
            if (num == null) {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                this.bb.put(bytes, 0, bytes.length);
                this.bb.put((byte) 0);
                this.keyPool.put(str, Integer.valueOf(iWritePosition));
                return iWritePosition;
            }
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(iWritePosition));
        return iWritePosition;
    }

    public void putInt(int i) {
        putInt((String) null, i);
    }

    public void putInt(String str, int i) {
        putInt(str, i);
    }

    public void putInt(String str, long j) {
        int iPutKey = putKey(str);
        if (-128 <= j && j <= 127) {
            this.stack.add(Value.int8(iPutKey, (int) j));
            return;
        }
        if (-32768 <= j && j <= 32767) {
            this.stack.add(Value.int16(iPutKey, (int) j));
        } else if (-2147483648L <= j && j <= 2147483647L) {
            this.stack.add(Value.int32(iPutKey, (int) j));
        } else {
            this.stack.add(Value.int64(iPutKey, j));
        }
    }

    public void putInt(long j) {
        putInt((String) null, j);
    }

    public void putUInt(int i) {
        putUInt(null, i);
    }

    public void putUInt(long j) {
        putUInt(null, j);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64(null, bigInteger.longValue());
    }

    private void putUInt64(String str, long j) {
        this.stack.add(Value.uInt64(putKey(str), j));
    }

    private void putUInt(String str, long j) {
        Value valueUInt64;
        int iPutKey = putKey(str);
        int iWidthUInBits = widthUInBits(j);
        if (iWidthUInBits == 0) {
            valueUInt64 = Value.uInt8(iPutKey, (int) j);
        } else if (iWidthUInBits == 1) {
            valueUInt64 = Value.uInt16(iPutKey, (int) j);
        } else if (iWidthUInBits == 2) {
            valueUInt64 = Value.uInt32(iPutKey, (int) j);
        } else {
            valueUInt64 = Value.uInt64(iPutKey, j);
        }
        this.stack.add(valueUInt64);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putFloat(String str, float f) {
        this.stack.add(Value.float32(putKey(str), f));
    }

    public void putFloat(double d) {
        putFloat((String) null, d);
    }

    public void putFloat(String str, double d) {
        this.stack.add(Value.float64(putKey(str), d));
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public int putString(String str, String str2) {
        int iPutKey = putKey(str);
        if ((this.flags & 2) != 0) {
            Integer num = this.stringPool.get(str2);
            if (num == null) {
                Value valueWriteString = writeString(iPutKey, str2);
                this.stringPool.put(str2, Integer.valueOf((int) valueWriteString.iValue));
                this.stack.add(valueWriteString);
                return (int) valueWriteString.iValue;
            }
            this.stack.add(Value.blob(iPutKey, num.intValue(), 5, widthUInBits(str2.length())));
            return num.intValue();
        }
        Value valueWriteString2 = writeString(iPutKey, str2);
        this.stack.add(valueWriteString2);
        return (int) valueWriteString2.iValue;
    }

    private Value writeString(int i, String str) {
        return writeBlob(i, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    static int widthUInBits(long j) {
        if (j <= FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) {
            return 0;
        }
        if (j <= FlexBuffers.Unsigned.shortToUnsignedInt((short) -1)) {
            return 1;
        }
        return j <= FlexBuffers.Unsigned.intToUnsignedLong(-1) ? 2 : 3;
    }

    private Value writeBlob(int i, byte[] bArr, int i2, boolean z) {
        int iWidthUInBits = widthUInBits(bArr.length);
        writeInt(bArr.length, align(iWidthUInBits));
        int iWritePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i, iWritePosition, i2, iWidthUInBits);
    }

    private int align(int i) {
        int i2 = 1 << i;
        int iPaddingBytes = Value.paddingBytes(this.bb.writePosition(), i2);
        while (true) {
            int i3 = iPaddingBytes - 1;
            if (iPaddingBytes == 0) {
                return i2;
            }
            this.bb.put((byte) 0);
            iPaddingBytes = i3;
        }
    }

    private void writeInt(long j, int i) {
        if (i == 1) {
            this.bb.put((byte) j);
            return;
        }
        if (i == 2) {
            this.bb.putShort((short) j);
        } else if (i == 4) {
            this.bb.putInt((int) j);
        } else {
            if (i != 8) {
                return;
            }
            this.bb.putLong(j);
        }
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public int putBlob(String str, byte[] bArr) {
        Value valueWriteBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(valueWriteBlob);
        return (int) valueWriteBlob.iValue;
    }

    public int startVector() {
        return this.stack.size();
    }

    public int endVector(String str, int i, boolean z, boolean z2) {
        Value valueCreateVector = createVector(putKey(str), i, this.stack.size() - i, z, z2, null);
        while (this.stack.size() > i) {
            ArrayList<Value> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public ByteBuffer finish() {
        int iAlign = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), iAlign);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) iAlign);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    private Value createVector(int i, int i2, int i3, boolean z, boolean z2, Value value) {
        int i4;
        int typedVector;
        int i5 = i3;
        long j = i5;
        int iMax = Math.max(0, widthUInBits(j));
        if (value != null) {
            iMax = Math.max(iMax, value.elemWidth(this.bb.writePosition(), 0));
            i4 = 3;
        } else {
            i4 = 1;
        }
        int i6 = 4;
        int iMax2 = iMax;
        for (int i7 = i2; i7 < this.stack.size(); i7++) {
            iMax2 = Math.max(iMax2, this.stack.get(i7).elemWidth(this.bb.writePosition(), i7 + i4));
            if (z && i7 == i2) {
                i6 = this.stack.get(i7).type;
                if (!FlexBuffers.isTypedVectorElementType(i6)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i8 = i2;
        int iAlign = align(iMax2);
        if (value != null) {
            writeOffset(value.iValue, iAlign);
            writeInt(1 << value.minBitWidth, iAlign);
        }
        if (!z2) {
            writeInt(j, iAlign);
        }
        int iWritePosition = this.bb.writePosition();
        for (int i9 = i8; i9 < this.stack.size(); i9++) {
            writeAny(this.stack.get(i9), iAlign);
        }
        if (!z) {
            while (i8 < this.stack.size()) {
                this.bb.put(this.stack.get(i8).storedPackedType(iMax2));
                i8++;
            }
        }
        if (value != null) {
            typedVector = 9;
        } else if (z) {
            if (!z2) {
                i5 = 0;
            }
            typedVector = FlexBuffers.toTypedVector(i6, i5);
        } else {
            typedVector = 10;
        }
        return new Value(i, typedVector, iMax2, iWritePosition);
    }

    private void writeOffset(long j, int i) {
        writeInt((int) (((long) this.bb.writePosition()) - j), i);
    }

    private void writeAny(Value value, int i) {
        int i2 = value.type;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                writeDouble(value.dValue, i);
                return;
            } else if (i2 != 26) {
                writeOffset(value.iValue, i);
                return;
            }
        }
        writeInt(value.iValue, i);
    }

    private void writeDouble(double d, int i) {
        if (i == 4) {
            this.bb.putFloat((float) d);
        } else if (i == 8) {
            this.bb.putDouble(d);
        }
    }

    public int startMap() {
        return this.stack.size();
    }

    public int endMap(String str, int i) {
        int iPutKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i, arrayList.size()), this.keyComparator);
        Value valueCreateVector = createVector(iPutKey, i, this.stack.size() - i, false, false, createKeyVector(i, this.stack.size() - i));
        while (this.stack.size() > i) {
            ArrayList<Value> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    private Value createKeyVector(int i, int i2) {
        long j = i2;
        int iMax = Math.max(0, widthUInBits(j));
        int i3 = i;
        while (i3 < this.stack.size()) {
            i3++;
            iMax = Math.max(iMax, Value.elemWidth(4, 0, this.stack.get(i3).key, this.bb.writePosition(), i3));
        }
        int iAlign = align(iMax);
        writeInt(j, iAlign);
        int iWritePosition = this.bb.writePosition();
        while (i < this.stack.size()) {
            int i4 = this.stack.get(i).key;
            writeOffset(this.stack.get(i).key, iAlign);
            i++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), iMax, iWritePosition);
    }

    private static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        private static byte packedType(int i, int i2) {
            return (byte) (i | (i2 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int paddingBytes(int i, int i2) {
            return ((~i) + 1) & (i2 - 1);
        }

        Value(int i, int i2, int i3, long j) {
            this.key = i;
            this.type = i2;
            this.minBitWidth = i3;
            this.iValue = j;
            this.dValue = Double.MIN_VALUE;
        }

        Value(int i, int i2, int i3, double d) {
            this.key = i;
            this.type = i2;
            this.minBitWidth = i3;
            this.dValue = d;
            this.iValue = Long.MIN_VALUE;
        }

        static Value bool(int i, boolean z) {
            return new Value(i, 26, 0, z ? 1L : 0L);
        }

        static Value blob(int i, int i2, int i3, int i4) {
            return new Value(i, i3, i4, i2);
        }

        static Value int8(int i, int i2) {
            return new Value(i, 1, 0, i2);
        }

        static Value int16(int i, int i2) {
            return new Value(i, 1, 1, i2);
        }

        static Value int32(int i, int i2) {
            return new Value(i, 1, 2, i2);
        }

        static Value int64(int i, long j) {
            return new Value(i, 1, 3, j);
        }

        static Value uInt8(int i, int i2) {
            return new Value(i, 2, 0, i2);
        }

        static Value uInt16(int i, int i2) {
            return new Value(i, 2, 1, i2);
        }

        static Value uInt32(int i, int i2) {
            return new Value(i, 2, 2, i2);
        }

        static Value uInt64(int i, long j) {
            return new Value(i, 2, 3, j);
        }

        static Value float32(int i, float f) {
            return new Value(i, 3, 2, f);
        }

        static Value float64(int i, double d) {
            return new Value(i, 3, 3, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType(int i) {
            return packedType(storedWidth(i), this.type);
        }

        private int storedWidth(int i) {
            if (FlexBuffers.isTypeInline(this.type)) {
                return Math.max(this.minBitWidth, i);
            }
            return this.minBitWidth;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int elemWidth(int i, int i2) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int elemWidth(int i, int i2, long j, int i3, int i4) {
            if (FlexBuffers.isTypeInline(i)) {
                return i2;
            }
            for (int i5 = 1; i5 <= 32; i5 *= 2) {
                int iWidthUInBits = FlexBuffersBuilder.widthUInBits((int) (((long) ((paddingBytes(i3, i5) + i3) + (i4 * i5))) - j));
                if ((1 << iWidthUInBits) == i5) {
                    return iWidthUInBits;
                }
            }
            return 3;
        }
    }
}

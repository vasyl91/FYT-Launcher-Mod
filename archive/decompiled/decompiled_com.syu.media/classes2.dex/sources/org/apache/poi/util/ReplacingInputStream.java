package org.apache.poi.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class ReplacingInputStream extends FilterInputStream {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    final int[] buf;
    private int matchedIndex;
    private final byte[] pattern;
    private int replacedIndex;
    private final byte[] replacement;
    private State state;
    private int unbufferIndex;

    private enum State {
        NOT_MATCHED,
        MATCHING,
        REPLACING,
        UNBUFFER
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReplacingInputStream(InputStream inputStream, String str, String str2) {
        Charset charset = UTF8;
        this(inputStream, str.getBytes(charset), str2 == null ? null : str2.getBytes(charset));
    }

    public ReplacingInputStream(InputStream inputStream, byte[] bArr, byte[] bArr2) {
        super(inputStream);
        this.matchedIndex = 0;
        this.unbufferIndex = 0;
        this.replacedIndex = 0;
        this.state = State.NOT_MATCHED;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("pattern length should be > 0");
        }
        this.pattern = bArr;
        this.replacement = bArr2;
        this.buf = new int[bArr.length];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = read();
        if (i3 == -1) {
            return -1;
        }
        bArr[i] = (byte) i3;
        int i4 = 1;
        while (i4 < i2) {
            int i5 = read();
            if (i5 == -1) {
                break;
            }
            bArr[i + i4] = (byte) i5;
            i4++;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: org.apache.poi.util.ReplacingInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$util$ReplacingInputStream$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$poi$util$ReplacingInputStream$State = iArr;
            try {
                iArr[State.NOT_MATCHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.MATCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.REPLACING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.UNBUFFER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$util$ReplacingInputStream$State[this.state.ordinal()];
        if (i == 2) {
            int i2 = super.read();
            byte[] bArr = this.pattern;
            int i3 = this.matchedIndex;
            if (bArr[i3] == i2) {
                int[] iArr = this.buf;
                int i4 = i3 + 1;
                this.matchedIndex = i4;
                iArr[i3] = i2;
                if (i4 == bArr.length) {
                    byte[] bArr2 = this.replacement;
                    if (bArr2 == null || bArr2.length == 0) {
                        this.state = State.NOT_MATCHED;
                        this.matchedIndex = 0;
                    } else {
                        this.state = State.REPLACING;
                        this.replacedIndex = 0;
                    }
                }
            } else {
                int[] iArr2 = this.buf;
                this.matchedIndex = i3 + 1;
                iArr2[i3] = i2;
                this.state = State.UNBUFFER;
                this.unbufferIndex = 0;
            }
            return read();
        }
        if (i == 3) {
            byte[] bArr3 = this.replacement;
            int i5 = this.replacedIndex;
            int i6 = i5 + 1;
            this.replacedIndex = i6;
            byte b = bArr3[i5];
            if (i6 == bArr3.length) {
                this.state = State.NOT_MATCHED;
                this.replacedIndex = 0;
            }
            return b;
        }
        if (i != 4) {
            int i7 = super.read();
            if (this.pattern[0] != i7) {
                return i7;
            }
            Arrays.fill(this.buf, 0);
            int[] iArr3 = this.buf;
            this.matchedIndex = 0 + 1;
            iArr3[0] = i7;
            if (this.pattern.length == 1) {
                this.state = State.REPLACING;
                this.replacedIndex = 0;
            } else {
                this.state = State.MATCHING;
            }
            return read();
        }
        int[] iArr4 = this.buf;
        int i8 = this.unbufferIndex;
        int i9 = i8 + 1;
        this.unbufferIndex = i9;
        int i10 = iArr4[i8];
        if (i9 == this.matchedIndex) {
            this.state = State.NOT_MATCHED;
            this.matchedIndex = 0;
        }
        return i10;
    }

    public String toString() {
        return this.state.name() + " " + this.matchedIndex + " " + this.replacedIndex + " " + this.unbufferIndex;
    }
}

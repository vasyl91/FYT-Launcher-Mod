package org.apache.poi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import kotlin.UByte;
import module.canbus.FinalCanbus;
import org.apache.poi.hpsf.Variant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RLEDecompressingInputStream extends InputStream {
    private static final int[] POWER2 = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, Variant.VT_BYREF, 32768};
    private final InputStream in;
    private int len;
    private final byte[] buf = new byte[4096];
    private int pos = 0;

    public RLEDecompressingInputStream(InputStream inputStream) throws IOException {
        this.in = inputStream;
        int i = inputStream.read();
        if (i != 1) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Header byte 0x01 expected, received 0x%02X", Integer.valueOf(i & 255)));
        }
        this.len = readChunk();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.len;
        if (i == -1) {
            return -1;
        }
        if (this.pos >= i) {
            int chunk = readChunk();
            this.len = chunk;
            if (chunk == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return bArr[i2] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.len == -1) {
            return -1;
        }
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            if (this.pos >= this.len) {
                int chunk = readChunk();
                this.len = chunk;
                if (chunk == -1) {
                    if (i3 > i) {
                        return i3 - i;
                    }
                    return -1;
                }
            }
            int iMin = Math.min(i4, this.len - this.pos);
            System.arraycopy(this.buf, this.pos, bArr, i3, iMin);
            this.pos += iMin;
            i4 -= iMin;
            i3 += iMin;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = j;
        while (j2 > 0) {
            if (this.pos >= this.len) {
                int chunk = readChunk();
                this.len = chunk;
                if (chunk == -1) {
                    return -1L;
                }
            }
            int iMin = (int) Math.min(j, this.len - this.pos);
            this.pos += iMin;
            j2 -= (long) iMin;
        }
        return j;
    }

    @Override // java.io.InputStream
    public int available() {
        int i = this.len;
        if (i > 0) {
            return i - this.pos;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    private int readChunk() throws IOException {
        this.pos = 0;
        int i = readShort(this.in);
        if (i == -1) {
            return -1;
        }
        int i2 = (i & 4095) + 1;
        if ((i & 28672) != 12288) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Chunksize header A should be 0x3000, received 0x%04X", Integer.valueOf(i & FinalCanbus.CAR_E000_ATS)));
        }
        if ((i & 32768) == 0) {
            if (this.in.read(this.buf, 0, i2) >= i2) {
                return i2;
            }
            throw new IllegalStateException(String.format(Locale.ROOT, "Not enough bytes read, expected %d", Integer.valueOf(i2)));
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = this.in.read();
            i3++;
            if (i5 == -1) {
                break;
            }
            for (int i6 = 0; i6 < 8 && i3 < i2; i6++) {
                int[] iArr = POWER2;
                if ((iArr[i6] & i5) == 0) {
                    int i7 = this.in.read();
                    if (i7 == -1) {
                        return -1;
                    }
                    this.buf[i4] = (byte) i7;
                    i3++;
                    i4++;
                } else {
                    int i8 = readShort(this.in);
                    if (i8 == -1) {
                        return -1;
                    }
                    i3 += 2;
                    int copyLenBits = getCopyLenBits(i4 - 1);
                    int i9 = ((iArr[copyLenBits] - 1) & i8) + 3;
                    int i10 = i4 - ((i8 >> copyLenBits) + 1);
                    int i11 = i9 + i10;
                    while (i10 < i11) {
                        byte[] bArr = this.buf;
                        bArr[i4] = bArr[i10];
                        i10++;
                        i4++;
                    }
                }
            }
        }
        return i4;
    }

    static int getCopyLenBits(int i) {
        for (int i2 = 11; i2 >= 4; i2--) {
            if ((POWER2[i2] & i) != 0) {
                return 15 - i2;
            }
        }
        return 12;
    }

    public int readShort() throws IOException {
        return readShort(this);
    }

    public int readInt() throws IOException {
        return readInt(this);
    }

    private int readShort(InputStream inputStream) throws IOException {
        int i;
        int i2 = inputStream.read();
        if (i2 == -1 || (i = inputStream.read()) == -1) {
            return -1;
        }
        return ((i & 255) << 8) | (i2 & 255);
    }

    private int readInt(InputStream inputStream) throws IOException {
        int i;
        int i2;
        int i3;
        int i4 = inputStream.read();
        if (i4 == -1 || (i = inputStream.read()) == -1 || (i2 = inputStream.read()) == -1 || (i3 = inputStream.read()) == -1) {
            return -1;
        }
        return ((i3 & 255) << 24) | (i4 & 255) | ((i & 255) << 8) | ((i2 & 255) << 16);
    }

    public static byte[] decompress(byte[] bArr) throws IOException {
        return decompress(bArr, 0, bArr.length);
    }

    public static byte[] decompress(byte[] bArr, int i, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(new ByteArrayInputStream(bArr, i, i2));
        IOUtils.copy(rLEDecompressingInputStream, byteArrayOutputStream);
        rLEDecompressingInputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}

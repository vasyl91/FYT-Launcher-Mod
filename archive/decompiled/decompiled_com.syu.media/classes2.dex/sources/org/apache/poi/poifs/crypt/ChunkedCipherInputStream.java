package org.apache.poi.poifs.crypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public abstract class ChunkedCipherInputStream extends LittleEndianInputStream {
    private final byte[] chunk;
    private final int chunkBits;
    private boolean chunkIsValid;
    private final int chunkSize;
    private final Cipher cipher;
    private int lastIndex;
    private final byte[] plain;
    private long pos;
    private final long size;

    protected abstract Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public void setNextRecordSize(int i) {
    }

    public ChunkedCipherInputStream(InputStream inputStream, long j, int i) throws GeneralSecurityException {
        this(inputStream, j, i, 0);
    }

    public ChunkedCipherInputStream(InputStream inputStream, long j, int i, int i2) throws GeneralSecurityException {
        super(inputStream);
        this.chunkIsValid = false;
        this.size = j;
        this.pos = i2;
        this.chunkSize = i;
        i = i == -1 ? 4096 : i;
        byte[] bArr = new byte[i];
        this.chunk = bArr;
        this.plain = new byte[i];
        int iBitCount = Integer.bitCount(bArr.length - 1);
        this.chunkBits = iBitCount;
        int i3 = (int) (this.pos >> iBitCount);
        this.lastIndex = i3;
        this.cipher = initCipherForBlock(null, i3);
    }

    public final Cipher initCipherForBlock(int i) throws GeneralSecurityException, IOException {
        if (this.chunkSize != -1) {
            throw new GeneralSecurityException("the cipher block can only be set for streaming encryption, e.g. CryptoAPI...");
        }
        this.chunkIsValid = false;
        return initCipherForBlock(this.cipher, i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = {0};
        if (read(bArr) == 1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return read(bArr, i, i2, false);
    }

    private int read(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (available() <= 0) {
            return -1;
        }
        int chunkMask = getChunkMask();
        int i3 = 0;
        while (i2 > 0) {
            if (!this.chunkIsValid) {
                try {
                    nextChunk();
                    this.chunkIsValid = true;
                } catch (GeneralSecurityException e) {
                    throw new EncryptedDocumentException(e.getMessage(), e);
                }
            }
            long j = chunkMask;
            int length = (int) (((long) this.chunk.length) - (this.pos & j));
            int iAvailable = available();
            if (iAvailable == 0) {
                return i3;
            }
            int iMin = Math.min(iAvailable, Math.min(length, i2));
            System.arraycopy(z ? this.plain : this.chunk, (int) (this.pos & j), bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
            long j2 = this.pos + ((long) iMin);
            this.pos = j2;
            if ((j2 & j) == 0) {
                this.chunkIsValid = false;
            }
            i3 += iMin;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = this.pos;
        long jMin = Math.min(remainingBytes(), j);
        if (((j2 ^ (this.pos + jMin)) & ((long) (~getChunkMask()))) != 0) {
            this.chunkIsValid = false;
        }
        this.pos += jMin;
        return jMin;
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return remainingBytes();
    }

    private int remainingBytes() {
        return (int) (this.size - this.pos);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    protected int getChunkMask() {
        return this.chunk.length - 1;
    }

    private void nextChunk() throws GeneralSecurityException, IOException {
        int i;
        if (this.chunkSize != -1) {
            int i2 = (int) (this.pos >> this.chunkBits);
            initCipherForBlock(this.cipher, i2);
            int i3 = this.lastIndex;
            if (i3 != i2) {
                long j = (i2 - i3) << this.chunkBits;
                if (super.skip(j) < j) {
                    throw new EOFException("buffer underrun");
                }
            }
            this.lastIndex = i2 + 1;
        }
        int iMin = (int) Math.min(this.size, this.chunk.length);
        int iMax = 0;
        do {
            i = super.read(this.plain, iMax, iMin - iMax);
            iMax += Math.max(0, i);
            if (i == -1) {
                break;
            }
        } while (iMax < iMin);
        if (i == -1) {
            long j2 = this.pos + ((long) iMax);
            long j3 = this.size;
            if (j2 < j3 && j3 < 2147483647L) {
                throw new EOFException("buffer underrun");
            }
        }
        System.arraycopy(this.plain, 0, this.chunk, 0, iMax);
        invokeCipher(iMax, iMax == this.chunkSize);
    }

    protected int invokeCipher(int i, boolean z) throws GeneralSecurityException {
        if (z) {
            Cipher cipher = this.cipher;
            byte[] bArr = this.chunk;
            return cipher.doFinal(bArr, 0, i, bArr);
        }
        Cipher cipher2 = this.cipher;
        byte[] bArr2 = this.chunk;
        return cipher2.update(bArr2, 0, i, bArr2);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        int iMax = 0;
        do {
            try {
                int i3 = read(bArr, i, i2, true);
                iMax += Math.max(0, i3);
                if (i3 <= -1) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (iMax < i2);
        if (iMax >= i2) {
        } else {
            throw new EOFException("buffer underrun");
        }
    }

    protected byte[] getChunk() {
        return this.chunk;
    }

    protected byte[] getPlain() {
        return this.plain;
    }

    public long getPos() {
        return this.pos;
    }
}

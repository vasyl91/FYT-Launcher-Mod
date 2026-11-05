package org.apache.poi.poifs.crypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.BitSet;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentOutputStream;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public abstract class ChunkedCipherOutputStream extends FilterOutputStream {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ChunkedCipherOutputStream.class);
    private static final int STREAMING = -1;
    private final byte[] chunk;
    private final int chunkBits;
    private final int chunkSize;
    private Cipher cipher;
    private final DirectoryNode dir;
    private final File fileOut;
    private boolean isClosed;
    private final BitSet plainByteFlags;
    private long pos;
    private long totalPos;
    private long written;

    protected abstract void calculateChecksum(File file, int i) throws GeneralSecurityException, IOException;

    protected abstract void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws GeneralSecurityException, IOException;

    protected abstract Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException, IOException;

    public void setNextRecordSize(int i, boolean z) {
    }

    public ChunkedCipherOutputStream(DirectoryNode directoryNode, int i) throws GeneralSecurityException, IOException {
        super(null);
        this.isClosed = false;
        this.chunkSize = i;
        i = i == -1 ? 4096 : i;
        this.chunk = new byte[i];
        this.plainByteFlags = new BitSet(i);
        this.chunkBits = Integer.bitCount(i - 1);
        File fileCreateTempFile = TempFile.createTempFile("encrypted_package", "crypt");
        this.fileOut = fileCreateTempFile;
        fileCreateTempFile.deleteOnExit();
        this.out = new FileOutputStream(fileCreateTempFile);
        this.dir = directoryNode;
        this.cipher = initCipherForBlock(null, 0, false);
    }

    public ChunkedCipherOutputStream(OutputStream outputStream, int i) throws GeneralSecurityException, IOException {
        super(outputStream);
        this.isClosed = false;
        this.chunkSize = i;
        i = i == -1 ? 4096 : i;
        this.chunk = new byte[i];
        this.plainByteFlags = new BitSet(i);
        this.chunkBits = Integer.bitCount(i - 1);
        this.fileOut = null;
        this.dir = null;
        this.cipher = initCipherForBlock(null, 0, false);
    }

    public final Cipher initCipherForBlock(int i, boolean z) throws GeneralSecurityException, IOException {
        return initCipherForBlock(this.cipher, i, z);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        write(bArr, i, i2, false);
    }

    public void writePlain(byte[] bArr, int i, int i2) throws IOException {
        write(bArr, i, i2, true);
    }

    protected void write(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (i2 == 0) {
            return;
        }
        if (i2 < 0 || bArr.length < i + i2) {
            throw new IOException("not enough bytes in your input buffer");
        }
        int chunkMask = getChunkMask();
        while (i2 > 0) {
            long j = chunkMask;
            int i3 = (int) (this.pos & j);
            int iMin = Math.min(this.chunk.length - i3, i2);
            System.arraycopy(bArr, i, this.chunk, i3, iMin);
            if (z) {
                this.plainByteFlags.set(i3, i3 + iMin);
            }
            long j2 = iMin;
            long j3 = this.pos + j2;
            this.pos = j3;
            this.totalPos += j2;
            i += iMin;
            i2 -= iMin;
            if ((j3 & j) == 0) {
                writeChunk(i2 > 0);
            }
        }
    }

    protected int getChunkMask() {
        return this.chunk.length - 1;
    }

    protected void writeChunk(boolean z) throws IOException {
        boolean z2;
        long j = this.pos;
        if (j == 0 || this.totalPos == this.written) {
            return;
        }
        int chunkMask = (int) (j & ((long) getChunkMask()));
        long j2 = this.pos;
        int i = (int) (j2 >> this.chunkBits);
        boolean z3 = true;
        if (chunkMask == 0) {
            i--;
            chunkMask = this.chunk.length;
            z2 = false;
        } else {
            z2 = true;
        }
        try {
            this.pos = 0L;
            if (this.chunkSize != -1) {
                this.cipher = initCipherForBlock(this.cipher, i, z2);
                this.pos = j2;
            } else if (z) {
                z3 = false;
            }
            int iInvokeCipher = invokeCipher(chunkMask, z3);
            this.out.write(this.chunk, 0, iInvokeCipher);
            this.plainByteFlags.clear();
            this.written += (long) iInvokeCipher;
        } catch (GeneralSecurityException e) {
            throw new IOException("can't re-/initialize cipher", e);
        }
    }

    protected int invokeCipher(int i, boolean z) throws GeneralSecurityException {
        int iUpdate;
        byte[] bArr = this.plainByteFlags.isEmpty() ? null : (byte[]) this.chunk.clone();
        int i2 = 0;
        if (z) {
            Cipher cipher = this.cipher;
            byte[] bArr2 = this.chunk;
            iUpdate = cipher.doFinal(bArr2, 0, i, bArr2);
        } else {
            Cipher cipher2 = this.cipher;
            byte[] bArr3 = this.chunk;
            iUpdate = cipher2.update(bArr3, 0, i, bArr3);
        }
        BitSet bitSet = this.plainByteFlags;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(i2);
            if (iNextSetBit < 0 || iNextSetBit >= i) {
                break;
            }
            this.chunk[iNextSetBit] = bArr[iNextSetBit];
            bitSet = this.plainByteFlags;
            i2 = iNextSetBit + 1;
        }
        return iUpdate;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed) {
            LOG.log(1, "ChunkedCipherOutputStream was already closed - ignoring");
            return;
        }
        this.isClosed = true;
        try {
            writeChunk(false);
            super.close();
            File file = this.fileOut;
            if (file != null) {
                int length = (int) (file.length() + 8);
                calculateChecksum(this.fileOut, (int) this.pos);
                this.dir.createDocument(Decryptor.DEFAULT_POIFS_ENTRY, length, new EncryptedPackageWriter());
                createEncryptionInfoEntry(this.dir, this.fileOut);
            }
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    protected byte[] getChunk() {
        return this.chunk;
    }

    protected BitSet getPlainByteFlags() {
        return this.plainByteFlags;
    }

    protected long getPos() {
        return this.pos;
    }

    protected long getTotalPos() {
        return this.totalPos;
    }

    private class EncryptedPackageWriter implements POIFSWriterListener {
        private EncryptedPackageWriter() {
        }

        @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
        public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
            try {
                DocumentOutputStream stream = pOIFSWriterEvent.getStream();
                byte[] bArr = new byte[8];
                LittleEndian.putLong(bArr, 0, ChunkedCipherOutputStream.this.pos);
                stream.write(bArr);
                FileInputStream fileInputStream = new FileInputStream(ChunkedCipherOutputStream.this.fileOut);
                try {
                    IOUtils.copy(fileInputStream, stream);
                    fileInputStream.close();
                    stream.close();
                    if (ChunkedCipherOutputStream.this.fileOut.delete()) {
                        return;
                    }
                    ChunkedCipherOutputStream.LOG.log(7, "Can't delete temporary encryption file: " + ChunkedCipherOutputStream.this.fileOut);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            } catch (IOException e) {
                throw new EncryptedDocumentException(e);
            }
        }
    }
}

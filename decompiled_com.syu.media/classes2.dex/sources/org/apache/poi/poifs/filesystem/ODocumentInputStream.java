package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import org.apache.poi.poifs.storage.DataInputBlock;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ODocumentInputStream extends DocumentInputStream {
    private boolean _closed;
    private DataInputBlock _currentBlock;
    private int _current_offset;
    private final OPOIFSDocument _document;
    private final int _document_size;
    private int _marked_offset;

    public ODocumentInputStream(DocumentEntry documentEntry) throws IOException {
        if (!(documentEntry instanceof DocumentNode)) {
            throw new IOException("Cannot open internal document storage");
        }
        DocumentNode documentNode = (DocumentNode) documentEntry;
        if (documentNode.getDocument() == null) {
            throw new IOException("Cannot open internal document storage");
        }
        this._current_offset = 0;
        this._marked_offset = 0;
        int size = documentEntry.getSize();
        this._document_size = size;
        if (size < 0) {
            throw new RecordFormatException("document_size cannot be < 0");
        }
        this._closed = false;
        this._document = documentNode.getDocument();
        this._currentBlock = getDataInputBlock(0);
    }

    public ODocumentInputStream(OPOIFSDocument oPOIFSDocument) {
        this._current_offset = 0;
        this._marked_offset = 0;
        this._document_size = oPOIFSDocument.getSize();
        this._closed = false;
        this._document = oPOIFSDocument;
        this._currentBlock = getDataInputBlock(0);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        if (this._closed) {
            throw new IllegalStateException("cannot perform requested operation on a closed stream");
        }
        return this._document_size - this._current_offset;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._closed = true;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public void mark(int i) {
        this._marked_offset = this._current_offset;
    }

    private DataInputBlock getDataInputBlock(int i) {
        return this._document.getDataInputBlock(i);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public int read() throws IOException {
        dieIfClosed();
        if (atEOD()) {
            return -1;
        }
        int uByte = this._currentBlock.readUByte();
        this._current_offset++;
        if (this._currentBlock.available() < 1) {
            this._currentBlock = getDataInputBlock(this._current_offset);
        }
        return uByte;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        dieIfClosed();
        if (bArr == null) {
            throw new IllegalArgumentException("buffer must not be null");
        }
        if (i < 0 || i2 < 0 || bArr.length < i + i2) {
            throw new IndexOutOfBoundsException("can't read past buffer boundaries");
        }
        if (i2 == 0) {
            return 0;
        }
        if (atEOD()) {
            return -1;
        }
        int iMin = Math.min(available(), i2);
        readFully(bArr, i, iMin);
        return iMin;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public void reset() {
        int i = this._marked_offset;
        this._current_offset = i;
        this._currentBlock = getDataInputBlock(i);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        dieIfClosed();
        if (j < 0) {
            return 0L;
        }
        int i = this._current_offset;
        int i2 = ((int) j) + i;
        if (i2 < i) {
            i2 = this._document_size;
        } else {
            int i3 = this._document_size;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        long j2 = i2 - i;
        this._current_offset = i2;
        this._currentBlock = getDataInputBlock(i2);
        return j2;
    }

    private void dieIfClosed() throws IOException {
        if (this._closed) {
            throw new IOException("cannot perform requested operation on a closed stream");
        }
    }

    private boolean atEOD() {
        return this._current_offset == this._document_size;
    }

    private void checkAvaliable(int i) {
        if (this._closed) {
            throw new IllegalStateException("cannot perform requested operation on a closed stream");
        }
        if (i > this._document_size - this._current_offset) {
            throw new RuntimeException("Buffer underrun - requested " + i + " bytes but " + (this._document_size - this._current_offset) + " was available");
        }
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        checkAvaliable(i2);
        int iAvailable = this._currentBlock.available();
        if (iAvailable > i2) {
            this._currentBlock.readFully(bArr, i, i2);
            this._current_offset += i2;
            return;
        }
        while (i2 > 0) {
            boolean z = i2 >= iAvailable;
            int i3 = z ? iAvailable : i2;
            this._currentBlock.readFully(bArr, i, i3);
            i2 -= i3;
            i += i3;
            int i4 = this._current_offset + i3;
            this._current_offset = i4;
            if (z) {
                if (i4 == this._document_size) {
                    if (i2 > 0) {
                        throw new IllegalStateException("reached end of document stream unexpectedly");
                    }
                    this._currentBlock = null;
                    return;
                } else {
                    DataInputBlock dataInputBlock = getDataInputBlock(i4);
                    this._currentBlock = dataInputBlock;
                    iAvailable = dataInputBlock.available();
                }
            }
        }
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public long readLong() {
        long longLE;
        long longLE2;
        checkAvaliable(8);
        int iAvailable = this._currentBlock.available();
        if (iAvailable > 8) {
            longLE2 = this._currentBlock.readLongLE();
        } else {
            DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + iAvailable);
            if (iAvailable == 8) {
                longLE = this._currentBlock.readLongLE();
            } else {
                longLE = dataInputBlock.readLongLE(this._currentBlock, iAvailable);
            }
            this._currentBlock = dataInputBlock;
            longLE2 = longLE;
        }
        this._current_offset += 8;
        return longLE2;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readInt() {
        int intLE;
        checkAvaliable(4);
        int iAvailable = this._currentBlock.available();
        if (iAvailable > 4) {
            intLE = this._currentBlock.readIntLE();
        } else {
            DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + iAvailable);
            if (iAvailable == 4) {
                intLE = this._currentBlock.readIntLE();
            } else {
                intLE = dataInputBlock.readIntLE(this._currentBlock, iAvailable);
            }
            this._currentBlock = dataInputBlock;
        }
        this._current_offset += 4;
        return intLE;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        int uShortLE;
        checkAvaliable(2);
        int iAvailable = this._currentBlock.available();
        if (iAvailable > 2) {
            uShortLE = this._currentBlock.readUShortLE();
        } else {
            DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + iAvailable);
            if (iAvailable == 2) {
                uShortLE = this._currentBlock.readUShortLE();
            } else {
                uShortLE = dataInputBlock.readUShortLE(this._currentBlock);
            }
            this._currentBlock = dataInputBlock;
        }
        this._current_offset += 2;
        return uShortLE;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkAvaliable(1);
        int uByte = this._currentBlock.readUByte();
        this._current_offset++;
        if (this._currentBlock.available() < 1) {
            this._currentBlock = getDataInputBlock(this._current_offset);
        }
        return uByte;
    }
}

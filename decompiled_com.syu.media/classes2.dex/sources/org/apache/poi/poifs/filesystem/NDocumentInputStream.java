package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NDocumentInputStream extends DocumentInputStream {
    private ByteBuffer _buffer;
    private boolean _closed;
    private int _current_block_count;
    private int _current_offset;
    private Iterator<ByteBuffer> _data;
    private final NPOIFSDocument _document;
    private final int _document_size;
    private int _marked_offset;
    private int _marked_offset_count;

    public NDocumentInputStream(DocumentEntry documentEntry) throws IOException {
        if (!(documentEntry instanceof DocumentNode)) {
            throw new IOException("Cannot open internal document storage, " + documentEntry + " not a Document Node");
        }
        this._current_offset = 0;
        this._current_block_count = 0;
        this._marked_offset = 0;
        this._marked_offset_count = 0;
        this._document_size = documentEntry.getSize();
        this._closed = false;
        DocumentNode documentNode = (DocumentNode) documentEntry;
        NPOIFSDocument nPOIFSDocument = new NPOIFSDocument((DocumentProperty) documentNode.getProperty(), ((DirectoryNode) documentNode.getParent()).getNFileSystem());
        this._document = nPOIFSDocument;
        this._data = nPOIFSDocument.getBlockIterator();
    }

    public NDocumentInputStream(NPOIFSDocument nPOIFSDocument) {
        this._current_offset = 0;
        this._current_block_count = 0;
        this._marked_offset = 0;
        this._marked_offset_count = 0;
        this._document_size = nPOIFSDocument.getSize();
        this._closed = false;
        this._document = nPOIFSDocument;
        this._data = nPOIFSDocument.getBlockIterator();
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return remainingBytes();
    }

    private int remainingBytes() {
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
        this._marked_offset_count = Math.max(0, this._current_block_count - 1);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public int read() throws IOException {
        dieIfClosed();
        if (atEOD()) {
            return -1;
        }
        byte[] bArr = new byte[1];
        int i = read(bArr, 0, 1);
        if (i < 0) {
            return i;
        }
        byte b = bArr[0];
        return b < 0 ? b + 256 : b;
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
        int iMin = Math.min(remainingBytes(), i2);
        readFully(bArr, i, iMin);
        return iMin;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public void reset() {
        int i;
        int i2;
        int i3 = this._marked_offset;
        if (i3 == 0 && (i2 = this._marked_offset_count) == 0) {
            this._current_block_count = i2;
            this._current_offset = i3;
            this._data = this._document.getBlockIterator();
            this._buffer = null;
            return;
        }
        this._data = this._document.getBlockIterator();
        int i4 = 0;
        this._current_offset = 0;
        while (true) {
            i = this._marked_offset_count;
            if (i4 >= i) {
                break;
            }
            ByteBuffer next = this._data.next();
            this._buffer = next;
            this._current_offset += next.remaining();
            i4++;
        }
        this._current_block_count = i;
        if (this._current_offset != this._marked_offset) {
            ByteBuffer next2 = this._data.next();
            this._buffer = next2;
            this._current_block_count++;
            next2.position(next2.position() + (this._marked_offset - this._current_offset));
        }
        this._current_offset = this._marked_offset;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        dieIfClosed();
        if (j < 0) {
            return 0L;
        }
        int i2 = this._current_offset;
        long j2 = ((long) i2) + j;
        if (j2 < i2) {
            i = this._document_size;
        } else {
            i = this._document_size;
            if (j2 > i) {
            }
            long j3 = j2 - ((long) i2);
            readFully(new byte[(int) j3]);
            return j3;
        }
        j2 = i;
        long j4 = j2 - ((long) i2);
        readFully(new byte[(int) j4]);
        return j4;
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
    public void readFully(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new RuntimeException("Can't read negative number of bytes");
        }
        checkAvaliable(i2);
        int i3 = 0;
        while (i3 < i2) {
            ByteBuffer byteBuffer = this._buffer;
            if (byteBuffer == null || byteBuffer.remaining() == 0) {
                this._current_block_count++;
                this._buffer = this._data.next();
            }
            int iMin = Math.min(i2 - i3, this._buffer.remaining());
            this._buffer.get(bArr, i + i3, iMin);
            this._current_offset += iMin;
            i3 += iMin;
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
    public long readLong() {
        checkAvaliable(8);
        byte[] bArr = new byte[8];
        readFully(bArr, 0, 8);
        return LittleEndian.getLong(bArr, 0);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkAvaliable(2);
        byte[] bArr = new byte[2];
        readFully(bArr, 0, 2);
        return LittleEndian.getShort(bArr);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkAvaliable(4);
        byte[] bArr = new byte[4];
        readFully(bArr, 0, 4);
        return LittleEndian.getInt(bArr);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkAvaliable(2);
        byte[] bArr = new byte[2];
        readFully(bArr, 0, 2);
        return LittleEndian.getUShort(bArr);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkAvaliable(1);
        byte[] bArr = new byte[1];
        readFully(bArr, 0, 1);
        byte b = bArr[0];
        return b >= 0 ? b : b + 256;
    }
}

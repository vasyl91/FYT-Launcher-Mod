package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DocumentInputStream extends InputStream implements LittleEndianInput {
    protected static final int EOF = -1;
    protected static final int SIZE_INT = 4;
    protected static final int SIZE_LONG = 8;
    protected static final int SIZE_SHORT = 2;
    private DocumentInputStream delegate;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    protected DocumentInputStream() {
    }

    public DocumentInputStream(DocumentEntry documentEntry) throws IOException {
        if (!(documentEntry instanceof DocumentNode)) {
            throw new IOException("Cannot open internal document storage");
        }
        DirectoryNode directoryNode = (DirectoryNode) documentEntry.getParent();
        if (((DocumentNode) documentEntry).getDocument() != null) {
            this.delegate = new ODocumentInputStream(documentEntry);
        } else if (directoryNode.getOFileSystem() != null) {
            this.delegate = new ODocumentInputStream(documentEntry);
        } else {
            if (directoryNode.getNFileSystem() != null) {
                this.delegate = new NDocumentInputStream(documentEntry);
                return;
            }
            throw new IOException("No FileSystem bound on the parent, can't read contents");
        }
    }

    public DocumentInputStream(OPOIFSDocument oPOIFSDocument) {
        this.delegate = new ODocumentInputStream(oPOIFSDocument);
    }

    public DocumentInputStream(NPOIFSDocument nPOIFSDocument) {
        this.delegate = new NDocumentInputStream(nPOIFSDocument);
    }

    @Override // java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return this.delegate.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.delegate.mark(i);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.delegate.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.delegate.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.delegate.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.delegate.skip(j);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return this.delegate.readByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return this.delegate.readDouble();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.delegate.readFully(bArr, i, i2);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        return this.delegate.readLong();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        return this.delegate.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return this.delegate.readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return this.delegate.readUByte();
    }

    public long readUInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2);
    }
}

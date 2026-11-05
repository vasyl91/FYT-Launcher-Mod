package org.apache.poi.poifs.filesystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.poifs.property.DocumentProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NDocumentOutputStream extends OutputStream {
    private ByteArrayOutputStream _buffer = new ByteArrayOutputStream(4096);
    private boolean _closed;
    private NPOIFSDocument _document;
    private int _document_size;
    private DocumentProperty _property;
    private NPOIFSStream _stream;
    private OutputStream _stream_output;

    public NDocumentOutputStream(DocumentEntry documentEntry) throws IOException {
        if (!(documentEntry instanceof DocumentNode)) {
            throw new IOException("Cannot open internal document storage, " + documentEntry + " not a Document Node");
        }
        this._document_size = 0;
        this._closed = false;
        DocumentNode documentNode = (DocumentNode) documentEntry;
        this._property = (DocumentProperty) documentNode.getProperty();
        NPOIFSDocument nPOIFSDocument = new NPOIFSDocument(documentNode);
        this._document = nPOIFSDocument;
        nPOIFSDocument.free();
    }

    public NDocumentOutputStream(DirectoryEntry directoryEntry, String str) throws IOException {
        if (!(directoryEntry instanceof DirectoryNode)) {
            throw new IOException("Cannot open internal directory storage, " + directoryEntry + " not a Directory Node");
        }
        this._document_size = 0;
        this._closed = false;
        DocumentNode documentNode = (DocumentNode) directoryEntry.createDocument(str, new ByteArrayInputStream(new byte[0]));
        this._property = (DocumentProperty) documentNode.getProperty();
        this._document = new NPOIFSDocument(documentNode);
    }

    private void dieIfClosed() throws IOException {
        if (this._closed) {
            throw new IOException("cannot perform requested operation on a closed stream");
        }
    }

    private void checkBufferSize() throws IOException {
        if (this._buffer.size() > 4096) {
            byte[] byteArray = this._buffer.toByteArray();
            this._buffer = null;
            write(byteArray, 0, byteArray.length);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        dieIfClosed();
        ByteArrayOutputStream byteArrayOutputStream = this._buffer;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.write(i);
            checkBufferSize();
        } else {
            write(new byte[]{(byte) i});
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        dieIfClosed();
        ByteArrayOutputStream byteArrayOutputStream = this._buffer;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.write(bArr);
            checkBufferSize();
        } else {
            write(bArr, 0, bArr.length);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        dieIfClosed();
        ByteArrayOutputStream byteArrayOutputStream = this._buffer;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.write(bArr, i, i2);
            checkBufferSize();
            return;
        }
        if (this._stream == null) {
            NPOIFSStream nPOIFSStream = new NPOIFSStream(this._document.getFileSystem());
            this._stream = nPOIFSStream;
            this._stream_output = nPOIFSStream.getOutputStream();
        }
        this._stream_output.write(bArr, i, i2);
        this._document_size += i2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this._buffer != null) {
            this._document.replaceContents(new ByteArrayInputStream(this._buffer.toByteArray()));
        } else {
            this._stream_output.close();
            this._property.updateSize(this._document_size);
            this._property.setStartBlock(this._stream.getStartBlock());
        }
        this._closed = true;
    }
}

package org.apache.poi.poifs.filesystem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.poifs.storage.BlockWritable;
import org.apache.poi.poifs.storage.DataInputBlock;
import org.apache.poi.poifs.storage.DocumentBlock;
import org.apache.poi.poifs.storage.ListManagedBlock;
import org.apache.poi.poifs.storage.RawDataBlock;
import org.apache.poi.poifs.storage.SmallDocumentBlock;
import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OPOIFSDocument implements BATManaged, BlockWritable, POIFSViewable {
    private static final DocumentBlock[] EMPTY_BIG_BLOCK_ARRAY = new DocumentBlock[0];
    private static final SmallDocumentBlock[] EMPTY_SMALL_BLOCK_ARRAY = new SmallDocumentBlock[0];
    private final POIFSBigBlockSize _bigBigBlockSize;
    private BigBlockStore _big_store;
    private DocumentProperty _property;
    private int _size;
    private SmallBlockStore _small_store;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return true;
    }

    public OPOIFSDocument(String str, RawDataBlock[] rawDataBlockArr, int i) throws IOException {
        this._size = i;
        if (rawDataBlockArr.length == 0) {
            this._bigBigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        } else {
            this._bigBigBlockSize = rawDataBlockArr[0].getBigBlockSize() == 512 ? POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS : POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS;
        }
        this._big_store = new BigBlockStore(this._bigBigBlockSize, convertRawBlocksToBigBlocks(rawDataBlockArr));
        this._property = new DocumentProperty(str, this._size);
        this._small_store = new SmallBlockStore(this._bigBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
        this._property.setDocument(this);
    }

    private static DocumentBlock[] convertRawBlocksToBigBlocks(ListManagedBlock[] listManagedBlockArr) throws IOException {
        int length = listManagedBlockArr.length;
        DocumentBlock[] documentBlockArr = new DocumentBlock[length];
        for (int i = 0; i < length; i++) {
            documentBlockArr[i] = new DocumentBlock((RawDataBlock) listManagedBlockArr[i]);
        }
        return documentBlockArr;
    }

    private static SmallDocumentBlock[] convertRawBlocksToSmallBlocks(ListManagedBlock[] listManagedBlockArr) {
        if (listManagedBlockArr instanceof SmallDocumentBlock[]) {
            return (SmallDocumentBlock[]) listManagedBlockArr;
        }
        SmallDocumentBlock[] smallDocumentBlockArr = new SmallDocumentBlock[listManagedBlockArr.length];
        System.arraycopy(listManagedBlockArr, 0, smallDocumentBlockArr, 0, listManagedBlockArr.length);
        return smallDocumentBlockArr;
    }

    public OPOIFSDocument(String str, SmallDocumentBlock[] smallDocumentBlockArr, int i) {
        this._size = i;
        if (smallDocumentBlockArr.length == 0) {
            this._bigBigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        } else {
            this._bigBigBlockSize = smallDocumentBlockArr[0].getBigBlockSize();
        }
        this._big_store = new BigBlockStore(this._bigBigBlockSize, EMPTY_BIG_BLOCK_ARRAY);
        this._property = new DocumentProperty(str, this._size);
        this._small_store = new SmallBlockStore(this._bigBigBlockSize, smallDocumentBlockArr);
        this._property.setDocument(this);
    }

    public OPOIFSDocument(String str, POIFSBigBlockSize pOIFSBigBlockSize, ListManagedBlock[] listManagedBlockArr, int i) throws IOException {
        this._size = i;
        this._bigBigBlockSize = pOIFSBigBlockSize;
        DocumentProperty documentProperty = new DocumentProperty(str, this._size);
        this._property = documentProperty;
        documentProperty.setDocument(this);
        if (Property.isSmall(this._size)) {
            this._big_store = new BigBlockStore(pOIFSBigBlockSize, EMPTY_BIG_BLOCK_ARRAY);
            this._small_store = new SmallBlockStore(pOIFSBigBlockSize, convertRawBlocksToSmallBlocks(listManagedBlockArr));
        } else {
            this._big_store = new BigBlockStore(pOIFSBigBlockSize, convertRawBlocksToBigBlocks(listManagedBlockArr));
            this._small_store = new SmallBlockStore(pOIFSBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
        }
    }

    public OPOIFSDocument(String str, ListManagedBlock[] listManagedBlockArr, int i) throws IOException {
        this(str, POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS, listManagedBlockArr, i);
    }

    public OPOIFSDocument(String str, POIFSBigBlockSize pOIFSBigBlockSize, InputStream inputStream) throws IOException {
        DocumentBlock documentBlock;
        ArrayList arrayList = new ArrayList();
        this._size = 0;
        this._bigBigBlockSize = pOIFSBigBlockSize;
        do {
            documentBlock = new DocumentBlock(inputStream, pOIFSBigBlockSize);
            int size = documentBlock.size();
            if (size > 0) {
                arrayList.add(documentBlock);
                this._size += size;
            }
        } while (!documentBlock.partiallyRead());
        DocumentBlock[] documentBlockArr = (DocumentBlock[]) arrayList.toArray(new DocumentBlock[arrayList.size()]);
        this._big_store = new BigBlockStore(pOIFSBigBlockSize, documentBlockArr);
        DocumentProperty documentProperty = new DocumentProperty(str, this._size);
        this._property = documentProperty;
        documentProperty.setDocument(this);
        if (this._property.shouldUseSmallBlocks()) {
            this._small_store = new SmallBlockStore(pOIFSBigBlockSize, SmallDocumentBlock.convert(pOIFSBigBlockSize, documentBlockArr, this._size));
            this._big_store = new BigBlockStore(pOIFSBigBlockSize, new DocumentBlock[0]);
        } else {
            this._small_store = new SmallBlockStore(pOIFSBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
        }
    }

    public OPOIFSDocument(String str, InputStream inputStream) throws IOException {
        this(str, POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS, inputStream);
    }

    public OPOIFSDocument(String str, int i, POIFSBigBlockSize pOIFSBigBlockSize, POIFSDocumentPath pOIFSDocumentPath, POIFSWriterListener pOIFSWriterListener) {
        this._size = i;
        this._bigBigBlockSize = pOIFSBigBlockSize;
        DocumentProperty documentProperty = new DocumentProperty(str, this._size);
        this._property = documentProperty;
        documentProperty.setDocument(this);
        if (this._property.shouldUseSmallBlocks()) {
            this._small_store = new SmallBlockStore(pOIFSBigBlockSize, pOIFSDocumentPath, str, i, pOIFSWriterListener);
            this._big_store = new BigBlockStore(pOIFSBigBlockSize, EMPTY_BIG_BLOCK_ARRAY);
        } else {
            this._small_store = new SmallBlockStore(pOIFSBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
            this._big_store = new BigBlockStore(pOIFSBigBlockSize, pOIFSDocumentPath, str, i, pOIFSWriterListener);
        }
    }

    public OPOIFSDocument(String str, int i, POIFSDocumentPath pOIFSDocumentPath, POIFSWriterListener pOIFSWriterListener) {
        this(str, i, POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS, pOIFSDocumentPath, pOIFSWriterListener);
    }

    public SmallDocumentBlock[] getSmallBlocks() {
        return this._small_store.getBlocks();
    }

    public int getSize() {
        return this._size;
    }

    void read(byte[] bArr, int i) {
        int length = bArr.length;
        DataInputBlock dataInputBlock = getDataInputBlock(i);
        int iAvailable = dataInputBlock.available();
        if (iAvailable > length) {
            dataInputBlock.readFully(bArr, 0, length);
            return;
        }
        int i2 = 0;
        while (length > 0) {
            boolean z = length >= iAvailable;
            int i3 = z ? iAvailable : length;
            dataInputBlock.readFully(bArr, i2, i3);
            length -= i3;
            i2 += i3;
            i += i3;
            if (z) {
                if (i == this._size) {
                    if (length > 0) {
                        throw new IllegalStateException("reached end of document stream unexpectedly");
                    }
                    return;
                } else {
                    dataInputBlock = getDataInputBlock(i);
                    iAvailable = dataInputBlock.available();
                }
            }
        }
    }

    DataInputBlock getDataInputBlock(int i) {
        int i2 = this._size;
        if (i >= i2) {
            if (i <= i2) {
                return null;
            }
            throw new RuntimeException("Request for Offset " + i + " doc size is " + this._size);
        }
        if (this._property.shouldUseSmallBlocks()) {
            return SmallDocumentBlock.getDataInputBlock(this._small_store.getBlocks(), i);
        }
        return DocumentBlock.getDataInputBlock(this._big_store.getBlocks(), i);
    }

    DocumentProperty getDocumentProperty() {
        return this._property;
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        this._big_store.writeBlocks(outputStream);
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        return this._big_store.countBlocks();
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public void setStartBlock(int i) {
        this._property.setStartBlock(i);
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        String message;
        BlockWritable[] blocks;
        try {
            if (this._big_store.isValid()) {
                blocks = this._big_store.getBlocks();
            } else {
                blocks = this._small_store.isValid() ? this._small_store.getBlocks() : null;
            }
            if (blocks != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (BlockWritable blockWritable : blocks) {
                    blockWritable.writeBlocks(byteArrayOutputStream);
                }
                message = HexDump.dump(byteArrayOutputStream.toByteArray(), 0L, 0, Math.min(byteArrayOutputStream.size(), this._property.getSize()));
            } else {
                message = "<NO DATA>";
            }
        } catch (IOException e) {
            message = e.getMessage();
        }
        return new String[]{message};
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        return Collections.emptyList().iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        StringBuffer stringBuffer = new StringBuffer("Document: \"");
        stringBuffer.append(this._property.getName()).append("\" size = ");
        stringBuffer.append(getSize());
        return stringBuffer.toString();
    }

    private static final class SmallBlockStore {
        private final POIFSBigBlockSize _bigBlockSize;
        private final String _name;
        private final POIFSDocumentPath _path;
        private final int _size;
        private SmallDocumentBlock[] _smallBlocks;
        private final POIFSWriterListener _writer;

        SmallBlockStore(POIFSBigBlockSize pOIFSBigBlockSize, SmallDocumentBlock[] smallDocumentBlockArr) {
            this._bigBlockSize = pOIFSBigBlockSize;
            this._smallBlocks = (SmallDocumentBlock[]) smallDocumentBlockArr.clone();
            this._path = null;
            this._name = null;
            this._size = -1;
            this._writer = null;
        }

        SmallBlockStore(POIFSBigBlockSize pOIFSBigBlockSize, POIFSDocumentPath pOIFSDocumentPath, String str, int i, POIFSWriterListener pOIFSWriterListener) {
            this._bigBlockSize = pOIFSBigBlockSize;
            this._smallBlocks = new SmallDocumentBlock[0];
            this._path = pOIFSDocumentPath;
            this._name = str;
            this._size = i;
            this._writer = pOIFSWriterListener;
        }

        boolean isValid() {
            return this._smallBlocks.length > 0 || this._writer != null;
        }

        SmallDocumentBlock[] getBlocks() {
            if (isValid() && this._writer != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this._size);
                this._writer.processPOIFSWriterEvent(new POIFSWriterEvent(new DocumentOutputStream(byteArrayOutputStream, this._size), this._path, this._name, this._size));
                this._smallBlocks = SmallDocumentBlock.convert(this._bigBlockSize, byteArrayOutputStream.toByteArray(), this._size);
            }
            return this._smallBlocks;
        }
    }

    private static final class BigBlockStore {
        private final POIFSBigBlockSize _bigBlockSize;
        private final String _name;
        private final POIFSDocumentPath _path;
        private final int _size;
        private final POIFSWriterListener _writer;
        private DocumentBlock[] bigBlocks;

        BigBlockStore(POIFSBigBlockSize pOIFSBigBlockSize, DocumentBlock[] documentBlockArr) {
            this._bigBlockSize = pOIFSBigBlockSize;
            this.bigBlocks = (DocumentBlock[]) documentBlockArr.clone();
            this._path = null;
            this._name = null;
            this._size = -1;
            this._writer = null;
        }

        BigBlockStore(POIFSBigBlockSize pOIFSBigBlockSize, POIFSDocumentPath pOIFSDocumentPath, String str, int i, POIFSWriterListener pOIFSWriterListener) {
            this._bigBlockSize = pOIFSBigBlockSize;
            this.bigBlocks = new DocumentBlock[0];
            this._path = pOIFSDocumentPath;
            this._name = str;
            this._size = i;
            this._writer = pOIFSWriterListener;
        }

        boolean isValid() {
            return this.bigBlocks.length > 0 || this._writer != null;
        }

        DocumentBlock[] getBlocks() {
            if (isValid() && this._writer != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this._size);
                this._writer.processPOIFSWriterEvent(new POIFSWriterEvent(new DocumentOutputStream(byteArrayOutputStream, this._size), this._path, this._name, this._size));
                this.bigBlocks = DocumentBlock.convert(this._bigBlockSize, byteArrayOutputStream.toByteArray(), this._size);
            }
            return this.bigBlocks;
        }

        void writeBlocks(OutputStream outputStream) throws IOException {
            if (!isValid()) {
                return;
            }
            if (this._writer != null) {
                DocumentOutputStream documentOutputStream = new DocumentOutputStream(outputStream, this._size);
                this._writer.processPOIFSWriterEvent(new POIFSWriterEvent(documentOutputStream, this._path, this._name, this._size));
                documentOutputStream.writeFiller(countBlocks() * this._bigBlockSize.getBigBlockSize(), DocumentBlock.getFillByte());
            } else {
                int i = 0;
                while (true) {
                    DocumentBlock[] documentBlockArr = this.bigBlocks;
                    if (i >= documentBlockArr.length) {
                        return;
                    }
                    documentBlockArr[i].writeBlocks(outputStream);
                    i++;
                }
            }
        }

        int countBlocks() {
            if (!isValid()) {
                return 0;
            }
            if (this._writer == null) {
                return this.bigBlocks.length;
            }
            return ((this._size + this._bigBlockSize.getBigBlockSize()) - 1) / this._bigBlockSize.getBigBlockSize();
        }
    }
}

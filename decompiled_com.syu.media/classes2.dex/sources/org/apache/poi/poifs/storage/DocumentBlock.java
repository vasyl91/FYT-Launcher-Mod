package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DocumentBlock extends BigBlock {
    private static final byte _default_value = -1;
    private int _bytes_read;
    private byte[] _data;

    public static byte getFillByte() {
        return (byte) -1;
    }

    @Override // org.apache.poi.poifs.storage.BigBlock, org.apache.poi.poifs.storage.BlockWritable
    public /* bridge */ /* synthetic */ void writeBlocks(OutputStream outputStream) throws IOException {
        super.writeBlocks(outputStream);
    }

    public DocumentBlock(RawDataBlock rawDataBlock) throws IOException {
        super(rawDataBlock.getBigBlockSize() == 512 ? POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS : POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS);
        byte[] data = rawDataBlock.getData();
        this._data = data;
        this._bytes_read = data.length;
    }

    public DocumentBlock(InputStream inputStream, POIFSBigBlockSize pOIFSBigBlockSize) throws IOException {
        this(pOIFSBigBlockSize);
        int fully = IOUtils.readFully(inputStream, this._data);
        this._bytes_read = fully == -1 ? 0 : fully;
    }

    private DocumentBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        super(pOIFSBigBlockSize);
        byte[] bArr = new byte[pOIFSBigBlockSize.getBigBlockSize()];
        this._data = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public int size() {
        return this._bytes_read;
    }

    public boolean partiallyRead() {
        return this._bytes_read != this.bigBlockSize.getBigBlockSize();
    }

    public static DocumentBlock[] convert(POIFSBigBlockSize pOIFSBigBlockSize, byte[] bArr, int i) {
        int bigBlockSize = ((i + pOIFSBigBlockSize.getBigBlockSize()) - 1) / pOIFSBigBlockSize.getBigBlockSize();
        DocumentBlock[] documentBlockArr = new DocumentBlock[bigBlockSize];
        int bigBlockSize2 = 0;
        for (int i2 = 0; i2 < bigBlockSize; i2++) {
            DocumentBlock documentBlock = new DocumentBlock(pOIFSBigBlockSize);
            documentBlockArr[i2] = documentBlock;
            if (bigBlockSize2 < bArr.length) {
                int iMin = Math.min(pOIFSBigBlockSize.getBigBlockSize(), bArr.length - bigBlockSize2);
                System.arraycopy(bArr, bigBlockSize2, documentBlockArr[i2]._data, 0, iMin);
                if (iMin != pOIFSBigBlockSize.getBigBlockSize()) {
                    Arrays.fill(documentBlockArr[i2]._data, iMin, pOIFSBigBlockSize.getBigBlockSize(), (byte) -1);
                }
            } else {
                Arrays.fill(documentBlock._data, (byte) -1);
            }
            bigBlockSize2 += pOIFSBigBlockSize.getBigBlockSize();
        }
        return documentBlockArr;
    }

    public static DataInputBlock getDataInputBlock(DocumentBlock[] documentBlockArr, int i) {
        if (documentBlockArr == null || documentBlockArr.length == 0) {
            return null;
        }
        POIFSBigBlockSize pOIFSBigBlockSize = documentBlockArr[0].bigBlockSize;
        return new DataInputBlock(documentBlockArr[i >> pOIFSBigBlockSize.getHeaderValue()]._data, i & (pOIFSBigBlockSize.getBigBlockSize() - 1));
    }

    @Override // org.apache.poi.poifs.storage.BigBlock
    void writeData(OutputStream outputStream) throws IOException {
        doWriteData(outputStream, this._data);
    }
}

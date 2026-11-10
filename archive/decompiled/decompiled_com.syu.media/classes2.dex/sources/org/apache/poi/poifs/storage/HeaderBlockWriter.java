package org.apache.poi.poifs.storage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.apache.poi.poifs.common.POIFSBigBlockSize;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HeaderBlockWriter implements HeaderBlockConstants, BlockWritable {
    private final HeaderBlock _header_block;

    public HeaderBlockWriter(POIFSBigBlockSize pOIFSBigBlockSize) {
        this._header_block = new HeaderBlock(pOIFSBigBlockSize);
    }

    public HeaderBlockWriter(HeaderBlock headerBlock) {
        this._header_block = headerBlock;
    }

    public BATBlock[] setBATBlocks(int i, int i2) {
        BATBlock[] bATBlockArrCreateXBATBlocks;
        POIFSBigBlockSize bigBlockSize = this._header_block.getBigBlockSize();
        this._header_block.setBATCount(i);
        int iMin = Math.min(i, 109);
        int[] iArr = new int[iMin];
        for (int i3 = 0; i3 < iMin; i3++) {
            iArr[i3] = i2 + i3;
        }
        this._header_block.setBATArray(iArr);
        if (i > 109) {
            int i4 = i - 109;
            int[] iArr2 = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                iArr2[i5] = i2 + i5 + 109;
            }
            int i6 = i2 + i;
            bATBlockArrCreateXBATBlocks = BATBlock.createXBATBlocks(bigBlockSize, iArr2, i6);
            this._header_block.setXBATStart(i6);
        } else {
            bATBlockArrCreateXBATBlocks = BATBlock.createXBATBlocks(bigBlockSize, new int[0], 0);
            this._header_block.setXBATStart(-2);
        }
        this._header_block.setXBATCount(bATBlockArrCreateXBATBlocks.length);
        return bATBlockArrCreateXBATBlocks;
    }

    public void setPropertyStart(int i) {
        this._header_block.setPropertyStart(i);
    }

    public void setSBATStart(int i) {
        this._header_block.setSBATStart(i);
    }

    public void setSBATBlockCount(int i) {
        this._header_block.setSBATBlockCount(i);
    }

    static int calculateXBATStorageRequirements(POIFSBigBlockSize pOIFSBigBlockSize, int i) {
        if (i > 109) {
            return BATBlock.calculateXBATStorageRequirements(pOIFSBigBlockSize, i - 109);
        }
        return 0;
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        this._header_block.writeData(outputStream);
    }

    public void writeBlock(ByteBuffer byteBuffer) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this._header_block.getBigBlockSize().getBigBlockSize());
        this._header_block.writeData(byteArrayOutputStream);
        byteBuffer.put(byteArrayOutputStream.toByteArray());
    }
}

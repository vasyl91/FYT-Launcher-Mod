package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.filesystem.BATManaged;
import org.apache.poi.util.IntList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BlockAllocationTableWriter implements BlockWritable, BATManaged {
    private POIFSBigBlockSize _bigBlockSize;
    private int _start_block = -2;
    private IntList _entries = new IntList();
    private BATBlock[] _blocks = new BATBlock[0];

    public BlockAllocationTableWriter(POIFSBigBlockSize pOIFSBigBlockSize) {
        this._bigBlockSize = pOIFSBigBlockSize;
    }

    public int createBlocks() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int iCalculateStorageRequirements = BATBlock.calculateStorageRequirements(this._bigBlockSize, i + i2 + this._entries.size());
            int iCalculateXBATStorageRequirements = HeaderBlockWriter.calculateXBATStorageRequirements(this._bigBlockSize, iCalculateStorageRequirements);
            if (i == iCalculateStorageRequirements && i2 == iCalculateXBATStorageRequirements) {
                int iAllocateSpace = allocateSpace(i);
                allocateSpace(i2);
                simpleCreateBlocks();
                return iAllocateSpace;
            }
            i = iCalculateStorageRequirements;
            i2 = iCalculateXBATStorageRequirements;
        }
    }

    public int allocateSpace(int i) {
        int size = this._entries.size();
        if (i > 0) {
            int i2 = i - 1;
            int i3 = size + 1;
            int i4 = 0;
            while (i4 < i2) {
                this._entries.add(i3);
                i4++;
                i3++;
            }
            this._entries.add(-2);
        }
        return size;
    }

    public int getStartBlock() {
        return this._start_block;
    }

    void simpleCreateBlocks() {
        this._blocks = BATBlock.createBATBlocks(this._bigBlockSize, this._entries.toArray());
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        int i = 0;
        while (true) {
            BATBlock[] bATBlockArr = this._blocks;
            if (i >= bATBlockArr.length) {
                return;
            }
            bATBlockArr[i].writeBlocks(outputStream);
            i++;
        }
    }

    public static void writeBlock(BATBlock bATBlock, ByteBuffer byteBuffer) throws IOException {
        bATBlock.writeData(byteBuffer);
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        return this._blocks.length;
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public void setStartBlock(int i) {
        this._start_block = i;
    }
}

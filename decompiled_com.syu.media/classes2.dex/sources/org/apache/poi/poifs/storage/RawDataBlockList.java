package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.poifs.common.POIFSBigBlockSize;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RawDataBlockList extends BlockListImpl {
    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ int blockCount() {
        return super.blockCount();
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ ListManagedBlock[] fetchBlocks(int i, int i2) throws IOException {
        return super.fetchBlocks(i, i2);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl
    public /* bridge */ /* synthetic */ ListManagedBlock get(int i) {
        return super.get(i);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ ListManagedBlock remove(int i) throws IOException {
        return super.remove(i);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ void setBAT(BlockAllocationTableReader blockAllocationTableReader) throws IOException {
        super.setBAT(blockAllocationTableReader);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ void zap(int i) {
        super.zap(i);
    }

    public RawDataBlockList(InputStream inputStream, POIFSBigBlockSize pOIFSBigBlockSize) throws IOException {
        RawDataBlock rawDataBlock;
        ArrayList arrayList = new ArrayList();
        do {
            rawDataBlock = new RawDataBlock(inputStream, pOIFSBigBlockSize.getBigBlockSize());
            if (rawDataBlock.hasData()) {
                arrayList.add(rawDataBlock);
            }
        } while (!rawDataBlock.eof());
        setBlocks((ListManagedBlock[]) arrayList.toArray(new RawDataBlock[arrayList.size()]));
    }
}
